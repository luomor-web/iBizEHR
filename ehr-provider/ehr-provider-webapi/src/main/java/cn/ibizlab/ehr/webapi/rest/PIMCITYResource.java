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
import cn.ibizlab.ehr.core.pim.domain.PIMCITY;
import cn.ibizlab.ehr.core.pim.service.IPIMCITYService;
import cn.ibizlab.ehr.core.pim.filter.PIMCITYSearchContext;

@Slf4j
@Api(tags = {"市" })
@RestController("WebApi-pimcity")
@RequestMapping("")
public class PIMCITYResource {

    @Autowired
    public IPIMCITYService pimcityService;

    @Autowired
    @Lazy
    public PIMCITYMapping pimcityMapping;

    @ApiOperation(value = "检查市", tags = {"市" },  notes = "检查市")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCITYDTO pimcitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcityService.checkKey(pimcityMapping.toDomain(pimcitydto)));
    }

    @PreAuthorize("hasPermission(this.pimcityService.get(#pimcity_id),'ehr-PIMCITY-Remove')")
    @ApiOperation(value = "删除市", tags = {"市" },  notes = "删除市")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcities/{pimcity_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcity_id") String pimcity_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcityService.remove(pimcity_id));
    }

    @PreAuthorize("hasPermission(this.pimcityService.getPimcityByIds(#ids),'ehr-PIMCITY-Remove')")
    @ApiOperation(value = "批量删除市", tags = {"市" },  notes = "批量删除市")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取市草稿", tags = {"市" },  notes = "获取市草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcities/getdraft")
    public ResponseEntity<PIMCITYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcityMapping.toDto(pimcityService.getDraft(new PIMCITY())));
    }

    @PreAuthorize("hasPermission(this.pimcityService.get(#pimcity_id),'ehr-PIMCITY-Update')")
    @ApiOperation(value = "更新市", tags = {"市" },  notes = "更新市")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcities/{pimcity_id}")
    @Transactional
    public ResponseEntity<PIMCITYDTO> update(@PathVariable("pimcity_id") String pimcity_id, @RequestBody PIMCITYDTO pimcitydto) {
		PIMCITY domain  = pimcityMapping.toDomain(pimcitydto);
        domain .setPimcityid(pimcity_id);
		pimcityService.update(domain );
		PIMCITYDTO dto = pimcityMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcityService.getPimcityByEntities(this.pimcityMapping.toDomain(#pimcitydtos)),'ehr-PIMCITY-Update')")
    @ApiOperation(value = "批量更新市", tags = {"市" },  notes = "批量更新市")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.updateBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcityMapping.toDomain(#pimcitydto),'ehr-PIMCITY-Save')")
    @ApiOperation(value = "保存市", tags = {"市" },  notes = "保存市")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCITYDTO pimcitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcityService.save(pimcityMapping.toDomain(pimcitydto)));
    }

    @PreAuthorize("hasPermission(this.pimcityMapping.toDomain(#pimcitydtos),'ehr-PIMCITY-Save')")
    @ApiOperation(value = "批量保存市", tags = {"市" },  notes = "批量保存市")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.saveBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcityMapping.toDomain(returnObject.body),'ehr-PIMCITY-Get')")
    @ApiOperation(value = "获取市", tags = {"市" },  notes = "获取市")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcities/{pimcity_id}")
    public ResponseEntity<PIMCITYDTO> get(@PathVariable("pimcity_id") String pimcity_id) {
        PIMCITY domain = pimcityService.get(pimcity_id);
        PIMCITYDTO dto = pimcityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcityMapping.toDomain(#pimcitydto),'ehr-PIMCITY-Create')")
    @ApiOperation(value = "新建市", tags = {"市" },  notes = "新建市")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities")
    @Transactional
    public ResponseEntity<PIMCITYDTO> create(@RequestBody PIMCITYDTO pimcitydto) {
        PIMCITY domain = pimcityMapping.toDomain(pimcitydto);
		pimcityService.create(domain);
        PIMCITYDTO dto = pimcityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcityMapping.toDomain(#pimcitydtos),'ehr-PIMCITY-Create')")
    @ApiOperation(value = "批量新建市", tags = {"市" },  notes = "批量新建市")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.createBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCITY-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"市" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcities/fetchdefault")
	public ResponseEntity<List<PIMCITYDTO>> fetchDefault(PIMCITYSearchContext context) {
        Page<PIMCITY> domains = pimcityService.searchDefault(context) ;
        List<PIMCITYDTO> list = pimcityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCITY-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"市" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcities/searchdefault")
	public ResponseEntity<Page<PIMCITYDTO>> searchDefault(@RequestBody PIMCITYSearchContext context) {
        Page<PIMCITY> domains = pimcityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

