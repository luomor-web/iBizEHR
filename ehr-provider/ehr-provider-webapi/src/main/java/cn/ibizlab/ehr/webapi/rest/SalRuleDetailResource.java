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
import cn.ibizlab.ehr.core.sal.domain.SalRuleDetail;
import cn.ibizlab.ehr.core.sal.service.ISalRuleDetailService;
import cn.ibizlab.ehr.core.sal.filter.SalRuleDetailSearchContext;

@Slf4j
@Api(tags = {"薪酬规则明细" })
@RestController("WebApi-salruledetail")
@RequestMapping("")
public class SalRuleDetailResource {

    @Autowired
    public ISalRuleDetailService salruledetailService;

    @Autowired
    @Lazy
    public SalRuleDetailMapping salruledetailMapping;

    @PostAuthorize("hasPermission(this.salruledetailMapping.toDomain(returnObject.body),'ehr-SalRuleDetail-Get')")
    @ApiOperation(value = "获取薪酬规则明细", tags = {"薪酬规则明细" },  notes = "获取薪酬规则明细")
	@RequestMapping(method = RequestMethod.GET, value = "/salruledetails/{salruledetail_id}")
    public ResponseEntity<SalRuleDetailDTO> get(@PathVariable("salruledetail_id") String salruledetail_id) {
        SalRuleDetail domain = salruledetailService.get(salruledetail_id);
        SalRuleDetailDTO dto = salruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查薪酬规则明细", tags = {"薪酬规则明细" },  notes = "检查薪酬规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalRuleDetailDTO salruledetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salruledetailService.checkKey(salruledetailMapping.toDomain(salruledetaildto)));
    }

    @PreAuthorize("hasPermission(this.salruledetailService.get(#salruledetail_id),'ehr-SalRuleDetail-Update')")
    @ApiOperation(value = "更新薪酬规则明细", tags = {"薪酬规则明细" },  notes = "更新薪酬规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salruledetails/{salruledetail_id}")
    @Transactional
    public ResponseEntity<SalRuleDetailDTO> update(@PathVariable("salruledetail_id") String salruledetail_id, @RequestBody SalRuleDetailDTO salruledetaildto) {
		SalRuleDetail domain  = salruledetailMapping.toDomain(salruledetaildto);
        domain .setSalruledetailid(salruledetail_id);
		salruledetailService.update(domain );
		SalRuleDetailDTO dto = salruledetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salruledetailService.getSalruledetailByEntities(this.salruledetailMapping.toDomain(#salruledetaildtos)),'ehr-SalRuleDetail-Update')")
    @ApiOperation(value = "批量更新薪酬规则明细", tags = {"薪酬规则明细" },  notes = "批量更新薪酬规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalRuleDetailDTO> salruledetaildtos) {
        salruledetailService.updateBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salruledetailMapping.toDomain(#salruledetaildto),'ehr-SalRuleDetail-Save')")
    @ApiOperation(value = "保存薪酬规则明细", tags = {"薪酬规则明细" },  notes = "保存薪酬规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SalRuleDetailDTO salruledetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salruledetailService.save(salruledetailMapping.toDomain(salruledetaildto)));
    }

    @PreAuthorize("hasPermission(this.salruledetailMapping.toDomain(#salruledetaildtos),'ehr-SalRuleDetail-Save')")
    @ApiOperation(value = "批量保存薪酬规则明细", tags = {"薪酬规则明细" },  notes = "批量保存薪酬规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalRuleDetailDTO> salruledetaildtos) {
        salruledetailService.saveBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salruledetailMapping.toDomain(#salruledetaildto),'ehr-SalRuleDetail-Create')")
    @ApiOperation(value = "新建薪酬规则明细", tags = {"薪酬规则明细" },  notes = "新建薪酬规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails")
    @Transactional
    public ResponseEntity<SalRuleDetailDTO> create(@RequestBody SalRuleDetailDTO salruledetaildto) {
        SalRuleDetail domain = salruledetailMapping.toDomain(salruledetaildto);
		salruledetailService.create(domain);
        SalRuleDetailDTO dto = salruledetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salruledetailMapping.toDomain(#salruledetaildtos),'ehr-SalRuleDetail-Create')")
    @ApiOperation(value = "批量新建薪酬规则明细", tags = {"薪酬规则明细" },  notes = "批量新建薪酬规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalRuleDetailDTO> salruledetaildtos) {
        salruledetailService.createBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salruledetailService.get(#salruledetail_id),'ehr-SalRuleDetail-Remove')")
    @ApiOperation(value = "删除薪酬规则明细", tags = {"薪酬规则明细" },  notes = "删除薪酬规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salruledetails/{salruledetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salruledetail_id") String salruledetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salruledetailService.remove(salruledetail_id));
    }

    @PreAuthorize("hasPermission(this.salruledetailService.getSalruledetailByIds(#ids),'ehr-SalRuleDetail-Remove')")
    @ApiOperation(value = "批量删除薪酬规则明细", tags = {"薪酬规则明细" },  notes = "批量删除薪酬规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salruledetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取薪酬规则明细草稿", tags = {"薪酬规则明细" },  notes = "获取薪酬规则明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salruledetails/getdraft")
    public ResponseEntity<SalRuleDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salruledetailMapping.toDto(salruledetailService.getDraft(new SalRuleDetail())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalRuleDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬规则明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salruledetails/fetchdefault")
	public ResponseEntity<List<SalRuleDetailDTO>> fetchDefault(SalRuleDetailSearchContext context) {
        Page<SalRuleDetail> domains = salruledetailService.searchDefault(context) ;
        List<SalRuleDetailDTO> list = salruledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalRuleDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬规则明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salruledetails/searchdefault")
	public ResponseEntity<Page<SalRuleDetailDTO>> searchDefault(@RequestBody SalRuleDetailSearchContext context) {
        Page<SalRuleDetail> domains = salruledetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salruledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

