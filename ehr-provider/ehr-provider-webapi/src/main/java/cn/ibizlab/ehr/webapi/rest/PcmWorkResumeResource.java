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
import cn.ibizlab.ehr.core.pcm.domain.PcmWorkResume;
import cn.ibizlab.ehr.core.pcm.service.IPcmWorkResumeService;
import cn.ibizlab.ehr.core.pcm.filter.PcmWorkResumeSearchContext;

@Slf4j
@Api(tags = {"工作履历" })
@RestController("WebApi-pcmworkresume")
@RequestMapping("")
public class PcmWorkResumeResource {

    @Autowired
    public IPcmWorkResumeService pcmworkresumeService;

    @Autowired
    @Lazy
    public PcmWorkResumeMapping pcmworkresumeMapping;

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PcmWorkResume-Create')")
    @ApiOperation(value = "新建工作履历", tags = {"工作履历" },  notes = "新建工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes")
    @Transactional
    public ResponseEntity<PcmWorkResumeDTO> create(@RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        PcmWorkResume domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
		pcmworkresumeService.create(domain);
        PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PcmWorkResume-Create')")
    @ApiOperation(value = "批量新建工作履历", tags = {"工作履历" },  notes = "批量新建工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        pcmworkresumeService.createBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取工作履历草稿", tags = {"工作履历" },  notes = "获取工作履历草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmworkresumes/getdraft")
    public ResponseEntity<PcmWorkResumeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeMapping.toDto(pcmworkresumeService.getDraft(new PcmWorkResume())));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PcmWorkResume-Save')")
    @ApiOperation(value = "保存工作履历", tags = {"工作履历" },  notes = "保存工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PcmWorkResume-Save')")
    @ApiOperation(value = "批量保存工作履历", tags = {"工作履历" },  notes = "批量保存工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        pcmworkresumeService.saveBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(returnObject.body),'ehr-PcmWorkResume-Get')")
    @ApiOperation(value = "获取工作履历", tags = {"工作履历" },  notes = "获取工作履历")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PcmWorkResumeDTO> get(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PcmWorkResume domain = pcmworkresumeService.get(pcmworkresume_id);
        PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PcmWorkResume-Update')")
    @ApiOperation(value = "更新工作履历", tags = {"工作履历" },  notes = "更新工作履历")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PcmWorkResumeDTO> update(@PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PcmWorkResumeDTO pcmworkresumedto) {
		PcmWorkResume domain  = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain .setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain );
		PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByEntities(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos)),'ehr-PcmWorkResume-Update')")
    @ApiOperation(value = "批量更新工作履历", tags = {"工作履历" },  notes = "批量更新工作履历")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        pcmworkresumeService.updateBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查工作履历", tags = {"工作履历" },  notes = "检查工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.checkKey(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PcmWorkResume-Remove')")
    @ApiOperation(value = "删除工作履历", tags = {"工作履历" },  notes = "删除工作履历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByIds(#ids),'ehr-PcmWorkResume-Remove')")
    @ApiOperation(value = "批量删除工作履历", tags = {"工作履历" },  notes = "批量删除工作履历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWorkResume-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"工作履历" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmworkresumes/fetchdefault")
	public ResponseEntity<List<PcmWorkResumeDTO>> fetchDefault(PcmWorkResumeSearchContext context) {
        Page<PcmWorkResume> domains = pcmworkresumeService.searchDefault(context) ;
        List<PcmWorkResumeDTO> list = pcmworkresumeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWorkResume-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"工作履历" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PcmWorkResumeDTO>> searchDefault(@RequestBody PcmWorkResumeSearchContext context) {
        Page<PcmWorkResume> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PcmWorkResume-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息建立工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes")
    @Transactional
    public ResponseEntity<PcmWorkResumeDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        PcmWorkResume domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmworkresumeService.create(domain);
        PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PcmWorkResume-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息批量建立工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        List<PcmWorkResume> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PcmWorkResume domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取工作履历草稿", tags = {"工作履历" },  notes = "根据应聘者基本信息获取工作履历草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/getdraft")
    public ResponseEntity<PcmWorkResumeDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmWorkResume domain = new PcmWorkResume();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeMapping.toDto(pcmworkresumeService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PcmWorkResume-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息保存工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        PcmWorkResume domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PcmWorkResume-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息批量保存工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        List<PcmWorkResume> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PcmWorkResume domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(returnObject.body),'ehr-PcmWorkResume-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息获取工作履历")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PcmWorkResumeDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PcmWorkResume domain = pcmworkresumeService.get(pcmworkresume_id);
        PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PcmWorkResume-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息更新工作履历")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PcmWorkResumeDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        PcmWorkResume domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain);
        PcmWorkResumeDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByEntities(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos)),'ehr-PcmWorkResume-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息批量更新工作履历")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmWorkResumeDTO> pcmworkresumedtos) {
        List<PcmWorkResume> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PcmWorkResume domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息检查工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息检查工作履历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmWorkResumeDTO pcmworkresumedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.checkKey(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PcmWorkResume-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息删除工作履历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByIds(#ids),'ehr-PcmWorkResume-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除工作履历", tags = {"工作履历" },  notes = "根据应聘者基本信息批量删除工作履历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWorkResume-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"工作履历" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/fetchdefault")
	public ResponseEntity<List<PcmWorkResumeDTO>> fetchPcmWorkResumeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmWorkResumeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmWorkResume> domains = pcmworkresumeService.searchDefault(context) ;
        List<PcmWorkResumeDTO> list = pcmworkresumeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWorkResume-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"工作履历" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PcmWorkResumeDTO>> searchPcmWorkResumeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmWorkResumeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmWorkResume> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

