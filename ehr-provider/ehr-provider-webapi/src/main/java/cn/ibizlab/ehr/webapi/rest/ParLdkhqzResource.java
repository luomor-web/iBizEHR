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
import cn.ibizlab.ehr.core.par.domain.ParLdkhqz;
import cn.ibizlab.ehr.core.par.service.IParLdkhqzService;
import cn.ibizlab.ehr.core.par.filter.ParLdkhqzSearchContext;

@Slf4j
@Api(tags = {"评分权重分配" })
@RestController("WebApi-parldkhqz")
@RequestMapping("")
public class ParLdkhqzResource {

    @Autowired
    public IParLdkhqzService parldkhqzService;

    @Autowired
    @Lazy
    public ParLdkhqzMapping parldkhqzMapping;

    @ApiOperation(value = "检查评分权重分配", tags = {"评分权重分配" },  notes = "检查评分权重分配")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.checkKey(parldkhqzMapping.toDomain(parldkhqzdto)));
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdto),'ehr-ParLdkhqz-Create')")
    @ApiOperation(value = "新建评分权重分配", tags = {"评分权重分配" },  notes = "新建评分权重分配")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs")
    @Transactional
    public ResponseEntity<ParLdkhqzDTO> create(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        ParLdkhqz domain = parldkhqzMapping.toDomain(parldkhqzdto);
		parldkhqzService.create(domain);
        ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdtos),'ehr-ParLdkhqz-Create')")
    @ApiOperation(value = "批量新建评分权重分配", tags = {"评分权重分配" },  notes = "批量新建评分权重分配")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.createBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取评分权重分配草稿", tags = {"评分权重分配" },  notes = "获取评分权重分配草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/getdraft")
    public ResponseEntity<ParLdkhqzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzMapping.toDto(parldkhqzService.getDraft(new ParLdkhqz())));
    }

    @PostAuthorize("hasPermission(this.parldkhqzMapping.toDomain(returnObject.body),'ehr-ParLdkhqz-Get')")
    @ApiOperation(value = "获取评分权重分配", tags = {"评分权重分配" },  notes = "获取评分权重分配")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/{parldkhqz_id}")
    public ResponseEntity<ParLdkhqzDTO> get(@PathVariable("parldkhqz_id") String parldkhqz_id) {
        ParLdkhqz domain = parldkhqzService.get(parldkhqz_id);
        ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.get(#parldkhqz_id),'ehr-ParLdkhqz-Remove')")
    @ApiOperation(value = "删除评分权重分配", tags = {"评分权重分配" },  notes = "删除评分权重分配")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldkhqz_id") String parldkhqz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.remove(parldkhqz_id));
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.getParldkhqzByIds(#ids),'ehr-ParLdkhqz-Remove')")
    @ApiOperation(value = "批量删除评分权重分配", tags = {"评分权重分配" },  notes = "批量删除评分权重分配")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldkhqzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdto),'ehr-ParLdkhqz-Save')")
    @ApiOperation(value = "保存评分权重分配", tags = {"评分权重分配" },  notes = "保存评分权重分配")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLdkhqzDTO parldkhqzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.save(parldkhqzMapping.toDomain(parldkhqzdto)));
    }

    @PreAuthorize("hasPermission(this.parldkhqzMapping.toDomain(#parldkhqzdtos),'ehr-ParLdkhqz-Save')")
    @ApiOperation(value = "批量保存评分权重分配", tags = {"评分权重分配" },  notes = "批量保存评分权重分配")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.saveBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.get(#parldkhqz_id),'ehr-ParLdkhqz-Update')")
    @ApiOperation(value = "更新评分权重分配", tags = {"评分权重分配" },  notes = "更新评分权重分配")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<ParLdkhqzDTO> update(@PathVariable("parldkhqz_id") String parldkhqz_id, @RequestBody ParLdkhqzDTO parldkhqzdto) {
		ParLdkhqz domain  = parldkhqzMapping.toDomain(parldkhqzdto);
        domain .setParldkhqzid(parldkhqz_id);
		parldkhqzService.update(domain );
		ParLdkhqzDTO dto = parldkhqzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldkhqzService.getParldkhqzByEntities(this.parldkhqzMapping.toDomain(#parldkhqzdtos)),'ehr-ParLdkhqz-Update')")
    @ApiOperation(value = "批量更新评分权重分配", tags = {"评分权重分配" },  notes = "批量更新评分权重分配")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLdkhqzDTO> parldkhqzdtos) {
        parldkhqzService.updateBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdkhqz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"评分权重分配" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldkhqzs/fetchdefault")
	public ResponseEntity<List<ParLdkhqzDTO>> fetchDefault(ParLdkhqzSearchContext context) {
        Page<ParLdkhqz> domains = parldkhqzService.searchDefault(context) ;
        List<ParLdkhqzDTO> list = parldkhqzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdkhqz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"评分权重分配" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldkhqzs/searchdefault")
	public ResponseEntity<Page<ParLdkhqzDTO>> searchDefault(@RequestBody ParLdkhqzSearchContext context) {
        Page<ParLdkhqz> domains = parldkhqzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldkhqzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

