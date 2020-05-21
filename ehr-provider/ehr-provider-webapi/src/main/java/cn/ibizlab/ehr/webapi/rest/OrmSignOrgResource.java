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
import cn.ibizlab.ehr.core.orm.domain.OrmSignOrg;
import cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService;
import cn.ibizlab.ehr.core.orm.filter.OrmSignOrgSearchContext;




@Slf4j
@Api(tags = {"OrmSignOrg" })
@RestController("WebApi-ormsignorg")
@RequestMapping("")
public class OrmSignOrgResource {

    @Autowired
    private IOrmSignOrgService ormsignorgService;

    @Autowired
    @Lazy
    public OrmSignOrgMapping ormsignorgMapping;

    public OrmSignOrgDTO permissionDTO=new OrmSignOrgDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrmSignOrg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmSignOrgDTO ormsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormsignorgService.checkKey(ormsignorgMapping.toDomain(ormsignorgdto)));
    }




    @PreAuthorize("hasPermission(#ormsignorg_id,'Update',{'Sql',this.ormsignorgMapping,#ormsignorgdto})")
    @ApiOperation(value = "Update", tags = {"OrmSignOrg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/{ormsignorg_id}")
    @Transactional
    public ResponseEntity<OrmSignOrgDTO> update(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody OrmSignOrgDTO ormsignorgdto) {
		OrmSignOrg domain = ormsignorgMapping.toDomain(ormsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
		ormsignorgService.update(domain);
		OrmSignOrgDTO dto = ormsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"OrmSignOrg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmSignOrgDTO> ormsignorgdtos) {
        ormsignorgService.updateBatch(ormsignorgMapping.toDomain(ormsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrmSignOrg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmSignOrgDTO ormsignorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormsignorgService.save(ormsignorgMapping.toDomain(ormsignorgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrmSignOrg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmSignOrgDTO> ormsignorgdtos) {
        ormsignorgService.saveBatch(ormsignorgMapping.toDomain(ormsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrmSignOrg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/getdraft")
    public ResponseEntity<OrmSignOrgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormsignorgMapping.toDto(ormsignorgService.getDraft(new OrmSignOrg())));
    }




    @PreAuthorize("hasPermission(#ormsignorg_id,'Get',{'Sql',this.ormsignorgMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrmSignOrg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/{ormsignorg_id}")
    public ResponseEntity<OrmSignOrgDTO> get(@PathVariable("ormsignorg_id") String ormsignorg_id) {
        OrmSignOrg domain = ormsignorgService.get(ormsignorg_id);
        OrmSignOrgDTO dto = ormsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormsignorgMapping,#ormsignorgdto})")
    @ApiOperation(value = "Create", tags = {"OrmSignOrg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs")
    @Transactional
    public ResponseEntity<OrmSignOrgDTO> create(@RequestBody OrmSignOrgDTO ormsignorgdto) {
        OrmSignOrg domain = ormsignorgMapping.toDomain(ormsignorgdto);
		ormsignorgService.create(domain);
        OrmSignOrgDTO dto = ormsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"OrmSignOrg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmSignOrgDTO> ormsignorgdtos) {
        ormsignorgService.createBatch(ormsignorgMapping.toDomain(ormsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormsignorg_id,'Remove',{'Sql',this.ormsignorgMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrmSignOrg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/{ormsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormsignorg_id") String ormsignorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormsignorgService.remove(ormsignorg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrmSignOrg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-HTQDDW-all')")
	@ApiOperation(value = "fetch合同签订单位", tags = {"OrmSignOrg" } ,notes = "fetch合同签订单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/fetchhtqddw")
	public ResponseEntity<List<OrmSignOrgDTO>> fetchHTQDDW(OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchHTQDDW(context) ;
        List<OrmSignOrgDTO> list = ormsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-HTQDDW-all')")
	@ApiOperation(value = "search合同签订单位", tags = {"OrmSignOrg" } ,notes = "search合同签订单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/searchhtqddw")
	public ResponseEntity<Page<OrmSignOrgDTO>> searchHTQDDW(@RequestBody OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchHTQDDW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmSignOrg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/fetchdefault")
	public ResponseEntity<List<OrmSignOrgDTO>> fetchDefault(OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchDefault(context) ;
        List<OrmSignOrgDTO> list = ormsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmSignOrg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/searchdefault")
	public ResponseEntity<Page<OrmSignOrgDTO>> searchDefault(@RequestBody OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-CKBDWDFRZT-all')")
	@ApiOperation(value = "fetch证书注册单位", tags = {"OrmSignOrg" } ,notes = "fetch证书注册单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/fetchckbdwdfrzt")
	public ResponseEntity<List<OrmSignOrgDTO>> fetchCKBDWDFRZT(OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchCKBDWDFRZT(context) ;
        List<OrmSignOrgDTO> list = ormsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmSignOrg-CKBDWDFRZT-all')")
	@ApiOperation(value = "search证书注册单位", tags = {"OrmSignOrg" } ,notes = "search证书注册单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/searchckbdwdfrzt")
	public ResponseEntity<Page<OrmSignOrgDTO>> searchCKBDWDFRZT(@RequestBody OrmSignOrgSearchContext context) {
        Page<OrmSignOrg> domains = ormsignorgService.searchCKBDWDFRZT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


