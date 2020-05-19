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
import cn.ibizlab.ehr.core.orm.domain.ORMTITLE;
import cn.ibizlab.ehr.core.orm.service.IORMTITLEService;
import cn.ibizlab.ehr.core.orm.filter.ORMTITLESearchContext;




@Slf4j
@Api(tags = {"ORMTITLE" })
@RestController("WebApi-ormtitle")
@RequestMapping("")
public class ORMTITLEResource {

    @Autowired
    private IORMTITLEService ormtitleService;

    @Autowired
    @Lazy
    private ORMTITLEMapping ormtitleMapping;




    @PreAuthorize("hasPermission('Remove',{#ormtitle_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMTITLE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormtitles/{ormtitle_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormtitle_id") String ormtitle_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormtitleService.remove(ormtitle_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMTITLE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormtitleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormtitle_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMTITLE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormtitles/{ormtitle_id}")
    @Transactional
    public ResponseEntity<ORMTITLEDTO> update(@PathVariable("ormtitle_id") String ormtitle_id, @RequestBody ORMTITLEDTO ormtitledto) {
		ORMTITLE domain = ormtitleMapping.toDomain(ormtitledto);
        domain.setOrmtitleid(ormtitle_id);
		ormtitleService.update(domain);
		ORMTITLEDTO dto = ormtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormtitle_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMTITLE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMTITLEDTO> ormtitledtos) {
        ormtitleService.updateBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMTITLE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormtitles/getdraft")
    public ResponseEntity<ORMTITLEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormtitleMapping.toDto(ormtitleService.getDraft(new ORMTITLE())));
    }




    @ApiOperation(value = "Save", tags = {"ORMTITLE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMTITLEDTO ormtitledto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormtitleService.save(ormtitleMapping.toDomain(ormtitledto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMTITLE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMTITLEDTO> ormtitledtos) {
        ormtitleService.saveBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMTITLE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMTITLEDTO ormtitledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormtitleService.checkKey(ormtitleMapping.toDomain(ormtitledto)));
    }




    @PreAuthorize("hasPermission(#ormtitle_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMTITLE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormtitles/{ormtitle_id}")
    public ResponseEntity<ORMTITLEDTO> get(@PathVariable("ormtitle_id") String ormtitle_id) {
        ORMTITLE domain = ormtitleService.get(ormtitle_id);
        ORMTITLEDTO dto = ormtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMTITLE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles")
    @Transactional
    public ResponseEntity<ORMTITLEDTO> create(@RequestBody ORMTITLEDTO ormtitledto) {
        ORMTITLE domain = ormtitleMapping.toDomain(ormtitledto);
		ormtitleService.create(domain);
        ORMTITLEDTO dto = ormtitleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMTITLE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMTITLEDTO> ormtitledtos) {
        ormtitleService.createBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMTITLE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormtitles/fetchdefault")
	public ResponseEntity<List<ORMTITLEDTO>> fetchDefault(ORMTITLESearchContext context) {
        Page<ORMTITLE> domains = ormtitleService.searchDefault(context) ;
        List<ORMTITLEDTO> list = ormtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMTITLE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormtitles/searchdefault")
	public ResponseEntity<Page<ORMTITLEDTO>> searchDefault(ORMTITLESearchContext context) {
        Page<ORMTITLE> domains = ormtitleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMTITLE getEntity(){
        return new ORMTITLE();
    }

}
