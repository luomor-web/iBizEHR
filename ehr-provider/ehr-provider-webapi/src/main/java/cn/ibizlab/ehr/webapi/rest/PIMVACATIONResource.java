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
import cn.ibizlab.ehr.core.pim.domain.PIMVACATION;
import cn.ibizlab.ehr.core.pim.service.IPIMVACATIONService;
import cn.ibizlab.ehr.core.pim.filter.PIMVACATIONSearchContext;




@Slf4j
@Api(tags = {"PIMVACATION" })
@RestController("WebApi-pimvacation")
@RequestMapping("")
public class PIMVACATIONResource {

    @Autowired
    private IPIMVACATIONService pimvacationService;

    @Autowired
    @Lazy
    private PIMVACATIONMapping pimvacationMapping;




    @PreAuthorize("hasPermission(#pimvacation_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMVACATION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<PIMVACATIONDTO> update(@PathVariable("pimvacation_id") String pimvacation_id, @RequestBody PIMVACATIONDTO pimvacationdto) {
		PIMVACATION domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimvacationid(pimvacation_id);
		pimvacationService.update(domain);
		PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimvacation_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMVACATION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        pimvacationService.updateBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pimvacation_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMVACATION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvacation_id") String pimvacation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.remove(pimvacation_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMVACATION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvacationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMVACATION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvacations/getdraft")
    public ResponseEntity<PIMVACATIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationMapping.toDto(pimvacationService.getDraft(new PIMVACATION())));
    }




    @ApiOperation(value = "Save", tags = {"PIMVACATION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMVACATIONDTO pimvacationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.save(pimvacationMapping.toDomain(pimvacationdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMVACATION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        pimvacationService.saveBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMVACATION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations")
    @Transactional
    public ResponseEntity<PIMVACATIONDTO> create(@RequestBody PIMVACATIONDTO pimvacationdto) {
        PIMVACATION domain = pimvacationMapping.toDomain(pimvacationdto);
		pimvacationService.create(domain);
        PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMVACATION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        pimvacationService.createBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMVACATION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMVACATIONDTO pimvacationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvacationService.checkKey(pimvacationMapping.toDomain(pimvacationdto)));
    }




    @PreAuthorize("hasPermission(#pimvacation_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMVACATION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvacations/{pimvacation_id}")
    public ResponseEntity<PIMVACATIONDTO> get(@PathVariable("pimvacation_id") String pimvacation_id) {
        PIMVACATION domain = pimvacationService.get(pimvacation_id);
        PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMVACATION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvacations/fetchdefault")
	public ResponseEntity<List<PIMVACATIONDTO>> fetchDefault(PIMVACATIONSearchContext context) {
        Page<PIMVACATION> domains = pimvacationService.searchDefault(context) ;
        List<PIMVACATIONDTO> list = pimvacationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMVACATION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvacations/searchdefault")
	public ResponseEntity<Page<PIMVACATIONDTO>> searchDefault(PIMVACATIONSearchContext context) {
        Page<PIMVACATION> domains = pimvacationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvacationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMVACATION" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<PIMVACATIONDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id, @RequestBody PIMVACATIONDTO pimvacationdto) {
        PIMVACATION domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimvacationid(pimvacation_id);
		pimvacationService.update(domain);
        PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMVACATION" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        List<PIMVACATION> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PIMVACATION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMVACATION" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.remove(pimvacation_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMVACATION" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimvacationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMVACATION" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvacations/getdraft")
    public ResponseEntity<PIMVACATIONDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMVACATION domain = new PIMVACATION();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationMapping.toDto(pimvacationService.getDraft(domain)));
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMVACATION" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVACATIONDTO pimvacationdto) {
        PIMVACATION domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMVACATION" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        List<PIMVACATION> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PIMVACATION domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMVACATION" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations")
    @Transactional
    public ResponseEntity<PIMVACATIONDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVACATIONDTO pimvacationdto) {
        PIMVACATION domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
		pimvacationService.create(domain);
        PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMVACATION" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVACATIONDTO> pimvacationdtos) {
        List<PIMVACATION> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PIMVACATION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMVACATION" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVACATIONDTO pimvacationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvacationService.checkKey(pimvacationMapping.toDomain(pimvacationdto)));
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMVACATION" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    public ResponseEntity<PIMVACATIONDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id) {
        PIMVACATION domain = pimvacationService.get(pimvacation_id);
        PIMVACATIONDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMVACATION" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvacations/fetchdefault")
	public ResponseEntity<List<PIMVACATIONDTO>> fetchPIMVACATIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVACATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVACATION> domains = pimvacationService.searchDefault(context) ;
        List<PIMVACATIONDTO> list = pimvacationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMVACATION" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvacations/searchdefault")
	public ResponseEntity<Page<PIMVACATIONDTO>> searchPIMVACATIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVACATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVACATION> domains = pimvacationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvacationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMVACATION getEntity(){
        return new PIMVACATION();
    }

}
