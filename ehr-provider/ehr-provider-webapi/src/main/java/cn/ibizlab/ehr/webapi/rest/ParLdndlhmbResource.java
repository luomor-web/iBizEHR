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
import cn.ibizlab.ehr.core.par.domain.ParLdndlhmb;
import cn.ibizlab.ehr.core.par.service.IParLdndlhmbService;
import cn.ibizlab.ehr.core.par.filter.ParLdndlhmbSearchContext;

@Slf4j
@Api(tags = {"年度量化目标（公司领导类）" })
@RestController("WebApi-parldndlhmb")
@RequestMapping("")
public class ParLdndlhmbResource {

    @Autowired
    public IParLdndlhmbService parldndlhmbService;

    @Autowired
    @Lazy
    public ParLdndlhmbMapping parldndlhmbMapping;

    @PreAuthorize("hasPermission(this.parldndlhmbMapping.toDomain(#parldndlhmbdto),'ehr-ParLdndlhmb-Save')")
    @ApiOperation(value = "保存年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "保存年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLdndlhmbDTO parldndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.save(parldndlhmbMapping.toDomain(parldndlhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbMapping.toDomain(#parldndlhmbdtos),'ehr-ParLdndlhmb-Save')")
    @ApiOperation(value = "批量保存年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "批量保存年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLdndlhmbDTO> parldndlhmbdtos) {
        parldndlhmbService.saveBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度量化目标（公司领导类）草稿", tags = {"年度量化目标（公司领导类）" },  notes = "获取年度量化目标（公司领导类）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/getdraft")
    public ResponseEntity<ParLdndlhmbDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbMapping.toDto(parldndlhmbService.getDraft(new ParLdndlhmb())));
    }

    @ApiOperation(value = "检查年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "检查年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLdndlhmbDTO parldndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.checkKey(parldndlhmbMapping.toDomain(parldndlhmbdto)));
    }

    @PostAuthorize("hasPermission(this.parldndlhmbMapping.toDomain(returnObject.body),'ehr-ParLdndlhmb-Get')")
    @ApiOperation(value = "获取年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "获取年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/{parldndlhmb_id}")
    public ResponseEntity<ParLdndlhmbDTO> get(@PathVariable("parldndlhmb_id") String parldndlhmb_id) {
        ParLdndlhmb domain = parldndlhmbService.get(parldndlhmb_id);
        ParLdndlhmbDTO dto = parldndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbMapping.toDomain(#parldndlhmbdto),'ehr-ParLdndlhmb-Create')")
    @ApiOperation(value = "新建年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "新建年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs")
    @Transactional
    public ResponseEntity<ParLdndlhmbDTO> create(@RequestBody ParLdndlhmbDTO parldndlhmbdto) {
        ParLdndlhmb domain = parldndlhmbMapping.toDomain(parldndlhmbdto);
		parldndlhmbService.create(domain);
        ParLdndlhmbDTO dto = parldndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbMapping.toDomain(#parldndlhmbdtos),'ehr-ParLdndlhmb-Create')")
    @ApiOperation(value = "批量新建年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "批量新建年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLdndlhmbDTO> parldndlhmbdtos) {
        parldndlhmbService.createBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbService.get(#parldndlhmb_id),'ehr-ParLdndlhmb-Update')")
    @ApiOperation(value = "更新年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "更新年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/{parldndlhmb_id}")
    @Transactional
    public ResponseEntity<ParLdndlhmbDTO> update(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody ParLdndlhmbDTO parldndlhmbdto) {
		ParLdndlhmb domain  = parldndlhmbMapping.toDomain(parldndlhmbdto);
        domain .setParldndlhmbid(parldndlhmb_id);
		parldndlhmbService.update(domain );
		ParLdndlhmbDTO dto = parldndlhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbService.getParldndlhmbByEntities(this.parldndlhmbMapping.toDomain(#parldndlhmbdtos)),'ehr-ParLdndlhmb-Update')")
    @ApiOperation(value = "批量更新年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "批量更新年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLdndlhmbDTO> parldndlhmbdtos) {
        parldndlhmbService.updateBatch(parldndlhmbMapping.toDomain(parldndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbService.get(#parldndlhmb_id),'ehr-ParLdndlhmb-Remove')")
    @ApiOperation(value = "删除年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "删除年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/{parldndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldndlhmb_id") String parldndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbService.remove(parldndlhmb_id));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbService.getParldndlhmbByIds(#ids),'ehr-ParLdndlhmb-Remove')")
    @ApiOperation(value = "批量删除年度量化目标（公司领导类）", tags = {"年度量化目标（公司领导类）" },  notes = "批量删除年度量化目标（公司领导类）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmb-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标（公司领导类）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldndlhmbs/fetchdefault")
	public ResponseEntity<List<ParLdndlhmbDTO>> fetchDefault(ParLdndlhmbSearchContext context) {
        Page<ParLdndlhmb> domains = parldndlhmbService.searchDefault(context) ;
        List<ParLdndlhmbDTO> list = parldndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmb-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标（公司领导类）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldndlhmbs/searchdefault")
	public ResponseEntity<Page<ParLdndlhmbDTO>> searchDefault(@RequestBody ParLdndlhmbSearchContext context) {
        Page<ParLdndlhmb> domains = parldndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

