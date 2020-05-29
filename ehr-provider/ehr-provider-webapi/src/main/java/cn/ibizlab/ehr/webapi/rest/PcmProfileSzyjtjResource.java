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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileSzyjtjService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSzyjtjSearchContext;

@Slf4j
@Api(tags = {"PcmProfileSzyjtj" })
@RestController("WebApi-pcmprofileszyjtj")
@RequestMapping("")
public class PcmProfileSzyjtjResource {

    @Autowired
    public IPcmProfileSzyjtjService pcmprofileszyjtjService;

    @Autowired
    @Lazy
    public PcmProfileSzyjtjMapping pcmprofileszyjtjMapping;

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdto),'ehr-PcmProfileSzyjtj-Save')")
    @ApiOperation(value = "Save", tags = {"PcmProfileSzyjtj" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.save(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos),'ehr-PcmProfileSzyjtj-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmProfileSzyjtj" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.saveBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdto),'ehr-PcmProfileSzyjtj-Create')")
    @ApiOperation(value = "Create", tags = {"PcmProfileSzyjtj" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs")
    @Transactional
    public ResponseEntity<PcmProfileSzyjtjDTO> create(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        PcmProfileSzyjtj domain = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
		pcmprofileszyjtjService.create(domain);
        PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos),'ehr-PcmProfileSzyjtj-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmProfileSzyjtj" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.createBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmProfileSzyjtj" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/getdraft")
    public ResponseEntity<PcmProfileSzyjtjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjMapping.toDto(pcmprofileszyjtjService.getDraft(new PcmProfileSzyjtj())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmProfileSzyjtj" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.checkKey(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.get(#pcmprofileszyjtj_id),'ehr-PcmProfileSzyjtj-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmProfileSzyjtj" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.remove(pcmprofileszyjtj_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.getPcmprofileszyjtjByIds(#ids),'ehr-PcmProfileSzyjtj-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmProfileSzyjtj" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileszyjtjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(returnObject.body),'ehr-PcmProfileSzyjtj-Get')")
    @ApiOperation(value = "Get", tags = {"PcmProfileSzyjtj" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    public ResponseEntity<PcmProfileSzyjtjDTO> get(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
        PcmProfileSzyjtj domain = pcmprofileszyjtjService.get(pcmprofileszyjtj_id);
        PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.get(#pcmprofileszyjtj_id),'ehr-PcmProfileSzyjtj-Update')")
    @ApiOperation(value = "Update", tags = {"PcmProfileSzyjtj" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<PcmProfileSzyjtjDTO> update(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id, @RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
		PcmProfileSzyjtj domain  = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
        domain .setPcmprofileszyjtjid(pcmprofileszyjtj_id);
		pcmprofileszyjtjService.update(domain );
		PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.getPcmprofileszyjtjByEntities(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos)),'ehr-PcmProfileSzyjtj-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmProfileSzyjtj" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.updateBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmProfileSzyjtj" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchdefault")
	public ResponseEntity<List<PcmProfileSzyjtjDTO>> fetchDefault(PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchDefault(context) ;
        List<PcmProfileSzyjtjDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmProfileSzyjtj" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchdefault")
	public ResponseEntity<Page<PcmProfileSzyjtjDTO>> searchDefault(@RequestBody PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-YGLX-all')")
	@ApiOperation(value = "fetch通过申报类型过滤", tags = {"PcmProfileSzyjtj" } ,notes = "fetch通过申报类型过滤")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchyglx")
	public ResponseEntity<List<PcmProfileSzyjtjDTO>> fetchYGLX(PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchYGLX(context) ;
        List<PcmProfileSzyjtjDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-YGLX-all')")
	@ApiOperation(value = "search通过申报类型过滤", tags = {"PcmProfileSzyjtj" } ,notes = "search通过申报类型过滤")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchyglx")
	public ResponseEntity<Page<PcmProfileSzyjtjDTO>> searchYGLX(@RequestBody PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchYGLX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

