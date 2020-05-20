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
import cn.ibizlab.ehr.core.wf.domain.WFStepData;
import cn.ibizlab.ehr.core.wf.service.IWFStepDataService;
import cn.ibizlab.ehr.core.wf.filter.WFStepDataSearchContext;




@Slf4j
@Api(tags = {"WFStepData" })
@RestController("WebApi-wfstepdata")
@RequestMapping("")
public class WFStepDataResource {

    @Autowired
    private IWFStepDataService wfstepdataService;

    @Autowired
    @Lazy
    private WFStepDataMapping wfstepdataMapping;




    @ApiOperation(value = "GetDraft", tags = {"WFStepData" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepdata/getdraft")
    public ResponseEntity<WFStepDataDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepdataMapping.toDto(wfstepdataService.getDraft(new WFStepData())));
    }




    @ApiOperation(value = "CheckKey", tags = {"WFStepData" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFStepDataDTO wfstepdatadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfstepdataService.checkKey(wfstepdataMapping.toDomain(wfstepdatadto)));
    }




    @PreAuthorize("hasPermission('Remove',{#wfstepdata_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFStepData" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepdata/{wfstepdata_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfstepdata_id") String wfstepdata_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfstepdataService.remove(wfstepdata_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFStepData" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepdata/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfstepdataService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "回撤操作", tags = {"WFStepData" },  notes = "回撤操作")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata/{wfstepdata_id}/rollback")
    @Transactional
    public ResponseEntity<WFStepDataDTO> rollback(@PathVariable("wfstepdata_id") String wfstepdata_id, @RequestBody WFStepDataDTO wfstepdatadto) {
        WFStepData wfstepdata = wfstepdataMapping.toDomain(wfstepdatadto);
        wfstepdata = wfstepdataService.rollback(wfstepdata);
        wfstepdatadto = wfstepdataMapping.toDto(wfstepdata);
        return ResponseEntity.status(HttpStatus.OK).body(wfstepdatadto);
    }




    @PreAuthorize("hasPermission(#wfstepdata_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFStepData" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepdata/{wfstepdata_id}")
    public ResponseEntity<WFStepDataDTO> get(@PathVariable("wfstepdata_id") String wfstepdata_id) {
        WFStepData domain = wfstepdataService.get(wfstepdata_id);
        WFStepDataDTO dto = wfstepdataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFStepData" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata")
    @Transactional
    public ResponseEntity<WFStepDataDTO> create(@RequestBody WFStepDataDTO wfstepdatadto) {
        WFStepData domain = wfstepdataMapping.toDomain(wfstepdatadto);
		wfstepdataService.create(domain);
        WFStepDataDTO dto = wfstepdataMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFStepData" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFStepDataDTO> wfstepdatadtos) {
        wfstepdataService.createBatch(wfstepdataMapping.toDomain(wfstepdatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFStepData" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata/save")
    public ResponseEntity<Boolean> save(@RequestBody WFStepDataDTO wfstepdatadto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepdataService.save(wfstepdataMapping.toDomain(wfstepdatadto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFStepData" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepdata/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFStepDataDTO> wfstepdatadtos) {
        wfstepdataService.saveBatch(wfstepdataMapping.toDomain(wfstepdatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfstepdata_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFStepData" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepdata/{wfstepdata_id}")
    @Transactional
    public ResponseEntity<WFStepDataDTO> update(@PathVariable("wfstepdata_id") String wfstepdata_id, @RequestBody WFStepDataDTO wfstepdatadto) {
		WFStepData domain = wfstepdataMapping.toDomain(wfstepdatadto);
        domain.setWfstepdataid(wfstepdata_id);
		wfstepdataService.update(domain);
		WFStepDataDTO dto = wfstepdataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfstepdata_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFStepData" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepdata/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFStepDataDTO> wfstepdatadtos) {
        wfstepdataService.updateBatch(wfstepdataMapping.toDomain(wfstepdatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetch我的历史", tags = {"WFStepData" } ,notes = "fetch我的历史")
    @RequestMapping(method= RequestMethod.GET , value="/wfstepdata/fetchmyhist")
	public ResponseEntity<List<WFStepDataDTO>> fetchMyHist(WFStepDataSearchContext context) {
        Page<WFStepData> domains = wfstepdataService.searchMyHist(context) ;
        List<WFStepDataDTO> list = wfstepdataMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search我的历史", tags = {"WFStepData" } ,notes = "search我的历史")
    @RequestMapping(method= RequestMethod.POST , value="/wfstepdata/searchmyhist")
	public ResponseEntity<Page<WFStepDataDTO>> searchMyHist(@RequestBody WFStepDataSearchContext context) {
        Page<WFStepData> domains = wfstepdataService.searchMyHist(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfstepdataMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"WFStepData" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfstepdata/fetchdefault")
	public ResponseEntity<List<WFStepDataDTO>> fetchDefault(WFStepDataSearchContext context) {
        Page<WFStepData> domains = wfstepdataService.searchDefault(context) ;
        List<WFStepDataDTO> list = wfstepdataMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WFStepData" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfstepdata/searchdefault")
	public ResponseEntity<Page<WFStepDataDTO>> searchDefault(@RequestBody WFStepDataSearchContext context) {
        Page<WFStepData> domains = wfstepdataService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfstepdataMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFStepData getEntity(){
        return new WFStepData();
    }

}
