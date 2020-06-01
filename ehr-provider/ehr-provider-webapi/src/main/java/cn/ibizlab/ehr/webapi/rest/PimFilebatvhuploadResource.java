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
import cn.ibizlab.ehr.core.pim.domain.PimFilebatvhupload;
import cn.ibizlab.ehr.core.pim.service.IPimFilebatvhuploadService;
import cn.ibizlab.ehr.core.pim.filter.PimFilebatvhuploadSearchContext;

@Slf4j
@Api(tags = {"附件批量上传" })
@RestController("WebApi-pimfilebatvhupload")
@RequestMapping("")
public class PimFilebatvhuploadResource {

    @Autowired
    public IPimFilebatvhuploadService pimfilebatvhuploadService;

    @Autowired
    @Lazy
    public PimFilebatvhuploadMapping pimfilebatvhuploadMapping;

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddto),'ehr-PimFilebatvhupload-Save')")
    @ApiOperation(value = "保存附件批量上传", tags = {"附件批量上传" },  notes = "保存附件批量上传")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/save")
    public ResponseEntity<Boolean> save(@RequestBody PimFilebatvhuploadDTO pimfilebatvhuploaddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.save(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto)));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos),'ehr-PimFilebatvhupload-Save')")
    @ApiOperation(value = "批量保存附件批量上传", tags = {"附件批量上传" },  notes = "批量保存附件批量上传")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimFilebatvhuploadDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.saveBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(returnObject.body),'ehr-PimFilebatvhupload-Get')")
    @ApiOperation(value = "获取附件批量上传", tags = {"附件批量上传" },  notes = "获取附件批量上传")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    public ResponseEntity<PimFilebatvhuploadDTO> get(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id) {
        PimFilebatvhupload domain = pimfilebatvhuploadService.get(pimfilebatvhupload_id);
        PimFilebatvhuploadDTO dto = pimfilebatvhuploadMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查附件批量上传", tags = {"附件批量上传" },  notes = "检查附件批量上传")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimFilebatvhuploadDTO pimfilebatvhuploaddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.checkKey(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto)));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.get(#pimfilebatvhupload_id),'ehr-PimFilebatvhupload-Update')")
    @ApiOperation(value = "更新附件批量上传", tags = {"附件批量上传" },  notes = "更新附件批量上传")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    @Transactional
    public ResponseEntity<PimFilebatvhuploadDTO> update(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id, @RequestBody PimFilebatvhuploadDTO pimfilebatvhuploaddto) {
		PimFilebatvhupload domain  = pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto);
        domain .setPimfilebatvhuploadid(pimfilebatvhupload_id);
		pimfilebatvhuploadService.update(domain );
		PimFilebatvhuploadDTO dto = pimfilebatvhuploadMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.getPimfilebatvhuploadByEntities(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos)),'ehr-PimFilebatvhupload-Update')")
    @ApiOperation(value = "批量更新附件批量上传", tags = {"附件批量上传" },  notes = "批量更新附件批量上传")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimFilebatvhuploadDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.updateBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddto),'ehr-PimFilebatvhupload-Create')")
    @ApiOperation(value = "新建附件批量上传", tags = {"附件批量上传" },  notes = "新建附件批量上传")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads")
    @Transactional
    public ResponseEntity<PimFilebatvhuploadDTO> create(@RequestBody PimFilebatvhuploadDTO pimfilebatvhuploaddto) {
        PimFilebatvhupload domain = pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto);
		pimfilebatvhuploadService.create(domain);
        PimFilebatvhuploadDTO dto = pimfilebatvhuploadMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos),'ehr-PimFilebatvhupload-Create')")
    @ApiOperation(value = "批量新建附件批量上传", tags = {"附件批量上传" },  notes = "批量新建附件批量上传")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimFilebatvhuploadDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.createBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取附件批量上传草稿", tags = {"附件批量上传" },  notes = "获取附件批量上传草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfilebatvhuploads/getdraft")
    public ResponseEntity<PimFilebatvhuploadDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadMapping.toDto(pimfilebatvhuploadService.getDraft(new PimFilebatvhupload())));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.get(#pimfilebatvhupload_id),'ehr-PimFilebatvhupload-Remove')")
    @ApiOperation(value = "删除附件批量上传", tags = {"附件批量上传" },  notes = "删除附件批量上传")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.remove(pimfilebatvhupload_id));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.getPimfilebatvhuploadByIds(#ids),'ehr-PimFilebatvhupload-Remove')")
    @ApiOperation(value = "批量删除附件批量上传", tags = {"附件批量上传" },  notes = "批量删除附件批量上传")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimfilebatvhuploadService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFilebatvhupload-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"附件批量上传" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimfilebatvhuploads/fetchdefault")
	public ResponseEntity<List<PimFilebatvhuploadDTO>> fetchDefault(PimFilebatvhuploadSearchContext context) {
        Page<PimFilebatvhupload> domains = pimfilebatvhuploadService.searchDefault(context) ;
        List<PimFilebatvhuploadDTO> list = pimfilebatvhuploadMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimFilebatvhupload-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"附件批量上传" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimfilebatvhuploads/searchdefault")
	public ResponseEntity<Page<PimFilebatvhuploadDTO>> searchDefault(@RequestBody PimFilebatvhuploadSearchContext context) {
        Page<PimFilebatvhupload> domains = pimfilebatvhuploadService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfilebatvhuploadMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

