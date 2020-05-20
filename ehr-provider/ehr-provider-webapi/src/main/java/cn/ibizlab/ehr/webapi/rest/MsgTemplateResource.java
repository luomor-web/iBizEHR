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
import cn.ibizlab.ehr.core.common.domain.MsgTemplate;
import cn.ibizlab.ehr.core.common.service.IMsgTemplateService;
import cn.ibizlab.ehr.core.common.filter.MsgTemplateSearchContext;




@Slf4j
@Api(tags = {"MsgTemplate" })
@RestController("WebApi-msgtemplate")
@RequestMapping("")
public class MsgTemplateResource {

    @Autowired
    private IMsgTemplateService msgtemplateService;

    @Autowired
    @Lazy
    private MsgTemplateMapping msgtemplateMapping;




    @ApiOperation(value = "GetDraft", tags = {"MsgTemplate" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/getdraft")
    public ResponseEntity<MsgTemplateDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(msgtemplateMapping.toDto(msgtemplateService.getDraft(new MsgTemplate())));
    }




    @PreAuthorize("hasPermission(#msgtemplate_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"MsgTemplate" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/{msgtemplate_id}")
    @Transactional
    public ResponseEntity<MsgTemplateDTO> update(@PathVariable("msgtemplate_id") String msgtemplate_id, @RequestBody MsgTemplateDTO msgtemplatedto) {
		MsgTemplate domain = msgtemplateMapping.toDomain(msgtemplatedto);
        domain.setMsgtemplateid(msgtemplate_id);
		msgtemplateService.update(domain);
		MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#msgtemplate_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"MsgTemplate" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.updateBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#msgtemplate_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"MsgTemplate" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/{msgtemplate_id}")
    public ResponseEntity<MsgTemplateDTO> get(@PathVariable("msgtemplate_id") String msgtemplate_id) {
        MsgTemplate domain = msgtemplateService.get(msgtemplate_id);
        MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"MsgTemplate" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates")
    @Transactional
    public ResponseEntity<MsgTemplateDTO> create(@RequestBody MsgTemplateDTO msgtemplatedto) {
        MsgTemplate domain = msgtemplateMapping.toDomain(msgtemplatedto);
		msgtemplateService.create(domain);
        MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"MsgTemplate" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.createBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"MsgTemplate" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgTemplateDTO msgtemplatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgtemplateService.checkKey(msgtemplateMapping.toDomain(msgtemplatedto)));
    }




    @PreAuthorize("hasPermission(#msgtemplate_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"MsgTemplate" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/{msgtemplate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("msgtemplate_id") String msgtemplate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgtemplateService.remove(msgtemplate_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"MsgTemplate" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgtemplateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"MsgTemplate" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgTemplateDTO msgtemplatedto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgtemplateService.save(msgtemplateMapping.toDomain(msgtemplatedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"MsgTemplate" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.saveBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgTemplate-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"MsgTemplate" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgtemplates/fetchdefault")
	public ResponseEntity<List<MsgTemplateDTO>> fetchDefault(MsgTemplateSearchContext context) {
        Page<MsgTemplate> domains = msgtemplateService.searchDefault(context) ;
        List<MsgTemplateDTO> list = msgtemplateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgTemplate-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"MsgTemplate" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgtemplates/searchdefault")
	public ResponseEntity<Page<MsgTemplateDTO>> searchDefault(@RequestBody MsgTemplateSearchContext context) {
        Page<MsgTemplate> domains = msgtemplateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgtemplateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public MsgTemplate getEntity(){
        return new MsgTemplate();
    }

}
