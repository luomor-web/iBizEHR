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
import cn.ibizlab.ehr.core.pim.domain.PIMPERSONCHANGE;
import cn.ibizlab.ehr.core.pim.service.IPIMPERSONCHANGEService;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONCHANGESearchContext;

@Slf4j
@Api(tags = {"PIMPERSONCHANGE" })
@RestController("WebApi-pimpersonchange")
@RequestMapping("")
public class PIMPERSONCHANGEResource {

    @Autowired
    private IPIMPERSONCHANGEService pimpersonchangeService;

    @Autowired
    @Lazy
    public PIMPERSONCHANGEMapping pimpersonchangeMapping;

    public PIMPERSONCHANGEDTO permissionDTO=new PIMPERSONCHANGEDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "Save", tags = {"PIMPERSONCHANGE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.save(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPERSONCHANGE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        pimpersonchangeService.saveBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-BH-all')")
    @ApiOperation(value = "驳回", tags = {"PIMPERSONCHANGE" },  notes = "驳回")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/bh")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> bH(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange = pimpersonchangeService.bH(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"PIMPERSONCHANGE" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/ensure")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> ensure(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange = pimpersonchangeService.ensure(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Update',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "Update", tags = {"PIMPERSONCHANGE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> update(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
		PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonchangeid(pimpersonchange_id);
		pimpersonchangeService.update(domain);
		PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPERSONCHANGE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        pimpersonchangeService.updateBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Get',{'Sql',this.pimpersonchangeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMPERSONCHANGE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonchanges/{pimpersonchange_id}")
    public ResponseEntity<PIMPERSONCHANGEDTO> get(@PathVariable("pimpersonchange_id") String pimpersonchange_id) {
        PIMPERSONCHANGE domain = pimpersonchangeService.get(pimpersonchange_id);
        PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "Create", tags = {"PIMPERSONCHANGE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> create(@RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
		pimpersonchangeService.create(domain);
        PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMPERSONCHANGE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        pimpersonchangeService.createBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Remove',{'Sql',this.pimpersonchangeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMPERSONCHANGE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonchange_id") String pimpersonchange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.remove(pimpersonchange_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPERSONCHANGE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonchangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-QR-all')")
    @ApiOperation(value = "确认", tags = {"PIMPERSONCHANGE" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/qr")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> qR(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange = pimpersonchangeService.qR(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMPERSONCHANGE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.checkKey(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMPERSONCHANGE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonchanges/getdraft")
    public ResponseEntity<PIMPERSONCHANGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeMapping.toDto(pimpersonchangeService.getDraft(new PIMPERSONCHANGE())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HistoryRec-all')")
	@ApiOperation(value = "fetch历史审批记录", tags = {"PIMPERSONCHANGE" } ,notes = "fetch历史审批记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchhistoryrec")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchHistoryRec(PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHistoryRec(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HistoryRec-all')")
	@ApiOperation(value = "search历史审批记录", tags = {"PIMPERSONCHANGE" } ,notes = "search历史审批记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchhistoryrec")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchHistoryRec(@RequestBody PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHistoryRec(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "fetchPIMCL_NOTAPPROVAL", tags = {"PIMPERSONCHANGE" } ,notes = "fetchPIMCL_NOTAPPROVAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchpimcl_notapproval")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchPIMCL_NOTAPPROVAL(PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "searchPIMCL_NOTAPPROVAL", tags = {"PIMPERSONCHANGE" } ,notes = "searchPIMCL_NOTAPPROVAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchpimcl_notapproval")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchPIMCL_NOTAPPROVAL(@RequestBody PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HeadRed-all')")
	@ApiOperation(value = "fetch总部记录", tags = {"PIMPERSONCHANGE" } ,notes = "fetch总部记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchheadred")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchHeadRed(PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHeadRed(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HeadRed-all')")
	@ApiOperation(value = "search总部记录", tags = {"PIMPERSONCHANGE" } ,notes = "search总部记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchheadred")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchHeadRed(@RequestBody PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHeadRed(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPERSONCHANGE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchdefault")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchDefault(PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchDefault(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPERSONCHANGE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchdefault")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchDefault(@RequestBody PIMPERSONCHANGESearchContext context) {
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        List<PIMPERSONCHANGE> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PIMPERSONCHANGE domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-BH-all')")
    @ApiOperation(value = "驳回ByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "驳回ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/bh")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> bHByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.bH(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Ensure-all')")
    @ApiOperation(value = "确认ByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "确认ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/ensure")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> ensureByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.ensure(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Update',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpersonchangeid(pimpersonchange_id);
		pimpersonchangeService.update(domain);
        PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        List<PIMPERSONCHANGE> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PIMPERSONCHANGE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Get',{'Sql',this.pimpersonchangeMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    public ResponseEntity<PIMPERSONCHANGEDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id) {
        PIMPERSONCHANGE domain = pimpersonchangeService.get(pimpersonchange_id);
        PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimpersonchangeMapping,#pimpersonchangedto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
		pimpersonchangeService.create(domain);
        PIMPERSONCHANGEDTO dto = pimpersonchangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPERSONCHANGEDTO> pimpersonchangedtos) {
        List<PIMPERSONCHANGE> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PIMPERSONCHANGE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonchange_id,'Remove',{'Sql',this.pimpersonchangeMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.remove(pimpersonchange_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimpersonchangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-QR-all')")
    @ApiOperation(value = "确认ByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "确认ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/qr")
    @Transactional
    public ResponseEntity<PIMPERSONCHANGEDTO> qRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        PIMPERSONCHANGE domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.qR(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGEDTO pimpersonchangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.checkKey(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMPERSONCHANGE" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonchanges/getdraft")
    public ResponseEntity<PIMPERSONCHANGEDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMPERSONCHANGE domain = new PIMPERSONCHANGE();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeMapping.toDto(pimpersonchangeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HistoryRec-all')")
	@ApiOperation(value = "fetch历史审批记录ByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "fetch历史审批记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchhistoryrec")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchPIMPERSONCHANGEHistoryRecByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHistoryRec(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HistoryRec-all')")
	@ApiOperation(value = "search历史审批记录ByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "search历史审批记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchhistoryrec")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchPIMPERSONCHANGEHistoryRecByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHistoryRec(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "fetchPIMCL_NOTAPPROVALByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "fetchPIMCL_NOTAPPROVALByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchpimcl_notapproval")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchPIMPERSONCHANGEPIMCL_NOTAPPROVALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "searchPIMCL_NOTAPPROVALByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "searchPIMCL_NOTAPPROVALByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchpimcl_notapproval")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchPIMPERSONCHANGEPIMCL_NOTAPPROVALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HeadRed-all')")
	@ApiOperation(value = "fetch总部记录ByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "fetch总部记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchheadred")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchPIMPERSONCHANGEHeadRedByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHeadRed(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-HeadRed-all')")
	@ApiOperation(value = "search总部记录ByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "search总部记录ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchheadred")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchPIMPERSONCHANGEHeadRedByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchHeadRed(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchdefault")
	public ResponseEntity<List<PIMPERSONCHANGEDTO>> fetchPIMPERSONCHANGEDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchDefault(context) ;
        List<PIMPERSONCHANGEDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPERSONCHANGE-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMPERSONCHANGE" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchdefault")
	public ResponseEntity<Page<PIMPERSONCHANGEDTO>> searchPIMPERSONCHANGEDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPERSONCHANGESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPERSONCHANGE> domains = pimpersonchangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
