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
import cn.ibizlab.ehr.core.orm.domain.OrmXmbq;
import cn.ibizlab.ehr.core.orm.service.IOrmXmbqService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmbqSearchContext;

@Slf4j
@Api(tags = {"项目标签" })
@RestController("WebApi-ormxmbq")
@RequestMapping("")
public class OrmXmbqResource {

    @Autowired
    public IOrmXmbqService ormxmbqService;

    @Autowired
    @Lazy
    public OrmXmbqMapping ormxmbqMapping;

    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-OrmXmbq-Get')")
    @ApiOperation(value = "获取项目标签", tags = {"项目标签" },  notes = "获取项目标签")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<OrmXmbqDTO> get(@PathVariable("ormxmbq_id") String ormxmbq_id) {
        OrmXmbq domain = ormxmbqService.get(ormxmbq_id);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "新建项目标签", tags = {"项目标签" },  notes = "新建项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> create(@RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
		ormxmbqService.create(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "批量新建项目标签", tags = {"项目标签" },  notes = "批量新建项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.createBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "保存项目标签", tags = {"项目标签" },  notes = "保存项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmbqDTO ormxmbqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "批量保存项目标签", tags = {"项目标签" },  notes = "批量保存项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.saveBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查项目标签", tags = {"项目标签" },  notes = "检查项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmbqDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "获取项目标签草稿", tags = {"项目标签" },  notes = "获取项目标签草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/getdraft")
    public ResponseEntity<OrmXmbqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(new OrmXmbq())));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "删除项目标签", tags = {"项目标签" },  notes = "删除项目标签")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbq_id") String ormxmbq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "批量删除项目标签", tags = {"项目标签" },  notes = "批量删除项目标签")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "更新项目标签", tags = {"项目标签" },  notes = "更新项目标签")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> update(@PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
		OrmXmbq domain  = ormxmbqMapping.toDomain(ormxmbqdto);
        domain .setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain );
		OrmXmbqDTO dto = ormxmbqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "批量更新项目标签", tags = {"项目标签" },  notes = "批量更新项目标签")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.updateBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目标签" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbqs/fetchdefault")
	public ResponseEntity<List<OrmXmbqDTO>> fetchDefault(OrmXmbqSearchContext context) {
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
        List<OrmXmbqDTO> list = ormxmbqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"项目标签" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbqs/searchdefault")
	public ResponseEntity<Page<OrmXmbqDTO>> searchDefault(@RequestBody OrmXmbqSearchContext context) {
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-OrmXmbq-Get')")
    @ApiOperation(value = "根据组织管理获取项目标签", tags = {"项目标签" },  notes = "根据组织管理获取项目标签")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<OrmXmbqDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
        OrmXmbq domain = ormxmbqService.get(ormxmbq_id);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "根据组织管理建立项目标签", tags = {"项目标签" },  notes = "根据组织管理建立项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
		ormxmbqService.create(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "根据组织管理批量建立项目标签", tags = {"项目标签" },  notes = "根据组织管理批量建立项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "根据组织管理保存项目标签", tags = {"项目标签" },  notes = "根据组织管理保存项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "根据组织管理批量保存项目标签", tags = {"项目标签" },  notes = "根据组织管理批量保存项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理检查项目标签", tags = {"项目标签" },  notes = "根据组织管理检查项目标签")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "根据组织管理获取项目标签草稿", tags = {"项目标签" },  notes = "根据组织管理获取项目标签草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/getdraft")
    public ResponseEntity<OrmXmbqDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        OrmXmbq domain = new OrmXmbq();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "根据组织管理删除项目标签", tags = {"项目标签" },  notes = "根据组织管理删除项目标签")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "根据组织管理批量删除项目标签", tags = {"项目标签" },  notes = "根据组织管理批量删除项目标签")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "根据组织管理更新项目标签", tags = {"项目标签" },  notes = "根据组织管理更新项目标签")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        domain.setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "根据组织管理批量更新项目标签", tags = {"项目标签" },  notes = "根据组织管理批量更新项目标签")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT", tags = {"项目标签" } ,notes = "根据组织管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormxmbqs/fetchdefault")
	public ResponseEntity<List<OrmXmbqDTO>> fetchOrmXmbqDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmXmbqSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
        List<OrmXmbqDTO> list = ormxmbqMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT", tags = {"项目标签" } ,notes = "根据组织管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormxmbqs/searchdefault")
	public ResponseEntity<Page<OrmXmbqDTO>> searchOrmXmbqDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

