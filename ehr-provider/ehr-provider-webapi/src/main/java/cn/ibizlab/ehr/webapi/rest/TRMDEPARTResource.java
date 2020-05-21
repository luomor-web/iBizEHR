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
import cn.ibizlab.ehr.core.trm.domain.TRMDEPART;
import cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService;
import cn.ibizlab.ehr.core.trm.filter.TRMDEPARTSearchContext;




@Slf4j
@Api(tags = {"TRMDEPART" })
@RestController("WebApi-trmdepart")
@RequestMapping("")
public class TRMDEPARTResource {

    @Autowired
    private ITRMDEPARTService trmdepartService;

    @Autowired
    @Lazy
    public TRMDEPARTMapping trmdepartMapping;

    public TRMDEPARTDTO permissionDTO=new TRMDEPARTDTO();




    @PreAuthorize("hasPermission(#trmdepart_id,'Get',{'Sql',this.trmdepartMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMDEPART" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}")
    public ResponseEntity<TRMDEPARTDTO> get(@PathVariable("trmdepart_id") String trmdepart_id) {
        TRMDEPART domain = trmdepartService.get(trmdepart_id);
        TRMDEPARTDTO dto = trmdepartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPART-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMDEPART" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMDEPARTDTO trmdepartdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartService.save(trmdepartMapping.toDomain(trmdepartdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMDEPART" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMDEPARTDTO> trmdepartdtos) {
        trmdepartService.saveBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmdepartMapping,#trmdepartdto})")
    @ApiOperation(value = "Create", tags = {"TRMDEPART" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts")
    @Transactional
    public ResponseEntity<TRMDEPARTDTO> create(@RequestBody TRMDEPARTDTO trmdepartdto) {
        TRMDEPART domain = trmdepartMapping.toDomain(trmdepartdto);
		trmdepartService.create(domain);
        TRMDEPARTDTO dto = trmdepartMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"TRMDEPART" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMDEPARTDTO> trmdepartdtos) {
        trmdepartService.createBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmdepart_id,'Remove',{'Sql',this.trmdepartMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMDEPART" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdepart_id") String trmdepart_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdepartService.remove(trmdepart_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMDEPART" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdepartService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPART-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMDEPART" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMDEPARTDTO trmdepartdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdepartService.checkKey(trmdepartMapping.toDomain(trmdepartdto)));
    }




    @PreAuthorize("hasPermission(#trmdepart_id,'Update',{'Sql',this.trmdepartMapping,#trmdepartdto})")
    @ApiOperation(value = "Update", tags = {"TRMDEPART" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}")
    @Transactional
    public ResponseEntity<TRMDEPARTDTO> update(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMDEPARTDTO trmdepartdto) {
		TRMDEPART domain = trmdepartMapping.toDomain(trmdepartdto);
        domain.setTrmdepartid(trmdepart_id);
		trmdepartService.update(domain);
		TRMDEPARTDTO dto = trmdepartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"TRMDEPART" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMDEPARTDTO> trmdepartdtos) {
        trmdepartService.updateBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPART-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMDEPART" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/getdraft")
    public ResponseEntity<TRMDEPARTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartMapping.toDto(trmdepartService.getDraft(new TRMDEPART())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPART-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMDEPART" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/fetchdefault")
	public ResponseEntity<List<TRMDEPARTDTO>> fetchDefault(TRMDEPARTSearchContext context) {
        Page<TRMDEPART> domains = trmdepartService.searchDefault(context) ;
        List<TRMDEPARTDTO> list = trmdepartMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPART-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMDEPART" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/searchdefault")
	public ResponseEntity<Page<TRMDEPARTDTO>> searchDefault(@RequestBody TRMDEPARTSearchContext context) {
        Page<TRMDEPART> domains = trmdepartService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdepartMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


