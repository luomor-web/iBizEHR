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
import cn.ibizlab.ehr.core.vac.domain.VACSITUATION;
import cn.ibizlab.ehr.core.vac.service.IVACSITUATIONService;
import cn.ibizlab.ehr.core.vac.filter.VACSITUATIONSearchContext;




@Slf4j
@Api(tags = {"VACSITUATION" })
@RestController("WebApi-vacsituation")
@RequestMapping("")
public class VACSITUATIONResource {

    @Autowired
    private IVACSITUATIONService vacsituationService;

    @Autowired
    @Lazy
    private VACSITUATIONMapping vacsituationMapping;




    @PreAuthorize("hasPermission(#vacsituation_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACSITUATION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituations/{vacsituation_id}")
    @Transactional
    public ResponseEntity<VACSITUATIONDTO> update(@PathVariable("vacsituation_id") String vacsituation_id, @RequestBody VACSITUATIONDTO vacsituationdto) {
		VACSITUATION domain = vacsituationMapping.toDomain(vacsituationdto);
        domain.setVacsituationid(vacsituation_id);
		vacsituationService.update(domain);
		VACSITUATIONDTO dto = vacsituationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacsituation_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACSITUATION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSITUATIONDTO> vacsituationdtos) {
        vacsituationService.updateBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACSITUATION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations")
    @Transactional
    public ResponseEntity<VACSITUATIONDTO> create(@RequestBody VACSITUATIONDTO vacsituationdto) {
        VACSITUATION domain = vacsituationMapping.toDomain(vacsituationdto);
		vacsituationService.create(domain);
        VACSITUATIONDTO dto = vacsituationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACSITUATION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSITUATIONDTO> vacsituationdtos) {
        vacsituationService.createBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACSITUATION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSITUATIONDTO vacsituationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsituationService.checkKey(vacsituationMapping.toDomain(vacsituationdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"VACSITUATION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituations/getdraft")
    public ResponseEntity<VACSITUATIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationMapping.toDto(vacsituationService.getDraft(new VACSITUATION())));
    }




    @ApiOperation(value = "Save", tags = {"VACSITUATION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSITUATIONDTO vacsituationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationService.save(vacsituationMapping.toDomain(vacsituationdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACSITUATION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSITUATIONDTO> vacsituationdtos) {
        vacsituationService.saveBatch(vacsituationMapping.toDomain(vacsituationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacsituation_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACSITUATION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituations/{vacsituation_id}")
    public ResponseEntity<VACSITUATIONDTO> get(@PathVariable("vacsituation_id") String vacsituation_id) {
        VACSITUATION domain = vacsituationService.get(vacsituation_id);
        VACSITUATIONDTO dto = vacsituationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#vacsituation_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACSITUATION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituations/{vacsituation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsituation_id") String vacsituation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsituationService.remove(vacsituation_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACSITUATION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsituationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"VACSITUATION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsituations/fetchdefault")
	public ResponseEntity<List<VACSITUATIONDTO>> fetchDefault(VACSITUATIONSearchContext context) {
        Page<VACSITUATION> domains = vacsituationService.searchDefault(context) ;
        List<VACSITUATIONDTO> list = vacsituationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"VACSITUATION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsituations/searchdefault")
	public ResponseEntity<Page<VACSITUATIONDTO>> searchDefault(@RequestBody VACSITUATIONSearchContext context) {
        Page<VACSITUATION> domains = vacsituationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsituationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACSITUATION getEntity(){
        return new VACSITUATION();
    }

}
