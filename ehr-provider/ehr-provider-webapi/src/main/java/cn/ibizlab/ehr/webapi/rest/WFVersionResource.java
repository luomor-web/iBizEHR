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
import cn.ibizlab.ehr.core.wf.domain.WFVersion;
import cn.ibizlab.ehr.core.wf.service.IWFVersionService;
import cn.ibizlab.ehr.core.wf.filter.WFVersionSearchContext;




@Slf4j
@Api(tags = {"WFVersion" })
@RestController("WebApi-wfversion")
@RequestMapping("")
public class WFVersionResource {

    @Autowired
    private IWFVersionService wfversionService;

    @Autowired
    @Lazy
    private WFVersionMapping wfversionMapping;




    @PreAuthorize("hasPermission(#wfversion_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFVersion" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfversions/{wfversion_id}")
    public ResponseEntity<WFVersionDTO> get(@PathVariable("wfversion_id") String wfversion_id) {
        WFVersion domain = wfversionService.get(wfversion_id);
        WFVersionDTO dto = wfversionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFVersion" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfversions")
    @Transactional
    public ResponseEntity<WFVersionDTO> create(@RequestBody WFVersionDTO wfversiondto) {
        WFVersion domain = wfversionMapping.toDomain(wfversiondto);
		wfversionService.create(domain);
        WFVersionDTO dto = wfversionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFVersion" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfversions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFVersionDTO> wfversiondtos) {
        wfversionService.createBatch(wfversionMapping.toDomain(wfversiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFVersion" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfversions/save")
    public ResponseEntity<Boolean> save(@RequestBody WFVersionDTO wfversiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfversionService.save(wfversionMapping.toDomain(wfversiondto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFVersion" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfversions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFVersionDTO> wfversiondtos) {
        wfversionService.saveBatch(wfversionMapping.toDomain(wfversiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFVersion" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfversions/getdraft")
    public ResponseEntity<WFVersionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfversionMapping.toDto(wfversionService.getDraft(new WFVersion())));
    }




    @PreAuthorize("hasPermission(#wfversion_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFVersion" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfversions/{wfversion_id}")
    @Transactional
    public ResponseEntity<WFVersionDTO> update(@PathVariable("wfversion_id") String wfversion_id, @RequestBody WFVersionDTO wfversiondto) {
		WFVersion domain = wfversionMapping.toDomain(wfversiondto);
        domain.setWfversionid(wfversion_id);
		wfversionService.update(domain);
		WFVersionDTO dto = wfversionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfversion_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFVersion" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfversions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFVersionDTO> wfversiondtos) {
        wfversionService.updateBatch(wfversionMapping.toDomain(wfversiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#wfversion_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFVersion" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfversions/{wfversion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfversion_id") String wfversion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfversionService.remove(wfversion_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFVersion" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfversions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfversionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFVersion" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfversions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFVersionDTO wfversiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfversionService.checkKey(wfversionMapping.toDomain(wfversiondto)));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"WFVersion" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfversions/fetchdefault")
	public ResponseEntity<List<WFVersionDTO>> fetchDefault(WFVersionSearchContext context) {
        Page<WFVersion> domains = wfversionService.searchDefault(context) ;
        List<WFVersionDTO> list = wfversionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WFVersion" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfversions/searchdefault")
	public ResponseEntity<Page<WFVersionDTO>> searchDefault(@RequestBody WFVersionSearchContext context) {
        Page<WFVersion> domains = wfversionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfversionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFVersion getEntity(){
        return new WFVersion();
    }

}
