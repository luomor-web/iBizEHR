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
import cn.ibizlab.ehr.core.pim.domain.PimWorkflowRef;
import cn.ibizlab.ehr.core.pim.service.IPimWorkflowRefService;
import cn.ibizlab.ehr.core.pim.filter.PimWorkflowRefSearchContext;

@Slf4j
@Api(tags = {"平台流程配置" })
@RestController("WebApi-pimworkflowref")
@RequestMapping("")
public class PimWorkflowRefResource {

    @Autowired
    public IPimWorkflowRefService pimworkflowrefService;

    @Autowired
    @Lazy
    public PimWorkflowRefMapping pimworkflowrefMapping;

    @ApiOperation(value = "获取平台流程配置草稿", tags = {"平台流程配置" },  notes = "获取平台流程配置草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflowrefs/getdraft")
    public ResponseEntity<PimWorkflowRefDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefMapping.toDto(pimworkflowrefService.getDraft(new PimWorkflowRef())));
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefService.get(#pimworkflowref_id),'ehr-PimWorkflowRef-Update')")
    @ApiOperation(value = "更新平台流程配置", tags = {"平台流程配置" },  notes = "更新平台流程配置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflowrefs/{pimworkflowref_id}")
    @Transactional
    public ResponseEntity<PimWorkflowRefDTO> update(@PathVariable("pimworkflowref_id") String pimworkflowref_id, @RequestBody PimWorkflowRefDTO pimworkflowrefdto) {
		PimWorkflowRef domain  = pimworkflowrefMapping.toDomain(pimworkflowrefdto);
        domain .setPimworkflowrefid(pimworkflowref_id);
		pimworkflowrefService.update(domain );
		PimWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefService.getPimworkflowrefByEntities(this.pimworkflowrefMapping.toDomain(#pimworkflowrefdtos)),'ehr-PimWorkflowRef-Update')")
    @ApiOperation(value = "批量更新平台流程配置", tags = {"平台流程配置" },  notes = "批量更新平台流程配置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.updateBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimworkflowrefMapping.toDomain(returnObject.body),'ehr-PimWorkflowRef-Get')")
    @ApiOperation(value = "获取平台流程配置", tags = {"平台流程配置" },  notes = "获取平台流程配置")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflowrefs/{pimworkflowref_id}")
    public ResponseEntity<PimWorkflowRefDTO> get(@PathVariable("pimworkflowref_id") String pimworkflowref_id) {
        PimWorkflowRef domain = pimworkflowrefService.get(pimworkflowref_id);
        PimWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefMapping.toDomain(#pimworkflowrefdto),'ehr-PimWorkflowRef-Save')")
    @ApiOperation(value = "保存平台流程配置", tags = {"平台流程配置" },  notes = "保存平台流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimWorkflowRefDTO pimworkflowrefdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.save(pimworkflowrefMapping.toDomain(pimworkflowrefdto)));
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefMapping.toDomain(#pimworkflowrefdtos),'ehr-PimWorkflowRef-Save')")
    @ApiOperation(value = "批量保存平台流程配置", tags = {"平台流程配置" },  notes = "批量保存平台流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.saveBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefService.get(#pimworkflowref_id),'ehr-PimWorkflowRef-Remove')")
    @ApiOperation(value = "删除平台流程配置", tags = {"平台流程配置" },  notes = "删除平台流程配置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflowrefs/{pimworkflowref_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkflowref_id") String pimworkflowref_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.remove(pimworkflowref_id));
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefService.getPimworkflowrefByIds(#ids),'ehr-PimWorkflowRef-Remove')")
    @ApiOperation(value = "批量删除平台流程配置", tags = {"平台流程配置" },  notes = "批量删除平台流程配置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkflowrefService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefMapping.toDomain(#pimworkflowrefdto),'ehr-PimWorkflowRef-Create')")
    @ApiOperation(value = "新建平台流程配置", tags = {"平台流程配置" },  notes = "新建平台流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs")
    @Transactional
    public ResponseEntity<PimWorkflowRefDTO> create(@RequestBody PimWorkflowRefDTO pimworkflowrefdto) {
        PimWorkflowRef domain = pimworkflowrefMapping.toDomain(pimworkflowrefdto);
		pimworkflowrefService.create(domain);
        PimWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowrefMapping.toDomain(#pimworkflowrefdtos),'ehr-PimWorkflowRef-Create')")
    @ApiOperation(value = "批量新建平台流程配置", tags = {"平台流程配置" },  notes = "批量新建平台流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.createBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查平台流程配置", tags = {"平台流程配置" },  notes = "检查平台流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimWorkflowRefDTO pimworkflowrefdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.checkKey(pimworkflowrefMapping.toDomain(pimworkflowrefdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkflowRef-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"平台流程配置" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkflowrefs/fetchdefault")
	public ResponseEntity<List<PimWorkflowRefDTO>> fetchDefault(PimWorkflowRefSearchContext context) {
        Page<PimWorkflowRef> domains = pimworkflowrefService.searchDefault(context) ;
        List<PimWorkflowRefDTO> list = pimworkflowrefMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkflowRef-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"平台流程配置" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkflowrefs/searchdefault")
	public ResponseEntity<Page<PimWorkflowRefDTO>> searchDefault(@RequestBody PimWorkflowRefSearchContext context) {
        Page<PimWorkflowRef> domains = pimworkflowrefService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkflowrefMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

