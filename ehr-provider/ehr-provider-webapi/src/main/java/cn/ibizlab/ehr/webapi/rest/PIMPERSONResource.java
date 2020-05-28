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
import cn.ibizlab.ehr.core.pim.domain.PIMPERSON;
import cn.ibizlab.ehr.core.pim.service.IPIMPERSONService;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONSearchContext;

@Slf4j
@Api(tags = {"PIMPERSON" })
@RestController("WebApi-pimperson")
@RequestMapping("")
public class PIMPERSONResource {

    @Autowired
    public IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    public PIMPERSONMapping pimpersonMapping;

    @PreAuthorize("hasPermission(this.pimpersonService.get(#pimperson_id),'ehr-PIMPERSON-Update')")
    @ApiOperation(value = "Update", tags = {"PIMPERSON" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> update(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
		PIMPERSON domain  = pimpersonMapping.toDomain(pimpersondto);
        domain .setPimpersonid(pimperson_id);
		pimpersonService.update(domain );
		PIMPERSONDTO dto = pimpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonService.getPimpersonByEntities(this.pimpersonMapping.toDomain(#pimpersondtos)),'ehr-PIMPERSON-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPERSON" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPERSONDTO> pimpersondtos) {
        pimpersonService.updateBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-YZSFYZFP-all')")
    @ApiOperation(value = "验证是否有（有效的）主分配", tags = {"PIMPERSON" },  notes = "验证是否有（有效的）主分配")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/yzsfyzfp")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> yZSFYZFP(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.yZSFYZFP(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-ToggleLeader-all')")
    @ApiOperation(value = "设置/取消为领导班子", tags = {"PIMPERSON" },  notes = "设置/取消为领导班子")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/toggleleader")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> toggleLeader(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.toggleLeader(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PostAuthorize("hasPermission(this.pimpersonMapping.toDomain(returnObject.body),'ehr-PIMPERSON-Get')")
    @ApiOperation(value = "Get", tags = {"PIMPERSON" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}")
    public ResponseEntity<PIMPERSONDTO> get(@PathVariable("pimperson_id") String pimperson_id) {
        PIMPERSON domain = pimpersonService.get(pimperson_id);
        PIMPERSONDTO dto = pimpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-PersonUpdateInfo-all')")
    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"PIMPERSON" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/personupdateinfo")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> personUpdateInfo(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.personUpdateInfo(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-FillPersonType-all')")
    @ApiOperation(value = "根据员工编号更新员工类型", tags = {"PIMPERSON" },  notes = "根据员工编号更新员工类型")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/fillpersontype")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> fillPersonType(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.fillPersonType(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondto),'ehr-PIMPERSON-Create')")
    @ApiOperation(value = "Create", tags = {"PIMPERSON" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> create(@RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON domain = pimpersonMapping.toDomain(pimpersondto);
		pimpersonService.create(domain);
        PIMPERSONDTO dto = pimpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondtos),'ehr-PIMPERSON-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMPERSON" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPERSONDTO> pimpersondtos) {
        pimpersonService.createBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondto),'ehr-PIMPERSON-Save')")
    @ApiOperation(value = "Save", tags = {"PIMPERSON" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPERSONDTO pimpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonService.save(pimpersonMapping.toDomain(pimpersondto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondtos),'ehr-PIMPERSON-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPERSON" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPERSONDTO> pimpersondtos) {
        pimpersonService.saveBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GetJTLXRDH-all')")
    @ApiOperation(value = "获取家庭联系人电话", tags = {"PIMPERSON" },  notes = "获取家庭联系人电话")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/getjtlxrdh")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> getJTLXRDH(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.getJTLXRDH(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SynPerson-all')")
    @ApiOperation(value = "推送员工信息", tags = {"PIMPERSON" },  notes = "推送员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/synperson")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> synPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.synPerson(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasPermission(this.pimpersonService.get(#pimperson_id),'ehr-PIMPERSON-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMPERSON" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimperson_id") String pimperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonService.remove(pimperson_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonService.getPimpersonByIds(#ids),'ehr-PIMPERSON-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPERSON" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PIMPERSON" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPERSONDTO pimpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonService.checkKey(pimpersonMapping.toDomain(pimpersondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-QRTX-all')")
    @ApiOperation(value = "确认退休", tags = {"PIMPERSON" },  notes = "确认退休")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/qrtx")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> qRTX(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.qRTX(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMPERSON" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/getdraft")
    public ResponseEntity<PIMPERSONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonMapping.toDto(pimpersonService.getDraft(new PIMPERSON())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GeneratePersonFile-all')")
    @ApiOperation(value = "生成人员档案", tags = {"PIMPERSON" },  notes = "生成人员档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/generatepersonfile")
    @Transactional
    public ResponseEntity<PIMPERSONDTO> generatePersonFile(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONDTO pimpersondto) {
        PIMPERSON pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.generatePersonFile(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KFPRY-all')")
	@ApiOperation(value = "fetch可返聘人员", tags = {"PIMPERSON" } ,notes = "fetch可返聘人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkfpry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKFPRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKFPRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KFPRY-all')")
	@ApiOperation(value = "search可返聘人员", tags = {"PIMPERSON" } ,notes = "search可返聘人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkfpry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKFPRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKFPRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-YGXXGLY-all')")
	@ApiOperation(value = "fetch员工信息（管理员）", tags = {"PIMPERSON" } ,notes = "fetch员工信息（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchygxxgly")
	public ResponseEntity<List<PIMPERSONDTO>> fetchYGXXGLY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchYGXXGLY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-YGXXGLY-all')")
	@ApiOperation(value = "search员工信息（管理员）", tags = {"PIMPERSON" } ,notes = "search员工信息（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchygxxgly")
	public ResponseEntity<Page<PIMPERSONDTO>> searchYGXXGLY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchYGXXGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-XMBRYCX-all')")
	@ApiOperation(value = "fetch项目部人员查询", tags = {"PIMPERSON" } ,notes = "fetch项目部人员查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchxmbrycx")
	public ResponseEntity<List<PIMPERSONDTO>> fetchXMBRYCX(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchXMBRYCX(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-XMBRYCX-all')")
	@ApiOperation(value = "search项目部人员查询", tags = {"PIMPERSON" } ,notes = "search项目部人员查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchxmbrycx")
	public ResponseEntity<Page<PIMPERSONDTO>> searchXMBRYCX(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchXMBRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurOrgPerson-all')")
	@ApiOperation(value = "fetch当前组织实际可选人员", tags = {"PIMPERSON" } ,notes = "fetch当前组织实际可选人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurorgperson")
	public ResponseEntity<List<PIMPERSONDTO>> fetchCurOrgPerson(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurOrgPerson(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurOrgPerson-all')")
	@ApiOperation(value = "search当前组织实际可选人员", tags = {"PIMPERSON" } ,notes = "search当前组织实际可选人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurorgperson")
	public ResponseEntity<Page<PIMPERSONDTO>> searchCurOrgPerson(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurOrgPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMPERSON" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjlssgr")
	public ResponseEntity<List<PIMPERSONDTO>> fetchJLSSGR(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJLSSGR(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMPERSON" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjlssgr")
	public ResponseEntity<Page<PIMPERSONDTO>> searchJLSSGR(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurLeader-all')")
	@ApiOperation(value = "fetch部门负责人选择范围", tags = {"PIMPERSON" } ,notes = "fetch部门负责人选择范围")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurleader")
	public ResponseEntity<List<PIMPERSONDTO>> fetchCurLeader(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurLeader(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurLeader-all')")
	@ApiOperation(value = "search部门负责人选择范围", tags = {"PIMPERSON" } ,notes = "search部门负责人选择范围")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurleader")
	public ResponseEntity<Page<PIMPERSONDTO>> searchCurLeader(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurLeader(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SFHMD-all')")
	@ApiOperation(value = "fetch是否黑名单", tags = {"PIMPERSON" } ,notes = "fetch是否黑名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsfhmd")
	public ResponseEntity<List<PIMPERSONDTO>> fetchSFHMD(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSFHMD(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SFHMD-all')")
	@ApiOperation(value = "search是否黑名单", tags = {"PIMPERSON" } ,notes = "search是否黑名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsfhmd")
	public ResponseEntity<Page<PIMPERSONDTO>> searchSFHMD(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSFHMD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SSTRERSONINFO-all')")
	@ApiOperation(value = "fetch人员信息树视图", tags = {"PIMPERSON" } ,notes = "fetch人员信息树视图")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsstrersoninfo")
	public ResponseEntity<List<PIMPERSONDTO>> fetchSSTRERSONINFO(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSSTRERSONINFO(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SSTRERSONINFO-all')")
	@ApiOperation(value = "search人员信息树视图", tags = {"PIMPERSON" } ,notes = "search人员信息树视图")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsstrersoninfo")
	public ResponseEntity<Page<PIMPERSONDTO>> searchSSTRERSONINFO(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSSTRERSONINFO(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurJHRY-all')")
	@ApiOperation(value = "fetch当前组织可选计划人员", tags = {"PIMPERSON" } ,notes = "fetch当前组织可选计划人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurjhry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchCurJHRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurJHRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurJHRY-all')")
	@ApiOperation(value = "search当前组织可选计划人员", tags = {"PIMPERSON" } ,notes = "search当前组织可选计划人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurjhry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchCurJHRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurJHRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KTXYG-all')")
	@ApiOperation(value = "fetch可退休人员", tags = {"PIMPERSON" } ,notes = "fetch可退休人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchktxyg")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKTXYG(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKTXYG(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KTXYG-all')")
	@ApiOperation(value = "search可退休人员", tags = {"PIMPERSON" } ,notes = "search可退休人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchktxyg")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKTXYG(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKTXYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-BYLYG-all')")
	@ApiOperation(value = "fetch非A类员工", tags = {"PIMPERSON" } ,notes = "fetch非A类员工")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchbylyg")
	public ResponseEntity<List<PIMPERSONDTO>> fetchBYLYG(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchBYLYG(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-BYLYG-all')")
	@ApiOperation(value = "search非A类员工", tags = {"PIMPERSON" } ,notes = "search非A类员工")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchbylyg")
	public ResponseEntity<Page<PIMPERSONDTO>> searchBYLYG(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchBYLYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GBHMC-all')")
	@ApiOperation(value = "fetch干部花名册", tags = {"PIMPERSON" } ,notes = "fetch干部花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchgbhmc")
	public ResponseEntity<List<PIMPERSONDTO>> fetchGBHMC(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchGBHMC(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GBHMC-all')")
	@ApiOperation(value = "search干部花名册", tags = {"PIMPERSON" } ,notes = "search干部花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchgbhmc")
	public ResponseEntity<Page<PIMPERSONDTO>> searchGBHMC(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchGBHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GZDQGL-all')")
	@ApiOperation(value = "fetch挂职到期管理", tags = {"PIMPERSON" } ,notes = "fetch挂职到期管理")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchgzdqgl")
	public ResponseEntity<List<PIMPERSONDTO>> fetchGZDQGL(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchGZDQGL(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-GZDQGL-all')")
	@ApiOperation(value = "search挂职到期管理", tags = {"PIMPERSON" } ,notes = "search挂职到期管理")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchgzdqgl")
	public ResponseEntity<Page<PIMPERSONDTO>> searchGZDQGL(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchGZDQGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KQJRYCX-all')")
	@ApiOperation(value = "fetch可请假员工查询", tags = {"PIMPERSON" } ,notes = "fetch可请假员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkqjrycx")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKQJRYCX(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKQJRYCX(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KQJRYCX-all')")
	@ApiOperation(value = "search可请假员工查询", tags = {"PIMPERSON" } ,notes = "search可请假员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkqjrycx")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKQJRYCX(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKQJRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-LTXSTAFF-all')")
	@ApiOperation(value = "fetch离（退）休员工", tags = {"PIMPERSON" } ,notes = "fetch离（退）休员工")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchltxstaff")
	public ResponseEntity<List<PIMPERSONDTO>> fetchLTXSTAFF(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchLTXSTAFF(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-LTXSTAFF-all')")
	@ApiOperation(value = "search离（退）休员工", tags = {"PIMPERSON" } ,notes = "search离（退）休员工")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchltxstaff")
	public ResponseEntity<Page<PIMPERSONDTO>> searchLTXSTAFF(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchLTXSTAFF(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-REP_PERSONORGTYPE-all')")
	@ApiOperation(value = "fetch机关 项目人员分布", tags = {"PIMPERSON" } ,notes = "fetch机关 项目人员分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchrep_personorgtype")
	public ResponseEntity<List<HashMap>> fetchREP_PERSONORGTYPE(PIMPERSONSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONORGTYPE(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-REP_PERSONORGTYPE-all')")
	@ApiOperation(value = "search机关 项目人员分布", tags = {"PIMPERSON" } ,notes = "search机关 项目人员分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchrep_personorgtype")
	public ResponseEntity<Page<HashMap>> searchREP_PERSONORGTYPE(@RequestBody PIMPERSONSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONORGTYPE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-AuthPerson-all')")
	@ApiOperation(value = "fetch显示人员（权限控制）", tags = {"PIMPERSON" } ,notes = "fetch显示人员（权限控制）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchauthperson")
	public ResponseEntity<List<PIMPERSONDTO>> fetchAuthPerson(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchAuthPerson(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-AuthPerson-all')")
	@ApiOperation(value = "search显示人员（权限控制）", tags = {"PIMPERSON" } ,notes = "search显示人员（权限控制）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchauthperson")
	public ResponseEntity<Page<PIMPERSONDTO>> searchAuthPerson(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchAuthPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPERSON" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchdefault")
	public ResponseEntity<List<PIMPERSONDTO>> fetchDefault(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchDefault(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPERSON" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchdefault")
	public ResponseEntity<Page<PIMPERSONDTO>> searchDefault(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KGZRY-all')")
	@ApiOperation(value = "fetch可挂职人员", tags = {"PIMPERSON" } ,notes = "fetch可挂职人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkgzry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKGZRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKGZRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KGZRY-all')")
	@ApiOperation(value = "search可挂职人员", tags = {"PIMPERSON" } ,notes = "search可挂职人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkgzry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKGZRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKGZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SELFHELPID-all')")
	@ApiOperation(value = "fetch员工自助登录人员ID", tags = {"PIMPERSON" } ,notes = "fetch员工自助登录人员ID")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchselfhelpid")
	public ResponseEntity<List<PIMPERSONDTO>> fetchSELFHELPID(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSELFHELPID(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SELFHELPID-all')")
	@ApiOperation(value = "search员工自助登录人员ID", tags = {"PIMPERSON" } ,notes = "search员工自助登录人员ID")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchselfhelpid")
	public ResponseEntity<Page<PIMPERSONDTO>> searchSELFHELPID(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSELFHELPID(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SYQYGCX-all')")
	@ApiOperation(value = "fetch试用期员工查询", tags = {"PIMPERSON" } ,notes = "fetch试用期员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsyqygcx")
	public ResponseEntity<List<PIMPERSONDTO>> fetchSYQYGCX(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSYQYGCX(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SYQYGCX-all')")
	@ApiOperation(value = "search试用期员工查询", tags = {"PIMPERSON" } ,notes = "search试用期员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsyqygcx")
	public ResponseEntity<Page<PIMPERSONDTO>> searchSYQYGCX(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSYQYGCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-LZRYHMC-all')")
	@ApiOperation(value = "fetch离职人员花名册", tags = {"PIMPERSON" } ,notes = "fetch离职人员花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchlzryhmc")
	public ResponseEntity<List<PIMPERSONDTO>> fetchLZRYHMC(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchLZRYHMC(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-LZRYHMC-all')")
	@ApiOperation(value = "search离职人员花名册", tags = {"PIMPERSON" } ,notes = "search离职人员花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchlzryhmc")
	public ResponseEntity<Page<PIMPERSONDTO>> searchLZRYHMC(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchLZRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TitleUse-all')")
	@ApiOperation(value = "fetch头衔专用", tags = {"PIMPERSON" } ,notes = "fetch头衔专用")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtitleuse")
	public ResponseEntity<List<PIMPERSONDTO>> fetchTitleUse(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTitleUse(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TitleUse-all')")
	@ApiOperation(value = "search头衔专用", tags = {"PIMPERSON" } ,notes = "search头衔专用")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtitleuse")
	public ResponseEntity<Page<PIMPERSONDTO>> searchTitleUse(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTitleUse(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JXQYGCX-all')")
	@ApiOperation(value = "fetch见习期员工查询", tags = {"PIMPERSON" } ,notes = "fetch见习期员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjxqygcx")
	public ResponseEntity<List<PIMPERSONDTO>> fetchJXQYGCX(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJXQYGCX(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JXQYGCX-all')")
	@ApiOperation(value = "search见习期员工查询", tags = {"PIMPERSON" } ,notes = "search见习期员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjxqygcx")
	public ResponseEntity<Page<PIMPERSONDTO>> searchJXQYGCX(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJXQYGCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-YXZFPRYDS-all')")
	@ApiOperation(value = "fetch存在有效分配的主分配的人员", tags = {"PIMPERSON" } ,notes = "fetch存在有效分配的主分配的人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchyxzfpryds")
	public ResponseEntity<List<PIMPERSONDTO>> fetchYXZFPRYDS(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchYXZFPRYDS(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-YXZFPRYDS-all')")
	@ApiOperation(value = "search存在有效分配的主分配的人员", tags = {"PIMPERSON" } ,notes = "search存在有效分配的主分配的人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchyxzfpryds")
	public ResponseEntity<Page<PIMPERSONDTO>> searchYXZFPRYDS(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchYXZFPRYDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-RYZT_30-all')")
	@ApiOperation(value = "fetch在职人员", tags = {"PIMPERSON" } ,notes = "fetch在职人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchryzt_30")
	public ResponseEntity<List<PIMPERSONDTO>> fetchRYZT_30(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchRYZT_30(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-RYZT_30-all')")
	@ApiOperation(value = "search在职人员", tags = {"PIMPERSON" } ,notes = "search在职人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchryzt_30")
	public ResponseEntity<Page<PIMPERSONDTO>> searchRYZT_30(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchRYZT_30(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-DTXYG-all')")
	@ApiOperation(value = "fetch待退休人员", tags = {"PIMPERSON" } ,notes = "fetch待退休人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchdtxyg")
	public ResponseEntity<List<PIMPERSONDTO>> fetchDTXYG(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchDTXYG(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-DTXYG-all')")
	@ApiOperation(value = "search待退休人员", tags = {"PIMPERSON" } ,notes = "search待退休人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchdtxyg")
	public ResponseEntity<Page<PIMPERSONDTO>> searchDTXYG(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchDTXYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-XZKQRY-all')")
	@ApiOperation(value = "fetch新增考勤人员（考勤设置）", tags = {"PIMPERSON" } ,notes = "fetch新增考勤人员（考勤设置）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchxzkqry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchXZKQRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchXZKQRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-XZKQRY-all')")
	@ApiOperation(value = "search新增考勤人员（考勤设置）", tags = {"PIMPERSON" } ,notes = "search新增考勤人员（考勤设置）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchxzkqry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchXZKQRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchXZKQRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-REP_PERSONAGE-all')")
	@ApiOperation(value = "fetch年龄分布", tags = {"PIMPERSON" } ,notes = "fetch年龄分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchrep_personage")
	public ResponseEntity<List<HashMap>> fetchREP_PERSONAGE(PIMPERSONSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONAGE(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-REP_PERSONAGE-all')")
	@ApiOperation(value = "search年龄分布", tags = {"PIMPERSON" } ,notes = "search年龄分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchrep_personage")
	public ResponseEntity<Page<HashMap>> searchREP_PERSONAGE(@RequestBody PIMPERSONSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONAGE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SYQKZZRY-all')")
	@ApiOperation(value = "fetch试用期可转正人员", tags = {"PIMPERSON" } ,notes = "fetch试用期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsyqkzzry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchSYQKZZRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSYQKZZRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-SYQKZZRY-all')")
	@ApiOperation(value = "search试用期可转正人员", tags = {"PIMPERSON" } ,notes = "search试用期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsyqkzzry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchSYQKZZRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchSYQKZZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JXQKZZRY-all')")
	@ApiOperation(value = "fetch见习期可转正人员", tags = {"PIMPERSON" } ,notes = "fetch见习期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjxqkzzry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchJXQKZZRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJXQKZZRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-JXQKZZRY-all')")
	@ApiOperation(value = "search见习期可转正人员", tags = {"PIMPERSON" } ,notes = "search见习期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjxqkzzry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchJXQKZZRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchJXQKZZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TXGB-all')")
	@ApiOperation(value = "fetch退休干部", tags = {"PIMPERSON" } ,notes = "fetch退休干部")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtxgb")
	public ResponseEntity<List<PIMPERSONDTO>> fetchTXGB(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTXGB(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TXGB-all')")
	@ApiOperation(value = "search退休干部", tags = {"PIMPERSON" } ,notes = "search退休干部")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtxgb")
	public ResponseEntity<Page<PIMPERSONDTO>> searchTXGB(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTXGB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KZJBDRY-all')")
	@ApiOperation(value = "fetch可进行职级变动的人员", tags = {"PIMPERSON" } ,notes = "fetch可进行职级变动的人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkzjbdry")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKZJBDRY(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKZJBDRY(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KZJBDRY-all')")
	@ApiOperation(value = "search可进行职级变动的人员", tags = {"PIMPERSON" } ,notes = "search可进行职级变动的人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkzjbdry")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKZJBDRY(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKZJBDRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurOrgPimperson-all')")
	@ApiOperation(value = "fetch当前组织下人员", tags = {"PIMPERSON" } ,notes = "fetch当前组织下人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurorgpimperson")
	public ResponseEntity<List<PIMPERSONDTO>> fetchCurOrgPimperson(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurOrgPimperson(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-CurOrgPimperson-all')")
	@ApiOperation(value = "search当前组织下人员", tags = {"PIMPERSON" } ,notes = "search当前组织下人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurorgpimperson")
	public ResponseEntity<Page<PIMPERSONDTO>> searchCurOrgPimperson(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchCurOrgPimperson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TXRYCX-all')")
	@ApiOperation(value = "fetch退休员工查询", tags = {"PIMPERSON" } ,notes = "fetch退休员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtxrycx")
	public ResponseEntity<List<PIMPERSONDTO>> fetchTXRYCX(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTXRYCX(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-TXRYCX-all')")
	@ApiOperation(value = "search退休员工查询", tags = {"PIMPERSON" } ,notes = "search退休员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtxrycx")
	public ResponseEntity<Page<PIMPERSONDTO>> searchTXRYCX(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchTXRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KXZSYQKZZRYDS-all')")
	@ApiOperation(value = "fetch申请单可选择试用期可转正人员", tags = {"PIMPERSON" } ,notes = "fetch申请单可选择试用期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkxzsyqkzzryds")
	public ResponseEntity<List<PIMPERSONDTO>> fetchKXZSYQKZZRYDS(PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKXZSYQKZZRYDS(context) ;
        List<PIMPERSONDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSON-KXZSYQKZZRYDS-all')")
	@ApiOperation(value = "search申请单可选择试用期可转正人员", tags = {"PIMPERSON" } ,notes = "search申请单可选择试用期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkxzsyqkzzryds")
	public ResponseEntity<Page<PIMPERSONDTO>> searchKXZSYQKZZRYDS(@RequestBody PIMPERSONSearchContext context) {
        Page<PIMPERSON> domains = pimpersonService.searchKXZSYQKZZRYDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

