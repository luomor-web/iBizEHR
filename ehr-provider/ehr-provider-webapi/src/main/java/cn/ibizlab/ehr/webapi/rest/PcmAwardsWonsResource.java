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
import cn.ibizlab.ehr.core.pcm.domain.PcmAwardsWons;
import cn.ibizlab.ehr.core.pcm.service.IPcmAwardsWonsService;
import cn.ibizlab.ehr.core.pcm.filter.PcmAwardsWonsSearchContext;

@Slf4j
@Api(tags = {"获奖情况" })
@RestController("WebApi-pcmawardswons")
@RequestMapping("")
public class PcmAwardsWonsResource {

    @Autowired
    public IPcmAwardsWonsService pcmawardswonsService;

    @Autowired
    @Lazy
    public PcmAwardsWonsMapping pcmawardswonsMapping;

    @ApiOperation(value = "获取获奖情况草稿", tags = {"获奖情况" },  notes = "获取获奖情况草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmawardswons/getdraft")
    public ResponseEntity<PcmAwardsWonsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsMapping.toDto(pcmawardswonsService.getDraft(new PcmAwardsWons())));
    }

    @PostAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(returnObject.body),'ehr-PcmAwardsWons-Get')")
    @ApiOperation(value = "获取获奖情况", tags = {"获奖情况" },  notes = "获取获奖情况")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmawardswons/{pcmawardswons_id}")
    public ResponseEntity<PcmAwardsWonsDTO> get(@PathVariable("pcmawardswons_id") String pcmawardswons_id) {
        PcmAwardsWons domain = pcmawardswonsService.get(pcmawardswons_id);
        PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.get(#pcmawardswons_id),'ehr-PcmAwardsWons-Update')")
    @ApiOperation(value = "更新获奖情况", tags = {"获奖情况" },  notes = "更新获奖情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<PcmAwardsWonsDTO> update(@PathVariable("pcmawardswons_id") String pcmawardswons_id, @RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
		PcmAwardsWons domain  = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain .setPcmawardswonsid(pcmawardswons_id);
		pcmawardswonsService.update(domain );
		PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.getPcmawardswonsByEntities(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos)),'ehr-PcmAwardsWons-Update')")
    @ApiOperation(value = "批量更新获奖情况", tags = {"获奖情况" },  notes = "批量更新获奖情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        pcmawardswonsService.updateBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdto),'ehr-PcmAwardsWons-Create')")
    @ApiOperation(value = "新建获奖情况", tags = {"获奖情况" },  notes = "新建获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons")
    @Transactional
    public ResponseEntity<PcmAwardsWonsDTO> create(@RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        PcmAwardsWons domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
		pcmawardswonsService.create(domain);
        PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos),'ehr-PcmAwardsWons-Create')")
    @ApiOperation(value = "批量新建获奖情况", tags = {"获奖情况" },  notes = "批量新建获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        pcmawardswonsService.createBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查获奖情况", tags = {"获奖情况" },  notes = "检查获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.checkKey(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdto),'ehr-PcmAwardsWons-Save')")
    @ApiOperation(value = "保存获奖情况", tags = {"获奖情况" },  notes = "保存获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.save(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos),'ehr-PcmAwardsWons-Save')")
    @ApiOperation(value = "批量保存获奖情况", tags = {"获奖情况" },  notes = "批量保存获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        pcmawardswonsService.saveBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.get(#pcmawardswons_id),'ehr-PcmAwardsWons-Remove')")
    @ApiOperation(value = "删除获奖情况", tags = {"获奖情况" },  notes = "删除获奖情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmawardswons_id") String pcmawardswons_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.remove(pcmawardswons_id));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.getPcmawardswonsByIds(#ids),'ehr-PcmAwardsWons-Remove')")
    @ApiOperation(value = "批量删除获奖情况", tags = {"获奖情况" },  notes = "批量删除获奖情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmawardswonsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmAwardsWons-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"获奖情况" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmawardswons/fetchdefault")
	public ResponseEntity<List<PcmAwardsWonsDTO>> fetchDefault(PcmAwardsWonsSearchContext context) {
        Page<PcmAwardsWons> domains = pcmawardswonsService.searchDefault(context) ;
        List<PcmAwardsWonsDTO> list = pcmawardswonsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmAwardsWons-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"获奖情况" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmawardswons/searchdefault")
	public ResponseEntity<Page<PcmAwardsWonsDTO>> searchDefault(@RequestBody PcmAwardsWonsSearchContext context) {
        Page<PcmAwardsWons> domains = pcmawardswonsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmawardswonsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据应聘者基本信息获取获奖情况草稿", tags = {"获奖情况" },  notes = "根据应聘者基本信息获取获奖情况草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/getdraft")
    public ResponseEntity<PcmAwardsWonsDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmAwardsWons domain = new PcmAwardsWons();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsMapping.toDto(pcmawardswonsService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(returnObject.body),'ehr-PcmAwardsWons-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息获取获奖情况")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    public ResponseEntity<PcmAwardsWonsDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id) {
        PcmAwardsWons domain = pcmawardswonsService.get(pcmawardswons_id);
        PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.get(#pcmawardswons_id),'ehr-PcmAwardsWons-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息更新获奖情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<PcmAwardsWonsDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id, @RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        PcmAwardsWons domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmawardswonsid(pcmawardswons_id);
		pcmawardswonsService.update(domain);
        PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.getPcmawardswonsByEntities(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos)),'ehr-PcmAwardsWons-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息批量更新获奖情况")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        List<PcmAwardsWons> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PcmAwardsWons domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdto),'ehr-PcmAwardsWons-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息建立获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons")
    @Transactional
    public ResponseEntity<PcmAwardsWonsDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        PcmAwardsWons domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmawardswonsService.create(domain);
        PcmAwardsWonsDTO dto = pcmawardswonsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos),'ehr-PcmAwardsWons-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息批量建立获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        List<PcmAwardsWons> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PcmAwardsWons domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息检查获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息检查获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.checkKey(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdto),'ehr-PcmAwardsWons-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息保存获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmAwardsWonsDTO pcmawardswonsdto) {
        PcmAwardsWons domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsMapping.toDomain(#pcmawardswonsdtos),'ehr-PcmAwardsWons-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息批量保存获奖情况")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmAwardsWonsDTO> pcmawardswonsdtos) {
        List<PcmAwardsWons> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PcmAwardsWons domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.get(#pcmawardswons_id),'ehr-PcmAwardsWons-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息删除获奖情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.remove(pcmawardswons_id));
    }

    @PreAuthorize("hasPermission(this.pcmawardswonsService.getPcmawardswonsByIds(#ids),'ehr-PcmAwardsWons-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除获奖情况", tags = {"获奖情况" },  notes = "根据应聘者基本信息批量删除获奖情况")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmawardswonsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmAwardsWons-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"获奖情况" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmawardswons/fetchdefault")
	public ResponseEntity<List<PcmAwardsWonsDTO>> fetchPcmAwardsWonsDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmAwardsWonsSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmAwardsWons> domains = pcmawardswonsService.searchDefault(context) ;
        List<PcmAwardsWonsDTO> list = pcmawardswonsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmAwardsWons-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"获奖情况" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmawardswons/searchdefault")
	public ResponseEntity<Page<PcmAwardsWonsDTO>> searchPcmAwardsWonsDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmAwardsWonsSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmAwardsWons> domains = pcmawardswonsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmawardswonsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

