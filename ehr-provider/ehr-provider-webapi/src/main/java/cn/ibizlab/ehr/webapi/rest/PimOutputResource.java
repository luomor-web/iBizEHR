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
import cn.ibizlab.ehr.core.pim.domain.PimOutput;
import cn.ibizlab.ehr.core.pim.service.IPimOutputService;
import cn.ibizlab.ehr.core.pim.filter.PimOutputSearchContext;

@Slf4j
@Api(tags = {"产值表" })
@RestController("WebApi-pimoutput")
@RequestMapping("")
public class PimOutputResource {

    @Autowired
    public IPimOutputService pimoutputService;

    @Autowired
    @Lazy
    public PimOutputMapping pimoutputMapping;

    @PreAuthorize("hasPermission(this.pimoutputService.get(#pimoutput_id),'ehr-PimOutput-Update')")
    @ApiOperation(value = "更新产值表", tags = {"产值表" },  notes = "更新产值表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimoutputs/{pimoutput_id}")
    @Transactional
    public ResponseEntity<PimOutputDTO> update(@PathVariable("pimoutput_id") String pimoutput_id, @RequestBody PimOutputDTO pimoutputdto) {
		PimOutput domain  = pimoutputMapping.toDomain(pimoutputdto);
        domain .setPimoutputid(pimoutput_id);
		pimoutputService.update(domain );
		PimOutputDTO dto = pimoutputMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimoutputService.getPimoutputByEntities(this.pimoutputMapping.toDomain(#pimoutputdtos)),'ehr-PimOutput-Update')")
    @ApiOperation(value = "批量更新产值表", tags = {"产值表" },  notes = "批量更新产值表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimOutputDTO> pimoutputdtos) {
        pimoutputService.updateBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimoutputMapping.toDomain(returnObject.body),'ehr-PimOutput-Get')")
    @ApiOperation(value = "获取产值表", tags = {"产值表" },  notes = "获取产值表")
	@RequestMapping(method = RequestMethod.GET, value = "/pimoutputs/{pimoutput_id}")
    public ResponseEntity<PimOutputDTO> get(@PathVariable("pimoutput_id") String pimoutput_id) {
        PimOutput domain = pimoutputService.get(pimoutput_id);
        PimOutputDTO dto = pimoutputMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimoutputMapping.toDomain(#pimoutputdto),'ehr-PimOutput-Create')")
    @ApiOperation(value = "新建产值表", tags = {"产值表" },  notes = "新建产值表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs")
    @Transactional
    public ResponseEntity<PimOutputDTO> create(@RequestBody PimOutputDTO pimoutputdto) {
        PimOutput domain = pimoutputMapping.toDomain(pimoutputdto);
		pimoutputService.create(domain);
        PimOutputDTO dto = pimoutputMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimoutputMapping.toDomain(#pimoutputdtos),'ehr-PimOutput-Create')")
    @ApiOperation(value = "批量新建产值表", tags = {"产值表" },  notes = "批量新建产值表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimOutputDTO> pimoutputdtos) {
        pimoutputService.createBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查产值表", tags = {"产值表" },  notes = "检查产值表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimOutputDTO pimoutputdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimoutputService.checkKey(pimoutputMapping.toDomain(pimoutputdto)));
    }

    @ApiOperation(value = "获取产值表草稿", tags = {"产值表" },  notes = "获取产值表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimoutputs/getdraft")
    public ResponseEntity<PimOutputDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimoutputMapping.toDto(pimoutputService.getDraft(new PimOutput())));
    }

    @PreAuthorize("hasPermission(this.pimoutputService.get(#pimoutput_id),'ehr-PimOutput-Remove')")
    @ApiOperation(value = "删除产值表", tags = {"产值表" },  notes = "删除产值表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimoutputs/{pimoutput_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimoutput_id") String pimoutput_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimoutputService.remove(pimoutput_id));
    }

    @PreAuthorize("hasPermission(this.pimoutputService.getPimoutputByIds(#ids),'ehr-PimOutput-Remove')")
    @ApiOperation(value = "批量删除产值表", tags = {"产值表" },  notes = "批量删除产值表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimoutputService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimoutputMapping.toDomain(#pimoutputdto),'ehr-PimOutput-Save')")
    @ApiOperation(value = "保存产值表", tags = {"产值表" },  notes = "保存产值表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimOutputDTO pimoutputdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimoutputService.save(pimoutputMapping.toDomain(pimoutputdto)));
    }

    @PreAuthorize("hasPermission(this.pimoutputMapping.toDomain(#pimoutputdtos),'ehr-PimOutput-Save')")
    @ApiOperation(value = "批量保存产值表", tags = {"产值表" },  notes = "批量保存产值表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimOutputDTO> pimoutputdtos) {
        pimoutputService.saveBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-CurOrg-all')")
	@ApiOperation(value = "获取当前组织范围", tags = {"产值表" } ,notes = "获取当前组织范围")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchcurorg")
	public ResponseEntity<List<PimOutputDTO>> fetchCurOrg(PimOutputSearchContext context) {
        Page<PimOutput> domains = pimoutputService.searchCurOrg(context) ;
        List<PimOutputDTO> list = pimoutputMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-CurOrg-all')")
	@ApiOperation(value = "查询当前组织范围", tags = {"产值表" } ,notes = "查询当前组织范围")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchcurorg")
	public ResponseEntity<Page<PimOutputDTO>> searchCurOrg(@RequestBody PimOutputSearchContext context) {
        Page<PimOutput> domains = pimoutputService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimoutputMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"产值表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchdefault")
	public ResponseEntity<List<PimOutputDTO>> fetchDefault(PimOutputSearchContext context) {
        Page<PimOutput> domains = pimoutputService.searchDefault(context) ;
        List<PimOutputDTO> list = pimoutputMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"产值表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchdefault")
	public ResponseEntity<Page<PimOutputDTO>> searchDefault(@RequestBody PimOutputSearchContext context) {
        Page<PimOutput> domains = pimoutputService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimoutputMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-REP_OUTPUT-all')")
	@ApiOperation(value = "获取人均产值", tags = {"产值表" } ,notes = "获取人均产值")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchrep_output")
	public ResponseEntity<List<HashMap>> fetchREP_OUTPUT(PimOutputSearchContext context) {
        Page<HashMap> domains = pimoutputService.searchREP_OUTPUT(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimOutput-REP_OUTPUT-all')")
	@ApiOperation(value = "查询人均产值", tags = {"产值表" } ,notes = "查询人均产值")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchrep_output")
	public ResponseEntity<Page<HashMap>> searchREP_OUTPUT(@RequestBody PimOutputSearchContext context) {
        Page<HashMap> domains = pimoutputService.searchREP_OUTPUT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
}

