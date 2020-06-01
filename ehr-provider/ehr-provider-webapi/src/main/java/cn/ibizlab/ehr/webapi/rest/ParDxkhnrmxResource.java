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
import cn.ibizlab.ehr.core.par.domain.ParDxkhnrmx;
import cn.ibizlab.ehr.core.par.service.IParDxkhnrmxService;
import cn.ibizlab.ehr.core.par.filter.ParDxkhnrmxSearchContext;

@Slf4j
@Api(tags = {"考核评分表" })
@RestController("WebApi-pardxkhnrmx")
@RequestMapping("")
public class ParDxkhnrmxResource {

    @Autowired
    public IParDxkhnrmxService pardxkhnrmxService;

    @Autowired
    @Lazy
    public ParDxkhnrmxMapping pardxkhnrmxMapping;

    @PreAuthorize("hasPermission(this.pardxkhnrmxService.get(#pardxkhnrmx_id),'ehr-ParDxkhnrmx-Remove')")
    @ApiOperation(value = "删除考核评分表", tags = {"考核评分表" },  notes = "删除考核评分表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.remove(pardxkhnrmx_id));
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxService.getPardxkhnrmxByIds(#ids),'ehr-ParDxkhnrmx-Remove')")
    @ApiOperation(value = "批量删除考核评分表", tags = {"考核评分表" },  notes = "批量删除考核评分表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pardxkhnrmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxMapping.toDomain(#pardxkhnrmxdto),'ehr-ParDxkhnrmx-Save')")
    @ApiOperation(value = "保存考核评分表", tags = {"考核评分表" },  notes = "保存考核评分表")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParDxkhnrmxDTO pardxkhnrmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.save(pardxkhnrmxMapping.toDomain(pardxkhnrmxdto)));
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxMapping.toDomain(#pardxkhnrmxdtos),'ehr-ParDxkhnrmx-Save')")
    @ApiOperation(value = "批量保存考核评分表", tags = {"考核评分表" },  notes = "批量保存考核评分表")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParDxkhnrmxDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.saveBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考核评分表", tags = {"考核评分表" },  notes = "检查考核评分表")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParDxkhnrmxDTO pardxkhnrmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.checkKey(pardxkhnrmxMapping.toDomain(pardxkhnrmxdto)));
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxMapping.toDomain(#pardxkhnrmxdto),'ehr-ParDxkhnrmx-Create')")
    @ApiOperation(value = "新建考核评分表", tags = {"考核评分表" },  notes = "新建考核评分表")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes")
    @Transactional
    public ResponseEntity<ParDxkhnrmxDTO> create(@RequestBody ParDxkhnrmxDTO pardxkhnrmxdto) {
        ParDxkhnrmx domain = pardxkhnrmxMapping.toDomain(pardxkhnrmxdto);
		pardxkhnrmxService.create(domain);
        ParDxkhnrmxDTO dto = pardxkhnrmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxMapping.toDomain(#pardxkhnrmxdtos),'ehr-ParDxkhnrmx-Create')")
    @ApiOperation(value = "批量新建考核评分表", tags = {"考核评分表" },  notes = "批量新建考核评分表")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParDxkhnrmxDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.createBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考核评分表草稿", tags = {"考核评分表" },  notes = "获取考核评分表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pardxkhnrmxes/getdraft")
    public ResponseEntity<ParDxkhnrmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxMapping.toDto(pardxkhnrmxService.getDraft(new ParDxkhnrmx())));
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxService.get(#pardxkhnrmx_id),'ehr-ParDxkhnrmx-Update')")
    @ApiOperation(value = "更新考核评分表", tags = {"考核评分表" },  notes = "更新考核评分表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    @Transactional
    public ResponseEntity<ParDxkhnrmxDTO> update(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id, @RequestBody ParDxkhnrmxDTO pardxkhnrmxdto) {
		ParDxkhnrmx domain  = pardxkhnrmxMapping.toDomain(pardxkhnrmxdto);
        domain .setPardxkhnrmxid(pardxkhnrmx_id);
		pardxkhnrmxService.update(domain );
		ParDxkhnrmxDTO dto = pardxkhnrmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pardxkhnrmxService.getPardxkhnrmxByEntities(this.pardxkhnrmxMapping.toDomain(#pardxkhnrmxdtos)),'ehr-ParDxkhnrmx-Update')")
    @ApiOperation(value = "批量更新考核评分表", tags = {"考核评分表" },  notes = "批量更新考核评分表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParDxkhnrmxDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.updateBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pardxkhnrmxMapping.toDomain(returnObject.body),'ehr-ParDxkhnrmx-Get')")
    @ApiOperation(value = "获取考核评分表", tags = {"考核评分表" },  notes = "获取考核评分表")
	@RequestMapping(method = RequestMethod.GET, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    public ResponseEntity<ParDxkhnrmxDTO> get(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id) {
        ParDxkhnrmx domain = pardxkhnrmxService.get(pardxkhnrmx_id);
        ParDxkhnrmxDTO dto = pardxkhnrmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParDxkhnrmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核评分表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pardxkhnrmxes/fetchdefault")
	public ResponseEntity<List<ParDxkhnrmxDTO>> fetchDefault(ParDxkhnrmxSearchContext context) {
        Page<ParDxkhnrmx> domains = pardxkhnrmxService.searchDefault(context) ;
        List<ParDxkhnrmxDTO> list = pardxkhnrmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParDxkhnrmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核评分表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pardxkhnrmxes/searchdefault")
	public ResponseEntity<Page<ParDxkhnrmxDTO>> searchDefault(@RequestBody ParDxkhnrmxSearchContext context) {
        Page<ParDxkhnrmx> domains = pardxkhnrmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pardxkhnrmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

