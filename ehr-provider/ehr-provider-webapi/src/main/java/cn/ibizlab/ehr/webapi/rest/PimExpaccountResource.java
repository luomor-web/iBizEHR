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
import cn.ibizlab.ehr.core.pim.domain.PimExpaccount;
import cn.ibizlab.ehr.core.pim.service.IPimExpaccountService;
import cn.ibizlab.ehr.core.pim.filter.PimExpaccountSearchContext;

@Slf4j
@Api(tags = {"费用台账" })
@RestController("WebApi-pimexpaccount")
@RequestMapping("")
public class PimExpaccountResource {

    @Autowired
    public IPimExpaccountService pimexpaccountService;

    @Autowired
    @Lazy
    public PimExpaccountMapping pimexpaccountMapping;

    @PreAuthorize("hasPermission(this.pimexpaccountService.get(#pimexpaccount_id),'ehr-PimExpaccount-Remove')")
    @ApiOperation(value = "删除费用台账", tags = {"费用台账" },  notes = "删除费用台账")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexpaccounts/{pimexpaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexpaccount_id") String pimexpaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.remove(pimexpaccount_id));
    }

    @PreAuthorize("hasPermission(this.pimexpaccountService.getPimexpaccountByIds(#ids),'ehr-PimExpaccount-Remove')")
    @ApiOperation(value = "批量删除费用台账", tags = {"费用台账" },  notes = "批量删除费用台账")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexpaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimexpaccountMapping.toDomain(returnObject.body),'ehr-PimExpaccount-Get')")
    @ApiOperation(value = "获取费用台账", tags = {"费用台账" },  notes = "获取费用台账")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexpaccounts/{pimexpaccount_id}")
    public ResponseEntity<PimExpaccountDTO> get(@PathVariable("pimexpaccount_id") String pimexpaccount_id) {
        PimExpaccount domain = pimexpaccountService.get(pimexpaccount_id);
        PimExpaccountDTO dto = pimexpaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexpaccountMapping.toDomain(#pimexpaccountdto),'ehr-PimExpaccount-Save')")
    @ApiOperation(value = "保存费用台账", tags = {"费用台账" },  notes = "保存费用台账")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody PimExpaccountDTO pimexpaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.save(pimexpaccountMapping.toDomain(pimexpaccountdto)));
    }

    @PreAuthorize("hasPermission(this.pimexpaccountMapping.toDomain(#pimexpaccountdtos),'ehr-PimExpaccount-Save')")
    @ApiOperation(value = "批量保存费用台账", tags = {"费用台账" },  notes = "批量保存费用台账")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimExpaccountDTO> pimexpaccountdtos) {
        pimexpaccountService.saveBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexpaccountService.get(#pimexpaccount_id),'ehr-PimExpaccount-Update')")
    @ApiOperation(value = "更新费用台账", tags = {"费用台账" },  notes = "更新费用台账")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexpaccounts/{pimexpaccount_id}")
    @Transactional
    public ResponseEntity<PimExpaccountDTO> update(@PathVariable("pimexpaccount_id") String pimexpaccount_id, @RequestBody PimExpaccountDTO pimexpaccountdto) {
		PimExpaccount domain  = pimexpaccountMapping.toDomain(pimexpaccountdto);
        domain .setPimexpaccountid(pimexpaccount_id);
		pimexpaccountService.update(domain );
		PimExpaccountDTO dto = pimexpaccountMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexpaccountService.getPimexpaccountByEntities(this.pimexpaccountMapping.toDomain(#pimexpaccountdtos)),'ehr-PimExpaccount-Update')")
    @ApiOperation(value = "批量更新费用台账", tags = {"费用台账" },  notes = "批量更新费用台账")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimExpaccountDTO> pimexpaccountdtos) {
        pimexpaccountService.updateBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取费用台账草稿", tags = {"费用台账" },  notes = "获取费用台账草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexpaccounts/getdraft")
    public ResponseEntity<PimExpaccountDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountMapping.toDto(pimexpaccountService.getDraft(new PimExpaccount())));
    }

    @ApiOperation(value = "检查费用台账", tags = {"费用台账" },  notes = "检查费用台账")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimExpaccountDTO pimexpaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.checkKey(pimexpaccountMapping.toDomain(pimexpaccountdto)));
    }

    @PreAuthorize("hasPermission(this.pimexpaccountMapping.toDomain(#pimexpaccountdto),'ehr-PimExpaccount-Create')")
    @ApiOperation(value = "新建费用台账", tags = {"费用台账" },  notes = "新建费用台账")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts")
    @Transactional
    public ResponseEntity<PimExpaccountDTO> create(@RequestBody PimExpaccountDTO pimexpaccountdto) {
        PimExpaccount domain = pimexpaccountMapping.toDomain(pimexpaccountdto);
		pimexpaccountService.create(domain);
        PimExpaccountDTO dto = pimexpaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexpaccountMapping.toDomain(#pimexpaccountdtos),'ehr-PimExpaccount-Create')")
    @ApiOperation(value = "批量新建费用台账", tags = {"费用台账" },  notes = "批量新建费用台账")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimExpaccountDTO> pimexpaccountdtos) {
        pimexpaccountService.createBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExpaccount-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"费用台账" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexpaccounts/fetchdefault")
	public ResponseEntity<List<PimExpaccountDTO>> fetchDefault(PimExpaccountSearchContext context) {
        Page<PimExpaccount> domains = pimexpaccountService.searchDefault(context) ;
        List<PimExpaccountDTO> list = pimexpaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExpaccount-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"费用台账" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexpaccounts/searchdefault")
	public ResponseEntity<Page<PimExpaccountDTO>> searchDefault(@RequestBody PimExpaccountSearchContext context) {
        Page<PimExpaccount> domains = pimexpaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexpaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

