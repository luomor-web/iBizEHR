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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveSystem;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveSystemService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveSystemSearchContext;

@Slf4j
@Api(tags = {"休假制度管理" })
@RestController("WebApi-vacleavesystem")
@RequestMapping("")
public class VacLeaveSystemResource {

    @Autowired
    public IVacLeaveSystemService vacleavesystemService;

    @Autowired
    @Lazy
    public VacLeaveSystemMapping vacleavesystemMapping;

    @PostAuthorize("hasPermission(this.vacleavesystemMapping.toDomain(returnObject.body),'ehr-VacLeaveSystem-Get')")
    @ApiOperation(value = "获取休假制度管理", tags = {"休假制度管理" },  notes = "获取休假制度管理")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystems/{vacleavesystem_id}")
    public ResponseEntity<VacLeaveSystemDTO> get(@PathVariable("vacleavesystem_id") String vacleavesystem_id) {
        VacLeaveSystem domain = vacleavesystemService.get(vacleavesystem_id);
        VacLeaveSystemDTO dto = vacleavesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemMapping.toDomain(#vacleavesystemdto),'ehr-VacLeaveSystem-Create')")
    @ApiOperation(value = "新建休假制度管理", tags = {"休假制度管理" },  notes = "新建休假制度管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems")
    @Transactional
    public ResponseEntity<VacLeaveSystemDTO> create(@RequestBody VacLeaveSystemDTO vacleavesystemdto) {
        VacLeaveSystem domain = vacleavesystemMapping.toDomain(vacleavesystemdto);
		vacleavesystemService.create(domain);
        VacLeaveSystemDTO dto = vacleavesystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemMapping.toDomain(#vacleavesystemdtos),'ehr-VacLeaveSystem-Create')")
    @ApiOperation(value = "批量新建休假制度管理", tags = {"休假制度管理" },  notes = "批量新建休假制度管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaveSystemDTO> vacleavesystemdtos) {
        vacleavesystemService.createBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取休假制度管理草稿", tags = {"休假制度管理" },  notes = "获取休假制度管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystems/getdraft")
    public ResponseEntity<VacLeaveSystemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemMapping.toDto(vacleavesystemService.getDraft(new VacLeaveSystem())));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemService.get(#vacleavesystem_id),'ehr-VacLeaveSystem-Update')")
    @ApiOperation(value = "更新休假制度管理", tags = {"休假制度管理" },  notes = "更新休假制度管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystems/{vacleavesystem_id}")
    @Transactional
    public ResponseEntity<VacLeaveSystemDTO> update(@PathVariable("vacleavesystem_id") String vacleavesystem_id, @RequestBody VacLeaveSystemDTO vacleavesystemdto) {
		VacLeaveSystem domain  = vacleavesystemMapping.toDomain(vacleavesystemdto);
        domain .setVacleavesystemid(vacleavesystem_id);
		vacleavesystemService.update(domain );
		VacLeaveSystemDTO dto = vacleavesystemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemService.getVacleavesystemByEntities(this.vacleavesystemMapping.toDomain(#vacleavesystemdtos)),'ehr-VacLeaveSystem-Update')")
    @ApiOperation(value = "批量更新休假制度管理", tags = {"休假制度管理" },  notes = "批量更新休假制度管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaveSystemDTO> vacleavesystemdtos) {
        vacleavesystemService.updateBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemService.get(#vacleavesystem_id),'ehr-VacLeaveSystem-Remove')")
    @ApiOperation(value = "删除休假制度管理", tags = {"休假制度管理" },  notes = "删除休假制度管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystems/{vacleavesystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavesystem_id") String vacleavesystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.remove(vacleavesystem_id));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemService.getVacleavesystemByIds(#ids),'ehr-VacLeaveSystem-Remove')")
    @ApiOperation(value = "批量删除休假制度管理", tags = {"休假制度管理" },  notes = "批量删除休假制度管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavesystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemMapping.toDomain(#vacleavesystemdto),'ehr-VacLeaveSystem-Save')")
    @ApiOperation(value = "保存休假制度管理", tags = {"休假制度管理" },  notes = "保存休假制度管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaveSystemDTO vacleavesystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.save(vacleavesystemMapping.toDomain(vacleavesystemdto)));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemMapping.toDomain(#vacleavesystemdtos),'ehr-VacLeaveSystem-Save')")
    @ApiOperation(value = "批量保存休假制度管理", tags = {"休假制度管理" },  notes = "批量保存休假制度管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaveSystemDTO> vacleavesystemdtos) {
        vacleavesystemService.saveBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查休假制度管理", tags = {"休假制度管理" },  notes = "检查休假制度管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaveSystemDTO vacleavesystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.checkKey(vacleavesystemMapping.toDomain(vacleavesystemdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveSystem-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"休假制度管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavesystems/fetchdefault")
	public ResponseEntity<List<VacLeaveSystemDTO>> fetchDefault(VacLeaveSystemSearchContext context) {
        Page<VacLeaveSystem> domains = vacleavesystemService.searchDefault(context) ;
        List<VacLeaveSystemDTO> list = vacleavesystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveSystem-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"休假制度管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavesystems/searchdefault")
	public ResponseEntity<Page<VacLeaveSystemDTO>> searchDefault(@RequestBody VacLeaveSystemSearchContext context) {
        Page<VacLeaveSystem> domains = vacleavesystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavesystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

