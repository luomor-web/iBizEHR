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
import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES;
import cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYRULESService;
import cn.ibizlab.ehr.core.vac.filter.VACHOLIDAYRULESSearchContext;




@Slf4j
@Api(tags = {"VACHOLIDAYRULES" })
@RestController("WebApi-vacholidayrules")
@RequestMapping("")
public class VACHOLIDAYRULESResource {

    @Autowired
    private IVACHOLIDAYRULESService vacholidayrulesService;

    @Autowired
    @Lazy
    private VACHOLIDAYRULESMapping vacholidayrulesMapping;




    @ApiOperation(value = "拷贝考勤规则", tags = {"VACHOLIDAYRULES" },  notes = "拷贝考勤规则")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/copykqgzdata")
    @Transactional
    public ResponseEntity<VACHOLIDAYRULESDTO> copyKQGZData(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYRULESDTO vacholidayrulesdto) {
        VACHOLIDAYRULES vacholidayrules = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
        vacholidayrules = vacholidayrulesService.copyKQGZData(vacholidayrules);
        vacholidayrulesdto = vacholidayrulesMapping.toDto(vacholidayrules);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesdto);
    }




    @PreAuthorize("hasPermission('Remove',{#vacholidayrules_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACHOLIDAYRULES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.remove(vacholidayrules_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACHOLIDAYRULES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacholidayrulesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACHOLIDAYRULES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACHOLIDAYRULESDTO vacholidayrulesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.checkKey(vacholidayrulesMapping.toDomain(vacholidayrulesdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACHOLIDAYRULES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules")
    @Transactional
    public ResponseEntity<VACHOLIDAYRULESDTO> create(@RequestBody VACHOLIDAYRULESDTO vacholidayrulesdto) {
        VACHOLIDAYRULES domain = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
		vacholidayrulesService.create(domain);
        VACHOLIDAYRULESDTO dto = vacholidayrulesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACHOLIDAYRULES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACHOLIDAYRULESDTO> vacholidayrulesdtos) {
        vacholidayrulesService.createBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"VACHOLIDAYRULES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/getdraft")
    public ResponseEntity<VACHOLIDAYRULESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesMapping.toDto(vacholidayrulesService.getDraft(new VACHOLIDAYRULES())));
    }




    @PreAuthorize("hasPermission(#vacholidayrules_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACHOLIDAYRULES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}")
    @Transactional
    public ResponseEntity<VACHOLIDAYRULESDTO> update(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYRULESDTO vacholidayrulesdto) {
		VACHOLIDAYRULES domain = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacholidayrulesService.update(domain);
		VACHOLIDAYRULESDTO dto = vacholidayrulesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacholidayrules_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACHOLIDAYRULES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACHOLIDAYRULESDTO> vacholidayrulesdtos) {
        vacholidayrulesService.updateBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacholidayrules_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACHOLIDAYRULES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}")
    public ResponseEntity<VACHOLIDAYRULESDTO> get(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VACHOLIDAYRULES domain = vacholidayrulesService.get(vacholidayrules_id);
        VACHOLIDAYRULESDTO dto = vacholidayrulesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"VACHOLIDAYRULES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/save")
    public ResponseEntity<Boolean> save(@RequestBody VACHOLIDAYRULESDTO vacholidayrulesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.save(vacholidayrulesMapping.toDomain(vacholidayrulesdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACHOLIDAYRULES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACHOLIDAYRULESDTO> vacholidayrulesdtos) {
        vacholidayrulesService.saveBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"VACHOLIDAYRULES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/fetchdefault")
	public ResponseEntity<List<VACHOLIDAYRULESDTO>> fetchDefault(VACHOLIDAYRULESSearchContext context) {
        Page<VACHOLIDAYRULES> domains = vacholidayrulesService.searchDefault(context) ;
        List<VACHOLIDAYRULESDTO> list = vacholidayrulesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"VACHOLIDAYRULES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/searchdefault")
	public ResponseEntity<Page<VACHOLIDAYRULESDTO>> searchDefault(@RequestBody VACHOLIDAYRULESSearchContext context) {
        Page<VACHOLIDAYRULES> domains = vacholidayrulesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayrulesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch当前组织下的假期规则", tags = {"VACHOLIDAYRULES" } ,notes = "fetch当前组织下的假期规则")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/fetchcurormorg")
	public ResponseEntity<List<VACHOLIDAYRULESDTO>> fetchCurOrmorg(VACHOLIDAYRULESSearchContext context) {
        Page<VACHOLIDAYRULES> domains = vacholidayrulesService.searchCurOrmorg(context) ;
        List<VACHOLIDAYRULESDTO> list = vacholidayrulesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search当前组织下的假期规则", tags = {"VACHOLIDAYRULES" } ,notes = "search当前组织下的假期规则")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/searchcurormorg")
	public ResponseEntity<Page<VACHOLIDAYRULESDTO>> searchCurOrmorg(@RequestBody VACHOLIDAYRULESSearchContext context) {
        Page<VACHOLIDAYRULES> domains = vacholidayrulesService.searchCurOrmorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayrulesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACHOLIDAYRULES getEntity(){
        return new VACHOLIDAYRULES();
    }

}
