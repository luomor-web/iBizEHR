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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveSystemDtail;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveSystemDtailService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveSystemDtailSearchContext;

@Slf4j
@Api(tags = {"休假制度明细" })
@RestController("WebApi-vacleavesystemdtail")
@RequestMapping("")
public class VacLeaveSystemDtailResource {

    @Autowired
    public IVacLeaveSystemDtailService vacleavesystemdtailService;

    @Autowired
    @Lazy
    public VacLeaveSystemDtailMapping vacleavesystemdtailMapping;

    @PreAuthorize("hasPermission(this.vacleavesystemdtailService.get(#vacleavesystemdtail_id),'ehr-VacLeaveSystemDtail-Update')")
    @ApiOperation(value = "更新休假制度明细", tags = {"休假制度明细" },  notes = "更新休假制度明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystemdtails/{vacleavesystemdtail_id}")
    @Transactional
    public ResponseEntity<VacLeaveSystemDtailDTO> update(@PathVariable("vacleavesystemdtail_id") String vacleavesystemdtail_id, @RequestBody VacLeaveSystemDtailDTO vacleavesystemdtaildto) {
		VacLeaveSystemDtail domain  = vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildto);
        domain .setVacleavesystemdetailid(vacleavesystemdtail_id);
		vacleavesystemdtailService.update(domain );
		VacLeaveSystemDtailDTO dto = vacleavesystemdtailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailService.getVacleavesystemdtailByEntities(this.vacleavesystemdtailMapping.toDomain(#vacleavesystemdtaildtos)),'ehr-VacLeaveSystemDtail-Update')")
    @ApiOperation(value = "批量更新休假制度明细", tags = {"休假制度明细" },  notes = "批量更新休假制度明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystemdtails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaveSystemDtailDTO> vacleavesystemdtaildtos) {
        vacleavesystemdtailService.updateBatch(vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查休假制度明细", tags = {"休假制度明细" },  notes = "检查休假制度明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdtails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaveSystemDtailDTO vacleavesystemdtaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdtailService.checkKey(vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildto)));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailMapping.toDomain(#vacleavesystemdtaildto),'ehr-VacLeaveSystemDtail-Save')")
    @ApiOperation(value = "保存休假制度明细", tags = {"休假制度明细" },  notes = "保存休假制度明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdtails/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaveSystemDtailDTO vacleavesystemdtaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdtailService.save(vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildto)));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailMapping.toDomain(#vacleavesystemdtaildtos),'ehr-VacLeaveSystemDtail-Save')")
    @ApiOperation(value = "批量保存休假制度明细", tags = {"休假制度明细" },  notes = "批量保存休假制度明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdtails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaveSystemDtailDTO> vacleavesystemdtaildtos) {
        vacleavesystemdtailService.saveBatch(vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailService.get(#vacleavesystemdtail_id),'ehr-VacLeaveSystemDtail-Remove')")
    @ApiOperation(value = "删除休假制度明细", tags = {"休假制度明细" },  notes = "删除休假制度明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystemdtails/{vacleavesystemdtail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavesystemdtail_id") String vacleavesystemdtail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdtailService.remove(vacleavesystemdtail_id));
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailService.getVacleavesystemdtailByIds(#ids),'ehr-VacLeaveSystemDtail-Remove')")
    @ApiOperation(value = "批量删除休假制度明细", tags = {"休假制度明细" },  notes = "批量删除休假制度明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystemdtails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavesystemdtailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取休假制度明细草稿", tags = {"休假制度明细" },  notes = "获取休假制度明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystemdtails/getdraft")
    public ResponseEntity<VacLeaveSystemDtailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdtailMapping.toDto(vacleavesystemdtailService.getDraft(new VacLeaveSystemDtail())));
    }

    @PostAuthorize("hasPermission(this.vacleavesystemdtailMapping.toDomain(returnObject.body),'ehr-VacLeaveSystemDtail-Get')")
    @ApiOperation(value = "获取休假制度明细", tags = {"休假制度明细" },  notes = "获取休假制度明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystemdtails/{vacleavesystemdtail_id}")
    public ResponseEntity<VacLeaveSystemDtailDTO> get(@PathVariable("vacleavesystemdtail_id") String vacleavesystemdtail_id) {
        VacLeaveSystemDtail domain = vacleavesystemdtailService.get(vacleavesystemdtail_id);
        VacLeaveSystemDtailDTO dto = vacleavesystemdtailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailMapping.toDomain(#vacleavesystemdtaildto),'ehr-VacLeaveSystemDtail-Create')")
    @ApiOperation(value = "新建休假制度明细", tags = {"休假制度明细" },  notes = "新建休假制度明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdtails")
    @Transactional
    public ResponseEntity<VacLeaveSystemDtailDTO> create(@RequestBody VacLeaveSystemDtailDTO vacleavesystemdtaildto) {
        VacLeaveSystemDtail domain = vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildto);
		vacleavesystemdtailService.create(domain);
        VacLeaveSystemDtailDTO dto = vacleavesystemdtailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavesystemdtailMapping.toDomain(#vacleavesystemdtaildtos),'ehr-VacLeaveSystemDtail-Create')")
    @ApiOperation(value = "批量新建休假制度明细", tags = {"休假制度明细" },  notes = "批量新建休假制度明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdtails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaveSystemDtailDTO> vacleavesystemdtaildtos) {
        vacleavesystemdtailService.createBatch(vacleavesystemdtailMapping.toDomain(vacleavesystemdtaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveSystemDtail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"休假制度明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavesystemdtails/fetchdefault")
	public ResponseEntity<List<VacLeaveSystemDtailDTO>> fetchDefault(VacLeaveSystemDtailSearchContext context) {
        Page<VacLeaveSystemDtail> domains = vacleavesystemdtailService.searchDefault(context) ;
        List<VacLeaveSystemDtailDTO> list = vacleavesystemdtailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveSystemDtail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"休假制度明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavesystemdtails/searchdefault")
	public ResponseEntity<Page<VacLeaveSystemDtailDTO>> searchDefault(@RequestBody VacLeaveSystemDtailSearchContext context) {
        Page<VacLeaveSystemDtail> domains = vacleavesystemdtailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavesystemdtailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

