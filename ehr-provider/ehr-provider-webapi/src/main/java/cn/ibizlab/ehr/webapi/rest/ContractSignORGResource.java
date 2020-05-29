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
import cn.ibizlab.ehr.core.pim.domain.ContractSignORG;
import cn.ibizlab.ehr.core.pim.service.IContractSignORGService;
import cn.ibizlab.ehr.core.pim.filter.ContractSignORGSearchContext;

@Slf4j
@Api(tags = {"ContractSignORG" })
@RestController("WebApi-contractsignorg")
@RequestMapping("")
public class ContractSignORGResource {

    @Autowired
    public IContractSignORGService contractsignorgService;

    @Autowired
    @Lazy
    public ContractSignORGMapping contractsignorgMapping;

    @PostAuthorize("hasPermission(this.contractsignorgMapping.toDomain(returnObject.body),'ehr-ContractSignORG-Get')")
    @ApiOperation(value = "Get", tags = {"ContractSignORG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/contractsignorgs/{contractsignorg_id}")
    public ResponseEntity<ContractSignORGDTO> get(@PathVariable("contractsignorg_id") String contractsignorg_id) {
        ContractSignORG domain = contractsignorgService.get(contractsignorg_id);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ContractSignORG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ContractSignORGDTO contractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.checkKey(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "Update", tags = {"ContractSignORG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> update(@PathVariable("contractsignorg_id") String contractsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
		ContractSignORG domain  = contractsignorgMapping.toDomain(contractsignorgdto);
        domain .setContractsignorgid(contractsignorg_id);
		contractsignorgService.update(domain );
		ContractSignORGDTO dto = contractsignorgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByEntities(this.contractsignorgMapping.toDomain(#contractsignorgdtos)),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ContractSignORG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        contractsignorgService.updateBatch(contractsignorgMapping.toDomain(contractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "Remove", tags = {"ContractSignORG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("contractsignorg_id") String contractsignorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.remove(contractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByIds(#ids),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ContractSignORG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        contractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "Create", tags = {"ContractSignORG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> create(@RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
		contractsignorgService.create(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "createBatch", tags = {"ContractSignORG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        contractsignorgService.createBatch(contractsignorgMapping.toDomain(contractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ContractSignORG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/contractsignorgs/getdraft")
    public ResponseEntity<ContractSignORGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgMapping.toDto(contractsignorgService.getDraft(new ContractSignORG())));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "Save", tags = {"ContractSignORG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ContractSignORGDTO contractsignorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.save(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ContractSignORG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        contractsignorgService.saveBatch(contractsignorgMapping.toDomain(contractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ContractSignORG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/contractsignorgs/fetchdefault")
	public ResponseEntity<List<ContractSignORGDTO>> fetchDefault(ContractSignORGSearchContext context) {
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ContractSignORG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/contractsignorgs/searchdefault")
	public ResponseEntity<Page<ContractSignORGDTO>> searchDefault(@RequestBody ContractSignORGSearchContext context) {
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "fetchDEFAULT2", tags = {"ContractSignORG" } ,notes = "fetchDEFAULT2")
    @RequestMapping(method= RequestMethod.GET , value="/contractsignorgs/fetchdefault2")
	public ResponseEntity<List<ContractSignORGDTO>> fetchDefault2(ContractSignORGSearchContext context) {
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "searchDEFAULT2", tags = {"ContractSignORG" } ,notes = "searchDEFAULT2")
    @RequestMapping(method= RequestMethod.POST , value="/contractsignorgs/searchdefault2")
	public ResponseEntity<Page<ContractSignORGDTO>> searchDefault2(@RequestBody ContractSignORGSearchContext context) {
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.contractsignorgMapping.toDomain(returnObject.body),'ehr-ContractSignORG-Get')")
    @ApiOperation(value = "GetByOrmOrg", tags = {"ContractSignORG" },  notes = "GetByOrmOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/contractsignorgs/{contractsignorg_id}")
    public ResponseEntity<ContractSignORGDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id) {
        ContractSignORG domain = contractsignorgService.get(contractsignorg_id);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmOrg", tags = {"ContractSignORG" },  notes = "CheckKeyByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/contractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.checkKey(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "UpdateByOrmOrg", tags = {"ContractSignORG" },  notes = "UpdateByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmorgid(ormorg_id);
        domain.setContractsignorgid(contractsignorg_id);
		contractsignorgService.update(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByEntities(this.contractsignorgMapping.toDomain(#contractsignorgdtos)),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrg", tags = {"ContractSignORG" },  notes = "UpdateBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        contractsignorgService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "RemoveByOrmOrg", tags = {"ContractSignORG" },  notes = "RemoveByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.remove(contractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByIds(#ids),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrg", tags = {"ContractSignORG" },  notes = "RemoveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        contractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "CreateByOrmOrg", tags = {"ContractSignORG" },  notes = "CreateByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/contractsignorgs")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmorgid(ormorg_id);
		contractsignorgService.create(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "createBatchByOrmOrg", tags = {"ContractSignORG" },  notes = "createBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        contractsignorgService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrg", tags = {"ContractSignORG" },  notes = "GetDraftByOrmOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/contractsignorgs/getdraft")
    public ResponseEntity<ContractSignORGDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        ContractSignORG domain = new ContractSignORG();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgMapping.toDto(contractsignorgService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "SaveByOrmOrg", tags = {"ContractSignORG" },  notes = "SaveByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/contractsignorgs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.save(domain));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrg", tags = {"ContractSignORG" },  notes = "SaveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/contractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        contractsignorgService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrg", tags = {"ContractSignORG" } ,notes = "fetchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/contractsignorgs/fetchdefault")
	public ResponseEntity<List<ContractSignORGDTO>> fetchContractSignORGDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,ContractSignORGSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrg", tags = {"ContractSignORG" } ,notes = "searchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/contractsignorgs/searchdefault")
	public ResponseEntity<Page<ContractSignORGDTO>> searchContractSignORGDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ContractSignORGSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "fetchDEFAULT2ByOrmOrg", tags = {"ContractSignORG" } ,notes = "fetchDEFAULT2ByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/contractsignorgs/fetchdefault2")
	public ResponseEntity<List<ContractSignORGDTO>> fetchContractSignORGDefault2ByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,ContractSignORGSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "searchDEFAULT2ByOrmOrg", tags = {"ContractSignORG" } ,notes = "searchDEFAULT2ByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/contractsignorgs/searchdefault2")
	public ResponseEntity<Page<ContractSignORGDTO>> searchContractSignORGDefault2ByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ContractSignORGSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.contractsignorgMapping.toDomain(returnObject.body),'ehr-ContractSignORG-Get')")
    @ApiOperation(value = "GetByOrmSignOrg", tags = {"ContractSignORG" },  notes = "GetByOrmSignOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/{contractsignorg_id}")
    public ResponseEntity<ContractSignORGDTO> getByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id) {
        ContractSignORG domain = contractsignorgService.get(contractsignorg_id);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmSignOrg", tags = {"ContractSignORG" },  notes = "CheckKeyByOrmSignOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.checkKey(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "UpdateByOrmSignOrg", tags = {"ContractSignORG" },  notes = "UpdateByOrmSignOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> updateByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
        domain.setContractsignorgid(contractsignorg_id);
		contractsignorgService.update(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByEntities(this.contractsignorgMapping.toDomain(#contractsignorgdtos)),'ehr-ContractSignORG-Update')")
    @ApiOperation(value = "UpdateBatchByOrmSignOrg", tags = {"ContractSignORG" },  notes = "UpdateBatchByOrmSignOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
            domain.setOrmsignorgid(ormsignorg_id);
        }
        contractsignorgService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.get(#contractsignorg_id),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "RemoveByOrmSignOrg", tags = {"ContractSignORG" },  notes = "RemoveByOrmSignOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @PathVariable("contractsignorg_id") String contractsignorg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.remove(contractsignorg_id));
    }

    @PreAuthorize("hasPermission(this.contractsignorgService.getContractsignorgByIds(#ids),'ehr-ContractSignORG-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmSignOrg", tags = {"ContractSignORG" },  notes = "RemoveBatchByOrmSignOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmSignOrg(@RequestBody List<String> ids) {
        contractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "CreateByOrmSignOrg", tags = {"ContractSignORG" },  notes = "CreateByOrmSignOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> createByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
		contractsignorgService.create(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Create')")
    @ApiOperation(value = "createBatchByOrmSignOrg", tags = {"ContractSignORG" },  notes = "createBatchByOrmSignOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/batch")
    public ResponseEntity<Boolean> createBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
            domain.setOrmsignorgid(ormsignorg_id);
        }
        contractsignorgService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmSignOrg", tags = {"ContractSignORG" },  notes = "GetDraftByOrmSignOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/getdraft")
    public ResponseEntity<ContractSignORGDTO> getDraftByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id) {
        ContractSignORG domain = new ContractSignORG();
        domain.setOrmsignorgid(ormsignorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgMapping.toDto(contractsignorgService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdto),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "SaveByOrmSignOrg", tags = {"ContractSignORG" },  notes = "SaveByOrmSignOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/save")
    public ResponseEntity<Boolean> saveByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setOrmsignorgid(ormsignorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.save(domain));
    }

    @PreAuthorize("hasPermission(this.contractsignorgMapping.toDomain(#contractsignorgdtos),'ehr-ContractSignORG-Save')")
    @ApiOperation(value = "SaveBatchByOrmSignOrg", tags = {"ContractSignORG" },  notes = "SaveBatchByOrmSignOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormsignorgs/{ormsignorg_id}/contractsignorgs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        List<ContractSignORG> domainlist=contractsignorgMapping.toDomain(contractsignorgdtos);
        for(ContractSignORG domain:domainlist){
             domain.setOrmsignorgid(ormsignorg_id);
        }
        contractsignorgService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmSignOrg", tags = {"ContractSignORG" } ,notes = "fetchDEFAULTByOrmSignOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/{ormsignorg_id}/contractsignorgs/fetchdefault")
	public ResponseEntity<List<ContractSignORGDTO>> fetchContractSignORGDefaultByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id,ContractSignORGSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmSignOrg", tags = {"ContractSignORG" } ,notes = "searchDEFAULTByOrmSignOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/{ormsignorg_id}/contractsignorgs/searchdefault")
	public ResponseEntity<Page<ContractSignORGDTO>> searchContractSignORGDefaultByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody ContractSignORGSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "fetchDEFAULT2ByOrmSignOrg", tags = {"ContractSignORG" } ,notes = "fetchDEFAULT2ByOrmSignOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormsignorgs/{ormsignorg_id}/contractsignorgs/fetchdefault2")
	public ResponseEntity<List<ContractSignORGDTO>> fetchContractSignORGDefault2ByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id,ContractSignORGSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
        List<ContractSignORGDTO> list = contractsignorgMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-Default2-all')")
	@ApiOperation(value = "searchDEFAULT2ByOrmSignOrg", tags = {"ContractSignORG" } ,notes = "searchDEFAULT2ByOrmSignOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormsignorgs/{ormsignorg_id}/contractsignorgs/searchdefault2")
	public ResponseEntity<Page<ContractSignORGDTO>> searchContractSignORGDefault2ByOrmSignOrg(@PathVariable("ormsignorg_id") String ormsignorg_id, @RequestBody ContractSignORGSearchContext context) {
        context.setN_ormsignorgid_eq(ormsignorg_id);
        Page<ContractSignORG> domains = contractsignorgService.searchDefault2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(contractsignorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

