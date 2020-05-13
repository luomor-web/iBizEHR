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
import cn.ibizlab.ehr.core.orm.domain.ORMXMGL;
import cn.ibizlab.ehr.core.orm.service.IORMXMGLService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMGLSearchContext;




@Slf4j
@Api(tags = {"ORMXMGL" })
@RestController("WebApi-ormxmgl")
@RequestMapping("")
public class ORMXMGLResource {

    @Autowired
    private IORMXMGLService ormxmglService;

    @Autowired
    @Lazy
    private ORMXMGLMapping ormxmglMapping;




    @PreAuthorize("hasPermission(#ormxmgl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMXMGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmgls/{ormxmgl_id}")
    public ResponseEntity<ORMXMGLDTO> get(@PathVariable("ormxmgl_id") String ormxmgl_id) {
        ORMXMGL domain = ormxmglService.get(ormxmgl_id);
        ORMXMGLDTO dto = ormxmglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMXMGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMGLDTO ormxmgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmglService.checkKey(ormxmglMapping.toDomain(ormxmgldto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMXMGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmgls/getdraft")
    public ResponseEntity<ORMXMGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmglMapping.toDto(ormxmglService.getDraft(new ORMXMGL())));
    }




    @PreAuthorize("hasPermission(#ormxmgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMXMGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmgls/{ormxmgl_id}")
    @Transactional
    public ResponseEntity<ORMXMGLDTO> update(@PathVariable("ormxmgl_id") String ormxmgl_id, @RequestBody ORMXMGLDTO ormxmgldto) {
		ORMXMGL domain = ormxmglMapping.toDomain(ormxmgldto);
        domain.setOrmxmglid(ormxmgl_id);
		ormxmglService.update(domain);
		ORMXMGLDTO dto = ormxmglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormxmgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMGLDTO> ormxmgldtos) {
        ormxmglService.updateBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMXMGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls")
    @Transactional
    public ResponseEntity<ORMXMGLDTO> create(@RequestBody ORMXMGLDTO ormxmgldto) {
        ORMXMGL domain = ormxmglMapping.toDomain(ormxmgldto);
		ormxmglService.create(domain);
        ORMXMGLDTO dto = ormxmglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMGLDTO> ormxmgldtos) {
        ormxmglService.createBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#ormxmgl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMXMGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmgls/{ormxmgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmgl_id") String ormxmgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmglService.remove(ormxmgl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "同步项目信息", tags = {"ORMXMGL" },  notes = "同步项目信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/{ormxmgl_id}/synchro")
    @Transactional
    public ResponseEntity<ORMXMGLDTO> synchro(@PathVariable("ormxmgl_id") String ormxmgl_id, @RequestBody ORMXMGLDTO ormxmgldto) {
        ORMXMGL ormxmgl = ormxmglMapping.toDomain(ormxmgldto);
        ormxmgl = ormxmglService.synchro(ormxmgl);
        ormxmgldto = ormxmglMapping.toDto(ormxmgl);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmgldto);
    }




    @ApiOperation(value = "Save", tags = {"ORMXMGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMGLDTO ormxmgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmglService.save(ormxmglMapping.toDomain(ormxmgldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMXMGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMGLDTO> ormxmgldtos) {
        ormxmglService.saveBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/fetchdefault")
	public ResponseEntity<List<ORMXMGLDTO>> fetchDefault(ORMXMGLSearchContext context) {
        Page<ORMXMGL> domains = ormxmglService.searchDefault(context) ;
        List<ORMXMGLDTO> list = ormxmglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/searchdefault")
	public ResponseEntity<Page<ORMXMGLDTO>> searchDefault(ORMXMGLSearchContext context) {
        Page<ORMXMGL> domains = ormxmglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'ValidPro',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch有效项目", tags = {"ORMXMGL" } ,notes = "fetch有效项目")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/fetchvalidpro")
	public ResponseEntity<List<ORMXMGLDTO>> fetchValidPro(ORMXMGLSearchContext context) {
        Page<ORMXMGL> domains = ormxmglService.searchValidPro(context) ;
        List<ORMXMGLDTO> list = ormxmglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'ValidPro',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search有效项目", tags = {"ORMXMGL" } ,notes = "search有效项目")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/searchvalidpro")
	public ResponseEntity<Page<ORMXMGLDTO>> searchValidPro(ORMXMGLSearchContext context) {
        Page<ORMXMGL> domains = ormxmglService.searchValidPro(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMXMGL getEntity(){
        return new ORMXMGL();
    }

}
