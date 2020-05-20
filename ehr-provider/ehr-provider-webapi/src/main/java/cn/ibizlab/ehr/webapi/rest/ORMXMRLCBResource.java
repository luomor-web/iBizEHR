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
import cn.ibizlab.ehr.core.orm.domain.ORMXMRLCB;
import cn.ibizlab.ehr.core.orm.service.IORMXMRLCBService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRLCBSearchContext;




@Slf4j
@Api(tags = {"ORMXMRLCB" })
@RestController("WebApi-ormxmrlcb")
@RequestMapping("")
public class ORMXMRLCBResource {

    @Autowired
    private IORMXMRLCBService ormxmrlcbService;

    @Autowired
    @Lazy
    private ORMXMRLCBMapping ormxmrlcbMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMXMRLCB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrlcbs")
    @Transactional
    public ResponseEntity<ORMXMRLCBDTO> create(@RequestBody ORMXMRLCBDTO ormxmrlcbdto) {
        ORMXMRLCB domain = ormxmrlcbMapping.toDomain(ormxmrlcbdto);
		ormxmrlcbService.create(domain);
        ORMXMRLCBDTO dto = ormxmrlcbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMRLCB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrlcbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMRLCBDTO> ormxmrlcbdtos) {
        ormxmrlcbService.createBatch(ormxmrlcbMapping.toDomain(ormxmrlcbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#ormxmrlcb_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMXMRLCB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrlcbs/{ormxmrlcb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmrlcb_id") String ormxmrlcb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmrlcbService.remove(ormxmrlcb_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMRLCB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrlcbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmrlcbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormxmrlcb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMXMRLCB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrlcbs/{ormxmrlcb_id}")
    @Transactional
    public ResponseEntity<ORMXMRLCBDTO> update(@PathVariable("ormxmrlcb_id") String ormxmrlcb_id, @RequestBody ORMXMRLCBDTO ormxmrlcbdto) {
		ORMXMRLCB domain = ormxmrlcbMapping.toDomain(ormxmrlcbdto);
        domain.setOrmxmrlcbid(ormxmrlcb_id);
		ormxmrlcbService.update(domain);
		ORMXMRLCBDTO dto = ormxmrlcbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormxmrlcb_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMRLCB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrlcbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMRLCBDTO> ormxmrlcbdtos) {
        ormxmrlcbService.updateBatch(ormxmrlcbMapping.toDomain(ormxmrlcbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMXMRLCB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrlcbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMRLCBDTO ormxmrlcbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmrlcbService.checkKey(ormxmrlcbMapping.toDomain(ormxmrlcbdto)));
    }




    @ApiOperation(value = "Save", tags = {"ORMXMRLCB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrlcbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMRLCBDTO ormxmrlcbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrlcbService.save(ormxmrlcbMapping.toDomain(ormxmrlcbdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMXMRLCB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrlcbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMRLCBDTO> ormxmrlcbdtos) {
        ormxmrlcbService.saveBatch(ormxmrlcbMapping.toDomain(ormxmrlcbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMXMRLCB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrlcbs/getdraft")
    public ResponseEntity<ORMXMRLCBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrlcbMapping.toDto(ormxmrlcbService.getDraft(new ORMXMRLCB())));
    }




    @PreAuthorize("hasPermission(#ormxmrlcb_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMXMRLCB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrlcbs/{ormxmrlcb_id}")
    public ResponseEntity<ORMXMRLCBDTO> get(@PathVariable("ormxmrlcb_id") String ormxmrlcb_id) {
        ORMXMRLCB domain = ormxmrlcbService.get(ormxmrlcb_id);
        ORMXMRLCBDTO dto = ormxmrlcbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetch项目人工成本查询", tags = {"ORMXMRLCB" } ,notes = "fetch项目人工成本查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrlcbs/fetchcbcx")
	public ResponseEntity<List<ORMXMRLCBDTO>> fetchCBCX(ORMXMRLCBSearchContext context) {
        Page<ORMXMRLCB> domains = ormxmrlcbService.searchCBCX(context) ;
        List<ORMXMRLCBDTO> list = ormxmrlcbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search项目人工成本查询", tags = {"ORMXMRLCB" } ,notes = "search项目人工成本查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrlcbs/searchcbcx")
	public ResponseEntity<Page<ORMXMRLCBDTO>> searchCBCX(@RequestBody ORMXMRLCBSearchContext context) {
        Page<ORMXMRLCB> domains = ormxmrlcbService.searchCBCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrlcbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMRLCB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrlcbs/fetchdefault")
	public ResponseEntity<List<ORMXMRLCBDTO>> fetchDefault(ORMXMRLCBSearchContext context) {
        Page<ORMXMRLCB> domains = ormxmrlcbService.searchDefault(context) ;
        List<ORMXMRLCBDTO> list = ormxmrlcbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMRLCB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrlcbs/searchdefault")
	public ResponseEntity<Page<ORMXMRLCBDTO>> searchDefault(@RequestBody ORMXMRLCBSearchContext context) {
        Page<ORMXMRLCB> domains = ormxmrlcbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrlcbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMXMRLCB getEntity(){
        return new ORMXMRLCB();
    }

}
