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
import cn.ibizlab.ehr.core.pcm.domain.PCMGXXKTEMP;
import cn.ibizlab.ehr.core.pcm.service.IPCMGXXKTEMPService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXXKTEMPSearchContext;




@Slf4j
@Api(tags = {"PCMGXXKTEMP" })
@RestController("WebApi-pcmgxxktemp")
@RequestMapping("")
public class PCMGXXKTEMPResource {

    @Autowired
    private IPCMGXXKTEMPService pcmgxxktempService;

    @Autowired
    @Lazy
    private PCMGXXKTEMPMapping pcmgxxktempMapping;




    @ApiOperation(value = "GetDraft", tags = {"PCMGXXKTEMP" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGXXKTEMPDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(new PCMGXXKTEMP())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMGXXKTEMP" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> create(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
		pcmgxxktempService.create(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMGXXKTEMP" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.createBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmgxxktemp_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMGXXKTEMP" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMGXXKTEMP" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMGXXKTEMP" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMGXXKTEMP" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMGXXKTEMP" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.saveBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMGXXKTEMP" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGXXKTEMPDTO> get(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGXXKTEMP domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMGXXKTEMP" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> update(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
		PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
		PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMGXXKTEMP" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.updateBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMGXXKTEMP" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGXXKTEMPDTO>> fetchDefault(PCMGXXKTEMPSearchContext context) {
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGXXKTEMPDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PCMGXXKTEMP" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGXXKTEMPDTO>> searchDefault(@RequestBody PCMGXXKTEMPSearchContext context) {
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMGXXKTEMP getEntity(){
        return new PCMGXXKTEMP();
    }

}
