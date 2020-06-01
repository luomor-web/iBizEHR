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
import cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail;
import cn.ibizlab.ehr.core.sal.service.ISalSalaryDetailService;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryDetailSearchContext;

@Slf4j
@Api(tags = {"员工薪酬明细" })
@RestController("WebApi-salsalarydetail")
@RequestMapping("")
public class SalSalaryDetailResource {

    @Autowired
    public ISalSalaryDetailService salsalarydetailService;

    @Autowired
    @Lazy
    public SalSalaryDetailMapping salsalarydetailMapping;

    @PreAuthorize("hasPermission(this.salsalarydetailService.get(#salsalarydetail_id),'ehr-SalSalaryDetail-Update')")
    @ApiOperation(value = "更新员工薪酬明细", tags = {"员工薪酬明细" },  notes = "更新员工薪酬明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<SalSalaryDetailDTO> update(@PathVariable("salsalarydetail_id") String salsalarydetail_id, @RequestBody SalSalaryDetailDTO salsalarydetaildto) {
		SalSalaryDetail domain  = salsalarydetailMapping.toDomain(salsalarydetaildto);
        domain .setSalsalarydetailid(salsalarydetail_id);
		salsalarydetailService.update(domain );
		SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.getSalsalarydetailByEntities(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos)),'ehr-SalSalaryDetail-Update')")
    @ApiOperation(value = "批量更新员工薪酬明细", tags = {"员工薪酬明细" },  notes = "批量更新员工薪酬明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.updateBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildto),'ehr-SalSalaryDetail-Create')")
    @ApiOperation(value = "新建员工薪酬明细", tags = {"员工薪酬明细" },  notes = "新建员工薪酬明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails")
    @Transactional
    public ResponseEntity<SalSalaryDetailDTO> create(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        SalSalaryDetail domain = salsalarydetailMapping.toDomain(salsalarydetaildto);
		salsalarydetailService.create(domain);
        SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos),'ehr-SalSalaryDetail-Create')")
    @ApiOperation(value = "批量新建员工薪酬明细", tags = {"员工薪酬明细" },  notes = "批量新建员工薪酬明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.createBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取员工薪酬明细草稿", tags = {"员工薪酬明细" },  notes = "获取员工薪酬明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/getdraft")
    public ResponseEntity<SalSalaryDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailMapping.toDto(salsalarydetailService.getDraft(new SalSalaryDetail())));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.get(#salsalarydetail_id),'ehr-SalSalaryDetail-Remove')")
    @ApiOperation(value = "删除员工薪酬明细", tags = {"员工薪酬明细" },  notes = "删除员工薪酬明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.remove(salsalarydetail_id));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.getSalsalarydetailByIds(#ids),'ehr-SalSalaryDetail-Remove')")
    @ApiOperation(value = "批量删除员工薪酬明细", tags = {"员工薪酬明细" },  notes = "批量删除员工薪酬明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalarydetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(returnObject.body),'ehr-SalSalaryDetail-Get')")
    @ApiOperation(value = "获取员工薪酬明细", tags = {"员工薪酬明细" },  notes = "获取员工薪酬明细")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/{salsalarydetail_id}")
    public ResponseEntity<SalSalaryDetailDTO> get(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
        SalSalaryDetail domain = salsalarydetailService.get(salsalarydetail_id);
        SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查员工薪酬明细", tags = {"员工薪酬明细" },  notes = "检查员工薪酬明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.checkKey(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildto),'ehr-SalSalaryDetail-Save')")
    @ApiOperation(value = "保存员工薪酬明细", tags = {"员工薪酬明细" },  notes = "保存员工薪酬明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.save(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos),'ehr-SalSalaryDetail-Save')")
    @ApiOperation(value = "批量保存员工薪酬明细", tags = {"员工薪酬明细" },  notes = "批量保存员工薪酬明细")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.saveBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工薪酬明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarydetails/fetchdefault")
	public ResponseEntity<List<SalSalaryDetailDTO>> fetchDefault(SalSalaryDetailSearchContext context) {
        Page<SalSalaryDetail> domains = salsalarydetailService.searchDefault(context) ;
        List<SalSalaryDetailDTO> list = salsalarydetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工薪酬明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalarydetails/searchdefault")
	public ResponseEntity<Page<SalSalaryDetailDTO>> searchDefault(@RequestBody SalSalaryDetailSearchContext context) {
        Page<SalSalaryDetail> domains = salsalarydetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalarydetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

