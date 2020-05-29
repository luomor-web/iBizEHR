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
import cn.ibizlab.ehr.core.trm.domain.TrmGradecadres;
import cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService;
import cn.ibizlab.ehr.core.trm.filter.TrmGradecadresSearchContext;

@Slf4j
@Api(tags = {"优秀青年干部推荐" })
@RestController("WebApi-trmgradecadres")
@RequestMapping("")
public class TrmGradecadresResource {

    @Autowired
    public ITrmGradecadresService trmgradecadresService;

    @Autowired
    @Lazy
    public TrmGradecadresMapping trmgradecadresMapping;

    @PreAuthorize("hasPermission(this.trmgradecadresService.get(#trmgradecadres_id),'ehr-TrmGradecadres-Update')")
    @ApiOperation(value = "更新优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "更新优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmgradecadres/{trmgradecadres_id}")
    @Transactional
    public ResponseEntity<TrmGradecadresDTO> update(@PathVariable("trmgradecadres_id") String trmgradecadres_id, @RequestBody TrmGradecadresDTO trmgradecadresdto) {
		TrmGradecadres domain  = trmgradecadresMapping.toDomain(trmgradecadresdto);
        domain .setTrmgradecadresid(trmgradecadres_id);
		trmgradecadresService.update(domain );
		TrmGradecadresDTO dto = trmgradecadresMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmgradecadresService.getTrmgradecadresByEntities(this.trmgradecadresMapping.toDomain(#trmgradecadresdtos)),'ehr-TrmGradecadres-Update')")
    @ApiOperation(value = "批量更新优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "批量更新优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmGradecadresDTO> trmgradecadresdtos) {
        trmgradecadresService.updateBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "检查优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmGradecadresDTO trmgradecadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.checkKey(trmgradecadresMapping.toDomain(trmgradecadresdto)));
    }

    @PreAuthorize("hasPermission(this.trmgradecadresService.get(#trmgradecadres_id),'ehr-TrmGradecadres-Remove')")
    @ApiOperation(value = "删除优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "删除优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmgradecadres/{trmgradecadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmgradecadres_id") String trmgradecadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.remove(trmgradecadres_id));
    }

    @PreAuthorize("hasPermission(this.trmgradecadresService.getTrmgradecadresByIds(#ids),'ehr-TrmGradecadres-Remove')")
    @ApiOperation(value = "批量删除优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "批量删除优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmgradecadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmgradecadresMapping.toDomain(#trmgradecadresdto),'ehr-TrmGradecadres-Create')")
    @ApiOperation(value = "新建优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "新建优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres")
    @Transactional
    public ResponseEntity<TrmGradecadresDTO> create(@RequestBody TrmGradecadresDTO trmgradecadresdto) {
        TrmGradecadres domain = trmgradecadresMapping.toDomain(trmgradecadresdto);
		trmgradecadresService.create(domain);
        TrmGradecadresDTO dto = trmgradecadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmgradecadresMapping.toDomain(#trmgradecadresdtos),'ehr-TrmGradecadres-Create')")
    @ApiOperation(value = "批量新建优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "批量新建优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmGradecadresDTO> trmgradecadresdtos) {
        trmgradecadresService.createBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取优秀青年干部推荐草稿", tags = {"优秀青年干部推荐" },  notes = "获取优秀青年干部推荐草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmgradecadres/getdraft")
    public ResponseEntity<TrmGradecadresDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresMapping.toDto(trmgradecadresService.getDraft(new TrmGradecadres())));
    }

    @PreAuthorize("hasPermission(this.trmgradecadresMapping.toDomain(#trmgradecadresdto),'ehr-TrmGradecadres-Save')")
    @ApiOperation(value = "保存优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "保存优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmGradecadresDTO trmgradecadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.save(trmgradecadresMapping.toDomain(trmgradecadresdto)));
    }

    @PreAuthorize("hasPermission(this.trmgradecadresMapping.toDomain(#trmgradecadresdtos),'ehr-TrmGradecadres-Save')")
    @ApiOperation(value = "批量保存优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "批量保存优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmGradecadresDTO> trmgradecadresdtos) {
        trmgradecadresService.saveBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmgradecadresMapping.toDomain(returnObject.body),'ehr-TrmGradecadres-Get')")
    @ApiOperation(value = "获取优秀青年干部推荐", tags = {"优秀青年干部推荐" },  notes = "获取优秀青年干部推荐")
	@RequestMapping(method = RequestMethod.GET, value = "/trmgradecadres/{trmgradecadres_id}")
    public ResponseEntity<TrmGradecadresDTO> get(@PathVariable("trmgradecadres_id") String trmgradecadres_id) {
        TrmGradecadres domain = trmgradecadresService.get(trmgradecadres_id);
        TrmGradecadresDTO dto = trmgradecadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmGradecadres-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"优秀青年干部推荐" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmgradecadres/fetchdefault")
	public ResponseEntity<List<TrmGradecadresDTO>> fetchDefault(TrmGradecadresSearchContext context) {
        Page<TrmGradecadres> domains = trmgradecadresService.searchDefault(context) ;
        List<TrmGradecadresDTO> list = trmgradecadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmGradecadres-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"优秀青年干部推荐" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmgradecadres/searchdefault")
	public ResponseEntity<Page<TrmGradecadresDTO>> searchDefault(@RequestBody TrmGradecadresSearchContext context) {
        Page<TrmGradecadres> domains = trmgradecadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmgradecadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

