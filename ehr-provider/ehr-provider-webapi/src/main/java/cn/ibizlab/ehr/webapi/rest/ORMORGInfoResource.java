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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.orm.domain.ORMORGInfo;
import cn.ibizlab.ehr.core.orm.service.IORMORGInfoService;
import cn.ibizlab.ehr.core.orm.filter.ORMORGInfoSearchContext;




@Slf4j
@Api(tags = {"ORMORGInfo" })
@RestController("WebApi-ormorginfo")
@RequestMapping("")
public class ORMORGInfoResource {

    @Autowired
    private IORMORGInfoService ormorginfoService;

    @Autowired
    @Lazy
    private ORMORGInfoMapping ormorginfoMapping;




    @ApiOperation(value = "CheckKey", tags = {"ORMORGInfo" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMORGInfoDTO ormorginfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.checkKey(ormorginfoMapping.toDomain(ormorginfodto)));
    }




    @ApiOperation(value = "Save", tags = {"ORMORGInfo" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMORGInfoDTO ormorginfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.save(ormorginfoMapping.toDomain(ormorginfodto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMORGInfo" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMORGInfoDTO> ormorginfodtos) {
        ormorginfoService.saveBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMORGInfo" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorginfos/getdraft")
    public ResponseEntity<ORMORGInfoDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorginfoMapping.toDto(ormorginfoService.getDraft(new ORMORGInfo())));
    }




    @PreAuthorize("hasPermission('Remove',{#ormorginfo_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMORGInfo" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorginfos/{ormorginfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorginfo_id") String ormorginfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.remove(ormorginfo_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMORGInfo" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorginfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormorginfo_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMORGInfo" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorginfos/{ormorginfo_id}")
    public ResponseEntity<ORMORGInfoDTO> get(@PathVariable("ormorginfo_id") String ormorginfo_id) {
        ORMORGInfo domain = ormorginfoService.get(ormorginfo_id);
        ORMORGInfoDTO dto = ormorginfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMORGInfo" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos")
    @Transactional
    public ResponseEntity<ORMORGInfoDTO> create(@RequestBody ORMORGInfoDTO ormorginfodto) {
        ORMORGInfo domain = ormorginfoMapping.toDomain(ormorginfodto);
		ormorginfoService.create(domain);
        ORMORGInfoDTO dto = ormorginfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMORGInfo" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMORGInfoDTO> ormorginfodtos) {
        ormorginfoService.createBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormorginfo_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMORGInfo" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorginfos/{ormorginfo_id}")
    @Transactional
    public ResponseEntity<ORMORGInfoDTO> update(@PathVariable("ormorginfo_id") String ormorginfo_id, @RequestBody ORMORGInfoDTO ormorginfodto) {
		ORMORGInfo domain = ormorginfoMapping.toDomain(ormorginfodto);
        domain.setOrmorginfoid(ormorginfo_id);
		ormorginfoService.update(domain);
		ORMORGInfoDTO dto = ormorginfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormorginfo_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMORGInfo" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMORGInfoDTO> ormorginfodtos) {
        ormorginfoService.updateBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'SubOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch子部门查询", tags = {"ORMORGInfo" } ,notes = "fetch子部门查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsuborgsector")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchSubOrgsector(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSubOrgsector(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'SubOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search子部门查询", tags = {"ORMORGInfo" } ,notes = "search子部门查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchsuborgsector")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchSubOrgsector(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSubOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch自定义查询", tags = {"ORMORGInfo" } ,notes = "fetch自定义查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcx")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchCX(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCX(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search自定义查询", tags = {"ORMORGInfo" } ,notes = "search自定义查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchcx")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchCX(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch部门/项目部查询", tags = {"ORMORGInfo" } ,notes = "fetch部门/项目部查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurorgsector")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchCurOrgsector(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurOrgsector(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search部门/项目部查询", tags = {"ORMORGInfo" } ,notes = "search部门/项目部查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchcurorgsector")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchCurOrgsector(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurChild',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch子组织查询", tags = {"ORMORGInfo" } ,notes = "fetch子组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurchild")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchCurChild(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurChild(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurChild',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search子组织查询", tags = {"ORMORGInfo" } ,notes = "search子组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchcurchild")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchCurChild(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurPorg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根组织查询", tags = {"ORMORGInfo" } ,notes = "fetch根组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurporg")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchCurPorg(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurPorg(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurPorg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根组织查询", tags = {"ORMORGInfo" } ,notes = "search根组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchcurporg")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchCurPorg(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchCurPorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'SubPerson',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前部门/项目部人员清单", tags = {"ORMORGInfo" } ,notes = "fetch当前部门/项目部人员清单")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsubperson")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchSubPerson(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSubPerson(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'SubPerson',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前部门/项目部人员清单", tags = {"ORMORGInfo" } ,notes = "search当前部门/项目部人员清单")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchsubperson")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchSubPerson(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSubPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMORGInfo" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchdefault")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchDefault(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchDefault(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMORGInfo" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchdefault")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchDefault(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Suborg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前组织所包含的直接下级组织查询", tags = {"ORMORGInfo" } ,notes = "fetch当前组织所包含的直接下级组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsuborg")
	public ResponseEntity<List<ORMORGInfoDTO>> fetchSuborg(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSuborg(context) ;
        List<ORMORGInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Suborg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前组织所包含的直接下级组织查询", tags = {"ORMORGInfo" } ,notes = "search当前组织所包含的直接下级组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/searchsuborg")
	public ResponseEntity<Page<ORMORGInfoDTO>> searchSuborg(ORMORGInfoSearchContext context) {
        Page<ORMORGInfo> domains = ormorginfoService.searchSuborg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMORGInfo getEntity(){
        return new ORMORGInfo();
    }

}