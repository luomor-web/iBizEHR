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
import cn.ibizlab.ehr.core.pim.domain.PimPatent;
import cn.ibizlab.ehr.core.pim.service.IPimPatentService;
import cn.ibizlab.ehr.core.pim.filter.PimPatentSearchContext;

@Slf4j
@Api(tags = {"专利信息" })
@RestController("WebApi-pimpatent")
@RequestMapping("")
public class PimPatentResource {

    @Autowired
    public IPimPatentService pimpatentService;

    @Autowired
    @Lazy
    public PimPatentMapping pimpatentMapping;

    @PostAuthorize("hasPermission(this.pimpatentMapping.toDomain(returnObject.body),'ehr-PimPatent-Get')")
    @ApiOperation(value = "获取专利信息", tags = {"专利信息" },  notes = "获取专利信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/{pimpatent_id}")
    public ResponseEntity<PimPatentDTO> get(@PathVariable("pimpatent_id") String pimpatent_id) {
        PimPatent domain = pimpatentService.get(pimpatent_id);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取专利信息草稿", tags = {"专利信息" },  notes = "获取专利信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpatents/getdraft")
    public ResponseEntity<PimPatentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(new PimPatent())));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Update')")
    @ApiOperation(value = "更新专利信息", tags = {"专利信息" },  notes = "更新专利信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PimPatentDTO> update(@PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PimPatentDTO pimpatentdto) {
		PimPatent domain  = pimpatentMapping.toDomain(pimpatentdto);
        domain .setPimpatentid(pimpatent_id);
		pimpatentService.update(domain );
		PimPatentDTO dto = pimpatentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByEntities(this.pimpatentMapping.toDomain(#pimpatentdtos)),'ehr-PimPatent-Update')")
    @ApiOperation(value = "批量更新专利信息", tags = {"专利信息" },  notes = "批量更新专利信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.updateBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Create')")
    @ApiOperation(value = "新建专利信息", tags = {"专利信息" },  notes = "新建专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents")
    @Transactional
    public ResponseEntity<PimPatentDTO> create(@RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
		pimpatentService.create(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Create')")
    @ApiOperation(value = "批量新建专利信息", tags = {"专利信息" },  notes = "批量新建专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.createBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Save')")
    @ApiOperation(value = "保存专利信息", tags = {"专利信息" },  notes = "保存专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPatentDTO pimpatentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Save')")
    @ApiOperation(value = "批量保存专利信息", tags = {"专利信息" },  notes = "批量保存专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPatentDTO> pimpatentdtos) {
        pimpatentService.saveBatch(pimpatentMapping.toDomain(pimpatentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "删除专利信息", tags = {"专利信息" },  notes = "删除专利信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpatent_id") String pimpatent_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByIds(#ids),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "批量删除专利信息", tags = {"专利信息" },  notes = "批量删除专利信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查专利信息", tags = {"专利信息" },  notes = "检查专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPatentDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"专利信息" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PimPatentDTO>> fetchJLSSGLY(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"专利信息" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PimPatentDTO>> searchJLSSGLY(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"专利信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchdefault")
	public ResponseEntity<List<PimPatentDTO>> fetchDefault(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"专利信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchdefault")
	public ResponseEntity<Page<PimPatentDTO>> searchDefault(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"专利信息" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PimPatentDTO>> fetchJLSSGR(PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"专利信息" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PimPatentDTO>> searchJLSSGR(@RequestBody PimPatentSearchContext context) {
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimpatentMapping.toDomain(returnObject.body),'ehr-PimPatent-Get')")
    @ApiOperation(value = "根据人员信息获取专利信息", tags = {"专利信息" },  notes = "根据人员信息获取专利信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    public ResponseEntity<PimPatentDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
        PimPatent domain = pimpatentService.get(pimpatent_id);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取专利信息草稿", tags = {"专利信息" },  notes = "根据人员信息获取专利信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpatents/getdraft")
    public ResponseEntity<PimPatentDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimPatent domain = new PimPatent();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentMapping.toDto(pimpatentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Update')")
    @ApiOperation(value = "根据人员信息更新专利信息", tags = {"专利信息" },  notes = "根据人员信息更新专利信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<PimPatentDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpatentid(pimpatent_id);
		pimpatentService.update(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByEntities(this.pimpatentMapping.toDomain(#pimpatentdtos)),'ehr-PimPatent-Update')")
    @ApiOperation(value = "根据人员信息批量更新专利信息", tags = {"专利信息" },  notes = "根据人员信息批量更新专利信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Create')")
    @ApiOperation(value = "根据人员信息建立专利信息", tags = {"专利信息" },  notes = "根据人员信息建立专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents")
    @Transactional
    public ResponseEntity<PimPatentDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
		pimpatentService.create(domain);
        PimPatentDTO dto = pimpatentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Create')")
    @ApiOperation(value = "根据人员信息批量建立专利信息", tags = {"专利信息" },  notes = "根据人员信息批量建立专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdto),'ehr-PimPatent-Save')")
    @ApiOperation(value = "根据人员信息保存专利信息", tags = {"专利信息" },  notes = "根据人员信息保存专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        PimPatent domain = pimpatentMapping.toDomain(pimpatentdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpatentMapping.toDomain(#pimpatentdtos),'ehr-PimPatent-Save')")
    @ApiOperation(value = "根据人员信息批量保存专利信息", tags = {"专利信息" },  notes = "根据人员信息批量保存专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPatentDTO> pimpatentdtos) {
        List<PimPatent> domainlist=pimpatentMapping.toDomain(pimpatentdtos);
        for(PimPatent domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpatentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpatentService.get(#pimpatent_id),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "根据人员信息删除专利信息", tags = {"专利信息" },  notes = "根据人员信息删除专利信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/{pimpatent_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpatent_id") String pimpatent_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpatentService.remove(pimpatent_id));
    }

    @PreAuthorize("hasPermission(this.pimpatentService.getPimpatentByIds(#ids),'ehr-PimPatent-Remove')")
    @ApiOperation(value = "根据人员信息批量删除专利信息", tags = {"专利信息" },  notes = "根据人员信息批量删除专利信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpatents/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimpatentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查专利信息", tags = {"专利信息" },  notes = "根据人员信息检查专利信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpatents/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentDTO pimpatentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpatentService.checkKey(pimpatentMapping.toDomain(pimpatentdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"专利信息" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgly")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"专利信息" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgly")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"专利信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchdefault")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"专利信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchdefault")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"专利信息" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpatents/fetchjlssgr")
	public ResponseEntity<List<PimPatentDTO>> fetchPimPatentJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
        List<PimPatentDTO> list = pimpatentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPatent-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"专利信息" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpatents/searchjlssgr")
	public ResponseEntity<Page<PimPatentDTO>> searchPimPatentJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPatentSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPatent> domains = pimpatentService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpatentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

