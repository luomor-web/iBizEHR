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
import cn.ibizlab.ehr.core.orm.domain.OrmQybzwh;
import cn.ibizlab.ehr.core.orm.service.IOrmQybzwhService;
import cn.ibizlab.ehr.core.orm.filter.OrmQybzwhSearchContext;

@Slf4j
@Api(tags = {"区域标准维护" })
@RestController("WebApi-ormqybzwh")
@RequestMapping("")
public class OrmQybzwhResource {

    @Autowired
    public IOrmQybzwhService ormqybzwhService;

    @Autowired
    @Lazy
    public OrmQybzwhMapping ormqybzwhMapping;

    @ApiOperation(value = "检查区域标准维护", tags = {"区域标准维护" },  notes = "检查区域标准维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmQybzwhDTO ormqybzwhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.checkKey(ormqybzwhMapping.toDomain(ormqybzwhdto)));
    }

    @PostAuthorize("hasPermission(this.ormqybzwhMapping.toDomain(returnObject.body),'ehr-OrmQybzwh-Get')")
    @ApiOperation(value = "获取区域标准维护", tags = {"区域标准维护" },  notes = "获取区域标准维护")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqybzwhs/{ormqybzwh_id}")
    public ResponseEntity<OrmQybzwhDTO> get(@PathVariable("ormqybzwh_id") String ormqybzwh_id) {
        OrmQybzwh domain = ormqybzwhService.get(ormqybzwh_id);
        OrmQybzwhDTO dto = ormqybzwhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqybzwhMapping.toDomain(#ormqybzwhdto),'ehr-OrmQybzwh-Save')")
    @ApiOperation(value = "保存区域标准维护", tags = {"区域标准维护" },  notes = "保存区域标准维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmQybzwhDTO ormqybzwhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.save(ormqybzwhMapping.toDomain(ormqybzwhdto)));
    }

    @PreAuthorize("hasPermission(this.ormqybzwhMapping.toDomain(#ormqybzwhdtos),'ehr-OrmQybzwh-Save')")
    @ApiOperation(value = "批量保存区域标准维护", tags = {"区域标准维护" },  notes = "批量保存区域标准维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmQybzwhDTO> ormqybzwhdtos) {
        ormqybzwhService.saveBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormqybzwhService.get(#ormqybzwh_id),'ehr-OrmQybzwh-Remove')")
    @ApiOperation(value = "删除区域标准维护", tags = {"区域标准维护" },  notes = "删除区域标准维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqybzwhs/{ormqybzwh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormqybzwh_id") String ormqybzwh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhService.remove(ormqybzwh_id));
    }

    @PreAuthorize("hasPermission(this.ormqybzwhService.getOrmqybzwhByIds(#ids),'ehr-OrmQybzwh-Remove')")
    @ApiOperation(value = "批量删除区域标准维护", tags = {"区域标准维护" },  notes = "批量删除区域标准维护")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormqybzwhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormqybzwhService.get(#ormqybzwh_id),'ehr-OrmQybzwh-Update')")
    @ApiOperation(value = "更新区域标准维护", tags = {"区域标准维护" },  notes = "更新区域标准维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqybzwhs/{ormqybzwh_id}")
    @Transactional
    public ResponseEntity<OrmQybzwhDTO> update(@PathVariable("ormqybzwh_id") String ormqybzwh_id, @RequestBody OrmQybzwhDTO ormqybzwhdto) {
		OrmQybzwh domain  = ormqybzwhMapping.toDomain(ormqybzwhdto);
        domain .setOrmqybzwhid(ormqybzwh_id);
		ormqybzwhService.update(domain );
		OrmQybzwhDTO dto = ormqybzwhMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqybzwhService.getOrmqybzwhByEntities(this.ormqybzwhMapping.toDomain(#ormqybzwhdtos)),'ehr-OrmQybzwh-Update')")
    @ApiOperation(value = "批量更新区域标准维护", tags = {"区域标准维护" },  notes = "批量更新区域标准维护")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmQybzwhDTO> ormqybzwhdtos) {
        ormqybzwhService.updateBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取区域标准维护草稿", tags = {"区域标准维护" },  notes = "获取区域标准维护草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqybzwhs/getdraft")
    public ResponseEntity<OrmQybzwhDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormqybzwhMapping.toDto(ormqybzwhService.getDraft(new OrmQybzwh())));
    }

    @PreAuthorize("hasPermission(this.ormqybzwhMapping.toDomain(#ormqybzwhdto),'ehr-OrmQybzwh-Create')")
    @ApiOperation(value = "新建区域标准维护", tags = {"区域标准维护" },  notes = "新建区域标准维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs")
    @Transactional
    public ResponseEntity<OrmQybzwhDTO> create(@RequestBody OrmQybzwhDTO ormqybzwhdto) {
        OrmQybzwh domain = ormqybzwhMapping.toDomain(ormqybzwhdto);
		ormqybzwhService.create(domain);
        OrmQybzwhDTO dto = ormqybzwhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqybzwhMapping.toDomain(#ormqybzwhdtos),'ehr-OrmQybzwh-Create')")
    @ApiOperation(value = "批量新建区域标准维护", tags = {"区域标准维护" },  notes = "批量新建区域标准维护")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqybzwhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmQybzwhDTO> ormqybzwhdtos) {
        ormqybzwhService.createBatch(ormqybzwhMapping.toDomain(ormqybzwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmQybzwh-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"区域标准维护" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormqybzwhs/fetchdefault")
	public ResponseEntity<List<OrmQybzwhDTO>> fetchDefault(OrmQybzwhSearchContext context) {
        Page<OrmQybzwh> domains = ormqybzwhService.searchDefault(context) ;
        List<OrmQybzwhDTO> list = ormqybzwhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmQybzwh-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"区域标准维护" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormqybzwhs/searchdefault")
	public ResponseEntity<Page<OrmQybzwhDTO>> searchDefault(@RequestBody OrmQybzwhSearchContext context) {
        Page<OrmQybzwh> domains = ormqybzwhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormqybzwhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

