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
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMB;
import cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBService;
import cn.ibizlab.ehr.core.par.filter.PARPTRYNDLHMBSearchContext;




@Slf4j
@Api(tags = {"PARPTRYNDLHMB" })
@RestController("WebApi-parptryndlhmb")
@RequestMapping("")
public class PARPTRYNDLHMBResource {

    @Autowired
    private IPARPTRYNDLHMBService parptryndlhmbService;

    @Autowired
    @Lazy
    private PARPTRYNDLHMBMapping parptryndlhmbMapping;




    @PreAuthorize("hasPermission(#parptryndlhmb_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARPTRYNDLHMB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    public ResponseEntity<PARPTRYNDLHMBDTO> get(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id) {
        PARPTRYNDLHMB domain = parptryndlhmbService.get(parptryndlhmb_id);
        PARPTRYNDLHMBDTO dto = parptryndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARPTRYNDLHMB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs")
    @Transactional
    public ResponseEntity<PARPTRYNDLHMBDTO> create(@RequestBody PARPTRYNDLHMBDTO parptryndlhmbdto) {
        PARPTRYNDLHMB domain = parptryndlhmbMapping.toDomain(parptryndlhmbdto);
		parptryndlhmbService.create(domain);
        PARPTRYNDLHMBDTO dto = parptryndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARPTRYNDLHMB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARPTRYNDLHMBDTO> parptryndlhmbdtos) {
        parptryndlhmbService.createBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parptryndlhmb_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARPTRYNDLHMB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.remove(parptryndlhmb_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARPTRYNDLHMB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parptryndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parptryndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARPTRYNDLHMB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    @Transactional
    public ResponseEntity<PARPTRYNDLHMBDTO> update(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id, @RequestBody PARPTRYNDLHMBDTO parptryndlhmbdto) {
		PARPTRYNDLHMB domain = parptryndlhmbMapping.toDomain(parptryndlhmbdto);
        domain.setParptryndlhmbid(parptryndlhmb_id);
		parptryndlhmbService.update(domain);
		PARPTRYNDLHMBDTO dto = parptryndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parptryndlhmb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARPTRYNDLHMB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARPTRYNDLHMBDTO> parptryndlhmbdtos) {
        parptryndlhmbService.updateBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARPTRYNDLHMB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARPTRYNDLHMBDTO parptryndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.save(parptryndlhmbMapping.toDomain(parptryndlhmbdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARPTRYNDLHMB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARPTRYNDLHMBDTO> parptryndlhmbdtos) {
        parptryndlhmbService.saveBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARPTRYNDLHMB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbs/getdraft")
    public ResponseEntity<PARPTRYNDLHMBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbMapping.toDto(parptryndlhmbService.getDraft(new PARPTRYNDLHMB())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PARPTRYNDLHMB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARPTRYNDLHMBDTO parptryndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.checkKey(parptryndlhmbMapping.toDomain(parptryndlhmbdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARPTRYNDLHMB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parptryndlhmbs/fetchdefault")
	public ResponseEntity<List<PARPTRYNDLHMBDTO>> fetchDefault(PARPTRYNDLHMBSearchContext context) {
        Page<PARPTRYNDLHMB> domains = parptryndlhmbService.searchDefault(context) ;
        List<PARPTRYNDLHMBDTO> list = parptryndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARPTRYNDLHMB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parptryndlhmbs/searchdefault")
	public ResponseEntity<Page<PARPTRYNDLHMBDTO>> searchDefault(PARPTRYNDLHMBSearchContext context) {
        Page<PARPTRYNDLHMB> domains = parptryndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parptryndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARPTRYNDLHMB getEntity(){
        return new PARPTRYNDLHMB();
    }

}
