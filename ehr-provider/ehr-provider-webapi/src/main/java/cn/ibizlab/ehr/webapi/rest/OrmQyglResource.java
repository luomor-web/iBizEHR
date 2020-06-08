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
import cn.ibizlab.ehr.core.orm.domain.OrmQygl;
import cn.ibizlab.ehr.core.orm.service.IOrmQyglService;
import cn.ibizlab.ehr.core.orm.filter.OrmQyglSearchContext;

@Slf4j
@Api(tags = {"补贴标准" })
@RestController("WebApi-ormqygl")
@RequestMapping("")
public class OrmQyglResource {

    @Autowired
    public IOrmQyglService ormqyglService;

    @Autowired
    @Lazy
    public OrmQyglMapping ormqyglMapping;

    @PreAuthorize("hasPermission(this.ormqyglService.get(#ormqygl_id),'ehr-OrmQygl-Update')")
    @ApiOperation(value = "更新补贴标准", tags = {"补贴标准" },  notes = "更新补贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqygls/{ormqygl_id}")
    @Transactional
    public ResponseEntity<OrmQyglDTO> update(@PathVariable("ormqygl_id") String ormqygl_id, @RequestBody OrmQyglDTO ormqygldto) {
		OrmQygl domain  = ormqyglMapping.toDomain(ormqygldto);
        domain .setOrmqyglid(ormqygl_id);
		ormqyglService.update(domain );
		OrmQyglDTO dto = ormqyglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqyglService.getOrmqyglByEntities(this.ormqyglMapping.toDomain(#ormqygldtos)),'ehr-OrmQygl-Update')")
    @ApiOperation(value = "批量更新补贴标准", tags = {"补贴标准" },  notes = "批量更新补贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmQyglDTO> ormqygldtos) {
        ormqyglService.updateBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormqyglMapping.toDomain(returnObject.body),'ehr-OrmQygl-Get')")
    @ApiOperation(value = "获取补贴标准", tags = {"补贴标准" },  notes = "获取补贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqygls/{ormqygl_id}")
    public ResponseEntity<OrmQyglDTO> get(@PathVariable("ormqygl_id") String ormqygl_id) {
        OrmQygl domain = ormqyglService.get(ormqygl_id);
        OrmQyglDTO dto = ormqyglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqyglMapping.toDomain(#ormqygldto),'ehr-OrmQygl-Create')")
    @ApiOperation(value = "新建补贴标准", tags = {"补贴标准" },  notes = "新建补贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls")
    @Transactional
    public ResponseEntity<OrmQyglDTO> create(@RequestBody OrmQyglDTO ormqygldto) {
        OrmQygl domain = ormqyglMapping.toDomain(ormqygldto);
		ormqyglService.create(domain);
        OrmQyglDTO dto = ormqyglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormqyglMapping.toDomain(#ormqygldtos),'ehr-OrmQygl-Create')")
    @ApiOperation(value = "批量新建补贴标准", tags = {"补贴标准" },  notes = "批量新建补贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmQyglDTO> ormqygldtos) {
        ormqyglService.createBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取补贴标准草稿", tags = {"补贴标准" },  notes = "获取补贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormqygls/getdraft")
    public ResponseEntity<OrmQyglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormqyglMapping.toDto(ormqyglService.getDraft(new OrmQygl())));
    }

    @PreAuthorize("hasPermission(this.ormqyglService.get(#ormqygl_id),'ehr-OrmQygl-Remove')")
    @ApiOperation(value = "删除补贴标准", tags = {"补贴标准" },  notes = "删除补贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqygls/{ormqygl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormqygl_id") String ormqygl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormqyglService.remove(ormqygl_id));
    }

    @PreAuthorize("hasPermission(this.ormqyglService.getOrmqyglByIds(#ids),'ehr-OrmQygl-Remove')")
    @ApiOperation(value = "批量删除补贴标准", tags = {"补贴标准" },  notes = "批量删除补贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormqygls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormqyglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormqyglMapping.toDomain(#ormqygldto),'ehr-OrmQygl-Save')")
    @ApiOperation(value = "保存补贴标准", tags = {"补贴标准" },  notes = "保存补贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmQyglDTO ormqygldto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormqyglService.save(ormqyglMapping.toDomain(ormqygldto)));
    }

    @PreAuthorize("hasPermission(this.ormqyglMapping.toDomain(#ormqygldtos),'ehr-OrmQygl-Save')")
    @ApiOperation(value = "批量保存补贴标准", tags = {"补贴标准" },  notes = "批量保存补贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmQyglDTO> ormqygldtos) {
        ormqyglService.saveBatch(ormqyglMapping.toDomain(ormqygldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查补贴标准", tags = {"补贴标准" },  notes = "检查补贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/ormqygls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmQyglDTO ormqygldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormqyglService.checkKey(ormqyglMapping.toDomain(ormqygldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmQygl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"补贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormqygls/fetchdefault")
	public ResponseEntity<List<OrmQyglDTO>> fetchDefault(OrmQyglSearchContext context) {
        Page<OrmQygl> domains = ormqyglService.searchDefault(context) ;
        List<OrmQyglDTO> list = ormqyglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmQygl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"补贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormqygls/searchdefault")
	public ResponseEntity<Page<OrmQyglDTO>> searchDefault(@RequestBody OrmQyglSearchContext context) {
        Page<OrmQygl> domains = ormqyglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormqyglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

