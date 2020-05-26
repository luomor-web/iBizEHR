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
import cn.ibizlab.ehr.core.orm.domain.ORMQYBZWH;
import cn.ibizlab.ehr.core.orm.service.IORMQYBZWHService;
import cn.ibizlab.ehr.core.orm.filter.ORMQYBZWHSearchContext;

@Slf4j
@Api(tags = {"ORMQYBZWH" })
@RestController("WebApi-ormqybzwh")
@RequestMapping("")
public class ORMQYBZWHResource {

    @Autowired
    private IORMQYBZWHService ormqybzwhService;

    @Autowired
    @Lazy
    public ORMQYBZWHMapping ormqybzwhMapping;

    public ORMQYBZWHDTO permissionDTO=new ORMQYBZWHDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYBZWH-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMQYBZWH" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMQYBZWHDTO ormqybzwhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.checkKey(ormqybzwhMapping.toDomain(ormqybzwhdto)));
    }

    @PreAuthorize("hasPermission(#ormqybzwh_id,'Get',{'Sql',this.ormqybzwhMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMQYBZWH" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqybzwhs/{ormqybzwh_id}")
    public ResponseEntity<ORMQYBZWHDTO> get(@PathVariable("ormqybzwh_id") String ormqybzwh_id) {
        ORMQYBZWH domain = ormqybzwhService.get(ormqybzwh_id);
        ORMQYBZWHDTO dto = ormqybzwhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormqybzwhMapping,#ormqybzwhdto})")
    @ApiOperation(value = "Save", tags = {"ORMQYBZWH" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMQYBZWHDTO ormqybzwhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.save(ormqybzwhMapping.toDomain(ormqybzwhdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormqybzwhMapping,#ormqybzwhdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMQYBZWH" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMQYBZWHDTO> ormqybzwhdtos) {
        ormqybzwhService.saveBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormqybzwh_id,'Remove',{'Sql',this.ormqybzwhMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMQYBZWH" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqybzwhs/{ormqybzwh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormqybzwh_id") String ormqybzwh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.remove(ormqybzwh_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormqybzwhMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMQYBZWH" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormqybzwhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormqybzwh_id,'Update',{'Sql',this.ormqybzwhMapping,#ormqybzwhdto})")
    @ApiOperation(value = "Update", tags = {"ORMQYBZWH" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqybzwhs/{ormqybzwh_id}")
    @Transactional
    public ResponseEntity<ORMQYBZWHDTO> update(@PathVariable("ormqybzwh_id") String ormqybzwh_id, @RequestBody ORMQYBZWHDTO ormqybzwhdto) {
		ORMQYBZWH domain  = ormqybzwhMapping.toDomain(ormqybzwhdto);
        domain .setOrmqybzwhid(ormqybzwh_id);
		ormqybzwhService.update(domain );
		ORMQYBZWHDTO dto = ormqybzwhMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormqybzwhMapping,#ormqybzwhdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMQYBZWH" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMQYBZWHDTO> ormqybzwhdtos) {
        ormqybzwhService.updateBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYBZWH-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMQYBZWH" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqybzwhs/getdraft")
    public ResponseEntity<ORMQYBZWHDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhMapping.toDto(ormqybzwhService.getDraft(new ORMQYBZWH())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormqybzwhMapping,#ormqybzwhdto})")
    @ApiOperation(value = "Create", tags = {"ORMQYBZWH" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs")
    @Transactional
    public ResponseEntity<ORMQYBZWHDTO> create(@RequestBody ORMQYBZWHDTO ormqybzwhdto) {
        ORMQYBZWH domain = ormqybzwhMapping.toDomain(ormqybzwhdto);
		ormqybzwhService.create(domain);
        ORMQYBZWHDTO dto = ormqybzwhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormqybzwhMapping,#ormqybzwhdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMQYBZWH" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMQYBZWHDTO> ormqybzwhdtos) {
        ormqybzwhService.createBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYBZWH-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMQYBZWH" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormqybzwhs/fetchdefault")
	public ResponseEntity<List<ORMQYBZWHDTO>> fetchDefault(ORMQYBZWHSearchContext context) {
        Page<ORMQYBZWH> domains = ormqybzwhService.searchDefault(context) ;
        List<ORMQYBZWHDTO> list = ormqybzwhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMQYBZWH-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMQYBZWH" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormqybzwhs/searchdefault")
	public ResponseEntity<Page<ORMQYBZWHDTO>> searchDefault(@RequestBody ORMQYBZWHSearchContext context) {
        Page<ORMQYBZWH> domains = ormqybzwhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormqybzwhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
