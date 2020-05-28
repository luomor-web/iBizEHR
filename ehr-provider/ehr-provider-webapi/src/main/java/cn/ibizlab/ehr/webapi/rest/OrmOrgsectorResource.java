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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgsectorSearchContext;

@Slf4j
@Api(tags = {"OrmOrgsector" })
@RestController("WebApi-ormorgsector")
@RequestMapping("")
public class OrmOrgsectorResource {

    @Autowired
    public IOrmOrgsectorService ormorgsectorService;

    @Autowired
    @Lazy
    public OrmOrgsectorMapping ormorgsectorMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ChangeEdition-all')")
    @ApiOperation(value = "设置为生效版本", tags = {"OrmOrgsector" },  notes = "设置为生效版本")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/changeedition")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> changeEdition(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.changeEdition(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordto),'ehr-OrmOrgsector-Create')")
    @ApiOperation(value = "Create", tags = {"OrmOrgsector" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> create(@RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
		ormorgsectorService.create(domain);
        OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordtos),'ehr-OrmOrgsector-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmOrgsector" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        ormorgsectorService.createBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSectPro-all')")
    @ApiOperation(value = "通过项目部选择计算项目信息", tags = {"OrmOrgsector" },  notes = "通过项目部选择计算项目信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsectpro")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSectPro(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.synOrgSectPro(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CLWC-all')")
    @ApiOperation(value = "处理完成", tags = {"OrmOrgsector" },  notes = "处理完成")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/clwc")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> cLWC(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.cLWC(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmOrgsector" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmOrgsectorDTO ormorgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.checkKey(ormorgsectorMapping.toDomain(ormorgsectordto)));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordto),'ehr-OrmOrgsector-Save')")
    @ApiOperation(value = "Save", tags = {"OrmOrgsector" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmOrgsectorDTO ormorgsectordto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.save(ormorgsectorMapping.toDomain(ormorgsectordto)));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordtos),'ehr-OrmOrgsector-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmOrgsector" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        ormorgsectorService.saveBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmOrgsector" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/getdraft")
    public ResponseEntity<OrmOrgsectorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorMapping.toDto(ormorgsectorService.getDraft(new OrmOrgsector())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-TJ-all')")
    @ApiOperation(value = "提交需求计划", tags = {"OrmOrgsector" },  notes = "提交需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/tj")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> tJ(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.tJ(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.get(#ormorgsector_id),'ehr-OrmOrgsector-Update')")
    @ApiOperation(value = "Update", tags = {"OrmOrgsector" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> update(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
		OrmOrgsector domain  = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain .setOrgsectorid(ormorgsector_id);
		ormorgsectorService.update(domain );
		OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.getOrmorgsectorByEntities(this.ormorgsectorMapping.toDomain(#ormorgsectordtos)),'ehr-OrmOrgsector-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmOrgsector" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        ormorgsectorService.updateBatch(ormorgsectorMapping.toDomain(ormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(returnObject.body),'ehr-OrmOrgsector-Get')")
    @ApiOperation(value = "Get", tags = {"OrmOrgsector" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}")
    public ResponseEntity<OrmOrgsectorDTO> get(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmOrgsector domain = ormorgsectorService.get(ormorgsector_id);
        OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSectOderNum-all')")
    @ApiOperation(value = "根据当前所选组织默认计算当前部门的排序", tags = {"OrmOrgsector" },  notes = "根据当前所选组织默认计算当前部门的排序")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsectodernum")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSectOderNum(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.synOrgSectOderNum(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.get(#ormorgsector_id),'ehr-OrmOrgsector-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmOrgsector" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorgsector_id") String ormorgsector_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.remove(ormorgsector_id));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.getOrmorgsectorByIds(#ids),'ehr-OrmOrgsector-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmOrgsector" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSec-all')")
    @ApiOperation(value = "计算当前部门默认所属区域", tags = {"OrmOrgsector" },  notes = "计算当前部门默认所属区域")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/synorgsec")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSec(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector ormorgsector = ormorgsectorMapping.toDomain(ormorgsectordto);
        ormorgsector.setOrgsectorid(ormorgsector_id);
        ormorgsector = ormorgsectorService.synOrgSec(ormorgsector);
        ormorgsectordto = ormorgsectorMapping.toDto(ormorgsector);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORMORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门(ORMORGID)", tags = {"OrmOrgsector" } ,notes = "fetch通过当前组织过滤部门(ORMORGID)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurormorg")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchCURORMORG(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORMORG(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORMORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门(ORMORGID)", tags = {"OrmOrgsector" } ,notes = "search通过当前组织过滤部门(ORMORGID)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurormorg")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchCURORMORG(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORMORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-XMBBZGL-all')")
	@ApiOperation(value = "fetch项目部编制管理", tags = {"OrmOrgsector" } ,notes = "fetch项目部编制管理")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchxmbbzgl")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchXMBBZGL(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchXMBBZGL(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-XMBBZGL-all')")
	@ApiOperation(value = "search项目部编制管理", tags = {"OrmOrgsector" } ,notes = "search项目部编制管理")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchxmbbzgl")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchXMBBZGL(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchXMBBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-JSYXMB-all')")
	@ApiOperation(value = "fetch局所有项目部选择（第一版规则）", tags = {"OrmOrgsector" } ,notes = "fetch局所有项目部选择（第一版规则）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchjsyxmb")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchJSYXMB(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchJSYXMB(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-JSYXMB-all')")
	@ApiOperation(value = "search局所有项目部选择（第一版规则）", tags = {"OrmOrgsector" } ,notes = "search局所有项目部选择（第一版规则）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchjsyxmb")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchJSYXMB(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchJSYXMB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM-all')")
	@ApiOperation(value = "fetch当前组织下的部门", tags = {"OrmOrgsector" } ,notes = "fetch当前组织下的部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurzzbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchCurZZBM(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM-all')")
	@ApiOperation(value = "search当前组织下的部门", tags = {"OrmOrgsector" } ,notes = "search当前组织下的部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurzzbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchCurZZBM(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "fetch当前组织部门（考勤设置）", tags = {"OrmOrgsector" } ,notes = "fetch当前组织部门（考勤设置）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurzzbm_kqsz")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchCurZZBM_KQSZ(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "search当前组织部门（考勤设置）", tags = {"OrmOrgsector" } ,notes = "search当前组织部门（考勤设置）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurzzbm_kqsz")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchCurZZBM_KQSZ(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门", tags = {"OrmOrgsector" } ,notes = "fetch通过当前组织过滤部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurorg")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchCURORG(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORG(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门", tags = {"OrmOrgsector" } ,notes = "search通过当前组织过滤部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurorg")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchCURORG(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurOrgSector-all')")
	@ApiOperation(value = "fetch当前部门", tags = {"OrmOrgsector" } ,notes = "fetch当前部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchcurorgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchCurOrgSector(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurOrgSector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurOrgSector-all')")
	@ApiOperation(value = "search当前部门", tags = {"OrmOrgsector" } ,notes = "search当前部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchcurorgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchCurOrgSector(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmOrgsector" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchdefault")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchDefault(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchDefault(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmOrgsector" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchdefault")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchDefault(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BaseInfo-all')")
	@ApiOperation(value = "fetch项目人员需求", tags = {"OrmOrgsector" } ,notes = "fetch项目人员需求")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchbaseinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchBaseInfo(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchBaseInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BaseInfo-all')")
	@ApiOperation(value = "search项目人员需求", tags = {"OrmOrgsector" } ,notes = "search项目人员需求")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchbaseinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchBaseInfo(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchBaseInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-DQZZXBM-all')")
	@ApiOperation(value = "fetch当前组织（及下级组织）下部门", tags = {"OrmOrgsector" } ,notes = "fetch当前组织（及下级组织）下部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchdqzzxbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchDQZZXBM(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchDQZZXBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-DQZZXBM-all')")
	@ApiOperation(value = "search当前组织（及下级组织）下部门", tags = {"OrmOrgsector" } ,notes = "search当前组织（及下级组织）下部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchdqzzxbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchDQZZXBM(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchDQZZXBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-RsshInfo-all')")
	@ApiOperation(value = "fetch设置项目负责人", tags = {"OrmOrgsector" } ,notes = "fetch设置项目负责人")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchrsshinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchRsshInfo(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchRsshInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-RsshInfo-all')")
	@ApiOperation(value = "search设置项目负责人", tags = {"OrmOrgsector" } ,notes = "search设置项目负责人")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchrsshinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchRsshInfo(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchRsshInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（组织专用）", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门/项目部（组织专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchsuborgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchSubOrgsector(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubOrgsector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（组织专用）", tags = {"OrmOrgsector" } ,notes = "search子组织部门/项目部（组织专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchsuborgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchSubOrgsector(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（人员信息专用）", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门/项目部（人员信息专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchpimpersoninfoorgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchPimpersonInfoOrgsector(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（人员信息专用）", tags = {"OrmOrgsector" } ,notes = "search子组织部门/项目部（人员信息专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchpimpersoninfoorgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchPimpersonInfoOrgsector(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-HisInfo-all')")
	@ApiOperation(value = "fetch项目人员需求（历史版本）", tags = {"OrmOrgsector" } ,notes = "fetch项目人员需求（历史版本）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchhisinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchHisInfo(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchHisInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-HisInfo-all')")
	@ApiOperation(value = "search项目人员需求（历史版本）", tags = {"OrmOrgsector" } ,notes = "search项目人员需求（历史版本）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchhisinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchHisInfo(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchHisInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubZZBM-all')")
	@ApiOperation(value = "fetch子组织部门", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchsubzzbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchSubZZBM(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubZZBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubZZBM-all')")
	@ApiOperation(value = "search子组织部门", tags = {"OrmOrgsector" } ,notes = "search子组织部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchsubzzbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchSubZZBM(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ProExpandInfo-all')")
	@ApiOperation(value = "fetch项目拓展信息", tags = {"OrmOrgsector" } ,notes = "fetch项目拓展信息")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchproexpandinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchProExpandInfo(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchProExpandInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ProExpandInfo-all')")
	@ApiOperation(value = "search项目拓展信息", tags = {"OrmOrgsector" } ,notes = "search项目拓展信息")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchproexpandinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchProExpandInfo(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchProExpandInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BMBZGL-all')")
	@ApiOperation(value = "fetch部门编制管理", tags = {"OrmOrgsector" } ,notes = "fetch部门编制管理")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/fetchbmbzgl")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchBMBZGL(OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchBMBZGL(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BMBZGL-all')")
	@ApiOperation(value = "search部门编制管理", tags = {"OrmOrgsector" } ,notes = "search部门编制管理")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/searchbmbzgl")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchBMBZGL(@RequestBody OrmOrgsectorSearchContext context) {
        Page<OrmOrgsector> domains = ormorgsectorService.searchBMBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ChangeEdition-all')")
    @ApiOperation(value = "设置为生效版本ByOrmOrg", tags = {"OrmOrgsector" },  notes = "设置为生效版本ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/changeedition")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> changeEditionByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.changeEdition(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordto),'ehr-OrmOrgsector-Create')")
    @ApiOperation(value = "CreateByOrmOrg", tags = {"OrmOrgsector" },  notes = "CreateByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
		ormorgsectorService.create(domain);
        OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordtos),'ehr-OrmOrgsector-Create')")
    @ApiOperation(value = "createBatchByOrmOrg", tags = {"OrmOrgsector" },  notes = "createBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        List<OrmOrgsector> domainlist=ormorgsectorMapping.toDomain(ormorgsectordtos);
        for(OrmOrgsector domain:domainlist){
            domain.setOrgid(ormorg_id);
        }
        ormorgsectorService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSectPro-all')")
    @ApiOperation(value = "通过项目部选择计算项目信息ByOrmOrg", tags = {"OrmOrgsector" },  notes = "通过项目部选择计算项目信息ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/synorgsectpro")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSectProByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.synOrgSectPro(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CLWC-all')")
    @ApiOperation(value = "处理完成ByOrmOrg", tags = {"OrmOrgsector" },  notes = "处理完成ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/clwc")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> cLWCByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.cLWC(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @ApiOperation(value = "CheckKeyByOrmOrg", tags = {"OrmOrgsector" },  notes = "CheckKeyByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.checkKey(ormorgsectorMapping.toDomain(ormorgsectordto)));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordto),'ehr-OrmOrgsector-Save')")
    @ApiOperation(value = "SaveByOrmOrg", tags = {"OrmOrgsector" },  notes = "SaveByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(#ormorgsectordtos),'ehr-OrmOrgsector-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrg", tags = {"OrmOrgsector" },  notes = "SaveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        List<OrmOrgsector> domainlist=ormorgsectorMapping.toDomain(ormorgsectordtos);
        for(OrmOrgsector domain:domainlist){
             domain.setOrgid(ormorg_id);
        }
        ormorgsectorService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrg", tags = {"OrmOrgsector" },  notes = "GetDraftByOrmOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/getdraft")
    public ResponseEntity<OrmOrgsectorDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        OrmOrgsector domain = new OrmOrgsector();
        domain.setOrgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorMapping.toDto(ormorgsectorService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-TJ-all')")
    @ApiOperation(value = "提交需求计划ByOrmOrg", tags = {"OrmOrgsector" },  notes = "提交需求计划ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/tj")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> tJByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.tJ(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.get(#ormorgsector_id),'ehr-OrmOrgsector-Update')")
    @ApiOperation(value = "UpdateByOrmOrg", tags = {"OrmOrgsector" },  notes = "UpdateByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain.setOrgsectorid(ormorgsector_id);
		ormorgsectorService.update(domain);
        OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.getOrmorgsectorByEntities(this.ormorgsectorMapping.toDomain(#ormorgsectordtos)),'ehr-OrmOrgsector-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrg", tags = {"OrmOrgsector" },  notes = "UpdateBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgsectorDTO> ormorgsectordtos) {
        List<OrmOrgsector> domainlist=ormorgsectorMapping.toDomain(ormorgsectordtos);
        for(OrmOrgsector domain:domainlist){
            domain.setOrgid(ormorg_id);
        }
        ormorgsectorService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormorgsectorMapping.toDomain(returnObject.body),'ehr-OrmOrgsector-Get')")
    @ApiOperation(value = "GetByOrmOrg", tags = {"OrmOrgsector" },  notes = "GetByOrmOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}")
    public ResponseEntity<OrmOrgsectorDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmOrgsector domain = ormorgsectorService.get(ormorgsector_id);
        OrmOrgsectorDTO dto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSectOderNum-all')")
    @ApiOperation(value = "根据当前所选组织默认计算当前部门的排序ByOrmOrg", tags = {"OrmOrgsector" },  notes = "根据当前所选组织默认计算当前部门的排序ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/synorgsectodernum")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSectOderNumByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.synOrgSectOderNum(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.get(#ormorgsector_id),'ehr-OrmOrgsector-Remove')")
    @ApiOperation(value = "RemoveByOrmOrg", tags = {"OrmOrgsector" },  notes = "RemoveByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormorgsectorService.remove(ormorgsector_id));
    }

    @PreAuthorize("hasPermission(this.ormorgsectorService.getOrmorgsectorByIds(#ids),'ehr-OrmOrgsector-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrg", tags = {"OrmOrgsector" },  notes = "RemoveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormorgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SynOrgSec-all')")
    @ApiOperation(value = "计算当前部门默认所属区域ByOrmOrg", tags = {"OrmOrgsector" },  notes = "计算当前部门默认所属区域ByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/synorgsec")
    @Transactional
    public ResponseEntity<OrmOrgsectorDTO> synOrgSecByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmOrgsectorDTO ormorgsectordto) {
        OrmOrgsector domain = ormorgsectorMapping.toDomain(ormorgsectordto);
        domain.setOrgid(ormorg_id);
        domain = ormorgsectorService.synOrgSec(domain) ;
        ormorgsectordto = ormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgsectordto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORMORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门(ORMORGID)ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch通过当前组织过滤部门(ORMORGID)ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchcurormorg")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorCURORMORGByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORMORG(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORMORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门(ORMORGID)ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search通过当前组织过滤部门(ORMORGID)ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchcurormorg")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorCURORMORGByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORMORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-XMBBZGL-all')")
	@ApiOperation(value = "fetch项目部编制管理ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch项目部编制管理ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchxmbbzgl")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorXMBBZGLByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchXMBBZGL(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-XMBBZGL-all')")
	@ApiOperation(value = "search项目部编制管理ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search项目部编制管理ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchxmbbzgl")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorXMBBZGLByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchXMBBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-JSYXMB-all')")
	@ApiOperation(value = "fetch局所有项目部选择（第一版规则）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch局所有项目部选择（第一版规则）ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchjsyxmb")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorJSYXMBByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchJSYXMB(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-JSYXMB-all')")
	@ApiOperation(value = "search局所有项目部选择（第一版规则）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search局所有项目部选择（第一版规则）ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchjsyxmb")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorJSYXMBByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchJSYXMB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM-all')")
	@ApiOperation(value = "fetch当前组织下的部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch当前组织下的部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchcurzzbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorCurZZBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM-all')")
	@ApiOperation(value = "search当前组织下的部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search当前组织下的部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchcurzzbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorCurZZBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "fetch当前组织部门（考勤设置）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch当前组织部门（考勤设置）ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchcurzzbm_kqsz")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorCurZZBM_KQSZByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurZZBM_KQSZ-all')")
	@ApiOperation(value = "search当前组织部门（考勤设置）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search当前组织部门（考勤设置）ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchcurzzbm_kqsz")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorCurZZBM_KQSZByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurZZBM_KQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORG-all')")
	@ApiOperation(value = "fetch通过当前组织过滤部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch通过当前组织过滤部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchcurorg")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorCURORGByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORG(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CURORG-all')")
	@ApiOperation(value = "search通过当前组织过滤部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search通过当前组织过滤部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchcurorg")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorCURORGByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCURORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurOrgSector-all')")
	@ApiOperation(value = "fetch当前部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch当前部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchcurorgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorCurOrgSectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurOrgSector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-CurOrgSector-all')")
	@ApiOperation(value = "search当前部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search当前部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchcurorgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorCurOrgSectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchCurOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchdefault")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchDefault(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrg", tags = {"OrmOrgsector" } ,notes = "searchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchdefault")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BaseInfo-all')")
	@ApiOperation(value = "fetch项目人员需求ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch项目人员需求ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchbaseinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorBaseInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchBaseInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BaseInfo-all')")
	@ApiOperation(value = "search项目人员需求ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search项目人员需求ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchbaseinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorBaseInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchBaseInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-DQZZXBM-all')")
	@ApiOperation(value = "fetch当前组织（及下级组织）下部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch当前组织（及下级组织）下部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchdqzzxbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorDQZZXBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchDQZZXBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-DQZZXBM-all')")
	@ApiOperation(value = "search当前组织（及下级组织）下部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search当前组织（及下级组织）下部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchdqzzxbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorDQZZXBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchDQZZXBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-RsshInfo-all')")
	@ApiOperation(value = "fetch设置项目负责人ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch设置项目负责人ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchrsshinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorRsshInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchRsshInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-RsshInfo-all')")
	@ApiOperation(value = "search设置项目负责人ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search设置项目负责人ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchrsshinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorRsshInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchRsshInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（组织专用）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门/项目部（组织专用）ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchsuborgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorSubOrgsectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubOrgsector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（组织专用）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search子组织部门/项目部（组织专用）ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchsuborgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorSubOrgsectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "fetch子组织部门/项目部（人员信息专用）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门/项目部（人员信息专用）ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchpimpersoninfoorgsector")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorPimpersonInfoOrgsectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-PimpersonInfoOrgsector-all')")
	@ApiOperation(value = "search子组织部门/项目部（人员信息专用）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search子组织部门/项目部（人员信息专用）ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchpimpersoninfoorgsector")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorPimpersonInfoOrgsectorByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchPimpersonInfoOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-HisInfo-all')")
	@ApiOperation(value = "fetch项目人员需求（历史版本）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch项目人员需求（历史版本）ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchhisinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorHisInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchHisInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-HisInfo-all')")
	@ApiOperation(value = "search项目人员需求（历史版本）ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search项目人员需求（历史版本）ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchhisinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorHisInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchHisInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubZZBM-all')")
	@ApiOperation(value = "fetch子组织部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch子组织部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchsubzzbm")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorSubZZBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubZZBM(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-SubZZBM-all')")
	@ApiOperation(value = "search子组织部门ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search子组织部门ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchsubzzbm")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorSubZZBMByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchSubZZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ProExpandInfo-all')")
	@ApiOperation(value = "fetch项目拓展信息ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch项目拓展信息ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchproexpandinfo")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorProExpandInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchProExpandInfo(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-ProExpandInfo-all')")
	@ApiOperation(value = "search项目拓展信息ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search项目拓展信息ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchproexpandinfo")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorProExpandInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchProExpandInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BMBZGL-all')")
	@ApiOperation(value = "fetch部门编制管理ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "fetch部门编制管理ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/fetchbmbzgl")
	public ResponseEntity<List<OrmOrgsectorDTO>> fetchOrmOrgsectorBMBZGLByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchBMBZGL(context) ;
        List<OrmOrgsectorDTO> list = ormorgsectorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgsector-BMBZGL-all')")
	@ApiOperation(value = "search部门编制管理ByOrmOrg", tags = {"OrmOrgsector" } ,notes = "search部门编制管理ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/searchbmbzgl")
	public ResponseEntity<Page<OrmOrgsectorDTO>> searchOrmOrgsectorBMBZGLByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgsectorSearchContext context) {
        context.setN_orgid_eq(ormorg_id);
        Page<OrmOrgsector> domains = ormorgsectorService.searchBMBZGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

