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
import cn.ibizlab.ehr.core.trm.domain.TrmEmployeeRetion;
import cn.ibizlab.ehr.core.trm.service.ITrmEmployeeRetionService;
import cn.ibizlab.ehr.core.trm.filter.TrmEmployeeRetionSearchContext;

@Slf4j
@Api(tags = {"员工培训报名" })
@RestController("WebApi-trmemployeeretion")
@RequestMapping("")
public class TrmEmployeeRetionResource {

    @Autowired
    public ITrmEmployeeRetionService trmemployeeretionService;

    @Autowired
    @Lazy
    public TrmEmployeeRetionMapping trmemployeeretionMapping;

    @PreAuthorize("hasPermission(this.trmemployeeretionService.get(#trmemployeeretion_id),'ehr-TrmEmployeeRetion-Remove')")
    @ApiOperation(value = "删除员工培训报名", tags = {"员工培训报名" },  notes = "删除员工培训报名")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployeeretions/{trmemployeeretion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.remove(trmemployeeretion_id));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.getTrmemployeeretionByIds(#ids),'ehr-TrmEmployeeRetion-Remove')")
    @ApiOperation(value = "批量删除员工培训报名", tags = {"员工培训报名" },  notes = "批量删除员工培训报名")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmemployeeretionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取员工培训报名草稿", tags = {"员工培训报名" },  notes = "获取员工培训报名草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployeeretions/getdraft")
    public ResponseEntity<TrmEmployeeRetionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionMapping.toDto(trmemployeeretionService.getDraft(new TrmEmployeeRetion())));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.get(#trmemployeeretion_id),'ehr-TrmEmployeeRetion-Update')")
    @ApiOperation(value = "更新员工培训报名", tags = {"员工培训报名" },  notes = "更新员工培训报名")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployeeretions/{trmemployeeretion_id}")
    @Transactional
    public ResponseEntity<TrmEmployeeRetionDTO> update(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id, @RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
		TrmEmployeeRetion domain  = trmemployeeretionMapping.toDomain(trmemployeeretiondto);
        domain .setTrmemployretionid(trmemployeeretion_id);
		trmemployeeretionService.update(domain );
		TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.getTrmemployeeretionByEntities(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos)),'ehr-TrmEmployeeRetion-Update')")
    @ApiOperation(value = "批量更新员工培训报名", tags = {"员工培训报名" },  notes = "批量更新员工培训报名")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.updateBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondto),'ehr-TrmEmployeeRetion-Save')")
    @ApiOperation(value = "保存员工培训报名", tags = {"员工培训报名" },  notes = "保存员工培训报名")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.save(trmemployeeretionMapping.toDomain(trmemployeeretiondto)));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos),'ehr-TrmEmployeeRetion-Save')")
    @ApiOperation(value = "批量保存员工培训报名", tags = {"员工培训报名" },  notes = "批量保存员工培训报名")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.saveBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondto),'ehr-TrmEmployeeRetion-Create')")
    @ApiOperation(value = "新建员工培训报名", tags = {"员工培训报名" },  notes = "新建员工培训报名")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions")
    @Transactional
    public ResponseEntity<TrmEmployeeRetionDTO> create(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        TrmEmployeeRetion domain = trmemployeeretionMapping.toDomain(trmemployeeretiondto);
		trmemployeeretionService.create(domain);
        TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos),'ehr-TrmEmployeeRetion-Create')")
    @ApiOperation(value = "批量新建员工培训报名", tags = {"员工培训报名" },  notes = "批量新建员工培训报名")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.createBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查员工培训报名", tags = {"员工培训报名" },  notes = "检查员工培训报名")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.checkKey(trmemployeeretionMapping.toDomain(trmemployeeretiondto)));
    }

    @PostAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(returnObject.body),'ehr-TrmEmployeeRetion-Get')")
    @ApiOperation(value = "获取员工培训报名", tags = {"员工培训报名" },  notes = "获取员工培训报名")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployeeretions/{trmemployeeretion_id}")
    public ResponseEntity<TrmEmployeeRetionDTO> get(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id) {
        TrmEmployeeRetion domain = trmemployeeretionService.get(trmemployeeretion_id);
        TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmEmployeeRetion-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工培训报名" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmemployeeretions/fetchdefault")
	public ResponseEntity<List<TrmEmployeeRetionDTO>> fetchDefault(TrmEmployeeRetionSearchContext context) {
        Page<TrmEmployeeRetion> domains = trmemployeeretionService.searchDefault(context) ;
        List<TrmEmployeeRetionDTO> list = trmemployeeretionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmEmployeeRetion-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"员工培训报名" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmemployeeretions/searchdefault")
	public ResponseEntity<Page<TrmEmployeeRetionDTO>> searchDefault(@RequestBody TrmEmployeeRetionSearchContext context) {
        Page<TrmEmployeeRetion> domains = trmemployeeretionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmemployeeretionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

