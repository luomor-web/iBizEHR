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
import cn.ibizlab.ehr.core.trm.domain.TrmStaff;
import cn.ibizlab.ehr.core.trm.service.ITrmStaffService;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffSearchContext;

@Slf4j
@Api(tags = {"员工需求填报" })
@RestController("WebApi-trmstaff")
@RequestMapping("")
public class TrmStaffResource {

    @Autowired
    public ITrmStaffService trmstaffService;

    @Autowired
    @Lazy
    public TrmStaffMapping trmstaffMapping;

    @PreAuthorize("hasPermission(this.trmstaffService.get(#trmstaff_id),'ehr-TrmStaff-Remove')")
    @ApiOperation(value = "删除员工需求填报", tags = {"员工需求填报" },  notes = "删除员工需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffs/{trmstaff_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstaff_id") String trmstaff_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstaffService.remove(trmstaff_id));
    }

    @PreAuthorize("hasPermission(this.trmstaffService.getTrmstaffByIds(#ids),'ehr-TrmStaff-Remove')")
    @ApiOperation(value = "批量删除员工需求填报", tags = {"员工需求填报" },  notes = "批量删除员工需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstaffService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查员工需求填报", tags = {"员工需求填报" },  notes = "检查员工需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmStaffDTO trmstaffdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstaffService.checkKey(trmstaffMapping.toDomain(trmstaffdto)));
    }

    @PreAuthorize("hasPermission(this.trmstaffService.get(#trmstaff_id),'ehr-TrmStaff-Update')")
    @ApiOperation(value = "更新员工需求填报", tags = {"员工需求填报" },  notes = "更新员工需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffs/{trmstaff_id}")
    @Transactional
    public ResponseEntity<TrmStaffDTO> update(@PathVariable("trmstaff_id") String trmstaff_id, @RequestBody TrmStaffDTO trmstaffdto) {
		TrmStaff domain  = trmstaffMapping.toDomain(trmstaffdto);
        domain .setTrmstaffid(trmstaff_id);
		trmstaffService.update(domain );
		TrmStaffDTO dto = trmstaffMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstaffService.getTrmstaffByEntities(this.trmstaffMapping.toDomain(#trmstaffdtos)),'ehr-TrmStaff-Update')")
    @ApiOperation(value = "批量更新员工需求填报", tags = {"员工需求填报" },  notes = "批量更新员工需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmStaffDTO> trmstaffdtos) {
        trmstaffService.updateBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstaffMapping.toDomain(#trmstaffdto),'ehr-TrmStaff-Create')")
    @ApiOperation(value = "新建员工需求填报", tags = {"员工需求填报" },  notes = "新建员工需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs")
    @Transactional
    public ResponseEntity<TrmStaffDTO> create(@RequestBody TrmStaffDTO trmstaffdto) {
        TrmStaff domain = trmstaffMapping.toDomain(trmstaffdto);
		trmstaffService.create(domain);
        TrmStaffDTO dto = trmstaffMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstaffMapping.toDomain(#trmstaffdtos),'ehr-TrmStaff-Create')")
    @ApiOperation(value = "批量新建员工需求填报", tags = {"员工需求填报" },  notes = "批量新建员工需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmStaffDTO> trmstaffdtos) {
        trmstaffService.createBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取员工需求填报草稿", tags = {"员工需求填报" },  notes = "获取员工需求填报草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffs/getdraft")
    public ResponseEntity<TrmStaffDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffMapping.toDto(trmstaffService.getDraft(new TrmStaff())));
    }

    @PostAuthorize("hasPermission(this.trmstaffMapping.toDomain(returnObject.body),'ehr-TrmStaff-Get')")
    @ApiOperation(value = "获取员工需求填报", tags = {"员工需求填报" },  notes = "获取员工需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffs/{trmstaff_id}")
    public ResponseEntity<TrmStaffDTO> get(@PathVariable("trmstaff_id") String trmstaff_id) {
        TrmStaff domain = trmstaffService.get(trmstaff_id);
        TrmStaffDTO dto = trmstaffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstaffMapping.toDomain(#trmstaffdto),'ehr-TrmStaff-Save')")
    @ApiOperation(value = "保存员工需求填报", tags = {"员工需求填报" },  notes = "保存员工需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmStaffDTO trmstaffdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffService.save(trmstaffMapping.toDomain(trmstaffdto)));
    }

    @PreAuthorize("hasPermission(this.trmstaffMapping.toDomain(#trmstaffdtos),'ehr-TrmStaff-Save')")
    @ApiOperation(value = "批量保存员工需求填报", tags = {"员工需求填报" },  notes = "批量保存员工需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmStaffDTO> trmstaffdtos) {
        trmstaffService.saveBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStaff-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工需求填报" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstaffs/fetchdefault")
	public ResponseEntity<List<TrmStaffDTO>> fetchDefault(TrmStaffSearchContext context) {
        Page<TrmStaff> domains = trmstaffService.searchDefault(context) ;
        List<TrmStaffDTO> list = trmstaffMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStaff-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工需求填报" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstaffs/searchdefault")
	public ResponseEntity<Page<TrmStaffDTO>> searchDefault(@RequestBody TrmStaffSearchContext context) {
        Page<TrmStaff> domains = trmstaffService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstaffMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

