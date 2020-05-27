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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBMX;
import cn.ibizlab.ehr.core.orm.service.IORMXMBMXService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBMXSearchContext;

@Slf4j
@Api(tags = {"ORMXMBMX" })
@RestController("WebApi-ormxmbmx")
@RequestMapping("")
public class ORMXMBMXResource {

    @Autowired
    private IORMXMBMXService ormxmbmxService;

    @Autowired
    @Lazy
    public ORMXMBMXMapping ormxmbmxMapping;

    public ORMXMBMXDTO permissionDTO=new ORMXMBMXDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "Save", tags = {"ORMXMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMXMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.saveBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMXMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(new ORMXMBMX())));
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
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

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.updateBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Get',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMXMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> get(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMXMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "Create", tags = {"ORMXMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> create(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.createBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMXMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO,#ids})")
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
    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "SaveByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "SaveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "SaveBatchByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "SaveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "GetDraftByORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "UpdateByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "UpdateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "UpdateBatchByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "UpdateBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Get',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "GetByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "CheckKeyByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "CreateByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "CreateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "createBatchByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "createBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "RemoveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "RemoveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGSECTOR(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGSECTOR", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGSECTOR", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"ORMXMBMX" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"ORMXMBMX" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"ORMXMBMX" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"ORMXMBMX" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"ORMXMBMX" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Get',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"ORMXMBMX" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"ORMXMBMX" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"ORMXMBMX" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"ORMXMBMX" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"ORMXMBMX" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"ORMXMBMX" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,ORMXMBMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "SaveByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "SaveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "SaveBatchByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "SaveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "GetDraftByORMORGORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "UpdateByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "UpdateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "UpdateBatchByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "UpdateBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Get',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "GetByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "CheckKeyByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "CreateByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "CreateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdtos})")
    @ApiOperation(value = "createBatchByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "createBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "RemoveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMORGORMORGSECTOR", tags = {"ORMXMBMX" },  notes = "RemoveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGORMORGSECTOR(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMXMBMX" } ,notes = "searchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
