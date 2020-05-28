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
import cn.ibizlab.ehr.core.pim.domain.NationMGR;
import cn.ibizlab.ehr.core.pim.service.INationMGRService;
import cn.ibizlab.ehr.core.pim.filter.NationMGRSearchContext;

@Slf4j
@Api(tags = {"NationMGR" })
@RestController("WebApi-nationmgr")
@RequestMapping("")
public class NationMGRResource {

    @Autowired
    public INationMGRService nationmgrService;

    @Autowired
    @Lazy
    public NationMGRMapping nationmgrMapping;

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdto),'ehr-NationMGR-Save')")
    @ApiOperation(value = "Save", tags = {"NationMGR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody NationMGRDTO nationmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(nationmgrService.save(nationmgrMapping.toDomain(nationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdtos),'ehr-NationMGR-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"NationMGR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<NationMGRDTO> nationmgrdtos) {
        nationmgrService.saveBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.get(#nationmgr_id),'ehr-NationMGR-Remove')")
    @ApiOperation(value = "Remove", tags = {"NationMGR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/nationmgrs/{nationmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("nationmgr_id") String nationmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(nationmgrService.remove(nationmgr_id));
    }

    @PreAuthorize("hasPermission(this.nationmgrService.getNationmgrByIds(#ids),'ehr-NationMGR-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"NationMGR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        nationmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"NationMGR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/nationmgrs/getdraft")
    public ResponseEntity<NationMGRDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(nationmgrMapping.toDto(nationmgrService.getDraft(new NationMGR())));
    }

    @ApiOperation(value = "CheckKey", tags = {"NationMGR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody NationMGRDTO nationmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(nationmgrService.checkKey(nationmgrMapping.toDomain(nationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdto),'ehr-NationMGR-Create')")
    @ApiOperation(value = "Create", tags = {"NationMGR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs")
    @Transactional
    public ResponseEntity<NationMGRDTO> create(@RequestBody NationMGRDTO nationmgrdto) {
        NationMGR domain = nationmgrMapping.toDomain(nationmgrdto);
		nationmgrService.create(domain);
        NationMGRDTO dto = nationmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdtos),'ehr-NationMGR-Create')")
    @ApiOperation(value = "createBatch", tags = {"NationMGR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<NationMGRDTO> nationmgrdtos) {
        nationmgrService.createBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.nationmgrMapping.toDomain(returnObject.body),'ehr-NationMGR-Get')")
    @ApiOperation(value = "Get", tags = {"NationMGR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/nationmgrs/{nationmgr_id}")
    public ResponseEntity<NationMGRDTO> get(@PathVariable("nationmgr_id") String nationmgr_id) {
        NationMGR domain = nationmgrService.get(nationmgr_id);
        NationMGRDTO dto = nationmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.get(#nationmgr_id),'ehr-NationMGR-Update')")
    @ApiOperation(value = "Update", tags = {"NationMGR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/nationmgrs/{nationmgr_id}")
    @Transactional
    public ResponseEntity<NationMGRDTO> update(@PathVariable("nationmgr_id") String nationmgr_id, @RequestBody NationMGRDTO nationmgrdto) {
		NationMGR domain  = nationmgrMapping.toDomain(nationmgrdto);
        domain .setNationmgrid(nationmgr_id);
		nationmgrService.update(domain );
		NationMGRDTO dto = nationmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.getNationmgrByEntities(this.nationmgrMapping.toDomain(#nationmgrdtos)),'ehr-NationMGR-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"NationMGR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<NationMGRDTO> nationmgrdtos) {
        nationmgrService.updateBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-NationMGR-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"NationMGR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/nationmgrs/fetchdefault")
	public ResponseEntity<List<NationMGRDTO>> fetchDefault(NationMGRSearchContext context) {
        Page<NationMGR> domains = nationmgrService.searchDefault(context) ;
        List<NationMGRDTO> list = nationmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-NationMGR-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"NationMGR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/nationmgrs/searchdefault")
	public ResponseEntity<Page<NationMGRDTO>> searchDefault(@RequestBody NationMGRSearchContext context) {
        Page<NationMGR> domains = nationmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(nationmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

