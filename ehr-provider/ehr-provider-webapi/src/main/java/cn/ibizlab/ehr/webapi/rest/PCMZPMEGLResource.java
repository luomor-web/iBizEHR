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
import cn.ibizlab.ehr.core.pcm.domain.PCMZPMEGL;
import cn.ibizlab.ehr.core.pcm.service.IPCMZPMEGLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMZPMEGLSearchContext;

@Slf4j
@Api(tags = {"招聘名额管理" })
@RestController("WebApi-pcmzpmegl")
@RequestMapping("")
public class PCMZPMEGLResource {

    @Autowired
    public IPCMZPMEGLService pcmzpmeglService;

    @Autowired
    @Lazy
    public PCMZPMEGLMapping pcmzpmeglMapping;

    @PreAuthorize("hasPermission(this.pcmzpmeglService.get(#pcmzpmegl_id),'ehr-PCMZPMEGL-Remove')")
    @ApiOperation(value = "删除招聘名额管理", tags = {"招聘名额管理" },  notes = "删除招聘名额管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmegls/{pcmzpmegl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzpmegl_id") String pcmzpmegl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglService.remove(pcmzpmegl_id));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglService.getPcmzpmeglByIds(#ids),'ehr-PCMZPMEGL-Remove')")
    @ApiOperation(value = "批量删除招聘名额管理", tags = {"招聘名额管理" },  notes = "批量删除招聘名额管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmegls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzpmeglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查招聘名额管理", tags = {"招聘名额管理" },  notes = "检查招聘名额管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmegls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMZPMEGLDTO pcmzpmegldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglService.checkKey(pcmzpmeglMapping.toDomain(pcmzpmegldto)));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglMapping.toDomain(#pcmzpmegldto),'ehr-PCMZPMEGL-Save')")
    @ApiOperation(value = "保存招聘名额管理", tags = {"招聘名额管理" },  notes = "保存招聘名额管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmegls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMZPMEGLDTO pcmzpmegldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglService.save(pcmzpmeglMapping.toDomain(pcmzpmegldto)));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglMapping.toDomain(#pcmzpmegldtos),'ehr-PCMZPMEGL-Save')")
    @ApiOperation(value = "批量保存招聘名额管理", tags = {"招聘名额管理" },  notes = "批量保存招聘名额管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmegls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMZPMEGLDTO> pcmzpmegldtos) {
        pcmzpmeglService.saveBatch(pcmzpmeglMapping.toDomain(pcmzpmegldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglService.get(#pcmzpmegl_id),'ehr-PCMZPMEGL-Update')")
    @ApiOperation(value = "更新招聘名额管理", tags = {"招聘名额管理" },  notes = "更新招聘名额管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmegls/{pcmzpmegl_id}")
    @Transactional
    public ResponseEntity<PCMZPMEGLDTO> update(@PathVariable("pcmzpmegl_id") String pcmzpmegl_id, @RequestBody PCMZPMEGLDTO pcmzpmegldto) {
		PCMZPMEGL domain  = pcmzpmeglMapping.toDomain(pcmzpmegldto);
        domain .setPcmzpmeglid(pcmzpmegl_id);
		pcmzpmeglService.update(domain );
		PCMZPMEGLDTO dto = pcmzpmeglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglService.getPcmzpmeglByEntities(this.pcmzpmeglMapping.toDomain(#pcmzpmegldtos)),'ehr-PCMZPMEGL-Update')")
    @ApiOperation(value = "批量更新招聘名额管理", tags = {"招聘名额管理" },  notes = "批量更新招聘名额管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmegls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMZPMEGLDTO> pcmzpmegldtos) {
        pcmzpmeglService.updateBatch(pcmzpmeglMapping.toDomain(pcmzpmegldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglMapping.toDomain(#pcmzpmegldto),'ehr-PCMZPMEGL-Create')")
    @ApiOperation(value = "新建招聘名额管理", tags = {"招聘名额管理" },  notes = "新建招聘名额管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmegls")
    @Transactional
    public ResponseEntity<PCMZPMEGLDTO> create(@RequestBody PCMZPMEGLDTO pcmzpmegldto) {
        PCMZPMEGL domain = pcmzpmeglMapping.toDomain(pcmzpmegldto);
		pcmzpmeglService.create(domain);
        PCMZPMEGLDTO dto = pcmzpmeglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglMapping.toDomain(#pcmzpmegldtos),'ehr-PCMZPMEGL-Create')")
    @ApiOperation(value = "批量新建招聘名额管理", tags = {"招聘名额管理" },  notes = "批量新建招聘名额管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmegls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMZPMEGLDTO> pcmzpmegldtos) {
        pcmzpmeglService.createBatch(pcmzpmeglMapping.toDomain(pcmzpmegldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzpmeglMapping.toDomain(returnObject.body),'ehr-PCMZPMEGL-Get')")
    @ApiOperation(value = "获取招聘名额管理", tags = {"招聘名额管理" },  notes = "获取招聘名额管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmegls/{pcmzpmegl_id}")
    public ResponseEntity<PCMZPMEGLDTO> get(@PathVariable("pcmzpmegl_id") String pcmzpmegl_id) {
        PCMZPMEGL domain = pcmzpmeglService.get(pcmzpmegl_id);
        PCMZPMEGLDTO dto = pcmzpmeglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取招聘名额管理草稿", tags = {"招聘名额管理" },  notes = "获取招聘名额管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmegls/getdraft")
    public ResponseEntity<PCMZPMEGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglMapping.toDto(pcmzpmeglService.getDraft(new PCMZPMEGL())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGL-CurND-all')")
	@ApiOperation(value = "获取当前年度招聘名额", tags = {"招聘名额管理" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzpmegls/fetchcurnd")
	public ResponseEntity<List<PCMZPMEGLDTO>> fetchCurND(PCMZPMEGLSearchContext context) {
        Page<PCMZPMEGL> domains = pcmzpmeglService.searchCurND(context) ;
        List<PCMZPMEGLDTO> list = pcmzpmeglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGL-CurND-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"招聘名额管理" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzpmegls/searchcurnd")
	public ResponseEntity<Page<PCMZPMEGLDTO>> searchCurND(@RequestBody PCMZPMEGLSearchContext context) {
        Page<PCMZPMEGL> domains = pcmzpmeglService.searchCurND(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzpmeglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGL-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"招聘名额管理" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzpmegls/fetchdefault")
	public ResponseEntity<List<PCMZPMEGLDTO>> fetchDefault(PCMZPMEGLSearchContext context) {
        Page<PCMZPMEGL> domains = pcmzpmeglService.searchDefault(context) ;
        List<PCMZPMEGLDTO> list = pcmzpmeglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGL-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"招聘名额管理" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzpmegls/searchdefault")
	public ResponseEntity<Page<PCMZPMEGLDTO>> searchDefault(@RequestBody PCMZPMEGLSearchContext context) {
        Page<PCMZPMEGL> domains = pcmzpmeglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzpmeglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

