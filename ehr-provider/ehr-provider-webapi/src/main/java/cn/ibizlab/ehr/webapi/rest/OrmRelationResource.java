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
import cn.ibizlab.ehr.core.orm.domain.OrmRelation;
import cn.ibizlab.ehr.core.orm.service.IOrmRelationService;
import cn.ibizlab.ehr.core.orm.filter.OrmRelationSearchContext;

@Slf4j
@Api(tags = {"组织管理关系表" })
@RestController("WebApi-ormrelation")
@RequestMapping("")
public class OrmRelationResource {

    @Autowired
    public IOrmRelationService ormrelationService;

    @Autowired
    @Lazy
    public OrmRelationMapping ormrelationMapping;

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdto),'ehr-OrmRelation-Create')")
    @ApiOperation(value = "新建组织管理关系表", tags = {"组织管理关系表" },  notes = "新建组织管理关系表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations")
    @Transactional
    public ResponseEntity<OrmRelationDTO> create(@RequestBody OrmRelationDTO ormrelationdto) {
        OrmRelation domain = ormrelationMapping.toDomain(ormrelationdto);
		ormrelationService.create(domain);
        OrmRelationDTO dto = ormrelationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdtos),'ehr-OrmRelation-Create')")
    @ApiOperation(value = "批量新建组织管理关系表", tags = {"组织管理关系表" },  notes = "批量新建组织管理关系表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.createBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.get(#ormrelation_id),'ehr-OrmRelation-Update')")
    @ApiOperation(value = "更新组织管理关系表", tags = {"组织管理关系表" },  notes = "更新组织管理关系表")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<OrmRelationDTO> update(@PathVariable("ormrelation_id") String ormrelation_id, @RequestBody OrmRelationDTO ormrelationdto) {
		OrmRelation domain  = ormrelationMapping.toDomain(ormrelationdto);
        domain .setOrmorgrelationid(ormrelation_id);
		ormrelationService.update(domain );
		OrmRelationDTO dto = ormrelationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.getOrmrelationByEntities(this.ormrelationMapping.toDomain(#ormrelationdtos)),'ehr-OrmRelation-Update')")
    @ApiOperation(value = "批量更新组织管理关系表", tags = {"组织管理关系表" },  notes = "批量更新组织管理关系表")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.updateBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormrelationMapping.toDomain(returnObject.body),'ehr-OrmRelation-Get')")
    @ApiOperation(value = "获取组织管理关系表", tags = {"组织管理关系表" },  notes = "获取组织管理关系表")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/{ormrelation_id}")
    public ResponseEntity<OrmRelationDTO> get(@PathVariable("ormrelation_id") String ormrelation_id) {
        OrmRelation domain = ormrelationService.get(ormrelation_id);
        OrmRelationDTO dto = ormrelationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrelationService.get(#ormrelation_id),'ehr-OrmRelation-Remove')")
    @ApiOperation(value = "删除组织管理关系表", tags = {"组织管理关系表" },  notes = "删除组织管理关系表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/{ormrelation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormrelation_id") String ormrelation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.remove(ormrelation_id));
    }

    @PreAuthorize("hasPermission(this.ormrelationService.getOrmrelationByIds(#ids),'ehr-OrmRelation-Remove')")
    @ApiOperation(value = "批量删除组织管理关系表", tags = {"组织管理关系表" },  notes = "批量删除组织管理关系表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormrelations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormrelationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取组织管理关系表草稿", tags = {"组织管理关系表" },  notes = "获取组织管理关系表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormrelations/getdraft")
    public ResponseEntity<OrmRelationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationMapping.toDto(ormrelationService.getDraft(new OrmRelation())));
    }

    @ApiOperation(value = "检查组织管理关系表", tags = {"组织管理关系表" },  notes = "检查组织管理关系表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmRelationDTO ormrelationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormrelationService.checkKey(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdto),'ehr-OrmRelation-Save')")
    @ApiOperation(value = "保存组织管理关系表", tags = {"组织管理关系表" },  notes = "保存组织管理关系表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmRelationDTO ormrelationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormrelationService.save(ormrelationMapping.toDomain(ormrelationdto)));
    }

    @PreAuthorize("hasPermission(this.ormrelationMapping.toDomain(#ormrelationdtos),'ehr-OrmRelation-Save')")
    @ApiOperation(value = "批量保存组织管理关系表", tags = {"组织管理关系表" },  notes = "批量保存组织管理关系表")
	@RequestMapping(method = RequestMethod.POST, value = "/ormrelations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmRelationDTO> ormrelationdtos) {
        ormrelationService.saveBatch(ormrelationMapping.toDomain(ormrelationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRelation-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"组织管理关系表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormrelations/fetchdefault")
	public ResponseEntity<List<OrmRelationDTO>> fetchDefault(OrmRelationSearchContext context) {
        Page<OrmRelation> domains = ormrelationService.searchDefault(context) ;
        List<OrmRelationDTO> list = ormrelationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRelation-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"组织管理关系表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormrelations/searchdefault")
	public ResponseEntity<Page<OrmRelationDTO>> searchDefault(@RequestBody OrmRelationSearchContext context) {
        Page<OrmRelation> domains = ormrelationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrelationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

