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
import cn.ibizlab.ehr.core.pim.domain.PimSearchFieldSet;
import cn.ibizlab.ehr.core.pim.service.IPimSearchFieldSetService;
import cn.ibizlab.ehr.core.pim.filter.PimSearchFieldSetSearchContext;




@Slf4j
@Api(tags = {"PimSearchFieldSet" })
@RestController("WebApi-pimsearchfieldset")
@RequestMapping("")
public class PimSearchFieldSetResource {

    @Autowired
    private IPimSearchFieldSetService pimsearchfieldsetService;

    @Autowired
    @Lazy
    public PimSearchFieldSetMapping pimsearchfieldsetMapping;

    public PimSearchFieldSetDTO permissionDTO=new PimSearchFieldSetDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-InitDictionary-all')")
    @ApiOperation(value = "生成字典", tags = {"PimSearchFieldSet" },  notes = "生成字典")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/{pimsearchfieldset_id}/initdictionary")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> initDictionary(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id, @RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        PimSearchFieldSet pimsearchfieldset = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
        pimsearchfieldset = pimsearchfieldsetService.initDictionary(pimsearchfieldset);
        pimsearchfieldsetdto = pimsearchfieldsetMapping.toDto(pimsearchfieldset);
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-Save-all')")
    @ApiOperation(value = "Save", tags = {"PimSearchFieldSet" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/save")
    public ResponseEntity<Boolean> save(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.save(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PimSearchFieldSet" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.saveBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimsearchfieldset_id,'Update',{'Sql',this.pimsearchfieldsetMapping,#pimsearchfieldsetdto})")
    @ApiOperation(value = "Update", tags = {"PimSearchFieldSet" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> update(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id, @RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
		PimSearchFieldSet domain = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
        domain.setPimsearchfieldsetid(pimsearchfieldset_id);
		pimsearchfieldsetService.update(domain);
		PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PimSearchFieldSet" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.updateBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PimSearchFieldSet" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchfieldsets/getdraft")
    public ResponseEntity<PimSearchFieldSetDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetMapping.toDto(pimsearchfieldsetService.getDraft(new PimSearchFieldSet())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PimSearchFieldSet" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.checkKey(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto)));
    }




    @PreAuthorize("hasPermission(#pimsearchfieldset_id,'Remove',{'Sql',this.pimsearchfieldsetMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PimSearchFieldSet" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.remove(pimsearchfieldset_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PimSearchFieldSet" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsearchfieldsetService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimsearchfieldset_id,'Get',{'Sql',this.pimsearchfieldsetMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PimSearchFieldSet" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    public ResponseEntity<PimSearchFieldSetDTO> get(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id) {
        PimSearchFieldSet domain = pimsearchfieldsetService.get(pimsearchfieldset_id);
        PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimsearchfieldsetMapping,#pimsearchfieldsetdto})")
    @ApiOperation(value = "Create", tags = {"PimSearchFieldSet" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> create(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        PimSearchFieldSet domain = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
		pimsearchfieldsetService.create(domain);
        PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PimSearchFieldSet" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.createBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-AllDATA-all')")
	@ApiOperation(value = "fetch全部数据", tags = {"PimSearchFieldSet" } ,notes = "fetch全部数据")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchfieldsets/fetchalldata")
	public ResponseEntity<List<PimSearchFieldSetDTO>> fetchAllDATA(PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchAllDATA(context) ;
        List<PimSearchFieldSetDTO> list = pimsearchfieldsetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-AllDATA-all')")
	@ApiOperation(value = "search全部数据", tags = {"PimSearchFieldSet" } ,notes = "search全部数据")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchfieldsets/searchalldata")
	public ResponseEntity<Page<PimSearchFieldSetDTO>> searchAllDATA(@RequestBody PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchAllDATA(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchfieldsetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimSearchFieldSet" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchfieldsets/fetchdefault")
	public ResponseEntity<List<PimSearchFieldSetDTO>> fetchDefault(PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchDefault(context) ;
        List<PimSearchFieldSetDTO> list = pimsearchfieldsetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimSearchFieldSet" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchfieldsets/searchdefault")
	public ResponseEntity<Page<PimSearchFieldSetDTO>> searchDefault(@RequestBody PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchfieldsetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


