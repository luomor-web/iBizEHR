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
import cn.ibizlab.ehr.core.par.domain.ParJxlhmb;
import cn.ibizlab.ehr.core.par.service.IParJxlhmbService;
import cn.ibizlab.ehr.core.par.filter.ParJxlhmbSearchContext;

@Slf4j
@Api(tags = {"绩效量化目标" })
@RestController("WebApi-parjxlhmb")
@RequestMapping("")
public class ParJxlhmbResource {

    @Autowired
    public IParJxlhmbService parjxlhmbService;

    @Autowired
    @Lazy
    public ParJxlhmbMapping parjxlhmbMapping;

    @PreAuthorize("hasPermission(this.parjxlhmbMapping.toDomain(#parjxlhmbdto),'ehr-ParJxlhmb-Save')")
    @ApiOperation(value = "保存绩效量化目标", tags = {"绩效量化目标" },  notes = "保存绩效量化目标")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxlhmbDTO parjxlhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.save(parjxlhmbMapping.toDomain(parjxlhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parjxlhmbMapping.toDomain(#parjxlhmbdtos),'ehr-ParJxlhmb-Save')")
    @ApiOperation(value = "批量保存绩效量化目标", tags = {"绩效量化目标" },  notes = "批量保存绩效量化目标")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxlhmbDTO> parjxlhmbdtos) {
        parjxlhmbService.saveBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效量化目标草稿", tags = {"绩效量化目标" },  notes = "获取绩效量化目标草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxlhmbs/getdraft")
    public ResponseEntity<ParJxlhmbDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbMapping.toDto(parjxlhmbService.getDraft(new ParJxlhmb())));
    }

    @ApiOperation(value = "检查绩效量化目标", tags = {"绩效量化目标" },  notes = "检查绩效量化目标")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxlhmbDTO parjxlhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.checkKey(parjxlhmbMapping.toDomain(parjxlhmbdto)));
    }

    @PostAuthorize("hasPermission(this.parjxlhmbMapping.toDomain(returnObject.body),'ehr-ParJxlhmb-Get')")
    @ApiOperation(value = "获取绩效量化目标", tags = {"绩效量化目标" },  notes = "获取绩效量化目标")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxlhmbs/{parjxlhmb_id}")
    public ResponseEntity<ParJxlhmbDTO> get(@PathVariable("parjxlhmb_id") String parjxlhmb_id) {
        ParJxlhmb domain = parjxlhmbService.get(parjxlhmb_id);
        ParJxlhmbDTO dto = parjxlhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxlhmbService.get(#parjxlhmb_id),'ehr-ParJxlhmb-Update')")
    @ApiOperation(value = "更新绩效量化目标", tags = {"绩效量化目标" },  notes = "更新绩效量化目标")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxlhmbs/{parjxlhmb_id}")
    @Transactional
    public ResponseEntity<ParJxlhmbDTO> update(@PathVariable("parjxlhmb_id") String parjxlhmb_id, @RequestBody ParJxlhmbDTO parjxlhmbdto) {
		ParJxlhmb domain  = parjxlhmbMapping.toDomain(parjxlhmbdto);
        domain .setParjxlhmbid(parjxlhmb_id);
		parjxlhmbService.update(domain );
		ParJxlhmbDTO dto = parjxlhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxlhmbService.getParjxlhmbByEntities(this.parjxlhmbMapping.toDomain(#parjxlhmbdtos)),'ehr-ParJxlhmb-Update')")
    @ApiOperation(value = "批量更新绩效量化目标", tags = {"绩效量化目标" },  notes = "批量更新绩效量化目标")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxlhmbDTO> parjxlhmbdtos) {
        parjxlhmbService.updateBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxlhmbService.get(#parjxlhmb_id),'ehr-ParJxlhmb-Remove')")
    @ApiOperation(value = "删除绩效量化目标", tags = {"绩效量化目标" },  notes = "删除绩效量化目标")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxlhmbs/{parjxlhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxlhmb_id") String parjxlhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxlhmbService.remove(parjxlhmb_id));
    }

    @PreAuthorize("hasPermission(this.parjxlhmbService.getParjxlhmbByIds(#ids),'ehr-ParJxlhmb-Remove')")
    @ApiOperation(value = "批量删除绩效量化目标", tags = {"绩效量化目标" },  notes = "批量删除绩效量化目标")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxlhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxlhmbMapping.toDomain(#parjxlhmbdto),'ehr-ParJxlhmb-Create')")
    @ApiOperation(value = "新建绩效量化目标", tags = {"绩效量化目标" },  notes = "新建绩效量化目标")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs")
    @Transactional
    public ResponseEntity<ParJxlhmbDTO> create(@RequestBody ParJxlhmbDTO parjxlhmbdto) {
        ParJxlhmb domain = parjxlhmbMapping.toDomain(parjxlhmbdto);
		parjxlhmbService.create(domain);
        ParJxlhmbDTO dto = parjxlhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxlhmbMapping.toDomain(#parjxlhmbdtos),'ehr-ParJxlhmb-Create')")
    @ApiOperation(value = "批量新建绩效量化目标", tags = {"绩效量化目标" },  notes = "批量新建绩效量化目标")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxlhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxlhmbDTO> parjxlhmbdtos) {
        parjxlhmbService.createBatch(parjxlhmbMapping.toDomain(parjxlhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxlhmb-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效量化目标" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxlhmbs/fetchdefault")
	public ResponseEntity<List<ParJxlhmbDTO>> fetchDefault(ParJxlhmbSearchContext context) {
        Page<ParJxlhmb> domains = parjxlhmbService.searchDefault(context) ;
        List<ParJxlhmbDTO> list = parjxlhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxlhmb-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效量化目标" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxlhmbs/searchdefault")
	public ResponseEntity<Page<ParJxlhmbDTO>> searchDefault(@RequestBody ParJxlhmbSearchContext context) {
        Page<ParJxlhmb> domains = parjxlhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxlhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

