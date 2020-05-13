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
import cn.ibizlab.ehr.core.pim.domain.PIMWORKHISTORY;
import cn.ibizlab.ehr.core.pim.service.IPIMWORKHISTORYService;
import cn.ibizlab.ehr.core.pim.filter.PIMWORKHISTORYSearchContext;




@Slf4j
@Api(tags = {"PIMWORKHISTORY" })
@RestController("WebApi-pimworkhistory")
@RequestMapping("")
public class PIMWORKHISTORYResource {

    @Autowired
    private IPIMWORKHISTORYService pimworkhistoryService;

    @Autowired
    @Lazy
    private PIMWORKHISTORYMapping pimworkhistoryMapping;




    @PreAuthorize("hasPermission(#pimworkhistory_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMWORKHISTORY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkhistories/{pimworkhistory_id}")
    public ResponseEntity<PIMWORKHISTORYDTO> get(@PathVariable("pimworkhistory_id") String pimworkhistory_id) {
        PIMWORKHISTORY domain = pimworkhistoryService.get(pimworkhistory_id);
        PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMWORKHISTORY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories")
    @Transactional
    public ResponseEntity<PIMWORKHISTORYDTO> create(@RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        PIMWORKHISTORY domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
		pimworkhistoryService.create(domain);
        PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMWORKHISTORY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        pimworkhistoryService.createBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMWORKHISTORY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.save(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMWORKHISTORY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        pimworkhistoryService.saveBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimworkhistory_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMWORKHISTORY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<PIMWORKHISTORYDTO> update(@PathVariable("pimworkhistory_id") String pimworkhistory_id, @RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
		PIMWORKHISTORY domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimworkhistoryid(pimworkhistory_id);
		pimworkhistoryService.update(domain);
		PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimworkhistory_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMWORKHISTORY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        pimworkhistoryService.updateBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMWORKHISTORY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.checkKey(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pimworkhistory_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMWORKHISTORY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkhistory_id") String pimworkhistory_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.remove(pimworkhistory_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMWORKHISTORY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMWORKHISTORY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkhistories/getdraft")
    public ResponseEntity<PIMWORKHISTORYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryMapping.toDto(pimworkhistoryService.getDraft(new PIMWORKHISTORY())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMWORKHISTORY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchdefault")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchDefault(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchDefault(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMWORKHISTORY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchdefault")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchDefault(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'IsMain',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch是主要工作经历的", tags = {"PIMWORKHISTORY" } ,notes = "fetch是主要工作经历的")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchismain")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchIsMain(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchIsMain(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'IsMain',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search是主要工作经历的", tags = {"PIMWORKHISTORY" } ,notes = "search是主要工作经历的")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchismain")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchIsMain(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchIsMain(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSSGLY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlssgly")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchJLSSGLY(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGLY(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSSGLY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchjlssgly")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchJLSSGLY(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'ZIZHU',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch记录所属(个人履历)", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属(个人履历)")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchzizhu")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchZIZHU(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchZIZHU(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'ZIZHU',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search记录所属(个人履历)", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属(个人履历)")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchzizhu")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchZIZHU(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch记录所属", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlss")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchJLSS(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSS(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search记录所属", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchjlss")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchJLSS(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'FAZZSY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch非A转正使用", tags = {"PIMWORKHISTORY" } ,notes = "fetch非A转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchfazzsy")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchFAZZSY(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchFAZZSY(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'FAZZSY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search非A转正使用", tags = {"PIMWORKHISTORY" } ,notes = "search非A转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchfazzsy")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchFAZZSY(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSSGR',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlssgr")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchJLSSGR(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGR(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLSSGR',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/searchjlssgr")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchJLSSGR(PIMWORKHISTORYSearchContext context) {
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    public ResponseEntity<PIMWORKHISTORYDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id) {
        PIMWORKHISTORY domain = pimworkhistoryService.get(pimworkhistory_id);
        PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories")
    @Transactional
    public ResponseEntity<PIMWORKHISTORYDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        PIMWORKHISTORY domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
		pimworkhistoryService.create(domain);
        PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        List<PIMWORKHISTORY> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PIMWORKHISTORY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        PIMWORKHISTORY domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        List<PIMWORKHISTORY> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PIMWORKHISTORY domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<PIMWORKHISTORYDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id, @RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        PIMWORKHISTORY domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimworkhistoryid(pimworkhistory_id);
		pimworkhistoryService.update(domain);
        PIMWORKHISTORYDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMWORKHISTORYDTO> pimworkhistorydtos) {
        List<PIMWORKHISTORY> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PIMWORKHISTORY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMWORKHISTORYDTO pimworkhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.checkKey(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.remove(pimworkhistory_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimworkhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMWORKHISTORY" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimworkhistories/getdraft")
    public ResponseEntity<PIMWORKHISTORYDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMWORKHISTORY domain = new PIMWORKHISTORY();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryMapping.toDto(pimworkhistoryService.getDraft(domain)));
    }

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchdefault")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchDefault(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchdefault")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch是主要工作经历的ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch是主要工作经历的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchismain")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYIsMainByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchIsMain(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search是主要工作经历的ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search是主要工作经历的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchismain")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYIsMainByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchIsMain(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlssgly")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGLY(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlssgly")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属(个人履历)ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属(个人履历)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchzizhu")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchZIZHU(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属(个人履历)ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属(个人履历)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchzizhu")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlss")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSS(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlss")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch非A转正使用ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch非A转正使用ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchfazzsy")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchFAZZSY(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search非A转正使用ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search非A转正使用ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchfazzsy")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlssgr")
	public ResponseEntity<List<PIMWORKHISTORYDTO>> fetchPIMWORKHISTORYJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGR(context) ;
        List<PIMWORKHISTORYDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMWORKHISTORY" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlssgr")
	public ResponseEntity<Page<PIMWORKHISTORYDTO>> searchPIMWORKHISTORYJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMWORKHISTORYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMWORKHISTORY> domains = pimworkhistoryService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMWORKHISTORY getEntity(){
        return new PIMWORKHISTORY();
    }

}
