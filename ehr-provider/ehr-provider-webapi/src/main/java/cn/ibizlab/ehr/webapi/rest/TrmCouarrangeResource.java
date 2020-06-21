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
import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
import cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService;
import cn.ibizlab.ehr.core.trm.filter.TrmCouarrangeSearchContext;

@Slf4j
@Api(tags = {"培训记录" })
@RestController("WebApi-trmcouarrange")
@RequestMapping("")
public class TrmCouarrangeResource {

    @Autowired
    public ITrmCouarrangeService trmcouarrangeService;

    @Autowired
    @Lazy
    public TrmCouarrangeMapping trmcouarrangeMapping;

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "新建培训记录", tags = {"培训记录" },  notes = "新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> create(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "批量新建培训记录", tags = {"培训记录" },  notes = "批量新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.createBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "获取培训记录", tags = {"培训记录" },  notes = "获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> get(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "删除培训记录", tags = {"培训记录" },  notes = "删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "批量删除培训记录", tags = {"培训记录" },  notes = "批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训记录草稿", tags = {"培训记录" },  notes = "获取培训记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(new TrmCouarrange())));
    }

    @ApiOperation(value = "检查培训记录", tags = {"培训记录" },  notes = "检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "保存培训记录", tags = {"培训记录" },  notes = "保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "批量保存培训记录", tags = {"培训记录" },  notes = "批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.saveBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "更新培训记录", tags = {"培训记录" },  notes = "更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> update(@PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
		TrmCouarrange domain  = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain .setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain );
		TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "批量更新培训记录", tags = {"培训记录" },  notes = "批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.updateBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchDefault(TrmCouarrangeSearchContext context) {
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchDefault(@RequestBody TrmCouarrangeSearchContext context) {
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训模块建立培训记录", tags = {"培训记录" },  notes = "根据培训模块建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训模块批量建立培训记录", tags = {"培训记录" },  notes = "根据培训模块批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训模块获取培训记录", tags = {"培训记录" },  notes = "根据培训模块获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训模块删除培训记录", tags = {"培训记录" },  notes = "根据培训模块删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训模块批量删除培训记录", tags = {"培训记录" },  notes = "根据培训模块批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmCourseSystem(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训模块获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训模块获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训模块检查培训记录", tags = {"培训记录" },  notes = "根据培训模块检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训模块保存培训记录", tags = {"培训记录" },  notes = "根据培训模块保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训模块批量保存培训记录", tags = {"培训记录" },  notes = "根据培训模块批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训模块更新培训记录", tags = {"培训记录" },  notes = "根据培训模块更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训模块批量更新培训记录", tags = {"培训记录" },  notes = "根据培训模块批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训模块获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训模块获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id,TrmCouarrangeSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训模块查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训模块查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训场地建立培训记录", tags = {"培训记录" },  notes = "根据培训场地建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训场地批量建立培训记录", tags = {"培训记录" },  notes = "根据培训场地批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训场地获取培训记录", tags = {"培训记录" },  notes = "根据培训场地获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训场地删除培训记录", tags = {"培训记录" },  notes = "根据培训场地删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训场地批量删除培训记录", tags = {"培训记录" },  notes = "根据培训场地批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAddress(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训场地获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训场地获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训场地检查培训记录", tags = {"培训记录" },  notes = "根据培训场地检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训场地保存培训记录", tags = {"培训记录" },  notes = "根据培训场地保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训场地批量保存培训记录", tags = {"培训记录" },  notes = "根据培训场地批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训场地更新培训记录", tags = {"培训记录" },  notes = "根据培训场地更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训场地批量更新培训记录", tags = {"培训记录" },  notes = "根据培训场地批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训场地获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训场地获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id,TrmCouarrangeSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训场地查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训场地查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainaddresses/{trmtrainaddress_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构建立培训记录", tags = {"培训记录" },  notes = "根据培训机构建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构批量建立培训记录", tags = {"培训记录" },  notes = "根据培训机构批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训机构获取培训记录", tags = {"培训记录" },  notes = "根据培训机构获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构删除培训记录", tags = {"培训记录" },  notes = "根据培训机构删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构批量删除培训记录", tags = {"培训记录" },  notes = "根据培训机构批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgency(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训机构获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构检查培训记录", tags = {"培训记录" },  notes = "根据培训机构检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构保存培训记录", tags = {"培训记录" },  notes = "根据培训机构保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构批量保存培训记录", tags = {"培训记录" },  notes = "根据培训机构批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构更新培训记录", tags = {"培训记录" },  notes = "根据培训机构更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构批量更新培训记录", tags = {"培训记录" },  notes = "根据培训机构批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id,TrmCouarrangeSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训讲师建立培训记录", tags = {"培训记录" },  notes = "根据培训讲师建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训讲师批量建立培训记录", tags = {"培训记录" },  notes = "根据培训讲师批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训讲师获取培训记录", tags = {"培训记录" },  notes = "根据培训讲师获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训讲师删除培训记录", tags = {"培训记录" },  notes = "根据培训讲师删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训讲师批量删除培训记录", tags = {"培训记录" },  notes = "根据培训讲师批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainTeacher(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训讲师获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训讲师检查培训记录", tags = {"培训记录" },  notes = "根据培训讲师检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训讲师保存培训记录", tags = {"培训记录" },  notes = "根据培训讲师保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训讲师批量保存培训记录", tags = {"培训记录" },  notes = "根据培训讲师批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训讲师更新培训记录", tags = {"培训记录" },  notes = "根据培训讲师更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训讲师批量更新培训记录", tags = {"培训记录" },  notes = "根据培训讲师批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训讲师获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmCouarrangeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训讲师查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构培训模块建立培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构培训模块批量建立培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训机构培训模块获取培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构培训模块删除培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构培训模块批量删除培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmCourseSystem(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训模块获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训机构培训模块获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构培训模块检查培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构培训模块保存培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构培训模块批量保存培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构培训模块更新培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构培训模块批量更新培训记录", tags = {"培训记录" },  notes = "根据培训机构培训模块批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构培训模块获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构培训模块获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id,TrmCouarrangeSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构培训模块查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构培训模块查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构培训讲师建立培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构培训讲师批量建立培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训机构培训讲师获取培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师删除培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师批量删除培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmTrainTeacher(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训机构培训讲师获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构培训讲师检查培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构培训讲师保存培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构培训讲师批量保存培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构培训讲师更新培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构培训讲师批量更新培训记录", tags = {"培训记录" },  notes = "根据培训机构培训讲师批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmCouarrangeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

