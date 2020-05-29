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
import cn.ibizlab.ehr.core.vac.domain.VacDayOff;
import cn.ibizlab.ehr.core.vac.service.IVacDayOffService;
import cn.ibizlab.ehr.core.vac.filter.VacDayOffSearchContext;

@Slf4j
@Api(tags = {"VacDayOff" })
@RestController("WebApi-vacdayoff")
@RequestMapping("")
public class VacDayOffResource {

    @Autowired
    public IVacDayOffService vacdayoffService;

    @Autowired
    @Lazy
    public VacDayOffMapping vacdayoffMapping;

    @PostAuthorize("hasPermission(this.vacdayoffMapping.toDomain(returnObject.body),'ehr-VacDayOff-Get')")
    @ApiOperation(value = "Get", tags = {"VacDayOff" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacdayoffs/{vacdayoff_id}")
    public ResponseEntity<VacDayOffDTO> get(@PathVariable("vacdayoff_id") String vacdayoff_id) {
        VacDayOff domain = vacdayoffService.get(vacdayoff_id);
        VacDayOffDTO dto = vacdayoffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacDayOff" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacdayoffs/getdraft")
    public ResponseEntity<VacDayOffDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacdayoffMapping.toDto(vacdayoffService.getDraft(new VacDayOff())));
    }

    @ApiOperation(value = "CheckKey", tags = {"VacDayOff" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacDayOffDTO vacdayoffdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.checkKey(vacdayoffMapping.toDomain(vacdayoffdto)));
    }

    @PreAuthorize("hasPermission(this.vacdayoffMapping.toDomain(#vacdayoffdto),'ehr-VacDayOff-Save')")
    @ApiOperation(value = "Save", tags = {"VacDayOff" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/save")
    public ResponseEntity<Boolean> save(@RequestBody VacDayOffDTO vacdayoffdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.save(vacdayoffMapping.toDomain(vacdayoffdto)));
    }

    @PreAuthorize("hasPermission(this.vacdayoffMapping.toDomain(#vacdayoffdtos),'ehr-VacDayOff-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacDayOff" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacDayOffDTO> vacdayoffdtos) {
        vacdayoffService.saveBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacdayoffMapping.toDomain(#vacdayoffdto),'ehr-VacDayOff-Create')")
    @ApiOperation(value = "Create", tags = {"VacDayOff" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs")
    @Transactional
    public ResponseEntity<VacDayOffDTO> create(@RequestBody VacDayOffDTO vacdayoffdto) {
        VacDayOff domain = vacdayoffMapping.toDomain(vacdayoffdto);
		vacdayoffService.create(domain);
        VacDayOffDTO dto = vacdayoffMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacdayoffMapping.toDomain(#vacdayoffdtos),'ehr-VacDayOff-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacDayOff" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacDayOffDTO> vacdayoffdtos) {
        vacdayoffService.createBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacdayoffService.get(#vacdayoff_id),'ehr-VacDayOff-Update')")
    @ApiOperation(value = "Update", tags = {"VacDayOff" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacdayoffs/{vacdayoff_id}")
    @Transactional
    public ResponseEntity<VacDayOffDTO> update(@PathVariable("vacdayoff_id") String vacdayoff_id, @RequestBody VacDayOffDTO vacdayoffdto) {
		VacDayOff domain  = vacdayoffMapping.toDomain(vacdayoffdto);
        domain .setVacdayoffid(vacdayoff_id);
		vacdayoffService.update(domain );
		VacDayOffDTO dto = vacdayoffMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacdayoffService.getVacdayoffByEntities(this.vacdayoffMapping.toDomain(#vacdayoffdtos)),'ehr-VacDayOff-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacDayOff" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacDayOffDTO> vacdayoffdtos) {
        vacdayoffService.updateBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacdayoffService.get(#vacdayoff_id),'ehr-VacDayOff-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacDayOff" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacdayoffs/{vacdayoff_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacdayoff_id") String vacdayoff_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.remove(vacdayoff_id));
    }

    @PreAuthorize("hasPermission(this.vacdayoffService.getVacdayoffByIds(#ids),'ehr-VacDayOff-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacDayOff" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacdayoffService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacDayOff-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacDayOff" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacdayoffs/fetchdefault")
	public ResponseEntity<List<VacDayOffDTO>> fetchDefault(VacDayOffSearchContext context) {
        Page<VacDayOff> domains = vacdayoffService.searchDefault(context) ;
        List<VacDayOffDTO> list = vacdayoffMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacDayOff-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacDayOff" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacdayoffs/searchdefault")
	public ResponseEntity<Page<VacDayOffDTO>> searchDefault(@RequestBody VacDayOffSearchContext context) {
        Page<VacDayOff> domains = vacdayoffService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacdayoffMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

