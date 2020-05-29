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
import cn.ibizlab.ehr.core.vac.domain.VacInitnxj;
import cn.ibizlab.ehr.core.vac.service.IVacInitnxjService;
import cn.ibizlab.ehr.core.vac.filter.VacInitnxjSearchContext;

@Slf4j
@Api(tags = {"初始化年休假" })
@RestController("WebApi-vacinitnxj")
@RequestMapping("")
public class VacInitnxjResource {

    @Autowired
    public IVacInitnxjService vacinitnxjService;

    @Autowired
    @Lazy
    public VacInitnxjMapping vacinitnxjMapping;

    @ApiOperation(value = "检查初始化年休假", tags = {"初始化年休假" },  notes = "检查初始化年休假")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacInitnxjDTO vacinitnxjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.checkKey(vacinitnxjMapping.toDomain(vacinitnxjdto)));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdto),'ehr-VacInitnxj-Create')")
    @ApiOperation(value = "新建初始化年休假", tags = {"初始化年休假" },  notes = "新建初始化年休假")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs")
    @Transactional
    public ResponseEntity<VacInitnxjDTO> create(@RequestBody VacInitnxjDTO vacinitnxjdto) {
        VacInitnxj domain = vacinitnxjMapping.toDomain(vacinitnxjdto);
		vacinitnxjService.create(domain);
        VacInitnxjDTO dto = vacinitnxjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos),'ehr-VacInitnxj-Create')")
    @ApiOperation(value = "批量新建初始化年休假", tags = {"初始化年休假" },  notes = "批量新建初始化年休假")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacInitnxjDTO> vacinitnxjdtos) {
        vacinitnxjService.createBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取初始化年休假草稿", tags = {"初始化年休假" },  notes = "获取初始化年休假草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacinitnxjs/getdraft")
    public ResponseEntity<VacInitnxjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjMapping.toDto(vacinitnxjService.getDraft(new VacInitnxj())));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.get(#vacinitnxj_id),'ehr-VacInitnxj-Remove')")
    @ApiOperation(value = "删除初始化年休假", tags = {"初始化年休假" },  notes = "删除初始化年休假")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacinitnxjs/{vacinitnxj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacinitnxj_id") String vacinitnxj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.remove(vacinitnxj_id));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.getVacinitnxjByIds(#ids),'ehr-VacInitnxj-Remove')")
    @ApiOperation(value = "批量删除初始化年休假", tags = {"初始化年休假" },  notes = "批量删除初始化年休假")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacinitnxjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(returnObject.body),'ehr-VacInitnxj-Get')")
    @ApiOperation(value = "获取初始化年休假", tags = {"初始化年休假" },  notes = "获取初始化年休假")
	@RequestMapping(method = RequestMethod.GET, value = "/vacinitnxjs/{vacinitnxj_id}")
    public ResponseEntity<VacInitnxjDTO> get(@PathVariable("vacinitnxj_id") String vacinitnxj_id) {
        VacInitnxj domain = vacinitnxjService.get(vacinitnxj_id);
        VacInitnxjDTO dto = vacinitnxjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdto),'ehr-VacInitnxj-Save')")
    @ApiOperation(value = "保存初始化年休假", tags = {"初始化年休假" },  notes = "保存初始化年休假")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/save")
    public ResponseEntity<Boolean> save(@RequestBody VacInitnxjDTO vacinitnxjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.save(vacinitnxjMapping.toDomain(vacinitnxjdto)));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos),'ehr-VacInitnxj-Save')")
    @ApiOperation(value = "批量保存初始化年休假", tags = {"初始化年休假" },  notes = "批量保存初始化年休假")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacInitnxjDTO> vacinitnxjdtos) {
        vacinitnxjService.saveBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.get(#vacinitnxj_id),'ehr-VacInitnxj-Update')")
    @ApiOperation(value = "更新初始化年休假", tags = {"初始化年休假" },  notes = "更新初始化年休假")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacinitnxjs/{vacinitnxj_id}")
    @Transactional
    public ResponseEntity<VacInitnxjDTO> update(@PathVariable("vacinitnxj_id") String vacinitnxj_id, @RequestBody VacInitnxjDTO vacinitnxjdto) {
		VacInitnxj domain  = vacinitnxjMapping.toDomain(vacinitnxjdto);
        domain .setVacinitnxjid(vacinitnxj_id);
		vacinitnxjService.update(domain );
		VacInitnxjDTO dto = vacinitnxjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.getVacinitnxjByEntities(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos)),'ehr-VacInitnxj-Update')")
    @ApiOperation(value = "批量更新初始化年休假", tags = {"初始化年休假" },  notes = "批量更新初始化年休假")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacInitnxjDTO> vacinitnxjdtos) {
        vacinitnxjService.updateBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacInitnxj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"初始化年休假" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacinitnxjs/fetchdefault")
	public ResponseEntity<List<VacInitnxjDTO>> fetchDefault(VacInitnxjSearchContext context) {
        Page<VacInitnxj> domains = vacinitnxjService.searchDefault(context) ;
        List<VacInitnxjDTO> list = vacinitnxjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacInitnxj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"初始化年休假" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacinitnxjs/searchdefault")
	public ResponseEntity<Page<VacInitnxjDTO>> searchDefault(@RequestBody VacInitnxjSearchContext context) {
        Page<VacInitnxj> domains = vacinitnxjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacinitnxjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

