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
import cn.ibizlab.ehr.core.trm.domain.TRMAGENCYRECORD;
import cn.ibizlab.ehr.core.trm.service.ITRMAGENCYRECORDService;
import cn.ibizlab.ehr.core.trm.filter.TRMAGENCYRECORDSearchContext;

@Slf4j
@Api(tags = {"TRMAGENCYRECORD" })
@RestController("WebApi-trmagencyrecord")
@RequestMapping("")
public class TRMAGENCYRECORDResource {

    @Autowired
    public ITRMAGENCYRECORDService trmagencyrecordService;

    @Autowired
    @Lazy
    public TRMAGENCYRECORDMapping trmagencyrecordMapping;

    @ApiOperation(value = "GetDraft", tags = {"TRMAGENCYRECORD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmagencyrecords/getdraft")
    public ResponseEntity<TRMAGENCYRECORDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordMapping.toDto(trmagencyrecordService.getDraft(new TRMAGENCYRECORD())));
    }

    @PostAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(returnObject.body),'ehr-TRMAGENCYRECORD-Get')")
    @ApiOperation(value = "Get", tags = {"TRMAGENCYRECORD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmagencyrecords/{trmagencyrecord_id}")
    public ResponseEntity<TRMAGENCYRECORDDTO> get(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id) {
        TRMAGENCYRECORD domain = trmagencyrecordService.get(trmagencyrecord_id);
        TRMAGENCYRECORDDTO dto = trmagencyrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMAGENCYRECORD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMAGENCYRECORDDTO trmagencyrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.checkKey(trmagencyrecordMapping.toDomain(trmagencyrecorddto)));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.get(#trmagencyrecord_id),'ehr-TRMAGENCYRECORD-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMAGENCYRECORD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmagencyrecords/{trmagencyrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.remove(trmagencyrecord_id));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.getTrmagencyrecordByIds(#ids),'ehr-TRMAGENCYRECORD-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMAGENCYRECORD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmagencyrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddto),'ehr-TRMAGENCYRECORD-Save')")
    @ApiOperation(value = "Save", tags = {"TRMAGENCYRECORD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMAGENCYRECORDDTO trmagencyrecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.save(trmagencyrecordMapping.toDomain(trmagencyrecorddto)));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos),'ehr-TRMAGENCYRECORD-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMAGENCYRECORD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMAGENCYRECORDDTO> trmagencyrecorddtos) {
        trmagencyrecordService.saveBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.get(#trmagencyrecord_id),'ehr-TRMAGENCYRECORD-Update')")
    @ApiOperation(value = "Update", tags = {"TRMAGENCYRECORD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmagencyrecords/{trmagencyrecord_id}")
    @Transactional
    public ResponseEntity<TRMAGENCYRECORDDTO> update(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id, @RequestBody TRMAGENCYRECORDDTO trmagencyrecorddto) {
		TRMAGENCYRECORD domain  = trmagencyrecordMapping.toDomain(trmagencyrecorddto);
        domain .setTrmagencyrecordid(trmagencyrecord_id);
		trmagencyrecordService.update(domain );
		TRMAGENCYRECORDDTO dto = trmagencyrecordMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.getTrmagencyrecordByEntities(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos)),'ehr-TRMAGENCYRECORD-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMAGENCYRECORD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMAGENCYRECORDDTO> trmagencyrecorddtos) {
        trmagencyrecordService.updateBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddto),'ehr-TRMAGENCYRECORD-Create')")
    @ApiOperation(value = "Create", tags = {"TRMAGENCYRECORD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords")
    @Transactional
    public ResponseEntity<TRMAGENCYRECORDDTO> create(@RequestBody TRMAGENCYRECORDDTO trmagencyrecorddto) {
        TRMAGENCYRECORD domain = trmagencyrecordMapping.toDomain(trmagencyrecorddto);
		trmagencyrecordService.create(domain);
        TRMAGENCYRECORDDTO dto = trmagencyrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos),'ehr-TRMAGENCYRECORD-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMAGENCYRECORD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMAGENCYRECORDDTO> trmagencyrecorddtos) {
        trmagencyrecordService.createBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMAGENCYRECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMAGENCYRECORD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmagencyrecords/fetchdefault")
	public ResponseEntity<List<TRMAGENCYRECORDDTO>> fetchDefault(TRMAGENCYRECORDSearchContext context) {
        Page<TRMAGENCYRECORD> domains = trmagencyrecordService.searchDefault(context) ;
        List<TRMAGENCYRECORDDTO> list = trmagencyrecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMAGENCYRECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMAGENCYRECORD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmagencyrecords/searchdefault")
	public ResponseEntity<Page<TRMAGENCYRECORDDTO>> searchDefault(@RequestBody TRMAGENCYRECORDSearchContext context) {
        Page<TRMAGENCYRECORD> domains = trmagencyrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmagencyrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

