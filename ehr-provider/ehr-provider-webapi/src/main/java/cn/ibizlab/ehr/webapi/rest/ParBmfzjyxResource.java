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
import cn.ibizlab.ehr.core.par.domain.ParBmfzjyx;
import cn.ibizlab.ehr.core.par.service.IParBmfzjyxService;
import cn.ibizlab.ehr.core.par.filter.ParBmfzjyxSearchContext;

@Slf4j
@Api(tags = {"通知选择部门副职及以下" })
@RestController("WebApi-parbmfzjyx")
@RequestMapping("")
public class ParBmfzjyxResource {

    @Autowired
    public IParBmfzjyxService parbmfzjyxService;

    @Autowired
    @Lazy
    public ParBmfzjyxMapping parbmfzjyxMapping;

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "批量保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "批量保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        parbmfzjyxService.saveBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取通知选择部门副职及以下草稿", tags = {"通知选择部门副职及以下" },  notes = "获取通知选择部门副职及以下草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/getdraft")
    public ResponseEntity<ParBmfzjyxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(new ParBmfzjyx())));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "新建通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "新建通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> create(@RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
		parbmfzjyxService.create(domain);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "批量新建通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "批量新建通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        parbmfzjyxService.createBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "检查通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "批量删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "批量删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> update(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
		ParBmfzjyx domain  = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain .setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain );
		ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "批量更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "批量更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        parbmfzjyxService.updateBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-ParBmfzjyx-Get')")
    @ApiOperation(value = "获取通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "获取通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<ParBmfzjyxDTO> get(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        ParBmfzjyx domain = parbmfzjyxService.get(parbmfzjyx_id);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<ParBmfzjyxDTO>> fetchDefault(ParBmfzjyxSearchContext context) {
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
        List<ParBmfzjyxDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<ParBmfzjyxDTO>> searchDefault(@RequestBody ParBmfzjyxSearchContext context) {
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "根据通知发布保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/save")
    public ResponseEntity<Boolean> saveByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "根据通知发布批量保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布批量保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据通知发布获取通知选择部门副职及以下草稿", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布获取通知选择部门副职及以下草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parbmfzjyxes/getdraft")
    public ResponseEntity<ParBmfzjyxDTO> getDraftByParTzgg(@PathVariable("partzgg_id") String partzgg_id) {
        ParBmfzjyx domain = new ParBmfzjyx();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "根据通知发布建立通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布建立通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> createByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
		parbmfzjyxService.create(domain);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "根据通知发布批量建立通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布批量建立通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据通知发布检查通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布检查通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "根据通知发布删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "根据通知发布批量删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布批量删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatchByParTzgg(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "根据通知发布更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> updateByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "根据通知发布批量更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布批量更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-ParBmfzjyx-Get')")
    @ApiOperation(value = "根据通知发布获取通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据通知发布获取通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<ParBmfzjyxDTO> getByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        ParBmfzjyx domain = parbmfzjyxService.get(parbmfzjyx_id);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "根据通知发布获取DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "根据通知发布获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<ParBmfzjyxDTO>> fetchParBmfzjyxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id,ParBmfzjyxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
        List<ParBmfzjyxDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "根据通知发布查询DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "根据通知发布查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<ParBmfzjyxDTO>> searchParBmfzjyxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParBmfzjyxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "根据人员信息保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Save')")
    @ApiOperation(value = "根据人员信息批量保存通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息批量保存通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取通知选择部门副职及以下草稿", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息获取通知选择部门副职及以下草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/getdraft")
    public ResponseEntity<ParBmfzjyxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ParBmfzjyx domain = new ParBmfzjyx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "根据人员信息建立通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息建立通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
		parbmfzjyxService.create(domain);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-ParBmfzjyx-Create')")
    @ApiOperation(value = "根据人员信息批量建立通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息批量建立通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息检查通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "根据人员信息删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-ParBmfzjyx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息批量删除通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "根据人员信息更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<ParBmfzjyxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody ParBmfzjyxDTO parbmfzjyxdto) {
        ParBmfzjyx domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-ParBmfzjyx-Update')")
    @ApiOperation(value = "根据人员信息批量更新通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息批量更新通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParBmfzjyxDTO> parbmfzjyxdtos) {
        List<ParBmfzjyx> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(ParBmfzjyx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-ParBmfzjyx-Get')")
    @ApiOperation(value = "根据人员信息获取通知选择部门副职及以下", tags = {"通知选择部门副职及以下" },  notes = "根据人员信息获取通知选择部门副职及以下")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<ParBmfzjyxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        ParBmfzjyx domain = parbmfzjyxService.get(parbmfzjyx_id);
        ParBmfzjyxDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<ParBmfzjyxDTO>> fetchParBmfzjyxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ParBmfzjyxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
        List<ParBmfzjyxDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParBmfzjyx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"通知选择部门副职及以下" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<ParBmfzjyxDTO>> searchParBmfzjyxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParBmfzjyxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParBmfzjyx> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

