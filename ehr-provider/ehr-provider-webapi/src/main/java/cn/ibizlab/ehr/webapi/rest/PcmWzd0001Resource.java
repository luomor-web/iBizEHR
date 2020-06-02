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
import cn.ibizlab.ehr.core.pcm.domain.PcmWzd0001;
import cn.ibizlab.ehr.core.pcm.service.IPcmWzd0001Service;
import cn.ibizlab.ehr.core.pcm.filter.PcmWzd0001SearchContext;

@Slf4j
@Api(tags = {"向导实体1" })
@RestController("WebApi-pcmwzd0001")
@RequestMapping("")
public class PcmWzd0001Resource {

    @Autowired
    public IPcmWzd0001Service pcmwzd0001Service;

    @Autowired
    @Lazy
    public PcmWzd0001Mapping pcmwzd0001Mapping;

    @PreAuthorize("hasPermission(this.pcmwzd0001Service.get(#pcmwzd0001_id),'ehr-PcmWzd0001-Remove')")
    @ApiOperation(value = "删除向导实体1", tags = {"向导实体1" },  notes = "删除向导实体1")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmwzd0001s/{pcmwzd0001_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmwzd0001_id") String pcmwzd0001_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0001Service.remove(pcmwzd0001_id));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Service.getPcmwzd0001ByIds(#ids),'ehr-PcmWzd0001-Remove')")
    @ApiOperation(value = "批量删除向导实体1", tags = {"向导实体1" },  notes = "批量删除向导实体1")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmwzd0001s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmwzd0001Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取向导实体1草稿", tags = {"向导实体1" },  notes = "获取向导实体1草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmwzd0001s/getdraft")
    public ResponseEntity<PcmWzd0001DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0001Mapping.toDto(pcmwzd0001Service.getDraft(new PcmWzd0001())));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Mapping.toDomain(#pcmwzd0001dto),'ehr-PcmWzd0001-Save')")
    @ApiOperation(value = "保存向导实体1", tags = {"向导实体1" },  notes = "保存向导实体1")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0001s/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmWzd0001DTO pcmwzd0001dto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0001Service.save(pcmwzd0001Mapping.toDomain(pcmwzd0001dto)));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Mapping.toDomain(#pcmwzd0001dtos),'ehr-PcmWzd0001-Save')")
    @ApiOperation(value = "批量保存向导实体1", tags = {"向导实体1" },  notes = "批量保存向导实体1")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0001s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmWzd0001DTO> pcmwzd0001dtos) {
        pcmwzd0001Service.saveBatch(pcmwzd0001Mapping.toDomain(pcmwzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmwzd0001Mapping.toDomain(returnObject.body),'ehr-PcmWzd0001-Get')")
    @ApiOperation(value = "获取向导实体1", tags = {"向导实体1" },  notes = "获取向导实体1")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmwzd0001s/{pcmwzd0001_id}")
    public ResponseEntity<PcmWzd0001DTO> get(@PathVariable("pcmwzd0001_id") String pcmwzd0001_id) {
        PcmWzd0001 domain = pcmwzd0001Service.get(pcmwzd0001_id);
        PcmWzd0001DTO dto = pcmwzd0001Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Service.get(#pcmwzd0001_id),'ehr-PcmWzd0001-Update')")
    @ApiOperation(value = "更新向导实体1", tags = {"向导实体1" },  notes = "更新向导实体1")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmwzd0001s/{pcmwzd0001_id}")
    @Transactional
    public ResponseEntity<PcmWzd0001DTO> update(@PathVariable("pcmwzd0001_id") String pcmwzd0001_id, @RequestBody PcmWzd0001DTO pcmwzd0001dto) {
		PcmWzd0001 domain  = pcmwzd0001Mapping.toDomain(pcmwzd0001dto);
        domain .setWzd0001id(pcmwzd0001_id);
		pcmwzd0001Service.update(domain );
		PcmWzd0001DTO dto = pcmwzd0001Mapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Service.getPcmwzd0001ByEntities(this.pcmwzd0001Mapping.toDomain(#pcmwzd0001dtos)),'ehr-PcmWzd0001-Update')")
    @ApiOperation(value = "批量更新向导实体1", tags = {"向导实体1" },  notes = "批量更新向导实体1")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmwzd0001s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmWzd0001DTO> pcmwzd0001dtos) {
        pcmwzd0001Service.updateBatch(pcmwzd0001Mapping.toDomain(pcmwzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查向导实体1", tags = {"向导实体1" },  notes = "检查向导实体1")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0001s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmWzd0001DTO pcmwzd0001dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmwzd0001Service.checkKey(pcmwzd0001Mapping.toDomain(pcmwzd0001dto)));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Mapping.toDomain(#pcmwzd0001dto),'ehr-PcmWzd0001-Create')")
    @ApiOperation(value = "新建向导实体1", tags = {"向导实体1" },  notes = "新建向导实体1")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0001s")
    @Transactional
    public ResponseEntity<PcmWzd0001DTO> create(@RequestBody PcmWzd0001DTO pcmwzd0001dto) {
        PcmWzd0001 domain = pcmwzd0001Mapping.toDomain(pcmwzd0001dto);
		pcmwzd0001Service.create(domain);
        PcmWzd0001DTO dto = pcmwzd0001Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0001Mapping.toDomain(#pcmwzd0001dtos),'ehr-PcmWzd0001-Create')")
    @ApiOperation(value = "批量新建向导实体1", tags = {"向导实体1" },  notes = "批量新建向导实体1")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0001s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmWzd0001DTO> pcmwzd0001dtos) {
        pcmwzd0001Service.createBatch(pcmwzd0001Mapping.toDomain(pcmwzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWzd0001-UpdatePeopleNum-all')")
    @ApiOperation(value = "刷新人数", tags = {"向导实体1" },  notes = "刷新人数")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmwzd0001s/{pcmwzd0001_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PcmWzd0001DTO> updatePeopleNum(@PathVariable("pcmwzd0001_id") String pcmwzd0001_id, @RequestBody PcmWzd0001DTO pcmwzd0001dto) {
        PcmWzd0001 pcmwzd0001 = pcmwzd0001Mapping.toDomain(pcmwzd0001dto);
        pcmwzd0001.setWzd0001id(pcmwzd0001_id);
        pcmwzd0001 = pcmwzd0001Service.updatePeopleNum(pcmwzd0001);
        pcmwzd0001dto = pcmwzd0001Mapping.toDto(pcmwzd0001);
        return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0001dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWzd0001-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"向导实体1" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmwzd0001s/fetchdefault")
	public ResponseEntity<List<PcmWzd0001DTO>> fetchDefault(PcmWzd0001SearchContext context) {
        Page<PcmWzd0001> domains = pcmwzd0001Service.searchDefault(context) ;
        List<PcmWzd0001DTO> list = pcmwzd0001Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWzd0001-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"向导实体1" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmwzd0001s/searchdefault")
	public ResponseEntity<Page<PcmWzd0001DTO>> searchDefault(@RequestBody PcmWzd0001SearchContext context) {
        Page<PcmWzd0001> domains = pcmwzd0001Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmwzd0001Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

