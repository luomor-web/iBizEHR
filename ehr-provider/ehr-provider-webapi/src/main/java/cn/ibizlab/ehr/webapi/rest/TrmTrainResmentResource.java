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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainResment;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainResmentService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainResmentSearchContext;

@Slf4j
@Api(tags = {"TrmTrainResment" })
@RestController("WebApi-trmtrainresment")
@RequestMapping("")
public class TrmTrainResmentResource {

    @Autowired
    public ITrmTrainResmentService trmtrainresmentService;

    @Autowired
    @Lazy
    public TrmTrainResmentMapping trmtrainresmentMapping;

    @PreAuthorize("hasPermission(this.trmtrainresmentService.get(#trmtrainresment_id),'ehr-TrmTrainResment-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainResment" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainresments/{trmtrainresment_id}")
    @Transactional
    public ResponseEntity<TrmTrainResmentDTO> update(@PathVariable("trmtrainresment_id") String trmtrainresment_id, @RequestBody TrmTrainResmentDTO trmtrainresmentdto) {
		TrmTrainResment domain  = trmtrainresmentMapping.toDomain(trmtrainresmentdto);
        domain .setTrmtrainresmentid(trmtrainresment_id);
		trmtrainresmentService.update(domain );
		TrmTrainResmentDTO dto = trmtrainresmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentService.getTrmtrainresmentByEntities(this.trmtrainresmentMapping.toDomain(#trmtrainresmentdtos)),'ehr-TrmTrainResment-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainResment" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainResmentDTO> trmtrainresmentdtos) {
        trmtrainresmentService.updateBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainResment" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainresments/getdraft")
    public ResponseEntity<TrmTrainResmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentMapping.toDto(trmtrainresmentService.getDraft(new TrmTrainResment())));
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentMapping.toDomain(#trmtrainresmentdto),'ehr-TrmTrainResment-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainResment" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainResmentDTO trmtrainresmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.save(trmtrainresmentMapping.toDomain(trmtrainresmentdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentMapping.toDomain(#trmtrainresmentdtos),'ehr-TrmTrainResment-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainResment" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainResmentDTO> trmtrainresmentdtos) {
        trmtrainresmentService.saveBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainResment" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainResmentDTO trmtrainresmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.checkKey(trmtrainresmentMapping.toDomain(trmtrainresmentdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentMapping.toDomain(#trmtrainresmentdto),'ehr-TrmTrainResment-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainResment" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments")
    @Transactional
    public ResponseEntity<TrmTrainResmentDTO> create(@RequestBody TrmTrainResmentDTO trmtrainresmentdto) {
        TrmTrainResment domain = trmtrainresmentMapping.toDomain(trmtrainresmentdto);
		trmtrainresmentService.create(domain);
        TrmTrainResmentDTO dto = trmtrainresmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentMapping.toDomain(#trmtrainresmentdtos),'ehr-TrmTrainResment-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainResment" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainResmentDTO> trmtrainresmentdtos) {
        trmtrainresmentService.createBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentService.get(#trmtrainresment_id),'ehr-TrmTrainResment-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainResment" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainresments/{trmtrainresment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainresment_id") String trmtrainresment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.remove(trmtrainresment_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainresmentService.getTrmtrainresmentByIds(#ids),'ehr-TrmTrainResment-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainResment" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainresmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainresmentMapping.toDomain(returnObject.body),'ehr-TrmTrainResment-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainResment" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainresments/{trmtrainresment_id}")
    public ResponseEntity<TrmTrainResmentDTO> get(@PathVariable("trmtrainresment_id") String trmtrainresment_id) {
        TrmTrainResment domain = trmtrainresmentService.get(trmtrainresment_id);
        TrmTrainResmentDTO dto = trmtrainresmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainResment-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainResment" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainresments/fetchdefault")
	public ResponseEntity<List<TrmTrainResmentDTO>> fetchDefault(TrmTrainResmentSearchContext context) {
        Page<TrmTrainResment> domains = trmtrainresmentService.searchDefault(context) ;
        List<TrmTrainResmentDTO> list = trmtrainresmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainResment-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainResment" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainresments/searchdefault")
	public ResponseEntity<Page<TrmTrainResmentDTO>> searchDefault(@RequestBody TrmTrainResmentSearchContext context) {
        Page<TrmTrainResment> domains = trmtrainresmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainresmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

