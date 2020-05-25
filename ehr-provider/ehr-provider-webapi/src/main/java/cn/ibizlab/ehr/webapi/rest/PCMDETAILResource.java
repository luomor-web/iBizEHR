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
import cn.ibizlab.ehr.core.pim.domain.PCMDETAIL;
import cn.ibizlab.ehr.core.pim.service.IPCMDETAILService;
import cn.ibizlab.ehr.core.pim.filter.PCMDETAILSearchContext;

@Slf4j
@Api(tags = {"PCMDETAIL" })
@RestController("WebApi-pcmdetail")
@RequestMapping("")
public class PCMDETAILResource {

    @Autowired
    private IPCMDETAILService pcmdetailService;

    @Autowired
    @Lazy
    public PCMDETAILMapping pcmdetailMapping;

    public PCMDETAILDTO permissionDTO=new PCMDETAILDTO();

    @PreAuthorize("hasPermission(#pcmdetail_id,'Remove',{'Sql',this.pcmdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmdetails/{pcmdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmdetail_id") String pcmdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmdetailService.remove(pcmdetail_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmdetail_id,'Update',{'Sql',this.pcmdetailMapping,#pcmdetaildto})")
    @ApiOperation(value = "Update", tags = {"PCMDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmdetails/{pcmdetail_id}")
    @Transactional
    public ResponseEntity<PCMDETAILDTO> update(@PathVariable("pcmdetail_id") String pcmdetail_id, @RequestBody PCMDETAILDTO pcmdetaildto) {
		PCMDETAIL domain = pcmdetailMapping.toDomain(pcmdetaildto);
        domain.setPcmdetailid(pcmdetail_id);
		pcmdetailService.update(domain);
		PCMDETAILDTO dto = pcmdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMDETAILDTO> pcmdetaildtos) {
        pcmdetailService.updateBatch(pcmdetailMapping.toDomain(pcmdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmdetailMapping,#pcmdetaildto})")
    @ApiOperation(value = "Create", tags = {"PCMDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmdetails")
    @Transactional
    public ResponseEntity<PCMDETAILDTO> create(@RequestBody PCMDETAILDTO pcmdetaildto) {
        PCMDETAIL domain = pcmdetailMapping.toDomain(pcmdetaildto);
		pcmdetailService.create(domain);
        PCMDETAILDTO dto = pcmdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMDETAILDTO> pcmdetaildtos) {
        pcmdetailService.createBatch(pcmdetailMapping.toDomain(pcmdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDETAIL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMDETAILDTO pcmdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmdetailService.checkKey(pcmdetailMapping.toDomain(pcmdetaildto)));
    }

    @PreAuthorize("hasPermission(#pcmdetail_id,'Get',{'Sql',this.pcmdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmdetails/{pcmdetail_id}")
    public ResponseEntity<PCMDETAILDTO> get(@PathVariable("pcmdetail_id") String pcmdetail_id) {
        PCMDETAIL domain = pcmdetailService.get(pcmdetail_id);
        PCMDETAILDTO dto = pcmdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmdetailMapping,#pcmdetaildto})")
    @ApiOperation(value = "Save", tags = {"PCMDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMDETAILDTO pcmdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmdetailService.save(pcmdetailMapping.toDomain(pcmdetaildto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMDETAILDTO> pcmdetaildtos) {
        pcmdetailService.saveBatch(pcmdetailMapping.toDomain(pcmdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDETAIL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmdetails/getdraft")
    public ResponseEntity<PCMDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmdetailMapping.toDto(pcmdetailService.getDraft(new PCMDETAIL())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDETAIL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmdetails/fetchdefault")
	public ResponseEntity<List<PCMDETAILDTO>> fetchDefault(PCMDETAILSearchContext context) {
        Page<PCMDETAIL> domains = pcmdetailService.searchDefault(context) ;
        List<PCMDETAILDTO> list = pcmdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDETAIL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmdetails/searchdefault")
	public ResponseEntity<Page<PCMDETAILDTO>> searchDefault(@RequestBody PCMDETAILSearchContext context) {
        Page<PCMDETAIL> domains = pcmdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
