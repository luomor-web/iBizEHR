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
import cn.ibizlab.ehr.core.pim.domain.PimWorkHistory;
import cn.ibizlab.ehr.core.pim.service.IPimWorkHistoryService;
import cn.ibizlab.ehr.core.pim.filter.PimWorkHistorySearchContext;

@Slf4j
@Api(tags = {"PimWorkHistory" })
@RestController("WebApi-pimworkhistory")
@RequestMapping("")
public class PimWorkHistoryResource {

    @Autowired
    public IPimWorkHistoryService pimworkhistoryService;

    @Autowired
    @Lazy
    public PimWorkHistoryMapping pimworkhistoryMapping;

    @PostAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(returnObject.body),'ehr-PimWorkHistory-Get')")
    @ApiOperation(value = "Get", tags = {"PimWorkHistory" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkhistories/{pimworkhistory_id}")
    public ResponseEntity<PimWorkHistoryDTO> get(@PathVariable("pimworkhistory_id") String pimworkhistory_id) {
        PimWorkHistory domain = pimworkhistoryService.get(pimworkhistory_id);
        PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydto),'ehr-PimWorkHistory-Create')")
    @ApiOperation(value = "Create", tags = {"PimWorkHistory" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories")
    @Transactional
    public ResponseEntity<PimWorkHistoryDTO> create(@RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        PimWorkHistory domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
		pimworkhistoryService.create(domain);
        PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos),'ehr-PimWorkHistory-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimWorkHistory" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        pimworkhistoryService.createBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydto),'ehr-PimWorkHistory-Save')")
    @ApiOperation(value = "Save", tags = {"PimWorkHistory" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/save")
    public ResponseEntity<Boolean> save(@RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.save(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos),'ehr-PimWorkHistory-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimWorkHistory" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        pimworkhistoryService.saveBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.get(#pimworkhistory_id),'ehr-PimWorkHistory-Update')")
    @ApiOperation(value = "Update", tags = {"PimWorkHistory" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<PimWorkHistoryDTO> update(@PathVariable("pimworkhistory_id") String pimworkhistory_id, @RequestBody PimWorkHistoryDTO pimworkhistorydto) {
		PimWorkHistory domain  = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain .setPimworkhistoryid(pimworkhistory_id);
		pimworkhistoryService.update(domain );
		PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.getPimworkhistoryByEntities(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos)),'ehr-PimWorkHistory-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimWorkHistory" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        pimworkhistoryService.updateBatch(pimworkhistoryMapping.toDomain(pimworkhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimWorkHistory" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkhistories/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.checkKey(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.get(#pimworkhistory_id),'ehr-PimWorkHistory-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimWorkHistory" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkhistory_id") String pimworkhistory_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.remove(pimworkhistory_id));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.getPimworkhistoryByIds(#ids),'ehr-PimWorkHistory-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimWorkHistory" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkhistories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimWorkHistory" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkhistories/getdraft")
    public ResponseEntity<PimWorkHistoryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryMapping.toDto(pimworkhistoryService.getDraft(new PimWorkHistory())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimWorkHistory" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchdefault")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchDefault(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchDefault(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimWorkHistory" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchdefault")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchDefault(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-IsMain-all')")
	@ApiOperation(value = "fetch是主要工作经历的", tags = {"PimWorkHistory" } ,notes = "fetch是主要工作经历的")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchismain")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchIsMain(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchIsMain(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-IsMain-all')")
	@ApiOperation(value = "search是主要工作经历的", tags = {"PimWorkHistory" } ,notes = "search是主要工作经历的")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchismain")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchIsMain(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchIsMain(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PimWorkHistory" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlssgly")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchJLSSGLY(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGLY(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PimWorkHistory" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchjlssgly")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchJLSSGLY(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-ZIZHU-all')")
	@ApiOperation(value = "fetch记录所属(个人履历)", tags = {"PimWorkHistory" } ,notes = "fetch记录所属(个人履历)")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchzizhu")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchZIZHU(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchZIZHU(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-ZIZHU-all')")
	@ApiOperation(value = "search记录所属(个人履历)", tags = {"PimWorkHistory" } ,notes = "search记录所属(个人履历)")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchzizhu")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchZIZHU(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PimWorkHistory" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlss")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchJLSS(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSS(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PimWorkHistory" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchjlss")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchJLSS(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-FAZZSY-all')")
	@ApiOperation(value = "fetch非A转正使用", tags = {"PimWorkHistory" } ,notes = "fetch非A转正使用")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchfazzsy")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchFAZZSY(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchFAZZSY(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-FAZZSY-all')")
	@ApiOperation(value = "search非A转正使用", tags = {"PimWorkHistory" } ,notes = "search非A转正使用")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchfazzsy")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchFAZZSY(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PimWorkHistory" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkhistories/fetchjlssgr")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchJLSSGR(PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGR(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PimWorkHistory" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkhistories/searchjlssgr")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchJLSSGR(@RequestBody PimWorkHistorySearchContext context) {
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(returnObject.body),'ehr-PimWorkHistory-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimWorkHistory" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    public ResponseEntity<PimWorkHistoryDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id) {
        PimWorkHistory domain = pimworkhistoryService.get(pimworkhistory_id);
        PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydto),'ehr-PimWorkHistory-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimWorkHistory" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories")
    @Transactional
    public ResponseEntity<PimWorkHistoryDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        PimWorkHistory domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
		pimworkhistoryService.create(domain);
        PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos),'ehr-PimWorkHistory-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimWorkHistory" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        List<PimWorkHistory> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PimWorkHistory domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydto),'ehr-PimWorkHistory-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimWorkHistory" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        PimWorkHistory domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos),'ehr-PimWorkHistory-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimWorkHistory" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        List<PimWorkHistory> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PimWorkHistory domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.get(#pimworkhistory_id),'ehr-PimWorkHistory-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimWorkHistory" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<PimWorkHistoryDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id, @RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        PimWorkHistory domain = pimworkhistoryMapping.toDomain(pimworkhistorydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimworkhistoryid(pimworkhistory_id);
		pimworkhistoryService.update(domain);
        PimWorkHistoryDTO dto = pimworkhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.getPimworkhistoryByEntities(this.pimworkhistoryMapping.toDomain(#pimworkhistorydtos)),'ehr-PimWorkHistory-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimWorkHistory" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimWorkHistoryDTO> pimworkhistorydtos) {
        List<PimWorkHistory> domainlist=pimworkhistoryMapping.toDomain(pimworkhistorydtos);
        for(PimWorkHistory domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimworkhistoryService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimWorkHistory" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimworkhistories/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistoryDTO pimworkhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.checkKey(pimworkhistoryMapping.toDomain(pimworkhistorydto)));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.get(#pimworkhistory_id),'ehr-PimWorkHistory-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimWorkHistory" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimworkhistories/{pimworkhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimworkhistory_id") String pimworkhistory_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryService.remove(pimworkhistory_id));
    }

    @PreAuthorize("hasPermission(this.pimworkhistoryService.getPimworkhistoryByIds(#ids),'ehr-PimWorkHistory-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimWorkHistory" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimworkhistories/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimworkhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimWorkHistory" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimworkhistories/getdraft")
    public ResponseEntity<PimWorkHistoryDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimWorkHistory domain = new PimWorkHistory();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkhistoryMapping.toDto(pimworkhistoryService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchdefault")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchDefault(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimWorkHistory" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchdefault")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-IsMain-all')")
	@ApiOperation(value = "fetch是主要工作经历的ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch是主要工作经历的ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchismain")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryIsMainByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchIsMain(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-IsMain-all')")
	@ApiOperation(value = "search是主要工作经历的ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search是主要工作经历的ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchismain")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryIsMainByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchIsMain(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch记录所属（管理员）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlssgly")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGLY(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search记录所属（管理员）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlssgly")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-ZIZHU-all')")
	@ApiOperation(value = "fetch记录所属(个人履历)ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch记录所属(个人履历)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchzizhu")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchZIZHU(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-ZIZHU-all')")
	@ApiOperation(value = "search记录所属(个人履历)ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search记录所属(个人履历)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchzizhu")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlss")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSS(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlss")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-FAZZSY-all')")
	@ApiOperation(value = "fetch非A转正使用ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch非A转正使用ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchfazzsy")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchFAZZSY(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-FAZZSY-all')")
	@ApiOperation(value = "search非A转正使用ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search非A转正使用ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchfazzsy")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPimPerson", tags = {"PimWorkHistory" } ,notes = "fetch记录所属（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimworkhistories/fetchjlssgr")
	public ResponseEntity<List<PimWorkHistoryDTO>> fetchPimWorkHistoryJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGR(context) ;
        List<PimWorkHistoryDTO> list = pimworkhistoryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkHistory-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPimPerson", tags = {"PimWorkHistory" } ,notes = "search记录所属（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimworkhistories/searchjlssgr")
	public ResponseEntity<Page<PimWorkHistoryDTO>> searchPimWorkHistoryJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimWorkHistorySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimWorkHistory> domains = pimworkhistoryService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

