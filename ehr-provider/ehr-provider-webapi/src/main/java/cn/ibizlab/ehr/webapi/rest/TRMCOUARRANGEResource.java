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
import cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE;
import cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService;
import cn.ibizlab.ehr.core.trm.filter.TRMCOUARRANGESearchContext;

@Slf4j
@Api(tags = {"培训记录" })
@RestController("WebApi-trmcouarrange")
@RequestMapping("")
public class TRMCOUARRANGEResource {

    @Autowired
    public ITRMCOUARRANGEService trmcouarrangeService;

    @Autowired
    @Lazy
    public TRMCOUARRANGEMapping trmcouarrangeMapping;

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TRMCOUARRANGE-Create')")
    @ApiOperation(value = "新建培训记录", tags = {"培训记录" },  notes = "新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges")
    @Transactional
    public ResponseEntity<TRMCOUARRANGEDTO> create(@RequestBody TRMCOUARRANGEDTO trmcouarrangedto) {
        TRMCOUARRANGE domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
		trmcouarrangeService.create(domain);
        TRMCOUARRANGEDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TRMCOUARRANGE-Create')")
    @ApiOperation(value = "批量新建培训记录", tags = {"培训记录" },  notes = "批量新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMCOUARRANGEDTO> trmcouarrangedtos) {
        trmcouarrangeService.createBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TRMCOUARRANGE-Get')")
    @ApiOperation(value = "获取培训记录", tags = {"培训记录" },  notes = "获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TRMCOUARRANGEDTO> get(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TRMCOUARRANGE domain = trmcouarrangeService.get(trmcouarrange_id);
        TRMCOUARRANGEDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TRMCOUARRANGE-Remove')")
    @ApiOperation(value = "删除培训记录", tags = {"培训记录" },  notes = "删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TRMCOUARRANGE-Remove')")
    @ApiOperation(value = "批量删除培训记录", tags = {"培训记录" },  notes = "批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训记录草稿", tags = {"培训记录" },  notes = "获取培训记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/getdraft")
    public ResponseEntity<TRMCOUARRANGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(new TRMCOUARRANGE())));
    }

    @ApiOperation(value = "检查培训记录", tags = {"培训记录" },  notes = "检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMCOUARRANGEDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TRMCOUARRANGE-Save')")
    @ApiOperation(value = "保存培训记录", tags = {"培训记录" },  notes = "保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMCOUARRANGEDTO trmcouarrangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TRMCOUARRANGE-Save')")
    @ApiOperation(value = "批量保存培训记录", tags = {"培训记录" },  notes = "批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMCOUARRANGEDTO> trmcouarrangedtos) {
        trmcouarrangeService.saveBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TRMCOUARRANGE-Update')")
    @ApiOperation(value = "更新培训记录", tags = {"培训记录" },  notes = "更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TRMCOUARRANGEDTO> update(@PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TRMCOUARRANGEDTO trmcouarrangedto) {
		TRMCOUARRANGE domain  = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain .setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain );
		TRMCOUARRANGEDTO dto = trmcouarrangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TRMCOUARRANGE-Update')")
    @ApiOperation(value = "批量更新培训记录", tags = {"培训记录" },  notes = "批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMCOUARRANGEDTO> trmcouarrangedtos) {
        trmcouarrangeService.updateBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMCOUARRANGE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TRMCOUARRANGEDTO>> fetchDefault(TRMCOUARRANGESearchContext context) {
        Page<TRMCOUARRANGE> domains = trmcouarrangeService.searchDefault(context) ;
        List<TRMCOUARRANGEDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMCOUARRANGE-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TRMCOUARRANGEDTO>> searchDefault(@RequestBody TRMCOUARRANGESearchContext context) {
        Page<TRMCOUARRANGE> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

