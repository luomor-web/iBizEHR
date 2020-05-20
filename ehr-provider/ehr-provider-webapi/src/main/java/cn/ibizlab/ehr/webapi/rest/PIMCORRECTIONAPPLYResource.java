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
import cn.ibizlab.ehr.core.pim.domain.PIMCORRECTIONAPPLY;
import cn.ibizlab.ehr.core.pim.service.IPIMCORRECTIONAPPLYService;
import cn.ibizlab.ehr.core.pim.filter.PIMCORRECTIONAPPLYSearchContext;




@Slf4j
@Api(tags = {"PIMCORRECTIONAPPLY" })
@RestController("WebApi-pimcorrectionapply")
@RequestMapping("")
public class PIMCORRECTIONAPPLYResource {

    @Autowired
    private IPIMCORRECTIONAPPLYService pimcorrectionapplyService;

    @Autowired
    @Lazy
    private PIMCORRECTIONAPPLYMapping pimcorrectionapplyMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMCORRECTIONAPPLY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> create(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
		pimcorrectionapplyService.create(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.createBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/getdraft")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(new PIMCORRECTIONAPPLY())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMCORRECTIONAPPLY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }




    @ApiOperation(value = "Save", tags = {"PIMCORRECTIONAPPLY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.saveBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimcorrectionapply_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMCORRECTIONAPPLY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> get(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pimcorrectionapply_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMCORRECTIONAPPLY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> update(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
		PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain);
		PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimcorrectionapply_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.updateBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimcorrectionapply_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PIMCORRECTIONAPPLY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMCORRECTIONAPPLY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PIMCORRECTIONAPPLYDTO>> fetchDefault(PIMCORRECTIONAPPLYSearchContext context) {
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PIMCORRECTIONAPPLYDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMCORRECTIONAPPLY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PIMCORRECTIONAPPLYDTO>> searchDefault(@RequestBody PIMCORRECTIONAPPLYSearchContext context) {
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMCORRECTIONAPPLY getEntity(){
        return new PIMCORRECTIONAPPLY();
    }

}
