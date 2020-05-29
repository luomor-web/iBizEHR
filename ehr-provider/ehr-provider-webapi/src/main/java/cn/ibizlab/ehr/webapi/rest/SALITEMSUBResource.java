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
import cn.ibizlab.ehr.core.sal.domain.SALITEMSUB;
import cn.ibizlab.ehr.core.sal.service.ISALITEMSUBService;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSUBSearchContext;

@Slf4j
@Api(tags = {"薪酬要素项维护" })
@RestController("WebApi-salitemsub")
@RequestMapping("")
public class SALITEMSUBResource {

    @Autowired
    public ISALITEMSUBService salitemsubService;

    @Autowired
    @Lazy
    public SALITEMSUBMapping salitemsubMapping;

    @PostAuthorize("hasPermission(this.salitemsubMapping.toDomain(returnObject.body),'ehr-SALITEMSUB-Get')")
    @ApiOperation(value = "获取薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "获取薪酬要素项维护")
	@RequestMapping(method = RequestMethod.GET, value = "/salitemsubs/{salitemsub_id}")
    public ResponseEntity<SALITEMSUBDTO> get(@PathVariable("salitemsub_id") String salitemsub_id) {
        SALITEMSUB domain = salitemsubService.get(salitemsub_id);
        SALITEMSUBDTO dto = salitemsubMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemsubService.get(#salitemsub_id),'ehr-SALITEMSUB-Update')")
    @ApiOperation(value = "更新薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "更新薪酬要素项维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitemsubs/{salitemsub_id}")
    @Transactional
    public ResponseEntity<SALITEMSUBDTO> update(@PathVariable("salitemsub_id") String salitemsub_id, @RequestBody SALITEMSUBDTO salitemsubdto) {
		SALITEMSUB domain  = salitemsubMapping.toDomain(salitemsubdto);
        domain .setSalitemsubid(salitemsub_id);
		salitemsubService.update(domain );
		SALITEMSUBDTO dto = salitemsubMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemsubService.getSalitemsubByEntities(this.salitemsubMapping.toDomain(#salitemsubdtos)),'ehr-SALITEMSUB-Update')")
    @ApiOperation(value = "批量更新薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "批量更新薪酬要素项维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.updateBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salitemsubService.get(#salitemsub_id),'ehr-SALITEMSUB-Remove')")
    @ApiOperation(value = "删除薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "删除薪酬要素项维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitemsubs/{salitemsub_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salitemsub_id") String salitemsub_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salitemsubService.remove(salitemsub_id));
    }

    @PreAuthorize("hasPermission(this.salitemsubService.getSalitemsubByIds(#ids),'ehr-SALITEMSUB-Remove')")
    @ApiOperation(value = "批量删除薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "批量删除薪酬要素项维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salitemsubService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "检查薪酬要素项维护")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALITEMSUBDTO salitemsubdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salitemsubService.checkKey(salitemsubMapping.toDomain(salitemsubdto)));
    }

    @PreAuthorize("hasPermission(this.salitemsubMapping.toDomain(#salitemsubdto),'ehr-SALITEMSUB-Save')")
    @ApiOperation(value = "保存薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "保存薪酬要素项维护")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALITEMSUBDTO salitemsubdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salitemsubService.save(salitemsubMapping.toDomain(salitemsubdto)));
    }

    @PreAuthorize("hasPermission(this.salitemsubMapping.toDomain(#salitemsubdtos),'ehr-SALITEMSUB-Save')")
    @ApiOperation(value = "批量保存薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "批量保存薪酬要素项维护")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.saveBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取薪酬要素项维护草稿", tags = {"薪酬要素项维护" },  notes = "获取薪酬要素项维护草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salitemsubs/getdraft")
    public ResponseEntity<SALITEMSUBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salitemsubMapping.toDto(salitemsubService.getDraft(new SALITEMSUB())));
    }

    @PreAuthorize("hasPermission(this.salitemsubMapping.toDomain(#salitemsubdto),'ehr-SALITEMSUB-Create')")
    @ApiOperation(value = "新建薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "新建薪酬要素项维护")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs")
    @Transactional
    public ResponseEntity<SALITEMSUBDTO> create(@RequestBody SALITEMSUBDTO salitemsubdto) {
        SALITEMSUB domain = salitemsubMapping.toDomain(salitemsubdto);
		salitemsubService.create(domain);
        SALITEMSUBDTO dto = salitemsubMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemsubMapping.toDomain(#salitemsubdtos),'ehr-SALITEMSUB-Create')")
    @ApiOperation(value = "批量新建薪酬要素项维护", tags = {"薪酬要素项维护" },  notes = "批量新建薪酬要素项维护")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.createBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALITEMSUB-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬要素项维护" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salitemsubs/fetchdefault")
	public ResponseEntity<List<SALITEMSUBDTO>> fetchDefault(SALITEMSUBSearchContext context) {
        Page<SALITEMSUB> domains = salitemsubService.searchDefault(context) ;
        List<SALITEMSUBDTO> list = salitemsubMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALITEMSUB-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬要素项维护" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salitemsubs/searchdefault")
	public ResponseEntity<Page<SALITEMSUBDTO>> searchDefault(@RequestBody SALITEMSUBSearchContext context) {
        Page<SALITEMSUB> domains = salitemsubService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salitemsubMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

