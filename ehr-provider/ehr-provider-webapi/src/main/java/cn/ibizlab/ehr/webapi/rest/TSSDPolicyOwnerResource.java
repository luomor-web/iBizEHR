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
import cn.ibizlab.ehr.core.common.domain.TSSDPolicyOwner;
import cn.ibizlab.ehr.core.common.service.ITSSDPolicyOwnerService;
import cn.ibizlab.ehr.core.common.filter.TSSDPolicyOwnerSearchContext;




@Slf4j
@Api(tags = {"TSSDPolicyOwner" })
@RestController("WebApi-tssdpolicyowner")
@RequestMapping("")
public class TSSDPolicyOwnerResource {

    @Autowired
    private ITSSDPolicyOwnerService tssdpolicyownerService;

    @Autowired
    @Lazy
    private TSSDPolicyOwnerMapping tssdpolicyownerMapping;




    @ApiOperation(value = "CheckKey", tags = {"TSSDPolicyOwner" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicyowners/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDPolicyOwnerDTO tssdpolicyownerdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdpolicyownerService.checkKey(tssdpolicyownerMapping.toDomain(tssdpolicyownerdto)));
    }




    @PreAuthorize("hasPermission(#tssdpolicyowner_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDPolicyOwner" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdpolicyowners/{tssdpolicyowner_id}")
    @Transactional
    public ResponseEntity<TSSDPolicyOwnerDTO> update(@PathVariable("tssdpolicyowner_id") String tssdpolicyowner_id, @RequestBody TSSDPolicyOwnerDTO tssdpolicyownerdto) {
		TSSDPolicyOwner domain = tssdpolicyownerMapping.toDomain(tssdpolicyownerdto);
        domain.setTssdpolicyownerid(tssdpolicyowner_id);
		tssdpolicyownerService.update(domain);
		TSSDPolicyOwnerDTO dto = tssdpolicyownerMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdpolicyowner_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDPolicyOwner" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdpolicyowners/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDPolicyOwnerDTO> tssdpolicyownerdtos) {
        tssdpolicyownerService.updateBatch(tssdpolicyownerMapping.toDomain(tssdpolicyownerdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#tssdpolicyowner_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDPolicyOwner" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdpolicyowners/{tssdpolicyowner_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdpolicyowner_id") String tssdpolicyowner_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyownerService.remove(tssdpolicyowner_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDPolicyOwner" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdpolicyowners/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdpolicyownerService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDPolicyOwner" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicyowners")
    @Transactional
    public ResponseEntity<TSSDPolicyOwnerDTO> create(@RequestBody TSSDPolicyOwnerDTO tssdpolicyownerdto) {
        TSSDPolicyOwner domain = tssdpolicyownerMapping.toDomain(tssdpolicyownerdto);
		tssdpolicyownerService.create(domain);
        TSSDPolicyOwnerDTO dto = tssdpolicyownerMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDPolicyOwner" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicyowners/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDPolicyOwnerDTO> tssdpolicyownerdtos) {
        tssdpolicyownerService.createBatch(tssdpolicyownerMapping.toDomain(tssdpolicyownerdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdpolicyowner_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDPolicyOwner" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdpolicyowners/{tssdpolicyowner_id}")
    public ResponseEntity<TSSDPolicyOwnerDTO> get(@PathVariable("tssdpolicyowner_id") String tssdpolicyowner_id) {
        TSSDPolicyOwner domain = tssdpolicyownerService.get(tssdpolicyowner_id);
        TSSDPolicyOwnerDTO dto = tssdpolicyownerMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"TSSDPolicyOwner" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicyowners/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDPolicyOwnerDTO tssdpolicyownerdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyownerService.save(tssdpolicyownerMapping.toDomain(tssdpolicyownerdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDPolicyOwner" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdpolicyowners/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDPolicyOwnerDTO> tssdpolicyownerdtos) {
        tssdpolicyownerService.saveBatch(tssdpolicyownerMapping.toDomain(tssdpolicyownerdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TSSDPolicyOwner" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdpolicyowners/getdraft")
    public ResponseEntity<TSSDPolicyOwnerDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdpolicyownerMapping.toDto(tssdpolicyownerService.getDraft(new TSSDPolicyOwner())));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDPolicyOwner" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdpolicyowners/fetchdefault")
	public ResponseEntity<List<TSSDPolicyOwnerDTO>> fetchDefault(TSSDPolicyOwnerSearchContext context) {
        Page<TSSDPolicyOwner> domains = tssdpolicyownerService.searchDefault(context) ;
        List<TSSDPolicyOwnerDTO> list = tssdpolicyownerMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDPolicyOwner" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdpolicyowners/searchdefault")
	public ResponseEntity<Page<TSSDPolicyOwnerDTO>> searchDefault(@RequestBody TSSDPolicyOwnerSearchContext context) {
        Page<TSSDPolicyOwner> domains = tssdpolicyownerService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdpolicyownerMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDPolicyOwner getEntity(){
        return new TSSDPolicyOwner();
    }

}
