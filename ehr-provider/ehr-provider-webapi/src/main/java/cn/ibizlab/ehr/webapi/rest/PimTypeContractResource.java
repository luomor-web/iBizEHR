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
import cn.ibizlab.ehr.core.pim.domain.PimTypeContract;
import cn.ibizlab.ehr.core.pim.service.IPimTypeContractService;
import cn.ibizlab.ehr.core.pim.filter.PimTypeContractSearchContext;

@Slf4j
@Api(tags = {"PimTypeContract" })
@RestController("WebApi-pimtypecontract")
@RequestMapping("")
public class PimTypeContractResource {

    @Autowired
    public IPimTypeContractService pimtypecontractService;

    @Autowired
    @Lazy
    public PimTypeContractMapping pimtypecontractMapping;

    @PreAuthorize("hasPermission(this.pimtypecontractService.get(#pimtypecontract_id),'ehr-PimTypeContract-Update')")
    @ApiOperation(value = "Update", tags = {"PimTypeContract" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtypecontracts/{pimtypecontract_id}")
    @Transactional
    public ResponseEntity<PimTypeContractDTO> update(@PathVariable("pimtypecontract_id") String pimtypecontract_id, @RequestBody PimTypeContractDTO pimtypecontractdto) {
		PimTypeContract domain  = pimtypecontractMapping.toDomain(pimtypecontractdto);
        domain .setPimtypecontractid(pimtypecontract_id);
		pimtypecontractService.update(domain );
		PimTypeContractDTO dto = pimtypecontractMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtypecontractService.getPimtypecontractByEntities(this.pimtypecontractMapping.toDomain(#pimtypecontractdtos)),'ehr-PimTypeContract-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimTypeContract" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimTypeContractDTO> pimtypecontractdtos) {
        pimtypecontractService.updateBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimTypeContract" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimTypeContractDTO pimtypecontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.checkKey(pimtypecontractMapping.toDomain(pimtypecontractdto)));
    }

    @PostAuthorize("hasPermission(this.pimtypecontractMapping.toDomain(returnObject.body),'ehr-PimTypeContract-Get')")
    @ApiOperation(value = "Get", tags = {"PimTypeContract" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtypecontracts/{pimtypecontract_id}")
    public ResponseEntity<PimTypeContractDTO> get(@PathVariable("pimtypecontract_id") String pimtypecontract_id) {
        PimTypeContract domain = pimtypecontractService.get(pimtypecontract_id);
        PimTypeContractDTO dto = pimtypecontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtypecontractService.get(#pimtypecontract_id),'ehr-PimTypeContract-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimTypeContract" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtypecontracts/{pimtypecontract_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtypecontract_id") String pimtypecontract_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.remove(pimtypecontract_id));
    }

    @PreAuthorize("hasPermission(this.pimtypecontractService.getPimtypecontractByIds(#ids),'ehr-PimTypeContract-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimTypeContract" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtypecontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtypecontractMapping.toDomain(#pimtypecontractdto),'ehr-PimTypeContract-Create')")
    @ApiOperation(value = "Create", tags = {"PimTypeContract" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts")
    @Transactional
    public ResponseEntity<PimTypeContractDTO> create(@RequestBody PimTypeContractDTO pimtypecontractdto) {
        PimTypeContract domain = pimtypecontractMapping.toDomain(pimtypecontractdto);
		pimtypecontractService.create(domain);
        PimTypeContractDTO dto = pimtypecontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtypecontractMapping.toDomain(#pimtypecontractdtos),'ehr-PimTypeContract-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimTypeContract" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimTypeContractDTO> pimtypecontractdtos) {
        pimtypecontractService.createBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtypecontractMapping.toDomain(#pimtypecontractdto),'ehr-PimTypeContract-Save')")
    @ApiOperation(value = "Save", tags = {"PimTypeContract" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/save")
    public ResponseEntity<Boolean> save(@RequestBody PimTypeContractDTO pimtypecontractdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.save(pimtypecontractMapping.toDomain(pimtypecontractdto)));
    }

    @PreAuthorize("hasPermission(this.pimtypecontractMapping.toDomain(#pimtypecontractdtos),'ehr-PimTypeContract-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimTypeContract" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimTypeContractDTO> pimtypecontractdtos) {
        pimtypecontractService.saveBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimTypeContract" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtypecontracts/getdraft")
    public ResponseEntity<PimTypeContractDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractMapping.toDto(pimtypecontractService.getDraft(new PimTypeContract())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTypeContract-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimTypeContract" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimtypecontracts/fetchdefault")
	public ResponseEntity<List<PimTypeContractDTO>> fetchDefault(PimTypeContractSearchContext context) {
        Page<PimTypeContract> domains = pimtypecontractService.searchDefault(context) ;
        List<PimTypeContractDTO> list = pimtypecontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTypeContract-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimTypeContract" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimtypecontracts/searchdefault")
	public ResponseEntity<Page<PimTypeContractDTO>> searchDefault(@RequestBody PimTypeContractSearchContext context) {
        Page<PimTypeContract> domains = pimtypecontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtypecontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

