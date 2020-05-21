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
import cn.ibizlab.ehr.core.common.domain.PVPart;
import cn.ibizlab.ehr.core.common.service.IPVPartService;
import cn.ibizlab.ehr.core.common.filter.PVPartSearchContext;




@Slf4j
@Api(tags = {"PVPart" })
@RestController("WebApi-pvpart")
@RequestMapping("")
public class PVPartResource {

    @Autowired
    private IPVPartService pvpartService;

    @Autowired
    @Lazy
    public PVPartMapping pvpartMapping;

    public PVPartDTO permissionDTO=new PVPartDTO();




    @PreAuthorize("hasPermission(#pvpart_id,'Update',{'Sql',this.pvpartMapping,#pvpartdto})")
    @ApiOperation(value = "Update", tags = {"PVPart" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pvparts/{pvpart_id}")
    @Transactional
    public ResponseEntity<PVPartDTO> update(@PathVariable("pvpart_id") String pvpart_id, @RequestBody PVPartDTO pvpartdto) {
		PVPart domain = pvpartMapping.toDomain(pvpartdto);
        domain.setPvpartid(pvpart_id);
		pvpartService.update(domain);
		PVPartDTO dto = pvpartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PVPart" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pvparts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PVPartDTO> pvpartdtos) {
        pvpartService.updateBatch(pvpartMapping.toDomain(pvpartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pvpart_id,'Get',{'Sql',this.pvpartMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PVPart" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pvparts/{pvpart_id}")
    public ResponseEntity<PVPartDTO> get(@PathVariable("pvpart_id") String pvpart_id) {
        PVPart domain = pvpartService.get(pvpart_id);
        PVPartDTO dto = pvpartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PVPart" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pvparts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PVPartDTO pvpartdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pvpartService.checkKey(pvpartMapping.toDomain(pvpartdto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PVPart" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pvparts/getdraft")
    public ResponseEntity<PVPartDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pvpartMapping.toDto(pvpartService.getDraft(new PVPart())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-Save-all')")
    @ApiOperation(value = "Save", tags = {"PVPart" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pvparts/save")
    public ResponseEntity<Boolean> save(@RequestBody PVPartDTO pvpartdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pvpartService.save(pvpartMapping.toDomain(pvpartdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PVPart" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pvparts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PVPartDTO> pvpartdtos) {
        pvpartService.saveBatch(pvpartMapping.toDomain(pvpartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pvpart_id,'Remove',{'Sql',this.pvpartMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PVPart" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pvparts/{pvpart_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pvpart_id") String pvpart_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pvpartService.remove(pvpart_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PVPart" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pvparts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pvpartService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pvpartMapping,#pvpartdto})")
    @ApiOperation(value = "Create", tags = {"PVPart" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pvparts")
    @Transactional
    public ResponseEntity<PVPartDTO> create(@RequestBody PVPartDTO pvpartdto) {
        PVPart domain = pvpartMapping.toDomain(pvpartdto);
		pvpartService.create(domain);
        PVPartDTO dto = pvpartMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PVPart" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pvparts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PVPartDTO> pvpartdtos) {
        pvpartService.createBatch(pvpartMapping.toDomain(pvpartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PVPart" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pvparts/fetchdefault")
	public ResponseEntity<List<PVPartDTO>> fetchDefault(PVPartSearchContext context) {
        Page<PVPart> domains = pvpartService.searchDefault(context) ;
        List<PVPartDTO> list = pvpartMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PVPart" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pvparts/searchdefault")
	public ResponseEntity<Page<PVPartDTO>> searchDefault(@RequestBody PVPartSearchContext context) {
        Page<PVPart> domains = pvpartService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pvpartMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-CurPV-all')")
	@ApiOperation(value = "fetch当前门户视图", tags = {"PVPart" } ,notes = "fetch当前门户视图")
    @RequestMapping(method= RequestMethod.GET , value="/pvparts/fetchcurpv")
	public ResponseEntity<List<PVPartDTO>> fetchCurPV(PVPartSearchContext context) {
        Page<PVPart> domains = pvpartService.searchCurPV(context) ;
        List<PVPartDTO> list = pvpartMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PVPart-CurPV-all')")
	@ApiOperation(value = "search当前门户视图", tags = {"PVPart" } ,notes = "search当前门户视图")
    @RequestMapping(method= RequestMethod.POST , value="/pvparts/searchcurpv")
	public ResponseEntity<Page<PVPartDTO>> searchCurPV(@RequestBody PVPartSearchContext context) {
        Page<PVPart> domains = pvpartService.searchCurPV(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pvpartMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


