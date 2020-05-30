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
import cn.ibizlab.ehr.core.par.domain.ParNdlhmbkh;
import cn.ibizlab.ehr.core.par.service.IParNdlhmbkhService;
import cn.ibizlab.ehr.core.par.filter.ParNdlhmbkhSearchContext;

@Slf4j
@Api(tags = {"量化目标考核" })
@RestController("WebApi-parndlhmbkh")
@RequestMapping("")
public class ParNdlhmbkhResource {

    @Autowired
    public IParNdlhmbkhService parndlhmbkhService;

    @Autowired
    @Lazy
    public ParNdlhmbkhMapping parndlhmbkhMapping;

    @PreAuthorize("hasPermission(this.parndlhmbkhService.get(#parndlhmbkh_id),'ehr-ParNdlhmbkh-Update')")
    @ApiOperation(value = "更新量化目标考核", tags = {"量化目标考核" },  notes = "更新量化目标考核")
	@RequestMapping(method = RequestMethod.PUT, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    @Transactional
    public ResponseEntity<ParNdlhmbkhDTO> update(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id, @RequestBody ParNdlhmbkhDTO parndlhmbkhdto) {
		ParNdlhmbkh domain  = parndlhmbkhMapping.toDomain(parndlhmbkhdto);
        domain .setParndlhmbkhid(parndlhmbkh_id);
		parndlhmbkhService.update(domain );
		ParNdlhmbkhDTO dto = parndlhmbkhMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhService.getParndlhmbkhByEntities(this.parndlhmbkhMapping.toDomain(#parndlhmbkhdtos)),'ehr-ParNdlhmbkh-Update')")
    @ApiOperation(value = "批量更新量化目标考核", tags = {"量化目标考核" },  notes = "批量更新量化目标考核")
	@RequestMapping(method = RequestMethod.PUT, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParNdlhmbkhDTO> parndlhmbkhdtos) {
        parndlhmbkhService.updateBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取量化目标考核草稿", tags = {"量化目标考核" },  notes = "获取量化目标考核草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parndlhmbkhs/getdraft")
    public ResponseEntity<ParNdlhmbkhDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhMapping.toDto(parndlhmbkhService.getDraft(new ParNdlhmbkh())));
    }

    @ApiOperation(value = "检查量化目标考核", tags = {"量化目标考核" },  notes = "检查量化目标考核")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParNdlhmbkhDTO parndlhmbkhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.checkKey(parndlhmbkhMapping.toDomain(parndlhmbkhdto)));
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhMapping.toDomain(#parndlhmbkhdto),'ehr-ParNdlhmbkh-Create')")
    @ApiOperation(value = "新建量化目标考核", tags = {"量化目标考核" },  notes = "新建量化目标考核")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs")
    @Transactional
    public ResponseEntity<ParNdlhmbkhDTO> create(@RequestBody ParNdlhmbkhDTO parndlhmbkhdto) {
        ParNdlhmbkh domain = parndlhmbkhMapping.toDomain(parndlhmbkhdto);
		parndlhmbkhService.create(domain);
        ParNdlhmbkhDTO dto = parndlhmbkhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhMapping.toDomain(#parndlhmbkhdtos),'ehr-ParNdlhmbkh-Create')")
    @ApiOperation(value = "批量新建量化目标考核", tags = {"量化目标考核" },  notes = "批量新建量化目标考核")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParNdlhmbkhDTO> parndlhmbkhdtos) {
        parndlhmbkhService.createBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhService.get(#parndlhmbkh_id),'ehr-ParNdlhmbkh-Remove')")
    @ApiOperation(value = "删除量化目标考核", tags = {"量化目标考核" },  notes = "删除量化目标考核")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.remove(parndlhmbkh_id));
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhService.getParndlhmbkhByIds(#ids),'ehr-ParNdlhmbkh-Remove')")
    @ApiOperation(value = "批量删除量化目标考核", tags = {"量化目标考核" },  notes = "批量删除量化目标考核")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parndlhmbkhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhMapping.toDomain(#parndlhmbkhdto),'ehr-ParNdlhmbkh-Save')")
    @ApiOperation(value = "保存量化目标考核", tags = {"量化目标考核" },  notes = "保存量化目标考核")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParNdlhmbkhDTO parndlhmbkhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.save(parndlhmbkhMapping.toDomain(parndlhmbkhdto)));
    }

    @PreAuthorize("hasPermission(this.parndlhmbkhMapping.toDomain(#parndlhmbkhdtos),'ehr-ParNdlhmbkh-Save')")
    @ApiOperation(value = "批量保存量化目标考核", tags = {"量化目标考核" },  notes = "批量保存量化目标考核")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParNdlhmbkhDTO> parndlhmbkhdtos) {
        parndlhmbkhService.saveBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parndlhmbkhMapping.toDomain(returnObject.body),'ehr-ParNdlhmbkh-Get')")
    @ApiOperation(value = "获取量化目标考核", tags = {"量化目标考核" },  notes = "获取量化目标考核")
	@RequestMapping(method = RequestMethod.GET, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    public ResponseEntity<ParNdlhmbkhDTO> get(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id) {
        ParNdlhmbkh domain = parndlhmbkhService.get(parndlhmbkh_id);
        ParNdlhmbkhDTO dto = parndlhmbkhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParNdlhmbkh-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"量化目标考核" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parndlhmbkhs/fetchdefault")
	public ResponseEntity<List<ParNdlhmbkhDTO>> fetchDefault(ParNdlhmbkhSearchContext context) {
        Page<ParNdlhmbkh> domains = parndlhmbkhService.searchDefault(context) ;
        List<ParNdlhmbkhDTO> list = parndlhmbkhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParNdlhmbkh-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"量化目标考核" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parndlhmbkhs/searchdefault")
	public ResponseEntity<Page<ParNdlhmbkhDTO>> searchDefault(@RequestBody ParNdlhmbkhSearchContext context) {
        Page<ParNdlhmbkh> domains = parndlhmbkhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parndlhmbkhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

