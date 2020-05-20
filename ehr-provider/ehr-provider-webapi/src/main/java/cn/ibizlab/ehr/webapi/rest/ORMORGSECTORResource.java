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
import cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR;
import cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSECTORSearchContext;




@Slf4j
@Api(tags = {"ORMORGSECTOR" })
@RestController("WebApi-ormorgsector")
@RequestMapping("")
public class ORMORGSECTORResource {

    @Autowired
    private IORMORGSECTORService ormorgsectorService;

    @Autowired
    @Lazy
    private ORMORGSECTORMapping ormorgsectorMapping;




    @ApiOperation(value = "设置为生效版本", tags = {"ORMORGSECTOR" },  notes = "设置为生效版本")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/changeedition")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> changeEdition(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.changeEdition(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMORGSECTOR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> create(@RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR domain = ormorgsectorMapping.toDomain(ormorgsectordto);
		ormorgsectorService.create(domain);
        ORMORGSECTORDTO dto = ormorgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMORGSECTOR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMORGSECTORDTO> ormorgsectordtos) {
        ormorgsectorService.createBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "通过项目部选择计算项目信息", tags = {"ORMORGSECTOR" },  notes = "通过项目部选择计算项目信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsectpro")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> synOrgSectPro(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.synOrgSectPro(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }




    @ApiOperation(value = "处理完成", tags = {"ORMORGSECTOR" },  notes = "处理完成")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/clwc")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> cLWC(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.cLWC(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMORGSECTOR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMORGSECTORDTO ormorgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.checkKey(ormorgsectorMapping.toDomain(ormorgsectordto)));
    }




    @ApiOperation(value = "Save", tags = {"ORMORGSECTOR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMORGSECTORDTO ormorgsectordto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.save(ormorgsectorMapping.toDomain(ormorgsectordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMORGSECTOR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMORGSECTORDTO> ormorgsectordtos) {
        ormorgsectorService.saveBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMORGSECTOR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/getdraft")
    public ResponseEntity<ORMORGSECTORDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorMapping.toDto(ormorgsectorService.getDraft(new ORMORGSECTOR())));
    }




    @ApiOperation(value = "提交需求计划", tags = {"ORMORGSECTOR" },  notes = "提交需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/tj")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> tJ(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.tJ(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }




    @PreAuthorize("hasPermission(#ormorgsector_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMORGSECTOR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> update(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
		ORMORGSECTOR domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgsectorid(ormorgsector_id);
		ormorgsectorService.update(domain);
		ORMORGSECTORDTO dto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormorgsector_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMORGSECTOR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMORGSECTORDTO> ormorgsectordtos) {
        ormorgsectorService.updateBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormorgsector_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMORGSECTOR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}")
    public ResponseEntity<ORMORGSECTORDTO> get(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMORGSECTOR domain = ormorgsectorService.get(ormorgsector_id);
        ORMORGSECTORDTO dto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "根据当前所选组织默认计算当前部门的排序", tags = {"ORMORGSECTOR" },  notes = "根据当前所选组织默认计算当前部门的排序")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsectodernum")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> synOrgSectOderNum(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.synOrgSectOderNum(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }




    @PreAuthorize("hasPermission(#ormorgsector_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMORGSECTOR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorgsector_id") String ormorgsector_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.remove(ormorgsector_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMORGSECTOR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "计算当前部门默认所属区域", tags = {"ORMORGSECTOR" },  notes = "计算当前部门默认所属区域")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsec")
    @Transactional
    public ResponseEntity<ORMORGSECTORDTO> synOrgSec(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMORGSECTORDTO ormorgsectordto) {
        ORMORGSECTOR ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector = ormorgsectorService.synOrgSec(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CURORMORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门(ORMORGID)", tags = {"ORMORGSECTOR" } ,notes = "fetch通过当前组织过滤部门(ORMORGID)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurormorg")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchCURORMORG(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCURORMORG(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CURORMORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门(ORMORGID)", tags = {"ORMORGSECTOR" } ,notes = "search通过当前组织过滤部门(ORMORGID)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurormorg")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchCURORMORG(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCURORMORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-XMBBZGL-all')")
	@ApiOperation(value = "fetch项目部编制管理", tags = {"ORMORGSECTOR" } ,notes = "fetch项目部编制管理")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchxmbbzgl")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchXMBBZGL(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchXMBBZGL(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-XMBBZGL-all')")
	@ApiOperation(value = "search项目部编制管理", tags = {"ORMORGSECTOR" } ,notes = "search项目部编制管理")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchxmbbzgl")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchXMBBZGL(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchXMBBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-JSYXMB-all')")
	@ApiOperation(value = "fetch局所有项目部选择（第一版规则）", tags = {"ORMORGSECTOR" } ,notes = "fetch局所有项目部选择（第一版规则）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchjsyxmb")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchJSYXMB(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchJSYXMB(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-JSYXMB-all')")
	@ApiOperation(value = "search局所有项目部选择（第一版规则）", tags = {"ORMORGSECTOR" } ,notes = "search局所有项目部选择（第一版规则）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchjsyxmb")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchJSYXMB(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchJSYXMB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurZZBM-all')")
	@ApiOperation(value = "fetch当前组织下的部门", tags = {"ORMORGSECTOR" } ,notes = "fetch当前组织下的部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurzzbm")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchCurZZBM(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurZZBM(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurZZBM-all')")
	@ApiOperation(value = "search当前组织下的部门", tags = {"ORMORGSECTOR" } ,notes = "search当前组织下的部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurzzbm")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchCurZZBM(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "fetch当前组织部门（考勤设置）", tags = {"ORMORGSECTOR" } ,notes = "fetch当前组织部门（考勤设置）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurzzbm_kqsz")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchCurZZBM_KQSZ(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "search当前组织部门（考勤设置）", tags = {"ORMORGSECTOR" } ,notes = "search当前组织部门（考勤设置）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurzzbm_kqsz")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchCurZZBM_KQSZ(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CURORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门", tags = {"ORMORGSECTOR" } ,notes = "fetch通过当前组织过滤部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurorg")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchCURORG(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCURORG(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CURORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门", tags = {"ORMORGSECTOR" } ,notes = "search通过当前组织过滤部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurorg")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchCURORG(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCURORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurOrgSector-all')")
	@ApiOperation(value = "fetch当前部门", tags = {"ORMORGSECTOR" } ,notes = "fetch当前部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurorgsector")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchCurOrgSector(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurOrgSector(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-CurOrgSector-all')")
	@ApiOperation(value = "search当前部门", tags = {"ORMORGSECTOR" } ,notes = "search当前部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurorgsector")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchCurOrgSector(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchCurOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMORGSECTOR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchdefault")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchDefault(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchDefault(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMORGSECTOR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchdefault")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchDefault(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-BaseInfo-all')")
	@ApiOperation(value = "fetch项目人员需求", tags = {"ORMORGSECTOR" } ,notes = "fetch项目人员需求")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchbaseinfo")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchBaseInfo(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchBaseInfo(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-BaseInfo-all')")
	@ApiOperation(value = "search项目人员需求", tags = {"ORMORGSECTOR" } ,notes = "search项目人员需求")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchbaseinfo")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchBaseInfo(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchBaseInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-DQZZXBM-all')")
	@ApiOperation(value = "fetch当前组织（及下级组织）下部门", tags = {"ORMORGSECTOR" } ,notes = "fetch当前组织（及下级组织）下部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchdqzzxbm")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchDQZZXBM(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchDQZZXBM(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-DQZZXBM-all')")
	@ApiOperation(value = "search当前组织（及下级组织）下部门", tags = {"ORMORGSECTOR" } ,notes = "search当前组织（及下级组织）下部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchdqzzxbm")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchDQZZXBM(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchDQZZXBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-RsshInfo-all')")
	@ApiOperation(value = "fetch设置项目负责人", tags = {"ORMORGSECTOR" } ,notes = "fetch设置项目负责人")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchrsshinfo")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchRsshInfo(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchRsshInfo(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-RsshInfo-all')")
	@ApiOperation(value = "search设置项目负责人", tags = {"ORMORGSECTOR" } ,notes = "search设置项目负责人")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchrsshinfo")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchRsshInfo(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchRsshInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-SubOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（组织专用）", tags = {"ORMORGSECTOR" } ,notes = "fetch子组织部门/项目部（组织专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchsuborgsector")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchSubOrgsector(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchSubOrgsector(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-SubOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（组织专用）", tags = {"ORMORGSECTOR" } ,notes = "search子组织部门/项目部（组织专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchsuborgsector")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchSubOrgsector(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchSubOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（人员信息专用）", tags = {"ORMORGSECTOR" } ,notes = "fetch子组织部门/项目部（人员信息专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchpimpersoninfoorgsector")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchPimpersonInfoOrgsector(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（人员信息专用）", tags = {"ORMORGSECTOR" } ,notes = "search子组织部门/项目部（人员信息专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchpimpersoninfoorgsector")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchPimpersonInfoOrgsector(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-HisInfo-all')")
	@ApiOperation(value = "fetch项目人员需求（历史版本）", tags = {"ORMORGSECTOR" } ,notes = "fetch项目人员需求（历史版本）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchhisinfo")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchHisInfo(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchHisInfo(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-HisInfo-all')")
	@ApiOperation(value = "search项目人员需求（历史版本）", tags = {"ORMORGSECTOR" } ,notes = "search项目人员需求（历史版本）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchhisinfo")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchHisInfo(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchHisInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-SubZZBM-all')")
	@ApiOperation(value = "fetch子组织部门", tags = {"ORMORGSECTOR" } ,notes = "fetch子组织部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchsubzzbm")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchSubZZBM(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchSubZZBM(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-SubZZBM-all')")
	@ApiOperation(value = "search子组织部门", tags = {"ORMORGSECTOR" } ,notes = "search子组织部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchsubzzbm")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchSubZZBM(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchSubZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-ProExpandInfo-all')")
	@ApiOperation(value = "fetch项目拓展信息", tags = {"ORMORGSECTOR" } ,notes = "fetch项目拓展信息")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchproexpandinfo")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchProExpandInfo(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchProExpandInfo(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-ProExpandInfo-all')")
	@ApiOperation(value = "search项目拓展信息", tags = {"ORMORGSECTOR" } ,notes = "search项目拓展信息")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchproexpandinfo")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchProExpandInfo(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchProExpandInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-BMBZGL-all')")
	@ApiOperation(value = "fetch部门编制管理", tags = {"ORMORGSECTOR" } ,notes = "fetch部门编制管理")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchbmbzgl")
	public ResponseEntity<List<ORMORGSECTORDTO>> fetchBMBZGL(ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchBMBZGL(context) ;
        List<ORMORGSECTORDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGSECTOR-BMBZGL-all')")
	@ApiOperation(value = "search部门编制管理", tags = {"ORMORGSECTOR" } ,notes = "search部门编制管理")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchbmbzgl")
	public ResponseEntity<Page<ORMORGSECTORDTO>> searchBMBZGL(@RequestBody ORMORGSECTORSearchContext context) {
        Page<ORMORGSECTOR> domains = ormorgsectorService.searchBMBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMORGSECTOR getEntity(){
        return new ORMORGSECTOR();
    }

}
