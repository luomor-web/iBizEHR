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
import cn.ibizlab.ehr.core.common.domain.OrgUnitCat;
import cn.ibizlab.ehr.core.common.service.IOrgUnitCatService;
import cn.ibizlab.ehr.core.common.filter.OrgUnitCatSearchContext;




@Slf4j
@Api(tags = {"OrgUnitCat" })
@RestController("WebApi-orgunitcat")
@RequestMapping("")
public class OrgUnitCatResource {

    @Autowired
    private IOrgUnitCatService orgunitcatService;

    @Autowired
    @Lazy
    public OrgUnitCatMapping orgunitcatMapping;

    public OrgUnitCatDTO permissionDTO=new OrgUnitCatDTO();




    @PreAuthorize("hasPermission(#orgunitcat_id,'Update',{'Sql',this.orgunitcatMapping,#orgunitcatdto})")
    @ApiOperation(value = "Update", tags = {"OrgUnitCat" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgunitcats/{orgunitcat_id}")
    @Transactional
    public ResponseEntity<OrgUnitCatDTO> update(@PathVariable("orgunitcat_id") String orgunitcat_id, @RequestBody OrgUnitCatDTO orgunitcatdto) {
		OrgUnitCat domain = orgunitcatMapping.toDomain(orgunitcatdto);
        domain.setOrgunitcatid(orgunitcat_id);
		orgunitcatService.update(domain);
		OrgUnitCatDTO dto = orgunitcatMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"OrgUnitCat" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgunitcats/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgUnitCatDTO> orgunitcatdtos) {
        orgunitcatService.updateBatch(orgunitcatMapping.toDomain(orgunitcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.orgunitcatMapping,#orgunitcatdto})")
    @ApiOperation(value = "Create", tags = {"OrgUnitCat" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgunitcats")
    @Transactional
    public ResponseEntity<OrgUnitCatDTO> create(@RequestBody OrgUnitCatDTO orgunitcatdto) {
        OrgUnitCat domain = orgunitcatMapping.toDomain(orgunitcatdto);
		orgunitcatService.create(domain);
        OrgUnitCatDTO dto = orgunitcatMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"OrgUnitCat" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgunitcats/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgUnitCatDTO> orgunitcatdtos) {
        orgunitcatService.createBatch(orgunitcatMapping.toDomain(orgunitcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orgunitcat_id,'Remove',{'Sql',this.orgunitcatMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgUnitCat" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgunitcats/{orgunitcat_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orgunitcat_id") String orgunitcat_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgunitcatService.remove(orgunitcat_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrgUnitCat" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgunitcats/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgunitcatService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUnitCat-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgUnitCat" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgunitcats/getdraft")
    public ResponseEntity<OrgUnitCatDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgunitcatMapping.toDto(orgunitcatService.getDraft(new OrgUnitCat())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUnitCat-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgUnitCat" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgunitcats/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgUnitCatDTO orgunitcatdto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgunitcatService.save(orgunitcatMapping.toDomain(orgunitcatdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrgUnitCat" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgunitcats/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgUnitCatDTO> orgunitcatdtos) {
        orgunitcatService.saveBatch(orgunitcatMapping.toDomain(orgunitcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUnitCat-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgUnitCat" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgunitcats/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgUnitCatDTO orgunitcatdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgunitcatService.checkKey(orgunitcatMapping.toDomain(orgunitcatdto)));
    }




    @PreAuthorize("hasPermission(#orgunitcat_id,'Get',{'Sql',this.orgunitcatMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgUnitCat" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgunitcats/{orgunitcat_id}")
    public ResponseEntity<OrgUnitCatDTO> get(@PathVariable("orgunitcat_id") String orgunitcat_id) {
        OrgUnitCat domain = orgunitcatService.get(orgunitcat_id);
        OrgUnitCatDTO dto = orgunitcatMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUnitCat-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgUnitCat" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgunitcats/fetchdefault")
	public ResponseEntity<List<OrgUnitCatDTO>> fetchDefault(OrgUnitCatSearchContext context) {
        Page<OrgUnitCat> domains = orgunitcatService.searchDefault(context) ;
        List<OrgUnitCatDTO> list = orgunitcatMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUnitCat-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgUnitCat" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgunitcats/searchdefault")
	public ResponseEntity<Page<OrgUnitCatDTO>> searchDefault(@RequestBody OrgUnitCatSearchContext context) {
        Page<OrgUnitCat> domains = orgunitcatService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgunitcatMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


