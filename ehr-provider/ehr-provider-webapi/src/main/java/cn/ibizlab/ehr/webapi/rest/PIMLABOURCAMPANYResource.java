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
import cn.ibizlab.ehr.core.pim.domain.PIMLABOURCAMPANY;
import cn.ibizlab.ehr.core.pim.service.IPIMLABOURCAMPANYService;
import cn.ibizlab.ehr.core.pim.filter.PIMLABOURCAMPANYSearchContext;

@Slf4j
@Api(tags = {"PIMLABOURCAMPANY" })
@RestController("WebApi-pimlabourcampany")
@RequestMapping("")
public class PIMLABOURCAMPANYResource {

    @Autowired
    private IPIMLABOURCAMPANYService pimlabourcampanyService;

    @Autowired
    @Lazy
    public PIMLABOURCAMPANYMapping pimlabourcampanyMapping;

    public PIMLABOURCAMPANYDTO permissionDTO=new PIMLABOURCAMPANYDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydto})")
    @ApiOperation(value = "Save", tags = {"PIMLABOURCAMPANY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMLABOURCAMPANYDTO pimlabourcampanydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.save(pimlabourcampanyMapping.toDomain(pimlabourcampanydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMLABOURCAMPANY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMLABOURCAMPANYDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.saveBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMLABOURCAMPANY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMLABOURCAMPANYDTO pimlabourcampanydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.checkKey(pimlabourcampanyMapping.toDomain(pimlabourcampanydto)));
    }

    @PreAuthorize("hasPermission(#pimlabourcampany_id,'Update',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydto})")
    @ApiOperation(value = "Update", tags = {"PIMLABOURCAMPANY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    @Transactional
    public ResponseEntity<PIMLABOURCAMPANYDTO> update(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id, @RequestBody PIMLABOURCAMPANYDTO pimlabourcampanydto) {
		PIMLABOURCAMPANY domain  = pimlabourcampanyMapping.toDomain(pimlabourcampanydto);
        domain .setPimlabourcampanyid(pimlabourcampany_id);
		pimlabourcampanyService.update(domain );
		PIMLABOURCAMPANYDTO dto = pimlabourcampanyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMLABOURCAMPANY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMLABOURCAMPANYDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.updateBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydto})")
    @ApiOperation(value = "Create", tags = {"PIMLABOURCAMPANY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies")
    @Transactional
    public ResponseEntity<PIMLABOURCAMPANYDTO> create(@RequestBody PIMLABOURCAMPANYDTO pimlabourcampanydto) {
        PIMLABOURCAMPANY domain = pimlabourcampanyMapping.toDomain(pimlabourcampanydto);
		pimlabourcampanyService.create(domain);
        PIMLABOURCAMPANYDTO dto = pimlabourcampanyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimlabourcampanyMapping,#pimlabourcampanydtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMLABOURCAMPANY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMLABOURCAMPANYDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.createBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimlabourcampany_id,'Remove',{'Sql',this.pimlabourcampanyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMLABOURCAMPANY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.remove(pimlabourcampany_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimlabourcampanyMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMLABOURCAMPANY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlabourcampanyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimlabourcampany_id,'Get',{'Sql',this.pimlabourcampanyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMLABOURCAMPANY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    public ResponseEntity<PIMLABOURCAMPANYDTO> get(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id) {
        PIMLABOURCAMPANY domain = pimlabourcampanyService.get(pimlabourcampany_id);
        PIMLABOURCAMPANYDTO dto = pimlabourcampanyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMLABOURCAMPANY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlabourcampanies/getdraft")
    public ResponseEntity<PIMLABOURCAMPANYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyMapping.toDto(pimlabourcampanyService.getDraft(new PIMLABOURCAMPANY())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-AuthLab-all')")
	@ApiOperation(value = "fetchAuthLab", tags = {"PIMLABOURCAMPANY" } ,notes = "fetchAuthLab")
    @RequestMapping(method= RequestMethod.GET , value="/pimlabourcampanies/fetchauthlab")
	public ResponseEntity<List<PIMLABOURCAMPANYDTO>> fetchAuthLab(PIMLABOURCAMPANYSearchContext context) {
        Page<PIMLABOURCAMPANY> domains = pimlabourcampanyService.searchAuthLab(context) ;
        List<PIMLABOURCAMPANYDTO> list = pimlabourcampanyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-AuthLab-all')")
	@ApiOperation(value = "searchAuthLab", tags = {"PIMLABOURCAMPANY" } ,notes = "searchAuthLab")
    @RequestMapping(method= RequestMethod.POST , value="/pimlabourcampanies/searchauthlab")
	public ResponseEntity<Page<PIMLABOURCAMPANYDTO>> searchAuthLab(@RequestBody PIMLABOURCAMPANYSearchContext context) {
        Page<PIMLABOURCAMPANY> domains = pimlabourcampanyService.searchAuthLab(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlabourcampanyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMLABOURCAMPANY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlabourcampanies/fetchdefault")
	public ResponseEntity<List<PIMLABOURCAMPANYDTO>> fetchDefault(PIMLABOURCAMPANYSearchContext context) {
        Page<PIMLABOURCAMPANY> domains = pimlabourcampanyService.searchDefault(context) ;
        List<PIMLABOURCAMPANYDTO> list = pimlabourcampanyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLABOURCAMPANY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMLABOURCAMPANY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlabourcampanies/searchdefault")
	public ResponseEntity<Page<PIMLABOURCAMPANYDTO>> searchDefault(@RequestBody PIMLABOURCAMPANYSearchContext context) {
        Page<PIMLABOURCAMPANY> domains = pimlabourcampanyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlabourcampanyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
