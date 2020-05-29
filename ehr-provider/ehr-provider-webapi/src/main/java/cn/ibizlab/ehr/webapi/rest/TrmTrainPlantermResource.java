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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlantermSearchContext;

@Slf4j
@Api(tags = {"培训立项" })
@RestController("WebApi-trmtrainplanterm")
@RequestMapping("")
public class TrmTrainPlantermResource {

    @Autowired
    public ITrmTrainPlantermService trmtrainplantermService;

    @Autowired
    @Lazy
    public TrmTrainPlantermMapping trmtrainplantermMapping;

    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "获取培训立项", tags = {"培训立项" },  notes = "获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> get(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "删除培训立项", tags = {"培训立项" },  notes = "删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "批量删除培训立项", tags = {"培训立项" },  notes = "批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训立项", tags = {"培训立项" },  notes = "检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "更新培训立项", tags = {"培训立项" },  notes = "更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> update(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
		TrmTrainPlanterm domain  = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain .setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain );
		TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "批量更新培训立项", tags = {"培训立项" },  notes = "批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.updateBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "保存培训立项", tags = {"培训立项" },  notes = "保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "批量保存培训立项", tags = {"培训立项" },  notes = "批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.saveBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训立项草稿", tags = {"培训立项" },  notes = "获取培训立项草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(new TrmTrainPlanterm())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "开班", tags = {"培训立项" },  notes = "开班")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kB(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.kB(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "新建培训立项", tags = {"培训立项" },  notes = "新建培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> create(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "批量新建培训立项", tags = {"培训立项" },  notes = "批量新建培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.createBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "取消", tags = {"培训立项" },  notes = "取消")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.qX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "立项", tags = {"培训立项" },  notes = "立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.lX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训立项" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchDefault(TrmTrainPlantermSearchContext context) {
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训立项" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchDefault(@RequestBody TrmTrainPlantermSearchContext context) {
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

