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
import cn.ibizlab.ehr.core.common.domain.OrgSecUserType;
import cn.ibizlab.ehr.core.common.service.IOrgSecUserTypeService;
import cn.ibizlab.ehr.core.common.filter.OrgSecUserTypeSearchContext;




@Slf4j
@Api(tags = {"OrgSecUserType" })
@RestController("WebApi-orgsecusertype")
@RequestMapping("")
public class OrgSecUserTypeResource {

    @Autowired
    private IOrgSecUserTypeService orgsecusertypeService;

    @Autowired
    @Lazy
    private OrgSecUserTypeMapping orgsecusertypeMapping;




    @PreAuthorize("hasPermission('Remove',{#orgsecusertype_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"OrgSecUserType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsecusertypes/{orgsecusertype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orgsecusertype_id") String orgsecusertype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgsecusertypeService.remove(orgsecusertype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrgSecUserType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsecusertypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgsecusertypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orgsecusertype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"OrgSecUserType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsecusertypes/{orgsecusertype_id}")
    @Transactional
    public ResponseEntity<OrgSecUserTypeDTO> update(@PathVariable("orgsecusertype_id") String orgsecusertype_id, @RequestBody OrgSecUserTypeDTO orgsecusertypedto) {
		OrgSecUserType domain = orgsecusertypeMapping.toDomain(orgsecusertypedto);
        domain.setOrgsecusertypeid(orgsecusertype_id);
		orgsecusertypeService.update(domain);
		OrgSecUserTypeDTO dto = orgsecusertypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#orgsecusertype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"OrgSecUserType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsecusertypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgSecUserTypeDTO> orgsecusertypedtos) {
        orgsecusertypeService.updateBatch(orgsecusertypeMapping.toDomain(orgsecusertypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"OrgSecUserType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusertypes/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgSecUserTypeDTO orgsecusertypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgsecusertypeService.save(orgsecusertypeMapping.toDomain(orgsecusertypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrgSecUserType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusertypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgSecUserTypeDTO> orgsecusertypedtos) {
        orgsecusertypeService.saveBatch(orgsecusertypeMapping.toDomain(orgsecusertypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"OrgSecUserType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusertypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgSecUserTypeDTO orgsecusertypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgsecusertypeService.checkKey(orgsecusertypeMapping.toDomain(orgsecusertypedto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"OrgSecUserType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsecusertypes/getdraft")
    public ResponseEntity<OrgSecUserTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgsecusertypeMapping.toDto(orgsecusertypeService.getDraft(new OrgSecUserType())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"OrgSecUserType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusertypes")
    @Transactional
    public ResponseEntity<OrgSecUserTypeDTO> create(@RequestBody OrgSecUserTypeDTO orgsecusertypedto) {
        OrgSecUserType domain = orgsecusertypeMapping.toDomain(orgsecusertypedto);
		orgsecusertypeService.create(domain);
        OrgSecUserTypeDTO dto = orgsecusertypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"OrgSecUserType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusertypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgSecUserTypeDTO> orgsecusertypedtos) {
        orgsecusertypeService.createBatch(orgsecusertypeMapping.toDomain(orgsecusertypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orgsecusertype_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"OrgSecUserType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsecusertypes/{orgsecusertype_id}")
    public ResponseEntity<OrgSecUserTypeDTO> get(@PathVariable("orgsecusertype_id") String orgsecusertype_id) {
        OrgSecUserType domain = orgsecusertypeService.get(orgsecusertype_id);
        OrgSecUserTypeDTO dto = orgsecusertypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgSecUserType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgsecusertypes/fetchdefault")
	public ResponseEntity<List<OrgSecUserTypeDTO>> fetchDefault(OrgSecUserTypeSearchContext context) {
        Page<OrgSecUserType> domains = orgsecusertypeService.searchDefault(context) ;
        List<OrgSecUserTypeDTO> list = orgsecusertypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"OrgSecUserType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgsecusertypes/searchdefault")
	public ResponseEntity<Page<OrgSecUserTypeDTO>> searchDefault(@RequestBody OrgSecUserTypeSearchContext context) {
        Page<OrgSecUserType> domains = orgsecusertypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsecusertypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public OrgSecUserType getEntity(){
        return new OrgSecUserType();
    }

}
