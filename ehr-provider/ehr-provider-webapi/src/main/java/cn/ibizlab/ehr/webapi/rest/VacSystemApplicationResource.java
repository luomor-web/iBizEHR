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
import cn.ibizlab.ehr.core.vac.domain.VacSystemApplication;
import cn.ibizlab.ehr.core.vac.service.IVacSystemApplicationService;
import cn.ibizlab.ehr.core.vac.filter.VacSystemApplicationSearchContext;

@Slf4j
@Api(tags = {"制度适用" })
@RestController("WebApi-vacsystemapplication")
@RequestMapping("")
public class VacSystemApplicationResource {

    @Autowired
    public IVacSystemApplicationService vacsystemapplicationService;

    @Autowired
    @Lazy
    public VacSystemApplicationMapping vacsystemapplicationMapping;

    @PreAuthorize("hasPermission(this.vacsystemapplicationMapping.toDomain(#vacsystemapplicationdto),'ehr-VacSystemApplication-Create')")
    @ApiOperation(value = "新建制度适用", tags = {"制度适用" },  notes = "新建制度适用")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications")
    @Transactional
    public ResponseEntity<VacSystemApplicationDTO> create(@RequestBody VacSystemApplicationDTO vacsystemapplicationdto) {
        VacSystemApplication domain = vacsystemapplicationMapping.toDomain(vacsystemapplicationdto);
		vacsystemapplicationService.create(domain);
        VacSystemApplicationDTO dto = vacsystemapplicationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationMapping.toDomain(#vacsystemapplicationdtos),'ehr-VacSystemApplication-Create')")
    @ApiOperation(value = "批量新建制度适用", tags = {"制度适用" },  notes = "批量新建制度适用")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacSystemApplicationDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.createBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationService.get(#vacsystemapplication_id),'ehr-VacSystemApplication-Remove')")
    @ApiOperation(value = "删除制度适用", tags = {"制度适用" },  notes = "删除制度适用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemapplications/{vacsystemapplication_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.remove(vacsystemapplication_id));
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationService.getVacsystemapplicationByIds(#ids),'ehr-VacSystemApplication-Remove')")
    @ApiOperation(value = "批量删除制度适用", tags = {"制度适用" },  notes = "批量删除制度适用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsystemapplicationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationService.get(#vacsystemapplication_id),'ehr-VacSystemApplication-Update')")
    @ApiOperation(value = "更新制度适用", tags = {"制度适用" },  notes = "更新制度适用")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemapplications/{vacsystemapplication_id}")
    @Transactional
    public ResponseEntity<VacSystemApplicationDTO> update(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id, @RequestBody VacSystemApplicationDTO vacsystemapplicationdto) {
		VacSystemApplication domain  = vacsystemapplicationMapping.toDomain(vacsystemapplicationdto);
        domain .setVacsystemapplicationid(vacsystemapplication_id);
		vacsystemapplicationService.update(domain );
		VacSystemApplicationDTO dto = vacsystemapplicationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationService.getVacsystemapplicationByEntities(this.vacsystemapplicationMapping.toDomain(#vacsystemapplicationdtos)),'ehr-VacSystemApplication-Update')")
    @ApiOperation(value = "批量更新制度适用", tags = {"制度适用" },  notes = "批量更新制度适用")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemapplications/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacSystemApplicationDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.updateBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsystemapplicationMapping.toDomain(returnObject.body),'ehr-VacSystemApplication-Get')")
    @ApiOperation(value = "获取制度适用", tags = {"制度适用" },  notes = "获取制度适用")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemapplications/{vacsystemapplication_id}")
    public ResponseEntity<VacSystemApplicationDTO> get(@PathVariable("vacsystemapplication_id") String vacsystemapplication_id) {
        VacSystemApplication domain = vacsystemapplicationService.get(vacsystemapplication_id);
        VacSystemApplicationDTO dto = vacsystemapplicationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationMapping.toDomain(#vacsystemapplicationdto),'ehr-VacSystemApplication-Save')")
    @ApiOperation(value = "保存制度适用", tags = {"制度适用" },  notes = "保存制度适用")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/save")
    public ResponseEntity<Boolean> save(@RequestBody VacSystemApplicationDTO vacsystemapplicationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.save(vacsystemapplicationMapping.toDomain(vacsystemapplicationdto)));
    }

    @PreAuthorize("hasPermission(this.vacsystemapplicationMapping.toDomain(#vacsystemapplicationdtos),'ehr-VacSystemApplication-Save')")
    @ApiOperation(value = "批量保存制度适用", tags = {"制度适用" },  notes = "批量保存制度适用")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacSystemApplicationDTO> vacsystemapplicationdtos) {
        vacsystemapplicationService.saveBatch(vacsystemapplicationMapping.toDomain(vacsystemapplicationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取制度适用草稿", tags = {"制度适用" },  notes = "获取制度适用草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemapplications/getdraft")
    public ResponseEntity<VacSystemApplicationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationMapping.toDto(vacsystemapplicationService.getDraft(new VacSystemApplication())));
    }

    @ApiOperation(value = "检查制度适用", tags = {"制度适用" },  notes = "检查制度适用")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemapplications/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacSystemApplicationDTO vacsystemapplicationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsystemapplicationService.checkKey(vacsystemapplicationMapping.toDomain(vacsystemapplicationdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSystemApplication-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"制度适用" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsystemapplications/fetchdefault")
	public ResponseEntity<List<VacSystemApplicationDTO>> fetchDefault(VacSystemApplicationSearchContext context) {
        Page<VacSystemApplication> domains = vacsystemapplicationService.searchDefault(context) ;
        List<VacSystemApplicationDTO> list = vacsystemapplicationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSystemApplication-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"制度适用" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsystemapplications/searchdefault")
	public ResponseEntity<Page<VacSystemApplicationDTO>> searchDefault(@RequestBody VacSystemApplicationSearchContext context) {
        Page<VacSystemApplication> domains = vacsystemapplicationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsystemapplicationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

