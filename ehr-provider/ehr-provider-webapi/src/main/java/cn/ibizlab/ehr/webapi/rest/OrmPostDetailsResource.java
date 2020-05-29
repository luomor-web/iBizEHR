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
import cn.ibizlab.ehr.core.orm.domain.OrmPostDetails;
import cn.ibizlab.ehr.core.orm.service.IOrmPostDetailsService;
import cn.ibizlab.ehr.core.orm.filter.OrmPostDetailsSearchContext;

@Slf4j
@Api(tags = {"岗位明细" })
@RestController("WebApi-ormpostdetails")
@RequestMapping("")
public class OrmPostDetailsResource {

    @Autowired
    public IOrmPostDetailsService ormpostdetailsService;

    @Autowired
    @Lazy
    public OrmPostDetailsMapping ormpostdetailsMapping;

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "新建岗位明细", tags = {"岗位明细" },  notes = "新建岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> create(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "批量新建岗位明细", tags = {"岗位明细" },  notes = "批量新建岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.createBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "获取岗位明细", tags = {"岗位明细" },  notes = "获取岗位明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> get(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查岗位明细", tags = {"岗位明细" },  notes = "检查岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "更新岗位明细", tags = {"岗位明细" },  notes = "更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> update(@PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
		OrmPostDetails domain  = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain .setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain );
		OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "批量更新岗位明细", tags = {"岗位明细" },  notes = "批量更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.updateBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位明细草稿", tags = {"岗位明细" },  notes = "获取岗位明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(new OrmPostDetails())));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "保存岗位明细", tags = {"岗位明细" },  notes = "保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "批量保存岗位明细", tags = {"岗位明细" },  notes = "批量保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.saveBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "删除岗位明细", tags = {"岗位明细" },  notes = "删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "批量删除岗位明细", tags = {"岗位明细" },  notes = "批量删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchDefault(OrmPostDetailsSearchContext context) {
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchDefault(@RequestBody OrmPostDetailsSearchContext context) {
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据岗位库建立岗位明细", tags = {"岗位明细" },  notes = "根据岗位库建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据岗位库批量建立岗位明细", tags = {"岗位明细" },  notes = "根据岗位库批量建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "根据岗位库获取岗位明细", tags = {"岗位明细" },  notes = "根据岗位库获取岗位明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据岗位库检查岗位明细", tags = {"岗位明细" },  notes = "根据岗位库检查岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据岗位库更新岗位明细", tags = {"岗位明细" },  notes = "根据岗位库更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据岗位库批量更新岗位明细", tags = {"岗位明细" },  notes = "根据岗位库批量更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据岗位库获取岗位明细草稿", tags = {"岗位明细" },  notes = "根据岗位库获取岗位明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据岗位库保存岗位明细", tags = {"岗位明细" },  notes = "根据岗位库保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据岗位库批量保存岗位明细", tags = {"岗位明细" },  notes = "根据岗位库批量保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据岗位库删除岗位明细", tags = {"岗位明细" },  notes = "根据岗位库删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据岗位库批量删除岗位明细", tags = {"岗位明细" },  notes = "根据岗位库批量删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPostLib(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据岗位库获取DEFAULT", tags = {"岗位明细" } ,notes = "根据岗位库获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据岗位库查询DEFAULT", tags = {"岗位明细" } ,notes = "根据岗位库查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据岗位建立岗位明细", tags = {"岗位明细" },  notes = "根据岗位建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据岗位批量建立岗位明细", tags = {"岗位明细" },  notes = "根据岗位批量建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "根据岗位获取岗位明细", tags = {"岗位明细" },  notes = "根据岗位获取岗位明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据岗位检查岗位明细", tags = {"岗位明细" },  notes = "根据岗位检查岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据岗位更新岗位明细", tags = {"岗位明细" },  notes = "根据岗位更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据岗位批量更新岗位明细", tags = {"岗位明细" },  notes = "根据岗位批量更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据岗位获取岗位明细草稿", tags = {"岗位明细" },  notes = "根据岗位获取岗位明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmPost(@PathVariable("ormpost_id") String ormpost_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据岗位保存岗位明细", tags = {"岗位明细" },  notes = "根据岗位保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据岗位批量保存岗位明细", tags = {"岗位明细" },  notes = "根据岗位批量保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据岗位删除岗位明细", tags = {"岗位明细" },  notes = "根据岗位删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据岗位批量删除岗位明细", tags = {"岗位明细" },  notes = "根据岗位批量删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPost(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据岗位获取DEFAULT", tags = {"岗位明细" } ,notes = "根据岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据岗位查询DEFAULT", tags = {"岗位明细" } ,notes = "根据岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据组织管理岗位建立岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "根据组织管理岗位批量建立岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位批量建立岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "根据组织管理岗位获取岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位获取岗位明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理岗位检查岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位检查岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据组织管理岗位更新岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "根据组织管理岗位批量更新岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位批量更新岗位明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理岗位获取岗位明细草稿", tags = {"岗位明细" },  notes = "根据组织管理岗位获取岗位明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据组织管理岗位保存岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "根据组织管理岗位批量保存岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位批量保存岗位明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据组织管理岗位删除岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "根据组织管理岗位批量删除岗位明细", tags = {"岗位明细" },  notes = "根据组织管理岗位批量删除岗位明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmPost(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据组织管理岗位获取DEFAULT", tags = {"岗位明细" } ,notes = "根据组织管理岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "根据组织管理岗位查询DEFAULT", tags = {"岗位明细" } ,notes = "根据组织管理岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

