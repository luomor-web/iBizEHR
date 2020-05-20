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
import cn.ibizlab.ehr.core.pim.domain.PIMFAMINFO;
import cn.ibizlab.ehr.core.pim.service.IPIMFAMINFOService;
import cn.ibizlab.ehr.core.pim.filter.PIMFAMINFOSearchContext;




@Slf4j
@Api(tags = {"PIMFAMINFO" })
@RestController("WebApi-pimfaminfo")
@RequestMapping("")
public class PIMFAMINFOResource {

    @Autowired
    private IPIMFAMINFOService pimfaminfoService;

    @Autowired
    @Lazy
    private PIMFAMINFOMapping pimfaminfoMapping;




    @ApiOperation(value = "CheckKey", tags = {"PIMFAMINFO" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMFAMINFODTO pimfaminfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.checkKey(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }




    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"PIMFAMINFO" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}/updateinfo")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> updateInfo(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO pimfaminfo = pimfaminfoMapping.toDomain(pimfaminfodto);
        pimfaminfo = pimfaminfoService.updateInfo(pimfaminfo);
        pimfaminfodto = pimfaminfoMapping.toDto(pimfaminfo);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }




    @ApiOperation(value = "更新紧急联络人", tags = {"PIMFAMINFO" },  notes = "更新紧急联络人")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}/updatecontact")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> updateContact(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO pimfaminfo = pimfaminfoMapping.toDomain(pimfaminfodto);
        pimfaminfo = pimfaminfoService.updateContact(pimfaminfo);
        pimfaminfodto = pimfaminfoMapping.toDto(pimfaminfo);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMFAMINFO" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> create(@RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
		pimfaminfoService.create(domain);
        PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMFAMINFO" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        pimfaminfoService.createBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimfaminfo_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMFAMINFO" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> update(@PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
		PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimfaminfoid(pimfaminfo_id);
		pimfaminfoService.update(domain);
		PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimfaminfo_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMFAMINFO" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        pimfaminfoService.updateBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMFAMINFO" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfaminfos/getdraft")
    public ResponseEntity<PIMFAMINFODTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoMapping.toDto(pimfaminfoService.getDraft(new PIMFAMINFO())));
    }




    @PreAuthorize("hasPermission('Remove',{#pimfaminfo_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMFAMINFO" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimfaminfo_id") String pimfaminfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.remove(pimfaminfo_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMFAMINFO" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfaminfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimfaminfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMFAMINFO" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMFAMINFODTO pimfaminfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.save(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMFAMINFO" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfaminfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        pimfaminfoService.saveBatch(pimfaminfoMapping.toDomain(pimfaminfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimfaminfo_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMFAMINFO" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfaminfos/{pimfaminfo_id}")
    public ResponseEntity<PIMFAMINFODTO> get(@PathVariable("pimfaminfo_id") String pimfaminfo_id) {
        PIMFAMINFO domain = pimfaminfoService.get(pimfaminfo_id);
        PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlssgr")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchJLSSGR(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGR(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMFAMINFO" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlssgr")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchJLSSGR(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch查询该人员的家庭联系人", tags = {"PIMFAMINFO" } ,notes = "fetch查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjtlxr")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchJTLXR(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJTLXR(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search查询该人员的家庭联系人", tags = {"PIMFAMINFO" } ,notes = "search查询该人员的家庭联系人")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjtlxr")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchJTLXR(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJTLXR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMFAMINFO" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchdefault")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchDefault(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchDefault(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMFAMINFO" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchdefault")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchDefault(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlssgly")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchJLSSGLY(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGLY(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMFAMINFO" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlssgly")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchJLSSGLY(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch非A类员工转正使用", tags = {"PIMFAMINFO" } ,notes = "fetch非A类员工转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchfazzsy")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchFAZZSY(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchFAZZSY(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search非A类员工转正使用", tags = {"PIMFAMINFO" } ,notes = "search非A类员工转正使用")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchfazzsy")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchFAZZSY(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(家庭情况)", tags = {"PIMFAMINFO" } ,notes = "fetch自助(家庭情况)")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchzizhu")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchZIZHU(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchZIZHU(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(家庭情况)", tags = {"PIMFAMINFO" } ,notes = "search自助(家庭情况)")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchzizhu")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchZIZHU(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimfaminfos/fetchjlss")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchJLSS(PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSS(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属", tags = {"PIMFAMINFO" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimfaminfos/searchjlss")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchJLSS(@RequestBody PIMFAMINFOSearchContext context) {
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.checkKey(pimfaminfoMapping.toDomain(pimfaminfodto)));
    }

    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄ByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "根据证件号更改出生日期、性别、年龄ByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfopimfaminfoid}/updateinfo")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> updateInfoByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain = pimfaminfoService.updateInfo(domain) ;
        pimfaminfodto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @ApiOperation(value = "更新紧急联络人ByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "更新紧急联络人ByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfopimfaminfoid}/updatecontact")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> updateContactByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain = pimfaminfoService.updateContact(domain) ;
        pimfaminfodto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfodto);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
		pimfaminfoService.create(domain);
        PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        List<PIMFAMINFO> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PIMFAMINFO domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<PIMFAMINFODTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimfaminfoid(pimfaminfo_id);
		pimfaminfoService.update(domain);
        PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        List<PIMFAMINFO> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PIMFAMINFO domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimfaminfos/getdraft")
    public ResponseEntity<PIMFAMINFODTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMFAMINFO domain = new PIMFAMINFO();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoMapping.toDto(pimfaminfoService.getDraft(domain)));
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.remove(pimfaminfo_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimfaminfos/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimfaminfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFODTO pimfaminfodto) {
        PIMFAMINFO domain = pimfaminfoMapping.toDomain(pimfaminfodto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimfaminfoService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimfaminfos/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMFAMINFODTO> pimfaminfodtos) {
        List<PIMFAMINFO> domainlist=pimfaminfoMapping.toDomain(pimfaminfodtos);
        for(PIMFAMINFO domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimfaminfoService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMFAMINFO" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimfaminfos/{pimfaminfo_id}")
    public ResponseEntity<PIMFAMINFODTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimfaminfo_id") String pimfaminfo_id) {
        PIMFAMINFO domain = pimfaminfoService.get(pimfaminfo_id);
        PIMFAMINFODTO dto = pimfaminfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlssgr")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGR(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlssgr")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch查询该人员的家庭联系人ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch查询该人员的家庭联系人ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjtlxr")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOJTLXRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJTLXR(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search查询该人员的家庭联系人ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search查询该人员的家庭联系人ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjtlxr")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOJTLXRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJTLXR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchdefault")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFODefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchDefault(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchdefault")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFODefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlssgly")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGLY(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlssgly")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch非A类员工转正使用ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch非A类员工转正使用ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchfazzsy")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchFAZZSY(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search非A类员工转正使用ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search非A类员工转正使用ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchfazzsy")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(家庭情况)ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch自助(家庭情况)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchzizhu")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchZIZHU(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(家庭情况)ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search自助(家庭情况)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchzizhu")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "fetch记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimfaminfos/fetchjlss")
	public ResponseEntity<List<PIMFAMINFODTO>> fetchPIMFAMINFOJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSS(context) ;
        List<PIMFAMINFODTO> list = pimfaminfoMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属ByPIMPERSON", tags = {"PIMFAMINFO" } ,notes = "search记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimfaminfos/searchjlss")
	public ResponseEntity<Page<PIMFAMINFODTO>> searchPIMFAMINFOJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMFAMINFOSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMFAMINFO> domains = pimfaminfoService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfaminfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMFAMINFO getEntity(){
        return new PIMFAMINFO();
    }

}
