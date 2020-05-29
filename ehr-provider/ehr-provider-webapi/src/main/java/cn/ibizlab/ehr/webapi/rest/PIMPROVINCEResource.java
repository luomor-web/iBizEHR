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
import cn.ibizlab.ehr.core.pim.domain.PIMPROVINCE;
import cn.ibizlab.ehr.core.pim.service.IPIMPROVINCEService;
import cn.ibizlab.ehr.core.pim.filter.PIMPROVINCESearchContext;

@Slf4j
@Api(tags = {"省" })
@RestController("WebApi-pimprovince")
@RequestMapping("")
public class PIMPROVINCEResource {

    @Autowired
    public IPIMPROVINCEService pimprovinceService;

    @Autowired
    @Lazy
    public PIMPROVINCEMapping pimprovinceMapping;

    @ApiOperation(value = "检查省", tags = {"省" },  notes = "检查省")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.checkKey(pimprovinceMapping.toDomain(pimprovincedto)));
    }

    @PreAuthorize("hasPermission(this.pimprovinceService.get(#pimprovince_id),'ehr-PIMPROVINCE-Remove')")
    @ApiOperation(value = "删除省", tags = {"省" },  notes = "删除省")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimprovinces/{pimprovince_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimprovince_id") String pimprovince_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.remove(pimprovince_id));
    }

    @PreAuthorize("hasPermission(this.pimprovinceService.getPimprovinceByIds(#ids),'ehr-PIMPROVINCE-Remove')")
    @ApiOperation(value = "批量删除省", tags = {"省" },  notes = "批量删除省")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimprovinceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimprovinceMapping.toDomain(returnObject.body),'ehr-PIMPROVINCE-Get')")
    @ApiOperation(value = "获取省", tags = {"省" },  notes = "获取省")
	@RequestMapping(method = RequestMethod.GET, value = "/pimprovinces/{pimprovince_id}")
    public ResponseEntity<PIMPROVINCEDTO> get(@PathVariable("pimprovince_id") String pimprovince_id) {
        PIMPROVINCE domain = pimprovinceService.get(pimprovince_id);
        PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimprovinceMapping.toDomain(#pimprovincedto),'ehr-PIMPROVINCE-Create')")
    @ApiOperation(value = "新建省", tags = {"省" },  notes = "新建省")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces")
    @Transactional
    public ResponseEntity<PIMPROVINCEDTO> create(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        PIMPROVINCE domain = pimprovinceMapping.toDomain(pimprovincedto);
		pimprovinceService.create(domain);
        PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimprovinceMapping.toDomain(#pimprovincedtos),'ehr-PIMPROVINCE-Create')")
    @ApiOperation(value = "批量新建省", tags = {"省" },  notes = "批量新建省")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.createBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取省草稿", tags = {"省" },  notes = "获取省草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimprovinces/getdraft")
    public ResponseEntity<PIMPROVINCEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimprovinceMapping.toDto(pimprovinceService.getDraft(new PIMPROVINCE())));
    }

    @PreAuthorize("hasPermission(this.pimprovinceService.get(#pimprovince_id),'ehr-PIMPROVINCE-Update')")
    @ApiOperation(value = "更新省", tags = {"省" },  notes = "更新省")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimprovinces/{pimprovince_id}")
    @Transactional
    public ResponseEntity<PIMPROVINCEDTO> update(@PathVariable("pimprovince_id") String pimprovince_id, @RequestBody PIMPROVINCEDTO pimprovincedto) {
		PIMPROVINCE domain  = pimprovinceMapping.toDomain(pimprovincedto);
        domain .setPimprovinceid(pimprovince_id);
		pimprovinceService.update(domain );
		PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimprovinceService.getPimprovinceByEntities(this.pimprovinceMapping.toDomain(#pimprovincedtos)),'ehr-PIMPROVINCE-Update')")
    @ApiOperation(value = "批量更新省", tags = {"省" },  notes = "批量更新省")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.updateBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimprovinceMapping.toDomain(#pimprovincedto),'ehr-PIMPROVINCE-Save')")
    @ApiOperation(value = "保存省", tags = {"省" },  notes = "保存省")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.save(pimprovinceMapping.toDomain(pimprovincedto)));
    }

    @PreAuthorize("hasPermission(this.pimprovinceMapping.toDomain(#pimprovincedtos),'ehr-PIMPROVINCE-Save')")
    @ApiOperation(value = "批量保存省", tags = {"省" },  notes = "批量保存省")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.saveBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"省" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimprovinces/fetchdefault")
	public ResponseEntity<List<PIMPROVINCEDTO>> fetchDefault(PIMPROVINCESearchContext context) {
        Page<PIMPROVINCE> domains = pimprovinceService.searchDefault(context) ;
        List<PIMPROVINCEDTO> list = pimprovinceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"省" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimprovinces/searchdefault")
	public ResponseEntity<Page<PIMPROVINCEDTO>> searchDefault(@RequestBody PIMPROVINCESearchContext context) {
        Page<PIMPROVINCE> domains = pimprovinceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimprovinceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

