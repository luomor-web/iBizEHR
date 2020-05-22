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
import cn.ibizlab.ehr.core.common.domain.OrgSector;
import cn.ibizlab.ehr.core.common.service.IOrgSectorService;
import cn.ibizlab.ehr.core.common.filter.OrgSectorSearchContext;




@Slf4j
@Api(tags = {"OrgSector" })
@RestController("WebApi-orgsector")
@RequestMapping("")
public class OrgSectorResource {

    @Autowired
    private IOrgSectorService orgsectorService;

    @Autowired
    @Lazy
    public OrgSectorMapping orgsectorMapping;

    public OrgSectorDTO permissionDTO=new OrgSectorDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.orgsectorMapping,#orgsectordto})")
    @ApiOperation(value = "Create", tags = {"OrgSector" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors")
    @Transactional
    public ResponseEntity<OrgSectorDTO> create(@RequestBody OrgSectorDTO orgsectordto) {
        OrgSector domain = orgsectorMapping.toDomain(orgsectordto);
		orgsectorService.create(domain);
        OrgSectorDTO dto = orgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"OrgSector" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgSectorDTO> orgsectordtos) {
        orgsectorService.createBatch(orgsectorMapping.toDomain(orgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgSector" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgSectorDTO orgsectordto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgsectorService.save(orgsectorMapping.toDomain(orgsectordto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"OrgSector" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgSectorDTO> orgsectordtos) {
        orgsectorService.saveBatch(orgsectorMapping.toDomain(orgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#orgsector_id,'Get',{'Sql',this.orgsectorMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgSector" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsectors/{orgsector_id}")
    public ResponseEntity<OrgSectorDTO> get(@PathVariable("orgsector_id") String orgsector_id) {
        OrgSector domain = orgsectorService.get(orgsector_id);
        OrgSectorDTO dto = orgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-InitUserObject-all')")
    @ApiOperation(value = "初始化用户对象", tags = {"OrgSector" },  notes = "初始化用户对象")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors/{orgsector_id}/inituserobject")
    @Transactional
    public ResponseEntity<OrgSectorDTO> initUserObject(@PathVariable("orgsector_id") String orgsector_id, @RequestBody OrgSectorDTO orgsectordto) {
        OrgSector orgsector = orgsectorMapping.toDomain(orgsectordto);
        orgsector = orgsectorService.initUserObject(orgsector);
        orgsectordto = orgsectorMapping.toDto(orgsector);
        return ResponseEntity.status(HttpStatus.OK).body(orgsectordto);
    }

    @PreAuthorize("hasPermission(#orgsector_id,'Update',{'Sql',this.orgsectorMapping,#orgsectordto})")
    @ApiOperation(value = "Update", tags = {"OrgSector" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsectors/{orgsector_id}")
    @Transactional
    public ResponseEntity<OrgSectorDTO> update(@PathVariable("orgsector_id") String orgsector_id, @RequestBody OrgSectorDTO orgsectordto) {
		OrgSector domain = orgsectorMapping.toDomain(orgsectordto);
        domain.setOrgsectorid(orgsector_id);
		orgsectorService.update(domain);
		OrgSectorDTO dto = orgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"OrgSector" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsectors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgSectorDTO> orgsectordtos) {
        orgsectorService.updateBatch(orgsectorMapping.toDomain(orgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#orgsector_id,'Remove',{'Sql',this.orgsectorMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgSector" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsectors/{orgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orgsector_id") String orgsector_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgsectorService.remove(orgsector_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"OrgSector" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsectors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgSector" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsectors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgSectorDTO orgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgsectorService.checkKey(orgsectorMapping.toDomain(orgsectordto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgSector" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsectors/getdraft")
    public ResponseEntity<OrgSectorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgsectorMapping.toDto(orgsectorService.getDraft(new OrgSector())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurChild-all')")
	@ApiOperation(value = "fetch当前部门子部门", tags = {"OrgSector" } ,notes = "fetch当前部门子部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchcurchild")
	public ResponseEntity<List<OrgSectorDTO>> fetchCurChild(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurChild(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurChild-all')")
	@ApiOperation(value = "search当前部门子部门", tags = {"OrgSector" } ,notes = "search当前部门子部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchcurchild")
	public ResponseEntity<Page<OrgSectorDTO>> searchCurChild(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurOrgOrg-all')")
	@ApiOperation(value = "fetch当前组织下部门", tags = {"OrgSector" } ,notes = "fetch当前组织下部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchcurorgorg")
	public ResponseEntity<List<OrgSectorDTO>> fetchCurOrgOrg(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurOrgOrg(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurOrgOrg-all')")
	@ApiOperation(value = "search当前组织下部门", tags = {"OrgSector" } ,notes = "search当前组织下部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchcurorgorg")
	public ResponseEntity<Page<OrgSectorDTO>> searchCurOrgOrg(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurOrgOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-UserOrgSector-all')")
	@ApiOperation(value = "fetch用户部门子部门", tags = {"OrgSector" } ,notes = "fetch用户部门子部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchuserorgsector")
	public ResponseEntity<List<OrgSectorDTO>> fetchUserOrgSector(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchUserOrgSector(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-UserOrgSector-all')")
	@ApiOperation(value = "search用户部门子部门", tags = {"OrgSector" } ,notes = "search用户部门子部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchuserorgsector")
	public ResponseEntity<Page<OrgSectorDTO>> searchUserOrgSector(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchUserOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-OrgRoot-all')")
	@ApiOperation(value = "fetch组织根部门", tags = {"OrgSector" } ,notes = "fetch组织根部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchorgroot")
	public ResponseEntity<List<OrgSectorDTO>> fetchOrgRoot(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchOrgRoot(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-OrgRoot-all')")
	@ApiOperation(value = "search组织根部门", tags = {"OrgSector" } ,notes = "search组织根部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchorgroot")
	public ResponseEntity<Page<OrgSectorDTO>> searchOrgRoot(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchOrgRoot(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-UserOrg-all')")
	@ApiOperation(value = "fetch用户组织部门", tags = {"OrgSector" } ,notes = "fetch用户组织部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchuserorg")
	public ResponseEntity<List<OrgSectorDTO>> fetchUserOrg(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchUserOrg(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-UserOrg-all')")
	@ApiOperation(value = "search用户组织部门", tags = {"OrgSector" } ,notes = "search用户组织部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchuserorg")
	public ResponseEntity<Page<OrgSectorDTO>> searchUserOrg(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchUserOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurOrg-all')")
	@ApiOperation(value = "fetch当前组织", tags = {"OrgSector" } ,notes = "fetch当前组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchcurorg")
	public ResponseEntity<List<OrgSectorDTO>> fetchCurOrg(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurOrg(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-CurOrg-all')")
	@ApiOperation(value = "search当前组织", tags = {"OrgSector" } ,notes = "search当前组织")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchcurorg")
	public ResponseEntity<Page<OrgSectorDTO>> searchCurOrg(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgSector" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgsectors/fetchdefault")
	public ResponseEntity<List<OrgSectorDTO>> fetchDefault(OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchDefault(context) ;
        List<OrgSectorDTO> list = orgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSector-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgSector" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgsectors/searchdefault")
	public ResponseEntity<Page<OrgSectorDTO>> searchDefault(@RequestBody OrgSectorSearchContext context) {
        Page<OrgSector> domains = orgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
