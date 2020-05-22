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
import cn.ibizlab.ehr.core.common.domain.UniRes;
import cn.ibizlab.ehr.core.common.service.IUniResService;
import cn.ibizlab.ehr.core.common.filter.UniResSearchContext;




@Slf4j
@Api(tags = {"UniRes" })
@RestController("WebApi-unires")
@RequestMapping("")
public class UniResResource {

    @Autowired
    private IUniResService uniresService;

    @Autowired
    @Lazy
    public UniResMapping uniresMapping;

    public UniResDTO permissionDTO=new UniResDTO();

    @PreAuthorize("hasPermission(#unires_id,'Update',{'Sql',this.uniresMapping,#uniresdto})")
    @ApiOperation(value = "Update", tags = {"UniRes" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/unires/{unires_id}")
    @Transactional
    public ResponseEntity<UniResDTO> update(@PathVariable("unires_id") String unires_id, @RequestBody UniResDTO uniresdto) {
		UniRes domain = uniresMapping.toDomain(uniresdto);
        domain.setUniresid(unires_id);
		uniresService.update(domain);
		UniResDTO dto = uniresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UniRes" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/unires/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UniResDTO> uniresdtos) {
        uniresService.updateBatch(uniresMapping.toDomain(uniresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UniRes-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UniRes" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/unires/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UniResDTO uniresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(uniresService.checkKey(uniresMapping.toDomain(uniresdto)));
    }

    @PreAuthorize("hasPermission(#unires_id,'Get',{'Sql',this.uniresMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UniRes" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/unires/{unires_id}")
    public ResponseEntity<UniResDTO> get(@PathVariable("unires_id") String unires_id) {
        UniRes domain = uniresService.get(unires_id);
        UniResDTO dto = uniresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UniRes-Save-all')")
    @ApiOperation(value = "Save", tags = {"UniRes" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/unires/save")
    public ResponseEntity<Boolean> save(@RequestBody UniResDTO uniresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(uniresService.save(uniresMapping.toDomain(uniresdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UniRes" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/unires/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UniResDTO> uniresdtos) {
        uniresService.saveBatch(uniresMapping.toDomain(uniresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UniRes-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UniRes" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/unires/getdraft")
    public ResponseEntity<UniResDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(uniresMapping.toDto(uniresService.getDraft(new UniRes())));
    }

    @PreAuthorize("hasPermission(#unires_id,'Remove',{'Sql',this.uniresMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UniRes" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unires/{unires_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("unires_id") String unires_id) {
         return ResponseEntity.status(HttpStatus.OK).body(uniresService.remove(unires_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UniRes" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unires/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        uniresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.uniresMapping,#uniresdto})")
    @ApiOperation(value = "Create", tags = {"UniRes" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/unires")
    @Transactional
    public ResponseEntity<UniResDTO> create(@RequestBody UniResDTO uniresdto) {
        UniRes domain = uniresMapping.toDomain(uniresdto);
		uniresService.create(domain);
        UniResDTO dto = uniresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UniRes" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/unires/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UniResDTO> uniresdtos) {
        uniresService.createBatch(uniresMapping.toDomain(uniresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UniRes-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UniRes" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/unires/fetchdefault")
	public ResponseEntity<List<UniResDTO>> fetchDefault(UniResSearchContext context) {
        Page<UniRes> domains = uniresService.searchDefault(context) ;
        List<UniResDTO> list = uniresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UniRes-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UniRes" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/unires/searchdefault")
	public ResponseEntity<Page<UniResDTO>> searchDefault(@RequestBody UniResSearchContext context) {
        Page<UniRes> domains = uniresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(uniresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
