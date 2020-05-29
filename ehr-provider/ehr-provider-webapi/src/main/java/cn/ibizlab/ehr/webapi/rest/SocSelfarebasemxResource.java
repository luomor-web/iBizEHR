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
import cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx;
import cn.ibizlab.ehr.core.soc.service.ISocSelfarebasemxService;
import cn.ibizlab.ehr.core.soc.filter.SocSelfarebasemxSearchContext;

@Slf4j
@Api(tags = {"SocSelfarebasemx" })
@RestController("WebApi-socselfarebasemx")
@RequestMapping("")
public class SocSelfarebasemxResource {

    @Autowired
    public ISocSelfarebasemxService socselfarebasemxService;

    @Autowired
    @Lazy
    public SocSelfarebasemxMapping socselfarebasemxMapping;

    @ApiOperation(value = "CheckKey", tags = {"SocSelfarebasemx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocSelfarebasemxDTO socselfarebasemxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.checkKey(socselfarebasemxMapping.toDomain(socselfarebasemxdto)));
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxService.get(#socselfarebasemx_id),'ehr-SocSelfarebasemx-Remove')")
    @ApiOperation(value = "Remove", tags = {"SocSelfarebasemx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.remove(socselfarebasemx_id));
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxService.getSocselfarebasemxByIds(#ids),'ehr-SocSelfarebasemx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SocSelfarebasemx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socselfarebasemxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socselfarebasemxMapping.toDomain(returnObject.body),'ehr-SocSelfarebasemx-Get')")
    @ApiOperation(value = "Get", tags = {"SocSelfarebasemx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    public ResponseEntity<SocSelfarebasemxDTO> get(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id) {
        SocSelfarebasemx domain = socselfarebasemxService.get(socselfarebasemx_id);
        SocSelfarebasemxDTO dto = socselfarebasemxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"SocSelfarebasemx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebasemxes/getdraft")
    public ResponseEntity<SocSelfarebasemxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxMapping.toDto(socselfarebasemxService.getDraft(new SocSelfarebasemx())));
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxMapping.toDomain(#socselfarebasemxdto),'ehr-SocSelfarebasemx-Create')")
    @ApiOperation(value = "Create", tags = {"SocSelfarebasemx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes")
    @Transactional
    public ResponseEntity<SocSelfarebasemxDTO> create(@RequestBody SocSelfarebasemxDTO socselfarebasemxdto) {
        SocSelfarebasemx domain = socselfarebasemxMapping.toDomain(socselfarebasemxdto);
		socselfarebasemxService.create(domain);
        SocSelfarebasemxDTO dto = socselfarebasemxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxMapping.toDomain(#socselfarebasemxdtos),'ehr-SocSelfarebasemx-Create')")
    @ApiOperation(value = "createBatch", tags = {"SocSelfarebasemx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocSelfarebasemxDTO> socselfarebasemxdtos) {
        socselfarebasemxService.createBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxMapping.toDomain(#socselfarebasemxdto),'ehr-SocSelfarebasemx-Save')")
    @ApiOperation(value = "Save", tags = {"SocSelfarebasemx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SocSelfarebasemxDTO socselfarebasemxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.save(socselfarebasemxMapping.toDomain(socselfarebasemxdto)));
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxMapping.toDomain(#socselfarebasemxdtos),'ehr-SocSelfarebasemx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SocSelfarebasemx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocSelfarebasemxDTO> socselfarebasemxdtos) {
        socselfarebasemxService.saveBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxService.get(#socselfarebasemx_id),'ehr-SocSelfarebasemx-Update')")
    @ApiOperation(value = "Update", tags = {"SocSelfarebasemx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    @Transactional
    public ResponseEntity<SocSelfarebasemxDTO> update(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id, @RequestBody SocSelfarebasemxDTO socselfarebasemxdto) {
		SocSelfarebasemx domain  = socselfarebasemxMapping.toDomain(socselfarebasemxdto);
        domain .setSocselfarebasemxid(socselfarebasemx_id);
		socselfarebasemxService.update(domain );
		SocSelfarebasemxDTO dto = socselfarebasemxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socselfarebasemxService.getSocselfarebasemxByEntities(this.socselfarebasemxMapping.toDomain(#socselfarebasemxdtos)),'ehr-SocSelfarebasemx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SocSelfarebasemx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocSelfarebasemxDTO> socselfarebasemxdtos) {
        socselfarebasemxService.updateBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocSelfarebasemx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SocSelfarebasemx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socselfarebasemxes/fetchdefault")
	public ResponseEntity<List<SocSelfarebasemxDTO>> fetchDefault(SocSelfarebasemxSearchContext context) {
        Page<SocSelfarebasemx> domains = socselfarebasemxService.searchDefault(context) ;
        List<SocSelfarebasemxDTO> list = socselfarebasemxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocSelfarebasemx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SocSelfarebasemx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socselfarebasemxes/searchdefault")
	public ResponseEntity<Page<SocSelfarebasemxDTO>> searchDefault(@RequestBody SocSelfarebasemxSearchContext context) {
        Page<SocSelfarebasemx> domains = socselfarebasemxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socselfarebasemxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

