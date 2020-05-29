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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PimSocialSecurity;
import cn.ibizlab.ehr.core.pim.service.IPimSocialSecurityService;
import cn.ibizlab.ehr.core.pim.filter.PimSocialSecuritySearchContext;

@Slf4j
@Api(tags = {"PimSocialSecurity" })
@RestController("WebApi-pimsocialsecurity")
@RequestMapping("")
public class PimSocialSecurityResource {

    @Autowired
    public IPimSocialSecurityService pimsocialsecurityService;

    @Autowired
    @Lazy
    public PimSocialSecurityMapping pimsocialsecurityMapping;

    @PreAuthorize("hasPermission(this.pimsocialsecurityService.get(#pimsocialsecurity_id),'ehr-PimSocialSecurity-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimSocialSecurity" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.remove(pimsocialsecurity_id));
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityService.getPimsocialsecurityByIds(#ids),'ehr-PimSocialSecurity-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimSocialSecurity" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsocialsecurityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimSocialSecurity" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimSocialSecurityDTO pimsocialsecuritydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.checkKey(pimsocialsecurityMapping.toDomain(pimsocialsecuritydto)));
    }

    @PostAuthorize("hasPermission(this.pimsocialsecurityMapping.toDomain(returnObject.body),'ehr-PimSocialSecurity-Get')")
    @ApiOperation(value = "Get", tags = {"PimSocialSecurity" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    public ResponseEntity<PimSocialSecurityDTO> get(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id) {
        PimSocialSecurity domain = pimsocialsecurityService.get(pimsocialsecurity_id);
        PimSocialSecurityDTO dto = pimsocialsecurityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimSocialSecurity" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsocialsecurities/getdraft")
    public ResponseEntity<PimSocialSecurityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityMapping.toDto(pimsocialsecurityService.getDraft(new PimSocialSecurity())));
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityService.get(#pimsocialsecurity_id),'ehr-PimSocialSecurity-Update')")
    @ApiOperation(value = "Update", tags = {"PimSocialSecurity" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsocialsecurities/{pimsocialsecurity_id}")
    @Transactional
    public ResponseEntity<PimSocialSecurityDTO> update(@PathVariable("pimsocialsecurity_id") String pimsocialsecurity_id, @RequestBody PimSocialSecurityDTO pimsocialsecuritydto) {
		PimSocialSecurity domain  = pimsocialsecurityMapping.toDomain(pimsocialsecuritydto);
        domain .setPimsocialsecurityid(pimsocialsecurity_id);
		pimsocialsecurityService.update(domain );
		PimSocialSecurityDTO dto = pimsocialsecurityMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityService.getPimsocialsecurityByEntities(this.pimsocialsecurityMapping.toDomain(#pimsocialsecuritydtos)),'ehr-PimSocialSecurity-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimSocialSecurity" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimSocialSecurityDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.updateBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityMapping.toDomain(#pimsocialsecuritydto),'ehr-PimSocialSecurity-Create')")
    @ApiOperation(value = "Create", tags = {"PimSocialSecurity" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities")
    @Transactional
    public ResponseEntity<PimSocialSecurityDTO> create(@RequestBody PimSocialSecurityDTO pimsocialsecuritydto) {
        PimSocialSecurity domain = pimsocialsecurityMapping.toDomain(pimsocialsecuritydto);
		pimsocialsecurityService.create(domain);
        PimSocialSecurityDTO dto = pimsocialsecurityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityMapping.toDomain(#pimsocialsecuritydtos),'ehr-PimSocialSecurity-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimSocialSecurity" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimSocialSecurityDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.createBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityMapping.toDomain(#pimsocialsecuritydto),'ehr-PimSocialSecurity-Save')")
    @ApiOperation(value = "Save", tags = {"PimSocialSecurity" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/save")
    public ResponseEntity<Boolean> save(@RequestBody PimSocialSecurityDTO pimsocialsecuritydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsocialsecurityService.save(pimsocialsecurityMapping.toDomain(pimsocialsecuritydto)));
    }

    @PreAuthorize("hasPermission(this.pimsocialsecurityMapping.toDomain(#pimsocialsecuritydtos),'ehr-PimSocialSecurity-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimSocialSecurity" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsocialsecurities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimSocialSecurityDTO> pimsocialsecuritydtos) {
        pimsocialsecurityService.saveBatch(pimsocialsecurityMapping.toDomain(pimsocialsecuritydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(社保信息)", tags = {"PimSocialSecurity" } ,notes = "fetch自助(社保信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchzizhu")
	public ResponseEntity<List<PimSocialSecurityDTO>> fetchZIZHU(PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchZIZHU(context) ;
        List<PimSocialSecurityDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-ZIZHU-all')")
	@ApiOperation(value = "search自助(社保信息)", tags = {"PimSocialSecurity" } ,notes = "search自助(社保信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchzizhu")
	public ResponseEntity<Page<PimSocialSecurityDTO>> searchZIZHU(@RequestBody PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimSocialSecurity" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchdefault")
	public ResponseEntity<List<PimSocialSecurityDTO>> fetchDefault(PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchDefault(context) ;
        List<PimSocialSecurityDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimSocialSecurity" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchdefault")
	public ResponseEntity<Page<PimSocialSecurityDTO>> searchDefault(@RequestBody PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PimSocialSecurity" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimsocialsecurities/fetchjlss")
	public ResponseEntity<List<PimSocialSecurityDTO>> fetchJLSS(PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchJLSS(context) ;
        List<PimSocialSecurityDTO> list = pimsocialsecurityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSocialSecurity-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PimSocialSecurity" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimsocialsecurities/searchjlss")
	public ResponseEntity<Page<PimSocialSecurityDTO>> searchJLSS(@RequestBody PimSocialSecuritySearchContext context) {
        Page<PimSocialSecurity> domains = pimsocialsecurityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsocialsecurityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

