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
import cn.ibizlab.ehr.core.pcm.domain.PcmRecruitment;
import cn.ibizlab.ehr.core.pcm.service.IPcmRecruitmentService;
import cn.ibizlab.ehr.core.pcm.filter.PcmRecruitmentSearchContext;

@Slf4j
@Api(tags = {"内部招聘信息" })
@RestController("WebApi-pcmrecruitment")
@RequestMapping("")
public class PcmRecruitmentResource {

    @Autowired
    public IPcmRecruitmentService pcmrecruitmentService;

    @Autowired
    @Lazy
    public PcmRecruitmentMapping pcmrecruitmentMapping;

    @ApiOperation(value = "获取内部招聘信息草稿", tags = {"内部招聘信息" },  notes = "获取内部招聘信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrecruitments/getdraft")
    public ResponseEntity<PcmRecruitmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentMapping.toDto(pcmrecruitmentService.getDraft(new PcmRecruitment())));
    }

    @PostAuthorize("hasPermission(this.pcmrecruitmentMapping.toDomain(returnObject.body),'ehr-PcmRecruitment-Get')")
    @ApiOperation(value = "获取内部招聘信息", tags = {"内部招聘信息" },  notes = "获取内部招聘信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrecruitments/{pcmrecruitment_id}")
    public ResponseEntity<PcmRecruitmentDTO> get(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id) {
        PcmRecruitment domain = pcmrecruitmentService.get(pcmrecruitment_id);
        PcmRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentMapping.toDomain(#pcmrecruitmentdto),'ehr-PcmRecruitment-Save')")
    @ApiOperation(value = "保存内部招聘信息", tags = {"内部招聘信息" },  notes = "保存内部招聘信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmRecruitmentDTO pcmrecruitmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.save(pcmrecruitmentMapping.toDomain(pcmrecruitmentdto)));
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentMapping.toDomain(#pcmrecruitmentdtos),'ehr-PcmRecruitment-Save')")
    @ApiOperation(value = "批量保存内部招聘信息", tags = {"内部招聘信息" },  notes = "批量保存内部招聘信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.saveBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentMapping.toDomain(#pcmrecruitmentdto),'ehr-PcmRecruitment-Create')")
    @ApiOperation(value = "新建内部招聘信息", tags = {"内部招聘信息" },  notes = "新建内部招聘信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments")
    @Transactional
    public ResponseEntity<PcmRecruitmentDTO> create(@RequestBody PcmRecruitmentDTO pcmrecruitmentdto) {
        PcmRecruitment domain = pcmrecruitmentMapping.toDomain(pcmrecruitmentdto);
		pcmrecruitmentService.create(domain);
        PcmRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentMapping.toDomain(#pcmrecruitmentdtos),'ehr-PcmRecruitment-Create')")
    @ApiOperation(value = "批量新建内部招聘信息", tags = {"内部招聘信息" },  notes = "批量新建内部招聘信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.createBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查内部招聘信息", tags = {"内部招聘信息" },  notes = "检查内部招聘信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmRecruitmentDTO pcmrecruitmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.checkKey(pcmrecruitmentMapping.toDomain(pcmrecruitmentdto)));
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentService.get(#pcmrecruitment_id),'ehr-PcmRecruitment-Update')")
    @ApiOperation(value = "更新内部招聘信息", tags = {"内部招聘信息" },  notes = "更新内部招聘信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrecruitments/{pcmrecruitment_id}")
    @Transactional
    public ResponseEntity<PcmRecruitmentDTO> update(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id, @RequestBody PcmRecruitmentDTO pcmrecruitmentdto) {
		PcmRecruitment domain  = pcmrecruitmentMapping.toDomain(pcmrecruitmentdto);
        domain .setPcmrecruitmentid(pcmrecruitment_id);
		pcmrecruitmentService.update(domain );
		PcmRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentService.getPcmrecruitmentByEntities(this.pcmrecruitmentMapping.toDomain(#pcmrecruitmentdtos)),'ehr-PcmRecruitment-Update')")
    @ApiOperation(value = "批量更新内部招聘信息", tags = {"内部招聘信息" },  notes = "批量更新内部招聘信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.updateBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentService.get(#pcmrecruitment_id),'ehr-PcmRecruitment-Remove')")
    @ApiOperation(value = "删除内部招聘信息", tags = {"内部招聘信息" },  notes = "删除内部招聘信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrecruitments/{pcmrecruitment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.remove(pcmrecruitment_id));
    }

    @PreAuthorize("hasPermission(this.pcmrecruitmentService.getPcmrecruitmentByIds(#ids),'ehr-PcmRecruitment-Remove')")
    @ApiOperation(value = "批量删除内部招聘信息", tags = {"内部招聘信息" },  notes = "批量删除内部招聘信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrecruitmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRecruitment-NBZP-all')")
	@ApiOperation(value = "获取内部招聘信息", tags = {"内部招聘信息" } ,notes = "获取内部招聘信息")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrecruitments/fetchnbzp")
	public ResponseEntity<List<PcmRecruitmentDTO>> fetchNBZP(PcmRecruitmentSearchContext context) {
        Page<PcmRecruitment> domains = pcmrecruitmentService.searchNBZP(context) ;
        List<PcmRecruitmentDTO> list = pcmrecruitmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRecruitment-NBZP-all')")
	@ApiOperation(value = "查询内部招聘信息", tags = {"内部招聘信息" } ,notes = "查询内部招聘信息")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrecruitments/searchnbzp")
	public ResponseEntity<Page<PcmRecruitmentDTO>> searchNBZP(@RequestBody PcmRecruitmentSearchContext context) {
        Page<PcmRecruitment> domains = pcmrecruitmentService.searchNBZP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrecruitmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRecruitment-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"内部招聘信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrecruitments/fetchdefault")
	public ResponseEntity<List<PcmRecruitmentDTO>> fetchDefault(PcmRecruitmentSearchContext context) {
        Page<PcmRecruitment> domains = pcmrecruitmentService.searchDefault(context) ;
        List<PcmRecruitmentDTO> list = pcmrecruitmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRecruitment-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"内部招聘信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrecruitments/searchdefault")
	public ResponseEntity<Page<PcmRecruitmentDTO>> searchDefault(@RequestBody PcmRecruitmentSearchContext context) {
        Page<PcmRecruitment> domains = pcmrecruitmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrecruitmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

