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
import cn.ibizlab.ehr.core.common.domain.TSSDTaskPolicy;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskPolicyService;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskPolicySearchContext;




@Slf4j
@Api(tags = {"TSSDTaskPolicy" })
@RestController("WebApi-tssdtaskpolicy")
@RequestMapping("")
public class TSSDTaskPolicyResource {

    @Autowired
    private ITSSDTaskPolicyService tssdtaskpolicyService;

    @Autowired
    @Lazy
    private TSSDTaskPolicyMapping tssdtaskpolicyMapping;




    @ApiOperation(value = "GetDraft", tags = {"TSSDTaskPolicy" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtaskpolicies/getdraft")
    public ResponseEntity<TSSDTaskPolicyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtaskpolicyMapping.toDto(tssdtaskpolicyService.getDraft(new TSSDTaskPolicy())));
    }




    @PreAuthorize("hasPermission(#tssdtaskpolicy_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDTaskPolicy" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtaskpolicies/{tssdtaskpolicy_id}")
    @Transactional
    public ResponseEntity<TSSDTaskPolicyDTO> update(@PathVariable("tssdtaskpolicy_id") String tssdtaskpolicy_id, @RequestBody TSSDTaskPolicyDTO tssdtaskpolicydto) {
		TSSDTaskPolicy domain = tssdtaskpolicyMapping.toDomain(tssdtaskpolicydto);
        domain.setTssdtaskpolicyid(tssdtaskpolicy_id);
		tssdtaskpolicyService.update(domain);
		TSSDTaskPolicyDTO dto = tssdtaskpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdtaskpolicy_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDTaskPolicy" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtaskpolicies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDTaskPolicyDTO> tssdtaskpolicydtos) {
        tssdtaskpolicyService.updateBatch(tssdtaskpolicyMapping.toDomain(tssdtaskpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDTaskPolicy" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtaskpolicies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDTaskPolicyDTO tssdtaskpolicydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdtaskpolicyService.checkKey(tssdtaskpolicyMapping.toDomain(tssdtaskpolicydto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDTaskPolicy" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtaskpolicies")
    @Transactional
    public ResponseEntity<TSSDTaskPolicyDTO> create(@RequestBody TSSDTaskPolicyDTO tssdtaskpolicydto) {
        TSSDTaskPolicy domain = tssdtaskpolicyMapping.toDomain(tssdtaskpolicydto);
		tssdtaskpolicyService.create(domain);
        TSSDTaskPolicyDTO dto = tssdtaskpolicyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDTaskPolicy" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtaskpolicies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDTaskPolicyDTO> tssdtaskpolicydtos) {
        tssdtaskpolicyService.createBatch(tssdtaskpolicyMapping.toDomain(tssdtaskpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtaskpolicy_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"TSSDTaskPolicy" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtaskpolicies/{tssdtaskpolicy_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdtaskpolicy_id") String tssdtaskpolicy_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdtaskpolicyService.remove(tssdtaskpolicy_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDTaskPolicy" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtaskpolicies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdtaskpolicyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TSSDTaskPolicy" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtaskpolicies/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDTaskPolicyDTO tssdtaskpolicydto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtaskpolicyService.save(tssdtaskpolicyMapping.toDomain(tssdtaskpolicydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDTaskPolicy" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtaskpolicies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDTaskPolicyDTO> tssdtaskpolicydtos) {
        tssdtaskpolicyService.saveBatch(tssdtaskpolicyMapping.toDomain(tssdtaskpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtaskpolicy_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDTaskPolicy" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtaskpolicies/{tssdtaskpolicy_id}")
    public ResponseEntity<TSSDTaskPolicyDTO> get(@PathVariable("tssdtaskpolicy_id") String tssdtaskpolicy_id) {
        TSSDTaskPolicy domain = tssdtaskpolicyService.get(tssdtaskpolicy_id);
        TSSDTaskPolicyDTO dto = tssdtaskpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDTaskPolicy-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDTaskPolicy" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdtaskpolicies/fetchdefault")
	public ResponseEntity<List<TSSDTaskPolicyDTO>> fetchDefault(TSSDTaskPolicySearchContext context) {
        Page<TSSDTaskPolicy> domains = tssdtaskpolicyService.searchDefault(context) ;
        List<TSSDTaskPolicyDTO> list = tssdtaskpolicyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDTaskPolicy-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDTaskPolicy" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdtaskpolicies/searchdefault")
	public ResponseEntity<Page<TSSDTaskPolicyDTO>> searchDefault(@RequestBody TSSDTaskPolicySearchContext context) {
        Page<TSSDTaskPolicy> domains = tssdtaskpolicyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdtaskpolicyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDTaskPolicy getEntity(){
        return new TSSDTaskPolicy();
    }

}
