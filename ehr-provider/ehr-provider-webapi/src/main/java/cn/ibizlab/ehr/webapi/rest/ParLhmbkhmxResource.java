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
import cn.ibizlab.ehr.core.par.domain.ParLhmbkhmx;
import cn.ibizlab.ehr.core.par.service.IParLhmbkhmxService;
import cn.ibizlab.ehr.core.par.filter.ParLhmbkhmxSearchContext;

@Slf4j
@Api(tags = {"ParLhmbkhmx" })
@RestController("WebApi-parlhmbkhmx")
@RequestMapping("")
public class ParLhmbkhmxResource {

    @Autowired
    public IParLhmbkhmxService parlhmbkhmxService;

    @Autowired
    @Lazy
    public ParLhmbkhmxMapping parlhmbkhmxMapping;

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.get(#parlhmbkhmx_id),'ehr-ParLhmbkhmx-Update')")
    @ApiOperation(value = "Update", tags = {"ParLhmbkhmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<ParLhmbkhmxDTO> update(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id, @RequestBody ParLhmbkhmxDTO parlhmbkhmxdto) {
		ParLhmbkhmx domain  = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
        domain .setParlhmbkhmxid(parlhmbkhmx_id);
		parlhmbkhmxService.update(domain );
		ParLhmbkhmxDTO dto = parlhmbkhmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.getParlhmbkhmxByEntities(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos)),'ehr-ParLhmbkhmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParLhmbkhmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLhmbkhmxDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.updateBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParLhmbkhmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/getdraft")
    public ResponseEntity<ParLhmbkhmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxMapping.toDto(parlhmbkhmxService.getDraft(new ParLhmbkhmx())));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.get(#parlhmbkhmx_id),'ehr-ParLhmbkhmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParLhmbkhmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.remove(parlhmbkhmx_id));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.getParlhmbkhmxByIds(#ids),'ehr-ParLhmbkhmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParLhmbkhmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbkhmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdto),'ehr-ParLhmbkhmx-Save')")
    @ApiOperation(value = "Save", tags = {"ParLhmbkhmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLhmbkhmxDTO parlhmbkhmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.save(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos),'ehr-ParLhmbkhmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParLhmbkhmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLhmbkhmxDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.saveBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParLhmbkhmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLhmbkhmxDTO parlhmbkhmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.checkKey(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }

    @PostAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(returnObject.body),'ehr-ParLhmbkhmx-Get')")
    @ApiOperation(value = "Get", tags = {"ParLhmbkhmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    public ResponseEntity<ParLhmbkhmxDTO> get(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
        ParLhmbkhmx domain = parlhmbkhmxService.get(parlhmbkhmx_id);
        ParLhmbkhmxDTO dto = parlhmbkhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdto),'ehr-ParLhmbkhmx-Create')")
    @ApiOperation(value = "Create", tags = {"ParLhmbkhmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes")
    @Transactional
    public ResponseEntity<ParLhmbkhmxDTO> create(@RequestBody ParLhmbkhmxDTO parlhmbkhmxdto) {
        ParLhmbkhmx domain = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
		parlhmbkhmxService.create(domain);
        ParLhmbkhmxDTO dto = parlhmbkhmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos),'ehr-ParLhmbkhmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParLhmbkhmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLhmbkhmxDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.createBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLhmbkhmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParLhmbkhmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbkhmxes/fetchdefault")
	public ResponseEntity<List<ParLhmbkhmxDTO>> fetchDefault(ParLhmbkhmxSearchContext context) {
        Page<ParLhmbkhmx> domains = parlhmbkhmxService.searchDefault(context) ;
        List<ParLhmbkhmxDTO> list = parlhmbkhmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLhmbkhmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParLhmbkhmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbkhmxes/searchdefault")
	public ResponseEntity<Page<ParLhmbkhmxDTO>> searchDefault(@RequestBody ParLhmbkhmxSearchContext context) {
        Page<ParLhmbkhmx> domains = parlhmbkhmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbkhmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

