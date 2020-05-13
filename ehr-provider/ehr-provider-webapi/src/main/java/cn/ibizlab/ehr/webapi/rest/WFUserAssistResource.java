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
import cn.ibizlab.ehr.core.wf.domain.WFUserAssist;
import cn.ibizlab.ehr.core.wf.service.IWFUserAssistService;
import cn.ibizlab.ehr.core.wf.filter.WFUserAssistSearchContext;




@Slf4j
@Api(tags = {"WFUserAssist" })
@RestController("WebApi-wfuserassist")
@RequestMapping("")
public class WFUserAssistResource {

    @Autowired
    private IWFUserAssistService wfuserassistService;

    @Autowired
    @Lazy
    private WFUserAssistMapping wfuserassistMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFUserAssist" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuserassists")
    @Transactional
    public ResponseEntity<WFUserAssistDTO> create(@RequestBody WFUserAssistDTO wfuserassistdto) {
        WFUserAssist domain = wfuserassistMapping.toDomain(wfuserassistdto);
		wfuserassistService.create(domain);
        WFUserAssistDTO dto = wfuserassistMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFUserAssist" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuserassists/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserAssistDTO> wfuserassistdtos) {
        wfuserassistService.createBatch(wfuserassistMapping.toDomain(wfuserassistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfuserassist_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFUserAssist" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfuserassists/{wfuserassist_id}")
    @Transactional
    public ResponseEntity<WFUserAssistDTO> update(@PathVariable("wfuserassist_id") String wfuserassist_id, @RequestBody WFUserAssistDTO wfuserassistdto) {
		WFUserAssist domain = wfuserassistMapping.toDomain(wfuserassistdto);
        domain.setWfuserassistid(wfuserassist_id);
		wfuserassistService.update(domain);
		WFUserAssistDTO dto = wfuserassistMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfuserassist_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUserAssist" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfuserassists/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserAssistDTO> wfuserassistdtos) {
        wfuserassistService.updateBatch(wfuserassistMapping.toDomain(wfuserassistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#wfuserassist_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFUserAssist" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfuserassists/{wfuserassist_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfuserassist_id") String wfuserassist_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfuserassistService.remove(wfuserassist_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFUserAssist" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfuserassists/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfuserassistService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFUserAssist" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuserassists/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserAssistDTO wfuserassistdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfuserassistService.checkKey(wfuserassistMapping.toDomain(wfuserassistdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"WFUserAssist" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfuserassists/getdraft")
    public ResponseEntity<WFUserAssistDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserassistMapping.toDto(wfuserassistService.getDraft(new WFUserAssist())));
    }




    @ApiOperation(value = "Save", tags = {"WFUserAssist" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuserassists/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserAssistDTO wfuserassistdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserassistService.save(wfuserassistMapping.toDomain(wfuserassistdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFUserAssist" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuserassists/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserAssistDTO> wfuserassistdtos) {
        wfuserassistService.saveBatch(wfuserassistMapping.toDomain(wfuserassistdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfuserassist_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFUserAssist" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfuserassists/{wfuserassist_id}")
    public ResponseEntity<WFUserAssistDTO> get(@PathVariable("wfuserassist_id") String wfuserassist_id) {
        WFUserAssist domain = wfuserassistService.get(wfuserassist_id);
        WFUserAssistDTO dto = wfuserassistMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUserAssist" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfuserassists/fetchdefault")
	public ResponseEntity<List<WFUserAssistDTO>> fetchDefault(WFUserAssistSearchContext context) {
        Page<WFUserAssist> domains = wfuserassistService.searchDefault(context) ;
        List<WFUserAssistDTO> list = wfuserassistMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUserAssist" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfuserassists/searchdefault")
	public ResponseEntity<Page<WFUserAssistDTO>> searchDefault(WFUserAssistSearchContext context) {
        Page<WFUserAssist> domains = wfuserassistService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfuserassistMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFUserAssist getEntity(){
        return new WFUserAssist();
    }

}
