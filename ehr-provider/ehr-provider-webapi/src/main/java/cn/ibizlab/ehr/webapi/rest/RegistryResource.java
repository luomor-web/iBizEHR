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
import cn.ibizlab.ehr.core.common.domain.Registry;
import cn.ibizlab.ehr.core.common.service.IRegistryService;
import cn.ibizlab.ehr.core.common.filter.RegistrySearchContext;




@Slf4j
@Api(tags = {"Registry" })
@RestController("WebApi-registry")
@RequestMapping("")
public class RegistryResource {

    @Autowired
    private IRegistryService registryService;

    @Autowired
    @Lazy
    private RegistryMapping registryMapping;




    @PreAuthorize("hasPermission(#registry_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"Registry" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/registries/{registry_id}")
    @Transactional
    public ResponseEntity<RegistryDTO> update(@PathVariable("registry_id") String registry_id, @RequestBody RegistryDTO registrydto) {
		Registry domain = registryMapping.toDomain(registrydto);
        domain.setRegistryid(registry_id);
		registryService.update(domain);
		RegistryDTO dto = registryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#registry_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"Registry" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/registries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<RegistryDTO> registrydtos) {
        registryService.updateBatch(registryMapping.toDomain(registrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#registry_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"Registry" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/registries/{registry_id}")
    public ResponseEntity<RegistryDTO> get(@PathVariable("registry_id") String registry_id) {
        Registry domain = registryService.get(registry_id);
        RegistryDTO dto = registryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"Registry" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/registries")
    @Transactional
    public ResponseEntity<RegistryDTO> create(@RequestBody RegistryDTO registrydto) {
        Registry domain = registryMapping.toDomain(registrydto);
		registryService.create(domain);
        RegistryDTO dto = registryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"Registry" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/registries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<RegistryDTO> registrydtos) {
        registryService.createBatch(registryMapping.toDomain(registrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"Registry" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/registries/save")
    public ResponseEntity<Boolean> save(@RequestBody RegistryDTO registrydto) {
        return ResponseEntity.status(HttpStatus.OK).body(registryService.save(registryMapping.toDomain(registrydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"Registry" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/registries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<RegistryDTO> registrydtos) {
        registryService.saveBatch(registryMapping.toDomain(registrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#registry_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"Registry" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/registries/{registry_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("registry_id") String registry_id) {
         return ResponseEntity.status(HttpStatus.OK).body(registryService.remove(registry_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"Registry" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/registries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        registryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"Registry" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/registries/getdraft")
    public ResponseEntity<RegistryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(registryMapping.toDto(registryService.getDraft(new Registry())));
    }




    @ApiOperation(value = "CheckKey", tags = {"Registry" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/registries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody RegistryDTO registrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(registryService.checkKey(registryMapping.toDomain(registrydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-Registry-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"Registry" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/registries/fetchdefault")
	public ResponseEntity<List<RegistryDTO>> fetchDefault(RegistrySearchContext context) {
        Page<Registry> domains = registryService.searchDefault(context) ;
        List<RegistryDTO> list = registryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-Registry-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"Registry" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/registries/searchdefault")
	public ResponseEntity<Page<RegistryDTO>> searchDefault(@RequestBody RegistrySearchContext context) {
        Page<Registry> domains = registryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(registryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public Registry getEntity(){
        return new Registry();
    }

}
