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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemandSum;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandSumService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainDemandSumSearchContext;

@Slf4j
@Api(tags = {"TrmTrainDemandSum" })
@RestController("WebApi-trmtraindemandsum")
@RequestMapping("")
public class TrmTrainDemandSumResource {

    @Autowired
    public ITrmTrainDemandSumService trmtraindemandsumService;

    @Autowired
    @Lazy
    public TrmTrainDemandSumMapping trmtraindemandsumMapping;

    @PreAuthorize("hasPermission(this.trmtraindemandsumMapping.toDomain(#trmtraindemandsumdto),'ehr-TrmTrainDemandSum-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainDemandSum" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainDemandSumDTO trmtraindemandsumdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.save(trmtraindemandsumMapping.toDomain(trmtraindemandsumdto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumMapping.toDomain(#trmtraindemandsumdtos),'ehr-TrmTrainDemandSum-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainDemandSum" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainDemandSumDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.saveBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtraindemandsumMapping.toDomain(returnObject.body),'ehr-TrmTrainDemandSum-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainDemandSum" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    public ResponseEntity<TrmTrainDemandSumDTO> get(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id) {
        TrmTrainDemandSum domain = trmtraindemandsumService.get(trmtraindemandsum_id);
        TrmTrainDemandSumDTO dto = trmtraindemandsumMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumMapping.toDomain(#trmtraindemandsumdto),'ehr-TrmTrainDemandSum-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainDemandSum" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums")
    @Transactional
    public ResponseEntity<TrmTrainDemandSumDTO> create(@RequestBody TrmTrainDemandSumDTO trmtraindemandsumdto) {
        TrmTrainDemandSum domain = trmtraindemandsumMapping.toDomain(trmtraindemandsumdto);
		trmtraindemandsumService.create(domain);
        TrmTrainDemandSumDTO dto = trmtraindemandsumMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumMapping.toDomain(#trmtraindemandsumdtos),'ehr-TrmTrainDemandSum-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainDemandSum" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainDemandSumDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.createBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumService.get(#trmtraindemandsum_id),'ehr-TrmTrainDemandSum-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainDemandSum" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.remove(trmtraindemandsum_id));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumService.getTrmtraindemandsumByIds(#ids),'ehr-TrmTrainDemandSum-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainDemandSum" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindemandsumService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainDemandSum" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindemandsums/getdraft")
    public ResponseEntity<TrmTrainDemandSumDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumMapping.toDto(trmtraindemandsumService.getDraft(new TrmTrainDemandSum())));
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumService.get(#trmtraindemandsum_id),'ehr-TrmTrainDemandSum-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainDemandSum" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemandsums/{trmtraindemandsum_id}")
    @Transactional
    public ResponseEntity<TrmTrainDemandSumDTO> update(@PathVariable("trmtraindemandsum_id") String trmtraindemandsum_id, @RequestBody TrmTrainDemandSumDTO trmtraindemandsumdto) {
		TrmTrainDemandSum domain  = trmtraindemandsumMapping.toDomain(trmtraindemandsumdto);
        domain .setTrmtraindemandsumid(trmtraindemandsum_id);
		trmtraindemandsumService.update(domain );
		TrmTrainDemandSumDTO dto = trmtraindemandsumMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindemandsumService.getTrmtraindemandsumByEntities(this.trmtraindemandsumMapping.toDomain(#trmtraindemandsumdtos)),'ehr-TrmTrainDemandSum-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainDemandSum" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindemandsums/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainDemandSumDTO> trmtraindemandsumdtos) {
        trmtraindemandsumService.updateBatch(trmtraindemandsumMapping.toDomain(trmtraindemandsumdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainDemandSum" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindemandsums/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainDemandSumDTO trmtraindemandsumdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindemandsumService.checkKey(trmtraindemandsumMapping.toDomain(trmtraindemandsumdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainDemandSum-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainDemandSum" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindemandsums/fetchdefault")
	public ResponseEntity<List<TrmTrainDemandSumDTO>> fetchDefault(TrmTrainDemandSumSearchContext context) {
        Page<TrmTrainDemandSum> domains = trmtraindemandsumService.searchDefault(context) ;
        List<TrmTrainDemandSumDTO> list = trmtraindemandsumMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainDemandSum-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainDemandSum" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindemandsums/searchdefault")
	public ResponseEntity<Page<TrmTrainDemandSumDTO>> searchDefault(@RequestBody TrmTrainDemandSumSearchContext context) {
        Page<TrmTrainDemandSum> domains = trmtraindemandsumService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindemandsumMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

