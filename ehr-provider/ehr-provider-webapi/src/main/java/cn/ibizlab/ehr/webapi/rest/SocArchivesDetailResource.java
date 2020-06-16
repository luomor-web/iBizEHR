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
import cn.ibizlab.ehr.core.soc.domain.SocArchivesDetail;
import cn.ibizlab.ehr.core.soc.service.ISocArchivesDetailService;
import cn.ibizlab.ehr.core.soc.filter.SocArchivesDetailSearchContext;

@Slf4j
@Api(tags = {"社保档案明细" })
@RestController("WebApi-socarchivesdetail")
@RequestMapping("")
public class SocArchivesDetailResource {

    @Autowired
    public ISocArchivesDetailService socarchivesdetailService;

    @Autowired
    @Lazy
    public SocArchivesDetailMapping socarchivesdetailMapping;

    @PreAuthorize("hasPermission(this.socarchivesdetailMapping.toDomain(#socarchivesdetaildto),'ehr-SocArchivesDetail-Create')")
    @ApiOperation(value = "新建社保档案明细", tags = {"社保档案明细" },  notes = "新建社保档案明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchivesdetails")
    @Transactional
    public ResponseEntity<SocArchivesDetailDTO> create(@RequestBody SocArchivesDetailDTO socarchivesdetaildto) {
        SocArchivesDetail domain = socarchivesdetailMapping.toDomain(socarchivesdetaildto);
		socarchivesdetailService.create(domain);
        SocArchivesDetailDTO dto = socarchivesdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailMapping.toDomain(#socarchivesdetaildtos),'ehr-SocArchivesDetail-Create')")
    @ApiOperation(value = "批量新建社保档案明细", tags = {"社保档案明细" },  notes = "批量新建社保档案明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchivesdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocArchivesDetailDTO> socarchivesdetaildtos) {
        socarchivesdetailService.createBatch(socarchivesdetailMapping.toDomain(socarchivesdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailMapping.toDomain(#socarchivesdetaildto),'ehr-SocArchivesDetail-Save')")
    @ApiOperation(value = "保存社保档案明细", tags = {"社保档案明细" },  notes = "保存社保档案明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchivesdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SocArchivesDetailDTO socarchivesdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesdetailService.save(socarchivesdetailMapping.toDomain(socarchivesdetaildto)));
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailMapping.toDomain(#socarchivesdetaildtos),'ehr-SocArchivesDetail-Save')")
    @ApiOperation(value = "批量保存社保档案明细", tags = {"社保档案明细" },  notes = "批量保存社保档案明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchivesdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocArchivesDetailDTO> socarchivesdetaildtos) {
        socarchivesdetailService.saveBatch(socarchivesdetailMapping.toDomain(socarchivesdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查社保档案明细", tags = {"社保档案明细" },  notes = "检查社保档案明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchivesdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocArchivesDetailDTO socarchivesdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socarchivesdetailService.checkKey(socarchivesdetailMapping.toDomain(socarchivesdetaildto)));
    }

    @ApiOperation(value = "获取社保档案明细草稿", tags = {"社保档案明细" },  notes = "获取社保档案明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchivesdetails/getdraft")
    public ResponseEntity<SocArchivesDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesdetailMapping.toDto(socarchivesdetailService.getDraft(new SocArchivesDetail())));
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailService.get(#socarchivesdetail_id),'ehr-SocArchivesDetail-Update')")
    @ApiOperation(value = "更新社保档案明细", tags = {"社保档案明细" },  notes = "更新社保档案明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchivesdetails/{socarchivesdetail_id}")
    @Transactional
    public ResponseEntity<SocArchivesDetailDTO> update(@PathVariable("socarchivesdetail_id") String socarchivesdetail_id, @RequestBody SocArchivesDetailDTO socarchivesdetaildto) {
		SocArchivesDetail domain  = socarchivesdetailMapping.toDomain(socarchivesdetaildto);
        domain .setSocarchivesdetailid(socarchivesdetail_id);
		socarchivesdetailService.update(domain );
		SocArchivesDetailDTO dto = socarchivesdetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailService.getSocarchivesdetailByEntities(this.socarchivesdetailMapping.toDomain(#socarchivesdetaildtos)),'ehr-SocArchivesDetail-Update')")
    @ApiOperation(value = "批量更新社保档案明细", tags = {"社保档案明细" },  notes = "批量更新社保档案明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchivesdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocArchivesDetailDTO> socarchivesdetaildtos) {
        socarchivesdetailService.updateBatch(socarchivesdetailMapping.toDomain(socarchivesdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socarchivesdetailMapping.toDomain(returnObject.body),'ehr-SocArchivesDetail-Get')")
    @ApiOperation(value = "获取社保档案明细", tags = {"社保档案明细" },  notes = "获取社保档案明细")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchivesdetails/{socarchivesdetail_id}")
    public ResponseEntity<SocArchivesDetailDTO> get(@PathVariable("socarchivesdetail_id") String socarchivesdetail_id) {
        SocArchivesDetail domain = socarchivesdetailService.get(socarchivesdetail_id);
        SocArchivesDetailDTO dto = socarchivesdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailService.get(#socarchivesdetail_id),'ehr-SocArchivesDetail-Remove')")
    @ApiOperation(value = "删除社保档案明细", tags = {"社保档案明细" },  notes = "删除社保档案明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchivesdetails/{socarchivesdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socarchivesdetail_id") String socarchivesdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socarchivesdetailService.remove(socarchivesdetail_id));
    }

    @PreAuthorize("hasPermission(this.socarchivesdetailService.getSocarchivesdetailByIds(#ids),'ehr-SocArchivesDetail-Remove')")
    @ApiOperation(value = "批量删除社保档案明细", tags = {"社保档案明细" },  notes = "批量删除社保档案明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchivesdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socarchivesdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchivesDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"社保档案明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socarchivesdetails/fetchdefault")
	public ResponseEntity<List<SocArchivesDetailDTO>> fetchDefault(SocArchivesDetailSearchContext context) {
        Page<SocArchivesDetail> domains = socarchivesdetailService.searchDefault(context) ;
        List<SocArchivesDetailDTO> list = socarchivesdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchivesDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"社保档案明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socarchivesdetails/searchdefault")
	public ResponseEntity<Page<SocArchivesDetailDTO>> searchDefault(@RequestBody SocArchivesDetailSearchContext context) {
        Page<SocArchivesDetail> domains = socarchivesdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

