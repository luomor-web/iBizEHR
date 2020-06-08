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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileFj;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileFjService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileFjSearchContext;

@Slf4j
@Api(tags = {"应聘者附件" })
@RestController("WebApi-pcmprofilefj")
@RequestMapping("")
public class PcmProfileFjResource {

    @Autowired
    public IPcmProfileFjService pcmprofilefjService;

    @Autowired
    @Lazy
    public PcmProfileFjMapping pcmprofilefjMapping;

    @ApiOperation(value = "获取应聘者附件草稿", tags = {"应聘者附件" },  notes = "获取应聘者附件草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilefjs/getdraft")
    public ResponseEntity<PcmProfileFjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjMapping.toDto(pcmprofilefjService.getDraft(new PcmProfileFj())));
    }

    @ApiOperation(value = "检查应聘者附件", tags = {"应聘者附件" },  notes = "检查应聘者附件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileFjDTO pcmprofilefjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.checkKey(pcmprofilefjMapping.toDomain(pcmprofilefjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjService.get(#pcmprofilefj_id),'ehr-PcmProfileFj-Update')")
    @ApiOperation(value = "更新应聘者附件", tags = {"应聘者附件" },  notes = "更新应聘者附件")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    @Transactional
    public ResponseEntity<PcmProfileFjDTO> update(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id, @RequestBody PcmProfileFjDTO pcmprofilefjdto) {
		PcmProfileFj domain  = pcmprofilefjMapping.toDomain(pcmprofilefjdto);
        domain .setPcmprofilefjid(pcmprofilefj_id);
		pcmprofilefjService.update(domain );
		PcmProfileFjDTO dto = pcmprofilefjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjService.getPcmprofilefjByEntities(this.pcmprofilefjMapping.toDomain(#pcmprofilefjdtos)),'ehr-PcmProfileFj-Update')")
    @ApiOperation(value = "批量更新应聘者附件", tags = {"应聘者附件" },  notes = "批量更新应聘者附件")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileFjDTO> pcmprofilefjdtos) {
        pcmprofilefjService.updateBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjService.get(#pcmprofilefj_id),'ehr-PcmProfileFj-Remove')")
    @ApiOperation(value = "删除应聘者附件", tags = {"应聘者附件" },  notes = "删除应聘者附件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.remove(pcmprofilefj_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjService.getPcmprofilefjByIds(#ids),'ehr-PcmProfileFj-Remove')")
    @ApiOperation(value = "批量删除应聘者附件", tags = {"应聘者附件" },  notes = "批量删除应聘者附件")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilefjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofilefjMapping.toDomain(returnObject.body),'ehr-PcmProfileFj-Get')")
    @ApiOperation(value = "获取应聘者附件", tags = {"应聘者附件" },  notes = "获取应聘者附件")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    public ResponseEntity<PcmProfileFjDTO> get(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id) {
        PcmProfileFj domain = pcmprofilefjService.get(pcmprofilefj_id);
        PcmProfileFjDTO dto = pcmprofilefjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjMapping.toDomain(#pcmprofilefjdto),'ehr-PcmProfileFj-Save')")
    @ApiOperation(value = "保存应聘者附件", tags = {"应聘者附件" },  notes = "保存应聘者附件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileFjDTO pcmprofilefjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.save(pcmprofilefjMapping.toDomain(pcmprofilefjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjMapping.toDomain(#pcmprofilefjdtos),'ehr-PcmProfileFj-Save')")
    @ApiOperation(value = "批量保存应聘者附件", tags = {"应聘者附件" },  notes = "批量保存应聘者附件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileFjDTO> pcmprofilefjdtos) {
        pcmprofilefjService.saveBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjMapping.toDomain(#pcmprofilefjdto),'ehr-PcmProfileFj-Create')")
    @ApiOperation(value = "新建应聘者附件", tags = {"应聘者附件" },  notes = "新建应聘者附件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs")
    @Transactional
    public ResponseEntity<PcmProfileFjDTO> create(@RequestBody PcmProfileFjDTO pcmprofilefjdto) {
        PcmProfileFj domain = pcmprofilefjMapping.toDomain(pcmprofilefjdto);
		pcmprofilefjService.create(domain);
        PcmProfileFjDTO dto = pcmprofilefjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilefjMapping.toDomain(#pcmprofilefjdtos),'ehr-PcmProfileFj-Create')")
    @ApiOperation(value = "批量新建应聘者附件", tags = {"应聘者附件" },  notes = "批量新建应聘者附件")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileFjDTO> pcmprofilefjdtos) {
        pcmprofilefjService.createBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileFj-PROFILEFJ-all')")
	@ApiOperation(value = "获取应聘者附件", tags = {"应聘者附件" } ,notes = "获取应聘者附件")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilefjs/fetchprofilefj")
	public ResponseEntity<List<PcmProfileFjDTO>> fetchPROFILEFJ(PcmProfileFjSearchContext context) {
        Page<PcmProfileFj> domains = pcmprofilefjService.searchPROFILEFJ(context) ;
        List<PcmProfileFjDTO> list = pcmprofilefjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileFj-PROFILEFJ-all')")
	@ApiOperation(value = "查询应聘者附件", tags = {"应聘者附件" } ,notes = "查询应聘者附件")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilefjs/searchprofilefj")
	public ResponseEntity<Page<PcmProfileFjDTO>> searchPROFILEFJ(@RequestBody PcmProfileFjSearchContext context) {
        Page<PcmProfileFj> domains = pcmprofilefjService.searchPROFILEFJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilefjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileFj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者附件" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilefjs/fetchdefault")
	public ResponseEntity<List<PcmProfileFjDTO>> fetchDefault(PcmProfileFjSearchContext context) {
        Page<PcmProfileFj> domains = pcmprofilefjService.searchDefault(context) ;
        List<PcmProfileFjDTO> list = pcmprofilefjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileFj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者附件" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilefjs/searchdefault")
	public ResponseEntity<Page<PcmProfileFjDTO>> searchDefault(@RequestBody PcmProfileFjSearchContext context) {
        Page<PcmProfileFj> domains = pcmprofilefjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilefjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

