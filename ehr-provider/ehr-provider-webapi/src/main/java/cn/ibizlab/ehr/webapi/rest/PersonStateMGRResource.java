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
import cn.ibizlab.ehr.core.pim.domain.PersonStateMGR;
import cn.ibizlab.ehr.core.pim.service.IPersonStateMGRService;
import cn.ibizlab.ehr.core.pim.filter.PersonStateMGRSearchContext;




@Slf4j
@Api(tags = {"PersonStateMGR" })
@RestController("WebApi-personstatemgr")
@RequestMapping("")
public class PersonStateMGRResource {

    @Autowired
    private IPersonStateMGRService personstatemgrService;

    @Autowired
    @Lazy
    private PersonStateMGRMapping personstatemgrMapping;




    @ApiOperation(value = "Save", tags = {"PersonStateMGR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PersonStateMGRDTO personstatemgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.save(personstatemgrMapping.toDomain(personstatemgrdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PersonStateMGR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PersonStateMGRDTO> personstatemgrdtos) {
        personstatemgrService.saveBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PersonStateMGR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PersonStateMGRDTO personstatemgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.checkKey(personstatemgrMapping.toDomain(personstatemgrdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"PersonStateMGR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/personstatemgrs/getdraft")
    public ResponseEntity<PersonStateMGRDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(personstatemgrMapping.toDto(personstatemgrService.getDraft(new PersonStateMGR())));
    }




    @PreAuthorize("hasPermission(#personstatemgr_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PersonStateMGR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/personstatemgrs/{personstatemgr_id}")
    public ResponseEntity<PersonStateMGRDTO> get(@PathVariable("personstatemgr_id") String personstatemgr_id) {
        PersonStateMGR domain = personstatemgrService.get(personstatemgr_id);
        PersonStateMGRDTO dto = personstatemgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PersonStateMGR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs")
    @Transactional
    public ResponseEntity<PersonStateMGRDTO> create(@RequestBody PersonStateMGRDTO personstatemgrdto) {
        PersonStateMGR domain = personstatemgrMapping.toDomain(personstatemgrdto);
		personstatemgrService.create(domain);
        PersonStateMGRDTO dto = personstatemgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PersonStateMGR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PersonStateMGRDTO> personstatemgrdtos) {
        personstatemgrService.createBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#personstatemgr_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PersonStateMGR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/personstatemgrs/{personstatemgr_id}")
    @Transactional
    public ResponseEntity<PersonStateMGRDTO> update(@PathVariable("personstatemgr_id") String personstatemgr_id, @RequestBody PersonStateMGRDTO personstatemgrdto) {
		PersonStateMGR domain = personstatemgrMapping.toDomain(personstatemgrdto);
        domain.setPersonstatemgrid(personstatemgr_id);
		personstatemgrService.update(domain);
		PersonStateMGRDTO dto = personstatemgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#personstatemgr_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PersonStateMGR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PersonStateMGRDTO> personstatemgrdtos) {
        personstatemgrService.updateBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#personstatemgr_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PersonStateMGR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/personstatemgrs/{personstatemgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("personstatemgr_id") String personstatemgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.remove(personstatemgr_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PersonStateMGR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        personstatemgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PersonStateMGR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/personstatemgrs/fetchdefault")
	public ResponseEntity<List<PersonStateMGRDTO>> fetchDefault(PersonStateMGRSearchContext context) {
        Page<PersonStateMGR> domains = personstatemgrService.searchDefault(context) ;
        List<PersonStateMGRDTO> list = personstatemgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PersonStateMGR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/personstatemgrs/searchdefault")
	public ResponseEntity<Page<PersonStateMGRDTO>> searchDefault(@RequestBody PersonStateMGRSearchContext context) {
        Page<PersonStateMGR> domains = personstatemgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(personstatemgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PersonStateMGR getEntity(){
        return new PersonStateMGR();
    }

}
