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
import cn.ibizlab.ehr.core.wf.domain.WFAction;
import cn.ibizlab.ehr.core.wf.service.IWFActionService;
import cn.ibizlab.ehr.core.wf.filter.WFActionSearchContext;




@Slf4j
@Api(tags = {"WFAction" })
@RestController("WebApi-wfaction")
@RequestMapping("")
public class WFActionResource {

    @Autowired
    private IWFActionService wfactionService;

    @Autowired
    @Lazy
    private WFActionMapping wfactionMapping;




    @ApiOperation(value = "CheckKey", tags = {"WFAction" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFActionDTO wfactiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfactionService.checkKey(wfactionMapping.toDomain(wfactiondto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"WFAction" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfactions/getdraft")
    public ResponseEntity<WFActionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfactionMapping.toDto(wfactionService.getDraft(new WFAction())));
    }




    @PreAuthorize("hasPermission(#wfaction_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFAction" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfactions/{wfaction_id}")
    @Transactional
    public ResponseEntity<WFActionDTO> update(@PathVariable("wfaction_id") String wfaction_id, @RequestBody WFActionDTO wfactiondto) {
		WFAction domain = wfactionMapping.toDomain(wfactiondto);
        domain.setWfactionid(wfaction_id);
		wfactionService.update(domain);
		WFActionDTO dto = wfactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfaction_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFAction" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfactions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFActionDTO> wfactiondtos) {
        wfactionService.updateBatch(wfactionMapping.toDomain(wfactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFAction" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactions/save")
    public ResponseEntity<Boolean> save(@RequestBody WFActionDTO wfactiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfactionService.save(wfactionMapping.toDomain(wfactiondto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFAction" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFActionDTO> wfactiondtos) {
        wfactionService.saveBatch(wfactionMapping.toDomain(wfactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFAction" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactions")
    @Transactional
    public ResponseEntity<WFActionDTO> create(@RequestBody WFActionDTO wfactiondto) {
        WFAction domain = wfactionMapping.toDomain(wfactiondto);
		wfactionService.create(domain);
        WFActionDTO dto = wfactionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFAction" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFActionDTO> wfactiondtos) {
        wfactionService.createBatch(wfactionMapping.toDomain(wfactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfaction_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFAction" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfactions/{wfaction_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfaction_id") String wfaction_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfactionService.remove(wfaction_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFAction" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfactions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfactionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfaction_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFAction" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfactions/{wfaction_id}")
    public ResponseEntity<WFActionDTO> get(@PathVariable("wfaction_id") String wfaction_id) {
        WFAction domain = wfactionService.get(wfaction_id);
        WFActionDTO dto = wfactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFAction-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFAction" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfactions/fetchdefault")
	public ResponseEntity<List<WFActionDTO>> fetchDefault(WFActionSearchContext context) {
        Page<WFAction> domains = wfactionService.searchDefault(context) ;
        List<WFActionDTO> list = wfactionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFAction-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFAction" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfactions/searchdefault")
	public ResponseEntity<Page<WFActionDTO>> searchDefault(@RequestBody WFActionSearchContext context) {
        Page<WFAction> domains = wfactionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfactionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFAction getEntity(){
        return new WFAction();
    }

}
