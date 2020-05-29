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
import cn.ibizlab.ehr.core.pim.domain.PimPerson;
import cn.ibizlab.ehr.core.pim.service.IPimPersonService;
import cn.ibizlab.ehr.core.pim.filter.PimPersonSearchContext;

@Slf4j
@Api(tags = {"PimPerson" })
@RestController("WebApi-pimperson")
@RequestMapping("")
public class PimPersonResource {

    @Autowired
    public IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    public PimPersonMapping pimpersonMapping;

    @PreAuthorize("hasPermission(this.pimpersonService.get(#pimperson_id),'ehr-PimPerson-Update')")
    @ApiOperation(value = "Update", tags = {"PimPerson" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}")
    @Transactional
    public ResponseEntity<PimPersonDTO> update(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
		PimPerson domain  = pimpersonMapping.toDomain(pimpersondto);
        domain .setPimpersonid(pimperson_id);
		pimpersonService.update(domain );
		PimPersonDTO dto = pimpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonService.getPimpersonByEntities(this.pimpersonMapping.toDomain(#pimpersondtos)),'ehr-PimPerson-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimPerson" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPersonDTO> pimpersondtos) {
        pimpersonService.updateBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-YZSFYZFP-all')")
    @ApiOperation(value = "验证是否有（有效的）主分配", tags = {"PimPerson" },  notes = "验证是否有（有效的）主分配")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/yzsfyzfp")
    @Transactional
    public ResponseEntity<PimPersonDTO> yZSFYZFP(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.yZSFYZFP(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-ToggleLeader-all')")
    @ApiOperation(value = "设置/取消为领导班子", tags = {"PimPerson" },  notes = "设置/取消为领导班子")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/toggleleader")
    @Transactional
    public ResponseEntity<PimPersonDTO> toggleLeader(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.toggleLeader(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PostAuthorize("hasPermission(this.pimpersonMapping.toDomain(returnObject.body),'ehr-PimPerson-Get')")
    @ApiOperation(value = "Get", tags = {"PimPerson" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}")
    public ResponseEntity<PimPersonDTO> get(@PathVariable("pimperson_id") String pimperson_id) {
        PimPerson domain = pimpersonService.get(pimperson_id);
        PimPersonDTO dto = pimpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-PersonUpdateInfo-all')")
    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"PimPerson" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/personupdateinfo")
    @Transactional
    public ResponseEntity<PimPersonDTO> personUpdateInfo(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.personUpdateInfo(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-FillPersonType-all')")
    @ApiOperation(value = "根据员工编号更新员工类型", tags = {"PimPerson" },  notes = "根据员工编号更新员工类型")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/fillpersontype")
    @Transactional
    public ResponseEntity<PimPersonDTO> fillPersonType(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.fillPersonType(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondto),'ehr-PimPerson-Create')")
    @ApiOperation(value = "Create", tags = {"PimPerson" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople")
    @Transactional
    public ResponseEntity<PimPersonDTO> create(@RequestBody PimPersonDTO pimpersondto) {
        PimPerson domain = pimpersonMapping.toDomain(pimpersondto);
		pimpersonService.create(domain);
        PimPersonDTO dto = pimpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondtos),'ehr-PimPerson-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimPerson" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPersonDTO> pimpersondtos) {
        pimpersonService.createBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondto),'ehr-PimPerson-Save')")
    @ApiOperation(value = "Save", tags = {"PimPerson" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPersonDTO pimpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonService.save(pimpersonMapping.toDomain(pimpersondto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonMapping.toDomain(#pimpersondtos),'ehr-PimPerson-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimPerson" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPersonDTO> pimpersondtos) {
        pimpersonService.saveBatch(pimpersonMapping.toDomain(pimpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GetJTLXRDH-all')")
    @ApiOperation(value = "获取家庭联系人电话", tags = {"PimPerson" },  notes = "获取家庭联系人电话")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/getjtlxrdh")
    @Transactional
    public ResponseEntity<PimPersonDTO> getJTLXRDH(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.getJTLXRDH(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SynPerson-all')")
    @ApiOperation(value = "推送员工信息", tags = {"PimPerson" },  notes = "推送员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/synperson")
    @Transactional
    public ResponseEntity<PimPersonDTO> synPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.synPerson(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasPermission(this.pimpersonService.get(#pimperson_id),'ehr-PimPerson-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimPerson" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimperson_id") String pimperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonService.remove(pimperson_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonService.getPimpersonByIds(#ids),'ehr-PimPerson-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimPerson" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimPerson" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPersonDTO pimpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonService.checkKey(pimpersonMapping.toDomain(pimpersondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-QRTX-all')")
    @ApiOperation(value = "确认退休", tags = {"PimPerson" },  notes = "确认退休")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/qrtx")
    @Transactional
    public ResponseEntity<PimPersonDTO> qRTX(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.qRTX(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimPerson" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/getdraft")
    public ResponseEntity<PimPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonMapping.toDto(pimpersonService.getDraft(new PimPerson())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GeneratePersonFile-all')")
    @ApiOperation(value = "生成人员档案", tags = {"PimPerson" },  notes = "生成人员档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/generatepersonfile")
    @Transactional
    public ResponseEntity<PimPersonDTO> generatePersonFile(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonDTO pimpersondto) {
        PimPerson pimperson = pimpersonMapping.toDomain(pimpersondto);
        pimperson.setPimpersonid(pimperson_id);
        pimperson = pimpersonService.generatePersonFile(pimperson);
        pimpersondto = pimpersonMapping.toDto(pimperson);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KFPRY-all')")
	@ApiOperation(value = "fetch可返聘人员", tags = {"PimPerson" } ,notes = "fetch可返聘人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkfpry")
	public ResponseEntity<List<PimPersonDTO>> fetchKFPRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKFPRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KFPRY-all')")
	@ApiOperation(value = "search可返聘人员", tags = {"PimPerson" } ,notes = "search可返聘人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkfpry")
	public ResponseEntity<Page<PimPersonDTO>> searchKFPRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKFPRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-YGXXGLY-all')")
	@ApiOperation(value = "fetch员工信息（管理员）", tags = {"PimPerson" } ,notes = "fetch员工信息（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchygxxgly")
	public ResponseEntity<List<PimPersonDTO>> fetchYGXXGLY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchYGXXGLY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-YGXXGLY-all')")
	@ApiOperation(value = "search员工信息（管理员）", tags = {"PimPerson" } ,notes = "search员工信息（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchygxxgly")
	public ResponseEntity<Page<PimPersonDTO>> searchYGXXGLY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchYGXXGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-XMBRYCX-all')")
	@ApiOperation(value = "fetch项目部人员查询", tags = {"PimPerson" } ,notes = "fetch项目部人员查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchxmbrycx")
	public ResponseEntity<List<PimPersonDTO>> fetchXMBRYCX(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchXMBRYCX(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-XMBRYCX-all')")
	@ApiOperation(value = "search项目部人员查询", tags = {"PimPerson" } ,notes = "search项目部人员查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchxmbrycx")
	public ResponseEntity<Page<PimPersonDTO>> searchXMBRYCX(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchXMBRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurOrgPerson-all')")
	@ApiOperation(value = "fetch当前组织实际可选人员", tags = {"PimPerson" } ,notes = "fetch当前组织实际可选人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurorgperson")
	public ResponseEntity<List<PimPersonDTO>> fetchCurOrgPerson(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurOrgPerson(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurOrgPerson-all')")
	@ApiOperation(value = "search当前组织实际可选人员", tags = {"PimPerson" } ,notes = "search当前组织实际可选人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurorgperson")
	public ResponseEntity<Page<PimPersonDTO>> searchCurOrgPerson(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurOrgPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PimPerson" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjlssgr")
	public ResponseEntity<List<PimPersonDTO>> fetchJLSSGR(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJLSSGR(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PimPerson" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjlssgr")
	public ResponseEntity<Page<PimPersonDTO>> searchJLSSGR(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurLeader-all')")
	@ApiOperation(value = "fetch部门负责人选择范围", tags = {"PimPerson" } ,notes = "fetch部门负责人选择范围")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurleader")
	public ResponseEntity<List<PimPersonDTO>> fetchCurLeader(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurLeader(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurLeader-all')")
	@ApiOperation(value = "search部门负责人选择范围", tags = {"PimPerson" } ,notes = "search部门负责人选择范围")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurleader")
	public ResponseEntity<Page<PimPersonDTO>> searchCurLeader(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurLeader(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SFHMD-all')")
	@ApiOperation(value = "fetch是否黑名单", tags = {"PimPerson" } ,notes = "fetch是否黑名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsfhmd")
	public ResponseEntity<List<PimPersonDTO>> fetchSFHMD(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSFHMD(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SFHMD-all')")
	@ApiOperation(value = "search是否黑名单", tags = {"PimPerson" } ,notes = "search是否黑名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsfhmd")
	public ResponseEntity<Page<PimPersonDTO>> searchSFHMD(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSFHMD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SSTRERSONINFO-all')")
	@ApiOperation(value = "fetch人员信息树视图", tags = {"PimPerson" } ,notes = "fetch人员信息树视图")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsstrersoninfo")
	public ResponseEntity<List<PimPersonDTO>> fetchSSTRERSONINFO(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSSTRERSONINFO(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SSTRERSONINFO-all')")
	@ApiOperation(value = "search人员信息树视图", tags = {"PimPerson" } ,notes = "search人员信息树视图")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsstrersoninfo")
	public ResponseEntity<Page<PimPersonDTO>> searchSSTRERSONINFO(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSSTRERSONINFO(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurJHRY-all')")
	@ApiOperation(value = "fetch当前组织可选计划人员", tags = {"PimPerson" } ,notes = "fetch当前组织可选计划人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurjhry")
	public ResponseEntity<List<PimPersonDTO>> fetchCurJHRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurJHRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurJHRY-all')")
	@ApiOperation(value = "search当前组织可选计划人员", tags = {"PimPerson" } ,notes = "search当前组织可选计划人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurjhry")
	public ResponseEntity<Page<PimPersonDTO>> searchCurJHRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurJHRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KTXYG-all')")
	@ApiOperation(value = "fetch可退休人员", tags = {"PimPerson" } ,notes = "fetch可退休人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchktxyg")
	public ResponseEntity<List<PimPersonDTO>> fetchKTXYG(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKTXYG(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KTXYG-all')")
	@ApiOperation(value = "search可退休人员", tags = {"PimPerson" } ,notes = "search可退休人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchktxyg")
	public ResponseEntity<Page<PimPersonDTO>> searchKTXYG(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKTXYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-BYLYG-all')")
	@ApiOperation(value = "fetch非A类员工", tags = {"PimPerson" } ,notes = "fetch非A类员工")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchbylyg")
	public ResponseEntity<List<PimPersonDTO>> fetchBYLYG(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchBYLYG(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-BYLYG-all')")
	@ApiOperation(value = "search非A类员工", tags = {"PimPerson" } ,notes = "search非A类员工")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchbylyg")
	public ResponseEntity<Page<PimPersonDTO>> searchBYLYG(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchBYLYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GBHMC-all')")
	@ApiOperation(value = "fetch干部花名册", tags = {"PimPerson" } ,notes = "fetch干部花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchgbhmc")
	public ResponseEntity<List<PimPersonDTO>> fetchGBHMC(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchGBHMC(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GBHMC-all')")
	@ApiOperation(value = "search干部花名册", tags = {"PimPerson" } ,notes = "search干部花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchgbhmc")
	public ResponseEntity<Page<PimPersonDTO>> searchGBHMC(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchGBHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GZDQGL-all')")
	@ApiOperation(value = "fetch挂职到期管理", tags = {"PimPerson" } ,notes = "fetch挂职到期管理")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchgzdqgl")
	public ResponseEntity<List<PimPersonDTO>> fetchGZDQGL(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchGZDQGL(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-GZDQGL-all')")
	@ApiOperation(value = "search挂职到期管理", tags = {"PimPerson" } ,notes = "search挂职到期管理")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchgzdqgl")
	public ResponseEntity<Page<PimPersonDTO>> searchGZDQGL(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchGZDQGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KQJRYCX-all')")
	@ApiOperation(value = "fetch可请假员工查询", tags = {"PimPerson" } ,notes = "fetch可请假员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkqjrycx")
	public ResponseEntity<List<PimPersonDTO>> fetchKQJRYCX(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKQJRYCX(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KQJRYCX-all')")
	@ApiOperation(value = "search可请假员工查询", tags = {"PimPerson" } ,notes = "search可请假员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkqjrycx")
	public ResponseEntity<Page<PimPersonDTO>> searchKQJRYCX(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKQJRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-LTXSTAFF-all')")
	@ApiOperation(value = "fetch离（退）休员工", tags = {"PimPerson" } ,notes = "fetch离（退）休员工")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchltxstaff")
	public ResponseEntity<List<PimPersonDTO>> fetchLTXSTAFF(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchLTXSTAFF(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-LTXSTAFF-all')")
	@ApiOperation(value = "search离（退）休员工", tags = {"PimPerson" } ,notes = "search离（退）休员工")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchltxstaff")
	public ResponseEntity<Page<PimPersonDTO>> searchLTXSTAFF(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchLTXSTAFF(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-REP_PERSONORGTYPE-all')")
	@ApiOperation(value = "fetch机关 项目人员分布", tags = {"PimPerson" } ,notes = "fetch机关 项目人员分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchrep_personorgtype")
	public ResponseEntity<List<HashMap>> fetchREP_PERSONORGTYPE(PimPersonSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONORGTYPE(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-REP_PERSONORGTYPE-all')")
	@ApiOperation(value = "search机关 项目人员分布", tags = {"PimPerson" } ,notes = "search机关 项目人员分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchrep_personorgtype")
	public ResponseEntity<Page<HashMap>> searchREP_PERSONORGTYPE(@RequestBody PimPersonSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONORGTYPE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-AuthPerson-all')")
	@ApiOperation(value = "fetch显示人员（权限控制）", tags = {"PimPerson" } ,notes = "fetch显示人员（权限控制）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchauthperson")
	public ResponseEntity<List<PimPersonDTO>> fetchAuthPerson(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchAuthPerson(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-AuthPerson-all')")
	@ApiOperation(value = "search显示人员（权限控制）", tags = {"PimPerson" } ,notes = "search显示人员（权限控制）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchauthperson")
	public ResponseEntity<Page<PimPersonDTO>> searchAuthPerson(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchAuthPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimPerson" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchdefault")
	public ResponseEntity<List<PimPersonDTO>> fetchDefault(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchDefault(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimPerson" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchdefault")
	public ResponseEntity<Page<PimPersonDTO>> searchDefault(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KGZRY-all')")
	@ApiOperation(value = "fetch可挂职人员", tags = {"PimPerson" } ,notes = "fetch可挂职人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkgzry")
	public ResponseEntity<List<PimPersonDTO>> fetchKGZRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKGZRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KGZRY-all')")
	@ApiOperation(value = "search可挂职人员", tags = {"PimPerson" } ,notes = "search可挂职人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkgzry")
	public ResponseEntity<Page<PimPersonDTO>> searchKGZRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKGZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SELFHELPID-all')")
	@ApiOperation(value = "fetch员工自助登录人员ID", tags = {"PimPerson" } ,notes = "fetch员工自助登录人员ID")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchselfhelpid")
	public ResponseEntity<List<PimPersonDTO>> fetchSELFHELPID(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSELFHELPID(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SELFHELPID-all')")
	@ApiOperation(value = "search员工自助登录人员ID", tags = {"PimPerson" } ,notes = "search员工自助登录人员ID")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchselfhelpid")
	public ResponseEntity<Page<PimPersonDTO>> searchSELFHELPID(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSELFHELPID(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SYQYGCX-all')")
	@ApiOperation(value = "fetch试用期员工查询", tags = {"PimPerson" } ,notes = "fetch试用期员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsyqygcx")
	public ResponseEntity<List<PimPersonDTO>> fetchSYQYGCX(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSYQYGCX(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SYQYGCX-all')")
	@ApiOperation(value = "search试用期员工查询", tags = {"PimPerson" } ,notes = "search试用期员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsyqygcx")
	public ResponseEntity<Page<PimPersonDTO>> searchSYQYGCX(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSYQYGCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-LZRYHMC-all')")
	@ApiOperation(value = "fetch离职人员花名册", tags = {"PimPerson" } ,notes = "fetch离职人员花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchlzryhmc")
	public ResponseEntity<List<PimPersonDTO>> fetchLZRYHMC(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchLZRYHMC(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-LZRYHMC-all')")
	@ApiOperation(value = "search离职人员花名册", tags = {"PimPerson" } ,notes = "search离职人员花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchlzryhmc")
	public ResponseEntity<Page<PimPersonDTO>> searchLZRYHMC(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchLZRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TitleUse-all')")
	@ApiOperation(value = "fetch头衔专用", tags = {"PimPerson" } ,notes = "fetch头衔专用")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtitleuse")
	public ResponseEntity<List<PimPersonDTO>> fetchTitleUse(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTitleUse(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TitleUse-all')")
	@ApiOperation(value = "search头衔专用", tags = {"PimPerson" } ,notes = "search头衔专用")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtitleuse")
	public ResponseEntity<Page<PimPersonDTO>> searchTitleUse(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTitleUse(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JXQYGCX-all')")
	@ApiOperation(value = "fetch见习期员工查询", tags = {"PimPerson" } ,notes = "fetch见习期员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjxqygcx")
	public ResponseEntity<List<PimPersonDTO>> fetchJXQYGCX(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJXQYGCX(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JXQYGCX-all')")
	@ApiOperation(value = "search见习期员工查询", tags = {"PimPerson" } ,notes = "search见习期员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjxqygcx")
	public ResponseEntity<Page<PimPersonDTO>> searchJXQYGCX(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJXQYGCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-YXZFPRYDS-all')")
	@ApiOperation(value = "fetch存在有效分配的主分配的人员", tags = {"PimPerson" } ,notes = "fetch存在有效分配的主分配的人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchyxzfpryds")
	public ResponseEntity<List<PimPersonDTO>> fetchYXZFPRYDS(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchYXZFPRYDS(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-YXZFPRYDS-all')")
	@ApiOperation(value = "search存在有效分配的主分配的人员", tags = {"PimPerson" } ,notes = "search存在有效分配的主分配的人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchyxzfpryds")
	public ResponseEntity<Page<PimPersonDTO>> searchYXZFPRYDS(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchYXZFPRYDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-RYZT_30-all')")
	@ApiOperation(value = "fetch在职人员", tags = {"PimPerson" } ,notes = "fetch在职人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchryzt_30")
	public ResponseEntity<List<PimPersonDTO>> fetchRYZT_30(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchRYZT_30(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-RYZT_30-all')")
	@ApiOperation(value = "search在职人员", tags = {"PimPerson" } ,notes = "search在职人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchryzt_30")
	public ResponseEntity<Page<PimPersonDTO>> searchRYZT_30(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchRYZT_30(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-DTXYG-all')")
	@ApiOperation(value = "fetch待退休人员", tags = {"PimPerson" } ,notes = "fetch待退休人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchdtxyg")
	public ResponseEntity<List<PimPersonDTO>> fetchDTXYG(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchDTXYG(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-DTXYG-all')")
	@ApiOperation(value = "search待退休人员", tags = {"PimPerson" } ,notes = "search待退休人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchdtxyg")
	public ResponseEntity<Page<PimPersonDTO>> searchDTXYG(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchDTXYG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-XZKQRY-all')")
	@ApiOperation(value = "fetch新增考勤人员（考勤设置）", tags = {"PimPerson" } ,notes = "fetch新增考勤人员（考勤设置）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchxzkqry")
	public ResponseEntity<List<PimPersonDTO>> fetchXZKQRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchXZKQRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-XZKQRY-all')")
	@ApiOperation(value = "search新增考勤人员（考勤设置）", tags = {"PimPerson" } ,notes = "search新增考勤人员（考勤设置）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchxzkqry")
	public ResponseEntity<Page<PimPersonDTO>> searchXZKQRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchXZKQRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-REP_PERSONAGE-all')")
	@ApiOperation(value = "fetch年龄分布", tags = {"PimPerson" } ,notes = "fetch年龄分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchrep_personage")
	public ResponseEntity<List<HashMap>> fetchREP_PERSONAGE(PimPersonSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONAGE(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-REP_PERSONAGE-all')")
	@ApiOperation(value = "search年龄分布", tags = {"PimPerson" } ,notes = "search年龄分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchrep_personage")
	public ResponseEntity<Page<HashMap>> searchREP_PERSONAGE(@RequestBody PimPersonSearchContext context) {
        Page<HashMap> domains = pimpersonService.searchREP_PERSONAGE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SYQKZZRY-all')")
	@ApiOperation(value = "fetch试用期可转正人员", tags = {"PimPerson" } ,notes = "fetch试用期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchsyqkzzry")
	public ResponseEntity<List<PimPersonDTO>> fetchSYQKZZRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSYQKZZRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-SYQKZZRY-all')")
	@ApiOperation(value = "search试用期可转正人员", tags = {"PimPerson" } ,notes = "search试用期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchsyqkzzry")
	public ResponseEntity<Page<PimPersonDTO>> searchSYQKZZRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchSYQKZZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JXQKZZRY-all')")
	@ApiOperation(value = "fetch见习期可转正人员", tags = {"PimPerson" } ,notes = "fetch见习期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchjxqkzzry")
	public ResponseEntity<List<PimPersonDTO>> fetchJXQKZZRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJXQKZZRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-JXQKZZRY-all')")
	@ApiOperation(value = "search见习期可转正人员", tags = {"PimPerson" } ,notes = "search见习期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchjxqkzzry")
	public ResponseEntity<Page<PimPersonDTO>> searchJXQKZZRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchJXQKZZRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TXGB-all')")
	@ApiOperation(value = "fetch退休干部", tags = {"PimPerson" } ,notes = "fetch退休干部")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtxgb")
	public ResponseEntity<List<PimPersonDTO>> fetchTXGB(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTXGB(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TXGB-all')")
	@ApiOperation(value = "search退休干部", tags = {"PimPerson" } ,notes = "search退休干部")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtxgb")
	public ResponseEntity<Page<PimPersonDTO>> searchTXGB(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTXGB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KZJBDRY-all')")
	@ApiOperation(value = "fetch可进行职级变动的人员", tags = {"PimPerson" } ,notes = "fetch可进行职级变动的人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkzjbdry")
	public ResponseEntity<List<PimPersonDTO>> fetchKZJBDRY(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKZJBDRY(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KZJBDRY-all')")
	@ApiOperation(value = "search可进行职级变动的人员", tags = {"PimPerson" } ,notes = "search可进行职级变动的人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkzjbdry")
	public ResponseEntity<Page<PimPersonDTO>> searchKZJBDRY(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKZJBDRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurOrgPimperson-all')")
	@ApiOperation(value = "fetch当前组织下人员", tags = {"PimPerson" } ,notes = "fetch当前组织下人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchcurorgpimperson")
	public ResponseEntity<List<PimPersonDTO>> fetchCurOrgPimperson(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurOrgPimperson(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-CurOrgPimperson-all')")
	@ApiOperation(value = "search当前组织下人员", tags = {"PimPerson" } ,notes = "search当前组织下人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchcurorgpimperson")
	public ResponseEntity<Page<PimPersonDTO>> searchCurOrgPimperson(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchCurOrgPimperson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TXRYCX-all')")
	@ApiOperation(value = "fetch退休员工查询", tags = {"PimPerson" } ,notes = "fetch退休员工查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchtxrycx")
	public ResponseEntity<List<PimPersonDTO>> fetchTXRYCX(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTXRYCX(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-TXRYCX-all')")
	@ApiOperation(value = "search退休员工查询", tags = {"PimPerson" } ,notes = "search退休员工查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchtxrycx")
	public ResponseEntity<Page<PimPersonDTO>> searchTXRYCX(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchTXRYCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KXZSYQKZZRYDS-all')")
	@ApiOperation(value = "fetch申请单可选择试用期可转正人员", tags = {"PimPerson" } ,notes = "fetch申请单可选择试用期可转正人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/fetchkxzsyqkzzryds")
	public ResponseEntity<List<PimPersonDTO>> fetchKXZSYQKZZRYDS(PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKXZSYQKZZRYDS(context) ;
        List<PimPersonDTO> list = pimpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPerson-KXZSYQKZZRYDS-all')")
	@ApiOperation(value = "search申请单可选择试用期可转正人员", tags = {"PimPerson" } ,notes = "search申请单可选择试用期可转正人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/searchkxzsyqkzzryds")
	public ResponseEntity<Page<PimPersonDTO>> searchKXZSYQKZZRYDS(@RequestBody PimPersonSearchContext context) {
        Page<PimPerson> domains = pimpersonService.searchKXZSYQKZZRYDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

