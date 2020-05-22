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
import cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ;
import cn.ibizlab.ehr.core.pim.service.IPIMBYYGZZSQService;
import cn.ibizlab.ehr.core.pim.filter.PIMBYYGZZSQSearchContext;




@Slf4j
@Api(tags = {"PIMBYYGZZSQ" })
@RestController("WebApi-pimbyygzzsq")
@RequestMapping("")
public class PIMBYYGZZSQResource {

    @Autowired
    private IPIMBYYGZZSQService pimbyygzzsqService;

    @Autowired
    @Lazy
    public PIMBYYGZZSQMapping pimbyygzzsqMapping;

    public PIMBYYGZZSQDTO permissionDTO=new PIMBYYGZZSQDTO();

    @PreAuthorize("hasPermission(#pimbyygzzsq_id,'Get',{'Sql',this.pimbyygzzsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMBYYGZZSQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    public ResponseEntity<PIMBYYGZZSQDTO> get(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PIMBYYGZZSQ domain = pimbyygzzsqService.get(pimbyygzzsq_id);
        PIMBYYGZZSQDTO dto = pimbyygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimbyygzzsq_id,'Update',{'Sql',this.pimbyygzzsqMapping,#pimbyygzzsqdto})")
    @ApiOperation(value = "Update", tags = {"PIMBYYGZZSQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    @Transactional
    public ResponseEntity<PIMBYYGZZSQDTO> update(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYYGZZSQDTO pimbyygzzsqdto) {
		PIMBYYGZZSQ domain = pimbyygzzsqMapping.toDomain(pimbyygzzsqdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
		pimbyygzzsqService.update(domain);
		PIMBYYGZZSQDTO dto = pimbyygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMBYYGZZSQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMBYYGZZSQDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.updateBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimbyygzzsq_id,'Remove',{'Sql',this.pimbyygzzsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMBYYGZZSQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.remove(pimbyygzzsq_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMBYYGZZSQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbyygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYYGZZSQ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMBYYGZZSQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMBYYGZZSQDTO pimbyygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.save(pimbyygzzsqMapping.toDomain(pimbyygzzsqdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMBYYGZZSQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMBYYGZZSQDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.saveBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYYGZZSQ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMBYYGZZSQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/getdraft")
    public ResponseEntity<PIMBYYGZZSQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqMapping.toDto(pimbyygzzsqService.getDraft(new PIMBYYGZZSQ())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimbyygzzsqMapping,#pimbyygzzsqdto})")
    @ApiOperation(value = "Create", tags = {"PIMBYYGZZSQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs")
    @Transactional
    public ResponseEntity<PIMBYYGZZSQDTO> create(@RequestBody PIMBYYGZZSQDTO pimbyygzzsqdto) {
        PIMBYYGZZSQ domain = pimbyygzzsqMapping.toDomain(pimbyygzzsqdto);
		pimbyygzzsqService.create(domain);
        PIMBYYGZZSQDTO dto = pimbyygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMBYYGZZSQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMBYYGZZSQDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.createBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYYGZZSQ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMBYYGZZSQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMBYYGZZSQDTO pimbyygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.checkKey(pimbyygzzsqMapping.toDomain(pimbyygzzsqdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYYGZZSQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMBYYGZZSQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/fetchdefault")
	public ResponseEntity<List<PIMBYYGZZSQDTO>> fetchDefault(PIMBYYGZZSQSearchContext context) {
        Page<PIMBYYGZZSQ> domains = pimbyygzzsqService.searchDefault(context) ;
        List<PIMBYYGZZSQDTO> list = pimbyygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYYGZZSQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMBYYGZZSQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/searchdefault")
	public ResponseEntity<Page<PIMBYYGZZSQDTO>> searchDefault(@RequestBody PIMBYYGZZSQSearchContext context) {
        Page<PIMBYYGZZSQ> domains = pimbyygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
