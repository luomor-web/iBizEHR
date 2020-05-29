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
import cn.ibizlab.ehr.core.pim.domain.PimPatent;
import cn.ibizlab.ehr.core.pim.service.IPimPatentService;
import cn.ibizlab.ehr.core.pim.filter.PimPatentSearchContext;

@Slf4j
@Api(tags = {"PimPatent" })
@RestController("WebApi-pimpatent")
@RequestMapping("")
public class PimPatentResource {

    @Autowired
    public IPimPatentService pimpatentService;

    @Autowired
    @Lazy
    public PimPatentMapping pimpatentMapping;

    @PostAuthorize("hasPermission(this.pimpatentMapping.toDomain(returnObject.body),'ehr-PimPatent-Get')")
    @ApiOperation(value = "Get", tags = {"PimPatent" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/{pimpatent_id}")
    public ResponseEntity<PimPatentDTO> get(@PathVariable("pimpatent_id") String pimpatent_id) {
        PimPatent domain = pimpatentService.get(pimpatent_id);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimPatent" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/getdraft")
    public ResponseEntity<PimPatentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(new PimPatent())));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Update')")
    @ApiOperation(value = "Update", tags = {"PimPatent" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PimPatentDTO> update(@PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PimPatentDTO pimpatentdto) {
		PimPatent domain  = pimpatentMapping.toDomain(pimpatentdto);
        domain .setPimpatentid(pimpatent_id);
		pimpatentService.update(domain );
		PimPatentDTO dto = pimpatentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByEntities(this.pimpatentMapping.toDomain(#pimpatentdtos)),'ehr-PimPatent-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimPatent" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.updateBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Create')")
    @ApiOperation(value = "Create", tags = {"PimPatent" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents")
    @Transactional
    public ResponseEntity<PimPatentDTO> create(@RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
		pimpatentService.create(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimPatent" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.createBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Save')")
    @ApiOperation(value = "Save", tags = {"PimPatent" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPatentDTO pimpatentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimPatent" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.saveBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimPatent" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpatent_id") String pimpatent_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByIds(#ids),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimPatent" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimPatent" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPatentDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PimPatent" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PimPatentDTO>> fetchJLSSGLY(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PimPatent" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PimPatentDTO>> searchJLSSGLY(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimPatent" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchdefault")
	public ResponseEntity<List<PimPatentDTO>> fetchDefault(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimPatent" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchdefault")
	public ResponseEntity<Page<PimPatentDTO>> searchDefault(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PimPatent" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PimPatentDTO>> fetchJLSSGR(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PimPatent" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PimPatentDTO>> searchJLSSGR(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimpatentMapping.toDomain(returnObject.body),'ehr-PimPatent-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PimPatent" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    public ResponseEntity<PimPatentDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
        PimPatent domain = pimpatentService.get(pimpatent_id);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PimPatent" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/getdraft")
    public ResponseEntity<PimPatentDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PimPatent domain = new PimPatent();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PimPatent" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PimPatentDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpatentid(pimpatent_id);
		pimpatentService.update(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByEntities(this.pimpatentMapping.toDomain(#pimpatentdtos)),'ehr-PimPatent-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PimPatent" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PimPatent" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents")
    @Transactional
    public ResponseEntity<PimPatentDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
		pimpatentService.create(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PimPatent" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PimPatent" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PimPatent" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PimPatent" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByIds(#ids),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PimPatent" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PimPatent" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PimPatent" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PimPatent" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PimPatent" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchdefault")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PimPatent" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchdefault")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PimPatent" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PimPatent" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

