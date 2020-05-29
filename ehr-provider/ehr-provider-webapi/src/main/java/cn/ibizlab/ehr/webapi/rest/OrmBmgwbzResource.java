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
import cn.ibizlab.ehr.core.orm.domain.OrmBmgwbz;
import cn.ibizlab.ehr.core.orm.service.IOrmBmgwbzService;
import cn.ibizlab.ehr.core.orm.filter.OrmBmgwbzSearchContext;

@Slf4j
@Api(tags = {"部门岗位编制" })
@RestController("WebApi-ormbmgwbz")
@RequestMapping("")
public class OrmBmgwbzResource {

    @Autowired
    public IOrmBmgwbzService ormbmgwbzService;

    @Autowired
    @Lazy
    public OrmBmgwbzMapping ormbmgwbzMapping;

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "新建部门岗位编制", tags = {"部门岗位编制" },  notes = "新建部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> create(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "批量新建部门岗位编制", tags = {"部门岗位编制" },  notes = "批量新建部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.createBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查部门岗位编制", tags = {"部门岗位编制" },  notes = "检查部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "获取部门岗位编制", tags = {"部门岗位编制" },  notes = "获取部门岗位编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> get(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "保存部门岗位编制", tags = {"部门岗位编制" },  notes = "保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "批量保存部门岗位编制", tags = {"部门岗位编制" },  notes = "批量保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.saveBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "更新部门岗位编制", tags = {"部门岗位编制" },  notes = "更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> update(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
		OrmBmgwbz domain  = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain .setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain );
		OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "批量更新部门岗位编制", tags = {"部门岗位编制" },  notes = "批量更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.updateBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取部门岗位编制草稿", tags = {"部门岗位编制" },  notes = "获取部门岗位编制草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(new OrmBmgwbz())));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "删除部门岗位编制", tags = {"部门岗位编制" },  notes = "删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "批量删除部门岗位编制", tags = {"部门岗位编制" },  notes = "批量删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门岗位编制" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchDefault(OrmBmgwbzSearchContext context) {
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门岗位编制" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchDefault(@RequestBody OrmBmgwbzSearchContext context) {
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据部门管理建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据部门管理批量建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理批量建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理检查部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理检查部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "根据部门管理获取部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理获取部门岗位编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据部门管理保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据部门管理批量保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理批量保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据部门管理更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据部门管理批量更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理批量更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理获取部门岗位编制草稿", tags = {"部门岗位编制" },  notes = "根据部门管理获取部门岗位编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据部门管理删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据部门管理批量删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据部门管理批量删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"部门岗位编制" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"部门岗位编制" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据岗位建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据岗位批量建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位批量建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据岗位检查部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位检查部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "根据岗位获取部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位获取部门岗位编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据岗位保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据岗位批量保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位批量保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据岗位更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据岗位批量更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位批量更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据岗位获取部门岗位编制草稿", tags = {"部门岗位编制" },  notes = "根据岗位获取部门岗位编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmPost(@PathVariable("ormpost_id") String ormpost_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据岗位删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据岗位批量删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据岗位批量删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPost(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据岗位获取DEFAULT", tags = {"部门岗位编制" } ,notes = "根据岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id,OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据岗位查询DEFAULT", tags = {"部门岗位编制" } ,notes = "根据岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理批量建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理检查部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理检查部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理获取部门岗位编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理批量保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理批量更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理获取部门岗位编制草稿", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理获取部门岗位编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理部门管理批量删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"部门岗位编制" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"部门岗位编制" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据组织管理岗位建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "根据组织管理岗位批量建立部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位批量建立部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理岗位检查部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位检查部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "根据组织管理岗位获取部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位获取部门岗位编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据组织管理岗位保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "根据组织管理岗位批量保存部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位批量保存部门岗位编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据组织管理岗位更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "根据组织管理岗位批量更新部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位批量更新部门岗位编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理岗位获取部门岗位编制草稿", tags = {"部门岗位编制" },  notes = "根据组织管理岗位获取部门岗位编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据组织管理岗位删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "根据组织管理岗位批量删除部门岗位编制", tags = {"部门岗位编制" },  notes = "根据组织管理岗位批量删除部门岗位编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmPost(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据组织管理岗位获取DEFAULT", tags = {"部门岗位编制" } ,notes = "根据组织管理岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "根据组织管理岗位查询DEFAULT", tags = {"部门岗位编制" } ,notes = "根据组织管理岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

