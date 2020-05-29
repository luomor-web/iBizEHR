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
import cn.ibizlab.ehr.core.orm.domain.OrmZwdqgz;
import cn.ibizlab.ehr.core.orm.service.IOrmZwdqgzService;
import cn.ibizlab.ehr.core.orm.filter.OrmZwdqgzSearchContext;

@Slf4j
@Api(tags = {"职级到期规则" })
@RestController("WebApi-ormzwdqgz")
@RequestMapping("")
public class OrmZwdqgzResource {

    @Autowired
    public IOrmZwdqgzService ormzwdqgzService;

    @Autowired
    @Lazy
    public OrmZwdqgzMapping ormzwdqgzMapping;

    @PostAuthorize("hasPermission(this.ormzwdqgzMapping.toDomain(returnObject.body),'ehr-OrmZwdqgz-Get')")
    @ApiOperation(value = "获取职级到期规则", tags = {"职级到期规则" },  notes = "获取职级到期规则")
	@RequestMapping(method = RequestMethod.GET, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    public ResponseEntity<OrmZwdqgzDTO> get(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id) {
        OrmZwdqgz domain = ormzwdqgzService.get(ormzwdqgz_id);
        OrmZwdqgzDTO dto = ormzwdqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzMapping.toDomain(#ormzwdqgzdto),'ehr-OrmZwdqgz-Save')")
    @ApiOperation(value = "保存职级到期规则", tags = {"职级到期规则" },  notes = "保存职级到期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmZwdqgzDTO ormzwdqgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.save(ormzwdqgzMapping.toDomain(ormzwdqgzdto)));
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzMapping.toDomain(#ormzwdqgzdtos),'ehr-OrmZwdqgz-Save')")
    @ApiOperation(value = "批量保存职级到期规则", tags = {"职级到期规则" },  notes = "批量保存职级到期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmZwdqgzDTO> ormzwdqgzdtos) {
        ormzwdqgzService.saveBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查职级到期规则", tags = {"职级到期规则" },  notes = "检查职级到期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmZwdqgzDTO ormzwdqgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.checkKey(ormzwdqgzMapping.toDomain(ormzwdqgzdto)));
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzService.get(#ormzwdqgz_id),'ehr-OrmZwdqgz-Update')")
    @ApiOperation(value = "更新职级到期规则", tags = {"职级到期规则" },  notes = "更新职级到期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    @Transactional
    public ResponseEntity<OrmZwdqgzDTO> update(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id, @RequestBody OrmZwdqgzDTO ormzwdqgzdto) {
		OrmZwdqgz domain  = ormzwdqgzMapping.toDomain(ormzwdqgzdto);
        domain .setOrmzwdqgzid(ormzwdqgz_id);
		ormzwdqgzService.update(domain );
		OrmZwdqgzDTO dto = ormzwdqgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzService.getOrmzwdqgzByEntities(this.ormzwdqgzMapping.toDomain(#ormzwdqgzdtos)),'ehr-OrmZwdqgz-Update')")
    @ApiOperation(value = "批量更新职级到期规则", tags = {"职级到期规则" },  notes = "批量更新职级到期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmZwdqgzDTO> ormzwdqgzdtos) {
        ormzwdqgzService.updateBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取职级到期规则草稿", tags = {"职级到期规则" },  notes = "获取职级到期规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormzwdqgzs/getdraft")
    public ResponseEntity<OrmZwdqgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzMapping.toDto(ormzwdqgzService.getDraft(new OrmZwdqgz())));
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzMapping.toDomain(#ormzwdqgzdto),'ehr-OrmZwdqgz-Create')")
    @ApiOperation(value = "新建职级到期规则", tags = {"职级到期规则" },  notes = "新建职级到期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs")
    @Transactional
    public ResponseEntity<OrmZwdqgzDTO> create(@RequestBody OrmZwdqgzDTO ormzwdqgzdto) {
        OrmZwdqgz domain = ormzwdqgzMapping.toDomain(ormzwdqgzdto);
		ormzwdqgzService.create(domain);
        OrmZwdqgzDTO dto = ormzwdqgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzMapping.toDomain(#ormzwdqgzdtos),'ehr-OrmZwdqgz-Create')")
    @ApiOperation(value = "批量新建职级到期规则", tags = {"职级到期规则" },  notes = "批量新建职级到期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmZwdqgzDTO> ormzwdqgzdtos) {
        ormzwdqgzService.createBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzService.get(#ormzwdqgz_id),'ehr-OrmZwdqgz-Remove')")
    @ApiOperation(value = "删除职级到期规则", tags = {"职级到期规则" },  notes = "删除职级到期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.remove(ormzwdqgz_id));
    }

    @PreAuthorize("hasPermission(this.ormzwdqgzService.getOrmzwdqgzByIds(#ids),'ehr-OrmZwdqgz-Remove')")
    @ApiOperation(value = "批量删除职级到期规则", tags = {"职级到期规则" },  notes = "批量删除职级到期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormzwdqgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmZwdqgz-DQYHZZ-all')")
	@ApiOperation(value = "获取查看当前单位的职级到期规则", tags = {"职级到期规则" } ,notes = "获取查看当前单位的职级到期规则")
    @RequestMapping(method= RequestMethod.GET , value="/ormzwdqgzs/fetchdqyhzz")
	public ResponseEntity<List<OrmZwdqgzDTO>> fetchDQYHZZ(OrmZwdqgzSearchContext context) {
        Page<OrmZwdqgz> domains = ormzwdqgzService.searchDQYHZZ(context) ;
        List<OrmZwdqgzDTO> list = ormzwdqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmZwdqgz-DQYHZZ-all')")
	@ApiOperation(value = "查询查看当前单位的职级到期规则", tags = {"职级到期规则" } ,notes = "查询查看当前单位的职级到期规则")
    @RequestMapping(method= RequestMethod.POST , value="/ormzwdqgzs/searchdqyhzz")
	public ResponseEntity<Page<OrmZwdqgzDTO>> searchDQYHZZ(@RequestBody OrmZwdqgzSearchContext context) {
        Page<OrmZwdqgz> domains = ormzwdqgzService.searchDQYHZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormzwdqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmZwdqgz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职级到期规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormzwdqgzs/fetchdefault")
	public ResponseEntity<List<OrmZwdqgzDTO>> fetchDefault(OrmZwdqgzSearchContext context) {
        Page<OrmZwdqgz> domains = ormzwdqgzService.searchDefault(context) ;
        List<OrmZwdqgzDTO> list = ormzwdqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmZwdqgz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职级到期规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormzwdqgzs/searchdefault")
	public ResponseEntity<Page<OrmZwdqgzDTO>> searchDefault(@RequestBody OrmZwdqgzSearchContext context) {
        Page<OrmZwdqgz> domains = ormzwdqgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormzwdqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

