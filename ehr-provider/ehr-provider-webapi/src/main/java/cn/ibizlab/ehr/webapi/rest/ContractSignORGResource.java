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
import cn.ibizlab.ehr.core.pim.domain.ContractSignORG;
import cn.ibizlab.ehr.core.pim.service.IContractSignORGService;
import cn.ibizlab.ehr.core.pim.filter.ContractSignORGSearchContext;

@Slf4j
@Api(tags = {"ContractSignORG" })
@RestController("WebApi-contractsignorg")
@RequestMapping("")
public class ContractSignORGResource {

    @Autowired
    private IContractSignORGService contractsignorgService;

    @Autowired
    @Lazy
    public ContractSignORGMapping contractsignorgMapping;

    public ContractSignORGDTO permissionDTO=new ContractSignORGDTO();

    @PreAuthorize("hasPermission(#contractsignorg_id,'Get',{'Sql',this.contractsignorgMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ContractSignORG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/contractsignorgs/{contractsignorg_id}")
    public ResponseEntity<ContractSignORGDTO> get(@PathVariable("contractsignorg_id") String contractsignorg_id) {
        ContractSignORG domain = contractsignorgService.get(contractsignorg_id);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ContractSignORG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ContractSignORGDTO contractsignorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.checkKey(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission(#contractsignorg_id,'Update',{'Sql',this.contractsignorgMapping,#contractsignorgdto})")
    @ApiOperation(value = "Update", tags = {"ContractSignORG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> update(@PathVariable("contractsignorg_id") String contractsignorg_id, @RequestBody ContractSignORGDTO contractsignorgdto) {
		ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
        domain.setContractsignorgid(contractsignorg_id);
		contractsignorgService.update(domain);
		ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ContractSignORG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        contractsignorgService.updateBatch(contractsignorgMapping.toDomain(contractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#contractsignorg_id,'Remove',{'Sql',this.contractsignorgMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ContractSignORG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/contractsignorgs/{contractsignorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("contractsignorg_id") String contractsignorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.remove(contractsignorg_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ContractSignORG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        contractsignorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.contractsignorgMapping,#contractsignorgdto})")
    @ApiOperation(value = "Create", tags = {"ContractSignORG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs")
    @Transactional
    public ResponseEntity<ContractSignORGDTO> create(@RequestBody ContractSignORGDTO contractsignorgdto) {
        ContractSignORG domain = contractsignorgMapping.toDomain(contractsignorgdto);
		contractsignorgService.create(domain);
        ContractSignORGDTO dto = contractsignorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ContractSignORG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ContractSignORGDTO> contractsignorgdtos) {
        contractsignorgService.createBatch(contractsignorgMapping.toDomain(contractsignorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ContractSignORG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ContractSignORG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/contractsignorgs/getdraft")
    public ResponseEntity<ContractSignORGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgMapping.toDto(contractsignorgService.getDraft(new ContractSignORG())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.contractsignorgMapping,#contractsignorgdto})")
    @ApiOperation(value = "Save", tags = {"ContractSignORG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/contractsignorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ContractSignORGDTO contractsignorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(contractsignorgService.save(contractsignorgMapping.toDomain(contractsignorgdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
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
}
