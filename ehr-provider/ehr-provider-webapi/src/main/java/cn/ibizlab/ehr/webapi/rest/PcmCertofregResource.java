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
import cn.ibizlab.ehr.core.pcm.domain.PcmCertofreg;
import cn.ibizlab.ehr.core.pcm.service.IPcmCertofregService;
import cn.ibizlab.ehr.core.pcm.filter.PcmCertofregSearchContext;

@Slf4j
@Api(tags = {"注册证书" })
@RestController("WebApi-pcmcertofreg")
@RequestMapping("")
public class PcmCertofregResource {

    @Autowired
    public IPcmCertofregService pcmcertofregService;

    @Autowired
    @Lazy
    public PcmCertofregMapping pcmcertofregMapping;

    @PreAuthorize("hasPermission(this.pcmcertofregService.get(#pcmcertofreg_id),'ehr-PcmCertofreg-Remove')")
    @ApiOperation(value = "删除注册证书", tags = {"注册证书" },  notes = "删除注册证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.remove(pcmcertofreg_id));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.getPcmcertofregByIds(#ids),'ehr-PcmCertofreg-Remove')")
    @ApiOperation(value = "批量删除注册证书", tags = {"注册证书" },  notes = "批量删除注册证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmcertofregService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdto),'ehr-PcmCertofreg-Save')")
    @ApiOperation(value = "保存注册证书", tags = {"注册证书" },  notes = "保存注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmCertofregDTO pcmcertofregdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.save(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos),'ehr-PcmCertofreg-Save')")
    @ApiOperation(value = "批量保存注册证书", tags = {"注册证书" },  notes = "批量保存注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        pcmcertofregService.saveBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取注册证书草稿", tags = {"注册证书" },  notes = "获取注册证书草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcertofregs/getdraft")
    public ResponseEntity<PcmCertofregDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregMapping.toDto(pcmcertofregService.getDraft(new PcmCertofreg())));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdto),'ehr-PcmCertofreg-Create')")
    @ApiOperation(value = "新建注册证书", tags = {"注册证书" },  notes = "新建注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs")
    @Transactional
    public ResponseEntity<PcmCertofregDTO> create(@RequestBody PcmCertofregDTO pcmcertofregdto) {
        PcmCertofreg domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
		pcmcertofregService.create(domain);
        PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos),'ehr-PcmCertofreg-Create')")
    @ApiOperation(value = "批量新建注册证书", tags = {"注册证书" },  notes = "批量新建注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        pcmcertofregService.createBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.get(#pcmcertofreg_id),'ehr-PcmCertofreg-Update')")
    @ApiOperation(value = "更新注册证书", tags = {"注册证书" },  notes = "更新注册证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<PcmCertofregDTO> update(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id, @RequestBody PcmCertofregDTO pcmcertofregdto) {
		PcmCertofreg domain  = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain .setPcmcertofregid(pcmcertofreg_id);
		pcmcertofregService.update(domain );
		PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.getPcmcertofregByEntities(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos)),'ehr-PcmCertofreg-Update')")
    @ApiOperation(value = "批量更新注册证书", tags = {"注册证书" },  notes = "批量更新注册证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        pcmcertofregService.updateBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(returnObject.body),'ehr-PcmCertofreg-Get')")
    @ApiOperation(value = "获取注册证书", tags = {"注册证书" },  notes = "获取注册证书")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcertofregs/{pcmcertofreg_id}")
    public ResponseEntity<PcmCertofregDTO> get(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
        PcmCertofreg domain = pcmcertofregService.get(pcmcertofreg_id);
        PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查注册证书", tags = {"注册证书" },  notes = "检查注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmCertofregDTO pcmcertofregdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.checkKey(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCertofreg-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"注册证书" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmcertofregs/fetchdefault")
	public ResponseEntity<List<PcmCertofregDTO>> fetchDefault(PcmCertofregSearchContext context) {
        Page<PcmCertofreg> domains = pcmcertofregService.searchDefault(context) ;
        List<PcmCertofregDTO> list = pcmcertofregMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCertofreg-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"注册证书" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmcertofregs/searchdefault")
	public ResponseEntity<Page<PcmCertofregDTO>> searchDefault(@RequestBody PcmCertofregSearchContext context) {
        Page<PcmCertofreg> domains = pcmcertofregService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcertofregMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmcertofregService.get(#pcmcertofreg_id),'ehr-PcmCertofreg-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息删除注册证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.remove(pcmcertofreg_id));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.getPcmcertofregByIds(#ids),'ehr-PcmCertofreg-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息批量删除注册证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmcertofregService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdto),'ehr-PcmCertofreg-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息保存注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmCertofregDTO pcmcertofregdto) {
        PcmCertofreg domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos),'ehr-PcmCertofreg-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息批量保存注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        List<PcmCertofreg> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PcmCertofreg domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取注册证书草稿", tags = {"注册证书" },  notes = "根据应聘者基本信息获取注册证书草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/getdraft")
    public ResponseEntity<PcmCertofregDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmCertofreg domain = new PcmCertofreg();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregMapping.toDto(pcmcertofregService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdto),'ehr-PcmCertofreg-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息建立注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs")
    @Transactional
    public ResponseEntity<PcmCertofregDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmCertofregDTO pcmcertofregdto) {
        PcmCertofreg domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmcertofregService.create(domain);
        PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos),'ehr-PcmCertofreg-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息批量建立注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        List<PcmCertofreg> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PcmCertofreg domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.get(#pcmcertofreg_id),'ehr-PcmCertofreg-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息更新注册证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<PcmCertofregDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id, @RequestBody PcmCertofregDTO pcmcertofregdto) {
        PcmCertofreg domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmcertofregid(pcmcertofreg_id);
		pcmcertofregService.update(domain);
        PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcertofregService.getPcmcertofregByEntities(this.pcmcertofregMapping.toDomain(#pcmcertofregdtos)),'ehr-PcmCertofreg-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息批量更新注册证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmCertofregDTO> pcmcertofregdtos) {
        List<PcmCertofreg> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PcmCertofreg domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmcertofregMapping.toDomain(returnObject.body),'ehr-PcmCertofreg-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息获取注册证书")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    public ResponseEntity<PcmCertofregDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
        PcmCertofreg domain = pcmcertofregService.get(pcmcertofreg_id);
        PcmCertofregDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据应聘者基本信息检查注册证书", tags = {"注册证书" },  notes = "根据应聘者基本信息检查注册证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmCertofregDTO pcmcertofregdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.checkKey(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCertofreg-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"注册证书" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmcertofregs/fetchdefault")
	public ResponseEntity<List<PcmCertofregDTO>> fetchPcmCertofregDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmCertofregSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmCertofreg> domains = pcmcertofregService.searchDefault(context) ;
        List<PcmCertofregDTO> list = pcmcertofregMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCertofreg-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"注册证书" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmcertofregs/searchdefault")
	public ResponseEntity<Page<PcmCertofregDTO>> searchPcmCertofregDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmCertofregSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmCertofreg> domains = pcmcertofregService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcertofregMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

