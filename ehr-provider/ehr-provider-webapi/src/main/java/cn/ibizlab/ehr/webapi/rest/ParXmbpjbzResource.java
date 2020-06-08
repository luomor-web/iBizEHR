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
import cn.ibizlab.ehr.core.par.domain.ParXmbpjbz;
import cn.ibizlab.ehr.core.par.service.IParXmbpjbzService;
import cn.ibizlab.ehr.core.par.filter.ParXmbpjbzSearchContext;

@Slf4j
@Api(tags = {"项目部评级标准" })
@RestController("WebApi-parxmbpjbz")
@RequestMapping("")
public class ParXmbpjbzResource {

    @Autowired
    public IParXmbpjbzService parxmbpjbzService;

    @Autowired
    @Lazy
    public ParXmbpjbzMapping parxmbpjbzMapping;

    @PostAuthorize("hasPermission(this.parxmbpjbzMapping.toDomain(returnObject.body),'ehr-ParXmbpjbz-Get')")
    @ApiOperation(value = "获取项目部评级标准", tags = {"项目部评级标准" },  notes = "获取项目部评级标准")
	@RequestMapping(method = RequestMethod.GET, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    public ResponseEntity<ParXmbpjbzDTO> get(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id) {
        ParXmbpjbz domain = parxmbpjbzService.get(parxmbpjbz_id);
        ParXmbpjbzDTO dto = parxmbpjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzService.get(#parxmbpjbz_id),'ehr-ParXmbpjbz-Remove')")
    @ApiOperation(value = "删除项目部评级标准", tags = {"项目部评级标准" },  notes = "删除项目部评级标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.remove(parxmbpjbz_id));
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzService.getParxmbpjbzByIds(#ids),'ehr-ParXmbpjbz-Remove')")
    @ApiOperation(value = "批量删除项目部评级标准", tags = {"项目部评级标准" },  notes = "批量删除项目部评级标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parxmbpjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查项目部评级标准", tags = {"项目部评级标准" },  notes = "检查项目部评级标准")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParXmbpjbzDTO parxmbpjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.checkKey(parxmbpjbzMapping.toDomain(parxmbpjbzdto)));
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzService.get(#parxmbpjbz_id),'ehr-ParXmbpjbz-Update')")
    @ApiOperation(value = "更新项目部评级标准", tags = {"项目部评级标准" },  notes = "更新项目部评级标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    @Transactional
    public ResponseEntity<ParXmbpjbzDTO> update(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id, @RequestBody ParXmbpjbzDTO parxmbpjbzdto) {
		ParXmbpjbz domain  = parxmbpjbzMapping.toDomain(parxmbpjbzdto);
        domain .setParxmbpjbzid(parxmbpjbz_id);
		parxmbpjbzService.update(domain );
		ParXmbpjbzDTO dto = parxmbpjbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzService.getParxmbpjbzByEntities(this.parxmbpjbzMapping.toDomain(#parxmbpjbzdtos)),'ehr-ParXmbpjbz-Update')")
    @ApiOperation(value = "批量更新项目部评级标准", tags = {"项目部评级标准" },  notes = "批量更新项目部评级标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParXmbpjbzDTO> parxmbpjbzdtos) {
        parxmbpjbzService.updateBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzMapping.toDomain(#parxmbpjbzdto),'ehr-ParXmbpjbz-Create')")
    @ApiOperation(value = "新建项目部评级标准", tags = {"项目部评级标准" },  notes = "新建项目部评级标准")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs")
    @Transactional
    public ResponseEntity<ParXmbpjbzDTO> create(@RequestBody ParXmbpjbzDTO parxmbpjbzdto) {
        ParXmbpjbz domain = parxmbpjbzMapping.toDomain(parxmbpjbzdto);
		parxmbpjbzService.create(domain);
        ParXmbpjbzDTO dto = parxmbpjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzMapping.toDomain(#parxmbpjbzdtos),'ehr-ParXmbpjbz-Create')")
    @ApiOperation(value = "批量新建项目部评级标准", tags = {"项目部评级标准" },  notes = "批量新建项目部评级标准")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParXmbpjbzDTO> parxmbpjbzdtos) {
        parxmbpjbzService.createBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzMapping.toDomain(#parxmbpjbzdto),'ehr-ParXmbpjbz-Save')")
    @ApiOperation(value = "保存项目部评级标准", tags = {"项目部评级标准" },  notes = "保存项目部评级标准")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParXmbpjbzDTO parxmbpjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.save(parxmbpjbzMapping.toDomain(parxmbpjbzdto)));
    }

    @PreAuthorize("hasPermission(this.parxmbpjbzMapping.toDomain(#parxmbpjbzdtos),'ehr-ParXmbpjbz-Save')")
    @ApiOperation(value = "批量保存项目部评级标准", tags = {"项目部评级标准" },  notes = "批量保存项目部评级标准")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParXmbpjbzDTO> parxmbpjbzdtos) {
        parxmbpjbzService.saveBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取项目部评级标准草稿", tags = {"项目部评级标准" },  notes = "获取项目部评级标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parxmbpjbzs/getdraft")
    public ResponseEntity<ParXmbpjbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzMapping.toDto(parxmbpjbzService.getDraft(new ParXmbpjbz())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParXmbpjbz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目部评级标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parxmbpjbzs/fetchdefault")
	public ResponseEntity<List<ParXmbpjbzDTO>> fetchDefault(ParXmbpjbzSearchContext context) {
        Page<ParXmbpjbz> domains = parxmbpjbzService.searchDefault(context) ;
        List<ParXmbpjbzDTO> list = parxmbpjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParXmbpjbz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"项目部评级标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parxmbpjbzs/searchdefault")
	public ResponseEntity<Page<ParXmbpjbzDTO>> searchDefault(@RequestBody ParXmbpjbzSearchContext context) {
        Page<ParXmbpjbz> domains = parxmbpjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parxmbpjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

