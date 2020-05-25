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
import cn.ibizlab.ehr.core.pim.domain.PIMPATENT;
import cn.ibizlab.ehr.core.pim.service.IPIMPATENTService;
import cn.ibizlab.ehr.core.pim.filter.PIMPATENTSearchContext;

@Slf4j
@Api(tags = {"PIMPATENT" })
@RestController("WebApi-pimpatent")
@RequestMapping("")
public class PIMPATENTResource {

    @Autowired
    private IPIMPATENTService pimpatentService;

    @Autowired
    @Lazy
    public PIMPATENTMapping pimpatentMapping;

    public PIMPATENTDTO permissionDTO=new PIMPATENTDTO();

    @PreAuthorize("hasPermission(#pimpatent_id,'Get',{'Sql',this.pimpatentMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMPATENT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/{pimpatent_id}")
    public ResponseEntity<PIMPATENTDTO> get(@PathVariable("pimpatent_id") String pimpatent_id) {
        PIMPATENT domain = pimpatentService.get(pimpatent_id);
        PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMPATENT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/getdraft")
    public ResponseEntity<PIMPATENTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(new PIMPATENT())));
    }

    @PreAuthorize("hasPermission(#pimpatent_id,'Update',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "Update", tags = {"PIMPATENT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PIMPATENTDTO> update(@PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PIMPATENTDTO pimpatentdto) {
		PIMPATENT domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpatentid(pimpatent_id);
		pimpatentService.update(domain);
		PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPATENT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        pimpatentService.updateBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "Create", tags = {"PIMPATENT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents")
    @Transactional
    public ResponseEntity<PIMPATENTDTO> create(@RequestBody PIMPATENTDTO pimpatentdto) {
        PIMPATENT domain = pimpatentMapping.toDomain(pimpatentdto);
		pimpatentService.create(domain);
        PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMPATENT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        pimpatentService.createBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "Save", tags = {"PIMPATENT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPATENTDTO pimpatentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPATENT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        pimpatentService.saveBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpatent_id,'Remove',{'Sql',this.pimpatentMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMPATENT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpatent_id") String pimpatent_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPATENT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMPATENT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPATENTDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMPATENT" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PIMPATENTDTO>> fetchJLSSGLY(PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMPATENT" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PIMPATENTDTO>> searchJLSSGLY(@RequestBody PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPATENT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchdefault")
	public ResponseEntity<List<PIMPATENTDTO>> fetchDefault(PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchDefault(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPATENT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchdefault")
	public ResponseEntity<Page<PIMPATENTDTO>> searchDefault(@RequestBody PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMPATENT" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PIMPATENTDTO>> fetchJLSSGR(PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGR(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMPATENT" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PIMPATENTDTO>> searchJLSSGR(@RequestBody PIMPATENTSearchContext context) {
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#pimpatent_id,'Get',{'Sql',this.pimpatentMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMPATENT" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    public ResponseEntity<PIMPATENTDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
        PIMPATENT domain = pimpatentService.get(pimpatent_id);
        PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMPATENT" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/getdraft")
    public ResponseEntity<PIMPATENTDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMPATENT domain = new PIMPATENT();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#pimpatent_id,'Update',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMPATENT" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PIMPATENTDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PIMPATENTDTO pimpatentdto) {
        PIMPATENT domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpatentid(pimpatent_id);
		pimpatentService.update(domain);
        PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMPATENT" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        List<PIMPATENT> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PIMPATENT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMPATENT" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents")
    @Transactional
    public ResponseEntity<PIMPATENTDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTDTO pimpatentdto) {
        PIMPATENT domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
		pimpatentService.create(domain);
        PIMPATENTDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMPATENT" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        List<PIMPATENT> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PIMPATENT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimpatentMapping,#pimpatentdto})")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMPATENT" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTDTO pimpatentdto) {
        PIMPATENT domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMPATENT" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPATENTDTO> pimpatentdtos) {
        List<PIMPATENT> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PIMPATENT domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpatent_id,'Remove',{'Sql',this.pimpatentMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMPATENT" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMPATENT" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMPATENT" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMPATENT" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PIMPATENTDTO>> fetchPIMPATENTJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMPATENT" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PIMPATENTDTO>> searchPIMPATENTJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMPATENT" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchdefault")
	public ResponseEntity<List<PIMPATENTDTO>> fetchPIMPATENTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchDefault(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMPATENT" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchdefault")
	public ResponseEntity<Page<PIMPATENTDTO>> searchPIMPATENTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMPATENT" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PIMPATENTDTO>> fetchPIMPATENTJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGR(context) ;
        List<PIMPATENTDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPATENT-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMPATENT" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PIMPATENTDTO>> searchPIMPATENTJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPATENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPATENT> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
