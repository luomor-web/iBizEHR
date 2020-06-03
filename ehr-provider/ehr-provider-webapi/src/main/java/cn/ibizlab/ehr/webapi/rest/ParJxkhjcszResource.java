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
import cn.ibizlab.ehr.core.par.domain.ParJxkhjcsz;
import cn.ibizlab.ehr.core.par.service.IParJxkhjcszService;
import cn.ibizlab.ehr.core.par.filter.ParJxkhjcszSearchContext;

@Slf4j
@Api(tags = {"考核方案" })
@RestController("WebApi-parjxkhjcsz")
@RequestMapping("")
public class ParJxkhjcszResource {

    @Autowired
    public IParJxkhjcszService parjxkhjcszService;

    @Autowired
    @Lazy
    public ParJxkhjcszMapping parjxkhjcszMapping;

    @PreAuthorize("hasPermission(this.parjxkhjcszService.get(#parjxkhjcsz_id),'ehr-ParJxkhjcsz-Update')")
    @ApiOperation(value = "更新考核方案", tags = {"考核方案" },  notes = "更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    @Transactional
    public ResponseEntity<ParJxkhjcszDTO> update(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParJxkhjcszDTO parjxkhjcszdto) {
		ParJxkhjcsz domain  = parjxkhjcszMapping.toDomain(parjxkhjcszdto);
        domain .setParjxkhjcszid(parjxkhjcsz_id);
		parjxkhjcszService.update(domain );
		ParJxkhjcszDTO dto = parjxkhjcszMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszService.getParjxkhjcszByEntities(this.parjxkhjcszMapping.toDomain(#parjxkhjcszdtos)),'ehr-ParJxkhjcsz-Update')")
    @ApiOperation(value = "批量更新考核方案", tags = {"考核方案" },  notes = "批量更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxkhjcszDTO> parjxkhjcszdtos) {
        parjxkhjcszService.updateBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考核方案草稿", tags = {"考核方案" },  notes = "获取考核方案草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/getdraft")
    public ResponseEntity<ParJxkhjcszDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszMapping.toDto(parjxkhjcszService.getDraft(new ParJxkhjcsz())));
    }

    @ApiOperation(value = "检查考核方案", tags = {"考核方案" },  notes = "检查考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxkhjcszDTO parjxkhjcszdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.checkKey(parjxkhjcszMapping.toDomain(parjxkhjcszdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszService.get(#parjxkhjcsz_id),'ehr-ParJxkhjcsz-Remove')")
    @ApiOperation(value = "删除考核方案", tags = {"考核方案" },  notes = "删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.remove(parjxkhjcsz_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszService.getParjxkhjcszByIds(#ids),'ehr-ParJxkhjcsz-Remove')")
    @ApiOperation(value = "批量删除考核方案", tags = {"考核方案" },  notes = "批量删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhjcszService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszMapping.toDomain(#parjxkhjcszdto),'ehr-ParJxkhjcsz-Save')")
    @ApiOperation(value = "保存考核方案", tags = {"考核方案" },  notes = "保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxkhjcszDTO parjxkhjcszdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.save(parjxkhjcszMapping.toDomain(parjxkhjcszdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszMapping.toDomain(#parjxkhjcszdtos),'ehr-ParJxkhjcsz-Save')")
    @ApiOperation(value = "批量保存考核方案", tags = {"考核方案" },  notes = "批量保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxkhjcszDTO> parjxkhjcszdtos) {
        parjxkhjcszService.saveBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszMapping.toDomain(#parjxkhjcszdto),'ehr-ParJxkhjcsz-Create')")
    @ApiOperation(value = "新建考核方案", tags = {"考核方案" },  notes = "新建考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs")
    @Transactional
    public ResponseEntity<ParJxkhjcszDTO> create(@RequestBody ParJxkhjcszDTO parjxkhjcszdto) {
        ParJxkhjcsz domain = parjxkhjcszMapping.toDomain(parjxkhjcszdto);
		parjxkhjcszService.create(domain);
        ParJxkhjcszDTO dto = parjxkhjcszMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhjcszMapping.toDomain(#parjxkhjcszdtos),'ehr-ParJxkhjcsz-Create')")
    @ApiOperation(value = "批量新建考核方案", tags = {"考核方案" },  notes = "批量新建考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxkhjcszDTO> parjxkhjcszdtos) {
        parjxkhjcszService.createBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxkhjcszMapping.toDomain(returnObject.body),'ehr-ParJxkhjcsz-Get')")
    @ApiOperation(value = "获取考核方案", tags = {"考核方案" },  notes = "获取考核方案")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    public ResponseEntity<ParJxkhjcszDTO> get(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
        ParJxkhjcsz domain = parjxkhjcszService.get(parjxkhjcsz_id);
        ParJxkhjcszDTO dto = parjxkhjcszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhjcsz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核方案" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhjcszs/fetchdefault")
	public ResponseEntity<List<ParJxkhjcszDTO>> fetchDefault(ParJxkhjcszSearchContext context) {
        Page<ParJxkhjcsz> domains = parjxkhjcszService.searchDefault(context) ;
        List<ParJxkhjcszDTO> list = parjxkhjcszMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhjcsz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核方案" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhjcszs/searchdefault")
	public ResponseEntity<Page<ParJxkhjcszDTO>> searchDefault(@RequestBody ParJxkhjcszSearchContext context) {
        Page<ParJxkhjcsz> domains = parjxkhjcszService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhjcszMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

