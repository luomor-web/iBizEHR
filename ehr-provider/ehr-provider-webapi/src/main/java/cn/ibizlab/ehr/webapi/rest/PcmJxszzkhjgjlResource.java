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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxszzkhjgjl;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxszzkhjgjlService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxszzkhjgjlSearchContext;

@Slf4j
@Api(tags = {"见习生员工转正考核结果记录" })
@RestController("WebApi-pcmjxszzkhjgjl")
@RequestMapping("")
public class PcmJxszzkhjgjlResource {

    @Autowired
    public IPcmJxszzkhjgjlService pcmjxszzkhjgjlService;

    @Autowired
    @Lazy
    public PcmJxszzkhjgjlMapping pcmjxszzkhjgjlMapping;

    @ApiOperation(value = "检查见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "检查见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxszzkhjgjlDTO pcmjxszzkhjgjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.checkKey(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto)));
    }

    @ApiOperation(value = "获取见习生员工转正考核结果记录草稿", tags = {"见习生员工转正考核结果记录" },  notes = "获取见习生员工转正考核结果记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxszzkhjgjls/getdraft")
    public ResponseEntity<PcmJxszzkhjgjlDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlMapping.toDto(pcmjxszzkhjgjlService.getDraft(new PcmJxszzkhjgjl())));
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlService.get(#pcmjxszzkhjgjl_id),'ehr-PcmJxszzkhjgjl-Remove')")
    @ApiOperation(value = "删除见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "删除见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.remove(pcmjxszzkhjgjl_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlService.getPcmjxszzkhjgjlByIds(#ids),'ehr-PcmJxszzkhjgjl-Remove')")
    @ApiOperation(value = "批量删除见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "批量删除见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxszzkhjgjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmjxszzkhjgjlMapping.toDomain(returnObject.body),'ehr-PcmJxszzkhjgjl-Get')")
    @ApiOperation(value = "获取见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "获取见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    public ResponseEntity<PcmJxszzkhjgjlDTO> get(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id) {
        PcmJxszzkhjgjl domain = pcmjxszzkhjgjlService.get(pcmjxszzkhjgjl_id);
        PcmJxszzkhjgjlDTO dto = pcmjxszzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlMapping.toDomain(#pcmjxszzkhjgjldto),'ehr-PcmJxszzkhjgjl-Create')")
    @ApiOperation(value = "新建见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "新建见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls")
    @Transactional
    public ResponseEntity<PcmJxszzkhjgjlDTO> create(@RequestBody PcmJxszzkhjgjlDTO pcmjxszzkhjgjldto) {
        PcmJxszzkhjgjl domain = pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto);
		pcmjxszzkhjgjlService.create(domain);
        PcmJxszzkhjgjlDTO dto = pcmjxszzkhjgjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlMapping.toDomain(#pcmjxszzkhjgjldtos),'ehr-PcmJxszzkhjgjl-Create')")
    @ApiOperation(value = "批量新建见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "批量新建见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxszzkhjgjlDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.createBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlService.get(#pcmjxszzkhjgjl_id),'ehr-PcmJxszzkhjgjl-Update')")
    @ApiOperation(value = "更新见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "更新见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    @Transactional
    public ResponseEntity<PcmJxszzkhjgjlDTO> update(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id, @RequestBody PcmJxszzkhjgjlDTO pcmjxszzkhjgjldto) {
		PcmJxszzkhjgjl domain  = pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto);
        domain .setPcmjxszzkhjgjlid(pcmjxszzkhjgjl_id);
		pcmjxszzkhjgjlService.update(domain );
		PcmJxszzkhjgjlDTO dto = pcmjxszzkhjgjlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlService.getPcmjxszzkhjgjlByEntities(this.pcmjxszzkhjgjlMapping.toDomain(#pcmjxszzkhjgjldtos)),'ehr-PcmJxszzkhjgjl-Update')")
    @ApiOperation(value = "批量更新见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "批量更新见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxszzkhjgjlDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.updateBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlMapping.toDomain(#pcmjxszzkhjgjldto),'ehr-PcmJxszzkhjgjl-Save')")
    @ApiOperation(value = "保存见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "保存见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxszzkhjgjlDTO pcmjxszzkhjgjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.save(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxszzkhjgjlMapping.toDomain(#pcmjxszzkhjgjldtos),'ehr-PcmJxszzkhjgjl-Save')")
    @ApiOperation(value = "批量保存见习生员工转正考核结果记录", tags = {"见习生员工转正考核结果记录" },  notes = "批量保存见习生员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxszzkhjgjlDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.saveBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxszzkhjgjl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"见习生员工转正考核结果记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxszzkhjgjls/fetchdefault")
	public ResponseEntity<List<PcmJxszzkhjgjlDTO>> fetchDefault(PcmJxszzkhjgjlSearchContext context) {
        Page<PcmJxszzkhjgjl> domains = pcmjxszzkhjgjlService.searchDefault(context) ;
        List<PcmJxszzkhjgjlDTO> list = pcmjxszzkhjgjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxszzkhjgjl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"见习生员工转正考核结果记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxszzkhjgjls/searchdefault")
	public ResponseEntity<Page<PcmJxszzkhjgjlDTO>> searchDefault(@RequestBody PcmJxszzkhjgjlSearchContext context) {
        Page<PcmJxszzkhjgjl> domains = pcmjxszzkhjgjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxszzkhjgjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

