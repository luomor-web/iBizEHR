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
import cn.ibizlab.ehr.core.soc.domain.SocAccount;
import cn.ibizlab.ehr.core.soc.service.ISocAccountService;
import cn.ibizlab.ehr.core.soc.filter.SocAccountSearchContext;

@Slf4j
@Api(tags = {"参保账户" })
@RestController("WebApi-socaccount")
@RequestMapping("")
public class SocAccountResource {

    @Autowired
    public ISocAccountService socaccountService;

    @Autowired
    @Lazy
    public SocAccountMapping socaccountMapping;

    @ApiOperation(value = "检查参保账户", tags = {"参保账户" },  notes = "检查参保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/socaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocAccountDTO socaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socaccountService.checkKey(socaccountMapping.toDomain(socaccountdto)));
    }

    @PreAuthorize("hasPermission(this.socaccountMapping.toDomain(#socaccountdto),'ehr-SocAccount-Save')")
    @ApiOperation(value = "保存参保账户", tags = {"参保账户" },  notes = "保存参保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/socaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody SocAccountDTO socaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socaccountService.save(socaccountMapping.toDomain(socaccountdto)));
    }

    @PreAuthorize("hasPermission(this.socaccountMapping.toDomain(#socaccountdtos),'ehr-SocAccount-Save')")
    @ApiOperation(value = "批量保存参保账户", tags = {"参保账户" },  notes = "批量保存参保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/socaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocAccountDTO> socaccountdtos) {
        socaccountService.saveBatch(socaccountMapping.toDomain(socaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socaccountService.get(#socaccount_id),'ehr-SocAccount-Update')")
    @ApiOperation(value = "更新参保账户", tags = {"参保账户" },  notes = "更新参保账户")
	@RequestMapping(method = RequestMethod.PUT, value = "/socaccounts/{socaccount_id}")
    @Transactional
    public ResponseEntity<SocAccountDTO> update(@PathVariable("socaccount_id") String socaccount_id, @RequestBody SocAccountDTO socaccountdto) {
		SocAccount domain  = socaccountMapping.toDomain(socaccountdto);
        domain .setSocaccountid(socaccount_id);
		socaccountService.update(domain );
		SocAccountDTO dto = socaccountMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socaccountService.getSocaccountByEntities(this.socaccountMapping.toDomain(#socaccountdtos)),'ehr-SocAccount-Update')")
    @ApiOperation(value = "批量更新参保账户", tags = {"参保账户" },  notes = "批量更新参保账户")
	@RequestMapping(method = RequestMethod.PUT, value = "/socaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocAccountDTO> socaccountdtos) {
        socaccountService.updateBatch(socaccountMapping.toDomain(socaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socaccountService.get(#socaccount_id),'ehr-SocAccount-Remove')")
    @ApiOperation(value = "删除参保账户", tags = {"参保账户" },  notes = "删除参保账户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socaccounts/{socaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socaccount_id") String socaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socaccountService.remove(socaccount_id));
    }

    @PreAuthorize("hasPermission(this.socaccountService.getSocaccountByIds(#ids),'ehr-SocAccount-Remove')")
    @ApiOperation(value = "批量删除参保账户", tags = {"参保账户" },  notes = "批量删除参保账户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socaccountMapping.toDomain(returnObject.body),'ehr-SocAccount-Get')")
    @ApiOperation(value = "获取参保账户", tags = {"参保账户" },  notes = "获取参保账户")
	@RequestMapping(method = RequestMethod.GET, value = "/socaccounts/{socaccount_id}")
    public ResponseEntity<SocAccountDTO> get(@PathVariable("socaccount_id") String socaccount_id) {
        SocAccount domain = socaccountService.get(socaccount_id);
        SocAccountDTO dto = socaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socaccountMapping.toDomain(#socaccountdto),'ehr-SocAccount-Create')")
    @ApiOperation(value = "新建参保账户", tags = {"参保账户" },  notes = "新建参保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/socaccounts")
    @Transactional
    public ResponseEntity<SocAccountDTO> create(@RequestBody SocAccountDTO socaccountdto) {
        SocAccount domain = socaccountMapping.toDomain(socaccountdto);
		socaccountService.create(domain);
        SocAccountDTO dto = socaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socaccountMapping.toDomain(#socaccountdtos),'ehr-SocAccount-Create')")
    @ApiOperation(value = "批量新建参保账户", tags = {"参保账户" },  notes = "批量新建参保账户")
	@RequestMapping(method = RequestMethod.POST, value = "/socaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocAccountDTO> socaccountdtos) {
        socaccountService.createBatch(socaccountMapping.toDomain(socaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取参保账户草稿", tags = {"参保账户" },  notes = "获取参保账户草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socaccounts/getdraft")
    public ResponseEntity<SocAccountDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socaccountMapping.toDto(socaccountService.getDraft(new SocAccount())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocAccount-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"参保账户" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socaccounts/fetchdefault")
	public ResponseEntity<List<SocAccountDTO>> fetchDefault(SocAccountSearchContext context) {
        Page<SocAccount> domains = socaccountService.searchDefault(context) ;
        List<SocAccountDTO> list = socaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocAccount-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"参保账户" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socaccounts/searchdefault")
	public ResponseEntity<Page<SocAccountDTO>> searchDefault(@RequestBody SocAccountSearchContext context) {
        Page<SocAccount> domains = socaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

