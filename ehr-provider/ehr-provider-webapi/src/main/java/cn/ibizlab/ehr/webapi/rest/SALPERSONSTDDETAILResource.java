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
import cn.ibizlab.ehr.core.sal.domain.SALPERSONSTDDETAIL;
import cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDDETAILService;
import cn.ibizlab.ehr.core.sal.filter.SALPERSONSTDDETAILSearchContext;

@Slf4j
@Api(tags = {"员工薪酬标准明细" })
@RestController("WebApi-salpersonstddetail")
@RequestMapping("")
public class SALPERSONSTDDETAILResource {

    @Autowired
    public ISALPERSONSTDDETAILService salpersonstddetailService;

    @Autowired
    @Lazy
    public SALPERSONSTDDETAILMapping salpersonstddetailMapping;

    @PreAuthorize("hasPermission(this.salpersonstddetailMapping.toDomain(#salpersonstddetaildto),'ehr-SALPERSONSTDDETAIL-Save')")
    @ApiOperation(value = "保存员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "保存员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstddetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SALPERSONSTDDETAILDTO salpersonstddetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstddetailService.save(salpersonstddetailMapping.toDomain(salpersonstddetaildto)));
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailMapping.toDomain(#salpersonstddetaildtos),'ehr-SALPERSONSTDDETAIL-Save')")
    @ApiOperation(value = "批量保存员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "批量保存员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstddetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALPERSONSTDDETAILDTO> salpersonstddetaildtos) {
        salpersonstddetailService.saveBatch(salpersonstddetailMapping.toDomain(salpersonstddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "检查员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstddetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALPERSONSTDDETAILDTO salpersonstddetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salpersonstddetailService.checkKey(salpersonstddetailMapping.toDomain(salpersonstddetaildto)));
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailMapping.toDomain(#salpersonstddetaildto),'ehr-SALPERSONSTDDETAIL-Create')")
    @ApiOperation(value = "新建员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "新建员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstddetails")
    @Transactional
    public ResponseEntity<SALPERSONSTDDETAILDTO> create(@RequestBody SALPERSONSTDDETAILDTO salpersonstddetaildto) {
        SALPERSONSTDDETAIL domain = salpersonstddetailMapping.toDomain(salpersonstddetaildto);
		salpersonstddetailService.create(domain);
        SALPERSONSTDDETAILDTO dto = salpersonstddetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailMapping.toDomain(#salpersonstddetaildtos),'ehr-SALPERSONSTDDETAIL-Create')")
    @ApiOperation(value = "批量新建员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "批量新建员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstddetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALPERSONSTDDETAILDTO> salpersonstddetaildtos) {
        salpersonstddetailService.createBatch(salpersonstddetailMapping.toDomain(salpersonstddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailService.get(#salpersonstddetail_id),'ehr-SALPERSONSTDDETAIL-Remove')")
    @ApiOperation(value = "删除员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "删除员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstddetails/{salpersonstddetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salpersonstddetail_id") String salpersonstddetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salpersonstddetailService.remove(salpersonstddetail_id));
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailService.getSalpersonstddetailByIds(#ids),'ehr-SALPERSONSTDDETAIL-Remove')")
    @ApiOperation(value = "批量删除员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "批量删除员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstddetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salpersonstddetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salpersonstddetailMapping.toDomain(returnObject.body),'ehr-SALPERSONSTDDETAIL-Get')")
    @ApiOperation(value = "获取员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "获取员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstddetails/{salpersonstddetail_id}")
    public ResponseEntity<SALPERSONSTDDETAILDTO> get(@PathVariable("salpersonstddetail_id") String salpersonstddetail_id) {
        SALPERSONSTDDETAIL domain = salpersonstddetailService.get(salpersonstddetail_id);
        SALPERSONSTDDETAILDTO dto = salpersonstddetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取员工薪酬标准明细草稿", tags = {"员工薪酬标准明细" },  notes = "获取员工薪酬标准明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstddetails/getdraft")
    public ResponseEntity<SALPERSONSTDDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstddetailMapping.toDto(salpersonstddetailService.getDraft(new SALPERSONSTDDETAIL())));
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailService.get(#salpersonstddetail_id),'ehr-SALPERSONSTDDETAIL-Update')")
    @ApiOperation(value = "更新员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "更新员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstddetails/{salpersonstddetail_id}")
    @Transactional
    public ResponseEntity<SALPERSONSTDDETAILDTO> update(@PathVariable("salpersonstddetail_id") String salpersonstddetail_id, @RequestBody SALPERSONSTDDETAILDTO salpersonstddetaildto) {
		SALPERSONSTDDETAIL domain  = salpersonstddetailMapping.toDomain(salpersonstddetaildto);
        domain .setSalpersonstddetailid(salpersonstddetail_id);
		salpersonstddetailService.update(domain );
		SALPERSONSTDDETAILDTO dto = salpersonstddetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salpersonstddetailService.getSalpersonstddetailByEntities(this.salpersonstddetailMapping.toDomain(#salpersonstddetaildtos)),'ehr-SALPERSONSTDDETAIL-Update')")
    @ApiOperation(value = "批量更新员工薪酬标准明细", tags = {"员工薪酬标准明细" },  notes = "批量更新员工薪酬标准明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstddetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALPERSONSTDDETAILDTO> salpersonstddetaildtos) {
        salpersonstddetailService.updateBatch(salpersonstddetailMapping.toDomain(salpersonstddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALPERSONSTDDETAIL-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工薪酬标准明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salpersonstddetails/fetchdefault")
	public ResponseEntity<List<SALPERSONSTDDETAILDTO>> fetchDefault(SALPERSONSTDDETAILSearchContext context) {
        Page<SALPERSONSTDDETAIL> domains = salpersonstddetailService.searchDefault(context) ;
        List<SALPERSONSTDDETAILDTO> list = salpersonstddetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALPERSONSTDDETAIL-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工薪酬标准明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salpersonstddetails/searchdefault")
	public ResponseEntity<Page<SALPERSONSTDDETAILDTO>> searchDefault(@RequestBody SALPERSONSTDDETAILSearchContext context) {
        Page<SALPERSONSTDDETAIL> domains = salpersonstddetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salpersonstddetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

