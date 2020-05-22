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
import cn.ibizlab.ehr.core.common.domain.MsgSendQueue;
import cn.ibizlab.ehr.core.common.service.IMsgSendQueueService;
import cn.ibizlab.ehr.core.common.filter.MsgSendQueueSearchContext;




@Slf4j
@Api(tags = {"MsgSendQueue" })
@RestController("WebApi-msgsendqueue")
@RequestMapping("")
public class MsgSendQueueResource {

    @Autowired
    private IMsgSendQueueService msgsendqueueService;

    @Autowired
    @Lazy
    public MsgSendQueueMapping msgsendqueueMapping;

    public MsgSendQueueDTO permissionDTO=new MsgSendQueueDTO();

    @PreAuthorize("hasPermission(#msgsendqueue_id,'Update',{'Sql',this.msgsendqueueMapping,#msgsendqueuedto})")
    @ApiOperation(value = "Update", tags = {"MsgSendQueue" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgsendqueues/{msgsendqueue_id}")
    @Transactional
    public ResponseEntity<MsgSendQueueDTO> update(@PathVariable("msgsendqueue_id") String msgsendqueue_id, @RequestBody MsgSendQueueDTO msgsendqueuedto) {
		MsgSendQueue domain = msgsendqueueMapping.toDomain(msgsendqueuedto);
        domain.setMsgsendqueueid(msgsendqueue_id);
		msgsendqueueService.update(domain);
		MsgSendQueueDTO dto = msgsendqueueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"MsgSendQueue" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgsendqueues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgSendQueueDTO> msgsendqueuedtos) {
        msgsendqueueService.updateBatch(msgsendqueueMapping.toDomain(msgsendqueuedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#msgsendqueue_id,'Remove',{'Sql',this.msgsendqueueMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"MsgSendQueue" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgsendqueues/{msgsendqueue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("msgsendqueue_id") String msgsendqueue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgsendqueueService.remove(msgsendqueue_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"MsgSendQueue" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgsendqueues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgsendqueueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueue-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"MsgSendQueue" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgSendQueueDTO msgsendqueuedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgsendqueueService.checkKey(msgsendqueueMapping.toDomain(msgsendqueuedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueue-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"MsgSendQueue" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/msgsendqueues/getdraft")
    public ResponseEntity<MsgSendQueueDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(msgsendqueueMapping.toDto(msgsendqueueService.getDraft(new MsgSendQueue())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.msgsendqueueMapping,#msgsendqueuedto})")
    @ApiOperation(value = "Create", tags = {"MsgSendQueue" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueues")
    @Transactional
    public ResponseEntity<MsgSendQueueDTO> create(@RequestBody MsgSendQueueDTO msgsendqueuedto) {
        MsgSendQueue domain = msgsendqueueMapping.toDomain(msgsendqueuedto);
		msgsendqueueService.create(domain);
        MsgSendQueueDTO dto = msgsendqueueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"MsgSendQueue" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgSendQueueDTO> msgsendqueuedtos) {
        msgsendqueueService.createBatch(msgsendqueueMapping.toDomain(msgsendqueuedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#msgsendqueue_id,'Get',{'Sql',this.msgsendqueueMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"MsgSendQueue" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/msgsendqueues/{msgsendqueue_id}")
    public ResponseEntity<MsgSendQueueDTO> get(@PathVariable("msgsendqueue_id") String msgsendqueue_id) {
        MsgSendQueue domain = msgsendqueueService.get(msgsendqueue_id);
        MsgSendQueueDTO dto = msgsendqueueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueue-Save-all')")
    @ApiOperation(value = "Save", tags = {"MsgSendQueue" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueues/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgSendQueueDTO msgsendqueuedto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgsendqueueService.save(msgsendqueueMapping.toDomain(msgsendqueuedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"MsgSendQueue" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgSendQueueDTO> msgsendqueuedtos) {
        msgsendqueueService.saveBatch(msgsendqueueMapping.toDomain(msgsendqueuedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueue-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"MsgSendQueue" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgsendqueues/fetchdefault")
	public ResponseEntity<List<MsgSendQueueDTO>> fetchDefault(MsgSendQueueSearchContext context) {
        Page<MsgSendQueue> domains = msgsendqueueService.searchDefault(context) ;
        List<MsgSendQueueDTO> list = msgsendqueueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueue-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"MsgSendQueue" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgsendqueues/searchdefault")
	public ResponseEntity<Page<MsgSendQueueDTO>> searchDefault(@RequestBody MsgSendQueueSearchContext context) {
        Page<MsgSendQueue> domains = msgsendqueueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgsendqueueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
