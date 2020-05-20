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
import cn.ibizlab.ehr.core.pim.domain.AppCenter;
import cn.ibizlab.ehr.core.pim.service.IAppCenterService;
import cn.ibizlab.ehr.core.pim.filter.AppCenterSearchContext;




@Slf4j
@Api(tags = {"AppCenter" })
@RestController("WebApi-appcenter")
@RequestMapping("")
public class AppCenterResource {

    @Autowired
    private IAppCenterService appcenterService;

    @Autowired
    @Lazy
    private AppCenterMapping appcenterMapping;




    @ApiOperation(value = "Save", tags = {"AppCenter" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/appcenters/save")
    public ResponseEntity<Boolean> save(@RequestBody AppCenterDTO appcenterdto) {
        return ResponseEntity.status(HttpStatus.OK).body(appcenterService.save(appcenterMapping.toDomain(appcenterdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"AppCenter" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/appcenters/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AppCenterDTO> appcenterdtos) {
        appcenterService.saveBatch(appcenterMapping.toDomain(appcenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"AppCenter" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/appcenters")
    @Transactional
    public ResponseEntity<AppCenterDTO> create(@RequestBody AppCenterDTO appcenterdto) {
        AppCenter domain = appcenterMapping.toDomain(appcenterdto);
		appcenterService.create(domain);
        AppCenterDTO dto = appcenterMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"AppCenter" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/appcenters/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AppCenterDTO> appcenterdtos) {
        appcenterService.createBatch(appcenterMapping.toDomain(appcenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#appcenter_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"AppCenter" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/appcenters/{appcenter_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("appcenter_id") String appcenter_id) {
         return ResponseEntity.status(HttpStatus.OK).body(appcenterService.remove(appcenter_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"AppCenter" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/appcenters/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        appcenterService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#appcenter_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"AppCenter" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/appcenters/{appcenter_id}")
    @Transactional
    public ResponseEntity<AppCenterDTO> update(@PathVariable("appcenter_id") String appcenter_id, @RequestBody AppCenterDTO appcenterdto) {
		AppCenter domain = appcenterMapping.toDomain(appcenterdto);
        domain.setAppcenterid(appcenter_id);
		appcenterService.update(domain);
		AppCenterDTO dto = appcenterMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#appcenter_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"AppCenter" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/appcenters/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AppCenterDTO> appcenterdtos) {
        appcenterService.updateBatch(appcenterMapping.toDomain(appcenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"AppCenter" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/appcenters/getdraft")
    public ResponseEntity<AppCenterDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(appcenterMapping.toDto(appcenterService.getDraft(new AppCenter())));
    }




    @PreAuthorize("hasPermission(#appcenter_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"AppCenter" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/appcenters/{appcenter_id}")
    public ResponseEntity<AppCenterDTO> get(@PathVariable("appcenter_id") String appcenter_id) {
        AppCenter domain = appcenterService.get(appcenter_id);
        AppCenterDTO dto = appcenterMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"AppCenter" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/appcenters/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AppCenterDTO appcenterdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(appcenterService.checkKey(appcenterMapping.toDomain(appcenterdto)));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"AppCenter" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/appcenters/fetchdefault")
	public ResponseEntity<List<AppCenterDTO>> fetchDefault(AppCenterSearchContext context) {
        Page<AppCenter> domains = appcenterService.searchDefault(context) ;
        List<AppCenterDTO> list = appcenterMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"AppCenter" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/appcenters/searchdefault")
	public ResponseEntity<Page<AppCenterDTO>> searchDefault(@RequestBody AppCenterSearchContext context) {
        Page<AppCenter> domains = appcenterService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(appcenterMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public AppCenter getEntity(){
        return new AppCenter();
    }

}
