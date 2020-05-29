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
import cn.ibizlab.ehr.core.orm.domain.OrmTitle;
import cn.ibizlab.ehr.core.orm.service.IOrmTitleService;
import cn.ibizlab.ehr.core.orm.filter.OrmTitleSearchContext;

@Slf4j
@Api(tags = {"OrmTitle" })
@RestController("WebApi-ormtitle")
@RequestMapping("")
public class OrmTitleResource {

    @Autowired
    public IOrmTitleService ormtitleService;

    @Autowired
    @Lazy
    public OrmTitleMapping ormtitleMapping;

    @PreAuthorize("hasPermission(this.ormtitleService.get(#ormtitle_id),'ehr-OrmTitle-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmTitle" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormtitles/{ormtitle_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormtitle_id") String ormtitle_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormtitleService.remove(ormtitle_id));
    }

    @PreAuthorize("hasPermission(this.ormtitleService.getOrmtitleByIds(#ids),'ehr-OrmTitle-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmTitle" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormtitleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormtitleService.get(#ormtitle_id),'ehr-OrmTitle-Update')")
    @ApiOperation(value = "Update", tags = {"OrmTitle" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormtitles/{ormtitle_id}")
    @Transactional
    public ResponseEntity<OrmTitleDTO> update(@PathVariable("ormtitle_id") String ormtitle_id, @RequestBody OrmTitleDTO ormtitledto) {
		OrmTitle domain  = ormtitleMapping.toDomain(ormtitledto);
        domain .setOrmtitleid(ormtitle_id);
		ormtitleService.update(domain );
		OrmTitleDTO dto = ormtitleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormtitleService.getOrmtitleByEntities(this.ormtitleMapping.toDomain(#ormtitledtos)),'ehr-OrmTitle-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmTitle" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmTitleDTO> ormtitledtos) {
        ormtitleService.updateBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmTitle" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormtitles/getdraft")
    public ResponseEntity<OrmTitleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormtitleMapping.toDto(ormtitleService.getDraft(new OrmTitle())));
    }

    @PreAuthorize("hasPermission(this.ormtitleMapping.toDomain(#ormtitledto),'ehr-OrmTitle-Save')")
    @ApiOperation(value = "Save", tags = {"OrmTitle" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmTitleDTO ormtitledto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormtitleService.save(ormtitleMapping.toDomain(ormtitledto)));
    }

    @PreAuthorize("hasPermission(this.ormtitleMapping.toDomain(#ormtitledtos),'ehr-OrmTitle-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmTitle" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmTitleDTO> ormtitledtos) {
        ormtitleService.saveBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmTitle" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmTitleDTO ormtitledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormtitleService.checkKey(ormtitleMapping.toDomain(ormtitledto)));
    }

    @PostAuthorize("hasPermission(this.ormtitleMapping.toDomain(returnObject.body),'ehr-OrmTitle-Get')")
    @ApiOperation(value = "Get", tags = {"OrmTitle" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormtitles/{ormtitle_id}")
    public ResponseEntity<OrmTitleDTO> get(@PathVariable("ormtitle_id") String ormtitle_id) {
        OrmTitle domain = ormtitleService.get(ormtitle_id);
        OrmTitleDTO dto = ormtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormtitleMapping.toDomain(#ormtitledto),'ehr-OrmTitle-Create')")
    @ApiOperation(value = "Create", tags = {"OrmTitle" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles")
    @Transactional
    public ResponseEntity<OrmTitleDTO> create(@RequestBody OrmTitleDTO ormtitledto) {
        OrmTitle domain = ormtitleMapping.toDomain(ormtitledto);
		ormtitleService.create(domain);
        OrmTitleDTO dto = ormtitleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormtitleMapping.toDomain(#ormtitledtos),'ehr-OrmTitle-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmTitle" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormtitles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmTitleDTO> ormtitledtos) {
        ormtitleService.createBatch(ormtitleMapping.toDomain(ormtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmTitle-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmTitle" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormtitles/fetchdefault")
	public ResponseEntity<List<OrmTitleDTO>> fetchDefault(OrmTitleSearchContext context) {
        Page<OrmTitle> domains = ormtitleService.searchDefault(context) ;
        List<OrmTitleDTO> list = ormtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmTitle-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmTitle" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormtitles/searchdefault")
	public ResponseEntity<Page<OrmTitleDTO>> searchDefault(@RequestBody OrmTitleSearchContext context) {
        Page<OrmTitle> domains = ormtitleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

