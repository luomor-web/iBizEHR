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
import cn.ibizlab.ehr.core.wf.domain.WFCustomProcess;
import cn.ibizlab.ehr.core.wf.service.IWFCustomProcessService;
import cn.ibizlab.ehr.core.wf.filter.WFCustomProcessSearchContext;




@Slf4j
@Api(tags = {"WFCustomProcess" })
@RestController("WebApi-wfcustomprocess")
@RequestMapping("")
public class WFCustomProcessResource {

    @Autowired
    private IWFCustomProcessService wfcustomprocessService;

    @Autowired
    @Lazy
    private WFCustomProcessMapping wfcustomprocessMapping;




    @ApiOperation(value = "Save", tags = {"WFCustomProcess" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfcustomprocesses/save")
    public ResponseEntity<Boolean> save(@RequestBody WFCustomProcessDTO wfcustomprocessdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfcustomprocessService.save(wfcustomprocessMapping.toDomain(wfcustomprocessdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFCustomProcess" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfcustomprocesses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFCustomProcessDTO> wfcustomprocessdtos) {
        wfcustomprocessService.saveBatch(wfcustomprocessMapping.toDomain(wfcustomprocessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfcustomprocess_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFCustomProcess" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfcustomprocesses/{wfcustomprocess_id}")
    public ResponseEntity<WFCustomProcessDTO> get(@PathVariable("wfcustomprocess_id") String wfcustomprocess_id) {
        WFCustomProcess domain = wfcustomprocessService.get(wfcustomprocess_id);
        WFCustomProcessDTO dto = wfcustomprocessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#wfcustomprocess_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFCustomProcess" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfcustomprocesses/{wfcustomprocess_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfcustomprocess_id") String wfcustomprocess_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfcustomprocessService.remove(wfcustomprocess_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFCustomProcess" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfcustomprocesses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfcustomprocessService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfcustomprocess_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFCustomProcess" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfcustomprocesses/{wfcustomprocess_id}")
    @Transactional
    public ResponseEntity<WFCustomProcessDTO> update(@PathVariable("wfcustomprocess_id") String wfcustomprocess_id, @RequestBody WFCustomProcessDTO wfcustomprocessdto) {
		WFCustomProcess domain = wfcustomprocessMapping.toDomain(wfcustomprocessdto);
        domain.setWfcustomprocessid(wfcustomprocess_id);
		wfcustomprocessService.update(domain);
		WFCustomProcessDTO dto = wfcustomprocessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfcustomprocess_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFCustomProcess" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfcustomprocesses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFCustomProcessDTO> wfcustomprocessdtos) {
        wfcustomprocessService.updateBatch(wfcustomprocessMapping.toDomain(wfcustomprocessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFCustomProcess" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfcustomprocesses/getdraft")
    public ResponseEntity<WFCustomProcessDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfcustomprocessMapping.toDto(wfcustomprocessService.getDraft(new WFCustomProcess())));
    }




    @ApiOperation(value = "CheckKey", tags = {"WFCustomProcess" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfcustomprocesses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFCustomProcessDTO wfcustomprocessdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfcustomprocessService.checkKey(wfcustomprocessMapping.toDomain(wfcustomprocessdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFCustomProcess" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfcustomprocesses")
    @Transactional
    public ResponseEntity<WFCustomProcessDTO> create(@RequestBody WFCustomProcessDTO wfcustomprocessdto) {
        WFCustomProcess domain = wfcustomprocessMapping.toDomain(wfcustomprocessdto);
		wfcustomprocessService.create(domain);
        WFCustomProcessDTO dto = wfcustomprocessMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFCustomProcess" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfcustomprocesses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFCustomProcessDTO> wfcustomprocessdtos) {
        wfcustomprocessService.createBatch(wfcustomprocessMapping.toDomain(wfcustomprocessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFCustomProcess" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfcustomprocesses/fetchdefault")
	public ResponseEntity<List<WFCustomProcessDTO>> fetchDefault(WFCustomProcessSearchContext context) {
        Page<WFCustomProcess> domains = wfcustomprocessService.searchDefault(context) ;
        List<WFCustomProcessDTO> list = wfcustomprocessMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFCustomProcess" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfcustomprocesses/searchdefault")
	public ResponseEntity<Page<WFCustomProcessDTO>> searchDefault(WFCustomProcessSearchContext context) {
        Page<WFCustomProcess> domains = wfcustomprocessService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfcustomprocessMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFCustomProcess getEntity(){
        return new WFCustomProcess();
    }

}
