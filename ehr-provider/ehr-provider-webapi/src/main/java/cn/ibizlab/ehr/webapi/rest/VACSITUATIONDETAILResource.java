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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.vac.domain.VACSITUATIONDETAIL;
import cn.ibizlab.ehr.core.vac.service.IVACSITUATIONDETAILService;
import cn.ibizlab.ehr.core.vac.filter.VACSITUATIONDETAILSearchContext;

@Slf4j
@Api(tags = {"VACSITUATIONDETAIL" })
@RestController("WebApi-vacsituationdetail")
@RequestMapping("")
public class VACSITUATIONDETAILResource {

    @Autowired
    public IVACSITUATIONDETAILService vacsituationdetailService;

    @Autowired
    @Lazy
    public VACSITUATIONDETAILMapping vacsituationdetailMapping;

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VACSITUATIONDETAIL-Update')")
    @ApiOperation(value = "Update", tags = {"VACSITUATIONDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<VACSITUATIONDETAILDTO> update(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id, @RequestBody VACSITUATIONDETAILDTO vacsituationdetaildto) {
		VACSITUATIONDETAIL domain  = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
        domain .setVacsituationdetailid(vacsituationdetail_id);
		vacsituationdetailService.update(domain );
		VACSITUATIONDETAILDTO dto = vacsituationdetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByEntities(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos)),'ehr-VACSITUATIONDETAIL-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACSITUATIONDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSITUATIONDETAILDTO> vacsituationdetaildtos) {
        vacsituationdetailService.updateBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VACSITUATIONDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/getdraft")
    public ResponseEntity<VACSITUATIONDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailMapping.toDto(vacsituationdetailService.getDraft(new VACSITUATIONDETAIL())));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VACSITUATIONDETAIL-Create')")
    @ApiOperation(value = "Create", tags = {"VACSITUATIONDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails")
    @Transactional
    public ResponseEntity<VACSITUATIONDETAILDTO> create(@RequestBody VACSITUATIONDETAILDTO vacsituationdetaildto) {
        VACSITUATIONDETAIL domain = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
		vacsituationdetailService.create(domain);
        VACSITUATIONDETAILDTO dto = vacsituationdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VACSITUATIONDETAIL-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACSITUATIONDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSITUATIONDETAILDTO> vacsituationdetaildtos) {
        vacsituationdetailService.createBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(returnObject.body),'ehr-VACSITUATIONDETAIL-Get')")
    @ApiOperation(value = "Get", tags = {"VACSITUATIONDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/{vacsituationdetail_id}")
    public ResponseEntity<VACSITUATIONDETAILDTO> get(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
        VACSITUATIONDETAIL domain = vacsituationdetailService.get(vacsituationdetail_id);
        VACSITUATIONDETAILDTO dto = vacsituationdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"VACSITUATIONDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSITUATIONDETAILDTO vacsituationdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.checkKey(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VACSITUATIONDETAIL-Save')")
    @ApiOperation(value = "Save", tags = {"VACSITUATIONDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSITUATIONDETAILDTO vacsituationdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.save(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VACSITUATIONDETAIL-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACSITUATIONDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSITUATIONDETAILDTO> vacsituationdetaildtos) {
        vacsituationdetailService.saveBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VACSITUATIONDETAIL-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACSITUATIONDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.remove(vacsituationdetail_id));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByIds(#ids),'ehr-VACSITUATIONDETAIL-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACSITUATIONDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsituationdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSITUATIONDETAIL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACSITUATIONDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsituationdetails/fetchdefault")
	public ResponseEntity<List<VACSITUATIONDETAILDTO>> fetchDefault(VACSITUATIONDETAILSearchContext context) {
        Page<VACSITUATIONDETAIL> domains = vacsituationdetailService.searchDefault(context) ;
        List<VACSITUATIONDETAILDTO> list = vacsituationdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSITUATIONDETAIL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACSITUATIONDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsituationdetails/searchdefault")
	public ResponseEntity<Page<VACSITUATIONDETAILDTO>> searchDefault(@RequestBody VACSITUATIONDETAILSearchContext context) {
        Page<VACSITUATIONDETAIL> domains = vacsituationdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsituationdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

