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
import cn.ibizlab.ehr.core.par.domain.ParDjbz;
import cn.ibizlab.ehr.core.par.service.IParDjbzService;
import cn.ibizlab.ehr.core.par.filter.ParDjbzSearchContext;

@Slf4j
@Api(tags = {"定级规则" })
@RestController("WebApi-pardjbz")
@RequestMapping("")
public class ParDjbzResource {

    @Autowired
    public IParDjbzService pardjbzService;

    @Autowired
    @Lazy
    public ParDjbzMapping pardjbzMapping;

    @PreAuthorize("hasPermission(this.pardjbzMapping.toDomain(#pardjbzdto),'ehr-ParDjbz-Create')")
    @ApiOperation(value = "新建定级规则", tags = {"定级规则" },  notes = "新建定级规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs")
    @Transactional
    public ResponseEntity<ParDjbzDTO> create(@RequestBody ParDjbzDTO pardjbzdto) {
        ParDjbz domain = pardjbzMapping.toDomain(pardjbzdto);
		pardjbzService.create(domain);
        ParDjbzDTO dto = pardjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pardjbzMapping.toDomain(#pardjbzdtos),'ehr-ParDjbz-Create')")
    @ApiOperation(value = "批量新建定级规则", tags = {"定级规则" },  notes = "批量新建定级规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParDjbzDTO> pardjbzdtos) {
        pardjbzService.createBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pardjbzMapping.toDomain(returnObject.body),'ehr-ParDjbz-Get')")
    @ApiOperation(value = "获取定级规则", tags = {"定级规则" },  notes = "获取定级规则")
	@RequestMapping(method = RequestMethod.GET, value = "/pardjbzs/{pardjbz_id}")
    public ResponseEntity<ParDjbzDTO> get(@PathVariable("pardjbz_id") String pardjbz_id) {
        ParDjbz domain = pardjbzService.get(pardjbz_id);
        ParDjbzDTO dto = pardjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pardjbzMapping.toDomain(#pardjbzdto),'ehr-ParDjbz-Save')")
    @ApiOperation(value = "保存定级规则", tags = {"定级规则" },  notes = "保存定级规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParDjbzDTO pardjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pardjbzService.save(pardjbzMapping.toDomain(pardjbzdto)));
    }

    @PreAuthorize("hasPermission(this.pardjbzMapping.toDomain(#pardjbzdtos),'ehr-ParDjbz-Save')")
    @ApiOperation(value = "批量保存定级规则", tags = {"定级规则" },  notes = "批量保存定级规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParDjbzDTO> pardjbzdtos) {
        pardjbzService.saveBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取定级规则草稿", tags = {"定级规则" },  notes = "获取定级规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pardjbzs/getdraft")
    public ResponseEntity<ParDjbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pardjbzMapping.toDto(pardjbzService.getDraft(new ParDjbz())));
    }

    @PreAuthorize("hasPermission(this.pardjbzService.get(#pardjbz_id),'ehr-ParDjbz-Update')")
    @ApiOperation(value = "更新定级规则", tags = {"定级规则" },  notes = "更新定级规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardjbzs/{pardjbz_id}")
    @Transactional
    public ResponseEntity<ParDjbzDTO> update(@PathVariable("pardjbz_id") String pardjbz_id, @RequestBody ParDjbzDTO pardjbzdto) {
		ParDjbz domain  = pardjbzMapping.toDomain(pardjbzdto);
        domain .setPardjbzid(pardjbz_id);
		pardjbzService.update(domain );
		ParDjbzDTO dto = pardjbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pardjbzService.getPardjbzByEntities(this.pardjbzMapping.toDomain(#pardjbzdtos)),'ehr-ParDjbz-Update')")
    @ApiOperation(value = "批量更新定级规则", tags = {"定级规则" },  notes = "批量更新定级规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParDjbzDTO> pardjbzdtos) {
        pardjbzService.updateBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pardjbzService.get(#pardjbz_id),'ehr-ParDjbz-Remove')")
    @ApiOperation(value = "删除定级规则", tags = {"定级规则" },  notes = "删除定级规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardjbzs/{pardjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pardjbz_id") String pardjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pardjbzService.remove(pardjbz_id));
    }

    @PreAuthorize("hasPermission(this.pardjbzService.getPardjbzByIds(#ids),'ehr-ParDjbz-Remove')")
    @ApiOperation(value = "批量删除定级规则", tags = {"定级规则" },  notes = "批量删除定级规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pardjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查定级规则", tags = {"定级规则" },  notes = "检查定级规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParDjbzDTO pardjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pardjbzService.checkKey(pardjbzMapping.toDomain(pardjbzdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParDjbz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"定级规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pardjbzs/fetchdefault")
	public ResponseEntity<List<ParDjbzDTO>> fetchDefault(ParDjbzSearchContext context) {
        Page<ParDjbz> domains = pardjbzService.searchDefault(context) ;
        List<ParDjbzDTO> list = pardjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParDjbz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"定级规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pardjbzs/searchdefault")
	public ResponseEntity<Page<ParDjbzDTO>> searchDefault(@RequestBody ParDjbzSearchContext context) {
        Page<ParDjbz> domains = pardjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pardjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

