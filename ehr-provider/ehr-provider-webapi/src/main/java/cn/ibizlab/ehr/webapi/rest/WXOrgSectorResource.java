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
import cn.ibizlab.ehr.core.wx.domain.WXOrgSector;
import cn.ibizlab.ehr.core.wx.service.IWXOrgSectorService;
import cn.ibizlab.ehr.core.wx.filter.WXOrgSectorSearchContext;




@Slf4j
@Api(tags = {"WXOrgSector" })
@RestController("WebApi-wxorgsector")
@RequestMapping("")
public class WXOrgSectorResource {

    @Autowired
    private IWXOrgSectorService wxorgsectorService;

    @Autowired
    @Lazy
    private WXOrgSectorMapping wxorgsectorMapping;




    @PreAuthorize("hasPermission(#wxorgsector_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WXOrgSector" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxorgsectors/{wxorgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxorgsector_id") String wxorgsector_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxorgsectorService.remove(wxorgsector_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WXOrgSector" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxorgsectors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxorgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WXOrgSector" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxorgsectors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXOrgSectorDTO wxorgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxorgsectorService.checkKey(wxorgsectorMapping.toDomain(wxorgsectordto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WXOrgSector" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxorgsectors")
    @Transactional
    public ResponseEntity<WXOrgSectorDTO> create(@RequestBody WXOrgSectorDTO wxorgsectordto) {
        WXOrgSector domain = wxorgsectorMapping.toDomain(wxorgsectordto);
		wxorgsectorService.create(domain);
        WXOrgSectorDTO dto = wxorgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WXOrgSector" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxorgsectors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXOrgSectorDTO> wxorgsectordtos) {
        wxorgsectorService.createBatch(wxorgsectorMapping.toDomain(wxorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxorgsector_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WXOrgSector" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxorgsectors/{wxorgsector_id}")
    public ResponseEntity<WXOrgSectorDTO> get(@PathVariable("wxorgsector_id") String wxorgsector_id) {
        WXOrgSector domain = wxorgsectorService.get(wxorgsector_id);
        WXOrgSectorDTO dto = wxorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WXOrgSector" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxorgsectors/save")
    public ResponseEntity<Boolean> save(@RequestBody WXOrgSectorDTO wxorgsectordto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxorgsectorService.save(wxorgsectorMapping.toDomain(wxorgsectordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WXOrgSector" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxorgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXOrgSectorDTO> wxorgsectordtos) {
        wxorgsectorService.saveBatch(wxorgsectorMapping.toDomain(wxorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxorgsector_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WXOrgSector" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxorgsectors/{wxorgsector_id}")
    @Transactional
    public ResponseEntity<WXOrgSectorDTO> update(@PathVariable("wxorgsector_id") String wxorgsector_id, @RequestBody WXOrgSectorDTO wxorgsectordto) {
		WXOrgSector domain = wxorgsectorMapping.toDomain(wxorgsectordto);
        domain.setWxorgsectorid(wxorgsector_id);
		wxorgsectorService.update(domain);
		WXOrgSectorDTO dto = wxorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxorgsector_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXOrgSector" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxorgsectors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXOrgSectorDTO> wxorgsectordtos) {
        wxorgsectorService.updateBatch(wxorgsectorMapping.toDomain(wxorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WXOrgSector" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxorgsectors/getdraft")
    public ResponseEntity<WXOrgSectorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxorgsectorMapping.toDto(wxorgsectorService.getDraft(new WXOrgSector())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXOrgSector-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WXOrgSector" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxorgsectors/fetchdefault")
	public ResponseEntity<List<WXOrgSectorDTO>> fetchDefault(WXOrgSectorSearchContext context) {
        Page<WXOrgSector> domains = wxorgsectorService.searchDefault(context) ;
        List<WXOrgSectorDTO> list = wxorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXOrgSector-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WXOrgSector" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wxorgsectors/searchdefault")
	public ResponseEntity<Page<WXOrgSectorDTO>> searchDefault(@RequestBody WXOrgSectorSearchContext context) {
        Page<WXOrgSector> domains = wxorgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WXOrgSector getEntity(){
        return new WXOrgSector();
    }

}
