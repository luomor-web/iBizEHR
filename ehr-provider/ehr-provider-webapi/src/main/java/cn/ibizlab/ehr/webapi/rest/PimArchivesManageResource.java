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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesManage;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesManageService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesManageSearchContext;

@Slf4j
@Api(tags = {"档案管理" })
@RestController("WebApi-pimarchivesmanage")
@RequestMapping("")
public class PimArchivesManageResource {

    @Autowired
    public IPimArchivesManageService pimarchivesmanageService;

    @Autowired
    @Lazy
    public PimArchivesManageMapping pimarchivesmanageMapping;

    @PreAuthorize("hasPermission(this.pimarchivesmanageService.get(#pimarchivesmanage_id),'ehr-PimArchivesManage-Remove')")
    @ApiOperation(value = "删除档案管理", tags = {"档案管理" },  notes = "删除档案管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesmanages/{pimarchivesmanage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivesmanage_id") String pimarchivesmanage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesmanageService.remove(pimarchivesmanage_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageService.getPimarchivesmanageByIds(#ids),'ehr-PimArchivesManage-Remove')")
    @ApiOperation(value = "批量删除档案管理", tags = {"档案管理" },  notes = "批量删除档案管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesmanages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesmanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取档案管理草稿", tags = {"档案管理" },  notes = "获取档案管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesmanages/getdraft")
    public ResponseEntity<PimArchivesManageDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesmanageMapping.toDto(pimarchivesmanageService.getDraft(new PimArchivesManage())));
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageService.get(#pimarchivesmanage_id),'ehr-PimArchivesManage-Update')")
    @ApiOperation(value = "更新档案管理", tags = {"档案管理" },  notes = "更新档案管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesmanages/{pimarchivesmanage_id}")
    @Transactional
    public ResponseEntity<PimArchivesManageDTO> update(@PathVariable("pimarchivesmanage_id") String pimarchivesmanage_id, @RequestBody PimArchivesManageDTO pimarchivesmanagedto) {
		PimArchivesManage domain  = pimarchivesmanageMapping.toDomain(pimarchivesmanagedto);
        domain .setArchivesmanageid(pimarchivesmanage_id);
		pimarchivesmanageService.update(domain );
		PimArchivesManageDTO dto = pimarchivesmanageMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageService.getPimarchivesmanageByEntities(this.pimarchivesmanageMapping.toDomain(#pimarchivesmanagedtos)),'ehr-PimArchivesManage-Update')")
    @ApiOperation(value = "批量更新档案管理", tags = {"档案管理" },  notes = "批量更新档案管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesmanages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivesManageDTO> pimarchivesmanagedtos) {
        pimarchivesmanageService.updateBatch(pimarchivesmanageMapping.toDomain(pimarchivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageMapping.toDomain(#pimarchivesmanagedto),'ehr-PimArchivesManage-Create')")
    @ApiOperation(value = "新建档案管理", tags = {"档案管理" },  notes = "新建档案管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesmanages")
    @Transactional
    public ResponseEntity<PimArchivesManageDTO> create(@RequestBody PimArchivesManageDTO pimarchivesmanagedto) {
        PimArchivesManage domain = pimarchivesmanageMapping.toDomain(pimarchivesmanagedto);
		pimarchivesmanageService.create(domain);
        PimArchivesManageDTO dto = pimarchivesmanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageMapping.toDomain(#pimarchivesmanagedtos),'ehr-PimArchivesManage-Create')")
    @ApiOperation(value = "批量新建档案管理", tags = {"档案管理" },  notes = "批量新建档案管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesmanages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivesManageDTO> pimarchivesmanagedtos) {
        pimarchivesmanageService.createBatch(pimarchivesmanageMapping.toDomain(pimarchivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageMapping.toDomain(#pimarchivesmanagedto),'ehr-PimArchivesManage-Save')")
    @ApiOperation(value = "保存档案管理", tags = {"档案管理" },  notes = "保存档案管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesmanages/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivesManageDTO pimarchivesmanagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesmanageService.save(pimarchivesmanageMapping.toDomain(pimarchivesmanagedto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesmanageMapping.toDomain(#pimarchivesmanagedtos),'ehr-PimArchivesManage-Save')")
    @ApiOperation(value = "批量保存档案管理", tags = {"档案管理" },  notes = "批量保存档案管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesmanages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivesManageDTO> pimarchivesmanagedtos) {
        pimarchivesmanageService.saveBatch(pimarchivesmanageMapping.toDomain(pimarchivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查档案管理", tags = {"档案管理" },  notes = "检查档案管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesmanages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivesManageDTO pimarchivesmanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesmanageService.checkKey(pimarchivesmanageMapping.toDomain(pimarchivesmanagedto)));
    }

    @PostAuthorize("hasPermission(this.pimarchivesmanageMapping.toDomain(returnObject.body),'ehr-PimArchivesManage-Get')")
    @ApiOperation(value = "获取档案管理", tags = {"档案管理" },  notes = "获取档案管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesmanages/{pimarchivesmanage_id}")
    public ResponseEntity<PimArchivesManageDTO> get(@PathVariable("pimarchivesmanage_id") String pimarchivesmanage_id) {
        PimArchivesManage domain = pimarchivesmanageService.get(pimarchivesmanage_id);
        PimArchivesManageDTO dto = pimarchivesmanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesManage-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivesmanages/fetchdefault")
	public ResponseEntity<List<PimArchivesManageDTO>> fetchDefault(PimArchivesManageSearchContext context) {
        Page<PimArchivesManage> domains = pimarchivesmanageService.searchDefault(context) ;
        List<PimArchivesManageDTO> list = pimarchivesmanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesManage-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"档案管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivesmanages/searchdefault")
	public ResponseEntity<Page<PimArchivesManageDTO>> searchDefault(@RequestBody PimArchivesManageSearchContext context) {
        Page<PimArchivesManage> domains = pimarchivesmanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesmanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

