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
import cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz;
import cn.ibizlab.ehr.core.orm.service.IOrmBmkqdzService;
import cn.ibizlab.ehr.core.orm.filter.OrmBmkqdzSearchContext;

@Slf4j
@Api(tags = {"部门地址维护" })
@RestController("WebApi-ormbmkqdz")
@RequestMapping("")
public class OrmBmkqdzResource {

    @Autowired
    public IOrmBmkqdzService ormbmkqdzService;

    @Autowired
    @Lazy
    public OrmBmkqdzMapping ormbmkqdzMapping;

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "删除部门地址维护", tags = {"部门地址维护" },  notes = "删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "批量删除部门地址维护", tags = {"部门地址维护" },  notes = "批量删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取部门地址维护草稿", tags = {"部门地址维护" },  notes = "获取部门地址维护草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(new OrmBmkqdz())));
    }

    @ApiOperation(value = "检查部门地址维护", tags = {"部门地址维护" },  notes = "检查部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "保存部门地址维护", tags = {"部门地址维护" },  notes = "保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "批量保存部门地址维护", tags = {"部门地址维护" },  notes = "批量保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.saveBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "更新部门地址维护", tags = {"部门地址维护" },  notes = "更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> update(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
		OrmBmkqdz domain  = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain .setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain );
		OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "批量更新部门地址维护", tags = {"部门地址维护" },  notes = "批量更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.updateBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "新建部门地址维护", tags = {"部门地址维护" },  notes = "新建部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> create(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "批量新建部门地址维护", tags = {"部门地址维护" },  notes = "批量新建部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.createBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "获取部门地址维护", tags = {"部门地址维护" },  notes = "获取部门地址维护")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> get(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门地址维护" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchDefault(OrmBmkqdzSearchContext context) {
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门地址维护" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchDefault(@RequestBody OrmBmkqdzSearchContext context) {
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "根据部门管理删除部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "根据部门管理批量删除部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理批量删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理获取部门地址维护草稿", tags = {"部门地址维护" },  notes = "根据部门管理获取部门地址维护草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmkqdz domain = new OrmBmkqdz();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门管理检查部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理检查部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "根据部门管理保存部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "根据部门管理批量保存部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理批量保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "根据部门管理更新部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "根据部门管理批量更新部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理批量更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "根据部门管理建立部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理建立部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "根据部门管理批量建立部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理批量建立部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "根据部门管理获取部门地址维护", tags = {"部门地址维护" },  notes = "根据部门管理获取部门地址维护")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"部门地址维护" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchOrmBmkqdzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"部门地址维护" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchOrmBmkqdzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理批量删除部门地址维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理获取部门地址维护草稿", tags = {"部门地址维护" },  notes = "根据组织管理部门管理获取部门地址维护草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmkqdz domain = new OrmBmkqdz();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "根据组织管理部门管理检查部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理检查部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理批量保存部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理批量更新部门地址维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理建立部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理批量建立部门地址维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取部门地址维护", tags = {"部门地址维护" },  notes = "根据组织管理部门管理获取部门地址维护")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"部门地址维护" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchOrmBmkqdzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"部门地址维护" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchOrmBmkqdzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

