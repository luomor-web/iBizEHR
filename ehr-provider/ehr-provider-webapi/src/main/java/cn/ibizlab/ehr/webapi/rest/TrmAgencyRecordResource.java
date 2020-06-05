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
import cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord;
import cn.ibizlab.ehr.core.trm.service.ITrmAgencyRecordService;
import cn.ibizlab.ehr.core.trm.filter.TrmAgencyRecordSearchContext;

@Slf4j
@Api(tags = {"机构培训记录" })
@RestController("WebApi-trmagencyrecord")
@RequestMapping("")
public class TrmAgencyRecordResource {

    @Autowired
    public ITrmAgencyRecordService trmagencyrecordService;

    @Autowired
    @Lazy
    public TrmAgencyRecordMapping trmagencyrecordMapping;

    @ApiOperation(value = "获取机构培训记录草稿", tags = {"机构培训记录" },  notes = "获取机构培训记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmagencyrecords/getdraft")
    public ResponseEntity<TrmAgencyRecordDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordMapping.toDto(trmagencyrecordService.getDraft(new TrmAgencyRecord())));
    }

    @PostAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(returnObject.body),'ehr-TrmAgencyRecord-Get')")
    @ApiOperation(value = "获取机构培训记录", tags = {"机构培训记录" },  notes = "获取机构培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmagencyrecords/{trmagencyrecord_id}")
    public ResponseEntity<TrmAgencyRecordDTO> get(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id) {
        TrmAgencyRecord domain = trmagencyrecordService.get(trmagencyrecord_id);
        TrmAgencyRecordDTO dto = trmagencyrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查机构培训记录", tags = {"机构培训记录" },  notes = "检查机构培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmAgencyRecordDTO trmagencyrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.checkKey(trmagencyrecordMapping.toDomain(trmagencyrecorddto)));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.get(#trmagencyrecord_id),'ehr-TrmAgencyRecord-Remove')")
    @ApiOperation(value = "删除机构培训记录", tags = {"机构培训记录" },  notes = "删除机构培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmagencyrecords/{trmagencyrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.remove(trmagencyrecord_id));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.getTrmagencyrecordByIds(#ids),'ehr-TrmAgencyRecord-Remove')")
    @ApiOperation(value = "批量删除机构培训记录", tags = {"机构培训记录" },  notes = "批量删除机构培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmagencyrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddto),'ehr-TrmAgencyRecord-Save')")
    @ApiOperation(value = "保存机构培训记录", tags = {"机构培训记录" },  notes = "保存机构培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmAgencyRecordDTO trmagencyrecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmagencyrecordService.save(trmagencyrecordMapping.toDomain(trmagencyrecorddto)));
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos),'ehr-TrmAgencyRecord-Save')")
    @ApiOperation(value = "批量保存机构培训记录", tags = {"机构培训记录" },  notes = "批量保存机构培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmAgencyRecordDTO> trmagencyrecorddtos) {
        trmagencyrecordService.saveBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.get(#trmagencyrecord_id),'ehr-TrmAgencyRecord-Update')")
    @ApiOperation(value = "更新机构培训记录", tags = {"机构培训记录" },  notes = "更新机构培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmagencyrecords/{trmagencyrecord_id}")
    @Transactional
    public ResponseEntity<TrmAgencyRecordDTO> update(@PathVariable("trmagencyrecord_id") String trmagencyrecord_id, @RequestBody TrmAgencyRecordDTO trmagencyrecorddto) {
		TrmAgencyRecord domain  = trmagencyrecordMapping.toDomain(trmagencyrecorddto);
        domain .setTrmagencyrecordid(trmagencyrecord_id);
		trmagencyrecordService.update(domain );
		TrmAgencyRecordDTO dto = trmagencyrecordMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordService.getTrmagencyrecordByEntities(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos)),'ehr-TrmAgencyRecord-Update')")
    @ApiOperation(value = "批量更新机构培训记录", tags = {"机构培训记录" },  notes = "批量更新机构培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmAgencyRecordDTO> trmagencyrecorddtos) {
        trmagencyrecordService.updateBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddto),'ehr-TrmAgencyRecord-Create')")
    @ApiOperation(value = "新建机构培训记录", tags = {"机构培训记录" },  notes = "新建机构培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords")
    @Transactional
    public ResponseEntity<TrmAgencyRecordDTO> create(@RequestBody TrmAgencyRecordDTO trmagencyrecorddto) {
        TrmAgencyRecord domain = trmagencyrecordMapping.toDomain(trmagencyrecorddto);
		trmagencyrecordService.create(domain);
        TrmAgencyRecordDTO dto = trmagencyrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmagencyrecordMapping.toDomain(#trmagencyrecorddtos),'ehr-TrmAgencyRecord-Create')")
    @ApiOperation(value = "批量新建机构培训记录", tags = {"机构培训记录" },  notes = "批量新建机构培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmagencyrecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmAgencyRecordDTO> trmagencyrecorddtos) {
        trmagencyrecordService.createBatch(trmagencyrecordMapping.toDomain(trmagencyrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmAgencyRecord-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"机构培训记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmagencyrecords/fetchdefault")
	public ResponseEntity<List<TrmAgencyRecordDTO>> fetchDefault(TrmAgencyRecordSearchContext context) {
        Page<TrmAgencyRecord> domains = trmagencyrecordService.searchDefault(context) ;
        List<TrmAgencyRecordDTO> list = trmagencyrecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmAgencyRecord-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"机构培训记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmagencyrecords/searchdefault")
	public ResponseEntity<Page<TrmAgencyRecordDTO>> searchDefault(@RequestBody TrmAgencyRecordSearchContext context) {
        Page<TrmAgencyRecord> domains = trmagencyrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmagencyrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

