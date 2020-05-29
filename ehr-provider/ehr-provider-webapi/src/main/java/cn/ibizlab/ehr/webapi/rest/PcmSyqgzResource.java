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
import cn.ibizlab.ehr.core.pcm.domain.PcmSyqgz;
import cn.ibizlab.ehr.core.pcm.service.IPcmSyqgzService;
import cn.ibizlab.ehr.core.pcm.filter.PcmSyqgzSearchContext;

@Slf4j
@Api(tags = {"试用期规则" })
@RestController("WebApi-pcmsyqgz")
@RequestMapping("")
public class PcmSyqgzResource {

    @Autowired
    public IPcmSyqgzService pcmsyqgzService;

    @Autowired
    @Lazy
    public PcmSyqgzMapping pcmsyqgzMapping;

    @PreAuthorize("hasPermission(this.pcmsyqgzService.get(#pcmsyqgz_id),'ehr-PcmSyqgz-Update')")
    @ApiOperation(value = "更新试用期规则", tags = {"试用期规则" },  notes = "更新试用期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    @Transactional
    public ResponseEntity<PcmSyqgzDTO> update(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id, @RequestBody PcmSyqgzDTO pcmsyqgzdto) {
		PcmSyqgz domain  = pcmsyqgzMapping.toDomain(pcmsyqgzdto);
        domain .setPcmsyqgzid(pcmsyqgz_id);
		pcmsyqgzService.update(domain );
		PcmSyqgzDTO dto = pcmsyqgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzService.getPcmsyqgzByEntities(this.pcmsyqgzMapping.toDomain(#pcmsyqgzdtos)),'ehr-PcmSyqgz-Update')")
    @ApiOperation(value = "批量更新试用期规则", tags = {"试用期规则" },  notes = "批量更新试用期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmSyqgzDTO> pcmsyqgzdtos) {
        pcmsyqgzService.updateBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmsyqgzMapping.toDomain(returnObject.body),'ehr-PcmSyqgz-Get')")
    @ApiOperation(value = "获取试用期规则", tags = {"试用期规则" },  notes = "获取试用期规则")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    public ResponseEntity<PcmSyqgzDTO> get(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id) {
        PcmSyqgz domain = pcmsyqgzService.get(pcmsyqgz_id);
        PcmSyqgzDTO dto = pcmsyqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzMapping.toDomain(#pcmsyqgzdto),'ehr-PcmSyqgz-Create')")
    @ApiOperation(value = "新建试用期规则", tags = {"试用期规则" },  notes = "新建试用期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs")
    @Transactional
    public ResponseEntity<PcmSyqgzDTO> create(@RequestBody PcmSyqgzDTO pcmsyqgzdto) {
        PcmSyqgz domain = pcmsyqgzMapping.toDomain(pcmsyqgzdto);
		pcmsyqgzService.create(domain);
        PcmSyqgzDTO dto = pcmsyqgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzMapping.toDomain(#pcmsyqgzdtos),'ehr-PcmSyqgz-Create')")
    @ApiOperation(value = "批量新建试用期规则", tags = {"试用期规则" },  notes = "批量新建试用期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmSyqgzDTO> pcmsyqgzdtos) {
        pcmsyqgzService.createBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查试用期规则", tags = {"试用期规则" },  notes = "检查试用期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmSyqgzDTO pcmsyqgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.checkKey(pcmsyqgzMapping.toDomain(pcmsyqgzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzService.get(#pcmsyqgz_id),'ehr-PcmSyqgz-Remove')")
    @ApiOperation(value = "删除试用期规则", tags = {"试用期规则" },  notes = "删除试用期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.remove(pcmsyqgz_id));
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzService.getPcmsyqgzByIds(#ids),'ehr-PcmSyqgz-Remove')")
    @ApiOperation(value = "批量删除试用期规则", tags = {"试用期规则" },  notes = "批量删除试用期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmsyqgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzMapping.toDomain(#pcmsyqgzdto),'ehr-PcmSyqgz-Save')")
    @ApiOperation(value = "保存试用期规则", tags = {"试用期规则" },  notes = "保存试用期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmSyqgzDTO pcmsyqgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.save(pcmsyqgzMapping.toDomain(pcmsyqgzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmsyqgzMapping.toDomain(#pcmsyqgzdtos),'ehr-PcmSyqgz-Save')")
    @ApiOperation(value = "批量保存试用期规则", tags = {"试用期规则" },  notes = "批量保存试用期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmSyqgzDTO> pcmsyqgzdtos) {
        pcmsyqgzService.saveBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取试用期规则草稿", tags = {"试用期规则" },  notes = "获取试用期规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsyqgzs/getdraft")
    public ResponseEntity<PcmSyqgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzMapping.toDto(pcmsyqgzService.getDraft(new PcmSyqgz())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSyqgz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试用期规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmsyqgzs/fetchdefault")
	public ResponseEntity<List<PcmSyqgzDTO>> fetchDefault(PcmSyqgzSearchContext context) {
        Page<PcmSyqgz> domains = pcmsyqgzService.searchDefault(context) ;
        List<PcmSyqgzDTO> list = pcmsyqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSyqgz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试用期规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmsyqgzs/searchdefault")
	public ResponseEntity<Page<PcmSyqgzDTO>> searchDefault(@RequestBody PcmSyqgzSearchContext context) {
        Page<PcmSyqgz> domains = pcmsyqgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmsyqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

