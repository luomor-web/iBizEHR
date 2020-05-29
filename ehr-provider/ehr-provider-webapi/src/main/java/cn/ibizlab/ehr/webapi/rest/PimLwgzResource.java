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
import cn.ibizlab.ehr.core.pim.domain.PimLwgz;
import cn.ibizlab.ehr.core.pim.service.IPimLwgzService;
import cn.ibizlab.ehr.core.pim.filter.PimLwgzSearchContext;

@Slf4j
@Api(tags = {"PimLwgz" })
@RestController("WebApi-pimlwgz")
@RequestMapping("")
public class PimLwgzResource {

    @Autowired
    public IPimLwgzService pimlwgzService;

    @Autowired
    @Lazy
    public PimLwgzMapping pimlwgzMapping;

    @PreAuthorize("hasPermission(this.pimlwgzMapping.toDomain(#pimlwgzdto),'ehr-PimLwgz-Create')")
    @ApiOperation(value = "Create", tags = {"PimLwgz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs")
    @Transactional
    public ResponseEntity<PimLwgzDTO> create(@RequestBody PimLwgzDTO pimlwgzdto) {
        PimLwgz domain = pimlwgzMapping.toDomain(pimlwgzdto);
		pimlwgzService.create(domain);
        PimLwgzDTO dto = pimlwgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlwgzMapping.toDomain(#pimlwgzdtos),'ehr-PimLwgz-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimLwgz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimLwgzDTO> pimlwgzdtos) {
        pimlwgzService.createBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimlwgzMapping.toDomain(returnObject.body),'ehr-PimLwgz-Get')")
    @ApiOperation(value = "Get", tags = {"PimLwgz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlwgzs/{pimlwgz_id}")
    public ResponseEntity<PimLwgzDTO> get(@PathVariable("pimlwgz_id") String pimlwgz_id) {
        PimLwgz domain = pimlwgzService.get(pimlwgz_id);
        PimLwgzDTO dto = pimlwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlwgzService.get(#pimlwgz_id),'ehr-PimLwgz-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimLwgz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlwgzs/{pimlwgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlwgz_id") String pimlwgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.remove(pimlwgz_id));
    }

    @PreAuthorize("hasPermission(this.pimlwgzService.getPimlwgzByIds(#ids),'ehr-PimLwgz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimLwgz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlwgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimLwgz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlwgzs/getdraft")
    public ResponseEntity<PimLwgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlwgzMapping.toDto(pimlwgzService.getDraft(new PimLwgz())));
    }

    @PreAuthorize("hasPermission(this.pimlwgzMapping.toDomain(#pimlwgzdto),'ehr-PimLwgz-Save')")
    @ApiOperation(value = "Save", tags = {"PimLwgz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimLwgzDTO pimlwgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.save(pimlwgzMapping.toDomain(pimlwgzdto)));
    }

    @PreAuthorize("hasPermission(this.pimlwgzMapping.toDomain(#pimlwgzdtos),'ehr-PimLwgz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimLwgz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimLwgzDTO> pimlwgzdtos) {
        pimlwgzService.saveBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlwgzService.get(#pimlwgz_id),'ehr-PimLwgz-Update')")
    @ApiOperation(value = "Update", tags = {"PimLwgz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlwgzs/{pimlwgz_id}")
    @Transactional
    public ResponseEntity<PimLwgzDTO> update(@PathVariable("pimlwgz_id") String pimlwgz_id, @RequestBody PimLwgzDTO pimlwgzdto) {
		PimLwgz domain  = pimlwgzMapping.toDomain(pimlwgzdto);
        domain .setPimlwgzid(pimlwgz_id);
		pimlwgzService.update(domain );
		PimLwgzDTO dto = pimlwgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlwgzService.getPimlwgzByEntities(this.pimlwgzMapping.toDomain(#pimlwgzdtos)),'ehr-PimLwgz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimLwgz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimLwgzDTO> pimlwgzdtos) {
        pimlwgzService.updateBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimLwgz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimLwgzDTO pimlwgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.checkKey(pimlwgzMapping.toDomain(pimlwgzdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLwgz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimLwgz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlwgzs/fetchdefault")
	public ResponseEntity<List<PimLwgzDTO>> fetchDefault(PimLwgzSearchContext context) {
        Page<PimLwgz> domains = pimlwgzService.searchDefault(context) ;
        List<PimLwgzDTO> list = pimlwgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLwgz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimLwgz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlwgzs/searchdefault")
	public ResponseEntity<Page<PimLwgzDTO>> searchDefault(@RequestBody PimLwgzSearchContext context) {
        Page<PimLwgz> domains = pimlwgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlwgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

