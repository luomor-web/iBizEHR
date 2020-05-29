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
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb;
import cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbService;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbSearchContext;

@Slf4j
@Api(tags = {"年度量化目标（职能部门级）" })
@RestController("WebApi-parznbmndlhmb")
@RequestMapping("")
public class ParZnbmndlhmbResource {

    @Autowired
    public IParZnbmndlhmbService parznbmndlhmbService;

    @Autowired
    @Lazy
    public ParZnbmndlhmbMapping parznbmndlhmbMapping;

    @ApiOperation(value = "检查年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "检查年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParZnbmndlhmbDTO parznbmndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.checkKey(parznbmndlhmbMapping.toDomain(parznbmndlhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbMapping.toDomain(#parznbmndlhmbdto),'ehr-ParZnbmndlhmb-Save')")
    @ApiOperation(value = "保存年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "保存年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParZnbmndlhmbDTO parznbmndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.save(parznbmndlhmbMapping.toDomain(parznbmndlhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbMapping.toDomain(#parznbmndlhmbdtos),'ehr-ParZnbmndlhmb-Save')")
    @ApiOperation(value = "批量保存年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "批量保存年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParZnbmndlhmbDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.saveBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbService.get(#parznbmndlhmb_id),'ehr-ParZnbmndlhmb-Remove')")
    @ApiOperation(value = "删除年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "删除年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbService.remove(parznbmndlhmb_id));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbService.getParznbmndlhmbByIds(#ids),'ehr-ParZnbmndlhmb-Remove')")
    @ApiOperation(value = "批量删除年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "批量删除年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbService.get(#parznbmndlhmb_id),'ehr-ParZnbmndlhmb-Update')")
    @ApiOperation(value = "更新年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "更新年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    @Transactional
    public ResponseEntity<ParZnbmndlhmbDTO> update(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id, @RequestBody ParZnbmndlhmbDTO parznbmndlhmbdto) {
		ParZnbmndlhmb domain  = parznbmndlhmbMapping.toDomain(parznbmndlhmbdto);
        domain .setParznbmndlhmbid(parznbmndlhmb_id);
		parznbmndlhmbService.update(domain );
		ParZnbmndlhmbDTO dto = parznbmndlhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbService.getParznbmndlhmbByEntities(this.parznbmndlhmbMapping.toDomain(#parznbmndlhmbdtos)),'ehr-ParZnbmndlhmb-Update')")
    @ApiOperation(value = "批量更新年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "批量更新年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParZnbmndlhmbDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.updateBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度量化目标（职能部门级）草稿", tags = {"年度量化目标（职能部门级）" },  notes = "获取年度量化目标（职能部门级）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbs/getdraft")
    public ResponseEntity<ParZnbmndlhmbDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbMapping.toDto(parznbmndlhmbService.getDraft(new ParZnbmndlhmb())));
    }

    @PostAuthorize("hasPermission(this.parznbmndlhmbMapping.toDomain(returnObject.body),'ehr-ParZnbmndlhmb-Get')")
    @ApiOperation(value = "获取年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "获取年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbs/{parznbmndlhmb_id}")
    public ResponseEntity<ParZnbmndlhmbDTO> get(@PathVariable("parznbmndlhmb_id") String parznbmndlhmb_id) {
        ParZnbmndlhmb domain = parznbmndlhmbService.get(parznbmndlhmb_id);
        ParZnbmndlhmbDTO dto = parznbmndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbMapping.toDomain(#parznbmndlhmbdto),'ehr-ParZnbmndlhmb-Create')")
    @ApiOperation(value = "新建年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "新建年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs")
    @Transactional
    public ResponseEntity<ParZnbmndlhmbDTO> create(@RequestBody ParZnbmndlhmbDTO parznbmndlhmbdto) {
        ParZnbmndlhmb domain = parznbmndlhmbMapping.toDomain(parznbmndlhmbdto);
		parznbmndlhmbService.create(domain);
        ParZnbmndlhmbDTO dto = parznbmndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbMapping.toDomain(#parznbmndlhmbdtos),'ehr-ParZnbmndlhmb-Create')")
    @ApiOperation(value = "批量新建年度量化目标（职能部门级）", tags = {"年度量化目标（职能部门级）" },  notes = "批量新建年度量化目标（职能部门级）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParZnbmndlhmbDTO> parznbmndlhmbdtos) {
        parznbmndlhmbService.createBatch(parznbmndlhmbMapping.toDomain(parznbmndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmndlhmb-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标（职能部门级）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbs/fetchdefault")
	public ResponseEntity<List<ParZnbmndlhmbDTO>> fetchDefault(ParZnbmndlhmbSearchContext context) {
        Page<ParZnbmndlhmb> domains = parznbmndlhmbService.searchDefault(context) ;
        List<ParZnbmndlhmbDTO> list = parznbmndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmndlhmb-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标（职能部门级）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmndlhmbs/searchdefault")
	public ResponseEntity<Page<ParZnbmndlhmbDTO>> searchDefault(@RequestBody ParZnbmndlhmbSearchContext context) {
        Page<ParZnbmndlhmb> domains = parznbmndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

