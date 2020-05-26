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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMANDSUM;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDSUMService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDEMANDSUMSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINDEMANDSUM" })
@RestController("WebApi-trmtraindemandsum")
@RequestMapping("")
public class TRMTRAINDEMANDSUMResource {

    @Autowired
    private ITRMTRAINDEMANDSUMService trmtraindemandsumService;

    @Autowired
    @Lazy
    public TRMTRAINDEMANDSUMMapping trmtraindemandsumMapping;

    public TRMTRAINDEMANDSUMDTO permissionDTO=new TRMTRAINDEMANDSUMDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdto})")
    @ApiOperation(value = "Save", tags = {"TRMTRAINDEMANDSUM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINDEMANDSUMDTO trmtraindemandsumdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.save(trmtraindemandsumMapping.toDomain(trmtraindemandsumdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINDEMANDSUM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINDEMANDSUMDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.saveBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtraindemandsum_id,'Get',{'Sql',this.trmtraindemandsumMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINDEMANDSUM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    public ResponseEntity<TRMTRAINDEMANDSUMDTO> get(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id) {
        TRMTRAINDEMANDSUM domain = trmtraindemandsumService.get(trmtraindemandsum_id);
        TRMTRAINDEMANDSUMDTO dto = trmtraindemandsumMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINDEMANDSUM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums")
    @Transactional
    public ResponseEntity<TRMTRAINDEMANDSUMDTO> create(@RequestBody TRMTRAINDEMANDSUMDTO trmtraindemandsumdto) {
        TRMTRAINDEMANDSUM domain = trmtraindemandsumMapping.toDomain(trmtraindemandsumdto);
		trmtraindemandsumService.create(domain);
        TRMTRAINDEMANDSUMDTO dto = trmtraindemandsumMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINDEMANDSUM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINDEMANDSUMDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.createBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtraindemandsum_id,'Remove',{'Sql',this.trmtraindemandsumMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINDEMANDSUM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.remove(trmtraindemandsum_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtraindemandsumMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINDEMANDSUM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindemandsumService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMANDSUM-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINDEMANDSUM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemandsums/getdraft")
    public ResponseEntity<TRMTRAINDEMANDSUMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumMapping.toDto(trmtraindemandsumService.getDraft(new TRMTRAINDEMANDSUM())));
    }

    @PreAuthorize("hasPermission(#trmtraindemandsum_id,'Update',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINDEMANDSUM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    @Transactional
    public ResponseEntity<TRMTRAINDEMANDSUMDTO> update(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id, @RequestBody TRMTRAINDEMANDSUMDTO trmtraindemandsumdto) {
		TRMTRAINDEMANDSUM domain  = trmtraindemandsumMapping.toDomain(trmtraindemandsumdto);
        domain .setTrmtraindemandsumid(trmtraindemandsum_id);
		trmtraindemandsumService.update(domain );
		TRMTRAINDEMANDSUMDTO dto = trmtraindemandsumMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtraindemandsumMapping,#trmtraindemandsumdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINDEMANDSUM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINDEMANDSUMDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.updateBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMANDSUM-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINDEMANDSUM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINDEMANDSUMDTO trmtraindemandsumdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.checkKey(trmtraindemandsumMapping.toDomain(trmtraindemandsumdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMANDSUM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINDEMANDSUM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindemandsums/fetchdefault")
	public ResponseEntity<List<TRMTRAINDEMANDSUMDTO>> fetchDefault(TRMTRAINDEMANDSUMSearchContext context) {
        Page<TRMTRAINDEMANDSUM> domains = trmtraindemandsumService.searchDefault(context) ;
        List<TRMTRAINDEMANDSUMDTO> list = trmtraindemandsumMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMANDSUM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINDEMANDSUM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindemandsums/searchdefault")
	public ResponseEntity<Page<TRMTRAINDEMANDSUMDTO>> searchDefault(@RequestBody TRMTRAINDEMANDSUMSearchContext context) {
        Page<TRMTRAINDEMANDSUM> domains = trmtraindemandsumService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindemandsumMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
