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
import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmb;
import cn.ibizlab.ehr.core.par.service.IParPtryndlhmbService;
import cn.ibizlab.ehr.core.par.filter.ParPtryndlhmbSearchContext;

@Slf4j
@Api(tags = {"年度量化目标（部门副职及以下人员）" })
@RestController("WebApi-parptryndlhmb")
@RequestMapping("")
public class ParPtryndlhmbResource {

    @Autowired
    public IParPtryndlhmbService parptryndlhmbService;

    @Autowired
    @Lazy
    public ParPtryndlhmbMapping parptryndlhmbMapping;

    @PostAuthorize("hasPermission(this.parptryndlhmbMapping.toDomain(returnObject.body),'ehr-ParPtryndlhmb-Get')")
    @ApiOperation(value = "获取年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "获取年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    public ResponseEntity<ParPtryndlhmbDTO> get(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id) {
        ParPtryndlhmb domain = parptryndlhmbService.get(parptryndlhmb_id);
        ParPtryndlhmbDTO dto = parptryndlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbMapping.toDomain(#parptryndlhmbdto),'ehr-ParPtryndlhmb-Create')")
    @ApiOperation(value = "新建年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "新建年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs")
    @Transactional
    public ResponseEntity<ParPtryndlhmbDTO> create(@RequestBody ParPtryndlhmbDTO parptryndlhmbdto) {
        ParPtryndlhmb domain = parptryndlhmbMapping.toDomain(parptryndlhmbdto);
		parptryndlhmbService.create(domain);
        ParPtryndlhmbDTO dto = parptryndlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbMapping.toDomain(#parptryndlhmbdtos),'ehr-ParPtryndlhmb-Create')")
    @ApiOperation(value = "批量新建年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "批量新建年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParPtryndlhmbDTO> parptryndlhmbdtos) {
        parptryndlhmbService.createBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbService.get(#parptryndlhmb_id),'ehr-ParPtryndlhmb-Remove')")
    @ApiOperation(value = "删除年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "删除年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.remove(parptryndlhmb_id));
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbService.getParptryndlhmbByIds(#ids),'ehr-ParPtryndlhmb-Remove')")
    @ApiOperation(value = "批量删除年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "批量删除年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parptryndlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbService.get(#parptryndlhmb_id),'ehr-ParPtryndlhmb-Update')")
    @ApiOperation(value = "更新年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "更新年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbs/{parptryndlhmb_id}")
    @Transactional
    public ResponseEntity<ParPtryndlhmbDTO> update(@PathVariable("parptryndlhmb_id") String parptryndlhmb_id, @RequestBody ParPtryndlhmbDTO parptryndlhmbdto) {
		ParPtryndlhmb domain  = parptryndlhmbMapping.toDomain(parptryndlhmbdto);
        domain .setParptryndlhmbid(parptryndlhmb_id);
		parptryndlhmbService.update(domain );
		ParPtryndlhmbDTO dto = parptryndlhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbService.getParptryndlhmbByEntities(this.parptryndlhmbMapping.toDomain(#parptryndlhmbdtos)),'ehr-ParPtryndlhmb-Update')")
    @ApiOperation(value = "批量更新年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "批量更新年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParPtryndlhmbDTO> parptryndlhmbdtos) {
        parptryndlhmbService.updateBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbMapping.toDomain(#parptryndlhmbdto),'ehr-ParPtryndlhmb-Save')")
    @ApiOperation(value = "保存年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "保存年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParPtryndlhmbDTO parptryndlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.save(parptryndlhmbMapping.toDomain(parptryndlhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbMapping.toDomain(#parptryndlhmbdtos),'ehr-ParPtryndlhmb-Save')")
    @ApiOperation(value = "批量保存年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "批量保存年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParPtryndlhmbDTO> parptryndlhmbdtos) {
        parptryndlhmbService.saveBatch(parptryndlhmbMapping.toDomain(parptryndlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度量化目标（部门副职及以下人员）草稿", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "获取年度量化目标（部门副职及以下人员）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbs/getdraft")
    public ResponseEntity<ParPtryndlhmbDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbMapping.toDto(parptryndlhmbService.getDraft(new ParPtryndlhmb())));
    }

    @ApiOperation(value = "检查年度量化目标（部门副职及以下人员）", tags = {"年度量化目标（部门副职及以下人员）" },  notes = "检查年度量化目标（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParPtryndlhmbDTO parptryndlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbService.checkKey(parptryndlhmbMapping.toDomain(parptryndlhmbdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParPtryndlhmb-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标（部门副职及以下人员）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parptryndlhmbs/fetchdefault")
	public ResponseEntity<List<ParPtryndlhmbDTO>> fetchDefault(ParPtryndlhmbSearchContext context) {
        Page<ParPtryndlhmb> domains = parptryndlhmbService.searchDefault(context) ;
        List<ParPtryndlhmbDTO> list = parptryndlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParPtryndlhmb-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标（部门副职及以下人员）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parptryndlhmbs/searchdefault")
	public ResponseEntity<Page<ParPtryndlhmbDTO>> searchDefault(@RequestBody ParPtryndlhmbSearchContext context) {
        Page<ParPtryndlhmb> domains = parptryndlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parptryndlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

