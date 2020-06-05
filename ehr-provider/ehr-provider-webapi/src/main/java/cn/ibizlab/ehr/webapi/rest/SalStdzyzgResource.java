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
import cn.ibizlab.ehr.core.sal.domain.SalStdzyzg;
import cn.ibizlab.ehr.core.sal.service.ISalStdzyzgService;
import cn.ibizlab.ehr.core.sal.filter.SalStdzyzgSearchContext;

@Slf4j
@Api(tags = {"执业资格津贴标准" })
@RestController("WebApi-salstdzyzg")
@RequestMapping("")
public class SalStdzyzgResource {

    @Autowired
    public ISalStdzyzgService salstdzyzgService;

    @Autowired
    @Lazy
    public SalStdzyzgMapping salstdzyzgMapping;

    @PreAuthorize("hasPermission(this.salstdzyzgService.get(#salstdzyzg_id),'ehr-SalStdzyzg-Update')")
    @ApiOperation(value = "更新执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "更新执业资格津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzyzgs/{salstdzyzg_id}")
    @Transactional
    public ResponseEntity<SalStdzyzgDTO> update(@PathVariable("salstdzyzg_id") String salstdzyzg_id, @RequestBody SalStdzyzgDTO salstdzyzgdto) {
		SalStdzyzg domain  = salstdzyzgMapping.toDomain(salstdzyzgdto);
        domain .setSalstdzyzgid(salstdzyzg_id);
		salstdzyzgService.update(domain );
		SalStdzyzgDTO dto = salstdzyzgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzyzgService.getSalstdzyzgByEntities(this.salstdzyzgMapping.toDomain(#salstdzyzgdtos)),'ehr-SalStdzyzg-Update')")
    @ApiOperation(value = "批量更新执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "批量更新执业资格津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdzyzgDTO> salstdzyzgdtos) {
        salstdzyzgService.updateBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdzyzgMapping.toDomain(returnObject.body),'ehr-SalStdzyzg-Get')")
    @ApiOperation(value = "获取执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "获取执业资格津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzyzgs/{salstdzyzg_id}")
    public ResponseEntity<SalStdzyzgDTO> get(@PathVariable("salstdzyzg_id") String salstdzyzg_id) {
        SalStdzyzg domain = salstdzyzgService.get(salstdzyzg_id);
        SalStdzyzgDTO dto = salstdzyzgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzyzgService.get(#salstdzyzg_id),'ehr-SalStdzyzg-Remove')")
    @ApiOperation(value = "删除执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "删除执业资格津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzyzgs/{salstdzyzg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzyzg_id") String salstdzyzg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.remove(salstdzyzg_id));
    }

    @PreAuthorize("hasPermission(this.salstdzyzgService.getSalstdzyzgByIds(#ids),'ehr-SalStdzyzg-Remove')")
    @ApiOperation(value = "批量删除执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "批量删除执业资格津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzyzgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzyzgMapping.toDomain(#salstdzyzgdto),'ehr-SalStdzyzg-Create')")
    @ApiOperation(value = "新建执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "新建执业资格津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs")
    @Transactional
    public ResponseEntity<SalStdzyzgDTO> create(@RequestBody SalStdzyzgDTO salstdzyzgdto) {
        SalStdzyzg domain = salstdzyzgMapping.toDomain(salstdzyzgdto);
		salstdzyzgService.create(domain);
        SalStdzyzgDTO dto = salstdzyzgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzyzgMapping.toDomain(#salstdzyzgdtos),'ehr-SalStdzyzg-Create')")
    @ApiOperation(value = "批量新建执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "批量新建执业资格津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdzyzgDTO> salstdzyzgdtos) {
        salstdzyzgService.createBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取执业资格津贴标准草稿", tags = {"执业资格津贴标准" },  notes = "获取执业资格津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzyzgs/getdraft")
    public ResponseEntity<SalStdzyzgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgMapping.toDto(salstdzyzgService.getDraft(new SalStdzyzg())));
    }

    @ApiOperation(value = "检查执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "检查执业资格津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdzyzgDTO salstdzyzgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.checkKey(salstdzyzgMapping.toDomain(salstdzyzgdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzyzgMapping.toDomain(#salstdzyzgdto),'ehr-SalStdzyzg-Save')")
    @ApiOperation(value = "保存执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "保存执业资格津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdzyzgDTO salstdzyzgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.save(salstdzyzgMapping.toDomain(salstdzyzgdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzyzgMapping.toDomain(#salstdzyzgdtos),'ehr-SalStdzyzg-Save')")
    @ApiOperation(value = "批量保存执业资格津贴标准", tags = {"执业资格津贴标准" },  notes = "批量保存执业资格津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdzyzgDTO> salstdzyzgdtos) {
        salstdzyzgService.saveBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzyzg-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"执业资格津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzyzgs/fetchdefault")
	public ResponseEntity<List<SalStdzyzgDTO>> fetchDefault(SalStdzyzgSearchContext context) {
        Page<SalStdzyzg> domains = salstdzyzgService.searchDefault(context) ;
        List<SalStdzyzgDTO> list = salstdzyzgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzyzg-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"执业资格津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzyzgs/searchdefault")
	public ResponseEntity<Page<SalStdzyzgDTO>> searchDefault(@RequestBody SalStdzyzgSearchContext context) {
        Page<SalStdzyzg> domains = salstdzyzgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzyzgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

