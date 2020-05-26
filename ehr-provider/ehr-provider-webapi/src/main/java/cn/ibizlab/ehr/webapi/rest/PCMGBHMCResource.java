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
import cn.ibizlab.ehr.core.pcm.domain.PCMGBHMC;
import cn.ibizlab.ehr.core.pcm.service.IPCMGBHMCService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGBHMCSearchContext;

@Slf4j
@Api(tags = {"PCMGBHMC" })
@RestController("WebApi-pcmgbhmc")
@RequestMapping("")
public class PCMGBHMCResource {

    @Autowired
    private IPCMGBHMCService pcmgbhmcService;

    @Autowired
    @Lazy
    public PCMGBHMCMapping pcmgbhmcMapping;

    public PCMGBHMCDTO permissionDTO=new PCMGBHMCDTO();

    @PreAuthorize("hasPermission(#pcmgbhmc_id,'Remove',{'Sql',this.pcmgbhmcMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMGBHMC" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.remove(pcmgbhmc_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmgbhmcMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMGBHMC" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgbhmcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgbhmc_id,'Get',{'Sql',this.pcmgbhmcMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMGBHMC" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    public ResponseEntity<PCMGBHMCDTO> get(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id) {
        PCMGBHMC domain = pcmgbhmcService.get(pcmgbhmc_id);
        PCMGBHMCDTO dto = pcmgbhmcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-ToggleLeader-all')")
    @ApiOperation(value = "设置/取消为领导班子", tags = {"PCMGBHMC" },  notes = "设置/取消为领导班子")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/toggleleader")
    @Transactional
    public ResponseEntity<PCMGBHMCDTO> toggleLeader(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        PCMGBHMC pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.toggleLeader(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMGBHMC" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgbhmcs/getdraft")
    public ResponseEntity<PCMGBHMCDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcMapping.toDto(pcmgbhmcService.getDraft(new PCMGBHMC())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdto})")
    @ApiOperation(value = "Create", tags = {"PCMGBHMC" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs")
    @Transactional
    public ResponseEntity<PCMGBHMCDTO> create(@RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        PCMGBHMC domain = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
		pcmgbhmcService.create(domain);
        PCMGBHMCDTO dto = pcmgbhmcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMGBHMC" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGBHMCDTO> pcmgbhmcdtos) {
        pcmgbhmcService.createBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgbhmc_id,'Update',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdto})")
    @ApiOperation(value = "Update", tags = {"PCMGBHMC" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    @Transactional
    public ResponseEntity<PCMGBHMCDTO> update(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PCMGBHMCDTO pcmgbhmcdto) {
		PCMGBHMC domain  = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        domain .setPimpersonid(pcmgbhmc_id);
		pcmgbhmcService.update(domain );
		PCMGBHMCDTO dto = pcmgbhmcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMGBHMC" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGBHMCDTO> pcmgbhmcdtos) {
        pcmgbhmcService.updateBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdto})")
    @ApiOperation(value = "Save", tags = {"PCMGBHMC" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.save(pcmgbhmcMapping.toDomain(pcmgbhmcdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmgbhmcMapping,#pcmgbhmcdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMGBHMC" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGBHMCDTO> pcmgbhmcdtos) {
        pcmgbhmcService.saveBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-SGTG-all')")
    @ApiOperation(value = "试岗通过", tags = {"PCMGBHMC" },  notes = "试岗通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/sgtg")
    @Transactional
    public ResponseEntity<PCMGBHMCDTO> sGTG(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        PCMGBHMC pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.sGTG(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMGBHMC" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.checkKey(pcmgbhmcMapping.toDomain(pcmgbhmcdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-SGBTG-all')")
    @ApiOperation(value = "试岗不通过", tags = {"PCMGBHMC" },  notes = "试岗不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/sgbtg")
    @Transactional
    public ResponseEntity<PCMGBHMCDTO> sGBTG(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PCMGBHMCDTO pcmgbhmcdto) {
        PCMGBHMC pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.sGBTG(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-GBHMCNewTree-all')")
	@ApiOperation(value = "fetch树视图的干部花名册（新）", tags = {"PCMGBHMC" } ,notes = "fetch树视图的干部花名册（新）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchgbhmcnewtree")
	public ResponseEntity<List<PCMGBHMCDTO>> fetchGBHMCNewTree(PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchGBHMCNewTree(context) ;
        List<PCMGBHMCDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-GBHMCNewTree-all')")
	@ApiOperation(value = "search树视图的干部花名册（新）", tags = {"PCMGBHMC" } ,notes = "search树视图的干部花名册（新）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchgbhmcnewtree")
	public ResponseEntity<Page<PCMGBHMCDTO>> searchGBHMCNewTree(@RequestBody PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchGBHMCNewTree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-GBHMCTree-all')")
	@ApiOperation(value = "fetch树视图的干部花名册", tags = {"PCMGBHMC" } ,notes = "fetch树视图的干部花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchgbhmctree")
	public ResponseEntity<List<PCMGBHMCDTO>> fetchGBHMCTree(PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchGBHMCTree(context) ;
        List<PCMGBHMCDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-GBHMCTree-all')")
	@ApiOperation(value = "search树视图的干部花名册", tags = {"PCMGBHMC" } ,notes = "search树视图的干部花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchgbhmctree")
	public ResponseEntity<Page<PCMGBHMCDTO>> searchGBHMCTree(@RequestBody PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchGBHMCTree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMGBHMC" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchdefault")
	public ResponseEntity<List<PCMGBHMCDTO>> fetchDefault(PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchDefault(context) ;
        List<PCMGBHMCDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMGBHMC" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchdefault")
	public ResponseEntity<Page<PCMGBHMCDTO>> searchDefault(@RequestBody PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-ZJPD-all')")
	@ApiOperation(value = "fetchZJPD", tags = {"PCMGBHMC" } ,notes = "fetchZJPD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchzjpd")
	public ResponseEntity<List<PCMGBHMCDTO>> fetchZJPD(PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchZJPD(context) ;
        List<PCMGBHMCDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGBHMC-ZJPD-all')")
	@ApiOperation(value = "searchZJPD", tags = {"PCMGBHMC" } ,notes = "searchZJPD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchzjpd")
	public ResponseEntity<Page<PCMGBHMCDTO>> searchZJPD(@RequestBody PCMGBHMCSearchContext context) {
        Page<PCMGBHMC> domains = pcmgbhmcService.searchZJPD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
