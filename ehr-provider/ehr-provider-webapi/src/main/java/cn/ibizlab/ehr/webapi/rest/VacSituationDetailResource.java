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
import cn.ibizlab.ehr.core.vac.domain.VacSituationDetail;
import cn.ibizlab.ehr.core.vac.service.IVacSituationDetailService;
import cn.ibizlab.ehr.core.vac.filter.VacSituationDetailSearchContext;

@Slf4j
@Api(tags = {"VacSituationDetail" })
@RestController("WebApi-vacsituationdetail")
@RequestMapping("")
public class VacSituationDetailResource {

    @Autowired
    public IVacSituationDetailService vacsituationdetailService;

    @Autowired
    @Lazy
    public VacSituationDetailMapping vacsituationdetailMapping;

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VacSituationDetail-Update')")
    @ApiOperation(value = "Update", tags = {"VacSituationDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<VacSituationDetailDTO> update(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id, @RequestBody VacSituationDetailDTO vacsituationdetaildto) {
		VacSituationDetail domain  = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
        domain .setVacsituationdetailid(vacsituationdetail_id);
		vacsituationdetailService.update(domain );
		VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByEntities(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos)),'ehr-VacSituationDetail-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacSituationDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.updateBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacSituationDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/getdraft")
    public ResponseEntity<VacSituationDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailMapping.toDto(vacsituationdetailService.getDraft(new VacSituationDetail())));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VacSituationDetail-Create')")
    @ApiOperation(value = "Create", tags = {"VacSituationDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails")
    @Transactional
    public ResponseEntity<VacSituationDetailDTO> create(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        VacSituationDetail domain = vacsituationdetailMapping.toDomain(vacsituationdetaildto);
		vacsituationdetailService.create(domain);
        VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VacSituationDetail-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacSituationDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.createBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(returnObject.body),'ehr-VacSituationDetail-Get')")
    @ApiOperation(value = "Get", tags = {"VacSituationDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsituationdetails/{vacsituationdetail_id}")
    public ResponseEntity<VacSituationDetailDTO> get(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
        VacSituationDetail domain = vacsituationdetailService.get(vacsituationdetail_id);
        VacSituationDetailDTO dto = vacsituationdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"VacSituationDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.checkKey(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildto),'ehr-VacSituationDetail-Save')")
    @ApiOperation(value = "Save", tags = {"VacSituationDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VacSituationDetailDTO vacsituationdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.save(vacsituationdetailMapping.toDomain(vacsituationdetaildto)));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailMapping.toDomain(#vacsituationdetaildtos),'ehr-VacSituationDetail-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacSituationDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsituationdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacSituationDetailDTO> vacsituationdetaildtos) {
        vacsituationdetailService.saveBatch(vacsituationdetailMapping.toDomain(vacsituationdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.get(#vacsituationdetail_id),'ehr-VacSituationDetail-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacSituationDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/{vacsituationdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsituationdetail_id") String vacsituationdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsituationdetailService.remove(vacsituationdetail_id));
    }

    @PreAuthorize("hasPermission(this.vacsituationdetailService.getVacsituationdetailByIds(#ids),'ehr-VacSituationDetail-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacSituationDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsituationdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsituationdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituationDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacSituationDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsituationdetails/fetchdefault")
	public ResponseEntity<List<VacSituationDetailDTO>> fetchDefault(VacSituationDetailSearchContext context) {
        Page<VacSituationDetail> domains = vacsituationdetailService.searchDefault(context) ;
        List<VacSituationDetailDTO> list = vacsituationdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSituationDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacSituationDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsituationdetails/searchdefault")
	public ResponseEntity<Page<VacSituationDetailDTO>> searchDefault(@RequestBody VacSituationDetailSearchContext context) {
        Page<VacSituationDetail> domains = vacsituationdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsituationdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

