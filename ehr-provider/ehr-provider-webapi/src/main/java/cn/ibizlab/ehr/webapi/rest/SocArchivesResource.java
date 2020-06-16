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
import cn.ibizlab.ehr.core.soc.domain.SocArchives;
import cn.ibizlab.ehr.core.soc.service.ISocArchivesService;
import cn.ibizlab.ehr.core.soc.filter.SocArchivesSearchContext;

@Slf4j
@Api(tags = {"社保档案" })
@RestController("WebApi-socarchives")
@RequestMapping("")
public class SocArchivesResource {

    @Autowired
    public ISocArchivesService socarchivesService;

    @Autowired
    @Lazy
    public SocArchivesMapping socarchivesMapping;

    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "删除社保档案", tags = {"社保档案" },  notes = "删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socarchives_id") String socarchives_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.remove(socarchives_id));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByIds(#ids),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "批量删除社保档案", tags = {"社保档案" },  notes = "批量删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchives/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取社保档案草稿", tags = {"社保档案" },  notes = "获取社保档案草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchives/getdraft")
    public ResponseEntity<SocArchivesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesMapping.toDto(socarchivesService.getDraft(new SocArchives())));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Update')")
    @ApiOperation(value = "更新社保档案", tags = {"社保档案" },  notes = "更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<SocArchivesDTO> update(@PathVariable("socarchives_id") String socarchives_id, @RequestBody SocArchivesDTO socarchivesdto) {
		SocArchives domain  = socarchivesMapping.toDomain(socarchivesdto);
        domain .setSocarchivesid(socarchives_id);
		socarchivesService.update(domain );
		SocArchivesDTO dto = socarchivesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByEntities(this.socarchivesMapping.toDomain(#socarchivesdtos)),'ehr-SocArchives-Update')")
    @ApiOperation(value = "批量更新社保档案", tags = {"社保档案" },  notes = "批量更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchives/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.updateBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socarchivesMapping.toDomain(returnObject.body),'ehr-SocArchives-Get')")
    @ApiOperation(value = "获取社保档案", tags = {"社保档案" },  notes = "获取社保档案")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchives/{socarchives_id}")
    public ResponseEntity<SocArchivesDTO> get(@PathVariable("socarchives_id") String socarchives_id) {
        SocArchives domain = socarchivesService.get(socarchives_id);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Save')")
    @ApiOperation(value = "保存社保档案", tags = {"社保档案" },  notes = "保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/save")
    public ResponseEntity<Boolean> save(@RequestBody SocArchivesDTO socarchivesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.save(socarchivesMapping.toDomain(socarchivesdto)));
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Save')")
    @ApiOperation(value = "批量保存社保档案", tags = {"社保档案" },  notes = "批量保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.saveBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Create')")
    @ApiOperation(value = "新建社保档案", tags = {"社保档案" },  notes = "新建社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives")
    @Transactional
    public ResponseEntity<SocArchivesDTO> create(@RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
		socarchivesService.create(domain);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Create')")
    @ApiOperation(value = "批量新建社保档案", tags = {"社保档案" },  notes = "批量新建社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.createBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查社保档案", tags = {"社保档案" },  notes = "检查社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocArchivesDTO socarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socarchivesService.checkKey(socarchivesMapping.toDomain(socarchivesdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"社保档案" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socarchives/fetchdefault")
	public ResponseEntity<List<SocArchivesDTO>> fetchDefault(SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"社保档案" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socarchives/searchdefault")
	public ResponseEntity<Page<SocArchivesDTO>> searchDefault(@RequestBody SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

