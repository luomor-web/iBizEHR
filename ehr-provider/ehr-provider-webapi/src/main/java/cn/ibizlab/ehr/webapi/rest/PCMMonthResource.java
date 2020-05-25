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
import cn.ibizlab.ehr.core.pcm.domain.PCMMonth;
import cn.ibizlab.ehr.core.pcm.service.IPCMMonthService;
import cn.ibizlab.ehr.core.pcm.filter.PCMMonthSearchContext;

@Slf4j
@Api(tags = {"PCMMonth" })
@RestController("WebApi-pcmmonth")
@RequestMapping("")
public class PCMMonthResource {

    @Autowired
    private IPCMMonthService pcmmonthService;

    @Autowired
    @Lazy
    public PCMMonthMapping pcmmonthMapping;

    public PCMMonthDTO permissionDTO=new PCMMonthDTO();

    @PreAuthorize("hasPermission(#pcmmonth_id,'Update',{'Sql',this.pcmmonthMapping,#pcmmonthdto})")
    @ApiOperation(value = "Update", tags = {"PCMMonth" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmonths/{pcmmonth_id}")
    @Transactional
    public ResponseEntity<PCMMonthDTO> update(@PathVariable("pcmmonth_id") String pcmmonth_id, @RequestBody PCMMonthDTO pcmmonthdto) {
		PCMMonth domain = pcmmonthMapping.toDomain(pcmmonthdto);
        domain.setPcmmonthid(pcmmonth_id);
		pcmmonthService.update(domain);
		PCMMonthDTO dto = pcmmonthMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMMonth" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMMonthDTO> pcmmonthdtos) {
        pcmmonthService.updateBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmmonth_id,'Remove',{'Sql',this.pcmmonthMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMMonth" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmonths/{pcmmonth_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmmonth_id") String pcmmonth_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.remove(pcmmonth_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMMonth" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmmonthService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmmonthMapping,#pcmmonthdto})")
    @ApiOperation(value = "Save", tags = {"PCMMonth" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMMonthDTO pcmmonthdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.save(pcmmonthMapping.toDomain(pcmmonthdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMMonth" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMMonthDTO> pcmmonthdtos) {
        pcmmonthService.saveBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmmonthMapping,#pcmmonthdto})")
    @ApiOperation(value = "Create", tags = {"PCMMonth" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths")
    @Transactional
    public ResponseEntity<PCMMonthDTO> create(@RequestBody PCMMonthDTO pcmmonthdto) {
        PCMMonth domain = pcmmonthMapping.toDomain(pcmmonthdto);
		pcmmonthService.create(domain);
        PCMMonthDTO dto = pcmmonthMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMMonth" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMMonthDTO> pcmmonthdtos) {
        pcmmonthService.createBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMonth-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMMonth" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMMonthDTO pcmmonthdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.checkKey(pcmmonthMapping.toDomain(pcmmonthdto)));
    }

    @PreAuthorize("hasPermission(#pcmmonth_id,'Get',{'Sql',this.pcmmonthMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMMonth" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmonths/{pcmmonth_id}")
    public ResponseEntity<PCMMonthDTO> get(@PathVariable("pcmmonth_id") String pcmmonth_id) {
        PCMMonth domain = pcmmonthService.get(pcmmonth_id);
        PCMMonthDTO dto = pcmmonthMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMonth-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMMonth" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmonths/getdraft")
    public ResponseEntity<PCMMonthDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmonthMapping.toDto(pcmmonthService.getDraft(new PCMMonth())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMonth-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMMonth" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmmonths/fetchdefault")
	public ResponseEntity<List<PCMMonthDTO>> fetchDefault(PCMMonthSearchContext context) {
        Page<PCMMonth> domains = pcmmonthService.searchDefault(context) ;
        List<PCMMonthDTO> list = pcmmonthMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMonth-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMMonth" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmmonths/searchdefault")
	public ResponseEntity<Page<PCMMonthDTO>> searchDefault(@RequestBody PCMMonthSearchContext context) {
        Page<PCMMonth> domains = pcmmonthService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmmonthMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
