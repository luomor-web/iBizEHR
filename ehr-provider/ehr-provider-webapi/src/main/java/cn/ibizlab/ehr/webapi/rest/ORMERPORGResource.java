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
import cn.ibizlab.ehr.core.orm.domain.ORMERPORG;
import cn.ibizlab.ehr.core.orm.service.IORMERPORGService;
import cn.ibizlab.ehr.core.orm.filter.ORMERPORGSearchContext;




@Slf4j
@Api(tags = {"ORMERPORG" })
@RestController("WebApi-ormerporg")
@RequestMapping("")
public class ORMERPORGResource {

    @Autowired
    private IORMERPORGService ormerporgService;

    @Autowired
    @Lazy
    public ORMERPORGMapping ormerporgMapping;

    public ORMERPORGDTO permissionDTO=new ORMERPORGDTO();

    @PreAuthorize("hasPermission(#ormerporg_id,'Get',{'Sql',this.ormerporgMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMERPORG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormerporgs/{ormerporg_id}")
    public ResponseEntity<ORMERPORGDTO> get(@PathVariable("ormerporg_id") String ormerporg_id) {
        ORMERPORG domain = ormerporgService.get(ormerporg_id);
        ORMERPORGDTO dto = ormerporgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormerporg_id,'Update',{'Sql',this.ormerporgMapping,#ormerporgdto})")
    @ApiOperation(value = "Update", tags = {"ORMERPORG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormerporgs/{ormerporg_id}")
    @Transactional
    public ResponseEntity<ORMERPORGDTO> update(@PathVariable("ormerporg_id") String ormerporg_id, @RequestBody ORMERPORGDTO ormerporgdto) {
		ORMERPORG domain = ormerporgMapping.toDomain(ormerporgdto);
        domain.setOrmerporgid(ormerporg_id);
		ormerporgService.update(domain);
		ORMERPORGDTO dto = ormerporgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMERPORG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMERPORGDTO> ormerporgdtos) {
        ormerporgService.updateBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormerporg_id,'Remove',{'Sql',this.ormerporgMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMERPORG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormerporgs/{ormerporg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormerporg_id") String ormerporg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormerporgService.remove(ormerporg_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMERPORG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormerporgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-SynOrg-all')")
    @ApiOperation(value = "同步ERP组织信息", tags = {"ORMERPORG" },  notes = "同步ERP组织信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/{ormerporg_id}/synorg")
    @Transactional
    public ResponseEntity<ORMERPORGDTO> synOrg(@PathVariable("ormerporg_id") String ormerporg_id, @RequestBody ORMERPORGDTO ormerporgdto) {
        ORMERPORG ormerporg = ormerporgMapping.toDomain(ormerporgdto);
        ormerporg = ormerporgService.synOrg(ormerporg);
        ormerporgdto = ormerporgMapping.toDto(ormerporg);
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMERPORG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormerporgs/getdraft")
    public ResponseEntity<ORMERPORGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgMapping.toDto(ormerporgService.getDraft(new ORMERPORG())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMERPORG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMERPORGDTO ormerporgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormerporgService.save(ormerporgMapping.toDomain(ormerporgdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMERPORG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMERPORGDTO> ormerporgdtos) {
        ormerporgService.saveBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormerporgMapping,#ormerporgdto})")
    @ApiOperation(value = "Create", tags = {"ORMERPORG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs")
    @Transactional
    public ResponseEntity<ORMERPORGDTO> create(@RequestBody ORMERPORGDTO ormerporgdto) {
        ORMERPORG domain = ormerporgMapping.toDomain(ormerporgdto);
		ormerporgService.create(domain);
        ORMERPORGDTO dto = ormerporgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMERPORG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMERPORGDTO> ormerporgdtos) {
        ormerporgService.createBatch(ormerporgMapping.toDomain(ormerporgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMERPORG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormerporgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMERPORGDTO ormerporgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormerporgService.checkKey(ormerporgMapping.toDomain(ormerporgdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CXBM-all')")
	@ApiOperation(value = "fetch查询可用ERP部门", tags = {"ORMERPORG" } ,notes = "fetch查询可用ERP部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcxbm")
	public ResponseEntity<List<ORMERPORGDTO>> fetchCXBM(ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCXBM(context) ;
        List<ORMERPORGDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CXBM-all')")
	@ApiOperation(value = "search查询可用ERP部门", tags = {"ORMERPORG" } ,notes = "search查询可用ERP部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcxbm")
	public ResponseEntity<Page<ORMERPORGDTO>> searchCXBM(@RequestBody ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCXBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-LegalChoice-all')")
	@ApiOperation(value = "fetch管理单位选择", tags = {"ORMERPORG" } ,notes = "fetch管理单位选择")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchlegalchoice")
	public ResponseEntity<List<ORMERPORGDTO>> fetchLegalChoice(ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchLegalChoice(context) ;
        List<ORMERPORGDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-LegalChoice-all')")
	@ApiOperation(value = "search管理单位选择", tags = {"ORMERPORG" } ,notes = "search管理单位选择")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchlegalchoice")
	public ResponseEntity<Page<ORMERPORGDTO>> searchLegalChoice(@RequestBody ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchLegalChoice(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMERPORG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchdefault")
	public ResponseEntity<List<ORMERPORGDTO>> fetchDefault(ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchDefault(context) ;
        List<ORMERPORGDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMERPORG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchdefault")
	public ResponseEntity<Page<ORMERPORGDTO>> searchDefault(@RequestBody ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CX-all')")
	@ApiOperation(value = "fetch查询可用ERP组织", tags = {"ORMERPORG" } ,notes = "fetch查询可用ERP组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcx")
	public ResponseEntity<List<ORMERPORGDTO>> fetchCX(ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCX(context) ;
        List<ORMERPORGDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CX-all')")
	@ApiOperation(value = "search查询可用ERP组织", tags = {"ORMERPORG" } ,notes = "search查询可用ERP组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcx")
	public ResponseEntity<Page<ORMERPORGDTO>> searchCX(@RequestBody ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CXZBM-all')")
	@ApiOperation(value = "fetch查询可用ERP部门", tags = {"ORMERPORG" } ,notes = "fetch查询可用ERP部门")
    @RequestMapping(method= RequestMethod.GET , value="/ormerporgs/fetchcxzbm")
	public ResponseEntity<List<ORMERPORGDTO>> fetchCXZBM(ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCXZBM(context) ;
        List<ORMERPORGDTO> list = ormerporgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMERPORG-CXZBM-all')")
	@ApiOperation(value = "search查询可用ERP部门", tags = {"ORMERPORG" } ,notes = "search查询可用ERP部门")
    @RequestMapping(method= RequestMethod.POST , value="/ormerporgs/searchcxzbm")
	public ResponseEntity<Page<ORMERPORGDTO>> searchCXZBM(@RequestBody ORMERPORGSearchContext context) {
        Page<ORMERPORG> domains = ormerporgService.searchCXZBM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormerporgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
