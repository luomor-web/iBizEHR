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
import cn.ibizlab.ehr.core.pim.domain.PIMACHIEVEMENTS;
import cn.ibizlab.ehr.core.pim.service.IPIMACHIEVEMENTSService;
import cn.ibizlab.ehr.core.pim.filter.PIMACHIEVEMENTSSearchContext;




@Slf4j
@Api(tags = {"PIMACHIEVEMENTS" })
@RestController("WebApi-pimachievements")
@RequestMapping("")
public class PIMACHIEVEMENTSResource {

    @Autowired
    private IPIMACHIEVEMENTSService pimachievementsService;

    @Autowired
    @Lazy
    private PIMACHIEVEMENTSMapping pimachievementsMapping;




    @PreAuthorize("hasPermission(#pimachievements_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMACHIEVEMENTS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PIMACHIEVEMENTSDTO> update(@PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
		PIMACHIEVEMENTS domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain);
		PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimachievements_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMACHIEVEMENTS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        pimachievementsService.updateBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMACHIEVEMENTS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMACHIEVEMENTS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        pimachievementsService.saveBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMACHIEVEMENTS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/getdraft")
    public ResponseEntity<PIMACHIEVEMENTSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(new PIMACHIEVEMENTS())));
    }




    @PreAuthorize("hasPermission('Remove',{#pimachievements_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMACHIEVEMENTS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimachievements_id") String pimachievements_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMACHIEVEMENTS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimachievements_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMACHIEVEMENTS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/{pimachievements_id}")
    public ResponseEntity<PIMACHIEVEMENTSDTO> get(@PathVariable("pimachievements_id") String pimachievements_id) {
        PIMACHIEVEMENTS domain = pimachievementsService.get(pimachievements_id);
        PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMACHIEVEMENTS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMACHIEVEMENTS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements")
    @Transactional
    public ResponseEntity<PIMACHIEVEMENTSDTO> create(@RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        PIMACHIEVEMENTS domain = pimachievementsMapping.toDomain(pimachievementsdto);
		pimachievementsService.create(domain);
        PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMACHIEVEMENTS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        pimachievementsService.createBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PIMACHIEVEMENTS" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchjlss")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchJLSS(PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchJLSS(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PIMACHIEVEMENTS" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchjlss")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchJLSS(@RequestBody PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMACHIEVEMENTS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchdefault")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchDefault(PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchDefault(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMACHIEVEMENTS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchdefault")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchDefault(@RequestBody PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(绩效信息)", tags = {"PIMACHIEVEMENTS" } ,notes = "fetch自助(绩效信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchzizhu")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchZIZHU(PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchZIZHU(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(绩效信息)", tags = {"PIMACHIEVEMENTS" } ,notes = "search自助(绩效信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchzizhu")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchZIZHU(@RequestBody PIMACHIEVEMENTSSearchContext context) {
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PIMACHIEVEMENTSDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        PIMACHIEVEMENTS domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain);
        PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        List<PIMACHIEVEMENTS> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PIMACHIEVEMENTS domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        PIMACHIEVEMENTS domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        List<PIMACHIEVEMENTS> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PIMACHIEVEMENTS domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/getdraft")
    public ResponseEntity<PIMACHIEVEMENTSDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMACHIEVEMENTS domain = new PIMACHIEVEMENTS();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(domain)));
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    public ResponseEntity<PIMACHIEVEMENTSDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
        PIMACHIEVEMENTS domain = pimachievementsService.get(pimachievements_id);
        PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements")
    @Transactional
    public ResponseEntity<PIMACHIEVEMENTSDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSDTO pimachievementsdto) {
        PIMACHIEVEMENTS domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
		pimachievementsService.create(domain);
        PIMACHIEVEMENTSDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMACHIEVEMENTS" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMACHIEVEMENTSDTO> pimachievementsdtos) {
        List<PIMACHIEVEMENTS> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PIMACHIEVEMENTS domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "fetch记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchjlss")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchPIMACHIEVEMENTSJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchJLSS(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "search记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchjlss")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchPIMACHIEVEMENTSJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchdefault")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchPIMACHIEVEMENTSDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchDefault(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchdefault")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchPIMACHIEVEMENTSDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(绩效信息)ByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "fetch自助(绩效信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchzizhu")
	public ResponseEntity<List<PIMACHIEVEMENTSDTO>> fetchPIMACHIEVEMENTSZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchZIZHU(context) ;
        List<PIMACHIEVEMENTSDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(绩效信息)ByPIMPERSON", tags = {"PIMACHIEVEMENTS" } ,notes = "search自助(绩效信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchzizhu")
	public ResponseEntity<Page<PIMACHIEVEMENTSDTO>> searchPIMACHIEVEMENTSZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMACHIEVEMENTSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMACHIEVEMENTS> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMACHIEVEMENTS getEntity(){
        return new PIMACHIEVEMENTS();
    }

}
