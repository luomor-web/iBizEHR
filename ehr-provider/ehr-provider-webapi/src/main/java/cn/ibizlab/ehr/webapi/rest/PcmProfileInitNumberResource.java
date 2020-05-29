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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileInitNumber;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileInitNumberService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileInitNumberSearchContext;

@Slf4j
@Api(tags = {"应聘者起始编号（停用）" })
@RestController("WebApi-pcmprofileinitnumber")
@RequestMapping("")
public class PcmProfileInitNumberResource {

    @Autowired
    public IPcmProfileInitNumberService pcmprofileinitnumberService;

    @Autowired
    @Lazy
    public PcmProfileInitNumberMapping pcmprofileinitnumberMapping;

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberService.get(#pcmprofileinitnumber_id),'ehr-PcmProfileInitNumber-Remove')")
    @ApiOperation(value = "删除应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "删除应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.remove(pcmprofileinitnumber_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberService.getPcmprofileinitnumberByIds(#ids),'ehr-PcmProfileInitNumber-Remove')")
    @ApiOperation(value = "批量删除应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "批量删除应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileinitnumberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberMapping.toDomain(#pcmprofileinitnumberdto),'ehr-PcmProfileInitNumber-Save')")
    @ApiOperation(value = "保存应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "保存应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileInitNumberDTO pcmprofileinitnumberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.save(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberMapping.toDomain(#pcmprofileinitnumberdtos),'ehr-PcmProfileInitNumber-Save')")
    @ApiOperation(value = "批量保存应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "批量保存应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileInitNumberDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.saveBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberService.get(#pcmprofileinitnumber_id),'ehr-PcmProfileInitNumber-Update')")
    @ApiOperation(value = "更新应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "更新应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    @Transactional
    public ResponseEntity<PcmProfileInitNumberDTO> update(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id, @RequestBody PcmProfileInitNumberDTO pcmprofileinitnumberdto) {
		PcmProfileInitNumber domain  = pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto);
        domain .setPcmprofileinitnumberid(pcmprofileinitnumber_id);
		pcmprofileinitnumberService.update(domain );
		PcmProfileInitNumberDTO dto = pcmprofileinitnumberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberService.getPcmprofileinitnumberByEntities(this.pcmprofileinitnumberMapping.toDomain(#pcmprofileinitnumberdtos)),'ehr-PcmProfileInitNumber-Update')")
    @ApiOperation(value = "批量更新应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "批量更新应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileInitNumberDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.updateBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberMapping.toDomain(#pcmprofileinitnumberdto),'ehr-PcmProfileInitNumber-Create')")
    @ApiOperation(value = "新建应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "新建应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers")
    @Transactional
    public ResponseEntity<PcmProfileInitNumberDTO> create(@RequestBody PcmProfileInitNumberDTO pcmprofileinitnumberdto) {
        PcmProfileInitNumber domain = pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto);
		pcmprofileinitnumberService.create(domain);
        PcmProfileInitNumberDTO dto = pcmprofileinitnumberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileinitnumberMapping.toDomain(#pcmprofileinitnumberdtos),'ehr-PcmProfileInitNumber-Create')")
    @ApiOperation(value = "批量新建应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "批量新建应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileInitNumberDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.createBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileinitnumberMapping.toDomain(returnObject.body),'ehr-PcmProfileInitNumber-Get')")
    @ApiOperation(value = "获取应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "获取应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    public ResponseEntity<PcmProfileInitNumberDTO> get(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id) {
        PcmProfileInitNumber domain = pcmprofileinitnumberService.get(pcmprofileinitnumber_id);
        PcmProfileInitNumberDTO dto = pcmprofileinitnumberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取应聘者起始编号（停用）草稿", tags = {"应聘者起始编号（停用）" },  notes = "获取应聘者起始编号（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileinitnumbers/getdraft")
    public ResponseEntity<PcmProfileInitNumberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberMapping.toDto(pcmprofileinitnumberService.getDraft(new PcmProfileInitNumber())));
    }

    @ApiOperation(value = "检查应聘者起始编号（停用）", tags = {"应聘者起始编号（停用）" },  notes = "检查应聘者起始编号（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileInitNumberDTO pcmprofileinitnumberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.checkKey(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileInitNumber-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者起始编号（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileinitnumbers/fetchdefault")
	public ResponseEntity<List<PcmProfileInitNumberDTO>> fetchDefault(PcmProfileInitNumberSearchContext context) {
        Page<PcmProfileInitNumber> domains = pcmprofileinitnumberService.searchDefault(context) ;
        List<PcmProfileInitNumberDTO> list = pcmprofileinitnumberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileInitNumber-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者起始编号（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileinitnumbers/searchdefault")
	public ResponseEntity<Page<PcmProfileInitNumberDTO>> searchDefault(@RequestBody PcmProfileInitNumberSearchContext context) {
        Page<PcmProfileInitNumber> domains = pcmprofileinitnumberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileinitnumberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

