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
import cn.ibizlab.ehr.core.vac.domain.VACSYNJCX;
import cn.ibizlab.ehr.core.vac.service.IVACSYNJCXService;
import cn.ibizlab.ehr.core.vac.filter.VACSYNJCXSearchContext;




@Slf4j
@Api(tags = {"VACSYNJCX" })
@RestController("WebApi-vacsynjcx")
@RequestMapping("")
public class VACSYNJCXResource {

    @Autowired
    private IVACSYNJCXService vacsynjcxService;

    @Autowired
    @Lazy
    private VACSYNJCXMapping vacsynjcxMapping;




    @PreAuthorize("hasPermission('Remove',{#vacsynjcx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACSYNJCX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsynjcxes/{vacsynjcx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsynjcx_id") String vacsynjcx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.remove(vacsynjcx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACSYNJCX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsynjcxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacsynjcx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACSYNJCX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsynjcxes/{vacsynjcx_id}")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> update(@PathVariable("vacsynjcx_id") String vacsynjcx_id, @RequestBody VACSYNJCXDTO vacsynjcxdto) {
		VACSYNJCX domain = vacsynjcxMapping.toDomain(vacsynjcxdto);
        domain.setVacsynjcxid(vacsynjcx_id);
		vacsynjcxService.update(domain);
		VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacsynjcx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACSYNJCX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.updateBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACSYNJCX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.checkKey(vacsynjcxMapping.toDomain(vacsynjcxdto)));
    }




    @PreAuthorize("hasPermission(#vacsynjcx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACSYNJCX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsynjcxes/{vacsynjcx_id}")
    public ResponseEntity<VACSYNJCXDTO> get(@PathVariable("vacsynjcx_id") String vacsynjcx_id) {
        VACSYNJCX domain = vacsynjcxService.get(vacsynjcx_id);
        VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"VACSYNJCX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.save(vacsynjcxMapping.toDomain(vacsynjcxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACSYNJCX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.saveBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "计算剩余天数", tags = {"VACSYNJCX" },  notes = "计算剩余天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/{vacsynjcx_id}/jsts")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> jSTS(@PathVariable("vacsynjcx_id") String vacsynjcx_id, @RequestBody VACSYNJCXDTO vacsynjcxdto) {
        VACSYNJCX vacsynjcx = vacsynjcxMapping.toDomain(vacsynjcxdto);
        vacsynjcx = vacsynjcxService.jSTS(vacsynjcx);
        vacsynjcxdto = vacsynjcxMapping.toDto(vacsynjcx);
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACSYNJCX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> create(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        VACSYNJCX domain = vacsynjcxMapping.toDomain(vacsynjcxdto);
		vacsynjcxService.create(domain);
        VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACSYNJCX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.createBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"VACSYNJCX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsynjcxes/getdraft")
    public ResponseEntity<VACSYNJCXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxMapping.toDto(vacsynjcxService.getDraft(new VACSYNJCX())));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"VACSYNJCX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsynjcxes/fetchdefault")
	public ResponseEntity<List<VACSYNJCXDTO>> fetchDefault(VACSYNJCXSearchContext context) {
        Page<VACSYNJCX> domains = vacsynjcxService.searchDefault(context) ;
        List<VACSYNJCXDTO> list = vacsynjcxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"VACSYNJCX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsynjcxes/searchdefault")
	public ResponseEntity<Page<VACSYNJCXDTO>> searchDefault(@RequestBody VACSYNJCXSearchContext context) {
        Page<VACSYNJCX> domains = vacsynjcxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsynjcxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACSYNJCX getEntity(){
        return new VACSYNJCX();
    }

}
