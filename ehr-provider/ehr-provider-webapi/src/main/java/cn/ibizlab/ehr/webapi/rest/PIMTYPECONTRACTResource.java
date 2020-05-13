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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PIMTYPECONTRACT;
import cn.ibizlab.ehr.core.pim.service.IPIMTYPECONTRACTService;
import cn.ibizlab.ehr.core.pim.filter.PIMTYPECONTRACTSearchContext;




@Slf4j
@Api(tags = {"PIMTYPECONTRACT" })
@RestController("WebApi-pimtypecontract")
@RequestMapping("")
public class PIMTYPECONTRACTResource {

    @Autowired
    private IPIMTYPECONTRACTService pimtypecontractService;

    @Autowired
    @Lazy
    private PIMTYPECONTRACTMapping pimtypecontractMapping;




    @PreAuthorize("hasPermission(#pimtypecontract_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMTYPECONTRACT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtypecontracts/{pimtypecontract_id}")
    @Transactional
    public ResponseEntity<PIMTYPECONTRACTDTO> update(@PathVariable("pimtypecontract_id") String pimtypecontract_id, @RequestBody PIMTYPECONTRACTDTO pimtypecontractdto) {
		PIMTYPECONTRACT domain = pimtypecontractMapping.toDomain(pimtypecontractdto);
        domain.setPimtypecontractid(pimtypecontract_id);
		pimtypecontractService.update(domain);
		PIMTYPECONTRACTDTO dto = pimtypecontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimtypecontract_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMTYPECONTRACT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMTYPECONTRACTDTO> pimtypecontractdtos) {
        pimtypecontractService.updateBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMTYPECONTRACT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMTYPECONTRACTDTO pimtypecontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.checkKey(pimtypecontractMapping.toDomain(pimtypecontractdto)));
    }




    @PreAuthorize("hasPermission(#pimtypecontract_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMTYPECONTRACT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtypecontracts/{pimtypecontract_id}")
    public ResponseEntity<PIMTYPECONTRACTDTO> get(@PathVariable("pimtypecontract_id") String pimtypecontract_id) {
        PIMTYPECONTRACT domain = pimtypecontractService.get(pimtypecontract_id);
        PIMTYPECONTRACTDTO dto = pimtypecontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#pimtypecontract_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMTYPECONTRACT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtypecontracts/{pimtypecontract_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtypecontract_id") String pimtypecontract_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.remove(pimtypecontract_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMTYPECONTRACT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtypecontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMTYPECONTRACT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts")
    @Transactional
    public ResponseEntity<PIMTYPECONTRACTDTO> create(@RequestBody PIMTYPECONTRACTDTO pimtypecontractdto) {
        PIMTYPECONTRACT domain = pimtypecontractMapping.toDomain(pimtypecontractdto);
		pimtypecontractService.create(domain);
        PIMTYPECONTRACTDTO dto = pimtypecontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMTYPECONTRACT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMTYPECONTRACTDTO> pimtypecontractdtos) {
        pimtypecontractService.createBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMTYPECONTRACT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMTYPECONTRACTDTO pimtypecontractdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractService.save(pimtypecontractMapping.toDomain(pimtypecontractdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMTYPECONTRACT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtypecontracts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMTYPECONTRACTDTO> pimtypecontractdtos) {
        pimtypecontractService.saveBatch(pimtypecontractMapping.toDomain(pimtypecontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMTYPECONTRACT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtypecontracts/getdraft")
    public ResponseEntity<PIMTYPECONTRACTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtypecontractMapping.toDto(pimtypecontractService.getDraft(new PIMTYPECONTRACT())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMTYPECONTRACT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimtypecontracts/fetchdefault")
	public ResponseEntity<List<PIMTYPECONTRACTDTO>> fetchDefault(PIMTYPECONTRACTSearchContext context) {
        Page<PIMTYPECONTRACT> domains = pimtypecontractService.searchDefault(context) ;
        List<PIMTYPECONTRACTDTO> list = pimtypecontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMTYPECONTRACT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimtypecontracts/searchdefault")
	public ResponseEntity<Page<PIMTYPECONTRACTDTO>> searchDefault(PIMTYPECONTRACTSearchContext context) {
        Page<PIMTYPECONTRACT> domains = pimtypecontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtypecontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMTYPECONTRACT getEntity(){
        return new PIMTYPECONTRACT();
    }

}