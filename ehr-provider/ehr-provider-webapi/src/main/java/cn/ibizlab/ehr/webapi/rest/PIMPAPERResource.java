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
import cn.ibizlab.ehr.core.pim.domain.PIMPAPER;
import cn.ibizlab.ehr.core.pim.service.IPIMPAPERService;
import cn.ibizlab.ehr.core.pim.filter.PIMPAPERSearchContext;




@Slf4j
@Api(tags = {"PIMPAPER" })
@RestController("WebApi-pimpaper")
@RequestMapping("")
public class PIMPAPERResource {

    @Autowired
    private IPIMPAPERService pimpaperService;

    @Autowired
    @Lazy
    private PIMPAPERMapping pimpaperMapping;




    @PreAuthorize("hasPermission(#pimpaper_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMPAPER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<PIMPAPERDTO> update(@PathVariable("pimpaper_id") String pimpaper_id, @RequestBody PIMPAPERDTO pimpaperdto) {
		PIMPAPER domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpaperid(pimpaper_id);
		pimpaperService.update(domain);
		PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimpaper_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPAPER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        pimpaperService.updateBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMPAPER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpapers/getdraft")
    public ResponseEntity<PIMPAPERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperMapping.toDto(pimpaperService.getDraft(new PIMPAPER())));
    }




    @PreAuthorize("hasPermission('Remove',{#pimpaper_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMPAPER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpaper_id") String pimpaper_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.remove(pimpaper_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMPAPER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpaperService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMPAPER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers")
    @Transactional
    public ResponseEntity<PIMPAPERDTO> create(@RequestBody PIMPAPERDTO pimpaperdto) {
        PIMPAPER domain = pimpaperMapping.toDomain(pimpaperdto);
		pimpaperService.create(domain);
        PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMPAPER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        pimpaperService.createBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimpaper_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMPAPER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpapers/{pimpaper_id}")
    public ResponseEntity<PIMPAPERDTO> get(@PathVariable("pimpaper_id") String pimpaper_id) {
        PIMPAPER domain = pimpaperService.get(pimpaper_id);
        PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PIMPAPER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPAPERDTO pimpaperdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.save(pimpaperMapping.toDomain(pimpaperdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMPAPER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        pimpaperService.saveBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMPAPER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPAPERDTO pimpaperdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpaperService.checkKey(pimpaperMapping.toDomain(pimpaperdto)));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPAPER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchdefault")
	public ResponseEntity<List<PIMPAPERDTO>> fetchDefault(PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchDefault(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPAPER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchdefault")
	public ResponseEntity<Page<PIMPAPERDTO>> searchDefault(@RequestBody PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMPAPER" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchjlssgr")
	public ResponseEntity<List<PIMPAPERDTO>> fetchJLSSGR(PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGR(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMPAPER" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchjlssgr")
	public ResponseEntity<Page<PIMPAPERDTO>> searchJLSSGR(@RequestBody PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMPAPER" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchjlssgly")
	public ResponseEntity<List<PIMPAPERDTO>> fetchJLSSGLY(PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGLY(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMPAPER" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchjlssgly")
	public ResponseEntity<Page<PIMPAPERDTO>> searchJLSSGLY(@RequestBody PIMPAPERSearchContext context) {
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMPAPER" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<PIMPAPERDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id, @RequestBody PIMPAPERDTO pimpaperdto) {
        PIMPAPER domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpaperid(pimpaper_id);
		pimpaperService.update(domain);
        PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMPAPER" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        List<PIMPAPER> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PIMPAPER domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMPAPER" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpapers/getdraft")
    public ResponseEntity<PIMPAPERDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMPAPER domain = new PIMPAPER();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperMapping.toDto(pimpaperService.getDraft(domain)));
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMPAPER" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.remove(pimpaper_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMPAPER" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimpaperService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMPAPER" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers")
    @Transactional
    public ResponseEntity<PIMPAPERDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERDTO pimpaperdto) {
        PIMPAPER domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
		pimpaperService.create(domain);
        PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMPAPER" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        List<PIMPAPER> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PIMPAPER domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMPAPER" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    public ResponseEntity<PIMPAPERDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id) {
        PIMPAPER domain = pimpaperService.get(pimpaper_id);
        PIMPAPERDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMPAPER" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERDTO pimpaperdto) {
        PIMPAPER domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMPAPER" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPAPERDTO> pimpaperdtos) {
        List<PIMPAPER> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PIMPAPER domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMPAPER" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERDTO pimpaperdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpaperService.checkKey(pimpaperMapping.toDomain(pimpaperdto)));
    }

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMPAPER" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchdefault")
	public ResponseEntity<List<PIMPAPERDTO>> fetchPIMPAPERDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchDefault(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMPAPER" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchdefault")
	public ResponseEntity<Page<PIMPAPERDTO>> searchPIMPAPERDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMPAPER" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchjlssgr")
	public ResponseEntity<List<PIMPAPERDTO>> fetchPIMPAPERJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGR(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMPAPER" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchjlssgr")
	public ResponseEntity<Page<PIMPAPERDTO>> searchPIMPAPERJLSSGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMPAPER" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchjlssgly")
	public ResponseEntity<List<PIMPAPERDTO>> fetchPIMPAPERJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGLY(context) ;
        List<PIMPAPERDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMPAPER" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchjlssgly")
	public ResponseEntity<Page<PIMPAPERDTO>> searchPIMPAPERJLSSGLYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPAPERSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPAPER> domains = pimpaperService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMPAPER getEntity(){
        return new PIMPAPER();
    }

}
