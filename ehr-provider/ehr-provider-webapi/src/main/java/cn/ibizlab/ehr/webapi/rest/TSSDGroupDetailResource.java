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
import cn.ibizlab.ehr.core.common.domain.TSSDGroupDetail;
import cn.ibizlab.ehr.core.common.service.ITSSDGroupDetailService;
import cn.ibizlab.ehr.core.common.filter.TSSDGroupDetailSearchContext;




@Slf4j
@Api(tags = {"TSSDGroupDetail" })
@RestController("WebApi-tssdgroupdetail")
@RequestMapping("")
public class TSSDGroupDetailResource {

    @Autowired
    private ITSSDGroupDetailService tssdgroupdetailService;

    @Autowired
    @Lazy
    private TSSDGroupDetailMapping tssdgroupdetailMapping;




    @ApiOperation(value = "GetDraft", tags = {"TSSDGroupDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdgroupdetails/getdraft")
    public ResponseEntity<TSSDGroupDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdgroupdetailMapping.toDto(tssdgroupdetailService.getDraft(new TSSDGroupDetail())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDGroupDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroupdetails")
    @Transactional
    public ResponseEntity<TSSDGroupDetailDTO> create(@RequestBody TSSDGroupDetailDTO tssdgroupdetaildto) {
        TSSDGroupDetail domain = tssdgroupdetailMapping.toDomain(tssdgroupdetaildto);
		tssdgroupdetailService.create(domain);
        TSSDGroupDetailDTO dto = tssdgroupdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDGroupDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroupdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDGroupDetailDTO> tssdgroupdetaildtos) {
        tssdgroupdetailService.createBatch(tssdgroupdetailMapping.toDomain(tssdgroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdgroupdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDGroupDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdgroupdetails/{tssdgroupdetail_id}")
    @Transactional
    public ResponseEntity<TSSDGroupDetailDTO> update(@PathVariable("tssdgroupdetail_id") String tssdgroupdetail_id, @RequestBody TSSDGroupDetailDTO tssdgroupdetaildto) {
		TSSDGroupDetail domain = tssdgroupdetailMapping.toDomain(tssdgroupdetaildto);
        domain.setTssdgroupdetailid(tssdgroupdetail_id);
		tssdgroupdetailService.update(domain);
		TSSDGroupDetailDTO dto = tssdgroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdgroupdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDGroupDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdgroupdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDGroupDetailDTO> tssdgroupdetaildtos) {
        tssdgroupdetailService.updateBatch(tssdgroupdetailMapping.toDomain(tssdgroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TSSDGroupDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroupdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDGroupDetailDTO tssdgroupdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdgroupdetailService.save(tssdgroupdetailMapping.toDomain(tssdgroupdetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDGroupDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroupdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDGroupDetailDTO> tssdgroupdetaildtos) {
        tssdgroupdetailService.saveBatch(tssdgroupdetailMapping.toDomain(tssdgroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDGroupDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdgroupdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDGroupDetailDTO tssdgroupdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdgroupdetailService.checkKey(tssdgroupdetailMapping.toDomain(tssdgroupdetaildto)));
    }




    @PreAuthorize("hasPermission('Remove',{#tssdgroupdetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDGroupDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdgroupdetails/{tssdgroupdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdgroupdetail_id") String tssdgroupdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdgroupdetailService.remove(tssdgroupdetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDGroupDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdgroupdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdgroupdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdgroupdetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDGroupDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdgroupdetails/{tssdgroupdetail_id}")
    public ResponseEntity<TSSDGroupDetailDTO> get(@PathVariable("tssdgroupdetail_id") String tssdgroupdetail_id) {
        TSSDGroupDetail domain = tssdgroupdetailService.get(tssdgroupdetail_id);
        TSSDGroupDetailDTO dto = tssdgroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDGroupDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdgroupdetails/fetchdefault")
	public ResponseEntity<List<TSSDGroupDetailDTO>> fetchDefault(TSSDGroupDetailSearchContext context) {
        Page<TSSDGroupDetail> domains = tssdgroupdetailService.searchDefault(context) ;
        List<TSSDGroupDetailDTO> list = tssdgroupdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDGroupDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdgroupdetails/searchdefault")
	public ResponseEntity<Page<TSSDGroupDetailDTO>> searchDefault(TSSDGroupDetailSearchContext context) {
        Page<TSSDGroupDetail> domains = tssdgroupdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdgroupdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDGroupDetail getEntity(){
        return new TSSDGroupDetail();
    }

}
