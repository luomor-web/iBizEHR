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
import cn.ibizlab.ehr.core.att.domain.AttEnmembwes;
import cn.ibizlab.ehr.core.att.service.IAttEnmembwesService;
import cn.ibizlab.ehr.core.att.filter.AttEnmembwesSearchContext;

@Slf4j
@Api(tags = {"考勤员(停用)" })
@RestController("WebApi-attenmembwes")
@RequestMapping("")
public class AttEnmembwesResource {

    @Autowired
    public IAttEnmembwesService attenmembwesService;

    @Autowired
    @Lazy
    public AttEnmembwesMapping attenmembwesMapping;

    @ApiOperation(value = "检查考勤员(停用)", tags = {"考勤员(停用)" },  notes = "检查考勤员(停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEnmembwesDTO attenmembwesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.checkKey(attenmembwesMapping.toDomain(attenmembwesdto)));
    }

    @PostAuthorize("hasPermission(this.attenmembwesMapping.toDomain(returnObject.body),'ehr-AttEnmembwes-Get')")
    @ApiOperation(value = "获取考勤员(停用)", tags = {"考勤员(停用)" },  notes = "获取考勤员(停用)")
	@RequestMapping(method = RequestMethod.GET, value = "/attenmembwes/{attenmembwes_id}")
    public ResponseEntity<AttEnmembwesDTO> get(@PathVariable("attenmembwes_id") String attenmembwes_id) {
        AttEnmembwes domain = attenmembwesService.get(attenmembwes_id);
        AttEnmembwesDTO dto = attenmembwesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attenmembwesService.get(#attenmembwes_id),'ehr-AttEnmembwes-Remove')")
    @ApiOperation(value = "删除考勤员(停用)", tags = {"考勤员(停用)" },  notes = "删除考勤员(停用)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attenmembwes/{attenmembwes_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attenmembwes_id") String attenmembwes_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.remove(attenmembwes_id));
    }

    @PreAuthorize("hasPermission(this.attenmembwesService.getAttenmembwesByIds(#ids),'ehr-AttEnmembwes-Remove')")
    @ApiOperation(value = "批量删除考勤员(停用)", tags = {"考勤员(停用)" },  notes = "批量删除考勤员(停用)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attenmembwesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attenmembwesMapping.toDomain(#attenmembwesdto),'ehr-AttEnmembwes-Save')")
    @ApiOperation(value = "保存考勤员(停用)", tags = {"考勤员(停用)" },  notes = "保存考勤员(停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEnmembwesDTO attenmembwesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.save(attenmembwesMapping.toDomain(attenmembwesdto)));
    }

    @PreAuthorize("hasPermission(this.attenmembwesMapping.toDomain(#attenmembwesdtos),'ehr-AttEnmembwes-Save')")
    @ApiOperation(value = "批量保存考勤员(停用)", tags = {"考勤员(停用)" },  notes = "批量保存考勤员(停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEnmembwesDTO> attenmembwesdtos) {
        attenmembwesService.saveBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤员(停用)草稿", tags = {"考勤员(停用)" },  notes = "获取考勤员(停用)草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attenmembwes/getdraft")
    public ResponseEntity<AttEnmembwesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attenmembwesMapping.toDto(attenmembwesService.getDraft(new AttEnmembwes())));
    }

    @PreAuthorize("hasPermission(this.attenmembwesService.get(#attenmembwes_id),'ehr-AttEnmembwes-Update')")
    @ApiOperation(value = "更新考勤员(停用)", tags = {"考勤员(停用)" },  notes = "更新考勤员(停用)")
	@RequestMapping(method = RequestMethod.PUT, value = "/attenmembwes/{attenmembwes_id}")
    @Transactional
    public ResponseEntity<AttEnmembwesDTO> update(@PathVariable("attenmembwes_id") String attenmembwes_id, @RequestBody AttEnmembwesDTO attenmembwesdto) {
		AttEnmembwes domain  = attenmembwesMapping.toDomain(attenmembwesdto);
        domain .setAttenmembwesid(attenmembwes_id);
		attenmembwesService.update(domain );
		AttEnmembwesDTO dto = attenmembwesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attenmembwesService.getAttenmembwesByEntities(this.attenmembwesMapping.toDomain(#attenmembwesdtos)),'ehr-AttEnmembwes-Update')")
    @ApiOperation(value = "批量更新考勤员(停用)", tags = {"考勤员(停用)" },  notes = "批量更新考勤员(停用)")
	@RequestMapping(method = RequestMethod.PUT, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEnmembwesDTO> attenmembwesdtos) {
        attenmembwesService.updateBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attenmembwesMapping.toDomain(#attenmembwesdto),'ehr-AttEnmembwes-Create')")
    @ApiOperation(value = "新建考勤员(停用)", tags = {"考勤员(停用)" },  notes = "新建考勤员(停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes")
    @Transactional
    public ResponseEntity<AttEnmembwesDTO> create(@RequestBody AttEnmembwesDTO attenmembwesdto) {
        AttEnmembwes domain = attenmembwesMapping.toDomain(attenmembwesdto);
		attenmembwesService.create(domain);
        AttEnmembwesDTO dto = attenmembwesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attenmembwesMapping.toDomain(#attenmembwesdtos),'ehr-AttEnmembwes-Create')")
    @ApiOperation(value = "批量新建考勤员(停用)", tags = {"考勤员(停用)" },  notes = "批量新建考勤员(停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEnmembwesDTO> attenmembwesdtos) {
        attenmembwesService.createBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnmembwes-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤员(停用)" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attenmembwes/fetchdefault")
	public ResponseEntity<List<AttEnmembwesDTO>> fetchDefault(AttEnmembwesSearchContext context) {
        Page<AttEnmembwes> domains = attenmembwesService.searchDefault(context) ;
        List<AttEnmembwesDTO> list = attenmembwesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnmembwes-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤员(停用)" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attenmembwes/searchdefault")
	public ResponseEntity<Page<AttEnmembwesDTO>> searchDefault(@RequestBody AttEnmembwesSearchContext context) {
        Page<AttEnmembwes> domains = attenmembwesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attenmembwesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

