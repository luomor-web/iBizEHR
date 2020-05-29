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
import cn.ibizlab.ehr.core.par.domain.ParLdkhqz;
import cn.ibizlab.ehr.core.par.service.IParLdkhqzService;
import cn.ibizlab.ehr.core.par.filter.ParLdkhqzSearchContext;

@Slf4j
@Api(tags = {"ParLdkhqz" })
@RestController("WebApi-parldkhqz")
@RequestMapping("")
public class ParLdkhqzResource {

    @Autowired
    public IParLdkhqzService parldkhqzService;

    @Autowired
    @Lazy
    public ParLdkhqzMapping parldkhqzMapping;

    @ApiOperation(value = "CheckKey", tags = {"ParLdkhqz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.checkKey(parldkhqzMapping.toDomain(parldkhqzdto)));
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdto),'ehr-ParLdkhqz-Create')")
    @ApiOperation(value = "Create", tags = {"ParLdkhqz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs")
    @Transactional
    public ResponseEntity<ParLdkhqzDTO> create(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        ParLdkhqz domain = parldkhqzMapping.toDomain(parldkhqzdto);
		parldkhqzService.create(domain);
        ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdtos),'ehr-ParLdkhqz-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParLdkhqz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.createBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParLdkhqz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/getdraft")
    public ResponseEntity<ParLdkhqzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzMapping.toDto(parldkhqzService.getDraft(new ParLdkhqz())));
    }

    @PostAuthorize("hasPermission(this.parldkhqzMapping.toDomain(returnObject.body),'ehr-ParLdkhqz-Get')")
    @ApiOperation(value = "Get", tags = {"ParLdkhqz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/{parldkhqz_id}")
    public ResponseEntity<ParLdkhqzDTO> get(@PathVariable("parldkhqz_id") String parldkhqz_id) {
        ParLdkhqz domain = parldkhqzService.get(parldkhqz_id);
        ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.get(#parldkhqz_id),'ehr-ParLdkhqz-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParLdkhqz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldkhqz_id") String parldkhqz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.remove(parldkhqz_id));
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.getParldkhqzByIds(#ids),'ehr-ParLdkhqz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParLdkhqz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldkhqzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdto),'ehr-ParLdkhqz-Save')")
    @ApiOperation(value = "Save", tags = {"ParLdkhqz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.save(parldkhqzMapping.toDomain(parldkhqzdto)));
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdtos),'ehr-ParLdkhqz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParLdkhqz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.saveBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.get(#parldkhqz_id),'ehr-ParLdkhqz-Update')")
    @ApiOperation(value = "Update", tags = {"ParLdkhqz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<ParLdkhqzDTO> update(@PathVariable("parldkhqz_id") String parldkhqz_id, @RequestBody ParLdkhqzDTO parldkhqzdto) {
		ParLdkhqz domain  = parldkhqzMapping.toDomain(parldkhqzdto);
        domain .setParldkhqzid(parldkhqz_id);
		parldkhqzService.update(domain );
		ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.getParldkhqzByEntities(this.parldkhqzMapping.toDomain(#parldkhqzdtos)),'ehr-ParLdkhqz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParLdkhqz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.updateBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdkhqz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParLdkhqz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldkhqzs/fetchdefault")
	public ResponseEntity<List<ParLdkhqzDTO>> fetchDefault(ParLdkhqzSearchContext context) {
        Page<ParLdkhqz> domains = parldkhqzService.searchDefault(context) ;
        List<ParLdkhqzDTO> list = parldkhqzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdkhqz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParLdkhqz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldkhqzs/searchdefault")
	public ResponseEntity<Page<ParLdkhqzDTO>> searchDefault(@RequestBody ParLdkhqzSearchContext context) {
        Page<ParLdkhqz> domains = parldkhqzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldkhqzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

