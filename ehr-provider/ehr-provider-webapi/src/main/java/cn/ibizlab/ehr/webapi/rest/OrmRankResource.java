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
import cn.ibizlab.ehr.core.orm.domain.OrmRank;
import cn.ibizlab.ehr.core.orm.service.IOrmRankService;
import cn.ibizlab.ehr.core.orm.filter.OrmRankSearchContext;

@Slf4j
@Api(tags = {"职级管理" })
@RestController("WebApi-ormrank")
@RequestMapping("")
public class OrmRankResource {

    @Autowired
    public IOrmRankService ormrankService;

    @Autowired
    @Lazy
    public OrmRankMapping ormrankMapping;

    @PreAuthorize("hasPermission(this.ormrankService.get(#ormrank_id),'ehr-OrmRank-Update')")
    @ApiOperation(value = "更新职级管理", tags = {"职级管理" },  notes = "更新职级管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormranks/{ormrank_id}")
    @Transactional
    public ResponseEntity<OrmRankDTO> update(@PathVariable("ormrank_id") String ormrank_id, @RequestBody OrmRankDTO ormrankdto) {
		OrmRank domain  = ormrankMapping.toDomain(ormrankdto);
        domain .setOrmrankid(ormrank_id);
		ormrankService.update(domain );
		OrmRankDTO dto = ormrankMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrankService.getOrmrankByEntities(this.ormrankMapping.toDomain(#ormrankdtos)),'ehr-OrmRank-Update')")
    @ApiOperation(value = "批量更新职级管理", tags = {"职级管理" },  notes = "批量更新职级管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormranks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmRankDTO> ormrankdtos) {
        ormrankService.updateBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormrankService.get(#ormrank_id),'ehr-OrmRank-Remove')")
    @ApiOperation(value = "删除职级管理", tags = {"职级管理" },  notes = "删除职级管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormranks/{ormrank_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormrank_id") String ormrank_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormrankService.remove(ormrank_id));
    }

    @PreAuthorize("hasPermission(this.ormrankService.getOrmrankByIds(#ids),'ehr-OrmRank-Remove')")
    @ApiOperation(value = "批量删除职级管理", tags = {"职级管理" },  notes = "批量删除职级管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormranks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormrankService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormrankMapping.toDomain(#ormrankdto),'ehr-OrmRank-Save')")
    @ApiOperation(value = "保存职级管理", tags = {"职级管理" },  notes = "保存职级管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmRankDTO ormrankdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormrankService.save(ormrankMapping.toDomain(ormrankdto)));
    }

    @PreAuthorize("hasPermission(this.ormrankMapping.toDomain(#ormrankdtos),'ehr-OrmRank-Save')")
    @ApiOperation(value = "批量保存职级管理", tags = {"职级管理" },  notes = "批量保存职级管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmRankDTO> ormrankdtos) {
        ormrankService.saveBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormrankMapping.toDomain(returnObject.body),'ehr-OrmRank-Get')")
    @ApiOperation(value = "获取职级管理", tags = {"职级管理" },  notes = "获取职级管理")
	@RequestMapping(method = RequestMethod.GET, value = "/ormranks/{ormrank_id}")
    public ResponseEntity<OrmRankDTO> get(@PathVariable("ormrank_id") String ormrank_id) {
        OrmRank domain = ormrankService.get(ormrank_id);
        OrmRankDTO dto = ormrankMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查职级管理", tags = {"职级管理" },  notes = "检查职级管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmRankDTO ormrankdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormrankService.checkKey(ormrankMapping.toDomain(ormrankdto)));
    }

    @ApiOperation(value = "获取职级管理草稿", tags = {"职级管理" },  notes = "获取职级管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormranks/getdraft")
    public ResponseEntity<OrmRankDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormrankMapping.toDto(ormrankService.getDraft(new OrmRank())));
    }

    @PreAuthorize("hasPermission(this.ormrankMapping.toDomain(#ormrankdto),'ehr-OrmRank-Create')")
    @ApiOperation(value = "新建职级管理", tags = {"职级管理" },  notes = "新建职级管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks")
    @Transactional
    public ResponseEntity<OrmRankDTO> create(@RequestBody OrmRankDTO ormrankdto) {
        OrmRank domain = ormrankMapping.toDomain(ormrankdto);
		ormrankService.create(domain);
        OrmRankDTO dto = ormrankMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormrankMapping.toDomain(#ormrankdtos),'ehr-OrmRank-Create')")
    @ApiOperation(value = "批量新建职级管理", tags = {"职级管理" },  notes = "批量新建职级管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmRankDTO> ormrankdtos) {
        ormrankService.createBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JZRANK-all')")
	@ApiOperation(value = "获取JZRANK", tags = {"职级管理" } ,notes = "获取JZRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjzrank")
	public ResponseEntity<List<OrmRankDTO>> fetchJZRANK(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJZRANK(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JZRANK-all')")
	@ApiOperation(value = "查询JZRANK", tags = {"职级管理" } ,notes = "查询JZRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjzrank")
	public ResponseEntity<Page<OrmRankDTO>> searchJZRANK(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJZRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JSRANK-all')")
	@ApiOperation(value = "获取JSRANK", tags = {"职级管理" } ,notes = "获取JSRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjsrank")
	public ResponseEntity<List<OrmRankDTO>> fetchJSRANK(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJSRANK(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JSRANK-all')")
	@ApiOperation(value = "查询JSRANK", tags = {"职级管理" } ,notes = "查询JSRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjsrank")
	public ResponseEntity<Page<OrmRankDTO>> searchJSRANK(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJSRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-DJYX-all')")
	@ApiOperation(value = "获取D级以下", tags = {"职级管理" } ,notes = "获取D级以下")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchdjyx")
	public ResponseEntity<List<OrmRankDTO>> fetchDJYX(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchDJYX(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-DJYX-all')")
	@ApiOperation(value = "查询D级以下", tags = {"职级管理" } ,notes = "查询D级以下")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchdjyx")
	public ResponseEntity<Page<OrmRankDTO>> searchDJYX(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchDJYX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JSNRANK-all')")
	@ApiOperation(value = "获取JSNRANK", tags = {"职级管理" } ,notes = "获取JSNRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjsnrank")
	public ResponseEntity<List<OrmRankDTO>> fetchJSNRANK(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJSNRANK(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-JSNRANK-all')")
	@ApiOperation(value = "查询JSNRANK", tags = {"职级管理" } ,notes = "查询JSNRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjsnrank")
	public ResponseEntity<Page<OrmRankDTO>> searchJSNRANK(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchJSNRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职级管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchdefault")
	public ResponseEntity<List<OrmRankDTO>> fetchDefault(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchDefault(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职级管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchdefault")
	public ResponseEntity<Page<OrmRankDTO>> searchDefault(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-CurRank-all')")
	@ApiOperation(value = "获取根据登录人身份判定职级显示", tags = {"职级管理" } ,notes = "获取根据登录人身份判定职级显示")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchcurrank")
	public ResponseEntity<List<OrmRankDTO>> fetchCurRank(OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchCurRank(context) ;
        List<OrmRankDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmRank-CurRank-all')")
	@ApiOperation(value = "查询根据登录人身份判定职级显示", tags = {"职级管理" } ,notes = "查询根据登录人身份判定职级显示")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchcurrank")
	public ResponseEntity<Page<OrmRankDTO>> searchCurRank(@RequestBody OrmRankSearchContext context) {
        Page<OrmRank> domains = ormrankService.searchCurRank(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

