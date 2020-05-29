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
import cn.ibizlab.ehr.core.par.domain.ParJxmtfk;
import cn.ibizlab.ehr.core.par.service.IParJxmtfkService;
import cn.ibizlab.ehr.core.par.filter.ParJxmtfkSearchContext;

@Slf4j
@Api(tags = {"绩效面谈反馈" })
@RestController("WebApi-parjxmtfk")
@RequestMapping("")
public class ParJxmtfkResource {

    @Autowired
    public IParJxmtfkService parjxmtfkService;

    @Autowired
    @Lazy
    public ParJxmtfkMapping parjxmtfkMapping;

    @PreAuthorize("hasPermission(this.parjxmtfkMapping.toDomain(#parjxmtfkdto),'ehr-ParJxmtfk-Create')")
    @ApiOperation(value = "新建绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "新建绩效面谈反馈")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks")
    @Transactional
    public ResponseEntity<ParJxmtfkDTO> create(@RequestBody ParJxmtfkDTO parjxmtfkdto) {
        ParJxmtfk domain = parjxmtfkMapping.toDomain(parjxmtfkdto);
		parjxmtfkService.create(domain);
        ParJxmtfkDTO dto = parjxmtfkMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxmtfkMapping.toDomain(#parjxmtfkdtos),'ehr-ParJxmtfk-Create')")
    @ApiOperation(value = "批量新建绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "批量新建绩效面谈反馈")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxmtfkDTO> parjxmtfkdtos) {
        parjxmtfkService.createBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxmtfkService.get(#parjxmtfk_id),'ehr-ParJxmtfk-Update')")
    @ApiOperation(value = "更新绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "更新绩效面谈反馈")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxmtfks/{parjxmtfk_id}")
    @Transactional
    public ResponseEntity<ParJxmtfkDTO> update(@PathVariable("parjxmtfk_id") String parjxmtfk_id, @RequestBody ParJxmtfkDTO parjxmtfkdto) {
		ParJxmtfk domain  = parjxmtfkMapping.toDomain(parjxmtfkdto);
        domain .setParjxmtfkid(parjxmtfk_id);
		parjxmtfkService.update(domain );
		ParJxmtfkDTO dto = parjxmtfkMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxmtfkService.getParjxmtfkByEntities(this.parjxmtfkMapping.toDomain(#parjxmtfkdtos)),'ehr-ParJxmtfk-Update')")
    @ApiOperation(value = "批量更新绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "批量更新绩效面谈反馈")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxmtfkDTO> parjxmtfkdtos) {
        parjxmtfkService.updateBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效面谈反馈草稿", tags = {"绩效面谈反馈" },  notes = "获取绩效面谈反馈草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxmtfks/getdraft")
    public ResponseEntity<ParJxmtfkDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkMapping.toDto(parjxmtfkService.getDraft(new ParJxmtfk())));
    }

    @PostAuthorize("hasPermission(this.parjxmtfkMapping.toDomain(returnObject.body),'ehr-ParJxmtfk-Get')")
    @ApiOperation(value = "获取绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "获取绩效面谈反馈")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxmtfks/{parjxmtfk_id}")
    public ResponseEntity<ParJxmtfkDTO> get(@PathVariable("parjxmtfk_id") String parjxmtfk_id) {
        ParJxmtfk domain = parjxmtfkService.get(parjxmtfk_id);
        ParJxmtfkDTO dto = parjxmtfkMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxmtfkService.get(#parjxmtfk_id),'ehr-ParJxmtfk-Remove')")
    @ApiOperation(value = "删除绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "删除绩效面谈反馈")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxmtfks/{parjxmtfk_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxmtfk_id") String parjxmtfk_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.remove(parjxmtfk_id));
    }

    @PreAuthorize("hasPermission(this.parjxmtfkService.getParjxmtfkByIds(#ids),'ehr-ParJxmtfk-Remove')")
    @ApiOperation(value = "批量删除绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "批量删除绩效面谈反馈")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxmtfkService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "检查绩效面谈反馈")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxmtfkDTO parjxmtfkdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.checkKey(parjxmtfkMapping.toDomain(parjxmtfkdto)));
    }

    @PreAuthorize("hasPermission(this.parjxmtfkMapping.toDomain(#parjxmtfkdto),'ehr-ParJxmtfk-Save')")
    @ApiOperation(value = "保存绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "保存绩效面谈反馈")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxmtfkDTO parjxmtfkdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.save(parjxmtfkMapping.toDomain(parjxmtfkdto)));
    }

    @PreAuthorize("hasPermission(this.parjxmtfkMapping.toDomain(#parjxmtfkdtos),'ehr-ParJxmtfk-Save')")
    @ApiOperation(value = "批量保存绩效面谈反馈", tags = {"绩效面谈反馈" },  notes = "批量保存绩效面谈反馈")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxmtfkDTO> parjxmtfkdtos) {
        parjxmtfkService.saveBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxmtfk-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效面谈反馈" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxmtfks/fetchdefault")
	public ResponseEntity<List<ParJxmtfkDTO>> fetchDefault(ParJxmtfkSearchContext context) {
        Page<ParJxmtfk> domains = parjxmtfkService.searchDefault(context) ;
        List<ParJxmtfkDTO> list = parjxmtfkMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxmtfk-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效面谈反馈" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxmtfks/searchdefault")
	public ResponseEntity<Page<ParJxmtfkDTO>> searchDefault(@RequestBody ParJxmtfkSearchContext context) {
        Page<ParJxmtfk> domains = parjxmtfkService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxmtfkMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

