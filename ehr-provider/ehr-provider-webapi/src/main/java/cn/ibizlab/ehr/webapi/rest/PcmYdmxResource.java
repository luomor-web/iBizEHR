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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdmxSearchContext;

@Slf4j
@Api(tags = {"异动明细" })
@RestController("WebApi-pcmydmx")
@RequestMapping("")
public class PcmYdmxResource {

    @Autowired
    public IPcmYdmxService pcmydmxService;

    @Autowired
    @Lazy
    public PcmYdmxMapping pcmydmxMapping;

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PcmYdmx-Create')")
    @ApiOperation(value = "新建异动明细", tags = {"异动明细" },  notes = "新建异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> create(@RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx domain = pcmydmxMapping.toDomain(pcmydmxdto);
		pcmydmxService.create(domain);
        PcmYdmxDTO dto = pcmydmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PcmYdmx-Create')")
    @ApiOperation(value = "批量新建异动明细", tags = {"异动明细" },  notes = "批量新建异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        pcmydmxService.createBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PcmYdmx-Save')")
    @ApiOperation(value = "保存异动明细", tags = {"异动明细" },  notes = "保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdmxDTO pcmydmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.save(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PcmYdmx-Save')")
    @ApiOperation(value = "批量保存异动明细", tags = {"异动明细" },  notes = "批量保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        pcmydmxService.saveBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"异动明细" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/{pcmydmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> fillPersonInfo(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx pcmydmx = pcmydmxMapping.toDomain(pcmydmxdto);
        pcmydmx.setPcmydmxid(pcmydmx_id);
        pcmydmx = pcmydmxService.fillPersonInfo(pcmydmx);
        pcmydmxdto = pcmydmxMapping.toDto(pcmydmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxdto);
    }

    @ApiOperation(value = "检查异动明细", tags = {"异动明细" },  notes = "检查异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdmxDTO pcmydmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.checkKey(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PcmYdmx-Remove')")
    @ApiOperation(value = "删除异动明细", tags = {"异动明细" },  notes = "删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydmx_id") String pcmydmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.remove(pcmydmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByIds(#ids),'ehr-PcmYdmx-Remove')")
    @ApiOperation(value = "批量删除异动明细", tags = {"异动明细" },  notes = "批量删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PcmYdmx-Update')")
    @ApiOperation(value = "更新异动明细", tags = {"异动明细" },  notes = "更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> update(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
		PcmYdmx domain  = pcmydmxMapping.toDomain(pcmydmxdto);
        domain .setPcmydmxid(pcmydmx_id);
		pcmydmxService.update(domain );
		PcmYdmxDTO dto = pcmydmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByEntities(this.pcmydmxMapping.toDomain(#pcmydmxdtos)),'ehr-PcmYdmx-Update')")
    @ApiOperation(value = "批量更新异动明细", tags = {"异动明细" },  notes = "批量更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        pcmydmxService.updateBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取异动明细草稿", tags = {"异动明细" },  notes = "获取异动明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/getdraft")
    public ResponseEntity<PcmYdmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxMapping.toDto(pcmydmxService.getDraft(new PcmYdmx())));
    }

    @PostAuthorize("hasPermission(this.pcmydmxMapping.toDomain(returnObject.body),'ehr-PcmYdmx-Get')")
    @ApiOperation(value = "获取异动明细", tags = {"异动明细" },  notes = "获取异动明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/{pcmydmx_id}")
    public ResponseEntity<PcmYdmxDTO> get(@PathVariable("pcmydmx_id") String pcmydmx_id) {
        PcmYdmx domain = pcmydmxService.get(pcmydmx_id);
        PcmYdmxDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-IndexDER-all')")
	@ApiOperation(value = "获取IndexDER", tags = {"异动明细" } ,notes = "获取IndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchindexder")
	public ResponseEntity<List<PcmYdmxDTO>> fetchIndexDER(PcmYdmxSearchContext context) {
        Page<PcmYdmx> domains = pcmydmxService.searchIndexDER(context) ;
        List<PcmYdmxDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-IndexDER-all')")
	@ApiOperation(value = "查询IndexDER", tags = {"异动明细" } ,notes = "查询IndexDER")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydmxes/searchindexder")
	public ResponseEntity<Page<PcmYdmxDTO>> searchIndexDER(@RequestBody PcmYdmxSearchContext context) {
        Page<PcmYdmx> domains = pcmydmxService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchdefault")
	public ResponseEntity<List<PcmYdmxDTO>> fetchDefault(PcmYdmxSearchContext context) {
        Page<PcmYdmx> domains = pcmydmxService.searchDefault(context) ;
        List<PcmYdmxDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydmxes/searchdefault")
	public ResponseEntity<Page<PcmYdmxDTO>> searchDefault(@RequestBody PcmYdmxSearchContext context) {
        Page<PcmYdmx> domains = pcmydmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PcmYdmx-Create')")
    @ApiOperation(value = "根据人员信息建立异动明细", tags = {"异动明细" },  notes = "根据人员信息建立异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx domain = pcmydmxMapping.toDomain(pcmydmxdto);
        domain.setPimpersonid(pimperson_id);
		pcmydmxService.create(domain);
        PcmYdmxDTO dto = pcmydmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PcmYdmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立异动明细", tags = {"异动明细" },  notes = "根据人员信息批量建立异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        List<PcmYdmx> domainlist=pcmydmxMapping.toDomain(pcmydmxdtos);
        for(PcmYdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmydmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PcmYdmx-Save')")
    @ApiOperation(value = "根据人员信息保存异动明细", tags = {"异动明细" },  notes = "根据人员信息保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx domain = pcmydmxMapping.toDomain(pcmydmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PcmYdmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存异动明细", tags = {"异动明细" },  notes = "根据人员信息批量保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        List<PcmYdmx> domainlist=pcmydmxMapping.toDomain(pcmydmxdtos);
        for(PcmYdmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pcmydmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-FillPersonInfo-all')")
    @ApiOperation(value = "根据人员信息异动明细", tags = {"异动明细" },  notes = "根据人员信息异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes/{pcmydmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> fillPersonInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx domain = pcmydmxMapping.toDomain(pcmydmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmydmxService.fillPersonInfo(domain) ;
        pcmydmxdto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxdto);
    }

    @ApiOperation(value = "根据人员信息检查异动明细", tags = {"异动明细" },  notes = "根据人员信息检查异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmydmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.checkKey(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PcmYdmx-Remove')")
    @ApiOperation(value = "根据人员信息删除异动明细", tags = {"异动明细" },  notes = "根据人员信息删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmydmx_id") String pcmydmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.remove(pcmydmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByIds(#ids),'ehr-PcmYdmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除异动明细", tags = {"异动明细" },  notes = "根据人员信息批量删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmydmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pcmydmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PcmYdmx-Update')")
    @ApiOperation(value = "根据人员信息更新异动明细", tags = {"异动明细" },  notes = "根据人员信息更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<PcmYdmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PcmYdmxDTO pcmydmxdto) {
        PcmYdmx domain = pcmydmxMapping.toDomain(pcmydmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPcmydmxid(pcmydmx_id);
		pcmydmxService.update(domain);
        PcmYdmxDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByEntities(this.pcmydmxMapping.toDomain(#pcmydmxdtos)),'ehr-PcmYdmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新异动明细", tags = {"异动明细" },  notes = "根据人员信息批量更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmydmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmYdmxDTO> pcmydmxdtos) {
        List<PcmYdmx> domainlist=pcmydmxMapping.toDomain(pcmydmxdtos);
        for(PcmYdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmydmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取异动明细草稿", tags = {"异动明细" },  notes = "根据人员信息获取异动明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmydmxes/getdraft")
    public ResponseEntity<PcmYdmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PcmYdmx domain = new PcmYdmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxMapping.toDto(pcmydmxService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pcmydmxMapping.toDomain(returnObject.body),'ehr-PcmYdmx-Get')")
    @ApiOperation(value = "根据人员信息获取异动明细", tags = {"异动明细" },  notes = "根据人员信息获取异动明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmydmxes/{pcmydmx_id}")
    public ResponseEntity<PcmYdmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmydmx_id") String pcmydmx_id) {
        PcmYdmx domain = pcmydmxService.get(pcmydmx_id);
        PcmYdmxDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-IndexDER-all')")
	@ApiOperation(value = "根据人员信息获取IndexDER", tags = {"异动明细" } ,notes = "根据人员信息获取IndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmydmxes/fetchindexder")
	public ResponseEntity<List<PcmYdmxDTO>> fetchPcmYdmxIndexDERByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmYdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmYdmx> domains = pcmydmxService.searchIndexDER(context) ;
        List<PcmYdmxDTO> list = pcmydmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-IndexDER-all')")
	@ApiOperation(value = "根据人员信息查询IndexDER", tags = {"异动明细" } ,notes = "根据人员信息查询IndexDER")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmydmxes/searchindexder")
	public ResponseEntity<Page<PcmYdmxDTO>> searchPcmYdmxIndexDERByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmYdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmYdmx> domains = pcmydmxService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"异动明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmydmxes/fetchdefault")
	public ResponseEntity<List<PcmYdmxDTO>> fetchPcmYdmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmYdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmYdmx> domains = pcmydmxService.searchDefault(context) ;
        List<PcmYdmxDTO> list = pcmydmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdmx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"异动明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmydmxes/searchdefault")
	public ResponseEntity<Page<PcmYdmxDTO>> searchPcmYdmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmYdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmYdmx> domains = pcmydmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

