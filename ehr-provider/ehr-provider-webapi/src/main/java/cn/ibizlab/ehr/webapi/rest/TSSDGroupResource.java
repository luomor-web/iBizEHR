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
import cn.ibizlab.ehr.core.common.domain.TSSDGroup;
import cn.ibizlab.ehr.core.common.service.ITSSDGroupService;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupSearchContext;




@Slf4j
@Api(tags = {"TSSDGroup" })
@RestController("WebApi-tssdgroup")
@RequestMapping("")
public class TSSDGroupResource {

    @Autowired
    private ITSSDGroupService tssdgroupService;

    @Autowired
    @Lazy
    private TSSDGroupMapping tssdgroupMapping;




    @ApiOperation(value = "CheckKey", tags = {"TSSDGroup" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDGroupDTO tssdgroupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdgroupService.checkKey(tssdgroupMapping.toDomain(tssdgroupdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#tssdgroup_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDGroup" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdgroups/{tssdgroup_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdgroup_id") String tssdgroup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdgroupService.remove(tssdgroup_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDGroup" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdgroups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdgroupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TSSDGroup" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdgroups/getdraft")
    public ResponseEntity<TSSDGroupDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdgroupMapping.toDto(tssdgroupService.getDraft(new TSSDGroup())));
    }




    @PreAuthorize("hasPermission(#tssdgroup_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDGroup" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdgroups/{tssdgroup_id}")
    @Transactional
    public ResponseEntity<TSSDGroupDTO> update(@PathVariable("tssdgroup_id") String tssdgroup_id, @RequestBody TSSDGroupDTO tssdgroupdto) {
		TSSDGroup domain = tssdgroupMapping.toDomain(tssdgroupdto);
        domain.setTssdgroupid(tssdgroup_id);
		tssdgroupService.update(domain);
		TSSDGroupDTO dto = tssdgroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdgroup_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDGroup" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdgroups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDGroupDTO> tssdgroupdtos) {
        tssdgroupService.updateBatch(tssdgroupMapping.toDomain(tssdgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdgroup_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDGroup" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdgroups/{tssdgroup_id}")
    public ResponseEntity<TSSDGroupDTO> get(@PathVariable("tssdgroup_id") String tssdgroup_id) {
        TSSDGroup domain = tssdgroupService.get(tssdgroup_id);
        TSSDGroupDTO dto = tssdgroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"TSSDGroup" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroups/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDGroupDTO tssdgroupdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdgroupService.save(tssdgroupMapping.toDomain(tssdgroupdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDGroup" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDGroupDTO> tssdgroupdtos) {
        tssdgroupService.saveBatch(tssdgroupMapping.toDomain(tssdgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDGroup" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroups")
    @Transactional
    public ResponseEntity<TSSDGroupDTO> create(@RequestBody TSSDGroupDTO tssdgroupdto) {
        TSSDGroup domain = tssdgroupMapping.toDomain(tssdgroupdto);
		tssdgroupService.create(domain);
        TSSDGroupDTO dto = tssdgroupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDGroup" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDGroupDTO> tssdgroupdtos) {
        tssdgroupService.createBatch(tssdgroupMapping.toDomain(tssdgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDGroup" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdgroups/fetchdefault")
	public ResponseEntity<List<TSSDGroupDTO>> fetchDefault(TSSDGroupSearchContext context) {
        Page<TSSDGroup> domains = tssdgroupService.searchDefault(context) ;
        List<TSSDGroupDTO> list = tssdgroupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDGroup" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdgroups/searchdefault")
	public ResponseEntity<Page<TSSDGroupDTO>> searchDefault(@RequestBody TSSDGroupSearchContext context) {
        Page<TSSDGroup> domains = tssdgroupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdgroupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDGroup getEntity(){
        return new TSSDGroup();
    }

}
