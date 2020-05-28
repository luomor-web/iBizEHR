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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMAND;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDEMANDSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINDEMAND" })
@RestController("WebApi-trmtraindemand")
@RequestMapping("")
public class TRMTRAINDEMANDResource {

    @Autowired
    public ITRMTRAINDEMANDService trmtraindemandService;

    @Autowired
    @Lazy
    public TRMTRAINDEMANDMapping trmtraindemandMapping;

    @PreAuthorize("hasPermission(this.trmtraindemandService.get(#trmtraindemand_id),'ehr-TRMTRAINDEMAND-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINDEMAND" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemands/{trmtraindemand_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindemand_id") String trmtraindemand_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.remove(trmtraindemand_id));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.getTrmtraindemandByIds(#ids),'ehr-TRMTRAINDEMAND-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINDEMAND" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindemandService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.get(#trmtraindemand_id),'ehr-TRMTRAINDEMAND-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINDEMAND" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemands/{trmtraindemand_id}")
    @Transactional
    public ResponseEntity<TRMTRAINDEMANDDTO> update(@PathVariable("trmtraindemand_id") String trmtraindemand_id, @RequestBody TRMTRAINDEMANDDTO trmtraindemanddto) {
		TRMTRAINDEMAND domain  = trmtraindemandMapping.toDomain(trmtraindemanddto);
        domain .setTrmtraindemandid(trmtraindemand_id);
		trmtraindemandService.update(domain );
		TRMTRAINDEMANDDTO dto = trmtraindemandMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.getTrmtraindemandByEntities(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos)),'ehr-TRMTRAINDEMAND-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINDEMAND" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINDEMANDDTO> trmtraindemanddtos) {
        trmtraindemandService.updateBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddto),'ehr-TRMTRAINDEMAND-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINDEMAND" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINDEMANDDTO trmtraindemanddto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.save(trmtraindemandMapping.toDomain(trmtraindemanddto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos),'ehr-TRMTRAINDEMAND-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINDEMAND" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINDEMANDDTO> trmtraindemanddtos) {
        trmtraindemandService.saveBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINDEMAND" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINDEMANDDTO trmtraindemanddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.checkKey(trmtraindemandMapping.toDomain(trmtraindemanddto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINDEMAND" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemands/getdraft")
    public ResponseEntity<TRMTRAINDEMANDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandMapping.toDto(trmtraindemandService.getDraft(new TRMTRAINDEMAND())));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddto),'ehr-TRMTRAINDEMAND-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINDEMAND" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands")
    @Transactional
    public ResponseEntity<TRMTRAINDEMANDDTO> create(@RequestBody TRMTRAINDEMANDDTO trmtraindemanddto) {
        TRMTRAINDEMAND domain = trmtraindemandMapping.toDomain(trmtraindemanddto);
		trmtraindemandService.create(domain);
        TRMTRAINDEMANDDTO dto = trmtraindemandMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos),'ehr-TRMTRAINDEMAND-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINDEMAND" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINDEMANDDTO> trmtraindemanddtos) {
        trmtraindemandService.createBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(returnObject.body),'ehr-TRMTRAINDEMAND-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINDEMAND" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemands/{trmtraindemand_id}")
    public ResponseEntity<TRMTRAINDEMANDDTO> get(@PathVariable("trmtraindemand_id") String trmtraindemand_id) {
        TRMTRAINDEMAND domain = trmtraindemandService.get(trmtraindemand_id);
        TRMTRAINDEMANDDTO dto = trmtraindemandMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMAND-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINDEMAND" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindemands/fetchdefault")
	public ResponseEntity<List<TRMTRAINDEMANDDTO>> fetchDefault(TRMTRAINDEMANDSearchContext context) {
        Page<TRMTRAINDEMAND> domains = trmtraindemandService.searchDefault(context) ;
        List<TRMTRAINDEMANDDTO> list = trmtraindemandMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDEMAND-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINDEMAND" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindemands/searchdefault")
	public ResponseEntity<Page<TRMTRAINDEMANDDTO>> searchDefault(@RequestBody TRMTRAINDEMANDSearchContext context) {
        Page<TRMTRAINDEMAND> domains = trmtraindemandService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindemandMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

