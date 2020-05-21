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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PIMLANGUAGEABILITY;
import cn.ibizlab.ehr.core.pim.service.IPIMLANGUAGEABILITYService;
import cn.ibizlab.ehr.core.pim.filter.PIMLANGUAGEABILITYSearchContext;




@Slf4j
@Api(tags = {"PIMLANGUAGEABILITY" })
@RestController("WebApi-pimlanguageability")
@RequestMapping("")
public class PIMLANGUAGEABILITYResource {

    @Autowired
    private IPIMLANGUAGEABILITYService pimlanguageabilityService;

    @Autowired
    @Lazy
    public PIMLANGUAGEABILITYMapping pimlanguageabilityMapping;

    public PIMLANGUAGEABILITYDTO permissionDTO=new PIMLANGUAGEABILITYDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMLANGUAGEABILITY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlanguageabilities/getdraft")
    public ResponseEntity<PIMLANGUAGEABILITYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityMapping.toDto(pimlanguageabilityService.getDraft(new PIMLANGUAGEABILITY())));
    }




    @PreAuthorize("hasPermission(#pimlanguageability_id,'Get',{'Sql',this.pimlanguageabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMLANGUAGEABILITY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlanguageabilities/{pimlanguageability_id}")
    public ResponseEntity<PIMLANGUAGEABILITYDTO> get(@PathVariable("pimlanguageability_id") String pimlanguageability_id) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityService.get(pimlanguageability_id);
        PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-CustRemove-all')")
    @ApiOperation(value = "员工删除数据", tags = {"PIMLANGUAGEABILITY" },  notes = "员工删除数据")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/{pimlanguageability_id}/custremove")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> custRemove(@PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY pimlanguageability = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        pimlanguageability = pimlanguageabilityService.custRemove(pimlanguageability);
        pimlanguageabilitydto = pimlanguageabilityMapping.toDto(pimlanguageability);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilitydto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMLANGUAGEABILITY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.save(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMLANGUAGEABILITY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.saveBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMLANGUAGEABILITY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.checkKey(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }




    @PreAuthorize("hasPermission(#pimlanguageability_id,'Remove',{'Sql',this.pimlanguageabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMLANGUAGEABILITY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlanguageability_id") String pimlanguageability_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.remove(pimlanguageability_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMLANGUAGEABILITY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlanguageabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimlanguageability_id,'Update',{'Sql',this.pimlanguageabilityMapping,#pimlanguageabilitydto})")
    @ApiOperation(value = "Update", tags = {"PIMLANGUAGEABILITY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> update(@PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
		PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimlanguageabilityid(pimlanguageability_id);
		pimlanguageabilityService.update(domain);
		PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PIMLANGUAGEABILITY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.updateBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimlanguageabilityMapping,#pimlanguageabilitydto})")
    @ApiOperation(value = "Create", tags = {"PIMLANGUAGEABILITY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> create(@RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
		pimlanguageabilityService.create(domain);
        PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PIMLANGUAGEABILITY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.createBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlssgr")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchJLSSGR(PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGR(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlssgr")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchJLSSGR(@RequestBody PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchdefault")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchDefault(PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchDefault(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMLANGUAGEABILITY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchdefault")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchDefault(@RequestBody PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlss")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchJLSS(PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSS(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlss")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchJLSS(@RequestBody PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(语言能力)", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch自助(语言能力)")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchzizhu")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchZIZHU(PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchZIZHU(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-ZIZHU-all')")
	@ApiOperation(value = "search自助(语言能力)", tags = {"PIMLANGUAGEABILITY" } ,notes = "search自助(语言能力)")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchzizhu")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchZIZHU(@RequestBody PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlssgly")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchJLSSGLY(PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlssgly")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchJLSSGLY(@RequestBody PIMLANGUAGEABILITYSearchContext context) {
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/getdraft")
    public ResponseEntity<PIMLANGUAGEABILITYDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMLANGUAGEABILITY domain = new PIMLANGUAGEABILITY();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityMapping.toDto(pimlanguageabilityService.getDraft(domain)));
    }

    //@PreAuthorize("hasPermission(#pimlanguageability_id,'Get',{'Sql',this.pimlanguageabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    public ResponseEntity<PIMLANGUAGEABILITYDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityService.get(pimlanguageability_id);
        PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-CustRemove-all')")
    @ApiOperation(value = "员工删除数据ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "员工删除数据ByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageabilitypimlanguageabilityid}/custremove")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> custRemoveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimlanguageabilityService.custRemove(domain) ;
        pimlanguageabilitydto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilitydto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        List<PIMLANGUAGEABILITY> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PIMLANGUAGEABILITY domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.checkKey(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }

    //@PreAuthorize("hasPermission(#pimlanguageability_id,'Remove',{'Sql',this.pimlanguageabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.remove(pimlanguageability_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimlanguageabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimlanguageability_id,'Update',{'Sql',this.pimlanguageabilityMapping,#pimlanguageabilitydto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimlanguageabilityid(pimlanguageability_id);
		pimlanguageabilityService.update(domain);
        PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        List<PIMLANGUAGEABILITY> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PIMLANGUAGEABILITY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimlanguageabilityMapping,#pimlanguageabilitydto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities")
    @Transactional
    public ResponseEntity<PIMLANGUAGEABILITYDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYDTO pimlanguageabilitydto) {
        PIMLANGUAGEABILITY domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
		pimlanguageabilityService.create(domain);
        PIMLANGUAGEABILITYDTO dto = pimlanguageabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMLANGUAGEABILITY" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMLANGUAGEABILITYDTO> pimlanguageabilitydtos) {
        List<PIMLANGUAGEABILITY> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PIMLANGUAGEABILITY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlssgr")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchPIMLANGUAGEABILITYJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGR(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlssgr")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchPIMLANGUAGEABILITYJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchdefault")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchPIMLANGUAGEABILITYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchDefault(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchdefault")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchPIMLANGUAGEABILITYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlss")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchPIMLANGUAGEABILITYJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSS(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlss")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchPIMLANGUAGEABILITYJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(语言能力)ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch自助(语言能力)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchzizhu")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchPIMLANGUAGEABILITYZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchZIZHU(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-ZIZHU-all')")
	@ApiOperation(value = "search自助(语言能力)ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "search自助(语言能力)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchzizhu")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchPIMLANGUAGEABILITYZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlssgly")
	public ResponseEntity<List<PIMLANGUAGEABILITYDTO>> fetchPIMLANGUAGEABILITYJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
        List<PIMLANGUAGEABILITYDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLANGUAGEABILITY-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMLANGUAGEABILITY" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlssgly")
	public ResponseEntity<Page<PIMLANGUAGEABILITYDTO>> searchPIMLANGUAGEABILITYJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMLANGUAGEABILITYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMLANGUAGEABILITY> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


