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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB;
import cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBService;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBSearchContext;




@Slf4j
@Api(tags = {"PARZNBMNDLHMB" })
@RestController("WebApi-parznbmndlhmb")
@RequestMapping("")
public class PARZNBMNDLHMBResource {

    @Autowired
    private IPARZNBMNDLHMBService parznbmndlhmbService;

    @Autowired
    @Lazy
    private PARZNBMNDLHMBMapping parznbmndlhmbMapping;




    @ApiOperation(value = "CheckKey", tags = {"PARZNBMNDLHMB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARZNBMNDLHMBDTO parznbmndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.checkKey(parznbmndlhmbMapping.toDomain(parznbmndlhmbdto)));
    }




    @ApiOperation(value = "Save", tags = {"PARZNBMNDLHMB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARZNBMNDLHMBDTO parznbmndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.save(parznbmndlhmbMapping.toDomain(parznbmndlhmbdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARZNBMNDLHMB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARZNBMNDLHMBDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.saveBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parznbmndlhmb_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARZNBMNDLHMB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.remove(parznbmndlhmb_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARZNBMNDLHMB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parznbmndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARZNBMNDLHMB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBDTO> update(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id, @RequestBody PARZNBMNDLHMBDTO parznbmndlhmbdto) {
		PARZNBMNDLHMB domain = parznbmndlhmbMapping.toDomain(parznbmndlhmbdto);
        domain.setParznbmndlhmbid(parznbmndlhmb_id);
		parznbmndlhmbService.update(domain);
		PARZNBMNDLHMBDTO dto = parznbmndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parznbmndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARZNBMNDLHMB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARZNBMNDLHMBDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.updateBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARZNBMNDLHMB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbs/getdraft")
    public ResponseEntity<PARZNBMNDLHMBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbMapping.toDto(parznbmndlhmbService.getDraft(new PARZNBMNDLHMB())));
    }




    @PreAuthorize("hasPermission(#parznbmndlhmb_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARZNBMNDLHMB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    public ResponseEntity<PARZNBMNDLHMBDTO> get(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id) {
        PARZNBMNDLHMB domain = parznbmndlhmbService.get(parznbmndlhmb_id);
        PARZNBMNDLHMBDTO dto = parznbmndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARZNBMNDLHMB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBDTO> create(@RequestBody PARZNBMNDLHMBDTO parznbmndlhmbdto) {
        PARZNBMNDLHMB domain = parznbmndlhmbMapping.toDomain(parznbmndlhmbdto);
		parznbmndlhmbService.create(domain);
        PARZNBMNDLHMBDTO dto = parznbmndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARZNBMNDLHMB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARZNBMNDLHMBDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.createBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMNDLHMB-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARZNBMNDLHMB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbs/fetchdefault")
	public ResponseEntity<List<PARZNBMNDLHMBDTO>> fetchDefault(PARZNBMNDLHMBSearchContext context) {
        Page<PARZNBMNDLHMB> domains = parznbmndlhmbService.searchDefault(context) ;
        List<PARZNBMNDLHMBDTO> list = parznbmndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMNDLHMB-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARZNBMNDLHMB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmndlhmbs/searchdefault")
	public ResponseEntity<Page<PARZNBMNDLHMBDTO>> searchDefault(@RequestBody PARZNBMNDLHMBSearchContext context) {
        Page<PARZNBMNDLHMB> domains = parznbmndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARZNBMNDLHMB getEntity(){
        return new PARZNBMNDLHMB();
    }

}
