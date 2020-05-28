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
import cn.ibizlab.ehr.core.pim.domain.PIMPersonAbilityDetail;
import cn.ibizlab.ehr.core.pim.service.IPIMPersonAbilityDetailService;
import cn.ibizlab.ehr.core.pim.filter.PIMPersonAbilityDetailSearchContext;

@Slf4j
@Api(tags = {"PIMPersonAbilityDetail" })
@RestController("WebApi-pimpersonabilitydetail")
@RequestMapping("")
public class PIMPersonAbilityDetailResource {

    @Autowired
    public IPIMPersonAbilityDetailService pimpersonabilitydetailService;

    @Autowired
    @Lazy
    public PIMPersonAbilityDetailMapping pimpersonabilitydetailMapping;

    @ApiOperation(value = "CheckKey", tags = {"PIMPersonAbilityDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.checkKey(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildto),'ehr-PIMPersonAbilityDetail-Create')")
    @ApiOperation(value = "Create", tags = {"PIMPersonAbilityDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDetailDTO> create(@RequestBody PIMPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        PIMPersonAbilityDetail domain = pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto);
		pimpersonabilitydetailService.create(domain);
        PIMPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos),'ehr-PIMPersonAbilityDetail-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMPersonAbilityDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.createBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildto),'ehr-PIMPersonAbilityDetail-Save')")
    @ApiOperation(value = "Save", tags = {"PIMPersonAbilityDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPersonAbilityDetailDTO pimpersonabilitydetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.save(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos),'ehr-PIMPersonAbilityDetail-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPersonAbilityDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilitydetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.saveBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.get(#pimpersonabilitydetail_id),'ehr-PIMPersonAbilityDetail-Update')")
    @ApiOperation(value = "Update", tags = {"PIMPersonAbilityDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDetailDTO> update(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id, @RequestBody PIMPersonAbilityDetailDTO pimpersonabilitydetaildto) {
		PIMPersonAbilityDetail domain  = pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildto);
        domain .setPimpersonabilitydetailid(pimpersonabilitydetail_id);
		pimpersonabilitydetailService.update(domain );
		PIMPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.getPimpersonabilitydetailByEntities(this.pimpersonabilitydetailMapping.toDomain(#pimpersonabilitydetaildtos)),'ehr-PIMPersonAbilityDetail-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPersonAbilityDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPersonAbilityDetailDTO> pimpersonabilitydetaildtos) {
        pimpersonabilitydetailService.updateBatch(pimpersonabilitydetailMapping.toDomain(pimpersonabilitydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilitydetailMapping.toDomain(returnObject.body),'ehr-PIMPersonAbilityDetail-Get')")
    @ApiOperation(value = "Get", tags = {"PIMPersonAbilityDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    public ResponseEntity<PIMPersonAbilityDetailDTO> get(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id) {
        PIMPersonAbilityDetail domain = pimpersonabilitydetailService.get(pimpersonabilitydetail_id);
        PIMPersonAbilityDetailDTO dto = pimpersonabilitydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMPersonAbilityDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilitydetails/getdraft")
    public ResponseEntity<PIMPersonAbilityDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailMapping.toDto(pimpersonabilitydetailService.getDraft(new PIMPersonAbilityDetail())));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.get(#pimpersonabilitydetail_id),'ehr-PIMPersonAbilityDetail-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMPersonAbilityDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilitydetails/{pimpersonabilitydetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonabilitydetail_id") String pimpersonabilitydetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydetailService.remove(pimpersonabilitydetail_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilitydetailService.getPimpersonabilitydetailByIds(#ids),'ehr-PIMPersonAbilityDetail-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPersonAbilityDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilitydetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonabilitydetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbilityDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPersonAbilityDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonabilitydetails/fetchdefault")
	public ResponseEntity<List<PIMPersonAbilityDetailDTO>> fetchDefault(PIMPersonAbilityDetailSearchContext context) {
        Page<PIMPersonAbilityDetail> domains = pimpersonabilitydetailService.searchDefault(context) ;
        List<PIMPersonAbilityDetailDTO> list = pimpersonabilitydetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbilityDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPersonAbilityDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonabilitydetails/searchdefault")
	public ResponseEntity<Page<PIMPersonAbilityDetailDTO>> searchDefault(@RequestBody PIMPersonAbilityDetailSearchContext context) {
        Page<PIMPersonAbilityDetail> domains = pimpersonabilitydetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilitydetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

