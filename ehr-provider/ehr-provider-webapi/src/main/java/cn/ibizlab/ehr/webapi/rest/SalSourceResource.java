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
import cn.ibizlab.ehr.core.sal.domain.SalSource;
import cn.ibizlab.ehr.core.sal.service.ISalSourceService;
import cn.ibizlab.ehr.core.sal.filter.SalSourceSearchContext;

@Slf4j
@Api(tags = {"薪酬计算源" })
@RestController("WebApi-salsource")
@RequestMapping("")
public class SalSourceResource {

    @Autowired
    public ISalSourceService salsourceService;

    @Autowired
    @Lazy
    public SalSourceMapping salsourceMapping;

    @PostAuthorize("hasPermission(this.salsourceMapping.toDomain(returnObject.body),'ehr-SalSource-Get')")
    @ApiOperation(value = "获取薪酬计算源", tags = {"薪酬计算源" },  notes = "获取薪酬计算源")
	@RequestMapping(method = RequestMethod.GET, value = "/salsources/{salsource_id}")
    public ResponseEntity<SalSourceDTO> get(@PathVariable("salsource_id") String salsource_id) {
        SalSource domain = salsourceService.get(salsource_id);
        SalSourceDTO dto = salsourceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsourceMapping.toDomain(#salsourcedto),'ehr-SalSource-Save')")
    @ApiOperation(value = "保存薪酬计算源", tags = {"薪酬计算源" },  notes = "保存薪酬计算源")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSourceDTO salsourcedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsourceService.save(salsourceMapping.toDomain(salsourcedto)));
    }

    @PreAuthorize("hasPermission(this.salsourceMapping.toDomain(#salsourcedtos),'ehr-SalSource-Save')")
    @ApiOperation(value = "批量保存薪酬计算源", tags = {"薪酬计算源" },  notes = "批量保存薪酬计算源")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSourceDTO> salsourcedtos) {
        salsourceService.saveBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsourceService.get(#salsource_id),'ehr-SalSource-Update')")
    @ApiOperation(value = "更新薪酬计算源", tags = {"薪酬计算源" },  notes = "更新薪酬计算源")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsources/{salsource_id}")
    @Transactional
    public ResponseEntity<SalSourceDTO> update(@PathVariable("salsource_id") String salsource_id, @RequestBody SalSourceDTO salsourcedto) {
		SalSource domain  = salsourceMapping.toDomain(salsourcedto);
        domain .setSalsourceid(salsource_id);
		salsourceService.update(domain );
		SalSourceDTO dto = salsourceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsourceService.getSalsourceByEntities(this.salsourceMapping.toDomain(#salsourcedtos)),'ehr-SalSource-Update')")
    @ApiOperation(value = "批量更新薪酬计算源", tags = {"薪酬计算源" },  notes = "批量更新薪酬计算源")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsources/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSourceDTO> salsourcedtos) {
        salsourceService.updateBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsourceService.get(#salsource_id),'ehr-SalSource-Remove')")
    @ApiOperation(value = "删除薪酬计算源", tags = {"薪酬计算源" },  notes = "删除薪酬计算源")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsources/{salsource_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsource_id") String salsource_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsourceService.remove(salsource_id));
    }

    @PreAuthorize("hasPermission(this.salsourceService.getSalsourceByIds(#ids),'ehr-SalSource-Remove')")
    @ApiOperation(value = "批量删除薪酬计算源", tags = {"薪酬计算源" },  notes = "批量删除薪酬计算源")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsources/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsourceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsourceMapping.toDomain(#salsourcedto),'ehr-SalSource-Create')")
    @ApiOperation(value = "新建薪酬计算源", tags = {"薪酬计算源" },  notes = "新建薪酬计算源")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources")
    @Transactional
    public ResponseEntity<SalSourceDTO> create(@RequestBody SalSourceDTO salsourcedto) {
        SalSource domain = salsourceMapping.toDomain(salsourcedto);
		salsourceService.create(domain);
        SalSourceDTO dto = salsourceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsourceMapping.toDomain(#salsourcedtos),'ehr-SalSource-Create')")
    @ApiOperation(value = "批量新建薪酬计算源", tags = {"薪酬计算源" },  notes = "批量新建薪酬计算源")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSourceDTO> salsourcedtos) {
        salsourceService.createBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查薪酬计算源", tags = {"薪酬计算源" },  notes = "检查薪酬计算源")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSourceDTO salsourcedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsourceService.checkKey(salsourceMapping.toDomain(salsourcedto)));
    }

    @ApiOperation(value = "获取薪酬计算源草稿", tags = {"薪酬计算源" },  notes = "获取薪酬计算源草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salsources/getdraft")
    public ResponseEntity<SalSourceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsourceMapping.toDto(salsourceService.getDraft(new SalSource())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSource-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬计算源" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsources/fetchdefault")
	public ResponseEntity<List<SalSourceDTO>> fetchDefault(SalSourceSearchContext context) {
        Page<SalSource> domains = salsourceService.searchDefault(context) ;
        List<SalSourceDTO> list = salsourceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSource-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬计算源" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsources/searchdefault")
	public ResponseEntity<Page<SalSourceDTO>> searchDefault(@RequestBody SalSourceSearchContext context) {
        Page<SalSource> domains = salsourceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsourceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

