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
import cn.ibizlab.ehr.core.par.domain.ParExamCycle;
import cn.ibizlab.ehr.core.par.service.IParExamCycleService;
import cn.ibizlab.ehr.core.par.filter.ParExamCycleSearchContext;

@Slf4j
@Api(tags = {"考核周期" })
@RestController("WebApi-parexamcycle")
@RequestMapping("")
public class ParExamCycleResource {

    @Autowired
    public IParExamCycleService parexamcycleService;

    @Autowired
    @Lazy
    public ParExamCycleMapping parexamcycleMapping;

    @PreAuthorize("hasPermission(this.parexamcycleService.get(#parexamcycle_id),'ehr-ParExamCycle-Update')")
    @ApiOperation(value = "更新考核周期", tags = {"考核周期" },  notes = "更新考核周期")
	@RequestMapping(method = RequestMethod.PUT, value = "/parexamcycles/{parexamcycle_id}")
    @Transactional
    public ResponseEntity<ParExamCycleDTO> update(@PathVariable("parexamcycle_id") String parexamcycle_id, @RequestBody ParExamCycleDTO parexamcycledto) {
		ParExamCycle domain  = parexamcycleMapping.toDomain(parexamcycledto);
        domain .setParexamcycleid(parexamcycle_id);
		parexamcycleService.update(domain );
		ParExamCycleDTO dto = parexamcycleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parexamcycleService.getParexamcycleByEntities(this.parexamcycleMapping.toDomain(#parexamcycledtos)),'ehr-ParExamCycle-Update')")
    @ApiOperation(value = "批量更新考核周期", tags = {"考核周期" },  notes = "批量更新考核周期")
	@RequestMapping(method = RequestMethod.PUT, value = "/parexamcycles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParExamCycleDTO> parexamcycledtos) {
        parexamcycleService.updateBatch(parexamcycleMapping.toDomain(parexamcycledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parexamcycleMapping.toDomain(#parexamcycledto),'ehr-ParExamCycle-Create')")
    @ApiOperation(value = "新建考核周期", tags = {"考核周期" },  notes = "新建考核周期")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcycles")
    @Transactional
    public ResponseEntity<ParExamCycleDTO> create(@RequestBody ParExamCycleDTO parexamcycledto) {
        ParExamCycle domain = parexamcycleMapping.toDomain(parexamcycledto);
		parexamcycleService.create(domain);
        ParExamCycleDTO dto = parexamcycleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parexamcycleMapping.toDomain(#parexamcycledtos),'ehr-ParExamCycle-Create')")
    @ApiOperation(value = "批量新建考核周期", tags = {"考核周期" },  notes = "批量新建考核周期")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcycles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParExamCycleDTO> parexamcycledtos) {
        parexamcycleService.createBatch(parexamcycleMapping.toDomain(parexamcycledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考核周期草稿", tags = {"考核周期" },  notes = "获取考核周期草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parexamcycles/getdraft")
    public ResponseEntity<ParExamCycleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parexamcycleMapping.toDto(parexamcycleService.getDraft(new ParExamCycle())));
    }

    @ApiOperation(value = "检查考核周期", tags = {"考核周期" },  notes = "检查考核周期")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcycles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParExamCycleDTO parexamcycledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parexamcycleService.checkKey(parexamcycleMapping.toDomain(parexamcycledto)));
    }

    @PreAuthorize("hasPermission(this.parexamcycleMapping.toDomain(#parexamcycledto),'ehr-ParExamCycle-Save')")
    @ApiOperation(value = "保存考核周期", tags = {"考核周期" },  notes = "保存考核周期")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcycles/save")
    public ResponseEntity<Boolean> save(@RequestBody ParExamCycleDTO parexamcycledto) {
        return ResponseEntity.status(HttpStatus.OK).body(parexamcycleService.save(parexamcycleMapping.toDomain(parexamcycledto)));
    }

    @PreAuthorize("hasPermission(this.parexamcycleMapping.toDomain(#parexamcycledtos),'ehr-ParExamCycle-Save')")
    @ApiOperation(value = "批量保存考核周期", tags = {"考核周期" },  notes = "批量保存考核周期")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcycles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParExamCycleDTO> parexamcycledtos) {
        parexamcycleService.saveBatch(parexamcycleMapping.toDomain(parexamcycledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parexamcycleService.get(#parexamcycle_id),'ehr-ParExamCycle-Remove')")
    @ApiOperation(value = "删除考核周期", tags = {"考核周期" },  notes = "删除考核周期")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parexamcycles/{parexamcycle_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parexamcycle_id") String parexamcycle_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parexamcycleService.remove(parexamcycle_id));
    }

    @PreAuthorize("hasPermission(this.parexamcycleService.getParexamcycleByIds(#ids),'ehr-ParExamCycle-Remove')")
    @ApiOperation(value = "批量删除考核周期", tags = {"考核周期" },  notes = "批量删除考核周期")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parexamcycles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parexamcycleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parexamcycleMapping.toDomain(returnObject.body),'ehr-ParExamCycle-Get')")
    @ApiOperation(value = "获取考核周期", tags = {"考核周期" },  notes = "获取考核周期")
	@RequestMapping(method = RequestMethod.GET, value = "/parexamcycles/{parexamcycle_id}")
    public ResponseEntity<ParExamCycleDTO> get(@PathVariable("parexamcycle_id") String parexamcycle_id) {
        ParExamCycle domain = parexamcycleService.get(parexamcycle_id);
        ParExamCycleDTO dto = parexamcycleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParExamCycle-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核周期" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parexamcycles/fetchdefault")
	public ResponseEntity<List<ParExamCycleDTO>> fetchDefault(ParExamCycleSearchContext context) {
        Page<ParExamCycle> domains = parexamcycleService.searchDefault(context) ;
        List<ParExamCycleDTO> list = parexamcycleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParExamCycle-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核周期" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parexamcycles/searchdefault")
	public ResponseEntity<Page<ParExamCycleDTO>> searchDefault(@RequestBody ParExamCycleSearchContext context) {
        Page<ParExamCycle> domains = parexamcycleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parexamcycleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

