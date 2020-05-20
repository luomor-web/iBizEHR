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
import cn.ibizlab.ehr.core.orm.domain.ORMDepEstMan;
import cn.ibizlab.ehr.core.orm.service.IORMDepEstManService;
import cn.ibizlab.ehr.core.orm.filter.ORMDepEstManSearchContext;




@Slf4j
@Api(tags = {"ORMDepEstMan" })
@RestController("WebApi-ormdepestman")
@RequestMapping("")
public class ORMDepEstManResource {

    @Autowired
    private IORMDepEstManService ormdepestmanService;

    @Autowired
    @Lazy
    private ORMDepEstManMapping ormdepestmanMapping;




    @ApiOperation(value = "GetDraft", tags = {"ORMDepEstMan" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/getdraft")
    public ResponseEntity<ORMDepEstManDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(new ORMDepEstMan())));
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMDepEstMan" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMDepEstMan" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> create(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
		ormdepestmanService.create(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMDepEstMan" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.createBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormdepestman_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMDepEstMan" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<ORMDepEstManDTO> get(@PathVariable("ormdepestman_id") String ormdepestman_id) {
        ORMDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#ormdepestman_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMDepEstMan" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormdepestman_id") String ormdepestman_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMDepEstMan" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormdepestman_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMDepEstMan" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> update(@PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
		ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
		ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormdepestman_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMDepEstMan" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.updateBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ORMDepEstMan" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMDepEstMan" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.saveBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMDepEstMan" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormdepestmen/fetchdefault")
	public ResponseEntity<List<ORMDepEstManDTO>> fetchDefault(ORMDepEstManSearchContext context) {
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<ORMDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMDepEstMan" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormdepestmen/searchdefault")
	public ResponseEntity<Page<ORMDepEstManDTO>> searchDefault(@RequestBody ORMDepEstManSearchContext context) {
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMDepEstMan getEntity(){
        return new ORMDepEstMan();
    }

}
