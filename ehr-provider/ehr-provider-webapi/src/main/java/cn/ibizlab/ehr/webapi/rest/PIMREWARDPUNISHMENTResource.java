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
import cn.ibizlab.ehr.core.pim.domain.PIMREWARDPUNISHMENT;
import cn.ibizlab.ehr.core.pim.service.IPIMREWARDPUNISHMENTService;
import cn.ibizlab.ehr.core.pim.filter.PIMREWARDPUNISHMENTSearchContext;

@Slf4j
@Api(tags = {"PIMREWARDPUNISHMENT" })
@RestController("WebApi-pimrewardpunishment")
@RequestMapping("")
public class PIMREWARDPUNISHMENTResource {

    @Autowired
    public IPIMREWARDPUNISHMENTService pimrewardpunishmentService;

    @Autowired
    @Lazy
    public PIMREWARDPUNISHMENTMapping pimrewardpunishmentMapping;

    @ApiOperation(value = "CheckKey", tags = {"PIMREWARDPUNISHMENT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.checkKey(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PostAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(returnObject.body),'ehr-PIMREWARDPUNISHMENT-Get')")
    @ApiOperation(value = "Get", tags = {"PIMREWARDPUNISHMENT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> get(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentService.get(pimrewardpunishment_id);
        PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PIMREWARDPUNISHMENT-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMREWARDPUNISHMENT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.remove(pimrewardpunishment_id));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByIds(#ids),'ehr-PIMREWARDPUNISHMENT-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMREWARDPUNISHMENT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimrewardpunishmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PIMREWARDPUNISHMENT-Save')")
    @ApiOperation(value = "Save", tags = {"PIMREWARDPUNISHMENT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.save(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PIMREWARDPUNISHMENT-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMREWARDPUNISHMENT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.saveBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMREWARDPUNISHMENT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimrewardpunishments/getdraft")
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentMapping.toDto(pimrewardpunishmentService.getDraft(new PIMREWARDPUNISHMENT())));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PIMREWARDPUNISHMENT-Create')")
    @ApiOperation(value = "Create", tags = {"PIMREWARDPUNISHMENT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments")
    @Transactional
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> create(@RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
		pimrewardpunishmentService.create(domain);
        PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PIMREWARDPUNISHMENT-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMREWARDPUNISHMENT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.createBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PIMREWARDPUNISHMENT-Update')")
    @ApiOperation(value = "Update", tags = {"PIMREWARDPUNISHMENT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> update(@PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id, @RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
		PIMREWARDPUNISHMENT domain  = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain .setPimrewardpunishmentid(pimrewardpunishment_id);
		pimrewardpunishmentService.update(domain );
		PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByEntities(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos)),'ehr-PIMREWARDPUNISHMENT-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMREWARDPUNISHMENT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        pimrewardpunishmentService.updateBatch(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(奖惩信息)", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch自助(奖惩信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchzizhu")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchZIZHU(PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchZIZHU(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-ZIZHU-all')")
	@ApiOperation(value = "search自助(奖惩信息)", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search自助(奖惩信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchzizhu")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchZIZHU(@RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-HONORARY-all')")
	@ApiOperation(value = "fetch公司及以上荣誉", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch公司及以上荣誉")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchhonorary")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchHONORARY(PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchHONORARY(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-HONORARY-all')")
	@ApiOperation(value = "search公司及以上荣誉", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search公司及以上荣誉")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchhonorary")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchHONORARY(@RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchHONORARY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchdefault")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchDefault(PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchDefault(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMREWARDPUNISHMENT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchdefault")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchDefault(@RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimrewardpunishments/fetchjlss")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchJLSS(PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchJLSS(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimrewardpunishments/searchjlss")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchJLSS(@RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.checkKey(pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto)));
    }

    @PostAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(returnObject.body),'ehr-PIMREWARDPUNISHMENT-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentService.get(pimrewardpunishment_id);
        PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PIMREWARDPUNISHMENT-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.remove(pimrewardpunishment_id));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByIds(#ids),'ehr-PIMREWARDPUNISHMENT-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimrewardpunishmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PIMREWARDPUNISHMENT-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PIMREWARDPUNISHMENT-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        List<PIMREWARDPUNISHMENT> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PIMREWARDPUNISHMENT domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/getdraft")
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMREWARDPUNISHMENT domain = new PIMREWARDPUNISHMENT();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimrewardpunishmentMapping.toDto(pimrewardpunishmentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdto),'ehr-PIMREWARDPUNISHMENT-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments")
    @Transactional
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
		pimrewardpunishmentService.create(domain);
        PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos),'ehr-PIMREWARDPUNISHMENT-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        List<PIMREWARDPUNISHMENT> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PIMREWARDPUNISHMENT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.get(#pimrewardpunishment_id),'ehr-PIMREWARDPUNISHMENT-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/{pimrewardpunishment_id}")
    @Transactional
    public ResponseEntity<PIMREWARDPUNISHMENTDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimrewardpunishment_id") String pimrewardpunishment_id, @RequestBody PIMREWARDPUNISHMENTDTO pimrewardpunishmentdto) {
        PIMREWARDPUNISHMENT domain = pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimrewardpunishmentid(pimrewardpunishment_id);
		pimrewardpunishmentService.update(domain);
        PIMREWARDPUNISHMENTDTO dto = pimrewardpunishmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimrewardpunishmentService.getPimrewardpunishmentByEntities(this.pimrewardpunishmentMapping.toDomain(#pimrewardpunishmentdtos)),'ehr-PIMREWARDPUNISHMENT-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimrewardpunishments/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMREWARDPUNISHMENTDTO> pimrewardpunishmentdtos) {
        List<PIMREWARDPUNISHMENT> domainlist=pimrewardpunishmentMapping.toDomain(pimrewardpunishmentdtos);
        for(PIMREWARDPUNISHMENT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimrewardpunishmentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(奖惩信息)ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch自助(奖惩信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchzizhu")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchPIMREWARDPUNISHMENTZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchZIZHU(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-ZIZHU-all')")
	@ApiOperation(value = "search自助(奖惩信息)ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search自助(奖惩信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchzizhu")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchPIMREWARDPUNISHMENTZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-HONORARY-all')")
	@ApiOperation(value = "fetch公司及以上荣誉ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch公司及以上荣誉ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchhonorary")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchPIMREWARDPUNISHMENTHONORARYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchHONORARY(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-HONORARY-all')")
	@ApiOperation(value = "search公司及以上荣誉ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search公司及以上荣誉ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchhonorary")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchPIMREWARDPUNISHMENTHONORARYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchHONORARY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchdefault")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchPIMREWARDPUNISHMENTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchDefault(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchdefault")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchPIMREWARDPUNISHMENTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "fetch记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimrewardpunishments/fetchjlss")
	public ResponseEntity<List<PIMREWARDPUNISHMENTDTO>> fetchPIMREWARDPUNISHMENTJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchJLSS(context) ;
        List<PIMREWARDPUNISHMENTDTO> list = pimrewardpunishmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMREWARDPUNISHMENT-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPIMPERSON", tags = {"PIMREWARDPUNISHMENT" } ,notes = "search记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimrewardpunishments/searchjlss")
	public ResponseEntity<Page<PIMREWARDPUNISHMENTDTO>> searchPIMREWARDPUNISHMENTJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMREWARDPUNISHMENTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMREWARDPUNISHMENT> domains = pimrewardpunishmentService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimrewardpunishmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

