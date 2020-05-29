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
import cn.ibizlab.ehr.core.orm.domain.OrmEdition;
import cn.ibizlab.ehr.core.orm.service.IOrmEditionService;
import cn.ibizlab.ehr.core.orm.filter.OrmEditionSearchContext;

@Slf4j
@Api(tags = {"版本对照表" })
@RestController("WebApi-ormedition")
@RequestMapping("")
public class OrmEditionResource {

    @Autowired
    public IOrmEditionService ormeditionService;

    @Autowired
    @Lazy
    public OrmEditionMapping ormeditionMapping;

    @PreAuthorize("hasPermission(this.ormeditionService.get(#ormedition_id),'ehr-OrmEdition-Remove')")
    @ApiOperation(value = "删除版本对照表", tags = {"版本对照表" },  notes = "删除版本对照表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormedition_id") String ormedition_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.remove(ormedition_id));
    }

    @PreAuthorize("hasPermission(this.ormeditionService.getOrmeditionByIds(#ids),'ehr-OrmEdition-Remove')")
    @ApiOperation(value = "批量删除版本对照表", tags = {"版本对照表" },  notes = "批量删除版本对照表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormeditionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondto),'ehr-OrmEdition-Create')")
    @ApiOperation(value = "新建版本对照表", tags = {"版本对照表" },  notes = "新建版本对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions")
    @Transactional
    public ResponseEntity<OrmEditionDTO> create(@RequestBody OrmEditionDTO ormeditiondto) {
        OrmEdition domain = ormeditionMapping.toDomain(ormeditiondto);
		ormeditionService.create(domain);
        OrmEditionDTO dto = ormeditionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondtos),'ehr-OrmEdition-Create')")
    @ApiOperation(value = "批量新建版本对照表", tags = {"版本对照表" },  notes = "批量新建版本对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.createBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondto),'ehr-OrmEdition-Save')")
    @ApiOperation(value = "保存版本对照表", tags = {"版本对照表" },  notes = "保存版本对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmEditionDTO ormeditiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.save(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondtos),'ehr-OrmEdition-Save')")
    @ApiOperation(value = "批量保存版本对照表", tags = {"版本对照表" },  notes = "批量保存版本对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.saveBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取版本对照表草稿", tags = {"版本对照表" },  notes = "获取版本对照表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/getdraft")
    public ResponseEntity<OrmEditionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionMapping.toDto(ormeditionService.getDraft(new OrmEdition())));
    }

    @PreAuthorize("hasPermission(this.ormeditionService.get(#ormedition_id),'ehr-OrmEdition-Update')")
    @ApiOperation(value = "更新版本对照表", tags = {"版本对照表" },  notes = "更新版本对照表")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<OrmEditionDTO> update(@PathVariable("ormedition_id") String ormedition_id, @RequestBody OrmEditionDTO ormeditiondto) {
		OrmEdition domain  = ormeditionMapping.toDomain(ormeditiondto);
        domain .setOrmeditionid(ormedition_id);
		ormeditionService.update(domain );
		OrmEditionDTO dto = ormeditionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormeditionService.getOrmeditionByEntities(this.ormeditionMapping.toDomain(#ormeditiondtos)),'ehr-OrmEdition-Update')")
    @ApiOperation(value = "批量更新版本对照表", tags = {"版本对照表" },  notes = "批量更新版本对照表")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.updateBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查版本对照表", tags = {"版本对照表" },  notes = "检查版本对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmEditionDTO ormeditiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormeditionService.checkKey(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PostAuthorize("hasPermission(this.ormeditionMapping.toDomain(returnObject.body),'ehr-OrmEdition-Get')")
    @ApiOperation(value = "获取版本对照表", tags = {"版本对照表" },  notes = "获取版本对照表")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/{ormedition_id}")
    public ResponseEntity<OrmEditionDTO> get(@PathVariable("ormedition_id") String ormedition_id) {
        OrmEdition domain = ormeditionService.get(ormedition_id);
        OrmEditionDTO dto = ormeditionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmEdition-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"版本对照表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormeditions/fetchdefault")
	public ResponseEntity<List<OrmEditionDTO>> fetchDefault(OrmEditionSearchContext context) {
        Page<OrmEdition> domains = ormeditionService.searchDefault(context) ;
        List<OrmEditionDTO> list = ormeditionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmEdition-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"版本对照表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormeditions/searchdefault")
	public ResponseEntity<Page<OrmEditionDTO>> searchDefault(@RequestBody OrmEditionSearchContext context) {
        Page<OrmEdition> domains = ormeditionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormeditionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

