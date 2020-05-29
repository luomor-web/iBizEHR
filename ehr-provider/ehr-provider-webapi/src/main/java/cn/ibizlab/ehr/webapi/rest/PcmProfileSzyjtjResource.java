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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileSzyjtjService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSzyjtjSearchContext;

@Slf4j
@Api(tags = {"应聘者社招引进条件" })
@RestController("WebApi-pcmprofileszyjtj")
@RequestMapping("")
public class PcmProfileSzyjtjResource {

    @Autowired
    public IPcmProfileSzyjtjService pcmprofileszyjtjService;

    @Autowired
    @Lazy
    public PcmProfileSzyjtjMapping pcmprofileszyjtjMapping;

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdto),'ehr-PcmProfileSzyjtj-Save')")
    @ApiOperation(value = "保存应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "保存应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.save(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos),'ehr-PcmProfileSzyjtj-Save')")
    @ApiOperation(value = "批量保存应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "批量保存应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.saveBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdto),'ehr-PcmProfileSzyjtj-Create')")
    @ApiOperation(value = "新建应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "新建应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs")
    @Transactional
    public ResponseEntity<PcmProfileSzyjtjDTO> create(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        PcmProfileSzyjtj domain = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
		pcmprofileszyjtjService.create(domain);
        PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos),'ehr-PcmProfileSzyjtj-Create')")
    @ApiOperation(value = "批量新建应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "批量新建应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.createBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取应聘者社招引进条件草稿", tags = {"应聘者社招引进条件" },  notes = "获取应聘者社招引进条件草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/getdraft")
    public ResponseEntity<PcmProfileSzyjtjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjMapping.toDto(pcmprofileszyjtjService.getDraft(new PcmProfileSzyjtj())));
    }

    @ApiOperation(value = "检查应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "检查应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.checkKey(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.get(#pcmprofileszyjtj_id),'ehr-PcmProfileSzyjtj-Remove')")
    @ApiOperation(value = "删除应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "删除应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.remove(pcmprofileszyjtj_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.getPcmprofileszyjtjByIds(#ids),'ehr-PcmProfileSzyjtj-Remove')")
    @ApiOperation(value = "批量删除应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "批量删除应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileszyjtjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileszyjtjMapping.toDomain(returnObject.body),'ehr-PcmProfileSzyjtj-Get')")
    @ApiOperation(value = "获取应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "获取应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    public ResponseEntity<PcmProfileSzyjtjDTO> get(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
        PcmProfileSzyjtj domain = pcmprofileszyjtjService.get(pcmprofileszyjtj_id);
        PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.get(#pcmprofileszyjtj_id),'ehr-PcmProfileSzyjtj-Update')")
    @ApiOperation(value = "更新应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "更新应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<PcmProfileSzyjtjDTO> update(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id, @RequestBody PcmProfileSzyjtjDTO pcmprofileszyjtjdto) {
		PcmProfileSzyjtj domain  = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
        domain .setPcmprofileszyjtjid(pcmprofileszyjtj_id);
		pcmprofileszyjtjService.update(domain );
		PcmProfileSzyjtjDTO dto = pcmprofileszyjtjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileszyjtjService.getPcmprofileszyjtjByEntities(this.pcmprofileszyjtjMapping.toDomain(#pcmprofileszyjtjdtos)),'ehr-PcmProfileSzyjtj-Update')")
    @ApiOperation(value = "批量更新应聘者社招引进条件", tags = {"应聘者社招引进条件" },  notes = "批量更新应聘者社招引进条件")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileSzyjtjDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.updateBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者社招引进条件" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchdefault")
	public ResponseEntity<List<PcmProfileSzyjtjDTO>> fetchDefault(PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchDefault(context) ;
        List<PcmProfileSzyjtjDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者社招引进条件" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchdefault")
	public ResponseEntity<Page<PcmProfileSzyjtjDTO>> searchDefault(@RequestBody PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-YGLX-all')")
	@ApiOperation(value = "获取通过申报类型过滤", tags = {"应聘者社招引进条件" } ,notes = "获取通过申报类型过滤")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchyglx")
	public ResponseEntity<List<PcmProfileSzyjtjDTO>> fetchYGLX(PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchYGLX(context) ;
        List<PcmProfileSzyjtjDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileSzyjtj-YGLX-all')")
	@ApiOperation(value = "查询通过申报类型过滤", tags = {"应聘者社招引进条件" } ,notes = "查询通过申报类型过滤")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchyglx")
	public ResponseEntity<Page<PcmProfileSzyjtjDTO>> searchYGLX(@RequestBody PcmProfileSzyjtjSearchContext context) {
        Page<PcmProfileSzyjtj> domains = pcmprofileszyjtjService.searchYGLX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

