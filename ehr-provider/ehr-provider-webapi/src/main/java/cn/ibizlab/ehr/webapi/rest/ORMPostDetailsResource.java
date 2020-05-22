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
import cn.ibizlab.ehr.core.orm.domain.ORMPostDetails;
import cn.ibizlab.ehr.core.orm.service.IORMPostDetailsService;
import cn.ibizlab.ehr.core.orm.filter.ORMPostDetailsSearchContext;




@Slf4j
@Api(tags = {"ORMPostDetails" })
@RestController("WebApi-ormpostdetails")
@RequestMapping("")
public class ORMPostDetailsResource {

    @Autowired
    private IORMPostDetailsService ormpostdetailsService;

    @Autowired
    @Lazy
    public ORMPostDetailsMapping ormpostdetailsMapping;

    public ORMPostDetailsDTO permissionDTO=new ORMPostDetailsDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "Create", tags = {"ORMPostDetails" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> create(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
		ormpostdetailsService.create(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMPostDetails" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.createBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Get',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMPostDetails" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<ORMPostDetailsDTO> get(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        ORMPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMPostDetails" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "Update", tags = {"ORMPostDetails" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> update(@PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
		ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
		ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMPostDetails" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.updateBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMPostDetails" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/getdraft")
    public ResponseEntity<ORMPostDetailsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(new ORMPostDetails())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMPostDetails" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMPostDetails" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.saveBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMPostDetails" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMPostDetails" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMPostDetails" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostdetails/fetchdefault")
	public ResponseEntity<List<ORMPostDetailsDTO>> fetchDefault(ORMPostDetailsSearchContext context) {
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<ORMPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMPostDetails" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostdetails/searchdefault")
	public ResponseEntity<Page<ORMPostDetailsDTO>> searchDefault(@RequestBody ORMPostDetailsSearchContext context) {
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
