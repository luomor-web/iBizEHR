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
import cn.ibizlab.ehr.core.wf.domain.WFWorkList;
import cn.ibizlab.ehr.core.wf.service.IWFWorkListService;
import cn.ibizlab.ehr.core.wf.filter.WFWorkListSearchContext;




@Slf4j
@Api(tags = {"WFWorkList" })
@RestController("WebApi-wfworklist")
@RequestMapping("")
public class WFWorkListResource {

    @Autowired
    private IWFWorkListService wfworklistService;

    @Autowired
    @Lazy
    private WFWorkListMapping wfworklistMapping;




    @ApiOperation(value = "GetDraft", tags = {"WFWorkList" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfworklists/getdraft")
    public ResponseEntity<WFWorkListDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfworklistMapping.toDto(wfworklistService.getDraft(new WFWorkList())));
    }




    @ApiOperation(value = "CheckKey", tags = {"WFWorkList" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworklists/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFWorkListDTO wfworklistdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfworklistService.checkKey(wfworklistMapping.toDomain(wfworklistdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#wfworklist_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFWorkList" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfworklists/{wfworklist_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfworklist_id") String wfworklist_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfworklistService.remove(wfworklist_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFWorkList" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfworklists/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfworklistService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFWorkList" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworklists/save")
    public ResponseEntity<Boolean> save(@RequestBody WFWorkListDTO wfworklistdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfworklistService.save(wfworklistMapping.toDomain(wfworklistdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFWorkList" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworklists/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFWorkListDTO> wfworklistdtos) {
        wfworklistService.saveBatch(wfworklistMapping.toDomain(wfworklistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFWorkList" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworklists")
    @Transactional
    public ResponseEntity<WFWorkListDTO> create(@RequestBody WFWorkListDTO wfworklistdto) {
        WFWorkList domain = wfworklistMapping.toDomain(wfworklistdto);
		wfworklistService.create(domain);
        WFWorkListDTO dto = wfworklistMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFWorkList" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworklists/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFWorkListDTO> wfworklistdtos) {
        wfworklistService.createBatch(wfworklistMapping.toDomain(wfworklistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfworklist_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFWorkList" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfworklists/{wfworklist_id}")
    public ResponseEntity<WFWorkListDTO> get(@PathVariable("wfworklist_id") String wfworklist_id) {
        WFWorkList domain = wfworklistService.get(wfworklist_id);
        WFWorkListDTO dto = wfworklistMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfworklist_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFWorkList" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfworklists/{wfworklist_id}")
    @Transactional
    public ResponseEntity<WFWorkListDTO> update(@PathVariable("wfworklist_id") String wfworklist_id, @RequestBody WFWorkListDTO wfworklistdto) {
		WFWorkList domain = wfworklistMapping.toDomain(wfworklistdto);
        domain.setWfworklistid(wfworklist_id);
		wfworklistService.update(domain);
		WFWorkListDTO dto = wfworklistMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfworklist_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFWorkList" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfworklists/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFWorkListDTO> wfworklistdtos) {
        wfworklistService.updateBatch(wfworklistMapping.toDomain(wfworklistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"WFWorkList" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfworklists/fetchdefault")
	public ResponseEntity<List<WFWorkListDTO>> fetchDefault(WFWorkListSearchContext context) {
        Page<WFWorkList> domains = wfworklistService.searchDefault(context) ;
        List<WFWorkListDTO> list = wfworklistMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WFWorkList" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfworklists/searchdefault")
	public ResponseEntity<Page<WFWorkListDTO>> searchDefault(@RequestBody WFWorkListSearchContext context) {
        Page<WFWorkList> domains = wfworklistService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfworklistMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFWorkList getEntity(){
        return new WFWorkList();
    }

}
