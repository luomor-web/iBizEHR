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
import cn.ibizlab.ehr.core.sal.domain.SalSalary;
import cn.ibizlab.ehr.core.sal.service.ISalSalaryService;
import cn.ibizlab.ehr.core.sal.filter.SalSalarySearchContext;

@Slf4j
@Api(tags = {"员工薪酬" })
@RestController("WebApi-salsalary")
@RequestMapping("")
public class SalSalaryResource {

    @Autowired
    public ISalSalaryService salsalaryService;

    @Autowired
    @Lazy
    public SalSalaryMapping salsalaryMapping;

    @PreAuthorize("hasPermission(this.salsalaryMapping.toDomain(#salsalarydto),'ehr-SalSalary-Save')")
    @ApiOperation(value = "保存员工薪酬", tags = {"员工薪酬" },  notes = "保存员工薪酬")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSalaryDTO salsalarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalaryService.save(salsalaryMapping.toDomain(salsalarydto)));
    }

    @PreAuthorize("hasPermission(this.salsalaryMapping.toDomain(#salsalarydtos),'ehr-SalSalary-Save')")
    @ApiOperation(value = "批量保存员工薪酬", tags = {"员工薪酬" },  notes = "批量保存员工薪酬")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSalaryDTO> salsalarydtos) {
        salsalaryService.saveBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查员工薪酬", tags = {"员工薪酬" },  notes = "检查员工薪酬")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSalaryDTO salsalarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalaryService.checkKey(salsalaryMapping.toDomain(salsalarydto)));
    }

    @PostAuthorize("hasPermission(this.salsalaryMapping.toDomain(returnObject.body),'ehr-SalSalary-Get')")
    @ApiOperation(value = "获取员工薪酬", tags = {"员工薪酬" },  notes = "获取员工薪酬")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalaries/{salsalary_id}")
    public ResponseEntity<SalSalaryDTO> get(@PathVariable("salsalary_id") String salsalary_id) {
        SalSalary domain = salsalaryService.get(salsalary_id);
        SalSalaryDTO dto = salsalaryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取员工薪酬草稿", tags = {"员工薪酬" },  notes = "获取员工薪酬草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalaries/getdraft")
    public ResponseEntity<SalSalaryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalaryMapping.toDto(salsalaryService.getDraft(new SalSalary())));
    }

    @PreAuthorize("hasPermission(this.salsalaryService.get(#salsalary_id),'ehr-SalSalary-Remove')")
    @ApiOperation(value = "删除员工薪酬", tags = {"员工薪酬" },  notes = "删除员工薪酬")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalaries/{salsalary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalary_id") String salsalary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalaryService.remove(salsalary_id));
    }

    @PreAuthorize("hasPermission(this.salsalaryService.getSalsalaryByIds(#ids),'ehr-SalSalary-Remove')")
    @ApiOperation(value = "批量删除员工薪酬", tags = {"员工薪酬" },  notes = "批量删除员工薪酬")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalaryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsalaryMapping.toDomain(#salsalarydto),'ehr-SalSalary-Create')")
    @ApiOperation(value = "新建员工薪酬", tags = {"员工薪酬" },  notes = "新建员工薪酬")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries")
    @Transactional
    public ResponseEntity<SalSalaryDTO> create(@RequestBody SalSalaryDTO salsalarydto) {
        SalSalary domain = salsalaryMapping.toDomain(salsalarydto);
		salsalaryService.create(domain);
        SalSalaryDTO dto = salsalaryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalaryMapping.toDomain(#salsalarydtos),'ehr-SalSalary-Create')")
    @ApiOperation(value = "批量新建员工薪酬", tags = {"员工薪酬" },  notes = "批量新建员工薪酬")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSalaryDTO> salsalarydtos) {
        salsalaryService.createBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsalaryService.get(#salsalary_id),'ehr-SalSalary-Update')")
    @ApiOperation(value = "更新员工薪酬", tags = {"员工薪酬" },  notes = "更新员工薪酬")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalaries/{salsalary_id}")
    @Transactional
    public ResponseEntity<SalSalaryDTO> update(@PathVariable("salsalary_id") String salsalary_id, @RequestBody SalSalaryDTO salsalarydto) {
		SalSalary domain  = salsalaryMapping.toDomain(salsalarydto);
        domain .setSalsalaryid(salsalary_id);
		salsalaryService.update(domain );
		SalSalaryDTO dto = salsalaryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalaryService.getSalsalaryByEntities(this.salsalaryMapping.toDomain(#salsalarydtos)),'ehr-SalSalary-Update')")
    @ApiOperation(value = "批量更新员工薪酬", tags = {"员工薪酬" },  notes = "批量更新员工薪酬")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSalaryDTO> salsalarydtos) {
        salsalaryService.updateBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalary-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工薪酬" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalaries/fetchdefault")
	public ResponseEntity<List<SalSalaryDTO>> fetchDefault(SalSalarySearchContext context) {
        Page<SalSalary> domains = salsalaryService.searchDefault(context) ;
        List<SalSalaryDTO> list = salsalaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalary-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工薪酬" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalaries/searchdefault")
	public ResponseEntity<Page<SalSalaryDTO>> searchDefault(@RequestBody SalSalarySearchContext context) {
        Page<SalSalary> domains = salsalaryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

