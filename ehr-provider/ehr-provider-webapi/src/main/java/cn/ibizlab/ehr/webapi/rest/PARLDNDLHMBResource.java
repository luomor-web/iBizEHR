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
import cn.ibizlab.ehr.core.par.domain.PARLDNDLHMB;
import cn.ibizlab.ehr.core.par.service.IPARLDNDLHMBService;
import cn.ibizlab.ehr.core.par.filter.PARLDNDLHMBSearchContext;




@Slf4j
@Api(tags = {"PARLDNDLHMB" })
@RestController("WebApi-parldndlhmb")
@RequestMapping("")
public class PARLDNDLHMBResource {

    @Autowired
    private IPARLDNDLHMBService parldndlhmbService;

    @Autowired
    @Lazy
    private PARLDNDLHMBMapping parldndlhmbMapping;




    @ApiOperation(value = "Save", tags = {"PARLDNDLHMB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLDNDLHMBDTO parldndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.save(parldndlhmbMapping.toDomain(parldndlhmbdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARLDNDLHMB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLDNDLHMBDTO> parldndlhmbdtos) {
        parldndlhmbService.saveBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARLDNDLHMB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/getdraft")
    public ResponseEntity<PARLDNDLHMBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbMapping.toDto(parldndlhmbService.getDraft(new PARLDNDLHMB())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PARLDNDLHMB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLDNDLHMBDTO parldndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.checkKey(parldndlhmbMapping.toDomain(parldndlhmbdto)));
    }




    @PreAuthorize("hasPermission(#parldndlhmb_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARLDNDLHMB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/{parldndlhmb_id}")
    public ResponseEntity<PARLDNDLHMBDTO> get(@PathVariable("parldndlhmb_id") String parldndlhmb_id) {
        PARLDNDLHMB domain = parldndlhmbService.get(parldndlhmb_id);
        PARLDNDLHMBDTO dto = parldndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARLDNDLHMB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs")
    @Transactional
    public ResponseEntity<PARLDNDLHMBDTO> create(@RequestBody PARLDNDLHMBDTO parldndlhmbdto) {
        PARLDNDLHMB domain = parldndlhmbMapping.toDomain(parldndlhmbdto);
		parldndlhmbService.create(domain);
        PARLDNDLHMBDTO dto = parldndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARLDNDLHMB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLDNDLHMBDTO> parldndlhmbdtos) {
        parldndlhmbService.createBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parldndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARLDNDLHMB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/{parldndlhmb_id}")
    @Transactional
    public ResponseEntity<PARLDNDLHMBDTO> update(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody PARLDNDLHMBDTO parldndlhmbdto) {
		PARLDNDLHMB domain = parldndlhmbMapping.toDomain(parldndlhmbdto);
        domain.setParldndlhmbid(parldndlhmb_id);
		parldndlhmbService.update(domain);
		PARLDNDLHMBDTO dto = parldndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parldndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARLDNDLHMB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLDNDLHMBDTO> parldndlhmbdtos) {
        parldndlhmbService.updateBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parldndlhmb_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARLDNDLHMB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/{parldndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldndlhmb_id") String parldndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.remove(parldndlhmb_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARLDNDLHMB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMB-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLDNDLHMB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldndlhmbs/fetchdefault")
	public ResponseEntity<List<PARLDNDLHMBDTO>> fetchDefault(PARLDNDLHMBSearchContext context) {
        Page<PARLDNDLHMB> domains = parldndlhmbService.searchDefault(context) ;
        List<PARLDNDLHMBDTO> list = parldndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMB-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARLDNDLHMB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldndlhmbs/searchdefault")
	public ResponseEntity<Page<PARLDNDLHMBDTO>> searchDefault(@RequestBody PARLDNDLHMBSearchContext context) {
        Page<PARLDNDLHMB> domains = parldndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARLDNDLHMB getEntity(){
        return new PARLDNDLHMB();
    }

}
