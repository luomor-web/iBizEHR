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
import cn.ibizlab.ehr.core.pcm.domain.PcmYpzjkxx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYpzjkxxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYpzjkxxSearchContext;

@Slf4j
@Api(tags = {"应聘者接口信息管理" })
@RestController("WebApi-pcmypzjkxx")
@RequestMapping("")
public class PcmYpzjkxxResource {

    @Autowired
    public IPcmYpzjkxxService pcmypzjkxxService;

    @Autowired
    @Lazy
    public PcmYpzjkxxMapping pcmypzjkxxMapping;

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.get(#pcmypzjkxx_id),'ehr-PcmYpzjkxx-Update')")
    @ApiOperation(value = "更新应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "更新应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    @Transactional
    public ResponseEntity<PcmYpzjkxxDTO> update(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id, @RequestBody PcmYpzjkxxDTO pcmypzjkxxdto) {
		PcmYpzjkxx domain  = pcmypzjkxxMapping.toDomain(pcmypzjkxxdto);
        domain .setPcmypzjkxxid(pcmypzjkxx_id);
		pcmypzjkxxService.update(domain );
		PcmYpzjkxxDTO dto = pcmypzjkxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.getPcmypzjkxxByEntities(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos)),'ehr-PcmYpzjkxx-Update')")
    @ApiOperation(value = "批量更新应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "批量更新应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYpzjkxxDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.updateBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.get(#pcmypzjkxx_id),'ehr-PcmYpzjkxx-Remove')")
    @ApiOperation(value = "删除应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "删除应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.remove(pcmypzjkxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.getPcmypzjkxxByIds(#ids),'ehr-PcmYpzjkxx-Remove')")
    @ApiOperation(value = "批量删除应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "批量删除应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmypzjkxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "检查应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYpzjkxxDTO pcmypzjkxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.checkKey(pcmypzjkxxMapping.toDomain(pcmypzjkxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(returnObject.body),'ehr-PcmYpzjkxx-Get')")
    @ApiOperation(value = "获取应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "获取应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    public ResponseEntity<PcmYpzjkxxDTO> get(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id) {
        PcmYpzjkxx domain = pcmypzjkxxService.get(pcmypzjkxx_id);
        PcmYpzjkxxDTO dto = pcmypzjkxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取应聘者接口信息管理草稿", tags = {"应聘者接口信息管理" },  notes = "获取应聘者接口信息管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmypzjkxxes/getdraft")
    public ResponseEntity<PcmYpzjkxxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxMapping.toDto(pcmypzjkxxService.getDraft(new PcmYpzjkxx())));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdto),'ehr-PcmYpzjkxx-Create')")
    @ApiOperation(value = "新建应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "新建应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes")
    @Transactional
    public ResponseEntity<PcmYpzjkxxDTO> create(@RequestBody PcmYpzjkxxDTO pcmypzjkxxdto) {
        PcmYpzjkxx domain = pcmypzjkxxMapping.toDomain(pcmypzjkxxdto);
		pcmypzjkxxService.create(domain);
        PcmYpzjkxxDTO dto = pcmypzjkxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos),'ehr-PcmYpzjkxx-Create')")
    @ApiOperation(value = "批量新建应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "批量新建应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYpzjkxxDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.createBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdto),'ehr-PcmYpzjkxx-Save')")
    @ApiOperation(value = "保存应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "保存应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYpzjkxxDTO pcmypzjkxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.save(pcmypzjkxxMapping.toDomain(pcmypzjkxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos),'ehr-PcmYpzjkxx-Save')")
    @ApiOperation(value = "批量保存应聘者接口信息管理", tags = {"应聘者接口信息管理" },  notes = "批量保存应聘者接口信息管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYpzjkxxDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.saveBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYpzjkxx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者接口信息管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmypzjkxxes/fetchdefault")
	public ResponseEntity<List<PcmYpzjkxxDTO>> fetchDefault(PcmYpzjkxxSearchContext context) {
        Page<PcmYpzjkxx> domains = pcmypzjkxxService.searchDefault(context) ;
        List<PcmYpzjkxxDTO> list = pcmypzjkxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYpzjkxx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者接口信息管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmypzjkxxes/searchdefault")
	public ResponseEntity<Page<PcmYpzjkxxDTO>> searchDefault(@RequestBody PcmYpzjkxxSearchContext context) {
        Page<PcmYpzjkxx> domains = pcmypzjkxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmypzjkxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

