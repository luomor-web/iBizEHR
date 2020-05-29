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
import cn.ibizlab.ehr.core.par.domain.ParJxkhmb;
import cn.ibizlab.ehr.core.par.service.IParJxkhmbService;
import cn.ibizlab.ehr.core.par.filter.ParJxkhmbSearchContext;

@Slf4j
@Api(tags = {"ParJxkhmb" })
@RestController("WebApi-parjxkhmb")
@RequestMapping("")
public class ParJxkhmbResource {

    @Autowired
    public IParJxkhmbService parjxkhmbService;

    @Autowired
    @Lazy
    public ParJxkhmbMapping parjxkhmbMapping;

    @ApiOperation(value = "CheckKey", tags = {"ParJxkhmb" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxkhmbDTO parjxkhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.checkKey(parjxkhmbMapping.toDomain(parjxkhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.get(#parjxkhmb_id),'ehr-ParJxkhmb-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJxkhmb" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbs/{parjxkhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhmb_id") String parjxkhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.remove(parjxkhmb_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.getParjxkhmbByIds(#ids),'ehr-ParJxkhmb-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJxkhmb" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(returnObject.body),'ehr-ParJxkhmb-Get')")
    @ApiOperation(value = "Get", tags = {"ParJxkhmb" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbs/{parjxkhmb_id}")
    public ResponseEntity<ParJxkhmbDTO> get(@PathVariable("parjxkhmb_id") String parjxkhmb_id) {
        ParJxkhmb domain = parjxkhmbService.get(parjxkhmb_id);
        ParJxkhmbDTO dto = parjxkhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdto),'ehr-ParJxkhmb-Create')")
    @ApiOperation(value = "Create", tags = {"ParJxkhmb" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs")
    @Transactional
    public ResponseEntity<ParJxkhmbDTO> create(@RequestBody ParJxkhmbDTO parjxkhmbdto) {
        ParJxkhmb domain = parjxkhmbMapping.toDomain(parjxkhmbdto);
		parjxkhmbService.create(domain);
        ParJxkhmbDTO dto = parjxkhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos),'ehr-ParJxkhmb-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJxkhmb" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxkhmbDTO> parjxkhmbdtos) {
        parjxkhmbService.createBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJxkhmb" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbs/getdraft")
    public ResponseEntity<ParJxkhmbDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbMapping.toDto(parjxkhmbService.getDraft(new ParJxkhmb())));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdto),'ehr-ParJxkhmb-Save')")
    @ApiOperation(value = "Save", tags = {"ParJxkhmb" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxkhmbDTO parjxkhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.save(parjxkhmbMapping.toDomain(parjxkhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos),'ehr-ParJxkhmb-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJxkhmb" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxkhmbDTO> parjxkhmbdtos) {
        parjxkhmbService.saveBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.get(#parjxkhmb_id),'ehr-ParJxkhmb-Update')")
    @ApiOperation(value = "Update", tags = {"ParJxkhmb" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbs/{parjxkhmb_id}")
    @Transactional
    public ResponseEntity<ParJxkhmbDTO> update(@PathVariable("parjxkhmb_id") String parjxkhmb_id, @RequestBody ParJxkhmbDTO parjxkhmbdto) {
		ParJxkhmb domain  = parjxkhmbMapping.toDomain(parjxkhmbdto);
        domain .setParjxkhmbid(parjxkhmb_id);
		parjxkhmbService.update(domain );
		ParJxkhmbDTO dto = parjxkhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.getParjxkhmbByEntities(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos)),'ehr-ParJxkhmb-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJxkhmb" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxkhmbDTO> parjxkhmbdtos) {
        parjxkhmbService.updateBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhmb-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJxkhmb" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhmbs/fetchdefault")
	public ResponseEntity<List<ParJxkhmbDTO>> fetchDefault(ParJxkhmbSearchContext context) {
        Page<ParJxkhmb> domains = parjxkhmbService.searchDefault(context) ;
        List<ParJxkhmbDTO> list = parjxkhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhmb-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJxkhmb" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhmbs/searchdefault")
	public ResponseEntity<Page<ParJxkhmbDTO>> searchDefault(@RequestBody ParJxkhmbSearchContext context) {
        Page<ParJxkhmb> domains = parjxkhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

