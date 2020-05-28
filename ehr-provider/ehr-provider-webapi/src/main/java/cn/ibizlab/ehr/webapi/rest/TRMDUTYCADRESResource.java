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
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
import cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService;
import cn.ibizlab.ehr.core.trm.filter.TRMDUTYCADRESSearchContext;

@Slf4j
@Api(tags = {"TRMDUTYCADRES" })
@RestController("WebApi-trmdutycadres")
@RequestMapping("")
public class TRMDUTYCADRESResource {

    @Autowired
    public ITRMDUTYCADRESService trmdutycadresService;

    @Autowired
    @Lazy
    public TRMDUTYCADRESMapping trmdutycadresMapping;

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdto),'ehr-TRMDUTYCADRES-Save')")
    @ApiOperation(value = "Save", tags = {"TRMDUTYCADRES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.save(trmdutycadresMapping.toDomain(trmdutycadresdto)));
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos),'ehr-TRMDUTYCADRES-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMDUTYCADRES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMDUTYCADRESDTO> trmdutycadresdtos) {
        trmdutycadresService.saveBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-SetNQGBXX-all')")
    @ApiOperation(value = "设置年轻干部信息", tags = {"TRMDUTYCADRES" },  notes = "设置年轻干部信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/setnqgbxx")
    @Transactional
    public ResponseEntity<TRMDUTYCADRESDTO> setNQGBXX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        TRMDUTYCADRES trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.setNQGBXX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-SX-all')")
    @ApiOperation(value = "生效", tags = {"TRMDUTYCADRES" },  notes = "生效")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/sx")
    @Transactional
    public ResponseEntity<TRMDUTYCADRESDTO> sX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        TRMDUTYCADRES trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.sX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdto),'ehr-TRMDUTYCADRES-Create')")
    @ApiOperation(value = "Create", tags = {"TRMDUTYCADRES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres")
    @Transactional
    public ResponseEntity<TRMDUTYCADRESDTO> create(@RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        TRMDUTYCADRES domain = trmdutycadresMapping.toDomain(trmdutycadresdto);
		trmdutycadresService.create(domain);
        TRMDUTYCADRESDTO dto = trmdutycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos),'ehr-TRMDUTYCADRES-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMDUTYCADRES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMDUTYCADRESDTO> trmdutycadresdtos) {
        trmdutycadresService.createBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMDUTYCADRES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdutycadres/getdraft")
    public ResponseEntity<TRMDUTYCADRESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresMapping.toDto(trmdutycadresService.getDraft(new TRMDUTYCADRES())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMDUTYCADRES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.checkKey(trmdutycadresMapping.toDomain(trmdutycadresdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-XX-all')")
    @ApiOperation(value = "失效", tags = {"TRMDUTYCADRES" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/xx")
    @Transactional
    public ResponseEntity<TRMDUTYCADRESDTO> xX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
        TRMDUTYCADRES trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.xX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PostAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(returnObject.body),'ehr-TRMDUTYCADRES-Get')")
    @ApiOperation(value = "Get", tags = {"TRMDUTYCADRES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdutycadres/{trmdutycadres_id}")
    public ResponseEntity<TRMDUTYCADRESDTO> get(@PathVariable("trmdutycadres_id") String trmdutycadres_id) {
        TRMDUTYCADRES domain = trmdutycadresService.get(trmdutycadres_id);
        TRMDUTYCADRESDTO dto = trmdutycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.get(#trmdutycadres_id),'ehr-TRMDUTYCADRES-Update')")
    @ApiOperation(value = "Update", tags = {"TRMDUTYCADRES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdutycadres/{trmdutycadres_id}")
    @Transactional
    public ResponseEntity<TRMDUTYCADRESDTO> update(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TRMDUTYCADRESDTO trmdutycadresdto) {
		TRMDUTYCADRES domain  = trmdutycadresMapping.toDomain(trmdutycadresdto);
        domain .setTrmdutycadresid(trmdutycadres_id);
		trmdutycadresService.update(domain );
		TRMDUTYCADRESDTO dto = trmdutycadresMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.getTrmdutycadresByEntities(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos)),'ehr-TRMDUTYCADRES-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMDUTYCADRES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMDUTYCADRESDTO> trmdutycadresdtos) {
        trmdutycadresService.updateBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.get(#trmdutycadres_id),'ehr-TRMDUTYCADRES-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMDUTYCADRES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdutycadres/{trmdutycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdutycadres_id") String trmdutycadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.remove(trmdutycadres_id));
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.getTrmdutycadresByIds(#ids),'ehr-TRMDUTYCADRES-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMDUTYCADRES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdutycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-CurCXFW-all')")
	@ApiOperation(value = "fetch数据范围选择", tags = {"TRMDUTYCADRES" } ,notes = "fetch数据范围选择")
    @RequestMapping(method= RequestMethod.GET , value="/trmdutycadres/fetchcurcxfw")
	public ResponseEntity<List<TRMDUTYCADRESDTO>> fetchCurCXFW(TRMDUTYCADRESSearchContext context) {
        Page<TRMDUTYCADRES> domains = trmdutycadresService.searchCurCXFW(context) ;
        List<TRMDUTYCADRESDTO> list = trmdutycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-CurCXFW-all')")
	@ApiOperation(value = "search数据范围选择", tags = {"TRMDUTYCADRES" } ,notes = "search数据范围选择")
    @RequestMapping(method= RequestMethod.POST , value="/trmdutycadres/searchcurcxfw")
	public ResponseEntity<Page<TRMDUTYCADRESDTO>> searchCurCXFW(@RequestBody TRMDUTYCADRESSearchContext context) {
        Page<TRMDUTYCADRES> domains = trmdutycadresService.searchCurCXFW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdutycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMDUTYCADRES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdutycadres/fetchdefault")
	public ResponseEntity<List<TRMDUTYCADRESDTO>> fetchDefault(TRMDUTYCADRESSearchContext context) {
        Page<TRMDUTYCADRES> domains = trmdutycadresService.searchDefault(context) ;
        List<TRMDUTYCADRESDTO> list = trmdutycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDUTYCADRES-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMDUTYCADRES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdutycadres/searchdefault")
	public ResponseEntity<Page<TRMDUTYCADRESDTO>> searchDefault(@RequestBody TRMDUTYCADRESSearchContext context) {
        Page<TRMDUTYCADRES> domains = trmdutycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdutycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

