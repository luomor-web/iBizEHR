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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.orm.domain.OrmPostLib;
import cn.ibizlab.ehr.core.orm.service.IOrmPostLibService;
import cn.ibizlab.ehr.core.orm.filter.OrmPostLibSearchContext;

@Slf4j
@Api(tags = {"OrmPostLib" })
@RestController("WebApi-ormpostlib")
@RequestMapping("")
public class OrmPostLibResource {

    @Autowired
    public IOrmPostLibService ormpostlibService;

    @Autowired
    @Lazy
    public OrmPostLibMapping ormpostlibMapping;

    @PreAuthorize("hasPermission(this.ormpostlibService.get(#ormpostlib_id),'ehr-OrmPostLib-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmPostLib" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostlib_id") String ormpostlib_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.remove(ormpostlib_id));
    }

    @PreAuthorize("hasPermission(this.ormpostlibService.getOrmpostlibByIds(#ids),'ehr-OrmPostLib-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmPostLib" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostlibService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostlibMapping.toDomain(#ormpostlibdto),'ehr-OrmPostLib-Save')")
    @ApiOperation(value = "Save", tags = {"OrmPostLib" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmPostLibDTO ormpostlibdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.save(ormpostlibMapping.toDomain(ormpostlibdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostlibMapping.toDomain(#ormpostlibdtos),'ehr-OrmPostLib-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmPostLib" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmPostLibDTO> ormpostlibdtos) {
        ormpostlibService.saveBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostlibService.get(#ormpostlib_id),'ehr-OrmPostLib-Update')")
    @ApiOperation(value = "Update", tags = {"OrmPostLib" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}")
    @Transactional
    public ResponseEntity<OrmPostLibDTO> update(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostLibDTO ormpostlibdto) {
		OrmPostLib domain  = ormpostlibMapping.toDomain(ormpostlibdto);
        domain .setOrmpostlibid(ormpostlib_id);
		ormpostlibService.update(domain );
		OrmPostLibDTO dto = ormpostlibMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostlibService.getOrmpostlibByEntities(this.ormpostlibMapping.toDomain(#ormpostlibdtos)),'ehr-OrmPostLib-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmPostLib" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmPostLibDTO> ormpostlibdtos) {
        ormpostlibService.updateBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostlibMapping.toDomain(#ormpostlibdto),'ehr-OrmPostLib-Create')")
    @ApiOperation(value = "Create", tags = {"OrmPostLib" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs")
    @Transactional
    public ResponseEntity<OrmPostLibDTO> create(@RequestBody OrmPostLibDTO ormpostlibdto) {
        OrmPostLib domain = ormpostlibMapping.toDomain(ormpostlibdto);
		ormpostlibService.create(domain);
        OrmPostLibDTO dto = ormpostlibMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostlibMapping.toDomain(#ormpostlibdtos),'ehr-OrmPostLib-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmPostLib" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmPostLibDTO> ormpostlibdtos) {
        ormpostlibService.createBatch(ormpostlibMapping.toDomain(ormpostlibdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmPostLib" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/getdraft")
    public ResponseEntity<OrmPostLibDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostlibMapping.toDto(ormpostlibService.getDraft(new OrmPostLib())));
    }

    @PostAuthorize("hasPermission(this.ormpostlibMapping.toDomain(returnObject.body),'ehr-OrmPostLib-Get')")
    @ApiOperation(value = "Get", tags = {"OrmPostLib" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}")
    public ResponseEntity<OrmPostLibDTO> get(@PathVariable("ormpostlib_id") String ormpostlib_id) {
        OrmPostLib domain = ormpostlibService.get(ormpostlib_id);
        OrmPostLibDTO dto = ormpostlibMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmPostLib" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmPostLibDTO ormpostlibdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostlibService.checkKey(ormpostlibMapping.toDomain(ormpostlibdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostLib-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmPostLib" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostlibs/fetchdefault")
	public ResponseEntity<List<OrmPostLibDTO>> fetchDefault(OrmPostLibSearchContext context) {
        Page<OrmPostLib> domains = ormpostlibService.searchDefault(context) ;
        List<OrmPostLibDTO> list = ormpostlibMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostLib-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmPostLib" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostlibs/searchdefault")
	public ResponseEntity<Page<OrmPostLibDTO>> searchDefault(@RequestBody OrmPostLibSearchContext context) {
        Page<OrmPostLib> domains = ormpostlibService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostlibMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

