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
import cn.ibizlab.ehr.core.common.domain.ServiceRT;
import cn.ibizlab.ehr.core.common.service.IServiceRTService;
import cn.ibizlab.ehr.core.common.filter.ServiceRTSearchContext;




@Slf4j
@Api(tags = {"ServiceRT" })
@RestController("WebApi-servicert")
@RequestMapping("")
public class ServiceRTResource {

    @Autowired
    private IServiceRTService servicertService;

    @Autowired
    @Lazy
    private ServiceRTMapping servicertMapping;




    @ApiOperation(value = "停止服务", tags = {"ServiceRT" },  notes = "停止服务")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/{servicert_id}/stopservice")
    @Transactional
    public ResponseEntity<ServiceRTDTO> stopService(@PathVariable("servicert_id") String servicert_id, @RequestBody ServiceRTDTO servicertdto) {
        ServiceRT servicert = servicertMapping.toDomain(servicertdto);
        servicert = servicertService.stopService(servicert);
        servicertdto = servicertMapping.toDto(servicert);
        return ResponseEntity.status(HttpStatus.OK).body(servicertdto);
    }




    @ApiOperation(value = "GetDraft", tags = {"ServiceRT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/servicerts/getdraft")
    public ResponseEntity<ServiceRTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(servicertMapping.toDto(servicertService.getDraft(new ServiceRT())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ServiceRT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts")
    @Transactional
    public ResponseEntity<ServiceRTDTO> create(@RequestBody ServiceRTDTO servicertdto) {
        ServiceRT domain = servicertMapping.toDomain(servicertdto);
		servicertService.create(domain);
        ServiceRTDTO dto = servicertMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ServiceRT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ServiceRTDTO> servicertdtos) {
        servicertService.createBatch(servicertMapping.toDomain(servicertdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#servicert_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ServiceRT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/servicerts/{servicert_id}")
    public ResponseEntity<ServiceRTDTO> get(@PathVariable("servicert_id") String servicert_id) {
        ServiceRT domain = servicertService.get(servicert_id);
        ServiceRTDTO dto = servicertMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"ServiceRT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ServiceRTDTO servicertdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(servicertService.checkKey(servicertMapping.toDomain(servicertdto)));
    }




    @ApiOperation(value = "Save", tags = {"ServiceRT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/save")
    public ResponseEntity<Boolean> save(@RequestBody ServiceRTDTO servicertdto) {
        return ResponseEntity.status(HttpStatus.OK).body(servicertService.save(servicertMapping.toDomain(servicertdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ServiceRT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ServiceRTDTO> servicertdtos) {
        servicertService.saveBatch(servicertMapping.toDomain(servicertdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#servicert_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ServiceRT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/servicerts/{servicert_id}")
    @Transactional
    public ResponseEntity<ServiceRTDTO> update(@PathVariable("servicert_id") String servicert_id, @RequestBody ServiceRTDTO servicertdto) {
		ServiceRT domain = servicertMapping.toDomain(servicertdto);
        domain.setServiceid(servicert_id);
		servicertService.update(domain);
		ServiceRTDTO dto = servicertMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#servicert_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ServiceRT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/servicerts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ServiceRTDTO> servicertdtos) {
        servicertService.updateBatch(servicertMapping.toDomain(servicertdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#servicert_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ServiceRT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/servicerts/{servicert_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("servicert_id") String servicert_id) {
         return ResponseEntity.status(HttpStatus.OK).body(servicertService.remove(servicert_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ServiceRT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/servicerts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        servicertService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "启动服务", tags = {"ServiceRT" },  notes = "启动服务")
	@RequestMapping(method = RequestMethod.POST, value = "/servicerts/{servicert_id}/startservice")
    @Transactional
    public ResponseEntity<ServiceRTDTO> startService(@PathVariable("servicert_id") String servicert_id, @RequestBody ServiceRTDTO servicertdto) {
        ServiceRT servicert = servicertMapping.toDomain(servicertdto);
        servicert = servicertService.startService(servicert);
        servicertdto = servicertMapping.toDto(servicert);
        return ResponseEntity.status(HttpStatus.OK).body(servicertdto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ServiceRT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/servicerts/fetchdefault")
	public ResponseEntity<List<ServiceRTDTO>> fetchDefault(ServiceRTSearchContext context) {
        Page<ServiceRT> domains = servicertService.searchDefault(context) ;
        List<ServiceRTDTO> list = servicertMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"ServiceRT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/servicerts/searchdefault")
	public ResponseEntity<Page<ServiceRTDTO>> searchDefault(ServiceRTSearchContext context) {
        Page<ServiceRT> domains = servicertService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(servicertMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ServiceRT getEntity(){
        return new ServiceRT();
    }

}
