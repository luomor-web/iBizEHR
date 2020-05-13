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
import cn.ibizlab.ehr.core.wf.domain.WFIAAction;
import cn.ibizlab.ehr.core.wf.service.IWFIAActionService;
import cn.ibizlab.ehr.core.wf.filter.WFIAActionSearchContext;




@Slf4j
@Api(tags = {"WFIAAction" })
@RestController("WebApi-wfiaaction")
@RequestMapping("")
public class WFIAActionResource {

    @Autowired
    private IWFIAActionService wfiaactionService;

    @Autowired
    @Lazy
    private WFIAActionMapping wfiaactionMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFIAAction" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfiaactions")
    @Transactional
    public ResponseEntity<WFIAActionDTO> create(@RequestBody WFIAActionDTO wfiaactiondto) {
        WFIAAction domain = wfiaactionMapping.toDomain(wfiaactiondto);
		wfiaactionService.create(domain);
        WFIAActionDTO dto = wfiaactionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFIAAction" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfiaactions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFIAActionDTO> wfiaactiondtos) {
        wfiaactionService.createBatch(wfiaactionMapping.toDomain(wfiaactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfiaaction_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFIAAction" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfiaactions/{wfiaaction_id}")
    public ResponseEntity<WFIAActionDTO> get(@PathVariable("wfiaaction_id") String wfiaaction_id) {
        WFIAAction domain = wfiaactionService.get(wfiaaction_id);
        WFIAActionDTO dto = wfiaactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfiaaction_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFIAAction" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfiaactions/{wfiaaction_id}")
    @Transactional
    public ResponseEntity<WFIAActionDTO> update(@PathVariable("wfiaaction_id") String wfiaaction_id, @RequestBody WFIAActionDTO wfiaactiondto) {
		WFIAAction domain = wfiaactionMapping.toDomain(wfiaactiondto);
        domain.setWfiaactionid(wfiaaction_id);
		wfiaactionService.update(domain);
		WFIAActionDTO dto = wfiaactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfiaaction_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFIAAction" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfiaactions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFIAActionDTO> wfiaactiondtos) {
        wfiaactionService.updateBatch(wfiaactionMapping.toDomain(wfiaactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#wfiaaction_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFIAAction" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfiaactions/{wfiaaction_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfiaaction_id") String wfiaaction_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfiaactionService.remove(wfiaaction_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFIAAction" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfiaactions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfiaactionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFIAAction" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfiaactions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFIAActionDTO wfiaactiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfiaactionService.checkKey(wfiaactionMapping.toDomain(wfiaactiondto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"WFIAAction" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfiaactions/getdraft")
    public ResponseEntity<WFIAActionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfiaactionMapping.toDto(wfiaactionService.getDraft(new WFIAAction())));
    }




    @ApiOperation(value = "Save", tags = {"WFIAAction" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfiaactions/save")
    public ResponseEntity<Boolean> save(@RequestBody WFIAActionDTO wfiaactiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfiaactionService.save(wfiaactionMapping.toDomain(wfiaactiondto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFIAAction" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfiaactions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFIAActionDTO> wfiaactiondtos) {
        wfiaactionService.saveBatch(wfiaactionMapping.toDomain(wfiaactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFIAAction" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfiaactions/fetchdefault")
	public ResponseEntity<List<WFIAActionDTO>> fetchDefault(WFIAActionSearchContext context) {
        Page<WFIAAction> domains = wfiaactionService.searchDefault(context) ;
        List<WFIAActionDTO> list = wfiaactionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFIAAction" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfiaactions/searchdefault")
	public ResponseEntity<Page<WFIAActionDTO>> searchDefault(WFIAActionSearchContext context) {
        Page<WFIAAction> domains = wfiaactionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfiaactionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFIAAction getEntity(){
        return new WFIAAction();
    }

}
