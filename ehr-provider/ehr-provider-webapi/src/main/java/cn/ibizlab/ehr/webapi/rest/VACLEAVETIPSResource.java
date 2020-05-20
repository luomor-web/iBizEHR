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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVETIPS;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVETIPSService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVETIPSSearchContext;




@Slf4j
@Api(tags = {"VACLEAVETIPS" })
@RestController("WebApi-vacleavetips")
@RequestMapping("")
public class VACLEAVETIPSResource {

    @Autowired
    private IVACLEAVETIPSService vacleavetipsService;

    @Autowired
    @Lazy
    private VACLEAVETIPSMapping vacleavetipsMapping;




    @ApiOperation(value = "检查请假种类", tags = {"VACLEAVETIPS" },  notes = "检查请假种类")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkqjzl")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkQJZL(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips = vacleavetipsService.checkQJZL(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACLEAVETIPS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> create(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
		vacleavetipsService.create(domain);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACLEAVETIPS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.createBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"VACLEAVETIPS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/getdraft")
    public ResponseEntity<VACLEAVETIPSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsMapping.toDto(vacleavetipsService.getDraft(new VACLEAVETIPS())));
    }




    @PreAuthorize("hasPermission('Remove',{#vacleavetips_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACLEAVETIPS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavetips_id") String vacleavetips_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.remove(vacleavetips_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACLEAVETIPS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavetipsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACLEAVETIPS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.checkKey(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }




    @ApiOperation(value = "检查重复", tags = {"VACLEAVETIPS" },  notes = "检查重复")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkrepeat")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkRepeat(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips = vacleavetipsService.checkRepeat(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }




    @PreAuthorize("hasPermission(#vacleavetips_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACLEAVETIPS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/{vacleavetips_id}")
    public ResponseEntity<VACLEAVETIPSDTO> get(@PathVariable("vacleavetips_id") String vacleavetips_id) {
        VACLEAVETIPS domain = vacleavetipsService.get(vacleavetips_id);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#vacleavetips_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACLEAVETIPS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> update(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
		VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacleavetipsid(vacleavetips_id);
		vacleavetipsService.update(domain);
		VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacleavetips_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACLEAVETIPS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.updateBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"VACLEAVETIPS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.save(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACLEAVETIPS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.saveBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEAVETIPS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavetips/fetchdefault")
	public ResponseEntity<List<VACLEAVETIPSDTO>> fetchDefault(VACLEAVETIPSSearchContext context) {
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
        List<VACLEAVETIPSDTO> list = vacleavetipsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEAVETIPS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavetips/searchdefault")
	public ResponseEntity<Page<VACLEAVETIPSDTO>> searchDefault(@RequestBody VACLEAVETIPSSearchContext context) {
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavetipsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACLEAVETIPS getEntity(){
        return new VACLEAVETIPS();
    }

}
