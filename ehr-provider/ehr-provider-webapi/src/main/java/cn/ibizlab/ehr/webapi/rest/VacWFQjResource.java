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
import cn.ibizlab.ehr.core.vac.domain.VacWFQj;
import cn.ibizlab.ehr.core.vac.service.IVacWFQjService;
import cn.ibizlab.ehr.core.vac.filter.VacWFQjSearchContext;

@Slf4j
@Api(tags = {"请假（WF）" })
@RestController("WebApi-vacwfqj")
@RequestMapping("")
public class VacWFQjResource {

    @Autowired
    public IVacWFQjService vacwfqjService;

    @Autowired
    @Lazy
    public VacWFQjMapping vacwfqjMapping;

    @PreAuthorize("hasPermission(this.vacwfqjService.get(#vacwfqj_id),'ehr-VacWFQj-Update')")
    @ApiOperation(value = "更新请假（WF）", tags = {"请假（WF）" },  notes = "更新请假（WF）")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacwfqjs/{vacwfqj_id}")
    @Transactional
    public ResponseEntity<VacWFQjDTO> update(@PathVariable("vacwfqj_id") String vacwfqj_id, @RequestBody VacWFQjDTO vacwfqjdto) {
		VacWFQj domain  = vacwfqjMapping.toDomain(vacwfqjdto);
        domain .setWfqjid(vacwfqj_id);
		vacwfqjService.update(domain );
		VacWFQjDTO dto = vacwfqjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacwfqjService.getVacwfqjByEntities(this.vacwfqjMapping.toDomain(#vacwfqjdtos)),'ehr-VacWFQj-Update')")
    @ApiOperation(value = "批量更新请假（WF）", tags = {"请假（WF）" },  notes = "批量更新请假（WF）")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacwfqjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacWFQjDTO> vacwfqjdtos) {
        vacwfqjService.updateBatch(vacwfqjMapping.toDomain(vacwfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查请假（WF）", tags = {"请假（WF）" },  notes = "检查请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/vacwfqjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacWFQjDTO vacwfqjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacwfqjService.checkKey(vacwfqjMapping.toDomain(vacwfqjdto)));
    }

    @PreAuthorize("hasPermission(this.vacwfqjMapping.toDomain(#vacwfqjdto),'ehr-VacWFQj-Create')")
    @ApiOperation(value = "新建请假（WF）", tags = {"请假（WF）" },  notes = "新建请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/vacwfqjs")
    @Transactional
    public ResponseEntity<VacWFQjDTO> create(@RequestBody VacWFQjDTO vacwfqjdto) {
        VacWFQj domain = vacwfqjMapping.toDomain(vacwfqjdto);
		vacwfqjService.create(domain);
        VacWFQjDTO dto = vacwfqjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacwfqjMapping.toDomain(#vacwfqjdtos),'ehr-VacWFQj-Create')")
    @ApiOperation(value = "批量新建请假（WF）", tags = {"请假（WF）" },  notes = "批量新建请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/vacwfqjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacWFQjDTO> vacwfqjdtos) {
        vacwfqjService.createBatch(vacwfqjMapping.toDomain(vacwfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacwfqjMapping.toDomain(#vacwfqjdto),'ehr-VacWFQj-Save')")
    @ApiOperation(value = "保存请假（WF）", tags = {"请假（WF）" },  notes = "保存请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/vacwfqjs/save")
    public ResponseEntity<Boolean> save(@RequestBody VacWFQjDTO vacwfqjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacwfqjService.save(vacwfqjMapping.toDomain(vacwfqjdto)));
    }

    @PreAuthorize("hasPermission(this.vacwfqjMapping.toDomain(#vacwfqjdtos),'ehr-VacWFQj-Save')")
    @ApiOperation(value = "批量保存请假（WF）", tags = {"请假（WF）" },  notes = "批量保存请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/vacwfqjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacWFQjDTO> vacwfqjdtos) {
        vacwfqjService.saveBatch(vacwfqjMapping.toDomain(vacwfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取请假（WF）草稿", tags = {"请假（WF）" },  notes = "获取请假（WF）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacwfqjs/getdraft")
    public ResponseEntity<VacWFQjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacwfqjMapping.toDto(vacwfqjService.getDraft(new VacWFQj())));
    }

    @PreAuthorize("hasPermission(this.vacwfqjService.get(#vacwfqj_id),'ehr-VacWFQj-Remove')")
    @ApiOperation(value = "删除请假（WF）", tags = {"请假（WF）" },  notes = "删除请假（WF）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacwfqjs/{vacwfqj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacwfqj_id") String vacwfqj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacwfqjService.remove(vacwfqj_id));
    }

    @PreAuthorize("hasPermission(this.vacwfqjService.getVacwfqjByIds(#ids),'ehr-VacWFQj-Remove')")
    @ApiOperation(value = "批量删除请假（WF）", tags = {"请假（WF）" },  notes = "批量删除请假（WF）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacwfqjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacwfqjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacwfqjMapping.toDomain(returnObject.body),'ehr-VacWFQj-Get')")
    @ApiOperation(value = "获取请假（WF）", tags = {"请假（WF）" },  notes = "获取请假（WF）")
	@RequestMapping(method = RequestMethod.GET, value = "/vacwfqjs/{vacwfqj_id}")
    public ResponseEntity<VacWFQjDTO> get(@PathVariable("vacwfqj_id") String vacwfqj_id) {
        VacWFQj domain = vacwfqjService.get(vacwfqj_id);
        VacWFQjDTO dto = vacwfqjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacWFQj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"请假（WF）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacwfqjs/fetchdefault")
	public ResponseEntity<List<VacWFQjDTO>> fetchDefault(VacWFQjSearchContext context) {
        Page<VacWFQj> domains = vacwfqjService.searchDefault(context) ;
        List<VacWFQjDTO> list = vacwfqjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacWFQj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"请假（WF）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacwfqjs/searchdefault")
	public ResponseEntity<Page<VacWFQjDTO>> searchDefault(@RequestBody VacWFQjSearchContext context) {
        Page<VacWFQj> domains = vacwfqjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacwfqjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

