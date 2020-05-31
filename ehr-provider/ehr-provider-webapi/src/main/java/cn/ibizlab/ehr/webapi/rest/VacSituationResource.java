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
import cn.ibizlab.ehr.core.vac.domain.VacSituation;
import cn.ibizlab.ehr.core.vac.service.IVacSituationService;
import cn.ibizlab.ehr.core.vac.filter.VacSituationSearchContext;

@Slf4j
@Api(tags = {"用户休假情况" })
@RestController("WebApi-vacsituation")
@RequestMapping("")
public class VacSituationResource {

    @Autowired
    public IVacSituationService vacsituationService;

    @Autowired
    @Lazy
    public VacSituationMapping vacsituationMapping;

    @PreAuthorize("hasPermission(this.vacsituationService.get(#vacsituation_id),'ehr-VacSituation-Update')")
    @ApiOperation(value = "更新用户休假情况", tags = {"用户休假情况" },  notes = "更新用户休假情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituations/{vacsituation_id}")
    @Transactional
    public ResponseEntity<VacSituationDTO> update(@PathVariable("vacsituation_id") String vacsituation_id, @RequestBody VacSituationDTO vacsituationdto) {
		VacSituation domain  = vacsituationMapping.toDomain(vacsituationdto);
        domain .setVacsituationid(vacsituation_id);
		vacsituationService.update(domain );
		VacSituationDTO dto = vacsituationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationService.getVacsituationByEntities(this.vacsituationMapping.toDomain(#vacsituationdtos)),'ehr-VacSituation-Update')")
    @ApiOperation(value = "批量更新用户休假情况", tags = {"用户休假情况" },  notes = "批量更新用户休假情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacSituationDTO> vacsituationdtos) {
        vacsituationService.updateBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsituationMapping.toDomain(#vacsituationdto),'ehr-VacSituation-Create')")
    @ApiOperation(value = "新建用户休假情况", tags = {"用户休假情况" },  notes = "新建用户休假情况")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations")
    @Transactional
    public ResponseEntity<VacSituationDTO> create(@RequestBody VacSituationDTO vacsituationdto) {
        VacSituation domain = vacsituationMapping.toDomain(vacsituationdto);
		vacsituationService.create(domain);
        VacSituationDTO dto = vacsituationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationMapping.toDomain(#vacsituationdtos),'ehr-VacSituation-Create')")
    @ApiOperation(value = "批量新建用户休假情况", tags = {"用户休假情况" },  notes = "批量新建用户休假情况")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacSituationDTO> vacsituationdtos) {
        vacsituationService.createBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查用户休假情况", tags = {"用户休假情况" },  notes = "检查用户休假情况")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacSituationDTO vacsituationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsituationService.checkKey(vacsituationMapping.toDomain(vacsituationdto)));
    }

    @ApiOperation(value = "获取用户休假情况草稿", tags = {"用户休假情况" },  notes = "获取用户休假情况草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituations/getdraft")
    public ResponseEntity<VacSituationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationMapping.toDto(vacsituationService.getDraft(new VacSituation())));
    }

    @PreAuthorize("hasPermission(this.vacsituationMapping.toDomain(#vacsituationdto),'ehr-VacSituation-Save')")
    @ApiOperation(value = "保存用户休假情况", tags = {"用户休假情况" },  notes = "保存用户休假情况")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/save")
    public ResponseEntity<Boolean> save(@RequestBody VacSituationDTO vacsituationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationService.save(vacsituationMapping.toDomain(vacsituationdto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationMapping.toDomain(#vacsituationdtos),'ehr-VacSituation-Save')")
    @ApiOperation(value = "批量保存用户休假情况", tags = {"用户休假情况" },  notes = "批量保存用户休假情况")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacSituationDTO> vacsituationdtos) {
        vacsituationService.saveBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsituationMapping.toDomain(returnObject.body),'ehr-VacSituation-Get')")
    @ApiOperation(value = "获取用户休假情况", tags = {"用户休假情况" },  notes = "获取用户休假情况")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituations/{vacsituation_id}")
    public ResponseEntity<VacSituationDTO> get(@PathVariable("vacsituation_id") String vacsituation_id) {
        VacSituation domain = vacsituationService.get(vacsituation_id);
        VacSituationDTO dto = vacsituationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationService.get(#vacsituation_id),'ehr-VacSituation-Remove')")
    @ApiOperation(value = "删除用户休假情况", tags = {"用户休假情况" },  notes = "删除用户休假情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituations/{vacsituation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsituation_id") String vacsituation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsituationService.remove(vacsituation_id));
    }

    @PreAuthorize("hasPermission(this.vacsituationService.getVacsituationByIds(#ids),'ehr-VacSituation-Remove')")
    @ApiOperation(value = "批量删除用户休假情况", tags = {"用户休假情况" },  notes = "批量删除用户休假情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsituationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituation-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"用户休假情况" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsituations/fetchdefault")
	public ResponseEntity<List<VacSituationDTO>> fetchDefault(VacSituationSearchContext context) {
        Page<VacSituation> domains = vacsituationService.searchDefault(context) ;
        List<VacSituationDTO> list = vacsituationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituation-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"用户休假情况" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsituations/searchdefault")
	public ResponseEntity<Page<VacSituationDTO>> searchDefault(@RequestBody VacSituationSearchContext context) {
        Page<VacSituation> domains = vacsituationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsituationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

