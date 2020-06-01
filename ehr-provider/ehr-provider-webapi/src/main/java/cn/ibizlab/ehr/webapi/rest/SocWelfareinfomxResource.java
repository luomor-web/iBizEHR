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
import cn.ibizlab.ehr.core.soc.domain.SocWelfareinfomx;
import cn.ibizlab.ehr.core.soc.service.ISocWelfareinfomxService;
import cn.ibizlab.ehr.core.soc.filter.SocWelfareinfomxSearchContext;

@Slf4j
@Api(tags = {"个人社保福利明细" })
@RestController("WebApi-socwelfareinfomx")
@RequestMapping("")
public class SocWelfareinfomxResource {

    @Autowired
    public ISocWelfareinfomxService socwelfareinfomxService;

    @Autowired
    @Lazy
    public SocWelfareinfomxMapping socwelfareinfomxMapping;

    @PreAuthorize("hasPermission(this.socwelfareinfomxService.get(#socwelfareinfomx_id),'ehr-SocWelfareinfomx-Remove')")
    @ApiOperation(value = "删除个人社保福利明细", tags = {"个人社保福利明细" },  notes = "删除个人社保福利明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.remove(socwelfareinfomx_id));
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxService.getSocwelfareinfomxByIds(#ids),'ehr-SocWelfareinfomx-Remove')")
    @ApiOperation(value = "批量删除个人社保福利明细", tags = {"个人社保福利明细" },  notes = "批量删除个人社保福利明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socwelfareinfomxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxMapping.toDomain(#socwelfareinfomxdto),'ehr-SocWelfareinfomx-Save')")
    @ApiOperation(value = "保存个人社保福利明细", tags = {"个人社保福利明细" },  notes = "保存个人社保福利明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SocWelfareinfomxDTO socwelfareinfomxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.save(socwelfareinfomxMapping.toDomain(socwelfareinfomxdto)));
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxMapping.toDomain(#socwelfareinfomxdtos),'ehr-SocWelfareinfomx-Save')")
    @ApiOperation(value = "批量保存个人社保福利明细", tags = {"个人社保福利明细" },  notes = "批量保存个人社保福利明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocWelfareinfomxDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.saveBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查个人社保福利明细", tags = {"个人社保福利明细" },  notes = "检查个人社保福利明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocWelfareinfomxDTO socwelfareinfomxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.checkKey(socwelfareinfomxMapping.toDomain(socwelfareinfomxdto)));
    }

    @ApiOperation(value = "获取个人社保福利明细草稿", tags = {"个人社保福利明细" },  notes = "获取个人社保福利明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfomxes/getdraft")
    public ResponseEntity<SocWelfareinfomxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxMapping.toDto(socwelfareinfomxService.getDraft(new SocWelfareinfomx())));
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxMapping.toDomain(#socwelfareinfomxdto),'ehr-SocWelfareinfomx-Create')")
    @ApiOperation(value = "新建个人社保福利明细", tags = {"个人社保福利明细" },  notes = "新建个人社保福利明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes")
    @Transactional
    public ResponseEntity<SocWelfareinfomxDTO> create(@RequestBody SocWelfareinfomxDTO socwelfareinfomxdto) {
        SocWelfareinfomx domain = socwelfareinfomxMapping.toDomain(socwelfareinfomxdto);
		socwelfareinfomxService.create(domain);
        SocWelfareinfomxDTO dto = socwelfareinfomxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxMapping.toDomain(#socwelfareinfomxdtos),'ehr-SocWelfareinfomx-Create')")
    @ApiOperation(value = "批量新建个人社保福利明细", tags = {"个人社保福利明细" },  notes = "批量新建个人社保福利明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocWelfareinfomxDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.createBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socwelfareinfomxMapping.toDomain(returnObject.body),'ehr-SocWelfareinfomx-Get')")
    @ApiOperation(value = "获取个人社保福利明细", tags = {"个人社保福利明细" },  notes = "获取个人社保福利明细")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    public ResponseEntity<SocWelfareinfomxDTO> get(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id) {
        SocWelfareinfomx domain = socwelfareinfomxService.get(socwelfareinfomx_id);
        SocWelfareinfomxDTO dto = socwelfareinfomxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxService.get(#socwelfareinfomx_id),'ehr-SocWelfareinfomx-Update')")
    @ApiOperation(value = "更新个人社保福利明细", tags = {"个人社保福利明细" },  notes = "更新个人社保福利明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    @Transactional
    public ResponseEntity<SocWelfareinfomxDTO> update(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id, @RequestBody SocWelfareinfomxDTO socwelfareinfomxdto) {
		SocWelfareinfomx domain  = socwelfareinfomxMapping.toDomain(socwelfareinfomxdto);
        domain .setSocwelfareinfomxid(socwelfareinfomx_id);
		socwelfareinfomxService.update(domain );
		SocWelfareinfomxDTO dto = socwelfareinfomxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfomxService.getSocwelfareinfomxByEntities(this.socwelfareinfomxMapping.toDomain(#socwelfareinfomxdtos)),'ehr-SocWelfareinfomx-Update')")
    @ApiOperation(value = "批量更新个人社保福利明细", tags = {"个人社保福利明细" },  notes = "批量更新个人社保福利明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocWelfareinfomxDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.updateBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareinfomx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"个人社保福利明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socwelfareinfomxes/fetchdefault")
	public ResponseEntity<List<SocWelfareinfomxDTO>> fetchDefault(SocWelfareinfomxSearchContext context) {
        Page<SocWelfareinfomx> domains = socwelfareinfomxService.searchDefault(context) ;
        List<SocWelfareinfomxDTO> list = socwelfareinfomxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareinfomx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"个人社保福利明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socwelfareinfomxes/searchdefault")
	public ResponseEntity<Page<SocWelfareinfomxDTO>> searchDefault(@RequestBody SocWelfareinfomxSearchContext context) {
        Page<SocWelfareinfomx> domains = socwelfareinfomxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socwelfareinfomxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

