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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
import cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALSearchContext;

@Slf4j
@Api(tags = {"证书信息" })
@RestController("WebApi-pimvocational")
@RequestMapping("")
public class PIMVOCATIONALResource {

    @Autowired
    public IPIMVOCATIONALService pimvocationalService;

    @Autowired
    @Lazy
    public PIMVOCATIONALMapping pimvocationalMapping;

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PIMVOCATIONAL-Update')")
    @ApiOperation(value = "更新证书信息", tags = {"证书信息" },  notes = "更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> update(@PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
		PIMVOCATIONAL domain  = pimvocationalMapping.toDomain(pimvocationaldto);
        domain .setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain );
		PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByEntities(this.pimvocationalMapping.toDomain(#pimvocationaldtos)),'ehr-PIMVOCATIONAL-Update')")
    @ApiOperation(value = "批量更新证书信息", tags = {"证书信息" },  notes = "批量更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.updateBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PIMVOCATIONAL-Create')")
    @ApiOperation(value = "新建证书信息", tags = {"证书信息" },  notes = "新建证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> create(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
		pimvocationalService.create(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PIMVOCATIONAL-Create')")
    @ApiOperation(value = "批量新建证书信息", tags = {"证书信息" },  notes = "批量新建证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.createBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查证书信息", tags = {"证书信息" },  notes = "检查证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PIMVOCATIONAL-Remove')")
    @ApiOperation(value = "删除证书信息", tags = {"证书信息" },  notes = "删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvocational_id") String pimvocational_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByIds(#ids),'ehr-PIMVOCATIONAL-Remove')")
    @ApiOperation(value = "批量删除证书信息", tags = {"证书信息" },  notes = "批量删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PIMVOCATIONAL-Save')")
    @ApiOperation(value = "保存证书信息", tags = {"证书信息" },  notes = "保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PIMVOCATIONAL-Save')")
    @ApiOperation(value = "批量保存证书信息", tags = {"证书信息" },  notes = "批量保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.saveBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimvocationalMapping.toDomain(returnObject.body),'ehr-PIMVOCATIONAL-Get')")
    @ApiOperation(value = "获取证书信息", tags = {"证书信息" },  notes = "获取证书信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PIMVOCATIONALDTO> get(@PathVariable("pimvocational_id") String pimvocational_id) {
        PIMVOCATIONAL domain = pimvocationalService.get(pimvocational_id);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取证书信息草稿", tags = {"证书信息" },  notes = "获取证书信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/getdraft")
    public ResponseEntity<PIMVOCATIONALDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(new PIMVOCATIONAL())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-REP_VOCATIONAL-all')")
	@ApiOperation(value = "获取REP_VOCATIONAL", tags = {"证书信息" } ,notes = "获取REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchREP_VOCATIONAL(PIMVOCATIONALSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-REP_VOCATIONAL-all')")
	@ApiOperation(value = "查询REP_VOCATIONAL", tags = {"证书信息" } ,notes = "查询REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchREP_VOCATIONAL(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-AscriptionSysDQ-all')")
	@ApiOperation(value = "获取记录所属是管理员的", tags = {"证书信息" } ,notes = "获取记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchAscriptionSysDQ(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-AscriptionSysDQ-all')")
	@ApiOperation(value = "查询记录所属是管理员的", tags = {"证书信息" } ,notes = "查询记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchAscriptionSysDQ(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"证书信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchdefault")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchDefault(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"证书信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchdefault")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchDefault(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-JLSS-all')")
	@ApiOperation(value = "获取记录所属于", tags = {"证书信息" } ,notes = "获取记录所属于")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchjlss")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchJLSS(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-JLSS-all')")
	@ApiOperation(value = "查询记录所属于", tags = {"证书信息" } ,notes = "查询记录所属于")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchjlss")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchJLSS(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-ZIZHU-all')")
	@ApiOperation(value = "获取自助(证书信息)", tags = {"证书信息" } ,notes = "获取自助(证书信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchZIZHU(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-ZIZHU-all')")
	@ApiOperation(value = "查询自助(证书信息)", tags = {"证书信息" } ,notes = "查询自助(证书信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchZIZHU(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PIMVOCATIONAL-Update')")
    @ApiOperation(value = "根据人员信息更新证书信息", tags = {"证书信息" },  notes = "根据人员信息更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByEntities(this.pimvocationalMapping.toDomain(#pimvocationaldtos)),'ehr-PIMVOCATIONAL-Update')")
    @ApiOperation(value = "根据人员信息批量更新证书信息", tags = {"证书信息" },  notes = "根据人员信息批量更新证书信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PIMVOCATIONAL-Create')")
    @ApiOperation(value = "根据人员信息建立证书信息", tags = {"证书信息" },  notes = "根据人员信息建立证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
		pimvocationalService.create(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PIMVOCATIONAL-Create')")
    @ApiOperation(value = "根据人员信息批量建立证书信息", tags = {"证书信息" },  notes = "根据人员信息批量建立证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查证书信息", tags = {"证书信息" },  notes = "根据人员信息检查证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.get(#pimvocational_id),'ehr-PIMVOCATIONAL-Remove')")
    @ApiOperation(value = "根据人员信息删除证书信息", tags = {"证书信息" },  notes = "根据人员信息删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @PreAuthorize("hasPermission(this.pimvocationalService.getPimvocationalByIds(#ids),'ehr-PIMVOCATIONAL-Remove')")
    @ApiOperation(value = "根据人员信息批量删除证书信息", tags = {"证书信息" },  notes = "根据人员信息批量删除证书信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldto),'ehr-PIMVOCATIONAL-Save')")
    @ApiOperation(value = "根据人员信息保存证书信息", tags = {"证书信息" },  notes = "根据人员信息保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimvocationalMapping.toDomain(#pimvocationaldtos),'ehr-PIMVOCATIONAL-Save')")
    @ApiOperation(value = "根据人员信息批量保存证书信息", tags = {"证书信息" },  notes = "根据人员信息批量保存证书信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimvocationalMapping.toDomain(returnObject.body),'ehr-PIMVOCATIONAL-Get')")
    @ApiOperation(value = "根据人员信息获取证书信息", tags = {"证书信息" },  notes = "根据人员信息获取证书信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PIMVOCATIONALDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
        PIMVOCATIONAL domain = pimvocationalService.get(pimvocational_id);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取证书信息草稿", tags = {"证书信息" },  notes = "根据人员信息获取证书信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/getdraft")
    public ResponseEntity<PIMVOCATIONALDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PIMVOCATIONAL domain = new PIMVOCATIONAL();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-REP_VOCATIONAL-all')")
	@ApiOperation(value = "根据人员信息获取REP_VOCATIONAL", tags = {"证书信息" } ,notes = "根据人员信息获取REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchPIMVOCATIONALREP_VOCATIONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-REP_VOCATIONAL-all')")
	@ApiOperation(value = "根据人员信息查询REP_VOCATIONAL", tags = {"证书信息" } ,notes = "根据人员信息查询REP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchPIMVOCATIONALREP_VOCATIONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-AscriptionSysDQ-all')")
	@ApiOperation(value = "根据人员信息获取记录所属是管理员的", tags = {"证书信息" } ,notes = "根据人员信息获取记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALAscriptionSysDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-AscriptionSysDQ-all')")
	@ApiOperation(value = "根据人员信息查询记录所属是管理员的", tags = {"证书信息" } ,notes = "根据人员信息查询记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALAscriptionSysDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"证书信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchdefault")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"证书信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchdefault")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属于", tags = {"证书信息" } ,notes = "根据人员信息获取记录所属于")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchjlss")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属于", tags = {"证书信息" } ,notes = "根据人员信息查询记录所属于")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchjlss")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(证书信息)", tags = {"证书信息" } ,notes = "根据人员信息获取自助(证书信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONAL-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(证书信息)", tags = {"证书信息" } ,notes = "根据人员信息查询自助(证书信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

