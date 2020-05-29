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
import cn.ibizlab.ehr.core.pim.domain.PimRewardPunishment;
import cn.ibizlab.ehr.core.pim.service.IPimRewardPunishmentService;
import cn.ibizlab.ehr.core.pim.filter.PimRewardPunishmentSearchContext;

@Slf4j
@Api(tags = {"PimRewardPunishment" })
@RestController("WebApi-pimrewardpunishment")
@RequestMapping("")
public class PimRewardPunishmentResource {

    @Autowired
    public IPimRewardPunishmentService pimrewardpunishmentService;

    @Autowired
    @Lazy
    public PimRewardPunishmentMapping pimrewardpunishmentMapping;

    @ApiOperation(value = "CheckKey", tags = {"PimRewardPunishment" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.checkKey(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PostAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(returnObject.body),'ehr-PimRewardPunishment-Get')")
    @ApiOperation(value = "Get", tags = {"PimRewardPunishment" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    public ResponseEntity<PimRewardPunishmentDTO> get(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
        PimRewardPunishment domain = pimrewardpunishmentService.get(pimrewardpunishment_id);
        PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PimRewardPunishment-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimRewardPunishment" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.remove(pimrewardpunishment_id));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByIds(#ids),'ehr-PimRewardPunishment-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimRewardPunishment" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimrewardpunishmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PimRewardPunishment-Save')")
    @ApiOperation(value = "Save", tags = {"PimRewardPunishment" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/save")
    public ResponseEntity<Boolean> save(@RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.save(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PimRewardPunishment-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimRewardPunishment" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.saveBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimRewardPunishment" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimrewardpunishments/getdraft")
    public ResponseEntity<PimRewardPunishmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentMapping.toDto(pimrewardpunishmentService.getDraft(new PimRewardPunishment())));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PimRewardPunishment-Create')")
    @ApiOperation(value = "Create", tags = {"PimRewardPunishment" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments")
    @Transactional
    public ResponseEntity<PimRewardPunishmentDTO> create(@RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        PimRewardPunishment domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
		pimrewardpunishmentService.create(domain);
        PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PimRewardPunishment-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimRewardPunishment" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.createBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PimRewardPunishment-Update')")
    @ApiOperation(value = "Update", tags = {"PimRewardPunishment" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<PimRewardPunishmentDTO> update(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id, @RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
		PimRewardPunishment domain  = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain .setPimrewardpunishmentid(pimrewardpunishment_id);
		pimrewardpunishmentService.update(domain );
		PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByEntities(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos)),'ehr-PimRewardPunishment-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimRewardPunishment" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.updateBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(奖惩信息)", tags = {"PimRewardPunishment" } ,notes = "fetch自助(奖惩信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchzizhu")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchZIZHU(PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchZIZHU(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-ZIZHU-all')")
	@ApiOperation(value = "search自助(奖惩信息)", tags = {"PimRewardPunishment" } ,notes = "search自助(奖惩信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchzizhu")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchZIZHU(@RequestBody PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-HONORARY-all')")
	@ApiOperation(value = "fetch公司及以上荣誉", tags = {"PimRewardPunishment" } ,notes = "fetch公司及以上荣誉")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchhonorary")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchHONORARY(PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchHONORARY(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-HONORARY-all')")
	@ApiOperation(value = "search公司及以上荣誉", tags = {"PimRewardPunishment" } ,notes = "search公司及以上荣誉")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchhonorary")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchHONORARY(@RequestBody PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchHONORARY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimRewardPunishment" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchdefault")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchDefault(PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchDefault(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimRewardPunishment" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchdefault")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchDefault(@RequestBody PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PimRewardPunishment" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchjlss")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchJLSS(PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchJLSS(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PimRewardPunishment" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchjlss")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchJLSS(@RequestBody PimRewardPunishmentSearchContext context) {
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimRewardPunishment" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.checkKey(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PostAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(returnObject.body),'ehr-PimRewardPunishment-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimRewardPunishment" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    public ResponseEntity<PimRewardPunishmentDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
        PimRewardPunishment domain = pimrewardpunishmentService.get(pimrewardpunishment_id);
        PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PimRewardPunishment-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimRewardPunishment" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.remove(pimrewardpunishment_id));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByIds(#ids),'ehr-PimRewardPunishment-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimRewardPunishment" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimrewardpunishmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PimRewardPunishment-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimRewardPunishment" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        PimRewardPunishment domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PimRewardPunishment-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimRewardPunishment" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        List<PimRewardPunishment> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PimRewardPunishment domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimRewardPunishment" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/getdraft")
    public ResponseEntity<PimRewardPunishmentDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimRewardPunishment domain = new PimRewardPunishment();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentMapping.toDto(pimrewardpunishmentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PimRewardPunishment-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimRewardPunishment" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments")
    @Transactional
    public ResponseEntity<PimRewardPunishmentDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        PimRewardPunishment domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
		pimrewardpunishmentService.create(domain);
        PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PimRewardPunishment-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimRewardPunishment" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        List<PimRewardPunishment> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PimRewardPunishment domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PimRewardPunishment-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimRewardPunishment" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<PimRewardPunishmentDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id, @RequestBody PimRewardPunishmentDTO pimrewardpunishmentdto) {
        PimRewardPunishment domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimrewardpunishmentid(pimrewardpunishment_id);
		pimrewardpunishmentService.update(domain);
        PimRewardPunishmentDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByEntities(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos)),'ehr-PimRewardPunishment-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimRewardPunishment" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimRewardPunishmentDTO> pimrewardpunishmentdtos) {
        List<PimRewardPunishment> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PimRewardPunishment domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(奖惩信息)ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "fetch自助(奖惩信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchzizhu")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchPimRewardPunishmentZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchZIZHU(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-ZIZHU-all')")
	@ApiOperation(value = "search自助(奖惩信息)ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "search自助(奖惩信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchzizhu")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchPimRewardPunishmentZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-HONORARY-all')")
	@ApiOperation(value = "fetch公司及以上荣誉ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "fetch公司及以上荣誉ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchhonorary")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchPimRewardPunishmentHONORARYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchHONORARY(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-HONORARY-all')")
	@ApiOperation(value = "search公司及以上荣誉ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "search公司及以上荣誉ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchhonorary")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchPimRewardPunishmentHONORARYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchHONORARY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimRewardPunishment" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchdefault")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchPimRewardPunishmentDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchDefault(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimRewardPunishment" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchdefault")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchPimRewardPunishmentDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "fetch记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchjlss")
	public ResponseEntity<List<PimRewardPunishmentDTO>> fetchPimRewardPunishmentJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchJLSS(context) ;
        List<PimRewardPunishmentDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimRewardPunishment-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPimPerson", tags = {"PimRewardPunishment" } ,notes = "search记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchjlss")
	public ResponseEntity<Page<PimRewardPunishmentDTO>> searchPimRewardPunishmentJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimRewardPunishmentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimRewardPunishment> domains = pimrewardpunishmentService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

