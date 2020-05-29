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
import cn.ibizlab.ehr.core.par.domain.ParJxndkhjg;
import cn.ibizlab.ehr.core.par.service.IParJxndkhjgService;
import cn.ibizlab.ehr.core.par.filter.ParJxndkhjgSearchContext;

@Slf4j
@Api(tags = {"ParJxndkhjg" })
@RestController("WebApi-parjxndkhjg")
@RequestMapping("")
public class ParJxndkhjgResource {

    @Autowired
    public IParJxndkhjgService parjxndkhjgService;

    @Autowired
    @Lazy
    public ParJxndkhjgMapping parjxndkhjgMapping;

    @PreAuthorize("hasPermission(this.parjxndkhjgMapping.toDomain(#parjxndkhjgdto),'ehr-ParJxndkhjg-Save')")
    @ApiOperation(value = "Save", tags = {"ParJxndkhjg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxndkhjgDTO parjxndkhjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.save(parjxndkhjgMapping.toDomain(parjxndkhjgdto)));
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgMapping.toDomain(#parjxndkhjgdtos),'ehr-ParJxndkhjg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJxndkhjg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxndkhjgDTO> parjxndkhjgdtos) {
        parjxndkhjgService.saveBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgService.get(#parjxndkhjg_id),'ehr-ParJxndkhjg-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJxndkhjg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.remove(parjxndkhjg_id));
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgService.getParjxndkhjgByIds(#ids),'ehr-ParJxndkhjg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJxndkhjg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxndkhjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJxndkhjg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxndkhjgs/getdraft")
    public ResponseEntity<ParJxndkhjgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgMapping.toDto(parjxndkhjgService.getDraft(new ParJxndkhjg())));
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgMapping.toDomain(#parjxndkhjgdto),'ehr-ParJxndkhjg-Create')")
    @ApiOperation(value = "Create", tags = {"ParJxndkhjg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs")
    @Transactional
    public ResponseEntity<ParJxndkhjgDTO> create(@RequestBody ParJxndkhjgDTO parjxndkhjgdto) {
        ParJxndkhjg domain = parjxndkhjgMapping.toDomain(parjxndkhjgdto);
		parjxndkhjgService.create(domain);
        ParJxndkhjgDTO dto = parjxndkhjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgMapping.toDomain(#parjxndkhjgdtos),'ehr-ParJxndkhjg-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJxndkhjg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxndkhjgDTO> parjxndkhjgdtos) {
        parjxndkhjgService.createBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgService.get(#parjxndkhjg_id),'ehr-ParJxndkhjg-Update')")
    @ApiOperation(value = "Update", tags = {"ParJxndkhjg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    @Transactional
    public ResponseEntity<ParJxndkhjgDTO> update(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id, @RequestBody ParJxndkhjgDTO parjxndkhjgdto) {
		ParJxndkhjg domain  = parjxndkhjgMapping.toDomain(parjxndkhjgdto);
        domain .setParjxndkhjgid(parjxndkhjg_id);
		parjxndkhjgService.update(domain );
		ParJxndkhjgDTO dto = parjxndkhjgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxndkhjgService.getParjxndkhjgByEntities(this.parjxndkhjgMapping.toDomain(#parjxndkhjgdtos)),'ehr-ParJxndkhjg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJxndkhjg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxndkhjgDTO> parjxndkhjgdtos) {
        parjxndkhjgService.updateBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxndkhjgMapping.toDomain(returnObject.body),'ehr-ParJxndkhjg-Get')")
    @ApiOperation(value = "Get", tags = {"ParJxndkhjg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    public ResponseEntity<ParJxndkhjgDTO> get(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id) {
        ParJxndkhjg domain = parjxndkhjgService.get(parjxndkhjg_id);
        ParJxndkhjgDTO dto = parjxndkhjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParJxndkhjg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxndkhjgDTO parjxndkhjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.checkKey(parjxndkhjgMapping.toDomain(parjxndkhjgdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxndkhjg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJxndkhjg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/fetchdefault")
	public ResponseEntity<List<ParJxndkhjgDTO>> fetchDefault(ParJxndkhjgSearchContext context) {
        Page<ParJxndkhjg> domains = parjxndkhjgService.searchDefault(context) ;
        List<ParJxndkhjgDTO> list = parjxndkhjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxndkhjg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJxndkhjg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxndkhjgs/searchdefault")
	public ResponseEntity<Page<ParJxndkhjgDTO>> searchDefault(@RequestBody ParJxndkhjgSearchContext context) {
        Page<ParJxndkhjg> domains = parjxndkhjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxndkhjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxndkhjg-LastTwoYear-all')")
	@ApiOperation(value = "fetch最近2年下半年考核成绩", tags = {"ParJxndkhjg" } ,notes = "fetch最近2年下半年考核成绩")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/fetchlasttwoyear")
	public ResponseEntity<List<ParJxndkhjgDTO>> fetchLastTwoYear(ParJxndkhjgSearchContext context) {
        Page<ParJxndkhjg> domains = parjxndkhjgService.searchLastTwoYear(context) ;
        List<ParJxndkhjgDTO> list = parjxndkhjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxndkhjg-LastTwoYear-all')")
	@ApiOperation(value = "search最近2年下半年考核成绩", tags = {"ParJxndkhjg" } ,notes = "search最近2年下半年考核成绩")
    @RequestMapping(method= RequestMethod.POST , value="/parjxndkhjgs/searchlasttwoyear")
	public ResponseEntity<Page<ParJxndkhjgDTO>> searchLastTwoYear(@RequestBody ParJxndkhjgSearchContext context) {
        Page<ParJxndkhjg> domains = parjxndkhjgService.searchLastTwoYear(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxndkhjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

