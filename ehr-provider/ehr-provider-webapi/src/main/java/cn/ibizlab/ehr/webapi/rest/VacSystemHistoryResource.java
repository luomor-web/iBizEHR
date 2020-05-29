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
import cn.ibizlab.ehr.core.vac.domain.VacSystemHistory;
import cn.ibizlab.ehr.core.vac.service.IVacSystemHistoryService;
import cn.ibizlab.ehr.core.vac.filter.VacSystemHistorySearchContext;

@Slf4j
@Api(tags = {"制度历史" })
@RestController("WebApi-vacsystemhistory")
@RequestMapping("")
public class VacSystemHistoryResource {

    @Autowired
    public IVacSystemHistoryService vacsystemhistoryService;

    @Autowired
    @Lazy
    public VacSystemHistoryMapping vacsystemhistoryMapping;

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.get(#vacsystemhistory_id),'ehr-VacSystemHistory-Update')")
    @ApiOperation(value = "更新制度历史", tags = {"制度历史" },  notes = "更新制度历史")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemhistories/{vacsystemhistory_id}")
    @Transactional
    public ResponseEntity<VacSystemHistoryDTO> update(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id, @RequestBody VacSystemHistoryDTO vacsystemhistorydto) {
		VacSystemHistory domain  = vacsystemhistoryMapping.toDomain(vacsystemhistorydto);
        domain .setVacsystemhistoryid(vacsystemhistory_id);
		vacsystemhistoryService.update(domain );
		VacSystemHistoryDTO dto = vacsystemhistoryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.getVacsystemhistoryByEntities(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos)),'ehr-VacSystemHistory-Update')")
    @ApiOperation(value = "批量更新制度历史", tags = {"制度历史" },  notes = "批量更新制度历史")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacSystemHistoryDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.updateBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.get(#vacsystemhistory_id),'ehr-VacSystemHistory-Remove')")
    @ApiOperation(value = "删除制度历史", tags = {"制度历史" },  notes = "删除制度历史")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemhistories/{vacsystemhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.remove(vacsystemhistory_id));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.getVacsystemhistoryByIds(#ids),'ehr-VacSystemHistory-Remove')")
    @ApiOperation(value = "批量删除制度历史", tags = {"制度历史" },  notes = "批量删除制度历史")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsystemhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydto),'ehr-VacSystemHistory-Save')")
    @ApiOperation(value = "保存制度历史", tags = {"制度历史" },  notes = "保存制度历史")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/save")
    public ResponseEntity<Boolean> save(@RequestBody VacSystemHistoryDTO vacsystemhistorydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.save(vacsystemhistoryMapping.toDomain(vacsystemhistorydto)));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos),'ehr-VacSystemHistory-Save')")
    @ApiOperation(value = "批量保存制度历史", tags = {"制度历史" },  notes = "批量保存制度历史")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacSystemHistoryDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.saveBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(returnObject.body),'ehr-VacSystemHistory-Get')")
    @ApiOperation(value = "获取制度历史", tags = {"制度历史" },  notes = "获取制度历史")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemhistories/{vacsystemhistory_id}")
    public ResponseEntity<VacSystemHistoryDTO> get(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id) {
        VacSystemHistory domain = vacsystemhistoryService.get(vacsystemhistory_id);
        VacSystemHistoryDTO dto = vacsystemhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查制度历史", tags = {"制度历史" },  notes = "检查制度历史")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacSystemHistoryDTO vacsystemhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.checkKey(vacsystemhistoryMapping.toDomain(vacsystemhistorydto)));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydto),'ehr-VacSystemHistory-Create')")
    @ApiOperation(value = "新建制度历史", tags = {"制度历史" },  notes = "新建制度历史")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories")
    @Transactional
    public ResponseEntity<VacSystemHistoryDTO> create(@RequestBody VacSystemHistoryDTO vacsystemhistorydto) {
        VacSystemHistory domain = vacsystemhistoryMapping.toDomain(vacsystemhistorydto);
		vacsystemhistoryService.create(domain);
        VacSystemHistoryDTO dto = vacsystemhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos),'ehr-VacSystemHistory-Create')")
    @ApiOperation(value = "批量新建制度历史", tags = {"制度历史" },  notes = "批量新建制度历史")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacSystemHistoryDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.createBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取制度历史草稿", tags = {"制度历史" },  notes = "获取制度历史草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemhistories/getdraft")
    public ResponseEntity<VacSystemHistoryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryMapping.toDto(vacsystemhistoryService.getDraft(new VacSystemHistory())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSystemHistory-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"制度历史" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsystemhistories/fetchdefault")
	public ResponseEntity<List<VacSystemHistoryDTO>> fetchDefault(VacSystemHistorySearchContext context) {
        Page<VacSystemHistory> domains = vacsystemhistoryService.searchDefault(context) ;
        List<VacSystemHistoryDTO> list = vacsystemhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacSystemHistory-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"制度历史" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsystemhistories/searchdefault")
	public ResponseEntity<Page<VacSystemHistoryDTO>> searchDefault(@RequestBody VacSystemHistorySearchContext context) {
        Page<VacSystemHistory> domains = vacsystemhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsystemhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

