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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBMX;
import cn.ibizlab.ehr.core.orm.service.IORMXMBMXService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBMXSearchContext;

@Slf4j
@Api(tags = {"ORMXMBMX" })
@RestController("WebApi-ormxmbmx")
@RequestMapping("")
public class ORMXMBMXResource {

    @Autowired
    public IORMXMBMXService ormxmbmxService;

    @Autowired
    @Lazy
    public ORMXMBMXMapping ormxmbmxMapping;

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "Save", tags = {"ORMXMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ORMXMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.saveBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ORMXMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(new ORMXMBMX())));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "Update", tags = {"ORMXMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> update(@PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
		ORMXMBMX domain  = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain .setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain );
		ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.updateBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "Get", tags = {"ORMXMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> get(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ORMXMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "Create", tags = {"ORMXMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> create(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"ORMXMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.createBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"ORMXMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchDefault(ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchDefault(@RequestBody ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"ORMXMBMX" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"ORMXMBMX" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"ORMXMBMX" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"ORMXMBMX" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"ORMXMBMX" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"ORMXMBMX" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"ORMXMBMX" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"ORMXMBMX" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"ORMXMBMX" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"ORMXMBMX" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"ORMXMBMX" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"ORMXMBMX" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ORMXMBMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

