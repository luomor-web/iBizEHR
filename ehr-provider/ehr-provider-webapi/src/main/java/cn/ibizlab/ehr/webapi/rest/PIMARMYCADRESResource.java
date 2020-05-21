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
import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
import cn.ibizlab.ehr.core.pim.service.IPIMARMYCADRESService;
import cn.ibizlab.ehr.core.pim.filter.PIMARMYCADRESSearchContext;




@Slf4j
@Api(tags = {"PIMARMYCADRES" })
@RestController("WebApi-pimarmycadres")
@RequestMapping("")
public class PIMARMYCADRESResource {

    @Autowired
    private IPIMARMYCADRESService pimarmycadresService;

    @Autowired
    @Lazy
    public PIMARMYCADRESMapping pimarmycadresMapping;

    public PIMARMYCADRESDTO permissionDTO=new PIMARMYCADRESDTO();




    @PreAuthorize("hasPermission(#pimarmycadres_id,'Remove',{'Sql',this.pimarmycadresMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMARMYCADRES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMARMYCADRES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMARMYCADRES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/getdraft")
    public ResponseEntity<PIMARMYCADRESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(new PIMARMYCADRES())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMARMYCADRES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarmycadresMapping,#pimarmycadresdto})")
    @ApiOperation(value = "Create", tags = {"PIMARMYCADRES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> create(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
		pimarmycadresService.create(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PIMARMYCADRES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.createBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimarmycadres_id,'Update',{'Sql',this.pimarmycadresMapping,#pimarmycadresdto})")
    @ApiOperation(value = "Update", tags = {"PIMARMYCADRES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> update(@PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
		PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain);
		PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PIMARMYCADRES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.updateBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimarmycadres_id,'Get',{'Sql',this.pimarmycadresMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMARMYCADRES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PIMARMYCADRESDTO> get(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PIMARMYCADRES domain = pimarmycadresService.get(pimarmycadres_id);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMARMYCADRES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMARMYCADRES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.saveBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMARMYCADRES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchDefault(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMARMYCADRES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchDefault(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMARMYCADRES" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchJLSSGLY(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMARMYCADRES" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchJLSSGLY(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMARMYCADRES" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchJLSSGR(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMARMYCADRES" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchJLSSGR(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    //@PreAuthorize("hasPermission(#pimarmycadres_id,'Remove',{'Sql',this.pimarmycadresMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/getdraft")
    public ResponseEntity<PIMARMYCADRESDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMARMYCADRES domain = new PIMARMYCADRES();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(domain)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimarmycadresMapping,#pimarmycadresdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
		pimarmycadresService.create(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimarmycadres_id,'Update',{'Sql',this.pimarmycadresMapping,#pimarmycadresdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimarmycadres_id,'Get',{'Sql',this.pimarmycadresMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PIMARMYCADRESDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PIMARMYCADRES domain = pimarmycadresService.get(pimarmycadres_id);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMARMYCADRES" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMARMYCADRES" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


