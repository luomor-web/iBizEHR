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
import cn.ibizlab.ehr.core.par.domain.ParJxkhmbmx;
import cn.ibizlab.ehr.core.par.service.IParJxkhmbmxService;
import cn.ibizlab.ehr.core.par.filter.ParJxkhmbmxSearchContext;

@Slf4j
@Api(tags = {"ParJxkhmbmx" })
@RestController("WebApi-parjxkhmbmx")
@RequestMapping("")
public class ParJxkhmbmxResource {

    @Autowired
    public IParJxkhmbmxService parjxkhmbmxService;

    @Autowired
    @Lazy
    public ParJxkhmbmxMapping parjxkhmbmxMapping;

    @PreAuthorize("hasPermission(this.parjxkhmbmxMapping.toDomain(#parjxkhmbmxdto),'ehr-ParJxkhmbmx-Create')")
    @ApiOperation(value = "Create", tags = {"ParJxkhmbmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes")
    @Transactional
    public ResponseEntity<ParJxkhmbmxDTO> create(@RequestBody ParJxkhmbmxDTO parjxkhmbmxdto) {
        ParJxkhmbmx domain = parjxkhmbmxMapping.toDomain(parjxkhmbmxdto);
		parjxkhmbmxService.create(domain);
        ParJxkhmbmxDTO dto = parjxkhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxMapping.toDomain(#parjxkhmbmxdtos),'ehr-ParJxkhmbmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJxkhmbmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxkhmbmxDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.createBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParJxkhmbmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxkhmbmxDTO parjxkhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.checkKey(parjxkhmbmxMapping.toDomain(parjxkhmbmxdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJxkhmbmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbmxes/getdraft")
    public ResponseEntity<ParJxkhmbmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxMapping.toDto(parjxkhmbmxService.getDraft(new ParJxkhmbmx())));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxService.get(#parjxkhmbmx_id),'ehr-ParJxkhmbmx-Update')")
    @ApiOperation(value = "Update", tags = {"ParJxkhmbmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    @Transactional
    public ResponseEntity<ParJxkhmbmxDTO> update(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id, @RequestBody ParJxkhmbmxDTO parjxkhmbmxdto) {
		ParJxkhmbmx domain  = parjxkhmbmxMapping.toDomain(parjxkhmbmxdto);
        domain .setParjxkhmbmxid(parjxkhmbmx_id);
		parjxkhmbmxService.update(domain );
		ParJxkhmbmxDTO dto = parjxkhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxService.getParjxkhmbmxByEntities(this.parjxkhmbmxMapping.toDomain(#parjxkhmbmxdtos)),'ehr-ParJxkhmbmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJxkhmbmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxkhmbmxDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.updateBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxkhmbmxMapping.toDomain(returnObject.body),'ehr-ParJxkhmbmx-Get')")
    @ApiOperation(value = "Get", tags = {"ParJxkhmbmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    public ResponseEntity<ParJxkhmbmxDTO> get(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id) {
        ParJxkhmbmx domain = parjxkhmbmxService.get(parjxkhmbmx_id);
        ParJxkhmbmxDTO dto = parjxkhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxMapping.toDomain(#parjxkhmbmxdto),'ehr-ParJxkhmbmx-Save')")
    @ApiOperation(value = "Save", tags = {"ParJxkhmbmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxkhmbmxDTO parjxkhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.save(parjxkhmbmxMapping.toDomain(parjxkhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxMapping.toDomain(#parjxkhmbmxdtos),'ehr-ParJxkhmbmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJxkhmbmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxkhmbmxDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.saveBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxService.get(#parjxkhmbmx_id),'ehr-ParJxkhmbmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJxkhmbmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.remove(parjxkhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbmxService.getParjxkhmbmxByIds(#ids),'ehr-ParJxkhmbmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJxkhmbmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhmbmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJxkhmbmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhmbmxes/fetchdefault")
	public ResponseEntity<List<ParJxkhmbmxDTO>> fetchDefault(ParJxkhmbmxSearchContext context) {
        Page<ParJxkhmbmx> domains = parjxkhmbmxService.searchDefault(context) ;
        List<ParJxkhmbmxDTO> list = parjxkhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhmbmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJxkhmbmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhmbmxes/searchdefault")
	public ResponseEntity<Page<ParJxkhmbmxDTO>> searchDefault(@RequestBody ParJxkhmbmxSearchContext context) {
        Page<ParJxkhmbmx> domains = parjxkhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

