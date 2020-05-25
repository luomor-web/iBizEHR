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
import cn.ibizlab.ehr.core.pim.domain.PIMSOCIALSECURITY;
import cn.ibizlab.ehr.core.pim.service.IPIMSOCIALSECURITYService;
import cn.ibizlab.ehr.core.pim.filter.PIMSOCIALSECURITYSearchContext;

@Slf4j
@Api(tags = {"PIMSOCIALSECURITY" })
@RestController("WebApi-pimsocialsecurity")
@RequestMapping("")
public class PIMSOCIALSECURITYResource {

    @Autowired
    private IPIMSOCIALSECURITYService pimsocialsecurityService;

    @Autowired
    @Lazy
    public PIMSOCIALSECURITYMapping pimsocialsecurityMapping;

    public PIMSOCIALSECURITYDTO permissionDTO=new PIMSOCIALSECURITYDTO();

    @PreAuthorize("hasPermission(#pimsocialsecurity_id,'Remove',{'Sql',this.pimsocialsecurityMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMSOCIALSECURITY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.remove(pimsocialsecurity_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMSOCIALSECURITY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsocialsecurityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMSOCIALSECURITY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMSOCIALSECURITYDTO pimsocialsecuritydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.checkKey(pimsocialsecurityMapping.toDomain(pimsocialsecuritydto)));
    }

    @PreAuthorize("hasPermission(#pimsocialsecurity_id,'Get',{'Sql',this.pimsocialsecurityMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMSOCIALSECURITY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    public ResponseEntity<PIMSOCIALSECURITYDTO> get(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id) {
        PIMSOCIALSECURITY domain = pimsocialsecurityService.get(pimsocialsecurity_id);
        PIMSOCIALSECURITYDTO dto = pimsocialsecurityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMSOCIALSECURITY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsocialsecurities/getdraft")
    public ResponseEntity<PIMSOCIALSECURITYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityMapping.toDto(pimsocialsecurityService.getDraft(new PIMSOCIALSECURITY())));
    }

    @PreAuthorize("hasPermission(#pimsocialsecurity_id,'Update',{'Sql',this.pimsocialsecurityMapping,#pimsocialsecuritydto})")
    @ApiOperation(value = "Update", tags = {"PIMSOCIALSECURITY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    @Transactional
    public ResponseEntity<PIMSOCIALSECURITYDTO> update(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id, @RequestBody PIMSOCIALSECURITYDTO pimsocialsecuritydto) {
		PIMSOCIALSECURITY domain = pimsocialsecurityMapping.toDomain(pimsocialsecuritydto);
        domain.setPimsocialsecurityid(pimsocialsecurity_id);
		pimsocialsecurityService.update(domain);
		PIMSOCIALSECURITYDTO dto = pimsocialsecurityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMSOCIALSECURITY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMSOCIALSECURITYDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.updateBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimsocialsecurityMapping,#pimsocialsecuritydto})")
    @ApiOperation(value = "Create", tags = {"PIMSOCIALSECURITY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities")
    @Transactional
    public ResponseEntity<PIMSOCIALSECURITYDTO> create(@RequestBody PIMSOCIALSECURITYDTO pimsocialsecuritydto) {
        PIMSOCIALSECURITY domain = pimsocialsecurityMapping.toDomain(pimsocialsecuritydto);
		pimsocialsecurityService.create(domain);
        PIMSOCIALSECURITYDTO dto = pimsocialsecurityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMSOCIALSECURITY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMSOCIALSECURITYDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.createBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimsocialsecurityMapping,#pimsocialsecuritydto})")
    @ApiOperation(value = "Save", tags = {"PIMSOCIALSECURITY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMSOCIALSECURITYDTO pimsocialsecuritydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.save(pimsocialsecurityMapping.toDomain(pimsocialsecuritydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMSOCIALSECURITY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMSOCIALSECURITYDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.saveBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(社保信息)", tags = {"PIMSOCIALSECURITY" } ,notes = "fetch自助(社保信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchzizhu")
	public ResponseEntity<List<PIMSOCIALSECURITYDTO>> fetchZIZHU(PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchZIZHU(context) ;
        List<PIMSOCIALSECURITYDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-ZIZHU-all')")
	@ApiOperation(value = "search自助(社保信息)", tags = {"PIMSOCIALSECURITY" } ,notes = "search自助(社保信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchzizhu")
	public ResponseEntity<Page<PIMSOCIALSECURITYDTO>> searchZIZHU(@RequestBody PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMSOCIALSECURITY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchdefault")
	public ResponseEntity<List<PIMSOCIALSECURITYDTO>> fetchDefault(PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchDefault(context) ;
        List<PIMSOCIALSECURITYDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMSOCIALSECURITY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchdefault")
	public ResponseEntity<Page<PIMSOCIALSECURITYDTO>> searchDefault(@RequestBody PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PIMSOCIALSECURITY" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchjlss")
	public ResponseEntity<List<PIMSOCIALSECURITYDTO>> fetchJLSS(PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchJLSS(context) ;
        List<PIMSOCIALSECURITYDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSOCIALSECURITY-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PIMSOCIALSECURITY" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchjlss")
	public ResponseEntity<Page<PIMSOCIALSECURITYDTO>> searchJLSS(@RequestBody PIMSOCIALSECURITYSearchContext context) {
        Page<PIMSOCIALSECURITY> domains = pimsocialsecurityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
