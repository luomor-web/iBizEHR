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
import cn.ibizlab.ehr.core.wf.domain.WFUCPolicy;
import cn.ibizlab.ehr.core.wf.service.IWFUCPolicyService;
import cn.ibizlab.ehr.core.wf.filter.WFUCPolicySearchContext;




@Slf4j
@Api(tags = {"WFUCPolicy" })
@RestController("WebApi-wfucpolicy")
@RequestMapping("")
public class WFUCPolicyResource {

    @Autowired
    private IWFUCPolicyService wfucpolicyService;

    @Autowired
    @Lazy
    private WFUCPolicyMapping wfucpolicyMapping;




    @PreAuthorize("hasPermission(#wfucpolicy_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFUCPolicy" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfucpolicies/{wfucpolicy_id}")
    public ResponseEntity<WFUCPolicyDTO> get(@PathVariable("wfucpolicy_id") String wfucpolicy_id) {
        WFUCPolicy domain = wfucpolicyService.get(wfucpolicy_id);
        WFUCPolicyDTO dto = wfucpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "禁用策略", tags = {"WFUCPolicy" },  notes = "禁用策略")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/{wfucpolicy_id}/disablepolicy")
    @Transactional
    public ResponseEntity<WFUCPolicyDTO> disablePolicy(@PathVariable("wfucpolicy_id") String wfucpolicy_id, @RequestBody WFUCPolicyDTO wfucpolicydto) {
        WFUCPolicy wfucpolicy = wfucpolicyMapping.toDomain(wfucpolicydto);
        wfucpolicy = wfucpolicyService.disablePolicy(wfucpolicy);
        wfucpolicydto = wfucpolicyMapping.toDto(wfucpolicy);
        return ResponseEntity.status(HttpStatus.OK).body(wfucpolicydto);
    }




    @ApiOperation(value = "Save", tags = {"WFUCPolicy" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUCPolicyDTO wfucpolicydto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfucpolicyService.save(wfucpolicyMapping.toDomain(wfucpolicydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFUCPolicy" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUCPolicyDTO> wfucpolicydtos) {
        wfucpolicyService.saveBatch(wfucpolicyMapping.toDomain(wfucpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfucpolicy_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFUCPolicy" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfucpolicies/{wfucpolicy_id}")
    @Transactional
    public ResponseEntity<WFUCPolicyDTO> update(@PathVariable("wfucpolicy_id") String wfucpolicy_id, @RequestBody WFUCPolicyDTO wfucpolicydto) {
		WFUCPolicy domain = wfucpolicyMapping.toDomain(wfucpolicydto);
        domain.setWfucpolicyid(wfucpolicy_id);
		wfucpolicyService.update(domain);
		WFUCPolicyDTO dto = wfucpolicyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfucpolicy_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUCPolicy" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfucpolicies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUCPolicyDTO> wfucpolicydtos) {
        wfucpolicyService.updateBatch(wfucpolicyMapping.toDomain(wfucpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFUCPolicy" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies")
    @Transactional
    public ResponseEntity<WFUCPolicyDTO> create(@RequestBody WFUCPolicyDTO wfucpolicydto) {
        WFUCPolicy domain = wfucpolicyMapping.toDomain(wfucpolicydto);
		wfucpolicyService.create(domain);
        WFUCPolicyDTO dto = wfucpolicyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFUCPolicy" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUCPolicyDTO> wfucpolicydtos) {
        wfucpolicyService.createBatch(wfucpolicyMapping.toDomain(wfucpolicydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "启用策略", tags = {"WFUCPolicy" },  notes = "启用策略")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/{wfucpolicy_id}/enablepolicy")
    @Transactional
    public ResponseEntity<WFUCPolicyDTO> enablePolicy(@PathVariable("wfucpolicy_id") String wfucpolicy_id, @RequestBody WFUCPolicyDTO wfucpolicydto) {
        WFUCPolicy wfucpolicy = wfucpolicyMapping.toDomain(wfucpolicydto);
        wfucpolicy = wfucpolicyService.enablePolicy(wfucpolicy);
        wfucpolicydto = wfucpolicyMapping.toDto(wfucpolicy);
        return ResponseEntity.status(HttpStatus.OK).body(wfucpolicydto);
    }




    @PreAuthorize("hasPermission('Remove',{#wfucpolicy_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFUCPolicy" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfucpolicies/{wfucpolicy_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfucpolicy_id") String wfucpolicy_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfucpolicyService.remove(wfucpolicy_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFUCPolicy" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfucpolicies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfucpolicyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFUCPolicy" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfucpolicies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUCPolicyDTO wfucpolicydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfucpolicyService.checkKey(wfucpolicyMapping.toDomain(wfucpolicydto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"WFUCPolicy" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfucpolicies/getdraft")
    public ResponseEntity<WFUCPolicyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfucpolicyMapping.toDto(wfucpolicyService.getDraft(new WFUCPolicy())));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUCPolicy" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfucpolicies/fetchdefault")
	public ResponseEntity<List<WFUCPolicyDTO>> fetchDefault(WFUCPolicySearchContext context) {
        Page<WFUCPolicy> domains = wfucpolicyService.searchDefault(context) ;
        List<WFUCPolicyDTO> list = wfucpolicyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WFUCPolicy" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfucpolicies/searchdefault")
	public ResponseEntity<Page<WFUCPolicyDTO>> searchDefault(@RequestBody WFUCPolicySearchContext context) {
        Page<WFUCPolicy> domains = wfucpolicyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfucpolicyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFUCPolicy getEntity(){
        return new WFUCPolicy();
    }

}
