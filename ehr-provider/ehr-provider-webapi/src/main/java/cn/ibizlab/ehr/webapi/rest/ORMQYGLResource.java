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
import cn.ibizlab.ehr.core.orm.domain.ORMQYGL;
import cn.ibizlab.ehr.core.orm.service.IORMQYGLService;
import cn.ibizlab.ehr.core.orm.filter.ORMQYGLSearchContext;

@Slf4j
@Api(tags = {"ORMQYGL" })
@RestController("WebApi-ormqygl")
@RequestMapping("")
public class ORMQYGLResource {

    @Autowired
    private IORMQYGLService ormqyglService;

    @Autowired
    @Lazy
    public ORMQYGLMapping ormqyglMapping;

    public ORMQYGLDTO permissionDTO=new ORMQYGLDTO();

    @PreAuthorize("hasPermission(#ormqygl_id,'Update',{'Sql',this.ormqyglMapping,#ormqygldto})")
    @ApiOperation(value = "Update", tags = {"ORMQYGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqygls/{ormqygl_id}")
    @Transactional
    public ResponseEntity<ORMQYGLDTO> update(@PathVariable("ormqygl_id") String ormqygl_id, @RequestBody ORMQYGLDTO ormqygldto) {
		ORMQYGL domain = ormqyglMapping.toDomain(ormqygldto);
        domain.setOrmqyglid(ormqygl_id);
		ormqyglService.update(domain);
		ORMQYGLDTO dto = ormqyglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMQYGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMQYGLDTO> ormqygldtos) {
        ormqyglService.updateBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormqygl_id,'Get',{'Sql',this.ormqyglMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMQYGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqygls/{ormqygl_id}")
    public ResponseEntity<ORMQYGLDTO> get(@PathVariable("ormqygl_id") String ormqygl_id) {
        ORMQYGL domain = ormqyglService.get(ormqygl_id);
        ORMQYGLDTO dto = ormqyglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormqyglMapping,#ormqygldto})")
    @ApiOperation(value = "Create", tags = {"ORMQYGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls")
    @Transactional
    public ResponseEntity<ORMQYGLDTO> create(@RequestBody ORMQYGLDTO ormqygldto) {
        ORMQYGL domain = ormqyglMapping.toDomain(ormqygldto);
		ormqyglService.create(domain);
        ORMQYGLDTO dto = ormqyglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMQYGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMQYGLDTO> ormqygldtos) {
        ormqyglService.createBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYGL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMQYGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqygls/getdraft")
    public ResponseEntity<ORMQYGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormqyglMapping.toDto(ormqyglService.getDraft(new ORMQYGL())));
    }

    @PreAuthorize("hasPermission(#ormqygl_id,'Remove',{'Sql',this.ormqyglMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMQYGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqygls/{ormqygl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormqygl_id") String ormqygl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormqyglService.remove(ormqygl_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMQYGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormqyglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormqyglMapping,#ormqygldto})")
    @ApiOperation(value = "Save", tags = {"ORMQYGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMQYGLDTO ormqygldto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormqyglService.save(ormqyglMapping.toDomain(ormqygldto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMQYGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMQYGLDTO> ormqygldtos) {
        ormqyglService.saveBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYGL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMQYGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMQYGLDTO ormqygldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormqyglService.checkKey(ormqyglMapping.toDomain(ormqygldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYGL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMQYGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormqygls/fetchdefault")
	public ResponseEntity<List<ORMQYGLDTO>> fetchDefault(ORMQYGLSearchContext context) {
        Page<ORMQYGL> domains = ormqyglService.searchDefault(context) ;
        List<ORMQYGLDTO> list = ormqyglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYGL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMQYGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormqygls/searchdefault")
	public ResponseEntity<Page<ORMQYGLDTO>> searchDefault(@RequestBody ORMQYGLSearchContext context) {
        Page<ORMQYGL> domains = ormqyglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormqyglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
