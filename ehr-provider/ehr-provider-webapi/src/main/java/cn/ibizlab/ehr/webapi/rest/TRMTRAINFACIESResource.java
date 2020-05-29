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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFACIES;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINFACIESService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFACIESSearchContext;

@Slf4j
@Api(tags = {"培训设施" })
@RestController("WebApi-trmtrainfacies")
@RequestMapping("")
public class TRMTRAINFACIESResource {

    @Autowired
    public ITRMTRAINFACIESService trmtrainfaciesService;

    @Autowired
    @Lazy
    public TRMTRAINFACIESMapping trmtrainfaciesMapping;

    @ApiOperation(value = "检查培训设施", tags = {"培训设施" },  notes = "检查培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINFACIESDTO trmtrainfaciesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.checkKey(trmtrainfaciesMapping.toDomain(trmtrainfaciesdto)));
    }

    @ApiOperation(value = "获取培训设施草稿", tags = {"培训设施" },  notes = "获取培训设施草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfacies/getdraft")
    public ResponseEntity<TRMTRAINFACIESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesMapping.toDto(trmtrainfaciesService.getDraft(new TRMTRAINFACIES())));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TRMTRAINFACIES-Update')")
    @ApiOperation(value = "更新培训设施", tags = {"培训设施" },  notes = "更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFACIESDTO> update(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id, @RequestBody TRMTRAINFACIESDTO trmtrainfaciesdto) {
		TRMTRAINFACIES domain  = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
        domain .setTrmtrainfaciesid(trmtrainfacies_id);
		trmtrainfaciesService.update(domain );
		TRMTRAINFACIESDTO dto = trmtrainfaciesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByEntities(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos)),'ehr-TRMTRAINFACIES-Update')")
    @ApiOperation(value = "批量更新培训设施", tags = {"培训设施" },  notes = "批量更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINFACIESDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.updateBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TRMTRAINFACIES-Create')")
    @ApiOperation(value = "新建培训设施", tags = {"培训设施" },  notes = "新建培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies")
    @Transactional
    public ResponseEntity<TRMTRAINFACIESDTO> create(@RequestBody TRMTRAINFACIESDTO trmtrainfaciesdto) {
        TRMTRAINFACIES domain = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
		trmtrainfaciesService.create(domain);
        TRMTRAINFACIESDTO dto = trmtrainfaciesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TRMTRAINFACIES-Create')")
    @ApiOperation(value = "批量新建培训设施", tags = {"培训设施" },  notes = "批量新建培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINFACIESDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.createBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TRMTRAINFACIES-Remove')")
    @ApiOperation(value = "删除培训设施", tags = {"培训设施" },  notes = "删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.remove(trmtrainfacies_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByIds(#ids),'ehr-TRMTRAINFACIES-Remove')")
    @ApiOperation(value = "批量删除培训设施", tags = {"培训设施" },  notes = "批量删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfaciesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TRMTRAINFACIES-Save')")
    @ApiOperation(value = "保存培训设施", tags = {"培训设施" },  notes = "保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINFACIESDTO trmtrainfaciesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.save(trmtrainfaciesMapping.toDomain(trmtrainfaciesdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TRMTRAINFACIES-Save')")
    @ApiOperation(value = "批量保存培训设施", tags = {"培训设施" },  notes = "批量保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINFACIESDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.saveBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(returnObject.body),'ehr-TRMTRAINFACIES-Get')")
    @ApiOperation(value = "获取培训设施", tags = {"培训设施" },  notes = "获取培训设施")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfacies/{trmtrainfacies_id}")
    public ResponseEntity<TRMTRAINFACIESDTO> get(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
        TRMTRAINFACIES domain = trmtrainfaciesService.get(trmtrainfacies_id);
        TRMTRAINFACIESDTO dto = trmtrainfaciesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFACIES-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训设施" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfacies/fetchdefault")
	public ResponseEntity<List<TRMTRAINFACIESDTO>> fetchDefault(TRMTRAINFACIESSearchContext context) {
        Page<TRMTRAINFACIES> domains = trmtrainfaciesService.searchDefault(context) ;
        List<TRMTRAINFACIESDTO> list = trmtrainfaciesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFACIES-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训设施" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfacies/searchdefault")
	public ResponseEntity<Page<TRMTRAINFACIESDTO>> searchDefault(@RequestBody TRMTRAINFACIESSearchContext context) {
        Page<TRMTRAINFACIES> domains = trmtrainfaciesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfaciesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

