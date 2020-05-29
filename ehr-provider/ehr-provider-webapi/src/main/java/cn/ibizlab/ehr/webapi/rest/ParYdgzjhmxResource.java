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
import cn.ibizlab.ehr.core.par.domain.ParYdgzjhmx;
import cn.ibizlab.ehr.core.par.service.IParYdgzjhmxService;
import cn.ibizlab.ehr.core.par.filter.ParYdgzjhmxSearchContext;

@Slf4j
@Api(tags = {"ParYdgzjhmx" })
@RestController("WebApi-parydgzjhmx")
@RequestMapping("")
public class ParYdgzjhmxResource {

    @Autowired
    public IParYdgzjhmxService parydgzjhmxService;

    @Autowired
    @Lazy
    public ParYdgzjhmxMapping parydgzjhmxMapping;

    @PreAuthorize("hasPermission(this.parydgzjhmxService.get(#parydgzjhmx_id),'ehr-ParYdgzjhmx-Update')")
    @ApiOperation(value = "Update", tags = {"ParYdgzjhmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    @Transactional
    public ResponseEntity<ParYdgzjhmxDTO> update(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id, @RequestBody ParYdgzjhmxDTO parydgzjhmxdto) {
		ParYdgzjhmx domain  = parydgzjhmxMapping.toDomain(parydgzjhmxdto);
        domain .setParydgzjhmxid(parydgzjhmx_id);
		parydgzjhmxService.update(domain );
		ParYdgzjhmxDTO dto = parydgzjhmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxService.getParydgzjhmxByEntities(this.parydgzjhmxMapping.toDomain(#parydgzjhmxdtos)),'ehr-ParYdgzjhmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParYdgzjhmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParYdgzjhmxDTO> parydgzjhmxdtos) {
        parydgzjhmxService.updateBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxMapping.toDomain(#parydgzjhmxdto),'ehr-ParYdgzjhmx-Save')")
    @ApiOperation(value = "Save", tags = {"ParYdgzjhmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParYdgzjhmxDTO parydgzjhmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.save(parydgzjhmxMapping.toDomain(parydgzjhmxdto)));
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxMapping.toDomain(#parydgzjhmxdtos),'ehr-ParYdgzjhmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParYdgzjhmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParYdgzjhmxDTO> parydgzjhmxdtos) {
        parydgzjhmxService.saveBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxService.get(#parydgzjhmx_id),'ehr-ParYdgzjhmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParYdgzjhmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.remove(parydgzjhmx_id));
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxService.getParydgzjhmxByIds(#ids),'ehr-ParYdgzjhmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParYdgzjhmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parydgzjhmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parydgzjhmxMapping.toDomain(returnObject.body),'ehr-ParYdgzjhmx-Get')")
    @ApiOperation(value = "Get", tags = {"ParYdgzjhmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    public ResponseEntity<ParYdgzjhmxDTO> get(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id) {
        ParYdgzjhmx domain = parydgzjhmxService.get(parydgzjhmx_id);
        ParYdgzjhmxDTO dto = parydgzjhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParYdgzjhmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParYdgzjhmxDTO parydgzjhmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.checkKey(parydgzjhmxMapping.toDomain(parydgzjhmxdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"ParYdgzjhmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhmxes/getdraft")
    public ResponseEntity<ParYdgzjhmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxMapping.toDto(parydgzjhmxService.getDraft(new ParYdgzjhmx())));
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxMapping.toDomain(#parydgzjhmxdto),'ehr-ParYdgzjhmx-Create')")
    @ApiOperation(value = "Create", tags = {"ParYdgzjhmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes")
    @Transactional
    public ResponseEntity<ParYdgzjhmxDTO> create(@RequestBody ParYdgzjhmxDTO parydgzjhmxdto) {
        ParYdgzjhmx domain = parydgzjhmxMapping.toDomain(parydgzjhmxdto);
		parydgzjhmxService.create(domain);
        ParYdgzjhmxDTO dto = parydgzjhmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parydgzjhmxMapping.toDomain(#parydgzjhmxdtos),'ehr-ParYdgzjhmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParYdgzjhmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParYdgzjhmxDTO> parydgzjhmxdtos) {
        parydgzjhmxService.createBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParYdgzjhmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParYdgzjhmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parydgzjhmxes/fetchdefault")
	public ResponseEntity<List<ParYdgzjhmxDTO>> fetchDefault(ParYdgzjhmxSearchContext context) {
        Page<ParYdgzjhmx> domains = parydgzjhmxService.searchDefault(context) ;
        List<ParYdgzjhmxDTO> list = parydgzjhmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParYdgzjhmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParYdgzjhmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parydgzjhmxes/searchdefault")
	public ResponseEntity<Page<ParYdgzjhmxDTO>> searchDefault(@RequestBody ParYdgzjhmxSearchContext context) {
        Page<ParYdgzjhmx> domains = parydgzjhmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parydgzjhmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

