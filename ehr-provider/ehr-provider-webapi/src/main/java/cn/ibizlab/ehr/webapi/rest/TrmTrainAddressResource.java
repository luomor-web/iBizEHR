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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAddressSearchContext;

@Slf4j
@Api(tags = {"培训场地" })
@RestController("WebApi-trmtrainaddress")
@RequestMapping("")
public class TrmTrainAddressResource {

    @Autowired
    public ITrmTrainAddressService trmtrainaddressService;

    @Autowired
    @Lazy
    public TrmTrainAddressMapping trmtrainaddressMapping;

    @PreAuthorize("hasPermission(this.trmtrainaddressMapping.toDomain(#trmtrainaddressdto),'ehr-TrmTrainAddress-Save')")
    @ApiOperation(value = "保存培训场地", tags = {"培训场地" },  notes = "保存培训场地")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainAddressDTO trmtrainaddressdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.save(trmtrainaddressMapping.toDomain(trmtrainaddressdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressMapping.toDomain(#trmtrainaddressdtos),'ehr-TrmTrainAddress-Save')")
    @ApiOperation(value = "批量保存培训场地", tags = {"培训场地" },  notes = "批量保存培训场地")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainAddressDTO> trmtrainaddressdtos) {
        trmtrainaddressService.saveBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressService.get(#trmtrainaddress_id),'ehr-TrmTrainAddress-Remove')")
    @ApiOperation(value = "删除培训场地", tags = {"培训场地" },  notes = "删除培训场地")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.remove(trmtrainaddress_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressService.getTrmtrainaddressByIds(#ids),'ehr-TrmTrainAddress-Remove')")
    @ApiOperation(value = "批量删除培训场地", tags = {"培训场地" },  notes = "批量删除培训场地")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainaddressService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训场地草稿", tags = {"培训场地" },  notes = "获取培训场地草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/getdraft")
    public ResponseEntity<TrmTrainAddressDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressMapping.toDto(trmtrainaddressService.getDraft(new TrmTrainAddress())));
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressMapping.toDomain(#trmtrainaddressdto),'ehr-TrmTrainAddress-Create')")
    @ApiOperation(value = "新建培训场地", tags = {"培训场地" },  notes = "新建培训场地")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses")
    @Transactional
    public ResponseEntity<TrmTrainAddressDTO> create(@RequestBody TrmTrainAddressDTO trmtrainaddressdto) {
        TrmTrainAddress domain = trmtrainaddressMapping.toDomain(trmtrainaddressdto);
		trmtrainaddressService.create(domain);
        TrmTrainAddressDTO dto = trmtrainaddressMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressMapping.toDomain(#trmtrainaddressdtos),'ehr-TrmTrainAddress-Create')")
    @ApiOperation(value = "批量新建培训场地", tags = {"培训场地" },  notes = "批量新建培训场地")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainAddressDTO> trmtrainaddressdtos) {
        trmtrainaddressService.createBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressService.get(#trmtrainaddress_id),'ehr-TrmTrainAddress-Update')")
    @ApiOperation(value = "更新培训场地", tags = {"培训场地" },  notes = "更新培训场地")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    @Transactional
    public ResponseEntity<TrmTrainAddressDTO> update(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrainAddressDTO trmtrainaddressdto) {
		TrmTrainAddress domain  = trmtrainaddressMapping.toDomain(trmtrainaddressdto);
        domain .setTrmtrainaddressid(trmtrainaddress_id);
		trmtrainaddressService.update(domain );
		TrmTrainAddressDTO dto = trmtrainaddressMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainaddressService.getTrmtrainaddressByEntities(this.trmtrainaddressMapping.toDomain(#trmtrainaddressdtos)),'ehr-TrmTrainAddress-Update')")
    @ApiOperation(value = "批量更新培训场地", tags = {"培训场地" },  notes = "批量更新培训场地")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainAddressDTO> trmtrainaddressdtos) {
        trmtrainaddressService.updateBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainaddressMapping.toDomain(returnObject.body),'ehr-TrmTrainAddress-Get')")
    @ApiOperation(value = "获取培训场地", tags = {"培训场地" },  notes = "获取培训场地")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    public ResponseEntity<TrmTrainAddressDTO> get(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TrmTrainAddress domain = trmtrainaddressService.get(trmtrainaddress_id);
        TrmTrainAddressDTO dto = trmtrainaddressMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查培训场地", tags = {"培训场地" },  notes = "检查培训场地")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainAddressDTO trmtrainaddressdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.checkKey(trmtrainaddressMapping.toDomain(trmtrainaddressdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainAddress-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训场地" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/fetchdefault")
	public ResponseEntity<List<TrmTrainAddressDTO>> fetchDefault(TrmTrainAddressSearchContext context) {
        Page<TrmTrainAddress> domains = trmtrainaddressService.searchDefault(context) ;
        List<TrmTrainAddressDTO> list = trmtrainaddressMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainAddress-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训场地" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainaddresses/searchdefault")
	public ResponseEntity<Page<TrmTrainAddressDTO>> searchDefault(@RequestBody TrmTrainAddressSearchContext context) {
        Page<TrmTrainAddress> domains = trmtrainaddressService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainaddressMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

