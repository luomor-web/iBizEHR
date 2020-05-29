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
import cn.ibizlab.ehr.core.trm.domain.TrmInvoice;
import cn.ibizlab.ehr.core.trm.service.ITrmInvoiceService;
import cn.ibizlab.ehr.core.trm.filter.TrmInvoiceSearchContext;

@Slf4j
@Api(tags = {"开票信息" })
@RestController("WebApi-trminvoice")
@RequestMapping("")
public class TrmInvoiceResource {

    @Autowired
    public ITrmInvoiceService trminvoiceService;

    @Autowired
    @Lazy
    public TrmInvoiceMapping trminvoiceMapping;

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedto),'ehr-TrmInvoice-Create')")
    @ApiOperation(value = "新建开票信息", tags = {"开票信息" },  notes = "新建开票信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices")
    @Transactional
    public ResponseEntity<TrmInvoiceDTO> create(@RequestBody TrmInvoiceDTO trminvoicedto) {
        TrmInvoice domain = trminvoiceMapping.toDomain(trminvoicedto);
		trminvoiceService.create(domain);
        TrmInvoiceDTO dto = trminvoiceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedtos),'ehr-TrmInvoice-Create')")
    @ApiOperation(value = "批量新建开票信息", tags = {"开票信息" },  notes = "批量新建开票信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmInvoiceDTO> trminvoicedtos) {
        trminvoiceService.createBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedto),'ehr-TrmInvoice-Save')")
    @ApiOperation(value = "保存开票信息", tags = {"开票信息" },  notes = "保存开票信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmInvoiceDTO trminvoicedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.save(trminvoiceMapping.toDomain(trminvoicedto)));
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedtos),'ehr-TrmInvoice-Save')")
    @ApiOperation(value = "批量保存开票信息", tags = {"开票信息" },  notes = "批量保存开票信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmInvoiceDTO> trminvoicedtos) {
        trminvoiceService.saveBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取开票信息草稿", tags = {"开票信息" },  notes = "获取开票信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trminvoices/getdraft")
    public ResponseEntity<TrmInvoiceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trminvoiceMapping.toDto(trminvoiceService.getDraft(new TrmInvoice())));
    }

    @ApiOperation(value = "检查开票信息", tags = {"开票信息" },  notes = "检查开票信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmInvoiceDTO trminvoicedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.checkKey(trminvoiceMapping.toDomain(trminvoicedto)));
    }

    @PostAuthorize("hasPermission(this.trminvoiceMapping.toDomain(returnObject.body),'ehr-TrmInvoice-Get')")
    @ApiOperation(value = "获取开票信息", tags = {"开票信息" },  notes = "获取开票信息")
	@RequestMapping(method = RequestMethod.GET, value = "/trminvoices/{trminvoice_id}")
    public ResponseEntity<TrmInvoiceDTO> get(@PathVariable("trminvoice_id") String trminvoice_id) {
        TrmInvoice domain = trminvoiceService.get(trminvoice_id);
        TrmInvoiceDTO dto = trminvoiceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.get(#trminvoice_id),'ehr-TrmInvoice-Remove')")
    @ApiOperation(value = "删除开票信息", tags = {"开票信息" },  notes = "删除开票信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trminvoices/{trminvoice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trminvoice_id") String trminvoice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.remove(trminvoice_id));
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.getTrminvoiceByIds(#ids),'ehr-TrmInvoice-Remove')")
    @ApiOperation(value = "批量删除开票信息", tags = {"开票信息" },  notes = "批量删除开票信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trminvoiceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.get(#trminvoice_id),'ehr-TrmInvoice-Update')")
    @ApiOperation(value = "更新开票信息", tags = {"开票信息" },  notes = "更新开票信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/trminvoices/{trminvoice_id}")
    @Transactional
    public ResponseEntity<TrmInvoiceDTO> update(@PathVariable("trminvoice_id") String trminvoice_id, @RequestBody TrmInvoiceDTO trminvoicedto) {
		TrmInvoice domain  = trminvoiceMapping.toDomain(trminvoicedto);
        domain .setTrminvoiceid(trminvoice_id);
		trminvoiceService.update(domain );
		TrmInvoiceDTO dto = trminvoiceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.getTrminvoiceByEntities(this.trminvoiceMapping.toDomain(#trminvoicedtos)),'ehr-TrmInvoice-Update')")
    @ApiOperation(value = "批量更新开票信息", tags = {"开票信息" },  notes = "批量更新开票信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmInvoiceDTO> trminvoicedtos) {
        trminvoiceService.updateBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmInvoice-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"开票信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trminvoices/fetchdefault")
	public ResponseEntity<List<TrmInvoiceDTO>> fetchDefault(TrmInvoiceSearchContext context) {
        Page<TrmInvoice> domains = trminvoiceService.searchDefault(context) ;
        List<TrmInvoiceDTO> list = trminvoiceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmInvoice-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"开票信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trminvoices/searchdefault")
	public ResponseEntity<Page<TrmInvoiceDTO>> searchDefault(@RequestBody TrmInvoiceSearchContext context) {
        Page<TrmInvoice> domains = trminvoiceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trminvoiceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

