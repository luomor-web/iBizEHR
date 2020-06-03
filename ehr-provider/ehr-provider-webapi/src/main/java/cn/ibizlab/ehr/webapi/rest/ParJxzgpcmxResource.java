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
import cn.ibizlab.ehr.core.par.domain.ParJxzgpcmx;
import cn.ibizlab.ehr.core.par.service.IParJxzgpcmxService;
import cn.ibizlab.ehr.core.par.filter.ParJxzgpcmxSearchContext;

@Slf4j
@Api(tags = {"绩效主观评测明细" })
@RestController("WebApi-parjxzgpcmx")
@RequestMapping("")
public class ParJxzgpcmxResource {

    @Autowired
    public IParJxzgpcmxService parjxzgpcmxService;

    @Autowired
    @Lazy
    public ParJxzgpcmxMapping parjxzgpcmxMapping;

    @ApiOperation(value = "获取绩效主观评测明细草稿", tags = {"绩效主观评测明细" },  notes = "获取绩效主观评测明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcmxes/getdraft")
    public ResponseEntity<ParJxzgpcmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcmxMapping.toDto(parjxzgpcmxService.getDraft(new ParJxzgpcmx())));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxService.get(#parjxzgpcmx_id),'ehr-ParJxzgpcmx-Update')")
    @ApiOperation(value = "更新绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "更新绩效主观评测明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcmxes/{parjxzgpcmx_id}")
    @Transactional
    public ResponseEntity<ParJxzgpcmxDTO> update(@PathVariable("parjxzgpcmx_id") String parjxzgpcmx_id, @RequestBody ParJxzgpcmxDTO parjxzgpcmxdto) {
		ParJxzgpcmx domain  = parjxzgpcmxMapping.toDomain(parjxzgpcmxdto);
        domain .setParjxzgpcmxid(parjxzgpcmx_id);
		parjxzgpcmxService.update(domain );
		ParJxzgpcmxDTO dto = parjxzgpcmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxService.getParjxzgpcmxByEntities(this.parjxzgpcmxMapping.toDomain(#parjxzgpcmxdtos)),'ehr-ParJxzgpcmx-Update')")
    @ApiOperation(value = "批量更新绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "批量更新绩效主观评测明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxzgpcmxDTO> parjxzgpcmxdtos) {
        parjxzgpcmxService.updateBatch(parjxzgpcmxMapping.toDomain(parjxzgpcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxMapping.toDomain(#parjxzgpcmxdto),'ehr-ParJxzgpcmx-Save')")
    @ApiOperation(value = "保存绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "保存绩效主观评测明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxzgpcmxDTO parjxzgpcmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcmxService.save(parjxzgpcmxMapping.toDomain(parjxzgpcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxMapping.toDomain(#parjxzgpcmxdtos),'ehr-ParJxzgpcmx-Save')")
    @ApiOperation(value = "批量保存绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "批量保存绩效主观评测明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxzgpcmxDTO> parjxzgpcmxdtos) {
        parjxzgpcmxService.saveBatch(parjxzgpcmxMapping.toDomain(parjxzgpcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxService.get(#parjxzgpcmx_id),'ehr-ParJxzgpcmx-Remove')")
    @ApiOperation(value = "删除绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "删除绩效主观评测明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcmxes/{parjxzgpcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxzgpcmx_id") String parjxzgpcmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcmxService.remove(parjxzgpcmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxService.getParjxzgpcmxByIds(#ids),'ehr-ParJxzgpcmx-Remove')")
    @ApiOperation(value = "批量删除绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "批量删除绩效主观评测明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxzgpcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxMapping.toDomain(#parjxzgpcmxdto),'ehr-ParJxzgpcmx-Create')")
    @ApiOperation(value = "新建绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "新建绩效主观评测明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcmxes")
    @Transactional
    public ResponseEntity<ParJxzgpcmxDTO> create(@RequestBody ParJxzgpcmxDTO parjxzgpcmxdto) {
        ParJxzgpcmx domain = parjxzgpcmxMapping.toDomain(parjxzgpcmxdto);
		parjxzgpcmxService.create(domain);
        ParJxzgpcmxDTO dto = parjxzgpcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcmxMapping.toDomain(#parjxzgpcmxdtos),'ehr-ParJxzgpcmx-Create')")
    @ApiOperation(value = "批量新建绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "批量新建绩效主观评测明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxzgpcmxDTO> parjxzgpcmxdtos) {
        parjxzgpcmxService.createBatch(parjxzgpcmxMapping.toDomain(parjxzgpcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxzgpcmxMapping.toDomain(returnObject.body),'ehr-ParJxzgpcmx-Get')")
    @ApiOperation(value = "获取绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "获取绩效主观评测明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcmxes/{parjxzgpcmx_id}")
    public ResponseEntity<ParJxzgpcmxDTO> get(@PathVariable("parjxzgpcmx_id") String parjxzgpcmx_id) {
        ParJxzgpcmx domain = parjxzgpcmxService.get(parjxzgpcmx_id);
        ParJxzgpcmxDTO dto = parjxzgpcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查绩效主观评测明细", tags = {"绩效主观评测明细" },  notes = "检查绩效主观评测明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxzgpcmxDTO parjxzgpcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxzgpcmxService.checkKey(parjxzgpcmxMapping.toDomain(parjxzgpcmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxzgpcmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效主观评测明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxzgpcmxes/fetchdefault")
	public ResponseEntity<List<ParJxzgpcmxDTO>> fetchDefault(ParJxzgpcmxSearchContext context) {
        Page<ParJxzgpcmx> domains = parjxzgpcmxService.searchDefault(context) ;
        List<ParJxzgpcmxDTO> list = parjxzgpcmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxzgpcmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效主观评测明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxzgpcmxes/searchdefault")
	public ResponseEntity<Page<ParJxzgpcmxDTO>> searchDefault(@RequestBody ParJxzgpcmxSearchContext context) {
        Page<ParJxzgpcmx> domains = parjxzgpcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxzgpcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

