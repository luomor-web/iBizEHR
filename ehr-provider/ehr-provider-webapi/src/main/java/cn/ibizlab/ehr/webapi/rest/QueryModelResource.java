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
import cn.ibizlab.ehr.core.demodel.domain.QueryModel;
import cn.ibizlab.ehr.core.demodel.service.IQueryModelService;
import cn.ibizlab.ehr.core.demodel.filter.QueryModelSearchContext;




@Slf4j
@Api(tags = {"QueryModel" })
@RestController("WebApi-querymodel")
@RequestMapping("")
public class QueryModelResource {

    @Autowired
    private IQueryModelService querymodelService;

    @Autowired
    @Lazy
    public QueryModelMapping querymodelMapping;

    public QueryModelDTO permissionDTO=new QueryModelDTO();

    @PreAuthorize("hasPermission(#querymodel_id,'Get',{'Sql',this.querymodelMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"QueryModel" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/querymodels/{querymodel_id}")
    public ResponseEntity<QueryModelDTO> get(@PathVariable("querymodel_id") String querymodel_id) {
        QueryModel domain = querymodelService.get(querymodel_id);
        QueryModelDTO dto = querymodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#querymodel_id,'Remove',{'Sql',this.querymodelMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"QueryModel" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/querymodels/{querymodel_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("querymodel_id") String querymodel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(querymodelService.remove(querymodel_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"QueryModel" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/querymodels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        querymodelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#querymodel_id,'Update',{'Sql',this.querymodelMapping,#querymodeldto})")
    @ApiOperation(value = "Update", tags = {"QueryModel" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/querymodels/{querymodel_id}")
    @Transactional
    public ResponseEntity<QueryModelDTO> update(@PathVariable("querymodel_id") String querymodel_id, @RequestBody QueryModelDTO querymodeldto) {
		QueryModel domain = querymodelMapping.toDomain(querymodeldto);
        domain.setQuerymodelid(querymodel_id);
		querymodelService.update(domain);
		QueryModelDTO dto = querymodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"QueryModel" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/querymodels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<QueryModelDTO> querymodeldtos) {
        querymodelService.updateBatch(querymodelMapping.toDomain(querymodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-Save-all')")
    @ApiOperation(value = "Save", tags = {"QueryModel" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/querymodels/save")
    public ResponseEntity<Boolean> save(@RequestBody QueryModelDTO querymodeldto) {
        return ResponseEntity.status(HttpStatus.OK).body(querymodelService.save(querymodelMapping.toDomain(querymodeldto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"QueryModel" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/querymodels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<QueryModelDTO> querymodeldtos) {
        querymodelService.saveBatch(querymodelMapping.toDomain(querymodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"QueryModel" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/querymodels/getdraft")
    public ResponseEntity<QueryModelDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(querymodelMapping.toDto(querymodelService.getDraft(new QueryModel())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"QueryModel" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/querymodels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody QueryModelDTO querymodeldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(querymodelService.checkKey(querymodelMapping.toDomain(querymodeldto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.querymodelMapping,#querymodeldto})")
    @ApiOperation(value = "Create", tags = {"QueryModel" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/querymodels")
    @Transactional
    public ResponseEntity<QueryModelDTO> create(@RequestBody QueryModelDTO querymodeldto) {
        QueryModel domain = querymodelMapping.toDomain(querymodeldto);
		querymodelService.create(domain);
        QueryModelDTO dto = querymodelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"QueryModel" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/querymodels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<QueryModelDTO> querymodeldtos) {
        querymodelService.createBatch(querymodelMapping.toDomain(querymodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"QueryModel" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/querymodels/fetchdefault")
	public ResponseEntity<List<QueryModelDTO>> fetchDefault(QueryModelSearchContext context) {
        Page<QueryModel> domains = querymodelService.searchDefault(context) ;
        List<QueryModelDTO> list = querymodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"QueryModel" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/querymodels/searchdefault")
	public ResponseEntity<Page<QueryModelDTO>> searchDefault(@RequestBody QueryModelSearchContext context) {
        Page<QueryModel> domains = querymodelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(querymodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-CurDE-all')")
	@ApiOperation(value = "fetch当前实体", tags = {"QueryModel" } ,notes = "fetch当前实体")
    @RequestMapping(method= RequestMethod.GET , value="/querymodels/fetchcurde")
	public ResponseEntity<List<QueryModelDTO>> fetchCurDE(QueryModelSearchContext context) {
        Page<QueryModel> domains = querymodelService.searchCurDE(context) ;
        List<QueryModelDTO> list = querymodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QueryModel-CurDE-all')")
	@ApiOperation(value = "search当前实体", tags = {"QueryModel" } ,notes = "search当前实体")
    @RequestMapping(method= RequestMethod.POST , value="/querymodels/searchcurde")
	public ResponseEntity<Page<QueryModelDTO>> searchCurDE(@RequestBody QueryModelSearchContext context) {
        Page<QueryModel> domains = querymodelService.searchCurDE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(querymodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
