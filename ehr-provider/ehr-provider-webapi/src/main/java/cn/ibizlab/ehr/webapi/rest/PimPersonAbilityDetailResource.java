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
import cn.ibizlab.ehr.core.pim.domain.PimPersonAbilityDetail;
import cn.ibizlab.ehr.core.pim.service.IPimPersonAbilityDetailService;
import cn.ibizlab.ehr.core.pim.filter.PimPersonAbilityDetailSearchContext;

@Slf4j
@Api(tags = {"员工能力明细" })
@RestController("WebApi-pimpersonabilitydetail")
@RequestMapping("")
public class PimPersonAbilityDetailResource {

    @Autowired
    public IPimPersonAbilityDetailService pimpersonabilitydetailService;

    @Autowired
    @Lazy
    public PimPersonAbilityDetailMapping pimpersonabilitydetailMapping;

    @ApiOperation(value = "检查员工能力明细", tags = {"员工能力明细" },  notes = "检查员工能力明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.checkKey(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildto),'ehr-PimPersonAbilityDetail-Create')")
    @ApiOperation(value = "新建员工能力明细", tags = {"员工能力明细" },  notes = "新建员工能力明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails")
    @Transactional
    public ResponseEntity<PimPersonAbilityDetailDTO> create(@RequestBody PimPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        PimPersonAbilityDetail domain = pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto);
		pimpersonabilitydetailService.create(domain);
        PimPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos),'ehr-PimPersonAbilityDetail-Create')")
    @ApiOperation(value = "批量新建员工能力明细", tags = {"员工能力明细" },  notes = "批量新建员工能力明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.createBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildto),'ehr-PimPersonAbilityDetail-Save')")
    @ApiOperation(value = "保存员工能力明细", tags = {"员工能力明细" },  notes = "保存员工能力明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.save(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos),'ehr-PimPersonAbilityDetail-Save')")
    @ApiOperation(value = "批量保存员工能力明细", tags = {"员工能力明细" },  notes = "批量保存员工能力明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.saveBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.get(#pimpersonabilitydetail_id),'ehr-PimPersonAbilityDetail-Update')")
    @ApiOperation(value = "更新员工能力明细", tags = {"员工能力明细" },  notes = "更新员工能力明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    @Transactional
    public ResponseEntity<PimPersonAbilityDetailDTO> update(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id, @RequestBody PimPersonAbilityDetailDTO pimpersonabilitydetaildto) {
		PimPersonAbilityDetail domain  = pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto);
        domain .setPimpersonabilitydetailid(pimpersonabilitydetail_id);
		pimpersonabilitydetailService.update(domain );
		PimPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.getPimpersonabilitydetailByEntities(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos)),'ehr-PimPersonAbilityDetail-Update')")
    @ApiOperation(value = "批量更新员工能力明细", tags = {"员工能力明细" },  notes = "批量更新员工能力明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.updateBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(returnObject.body),'ehr-PimPersonAbilityDetail-Get')")
    @ApiOperation(value = "获取员工能力明细", tags = {"员工能力明细" },  notes = "获取员工能力明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    public ResponseEntity<PimPersonAbilityDetailDTO> get(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id) {
        PimPersonAbilityDetail domain = pimpersonabilitydetailService.get(pimpersonabilitydetail_id);
        PimPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取员工能力明细草稿", tags = {"员工能力明细" },  notes = "获取员工能力明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilitydetails/getdraft")
    public ResponseEntity<PimPersonAbilityDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailMapping.toDto(pimpersonabilitydetailService.getDraft(new PimPersonAbilityDetail())));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.get(#pimpersonabilitydetail_id),'ehr-PimPersonAbilityDetail-Remove')")
    @ApiOperation(value = "删除员工能力明细", tags = {"员工能力明细" },  notes = "删除员工能力明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.remove(pimpersonabilitydetail_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.getPimpersonabilitydetailByIds(#ids),'ehr-PimPersonAbilityDetail-Remove')")
    @ApiOperation(value = "批量删除员工能力明细", tags = {"员工能力明细" },  notes = "批量删除员工能力明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonabilitydetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbilityDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工能力明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonabilitydetails/fetchdefault")
	public ResponseEntity<List<PimPersonAbilityDetailDTO>> fetchDefault(PimPersonAbilityDetailSearchContext context) {
        Page<PimPersonAbilityDetail> domains = pimpersonabilitydetailService.searchDefault(context) ;
        List<PimPersonAbilityDetailDTO> list = pimpersonabilitydetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbilityDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工能力明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonabilitydetails/searchdefault")
	public ResponseEntity<Page<PimPersonAbilityDetailDTO>> searchDefault(@RequestBody PimPersonAbilityDetailSearchContext context) {
        Page<PimPersonAbilityDetail> domains = pimpersonabilitydetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilitydetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

