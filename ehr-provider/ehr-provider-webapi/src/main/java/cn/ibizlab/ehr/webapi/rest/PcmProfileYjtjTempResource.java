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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileYjtjTemp;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileYjtjTempService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileYjtjTempSearchContext;

@Slf4j
@Api(tags = {"PcmProfileYjtjTemp" })
@RestController("WebApi-pcmprofileyjtjtemp")
@RequestMapping("")
public class PcmProfileYjtjTempResource {

    @Autowired
    public IPcmProfileYjtjTempService pcmprofileyjtjtempService;

    @Autowired
    @Lazy
    public PcmProfileYjtjTempMapping pcmprofileyjtjtempMapping;

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempService.get(#pcmprofileyjtjtemp_id),'ehr-PcmProfileYjtjTemp-Update')")
    @ApiOperation(value = "Update", tags = {"PcmProfileYjtjTemp" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    @Transactional
    public ResponseEntity<PcmProfileYjtjTempDTO> update(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id, @RequestBody PcmProfileYjtjTempDTO pcmprofileyjtjtempdto) {
		PcmProfileYjtjTemp domain  = pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto);
        domain .setPcmprofileyjtjtempid(pcmprofileyjtjtemp_id);
		pcmprofileyjtjtempService.update(domain );
		PcmProfileYjtjTempDTO dto = pcmprofileyjtjtempMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempService.getPcmprofileyjtjtempByEntities(this.pcmprofileyjtjtempMapping.toDomain(#pcmprofileyjtjtempdtos)),'ehr-PcmProfileYjtjTemp-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmProfileYjtjTemp" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileYjtjTempDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.updateBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmProfileYjtjTemp" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileyjtjtemps/getdraft")
    public ResponseEntity<PcmProfileYjtjTempDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempMapping.toDto(pcmprofileyjtjtempService.getDraft(new PcmProfileYjtjTemp())));
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempMapping.toDomain(#pcmprofileyjtjtempdto),'ehr-PcmProfileYjtjTemp-Create')")
    @ApiOperation(value = "Create", tags = {"PcmProfileYjtjTemp" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps")
    @Transactional
    public ResponseEntity<PcmProfileYjtjTempDTO> create(@RequestBody PcmProfileYjtjTempDTO pcmprofileyjtjtempdto) {
        PcmProfileYjtjTemp domain = pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto);
		pcmprofileyjtjtempService.create(domain);
        PcmProfileYjtjTempDTO dto = pcmprofileyjtjtempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempMapping.toDomain(#pcmprofileyjtjtempdtos),'ehr-PcmProfileYjtjTemp-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmProfileYjtjTemp" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileYjtjTempDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.createBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmProfileYjtjTemp" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileYjtjTempDTO pcmprofileyjtjtempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.checkKey(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempService.get(#pcmprofileyjtjtemp_id),'ehr-PcmProfileYjtjTemp-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmProfileYjtjTemp" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.remove(pcmprofileyjtjtemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempService.getPcmprofileyjtjtempByIds(#ids),'ehr-PcmProfileYjtjTemp-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmProfileYjtjTemp" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileyjtjtempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempMapping.toDomain(#pcmprofileyjtjtempdto),'ehr-PcmProfileYjtjTemp-Save')")
    @ApiOperation(value = "Save", tags = {"PcmProfileYjtjTemp" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileYjtjTempDTO pcmprofileyjtjtempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.save(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileyjtjtempMapping.toDomain(#pcmprofileyjtjtempdtos),'ehr-PcmProfileYjtjTemp-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmProfileYjtjTemp" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileYjtjTempDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.saveBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileyjtjtempMapping.toDomain(returnObject.body),'ehr-PcmProfileYjtjTemp-Get')")
    @ApiOperation(value = "Get", tags = {"PcmProfileYjtjTemp" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    public ResponseEntity<PcmProfileYjtjTempDTO> get(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id) {
        PcmProfileYjtjTemp domain = pcmprofileyjtjtempService.get(pcmprofileyjtjtemp_id);
        PcmProfileYjtjTempDTO dto = pcmprofileyjtjtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileYjtjTemp-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmProfileYjtjTemp" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileyjtjtemps/fetchdefault")
	public ResponseEntity<List<PcmProfileYjtjTempDTO>> fetchDefault(PcmProfileYjtjTempSearchContext context) {
        Page<PcmProfileYjtjTemp> domains = pcmprofileyjtjtempService.searchDefault(context) ;
        List<PcmProfileYjtjTempDTO> list = pcmprofileyjtjtempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileYjtjTemp-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmProfileYjtjTemp" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileyjtjtemps/searchdefault")
	public ResponseEntity<Page<PcmProfileYjtjTempDTO>> searchDefault(@RequestBody PcmProfileYjtjTempSearchContext context) {
        Page<PcmProfileYjtjTemp> domains = pcmprofileyjtjtempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileyjtjtempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

