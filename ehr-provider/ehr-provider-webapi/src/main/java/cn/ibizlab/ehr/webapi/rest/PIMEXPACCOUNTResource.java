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
import cn.ibizlab.ehr.core.pim.domain.PIMEXPACCOUNT;
import cn.ibizlab.ehr.core.pim.service.IPIMEXPACCOUNTService;
import cn.ibizlab.ehr.core.pim.filter.PIMEXPACCOUNTSearchContext;




@Slf4j
@Api(tags = {"PIMEXPACCOUNT" })
@RestController("WebApi-pimexpaccount")
@RequestMapping("")
public class PIMEXPACCOUNTResource {

    @Autowired
    private IPIMEXPACCOUNTService pimexpaccountService;

    @Autowired
    @Lazy
    private PIMEXPACCOUNTMapping pimexpaccountMapping;




    @PreAuthorize("hasPermission('Remove',{#pimexpaccount_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMEXPACCOUNT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexpaccounts/{pimexpaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexpaccount_id") String pimexpaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.remove(pimexpaccount_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMEXPACCOUNT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexpaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimexpaccount_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMEXPACCOUNT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexpaccounts/{pimexpaccount_id}")
    public ResponseEntity<PIMEXPACCOUNTDTO> get(@PathVariable("pimexpaccount_id") String pimexpaccount_id) {
        PIMEXPACCOUNT domain = pimexpaccountService.get(pimexpaccount_id);
        PIMEXPACCOUNTDTO dto = pimexpaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PIMEXPACCOUNT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMEXPACCOUNTDTO pimexpaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.save(pimexpaccountMapping.toDomain(pimexpaccountdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMEXPACCOUNT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMEXPACCOUNTDTO> pimexpaccountdtos) {
        pimexpaccountService.saveBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimexpaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMEXPACCOUNT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexpaccounts/{pimexpaccount_id}")
    @Transactional
    public ResponseEntity<PIMEXPACCOUNTDTO> update(@PathVariable("pimexpaccount_id") String pimexpaccount_id, @RequestBody PIMEXPACCOUNTDTO pimexpaccountdto) {
		PIMEXPACCOUNT domain = pimexpaccountMapping.toDomain(pimexpaccountdto);
        domain.setPimexpaccountid(pimexpaccount_id);
		pimexpaccountService.update(domain);
		PIMEXPACCOUNTDTO dto = pimexpaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimexpaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMEXPACCOUNT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMEXPACCOUNTDTO> pimexpaccountdtos) {
        pimexpaccountService.updateBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMEXPACCOUNT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexpaccounts/getdraft")
    public ResponseEntity<PIMEXPACCOUNTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexpaccountMapping.toDto(pimexpaccountService.getDraft(new PIMEXPACCOUNT())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMEXPACCOUNT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMEXPACCOUNTDTO pimexpaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexpaccountService.checkKey(pimexpaccountMapping.toDomain(pimexpaccountdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMEXPACCOUNT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts")
    @Transactional
    public ResponseEntity<PIMEXPACCOUNTDTO> create(@RequestBody PIMEXPACCOUNTDTO pimexpaccountdto) {
        PIMEXPACCOUNT domain = pimexpaccountMapping.toDomain(pimexpaccountdto);
		pimexpaccountService.create(domain);
        PIMEXPACCOUNTDTO dto = pimexpaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMEXPACCOUNT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexpaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMEXPACCOUNTDTO> pimexpaccountdtos) {
        pimexpaccountService.createBatch(pimexpaccountMapping.toDomain(pimexpaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMEXPACCOUNT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexpaccounts/fetchdefault")
	public ResponseEntity<List<PIMEXPACCOUNTDTO>> fetchDefault(PIMEXPACCOUNTSearchContext context) {
        Page<PIMEXPACCOUNT> domains = pimexpaccountService.searchDefault(context) ;
        List<PIMEXPACCOUNTDTO> list = pimexpaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMEXPACCOUNT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexpaccounts/searchdefault")
	public ResponseEntity<Page<PIMEXPACCOUNTDTO>> searchDefault(PIMEXPACCOUNTSearchContext context) {
        Page<PIMEXPACCOUNT> domains = pimexpaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexpaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMEXPACCOUNT getEntity(){
        return new PIMEXPACCOUNT();
    }

}
