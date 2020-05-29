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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesRecord;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesRecordService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesRecordSearchContext;

@Slf4j
@Api(tags = {"档案目录缺失记录" })
@RestController("WebApi-pimarchivesrecord")
@RequestMapping("")
public class PimArchivesRecordResource {

    @Autowired
    public IPimArchivesRecordService pimarchivesrecordService;

    @Autowired
    @Lazy
    public PimArchivesRecordMapping pimarchivesrecordMapping;

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "新建档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "新建档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> create(@RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
		pimarchivesrecordService.create(domain);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "批量新建档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "批量新建档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.createBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "批量保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "批量保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.saveBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> update(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
		PimArchivesRecord domain  = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain .setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain );
		PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByEntities(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos)),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "批量更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "批量更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.updateBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "检查档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PostAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(returnObject.body),'ehr-PimArchivesRecord-Get')")
    @ApiOperation(value = "获取档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "获取档案目录缺失记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PimArchivesRecordDTO> get(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PimArchivesRecord domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取档案目录缺失记录草稿", tags = {"档案目录缺失记录" },  notes = "获取档案目录缺失记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesrecords/getdraft")
    public ResponseEntity<PimArchivesRecordDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(new PimArchivesRecord())));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByIds(#ids),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "批量删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "批量删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案目录缺失记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PimArchivesRecordDTO>> fetchDefault(PimArchivesRecordSearchContext context) {
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PimArchivesRecordDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"档案目录缺失记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PimArchivesRecordDTO>> searchDefault(@RequestBody PimArchivesRecordSearchContext context) {
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "根据档案信息建立档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息建立档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> createByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesrecordService.create(domain);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "根据档案信息批量建立档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息批量建立档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "根据档案信息保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/save")
    public ResponseEntity<Boolean> saveByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "根据档案信息批量保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息批量保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "根据档案信息更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> updateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByEntities(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos)),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "根据档案信息批量更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息批量更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据档案信息检查档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息检查档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PostAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(returnObject.body),'ehr-PimArchivesRecord-Get')")
    @ApiOperation(value = "根据档案信息获取档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息获取档案目录缺失记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PimArchivesRecordDTO> getByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PimArchivesRecord domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据档案信息获取档案目录缺失记录草稿", tags = {"档案目录缺失记录" },  notes = "根据档案信息获取档案目录缺失记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/getdraft")
    public ResponseEntity<PimArchivesRecordDTO> getDraftByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchivesRecord domain = new PimArchivesRecord();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "根据档案信息删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByIds(#ids),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "根据档案信息批量删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据档案信息批量删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatchByPimArchives(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "根据档案信息获取DEFAULT", tags = {"档案目录缺失记录" } ,notes = "根据档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PimArchivesRecordDTO>> fetchPimArchivesRecordDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PimArchivesRecordSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PimArchivesRecordDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "根据档案信息查询DEFAULT", tags = {"档案目录缺失记录" } ,notes = "根据档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PimArchivesRecordDTO>> searchPimArchivesRecordDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "根据人员信息档案信息建立档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息建立档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> createByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesrecordService.create(domain);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Create')")
    @ApiOperation(value = "根据人员信息档案信息批量建立档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息批量建立档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddto),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "根据人员信息档案信息保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/save")
    public ResponseEntity<Boolean> saveByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos),'ehr-PimArchivesRecord-Save')")
    @ApiOperation(value = "根据人员信息档案信息批量保存档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息批量保存档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "根据人员信息档案信息更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PimArchivesRecordDTO> updateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        PimArchivesRecord domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByEntities(this.pimarchivesrecordMapping.toDomain(#pimarchivesrecorddtos)),'ehr-PimArchivesRecord-Update')")
    @ApiOperation(value = "根据人员信息档案信息批量更新档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息批量更新档案目录缺失记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesRecordDTO> pimarchivesrecorddtos) {
        List<PimArchivesRecord> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PimArchivesRecord domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息档案信息检查档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息检查档案目录缺失记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PostAuthorize("hasPermission(this.pimarchivesrecordMapping.toDomain(returnObject.body),'ehr-PimArchivesRecord-Get')")
    @ApiOperation(value = "根据人员信息档案信息获取档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息获取档案目录缺失记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PimArchivesRecordDTO> getByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PimArchivesRecord domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PimArchivesRecordDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息档案信息获取档案目录缺失记录草稿", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息获取档案目录缺失记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/getdraft")
    public ResponseEntity<PimArchivesRecordDTO> getDraftByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchivesRecord domain = new PimArchivesRecord();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.get(#pimarchivesrecord_id),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "根据人员信息档案信息删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesrecordService.getPimarchivesrecordByIds(#ids),'ehr-PimArchivesRecord-Remove')")
    @ApiOperation(value = "根据人员信息档案信息批量删除档案目录缺失记录", tags = {"档案目录缺失记录" },  notes = "根据人员信息档案信息批量删除档案目录缺失记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimArchives(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息获取DEFAULT", tags = {"档案目录缺失记录" } ,notes = "根据人员信息档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PimArchivesRecordDTO>> fetchPimArchivesRecordDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PimArchivesRecordSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PimArchivesRecordDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesRecord-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息查询DEFAULT", tags = {"档案目录缺失记录" } ,notes = "根据人员信息档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PimArchivesRecordDTO>> searchPimArchivesRecordDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesRecordSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesRecord> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

