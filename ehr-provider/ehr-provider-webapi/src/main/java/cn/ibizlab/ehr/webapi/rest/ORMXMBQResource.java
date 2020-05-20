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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBQ;
import cn.ibizlab.ehr.core.orm.service.IORMXMBQService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBQSearchContext;




@Slf4j
@Api(tags = {"ORMXMBQ" })
@RestController("WebApi-ormxmbq")
@RequestMapping("")
public class ORMXMBQResource {

    @Autowired
    private IORMXMBQService ormxmbqService;

    @Autowired
    @Lazy
    private ORMXMBQMapping ormxmbqMapping;




    @PreAuthorize("hasPermission(#ormxmbq_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMXMBQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<ORMXMBQDTO> get(@PathVariable("ormxmbq_id") String ormxmbq_id) {
        ORMXMBQ domain = ormxmbqService.get(ormxmbq_id);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMXMBQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> create(@RequestBody ORMXMBQDTO ormxmbqdto) {
        ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
		ormxmbqService.create(domain);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMBQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.createBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ORMXMBQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBQDTO ormxmbqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMXMBQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.saveBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMXMBQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBQDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMXMBQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/getdraft")
    public ResponseEntity<ORMXMBQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(new ORMXMBQ())));
    }




    @PreAuthorize("hasPermission(#ormxmbq_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMXMBQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbq_id") String ormxmbq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMBQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormxmbq_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMXMBQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> update(@PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
		ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain);
		ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormxmbq_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMBQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.updateBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMBQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbqs/fetchdefault")
	public ResponseEntity<List<ORMXMBQDTO>> fetchDefault(ORMXMBQSearchContext context) {
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
        List<ORMXMBQDTO> list = ormxmbqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMBQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbqs/searchdefault")
	public ResponseEntity<Page<ORMXMBQDTO>> searchDefault(@RequestBody ORMXMBQSearchContext context) {
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMXMBQ getEntity(){
        return new ORMXMBQ();
    }

}
