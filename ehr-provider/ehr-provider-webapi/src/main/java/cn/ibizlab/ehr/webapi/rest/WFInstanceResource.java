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
import cn.ibizlab.ehr.core.wf.domain.WFInstance;
import cn.ibizlab.ehr.core.wf.service.IWFInstanceService;
import cn.ibizlab.ehr.core.wf.filter.WFInstanceSearchContext;




@Slf4j
@Api(tags = {"WFInstance" })
@RestController("WebApi-wfinstance")
@RequestMapping("")
public class WFInstanceResource {

    @Autowired
    private IWFInstanceService wfinstanceService;

    @Autowired
    @Lazy
    private WFInstanceMapping wfinstanceMapping;




    @PreAuthorize("hasPermission('Remove',{#wfinstance_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFInstance" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfinstances/{wfinstance_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfinstance_id") String wfinstance_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfinstanceService.remove(wfinstance_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFInstance" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfinstances/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfinstanceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFInstance" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfinstances/getdraft")
    public ResponseEntity<WFInstanceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfinstanceMapping.toDto(wfinstanceService.getDraft(new WFInstance())));
    }




    @ApiOperation(value = "Save", tags = {"WFInstance" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/save")
    public ResponseEntity<Boolean> save(@RequestBody WFInstanceDTO wfinstancedto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfinstanceService.save(wfinstanceMapping.toDomain(wfinstancedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFInstance" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFInstanceDTO> wfinstancedtos) {
        wfinstanceService.saveBatch(wfinstanceMapping.toDomain(wfinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFInstance" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances")
    @Transactional
    public ResponseEntity<WFInstanceDTO> create(@RequestBody WFInstanceDTO wfinstancedto) {
        WFInstance domain = wfinstanceMapping.toDomain(wfinstancedto);
		wfinstanceService.create(domain);
        WFInstanceDTO dto = wfinstanceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFInstance" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFInstanceDTO> wfinstancedtos) {
        wfinstanceService.createBatch(wfinstanceMapping.toDomain(wfinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfinstance_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFInstance" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfinstances/{wfinstance_id}")
    public ResponseEntity<WFInstanceDTO> get(@PathVariable("wfinstance_id") String wfinstance_id) {
        WFInstance domain = wfinstanceService.get(wfinstance_id);
        WFInstanceDTO dto = wfinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfinstance_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFInstance" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfinstances/{wfinstance_id}")
    @Transactional
    public ResponseEntity<WFInstanceDTO> update(@PathVariable("wfinstance_id") String wfinstance_id, @RequestBody WFInstanceDTO wfinstancedto) {
		WFInstance domain = wfinstanceMapping.toDomain(wfinstancedto);
        domain.setWfinstanceid(wfinstance_id);
		wfinstanceService.update(domain);
		WFInstanceDTO dto = wfinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfinstance_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFInstance" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfinstances/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFInstanceDTO> wfinstancedtos) {
        wfinstanceService.updateBatch(wfinstanceMapping.toDomain(wfinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFInstance" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFInstanceDTO wfinstancedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfinstanceService.checkKey(wfinstanceMapping.toDomain(wfinstancedto)));
    }




    @ApiOperation(value = "重新启动", tags = {"WFInstance" },  notes = "重新启动")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/{wfinstance_id}/restart")
    @Transactional
    public ResponseEntity<WFInstanceDTO> restart(@PathVariable("wfinstance_id") String wfinstance_id, @RequestBody WFInstanceDTO wfinstancedto) {
        WFInstance wfinstance = wfinstanceMapping.toDomain(wfinstancedto);
        wfinstance = wfinstanceService.restart(wfinstance);
        wfinstancedto = wfinstanceMapping.toDto(wfinstance);
        return ResponseEntity.status(HttpStatus.OK).body(wfinstancedto);
    }




    @ApiOperation(value = "取消流程", tags = {"WFInstance" },  notes = "取消流程")
	@RequestMapping(method = RequestMethod.POST, value = "/wfinstances/{wfinstance_id}/usercancel")
    @Transactional
    public ResponseEntity<WFInstanceDTO> userCancel(@PathVariable("wfinstance_id") String wfinstance_id, @RequestBody WFInstanceDTO wfinstancedto) {
        WFInstance wfinstance = wfinstanceMapping.toDomain(wfinstancedto);
        wfinstance = wfinstanceService.userCancel(wfinstance);
        wfinstancedto = wfinstanceMapping.toDto(wfinstance);
        return ResponseEntity.status(HttpStatus.OK).body(wfinstancedto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFInstance" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfinstances/fetchdefault")
	public ResponseEntity<List<WFInstanceDTO>> fetchDefault(WFInstanceSearchContext context) {
        Page<WFInstance> domains = wfinstanceService.searchDefault(context) ;
        List<WFInstanceDTO> list = wfinstanceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFInstance" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfinstances/searchdefault")
	public ResponseEntity<Page<WFInstanceDTO>> searchDefault(WFInstanceSearchContext context) {
        Page<WFInstance> domains = wfinstanceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfinstanceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFInstance getEntity(){
        return new WFInstance();
    }

}
