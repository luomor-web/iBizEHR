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
import cn.ibizlab.ehr.core.common.domain.DEDataChgDisp;
import cn.ibizlab.ehr.core.common.service.IDEDataChgDispService;
import cn.ibizlab.ehr.core.common.filter.DEDataChgDispSearchContext;




@Slf4j
@Api(tags = {"DEDataChgDisp" })
@RestController("WebApi-dedatachgdisp")
@RequestMapping("")
public class DEDataChgDispResource {

    @Autowired
    private IDEDataChgDispService dedatachgdispService;

    @Autowired
    @Lazy
    private DEDataChgDispMapping dedatachgdispMapping;




    @PreAuthorize("hasPermission(#dedatachgdisp_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"DEDataChgDisp" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachgdisps/{dedatachgdisp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dedatachgdisp_id") String dedatachgdisp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dedatachgdispService.remove(dedatachgdisp_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DEDataChgDisp" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachgdisps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dedatachgdispService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DEDataChgDisp" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgdisps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DEDataChgDispDTO dedatachgdispdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dedatachgdispService.checkKey(dedatachgdispMapping.toDomain(dedatachgdispdto)));
    }




    @PreAuthorize("hasPermission(#dedatachgdisp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DEDataChgDisp" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachgdisps/{dedatachgdisp_id}")
    @Transactional
    public ResponseEntity<DEDataChgDispDTO> update(@PathVariable("dedatachgdisp_id") String dedatachgdisp_id, @RequestBody DEDataChgDispDTO dedatachgdispdto) {
		DEDataChgDisp domain = dedatachgdispMapping.toDomain(dedatachgdispdto);
        domain.setDedatachgdispid(dedatachgdisp_id);
		dedatachgdispService.update(domain);
		DEDataChgDispDTO dto = dedatachgdispMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dedatachgdisp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DEDataChgDisp" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachgdisps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DEDataChgDispDTO> dedatachgdispdtos) {
        dedatachgdispService.updateBatch(dedatachgdispMapping.toDomain(dedatachgdispdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DEDataChgDisp" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgdisps")
    @Transactional
    public ResponseEntity<DEDataChgDispDTO> create(@RequestBody DEDataChgDispDTO dedatachgdispdto) {
        DEDataChgDisp domain = dedatachgdispMapping.toDomain(dedatachgdispdto);
		dedatachgdispService.create(domain);
        DEDataChgDispDTO dto = dedatachgdispMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DEDataChgDisp" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgdisps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DEDataChgDispDTO> dedatachgdispdtos) {
        dedatachgdispService.createBatch(dedatachgdispMapping.toDomain(dedatachgdispdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"DEDataChgDisp" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgdisps/save")
    public ResponseEntity<Boolean> save(@RequestBody DEDataChgDispDTO dedatachgdispdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachgdispService.save(dedatachgdispMapping.toDomain(dedatachgdispdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DEDataChgDisp" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgdisps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DEDataChgDispDTO> dedatachgdispdtos) {
        dedatachgdispService.saveBatch(dedatachgdispMapping.toDomain(dedatachgdispdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dedatachgdisp_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DEDataChgDisp" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachgdisps/{dedatachgdisp_id}")
    public ResponseEntity<DEDataChgDispDTO> get(@PathVariable("dedatachgdisp_id") String dedatachgdisp_id) {
        DEDataChgDisp domain = dedatachgdispService.get(dedatachgdisp_id);
        DEDataChgDispDTO dto = dedatachgdispMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"DEDataChgDisp" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachgdisps/getdraft")
    public ResponseEntity<DEDataChgDispDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachgdispMapping.toDto(dedatachgdispService.getDraft(new DEDataChgDisp())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DEDataChgDisp-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DEDataChgDisp" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dedatachgdisps/fetchdefault")
	public ResponseEntity<List<DEDataChgDispDTO>> fetchDefault(DEDataChgDispSearchContext context) {
        Page<DEDataChgDisp> domains = dedatachgdispService.searchDefault(context) ;
        List<DEDataChgDispDTO> list = dedatachgdispMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DEDataChgDisp-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DEDataChgDisp" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dedatachgdisps/searchdefault")
	public ResponseEntity<Page<DEDataChgDispDTO>> searchDefault(@RequestBody DEDataChgDispSearchContext context) {
        Page<DEDataChgDisp> domains = dedatachgdispService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dedatachgdispMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DEDataChgDisp getEntity(){
        return new DEDataChgDisp();
    }

}
