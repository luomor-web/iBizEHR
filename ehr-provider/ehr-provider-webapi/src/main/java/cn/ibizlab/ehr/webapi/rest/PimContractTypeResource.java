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
import cn.ibizlab.ehr.core.pim.domain.PimContractType;
import cn.ibizlab.ehr.core.pim.service.IPimContractTypeService;
import cn.ibizlab.ehr.core.pim.filter.PimContractTypeSearchContext;

@Slf4j
@Api(tags = {"合同类别" })
@RestController("WebApi-pimcontracttype")
@RequestMapping("")
public class PimContractTypeResource {

    @Autowired
    public IPimContractTypeService pimcontracttypeService;

    @Autowired
    @Lazy
    public PimContractTypeMapping pimcontracttypeMapping;

    @PreAuthorize("hasPermission(this.pimcontracttypeService.get(#pimcontracttype_id),'ehr-PimContractType-Update')")
    @ApiOperation(value = "更新合同类别", tags = {"合同类别" },  notes = "更新合同类别")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracttypes/{pimcontracttype_id}")
    @Transactional
    public ResponseEntity<PimContractTypeDTO> update(@PathVariable("pimcontracttype_id") String pimcontracttype_id, @RequestBody PimContractTypeDTO pimcontracttypedto) {
		PimContractType domain  = pimcontracttypeMapping.toDomain(pimcontracttypedto);
        domain .setPimcontracttypeid(pimcontracttype_id);
		pimcontracttypeService.update(domain );
		PimContractTypeDTO dto = pimcontracttypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.getPimcontracttypeByEntities(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos)),'ehr-PimContractType-Update')")
    @ApiOperation(value = "批量更新合同类别", tags = {"合同类别" },  notes = "批量更新合同类别")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimContractTypeDTO> pimcontracttypedtos) {
        pimcontracttypeService.updateBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedto),'ehr-PimContractType-Save')")
    @ApiOperation(value = "保存合同类别", tags = {"合同类别" },  notes = "保存合同类别")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimContractTypeDTO pimcontracttypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.save(pimcontracttypeMapping.toDomain(pimcontracttypedto)));
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos),'ehr-PimContractType-Save')")
    @ApiOperation(value = "批量保存合同类别", tags = {"合同类别" },  notes = "批量保存合同类别")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimContractTypeDTO> pimcontracttypedtos) {
        pimcontracttypeService.saveBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.get(#pimcontracttype_id),'ehr-PimContractType-Remove')")
    @ApiOperation(value = "删除合同类别", tags = {"合同类别" },  notes = "删除合同类别")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracttypes/{pimcontracttype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcontracttype_id") String pimcontracttype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.remove(pimcontracttype_id));
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.getPimcontracttypeByIds(#ids),'ehr-PimContractType-Remove')")
    @ApiOperation(value = "批量删除合同类别", tags = {"合同类别" },  notes = "批量删除合同类别")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcontracttypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedto),'ehr-PimContractType-Create')")
    @ApiOperation(value = "新建合同类别", tags = {"合同类别" },  notes = "新建合同类别")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes")
    @Transactional
    public ResponseEntity<PimContractTypeDTO> create(@RequestBody PimContractTypeDTO pimcontracttypedto) {
        PimContractType domain = pimcontracttypeMapping.toDomain(pimcontracttypedto);
		pimcontracttypeService.create(domain);
        PimContractTypeDTO dto = pimcontracttypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos),'ehr-PimContractType-Create')")
    @ApiOperation(value = "批量新建合同类别", tags = {"合同类别" },  notes = "批量新建合同类别")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimContractTypeDTO> pimcontracttypedtos) {
        pimcontracttypeService.createBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(returnObject.body),'ehr-PimContractType-Get')")
    @ApiOperation(value = "获取合同类别", tags = {"合同类别" },  notes = "获取合同类别")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracttypes/{pimcontracttype_id}")
    public ResponseEntity<PimContractTypeDTO> get(@PathVariable("pimcontracttype_id") String pimcontracttype_id) {
        PimContractType domain = pimcontracttypeService.get(pimcontracttype_id);
        PimContractTypeDTO dto = pimcontracttypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取合同类别草稿", tags = {"合同类别" },  notes = "获取合同类别草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracttypes/getdraft")
    public ResponseEntity<PimContractTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeMapping.toDto(pimcontracttypeService.getDraft(new PimContractType())));
    }

    @ApiOperation(value = "检查合同类别", tags = {"合同类别" },  notes = "检查合同类别")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimContractTypeDTO pimcontracttypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.checkKey(pimcontracttypeMapping.toDomain(pimcontracttypedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractType-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"合同类别" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracttypes/fetchdefault")
	public ResponseEntity<List<PimContractTypeDTO>> fetchDefault(PimContractTypeSearchContext context) {
        Page<PimContractType> domains = pimcontracttypeService.searchDefault(context) ;
        List<PimContractTypeDTO> list = pimcontracttypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContractType-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"合同类别" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracttypes/searchdefault")
	public ResponseEntity<Page<PimContractTypeDTO>> searchDefault(@RequestBody PimContractTypeSearchContext context) {
        Page<PimContractType> domains = pimcontracttypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontracttypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

