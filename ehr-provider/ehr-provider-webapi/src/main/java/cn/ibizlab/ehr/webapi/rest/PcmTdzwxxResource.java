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
import cn.ibizlab.ehr.core.pcm.domain.PcmTdzwxx;
import cn.ibizlab.ehr.core.pcm.service.IPcmTdzwxxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmTdzwxxSearchContext;

@Slf4j
@Api(tags = {"投递职位摘要信息" })
@RestController("WebApi-pcmtdzwxx")
@RequestMapping("")
public class PcmTdzwxxResource {

    @Autowired
    public IPcmTdzwxxService pcmtdzwxxService;

    @Autowired
    @Lazy
    public PcmTdzwxxMapping pcmtdzwxxMapping;

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "新建投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "新建投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> create(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
		pcmtdzwxxService.create(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "批量新建投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "批量新建投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.createBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取投递职位摘要信息草稿", tags = {"投递职位摘要信息" },  notes = "获取投递职位摘要信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtdzwxxes/getdraft")
    public ResponseEntity<PcmTdzwxxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxMapping.toDto(pcmtdzwxxService.getDraft(new PcmTdzwxx())));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "删除投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "删除投递职位摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.remove(pcmtdzwxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByIds(#ids),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "批量删除投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "批量删除投递职位摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "保存投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "保存投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.save(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "批量保存投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "批量保存投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.saveBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "更新投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "更新投递职位摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> update(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
		PcmTdzwxx domain  = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain .setTdzwxxid(pcmtdzwxx_id);
		pcmtdzwxxService.update(domain );
		PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByEntities(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos)),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "批量更新投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "批量更新投递职位摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.updateBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "检查投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.checkKey(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(returnObject.body),'ehr-PcmTdzwxx-Get')")
    @ApiOperation(value = "获取投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "获取投递职位摘要信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    public ResponseEntity<PcmTdzwxxDTO> get(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
        PcmTdzwxx domain = pcmtdzwxxService.get(pcmtdzwxx_id);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"投递职位摘要信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtdzwxxes/fetchdefault")
	public ResponseEntity<List<PcmTdzwxxDTO>> fetchDefault(PcmTdzwxxSearchContext context) {
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
        List<PcmTdzwxxDTO> list = pcmtdzwxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"投递职位摘要信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtdzwxxes/searchdefault")
	public ResponseEntity<Page<PcmTdzwxxDTO>> searchDefault(@RequestBody PcmTdzwxxSearchContext context) {
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息建立投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmtdzwxxService.create(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息批量建立投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取投递职位摘要信息草稿", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息获取投递职位摘要信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/getdraft")
    public ResponseEntity<PcmTdzwxxDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmTdzwxx domain = new PcmTdzwxx();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxMapping.toDto(pcmtdzwxxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息删除投递职位摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.remove(pcmtdzwxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByIds(#ids),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息批量删除投递职位摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmtdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息保存投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息批量保存投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息更新投递职位摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setTdzwxxid(pcmtdzwxx_id);
		pcmtdzwxxService.update(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByEntities(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos)),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息批量更新投递职位摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息检查投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息检查投递职位摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.checkKey(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(returnObject.body),'ehr-PcmTdzwxx-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取投递职位摘要信息", tags = {"投递职位摘要信息" },  notes = "根据应聘者基本信息获取投递职位摘要信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    public ResponseEntity<PcmTdzwxxDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
        PcmTdzwxx domain = pcmtdzwxxService.get(pcmtdzwxx_id);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"投递职位摘要信息" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/fetchdefault")
	public ResponseEntity<List<PcmTdzwxxDTO>> fetchPcmTdzwxxDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmTdzwxxSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
        List<PcmTdzwxxDTO> list = pcmtdzwxxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"投递职位摘要信息" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/searchdefault")
	public ResponseEntity<Page<PcmTdzwxxDTO>> searchPcmTdzwxxDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

