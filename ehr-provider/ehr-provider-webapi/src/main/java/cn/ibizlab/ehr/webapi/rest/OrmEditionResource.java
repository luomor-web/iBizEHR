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
import cn.ibizlab.ehr.core.orm.domain.OrmEdition;
import cn.ibizlab.ehr.core.orm.service.IOrmEditionService;
import cn.ibizlab.ehr.core.orm.filter.OrmEditionSearchContext;

@Slf4j
@Api(tags = {"OrmEdition" })
@RestController("WebApi-ormedition")
@RequestMapping("")
public class OrmEditionResource {

    @Autowired
    public IOrmEditionService ormeditionService;

    @Autowired
    @Lazy
    public OrmEditionMapping ormeditionMapping;

    @PreAuthorize("hasPermission(this.ormeditionService.get(#ormedition_id),'ehr-OrmEdition-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmEdition" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormedition_id") String ormedition_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.remove(ormedition_id));
    }

    @PreAuthorize("hasPermission(this.ormeditionService.getOrmeditionByIds(#ids),'ehr-OrmEdition-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmEdition" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormeditionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondto),'ehr-OrmEdition-Create')")
    @ApiOperation(value = "Create", tags = {"OrmEdition" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions")
    @Transactional
    public ResponseEntity<OrmEditionDTO> create(@RequestBody OrmEditionDTO ormeditiondto) {
        OrmEdition domain = ormeditionMapping.toDomain(ormeditiondto);
		ormeditionService.create(domain);
        OrmEditionDTO dto = ormeditionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondtos),'ehr-OrmEdition-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmEdition" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.createBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondto),'ehr-OrmEdition-Save')")
    @ApiOperation(value = "Save", tags = {"OrmEdition" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmEditionDTO ormeditiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.save(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PreAuthorize("hasPermission(this.ormeditionMapping.toDomain(#ormeditiondtos),'ehr-OrmEdition-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmEdition" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.saveBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmEdition" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/getdraft")
    public ResponseEntity<OrmEditionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionMapping.toDto(ormeditionService.getDraft(new OrmEdition())));
    }

    @PreAuthorize("hasPermission(this.ormeditionService.get(#ormedition_id),'ehr-OrmEdition-Update')")
    @ApiOperation(value = "Update", tags = {"OrmEdition" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<OrmEditionDTO> update(@PathVariable("ormedition_id") String ormedition_id, @RequestBody OrmEditionDTO ormeditiondto) {
		OrmEdition domain  = ormeditionMapping.toDomain(ormeditiondto);
        domain .setOrmeditionid(ormedition_id);
		ormeditionService.update(domain );
		OrmEditionDTO dto = ormeditionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormeditionService.getOrmeditionByEntities(this.ormeditionMapping.toDomain(#ormeditiondtos)),'ehr-OrmEdition-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmEdition" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmEditionDTO> ormeditiondtos) {
        ormeditionService.updateBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmEdition" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmEditionDTO ormeditiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormeditionService.checkKey(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PostAuthorize("hasPermission(this.ormeditionMapping.toDomain(returnObject.body),'ehr-OrmEdition-Get')")
    @ApiOperation(value = "Get", tags = {"OrmEdition" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/{ormedition_id}")
    public ResponseEntity<OrmEditionDTO> get(@PathVariable("ormedition_id") String ormedition_id) {
        OrmEdition domain = ormeditionService.get(ormedition_id);
        OrmEditionDTO dto = ormeditionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmEdition-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmEdition" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormeditions/fetchdefault")
	public ResponseEntity<List<OrmEditionDTO>> fetchDefault(OrmEditionSearchContext context) {
        Page<OrmEdition> domains = ormeditionService.searchDefault(context) ;
        List<OrmEditionDTO> list = ormeditionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmEdition-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmEdition" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormeditions/searchdefault")
	public ResponseEntity<Page<OrmEditionDTO>> searchDefault(@RequestBody OrmEditionSearchContext context) {
        Page<OrmEdition> domains = ormeditionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormeditionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

