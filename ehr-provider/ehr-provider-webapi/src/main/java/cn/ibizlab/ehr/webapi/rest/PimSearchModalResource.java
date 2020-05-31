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
import cn.ibizlab.ehr.core.pim.domain.PimSearchModal;
import cn.ibizlab.ehr.core.pim.service.IPimSearchModalService;
import cn.ibizlab.ehr.core.pim.filter.PimSearchModalSearchContext;

@Slf4j
@Api(tags = {"组合查询记录" })
@RestController("WebApi-pimsearchmodal")
@RequestMapping("")
public class PimSearchModalResource {

    @Autowired
    public IPimSearchModalService pimsearchmodalService;

    @Autowired
    @Lazy
    public PimSearchModalMapping pimsearchmodalMapping;

    @ApiOperation(value = "获取组合查询记录草稿", tags = {"组合查询记录" },  notes = "获取组合查询记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchmodals/getdraft")
    public ResponseEntity<PimSearchModalDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalMapping.toDto(pimsearchmodalService.getDraft(new PimSearchModal())));
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalService.get(#pimsearchmodal_id),'ehr-PimSearchModal-Update')")
    @ApiOperation(value = "更新组合查询记录", tags = {"组合查询记录" },  notes = "更新组合查询记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchmodals/{pimsearchmodal_id}")
    @Transactional
    public ResponseEntity<PimSearchModalDTO> update(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id, @RequestBody PimSearchModalDTO pimsearchmodaldto) {
		PimSearchModal domain  = pimsearchmodalMapping.toDomain(pimsearchmodaldto);
        domain .setPimsearchmodalid(pimsearchmodal_id);
		pimsearchmodalService.update(domain );
		PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalService.getPimsearchmodalByEntities(this.pimsearchmodalMapping.toDomain(#pimsearchmodaldtos)),'ehr-PimSearchModal-Update')")
    @ApiOperation(value = "批量更新组合查询记录", tags = {"组合查询记录" },  notes = "批量更新组合查询记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.updateBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimsearchmodalMapping.toDomain(returnObject.body),'ehr-PimSearchModal-Get')")
    @ApiOperation(value = "获取组合查询记录", tags = {"组合查询记录" },  notes = "获取组合查询记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchmodals/{pimsearchmodal_id}")
    public ResponseEntity<PimSearchModalDTO> get(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id) {
        PimSearchModal domain = pimsearchmodalService.get(pimsearchmodal_id);
        PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalMapping.toDomain(#pimsearchmodaldto),'ehr-PimSearchModal-Create')")
    @ApiOperation(value = "新建组合查询记录", tags = {"组合查询记录" },  notes = "新建组合查询记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals")
    @Transactional
    public ResponseEntity<PimSearchModalDTO> create(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        PimSearchModal domain = pimsearchmodalMapping.toDomain(pimsearchmodaldto);
		pimsearchmodalService.create(domain);
        PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalMapping.toDomain(#pimsearchmodaldtos),'ehr-PimSearchModal-Create')")
    @ApiOperation(value = "批量新建组合查询记录", tags = {"组合查询记录" },  notes = "批量新建组合查询记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.createBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查组合查询记录", tags = {"组合查询记录" },  notes = "检查组合查询记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.checkKey(pimsearchmodalMapping.toDomain(pimsearchmodaldto)));
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalMapping.toDomain(#pimsearchmodaldto),'ehr-PimSearchModal-Save')")
    @ApiOperation(value = "保存组合查询记录", tags = {"组合查询记录" },  notes = "保存组合查询记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/save")
    public ResponseEntity<Boolean> save(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.save(pimsearchmodalMapping.toDomain(pimsearchmodaldto)));
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalMapping.toDomain(#pimsearchmodaldtos),'ehr-PimSearchModal-Save')")
    @ApiOperation(value = "批量保存组合查询记录", tags = {"组合查询记录" },  notes = "批量保存组合查询记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.saveBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalService.get(#pimsearchmodal_id),'ehr-PimSearchModal-Remove')")
    @ApiOperation(value = "删除组合查询记录", tags = {"组合查询记录" },  notes = "删除组合查询记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchmodals/{pimsearchmodal_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.remove(pimsearchmodal_id));
    }

    @PreAuthorize("hasPermission(this.pimsearchmodalService.getPimsearchmodalByIds(#ids),'ehr-PimSearchModal-Remove')")
    @ApiOperation(value = "批量删除组合查询记录", tags = {"组合查询记录" },  notes = "批量删除组合查询记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsearchmodalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchModal-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"组合查询记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchmodals/fetchdefault")
	public ResponseEntity<List<PimSearchModalDTO>> fetchDefault(PimSearchModalSearchContext context) {
        Page<PimSearchModal> domains = pimsearchmodalService.searchDefault(context) ;
        List<PimSearchModalDTO> list = pimsearchmodalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchModal-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"组合查询记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchmodals/searchdefault")
	public ResponseEntity<Page<PimSearchModalDTO>> searchDefault(@RequestBody PimSearchModalSearchContext context) {
        Page<PimSearchModal> domains = pimsearchmodalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchmodalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

