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
import cn.ibizlab.ehr.core.common.domain.TSSDPolicy;
import cn.ibizlab.ehr.core.common.service.ITSSDPolicyService;
import cn.ibizlab.ehr.core.common.filter.TSSDPolicySearchContext;




@Slf4j
@Api(tags = {"TSSDPolicy" })
@RestController("WebApi-tssdpolicy")
@RequestMapping("")
public class TSSDPolicyResource {

    @Autowired
    private ITSSDPolicyService tssdpolicyService;

    @Autowired
    @Lazy
    public TSSDPolicyMapping tssdpolicyMapping;

    public TSSDPolicyDTO permissionDTO=new TSSDPolicyDTO();




    @PreAuthorize("hasPermission('','Create',{'Sql',this.tssdpolicyMapping,#tssdpolicydto})")
    @ApiOperation(value = "Create", tags = {"TSSDPolicy" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicies")
    @Transactional
    public ResponseEntity<TSSDPolicyDTO> create(@RequestBody TSSDPolicyDTO tssdpolicydto) {
        TSSDPolicy domain = tssdpolicyMapping.toDomain(tssdpolicydto);
		tssdpolicyService.create(domain);
        TSSDPolicyDTO dto = tssdpolicyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"TSSDPolicy" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDPolicyDTO> tssdpolicydtos) {
        tssdpolicyService.createBatch(tssdpolicyMapping.toDomain(tssdpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdpolicy_id,'Remove',{'Sql',this.tssdpolicyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TSSDPolicy" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdpolicies/{tssdpolicy_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdpolicy_id") String tssdpolicy_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyService.remove(tssdpolicy_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDPolicy" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdpolicies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdpolicyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDPolicy-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TSSDPolicy" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDPolicyDTO tssdpolicydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdpolicyService.checkKey(tssdpolicyMapping.toDomain(tssdpolicydto)));
    }




    @PreAuthorize("hasPermission(#tssdpolicy_id,'Update',{'Sql',this.tssdpolicyMapping,#tssdpolicydto})")
    @ApiOperation(value = "Update", tags = {"TSSDPolicy" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdpolicies/{tssdpolicy_id}")
    @Transactional
    public ResponseEntity<TSSDPolicyDTO> update(@PathVariable("tssdpolicy_id") String tssdpolicy_id, @RequestBody TSSDPolicyDTO tssdpolicydto) {
		TSSDPolicy domain = tssdpolicyMapping.toDomain(tssdpolicydto);
        domain.setTssdpolicyid(tssdpolicy_id);
		tssdpolicyService.update(domain);
		TSSDPolicyDTO dto = tssdpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"TSSDPolicy" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdpolicies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDPolicyDTO> tssdpolicydtos) {
        tssdpolicyService.updateBatch(tssdpolicyMapping.toDomain(tssdpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDPolicy-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TSSDPolicy" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdpolicies/getdraft")
    public ResponseEntity<TSSDPolicyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyMapping.toDto(tssdpolicyService.getDraft(new TSSDPolicy())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDPolicy-Save-all')")
    @ApiOperation(value = "Save", tags = {"TSSDPolicy" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicies/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDPolicyDTO tssdpolicydto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyService.save(tssdpolicyMapping.toDomain(tssdpolicydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDPolicy" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDPolicyDTO> tssdpolicydtos) {
        tssdpolicyService.saveBatch(tssdpolicyMapping.toDomain(tssdpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdpolicy_id,'Get',{'Sql',this.tssdpolicyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TSSDPolicy" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdpolicies/{tssdpolicy_id}")
    public ResponseEntity<TSSDPolicyDTO> get(@PathVariable("tssdpolicy_id") String tssdpolicy_id) {
        TSSDPolicy domain = tssdpolicyService.get(tssdpolicy_id);
        TSSDPolicyDTO dto = tssdpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDPolicy-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDPolicy" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdpolicies/fetchdefault")
	public ResponseEntity<List<TSSDPolicyDTO>> fetchDefault(TSSDPolicySearchContext context) {
        Page<TSSDPolicy> domains = tssdpolicyService.searchDefault(context) ;
        List<TSSDPolicyDTO> list = tssdpolicyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDPolicy-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDPolicy" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdpolicies/searchdefault")
	public ResponseEntity<Page<TSSDPolicyDTO>> searchDefault(@RequestBody TSSDPolicySearchContext context) {
        Page<TSSDPolicy> domains = tssdpolicyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdpolicyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


