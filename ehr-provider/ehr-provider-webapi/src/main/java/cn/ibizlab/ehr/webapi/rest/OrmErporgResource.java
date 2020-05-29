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
import cn.ibizlab.ehr.core.orm.domain.OrmErporg;
import cn.ibizlab.ehr.core.orm.service.IOrmErporgService;
import cn.ibizlab.ehr.core.orm.filter.OrmErporgSearchContext;

@Slf4j
@Api(tags = {"OrmErporg" })
@RestController("WebApi-ormerporg")
@RequestMapping("")
public class OrmErporgResource {

    @Autowired
    public IOrmErporgService ormerporgService;

    @Autowired
    @Lazy
    public OrmErporgMapping ormerporgMapping;

    @PostAuthorize("hasPermission(this.ormerporgMapping.toDomain(returnObject.body),'ehr-OrmErporg-Get')")
    @ApiOperation(value = "Get", tags = {"OrmErporg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormerporgs/{ormerporg_id}")
    public ResponseEntity<OrmErporgDTO> get(@PathVariable("ormerporg_id") String ormerporg_id) {
        OrmErporg domain = ormerporgService.get(ormerporg_id);
        OrmErporgDTO dto = ormerporgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormerporgService.get(#ormerporg_id),'ehr-OrmErporg-Update')")
    @ApiOperation(value = "Update", tags = {"OrmErporg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormerporgs/{ormerporg_id}")
    @Transactional
    public ResponseEntity<OrmErporgDTO> update(@PathVariable("ormerporg_id") String ormerporg_id, @RequestBody OrmErporgDTO ormerporgdto) {
		OrmErporg domain  = ormerporgMapping.toDomain(ormerporgdto);
        domain .setOrmerporgid(ormerporg_id);
		ormerporgService.update(domain );
		OrmErporgDTO dto = ormerporgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormerporgService.getOrmerporgByEntities(this.ormerporgMapping.toDomain(#ormerporgdtos)),'ehr-OrmErporg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmErporg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmErporgDTO> ormerporgdtos) {
        ormerporgService.updateBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormerporgService.get(#ormerporg_id),'ehr-OrmErporg-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmErporg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormerporgs/{ormerporg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormerporg_id") String ormerporg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormerporgService.remove(ormerporg_id));
    }

    @PreAuthorize("hasPermission(this.ormerporgService.getOrmerporgByIds(#ids),'ehr-OrmErporg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmErporg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormerporgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-SynOrg-all')")
    @ApiOperation(value = "同步ERP组织信息", tags = {"OrmErporg" },  notes = "同步ERP组织信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/{ormerporg_id}/synorg")
    @Transactional
    public ResponseEntity<OrmErporgDTO> synOrg(@PathVariable("ormerporg_id") String ormerporg_id, @RequestBody OrmErporgDTO ormerporgdto) {
        OrmErporg ormerporg = ormerporgMapping.toDomain(ormerporgdto);
        ormerporg.setOrmerporgid(ormerporg_id);
        ormerporg = ormerporgService.synOrg(ormerporg);
        ormerporgdto = ormerporgMapping.toDto(ormerporg);
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmErporg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormerporgs/getdraft")
    public ResponseEntity<OrmErporgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgMapping.toDto(ormerporgService.getDraft(new OrmErporg())));
    }

    @PreAuthorize("hasPermission(this.ormerporgMapping.toDomain(#ormerporgdto),'ehr-OrmErporg-Save')")
    @ApiOperation(value = "Save", tags = {"OrmErporg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmErporgDTO ormerporgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgService.save(ormerporgMapping.toDomain(ormerporgdto)));
    }

    @PreAuthorize("hasPermission(this.ormerporgMapping.toDomain(#ormerporgdtos),'ehr-OrmErporg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmErporg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmErporgDTO> ormerporgdtos) {
        ormerporgService.saveBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormerporgMapping.toDomain(#ormerporgdto),'ehr-OrmErporg-Create')")
    @ApiOperation(value = "Create", tags = {"OrmErporg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs")
    @Transactional
    public ResponseEntity<OrmErporgDTO> create(@RequestBody OrmErporgDTO ormerporgdto) {
        OrmErporg domain = ormerporgMapping.toDomain(ormerporgdto);
		ormerporgService.create(domain);
        OrmErporgDTO dto = ormerporgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormerporgMapping.toDomain(#ormerporgdtos),'ehr-OrmErporg-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmErporg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmErporgDTO> ormerporgdtos) {
        ormerporgService.createBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmErporg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmErporgDTO ormerporgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormerporgService.checkKey(ormerporgMapping.toDomain(ormerporgdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CXBM-all')")
	@ApiOperation(value = "fetch查询可用ERP部门", tags = {"OrmErporg" } ,notes = "fetch查询可用ERP部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcxbm")
	public ResponseEntity<List<OrmErporgDTO>> fetchCXBM(OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCXBM(context) ;
        List<OrmErporgDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CXBM-all')")
	@ApiOperation(value = "search查询可用ERP部门", tags = {"OrmErporg" } ,notes = "search查询可用ERP部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcxbm")
	public ResponseEntity<Page<OrmErporgDTO>> searchCXBM(@RequestBody OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCXBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-LegalChoice-all')")
	@ApiOperation(value = "fetch管理单位选择", tags = {"OrmErporg" } ,notes = "fetch管理单位选择")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchlegalchoice")
	public ResponseEntity<List<OrmErporgDTO>> fetchLegalChoice(OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchLegalChoice(context) ;
        List<OrmErporgDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-LegalChoice-all')")
	@ApiOperation(value = "search管理单位选择", tags = {"OrmErporg" } ,notes = "search管理单位选择")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchlegalchoice")
	public ResponseEntity<Page<OrmErporgDTO>> searchLegalChoice(@RequestBody OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchLegalChoice(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmErporg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchdefault")
	public ResponseEntity<List<OrmErporgDTO>> fetchDefault(OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchDefault(context) ;
        List<OrmErporgDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmErporg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchdefault")
	public ResponseEntity<Page<OrmErporgDTO>> searchDefault(@RequestBody OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CX-all')")
	@ApiOperation(value = "fetch查询可用ERP组织", tags = {"OrmErporg" } ,notes = "fetch查询可用ERP组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcx")
	public ResponseEntity<List<OrmErporgDTO>> fetchCX(OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCX(context) ;
        List<OrmErporgDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CX-all')")
	@ApiOperation(value = "search查询可用ERP组织", tags = {"OrmErporg" } ,notes = "search查询可用ERP组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcx")
	public ResponseEntity<Page<OrmErporgDTO>> searchCX(@RequestBody OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CXZBM-all')")
	@ApiOperation(value = "fetch查询可用ERP部门", tags = {"OrmErporg" } ,notes = "fetch查询可用ERP部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcxzbm")
	public ResponseEntity<List<OrmErporgDTO>> fetchCXZBM(OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCXZBM(context) ;
        List<OrmErporgDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmErporg-CXZBM-all')")
	@ApiOperation(value = "search查询可用ERP部门", tags = {"OrmErporg" } ,notes = "search查询可用ERP部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcxzbm")
	public ResponseEntity<Page<OrmErporgDTO>> searchCXZBM(@RequestBody OrmErporgSearchContext context) {
        Page<OrmErporg> domains = ormerporgService.searchCXZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

