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
import cn.ibizlab.ehr.core.vac.domain.VacSituationDetail;
import cn.ibizlab.ehr.core.vac.service.IVacSituationDetailService;
import cn.ibizlab.ehr.core.vac.filter.VacSituationDetailSearchContext;

@Slf4j
@Api(tags = {"休假明细" })
@RestController("WebApi-vacsituationdetail")
@RequestMapping("")
public class VacSituationDetailResource {

    @Autowired
    public IVacSituationDetailService vacsituationdetailService;

    @Autowired
    @Lazy
    public VacSituationDetailMapping vacsituationdetailMapping;

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VacSituationDetail-Update')")
    @ApiOperation(value = "更新休假明细", tags = {"休假明细" },  notes = "更新休假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<VacSituationDetailDTO> update(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id, @RequestBody VacSituationDetailDTO vacsituationdetaildto) {
		VacSituationDetail domain  = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
        domain .setVacsituationdetailid(vacsituationdetail_id);
		vacsituationdetailService.update(domain );
		VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByEntities(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos)),'ehr-VacSituationDetail-Update')")
    @ApiOperation(value = "批量更新休假明细", tags = {"休假明细" },  notes = "批量更新休假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.updateBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取休假明细草稿", tags = {"休假明细" },  notes = "获取休假明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/getdraft")
    public ResponseEntity<VacSituationDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailMapping.toDto(vacsituationdetailService.getDraft(new VacSituationDetail())));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VacSituationDetail-Create')")
    @ApiOperation(value = "新建休假明细", tags = {"休假明细" },  notes = "新建休假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails")
    @Transactional
    public ResponseEntity<VacSituationDetailDTO> create(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        VacSituationDetail domain = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
		vacsituationdetailService.create(domain);
        VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VacSituationDetail-Create')")
    @ApiOperation(value = "批量新建休假明细", tags = {"休假明细" },  notes = "批量新建休假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.createBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(returnObject.body),'ehr-VacSituationDetail-Get')")
    @ApiOperation(value = "获取休假明细", tags = {"休假明细" },  notes = "获取休假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/{vacsituationdetail_id}")
    public ResponseEntity<VacSituationDetailDTO> get(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
        VacSituationDetail domain = vacsituationdetailService.get(vacsituationdetail_id);
        VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查休假明细", tags = {"休假明细" },  notes = "检查休假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.checkKey(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VacSituationDetail-Save')")
    @ApiOperation(value = "保存休假明细", tags = {"休假明细" },  notes = "保存休假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.save(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VacSituationDetail-Save')")
    @ApiOperation(value = "批量保存休假明细", tags = {"休假明细" },  notes = "批量保存休假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.saveBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VacSituationDetail-Remove')")
    @ApiOperation(value = "删除休假明细", tags = {"休假明细" },  notes = "删除休假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.remove(vacsituationdetail_id));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByIds(#ids),'ehr-VacSituationDetail-Remove')")
    @ApiOperation(value = "批量删除休假明细", tags = {"休假明细" },  notes = "批量删除休假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsituationdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituationDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"休假明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsituationdetails/fetchdefault")
	public ResponseEntity<List<VacSituationDetailDTO>> fetchDefault(VacSituationDetailSearchContext context) {
        Page<VacSituationDetail> domains = vacsituationdetailService.searchDefault(context) ;
        List<VacSituationDetailDTO> list = vacsituationdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituationDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"休假明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsituationdetails/searchdefault")
	public ResponseEntity<Page<VacSituationDetailDTO>> searchDefault(@RequestBody VacSituationDetailSearchContext context) {
        Page<VacSituationDetail> domains = vacsituationdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsituationdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

