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
import cn.ibizlab.ehr.core.orm.domain.OrmDepEstMan;
import cn.ibizlab.ehr.core.orm.service.IOrmDepEstManService;
import cn.ibizlab.ehr.core.orm.filter.OrmDepEstManSearchContext;

@Slf4j
@Api(tags = {"部门职务编制" })
@RestController("WebApi-ormdepestman")
@RequestMapping("")
public class OrmDepEstManResource {

    @Autowired
    public IOrmDepEstManService ormdepestmanService;

    @Autowired
    @Lazy
    public OrmDepEstManMapping ormdepestmanMapping;

    @ApiOperation(value = "获取部门职务编制草稿", tags = {"部门职务编制" },  notes = "获取部门职务编制草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(new OrmDepEstMan())));
    }

    @ApiOperation(value = "检查部门职务编制", tags = {"部门职务编制" },  notes = "检查部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "新建部门职务编制", tags = {"部门职务编制" },  notes = "新建部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> create(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "批量新建部门职务编制", tags = {"部门职务编制" },  notes = "批量新建部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.createBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "获取部门职务编制", tags = {"部门职务编制" },  notes = "获取部门职务编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> get(@PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "删除部门职务编制", tags = {"部门职务编制" },  notes = "删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormdepestman_id") String ormdepestman_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "批量删除部门职务编制", tags = {"部门职务编制" },  notes = "批量删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "更新部门职务编制", tags = {"部门职务编制" },  notes = "更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> update(@PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
		OrmDepEstMan domain  = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain .setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain );
		OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "批量更新部门职务编制", tags = {"部门职务编制" },  notes = "批量更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.updateBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "保存部门职务编制", tags = {"部门职务编制" },  notes = "保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "批量保存部门职务编制", tags = {"部门职务编制" },  notes = "批量保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.saveBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门职务编制" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchDefault(OrmDepEstManSearchContext context) {
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门职务编制" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchDefault(@RequestBody OrmDepEstManSearchContext context) {
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据职务管理获取部门职务编制草稿", tags = {"部门职务编制" },  notes = "根据职务管理获取部门职务编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByOrmDuty(@PathVariable("ormduty_id") String ormduty_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "根据职务管理检查部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理检查部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据职务管理建立部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据职务管理批量建立部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理批量建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "根据职务管理获取部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理获取部门职务编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据职务管理删除部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据职务管理批量删除部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理批量删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmDuty(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据职务管理更新部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据职务管理批量更新部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理批量更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据职务管理保存部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据职务管理批量保存部门职务编制", tags = {"部门职务编制" },  notes = "根据职务管理批量保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据职务管理获取DEFAULT", tags = {"部门职务编制" } ,notes = "根据职务管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByOrmDuty(@PathVariable("ormduty_id") String ormduty_id,OrmDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据职务管理查询DEFAULT", tags = {"部门职务编制" } ,notes = "根据职务管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门管理获取部门职务编制草稿", tags = {"部门职务编制" },  notes = "根据部门管理获取部门职务编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门管理检查部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理检查部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据部门管理建立部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据部门管理批量建立部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理批量建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "根据部门管理获取部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理获取部门职务编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据部门管理删除部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据部门管理批量删除部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理批量删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据部门管理更新部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据部门管理批量更新部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理批量更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据部门管理保存部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据部门管理批量保存部门职务编制", tags = {"部门职务编制" },  notes = "根据部门管理批量保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"部门职务编制" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"部门职务编制" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组织管理部门管理获取部门职务编制草稿", tags = {"部门职务编制" },  notes = "根据组织管理部门管理获取部门职务编制草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "根据组织管理部门管理检查部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理检查部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理批量建立部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理获取部门职务编制")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理批量删除部门职务编制")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理批量更新部门职务编制")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存部门职务编制", tags = {"部门职务编制" },  notes = "根据组织管理部门管理批量保存部门职务编制")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"部门职务编制" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"部门职务编制" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

