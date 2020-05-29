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
import cn.ibizlab.ehr.core.soc.domain.SocSelfareBase;
import cn.ibizlab.ehr.core.soc.service.ISocSelfareBaseService;
import cn.ibizlab.ehr.core.soc.filter.SocSelfareBaseSearchContext;

@Slf4j
@Api(tags = {"参保地管理" })
@RestController("WebApi-socselfarebase")
@RequestMapping("")
public class SocSelfareBaseResource {

    @Autowired
    public ISocSelfareBaseService socselfarebaseService;

    @Autowired
    @Lazy
    public SocSelfareBaseMapping socselfarebaseMapping;

    @ApiOperation(value = "获取参保地管理草稿", tags = {"参保地管理" },  notes = "获取参保地管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebases/getdraft")
    public ResponseEntity<SocSelfareBaseDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseMapping.toDto(socselfarebaseService.getDraft(new SocSelfareBase())));
    }

    @ApiOperation(value = "检查参保地管理", tags = {"参保地管理" },  notes = "检查参保地管理")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocSelfareBaseDTO socselfarebasedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.checkKey(socselfarebaseMapping.toDomain(socselfarebasedto)));
    }

    @PreAuthorize("hasPermission(this.socselfarebaseMapping.toDomain(#socselfarebasedto),'ehr-SocSelfareBase-Save')")
    @ApiOperation(value = "保存参保地管理", tags = {"参保地管理" },  notes = "保存参保地管理")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/save")
    public ResponseEntity<Boolean> save(@RequestBody SocSelfareBaseDTO socselfarebasedto) {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.save(socselfarebaseMapping.toDomain(socselfarebasedto)));
    }

    @PreAuthorize("hasPermission(this.socselfarebaseMapping.toDomain(#socselfarebasedtos),'ehr-SocSelfareBase-Save')")
    @ApiOperation(value = "批量保存参保地管理", tags = {"参保地管理" },  notes = "批量保存参保地管理")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocSelfareBaseDTO> socselfarebasedtos) {
        socselfarebaseService.saveBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socselfarebaseService.get(#socselfarebase_id),'ehr-SocSelfareBase-Remove')")
    @ApiOperation(value = "删除参保地管理", tags = {"参保地管理" },  notes = "删除参保地管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebases/{socselfarebase_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socselfarebase_id") String socselfarebase_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.remove(socselfarebase_id));
    }

    @PreAuthorize("hasPermission(this.socselfarebaseService.getSocselfarebaseByIds(#ids),'ehr-SocSelfareBase-Remove')")
    @ApiOperation(value = "批量删除参保地管理", tags = {"参保地管理" },  notes = "批量删除参保地管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socselfarebaseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socselfarebaseMapping.toDomain(#socselfarebasedto),'ehr-SocSelfareBase-Create')")
    @ApiOperation(value = "新建参保地管理", tags = {"参保地管理" },  notes = "新建参保地管理")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases")
    @Transactional
    public ResponseEntity<SocSelfareBaseDTO> create(@RequestBody SocSelfareBaseDTO socselfarebasedto) {
        SocSelfareBase domain = socselfarebaseMapping.toDomain(socselfarebasedto);
		socselfarebaseService.create(domain);
        SocSelfareBaseDTO dto = socselfarebaseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socselfarebaseMapping.toDomain(#socselfarebasedtos),'ehr-SocSelfareBase-Create')")
    @ApiOperation(value = "批量新建参保地管理", tags = {"参保地管理" },  notes = "批量新建参保地管理")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocSelfareBaseDTO> socselfarebasedtos) {
        socselfarebaseService.createBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socselfarebaseService.get(#socselfarebase_id),'ehr-SocSelfareBase-Update')")
    @ApiOperation(value = "更新参保地管理", tags = {"参保地管理" },  notes = "更新参保地管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebases/{socselfarebase_id}")
    @Transactional
    public ResponseEntity<SocSelfareBaseDTO> update(@PathVariable("socselfarebase_id") String socselfarebase_id, @RequestBody SocSelfareBaseDTO socselfarebasedto) {
		SocSelfareBase domain  = socselfarebaseMapping.toDomain(socselfarebasedto);
        domain .setSocselfarebaseid(socselfarebase_id);
		socselfarebaseService.update(domain );
		SocSelfareBaseDTO dto = socselfarebaseMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socselfarebaseService.getSocselfarebaseByEntities(this.socselfarebaseMapping.toDomain(#socselfarebasedtos)),'ehr-SocSelfareBase-Update')")
    @ApiOperation(value = "批量更新参保地管理", tags = {"参保地管理" },  notes = "批量更新参保地管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocSelfareBaseDTO> socselfarebasedtos) {
        socselfarebaseService.updateBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socselfarebaseMapping.toDomain(returnObject.body),'ehr-SocSelfareBase-Get')")
    @ApiOperation(value = "获取参保地管理", tags = {"参保地管理" },  notes = "获取参保地管理")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebases/{socselfarebase_id}")
    public ResponseEntity<SocSelfareBaseDTO> get(@PathVariable("socselfarebase_id") String socselfarebase_id) {
        SocSelfareBase domain = socselfarebaseService.get(socselfarebase_id);
        SocSelfareBaseDTO dto = socselfarebaseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocSelfareBase-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"参保地管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socselfarebases/fetchdefault")
	public ResponseEntity<List<SocSelfareBaseDTO>> fetchDefault(SocSelfareBaseSearchContext context) {
        Page<SocSelfareBase> domains = socselfarebaseService.searchDefault(context) ;
        List<SocSelfareBaseDTO> list = socselfarebaseMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocSelfareBase-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"参保地管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socselfarebases/searchdefault")
	public ResponseEntity<Page<SocSelfareBaseDTO>> searchDefault(@RequestBody SocSelfareBaseSearchContext context) {
        Page<SocSelfareBase> domains = socselfarebaseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socselfarebaseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

