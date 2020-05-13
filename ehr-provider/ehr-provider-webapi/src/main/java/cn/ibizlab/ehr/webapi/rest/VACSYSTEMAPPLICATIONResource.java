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
import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMAPPLICATION;
import cn.ibizlab.ehr.core.vac.service.IVACSYSTEMAPPLICATIONService;
import cn.ibizlab.ehr.core.vac.filter.VACSYSTEMAPPLICATIONSearchContext;




@Slf4j
@Api(tags = {"VACSYSTEMAPPLICATION" })
@RestController("WebApi-vacsystemapplication")
@RequestMapping("")
public class VACSYSTEMAPPLICATIONResource {

    @Autowired
    private IVACSYSTEMAPPLICATIONService vacsystemapplicationService;

    @Autowired
    @Lazy
    private VACSYSTEMAPPLICATIONMapping vacsystemapplicationMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACSYSTEMAPPLICATION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications")
    @Transactional
    public ResponseEntity<VACSYSTEMAPPLICATIONDTO> create(@RequestBody VACSYSTEMAPPLICATIONDTO vacsystemapplicationdto) {
        VACSYSTEMAPPLICATION domain = vacsystemapplicationMapping.toDomain(vacsystemapplicationdto);
		vacsystemapplicationService.create(domain);
        VACSYSTEMAPPLICATIONDTO dto = vacsystemapplicationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACSYSTEMAPPLICATION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSYSTEMAPPLICATIONDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.createBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#vacsystemapplication_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACSYSTEMAPPLICATION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemapplications/{vacsystemapplication_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.remove(vacsystemapplication_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACSYSTEMAPPLICATION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsystemapplicationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacsystemapplication_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACSYSTEMAPPLICATION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemapplications/{vacsystemapplication_id}")
    @Transactional
    public ResponseEntity<VACSYSTEMAPPLICATIONDTO> update(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id, @RequestBody VACSYSTEMAPPLICATIONDTO vacsystemapplicationdto) {
		VACSYSTEMAPPLICATION domain = vacsystemapplicationMapping.toDomain(vacsystemapplicationdto);
        domain.setVacsystemapplicationid(vacsystemapplication_id);
		vacsystemapplicationService.update(domain);
		VACSYSTEMAPPLICATIONDTO dto = vacsystemapplicationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacsystemapplication_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACSYSTEMAPPLICATION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSYSTEMAPPLICATIONDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.updateBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacsystemapplication_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACSYSTEMAPPLICATION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemapplications/{vacsystemapplication_id}")
    public ResponseEntity<VACSYSTEMAPPLICATIONDTO> get(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id) {
        VACSYSTEMAPPLICATION domain = vacsystemapplicationService.get(vacsystemapplication_id);
        VACSYSTEMAPPLICATIONDTO dto = vacsystemapplicationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"VACSYSTEMAPPLICATION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSYSTEMAPPLICATIONDTO vacsystemapplicationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.save(vacsystemapplicationMapping.toDomain(vacsystemapplicationdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACSYSTEMAPPLICATION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSYSTEMAPPLICATIONDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.saveBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"VACSYSTEMAPPLICATION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemapplications/getdraft")
    public ResponseEntity<VACSYSTEMAPPLICATIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationMapping.toDto(vacsystemapplicationService.getDraft(new VACSYSTEMAPPLICATION())));
    }




    @ApiOperation(value = "CheckKey", tags = {"VACSYSTEMAPPLICATION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSYSTEMAPPLICATIONDTO vacsystemapplicationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.checkKey(vacsystemapplicationMapping.toDomain(vacsystemapplicationdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACSYSTEMAPPLICATION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsystemapplications/fetchdefault")
	public ResponseEntity<List<VACSYSTEMAPPLICATIONDTO>> fetchDefault(VACSYSTEMAPPLICATIONSearchContext context) {
        Page<VACSYSTEMAPPLICATION> domains = vacsystemapplicationService.searchDefault(context) ;
        List<VACSYSTEMAPPLICATIONDTO> list = vacsystemapplicationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACSYSTEMAPPLICATION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsystemapplications/searchdefault")
	public ResponseEntity<Page<VACSYSTEMAPPLICATIONDTO>> searchDefault(VACSYSTEMAPPLICATIONSearchContext context) {
        Page<VACSYSTEMAPPLICATION> domains = vacsystemapplicationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsystemapplicationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACSYSTEMAPPLICATION getEntity(){
        return new VACSYSTEMAPPLICATION();
    }

}