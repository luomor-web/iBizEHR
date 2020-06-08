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
import cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo;
import cn.ibizlab.ehr.core.soc.service.ISocWelfareInfoService;
import cn.ibizlab.ehr.core.soc.filter.SocWelfareInfoSearchContext;

@Slf4j
@Api(tags = {"个人社保福利" })
@RestController("WebApi-socwelfareinfo")
@RequestMapping("")
public class SocWelfareInfoResource {

    @Autowired
    public ISocWelfareInfoService socwelfareinfoService;

    @Autowired
    @Lazy
    public SocWelfareInfoMapping socwelfareinfoMapping;

    @ApiOperation(value = "检查个人社保福利", tags = {"个人社保福利" },  notes = "检查个人社保福利")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocWelfareInfoDTO socwelfareinfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.checkKey(socwelfareinfoMapping.toDomain(socwelfareinfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareInfo-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取人员的附加数据", tags = {"个人社保福利" },  notes = "获取人员的附加数据")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}/getfjsjofperson")
    @Transactional
    public ResponseEntity<SocWelfareInfoDTO> getFJSJofPerson(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SocWelfareInfoDTO socwelfareinfodto) {
        SocWelfareInfo socwelfareinfo = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        socwelfareinfo.setSocwelfareinfoid(socwelfareinfo_id);
        socwelfareinfo = socwelfareinfoService.getFJSJofPerson(socwelfareinfo);
        socwelfareinfodto = socwelfareinfoMapping.toDto(socwelfareinfo);
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfodto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoMapping.toDomain(#socwelfareinfodto),'ehr-SocWelfareInfo-Save')")
    @ApiOperation(value = "保存个人社保福利", tags = {"个人社保福利" },  notes = "保存个人社保福利")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/save")
    public ResponseEntity<Boolean> save(@RequestBody SocWelfareInfoDTO socwelfareinfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.save(socwelfareinfoMapping.toDomain(socwelfareinfodto)));
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoMapping.toDomain(#socwelfareinfodtos),'ehr-SocWelfareInfo-Save')")
    @ApiOperation(value = "批量保存个人社保福利", tags = {"个人社保福利" },  notes = "批量保存个人社保福利")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocWelfareInfoDTO> socwelfareinfodtos) {
        socwelfareinfoService.saveBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取个人社保福利草稿", tags = {"个人社保福利" },  notes = "获取个人社保福利草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/getdraft")
    public ResponseEntity<SocWelfareInfoDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoMapping.toDto(socwelfareinfoService.getDraft(new SocWelfareInfo())));
    }

    @PostAuthorize("hasPermission(this.socwelfareinfoMapping.toDomain(returnObject.body),'ehr-SocWelfareInfo-Get')")
    @ApiOperation(value = "获取个人社保福利", tags = {"个人社保福利" },  notes = "获取个人社保福利")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}")
    public ResponseEntity<SocWelfareInfoDTO> get(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id) {
        SocWelfareInfo domain = socwelfareinfoService.get(socwelfareinfo_id);
        SocWelfareInfoDTO dto = socwelfareinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareInfo-GetCBDofSOCCOMPANYWEL-all')")
    @ApiOperation(value = "获取单位社保账户的参保地", tags = {"个人社保福利" },  notes = "获取单位社保账户的参保地")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}/getcbdofsoccompanywel")
    @Transactional
    public ResponseEntity<SocWelfareInfoDTO> getCBDofSOCCOMPANYWEL(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SocWelfareInfoDTO socwelfareinfodto) {
        SocWelfareInfo socwelfareinfo = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        socwelfareinfo.setSocwelfareinfoid(socwelfareinfo_id);
        socwelfareinfo = socwelfareinfoService.getCBDofSOCCOMPANYWEL(socwelfareinfo);
        socwelfareinfodto = socwelfareinfoMapping.toDto(socwelfareinfo);
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfodto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoService.get(#socwelfareinfo_id),'ehr-SocWelfareInfo-Update')")
    @ApiOperation(value = "更新个人社保福利", tags = {"个人社保福利" },  notes = "更新个人社保福利")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfos/{socwelfareinfo_id}")
    @Transactional
    public ResponseEntity<SocWelfareInfoDTO> update(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SocWelfareInfoDTO socwelfareinfodto) {
		SocWelfareInfo domain  = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        domain .setSocwelfareinfoid(socwelfareinfo_id);
		socwelfareinfoService.update(domain );
		SocWelfareInfoDTO dto = socwelfareinfoMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoService.getSocwelfareinfoByEntities(this.socwelfareinfoMapping.toDomain(#socwelfareinfodtos)),'ehr-SocWelfareInfo-Update')")
    @ApiOperation(value = "批量更新个人社保福利", tags = {"个人社保福利" },  notes = "批量更新个人社保福利")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocWelfareInfoDTO> socwelfareinfodtos) {
        socwelfareinfoService.updateBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoService.get(#socwelfareinfo_id),'ehr-SocWelfareInfo-Remove')")
    @ApiOperation(value = "删除个人社保福利", tags = {"个人社保福利" },  notes = "删除个人社保福利")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfos/{socwelfareinfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.remove(socwelfareinfo_id));
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoService.getSocwelfareinfoByIds(#ids),'ehr-SocWelfareInfo-Remove')")
    @ApiOperation(value = "批量删除个人社保福利", tags = {"个人社保福利" },  notes = "批量删除个人社保福利")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socwelfareinfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoMapping.toDomain(#socwelfareinfodto),'ehr-SocWelfareInfo-Create')")
    @ApiOperation(value = "新建个人社保福利", tags = {"个人社保福利" },  notes = "新建个人社保福利")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos")
    @Transactional
    public ResponseEntity<SocWelfareInfoDTO> create(@RequestBody SocWelfareInfoDTO socwelfareinfodto) {
        SocWelfareInfo domain = socwelfareinfoMapping.toDomain(socwelfareinfodto);
		socwelfareinfoService.create(domain);
        SocWelfareInfoDTO dto = socwelfareinfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socwelfareinfoMapping.toDomain(#socwelfareinfodtos),'ehr-SocWelfareInfo-Create')")
    @ApiOperation(value = "批量新建个人社保福利", tags = {"个人社保福利" },  notes = "批量新建个人社保福利")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocWelfareInfoDTO> socwelfareinfodtos) {
        socwelfareinfoService.createBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareInfo-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"个人社保福利" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socwelfareinfos/fetchdefault")
	public ResponseEntity<List<SocWelfareInfoDTO>> fetchDefault(SocWelfareInfoSearchContext context) {
        Page<SocWelfareInfo> domains = socwelfareinfoService.searchDefault(context) ;
        List<SocWelfareInfoDTO> list = socwelfareinfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocWelfareInfo-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"个人社保福利" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socwelfareinfos/searchdefault")
	public ResponseEntity<Page<SocWelfareInfoDTO>> searchDefault(@RequestBody SocWelfareInfoSearchContext context) {
        Page<SocWelfareInfo> domains = socwelfareinfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socwelfareinfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

