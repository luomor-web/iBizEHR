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
import cn.ibizlab.ehr.core.orm.domain.ORMPostLib;
import cn.ibizlab.ehr.core.orm.service.IORMPostLibService;
import cn.ibizlab.ehr.core.orm.filter.ORMPostLibSearchContext;




@Slf4j
@Api(tags = {"ORMPostLib" })
@RestController("WebApi-ormpostlib")
@RequestMapping("")
public class ORMPostLibResource {

    @Autowired
    private IORMPostLibService ormpostlibService;

    @Autowired
    @Lazy
    public ORMPostLibMapping ormpostlibMapping;

    public ORMPostLibDTO permissionDTO=new ORMPostLibDTO();




    @PreAuthorize("hasPermission(#ormpostlib_id,'Remove',{'Sql',this.ormpostlibMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMPostLib" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostlib_id") String ormpostlib_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.remove(ormpostlib_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMPostLib" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostlibService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostLib-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMPostLib" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMPostLibDTO ormpostlibdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.save(ormpostlibMapping.toDomain(ormpostlibdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMPostLib" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMPostLibDTO> ormpostlibdtos) {
        ormpostlibService.saveBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormpostlib_id,'Update',{'Sql',this.ormpostlibMapping,#ormpostlibdto})")
    @ApiOperation(value = "Update", tags = {"ORMPostLib" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}")
    @Transactional
    public ResponseEntity<ORMPostLibDTO> update(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody ORMPostLibDTO ormpostlibdto) {
		ORMPostLib domain = ormpostlibMapping.toDomain(ormpostlibdto);
        domain.setOrmpostlibid(ormpostlib_id);
		ormpostlibService.update(domain);
		ORMPostLibDTO dto = ormpostlibMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"ORMPostLib" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMPostLibDTO> ormpostlibdtos) {
        ormpostlibService.updateBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormpostlibMapping,#ormpostlibdto})")
    @ApiOperation(value = "Create", tags = {"ORMPostLib" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs")
    @Transactional
    public ResponseEntity<ORMPostLibDTO> create(@RequestBody ORMPostLibDTO ormpostlibdto) {
        ORMPostLib domain = ormpostlibMapping.toDomain(ormpostlibdto);
		ormpostlibService.create(domain);
        ORMPostLibDTO dto = ormpostlibMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"ORMPostLib" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMPostLibDTO> ormpostlibdtos) {
        ormpostlibService.createBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostLib-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMPostLib" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/getdraft")
    public ResponseEntity<ORMPostLibDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostlibMapping.toDto(ormpostlibService.getDraft(new ORMPostLib())));
    }




    @PreAuthorize("hasPermission(#ormpostlib_id,'Get',{'Sql',this.ormpostlibMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMPostLib" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}")
    public ResponseEntity<ORMPostLibDTO> get(@PathVariable("ormpostlib_id") String ormpostlib_id) {
        ORMPostLib domain = ormpostlibService.get(ormpostlib_id);
        ORMPostLibDTO dto = ormpostlibMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostLib-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMPostLib" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMPostLibDTO ormpostlibdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.checkKey(ormpostlibMapping.toDomain(ormpostlibdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostLib-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMPostLib" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostlibs/fetchdefault")
	public ResponseEntity<List<ORMPostLibDTO>> fetchDefault(ORMPostLibSearchContext context) {
        Page<ORMPostLib> domains = ormpostlibService.searchDefault(context) ;
        List<ORMPostLibDTO> list = ormpostlibMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostLib-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMPostLib" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostlibs/searchdefault")
	public ResponseEntity<Page<ORMPostLibDTO>> searchDefault(@RequestBody ORMPostLibSearchContext context) {
        Page<ORMPostLib> domains = ormpostlibService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostlibMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


