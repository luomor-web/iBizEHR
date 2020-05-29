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
import cn.ibizlab.ehr.core.trm.domain.TrmDepart;
import cn.ibizlab.ehr.core.trm.service.ITrmDepartService;
import cn.ibizlab.ehr.core.trm.filter.TrmDepartSearchContext;

@Slf4j
@Api(tags = {"培训需求通知" })
@RestController("WebApi-trmdepart")
@RequestMapping("")
public class TrmDepartResource {

    @Autowired
    public ITrmDepartService trmdepartService;

    @Autowired
    @Lazy
    public TrmDepartMapping trmdepartMapping;

    @PostAuthorize("hasPermission(this.trmdepartMapping.toDomain(returnObject.body),'ehr-TrmDepart-Get')")
    @ApiOperation(value = "获取培训需求通知", tags = {"培训需求通知" },  notes = "获取培训需求通知")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}")
    public ResponseEntity<TrmDepartDTO> get(@PathVariable("trmdepart_id") String trmdepart_id) {
        TrmDepart domain = trmdepartService.get(trmdepart_id);
        TrmDepartDTO dto = trmdepartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartMapping.toDomain(#trmdepartdto),'ehr-TrmDepart-Save')")
    @ApiOperation(value = "保存培训需求通知", tags = {"培训需求通知" },  notes = "保存培训需求通知")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmDepartDTO trmdepartdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartService.save(trmdepartMapping.toDomain(trmdepartdto)));
    }

    @PreAuthorize("hasPermission(this.trmdepartMapping.toDomain(#trmdepartdtos),'ehr-TrmDepart-Save')")
    @ApiOperation(value = "批量保存培训需求通知", tags = {"培训需求通知" },  notes = "批量保存培训需求通知")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmDepartDTO> trmdepartdtos) {
        trmdepartService.saveBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdepartMapping.toDomain(#trmdepartdto),'ehr-TrmDepart-Create')")
    @ApiOperation(value = "新建培训需求通知", tags = {"培训需求通知" },  notes = "新建培训需求通知")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts")
    @Transactional
    public ResponseEntity<TrmDepartDTO> create(@RequestBody TrmDepartDTO trmdepartdto) {
        TrmDepart domain = trmdepartMapping.toDomain(trmdepartdto);
		trmdepartService.create(domain);
        TrmDepartDTO dto = trmdepartMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartMapping.toDomain(#trmdepartdtos),'ehr-TrmDepart-Create')")
    @ApiOperation(value = "批量新建培训需求通知", tags = {"培训需求通知" },  notes = "批量新建培训需求通知")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmDepartDTO> trmdepartdtos) {
        trmdepartService.createBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdepartService.get(#trmdepart_id),'ehr-TrmDepart-Remove')")
    @ApiOperation(value = "删除培训需求通知", tags = {"培训需求通知" },  notes = "删除培训需求通知")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdepart_id") String trmdepart_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdepartService.remove(trmdepart_id));
    }

    @PreAuthorize("hasPermission(this.trmdepartService.getTrmdepartByIds(#ids),'ehr-TrmDepart-Remove')")
    @ApiOperation(value = "批量删除培训需求通知", tags = {"培训需求通知" },  notes = "批量删除培训需求通知")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdepartService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训需求通知", tags = {"培训需求通知" },  notes = "检查培训需求通知")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmDepartDTO trmdepartdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdepartService.checkKey(trmdepartMapping.toDomain(trmdepartdto)));
    }

    @PreAuthorize("hasPermission(this.trmdepartService.get(#trmdepart_id),'ehr-TrmDepart-Update')")
    @ApiOperation(value = "更新培训需求通知", tags = {"培训需求通知" },  notes = "更新培训需求通知")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}")
    @Transactional
    public ResponseEntity<TrmDepartDTO> update(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmDepartDTO trmdepartdto) {
		TrmDepart domain  = trmdepartMapping.toDomain(trmdepartdto);
        domain .setTrmdepartid(trmdepart_id);
		trmdepartService.update(domain );
		TrmDepartDTO dto = trmdepartMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartService.getTrmdepartByEntities(this.trmdepartMapping.toDomain(#trmdepartdtos)),'ehr-TrmDepart-Update')")
    @ApiOperation(value = "批量更新培训需求通知", tags = {"培训需求通知" },  notes = "批量更新培训需求通知")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmDepartDTO> trmdepartdtos) {
        trmdepartService.updateBatch(trmdepartMapping.toDomain(trmdepartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训需求通知草稿", tags = {"培训需求通知" },  notes = "获取培训需求通知草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/getdraft")
    public ResponseEntity<TrmDepartDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartMapping.toDto(trmdepartService.getDraft(new TrmDepart())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDepart-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训需求通知" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/fetchdefault")
	public ResponseEntity<List<TrmDepartDTO>> fetchDefault(TrmDepartSearchContext context) {
        Page<TrmDepart> domains = trmdepartService.searchDefault(context) ;
        List<TrmDepartDTO> list = trmdepartMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDepart-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训需求通知" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/searchdefault")
	public ResponseEntity<Page<TrmDepartDTO>> searchDefault(@RequestBody TrmDepartSearchContext context) {
        Page<TrmDepart> domains = trmdepartService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdepartMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

