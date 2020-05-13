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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORDTEMP;
import cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDTEMPService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCERECORDTEMPSearchContext;




@Slf4j
@Api(tags = {"ATTENDANCERECORDTEMP" })
@RestController("WebApi-attendancerecordtemp")
@RequestMapping("")
public class ATTENDANCERECORDTEMPResource {

    @Autowired
    private IATTENDANCERECORDTEMPService attendancerecordtempService;

    @Autowired
    @Lazy
    private ATTENDANCERECORDTEMPMapping attendancerecordtempMapping;




    @PreAuthorize("hasPermission(#attendancerecordtemp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ATTENDANCERECORDTEMP" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDTEMPDTO> update(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id, @RequestBody ATTENDANCERECORDTEMPDTO attendancerecordtempdto) {
		ATTENDANCERECORDTEMP domain = attendancerecordtempMapping.toDomain(attendancerecordtempdto);
        domain.setAttendancerecordtempid(attendancerecordtemp_id);
		attendancerecordtempService.update(domain);
		ATTENDANCERECORDTEMPDTO dto = attendancerecordtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#attendancerecordtemp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCERECORDTEMP" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCERECORDTEMPDTO> attendancerecordtempdtos) {
        attendancerecordtempService.updateBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#attendancerecordtemp_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCERECORDTEMP" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.remove(attendancerecordtemp_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCERECORDTEMP" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancerecordtempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ATTENDANCERECORDTEMP" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCERECORDTEMPDTO attendancerecordtempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.save(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCERECORDTEMP" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCERECORDTEMPDTO> attendancerecordtempdtos) {
        attendancerecordtempService.saveBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCERECORDTEMP" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/getdraft")
    public ResponseEntity<ATTENDANCERECORDTEMPDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempMapping.toDto(attendancerecordtempService.getDraft(new ATTENDANCERECORDTEMP())));
    }




    @PreAuthorize("hasPermission(#attendancerecordtemp_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ATTENDANCERECORDTEMP" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    public ResponseEntity<ATTENDANCERECORDTEMPDTO> get(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
        ATTENDANCERECORDTEMP domain = attendancerecordtempService.get(attendancerecordtemp_id);
        ATTENDANCERECORDTEMPDTO dto = attendancerecordtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ATTENDANCERECORDTEMP" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDTEMPDTO> create(@RequestBody ATTENDANCERECORDTEMPDTO attendancerecordtempdto) {
        ATTENDANCERECORDTEMP domain = attendancerecordtempMapping.toDomain(attendancerecordtempdto);
		attendancerecordtempService.create(domain);
        ATTENDANCERECORDTEMPDTO dto = attendancerecordtempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDANCERECORDTEMP" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCERECORDTEMPDTO> attendancerecordtempdtos) {
        attendancerecordtempService.createBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCERECORDTEMP" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCERECORDTEMPDTO attendancerecordtempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.checkKey(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCERECORDTEMP" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancerecordtemps/fetchdefault")
	public ResponseEntity<List<ATTENDANCERECORDTEMPDTO>> fetchDefault(ATTENDANCERECORDTEMPSearchContext context) {
        Page<ATTENDANCERECORDTEMP> domains = attendancerecordtempService.searchDefault(context) ;
        List<ATTENDANCERECORDTEMPDTO> list = attendancerecordtempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCERECORDTEMP" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancerecordtemps/searchdefault")
	public ResponseEntity<Page<ATTENDANCERECORDTEMPDTO>> searchDefault(ATTENDANCERECORDTEMPSearchContext context) {
        Page<ATTENDANCERECORDTEMP> domains = attendancerecordtempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordtempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ATTENDANCERECORDTEMP getEntity(){
        return new ATTENDANCERECORDTEMP();
    }

}
