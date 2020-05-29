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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainBuapply;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainBuapplyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainBuapplySearchContext;

@Slf4j
@Api(tags = {"教育经费" })
@RestController("WebApi-trmtrainbuapply")
@RequestMapping("")
public class TrmTrainBuapplyResource {

    @Autowired
    public ITrmTrainBuapplyService trmtrainbuapplyService;

    @Autowired
    @Lazy
    public TrmTrainBuapplyMapping trmtrainbuapplyMapping;

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "新建教育经费", tags = {"教育经费" },  notes = "新建教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> create(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "批量新建教育经费", tags = {"教育经费" },  notes = "批量新建教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.createBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "更新教育经费", tags = {"教育经费" },  notes = "更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> update(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
		TrmTrainBuapply domain  = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain .setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain );
		TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "批量更新教育经费", tags = {"教育经费" },  notes = "批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.updateBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取教育经费草稿", tags = {"教育经费" },  notes = "获取教育经费草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(new TrmTrainBuapply())));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "获取教育经费", tags = {"教育经费" },  notes = "获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> get(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查教育经费", tags = {"教育经费" },  notes = "检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "删除教育经费", tags = {"教育经费" },  notes = "删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "批量删除教育经费", tags = {"教育经费" },  notes = "批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "保存教育经费", tags = {"教育经费" },  notes = "保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "批量保存教育经费", tags = {"教育经费" },  notes = "批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.saveBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"教育经费" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchDefault(TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"教育经费" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchDefault(@RequestBody TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

