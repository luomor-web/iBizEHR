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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainOutApply;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainOutApplyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainOutApplySearchContext;

@Slf4j
@Api(tags = {"外部培训申请" })
@RestController("WebApi-trmtrainoutapply")
@RequestMapping("")
public class TrmTrainOutApplyResource {

    @Autowired
    public ITrmTrainOutApplyService trmtrainoutapplyService;

    @Autowired
    @Lazy
    public TrmTrainOutApplyMapping trmtrainoutapplyMapping;

    @PostAuthorize("hasPermission(this.trmtrainoutapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainOutApply-Get')")
    @ApiOperation(value = "获取外部培训申请", tags = {"外部培训申请" },  notes = "获取外部培训申请")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    public ResponseEntity<TrmTrainOutApplyDTO> get(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id) {
        TrmTrainOutApply domain = trmtrainoutapplyService.get(trmtrainoutapply_id);
        TrmTrainOutApplyDTO dto = trmtrainoutapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查外部培训申请", tags = {"外部培训申请" },  notes = "检查外部培训申请")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainOutApplyDTO trmtrainoutapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.checkKey(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyMapping.toDomain(#trmtrainoutapplydto),'ehr-TrmTrainOutApply-Save')")
    @ApiOperation(value = "保存外部培训申请", tags = {"外部培训申请" },  notes = "保存外部培训申请")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainOutApplyDTO trmtrainoutapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.save(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyMapping.toDomain(#trmtrainoutapplydtos),'ehr-TrmTrainOutApply-Save')")
    @ApiOperation(value = "批量保存外部培训申请", tags = {"外部培训申请" },  notes = "批量保存外部培训申请")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainOutApplyDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.saveBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取外部培训申请草稿", tags = {"外部培训申请" },  notes = "获取外部培训申请草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainoutapplies/getdraft")
    public ResponseEntity<TrmTrainOutApplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyMapping.toDto(trmtrainoutapplyService.getDraft(new TrmTrainOutApply())));
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyService.get(#trmtrainoutapply_id),'ehr-TrmTrainOutApply-Remove')")
    @ApiOperation(value = "删除外部培训申请", tags = {"外部培训申请" },  notes = "删除外部培训申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.remove(trmtrainoutapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyService.getTrmtrainoutapplyByIds(#ids),'ehr-TrmTrainOutApply-Remove')")
    @ApiOperation(value = "批量删除外部培训申请", tags = {"外部培训申请" },  notes = "批量删除外部培训申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainoutapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyService.get(#trmtrainoutapply_id),'ehr-TrmTrainOutApply-Update')")
    @ApiOperation(value = "更新外部培训申请", tags = {"外部培训申请" },  notes = "更新外部培训申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainOutApplyDTO> update(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id, @RequestBody TrmTrainOutApplyDTO trmtrainoutapplydto) {
		TrmTrainOutApply domain  = trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto);
        domain .setTrmtrainoutapplyid(trmtrainoutapply_id);
		trmtrainoutapplyService.update(domain );
		TrmTrainOutApplyDTO dto = trmtrainoutapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyService.getTrmtrainoutapplyByEntities(this.trmtrainoutapplyMapping.toDomain(#trmtrainoutapplydtos)),'ehr-TrmTrainOutApply-Update')")
    @ApiOperation(value = "批量更新外部培训申请", tags = {"外部培训申请" },  notes = "批量更新外部培训申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainOutApplyDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.updateBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyMapping.toDomain(#trmtrainoutapplydto),'ehr-TrmTrainOutApply-Create')")
    @ApiOperation(value = "新建外部培训申请", tags = {"外部培训申请" },  notes = "新建外部培训申请")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies")
    @Transactional
    public ResponseEntity<TrmTrainOutApplyDTO> create(@RequestBody TrmTrainOutApplyDTO trmtrainoutapplydto) {
        TrmTrainOutApply domain = trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto);
		trmtrainoutapplyService.create(domain);
        TrmTrainOutApplyDTO dto = trmtrainoutapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainoutapplyMapping.toDomain(#trmtrainoutapplydtos),'ehr-TrmTrainOutApply-Create')")
    @ApiOperation(value = "批量新建外部培训申请", tags = {"外部培训申请" },  notes = "批量新建外部培训申请")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainOutApplyDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.createBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainOutApply-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"外部培训申请" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainoutapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainOutApplyDTO>> fetchDefault(TrmTrainOutApplySearchContext context) {
        Page<TrmTrainOutApply> domains = trmtrainoutapplyService.searchDefault(context) ;
        List<TrmTrainOutApplyDTO> list = trmtrainoutapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainOutApply-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"外部培训申请" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainoutapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainOutApplyDTO>> searchDefault(@RequestBody TrmTrainOutApplySearchContext context) {
        Page<TrmTrainOutApply> domains = trmtrainoutapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainoutapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

