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
import cn.ibizlab.ehr.core.trm.domain.TrmDutyCadres;
import cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService;
import cn.ibizlab.ehr.core.trm.filter.TrmDutyCadresSearchContext;

@Slf4j
@Api(tags = {"TrmDutyCadres" })
@RestController("WebApi-trmdutycadres")
@RequestMapping("")
public class TrmDutyCadresResource {

    @Autowired
    public ITrmDutyCadresService trmdutycadresService;

    @Autowired
    @Lazy
    public TrmDutyCadresMapping trmdutycadresMapping;

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdto),'ehr-TrmDutyCadres-Save')")
    @ApiOperation(value = "Save", tags = {"TrmDutyCadres" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.save(trmdutycadresMapping.toDomain(trmdutycadresdto)));
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos),'ehr-TrmDutyCadres-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmDutyCadres" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmDutyCadresDTO> trmdutycadresdtos) {
        trmdutycadresService.saveBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-SetNQGBXX-all')")
    @ApiOperation(value = "设置年轻干部信息", tags = {"TrmDutyCadres" },  notes = "设置年轻干部信息")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/setnqgbxx")
    @Transactional
    public ResponseEntity<TrmDutyCadresDTO> setNQGBXX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        TrmDutyCadres trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.setNQGBXX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-SX-all')")
    @ApiOperation(value = "生效", tags = {"TrmDutyCadres" },  notes = "生效")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/sx")
    @Transactional
    public ResponseEntity<TrmDutyCadresDTO> sX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        TrmDutyCadres trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.sX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdto),'ehr-TrmDutyCadres-Create')")
    @ApiOperation(value = "Create", tags = {"TrmDutyCadres" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres")
    @Transactional
    public ResponseEntity<TrmDutyCadresDTO> create(@RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        TrmDutyCadres domain = trmdutycadresMapping.toDomain(trmdutycadresdto);
		trmdutycadresService.create(domain);
        TrmDutyCadresDTO dto = trmdutycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos),'ehr-TrmDutyCadres-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmDutyCadres" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmDutyCadresDTO> trmdutycadresdtos) {
        trmdutycadresService.createBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmDutyCadres" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdutycadres/getdraft")
    public ResponseEntity<TrmDutyCadresDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresMapping.toDto(trmdutycadresService.getDraft(new TrmDutyCadres())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmDutyCadres" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.checkKey(trmdutycadresMapping.toDomain(trmdutycadresdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-XX-all')")
    @ApiOperation(value = "失效", tags = {"TrmDutyCadres" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdutycadres/{trmdutycadres_id}/xx")
    @Transactional
    public ResponseEntity<TrmDutyCadresDTO> xX(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TrmDutyCadresDTO trmdutycadresdto) {
        TrmDutyCadres trmdutycadres = trmdutycadresMapping.toDomain(trmdutycadresdto);
        trmdutycadres.setTrmdutycadresid(trmdutycadres_id);
        trmdutycadres = trmdutycadresService.xX(trmdutycadres);
        trmdutycadresdto = trmdutycadresMapping.toDto(trmdutycadres);
        return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresdto);
    }

    @PostAuthorize("hasPermission(this.trmdutycadresMapping.toDomain(returnObject.body),'ehr-TrmDutyCadres-Get')")
    @ApiOperation(value = "Get", tags = {"TrmDutyCadres" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdutycadres/{trmdutycadres_id}")
    public ResponseEntity<TrmDutyCadresDTO> get(@PathVariable("trmdutycadres_id") String trmdutycadres_id) {
        TrmDutyCadres domain = trmdutycadresService.get(trmdutycadres_id);
        TrmDutyCadresDTO dto = trmdutycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.get(#trmdutycadres_id),'ehr-TrmDutyCadres-Update')")
    @ApiOperation(value = "Update", tags = {"TrmDutyCadres" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdutycadres/{trmdutycadres_id}")
    @Transactional
    public ResponseEntity<TrmDutyCadresDTO> update(@PathVariable("trmdutycadres_id") String trmdutycadres_id, @RequestBody TrmDutyCadresDTO trmdutycadresdto) {
		TrmDutyCadres domain  = trmdutycadresMapping.toDomain(trmdutycadresdto);
        domain .setTrmdutycadresid(trmdutycadres_id);
		trmdutycadresService.update(domain );
		TrmDutyCadresDTO dto = trmdutycadresMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.getTrmdutycadresByEntities(this.trmdutycadresMapping.toDomain(#trmdutycadresdtos)),'ehr-TrmDutyCadres-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmDutyCadres" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmDutyCadresDTO> trmdutycadresdtos) {
        trmdutycadresService.updateBatch(trmdutycadresMapping.toDomain(trmdutycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.get(#trmdutycadres_id),'ehr-TrmDutyCadres-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmDutyCadres" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdutycadres/{trmdutycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdutycadres_id") String trmdutycadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdutycadresService.remove(trmdutycadres_id));
    }

    @PreAuthorize("hasPermission(this.trmdutycadresService.getTrmdutycadresByIds(#ids),'ehr-TrmDutyCadres-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmDutyCadres" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdutycadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdutycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-CurCXFW-all')")
	@ApiOperation(value = "fetch数据范围选择", tags = {"TrmDutyCadres" } ,notes = "fetch数据范围选择")
    @RequestMapping(method= RequestMethod.GET , value="/trmdutycadres/fetchcurcxfw")
	public ResponseEntity<List<TrmDutyCadresDTO>> fetchCurCXFW(TrmDutyCadresSearchContext context) {
        Page<TrmDutyCadres> domains = trmdutycadresService.searchCurCXFW(context) ;
        List<TrmDutyCadresDTO> list = trmdutycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-CurCXFW-all')")
	@ApiOperation(value = "search数据范围选择", tags = {"TrmDutyCadres" } ,notes = "search数据范围选择")
    @RequestMapping(method= RequestMethod.POST , value="/trmdutycadres/searchcurcxfw")
	public ResponseEntity<Page<TrmDutyCadresDTO>> searchCurCXFW(@RequestBody TrmDutyCadresSearchContext context) {
        Page<TrmDutyCadres> domains = trmdutycadresService.searchCurCXFW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdutycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmDutyCadres" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdutycadres/fetchdefault")
	public ResponseEntity<List<TrmDutyCadresDTO>> fetchDefault(TrmDutyCadresSearchContext context) {
        Page<TrmDutyCadres> domains = trmdutycadresService.searchDefault(context) ;
        List<TrmDutyCadresDTO> list = trmdutycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDutyCadres-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmDutyCadres" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdutycadres/searchdefault")
	public ResponseEntity<Page<TrmDutyCadresDTO>> searchDefault(@RequestBody TrmDutyCadresSearchContext context) {
        Page<TrmDutyCadres> domains = trmdutycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdutycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

