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
import cn.ibizlab.ehr.core.par.domain.ParExamContent;
import cn.ibizlab.ehr.core.par.service.IParExamContentService;
import cn.ibizlab.ehr.core.par.filter.ParExamContentSearchContext;

@Slf4j
@Api(tags = {"考核内容" })
@RestController("WebApi-parexamcontent")
@RequestMapping("")
public class ParExamContentResource {

    @Autowired
    public IParExamContentService parexamcontentService;

    @Autowired
    @Lazy
    public ParExamContentMapping parexamcontentMapping;

    @ApiOperation(value = "检查考核内容", tags = {"考核内容" },  notes = "检查考核内容")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcontents/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParExamContentDTO parexamcontentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parexamcontentService.checkKey(parexamcontentMapping.toDomain(parexamcontentdto)));
    }

    @PostAuthorize("hasPermission(this.parexamcontentMapping.toDomain(returnObject.body),'ehr-ParExamContent-Get')")
    @ApiOperation(value = "获取考核内容", tags = {"考核内容" },  notes = "获取考核内容")
	@RequestMapping(method = RequestMethod.GET, value = "/parexamcontents/{parexamcontent_id}")
    public ResponseEntity<ParExamContentDTO> get(@PathVariable("parexamcontent_id") String parexamcontent_id) {
        ParExamContent domain = parexamcontentService.get(parexamcontent_id);
        ParExamContentDTO dto = parexamcontentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parexamcontentMapping.toDomain(#parexamcontentdto),'ehr-ParExamContent-Save')")
    @ApiOperation(value = "保存考核内容", tags = {"考核内容" },  notes = "保存考核内容")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcontents/save")
    public ResponseEntity<Boolean> save(@RequestBody ParExamContentDTO parexamcontentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parexamcontentService.save(parexamcontentMapping.toDomain(parexamcontentdto)));
    }

    @PreAuthorize("hasPermission(this.parexamcontentMapping.toDomain(#parexamcontentdtos),'ehr-ParExamContent-Save')")
    @ApiOperation(value = "批量保存考核内容", tags = {"考核内容" },  notes = "批量保存考核内容")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcontents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParExamContentDTO> parexamcontentdtos) {
        parexamcontentService.saveBatch(parexamcontentMapping.toDomain(parexamcontentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parexamcontentService.get(#parexamcontent_id),'ehr-ParExamContent-Update')")
    @ApiOperation(value = "更新考核内容", tags = {"考核内容" },  notes = "更新考核内容")
	@RequestMapping(method = RequestMethod.PUT, value = "/parexamcontents/{parexamcontent_id}")
    @Transactional
    public ResponseEntity<ParExamContentDTO> update(@PathVariable("parexamcontent_id") String parexamcontent_id, @RequestBody ParExamContentDTO parexamcontentdto) {
		ParExamContent domain  = parexamcontentMapping.toDomain(parexamcontentdto);
        domain .setParexamcontentid(parexamcontent_id);
		parexamcontentService.update(domain );
		ParExamContentDTO dto = parexamcontentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parexamcontentService.getParexamcontentByEntities(this.parexamcontentMapping.toDomain(#parexamcontentdtos)),'ehr-ParExamContent-Update')")
    @ApiOperation(value = "批量更新考核内容", tags = {"考核内容" },  notes = "批量更新考核内容")
	@RequestMapping(method = RequestMethod.PUT, value = "/parexamcontents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParExamContentDTO> parexamcontentdtos) {
        parexamcontentService.updateBatch(parexamcontentMapping.toDomain(parexamcontentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parexamcontentService.get(#parexamcontent_id),'ehr-ParExamContent-Remove')")
    @ApiOperation(value = "删除考核内容", tags = {"考核内容" },  notes = "删除考核内容")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parexamcontents/{parexamcontent_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parexamcontent_id") String parexamcontent_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parexamcontentService.remove(parexamcontent_id));
    }

    @PreAuthorize("hasPermission(this.parexamcontentService.getParexamcontentByIds(#ids),'ehr-ParExamContent-Remove')")
    @ApiOperation(value = "批量删除考核内容", tags = {"考核内容" },  notes = "批量删除考核内容")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parexamcontents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parexamcontentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考核内容草稿", tags = {"考核内容" },  notes = "获取考核内容草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parexamcontents/getdraft")
    public ResponseEntity<ParExamContentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parexamcontentMapping.toDto(parexamcontentService.getDraft(new ParExamContent())));
    }

    @PreAuthorize("hasPermission(this.parexamcontentMapping.toDomain(#parexamcontentdto),'ehr-ParExamContent-Create')")
    @ApiOperation(value = "新建考核内容", tags = {"考核内容" },  notes = "新建考核内容")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcontents")
    @Transactional
    public ResponseEntity<ParExamContentDTO> create(@RequestBody ParExamContentDTO parexamcontentdto) {
        ParExamContent domain = parexamcontentMapping.toDomain(parexamcontentdto);
		parexamcontentService.create(domain);
        ParExamContentDTO dto = parexamcontentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parexamcontentMapping.toDomain(#parexamcontentdtos),'ehr-ParExamContent-Create')")
    @ApiOperation(value = "批量新建考核内容", tags = {"考核内容" },  notes = "批量新建考核内容")
	@RequestMapping(method = RequestMethod.POST, value = "/parexamcontents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParExamContentDTO> parexamcontentdtos) {
        parexamcontentService.createBatch(parexamcontentMapping.toDomain(parexamcontentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParExamContent-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核内容" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parexamcontents/fetchdefault")
	public ResponseEntity<List<ParExamContentDTO>> fetchDefault(ParExamContentSearchContext context) {
        Page<ParExamContent> domains = parexamcontentService.searchDefault(context) ;
        List<ParExamContentDTO> list = parexamcontentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParExamContent-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核内容" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parexamcontents/searchdefault")
	public ResponseEntity<Page<ParExamContentDTO>> searchDefault(@RequestBody ParExamContentSearchContext context) {
        Page<ParExamContent> domains = parexamcontentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parexamcontentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

