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
import cn.ibizlab.ehr.core.par.domain.ParJzszpsjg;
import cn.ibizlab.ehr.core.par.service.IParJzszpsjgService;
import cn.ibizlab.ehr.core.par.filter.ParJzszpsjgSearchContext;

@Slf4j
@Api(tags = {"ParJzszpsjg" })
@RestController("WebApi-parjzszpsjg")
@RequestMapping("")
public class ParJzszpsjgResource {

    @Autowired
    public IParJzszpsjgService parjzszpsjgService;

    @Autowired
    @Lazy
    public ParJzszpsjgMapping parjzszpsjgMapping;

    @PostAuthorize("hasPermission(this.parjzszpsjgMapping.toDomain(returnObject.body),'ehr-ParJzszpsjg-Get')")
    @ApiOperation(value = "Get", tags = {"ParJzszpsjg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    public ResponseEntity<ParJzszpsjgDTO> get(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id) {
        ParJzszpsjg domain = parjzszpsjgService.get(parjzszpsjg_id);
        ParJzszpsjgDTO dto = parjzszpsjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgService.get(#parjzszpsjg_id),'ehr-ParJzszpsjg-Update')")
    @ApiOperation(value = "Update", tags = {"ParJzszpsjg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    @Transactional
    public ResponseEntity<ParJzszpsjgDTO> update(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id, @RequestBody ParJzszpsjgDTO parjzszpsjgdto) {
		ParJzszpsjg domain  = parjzszpsjgMapping.toDomain(parjzszpsjgdto);
        domain .setParjzszpsjgid(parjzszpsjg_id);
		parjzszpsjgService.update(domain );
		ParJzszpsjgDTO dto = parjzszpsjgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgService.getParjzszpsjgByEntities(this.parjzszpsjgMapping.toDomain(#parjzszpsjgdtos)),'ehr-ParJzszpsjg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJzszpsjg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJzszpsjgDTO> parjzszpsjgdtos) {
        parjzszpsjgService.updateBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgMapping.toDomain(#parjzszpsjgdto),'ehr-ParJzszpsjg-Save')")
    @ApiOperation(value = "Save", tags = {"ParJzszpsjg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJzszpsjgDTO parjzszpsjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.save(parjzszpsjgMapping.toDomain(parjzszpsjgdto)));
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgMapping.toDomain(#parjzszpsjgdtos),'ehr-ParJzszpsjg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJzszpsjg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJzszpsjgDTO> parjzszpsjgdtos) {
        parjzszpsjgService.saveBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParJzszpsjg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJzszpsjgDTO parjzszpsjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.checkKey(parjzszpsjgMapping.toDomain(parjzszpsjgdto)));
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgService.get(#parjzszpsjg_id),'ehr-ParJzszpsjg-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJzszpsjg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.remove(parjzszpsjg_id));
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgService.getParjzszpsjgByIds(#ids),'ehr-ParJzszpsjg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJzszpsjg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjzszpsjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJzszpsjg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjzszpsjgs/getdraft")
    public ResponseEntity<ParJzszpsjgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgMapping.toDto(parjzszpsjgService.getDraft(new ParJzszpsjg())));
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgMapping.toDomain(#parjzszpsjgdto),'ehr-ParJzszpsjg-Create')")
    @ApiOperation(value = "Create", tags = {"ParJzszpsjg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs")
    @Transactional
    public ResponseEntity<ParJzszpsjgDTO> create(@RequestBody ParJzszpsjgDTO parjzszpsjgdto) {
        ParJzszpsjg domain = parjzszpsjgMapping.toDomain(parjzszpsjgdto);
		parjzszpsjgService.create(domain);
        ParJzszpsjgDTO dto = parjzszpsjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjzszpsjgMapping.toDomain(#parjzszpsjgdtos),'ehr-ParJzszpsjg-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJzszpsjg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJzszpsjgDTO> parjzszpsjgdtos) {
        parjzszpsjgService.createBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJzszpsjg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJzszpsjg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjzszpsjgs/fetchdefault")
	public ResponseEntity<List<ParJzszpsjgDTO>> fetchDefault(ParJzszpsjgSearchContext context) {
        Page<ParJzszpsjg> domains = parjzszpsjgService.searchDefault(context) ;
        List<ParJzszpsjgDTO> list = parjzszpsjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJzszpsjg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJzszpsjg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjzszpsjgs/searchdefault")
	public ResponseEntity<Page<ParJzszpsjgDTO>> searchDefault(@RequestBody ParJzszpsjgSearchContext context) {
        Page<ParJzszpsjg> domains = parjzszpsjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjzszpsjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

