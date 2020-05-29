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
import cn.ibizlab.ehr.core.trm.domain.TRMSTAY;
import cn.ibizlab.ehr.core.trm.service.ITRMSTAYService;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAYSearchContext;

@Slf4j
@Api(tags = {"培训住宿" })
@RestController("WebApi-trmstay")
@RequestMapping("")
public class TRMSTAYResource {

    @Autowired
    public ITRMSTAYService trmstayService;

    @Autowired
    @Lazy
    public TRMSTAYMapping trmstayMapping;

    @ApiOperation(value = "获取培训住宿草稿", tags = {"培训住宿" },  notes = "获取培训住宿草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstays/getdraft")
    public ResponseEntity<TRMSTAYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstayMapping.toDto(trmstayService.getDraft(new TRMSTAY())));
    }

    @PostAuthorize("hasPermission(this.trmstayMapping.toDomain(returnObject.body),'ehr-TRMSTAY-Get')")
    @ApiOperation(value = "获取培训住宿", tags = {"培训住宿" },  notes = "获取培训住宿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstays/{trmstay_id}")
    public ResponseEntity<TRMSTAYDTO> get(@PathVariable("trmstay_id") String trmstay_id) {
        TRMSTAY domain = trmstayService.get(trmstay_id);
        TRMSTAYDTO dto = trmstayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TRMSTAY-Remove')")
    @ApiOperation(value = "删除培训住宿", tags = {"培训住宿" },  notes = "删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstay_id") String trmstay_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstayService.remove(trmstay_id));
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByIds(#ids),'ehr-TRMSTAY-Remove')")
    @ApiOperation(value = "批量删除培训住宿", tags = {"培训住宿" },  notes = "批量删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TRMSTAY-Save')")
    @ApiOperation(value = "保存培训住宿", tags = {"培训住宿" },  notes = "保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMSTAYDTO trmstaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstayService.save(trmstayMapping.toDomain(trmstaydto)));
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TRMSTAY-Save')")
    @ApiOperation(value = "批量保存培训住宿", tags = {"培训住宿" },  notes = "批量保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMSTAYDTO> trmstaydtos) {
        trmstayService.saveBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TRMSTAY-Update')")
    @ApiOperation(value = "更新培训住宿", tags = {"培训住宿" },  notes = "更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<TRMSTAYDTO> update(@PathVariable("trmstay_id") String trmstay_id, @RequestBody TRMSTAYDTO trmstaydto) {
		TRMSTAY domain  = trmstayMapping.toDomain(trmstaydto);
        domain .setTrmstayid(trmstay_id);
		trmstayService.update(domain );
		TRMSTAYDTO dto = trmstayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByEntities(this.trmstayMapping.toDomain(#trmstaydtos)),'ehr-TRMSTAY-Update')")
    @ApiOperation(value = "批量更新培训住宿", tags = {"培训住宿" },  notes = "批量更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMSTAYDTO> trmstaydtos) {
        trmstayService.updateBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TRMSTAY-Create')")
    @ApiOperation(value = "新建培训住宿", tags = {"培训住宿" },  notes = "新建培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays")
    @Transactional
    public ResponseEntity<TRMSTAYDTO> create(@RequestBody TRMSTAYDTO trmstaydto) {
        TRMSTAY domain = trmstayMapping.toDomain(trmstaydto);
		trmstayService.create(domain);
        TRMSTAYDTO dto = trmstayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TRMSTAY-Create')")
    @ApiOperation(value = "批量新建培训住宿", tags = {"培训住宿" },  notes = "批量新建培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMSTAYDTO> trmstaydtos) {
        trmstayService.createBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训住宿", tags = {"培训住宿" },  notes = "检查培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMSTAYDTO trmstaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstayService.checkKey(trmstayMapping.toDomain(trmstaydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAY-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训住宿" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstays/fetchdefault")
	public ResponseEntity<List<TRMSTAYDTO>> fetchDefault(TRMSTAYSearchContext context) {
        Page<TRMSTAY> domains = trmstayService.searchDefault(context) ;
        List<TRMSTAYDTO> list = trmstayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAY-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训住宿" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstays/searchdefault")
	public ResponseEntity<Page<TRMSTAYDTO>> searchDefault(@RequestBody TRMSTAYSearchContext context) {
        Page<TRMSTAY> domains = trmstayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

