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
import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
import cn.ibizlab.ehr.core.pim.service.IPimFaminfoService;
import cn.ibizlab.ehr.core.pim.filter.PimFaminfoSearchContext;

@Slf4j
@Api(tags = {"家庭情况" })
@RestController("WebApi-pimfaminfo")
@RequestMapping("")
public class PimFaminfoResource {

    @Autowired
    public IPimFaminfoService pimfaminfoService;

    @Autowired
    @Lazy
    public PimFaminfoMapping pimfaminfoMapping;

    @ApiOperation(value = "检查家庭情况", tags = {"家庭情况" },  notes = "检查家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimFaminfoDTO pimfaminfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.checkKey(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-UpdateInfo-all')")
    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"家庭情况" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}/updateinfo")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> updateInfo(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo pimfaminfo = pimfaminfoMapping.toDomain(pimfaminfodto);
        pimfaminfo.setPimfaminfoid(pimfaminfo_id);
        pimfaminfo = pimfaminfoService.updateInfo(pimfaminfo);
        pimfaminfodto = pimfaminfoMapping.toDto(pimfaminfo);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-UpdateContact-all')")
    @ApiOperation(value = "更新紧急联络人", tags = {"家庭情况" },  notes = "更新紧急联络人")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}/updatecontact")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> updateContact(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo pimfaminfo = pimfaminfoMapping.toDomain(pimfaminfodto);
        pimfaminfo.setPimfaminfoid(pimfaminfo_id);
        pimfaminfo = pimfaminfoService.updateContact(pimfaminfo);
        pimfaminfodto = pimfaminfoMapping.toDto(pimfaminfo);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodto),'ehr-PimFaminfo-Create')")
    @ApiOperation(value = "新建家庭情况", tags = {"家庭情况" },  notes = "新建家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> create(@RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
		pimfaminfoService.create(domain);
        PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodtos),'ehr-PimFaminfo-Create')")
    @ApiOperation(value = "批量新建家庭情况", tags = {"家庭情况" },  notes = "批量新建家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        pimfaminfoService.createBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.get(#pimfaminfo_id),'ehr-PimFaminfo-Update')")
    @ApiOperation(value = "更新家庭情况", tags = {"家庭情况" },  notes = "更新家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> update(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
		PimFaminfo domain  = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain .setPimfaminfoid(pimfaminfo_id);
		pimfaminfoService.update(domain );
		PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.getPimfaminfoByEntities(this.pimfaminfoMapping.toDomain(#pimfaminfodtos)),'ehr-PimFaminfo-Update')")
    @ApiOperation(value = "批量更新家庭情况", tags = {"家庭情况" },  notes = "批量更新家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        pimfaminfoService.updateBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取家庭情况草稿", tags = {"家庭情况" },  notes = "获取家庭情况草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfaminfos/getdraft")
    public ResponseEntity<PimFaminfoDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoMapping.toDto(pimfaminfoService.getDraft(new PimFaminfo())));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.get(#pimfaminfo_id),'ehr-PimFaminfo-Remove')")
    @ApiOperation(value = "删除家庭情况", tags = {"家庭情况" },  notes = "删除家庭情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimfaminfo_id") String pimfaminfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.remove(pimfaminfo_id));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.getPimfaminfoByIds(#ids),'ehr-PimFaminfo-Remove')")
    @ApiOperation(value = "批量删除家庭情况", tags = {"家庭情况" },  notes = "批量删除家庭情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimfaminfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodto),'ehr-PimFaminfo-Save')")
    @ApiOperation(value = "保存家庭情况", tags = {"家庭情况" },  notes = "保存家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/save")
    public ResponseEntity<Boolean> save(@RequestBody PimFaminfoDTO pimfaminfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.save(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodtos),'ehr-PimFaminfo-Save')")
    @ApiOperation(value = "批量保存家庭情况", tags = {"家庭情况" },  notes = "批量保存家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        pimfaminfoService.saveBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(returnObject.body),'ehr-PimFaminfo-Get')")
    @ApiOperation(value = "获取家庭情况", tags = {"家庭情况" },  notes = "获取家庭情况")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfaminfos/{pimfaminfo_id}")
    public ResponseEntity<PimFaminfoDTO> get(@PathVariable("pimfaminfo_id") String pimfaminfo_id) {
        PimFaminfo domain = pimfaminfoService.get(pimfaminfo_id);
        PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"家庭情况" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlssgr")
	public ResponseEntity<List<PimFaminfoDTO>> fetchJLSSGR(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGR(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"家庭情况" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlssgr")
	public ResponseEntity<Page<PimFaminfoDTO>> searchJLSSGR(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JTLXR-all')")
	@ApiOperation(value = "获取查询该人员的家庭联系人", tags = {"家庭情况" } ,notes = "获取查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjtlxr")
	public ResponseEntity<List<PimFaminfoDTO>> fetchJTLXR(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJTLXR(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JTLXR-all')")
	@ApiOperation(value = "查询查询该人员的家庭联系人", tags = {"家庭情况" } ,notes = "查询查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjtlxr")
	public ResponseEntity<Page<PimFaminfoDTO>> searchJTLXR(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJTLXR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"家庭情况" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchdefault")
	public ResponseEntity<List<PimFaminfoDTO>> fetchDefault(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchDefault(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"家庭情况" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchdefault")
	public ResponseEntity<Page<PimFaminfoDTO>> searchDefault(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"家庭情况" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlssgly")
	public ResponseEntity<List<PimFaminfoDTO>> fetchJLSSGLY(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGLY(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"家庭情况" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlssgly")
	public ResponseEntity<Page<PimFaminfoDTO>> searchJLSSGLY(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-FAZZSY-all')")
	@ApiOperation(value = "获取非A类员工转正使用", tags = {"家庭情况" } ,notes = "获取非A类员工转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchfazzsy")
	public ResponseEntity<List<PimFaminfoDTO>> fetchFAZZSY(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchFAZZSY(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-FAZZSY-all')")
	@ApiOperation(value = "查询非A类员工转正使用", tags = {"家庭情况" } ,notes = "查询非A类员工转正使用")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchfazzsy")
	public ResponseEntity<Page<PimFaminfoDTO>> searchFAZZSY(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-ZIZHU-all')")
	@ApiOperation(value = "获取自助(家庭情况)", tags = {"家庭情况" } ,notes = "获取自助(家庭情况)")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchzizhu")
	public ResponseEntity<List<PimFaminfoDTO>> fetchZIZHU(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchZIZHU(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-ZIZHU-all')")
	@ApiOperation(value = "查询自助(家庭情况)", tags = {"家庭情况" } ,notes = "查询自助(家庭情况)")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchzizhu")
	public ResponseEntity<Page<PimFaminfoDTO>> searchZIZHU(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSS-all')")
	@ApiOperation(value = "获取记录所属", tags = {"家庭情况" } ,notes = "获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlss")
	public ResponseEntity<List<PimFaminfoDTO>> fetchJLSS(PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSS(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSS-all')")
	@ApiOperation(value = "查询记录所属", tags = {"家庭情况" } ,notes = "查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlss")
	public ResponseEntity<Page<PimFaminfoDTO>> searchJLSS(@RequestBody PimFaminfoSearchContext context) {
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息检查家庭情况", tags = {"家庭情况" },  notes = "根据人员信息检查家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.checkKey(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-UpdateInfo-all')")
    @ApiOperation(value = "根据人员信息家庭情况", tags = {"家庭情况" },  notes = "根据人员信息家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}/updateinfo")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> updateInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain = pimfaminfoService.updateInfo(domain) ;
        pimfaminfodto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-UpdateContact-all')")
    @ApiOperation(value = "根据人员信息家庭情况", tags = {"家庭情况" },  notes = "根据人员信息家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}/updatecontact")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> updateContactByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain = pimfaminfoService.updateContact(domain) ;
        pimfaminfodto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodto),'ehr-PimFaminfo-Create')")
    @ApiOperation(value = "根据人员信息建立家庭情况", tags = {"家庭情况" },  notes = "根据人员信息建立家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
		pimfaminfoService.create(domain);
        PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodtos),'ehr-PimFaminfo-Create')")
    @ApiOperation(value = "根据人员信息批量建立家庭情况", tags = {"家庭情况" },  notes = "根据人员信息批量建立家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        List<PimFaminfo> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PimFaminfo domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.get(#pimfaminfo_id),'ehr-PimFaminfo-Update')")
    @ApiOperation(value = "根据人员信息更新家庭情况", tags = {"家庭情况" },  notes = "根据人员信息更新家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<PimFaminfoDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimfaminfoid(pimfaminfo_id);
		pimfaminfoService.update(domain);
        PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.getPimfaminfoByEntities(this.pimfaminfoMapping.toDomain(#pimfaminfodtos)),'ehr-PimFaminfo-Update')")
    @ApiOperation(value = "根据人员信息批量更新家庭情况", tags = {"家庭情况" },  notes = "根据人员信息批量更新家庭情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        List<PimFaminfo> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PimFaminfo domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取家庭情况草稿", tags = {"家庭情况" },  notes = "根据人员信息获取家庭情况草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimfaminfos/getdraft")
    public ResponseEntity<PimFaminfoDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimFaminfo domain = new PimFaminfo();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoMapping.toDto(pimfaminfoService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.get(#pimfaminfo_id),'ehr-PimFaminfo-Remove')")
    @ApiOperation(value = "根据人员信息删除家庭情况", tags = {"家庭情况" },  notes = "根据人员信息删除家庭情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.remove(pimfaminfo_id));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoService.getPimfaminfoByIds(#ids),'ehr-PimFaminfo-Remove')")
    @ApiOperation(value = "根据人员信息批量删除家庭情况", tags = {"家庭情况" },  notes = "根据人员信息批量删除家庭情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimfaminfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodto),'ehr-PimFaminfo-Save')")
    @ApiOperation(value = "根据人员信息保存家庭情况", tags = {"家庭情况" },  notes = "根据人员信息保存家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoDTO pimfaminfodto) {
        PimFaminfo domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(#pimfaminfodtos),'ehr-PimFaminfo-Save')")
    @ApiOperation(value = "根据人员信息批量保存家庭情况", tags = {"家庭情况" },  notes = "根据人员信息批量保存家庭情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimFaminfoDTO> pimfaminfodtos) {
        List<PimFaminfo> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PimFaminfo domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimfaminfoMapping.toDomain(returnObject.body),'ehr-PimFaminfo-Get')")
    @ApiOperation(value = "根据人员信息获取家庭情况", tags = {"家庭情况" },  notes = "根据人员信息获取家庭情况")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    public ResponseEntity<PimFaminfoDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id) {
        PimFaminfo domain = pimfaminfoService.get(pimfaminfo_id);
        PimFaminfoDTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"家庭情况" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlssgr")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGR(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"家庭情况" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlssgr")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JTLXR-all')")
	@ApiOperation(value = "根据人员信息获取查询该人员的家庭联系人", tags = {"家庭情况" } ,notes = "根据人员信息获取查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjtlxr")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoJTLXRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJTLXR(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JTLXR-all')")
	@ApiOperation(value = "根据人员信息查询查询该人员的家庭联系人", tags = {"家庭情况" } ,notes = "根据人员信息查询查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjtlxr")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoJTLXRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJTLXR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"家庭情况" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchdefault")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchDefault(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"家庭情况" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchdefault")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"家庭情况" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlssgly")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGLY(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"家庭情况" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlssgly")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-FAZZSY-all')")
	@ApiOperation(value = "根据人员信息获取非A类员工转正使用", tags = {"家庭情况" } ,notes = "根据人员信息获取非A类员工转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchfazzsy")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchFAZZSY(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-FAZZSY-all')")
	@ApiOperation(value = "根据人员信息查询非A类员工转正使用", tags = {"家庭情况" } ,notes = "根据人员信息查询非A类员工转正使用")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchfazzsy")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(家庭情况)", tags = {"家庭情况" } ,notes = "根据人员信息获取自助(家庭情况)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchzizhu")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchZIZHU(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(家庭情况)", tags = {"家庭情况" } ,notes = "根据人员信息查询自助(家庭情况)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchzizhu")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属", tags = {"家庭情况" } ,notes = "根据人员信息获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlss")
	public ResponseEntity<List<PimFaminfoDTO>> fetchPimFaminfoJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSS(context) ;
        List<PimFaminfoDTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFaminfo-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属", tags = {"家庭情况" } ,notes = "根据人员信息查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlss")
	public ResponseEntity<Page<PimFaminfoDTO>> searchPimFaminfoJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimFaminfoSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimFaminfo> domains = pimfaminfoService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

