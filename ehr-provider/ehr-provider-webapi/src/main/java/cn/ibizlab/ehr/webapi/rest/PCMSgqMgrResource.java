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
import cn.ibizlab.ehr.core.pcm.domain.PCMSgqMgr;
import cn.ibizlab.ehr.core.pcm.service.IPCMSgqMgrService;
import cn.ibizlab.ehr.core.pcm.filter.PCMSgqMgrSearchContext;




@Slf4j
@Api(tags = {"PCMSgqMgr" })
@RestController("WebApi-pcmsgqmgr")
@RequestMapping("")
public class PCMSgqMgrResource {

    @Autowired
    private IPCMSgqMgrService pcmsgqmgrService;

    @Autowired
    @Lazy
    public PCMSgqMgrMapping pcmsgqmgrMapping;

    public PCMSgqMgrDTO permissionDTO=new PCMSgqMgrDTO();

    @PreAuthorize("hasPermission(#pcmsgqmgr_id,'Remove',{'Sql',this.pcmsgqmgrMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMSgqMgr" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.remove(pcmsgqmgr_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMSgqMgr" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmsgqmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-SGTG-all')")
    @ApiOperation(value = "试岗通过", tags = {"PCMSgqMgr" },  notes = "试岗通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/{pcmsgqmgr_id}/sgtg")
    @Transactional
    public ResponseEntity<PCMSgqMgrDTO> sGTG(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
        PCMSgqMgr pcmsgqmgr = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        pcmsgqmgr = pcmsgqmgrService.sGTG(pcmsgqmgr);
        pcmsgqmgrdto = pcmsgqmgrMapping.toDto(pcmsgqmgr);
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrdto);
    }

    @PreAuthorize("hasPermission(#pcmsgqmgr_id,'Get',{'Sql',this.pcmsgqmgrMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMSgqMgr" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    public ResponseEntity<PCMSgqMgrDTO> get(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id) {
        PCMSgqMgr domain = pcmsgqmgrService.get(pcmsgqmgr_id);
        PCMSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-SGBTG-all')")
    @ApiOperation(value = "试岗不通过", tags = {"PCMSgqMgr" },  notes = "试岗不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/{pcmsgqmgr_id}/sgbtg")
    @Transactional
    public ResponseEntity<PCMSgqMgrDTO> sGBTG(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
        PCMSgqMgr pcmsgqmgr = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        pcmsgqmgr = pcmsgqmgrService.sGBTG(pcmsgqmgr);
        pcmsgqmgrdto = pcmsgqmgrMapping.toDto(pcmsgqmgr);
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMSgqMgr" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.checkKey(pcmsgqmgrMapping.toDomain(pcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission(#pcmsgqmgr_id,'Update',{'Sql',this.pcmsgqmgrMapping,#pcmsgqmgrdto})")
    @ApiOperation(value = "Update", tags = {"PCMSgqMgr" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<PCMSgqMgrDTO> update(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
		PCMSgqMgr domain = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        domain.setPcmsgqmgrid(pcmsgqmgr_id);
		pcmsgqmgrService.update(domain);
		PCMSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMSgqMgr" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.updateBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmsgqmgrMapping,#pcmsgqmgrdto})")
    @ApiOperation(value = "Create", tags = {"PCMSgqMgr" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs")
    @Transactional
    public ResponseEntity<PCMSgqMgrDTO> create(@RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
        PCMSgqMgr domain = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
		pcmsgqmgrService.create(domain);
        PCMSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMSgqMgr" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.createBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMSgqMgr" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMSgqMgrDTO pcmsgqmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.save(pcmsgqmgrMapping.toDomain(pcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMSgqMgr" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.saveBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMSgqMgr" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsgqmgrs/getdraft")
    public ResponseEntity<PCMSgqMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrMapping.toDto(pcmsgqmgrService.getDraft(new PCMSgqMgr())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMSgqMgr" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmsgqmgrs/fetchdefault")
	public ResponseEntity<List<PCMSgqMgrDTO>> fetchDefault(PCMSgqMgrSearchContext context) {
        Page<PCMSgqMgr> domains = pcmsgqmgrService.searchDefault(context) ;
        List<PCMSgqMgrDTO> list = pcmsgqmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSgqMgr-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMSgqMgr" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmsgqmgrs/searchdefault")
	public ResponseEntity<Page<PCMSgqMgrDTO>> searchDefault(@RequestBody PCMSgqMgrSearchContext context) {
        Page<PCMSgqMgr> domains = pcmsgqmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmsgqmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
