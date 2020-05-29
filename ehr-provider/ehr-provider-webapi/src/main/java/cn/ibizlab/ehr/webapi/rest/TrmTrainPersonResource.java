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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPersonService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPersonSearchContext;

@Slf4j
@Api(tags = {"培训记录" })
@RestController("WebApi-trmtrainperson")
@RequestMapping("")
public class TrmTrainPersonResource {

    @Autowired
    public ITrmTrainPersonService trmtrainpersonService;

    @Autowired
    @Lazy
    public TrmTrainPersonMapping trmtrainpersonMapping;

    @ApiOperation(value = "获取培训记录草稿", tags = {"培训记录" },  notes = "获取培训记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainpeople/getdraft")
    public ResponseEntity<TrmTrainPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonMapping.toDto(trmtrainpersonService.getDraft(new TrmTrainPerson())));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "保存培训记录", tags = {"培训记录" },  notes = "保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.save(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "批量保存培训记录", tags = {"培训记录" },  notes = "批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.saveBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "删除培训记录", tags = {"培训记录" },  notes = "删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainperson_id") String trmtrainperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.remove(trmtrainperson_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByIds(#ids),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "批量删除培训记录", tags = {"培训记录" },  notes = "批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训记录", tags = {"培训记录" },  notes = "检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.checkKey(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "新建培训记录", tags = {"培训记录" },  notes = "新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> create(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
		trmtrainpersonService.create(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "批量新建培训记录", tags = {"培训记录" },  notes = "批量新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.createBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(returnObject.body),'ehr-TrmTrainPerson-Get')")
    @ApiOperation(value = "获取培训记录", tags = {"培训记录" },  notes = "获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainpeople/{trmtrainperson_id}")
    public ResponseEntity<TrmTrainPersonDTO> get(@PathVariable("trmtrainperson_id") String trmtrainperson_id) {
        TrmTrainPerson domain = trmtrainpersonService.get(trmtrainperson_id);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "更新培训记录", tags = {"培训记录" },  notes = "更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> update(@PathVariable("trmtrainperson_id") String trmtrainperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
		TrmTrainPerson domain  = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain .setTrmtrianpersonid(trmtrainperson_id);
		trmtrainpersonService.update(domain );
		TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByEntities(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos)),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "批量更新培训记录", tags = {"培训记录" },  notes = "批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.updateBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainpeople/fetchdefault")
	public ResponseEntity<List<TrmTrainPersonDTO>> fetchDefault(TrmTrainPersonSearchContext context) {
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
        List<TrmTrainPersonDTO> list = trmtrainpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainpeople/searchdefault")
	public ResponseEntity<Page<TrmTrainPersonDTO>> searchDefault(@RequestBody TrmTrainPersonSearchContext context) {
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息获取培训记录草稿", tags = {"培训记录" },  notes = "根据人员信息获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainpeople/getdraft")
    public ResponseEntity<TrmTrainPersonDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        TrmTrainPerson domain = new TrmTrainPerson();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonMapping.toDto(trmtrainpersonService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "根据人员信息保存培训记录", tags = {"培训记录" },  notes = "根据人员信息保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "根据人员信息批量保存培训记录", tags = {"培训记录" },  notes = "根据人员信息批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "根据人员信息删除培训记录", tags = {"培训记录" },  notes = "根据人员信息删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.remove(trmtrainperson_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByIds(#ids),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "根据人员信息批量删除培训记录", tags = {"培训记录" },  notes = "根据人员信息批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        trmtrainpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查培训记录", tags = {"培训记录" },  notes = "根据人员信息检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.checkKey(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "根据人员信息建立培训记录", tags = {"培训记录" },  notes = "根据人员信息建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
		trmtrainpersonService.create(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "根据人员信息批量建立培训记录", tags = {"培训记录" },  notes = "根据人员信息批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(returnObject.body),'ehr-TrmTrainPerson-Get')")
    @ApiOperation(value = "根据人员信息获取培训记录", tags = {"培训记录" },  notes = "根据人员信息获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    public ResponseEntity<TrmTrainPersonDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id) {
        TrmTrainPerson domain = trmtrainpersonService.get(trmtrainperson_id);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "根据人员信息更新培训记录", tags = {"培训记录" },  notes = "根据人员信息更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
        domain.setTrmtrianpersonid(trmtrainperson_id);
		trmtrainpersonService.update(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByEntities(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos)),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "根据人员信息批量更新培训记录", tags = {"培训记录" },  notes = "根据人员信息批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"培训记录" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrainpeople/fetchdefault")
	public ResponseEntity<List<TrmTrainPersonDTO>> fetchTrmTrainPersonDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,TrmTrainPersonSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
        List<TrmTrainPersonDTO> list = trmtrainpersonMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"培训记录" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrainpeople/searchdefault")
	public ResponseEntity<Page<TrmTrainPersonDTO>> searchTrmTrainPersonDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

