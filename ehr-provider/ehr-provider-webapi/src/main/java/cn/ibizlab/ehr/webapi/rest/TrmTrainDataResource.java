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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainData;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainDataService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDataSearchContext;

@Slf4j
@Api(tags = {"培训资料" })
@RestController("WebApi-trmtraindata")
@RequestMapping("")
public class TrmTrainDataResource {

    @Autowired
    public ITrmTrainDataService trmtraindataService;

    @Autowired
    @Lazy
    public TrmTrainDataMapping trmtraindataMapping;

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadto),'ehr-TrmTrainData-Save')")
    @ApiOperation(value = "保存培训资料", tags = {"培训资料" },  notes = "保存培训资料")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainDataDTO trmtraindatadto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.save(trmtraindataMapping.toDomain(trmtraindatadto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadtos),'ehr-TrmTrainData-Save')")
    @ApiOperation(value = "批量保存培训资料", tags = {"培训资料" },  notes = "批量保存培训资料")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainDataDTO> trmtraindatadtos) {
        trmtraindataService.saveBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.get(#trmtraindata_id),'ehr-TrmTrainData-Remove')")
    @ApiOperation(value = "删除培训资料", tags = {"培训资料" },  notes = "删除培训资料")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindata/{trmtraindata_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindata_id") String trmtraindata_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.remove(trmtraindata_id));
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.getTrmtraindataByIds(#ids),'ehr-TrmTrainData-Remove')")
    @ApiOperation(value = "批量删除培训资料", tags = {"培训资料" },  notes = "批量删除培训资料")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindataService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtraindataMapping.toDomain(returnObject.body),'ehr-TrmTrainData-Get')")
    @ApiOperation(value = "获取培训资料", tags = {"培训资料" },  notes = "获取培训资料")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindata/{trmtraindata_id}")
    public ResponseEntity<TrmTrainDataDTO> get(@PathVariable("trmtraindata_id") String trmtraindata_id) {
        TrmTrainData domain = trmtraindataService.get(trmtraindata_id);
        TrmTrainDataDTO dto = trmtraindataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取培训资料草稿", tags = {"培训资料" },  notes = "获取培训资料草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindata/getdraft")
    public ResponseEntity<TrmTrainDataDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindataMapping.toDto(trmtraindataService.getDraft(new TrmTrainData())));
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.get(#trmtraindata_id),'ehr-TrmTrainData-Update')")
    @ApiOperation(value = "更新培训资料", tags = {"培训资料" },  notes = "更新培训资料")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindata/{trmtraindata_id}")
    @Transactional
    public ResponseEntity<TrmTrainDataDTO> update(@PathVariable("trmtraindata_id") String trmtraindata_id, @RequestBody TrmTrainDataDTO trmtraindatadto) {
		TrmTrainData domain  = trmtraindataMapping.toDomain(trmtraindatadto);
        domain .setTrmtraindataid(trmtraindata_id);
		trmtraindataService.update(domain );
		TrmTrainDataDTO dto = trmtraindataMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.getTrmtraindataByEntities(this.trmtraindataMapping.toDomain(#trmtraindatadtos)),'ehr-TrmTrainData-Update')")
    @ApiOperation(value = "批量更新培训资料", tags = {"培训资料" },  notes = "批量更新培训资料")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainDataDTO> trmtraindatadtos) {
        trmtraindataService.updateBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训资料", tags = {"培训资料" },  notes = "检查培训资料")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainDataDTO trmtraindatadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.checkKey(trmtraindataMapping.toDomain(trmtraindatadto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadto),'ehr-TrmTrainData-Create')")
    @ApiOperation(value = "新建培训资料", tags = {"培训资料" },  notes = "新建培训资料")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata")
    @Transactional
    public ResponseEntity<TrmTrainDataDTO> create(@RequestBody TrmTrainDataDTO trmtraindatadto) {
        TrmTrainData domain = trmtraindataMapping.toDomain(trmtraindatadto);
		trmtraindataService.create(domain);
        TrmTrainDataDTO dto = trmtraindataMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadtos),'ehr-TrmTrainData-Create')")
    @ApiOperation(value = "批量新建培训资料", tags = {"培训资料" },  notes = "批量新建培训资料")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainDataDTO> trmtraindatadtos) {
        trmtraindataService.createBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainData-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训资料" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindata/fetchdefault")
	public ResponseEntity<List<TrmTrainDataDTO>> fetchDefault(TrmTrainDataSearchContext context) {
        Page<TrmTrainData> domains = trmtraindataService.searchDefault(context) ;
        List<TrmTrainDataDTO> list = trmtraindataMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainData-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训资料" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindata/searchdefault")
	public ResponseEntity<Page<TrmTrainDataDTO>> searchDefault(@RequestBody TrmTrainDataSearchContext context) {
        Page<TrmTrainData> domains = trmtraindataService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindataMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

