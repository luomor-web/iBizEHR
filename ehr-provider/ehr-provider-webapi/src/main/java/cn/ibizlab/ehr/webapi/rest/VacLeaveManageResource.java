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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveManageService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveManageSearchContext;

@Slf4j
@Api(tags = {"VacLeaveManage" })
@RestController("WebApi-vacleavemanage")
@RequestMapping("")
public class VacLeaveManageResource {

    @Autowired
    public IVacLeaveManageService vacleavemanageService;

    @Autowired
    @Lazy
    public VacLeaveManageMapping vacleavemanageMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-UpdateQJMX-all')")
    @ApiOperation(value = "更新请假明细", tags = {"VacLeaveManage" },  notes = "更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}/updateqjmx")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> updateQJMX(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage.setVacleavemanageid(vacleavemanage_id);
        vacleavemanage = vacleavemanageService.updateQJMX(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-CB-all')")
    @ApiOperation(value = "催办", tags = {"VacLeaveManage" },  notes = "催办")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/cb")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> cB(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage.setVacleavemanageid(vacleavemanage_id);
        vacleavemanage = vacleavemanageService.cB(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacLeaveManage" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/getdraft")
    public ResponseEntity<VacLeaveManageDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageMapping.toDto(vacleavemanageService.getDraft(new VacLeaveManage())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-CX-all')")
    @ApiOperation(value = "撤销", tags = {"VacLeaveManage" },  notes = "撤销")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/cx")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> cX(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage.setVacleavemanageid(vacleavemanage_id);
        vacleavemanage = vacleavemanageService.cX(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.get(#vacleavemanage_id),'ehr-VacLeaveManage-Update')")
    @ApiOperation(value = "Update", tags = {"VacLeaveManage" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> update(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
		VacLeaveManage domain  = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain .setVacleavemanageid(vacleavemanage_id);
		vacleavemanageService.update(domain );
		VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.getVacleavemanageByEntities(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos)),'ehr-VacLeaveManage-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacLeaveManage" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        vacleavemanageService.updateBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.get(#vacleavemanage_id),'ehr-VacLeaveManage-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacLeaveManage" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavemanage_id") String vacleavemanage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.remove(vacleavemanage_id));
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.getVacleavemanageByIds(#ids),'ehr-VacLeaveManage-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacLeaveManage" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavemanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取员工附加数据", tags = {"VacLeaveManage" },  notes = "获取员工附加数据")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}/getfjsjofperson")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> getFJSJofPerson(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage.setVacleavemanageid(vacleavemanage_id);
        vacleavemanage = vacleavemanageService.getFJSJofPerson(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedto),'ehr-VacLeaveManage-Save')")
    @ApiOperation(value = "Save", tags = {"VacLeaveManage" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaveManageDTO vacleavemanagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.save(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos),'ehr-VacLeaveManage-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacLeaveManage" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        vacleavemanageService.saveBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedto),'ehr-VacLeaveManage-Create')")
    @ApiOperation(value = "Create", tags = {"VacLeaveManage" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> create(@RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
		vacleavemanageService.create(domain);
        VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos),'ehr-VacLeaveManage-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacLeaveManage" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        vacleavemanageService.createBatch(vacleavemanageMapping.toDomain(vacleavemanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(returnObject.body),'ehr-VacLeaveManage-Get')")
    @ApiOperation(value = "Get", tags = {"VacLeaveManage" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}")
    public ResponseEntity<VacLeaveManageDTO> get(@PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VacLeaveManage domain = vacleavemanageService.get(vacleavemanage_id);
        VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"VacLeaveManage" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaveManageDTO vacleavemanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.checkKey(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MobStart-all')")
    @ApiOperation(value = "移动端启动流程", tags = {"VacLeaveManage" },  notes = "移动端启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/mobstart")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> mobStart(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage vacleavemanage = vacleavemanageMapping.toDomain(vacleavemanagedto);
        vacleavemanage.setVacleavemanageid(vacleavemanage_id);
        vacleavemanage = vacleavemanageService.mobStart(vacleavemanage);
        vacleavemanagedto = vacleavemanageMapping.toDto(vacleavemanage);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-FormType-all')")
	@ApiOperation(value = "fetchFormType", tags = {"VacLeaveManage" } ,notes = "fetchFormType")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchformtype")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchFormType(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchFormType(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-FormType-all')")
	@ApiOperation(value = "searchFormType", tags = {"VacLeaveManage" } ,notes = "searchFormType")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchformtype")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchFormType(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GR-all')")
	@ApiOperation(value = "fetch个人", tags = {"VacLeaveManage" } ,notes = "fetch个人")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchgr")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchGR(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchGR(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GR-all')")
	@ApiOperation(value = "search个人", tags = {"VacLeaveManage" } ,notes = "search个人")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchgr")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchGR(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MOBJLSS-all')")
	@ApiOperation(value = "fetch记录所属（移动端）", tags = {"VacLeaveManage" } ,notes = "fetch记录所属（移动端）")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchmobjlss")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchMOBJLSS(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchMOBJLSS(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MOBJLSS-all')")
	@ApiOperation(value = "search记录所属（移动端）", tags = {"VacLeaveManage" } ,notes = "search记录所属（移动端）")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchmobjlss")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchMOBJLSS(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"VacLeaveManage" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchjlss")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchJLSS(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchJLSS(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"VacLeaveManage" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchjlss")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchJLSS(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacLeaveManage" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchdefault")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchDefault(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchDefault(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacLeaveManage" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchdefault")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchDefault(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-OnlySPTY-all')")
	@ApiOperation(value = "fetch只查看审批中、已同意的请假记录", tags = {"VacLeaveManage" } ,notes = "fetch只查看审批中、已同意的请假记录")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/fetchonlyspty")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchOnlySPTY(VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchOnlySPTY(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-OnlySPTY-all')")
	@ApiOperation(value = "search只查看审批中、已同意的请假记录", tags = {"VacLeaveManage" } ,notes = "search只查看审批中、已同意的请假记录")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/searchonlyspty")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchOnlySPTY(@RequestBody VacLeaveManageSearchContext context) {
        Page<VacLeaveManage> domains = vacleavemanageService.searchOnlySPTY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-UpdateQJMX-all')")
    @ApiOperation(value = "更新请假明细ByPimPerson", tags = {"VacLeaveManage" },  notes = "更新请假明细ByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/updateqjmx")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> updateQJMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.updateQJMX(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-CB-all')")
    @ApiOperation(value = "催办ByPimPerson", tags = {"VacLeaveManage" },  notes = "催办ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/cb")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> cBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.cB(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"VacLeaveManage" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/getdraft")
    public ResponseEntity<VacLeaveManageDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        VacLeaveManage domain = new VacLeaveManage();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageMapping.toDto(vacleavemanageService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-CX-all')")
    @ApiOperation(value = "撤销ByPimPerson", tags = {"VacLeaveManage" },  notes = "撤销ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/cx")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> cXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.cX(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.get(#vacleavemanage_id),'ehr-VacLeaveManage-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"VacLeaveManage" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain.setVacleavemanageid(vacleavemanage_id);
		vacleavemanageService.update(domain);
        VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.getVacleavemanageByEntities(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos)),'ehr-VacLeaveManage-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"VacLeaveManage" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        List<VacLeaveManage> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VacLeaveManage domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.get(#vacleavemanage_id),'ehr-VacLeaveManage-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"VacLeaveManage" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.remove(vacleavemanage_id));
    }

    @PreAuthorize("hasPermission(this.vacleavemanageService.getVacleavemanageByIds(#ids),'ehr-VacLeaveManage-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"VacLeaveManage" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        vacleavemanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取员工附加数据ByPimPerson", tags = {"VacLeaveManage" },  notes = "获取员工附加数据ByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/getfjsjofperson")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> getFJSJofPersonByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.getFJSJofPerson(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedto),'ehr-VacLeaveManage-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"VacLeaveManage" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos),'ehr-VacLeaveManage-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"VacLeaveManage" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        List<VacLeaveManage> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VacLeaveManage domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedto),'ehr-VacLeaveManage-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"VacLeaveManage" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
		vacleavemanageService.create(domain);
        VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(#vacleavemanagedtos),'ehr-VacLeaveManage-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"VacLeaveManage" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<VacLeaveManageDTO> vacleavemanagedtos) {
        List<VacLeaveManage> domainlist=vacleavemanageMapping.toDomain(vacleavemanagedtos);
        for(VacLeaveManage domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        vacleavemanageService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacleavemanageMapping.toDomain(returnObject.body),'ehr-VacLeaveManage-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"VacLeaveManage" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}")
    public ResponseEntity<VacLeaveManageDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VacLeaveManage domain = vacleavemanageService.get(vacleavemanage_id);
        VacLeaveManageDTO dto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"VacLeaveManage" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavemanageService.checkKey(vacleavemanageMapping.toDomain(vacleavemanagedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MobStart-all')")
    @ApiOperation(value = "移动端启动流程ByPimPerson", tags = {"VacLeaveManage" },  notes = "移动端启动流程ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/mobstart")
    @Transactional
    public ResponseEntity<VacLeaveManageDTO> mobStartByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveManageDTO vacleavemanagedto) {
        VacLeaveManage domain = vacleavemanageMapping.toDomain(vacleavemanagedto);
        domain.setPimpersonid(pimperson_id);
        domain = vacleavemanageService.mobStart(domain) ;
        vacleavemanagedto = vacleavemanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavemanagedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-FormType-all')")
	@ApiOperation(value = "fetchFormTypeByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetchFormTypeByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchformtype")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageFormTypeByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchFormType(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-FormType-all')")
	@ApiOperation(value = "searchFormTypeByPimPerson", tags = {"VacLeaveManage" } ,notes = "searchFormTypeByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchformtype")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageFormTypeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GR-all')")
	@ApiOperation(value = "fetch个人ByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetch个人ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchgr")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchGR(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-GR-all')")
	@ApiOperation(value = "search个人ByPimPerson", tags = {"VacLeaveManage" } ,notes = "search个人ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchgr")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MOBJLSS-all')")
	@ApiOperation(value = "fetch记录所属（移动端）ByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetch记录所属（移动端）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchmobjlss")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageMOBJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchMOBJLSS(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-MOBJLSS-all')")
	@ApiOperation(value = "search记录所属（移动端）ByPimPerson", tags = {"VacLeaveManage" } ,notes = "search记录所属（移动端）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchmobjlss")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageMOBJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetch记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchjlss")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchJLSS(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPimPerson", tags = {"VacLeaveManage" } ,notes = "search记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchjlss")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchdefault")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchDefault(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"VacLeaveManage" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchdefault")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-OnlySPTY-all')")
	@ApiOperation(value = "fetch只查看审批中、已同意的请假记录ByPimPerson", tags = {"VacLeaveManage" } ,notes = "fetch只查看审批中、已同意的请假记录ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/fetchonlyspty")
	public ResponseEntity<List<VacLeaveManageDTO>> fetchVacLeaveManageOnlySPTYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchOnlySPTY(context) ;
        List<VacLeaveManageDTO> list = vacleavemanageMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveManage-OnlySPTY-all')")
	@ApiOperation(value = "search只查看审批中、已同意的请假记录ByPimPerson", tags = {"VacLeaveManage" } ,notes = "search只查看审批中、已同意的请假记录ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/searchonlyspty")
	public ResponseEntity<Page<VacLeaveManageDTO>> searchVacLeaveManageOnlySPTYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody VacLeaveManageSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<VacLeaveManage> domains = vacleavemanageService.searchOnlySPTY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavemanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

