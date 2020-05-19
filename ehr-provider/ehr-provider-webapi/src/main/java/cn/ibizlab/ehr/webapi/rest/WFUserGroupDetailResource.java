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
import cn.ibizlab.ehr.core.wf.domain.WFUserGroupDetail;
import cn.ibizlab.ehr.core.wf.service.IWFUserGroupDetailService;
import cn.ibizlab.ehr.core.wf.filter.WFUserGroupDetailSearchContext;




@Slf4j
@Api(tags = {"WFUserGroupDetail" })
@RestController("WebApi-wfusergroupdetail")
@RequestMapping("")
public class WFUserGroupDetailResource {

    @Autowired
    private IWFUserGroupDetailService wfusergroupdetailService;

    @Autowired
    @Lazy
    private WFUserGroupDetailMapping wfusergroupdetailMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFUserGroupDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroupdetails")
    @Transactional
    public ResponseEntity<WFUserGroupDetailDTO> create(@RequestBody WFUserGroupDetailDTO wfusergroupdetaildto) {
        WFUserGroupDetail domain = wfusergroupdetailMapping.toDomain(wfusergroupdetaildto);
		wfusergroupdetailService.create(domain);
        WFUserGroupDetailDTO dto = wfusergroupdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFUserGroupDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroupdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserGroupDetailDTO> wfusergroupdetaildtos) {
        wfusergroupdetailService.createBatch(wfusergroupdetailMapping.toDomain(wfusergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFUserGroupDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusergroupdetails/getdraft")
    public ResponseEntity<WFUserGroupDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfusergroupdetailMapping.toDto(wfusergroupdetailService.getDraft(new WFUserGroupDetail())));
    }




    @PreAuthorize("hasPermission(#wfusergroupdetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFUserGroupDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusergroupdetails/{wfusergroupdetail_id}")
    public ResponseEntity<WFUserGroupDetailDTO> get(@PathVariable("wfusergroupdetail_id") String wfusergroupdetail_id) {
        WFUserGroupDetail domain = wfusergroupdetailService.get(wfusergroupdetail_id);
        WFUserGroupDetailDTO dto = wfusergroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WFUserGroupDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroupdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserGroupDetailDTO wfusergroupdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfusergroupdetailService.save(wfusergroupdetailMapping.toDomain(wfusergroupdetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFUserGroupDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroupdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserGroupDetailDTO> wfusergroupdetaildtos) {
        wfusergroupdetailService.saveBatch(wfusergroupdetailMapping.toDomain(wfusergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfusergroupdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFUserGroupDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusergroupdetails/{wfusergroupdetail_id}")
    @Transactional
    public ResponseEntity<WFUserGroupDetailDTO> update(@PathVariable("wfusergroupdetail_id") String wfusergroupdetail_id, @RequestBody WFUserGroupDetailDTO wfusergroupdetaildto) {
		WFUserGroupDetail domain = wfusergroupdetailMapping.toDomain(wfusergroupdetaildto);
        domain.setWfusergroupdetailid(wfusergroupdetail_id);
		wfusergroupdetailService.update(domain);
		WFUserGroupDetailDTO dto = wfusergroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfusergroupdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUserGroupDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusergroupdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserGroupDetailDTO> wfusergroupdetaildtos) {
        wfusergroupdetailService.updateBatch(wfusergroupdetailMapping.toDomain(wfusergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#wfusergroupdetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WFUserGroupDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusergroupdetails/{wfusergroupdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfusergroupdetail_id") String wfusergroupdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfusergroupdetailService.remove(wfusergroupdetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFUserGroupDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusergroupdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfusergroupdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFUserGroupDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroupdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserGroupDetailDTO wfusergroupdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfusergroupdetailService.checkKey(wfusergroupdetailMapping.toDomain(wfusergroupdetaildto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUserGroupDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusergroupdetails/fetchdefault")
	public ResponseEntity<List<WFUserGroupDetailDTO>> fetchDefault(WFUserGroupDetailSearchContext context) {
        Page<WFUserGroupDetail> domains = wfusergroupdetailService.searchDefault(context) ;
        List<WFUserGroupDetailDTO> list = wfusergroupdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUserGroupDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusergroupdetails/searchdefault")
	public ResponseEntity<Page<WFUserGroupDetailDTO>> searchDefault(WFUserGroupDetailSearchContext context) {
        Page<WFUserGroupDetail> domains = wfusergroupdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfusergroupdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFUserGroupDetail getEntity(){
        return new WFUserGroupDetail();
    }

}
