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
import cn.ibizlab.ehr.core.orm.domain.OrmRelation;
import cn.ibizlab.ehr.core.orm.service.IOrmRelationService;
import cn.ibizlab.ehr.core.orm.filter.OrmRelationSearchContext;

@Slf4j
@Api(tags = {"OrmRelation" })
@RestController("WebApi-ormrelation")
@RequestMapping("")
public class OrmRelationResource {

    @Autowired
    public IOrmRelationService ormrelationService;

    @Autowired
    @Lazy
    public OrmRelationMapping ormrelationMapping;

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdto),'ehr-OrmRelation-Create')")
    @ApiOperation(value = "Create", tags = {"OrmRelation" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations")
    @Transactional
    public ResponseEntity<OrmRelationDTO> create(@RequestBody OrmRelationDTO ormrelationdto) {
        OrmRelation domain = ormrelationMapping.toDomain(ormrelationdto);
		ormrelationService.create(domain);
        OrmRelationDTO dto = ormrelationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdtos),'ehr-OrmRelation-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmRelation" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.createBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.get(#ormrelation_id),'ehr-OrmRelation-Update')")
    @ApiOperation(value = "Update", tags = {"OrmRelation" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<OrmRelationDTO> update(@PathVariable("ormrelation_id") String ormrelation_id, @RequestBody OrmRelationDTO ormrelationdto) {
		OrmRelation domain  = ormrelationMapping.toDomain(ormrelationdto);
        domain .setOrmorgrelationid(ormrelation_id);
		ormrelationService.update(domain );
		OrmRelationDTO dto = ormrelationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.getOrmrelationByEntities(this.ormrelationMapping.toDomain(#ormrelationdtos)),'ehr-OrmRelation-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmRelation" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.updateBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormrelationMapping.toDomain(returnObject.body),'ehr-OrmRelation-Get')")
    @ApiOperation(value = "Get", tags = {"OrmRelation" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/{ormrelation_id}")
    public ResponseEntity<OrmRelationDTO> get(@PathVariable("ormrelation_id") String ormrelation_id) {
        OrmRelation domain = ormrelationService.get(ormrelation_id);
        OrmRelationDTO dto = ormrelationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.get(#ormrelation_id),'ehr-OrmRelation-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmRelation" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormrelation_id") String ormrelation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.remove(ormrelation_id));
    }

    @PreAuthorize("hasPermission(this.ormrelationService.getOrmrelationByIds(#ids),'ehr-OrmRelation-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmRelation" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormrelationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmRelation" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/getdraft")
    public ResponseEntity<OrmRelationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationMapping.toDto(ormrelationService.getDraft(new OrmRelation())));
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmRelation" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmRelationDTO ormrelationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormrelationService.checkKey(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdto),'ehr-OrmRelation-Save')")
    @ApiOperation(value = "Save", tags = {"OrmRelation" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmRelationDTO ormrelationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.save(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdtos),'ehr-OrmRelation-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmRelation" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.saveBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRelation-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmRelation" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormrelations/fetchdefault")
	public ResponseEntity<List<OrmRelationDTO>> fetchDefault(OrmRelationSearchContext context) {
        Page<OrmRelation> domains = ormrelationService.searchDefault(context) ;
        List<OrmRelationDTO> list = ormrelationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRelation-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmRelation" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormrelations/searchdefault")
	public ResponseEntity<Page<OrmRelationDTO>> searchDefault(@RequestBody OrmRelationSearchContext context) {
        Page<OrmRelation> domains = ormrelationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrelationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

