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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVEMANAGEService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEMANAGESearchContext;




@Slf4j
@Api(tags = {"VACLEAVEMANAGE" })
@RestController("WebApi-vacleavemanage")
@RequestMapping("")
public class VACLEAVEMANAGEResource {

    @Autowired
    private IVACLEAVEMANAGEService vacleavemanageService;

    @Autowired
    @Lazy
    public VACLEAVEMANAGEMapping vacleavemanageMapping;

    public VACLEAVEMANAGEDTO permissionDTO=new VACLEAVEMANAGEDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-UpdateQJMX-all')")
    @ApiOperation(value = "更新请假明细", tags = {"VACLEAVEMANAGE" },  notes = "更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}/updateqjmx")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> updateQJMX(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage = vacleavemanageService.updateQJMX(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CB-all')")
    @ApiOperation(value = "催办", tags = {"VACLEAVEMANAGE" },  notes = "催办")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/cb")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> cB(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage = vacleavemanageService.cB(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"VACLEAVEMANAGE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/getdraft")
    public ResponseEntity<VACLEAVEMANAGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageMapping.toDto(vacleavemanageService.getDraft(new VACLEAVEMANAGE())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CX-all')")
    @ApiOperation(value = "撤销", tags = {"VACLEAVEMANAGE" },  notes = "撤销")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/cx")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> cX(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage = vacleavemanageService.cX(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }




    @PreAuthorize("hasPermission(#vacleavemanage_id,'Update',{'Sql',this.vacleavemanageMapping,#vacleavemanagedto})")
    @ApiOperation(value = "Update", tags = {"VACLEAVEMANAGE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> update(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
		VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setVacleavemanageid(vacleavemanage_id);
		vacleavemanageService.update(domain);
		VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"VACLEAVEMANAGE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        vacleavemanageService.updateBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacleavemanage_id,'Remove',{'Sql',this.vacleavemanageMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"VACLEAVEMANAGE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavemanage_id") String vacleavemanage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.remove(vacleavemanage_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACLEAVEMANAGE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavemanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取员工附加数据", tags = {"VACLEAVEMANAGE" },  notes = "获取员工附加数据")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}/getfjsjofperson")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> getFJSJofPerson(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage = vacleavemanageService.getFJSJofPerson(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Save-all')")
    @ApiOperation(value = "Save", tags = {"VACLEAVEMANAGE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.save(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACLEAVEMANAGE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        vacleavemanageService.saveBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.vacleavemanageMapping,#vacleavemanagedto})")
    @ApiOperation(value = "Create", tags = {"VACLEAVEMANAGE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> create(@RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
		vacleavemanageService.create(domain);
        VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"VACLEAVEMANAGE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        vacleavemanageService.createBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacleavemanage_id,'Get',{'Sql',this.vacleavemanageMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"VACLEAVEMANAGE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}")
    public ResponseEntity<VACLEAVEMANAGEDTO> get(@PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VACLEAVEMANAGE domain = vacleavemanageService.get(vacleavemanage_id);
        VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"VACLEAVEMANAGE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.checkKey(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MobStart-all')")
    @ApiOperation(value = "移动端启动流程", tags = {"VACLEAVEMANAGE" },  notes = "移动端启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/mobstart")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> mobStart(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage = vacleavemanageService.mobStart(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-FormType-all')")
	@ApiOperation(value = "fetchFormType", tags = {"VACLEAVEMANAGE" } ,notes = "fetchFormType")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchformtype")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchFormType(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchFormType(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-FormType-all')")
	@ApiOperation(value = "searchFormType", tags = {"VACLEAVEMANAGE" } ,notes = "searchFormType")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchformtype")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchFormType(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GR-all')")
	@ApiOperation(value = "fetch个人", tags = {"VACLEAVEMANAGE" } ,notes = "fetch个人")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchgr")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchGR(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchGR(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GR-all')")
	@ApiOperation(value = "search个人", tags = {"VACLEAVEMANAGE" } ,notes = "search个人")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchgr")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchGR(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MOBJLSS-all')")
	@ApiOperation(value = "fetch记录所属（移动端）", tags = {"VACLEAVEMANAGE" } ,notes = "fetch记录所属（移动端）")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchmobjlss")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchMOBJLSS(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchMOBJLSS(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MOBJLSS-all')")
	@ApiOperation(value = "search记录所属（移动端）", tags = {"VACLEAVEMANAGE" } ,notes = "search记录所属（移动端）")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchmobjlss")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchMOBJLSS(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"VACLEAVEMANAGE" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchjlss")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchJLSS(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchJLSS(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"VACLEAVEMANAGE" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchjlss")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchJLSS(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEAVEMANAGE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchdefault")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchDefault(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchDefault(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEAVEMANAGE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchdefault")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchDefault(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-OnlySPTY-all')")
	@ApiOperation(value = "fetch只查看审批中、已同意的请假记录", tags = {"VACLEAVEMANAGE" } ,notes = "fetch只查看审批中、已同意的请假记录")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchonlyspty")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchOnlySPTY(VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchOnlySPTY(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-OnlySPTY-all')")
	@ApiOperation(value = "search只查看审批中、已同意的请假记录", tags = {"VACLEAVEMANAGE" } ,notes = "search只查看审批中、已同意的请假记录")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchonlyspty")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchOnlySPTY(@RequestBody VACLEAVEMANAGESearchContext context) {
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchOnlySPTY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-UpdateQJMX-all')")
    @ApiOperation(value = "更新请假明细ByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "更新请假明细ByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanagevacleavemanageid}/updateqjmx")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> updateQJMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.updateQJMX(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CB-all')")
    @ApiOperation(value = "催办ByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "催办ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanagevacleavemanageid}/cb")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> cBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.cB(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/getdraft")
    public ResponseEntity<VACLEAVEMANAGEDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        VACLEAVEMANAGE domain = new VACLEAVEMANAGE();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageMapping.toDto(vacleavemanageService.getDraft(domain)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CX-all')")
    @ApiOperation(value = "撤销ByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "撤销ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanagevacleavemanageid}/cx")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> cXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.cX(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasPermission(#vacleavemanage_id,'Update',{'Sql',this.vacleavemanageMapping,#vacleavemanagedto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain.setVacleavemanageid(vacleavemanage_id);
		vacleavemanageService.update(domain);
        VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        List<VACLEAVEMANAGE> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VACLEAVEMANAGE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#vacleavemanage_id,'Remove',{'Sql',this.vacleavemanageMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.remove(vacleavemanage_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        vacleavemanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取员工附加数据ByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "获取员工附加数据ByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanagevacleavemanageid}/getfjsjofperson")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> getFJSJofPersonByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.getFJSJofPerson(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        List<VACLEAVEMANAGE> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VACLEAVEMANAGE domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.vacleavemanageMapping,#vacleavemanagedto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
		vacleavemanageService.create(domain);
        VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VACLEAVEMANAGEDTO> vacleavemanagedtos) {
        List<VACLEAVEMANAGE> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VACLEAVEMANAGE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#vacleavemanage_id,'Get',{'Sql',this.vacleavemanageMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    public ResponseEntity<VACLEAVEMANAGEDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VACLEAVEMANAGE domain = vacleavemanageService.get(vacleavemanage_id);
        VACLEAVEMANAGEDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.checkKey(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MobStart-all')")
    @ApiOperation(value = "移动端启动流程ByPIMPERSON", tags = {"VACLEAVEMANAGE" },  notes = "移动端启动流程ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanagevacleavemanageid}/mobstart")
    @Transactional
    public ResponseEntity<VACLEAVEMANAGEDTO> mobStartByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VACLEAVEMANAGEDTO vacleavemanagedto) {
        VACLEAVEMANAGE domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.mobStart(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-FormType-all')")
	@ApiOperation(value = "fetchFormTypeByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetchFormTypeByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchformtype")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEFormTypeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchFormType(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-FormType-all')")
	@ApiOperation(value = "searchFormTypeByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "searchFormTypeByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchformtype")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEFormTypeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GR-all')")
	@ApiOperation(value = "fetch个人ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetch个人ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchgr")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchGR(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-GR-all')")
	@ApiOperation(value = "search个人ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "search个人ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchgr")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MOBJLSS-all')")
	@ApiOperation(value = "fetch记录所属（移动端）ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetch记录所属（移动端）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchmobjlss")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEMOBJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchMOBJLSS(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-MOBJLSS-all')")
	@ApiOperation(value = "search记录所属（移动端）ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "search记录所属（移动端）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchmobjlss")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEMOBJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetch记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchjlss")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchJLSS(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "search记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchjlss")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchdefault")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchDefault(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchdefault")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-OnlySPTY-all')")
	@ApiOperation(value = "fetch只查看审批中、已同意的请假记录ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "fetch只查看审批中、已同意的请假记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchonlyspty")
	public ResponseEntity<List<VACLEAVEMANAGEDTO>> fetchVACLEAVEMANAGEOnlySPTYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchOnlySPTY(context) ;
        List<VACLEAVEMANAGEDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVEMANAGE-OnlySPTY-all')")
	@ApiOperation(value = "search只查看审批中、已同意的请假记录ByPIMPERSON", tags = {"VACLEAVEMANAGE" } ,notes = "search只查看审批中、已同意的请假记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchonlyspty")
	public ResponseEntity<Page<VACLEAVEMANAGEDTO>> searchVACLEAVEMANAGEOnlySPTYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VACLEAVEMANAGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VACLEAVEMANAGE> domains = vacleavemanageService.searchOnlySPTY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


