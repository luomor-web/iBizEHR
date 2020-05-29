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
import cn.ibizlab.ehr.core.pim.domain.PIMTITLE;
import cn.ibizlab.ehr.core.pim.service.IPIMTITLEService;
import cn.ibizlab.ehr.core.pim.filter.PIMTITLESearchContext;

@Slf4j
@Api(tags = {"职称信息" })
@RestController("WebApi-pimtitle")
@RequestMapping("")
public class PIMTITLEResource {

    @Autowired
    public IPIMTITLEService pimtitleService;

    @Autowired
    @Lazy
    public PIMTITLEMapping pimtitleMapping;

    @ApiOperation(value = "检查职称信息", tags = {"职称信息" },  notes = "检查职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMTITLEDTO pimtitledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtitleService.checkKey(pimtitleMapping.toDomain(pimtitledto)));
    }

    @PreAuthorize("hasPermission(this.pimtitleService.get(#pimtitle_id),'ehr-PIMTITLE-Update')")
    @ApiOperation(value = "更新职称信息", tags = {"职称信息" },  notes = "更新职称信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitles/{pimtitle_id}")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> update(@PathVariable("pimtitle_id") String pimtitle_id, @RequestBody PIMTITLEDTO pimtitledto) {
		PIMTITLE domain  = pimtitleMapping.toDomain(pimtitledto);
        domain .setPimtitleid(pimtitle_id);
		pimtitleService.update(domain );
		PIMTITLEDTO dto = pimtitleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleService.getPimtitleByEntities(this.pimtitleMapping.toDomain(#pimtitledtos)),'ehr-PIMTITLE-Update')")
    @ApiOperation(value = "批量更新职称信息", tags = {"职称信息" },  notes = "批量更新职称信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMTITLEDTO> pimtitledtos) {
        pimtitleService.updateBatch(pimtitleMapping.toDomain(pimtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledto),'ehr-PIMTITLE-Create')")
    @ApiOperation(value = "新建职称信息", tags = {"职称信息" },  notes = "新建职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> create(@RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE domain = pimtitleMapping.toDomain(pimtitledto);
		pimtitleService.create(domain);
        PIMTITLEDTO dto = pimtitleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledtos),'ehr-PIMTITLE-Create')")
    @ApiOperation(value = "批量新建职称信息", tags = {"职称信息" },  notes = "批量新建职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMTITLEDTO> pimtitledtos) {
        pimtitleService.createBatch(pimtitleMapping.toDomain(pimtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取职称信息草稿", tags = {"职称信息" },  notes = "获取职称信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitles/getdraft")
    public ResponseEntity<PIMTITLEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitleMapping.toDto(pimtitleService.getDraft(new PIMTITLE())));
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledto),'ehr-PIMTITLE-Save')")
    @ApiOperation(value = "保存职称信息", tags = {"职称信息" },  notes = "保存职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMTITLEDTO pimtitledto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitleService.save(pimtitleMapping.toDomain(pimtitledto)));
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledtos),'ehr-PIMTITLE-Save')")
    @ApiOperation(value = "批量保存职称信息", tags = {"职称信息" },  notes = "批量保存职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMTITLEDTO> pimtitledtos) {
        pimtitleService.saveBatch(pimtitleMapping.toDomain(pimtitledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-EnsureHighestTech-all')")
    @ApiOperation(value = "确认唯一最高职称", tags = {"职称信息" },  notes = "确认唯一最高职称")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitles/{pimtitle_id}/ensurehighesttech")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> ensureHighestTech(@PathVariable("pimtitle_id") String pimtitle_id, @RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE pimtitle = pimtitleMapping.toDomain(pimtitledto);
        pimtitle.setPimtitleid(pimtitle_id);
        pimtitle = pimtitleService.ensureHighestTech(pimtitle);
        pimtitledto = pimtitleMapping.toDto(pimtitle);
        return ResponseEntity.status(HttpStatus.OK).body(pimtitledto);
    }

    @PostAuthorize("hasPermission(this.pimtitleMapping.toDomain(returnObject.body),'ehr-PIMTITLE-Get')")
    @ApiOperation(value = "获取职称信息", tags = {"职称信息" },  notes = "获取职称信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitles/{pimtitle_id}")
    public ResponseEntity<PIMTITLEDTO> get(@PathVariable("pimtitle_id") String pimtitle_id) {
        PIMTITLE domain = pimtitleService.get(pimtitle_id);
        PIMTITLEDTO dto = pimtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleService.get(#pimtitle_id),'ehr-PIMTITLE-Remove')")
    @ApiOperation(value = "删除职称信息", tags = {"职称信息" },  notes = "删除职称信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitles/{pimtitle_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtitle_id") String pimtitle_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtitleService.remove(pimtitle_id));
    }

    @PreAuthorize("hasPermission(this.pimtitleService.getPimtitleByIds(#ids),'ehr-PIMTITLE-Remove')")
    @ApiOperation(value = "批量删除职称信息", tags = {"职称信息" },  notes = "批量删除职称信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtitleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职称信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitles/fetchdefault")
	public ResponseEntity<List<PIMTITLEDTO>> fetchDefault(PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchDefault(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职称信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitles/searchdefault")
	public ResponseEntity<Page<PIMTITLEDTO>> searchDefault(@RequestBody PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-JLSS-all')")
	@ApiOperation(value = "获取记录所属", tags = {"职称信息" } ,notes = "获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitles/fetchjlss")
	public ResponseEntity<List<PIMTITLEDTO>> fetchJLSS(PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchJLSS(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-JLSS-all')")
	@ApiOperation(value = "查询记录所属", tags = {"职称信息" } ,notes = "查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitles/searchjlss")
	public ResponseEntity<Page<PIMTITLEDTO>> searchJLSS(@RequestBody PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-AscriptionSys-all')")
	@ApiOperation(value = "获取职称记录所属是管理员的", tags = {"职称信息" } ,notes = "获取职称记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitles/fetchascriptionsys")
	public ResponseEntity<List<PIMTITLEDTO>> fetchAscriptionSys(PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchAscriptionSys(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-AscriptionSys-all')")
	@ApiOperation(value = "查询职称记录所属是管理员的", tags = {"职称信息" } ,notes = "查询职称记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitles/searchascriptionsys")
	public ResponseEntity<Page<PIMTITLEDTO>> searchAscriptionSys(@RequestBody PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchAscriptionSys(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-REP_TITLE-all')")
	@ApiOperation(value = "获取职称分布", tags = {"职称信息" } ,notes = "获取职称分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitles/fetchrep_title")
	public ResponseEntity<List<HashMap>> fetchREP_TITLE(PIMTITLESearchContext context) {
        Page<HashMap> domains = pimtitleService.searchREP_TITLE(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-REP_TITLE-all')")
	@ApiOperation(value = "查询职称分布", tags = {"职称信息" } ,notes = "查询职称分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitles/searchrep_title")
	public ResponseEntity<Page<HashMap>> searchREP_TITLE(@RequestBody PIMTITLESearchContext context) {
        Page<HashMap> domains = pimtitleService.searchREP_TITLE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-ZIZHU-all')")
	@ApiOperation(value = "获取自助(职称信息)", tags = {"职称信息" } ,notes = "获取自助(职称信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitles/fetchzizhu")
	public ResponseEntity<List<PIMTITLEDTO>> fetchZIZHU(PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchZIZHU(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-ZIZHU-all')")
	@ApiOperation(value = "查询自助(职称信息)", tags = {"职称信息" } ,notes = "查询自助(职称信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitles/searchzizhu")
	public ResponseEntity<Page<PIMTITLEDTO>> searchZIZHU(@RequestBody PIMTITLESearchContext context) {
        Page<PIMTITLE> domains = pimtitleService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息检查职称信息", tags = {"职称信息" },  notes = "根据人员信息检查职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLEDTO pimtitledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtitleService.checkKey(pimtitleMapping.toDomain(pimtitledto)));
    }

    @PreAuthorize("hasPermission(this.pimtitleService.get(#pimtitle_id),'ehr-PIMTITLE-Update')")
    @ApiOperation(value = "根据人员信息更新职称信息", tags = {"职称信息" },  notes = "根据人员信息更新职称信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimtitles/{pimtitle_id}")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimtitle_id") String pimtitle_id, @RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE domain = pimtitleMapping.toDomain(pimtitledto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimtitleid(pimtitle_id);
		pimtitleService.update(domain);
        PIMTITLEDTO dto = pimtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleService.getPimtitleByEntities(this.pimtitleMapping.toDomain(#pimtitledtos)),'ehr-PIMTITLE-Update')")
    @ApiOperation(value = "根据人员信息批量更新职称信息", tags = {"职称信息" },  notes = "根据人员信息批量更新职称信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimtitles/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMTITLEDTO> pimtitledtos) {
        List<PIMTITLE> domainlist=pimtitleMapping.toDomain(pimtitledtos);
        for(PIMTITLE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimtitleService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledto),'ehr-PIMTITLE-Create')")
    @ApiOperation(value = "根据人员信息建立职称信息", tags = {"职称信息" },  notes = "根据人员信息建立职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE domain = pimtitleMapping.toDomain(pimtitledto);
        domain.setPimpersonid(pimperson_id);
		pimtitleService.create(domain);
        PIMTITLEDTO dto = pimtitleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledtos),'ehr-PIMTITLE-Create')")
    @ApiOperation(value = "根据人员信息批量建立职称信息", tags = {"职称信息" },  notes = "根据人员信息批量建立职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMTITLEDTO> pimtitledtos) {
        List<PIMTITLE> domainlist=pimtitleMapping.toDomain(pimtitledtos);
        for(PIMTITLE domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimtitleService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取职称信息草稿", tags = {"职称信息" },  notes = "根据人员信息获取职称信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimtitles/getdraft")
    public ResponseEntity<PIMTITLEDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PIMTITLE domain = new PIMTITLE();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimtitleMapping.toDto(pimtitleService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledto),'ehr-PIMTITLE-Save')")
    @ApiOperation(value = "根据人员信息保存职称信息", tags = {"职称信息" },  notes = "根据人员信息保存职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE domain = pimtitleMapping.toDomain(pimtitledto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimtitleService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimtitleMapping.toDomain(#pimtitledtos),'ehr-PIMTITLE-Save')")
    @ApiOperation(value = "根据人员信息批量保存职称信息", tags = {"职称信息" },  notes = "根据人员信息批量保存职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMTITLEDTO> pimtitledtos) {
        List<PIMTITLE> domainlist=pimtitleMapping.toDomain(pimtitledtos);
        for(PIMTITLE domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimtitleService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-EnsureHighestTech-all')")
    @ApiOperation(value = "根据人员信息职称信息", tags = {"职称信息" },  notes = "根据人员信息职称信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimtitles/{pimtitle_id}/ensurehighesttech")
    @Transactional
    public ResponseEntity<PIMTITLEDTO> ensureHighestTechByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimtitle_id") String pimtitle_id, @RequestBody PIMTITLEDTO pimtitledto) {
        PIMTITLE domain = pimtitleMapping.toDomain(pimtitledto);
        domain.setPimpersonid(pimperson_id);
        domain = pimtitleService.ensureHighestTech(domain) ;
        pimtitledto = pimtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimtitledto);
    }

    @PostAuthorize("hasPermission(this.pimtitleMapping.toDomain(returnObject.body),'ehr-PIMTITLE-Get')")
    @ApiOperation(value = "根据人员信息获取职称信息", tags = {"职称信息" },  notes = "根据人员信息获取职称信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimtitles/{pimtitle_id}")
    public ResponseEntity<PIMTITLEDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimtitle_id") String pimtitle_id) {
        PIMTITLE domain = pimtitleService.get(pimtitle_id);
        PIMTITLEDTO dto = pimtitleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitleService.get(#pimtitle_id),'ehr-PIMTITLE-Remove')")
    @ApiOperation(value = "根据人员信息删除职称信息", tags = {"职称信息" },  notes = "根据人员信息删除职称信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimtitles/{pimtitle_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimtitle_id") String pimtitle_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimtitleService.remove(pimtitle_id));
    }

    @PreAuthorize("hasPermission(this.pimtitleService.getPimtitleByIds(#ids),'ehr-PIMTITLE-Remove')")
    @ApiOperation(value = "根据人员信息批量删除职称信息", tags = {"职称信息" },  notes = "根据人员信息批量删除职称信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimtitles/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimtitleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"职称信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimtitles/fetchdefault")
	public ResponseEntity<List<PIMTITLEDTO>> fetchPIMTITLEDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchDefault(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"职称信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimtitles/searchdefault")
	public ResponseEntity<Page<PIMTITLEDTO>> searchPIMTITLEDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属", tags = {"职称信息" } ,notes = "根据人员信息获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimtitles/fetchjlss")
	public ResponseEntity<List<PIMTITLEDTO>> fetchPIMTITLEJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchJLSS(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属", tags = {"职称信息" } ,notes = "根据人员信息查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimtitles/searchjlss")
	public ResponseEntity<Page<PIMTITLEDTO>> searchPIMTITLEJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-AscriptionSys-all')")
	@ApiOperation(value = "根据人员信息获取职称记录所属是管理员的", tags = {"职称信息" } ,notes = "根据人员信息获取职称记录所属是管理员的")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimtitles/fetchascriptionsys")
	public ResponseEntity<List<PIMTITLEDTO>> fetchPIMTITLEAscriptionSysByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchAscriptionSys(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-AscriptionSys-all')")
	@ApiOperation(value = "根据人员信息查询职称记录所属是管理员的", tags = {"职称信息" } ,notes = "根据人员信息查询职称记录所属是管理员的")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimtitles/searchascriptionsys")
	public ResponseEntity<Page<PIMTITLEDTO>> searchPIMTITLEAscriptionSysByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchAscriptionSys(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-REP_TITLE-all')")
	@ApiOperation(value = "根据人员信息获取职称分布", tags = {"职称信息" } ,notes = "根据人员信息获取职称分布")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimtitles/fetchrep_title")
	public ResponseEntity<List<HashMap>> fetchPIMTITLEREP_TITLEByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimtitleService.searchREP_TITLE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-REP_TITLE-all')")
	@ApiOperation(value = "根据人员信息查询职称分布", tags = {"职称信息" } ,notes = "根据人员信息查询职称分布")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimtitles/searchrep_title")
	public ResponseEntity<Page<HashMap>> searchPIMTITLEREP_TITLEByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimtitleService.searchREP_TITLE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(职称信息)", tags = {"职称信息" } ,notes = "根据人员信息获取自助(职称信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimtitles/fetchzizhu")
	public ResponseEntity<List<PIMTITLEDTO>> fetchPIMTITLEZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchZIZHU(context) ;
        List<PIMTITLEDTO> list = pimtitleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLE-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(职称信息)", tags = {"职称信息" } ,notes = "根据人员信息查询自助(职称信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimtitles/searchzizhu")
	public ResponseEntity<Page<PIMTITLEDTO>> searchPIMTITLEZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMTITLESearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMTITLE> domains = pimtitleService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

