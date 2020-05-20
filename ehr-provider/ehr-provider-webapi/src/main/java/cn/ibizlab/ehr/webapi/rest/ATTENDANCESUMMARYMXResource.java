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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCESUMMARYMX;
import cn.ibizlab.ehr.core.att.service.IATTENDANCESUMMARYMXService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCESUMMARYMXSearchContext;




@Slf4j
@Api(tags = {"ATTENDANCESUMMARYMX" })
@RestController("WebApi-attendancesummarymx")
@RequestMapping("")
public class ATTENDANCESUMMARYMXResource {

    @Autowired
    private IATTENDANCESUMMARYMXService attendancesummarymxService;

    @Autowired
    @Lazy
    private ATTENDANCESUMMARYMXMapping attendancesummarymxMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ATTENDANCESUMMARYMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesummarymxes")
    @Transactional
    public ResponseEntity<ATTENDANCESUMMARYMXDTO> create(@RequestBody ATTENDANCESUMMARYMXDTO attendancesummarymxdto) {
        ATTENDANCESUMMARYMX domain = attendancesummarymxMapping.toDomain(attendancesummarymxdto);
		attendancesummarymxService.create(domain);
        ATTENDANCESUMMARYMXDTO dto = attendancesummarymxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDANCESUMMARYMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesummarymxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCESUMMARYMXDTO> attendancesummarymxdtos) {
        attendancesummarymxService.createBatch(attendancesummarymxMapping.toDomain(attendancesummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCESUMMARYMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesummarymxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCESUMMARYMXDTO attendancesummarymxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesummarymxService.checkKey(attendancesummarymxMapping.toDomain(attendancesummarymxdto)));
    }




    @PreAuthorize("hasPermission(#attendancesummarymx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ATTENDANCESUMMARYMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesummarymxes/{attendancesummarymx_id}")
    public ResponseEntity<ATTENDANCESUMMARYMXDTO> get(@PathVariable("attendancesummarymx_id") String attendancesummarymx_id) {
        ATTENDANCESUMMARYMX domain = attendancesummarymxService.get(attendancesummarymx_id);
        ATTENDANCESUMMARYMXDTO dto = attendancesummarymxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCESUMMARYMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesummarymxes/getdraft")
    public ResponseEntity<ATTENDANCESUMMARYMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesummarymxMapping.toDto(attendancesummarymxService.getDraft(new ATTENDANCESUMMARYMX())));
    }




    @PreAuthorize("hasPermission('Remove',{#attendancesummarymx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCESUMMARYMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesummarymxes/{attendancesummarymx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancesummarymx_id") String attendancesummarymx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancesummarymxService.remove(attendancesummarymx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCESUMMARYMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesummarymxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancesummarymxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ATTENDANCESUMMARYMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesummarymxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCESUMMARYMXDTO attendancesummarymxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesummarymxService.save(attendancesummarymxMapping.toDomain(attendancesummarymxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCESUMMARYMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesummarymxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCESUMMARYMXDTO> attendancesummarymxdtos) {
        attendancesummarymxService.saveBatch(attendancesummarymxMapping.toDomain(attendancesummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#attendancesummarymx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ATTENDANCESUMMARYMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesummarymxes/{attendancesummarymx_id}")
    @Transactional
    public ResponseEntity<ATTENDANCESUMMARYMXDTO> update(@PathVariable("attendancesummarymx_id") String attendancesummarymx_id, @RequestBody ATTENDANCESUMMARYMXDTO attendancesummarymxdto) {
		ATTENDANCESUMMARYMX domain = attendancesummarymxMapping.toDomain(attendancesummarymxdto);
        domain.setAttendancesummarymxid(attendancesummarymx_id);
		attendancesummarymxService.update(domain);
		ATTENDANCESUMMARYMXDTO dto = attendancesummarymxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#attendancesummarymx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCESUMMARYMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesummarymxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCESUMMARYMXDTO> attendancesummarymxdtos) {
        attendancesummarymxService.updateBatch(attendancesummarymxMapping.toDomain(attendancesummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCESUMMARYMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesummarymxes/fetchdefault")
	public ResponseEntity<List<ATTENDANCESUMMARYMXDTO>> fetchDefault(ATTENDANCESUMMARYMXSearchContext context) {
        Page<ATTENDANCESUMMARYMX> domains = attendancesummarymxService.searchDefault(context) ;
        List<ATTENDANCESUMMARYMXDTO> list = attendancesummarymxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCESUMMARYMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesummarymxes/searchdefault")
	public ResponseEntity<Page<ATTENDANCESUMMARYMXDTO>> searchDefault(@RequestBody ATTENDANCESUMMARYMXSearchContext context) {
        Page<ATTENDANCESUMMARYMX> domains = attendancesummarymxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesummarymxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ATTENDANCESUMMARYMX getEntity(){
        return new ATTENDANCESUMMARYMX();
    }

}
