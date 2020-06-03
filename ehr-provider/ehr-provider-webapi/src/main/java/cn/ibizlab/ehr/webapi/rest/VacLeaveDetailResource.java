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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveDetailSearchContext;

@Slf4j
@Api(tags = {"请假明细" })
@RestController("WebApi-vacleavedetail")
@RequestMapping("")
public class VacLeaveDetailResource {

    @Autowired
    public IVacLeaveDetailService vacleavedetailService;

    @Autowired
    @Lazy
    public VacLeaveDetailMapping vacleavedetailMapping;

    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "删除请假明细", tags = {"请假明细" },  notes = "删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavedetail_id") String vacleavedetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.remove(vacleavedetail_id));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByIds(#ids),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "批量删除请假明细", tags = {"请假明细" },  notes = "批量删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavedetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcSJQJTS-all')")
    @ApiOperation(value = "计算实际请假天数", tags = {"请假明细" },  notes = "计算实际请假天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/{vacleavedetail_id}/calcsjqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcSJQJTS(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail.setVacleavedetailid(vacleavedetail_id);
        vacleavedetail = vacleavedetailService.calcSJQJTS(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "新建请假明细", tags = {"请假明细" },  notes = "新建请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> create(@RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
		vacleavedetailService.create(domain);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "批量新建请假明细", tags = {"请假明细" },  notes = "批量新建请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        vacleavedetailService.createBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "更新请假明细", tags = {"请假明细" },  notes = "更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> update(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
		VacLeaveDetail domain  = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain .setVacleavedetailid(vacleavedetail_id);
		vacleavedetailService.update(domain );
		VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByEntities(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos)),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "批量更新请假明细", tags = {"请假明细" },  notes = "批量更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        vacleavedetailService.updateBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-GetNianJia-all')")
    @ApiOperation(value = "获取假期使用情况、温馨提示、计算计划请假天数", tags = {"请假明细" },  notes = "获取假期使用情况、温馨提示、计算计划请假天数")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/{vacleavedetail_id}/getnianjia")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> getNianJia(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail.setVacleavedetailid(vacleavedetail_id);
        vacleavedetail = vacleavedetailService.getNianJia(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "保存请假明细", tags = {"请假明细" },  notes = "保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.save(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "批量保存请假明细", tags = {"请假明细" },  notes = "批量保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        vacleavedetailService.saveBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcJHQJTS-all')")
    @ApiOperation(value = "计算计划请假天数", tags = {"请假明细" },  notes = "计算计划请假天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/{vacleavedetail_id}/calcjhqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcJHQJTS(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail.setVacleavedetailid(vacleavedetail_id);
        vacleavedetail = vacleavedetailService.calcJHQJTS(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PostAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(returnObject.body),'ehr-VacLeaveDetail-Get')")
    @ApiOperation(value = "获取请假明细", tags = {"请假明细" },  notes = "获取请假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/{vacleavedetail_id}")
    public ResponseEntity<VacLeaveDetailDTO> get(@PathVariable("vacleavedetail_id") String vacleavedetail_id) {
        VacLeaveDetail domain = vacleavedetailService.get(vacleavedetail_id);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查请假明细", tags = {"请假明细" },  notes = "检查请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.checkKey(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }

    @ApiOperation(value = "获取请假明细草稿", tags = {"请假明细" },  notes = "获取请假明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/getdraft")
    public ResponseEntity<VacLeaveDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailMapping.toDto(vacleavedetailService.getDraft(new VacLeaveDetail())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"请假明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavedetails/fetchdefault")
	public ResponseEntity<List<VacLeaveDetailDTO>> fetchDefault(VacLeaveDetailSearchContext context) {
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
        List<VacLeaveDetailDTO> list = vacleavedetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"请假明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavedetails/searchdefault")
	public ResponseEntity<Page<VacLeaveDetailDTO>> searchDefault(@RequestBody VacLeaveDetailSearchContext context) {
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavedetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "根据请假管理删除请假明细", tags = {"请假明细" },  notes = "根据请假管理删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.remove(vacleavedetail_id));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByIds(#ids),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "根据请假管理批量删除请假明细", tags = {"请假明细" },  notes = "根据请假管理批量删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> removeBatchByVacLeaveManage(@RequestBody List<String> ids) {
        vacleavedetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcSJQJTS-all')")
    @ApiOperation(value = "根据请假管理请假明细", tags = {"请假明细" },  notes = "根据请假管理请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/calcsjqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcSJQJTSByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.calcSJQJTS(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "根据请假管理建立请假明细", tags = {"请假明细" },  notes = "根据请假管理建立请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> createByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
		vacleavedetailService.create(domain);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "根据请假管理批量建立请假明细", tags = {"请假明细" },  notes = "根据请假管理批量建立请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> createBatchByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
            domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "根据请假管理更新请假明细", tags = {"请假明细" },  notes = "根据请假管理更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> updateByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain.setVacleavedetailid(vacleavedetail_id);
		vacleavedetailService.update(domain);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByEntities(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos)),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "根据请假管理批量更新请假明细", tags = {"请假明细" },  notes = "根据请假管理批量更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> updateBatchByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
            domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-GetNianJia-all')")
    @ApiOperation(value = "根据请假管理请假明细", tags = {"请假明细" },  notes = "根据请假管理请假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/getnianjia")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> getNianJiaByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.getNianJia(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "根据请假管理保存请假明细", tags = {"请假明细" },  notes = "根据请假管理保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/save")
    public ResponseEntity<Boolean> saveByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "根据请假管理批量保存请假明细", tags = {"请假明细" },  notes = "根据请假管理批量保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
             domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcJHQJTS-all')")
    @ApiOperation(value = "根据请假管理请假明细", tags = {"请假明细" },  notes = "根据请假管理请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/calcjhqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcJHQJTSByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.calcJHQJTS(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PostAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(returnObject.body),'ehr-VacLeaveDetail-Get')")
    @ApiOperation(value = "根据请假管理获取请假明细", tags = {"请假明细" },  notes = "根据请假管理获取请假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    public ResponseEntity<VacLeaveDetailDTO> getByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id) {
        VacLeaveDetail domain = vacleavedetailService.get(vacleavedetail_id);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据请假管理检查请假明细", tags = {"请假明细" },  notes = "根据请假管理检查请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.checkKey(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }

    @ApiOperation(value = "根据请假管理获取请假明细草稿", tags = {"请假明细" },  notes = "根据请假管理获取请假明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/vacleavemanages/{vacleavemanage_id}/vacleavedetails/getdraft")
    public ResponseEntity<VacLeaveDetailDTO> getDraftByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VacLeaveDetail domain = new VacLeaveDetail();
        domain.setVacleavemanageid(vacleavemanage_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailMapping.toDto(vacleavedetailService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "根据请假管理获取DEFAULT", tags = {"请假明细" } ,notes = "根据请假管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavemanages/{vacleavemanage_id}/vacleavedetails/fetchdefault")
	public ResponseEntity<List<VacLeaveDetailDTO>> fetchVacLeaveDetailDefaultByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id,VacLeaveDetailSearchContext context) {
        context.setN_vacleavemanageid_eq(vacleavemanage_id);
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
        List<VacLeaveDetailDTO> list = vacleavedetailMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "根据请假管理查询DEFAULT", tags = {"请假明细" } ,notes = "根据请假管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavemanages/{vacleavemanage_id}/vacleavedetails/searchdefault")
	public ResponseEntity<Page<VacLeaveDetailDTO>> searchVacLeaveDetailDefaultByVacLeaveManage(@PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailSearchContext context) {
        context.setN_vacleavemanageid_eq(vacleavemanage_id);
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavedetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "根据人员信息请假管理删除请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.remove(vacleavedetail_id));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByIds(#ids),'ehr-VacLeaveDetail-Remove')")
    @ApiOperation(value = "根据人员信息请假管理批量删除请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理批量删除请假明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonVacLeaveManage(@RequestBody List<String> ids) {
        vacleavedetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcSJQJTS-all')")
    @ApiOperation(value = "根据人员信息请假管理请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/calcsjqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcSJQJTSByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.calcSJQJTS(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "根据人员信息请假管理建立请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理建立请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> createByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
		vacleavedetailService.create(domain);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Create')")
    @ApiOperation(value = "根据人员信息请假管理批量建立请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理批量建立请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
            domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.get(#vacleavedetail_id),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "根据人员信息请假管理更新请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> updateByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain.setVacleavedetailid(vacleavedetail_id);
		vacleavedetailService.update(domain);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailService.getVacleavedetailByEntities(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos)),'ehr-VacLeaveDetail-Update')")
    @ApiOperation(value = "根据人员信息请假管理批量更新请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理批量更新请假明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
            domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-GetNianJia-all')")
    @ApiOperation(value = "根据人员信息请假管理请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理请假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/getnianjia")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> getNianJiaByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.getNianJia(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildto),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "根据人员信息请假管理保存请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/save")
    public ResponseEntity<Boolean> saveByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(#vacleavedetaildtos),'ehr-VacLeaveDetail-Save')")
    @ApiOperation(value = "根据人员信息请假管理批量保存请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理批量保存请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody List<VacLeaveDetailDTO> vacleavedetaildtos) {
        List<VacLeaveDetail> domainlist=vacleavedetailMapping.toDomain(vacleavedetaildtos);
        for(VacLeaveDetail domain:domainlist){
             domain.setVacleavemanageid(vacleavemanage_id);
        }
        vacleavedetailService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-CalcJHQJTS-all')")
    @ApiOperation(value = "根据人员信息请假管理请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}/calcjhqjts")
    @Transactional
    public ResponseEntity<VacLeaveDetailDTO> calcJHQJTSByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        VacLeaveDetail domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavemanageid(vacleavemanage_id);
        domain = vacleavedetailService.calcJHQJTS(domain) ;
        vacleavedetaildto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }

    @PostAuthorize("hasPermission(this.vacleavedetailMapping.toDomain(returnObject.body),'ehr-VacLeaveDetail-Get')")
    @ApiOperation(value = "根据人员信息请假管理获取请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理获取请假明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/{vacleavedetail_id}")
    public ResponseEntity<VacLeaveDetailDTO> getByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @PathVariable("vacleavedetail_id") String vacleavedetail_id) {
        VacLeaveDetail domain = vacleavedetailService.get(vacleavedetail_id);
        VacLeaveDetailDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息请假管理检查请假明细", tags = {"请假明细" },  notes = "根据人员信息请假管理检查请假明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailDTO vacleavedetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.checkKey(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }

    @ApiOperation(value = "根据人员信息请假管理获取请假明细草稿", tags = {"请假明细" },  notes = "根据人员信息请假管理获取请假明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/getdraft")
    public ResponseEntity<VacLeaveDetailDTO> getDraftByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id) {
        VacLeaveDetail domain = new VacLeaveDetail();
        domain.setVacleavemanageid(vacleavemanage_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailMapping.toDto(vacleavedetailService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "根据人员信息请假管理获取DEFAULT", tags = {"请假明细" } ,notes = "根据人员信息请假管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/fetchdefault")
	public ResponseEntity<List<VacLeaveDetailDTO>> fetchVacLeaveDetailDefaultByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id,VacLeaveDetailSearchContext context) {
        context.setN_vacleavemanageid_eq(vacleavemanage_id);
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
        List<VacLeaveDetailDTO> list = vacleavedetailMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveDetail-Default-all')")
	@ApiOperation(value = "根据人员信息请假管理查询DEFAULT", tags = {"请假明细" } ,notes = "根据人员信息请假管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/vacleavemanages/{vacleavemanage_id}/vacleavedetails/searchdefault")
	public ResponseEntity<Page<VacLeaveDetailDTO>> searchVacLeaveDetailDefaultByPimPersonVacLeaveManage(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("vacleavemanage_id") String vacleavemanage_id, @RequestBody VacLeaveDetailSearchContext context) {
        context.setN_vacleavemanageid_eq(vacleavemanage_id);
        Page<VacLeaveDetail> domains = vacleavedetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavedetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

