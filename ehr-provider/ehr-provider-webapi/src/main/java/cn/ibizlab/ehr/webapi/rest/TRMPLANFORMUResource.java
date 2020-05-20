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
import cn.ibizlab.ehr.core.trm.domain.TRMPLANFORMU;
import cn.ibizlab.ehr.core.trm.service.ITRMPLANFORMUService;
import cn.ibizlab.ehr.core.trm.filter.TRMPLANFORMUSearchContext;




@Slf4j
@Api(tags = {"TRMPLANFORMU" })
@RestController("WebApi-trmplanformu")
@RequestMapping("")
public class TRMPLANFORMUResource {

    @Autowired
    private ITRMPLANFORMUService trmplanformuService;

    @Autowired
    @Lazy
    private TRMPLANFORMUMapping trmplanformuMapping;




    @ApiOperation(value = "Save", tags = {"TRMPLANFORMU" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMPLANFORMUDTO trmplanformudto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.save(trmplanformuMapping.toDomain(trmplanformudto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMPLANFORMU" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMPLANFORMUDTO> trmplanformudtos) {
        trmplanformuService.saveBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmplanformu_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"TRMPLANFORMU" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmplanformus/{trmplanformu_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmplanformu_id") String trmplanformu_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.remove(trmplanformu_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMPLANFORMU" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmplanformuService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmplanformu_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMPLANFORMU" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmplanformus/{trmplanformu_id}")
    public ResponseEntity<TRMPLANFORMUDTO> get(@PathVariable("trmplanformu_id") String trmplanformu_id) {
        TRMPLANFORMU domain = trmplanformuService.get(trmplanformu_id);
        TRMPLANFORMUDTO dto = trmplanformuMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#trmplanformu_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMPLANFORMU" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmplanformus/{trmplanformu_id}")
    @Transactional
    public ResponseEntity<TRMPLANFORMUDTO> update(@PathVariable("trmplanformu_id") String trmplanformu_id, @RequestBody TRMPLANFORMUDTO trmplanformudto) {
		TRMPLANFORMU domain = trmplanformuMapping.toDomain(trmplanformudto);
        domain.setTrmplanformuid(trmplanformu_id);
		trmplanformuService.update(domain);
		TRMPLANFORMUDTO dto = trmplanformuMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmplanformu_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMPLANFORMU" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMPLANFORMUDTO> trmplanformudtos) {
        trmplanformuService.updateBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMPLANFORMU" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus")
    @Transactional
    public ResponseEntity<TRMPLANFORMUDTO> create(@RequestBody TRMPLANFORMUDTO trmplanformudto) {
        TRMPLANFORMU domain = trmplanformuMapping.toDomain(trmplanformudto);
		trmplanformuService.create(domain);
        TRMPLANFORMUDTO dto = trmplanformuMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMPLANFORMU" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMPLANFORMUDTO> trmplanformudtos) {
        trmplanformuService.createBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMPLANFORMU" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmplanformus/getdraft")
    public ResponseEntity<TRMPLANFORMUDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmplanformuMapping.toDto(trmplanformuService.getDraft(new TRMPLANFORMU())));
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMPLANFORMU" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMPLANFORMUDTO trmplanformudto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.checkKey(trmplanformuMapping.toDomain(trmplanformudto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMPLANFORMU-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMPLANFORMU" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmplanformus/fetchdefault")
	public ResponseEntity<List<TRMPLANFORMUDTO>> fetchDefault(TRMPLANFORMUSearchContext context) {
        Page<TRMPLANFORMU> domains = trmplanformuService.searchDefault(context) ;
        List<TRMPLANFORMUDTO> list = trmplanformuMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMPLANFORMU-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMPLANFORMU" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmplanformus/searchdefault")
	public ResponseEntity<Page<TRMPLANFORMUDTO>> searchDefault(@RequestBody TRMPLANFORMUSearchContext context) {
        Page<TRMPLANFORMU> domains = trmplanformuService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmplanformuMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMPLANFORMU getEntity(){
        return new TRMPLANFORMU();
    }

}
