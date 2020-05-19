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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVEDETAILService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEDETAILSearchContext;




@Slf4j
@Api(tags = {"VACLEAVEDETAIL" })
@RestController("WebApi-vacleavedetail")
@RequestMapping("")
public class VACLEAVEDETAILResource {

    @Autowired
    private IVACLEAVEDETAILService vacleavedetailService;

    @Autowired
    @Lazy
    private VACLEAVEDETAILMapping vacleavedetailMapping;




    @PreAuthorize("hasPermission('Remove',{#vacleavedetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACLEAVEDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavedetail_id") String vacleavedetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.remove(vacleavedetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACLEAVEDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavedetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "计算实际请假天数", tags = {"VACLEAVEDETAIL" },  notes = "计算实际请假天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/{vacleavedetail_id}/calcsjqjts")
    @Transactional
    public ResponseEntity<VACLEAVEDETAILDTO> calcSJQJTS(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        VACLEAVEDETAIL vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail = vacleavedetailService.calcSJQJTS(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACLEAVEDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails")
    @Transactional
    public ResponseEntity<VACLEAVEDETAILDTO> create(@RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        VACLEAVEDETAIL domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
		vacleavedetailService.create(domain);
        VACLEAVEDETAILDTO dto = vacleavedetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACLEAVEDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVEDETAILDTO> vacleavedetaildtos) {
        vacleavedetailService.createBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacleavedetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACLEAVEDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavedetails/{vacleavedetail_id}")
    @Transactional
    public ResponseEntity<VACLEAVEDETAILDTO> update(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
		VACLEAVEDETAIL domain = vacleavedetailMapping.toDomain(vacleavedetaildto);
        domain.setVacleavedetailid(vacleavedetail_id);
		vacleavedetailService.update(domain);
		VACLEAVEDETAILDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacleavedetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACLEAVEDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavedetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVEDETAILDTO> vacleavedetaildtos) {
        vacleavedetailService.updateBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "获取假期使用情况、温馨提示、计算计划请假天数", tags = {"VACLEAVEDETAIL" },  notes = "获取假期使用情况、温馨提示、计算计划请假天数")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/{vacleavedetail_id}/getnianjia")
    @Transactional
    public ResponseEntity<VACLEAVEDETAILDTO> getNianJia(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        VACLEAVEDETAIL vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail = vacleavedetailService.getNianJia(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }




    @ApiOperation(value = "Save", tags = {"VACLEAVEDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.save(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACLEAVEDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVEDETAILDTO> vacleavedetaildtos) {
        vacleavedetailService.saveBatch(vacleavedetailMapping.toDomain(vacleavedetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "计算计划请假天数", tags = {"VACLEAVEDETAIL" },  notes = "计算计划请假天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/{vacleavedetail_id}/calcjhqjts")
    @Transactional
    public ResponseEntity<VACLEAVEDETAILDTO> calcJHQJTS(@PathVariable("vacleavedetail_id") String vacleavedetail_id, @RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        VACLEAVEDETAIL vacleavedetail = vacleavedetailMapping.toDomain(vacleavedetaildto);
        vacleavedetail = vacleavedetailService.calcJHQJTS(vacleavedetail);
        vacleavedetaildto = vacleavedetailMapping.toDto(vacleavedetail);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetaildto);
    }




    @PreAuthorize("hasPermission(#vacleavedetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACLEAVEDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/{vacleavedetail_id}")
    public ResponseEntity<VACLEAVEDETAILDTO> get(@PathVariable("vacleavedetail_id") String vacleavedetail_id) {
        VACLEAVEDETAIL domain = vacleavedetailService.get(vacleavedetail_id);
        VACLEAVEDETAILDTO dto = vacleavedetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACLEAVEDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavedetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVEDETAILDTO vacleavedetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavedetailService.checkKey(vacleavedetailMapping.toDomain(vacleavedetaildto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"VACLEAVEDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavedetails/getdraft")
    public ResponseEntity<VACLEAVEDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavedetailMapping.toDto(vacleavedetailService.getDraft(new VACLEAVEDETAIL())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEAVEDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavedetails/fetchdefault")
	public ResponseEntity<List<VACLEAVEDETAILDTO>> fetchDefault(VACLEAVEDETAILSearchContext context) {
        Page<VACLEAVEDETAIL> domains = vacleavedetailService.searchDefault(context) ;
        List<VACLEAVEDETAILDTO> list = vacleavedetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEAVEDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavedetails/searchdefault")
	public ResponseEntity<Page<VACLEAVEDETAILDTO>> searchDefault(VACLEAVEDETAILSearchContext context) {
        Page<VACLEAVEDETAIL> domains = vacleavedetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavedetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACLEAVEDETAIL getEntity(){
        return new VACLEAVEDETAIL();
    }

}
