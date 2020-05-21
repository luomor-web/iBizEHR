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
import cn.ibizlab.ehr.core.par.domain.PARJXLHMB;
import cn.ibizlab.ehr.core.par.service.IPARJXLHMBService;
import cn.ibizlab.ehr.core.par.filter.PARJXLHMBSearchContext;




@Slf4j
@Api(tags = {"PARJXLHMB" })
@RestController("WebApi-parjxlhmb")
@RequestMapping("")
public class PARJXLHMBResource {

    @Autowired
    private IPARJXLHMBService parjxlhmbService;

    @Autowired
    @Lazy
    public PARJXLHMBMapping parjxlhmbMapping;

    public PARJXLHMBDTO permissionDTO=new PARJXLHMBDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXLHMB-Save-all')")
    @ApiOperation(value = "Save", tags = {"PARJXLHMB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXLHMBDTO parjxlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.save(parjxlhmbMapping.toDomain(parjxlhmbdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJXLHMB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXLHMBDTO> parjxlhmbdtos) {
        parjxlhmbService.saveBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXLHMB-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXLHMB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxlhmbs/getdraft")
    public ResponseEntity<PARJXLHMBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbMapping.toDto(parjxlhmbService.getDraft(new PARJXLHMB())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXLHMB-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXLHMB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXLHMBDTO parjxlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.checkKey(parjxlhmbMapping.toDomain(parjxlhmbdto)));
    }




    @PreAuthorize("hasPermission(#parjxlhmb_id,'Get',{'Sql',this.parjxlhmbMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXLHMB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxlhmbs/{parjxlhmb_id}")
    public ResponseEntity<PARJXLHMBDTO> get(@PathVariable("parjxlhmb_id") String parjxlhmb_id) {
        PARJXLHMB domain = parjxlhmbService.get(parjxlhmb_id);
        PARJXLHMBDTO dto = parjxlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#parjxlhmb_id,'Update',{'Sql',this.parjxlhmbMapping,#parjxlhmbdto})")
    @ApiOperation(value = "Update", tags = {"PARJXLHMB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxlhmbs/{parjxlhmb_id}")
    @Transactional
    public ResponseEntity<PARJXLHMBDTO> update(@PathVariable("parjxlhmb_id") String parjxlhmb_id, @RequestBody PARJXLHMBDTO parjxlhmbdto) {
		PARJXLHMB domain = parjxlhmbMapping.toDomain(parjxlhmbdto);
        domain.setParjxlhmbid(parjxlhmb_id);
		parjxlhmbService.update(domain);
		PARJXLHMBDTO dto = parjxlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PARJXLHMB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXLHMBDTO> parjxlhmbdtos) {
        parjxlhmbService.updateBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxlhmb_id,'Remove',{'Sql',this.parjxlhmbMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXLHMB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxlhmbs/{parjxlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxlhmb_id") String parjxlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.remove(parjxlhmb_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJXLHMB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxlhmbMapping,#parjxlhmbdto})")
    @ApiOperation(value = "Create", tags = {"PARJXLHMB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs")
    @Transactional
    public ResponseEntity<PARJXLHMBDTO> create(@RequestBody PARJXLHMBDTO parjxlhmbdto) {
        PARJXLHMB domain = parjxlhmbMapping.toDomain(parjxlhmbdto);
		parjxlhmbService.create(domain);
        PARJXLHMBDTO dto = parjxlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PARJXLHMB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXLHMBDTO> parjxlhmbdtos) {
        parjxlhmbService.createBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXLHMB-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXLHMB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxlhmbs/fetchdefault")
	public ResponseEntity<List<PARJXLHMBDTO>> fetchDefault(PARJXLHMBSearchContext context) {
        Page<PARJXLHMB> domains = parjxlhmbService.searchDefault(context) ;
        List<PARJXLHMBDTO> list = parjxlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXLHMB-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXLHMB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxlhmbs/searchdefault")
	public ResponseEntity<Page<PARJXLHMBDTO>> searchDefault(@RequestBody PARJXLHMBSearchContext context) {
        Page<PARJXLHMB> domains = parjxlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


