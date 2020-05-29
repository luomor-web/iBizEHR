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
import cn.ibizlab.ehr.core.soc.domain.SocCompanyWel;
import cn.ibizlab.ehr.core.soc.service.ISocCompanyWelService;
import cn.ibizlab.ehr.core.soc.filter.SocCompanyWelSearchContext;

@Slf4j
@Api(tags = {"单位社保账户" })
@RestController("WebApi-soccompanywel")
@RequestMapping("")
public class SocCompanyWelResource {

    @Autowired
    public ISocCompanyWelService soccompanywelService;

    @Autowired
    @Lazy
    public SocCompanyWelMapping soccompanywelMapping;

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldto),'ehr-SocCompanyWel-Create')")
    @ApiOperation(value = "新建单位社保账户", tags = {"单位社保账户" },  notes = "新建单位社保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels")
    @Transactional
    public ResponseEntity<SocCompanyWelDTO> create(@RequestBody SocCompanyWelDTO soccompanyweldto) {
        SocCompanyWel domain = soccompanywelMapping.toDomain(soccompanyweldto);
		soccompanywelService.create(domain);
        SocCompanyWelDTO dto = soccompanywelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldtos),'ehr-SocCompanyWel-Create')")
    @ApiOperation(value = "批量新建单位社保账户", tags = {"单位社保账户" },  notes = "批量新建单位社保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocCompanyWelDTO> soccompanyweldtos) {
        soccompanywelService.createBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查单位社保账户", tags = {"单位社保账户" },  notes = "检查单位社保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocCompanyWelDTO soccompanyweldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.checkKey(soccompanywelMapping.toDomain(soccompanyweldto)));
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldto),'ehr-SocCompanyWel-Save')")
    @ApiOperation(value = "保存单位社保账户", tags = {"单位社保账户" },  notes = "保存单位社保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/save")
    public ResponseEntity<Boolean> save(@RequestBody SocCompanyWelDTO soccompanyweldto) {
        return ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.save(soccompanywelMapping.toDomain(soccompanyweldto)));
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldtos),'ehr-SocCompanyWel-Save')")
    @ApiOperation(value = "批量保存单位社保账户", tags = {"单位社保账户" },  notes = "批量保存单位社保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocCompanyWelDTO> soccompanyweldtos) {
        soccompanywelService.saveBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.get(#soccompanywel_id),'ehr-SocCompanyWel-Update')")
    @ApiOperation(value = "更新单位社保账户", tags = {"单位社保账户" },  notes = "更新单位社保账户")
	@RequestMapping(method = RequestMethod.PUT, value = "/soccompanywels/{soccompanywel_id}")
    @Transactional
    public ResponseEntity<SocCompanyWelDTO> update(@PathVariable("soccompanywel_id") String soccompanywel_id, @RequestBody SocCompanyWelDTO soccompanyweldto) {
		SocCompanyWel domain  = soccompanywelMapping.toDomain(soccompanyweldto);
        domain .setSoccompanywelid(soccompanywel_id);
		soccompanywelService.update(domain );
		SocCompanyWelDTO dto = soccompanywelMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.getSoccompanywelByEntities(this.soccompanywelMapping.toDomain(#soccompanyweldtos)),'ehr-SocCompanyWel-Update')")
    @ApiOperation(value = "批量更新单位社保账户", tags = {"单位社保账户" },  notes = "批量更新单位社保账户")
	@RequestMapping(method = RequestMethod.PUT, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocCompanyWelDTO> soccompanyweldtos) {
        soccompanywelService.updateBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.soccompanywelMapping.toDomain(returnObject.body),'ehr-SocCompanyWel-Get')")
    @ApiOperation(value = "获取单位社保账户", tags = {"单位社保账户" },  notes = "获取单位社保账户")
	@RequestMapping(method = RequestMethod.GET, value = "/soccompanywels/{soccompanywel_id}")
    public ResponseEntity<SocCompanyWelDTO> get(@PathVariable("soccompanywel_id") String soccompanywel_id) {
        SocCompanyWel domain = soccompanywelService.get(soccompanywel_id);
        SocCompanyWelDTO dto = soccompanywelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.get(#soccompanywel_id),'ehr-SocCompanyWel-Remove')")
    @ApiOperation(value = "删除单位社保账户", tags = {"单位社保账户" },  notes = "删除单位社保账户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soccompanywels/{soccompanywel_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("soccompanywel_id") String soccompanywel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.remove(soccompanywel_id));
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.getSoccompanywelByIds(#ids),'ehr-SocCompanyWel-Remove')")
    @ApiOperation(value = "批量删除单位社保账户", tags = {"单位社保账户" },  notes = "批量删除单位社保账户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        soccompanywelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取单位社保账户草稿", tags = {"单位社保账户" },  notes = "获取单位社保账户草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/soccompanywels/getdraft")
    public ResponseEntity<SocCompanyWelDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(soccompanywelMapping.toDto(soccompanywelService.getDraft(new SocCompanyWel())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocCompanyWel-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"单位社保账户" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/soccompanywels/fetchdefault")
	public ResponseEntity<List<SocCompanyWelDTO>> fetchDefault(SocCompanyWelSearchContext context) {
        Page<SocCompanyWel> domains = soccompanywelService.searchDefault(context) ;
        List<SocCompanyWelDTO> list = soccompanywelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocCompanyWel-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"单位社保账户" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/soccompanywels/searchdefault")
	public ResponseEntity<Page<SocCompanyWelDTO>> searchDefault(@RequestBody SocCompanyWelSearchContext context) {
        Page<SocCompanyWel> domains = soccompanywelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(soccompanywelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

