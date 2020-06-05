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
import cn.ibizlab.ehr.core.par.domain.ParJxqdsz;
import cn.ibizlab.ehr.core.par.service.IParJxqdszService;
import cn.ibizlab.ehr.core.par.filter.ParJxqdszSearchContext;

@Slf4j
@Api(tags = {"绩效启动设置" })
@RestController("WebApi-parjxqdsz")
@RequestMapping("")
public class ParJxqdszResource {

    @Autowired
    public IParJxqdszService parjxqdszService;

    @Autowired
    @Lazy
    public ParJxqdszMapping parjxqdszMapping;

    @PreAuthorize("hasPermission(this.parjxqdszService.get(#parjxqdsz_id),'ehr-ParJxqdsz-Update')")
    @ApiOperation(value = "更新绩效启动设置", tags = {"绩效启动设置" },  notes = "更新绩效启动设置")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxqdszs/{parjxqdsz_id}")
    @Transactional
    public ResponseEntity<ParJxqdszDTO> update(@PathVariable("parjxqdsz_id") String parjxqdsz_id, @RequestBody ParJxqdszDTO parjxqdszdto) {
		ParJxqdsz domain  = parjxqdszMapping.toDomain(parjxqdszdto);
        domain .setParjxqdszid(parjxqdsz_id);
		parjxqdszService.update(domain );
		ParJxqdszDTO dto = parjxqdszMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxqdszService.getParjxqdszByEntities(this.parjxqdszMapping.toDomain(#parjxqdszdtos)),'ehr-ParJxqdsz-Update')")
    @ApiOperation(value = "批量更新绩效启动设置", tags = {"绩效启动设置" },  notes = "批量更新绩效启动设置")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxqdszDTO> parjxqdszdtos) {
        parjxqdszService.updateBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxqdszMapping.toDomain(returnObject.body),'ehr-ParJxqdsz-Get')")
    @ApiOperation(value = "获取绩效启动设置", tags = {"绩效启动设置" },  notes = "获取绩效启动设置")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxqdszs/{parjxqdsz_id}")
    public ResponseEntity<ParJxqdszDTO> get(@PathVariable("parjxqdsz_id") String parjxqdsz_id) {
        ParJxqdsz domain = parjxqdszService.get(parjxqdsz_id);
        ParJxqdszDTO dto = parjxqdszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxqdszMapping.toDomain(#parjxqdszdto),'ehr-ParJxqdsz-Save')")
    @ApiOperation(value = "保存绩效启动设置", tags = {"绩效启动设置" },  notes = "保存绩效启动设置")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxqdszDTO parjxqdszdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.save(parjxqdszMapping.toDomain(parjxqdszdto)));
    }

    @PreAuthorize("hasPermission(this.parjxqdszMapping.toDomain(#parjxqdszdtos),'ehr-ParJxqdsz-Save')")
    @ApiOperation(value = "批量保存绩效启动设置", tags = {"绩效启动设置" },  notes = "批量保存绩效启动设置")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxqdszDTO> parjxqdszdtos) {
        parjxqdszService.saveBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查绩效启动设置", tags = {"绩效启动设置" },  notes = "检查绩效启动设置")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxqdszDTO parjxqdszdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.checkKey(parjxqdszMapping.toDomain(parjxqdszdto)));
    }

    @ApiOperation(value = "获取绩效启动设置草稿", tags = {"绩效启动设置" },  notes = "获取绩效启动设置草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxqdszs/getdraft")
    public ResponseEntity<ParJxqdszDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxqdszMapping.toDto(parjxqdszService.getDraft(new ParJxqdsz())));
    }

    @PreAuthorize("hasPermission(this.parjxqdszMapping.toDomain(#parjxqdszdto),'ehr-ParJxqdsz-Create')")
    @ApiOperation(value = "新建绩效启动设置", tags = {"绩效启动设置" },  notes = "新建绩效启动设置")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs")
    @Transactional
    public ResponseEntity<ParJxqdszDTO> create(@RequestBody ParJxqdszDTO parjxqdszdto) {
        ParJxqdsz domain = parjxqdszMapping.toDomain(parjxqdszdto);
		parjxqdszService.create(domain);
        ParJxqdszDTO dto = parjxqdszMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxqdszMapping.toDomain(#parjxqdszdtos),'ehr-ParJxqdsz-Create')")
    @ApiOperation(value = "批量新建绩效启动设置", tags = {"绩效启动设置" },  notes = "批量新建绩效启动设置")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxqdszDTO> parjxqdszdtos) {
        parjxqdszService.createBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxqdszService.get(#parjxqdsz_id),'ehr-ParJxqdsz-Remove')")
    @ApiOperation(value = "删除绩效启动设置", tags = {"绩效启动设置" },  notes = "删除绩效启动设置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxqdszs/{parjxqdsz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxqdsz_id") String parjxqdsz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.remove(parjxqdsz_id));
    }

    @PreAuthorize("hasPermission(this.parjxqdszService.getParjxqdszByIds(#ids),'ehr-ParJxqdsz-Remove')")
    @ApiOperation(value = "批量删除绩效启动设置", tags = {"绩效启动设置" },  notes = "批量删除绩效启动设置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxqdszService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxqdsz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效启动设置" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxqdszs/fetchdefault")
	public ResponseEntity<List<ParJxqdszDTO>> fetchDefault(ParJxqdszSearchContext context) {
        Page<ParJxqdsz> domains = parjxqdszService.searchDefault(context) ;
        List<ParJxqdszDTO> list = parjxqdszMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxqdsz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效启动设置" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxqdszs/searchdefault")
	public ResponseEntity<Page<ParJxqdszDTO>> searchDefault(@RequestBody ParJxqdszSearchContext context) {
        Page<ParJxqdsz> domains = parjxqdszService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxqdszMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

