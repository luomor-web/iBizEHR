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
import cn.ibizlab.ehr.core.common.domain.MsgSendQueueHis;
import cn.ibizlab.ehr.core.common.service.IMsgSendQueueHisService;
import cn.ibizlab.ehr.core.common.filter.MsgSendQueueHisSearchContext;




@Slf4j
@Api(tags = {"MsgSendQueueHis" })
@RestController("WebApi-msgsendqueuehis")
@RequestMapping("")
public class MsgSendQueueHisResource {

    @Autowired
    private IMsgSendQueueHisService msgsendqueuehisService;

    @Autowired
    @Lazy
    public MsgSendQueueHisMapping msgsendqueuehisMapping;

    public MsgSendQueueHisDTO permissionDTO=new MsgSendQueueHisDTO();




    @PreAuthorize("hasPermission(#msgsendqueuehis_id,'Remove',{'Sql',this.msgsendqueuehisMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"MsgSendQueueHis" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgsendqueuehis/{msgsendqueuehis_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("msgsendqueuehis_id") String msgsendqueuehis_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgsendqueuehisService.remove(msgsendqueuehis_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"MsgSendQueueHis" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgsendqueuehis/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgsendqueuehisService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueueHis-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"MsgSendQueueHis" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/msgsendqueuehis/getdraft")
    public ResponseEntity<MsgSendQueueHisDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(msgsendqueuehisMapping.toDto(msgsendqueuehisService.getDraft(new MsgSendQueueHis())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueueHis-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"MsgSendQueueHis" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueuehis/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgSendQueueHisDTO msgsendqueuehisdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgsendqueuehisService.checkKey(msgsendqueuehisMapping.toDomain(msgsendqueuehisdto)));
    }




    @PreAuthorize("hasPermission(#msgsendqueuehis_id,'Update',{'Sql',this.msgsendqueuehisMapping,#msgsendqueuehisdto})")
    @ApiOperation(value = "Update", tags = {"MsgSendQueueHis" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgsendqueuehis/{msgsendqueuehis_id}")
    @Transactional
    public ResponseEntity<MsgSendQueueHisDTO> update(@PathVariable("msgsendqueuehis_id") String msgsendqueuehis_id, @RequestBody MsgSendQueueHisDTO msgsendqueuehisdto) {
		MsgSendQueueHis domain = msgsendqueuehisMapping.toDomain(msgsendqueuehisdto);
        domain.setMsgsendqueuehisid(msgsendqueuehis_id);
		msgsendqueuehisService.update(domain);
		MsgSendQueueHisDTO dto = msgsendqueuehisMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"MsgSendQueueHis" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgsendqueuehis/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgSendQueueHisDTO> msgsendqueuehisdtos) {
        msgsendqueuehisService.updateBatch(msgsendqueuehisMapping.toDomain(msgsendqueuehisdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#msgsendqueuehis_id,'Get',{'Sql',this.msgsendqueuehisMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"MsgSendQueueHis" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/msgsendqueuehis/{msgsendqueuehis_id}")
    public ResponseEntity<MsgSendQueueHisDTO> get(@PathVariable("msgsendqueuehis_id") String msgsendqueuehis_id) {
        MsgSendQueueHis domain = msgsendqueuehisService.get(msgsendqueuehis_id);
        MsgSendQueueHisDTO dto = msgsendqueuehisMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueueHis-Save-all')")
    @ApiOperation(value = "Save", tags = {"MsgSendQueueHis" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueuehis/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgSendQueueHisDTO msgsendqueuehisdto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgsendqueuehisService.save(msgsendqueuehisMapping.toDomain(msgsendqueuehisdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"MsgSendQueueHis" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueuehis/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgSendQueueHisDTO> msgsendqueuehisdtos) {
        msgsendqueuehisService.saveBatch(msgsendqueuehisMapping.toDomain(msgsendqueuehisdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.msgsendqueuehisMapping,#msgsendqueuehisdto})")
    @ApiOperation(value = "Create", tags = {"MsgSendQueueHis" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueuehis")
    @Transactional
    public ResponseEntity<MsgSendQueueHisDTO> create(@RequestBody MsgSendQueueHisDTO msgsendqueuehisdto) {
        MsgSendQueueHis domain = msgsendqueuehisMapping.toDomain(msgsendqueuehisdto);
		msgsendqueuehisService.create(domain);
        MsgSendQueueHisDTO dto = msgsendqueuehisMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"MsgSendQueueHis" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgsendqueuehis/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgSendQueueHisDTO> msgsendqueuehisdtos) {
        msgsendqueuehisService.createBatch(msgsendqueuehisMapping.toDomain(msgsendqueuehisdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueueHis-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"MsgSendQueueHis" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgsendqueuehis/fetchdefault")
	public ResponseEntity<List<MsgSendQueueHisDTO>> fetchDefault(MsgSendQueueHisSearchContext context) {
        Page<MsgSendQueueHis> domains = msgsendqueuehisService.searchDefault(context) ;
        List<MsgSendQueueHisDTO> list = msgsendqueuehisMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgSendQueueHis-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"MsgSendQueueHis" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgsendqueuehis/searchdefault")
	public ResponseEntity<Page<MsgSendQueueHisDTO>> searchDefault(@RequestBody MsgSendQueueHisSearchContext context) {
        Page<MsgSendQueueHis> domains = msgsendqueuehisService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgsendqueuehisMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


