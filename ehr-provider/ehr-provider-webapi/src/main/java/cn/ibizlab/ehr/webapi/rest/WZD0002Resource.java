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
import cn.ibizlab.ehr.core.trm.domain.WZD0002;
import cn.ibizlab.ehr.core.trm.service.IWZD0002Service;
import cn.ibizlab.ehr.core.trm.filter.WZD0002SearchContext;

@Slf4j
@Api(tags = {"干部退出（优秀年轻干部梯队）" })
@RestController("WebApi-wzd0002")
@RequestMapping("")
public class WZD0002Resource {

    @Autowired
    public IWZD0002Service wzd0002Service;

    @Autowired
    @Lazy
    public WZD0002Mapping wzd0002Mapping;

    @PreAuthorize("hasPermission(this.wzd0002Service.get(#wzd0002_id),'ehr-WZD0002-Remove')")
    @ApiOperation(value = "删除干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "删除干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0002s/{wzd0002_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wzd0002_id") String wzd0002_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.remove(wzd0002_id));
    }

    @PreAuthorize("hasPermission(this.wzd0002Service.getWzd0002ByIds(#ids),'ehr-WZD0002-Remove')")
    @ApiOperation(value = "批量删除干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量删除干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wzd0002Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.wzd0002Mapping.toDomain(#wzd0002dto),'ehr-WZD0002-Save')")
    @ApiOperation(value = "保存干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "保存干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/save")
    public ResponseEntity<Boolean> save(@RequestBody WZD0002DTO wzd0002dto) {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.save(wzd0002Mapping.toDomain(wzd0002dto)));
    }

    @PreAuthorize("hasPermission(this.wzd0002Mapping.toDomain(#wzd0002dtos),'ehr-WZD0002-Save')")
    @ApiOperation(value = "批量保存干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量保存干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.saveBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取干部退出（优秀年轻干部梯队）草稿", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "获取干部退出（优秀年轻干部梯队）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0002s/getdraft")
    public ResponseEntity<WZD0002DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0002Mapping.toDto(wzd0002Service.getDraft(new WZD0002())));
    }

    @ApiOperation(value = "检查干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "检查干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WZD0002DTO wzd0002dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.checkKey(wzd0002Mapping.toDomain(wzd0002dto)));
    }

    @PostAuthorize("hasPermission(this.wzd0002Mapping.toDomain(returnObject.body),'ehr-WZD0002-Get')")
    @ApiOperation(value = "获取干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "获取干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0002s/{wzd0002_id}")
    public ResponseEntity<WZD0002DTO> get(@PathVariable("wzd0002_id") String wzd0002_id) {
        WZD0002 domain = wzd0002Service.get(wzd0002_id);
        WZD0002DTO dto = wzd0002Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.wzd0002Mapping.toDomain(#wzd0002dto),'ehr-WZD0002-Create')")
    @ApiOperation(value = "新建干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "新建干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s")
    @Transactional
    public ResponseEntity<WZD0002DTO> create(@RequestBody WZD0002DTO wzd0002dto) {
        WZD0002 domain = wzd0002Mapping.toDomain(wzd0002dto);
		wzd0002Service.create(domain);
        WZD0002DTO dto = wzd0002Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.wzd0002Mapping.toDomain(#wzd0002dtos),'ehr-WZD0002-Create')")
    @ApiOperation(value = "批量新建干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量新建干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.createBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.wzd0002Service.get(#wzd0002_id),'ehr-WZD0002-Update')")
    @ApiOperation(value = "更新干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "更新干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0002s/{wzd0002_id}")
    @Transactional
    public ResponseEntity<WZD0002DTO> update(@PathVariable("wzd0002_id") String wzd0002_id, @RequestBody WZD0002DTO wzd0002dto) {
		WZD0002 domain  = wzd0002Mapping.toDomain(wzd0002dto);
        domain .setWzd0002id(wzd0002_id);
		wzd0002Service.update(domain );
		WZD0002DTO dto = wzd0002Mapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.wzd0002Service.getWzd0002ByEntities(this.wzd0002Mapping.toDomain(#wzd0002dtos)),'ehr-WZD0002-Update')")
    @ApiOperation(value = "批量更新干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量更新干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.updateBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"干部退出（优秀年轻干部梯队）" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/wzd0002s/fetchdefault")
	public ResponseEntity<List<WZD0002DTO>> fetchDefault(WZD0002SearchContext context) {
        Page<WZD0002> domains = wzd0002Service.searchDefault(context) ;
        List<WZD0002DTO> list = wzd0002Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"干部退出（优秀年轻干部梯队）" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/wzd0002s/searchdefault")
	public ResponseEntity<Page<WZD0002DTO>> searchDefault(@RequestBody WZD0002SearchContext context) {
        Page<WZD0002> domains = wzd0002Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wzd0002Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

