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
import cn.ibizlab.ehr.core.orm.domain.OrmXmbq;
import cn.ibizlab.ehr.core.orm.service.IOrmXmbqService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmbqSearchContext;

@Slf4j
@Api(tags = {"OrmXmbq" })
@RestController("WebApi-ormxmbq")
@RequestMapping("")
public class OrmXmbqResource {

    @Autowired
    public IOrmXmbqService ormxmbqService;

    @Autowired
    @Lazy
    public OrmXmbqMapping ormxmbqMapping;

    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-OrmXmbq-Get')")
    @ApiOperation(value = "Get", tags = {"OrmXmbq" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<OrmXmbqDTO> get(@PathVariable("ormxmbq_id") String ormxmbq_id) {
        OrmXmbq domain = ormxmbqService.get(ormxmbq_id);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "Create", tags = {"OrmXmbq" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> create(@RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
		ormxmbqService.create(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmXmbq" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.createBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "Save", tags = {"OrmXmbq" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmbqDTO ormxmbqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmXmbq" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.saveBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmXmbq" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmbqDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmXmbq" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbqs/getdraft")
    public ResponseEntity<OrmXmbqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(new OrmXmbq())));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmXmbq" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbq_id") String ormxmbq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmXmbq" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "Update", tags = {"OrmXmbq" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> update(@PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
		OrmXmbq domain  = ormxmbqMapping.toDomain(ormxmbqdto);
        domain .setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain );
		OrmXmbqDTO dto = ormxmbqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmXmbq" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        ormxmbqService.updateBatch(ormxmbqMapping.toDomain(ormxmbqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmXmbq" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbqs/fetchdefault")
	public ResponseEntity<List<OrmXmbqDTO>> fetchDefault(OrmXmbqSearchContext context) {
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
        List<OrmXmbqDTO> list = ormxmbqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmXmbq" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbqs/searchdefault")
	public ResponseEntity<Page<OrmXmbqDTO>> searchDefault(@RequestBody OrmXmbqSearchContext context) {
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.ormxmbqMapping.toDomain(returnObject.body),'ehr-OrmXmbq-Get')")
    @ApiOperation(value = "GetByOrmOrg", tags = {"OrmXmbq" },  notes = "GetByOrmOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    public ResponseEntity<OrmXmbqDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
        OrmXmbq domain = ormxmbqService.get(ormxmbq_id);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "CreateByOrmOrg", tags = {"OrmXmbq" },  notes = "CreateByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
		ormxmbqService.create(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Create')")
    @ApiOperation(value = "createBatchByOrmOrg", tags = {"OrmXmbq" },  notes = "createBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdto),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "SaveByOrmOrg", tags = {"OrmXmbq" },  notes = "SaveByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbqMapping.toDomain(#ormxmbqdtos),'ehr-OrmXmbq-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrg", tags = {"OrmXmbq" },  notes = "SaveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrg", tags = {"OrmXmbq" },  notes = "CheckKeyByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormxmbqs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.checkKey(ormxmbqMapping.toDomain(ormxmbqdto)));
    }

    @ApiOperation(value = "GetDraftByOrmOrg", tags = {"OrmXmbq" },  notes = "GetDraftByOrmOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormxmbqs/getdraft")
    public ResponseEntity<OrmXmbqDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        OrmXmbq domain = new OrmXmbq();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbqMapping.toDto(ormxmbqService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "RemoveByOrmOrg", tags = {"OrmXmbq" },  notes = "RemoveByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbqService.remove(ormxmbq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByIds(#ids),'ehr-OrmXmbq-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrg", tags = {"OrmXmbq" },  notes = "RemoveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormxmbqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.get(#ormxmbq_id),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "UpdateByOrmOrg", tags = {"OrmXmbq" },  notes = "UpdateByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/{ormxmbq_id}")
    @Transactional
    public ResponseEntity<OrmXmbqDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormxmbq_id") String ormxmbq_id, @RequestBody OrmXmbqDTO ormxmbqdto) {
        OrmXmbq domain = ormxmbqMapping.toDomain(ormxmbqdto);
        domain.setOrmorgid(ormorg_id);
        domain.setOrmxmbqid(ormxmbq_id);
		ormxmbqService.update(domain);
        OrmXmbqDTO dto = ormxmbqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbqService.getOrmxmbqByEntities(this.ormxmbqMapping.toDomain(#ormxmbqdtos)),'ehr-OrmXmbq-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrg", tags = {"OrmXmbq" },  notes = "UpdateBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormxmbqs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmXmbqDTO> ormxmbqdtos) {
        List<OrmXmbq> domainlist=ormxmbqMapping.toDomain(ormxmbqdtos);
        for(OrmXmbq domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormxmbqService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrg", tags = {"OrmXmbq" } ,notes = "fetchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormxmbqs/fetchdefault")
	public ResponseEntity<List<OrmXmbqDTO>> fetchOrmXmbqDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmXmbqSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
        List<OrmXmbqDTO> list = ormxmbqMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmbq-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrg", tags = {"OrmXmbq" } ,notes = "searchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormxmbqs/searchdefault")
	public ResponseEntity<Page<OrmXmbqDTO>> searchOrmXmbqDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmXmbqSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmXmbq> domains = ormxmbqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

