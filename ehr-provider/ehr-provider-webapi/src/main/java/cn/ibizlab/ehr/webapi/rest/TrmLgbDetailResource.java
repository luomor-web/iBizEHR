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
import cn.ibizlab.ehr.core.trm.domain.TrmLgbDetail;
import cn.ibizlab.ehr.core.trm.service.ITrmLgbDetailService;
import cn.ibizlab.ehr.core.trm.filter.TrmLgbDetailSearchContext;

@Slf4j
@Api(tags = {"老干部明细" })
@RestController("WebApi-trmlgbdetail")
@RequestMapping("")
public class TrmLgbDetailResource {

    @Autowired
    public ITrmLgbDetailService trmlgbdetailService;

    @Autowired
    @Lazy
    public TrmLgbDetailMapping trmlgbdetailMapping;

    @PreAuthorize("hasPermission(this.trmlgbdetailService.get(#trmlgbdetail_id),'ehr-TrmLgbDetail-Update')")
    @ApiOperation(value = "更新老干部明细", tags = {"老干部明细" },  notes = "更新老干部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbdetails/{trmlgbdetail_id}")
    @Transactional
    public ResponseEntity<TrmLgbDetailDTO> update(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id, @RequestBody TrmLgbDetailDTO trmlgbdetaildto) {
		TrmLgbDetail domain  = trmlgbdetailMapping.toDomain(trmlgbdetaildto);
        domain .setTrmlgbdetailid(trmlgbdetail_id);
		trmlgbdetailService.update(domain );
		TrmLgbDetailDTO dto = trmlgbdetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailService.getTrmlgbdetailByEntities(this.trmlgbdetailMapping.toDomain(#trmlgbdetaildtos)),'ehr-TrmLgbDetail-Update')")
    @ApiOperation(value = "批量更新老干部明细", tags = {"老干部明细" },  notes = "批量更新老干部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmLgbDetailDTO> trmlgbdetaildtos) {
        trmlgbdetailService.updateBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmlgbdetailMapping.toDomain(returnObject.body),'ehr-TrmLgbDetail-Get')")
    @ApiOperation(value = "获取老干部明细", tags = {"老干部明细" },  notes = "获取老干部明细")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbdetails/{trmlgbdetail_id}")
    public ResponseEntity<TrmLgbDetailDTO> get(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id) {
        TrmLgbDetail domain = trmlgbdetailService.get(trmlgbdetail_id);
        TrmLgbDetailDTO dto = trmlgbdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailMapping.toDomain(#trmlgbdetaildto),'ehr-TrmLgbDetail-Save')")
    @ApiOperation(value = "保存老干部明细", tags = {"老干部明细" },  notes = "保存老干部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmLgbDetailDTO trmlgbdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.save(trmlgbdetailMapping.toDomain(trmlgbdetaildto)));
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailMapping.toDomain(#trmlgbdetaildtos),'ehr-TrmLgbDetail-Save')")
    @ApiOperation(value = "批量保存老干部明细", tags = {"老干部明细" },  notes = "批量保存老干部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmLgbDetailDTO> trmlgbdetaildtos) {
        trmlgbdetailService.saveBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查老干部明细", tags = {"老干部明细" },  notes = "检查老干部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmLgbDetailDTO trmlgbdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.checkKey(trmlgbdetailMapping.toDomain(trmlgbdetaildto)));
    }

    @ApiOperation(value = "获取老干部明细草稿", tags = {"老干部明细" },  notes = "获取老干部明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbdetails/getdraft")
    public ResponseEntity<TrmLgbDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailMapping.toDto(trmlgbdetailService.getDraft(new TrmLgbDetail())));
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailMapping.toDomain(#trmlgbdetaildto),'ehr-TrmLgbDetail-Create')")
    @ApiOperation(value = "新建老干部明细", tags = {"老干部明细" },  notes = "新建老干部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails")
    @Transactional
    public ResponseEntity<TrmLgbDetailDTO> create(@RequestBody TrmLgbDetailDTO trmlgbdetaildto) {
        TrmLgbDetail domain = trmlgbdetailMapping.toDomain(trmlgbdetaildto);
		trmlgbdetailService.create(domain);
        TrmLgbDetailDTO dto = trmlgbdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailMapping.toDomain(#trmlgbdetaildtos),'ehr-TrmLgbDetail-Create')")
    @ApiOperation(value = "批量新建老干部明细", tags = {"老干部明细" },  notes = "批量新建老干部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmLgbDetailDTO> trmlgbdetaildtos) {
        trmlgbdetailService.createBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailService.get(#trmlgbdetail_id),'ehr-TrmLgbDetail-Remove')")
    @ApiOperation(value = "删除老干部明细", tags = {"老干部明细" },  notes = "删除老干部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbdetails/{trmlgbdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.remove(trmlgbdetail_id));
    }

    @PreAuthorize("hasPermission(this.trmlgbdetailService.getTrmlgbdetailByIds(#ids),'ehr-TrmLgbDetail-Remove')")
    @ApiOperation(value = "批量删除老干部明细", tags = {"老干部明细" },  notes = "批量删除老干部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmlgbdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmLgbDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"老干部明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmlgbdetails/fetchdefault")
	public ResponseEntity<List<TrmLgbDetailDTO>> fetchDefault(TrmLgbDetailSearchContext context) {
        Page<TrmLgbDetail> domains = trmlgbdetailService.searchDefault(context) ;
        List<TrmLgbDetailDTO> list = trmlgbdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmLgbDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"老干部明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmlgbdetails/searchdefault")
	public ResponseEntity<Page<TrmLgbDetailDTO>> searchDefault(@RequestBody TrmLgbDetailSearchContext context) {
        Page<TrmLgbDetail> domains = trmlgbdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmlgbdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

