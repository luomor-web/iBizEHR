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
import cn.ibizlab.ehr.core.common.domain.DEDataChg;
import cn.ibizlab.ehr.core.common.service.IDEDataChgService;
import cn.ibizlab.ehr.core.common.filter.DEDataChgSearchContext;




@Slf4j
@Api(tags = {"DEDataChg" })
@RestController("WebApi-dedatachg")
@RequestMapping("")
public class DEDataChgResource {

    @Autowired
    private IDEDataChgService dedatachgService;

    @Autowired
    @Lazy
    private DEDataChgMapping dedatachgMapping;




    @PreAuthorize("hasPermission(#dedatachg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DEDataChg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachgs/{dedatachg_id}")
    @Transactional
    public ResponseEntity<DEDataChgDTO> update(@PathVariable("dedatachg_id") String dedatachg_id, @RequestBody DEDataChgDTO dedatachgdto) {
		DEDataChg domain = dedatachgMapping.toDomain(dedatachgdto);
        domain.setDedatachgid(dedatachg_id);
		dedatachgService.update(domain);
		DEDataChgDTO dto = dedatachgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dedatachg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DEDataChg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DEDataChgDTO> dedatachgdtos) {
        dedatachgService.updateBatch(dedatachgMapping.toDomain(dedatachgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"DEDataChg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgs/save")
    public ResponseEntity<Boolean> save(@RequestBody DEDataChgDTO dedatachgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachgService.save(dedatachgMapping.toDomain(dedatachgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DEDataChg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DEDataChgDTO> dedatachgdtos) {
        dedatachgService.saveBatch(dedatachgMapping.toDomain(dedatachgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dedatachg_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DEDataChg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachgs/{dedatachg_id}")
    public ResponseEntity<DEDataChgDTO> get(@PathVariable("dedatachg_id") String dedatachg_id) {
        DEDataChg domain = dedatachgService.get(dedatachg_id);
        DEDataChgDTO dto = dedatachgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"DEDataChg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DEDataChgDTO dedatachgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dedatachgService.checkKey(dedatachgMapping.toDomain(dedatachgdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"DEDataChg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachgs/getdraft")
    public ResponseEntity<DEDataChgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachgMapping.toDto(dedatachgService.getDraft(new DEDataChg())));
    }




    @PreAuthorize("hasPermission('Remove',{#dedatachg_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DEDataChg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachgs/{dedatachg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dedatachg_id") String dedatachg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dedatachgService.remove(dedatachg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DEDataChg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dedatachgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DEDataChg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgs")
    @Transactional
    public ResponseEntity<DEDataChgDTO> create(@RequestBody DEDataChgDTO dedatachgdto) {
        DEDataChg domain = dedatachgMapping.toDomain(dedatachgdto);
		dedatachgService.create(domain);
        DEDataChgDTO dto = dedatachgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DEDataChg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DEDataChgDTO> dedatachgdtos) {
        dedatachgService.createBatch(dedatachgMapping.toDomain(dedatachgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DEDataChg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dedatachgs/fetchdefault")
	public ResponseEntity<List<DEDataChgDTO>> fetchDefault(DEDataChgSearchContext context) {
        Page<DEDataChg> domains = dedatachgService.searchDefault(context) ;
        List<DEDataChgDTO> list = dedatachgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DEDataChg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dedatachgs/searchdefault")
	public ResponseEntity<Page<DEDataChgDTO>> searchDefault(@RequestBody DEDataChgSearchContext context) {
        Page<DEDataChg> domains = dedatachgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dedatachgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DEDataChg getEntity(){
        return new DEDataChg();
    }

}
