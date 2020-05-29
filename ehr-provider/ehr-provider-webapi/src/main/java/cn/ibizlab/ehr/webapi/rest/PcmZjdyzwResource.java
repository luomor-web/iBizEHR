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
import cn.ibizlab.ehr.core.pcm.domain.PcmZjdyzw;
import cn.ibizlab.ehr.core.pcm.service.IPcmZjdyzwService;
import cn.ibizlab.ehr.core.pcm.filter.PcmZjdyzwSearchContext;

@Slf4j
@Api(tags = {"职级和职务对应关系" })
@RestController("WebApi-pcmzjdyzw")
@RequestMapping("")
public class PcmZjdyzwResource {

    @Autowired
    public IPcmZjdyzwService pcmzjdyzwService;

    @Autowired
    @Lazy
    public PcmZjdyzwMapping pcmzjdyzwMapping;

    @ApiOperation(value = "检查职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "检查职级和职务对应关系")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.checkKey(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @ApiOperation(value = "获取职级和职务对应关系草稿", tags = {"职级和职务对应关系" },  notes = "获取职级和职务对应关系草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/getdraft")
    public ResponseEntity<PcmZjdyzwDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwMapping.toDto(pcmzjdyzwService.getDraft(new PcmZjdyzw())));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PcmZjdyzw-Create')")
    @ApiOperation(value = "新建职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "新建职级和职务对应关系")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws")
    @Transactional
    public ResponseEntity<PcmZjdyzwDTO> create(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        PcmZjdyzw domain = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
		pcmzjdyzwService.create(domain);
        PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PcmZjdyzw-Create')")
    @ApiOperation(value = "批量新建职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "批量新建职级和职务对应关系")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.createBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(returnObject.body),'ehr-PcmZjdyzw-Get')")
    @ApiOperation(value = "获取职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "获取职级和职务对应关系")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    public ResponseEntity<PcmZjdyzwDTO> get(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
        PcmZjdyzw domain = pcmzjdyzwService.get(pcmzjdyzw_id);
        PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PcmZjdyzw-Update')")
    @ApiOperation(value = "更新职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "更新职级和职务对应关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<PcmZjdyzwDTO> update(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id, @RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
		PcmZjdyzw domain  = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
        domain .setPcmzjdyzwid(pcmzjdyzw_id);
		pcmzjdyzwService.update(domain );
		PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByEntities(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos)),'ehr-PcmZjdyzw-Update')")
    @ApiOperation(value = "批量更新职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "批量更新职级和职务对应关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.updateBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PcmZjdyzw-Remove')")
    @ApiOperation(value = "删除职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "删除职级和职务对应关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.remove(pcmzjdyzw_id));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByIds(#ids),'ehr-PcmZjdyzw-Remove')")
    @ApiOperation(value = "批量删除职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "批量删除职级和职务对应关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzjdyzwService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PcmZjdyzw-Save')")
    @ApiOperation(value = "保存职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "保存职级和职务对应关系")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.save(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PcmZjdyzw-Save')")
    @ApiOperation(value = "批量保存职级和职务对应关系", tags = {"职级和职务对应关系" },  notes = "批量保存职级和职务对应关系")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.saveBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZjdyzw-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职级和职务对应关系" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzjdyzws/fetchdefault")
	public ResponseEntity<List<PcmZjdyzwDTO>> fetchDefault(PcmZjdyzwSearchContext context) {
        Page<PcmZjdyzw> domains = pcmzjdyzwService.searchDefault(context) ;
        List<PcmZjdyzwDTO> list = pcmzjdyzwMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZjdyzw-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职级和职务对应关系" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzjdyzws/searchdefault")
	public ResponseEntity<Page<PcmZjdyzwDTO>> searchDefault(@RequestBody PcmZjdyzwSearchContext context) {
        Page<PcmZjdyzw> domains = pcmzjdyzwService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzjdyzwMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

