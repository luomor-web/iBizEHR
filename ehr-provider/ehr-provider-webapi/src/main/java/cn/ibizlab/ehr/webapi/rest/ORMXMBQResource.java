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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBQ;
import cn.ibizlab.ehr.core.orm.service.IORMXMBQService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBQSearchContext;

@Slf4j
@Api(tags = {"ORMXMBQ" })
@RestController("WebApi-ormxmbq")
@RequestMapping("")
public class ORMXMBQResource {

    @Autowired
    public IORMXMBQService ormxmbqService;

    @Autowired
    @Lazy
    public ORMXMBQMapping ormxmbqMapping;

    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-ORMXMBQ-Get')")
    @ApiOperation(value = "Get", tags = {"ORMXMBQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<ORMXMBQDTO> get(@PathVariable("ormxmbq_id") String ormxmbq_id) {
        ORMXMBQ domain = ormxmbqService.get(ormxmbq_id);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-ORMXMBQ-Create')")
    @ApiOperation(value = "Create", tags = {"ORMXMBQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> create(@RequestBody ORMXMBQDTO ormxmbqdto) {
        ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
		ormxmbqService.create(domain);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-ORMXMBQ-Create')")
    @ApiOperation(value = "createBatch", tags = {"ORMXMBQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.createBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-ORMXMBQ-Save')")
    @ApiOperation(value = "Save", tags = {"ORMXMBQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBQDTO ormxmbqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-ORMXMBQ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ORMXMBQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.saveBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ORMXMBQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBQDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"ORMXMBQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/getdraft")
    public ResponseEntity<ORMXMBQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(new ORMXMBQ())));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-ORMXMBQ-Remove')")
    @ApiOperation(value = "Remove", tags = {"ORMXMBQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbq_id") String ormxmbq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-ORMXMBQ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMBQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-ORMXMBQ-Update')")
    @ApiOperation(value = "Update", tags = {"ORMXMBQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> update(@PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
		ORMXMBQ domain  = ormxmbqMapping.toDomain(ormxmbqdto);
        domain .setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain );
		ORMXMBQDTO dto = ormxmbqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-ORMXMBQ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMBQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        ormxmbqService.updateBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMBQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbqs/fetchdefault")
	public ResponseEntity<List<ORMXMBQDTO>> fetchDefault(ORMXMBQSearchContext context) {
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
        List<ORMXMBQDTO> list = ormxmbqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMBQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbqs/searchdefault")
	public ResponseEntity<Page<ORMXMBQDTO>> searchDefault(@RequestBody ORMXMBQSearchContext context) {
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-ORMXMBQ-Get')")
    @ApiOperation(value = "GetByOrmOrg", tags = {"ORMXMBQ" },  notes = "GetByOrmOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<ORMXMBQDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
        ORMXMBQ domain = ormxmbqService.get(ormxmbq_id);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-ORMXMBQ-Create')")
    @ApiOperation(value = "CreateByOrmOrg", tags = {"ORMXMBQ" },  notes = "CreateByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
        ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
		ormxmbqService.create(domain);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-ORMXMBQ-Create')")
    @ApiOperation(value = "createBatchByOrmOrg", tags = {"ORMXMBQ" },  notes = "createBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        List<ORMXMBQ> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(ORMXMBQ domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-ORMXMBQ-Save')")
    @ApiOperation(value = "SaveByOrmOrg", tags = {"ORMXMBQ" },  notes = "SaveByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
        ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-ORMXMBQ-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrg", tags = {"ORMXMBQ" },  notes = "SaveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        List<ORMXMBQ> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(ORMXMBQ domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrg", tags = {"ORMXMBQ" },  notes = "CheckKeyByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "GetDraftByOrmOrg", tags = {"ORMXMBQ" },  notes = "GetDraftByOrmOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/getdraft")
    public ResponseEntity<ORMXMBQDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        ORMXMBQ domain = new ORMXMBQ();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-ORMXMBQ-Remove')")
    @ApiOperation(value = "RemoveByOrmOrg", tags = {"ORMXMBQ" },  notes = "RemoveByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-ORMXMBQ-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrg", tags = {"ORMXMBQ" },  notes = "RemoveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-ORMXMBQ-Update')")
    @ApiOperation(value = "UpdateByOrmOrg", tags = {"ORMXMBQ" },  notes = "UpdateByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<ORMXMBQDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody ORMXMBQDTO ormxmbqdto) {
        ORMXMBQ domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        domain.setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain);
        ORMXMBQDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-ORMXMBQ-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrg", tags = {"ORMXMBQ" },  notes = "UpdateBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ORMXMBQDTO> ormxmbqdtos) {
        List<ORMXMBQ> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(ORMXMBQ domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrg", tags = {"ORMXMBQ" } ,notes = "fetchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormxmbqs/fetchdefault")
	public ResponseEntity<List<ORMXMBQDTO>> fetchORMXMBQDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,ORMXMBQSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
        List<ORMXMBQDTO> list = ormxmbqMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBQ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrg", tags = {"ORMXMBQ" } ,notes = "searchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormxmbqs/searchdefault")
	public ResponseEntity<Page<ORMXMBQDTO>> searchORMXMBQDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMXMBQSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ORMXMBQ> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

