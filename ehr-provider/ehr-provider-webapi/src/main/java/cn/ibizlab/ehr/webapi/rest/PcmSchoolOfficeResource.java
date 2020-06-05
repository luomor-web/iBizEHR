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
import cn.ibizlab.ehr.core.pcm.domain.PcmSchoolOffice;
import cn.ibizlab.ehr.core.pcm.service.IPcmSchoolOfficeService;
import cn.ibizlab.ehr.core.pcm.filter.PcmSchoolOfficeSearchContext;

@Slf4j
@Api(tags = {"在校职务" })
@RestController("WebApi-pcmschooloffice")
@RequestMapping("")
public class PcmSchoolOfficeResource {

    @Autowired
    public IPcmSchoolOfficeService pcmschoolofficeService;

    @Autowired
    @Lazy
    public PcmSchoolOfficeMapping pcmschoolofficeMapping;

    @PostAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(returnObject.body),'ehr-PcmSchoolOffice-Get')")
    @ApiOperation(value = "获取在校职务", tags = {"在校职务" },  notes = "获取在校职务")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PcmSchoolOfficeDTO> get(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PcmSchoolOffice domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "删除在校职务", tags = {"在校职务" },  notes = "删除在校职务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByIds(#ids),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "批量删除在校职务", tags = {"在校职务" },  notes = "批量删除在校职务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查在校职务", tags = {"在校职务" },  notes = "检查在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @ApiOperation(value = "获取在校职务草稿", tags = {"在校职务" },  notes = "获取在校职务草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/getdraft")
    public ResponseEntity<PcmSchoolOfficeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(new PcmSchoolOffice())));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "更新在校职务", tags = {"在校职务" },  notes = "更新在校职务")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> update(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
		PcmSchoolOffice domain  = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain .setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain );
		PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByEntities(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos)),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "批量更新在校职务", tags = {"在校职务" },  notes = "批量更新在校职务")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.updateBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "保存在校职务", tags = {"在校职务" },  notes = "保存在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "批量保存在校职务", tags = {"在校职务" },  notes = "批量保存在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.saveBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "新建在校职务", tags = {"在校职务" },  notes = "新建在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> create(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
		pcmschoolofficeService.create(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "批量新建在校职务", tags = {"在校职务" },  notes = "批量新建在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.createBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"在校职务" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PcmSchoolOfficeDTO>> fetchDefault(PcmSchoolOfficeSearchContext context) {
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PcmSchoolOfficeDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"在校职务" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PcmSchoolOfficeDTO>> searchDefault(@RequestBody PcmSchoolOfficeSearchContext context) {
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(returnObject.body),'ehr-PcmSchoolOffice-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息获取在校职务")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PcmSchoolOfficeDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PcmSchoolOffice domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息删除在校职务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByIds(#ids),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息批量删除在校职务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息检查在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息检查在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @ApiOperation(value = "根据应聘者基本信息获取在校职务草稿", tags = {"在校职务" },  notes = "根据应聘者基本信息获取在校职务草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/getdraft")
    public ResponseEntity<PcmSchoolOfficeDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmSchoolOffice domain = new PcmSchoolOffice();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息更新在校职务")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByEntities(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos)),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息批量更新在校职务")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息保存在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息批量保存在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息建立在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmschoolofficeService.create(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立在校职务", tags = {"在校职务" },  notes = "根据应聘者基本信息批量建立在校职务")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"在校职务" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PcmSchoolOfficeDTO>> fetchPcmSchoolOfficeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmSchoolOfficeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PcmSchoolOfficeDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"在校职务" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PcmSchoolOfficeDTO>> searchPcmSchoolOfficeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

