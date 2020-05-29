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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesCenterService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesCenterSearchContext;

@Slf4j
@Api(tags = {"PimArchivesCenter" })
@RestController("WebApi-pimarchivescenter")
@RequestMapping("")
public class PimArchivesCenterResource {

    @Autowired
    public IPimArchivesCenterService pimarchivescenterService;

    @Autowired
    @Lazy
    public PimArchivesCenterMapping pimarchivescenterMapping;

    @PreAuthorize("hasPermission(this.pimarchivescenterMapping.toDomain(#pimarchivescenterdto),'ehr-PimArchivesCenter-Save')")
    @ApiOperation(value = "Save", tags = {"PimArchivesCenter" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivescenters/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivesCenterDTO pimarchivescenterdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivescenterService.save(pimarchivescenterMapping.toDomain(pimarchivescenterdto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterMapping.toDomain(#pimarchivescenterdtos),'ehr-PimArchivesCenter-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimArchivesCenter" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivescenters/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivesCenterDTO> pimarchivescenterdtos) {
        pimarchivescenterService.saveBatch(pimarchivescenterMapping.toDomain(pimarchivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterService.get(#pimarchivescenter_id),'ehr-PimArchivesCenter-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimArchivesCenter" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivescenters/{pimarchivescenter_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivescenter_id") String pimarchivescenter_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivescenterService.remove(pimarchivescenter_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterService.getPimarchivescenterByIds(#ids),'ehr-PimArchivesCenter-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimArchivesCenter" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivescenters/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivescenterService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterMapping.toDomain(#pimarchivescenterdto),'ehr-PimArchivesCenter-Create')")
    @ApiOperation(value = "Create", tags = {"PimArchivesCenter" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivescenters")
    @Transactional
    public ResponseEntity<PimArchivesCenterDTO> create(@RequestBody PimArchivesCenterDTO pimarchivescenterdto) {
        PimArchivesCenter domain = pimarchivescenterMapping.toDomain(pimarchivescenterdto);
		pimarchivescenterService.create(domain);
        PimArchivesCenterDTO dto = pimarchivescenterMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterMapping.toDomain(#pimarchivescenterdtos),'ehr-PimArchivesCenter-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimArchivesCenter" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivescenters/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivesCenterDTO> pimarchivescenterdtos) {
        pimarchivescenterService.createBatch(pimarchivescenterMapping.toDomain(pimarchivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimArchivesCenter" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivescenters/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivesCenterDTO pimarchivescenterdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivescenterService.checkKey(pimarchivescenterMapping.toDomain(pimarchivescenterdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PimArchivesCenter" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivescenters/getdraft")
    public ResponseEntity<PimArchivesCenterDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivescenterMapping.toDto(pimarchivescenterService.getDraft(new PimArchivesCenter())));
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterService.get(#pimarchivescenter_id),'ehr-PimArchivesCenter-Update')")
    @ApiOperation(value = "Update", tags = {"PimArchivesCenter" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivescenters/{pimarchivescenter_id}")
    @Transactional
    public ResponseEntity<PimArchivesCenterDTO> update(@PathVariable("pimarchivescenter_id") String pimarchivescenter_id, @RequestBody PimArchivesCenterDTO pimarchivescenterdto) {
		PimArchivesCenter domain  = pimarchivescenterMapping.toDomain(pimarchivescenterdto);
        domain .setArchivescenterid(pimarchivescenter_id);
		pimarchivescenterService.update(domain );
		PimArchivesCenterDTO dto = pimarchivescenterMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivescenterService.getPimarchivescenterByEntities(this.pimarchivescenterMapping.toDomain(#pimarchivescenterdtos)),'ehr-PimArchivesCenter-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimArchivesCenter" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivescenters/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivesCenterDTO> pimarchivescenterdtos) {
        pimarchivescenterService.updateBatch(pimarchivescenterMapping.toDomain(pimarchivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchivescenterMapping.toDomain(returnObject.body),'ehr-PimArchivesCenter-Get')")
    @ApiOperation(value = "Get", tags = {"PimArchivesCenter" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivescenters/{pimarchivescenter_id}")
    public ResponseEntity<PimArchivesCenterDTO> get(@PathVariable("pimarchivescenter_id") String pimarchivescenter_id) {
        PimArchivesCenter domain = pimarchivescenterService.get(pimarchivescenter_id);
        PimArchivesCenterDTO dto = pimarchivescenterMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesCenter-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimArchivesCenter" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivescenters/fetchdefault")
	public ResponseEntity<List<PimArchivesCenterDTO>> fetchDefault(PimArchivesCenterSearchContext context) {
        Page<PimArchivesCenter> domains = pimarchivescenterService.searchDefault(context) ;
        List<PimArchivesCenterDTO> list = pimarchivescenterMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesCenter-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimArchivesCenter" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivescenters/searchdefault")
	public ResponseEntity<Page<PimArchivesCenterDTO>> searchDefault(@RequestBody PimArchivesCenterSearchContext context) {
        Page<PimArchivesCenter> domains = pimarchivescenterService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivescenterMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

