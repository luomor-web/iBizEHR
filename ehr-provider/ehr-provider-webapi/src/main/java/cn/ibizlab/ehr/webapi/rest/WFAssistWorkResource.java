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
import cn.ibizlab.ehr.core.wf.domain.WFAssistWork;
import cn.ibizlab.ehr.core.wf.service.IWFAssistWorkService;
import cn.ibizlab.ehr.core.wf.filter.WFAssistWorkSearchContext;




@Slf4j
@Api(tags = {"WFAssistWork" })
@RestController("WebApi-wfassistwork")
@RequestMapping("")
public class WFAssistWorkResource {

    @Autowired
    private IWFAssistWorkService wfassistworkService;

    @Autowired
    @Lazy
    private WFAssistWorkMapping wfassistworkMapping;




    @PreAuthorize("hasPermission(#wfassistwork_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFAssistWork" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfassistworks/{wfassistwork_id}")
    @Transactional
    public ResponseEntity<WFAssistWorkDTO> update(@PathVariable("wfassistwork_id") String wfassistwork_id, @RequestBody WFAssistWorkDTO wfassistworkdto) {
		WFAssistWork domain = wfassistworkMapping.toDomain(wfassistworkdto);
        domain.setWfassistworkid(wfassistwork_id);
		wfassistworkService.update(domain);
		WFAssistWorkDTO dto = wfassistworkMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfassistwork_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFAssistWork" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfassistworks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFAssistWorkDTO> wfassistworkdtos) {
        wfassistworkService.updateBatch(wfassistworkMapping.toDomain(wfassistworkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFAssistWork" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfassistworks")
    @Transactional
    public ResponseEntity<WFAssistWorkDTO> create(@RequestBody WFAssistWorkDTO wfassistworkdto) {
        WFAssistWork domain = wfassistworkMapping.toDomain(wfassistworkdto);
		wfassistworkService.create(domain);
        WFAssistWorkDTO dto = wfassistworkMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFAssistWork" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfassistworks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFAssistWorkDTO> wfassistworkdtos) {
        wfassistworkService.createBatch(wfassistworkMapping.toDomain(wfassistworkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfassistwork_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFAssistWork" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfassistworks/{wfassistwork_id}")
    public ResponseEntity<WFAssistWorkDTO> get(@PathVariable("wfassistwork_id") String wfassistwork_id) {
        WFAssistWork domain = wfassistworkService.get(wfassistwork_id);
        WFAssistWorkDTO dto = wfassistworkMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFAssistWork" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfassistworks/getdraft")
    public ResponseEntity<WFAssistWorkDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfassistworkMapping.toDto(wfassistworkService.getDraft(new WFAssistWork())));
    }




    @PreAuthorize("hasPermission('Remove',{#wfassistwork_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFAssistWork" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfassistworks/{wfassistwork_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfassistwork_id") String wfassistwork_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfassistworkService.remove(wfassistwork_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFAssistWork" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfassistworks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfassistworkService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFAssistWork" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfassistworks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFAssistWorkDTO wfassistworkdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfassistworkService.checkKey(wfassistworkMapping.toDomain(wfassistworkdto)));
    }




    @ApiOperation(value = "Save", tags = {"WFAssistWork" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfassistworks/save")
    public ResponseEntity<Boolean> save(@RequestBody WFAssistWorkDTO wfassistworkdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfassistworkService.save(wfassistworkMapping.toDomain(wfassistworkdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFAssistWork" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfassistworks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFAssistWorkDTO> wfassistworkdtos) {
        wfassistworkService.saveBatch(wfassistworkMapping.toDomain(wfassistworkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'CurUserAssistWork',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前用户代办工作", tags = {"WFAssistWork" } ,notes = "fetch当前用户代办工作")
    @RequestMapping(method= RequestMethod.GET , value="/wfassistworks/fetchcuruserassistwork")
	public ResponseEntity<List<WFAssistWorkDTO>> fetchCurUserAssistWork(WFAssistWorkSearchContext context) {
        Page<WFAssistWork> domains = wfassistworkService.searchCurUserAssistWork(context) ;
        List<WFAssistWorkDTO> list = wfassistworkMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurUserAssistWork',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前用户代办工作", tags = {"WFAssistWork" } ,notes = "search当前用户代办工作")
    @RequestMapping(method= RequestMethod.GET , value="/wfassistworks/searchcuruserassistwork")
	public ResponseEntity<Page<WFAssistWorkDTO>> searchCurUserAssistWork(WFAssistWorkSearchContext context) {
        Page<WFAssistWork> domains = wfassistworkService.searchCurUserAssistWork(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfassistworkMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFAssistWork" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfassistworks/fetchdefault")
	public ResponseEntity<List<WFAssistWorkDTO>> fetchDefault(WFAssistWorkSearchContext context) {
        Page<WFAssistWork> domains = wfassistworkService.searchDefault(context) ;
        List<WFAssistWorkDTO> list = wfassistworkMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFAssistWork" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfassistworks/searchdefault")
	public ResponseEntity<Page<WFAssistWorkDTO>> searchDefault(WFAssistWorkSearchContext context) {
        Page<WFAssistWork> domains = wfassistworkService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfassistworkMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFAssistWork getEntity(){
        return new WFAssistWork();
    }

}