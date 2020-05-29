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
import cn.ibizlab.ehr.core.sal.domain.SalSalaryBill;
import cn.ibizlab.ehr.core.sal.service.ISalSalaryBillService;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryBillSearchContext;

@Slf4j
@Api(tags = {"SalSalaryBill" })
@RestController("WebApi-salsalarybill")
@RequestMapping("")
public class SalSalaryBillResource {

    @Autowired
    public ISalSalaryBillService salsalarybillService;

    @Autowired
    @Lazy
    public SalSalaryBillMapping salsalarybillMapping;

    @PreAuthorize("hasPermission(this.salsalarybillService.get(#salsalarybill_id),'ehr-SalSalaryBill-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalSalaryBill" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarybills/{salsalarybill_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalarybill_id") String salsalarybill_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.remove(salsalarybill_id));
    }

    @PreAuthorize("hasPermission(this.salsalarybillService.getSalsalarybillByIds(#ids),'ehr-SalSalaryBill-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalSalaryBill" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalarybillService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalSalaryBill" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSalaryBillDTO salsalarybilldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.checkKey(salsalarybillMapping.toDomain(salsalarybilldto)));
    }

    @PreAuthorize("hasPermission(this.salsalarybillMapping.toDomain(#salsalarybilldto),'ehr-SalSalaryBill-Create')")
    @ApiOperation(value = "Create", tags = {"SalSalaryBill" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills")
    @Transactional
    public ResponseEntity<SalSalaryBillDTO> create(@RequestBody SalSalaryBillDTO salsalarybilldto) {
        SalSalaryBill domain = salsalarybillMapping.toDomain(salsalarybilldto);
		salsalarybillService.create(domain);
        SalSalaryBillDTO dto = salsalarybillMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarybillMapping.toDomain(#salsalarybilldtos),'ehr-SalSalaryBill-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalSalaryBill" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSalaryBillDTO> salsalarybilldtos) {
        salsalarybillService.createBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalSalaryBill" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarybills/getdraft")
    public ResponseEntity<SalSalaryBillDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarybillMapping.toDto(salsalarybillService.getDraft(new SalSalaryBill())));
    }

    @PreAuthorize("hasPermission(this.salsalarybillService.get(#salsalarybill_id),'ehr-SalSalaryBill-Update')")
    @ApiOperation(value = "Update", tags = {"SalSalaryBill" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarybills/{salsalarybill_id}")
    @Transactional
    public ResponseEntity<SalSalaryBillDTO> update(@PathVariable("salsalarybill_id") String salsalarybill_id, @RequestBody SalSalaryBillDTO salsalarybilldto) {
		SalSalaryBill domain  = salsalarybillMapping.toDomain(salsalarybilldto);
        domain .setSalsalarybillid(salsalarybill_id);
		salsalarybillService.update(domain );
		SalSalaryBillDTO dto = salsalarybillMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarybillService.getSalsalarybillByEntities(this.salsalarybillMapping.toDomain(#salsalarybilldtos)),'ehr-SalSalaryBill-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalSalaryBill" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSalaryBillDTO> salsalarybilldtos) {
        salsalarybillService.updateBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salsalarybillMapping.toDomain(returnObject.body),'ehr-SalSalaryBill-Get')")
    @ApiOperation(value = "Get", tags = {"SalSalaryBill" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarybills/{salsalarybill_id}")
    public ResponseEntity<SalSalaryBillDTO> get(@PathVariable("salsalarybill_id") String salsalarybill_id) {
        SalSalaryBill domain = salsalarybillService.get(salsalarybill_id);
        SalSalaryBillDTO dto = salsalarybillMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarybillMapping.toDomain(#salsalarybilldto),'ehr-SalSalaryBill-Save')")
    @ApiOperation(value = "Save", tags = {"SalSalaryBill" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSalaryBillDTO salsalarybilldto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.save(salsalarybillMapping.toDomain(salsalarybilldto)));
    }

    @PreAuthorize("hasPermission(this.salsalarybillMapping.toDomain(#salsalarybilldtos),'ehr-SalSalaryBill-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalSalaryBill" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSalaryBillDTO> salsalarybilldtos) {
        salsalarybillService.saveBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryBill-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalSalaryBill" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarybills/fetchdefault")
	public ResponseEntity<List<SalSalaryBillDTO>> fetchDefault(SalSalaryBillSearchContext context) {
        Page<SalSalaryBill> domains = salsalarybillService.searchDefault(context) ;
        List<SalSalaryBillDTO> list = salsalarybillMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryBill-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalSalaryBill" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalarybills/searchdefault")
	public ResponseEntity<Page<SalSalaryBillDTO>> searchDefault(@RequestBody SalSalaryBillSearchContext context) {
        Page<SalSalaryBill> domains = salsalarybillService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalarybillMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

