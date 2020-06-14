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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherTrain;
import cn.ibizlab.ehr.core.trm.service.ITrmTeacherTrainService;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherTrainSearchContext;

@Slf4j
@Api(tags = {"讲师授课记录" })
@RestController("WebApi-trmteachertrain")
@RequestMapping("")
public class TrmTeacherTrainResource {

    @Autowired
    public ITrmTeacherTrainService trmteachertrainService;

    @Autowired
    @Lazy
    public TrmTeacherTrainMapping trmteachertrainMapping;

    @PreAuthorize("hasPermission(this.trmteachertrainMapping.toDomain(#trmteachertraindto),'ehr-TrmTeacherTrain-Save')")
    @ApiOperation(value = "保存讲师授课记录", tags = {"讲师授课记录" },  notes = "保存讲师授课记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTeacherTrainDTO trmteachertraindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.save(trmteachertrainMapping.toDomain(trmteachertraindto)));
    }

    @PreAuthorize("hasPermission(this.trmteachertrainMapping.toDomain(#trmteachertraindtos),'ehr-TrmTeacherTrain-Save')")
    @ApiOperation(value = "批量保存讲师授课记录", tags = {"讲师授课记录" },  notes = "批量保存讲师授课记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTeacherTrainDTO> trmteachertraindtos) {
        trmteachertrainService.saveBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取讲师授课记录草稿", tags = {"讲师授课记录" },  notes = "获取讲师授课记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachertrains/getdraft")
    public ResponseEntity<TrmTeacherTrainDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainMapping.toDto(trmteachertrainService.getDraft(new TrmTeacherTrain())));
    }

    @PreAuthorize("hasPermission(this.trmteachertrainMapping.toDomain(#trmteachertraindto),'ehr-TrmTeacherTrain-Create')")
    @ApiOperation(value = "新建讲师授课记录", tags = {"讲师授课记录" },  notes = "新建讲师授课记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains")
    @Transactional
    public ResponseEntity<TrmTeacherTrainDTO> create(@RequestBody TrmTeacherTrainDTO trmteachertraindto) {
        TrmTeacherTrain domain = trmteachertrainMapping.toDomain(trmteachertraindto);
		trmteachertrainService.create(domain);
        TrmTeacherTrainDTO dto = trmteachertrainMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteachertrainMapping.toDomain(#trmteachertraindtos),'ehr-TrmTeacherTrain-Create')")
    @ApiOperation(value = "批量新建讲师授课记录", tags = {"讲师授课记录" },  notes = "批量新建讲师授课记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTeacherTrainDTO> trmteachertraindtos) {
        trmteachertrainService.createBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteachertrainService.get(#trmteachertrain_id),'ehr-TrmTeacherTrain-Remove')")
    @ApiOperation(value = "删除讲师授课记录", tags = {"讲师授课记录" },  notes = "删除讲师授课记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachertrains/{trmteachertrain_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachertrain_id") String trmteachertrain_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.remove(trmteachertrain_id));
    }

    @PreAuthorize("hasPermission(this.trmteachertrainService.getTrmteachertrainByIds(#ids),'ehr-TrmTeacherTrain-Remove')")
    @ApiOperation(value = "批量删除讲师授课记录", tags = {"讲师授课记录" },  notes = "批量删除讲师授课记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteachertrainService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteachertrainMapping.toDomain(returnObject.body),'ehr-TrmTeacherTrain-Get')")
    @ApiOperation(value = "获取讲师授课记录", tags = {"讲师授课记录" },  notes = "获取讲师授课记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachertrains/{trmteachertrain_id}")
    public ResponseEntity<TrmTeacherTrainDTO> get(@PathVariable("trmteachertrain_id") String trmteachertrain_id) {
        TrmTeacherTrain domain = trmteachertrainService.get(trmteachertrain_id);
        TrmTeacherTrainDTO dto = trmteachertrainMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteachertrainService.get(#trmteachertrain_id),'ehr-TrmTeacherTrain-Update')")
    @ApiOperation(value = "更新讲师授课记录", tags = {"讲师授课记录" },  notes = "更新讲师授课记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachertrains/{trmteachertrain_id}")
    @Transactional
    public ResponseEntity<TrmTeacherTrainDTO> update(@PathVariable("trmteachertrain_id") String trmteachertrain_id, @RequestBody TrmTeacherTrainDTO trmteachertraindto) {
		TrmTeacherTrain domain  = trmteachertrainMapping.toDomain(trmteachertraindto);
        domain .setTrmteachertrainid(trmteachertrain_id);
		trmteachertrainService.update(domain );
		TrmTeacherTrainDTO dto = trmteachertrainMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteachertrainService.getTrmteachertrainByEntities(this.trmteachertrainMapping.toDomain(#trmteachertraindtos)),'ehr-TrmTeacherTrain-Update')")
    @ApiOperation(value = "批量更新讲师授课记录", tags = {"讲师授课记录" },  notes = "批量更新讲师授课记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTeacherTrainDTO> trmteachertraindtos) {
        trmteachertrainService.updateBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查讲师授课记录", tags = {"讲师授课记录" },  notes = "检查讲师授课记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTeacherTrainDTO trmteachertraindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.checkKey(trmteachertrainMapping.toDomain(trmteachertraindto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherTrain-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"讲师授课记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachertrains/fetchdefault")
	public ResponseEntity<List<TrmTeacherTrainDTO>> fetchDefault(TrmTeacherTrainSearchContext context) {
        Page<TrmTeacherTrain> domains = trmteachertrainService.searchDefault(context) ;
        List<TrmTeacherTrainDTO> list = trmteachertrainMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherTrain-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"讲师授课记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmteachertrains/searchdefault")
	public ResponseEntity<Page<TrmTeacherTrainDTO>> searchDefault(@RequestBody TrmTeacherTrainSearchContext context) {
        Page<TrmTeacherTrain> domains = trmteachertrainService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteachertrainMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
