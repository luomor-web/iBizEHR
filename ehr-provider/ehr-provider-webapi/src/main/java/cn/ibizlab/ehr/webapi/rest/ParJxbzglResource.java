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
import cn.ibizlab.ehr.core.par.domain.ParJxbzgl;
import cn.ibizlab.ehr.core.par.service.IParJxbzglService;
import cn.ibizlab.ehr.core.par.filter.ParJxbzglSearchContext;

@Slf4j
@Api(tags = {"绩效标准管理" })
@RestController("WebApi-parjxbzgl")
@RequestMapping("")
public class ParJxbzglResource {

    @Autowired
    public IParJxbzglService parjxbzglService;

    @Autowired
    @Lazy
    public ParJxbzglMapping parjxbzglMapping;

    @PostAuthorize("hasPermission(this.parjxbzglMapping.toDomain(returnObject.body),'ehr-ParJxbzgl-Get')")
    @ApiOperation(value = "获取绩效标准管理", tags = {"绩效标准管理" },  notes = "获取绩效标准管理")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}")
    public ResponseEntity<ParJxbzglDTO> get(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
        ParJxbzgl domain = parjxbzglService.get(parjxbzgl_id);
        ParJxbzglDTO dto = parjxbzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取绩效标准管理草稿", tags = {"绩效标准管理" },  notes = "获取绩效标准管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/getdraft")
    public ResponseEntity<ParJxbzglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglMapping.toDto(parjxbzglService.getDraft(new ParJxbzgl())));
    }

    @PreAuthorize("hasPermission(this.parjxbzglMapping.toDomain(#parjxbzgldto),'ehr-ParJxbzgl-Save')")
    @ApiOperation(value = "保存绩效标准管理", tags = {"绩效标准管理" },  notes = "保存绩效标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxbzglDTO parjxbzgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.save(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @PreAuthorize("hasPermission(this.parjxbzglMapping.toDomain(#parjxbzgldtos),'ehr-ParJxbzgl-Save')")
    @ApiOperation(value = "批量保存绩效标准管理", tags = {"绩效标准管理" },  notes = "批量保存绩效标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxbzglDTO> parjxbzgldtos) {
        parjxbzglService.saveBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglMapping.toDomain(#parjxbzgldto),'ehr-ParJxbzgl-Create')")
    @ApiOperation(value = "新建绩效标准管理", tags = {"绩效标准管理" },  notes = "新建绩效标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls")
    @Transactional
    public ResponseEntity<ParJxbzglDTO> create(@RequestBody ParJxbzglDTO parjxbzgldto) {
        ParJxbzgl domain = parjxbzglMapping.toDomain(parjxbzgldto);
		parjxbzglService.create(domain);
        ParJxbzglDTO dto = parjxbzglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglMapping.toDomain(#parjxbzgldtos),'ehr-ParJxbzgl-Create')")
    @ApiOperation(value = "批量新建绩效标准管理", tags = {"绩效标准管理" },  notes = "批量新建绩效标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxbzglDTO> parjxbzgldtos) {
        parjxbzglService.createBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglService.get(#parjxbzgl_id),'ehr-ParJxbzgl-Update')")
    @ApiOperation(value = "更新绩效标准管理", tags = {"绩效标准管理" },  notes = "更新绩效标准管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<ParJxbzglDTO> update(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody ParJxbzglDTO parjxbzgldto) {
		ParJxbzgl domain  = parjxbzglMapping.toDomain(parjxbzgldto);
        domain .setParjxbzglid(parjxbzgl_id);
		parjxbzglService.update(domain );
		ParJxbzglDTO dto = parjxbzglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglService.getParjxbzglByEntities(this.parjxbzglMapping.toDomain(#parjxbzgldtos)),'ehr-ParJxbzgl-Update')")
    @ApiOperation(value = "批量更新绩效标准管理", tags = {"绩效标准管理" },  notes = "批量更新绩效标准管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxbzglDTO> parjxbzgldtos) {
        parjxbzglService.updateBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglService.get(#parjxbzgl_id),'ehr-ParJxbzgl-Remove')")
    @ApiOperation(value = "删除绩效标准管理", tags = {"绩效标准管理" },  notes = "删除绩效标准管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.remove(parjxbzgl_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglService.getParjxbzglByIds(#ids),'ehr-ParJxbzgl-Remove')")
    @ApiOperation(value = "批量删除绩效标准管理", tags = {"绩效标准管理" },  notes = "批量删除绩效标准管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查绩效标准管理", tags = {"绩效标准管理" },  notes = "检查绩效标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxbzglDTO parjxbzgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.checkKey(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzgl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效标准管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/fetchdefault")
	public ResponseEntity<List<ParJxbzglDTO>> fetchDefault(ParJxbzglSearchContext context) {
        Page<ParJxbzgl> domains = parjxbzglService.searchDefault(context) ;
        List<ParJxbzglDTO> list = parjxbzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzgl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效标准管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzgls/searchdefault")
	public ResponseEntity<Page<ParJxbzglDTO>> searchDefault(@RequestBody ParJxbzglSearchContext context) {
        Page<ParJxbzgl> domains = parjxbzglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

