package cn.ibizlab.ehr.webapi.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg;
import cn.ibizlab.ehr.core.pim.service.IPimContractSignOrgService;
import cn.ibizlab.ehr.core.pim.filter.PimContractSignOrgSearchContext;

@Slf4j
@Api(tags = {"签约主体单位" })
@RestController("WebApi-pimcontractsignorg")
@RequestMapping("")
public class PimContractSignOrgResource {

    @Autowired
    public IPimContractSignOrgService pimcontractsignorgService;

    @Autowired
    @Lazy
    public PimContractSignOrgMapping pimcontractsignorgMapping;

    @PostAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(returnObject.body),'ehr-PimContractSignOrg-Get')")
    @ApiOperation(value = "获取签约主体单位", tags = {"签约主体单位" },  notes = "获取签约主体单位")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontractsignorgs/{pimcontractsignorg_id}")
    public ResponseEntity<PimContractSignOrgDTO> get(@PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
        PimContractSignOrg domain = pimcontractsignorgService.get(pimcontractsignorg_id);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查签约主体单位", tags = {"签约主体单位" },  notes = "检查签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.checkKey(pimcontractsignorgMapping.toDomain(pimcontractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "更新签约主体单位", tags = {"签约主体单位" },  notes = "更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> update(@PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
		PimContractSignOrg domain  = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain .setContractsignorgid(pimcontractsignorg_id);
		pimcontractsignorgService.update(domain );
		PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByEntities(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos)),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "批量更新签约主体单位", tags = {"签约主体单位" },  notes = "批量更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        pimcontractsignorgService.updateBatch(pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "删除签约主体单位", tags = {"签约主体单位" },  notes = "删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.remove(pimcontractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByIds(#ids),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "批量删除签约主体单位", tags = {"签约主体单位" },  notes = "批量删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcontractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "新建签约主体单位", tags = {"签约主体单位" },  notes = "新建签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontractsignorgs")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> create(@RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
		pimcontractsignorgService.create(domain);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "批量新建签约主体单位", tags = {"签约主体单位" },  notes = "批量新建签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        pimcontractsignorgService.createBatch(pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取签约主体单位草稿", tags = {"签约主体单位" },  notes = "获取签约主体单位草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontractsignorgs/getdraft")
    public ResponseEntity<PimContractSignOrgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgMapping.toDto(pimcontractsignorgService.getDraft(new PimContractSignOrg())));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "保存签约主体单位", tags = {"签约主体单位" },  notes = "保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontractsignorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.save(pimcontractsignorgMapping.toDomain(pimcontractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "批量保存签约主体单位", tags = {"签约主体单位" },  notes = "批量保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        pimcontractsignorgService.saveBatch(pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"签约主体单位" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontractsignorgs/fetchdefault")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchDefault(PimContractSignOrgSearchContext context) {
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"签约主体单位" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontractsignorgs/searchdefault")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchDefault(@RequestBody PimContractSignOrgSearchContext context) {
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "获取DEFAULT2", tags = {"签约主体单位" } ,notes = "获取DEFAULT2")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontractsignorgs/fetchdefault2")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchDefault2(PimContractSignOrgSearchContext context) {
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "查询DEFAULT2", tags = {"签约主体单位" } ,notes = "查询DEFAULT2")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontractsignorgs/searchdefault2")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchDefault2(@RequestBody PimContractSignOrgSearchContext context) {
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(returnObject.body),'ehr-PimContractSignOrg-Get')")
    @ApiOperation(value = "根据组织管理获取签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理获取签约主体单位")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    public ResponseEntity<PimContractSignOrgDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
        PimContractSignOrg domain = pimcontractsignorgService.get(pimcontractsignorg_id);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理检查签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理检查签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.checkKey(pimcontractsignorgMapping.toDomain(pimcontractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "根据组织管理更新签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmorgid(ormorg_id);
        domain.setContractsignorgid(pimcontractsignorg_id);
		pimcontractsignorgService.update(domain);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByEntities(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos)),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "根据组织管理批量更新签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理批量更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        pimcontractsignorgService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "根据组织管理删除签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.remove(pimcontractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByIds(#ids),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "根据组织管理批量删除签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理批量删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        pimcontractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "根据组织管理建立签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理建立签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmorgid(ormorg_id);
		pimcontractsignorgService.create(domain);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "根据组织管理批量建立签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理批量建立签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        pimcontractsignorgService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理获取签约主体单位草稿", tags = {"签约主体单位" },  notes = "根据组织管理获取签约主体单位草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/getdraft")
    public ResponseEntity<PimContractSignOrgDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        PimContractSignOrg domain = new PimContractSignOrg();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgMapping.toDto(pimcontractsignorgService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "根据组织管理保存签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "根据组织管理批量保存签约主体单位", tags = {"签约主体单位" },  notes = "根据组织管理批量保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pimcontractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        pimcontractsignorgService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT", tags = {"签约主体单位" } ,notes = "根据组织管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/pimcontractsignorgs/fetchdefault")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchPimContractSignOrgDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,PimContractSignOrgSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT", tags = {"签约主体单位" } ,notes = "根据组织管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/pimcontractsignorgs/searchdefault")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchPimContractSignOrgDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PimContractSignOrgSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT2", tags = {"签约主体单位" } ,notes = "根据组织管理获取DEFAULT2")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/pimcontractsignorgs/fetchdefault2")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchPimContractSignOrgDefault2ByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,PimContractSignOrgSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT2", tags = {"签约主体单位" } ,notes = "根据组织管理查询DEFAULT2")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/pimcontractsignorgs/searchdefault2")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchPimContractSignOrgDefault2ByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PimContractSignOrgSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(returnObject.body),'ehr-PimContractSignOrg-Get')")
    @ApiOperation(value = "根据法人主体获取签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体获取签约主体单位")
	@RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    public ResponseEntity<PimContractSignOrgDTO> getByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
        PimContractSignOrg domain = pimcontractsignorgService.get(pimcontractsignorg_id);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据法人主体检查签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体检查签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.checkKey(pimcontractsignorgMapping.toDomain(pimcontractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "根据法人主体更新签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> updateByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
        domain.setContractsignorgid(pimcontractsignorg_id);
		pimcontractsignorgService.update(domain);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByEntities(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos)),'ehr-PimContractSignOrg-Update')")
    @ApiOperation(value = "根据法人主体批量更新签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体批量更新签约主体单位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
            domain.setOrmsignorgid(ormsignorg_id);
        }
        pimcontractsignorgService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.get(#pimcontractsignorg_id),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "根据法人主体删除签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/{pimcontractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("pimcontractsignorg_id") String pimcontractsignorg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.remove(pimcontractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgService.getPimcontractsignorgByIds(#ids),'ehr-PimContractSignOrg-Remove')")
    @ApiOperation(value = "根据法人主体批量删除签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体批量删除签约主体单位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmSignOrg(@RequestBody List<String> ids) {
        pimcontractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "根据法人主体建立签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体建立签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs")
    @Transactional
    public ResponseEntity<PimContractSignOrgDTO> createByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
		pimcontractsignorgService.create(domain);
        PimContractSignOrgDTO dto = pimcontractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Create')")
    @ApiOperation(value = "根据法人主体批量建立签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体批量建立签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/batch")
    public ResponseEntity<Boolean> createBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
            domain.setOrmsignorgid(ormsignorg_id);
        }
        pimcontractsignorgService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据法人主体获取签约主体单位草稿", tags = {"签约主体单位" },  notes = "根据法人主体获取签约主体单位草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/getdraft")
    public ResponseEntity<PimContractSignOrgDTO> getDraftByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id) {
        PimContractSignOrg domain = new PimContractSignOrg();
        domain.setOrmsignorgid(ormsignorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgMapping.toDto(pimcontractsignorgService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdto),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "根据法人主体保存签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/save")
    public ResponseEntity<Boolean> saveByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody PimContractSignOrgDTO pimcontractsignorgdto) {
        PimContractSignOrg domain = pimcontractsignorgMapping.toDomain(pimcontractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractsignorgService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcontractsignorgMapping.toDomain(#pimcontractsignorgdtos),'ehr-PimContractSignOrg-Save')")
    @ApiOperation(value = "根据法人主体批量保存签约主体单位", tags = {"签约主体单位" },  notes = "根据法人主体批量保存签约主体单位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<PimContractSignOrgDTO> pimcontractsignorgdtos) {
        List<PimContractSignOrg> domainlist=pimcontractsignorgMapping.toDomain(pimcontractsignorgdtos);
        for(PimContractSignOrg domain:domainlist){
             domain.setOrmsignorgid(ormsignorg_id);
        }
        pimcontractsignorgService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "根据法人主体获取DEFAULT", tags = {"签约主体单位" } ,notes = "根据法人主体获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/fetchdefault")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchPimContractSignOrgDefaultByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id,PimContractSignOrgSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default-all')")
	@ApiOperation(value = "根据法人主体查询DEFAULT", tags = {"签约主体单位" } ,notes = "根据法人主体查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/searchdefault")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchPimContractSignOrgDefaultByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody PimContractSignOrgSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "根据法人主体获取DEFAULT2", tags = {"签约主体单位" } ,notes = "根据法人主体获取DEFAULT2")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/fetchdefault2")
	public ResponseEntity<List<PimContractSignOrgDTO>> fetchPimContractSignOrgDefault2ByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id,PimContractSignOrgSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
        List<PimContractSignOrgDTO> list = pimcontractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractSignOrg-Default2-all')")
	@ApiOperation(value = "根据法人主体查询DEFAULT2", tags = {"签约主体单位" } ,notes = "根据法人主体查询DEFAULT2")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/{ormsignorg_id}/pimcontractsignorgs/searchdefault2")
	public ResponseEntity<Page<PimContractSignOrgDTO>> searchPimContractSignOrgDefault2ByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody PimContractSignOrgSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<PimContractSignOrg> domains = pimcontractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

