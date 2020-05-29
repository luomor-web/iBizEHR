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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemand;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDemandSearchContext;

@Slf4j
@Api(tags = {"TrmTrainDemand" })
@RestController("WebApi-trmtraindemand")
@RequestMapping("")
public class TrmTrainDemandResource {

    @Autowired
    public ITrmTrainDemandService trmtraindemandService;

    @Autowired
    @Lazy
    public TrmTrainDemandMapping trmtraindemandMapping;

    @PreAuthorize("hasPermission(this.trmtraindemandService.get(#trmtraindemand_id),'ehr-TrmTrainDemand-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainDemand" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemands/{trmtraindemand_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindemand_id") String trmtraindemand_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.remove(trmtraindemand_id));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.getTrmtraindemandByIds(#ids),'ehr-TrmTrainDemand-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainDemand" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindemandService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.get(#trmtraindemand_id),'ehr-TrmTrainDemand-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainDemand" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemands/{trmtraindemand_id}")
    @Transactional
    public ResponseEntity<TrmTrainDemandDTO> update(@PathVariable("trmtraindemand_id") String trmtraindemand_id, @RequestBody TrmTrainDemandDTO trmtraindemanddto) {
		TrmTrainDemand domain  = trmtraindemandMapping.toDomain(trmtraindemanddto);
        domain .setTrmtraindemandid(trmtraindemand_id);
		trmtraindemandService.update(domain );
		TrmTrainDemandDTO dto = trmtraindemandMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandService.getTrmtraindemandByEntities(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos)),'ehr-TrmTrainDemand-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainDemand" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainDemandDTO> trmtraindemanddtos) {
        trmtraindemandService.updateBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddto),'ehr-TrmTrainDemand-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainDemand" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainDemandDTO trmtraindemanddto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.save(trmtraindemandMapping.toDomain(trmtraindemanddto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos),'ehr-TrmTrainDemand-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainDemand" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainDemandDTO> trmtraindemanddtos) {
        trmtraindemandService.saveBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainDemand" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainDemandDTO trmtraindemanddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindemandService.checkKey(trmtraindemandMapping.toDomain(trmtraindemanddto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainDemand" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemands/getdraft")
    public ResponseEntity<TrmTrainDemandDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandMapping.toDto(trmtraindemandService.getDraft(new TrmTrainDemand())));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddto),'ehr-TrmTrainDemand-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainDemand" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands")
    @Transactional
    public ResponseEntity<TrmTrainDemandDTO> create(@RequestBody TrmTrainDemandDTO trmtraindemanddto) {
        TrmTrainDemand domain = trmtraindemandMapping.toDomain(trmtraindemanddto);
		trmtraindemandService.create(domain);
        TrmTrainDemandDTO dto = trmtraindemandMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(#trmtraindemanddtos),'ehr-TrmTrainDemand-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainDemand" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemands/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainDemandDTO> trmtraindemanddtos) {
        trmtraindemandService.createBatch(trmtraindemandMapping.toDomain(trmtraindemanddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtraindemandMapping.toDomain(returnObject.body),'ehr-TrmTrainDemand-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainDemand" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemands/{trmtraindemand_id}")
    public ResponseEntity<TrmTrainDemandDTO> get(@PathVariable("trmtraindemand_id") String trmtraindemand_id) {
        TrmTrainDemand domain = trmtraindemandService.get(trmtraindemand_id);
        TrmTrainDemandDTO dto = trmtraindemandMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainDemand-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainDemand" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindemands/fetchdefault")
	public ResponseEntity<List<TrmTrainDemandDTO>> fetchDefault(TrmTrainDemandSearchContext context) {
        Page<TrmTrainDemand> domains = trmtraindemandService.searchDefault(context) ;
        List<TrmTrainDemandDTO> list = trmtraindemandMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainDemand-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainDemand" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindemands/searchdefault")
	public ResponseEntity<Page<TrmTrainDemandDTO>> searchDefault(@RequestBody TrmTrainDemandSearchContext context) {
        Page<TrmTrainDemand> domains = trmtraindemandService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindemandMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

