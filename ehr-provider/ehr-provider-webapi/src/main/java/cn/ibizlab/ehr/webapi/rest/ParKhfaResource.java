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
import cn.ibizlab.ehr.core.par.domain.ParKhfa;
import cn.ibizlab.ehr.core.par.service.IParKhfaService;
import cn.ibizlab.ehr.core.par.filter.ParKhfaSearchContext;

@Slf4j
@Api(tags = {"考核对象" })
@RestController("WebApi-parkhfa")
@RequestMapping("")
public class ParKhfaResource {

    @Autowired
    public IParKhfaService parkhfaService;

    @Autowired
    @Lazy
    public ParKhfaMapping parkhfaMapping;

    @PreAuthorize("hasPermission(this.parkhfaService.get(#parkhfa_id),'ehr-ParKhfa-Remove')")
    @ApiOperation(value = "删除考核对象", tags = {"考核对象" },  notes = "删除考核对象")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhfas/{parkhfa_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parkhfa_id") String parkhfa_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parkhfaService.remove(parkhfa_id));
    }

    @PreAuthorize("hasPermission(this.parkhfaService.getParkhfaByIds(#ids),'ehr-ParKhfa-Remove')")
    @ApiOperation(value = "批量删除考核对象", tags = {"考核对象" },  notes = "批量删除考核对象")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parkhfaService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhfaMapping.toDomain(#parkhfadto),'ehr-ParKhfa-Save')")
    @ApiOperation(value = "保存考核对象", tags = {"考核对象" },  notes = "保存考核对象")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/save")
    public ResponseEntity<Boolean> save(@RequestBody ParKhfaDTO parkhfadto) {
        return ResponseEntity.status(HttpStatus.OK).body(parkhfaService.save(parkhfaMapping.toDomain(parkhfadto)));
    }

    @PreAuthorize("hasPermission(this.parkhfaMapping.toDomain(#parkhfadtos),'ehr-ParKhfa-Save')")
    @ApiOperation(value = "批量保存考核对象", tags = {"考核对象" },  notes = "批量保存考核对象")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParKhfaDTO> parkhfadtos) {
        parkhfaService.saveBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhfaMapping.toDomain(#parkhfadto),'ehr-ParKhfa-Create')")
    @ApiOperation(value = "新建考核对象", tags = {"考核对象" },  notes = "新建考核对象")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas")
    @Transactional
    public ResponseEntity<ParKhfaDTO> create(@RequestBody ParKhfaDTO parkhfadto) {
        ParKhfa domain = parkhfaMapping.toDomain(parkhfadto);
		parkhfaService.create(domain);
        ParKhfaDTO dto = parkhfaMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhfaMapping.toDomain(#parkhfadtos),'ehr-ParKhfa-Create')")
    @ApiOperation(value = "批量新建考核对象", tags = {"考核对象" },  notes = "批量新建考核对象")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParKhfaDTO> parkhfadtos) {
        parkhfaService.createBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考核对象", tags = {"考核对象" },  notes = "检查考核对象")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParKhfaDTO parkhfadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhfaService.checkKey(parkhfaMapping.toDomain(parkhfadto)));
    }

    @ApiOperation(value = "获取考核对象草稿", tags = {"考核对象" },  notes = "获取考核对象草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhfas/getdraft")
    public ResponseEntity<ParKhfaDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parkhfaMapping.toDto(parkhfaService.getDraft(new ParKhfa())));
    }

    @PostAuthorize("hasPermission(this.parkhfaMapping.toDomain(returnObject.body),'ehr-ParKhfa-Get')")
    @ApiOperation(value = "获取考核对象", tags = {"考核对象" },  notes = "获取考核对象")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhfas/{parkhfa_id}")
    public ResponseEntity<ParKhfaDTO> get(@PathVariable("parkhfa_id") String parkhfa_id) {
        ParKhfa domain = parkhfaService.get(parkhfa_id);
        ParKhfaDTO dto = parkhfaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhfaService.get(#parkhfa_id),'ehr-ParKhfa-Update')")
    @ApiOperation(value = "更新考核对象", tags = {"考核对象" },  notes = "更新考核对象")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhfas/{parkhfa_id}")
    @Transactional
    public ResponseEntity<ParKhfaDTO> update(@PathVariable("parkhfa_id") String parkhfa_id, @RequestBody ParKhfaDTO parkhfadto) {
		ParKhfa domain  = parkhfaMapping.toDomain(parkhfadto);
        domain .setParkhfaid(parkhfa_id);
		parkhfaService.update(domain );
		ParKhfaDTO dto = parkhfaMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhfaService.getParkhfaByEntities(this.parkhfaMapping.toDomain(#parkhfadtos)),'ehr-ParKhfa-Update')")
    @ApiOperation(value = "批量更新考核对象", tags = {"考核对象" },  notes = "批量更新考核对象")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParKhfaDTO> parkhfadtos) {
        parkhfaService.updateBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhfa-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核对象" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parkhfas/fetchdefault")
	public ResponseEntity<List<ParKhfaDTO>> fetchDefault(ParKhfaSearchContext context) {
        Page<ParKhfa> domains = parkhfaService.searchDefault(context) ;
        List<ParKhfaDTO> list = parkhfaMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhfa-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核对象" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parkhfas/searchdefault")
	public ResponseEntity<Page<ParKhfaDTO>> searchDefault(@RequestBody ParKhfaSearchContext context) {
        Page<ParKhfa> domains = parkhfaService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhfaMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

