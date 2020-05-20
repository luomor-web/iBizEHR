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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PimSearchModal;
import cn.ibizlab.ehr.core.pim.service.IPimSearchModalService;
import cn.ibizlab.ehr.core.pim.filter.PimSearchModalSearchContext;




@Slf4j
@Api(tags = {"PimSearchModal" })
@RestController("WebApi-pimsearchmodal")
@RequestMapping("")
public class PimSearchModalResource {

    @Autowired
    private IPimSearchModalService pimsearchmodalService;

    @Autowired
    @Lazy
    private PimSearchModalMapping pimsearchmodalMapping;




    @ApiOperation(value = "GetDraft", tags = {"PimSearchModal" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchmodals/getdraft")
    public ResponseEntity<PimSearchModalDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalMapping.toDto(pimsearchmodalService.getDraft(new PimSearchModal())));
    }




    @PreAuthorize("hasPermission(#pimsearchmodal_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PimSearchModal" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchmodals/{pimsearchmodal_id}")
    @Transactional
    public ResponseEntity<PimSearchModalDTO> update(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id, @RequestBody PimSearchModalDTO pimsearchmodaldto) {
		PimSearchModal domain = pimsearchmodalMapping.toDomain(pimsearchmodaldto);
        domain.setPimsearchmodalid(pimsearchmodal_id);
		pimsearchmodalService.update(domain);
		PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimsearchmodal_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PimSearchModal" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.updateBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimsearchmodal_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PimSearchModal" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchmodals/{pimsearchmodal_id}")
    public ResponseEntity<PimSearchModalDTO> get(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id) {
        PimSearchModal domain = pimsearchmodalService.get(pimsearchmodal_id);
        PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PimSearchModal" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals")
    @Transactional
    public ResponseEntity<PimSearchModalDTO> create(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        PimSearchModal domain = pimsearchmodalMapping.toDomain(pimsearchmodaldto);
		pimsearchmodalService.create(domain);
        PimSearchModalDTO dto = pimsearchmodalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PimSearchModal" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.createBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PimSearchModal" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.checkKey(pimsearchmodalMapping.toDomain(pimsearchmodaldto)));
    }




    @ApiOperation(value = "Save", tags = {"PimSearchModal" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/save")
    public ResponseEntity<Boolean> save(@RequestBody PimSearchModalDTO pimsearchmodaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.save(pimsearchmodalMapping.toDomain(pimsearchmodaldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PimSearchModal" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchmodals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimSearchModalDTO> pimsearchmodaldtos) {
        pimsearchmodalService.saveBatch(pimsearchmodalMapping.toDomain(pimsearchmodaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimsearchmodal_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PimSearchModal" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchmodals/{pimsearchmodal_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsearchmodal_id") String pimsearchmodal_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsearchmodalService.remove(pimsearchmodal_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PimSearchModal" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchmodals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsearchmodalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchModal-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimSearchModal" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchmodals/fetchdefault")
	public ResponseEntity<List<PimSearchModalDTO>> fetchDefault(PimSearchModalSearchContext context) {
        Page<PimSearchModal> domains = pimsearchmodalService.searchDefault(context) ;
        List<PimSearchModalDTO> list = pimsearchmodalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchModal-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimSearchModal" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchmodals/searchdefault")
	public ResponseEntity<Page<PimSearchModalDTO>> searchDefault(@RequestBody PimSearchModalSearchContext context) {
        Page<PimSearchModal> domains = pimsearchmodalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchmodalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PimSearchModal getEntity(){
        return new PimSearchModal();
    }

}
