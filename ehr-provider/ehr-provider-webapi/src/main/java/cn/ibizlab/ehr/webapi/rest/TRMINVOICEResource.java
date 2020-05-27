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
import cn.ibizlab.ehr.core.trm.domain.TRMINVOICE;
import cn.ibizlab.ehr.core.trm.service.ITRMINVOICEService;
import cn.ibizlab.ehr.core.trm.filter.TRMINVOICESearchContext;

@Slf4j
@Api(tags = {"TRMINVOICE" })
@RestController("WebApi-trminvoice")
@RequestMapping("")
public class TRMINVOICEResource {

    @Autowired
    public ITRMINVOICEService trminvoiceService;

    @Autowired
    @Lazy
    public TRMINVOICEMapping trminvoiceMapping;

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedto),'ehr-TRMINVOICE-Create')")
    @ApiOperation(value = "Create", tags = {"TRMINVOICE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices")
    @Transactional
    public ResponseEntity<TRMINVOICEDTO> create(@RequestBody TRMINVOICEDTO trminvoicedto) {
        TRMINVOICE domain = trminvoiceMapping.toDomain(trminvoicedto);
		trminvoiceService.create(domain);
        TRMINVOICEDTO dto = trminvoiceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedtos),'ehr-TRMINVOICE-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMINVOICE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMINVOICEDTO> trminvoicedtos) {
        trminvoiceService.createBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedto),'ehr-TRMINVOICE-Save')")
    @ApiOperation(value = "Save", tags = {"TRMINVOICE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMINVOICEDTO trminvoicedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.save(trminvoiceMapping.toDomain(trminvoicedto)));
    }

    @PreAuthorize("hasPermission(this.trminvoiceMapping.toDomain(#trminvoicedtos),'ehr-TRMINVOICE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMINVOICE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMINVOICEDTO> trminvoicedtos) {
        trminvoiceService.saveBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMINVOICE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trminvoices/getdraft")
    public ResponseEntity<TRMINVOICEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trminvoiceMapping.toDto(trminvoiceService.getDraft(new TRMINVOICE())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMINVOICE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trminvoices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMINVOICEDTO trminvoicedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.checkKey(trminvoiceMapping.toDomain(trminvoicedto)));
    }

    @PostAuthorize("hasPermission(this.trminvoiceMapping.toDomain(returnObject.body),'ehr-TRMINVOICE-Get')")
    @ApiOperation(value = "Get", tags = {"TRMINVOICE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trminvoices/{trminvoice_id}")
    public ResponseEntity<TRMINVOICEDTO> get(@PathVariable("trminvoice_id") String trminvoice_id) {
        TRMINVOICE domain = trminvoiceService.get(trminvoice_id);
        TRMINVOICEDTO dto = trminvoiceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.get(#trminvoice_id),'ehr-TRMINVOICE-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMINVOICE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trminvoices/{trminvoice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trminvoice_id") String trminvoice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trminvoiceService.remove(trminvoice_id));
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.getTrminvoiceByIds(#ids),'ehr-TRMINVOICE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMINVOICE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trminvoiceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.get(#trminvoice_id),'ehr-TRMINVOICE-Update')")
    @ApiOperation(value = "Update", tags = {"TRMINVOICE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trminvoices/{trminvoice_id}")
    @Transactional
    public ResponseEntity<TRMINVOICEDTO> update(@PathVariable("trminvoice_id") String trminvoice_id, @RequestBody TRMINVOICEDTO trminvoicedto) {
		TRMINVOICE domain  = trminvoiceMapping.toDomain(trminvoicedto);
        domain .setTrminvoiceid(trminvoice_id);
		trminvoiceService.update(domain );
		TRMINVOICEDTO dto = trminvoiceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trminvoiceService.getTrminvoiceByEntities(this.trminvoiceMapping.toDomain(#trminvoicedtos)),'ehr-TRMINVOICE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMINVOICE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trminvoices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMINVOICEDTO> trminvoicedtos) {
        trminvoiceService.updateBatch(trminvoiceMapping.toDomain(trminvoicedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMINVOICE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMINVOICE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trminvoices/fetchdefault")
	public ResponseEntity<List<TRMINVOICEDTO>> fetchDefault(TRMINVOICESearchContext context) {
        Page<TRMINVOICE> domains = trminvoiceService.searchDefault(context) ;
        List<TRMINVOICEDTO> list = trminvoiceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMINVOICE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMINVOICE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trminvoices/searchdefault")
	public ResponseEntity<Page<TRMINVOICEDTO>> searchDefault(@RequestBody TRMINVOICESearchContext context) {
        Page<TRMINVOICE> domains = trminvoiceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trminvoiceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

