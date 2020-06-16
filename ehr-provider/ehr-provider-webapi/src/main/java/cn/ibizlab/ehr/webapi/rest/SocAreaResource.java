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
import cn.ibizlab.ehr.core.soc.domain.SocArea;
import cn.ibizlab.ehr.core.soc.service.ISocAreaService;
import cn.ibizlab.ehr.core.soc.filter.SocAreaSearchContext;

@Slf4j
@Api(tags = {"参保地" })
@RestController("WebApi-socarea")
@RequestMapping("")
public class SocAreaResource {

    @Autowired
    public ISocAreaService socareaService;

    @Autowired
    @Lazy
    public SocAreaMapping socareaMapping;

    @PreAuthorize("hasPermission(this.socareaMapping.toDomain(#socareadto),'ehr-SocArea-Create')")
    @ApiOperation(value = "新建参保地", tags = {"参保地" },  notes = "新建参保地")
	@RequestMapping(method = RequestMethod.POST, value = "/socareas")
    @Transactional
    public ResponseEntity<SocAreaDTO> create(@RequestBody SocAreaDTO socareadto) {
        SocArea domain = socareaMapping.toDomain(socareadto);
		socareaService.create(domain);
        SocAreaDTO dto = socareaMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socareaMapping.toDomain(#socareadtos),'ehr-SocArea-Create')")
    @ApiOperation(value = "批量新建参保地", tags = {"参保地" },  notes = "批量新建参保地")
	@RequestMapping(method = RequestMethod.POST, value = "/socareas/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocAreaDTO> socareadtos) {
        socareaService.createBatch(socareaMapping.toDomain(socareadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取参保地草稿", tags = {"参保地" },  notes = "获取参保地草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socareas/getdraft")
    public ResponseEntity<SocAreaDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socareaMapping.toDto(socareaService.getDraft(new SocArea())));
    }

    @PreAuthorize("hasPermission(this.socareaService.get(#socarea_id),'ehr-SocArea-Update')")
    @ApiOperation(value = "更新参保地", tags = {"参保地" },  notes = "更新参保地")
	@RequestMapping(method = RequestMethod.PUT, value = "/socareas/{socarea_id}")
    @Transactional
    public ResponseEntity<SocAreaDTO> update(@PathVariable("socarea_id") String socarea_id, @RequestBody SocAreaDTO socareadto) {
		SocArea domain  = socareaMapping.toDomain(socareadto);
        domain .setSocareaid(socarea_id);
		socareaService.update(domain );
		SocAreaDTO dto = socareaMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socareaService.getSocareaByEntities(this.socareaMapping.toDomain(#socareadtos)),'ehr-SocArea-Update')")
    @ApiOperation(value = "批量更新参保地", tags = {"参保地" },  notes = "批量更新参保地")
	@RequestMapping(method = RequestMethod.PUT, value = "/socareas/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocAreaDTO> socareadtos) {
        socareaService.updateBatch(socareaMapping.toDomain(socareadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socareaMapping.toDomain(returnObject.body),'ehr-SocArea-Get')")
    @ApiOperation(value = "获取参保地", tags = {"参保地" },  notes = "获取参保地")
	@RequestMapping(method = RequestMethod.GET, value = "/socareas/{socarea_id}")
    public ResponseEntity<SocAreaDTO> get(@PathVariable("socarea_id") String socarea_id) {
        SocArea domain = socareaService.get(socarea_id);
        SocAreaDTO dto = socareaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socareaService.get(#socarea_id),'ehr-SocArea-Remove')")
    @ApiOperation(value = "删除参保地", tags = {"参保地" },  notes = "删除参保地")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socareas/{socarea_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socarea_id") String socarea_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socareaService.remove(socarea_id));
    }

    @PreAuthorize("hasPermission(this.socareaService.getSocareaByIds(#ids),'ehr-SocArea-Remove')")
    @ApiOperation(value = "批量删除参保地", tags = {"参保地" },  notes = "批量删除参保地")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socareas/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socareaService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查参保地", tags = {"参保地" },  notes = "检查参保地")
	@RequestMapping(method = RequestMethod.POST, value = "/socareas/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocAreaDTO socareadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socareaService.checkKey(socareaMapping.toDomain(socareadto)));
    }

    @PreAuthorize("hasPermission(this.socareaMapping.toDomain(#socareadto),'ehr-SocArea-Save')")
    @ApiOperation(value = "保存参保地", tags = {"参保地" },  notes = "保存参保地")
	@RequestMapping(method = RequestMethod.POST, value = "/socareas/save")
    public ResponseEntity<Boolean> save(@RequestBody SocAreaDTO socareadto) {
        return ResponseEntity.status(HttpStatus.OK).body(socareaService.save(socareaMapping.toDomain(socareadto)));
    }

    @PreAuthorize("hasPermission(this.socareaMapping.toDomain(#socareadtos),'ehr-SocArea-Save')")
    @ApiOperation(value = "批量保存参保地", tags = {"参保地" },  notes = "批量保存参保地")
	@RequestMapping(method = RequestMethod.POST, value = "/socareas/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocAreaDTO> socareadtos) {
        socareaService.saveBatch(socareaMapping.toDomain(socareadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArea-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"参保地" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socareas/fetchdefault")
	public ResponseEntity<List<SocAreaDTO>> fetchDefault(SocAreaSearchContext context) {
        Page<SocArea> domains = socareaService.searchDefault(context) ;
        List<SocAreaDTO> list = socareaMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArea-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"参保地" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socareas/searchdefault")
	public ResponseEntity<Page<SocAreaDTO>> searchDefault(@RequestBody SocAreaSearchContext context) {
        Page<SocArea> domains = socareaService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socareaMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

