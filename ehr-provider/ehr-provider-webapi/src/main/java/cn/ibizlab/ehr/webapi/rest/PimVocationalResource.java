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
import cn.ibizlab.ehr.core.pim.domain.PimVocational;
import cn.ibizlab.ehr.core.pim.service.IPimVocationalService;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalSearchContext;

@Slf4j
@Api(tags = {"证书信息" })
@RestController("WebApi-pimvocational")
@RequestMapping("")
public class PimVocationalResource {

    @Autowired
    public IPimVocationalService pimvocationalService;

    @Autowired
    @Lazy
    public PimVocationalMapping pimvocationalMapping;

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PimVocational-Update')")
    @ApiOperation(value = "更新证书信息", tags = {"证书信息" },  notes = "更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PimVocationalDTO> update(@PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PimVocationalDTO pimvocationaldto) {
		PimVocational domain  = pimvocationalMapping.toDomain(pimvocationaldto);
        domain .setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain );
		PimVocationalDTO dto = pimvocationalMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByEntities(this.pimvocationalMapping.toDomain(#pimvocationaldtos)),'ehr-PimVocational-Update')")
    @ApiOperation(value = "批量更新证书信息", tags = {"证书信息" },  notes = "批量更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        pimvocationalService.updateBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PimVocational-Create')")
    @ApiOperation(value = "新建证书信息", tags = {"证书信息" },  notes = "新建证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals")
    @Transactional
    public ResponseEntity<PimVocationalDTO> create(@RequestBody PimVocationalDTO pimvocationaldto) {
        PimVocational domain = pimvocationalMapping.toDomain(pimvocationaldto);
		pimvocationalService.create(domain);
        PimVocationalDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PimVocational-Create')")
    @ApiOperation(value = "批量新建证书信息", tags = {"证书信息" },  notes = "批量新建证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        pimvocationalService.createBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查证书信息", tags = {"证书信息" },  notes = "检查证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimVocationalDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PimVocational-Remove')")
    @ApiOperation(value = "删除证书信息", tags = {"证书信息" },  notes = "删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvocational_id") String pimvocational_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByIds(#ids),'ehr-PimVocational-Remove')")
    @ApiOperation(value = "批量删除证书信息", tags = {"证书信息" },  notes = "批量删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PimVocational-Save')")
    @ApiOperation(value = "保存证书信息", tags = {"证书信息" },  notes = "保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/save")
    public ResponseEntity<Boolean> save(@RequestBody PimVocationalDTO pimvocationaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PimVocational-Save')")
    @ApiOperation(value = "批量保存证书信息", tags = {"证书信息" },  notes = "批量保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        pimvocationalService.saveBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimvocationalMapping.toDomain(returnObject.body),'ehr-PimVocational-Get')")
    @ApiOperation(value = "获取证书信息", tags = {"证书信息" },  notes = "获取证书信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PimVocationalDTO> get(@PathVariable("pimvocational_id") String pimvocational_id) {
        PimVocational domain = pimvocationalService.get(pimvocational_id);
        PimVocationalDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取证书信息草稿", tags = {"证书信息" },  notes = "获取证书信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/getdraft")
    public ResponseEntity<PimVocationalDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(new PimVocational())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-REP_VOCATIONAL-all')")
	@ApiOperation(value = "获取REP_VOCATIONAL", tags = {"证书信息" } ,notes = "获取REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchREP_VOCATIONAL(PimVocationalSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-REP_VOCATIONAL-all')")
	@ApiOperation(value = "查询REP_VOCATIONAL", tags = {"证书信息" } ,notes = "查询REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchREP_VOCATIONAL(@RequestBody PimVocationalSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-AscriptionSysDQ-all')")
	@ApiOperation(value = "获取记录所属是管理员的", tags = {"证书信息" } ,notes = "获取记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PimVocationalDTO>> fetchAscriptionSysDQ(PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-AscriptionSysDQ-all')")
	@ApiOperation(value = "查询记录所属是管理员的", tags = {"证书信息" } ,notes = "查询记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PimVocationalDTO>> searchAscriptionSysDQ(@RequestBody PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"证书信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchdefault")
	public ResponseEntity<List<PimVocationalDTO>> fetchDefault(PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchDefault(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"证书信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchdefault")
	public ResponseEntity<Page<PimVocationalDTO>> searchDefault(@RequestBody PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-JLSS-all')")
	@ApiOperation(value = "获取记录所属于", tags = {"证书信息" } ,notes = "获取记录所属于")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchjlss")
	public ResponseEntity<List<PimVocationalDTO>> fetchJLSS(PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchJLSS(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-JLSS-all')")
	@ApiOperation(value = "查询记录所属于", tags = {"证书信息" } ,notes = "查询记录所属于")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchjlss")
	public ResponseEntity<Page<PimVocationalDTO>> searchJLSS(@RequestBody PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-ZIZHU-all')")
	@ApiOperation(value = "获取自助(证书信息)", tags = {"证书信息" } ,notes = "获取自助(证书信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PimVocationalDTO>> fetchZIZHU(PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchZIZHU(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-ZIZHU-all')")
	@ApiOperation(value = "查询自助(证书信息)", tags = {"证书信息" } ,notes = "查询自助(证书信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PimVocationalDTO>> searchZIZHU(@RequestBody PimVocationalSearchContext context) {
        Page<PimVocational> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PimVocational-Update')")
    @ApiOperation(value = "根据人员信息更新证书信息", tags = {"证书信息" },  notes = "根据人员信息更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PimVocationalDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PimVocationalDTO pimvocationaldto) {
        PimVocational domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain);
        PimVocationalDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByEntities(this.pimvocationalMapping.toDomain(#pimvocationaldtos)),'ehr-PimVocational-Update')")
    @ApiOperation(value = "根据人员信息批量更新证书信息", tags = {"证书信息" },  notes = "根据人员信息批量更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        List<PimVocational> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PimVocational domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PimVocational-Create')")
    @ApiOperation(value = "根据人员信息建立证书信息", tags = {"证书信息" },  notes = "根据人员信息建立证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals")
    @Transactional
    public ResponseEntity<PimVocationalDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalDTO pimvocationaldto) {
        PimVocational domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
		pimvocationalService.create(domain);
        PimVocationalDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PimVocational-Create')")
    @ApiOperation(value = "根据人员信息批量建立证书信息", tags = {"证书信息" },  notes = "根据人员信息批量建立证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        List<PimVocational> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PimVocational domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查证书信息", tags = {"证书信息" },  notes = "根据人员信息检查证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PimVocational-Remove')")
    @ApiOperation(value = "根据人员信息删除证书信息", tags = {"证书信息" },  notes = "根据人员信息删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByIds(#ids),'ehr-PimVocational-Remove')")
    @ApiOperation(value = "根据人员信息批量删除证书信息", tags = {"证书信息" },  notes = "根据人员信息批量删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PimVocational-Save')")
    @ApiOperation(value = "根据人员信息保存证书信息", tags = {"证书信息" },  notes = "根据人员信息保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalDTO pimvocationaldto) {
        PimVocational domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PimVocational-Save')")
    @ApiOperation(value = "根据人员信息批量保存证书信息", tags = {"证书信息" },  notes = "根据人员信息批量保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVocationalDTO> pimvocationaldtos) {
        List<PimVocational> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PimVocational domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimvocationalMapping.toDomain(returnObject.body),'ehr-PimVocational-Get')")
    @ApiOperation(value = "根据人员信息获取证书信息", tags = {"证书信息" },  notes = "根据人员信息获取证书信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PimVocationalDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
        PimVocational domain = pimvocationalService.get(pimvocational_id);
        PimVocationalDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取证书信息草稿", tags = {"证书信息" },  notes = "根据人员信息获取证书信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/getdraft")
    public ResponseEntity<PimVocationalDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimVocational domain = new PimVocational();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-REP_VOCATIONAL-all')")
	@ApiOperation(value = "根据人员信息获取REP_VOCATIONAL", tags = {"证书信息" } ,notes = "根据人员信息获取REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchPimVocationalREP_VOCATIONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-REP_VOCATIONAL-all')")
	@ApiOperation(value = "根据人员信息查询REP_VOCATIONAL", tags = {"证书信息" } ,notes = "根据人员信息查询REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchPimVocationalREP_VOCATIONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-AscriptionSysDQ-all')")
	@ApiOperation(value = "根据人员信息获取记录所属是管理员的", tags = {"证书信息" } ,notes = "根据人员信息获取记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PimVocationalDTO>> fetchPimVocationalAscriptionSysDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-AscriptionSysDQ-all')")
	@ApiOperation(value = "根据人员信息查询记录所属是管理员的", tags = {"证书信息" } ,notes = "根据人员信息查询记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PimVocationalDTO>> searchPimVocationalAscriptionSysDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"证书信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchdefault")
	public ResponseEntity<List<PimVocationalDTO>> fetchPimVocationalDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchDefault(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"证书信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchdefault")
	public ResponseEntity<Page<PimVocationalDTO>> searchPimVocationalDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属于", tags = {"证书信息" } ,notes = "根据人员信息获取记录所属于")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchjlss")
	public ResponseEntity<List<PimVocationalDTO>> fetchPimVocationalJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchJLSS(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属于", tags = {"证书信息" } ,notes = "根据人员信息查询记录所属于")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchjlss")
	public ResponseEntity<Page<PimVocationalDTO>> searchPimVocationalJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(证书信息)", tags = {"证书信息" } ,notes = "根据人员信息获取自助(证书信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PimVocationalDTO>> fetchPimVocationalZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchZIZHU(context) ;
        List<PimVocationalDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVocational-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(证书信息)", tags = {"证书信息" } ,notes = "根据人员信息查询自助(证书信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PimVocationalDTO>> searchPimVocationalZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVocationalSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVocational> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

