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
import cn.ibizlab.ehr.core.orm.domain.ORMDUTY;
import cn.ibizlab.ehr.core.orm.service.IORMDUTYService;
import cn.ibizlab.ehr.core.orm.filter.ORMDUTYSearchContext;




@Slf4j
@Api(tags = {"ORMDUTY" })
@RestController("WebApi-ormduty")
@RequestMapping("")
public class ORMDUTYResource {

    @Autowired
    private IORMDUTYService ormdutyService;

    @Autowired
    @Lazy
    private ORMDUTYMapping ormdutyMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMDUTY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties")
    @Transactional
    public ResponseEntity<ORMDUTYDTO> create(@RequestBody ORMDUTYDTO ormdutydto) {
        ORMDUTY domain = ormdutyMapping.toDomain(ormdutydto);
		ormdutyService.create(domain);
        ORMDUTYDTO dto = ormdutyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMDUTY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMDUTYDTO> ormdutydtos) {
        ormdutyService.createBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "设置默认排序信息", tags = {"ORMDUTY" },  notes = "设置默认排序信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/synordernum")
    @Transactional
    public ResponseEntity<ORMDUTYDTO> synOrderNum(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDUTYDTO ormdutydto) {
        ORMDUTY ormduty = ormdutyMapping.toDomain(ormdutydto);
        ormduty = ormdutyService.synOrderNum(ormduty);
        ormdutydto = ormdutyMapping.toDto(ormduty);
        return ResponseEntity.status(HttpStatus.OK).body(ormdutydto);
    }




    @PreAuthorize("hasPermission(#ormduty_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMDUTY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}")
    @Transactional
    public ResponseEntity<ORMDUTYDTO> update(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDUTYDTO ormdutydto) {
		ORMDUTY domain = ormdutyMapping.toDomain(ormdutydto);
        domain.setOrmdutyid(ormduty_id);
		ormdutyService.update(domain);
		ORMDUTYDTO dto = ormdutyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormduty_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMDUTY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMDUTYDTO> ormdutydtos) {
        ormdutyService.updateBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMDUTY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/getdraft")
    public ResponseEntity<ORMDUTYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdutyMapping.toDto(ormdutyService.getDraft(new ORMDUTY())));
    }




    @PreAuthorize("hasPermission('Remove',{#ormduty_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMDUTY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormduty_id") String ormduty_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdutyService.remove(ormduty_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMDUTY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdutyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMDUTY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMDUTYDTO ormdutydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdutyService.checkKey(ormdutyMapping.toDomain(ormdutydto)));
    }




    @PreAuthorize("hasPermission(#ormduty_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMDUTY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}")
    public ResponseEntity<ORMDUTYDTO> get(@PathVariable("ormduty_id") String ormduty_id) {
        ORMDUTY domain = ormdutyService.get(ormduty_id);
        ORMDUTYDTO dto = ormdutyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"ORMDUTY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMDUTYDTO ormdutydto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdutyService.save(ormdutyMapping.toDomain(ormdutydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMDUTY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMDUTYDTO> ormdutydtos) {
        ormdutyService.saveBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'BasDuty',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根据当前部门所属组织层次过滤数据", tags = {"ORMDUTY" } ,notes = "fetch根据当前部门所属组织层次过滤数据")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchbasduty")
	public ResponseEntity<List<ORMDUTYDTO>> fetchBasDuty(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchBasDuty(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'BasDuty',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根据当前部门所属组织层次过滤数据", tags = {"ORMDUTY" } ,notes = "search根据当前部门所属组织层次过滤数据")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchbasduty")
	public ResponseEntity<Page<ORMDUTYDTO>> searchBasDuty(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchBasDuty(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchCurOrgsector", tags = {"ORMDUTY" } ,notes = "fetchCurOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurorgsector")
	public ResponseEntity<List<ORMDUTYDTO>> fetchCurOrgsector(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrgsector(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchCurOrgsector", tags = {"ORMDUTY" } ,notes = "searchCurOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchcurorgsector")
	public ResponseEntity<Page<ORMDUTYDTO>> searchCurOrgsector(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'SrfOrgData',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根据当前人员身份判定职务范围", tags = {"ORMDUTY" } ,notes = "fetch根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchsrforgdata")
	public ResponseEntity<List<ORMDUTYDTO>> fetchSrfOrgData(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchSrfOrgData(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'SrfOrgData',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根据当前人员身份判定职务范围", tags = {"ORMDUTY" } ,notes = "search根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchsrforgdata")
	public ResponseEntity<Page<ORMDUTYDTO>> searchSrfOrgData(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchSrfOrgData(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMDUTY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchdefault")
	public ResponseEntity<List<ORMDUTYDTO>> fetchDefault(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchDefault(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMDUTY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchdefault")
	public ResponseEntity<Page<ORMDUTYDTO>> searchDefault(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根据当前人员身份判定职务范围", tags = {"ORMDUTY" } ,notes = "fetch根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurorg")
	public ResponseEntity<List<ORMDUTYDTO>> fetchCurOrg(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrg(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrg',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根据当前人员身份判定职务范围", tags = {"ORMDUTY" } ,notes = "search根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchcurorg")
	public ResponseEntity<Page<ORMDUTYDTO>> searchCurOrg(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrmorgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchCurOrmorgsector", tags = {"ORMDUTY" } ,notes = "fetchCurOrmorgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurormorgsector")
	public ResponseEntity<List<ORMDUTYDTO>> fetchCurOrmorgsector(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrmorgsector(context) ;
        List<ORMDUTYDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurOrmorgsector',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchCurOrmorgsector", tags = {"ORMDUTY" } ,notes = "searchCurOrmorgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/searchcurormorgsector")
	public ResponseEntity<Page<ORMDUTYDTO>> searchCurOrmorgsector(ORMDUTYSearchContext context) {
        Page<ORMDUTY> domains = ormdutyService.searchCurOrmorgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMDUTY getEntity(){
        return new ORMDUTY();
    }

}