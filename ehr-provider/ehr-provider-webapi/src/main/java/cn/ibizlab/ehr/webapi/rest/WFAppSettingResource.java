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
import cn.ibizlab.ehr.core.wf.domain.WFAppSetting;
import cn.ibizlab.ehr.core.wf.service.IWFAppSettingService;
import cn.ibizlab.ehr.core.wf.filter.WFAppSettingSearchContext;




@Slf4j
@Api(tags = {"WFAppSetting" })
@RestController("WebApi-wfappsetting")
@RequestMapping("")
public class WFAppSettingResource {

    @Autowired
    private IWFAppSettingService wfappsettingService;

    @Autowired
    @Lazy
    private WFAppSettingMapping wfappsettingMapping;




    @PreAuthorize("hasPermission('Remove',{#wfappsetting_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFAppSetting" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfappsettings/{wfappsetting_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfappsetting_id") String wfappsetting_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfappsettingService.remove(wfappsetting_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFAppSetting" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfappsettings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfappsettingService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfappsetting_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFAppSetting" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfappsettings/{wfappsetting_id}")
    @Transactional
    public ResponseEntity<WFAppSettingDTO> update(@PathVariable("wfappsetting_id") String wfappsetting_id, @RequestBody WFAppSettingDTO wfappsettingdto) {
		WFAppSetting domain = wfappsettingMapping.toDomain(wfappsettingdto);
        domain.setWfappsettingid(wfappsetting_id);
		wfappsettingService.update(domain);
		WFAppSettingDTO dto = wfappsettingMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfappsetting_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFAppSetting" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfappsettings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFAppSettingDTO> wfappsettingdtos) {
        wfappsettingService.updateBatch(wfappsettingMapping.toDomain(wfappsettingdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFAppSetting" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfappsettings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFAppSettingDTO wfappsettingdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfappsettingService.checkKey(wfappsettingMapping.toDomain(wfappsettingdto)));
    }




    @ApiOperation(value = "Save", tags = {"WFAppSetting" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfappsettings/save")
    public ResponseEntity<Boolean> save(@RequestBody WFAppSettingDTO wfappsettingdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfappsettingService.save(wfappsettingMapping.toDomain(wfappsettingdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFAppSetting" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfappsettings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFAppSettingDTO> wfappsettingdtos) {
        wfappsettingService.saveBatch(wfappsettingMapping.toDomain(wfappsettingdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFAppSetting" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfappsettings/getdraft")
    public ResponseEntity<WFAppSettingDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfappsettingMapping.toDto(wfappsettingService.getDraft(new WFAppSetting())));
    }




    @PreAuthorize("hasPermission(#wfappsetting_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFAppSetting" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfappsettings/{wfappsetting_id}")
    public ResponseEntity<WFAppSettingDTO> get(@PathVariable("wfappsetting_id") String wfappsetting_id) {
        WFAppSetting domain = wfappsettingService.get(wfappsetting_id);
        WFAppSettingDTO dto = wfappsettingMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFAppSetting" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfappsettings")
    @Transactional
    public ResponseEntity<WFAppSettingDTO> create(@RequestBody WFAppSettingDTO wfappsettingdto) {
        WFAppSetting domain = wfappsettingMapping.toDomain(wfappsettingdto);
		wfappsettingService.create(domain);
        WFAppSettingDTO dto = wfappsettingMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFAppSetting" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfappsettings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFAppSettingDTO> wfappsettingdtos) {
        wfappsettingService.createBatch(wfappsettingMapping.toDomain(wfappsettingdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"WFAppSetting" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfappsettings/fetchdefault")
	public ResponseEntity<List<WFAppSettingDTO>> fetchDefault(WFAppSettingSearchContext context) {
        Page<WFAppSetting> domains = wfappsettingService.searchDefault(context) ;
        List<WFAppSettingDTO> list = wfappsettingMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WFAppSetting" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfappsettings/searchdefault")
	public ResponseEntity<Page<WFAppSettingDTO>> searchDefault(@RequestBody WFAppSettingSearchContext context) {
        Page<WFAppSetting> domains = wfappsettingService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfappsettingMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFAppSetting getEntity(){
        return new WFAppSetting();
    }

}
