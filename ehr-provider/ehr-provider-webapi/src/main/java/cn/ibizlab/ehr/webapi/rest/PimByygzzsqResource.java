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
import cn.ibizlab.ehr.core.pim.domain.PimByygzzsq;
import cn.ibizlab.ehr.core.pim.service.IPimByygzzsqService;
import cn.ibizlab.ehr.core.pim.filter.PimByygzzsqSearchContext;

@Slf4j
@Api(tags = {"B/Y类员工转正申请" })
@RestController("WebApi-pimbyygzzsq")
@RequestMapping("")
public class PimByygzzsqResource {

    @Autowired
    public IPimByygzzsqService pimbyygzzsqService;

    @Autowired
    @Lazy
    public PimByygzzsqMapping pimbyygzzsqMapping;

    @PostAuthorize("hasPermission(this.pimbyygzzsqMapping.toDomain(returnObject.body),'ehr-PimByygzzsq-Get')")
    @ApiOperation(value = "获取B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "获取B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    public ResponseEntity<PimByygzzsqDTO> get(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PimByygzzsq domain = pimbyygzzsqService.get(pimbyygzzsq_id);
        PimByygzzsqDTO dto = pimbyygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqService.get(#pimbyygzzsq_id),'ehr-PimByygzzsq-Update')")
    @ApiOperation(value = "更新B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "更新B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    @Transactional
    public ResponseEntity<PimByygzzsqDTO> update(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByygzzsqDTO pimbyygzzsqdto) {
		PimByygzzsq domain  = pimbyygzzsqMapping.toDomain(pimbyygzzsqdto);
        domain .setPimbyygzzsqid(pimbyygzzsq_id);
		pimbyygzzsqService.update(domain );
		PimByygzzsqDTO dto = pimbyygzzsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqService.getPimbyygzzsqByEntities(this.pimbyygzzsqMapping.toDomain(#pimbyygzzsqdtos)),'ehr-PimByygzzsq-Update')")
    @ApiOperation(value = "批量更新B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "批量更新B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimByygzzsqDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.updateBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqService.get(#pimbyygzzsq_id),'ehr-PimByygzzsq-Remove')")
    @ApiOperation(value = "删除B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "删除B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.remove(pimbyygzzsq_id));
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqService.getPimbyygzzsqByIds(#ids),'ehr-PimByygzzsq-Remove')")
    @ApiOperation(value = "批量删除B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "批量删除B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbyygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqMapping.toDomain(#pimbyygzzsqdto),'ehr-PimByygzzsq-Save')")
    @ApiOperation(value = "保存B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "保存B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimByygzzsqDTO pimbyygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.save(pimbyygzzsqMapping.toDomain(pimbyygzzsqdto)));
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqMapping.toDomain(#pimbyygzzsqdtos),'ehr-PimByygzzsq-Save')")
    @ApiOperation(value = "批量保存B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "批量保存B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimByygzzsqDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.saveBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取B/Y类员工转正申请草稿", tags = {"B/Y类员工转正申请" },  notes = "获取B/Y类员工转正申请草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/getdraft")
    public ResponseEntity<PimByygzzsqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqMapping.toDto(pimbyygzzsqService.getDraft(new PimByygzzsq())));
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqMapping.toDomain(#pimbyygzzsqdto),'ehr-PimByygzzsq-Create')")
    @ApiOperation(value = "新建B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "新建B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs")
    @Transactional
    public ResponseEntity<PimByygzzsqDTO> create(@RequestBody PimByygzzsqDTO pimbyygzzsqdto) {
        PimByygzzsq domain = pimbyygzzsqMapping.toDomain(pimbyygzzsqdto);
		pimbyygzzsqService.create(domain);
        PimByygzzsqDTO dto = pimbyygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyygzzsqMapping.toDomain(#pimbyygzzsqdtos),'ehr-PimByygzzsq-Create')")
    @ApiOperation(value = "批量新建B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "批量新建B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimByygzzsqDTO> pimbyygzzsqdtos) {
        pimbyygzzsqService.createBatch(pimbyygzzsqMapping.toDomain(pimbyygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查B/Y类员工转正申请", tags = {"B/Y类员工转正申请" },  notes = "检查B/Y类员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimByygzzsqDTO pimbyygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyygzzsqService.checkKey(pimbyygzzsqMapping.toDomain(pimbyygzzsqdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByygzzsq-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"B/Y类员工转正申请" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/fetchdefault")
	public ResponseEntity<List<PimByygzzsqDTO>> fetchDefault(PimByygzzsqSearchContext context) {
        Page<PimByygzzsq> domains = pimbyygzzsqService.searchDefault(context) ;
        List<PimByygzzsqDTO> list = pimbyygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByygzzsq-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"B/Y类员工转正申请" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/searchdefault")
	public ResponseEntity<Page<PimByygzzsqDTO>> searchDefault(@RequestBody PimByygzzsqSearchContext context) {
        Page<PimByygzzsq> domains = pimbyygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

