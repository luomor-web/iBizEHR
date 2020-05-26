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
import cn.ibizlab.ehr.core.orm.domain.ORMRANK;
import cn.ibizlab.ehr.core.orm.service.IORMRANKService;
import cn.ibizlab.ehr.core.orm.filter.ORMRANKSearchContext;

@Slf4j
@Api(tags = {"ORMRANK" })
@RestController("WebApi-ormrank")
@RequestMapping("")
public class ORMRANKResource {

    @Autowired
    private IORMRANKService ormrankService;

    @Autowired
    @Lazy
    public ORMRANKMapping ormrankMapping;

    public ORMRANKDTO permissionDTO=new ORMRANKDTO();

    @PreAuthorize("hasPermission(#ormrank_id,'Update',{'Sql',this.ormrankMapping,#ormrankdto})")
    @ApiOperation(value = "Update", tags = {"ORMRANK" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormranks/{ormrank_id}")
    @Transactional
    public ResponseEntity<ORMRANKDTO> update(@PathVariable("ormrank_id") String ormrank_id, @RequestBody ORMRANKDTO ormrankdto) {
		ORMRANK domain  = ormrankMapping.toDomain(ormrankdto);
        domain .setOrmrankid(ormrank_id);
		ormrankService.update(domain );
		ORMRANKDTO dto = ormrankMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormrankMapping,#ormrankdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMRANK" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormranks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMRANKDTO> ormrankdtos) {
        ormrankService.updateBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormrank_id,'Remove',{'Sql',this.ormrankMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMRANK" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormranks/{ormrank_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormrank_id") String ormrank_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormrankService.remove(ormrank_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormrankMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMRANK" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormranks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormrankService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormrankMapping,#ormrankdto})")
    @ApiOperation(value = "Save", tags = {"ORMRANK" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMRANKDTO ormrankdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormrankService.save(ormrankMapping.toDomain(ormrankdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormrankMapping,#ormrankdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMRANK" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMRANKDTO> ormrankdtos) {
        ormrankService.saveBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormrank_id,'Get',{'Sql',this.ormrankMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMRANK" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormranks/{ormrank_id}")
    public ResponseEntity<ORMRANKDTO> get(@PathVariable("ormrank_id") String ormrank_id) {
        ORMRANK domain = ormrankService.get(ormrank_id);
        ORMRANKDTO dto = ormrankMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMRANK" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMRANKDTO ormrankdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormrankService.checkKey(ormrankMapping.toDomain(ormrankdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMRANK" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormranks/getdraft")
    public ResponseEntity<ORMRANKDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormrankMapping.toDto(ormrankService.getDraft(new ORMRANK())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormrankMapping,#ormrankdto})")
    @ApiOperation(value = "Create", tags = {"ORMRANK" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks")
    @Transactional
    public ResponseEntity<ORMRANKDTO> create(@RequestBody ORMRANKDTO ormrankdto) {
        ORMRANK domain = ormrankMapping.toDomain(ormrankdto);
		ormrankService.create(domain);
        ORMRANKDTO dto = ormrankMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormrankMapping,#ormrankdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMRANK" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormranks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMRANKDTO> ormrankdtos) {
        ormrankService.createBatch(ormrankMapping.toDomain(ormrankdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JZRANK-all')")
	@ApiOperation(value = "fetchJZRANK", tags = {"ORMRANK" } ,notes = "fetchJZRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjzrank")
	public ResponseEntity<List<ORMRANKDTO>> fetchJZRANK(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJZRANK(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JZRANK-all')")
	@ApiOperation(value = "searchJZRANK", tags = {"ORMRANK" } ,notes = "searchJZRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjzrank")
	public ResponseEntity<Page<ORMRANKDTO>> searchJZRANK(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJZRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JSRANK-all')")
	@ApiOperation(value = "fetchJSRANK", tags = {"ORMRANK" } ,notes = "fetchJSRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjsrank")
	public ResponseEntity<List<ORMRANKDTO>> fetchJSRANK(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJSRANK(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JSRANK-all')")
	@ApiOperation(value = "searchJSRANK", tags = {"ORMRANK" } ,notes = "searchJSRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjsrank")
	public ResponseEntity<Page<ORMRANKDTO>> searchJSRANK(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJSRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-DJYX-all')")
	@ApiOperation(value = "fetchD级以下", tags = {"ORMRANK" } ,notes = "fetchD级以下")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchdjyx")
	public ResponseEntity<List<ORMRANKDTO>> fetchDJYX(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchDJYX(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-DJYX-all')")
	@ApiOperation(value = "searchD级以下", tags = {"ORMRANK" } ,notes = "searchD级以下")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchdjyx")
	public ResponseEntity<Page<ORMRANKDTO>> searchDJYX(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchDJYX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JSNRANK-all')")
	@ApiOperation(value = "fetchJSNRANK", tags = {"ORMRANK" } ,notes = "fetchJSNRANK")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchjsnrank")
	public ResponseEntity<List<ORMRANKDTO>> fetchJSNRANK(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJSNRANK(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-JSNRANK-all')")
	@ApiOperation(value = "searchJSNRANK", tags = {"ORMRANK" } ,notes = "searchJSNRANK")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchjsnrank")
	public ResponseEntity<Page<ORMRANKDTO>> searchJSNRANK(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchJSNRANK(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMRANK" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchdefault")
	public ResponseEntity<List<ORMRANKDTO>> fetchDefault(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchDefault(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMRANK" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchdefault")
	public ResponseEntity<Page<ORMRANKDTO>> searchDefault(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-CurRank-all')")
	@ApiOperation(value = "fetch根据登录人身份判定职级显示", tags = {"ORMRANK" } ,notes = "fetch根据登录人身份判定职级显示")
    @RequestMapping(method= RequestMethod.GET , value="/ormranks/fetchcurrank")
	public ResponseEntity<List<ORMRANKDTO>> fetchCurRank(ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchCurRank(context) ;
        List<ORMRANKDTO> list = ormrankMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMRANK-CurRank-all')")
	@ApiOperation(value = "search根据登录人身份判定职级显示", tags = {"ORMRANK" } ,notes = "search根据登录人身份判定职级显示")
    @RequestMapping(method= RequestMethod.POST , value="/ormranks/searchcurrank")
	public ResponseEntity<Page<ORMRANKDTO>> searchCurRank(@RequestBody ORMRANKSearchContext context) {
        Page<ORMRANK> domains = ormrankService.searchCurRank(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormrankMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
