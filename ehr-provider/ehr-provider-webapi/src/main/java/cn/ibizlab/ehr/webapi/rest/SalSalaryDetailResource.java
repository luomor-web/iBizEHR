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
import cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail;
import cn.ibizlab.ehr.core.sal.service.ISalSalaryDetailService;
import cn.ibizlab.ehr.core.sal.filter.SalSalaryDetailSearchContext;

@Slf4j
@Api(tags = {"SalSalaryDetail" })
@RestController("WebApi-salsalarydetail")
@RequestMapping("")
public class SalSalaryDetailResource {

    @Autowired
    public ISalSalaryDetailService salsalarydetailService;

    @Autowired
    @Lazy
    public SalSalaryDetailMapping salsalarydetailMapping;

    @PreAuthorize("hasPermission(this.salsalarydetailService.get(#salsalarydetail_id),'ehr-SalSalaryDetail-Update')")
    @ApiOperation(value = "Update", tags = {"SalSalaryDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<SalSalaryDetailDTO> update(@PathVariable("salsalarydetail_id") String salsalarydetail_id, @RequestBody SalSalaryDetailDTO salsalarydetaildto) {
		SalSalaryDetail domain  = salsalarydetailMapping.toDomain(salsalarydetaildto);
        domain .setSalsalarydetailid(salsalarydetail_id);
		salsalarydetailService.update(domain );
		SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.getSalsalarydetailByEntities(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos)),'ehr-SalSalaryDetail-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalSalaryDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.updateBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildto),'ehr-SalSalaryDetail-Create')")
    @ApiOperation(value = "Create", tags = {"SalSalaryDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails")
    @Transactional
    public ResponseEntity<SalSalaryDetailDTO> create(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        SalSalaryDetail domain = salsalarydetailMapping.toDomain(salsalarydetaildto);
		salsalarydetailService.create(domain);
        SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos),'ehr-SalSalaryDetail-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalSalaryDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.createBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalSalaryDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/getdraft")
    public ResponseEntity<SalSalaryDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailMapping.toDto(salsalarydetailService.getDraft(new SalSalaryDetail())));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.get(#salsalarydetail_id),'ehr-SalSalaryDetail-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalSalaryDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.remove(salsalarydetail_id));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailService.getSalsalarydetailByIds(#ids),'ehr-SalSalaryDetail-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalSalaryDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalarydetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(returnObject.body),'ehr-SalSalaryDetail-Get')")
    @ApiOperation(value = "Get", tags = {"SalSalaryDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/{salsalarydetail_id}")
    public ResponseEntity<SalSalaryDetailDTO> get(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
        SalSalaryDetail domain = salsalarydetailService.get(salsalarydetail_id);
        SalSalaryDetailDTO dto = salsalarydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalSalaryDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.checkKey(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildto),'ehr-SalSalaryDetail-Save')")
    @ApiOperation(value = "Save", tags = {"SalSalaryDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSalaryDetailDTO salsalarydetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.save(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }

    @PreAuthorize("hasPermission(this.salsalarydetailMapping.toDomain(#salsalarydetaildtos),'ehr-SalSalaryDetail-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalSalaryDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSalaryDetailDTO> salsalarydetaildtos) {
        salsalarydetailService.saveBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalSalaryDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarydetails/fetchdefault")
	public ResponseEntity<List<SalSalaryDetailDTO>> fetchDefault(SalSalaryDetailSearchContext context) {
        Page<SalSalaryDetail> domains = salsalarydetailService.searchDefault(context) ;
        List<SalSalaryDetailDTO> list = salsalarydetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSalaryDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalSalaryDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalarydetails/searchdefault")
	public ResponseEntity<Page<SalSalaryDetailDTO>> searchDefault(@RequestBody SalSalaryDetailSearchContext context) {
        Page<SalSalaryDetail> domains = salsalarydetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalarydetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

