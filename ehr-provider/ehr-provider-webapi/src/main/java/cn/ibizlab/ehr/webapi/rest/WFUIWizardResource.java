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
import cn.ibizlab.ehr.core.wf.domain.WFUIWizard;
import cn.ibizlab.ehr.core.wf.service.IWFUIWizardService;
import cn.ibizlab.ehr.core.wf.filter.WFUIWizardSearchContext;




@Slf4j
@Api(tags = {"WFUIWizard" })
@RestController("WebApi-wfuiwizard")
@RequestMapping("")
public class WFUIWizardResource {

    @Autowired
    private IWFUIWizardService wfuiwizardService;

    @Autowired
    @Lazy
    private WFUIWizardMapping wfuiwizardMapping;




    @PreAuthorize("hasPermission(#wfuiwizard_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFUIWizard" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfuiwizards/{wfuiwizard_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfuiwizard_id") String wfuiwizard_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfuiwizardService.remove(wfuiwizard_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFUIWizard" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfuiwizards/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfuiwizardService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfuiwizard_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFUIWizard" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfuiwizards/{wfuiwizard_id}")
    @Transactional
    public ResponseEntity<WFUIWizardDTO> update(@PathVariable("wfuiwizard_id") String wfuiwizard_id, @RequestBody WFUIWizardDTO wfuiwizarddto) {
		WFUIWizard domain = wfuiwizardMapping.toDomain(wfuiwizarddto);
        domain.setWfuiwizardid(wfuiwizard_id);
		wfuiwizardService.update(domain);
		WFUIWizardDTO dto = wfuiwizardMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfuiwizard_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUIWizard" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfuiwizards/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUIWizardDTO> wfuiwizarddtos) {
        wfuiwizardService.updateBatch(wfuiwizardMapping.toDomain(wfuiwizarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFUIWizard" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuiwizards/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUIWizardDTO wfuiwizarddto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfuiwizardService.save(wfuiwizardMapping.toDomain(wfuiwizarddto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFUIWizard" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuiwizards/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUIWizardDTO> wfuiwizarddtos) {
        wfuiwizardService.saveBatch(wfuiwizardMapping.toDomain(wfuiwizarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFUIWizard" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfuiwizards/getdraft")
    public ResponseEntity<WFUIWizardDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfuiwizardMapping.toDto(wfuiwizardService.getDraft(new WFUIWizard())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFUIWizard" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuiwizards")
    @Transactional
    public ResponseEntity<WFUIWizardDTO> create(@RequestBody WFUIWizardDTO wfuiwizarddto) {
        WFUIWizard domain = wfuiwizardMapping.toDomain(wfuiwizarddto);
		wfuiwizardService.create(domain);
        WFUIWizardDTO dto = wfuiwizardMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFUIWizard" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuiwizards/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUIWizardDTO> wfuiwizarddtos) {
        wfuiwizardService.createBatch(wfuiwizardMapping.toDomain(wfuiwizarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFUIWizard" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfuiwizards/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUIWizardDTO wfuiwizarddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfuiwizardService.checkKey(wfuiwizardMapping.toDomain(wfuiwizarddto)));
    }




    @PreAuthorize("hasPermission(#wfuiwizard_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFUIWizard" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfuiwizards/{wfuiwizard_id}")
    public ResponseEntity<WFUIWizardDTO> get(@PathVariable("wfuiwizard_id") String wfuiwizard_id) {
        WFUIWizard domain = wfuiwizardService.get(wfuiwizard_id);
        WFUIWizardDTO dto = wfuiwizardMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUIWizard-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUIWizard" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfuiwizards/fetchdefault")
	public ResponseEntity<List<WFUIWizardDTO>> fetchDefault(WFUIWizardSearchContext context) {
        Page<WFUIWizard> domains = wfuiwizardService.searchDefault(context) ;
        List<WFUIWizardDTO> list = wfuiwizardMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUIWizard-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUIWizard" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfuiwizards/searchdefault")
	public ResponseEntity<Page<WFUIWizardDTO>> searchDefault(@RequestBody WFUIWizardSearchContext context) {
        Page<WFUIWizard> domains = wfuiwizardService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfuiwizardMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFUIWizard getEntity(){
        return new WFUIWizard();
    }

}
