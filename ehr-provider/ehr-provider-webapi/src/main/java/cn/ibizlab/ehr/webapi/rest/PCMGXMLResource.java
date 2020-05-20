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
import cn.ibizlab.ehr.core.pcm.domain.PCMGXML;
import cn.ibizlab.ehr.core.pcm.service.IPCMGXMLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXMLSearchContext;




@Slf4j
@Api(tags = {"PCMGXML" })
@RestController("WebApi-pcmgxml")
@RequestMapping("")
public class PCMGXMLResource {

    @Autowired
    private IPCMGXMLService pcmgxmlService;

    @Autowired
    @Lazy
    private PCMGXMLMapping pcmgxmlMapping;




    @PreAuthorize("hasPermission(#pcmgxml_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMGXML" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}")
    @Transactional
    public ResponseEntity<PCMGXMLDTO> update(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGXMLDTO pcmgxmldto) {
		PCMGXML domain = pcmgxmlMapping.toDomain(pcmgxmldto);
        domain.setPcmgxmlid(pcmgxml_id);
		pcmgxmlService.update(domain);
		PCMGXMLDTO dto = pcmgxmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmgxml_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMGXML" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGXMLDTO> pcmgxmldtos) {
        pcmgxmlService.updateBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMGXML" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGXMLDTO pcmgxmldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.save(pcmgxmlMapping.toDomain(pcmgxmldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMGXML" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGXMLDTO> pcmgxmldtos) {
        pcmgxmlService.saveBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMGXML" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/getdraft")
    public ResponseEntity<PCMGXMLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlMapping.toDto(pcmgxmlService.getDraft(new PCMGXML())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMGXML" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGXMLDTO pcmgxmldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.checkKey(pcmgxmlMapping.toDomain(pcmgxmldto)));
    }




    @PreAuthorize("hasPermission(#pcmgxml_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMGXML" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}")
    public ResponseEntity<PCMGXMLDTO> get(@PathVariable("pcmgxml_id") String pcmgxml_id) {
        PCMGXML domain = pcmgxmlService.get(pcmgxml_id);
        PCMGXMLDTO dto = pcmgxmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMGXML" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls")
    @Transactional
    public ResponseEntity<PCMGXMLDTO> create(@RequestBody PCMGXMLDTO pcmgxmldto) {
        PCMGXML domain = pcmgxmlMapping.toDomain(pcmgxmldto);
		pcmgxmlService.create(domain);
        PCMGXMLDTO dto = pcmgxmlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMGXML" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGXMLDTO> pcmgxmldtos) {
        pcmgxmlService.createBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmgxml_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMGXML" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxml_id") String pcmgxml_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.remove(pcmgxml_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMGXML" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxmlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXML-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMGXML" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/fetchdefault")
	public ResponseEntity<List<PCMGXMLDTO>> fetchDefault(PCMGXMLSearchContext context) {
        Page<PCMGXML> domains = pcmgxmlService.searchDefault(context) ;
        List<PCMGXMLDTO> list = pcmgxmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXML-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMGXML" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/searchdefault")
	public ResponseEntity<Page<PCMGXMLDTO>> searchDefault(@RequestBody PCMGXMLSearchContext context) {
        Page<PCMGXML> domains = pcmgxmlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXML-CurND-all')")
	@ApiOperation(value = "fetch当前年度高校名录", tags = {"PCMGXML" } ,notes = "fetch当前年度高校名录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/fetchcurnd")
	public ResponseEntity<List<PCMGXMLDTO>> fetchCurND(PCMGXMLSearchContext context) {
        Page<PCMGXML> domains = pcmgxmlService.searchCurND(context) ;
        List<PCMGXMLDTO> list = pcmgxmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXML-CurND-all')")
	@ApiOperation(value = "search当前年度高校名录", tags = {"PCMGXML" } ,notes = "search当前年度高校名录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/searchcurnd")
	public ResponseEntity<Page<PCMGXMLDTO>> searchCurND(@RequestBody PCMGXMLSearchContext context) {
        Page<PCMGXML> domains = pcmgxmlService.searchCurND(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMGXML getEntity(){
        return new PCMGXML();
    }

}
