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
import cn.ibizlab.ehr.core.orm.domain.ORMRelation;
import cn.ibizlab.ehr.core.orm.service.IORMRelationService;
import cn.ibizlab.ehr.core.orm.filter.ORMRelationSearchContext;

@Slf4j
@Api(tags = {"ORMRelation" })
@RestController("WebApi-ormrelation")
@RequestMapping("")
public class ORMRelationResource {

    @Autowired
    private IORMRelationService ormrelationService;

    @Autowired
    @Lazy
    public ORMRelationMapping ormrelationMapping;

    public ORMRelationDTO permissionDTO=new ORMRelationDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormrelationMapping,#ormrelationdto})")
    @ApiOperation(value = "Create", tags = {"ORMRelation" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations")
    @Transactional
    public ResponseEntity<ORMRelationDTO> create(@RequestBody ORMRelationDTO ormrelationdto) {
        ORMRelation domain = ormrelationMapping.toDomain(ormrelationdto);
		ormrelationService.create(domain);
        ORMRelationDTO dto = ormrelationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormrelationMapping,#ormrelationdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMRelation" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMRelationDTO> ormrelationdtos) {
        ormrelationService.createBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormrelation_id,'Update',{'Sql',this.ormrelationMapping,#ormrelationdto})")
    @ApiOperation(value = "Update", tags = {"ORMRelation" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<ORMRelationDTO> update(@PathVariable("ormrelation_id") String ormrelation_id, @RequestBody ORMRelationDTO ormrelationdto) {
		ORMRelation domain  = ormrelationMapping.toDomain(ormrelationdto);
        domain .setOrmorgrelationid(ormrelation_id);
		ormrelationService.update(domain );
		ORMRelationDTO dto = ormrelationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormrelationMapping,#ormrelationdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMRelation" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMRelationDTO> ormrelationdtos) {
        ormrelationService.updateBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormrelation_id,'Get',{'Sql',this.ormrelationMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMRelation" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/{ormrelation_id}")
    public ResponseEntity<ORMRelationDTO> get(@PathVariable("ormrelation_id") String ormrelation_id) {
        ORMRelation domain = ormrelationService.get(ormrelation_id);
        ORMRelationDTO dto = ormrelationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormrelation_id,'Remove',{'Sql',this.ormrelationMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMRelation" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormrelation_id") String ormrelation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.remove(ormrelation_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormrelationMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMRelation" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormrelationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRelation-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMRelation" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/getdraft")
    public ResponseEntity<ORMRelationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationMapping.toDto(ormrelationService.getDraft(new ORMRelation())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRelation-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMRelation" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMRelationDTO ormrelationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormrelationService.checkKey(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormrelationMapping,#ormrelationdto})")
    @ApiOperation(value = "Save", tags = {"ORMRelation" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMRelationDTO ormrelationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.save(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormrelationMapping,#ormrelationdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMRelation" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMRelationDTO> ormrelationdtos) {
        ormrelationService.saveBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRelation-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMRelation" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormrelations/fetchdefault")
	public ResponseEntity<List<ORMRelationDTO>> fetchDefault(ORMRelationSearchContext context) {
        Page<ORMRelation> domains = ormrelationService.searchDefault(context) ;
        List<ORMRelationDTO> list = ormrelationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRelation-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMRelation" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormrelations/searchdefault")
	public ResponseEntity<Page<ORMRelationDTO>> searchDefault(@RequestBody ORMRelationSearchContext context) {
        Page<ORMRelation> domains = ormrelationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrelationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
