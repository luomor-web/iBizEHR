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
import cn.ibizlab.ehr.core.par.domain.ParJxjg;
import cn.ibizlab.ehr.core.par.service.IParJxjgService;
import cn.ibizlab.ehr.core.par.filter.ParJxjgSearchContext;

@Slf4j
@Api(tags = {"ParJxjg" })
@RestController("WebApi-parjxjg")
@RequestMapping("")
public class ParJxjgResource {

    @Autowired
    public IParJxjgService parjxjgService;

    @Autowired
    @Lazy
    public ParJxjgMapping parjxjgMapping;

    @ApiOperation(value = "GetDraft", tags = {"ParJxjg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxjgs/getdraft")
    public ResponseEntity<ParJxjgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxjgMapping.toDto(parjxjgService.getDraft(new ParJxjg())));
    }

    @ApiOperation(value = "CheckKey", tags = {"ParJxjg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxjgDTO parjxjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxjgService.checkKey(parjxjgMapping.toDomain(parjxjgdto)));
    }

    @PreAuthorize("hasPermission(this.parjxjgMapping.toDomain(#parjxjgdto),'ehr-ParJxjg-Create')")
    @ApiOperation(value = "Create", tags = {"ParJxjg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs")
    @Transactional
    public ResponseEntity<ParJxjgDTO> create(@RequestBody ParJxjgDTO parjxjgdto) {
        ParJxjg domain = parjxjgMapping.toDomain(parjxjgdto);
		parjxjgService.create(domain);
        ParJxjgDTO dto = parjxjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxjgMapping.toDomain(#parjxjgdtos),'ehr-ParJxjg-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJxjg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxjgDTO> parjxjgdtos) {
        parjxjgService.createBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxjgMapping.toDomain(#parjxjgdto),'ehr-ParJxjg-Save')")
    @ApiOperation(value = "Save", tags = {"ParJxjg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxjgDTO parjxjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxjgService.save(parjxjgMapping.toDomain(parjxjgdto)));
    }

    @PreAuthorize("hasPermission(this.parjxjgMapping.toDomain(#parjxjgdtos),'ehr-ParJxjg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJxjg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxjgDTO> parjxjgdtos) {
        parjxjgService.saveBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxjgMapping.toDomain(returnObject.body),'ehr-ParJxjg-Get')")
    @ApiOperation(value = "Get", tags = {"ParJxjg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxjgs/{parjxjg_id}")
    public ResponseEntity<ParJxjgDTO> get(@PathVariable("parjxjg_id") String parjxjg_id) {
        ParJxjg domain = parjxjgService.get(parjxjg_id);
        ParJxjgDTO dto = parjxjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxjgService.get(#parjxjg_id),'ehr-ParJxjg-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJxjg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxjgs/{parjxjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxjg_id") String parjxjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxjgService.remove(parjxjg_id));
    }

    @PreAuthorize("hasPermission(this.parjxjgService.getParjxjgByIds(#ids),'ehr-ParJxjg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJxjg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxjgService.get(#parjxjg_id),'ehr-ParJxjg-Update')")
    @ApiOperation(value = "Update", tags = {"ParJxjg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxjgs/{parjxjg_id}")
    @Transactional
    public ResponseEntity<ParJxjgDTO> update(@PathVariable("parjxjg_id") String parjxjg_id, @RequestBody ParJxjgDTO parjxjgdto) {
		ParJxjg domain  = parjxjgMapping.toDomain(parjxjgdto);
        domain .setParjxjgid(parjxjg_id);
		parjxjgService.update(domain );
		ParJxjgDTO dto = parjxjgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxjgService.getParjxjgByEntities(this.parjxjgMapping.toDomain(#parjxjgdtos)),'ehr-ParJxjg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJxjg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxjgDTO> parjxjgdtos) {
        parjxjgService.updateBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxjg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJxjg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxjgs/fetchdefault")
	public ResponseEntity<List<ParJxjgDTO>> fetchDefault(ParJxjgSearchContext context) {
        Page<ParJxjg> domains = parjxjgService.searchDefault(context) ;
        List<ParJxjgDTO> list = parjxjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxjg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJxjg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxjgs/searchdefault")
	public ResponseEntity<Page<ParJxjgDTO>> searchDefault(@RequestBody ParJxjgSearchContext context) {
        Page<ParJxjg> domains = parjxjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

