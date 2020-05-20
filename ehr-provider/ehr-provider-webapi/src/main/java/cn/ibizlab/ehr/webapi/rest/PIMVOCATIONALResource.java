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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
import cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALSearchContext;




@Slf4j
@Api(tags = {"PIMVOCATIONAL" })
@RestController("WebApi-pimvocational")
@RequestMapping("")
public class PIMVOCATIONALResource {

    @Autowired
    private IPIMVOCATIONALService pimvocationalService;

    @Autowired
    @Lazy
    private PIMVOCATIONALMapping pimvocationalMapping;




    @PreAuthorize("hasPermission(#pimvocational_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMVOCATIONAL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> update(@PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
		PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain);
		PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimvocational_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMVOCATIONAL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.updateBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMVOCATIONAL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> create(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
		pimvocationalService.create(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMVOCATIONAL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.createBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMVOCATIONAL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pimvocational_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMVOCATIONAL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvocational_id") String pimvocational_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMVOCATIONAL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMVOCATIONAL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMVOCATIONAL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        pimvocationalService.saveBatch(pimvocationalMapping.toDomain(pimvocationaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimvocational_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMVOCATIONAL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PIMVOCATIONALDTO> get(@PathVariable("pimvocational_id") String pimvocational_id) {
        PIMVOCATIONAL domain = pimvocationalService.get(pimvocational_id);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMVOCATIONAL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationals/getdraft")
    public ResponseEntity<PIMVOCATIONALDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(new PIMVOCATIONAL())));
    }

	@ApiOperation(value = "fetchREP_VOCATIONAL", tags = {"PIMVOCATIONAL" } ,notes = "fetchREP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchREP_VOCATIONAL(PIMVOCATIONALSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

	@ApiOperation(value = "searchREP_VOCATIONAL", tags = {"PIMVOCATIONAL" } ,notes = "searchREP_VOCATIONAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchREP_VOCATIONAL(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属是管理员的", tags = {"PIMVOCATIONAL" } ,notes = "fetch记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchAscriptionSysDQ(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属是管理员的", tags = {"PIMVOCATIONAL" } ,notes = "search记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchAscriptionSysDQ(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMVOCATIONAL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchdefault")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchDefault(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMVOCATIONAL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchdefault")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchDefault(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属于", tags = {"PIMVOCATIONAL" } ,notes = "fetch记录所属于")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchjlss")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchJLSS(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属于", tags = {"PIMVOCATIONAL" } ,notes = "search记录所属于")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchjlss")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchJLSS(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(证书信息)", tags = {"PIMVOCATIONAL" } ,notes = "fetch自助(证书信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchZIZHU(PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(证书信息)", tags = {"PIMVOCATIONAL" } ,notes = "search自助(证书信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchZIZHU(@RequestBody PIMVOCATIONALSearchContext context) {
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimvocationalid(pimvocational_id);
		pimvocationalService.update(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals")
    @Transactional
    public ResponseEntity<PIMVOCATIONALDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
		pimvocationalService.create(domain);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.checkKey(pimvocationalMapping.toDomain(pimvocationaldto)));
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.remove(pimvocational_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvocationals/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimvocationalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALDTO pimvocationaldto) {
        PIMVOCATIONAL domain = pimvocationalMapping.toDomain(pimvocationaldto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvocationals/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMVOCATIONALDTO> pimvocationaldtos) {
        List<PIMVOCATIONAL> domainlist=pimvocationalMapping.toDomain(pimvocationaldtos);
        for(PIMVOCATIONAL domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimvocationalService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/{pimvocational_id}")
    public ResponseEntity<PIMVOCATIONALDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvocational_id") String pimvocational_id) {
        PIMVOCATIONAL domain = pimvocationalService.get(pimvocational_id);
        PIMVOCATIONALDTO dto = pimvocationalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMVOCATIONAL" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvocationals/getdraft")
    public ResponseEntity<PIMVOCATIONALDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMVOCATIONAL domain = new PIMVOCATIONAL();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalMapping.toDto(pimvocationalService.getDraft(domain)));
    }

	@ApiOperation(value = "fetchREP_VOCATIONALByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "fetchREP_VOCATIONALByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchrep_vocational")
	public ResponseEntity<List<HashMap>> fetchPIMVOCATIONALREP_VOCATIONALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

	@ApiOperation(value = "searchREP_VOCATIONALByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "searchREP_VOCATIONALByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchrep_vocational")
	public ResponseEntity<Page<HashMap>> searchPIMVOCATIONALREP_VOCATIONALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimvocationalService.searchREP_VOCATIONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属是管理员的ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "fetch记录所属是管理员的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchascriptionsysdq")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALAscriptionSysDQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属是管理员的ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "search记录所属是管理员的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchascriptionsysdq")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALAscriptionSysDQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchAscriptionSysDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchdefault")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchdefault")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属于ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "fetch记录所属于ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchjlss")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属于ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "search记录所属于ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchjlss")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(证书信息)ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "fetch自助(证书信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvocationals/fetchzizhu")
	public ResponseEntity<List<PIMVOCATIONALDTO>> fetchPIMVOCATIONALZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
        List<PIMVOCATIONALDTO> list = pimvocationalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(证书信息)ByPIMPERSON", tags = {"PIMVOCATIONAL" } ,notes = "search自助(证书信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvocationals/searchzizhu")
	public ResponseEntity<Page<PIMVOCATIONALDTO>> searchPIMVOCATIONALZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMVOCATIONALSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMVOCATIONAL> domains = pimvocationalService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMVOCATIONAL getEntity(){
        return new PIMVOCATIONAL();
    }

}
