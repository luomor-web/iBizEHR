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
import cn.ibizlab.ehr.core.pcm.domain.PcmMspjxx;
import cn.ibizlab.ehr.core.pcm.service.IPcmMspjxxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmMspjxxSearchContext;

@Slf4j
@Api(tags = {"面试评价信息" })
@RestController("WebApi-pcmmspjxx")
@RequestMapping("")
public class PcmMspjxxResource {

    @Autowired
    public IPcmMspjxxService pcmmspjxxService;

    @Autowired
    @Lazy
    public PcmMspjxxMapping pcmmspjxxMapping;

    @ApiOperation(value = "获取面试评价信息草稿", tags = {"面试评价信息" },  notes = "获取面试评价信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmspjxxes/getdraft")
    public ResponseEntity<PcmMspjxxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxMapping.toDto(pcmmspjxxService.getDraft(new PcmMspjxx())));
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxMapping.toDomain(#pcmmspjxxdto),'ehr-PcmMspjxx-Create')")
    @ApiOperation(value = "新建面试评价信息", tags = {"面试评价信息" },  notes = "新建面试评价信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes")
    @Transactional
    public ResponseEntity<PcmMspjxxDTO> create(@RequestBody PcmMspjxxDTO pcmmspjxxdto) {
        PcmMspjxx domain = pcmmspjxxMapping.toDomain(pcmmspjxxdto);
		pcmmspjxxService.create(domain);
        PcmMspjxxDTO dto = pcmmspjxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxMapping.toDomain(#pcmmspjxxdtos),'ehr-PcmMspjxx-Create')")
    @ApiOperation(value = "批量新建面试评价信息", tags = {"面试评价信息" },  notes = "批量新建面试评价信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmMspjxxDTO> pcmmspjxxdtos) {
        pcmmspjxxService.createBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查面试评价信息", tags = {"面试评价信息" },  notes = "检查面试评价信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmMspjxxDTO pcmmspjxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.checkKey(pcmmspjxxMapping.toDomain(pcmmspjxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxService.get(#pcmmspjxx_id),'ehr-PcmMspjxx-Remove')")
    @ApiOperation(value = "删除面试评价信息", tags = {"面试评价信息" },  notes = "删除面试评价信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.remove(pcmmspjxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxService.getPcmmspjxxByIds(#ids),'ehr-PcmMspjxx-Remove')")
    @ApiOperation(value = "批量删除面试评价信息", tags = {"面试评价信息" },  notes = "批量删除面试评价信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmmspjxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmmspjxxMapping.toDomain(returnObject.body),'ehr-PcmMspjxx-Get')")
    @ApiOperation(value = "获取面试评价信息", tags = {"面试评价信息" },  notes = "获取面试评价信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    public ResponseEntity<PcmMspjxxDTO> get(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id) {
        PcmMspjxx domain = pcmmspjxxService.get(pcmmspjxx_id);
        PcmMspjxxDTO dto = pcmmspjxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxMapping.toDomain(#pcmmspjxxdto),'ehr-PcmMspjxx-Save')")
    @ApiOperation(value = "保存面试评价信息", tags = {"面试评价信息" },  notes = "保存面试评价信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmMspjxxDTO pcmmspjxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.save(pcmmspjxxMapping.toDomain(pcmmspjxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxMapping.toDomain(#pcmmspjxxdtos),'ehr-PcmMspjxx-Save')")
    @ApiOperation(value = "批量保存面试评价信息", tags = {"面试评价信息" },  notes = "批量保存面试评价信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmMspjxxDTO> pcmmspjxxdtos) {
        pcmmspjxxService.saveBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxService.get(#pcmmspjxx_id),'ehr-PcmMspjxx-Update')")
    @ApiOperation(value = "更新面试评价信息", tags = {"面试评价信息" },  notes = "更新面试评价信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    @Transactional
    public ResponseEntity<PcmMspjxxDTO> update(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id, @RequestBody PcmMspjxxDTO pcmmspjxxdto) {
		PcmMspjxx domain  = pcmmspjxxMapping.toDomain(pcmmspjxxdto);
        domain .setPcmmspjxxid(pcmmspjxx_id);
		pcmmspjxxService.update(domain );
		PcmMspjxxDTO dto = pcmmspjxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmmspjxxService.getPcmmspjxxByEntities(this.pcmmspjxxMapping.toDomain(#pcmmspjxxdtos)),'ehr-PcmMspjxx-Update')")
    @ApiOperation(value = "批量更新面试评价信息", tags = {"面试评价信息" },  notes = "批量更新面试评价信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmMspjxxDTO> pcmmspjxxdtos) {
        pcmmspjxxService.updateBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmMspjxx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"面试评价信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmmspjxxes/fetchdefault")
	public ResponseEntity<List<PcmMspjxxDTO>> fetchDefault(PcmMspjxxSearchContext context) {
        Page<PcmMspjxx> domains = pcmmspjxxService.searchDefault(context) ;
        List<PcmMspjxxDTO> list = pcmmspjxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmMspjxx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"面试评价信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmmspjxxes/searchdefault")
	public ResponseEntity<Page<PcmMspjxxDTO>> searchDefault(@RequestBody PcmMspjxxSearchContext context) {
        Page<PcmMspjxx> domains = pcmmspjxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmmspjxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

