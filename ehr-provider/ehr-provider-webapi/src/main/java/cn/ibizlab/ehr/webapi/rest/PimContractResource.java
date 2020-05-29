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
import cn.ibizlab.ehr.core.pim.domain.PimContract;
import cn.ibizlab.ehr.core.pim.service.IPimContractService;
import cn.ibizlab.ehr.core.pim.filter.PimContractSearchContext;

@Slf4j
@Api(tags = {"PimContract" })
@RestController("WebApi-pimcontract")
@RequestMapping("")
public class PimContractResource {

    @Autowired
    public IPimContractService pimcontractService;

    @Autowired
    @Lazy
    public PimContractMapping pimcontractMapping;

    @ApiOperation(value = "CheckKey", tags = {"PimContract" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimContractDTO pimcontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractService.checkKey(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-CalContractTime-all')")
    @ApiOperation(value = "计算合同签订次数", tags = {"PimContract" },  notes = "计算合同签订次数")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/{pimcontract_id}/calcontracttime")
    @Transactional
    public ResponseEntity<PimContractDTO> calContractTime(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract pimcontract = pimcontractMapping.toDomain(pimcontractdto);
        pimcontract.setPimcontractid(pimcontract_id);
        pimcontract = pimcontractService.calContractTime(pimcontract);
        pimcontractdto = pimcontractMapping.toDto(pimcontract);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.get(#pimcontract_id),'ehr-PimContract-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimContract" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcontract_id") String pimcontract_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.remove(pimcontract_id));
    }

    @PreAuthorize("hasPermission(this.pimcontractService.getPimcontractByIds(#ids),'ehr-PimContract-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimContract" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcontractMapping.toDomain(returnObject.body),'ehr-PimContract-Get')")
    @ApiOperation(value = "Get", tags = {"PimContract" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracts/{pimcontract_id}")
    public ResponseEntity<PimContractDTO> get(@PathVariable("pimcontract_id") String pimcontract_id) {
        PimContract domain = pimcontractService.get(pimcontract_id);
        PimContractDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdto),'ehr-PimContract-Create')")
    @ApiOperation(value = "Create", tags = {"PimContract" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts")
    @Transactional
    public ResponseEntity<PimContractDTO> create(@RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
		pimcontractService.create(domain);
        PimContractDTO dto = pimcontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdtos),'ehr-PimContract-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimContract" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimContractDTO> pimcontractdtos) {
        pimcontractService.createBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdto),'ehr-PimContract-Save')")
    @ApiOperation(value = "Save", tags = {"PimContract" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/save")
    public ResponseEntity<Boolean> save(@RequestBody PimContractDTO pimcontractdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.save(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdtos),'ehr-PimContract-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimContract" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimContractDTO> pimcontractdtos) {
        pimcontractService.saveBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContract-all')")
    @ApiOperation(value = "终止合同", tags = {"PimContract" },  notes = "终止合同")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/{pimcontract_id}/stopcontract")
    @Transactional
    public ResponseEntity<PimContractDTO> stopContract(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract pimcontract = pimcontractMapping.toDomain(pimcontractdto);
        pimcontract.setPimcontractid(pimcontract_id);
        pimcontract = pimcontractService.stopContract(pimcontract);
        pimcontractdto = pimcontractMapping.toDto(pimcontract);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.get(#pimcontract_id),'ehr-PimContract-Update')")
    @ApiOperation(value = "Update", tags = {"PimContract" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<PimContractDTO> update(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
		PimContract domain  = pimcontractMapping.toDomain(pimcontractdto);
        domain .setPimcontractid(pimcontract_id);
		pimcontractService.update(domain );
		PimContractDTO dto = pimcontractMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.getPimcontractByEntities(this.pimcontractMapping.toDomain(#pimcontractdtos)),'ehr-PimContract-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimContract" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimContractDTO> pimcontractdtos) {
        pimcontractService.updateBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimContract" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracts/getdraft")
    public ResponseEntity<PimContractDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractMapping.toDto(pimcontractService.getDraft(new PimContract())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-RSTXDS-all')")
	@ApiOperation(value = "fetch人事提醒", tags = {"PimContract" } ,notes = "fetch人事提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchrstxds")
	public ResponseEntity<List<PimContractDTO>> fetchRSTXDS(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchRSTXDS(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-RSTXDS-all')")
	@ApiOperation(value = "search人事提醒", tags = {"PimContract" } ,notes = "search人事提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchrstxds")
	public ResponseEntity<Page<PimContractDTO>> searchRSTXDS(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchRSTXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PimContract" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchjlss")
	public ResponseEntity<List<PimContractDTO>> fetchJLSS(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchJLSS(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PimContract" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchjlss")
	public ResponseEntity<Page<PimContractDTO>> searchJLSS(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-OrderByOrg-all')")
	@ApiOperation(value = "fetch按组织树过滤", tags = {"PimContract" } ,notes = "fetch按组织树过滤")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchorderbyorg")
	public ResponseEntity<List<PimContractDTO>> fetchOrderByOrg(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchOrderByOrg(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-OrderByOrg-all')")
	@ApiOperation(value = "search按组织树过滤", tags = {"PimContract" } ,notes = "search按组织树过滤")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchorderbyorg")
	public ResponseEntity<Page<PimContractDTO>> searchOrderByOrg(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchOrderByOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContracts-all')")
	@ApiOperation(value = "fetch待终止合同", tags = {"PimContract" } ,notes = "fetch待终止合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchstopcontracts")
	public ResponseEntity<List<PimContractDTO>> fetchStopContracts(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchStopContracts(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContracts-all')")
	@ApiOperation(value = "search待终止合同", tags = {"PimContract" } ,notes = "search待终止合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchstopcontracts")
	public ResponseEntity<Page<PimContractDTO>> searchStopContracts(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchStopContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-SignContracts-all')")
	@ApiOperation(value = "fetch待签订合同", tags = {"PimContract" } ,notes = "fetch待签订合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchsigncontracts")
	public ResponseEntity<List<PimContractDTO>> fetchSignContracts(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchSignContracts(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-SignContracts-all')")
	@ApiOperation(value = "search待签订合同", tags = {"PimContract" } ,notes = "search待签订合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchsigncontracts")
	public ResponseEntity<Page<PimContractDTO>> searchSignContracts(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchSignContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimContract" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchdefault")
	public ResponseEntity<List<PimContractDTO>> fetchDefault(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchDefault(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimContract" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchdefault")
	public ResponseEntity<Page<PimContractDTO>> searchDefault(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-XYHT-all')")
	@ApiOperation(value = "fetch协议合同", tags = {"PimContract" } ,notes = "fetch协议合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchxyht")
	public ResponseEntity<List<PimContractDTO>> fetchXYHT(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchXYHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-XYHT-all')")
	@ApiOperation(value = "search协议合同", tags = {"PimContract" } ,notes = "search协议合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchxyht")
	public ResponseEntity<Page<PimContractDTO>> searchXYHT(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchXYHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(合同信息)", tags = {"PimContract" } ,notes = "fetch自助(合同信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchzizhu")
	public ResponseEntity<List<PimContractDTO>> fetchZIZHU(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchZIZHU(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-ZIZHU-all')")
	@ApiOperation(value = "search自助(合同信息)", tags = {"PimContract" } ,notes = "search自助(合同信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchzizhu")
	public ResponseEntity<Page<PimContractDTO>> searchZIZHU(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LDHT-all')")
	@ApiOperation(value = "fetch劳动合同", tags = {"PimContract" } ,notes = "fetch劳动合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchldht")
	public ResponseEntity<List<PimContractDTO>> fetchLDHT(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchLDHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LDHT-all')")
	@ApiOperation(value = "search劳动合同", tags = {"PimContract" } ,notes = "search劳动合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchldht")
	public ResponseEntity<Page<PimContractDTO>> searchLDHT(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchLDHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LWHT-all')")
	@ApiOperation(value = "fetch劳务合同", tags = {"PimContract" } ,notes = "fetch劳务合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchlwht")
	public ResponseEntity<List<PimContractDTO>> fetchLWHT(PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchLWHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LWHT-all')")
	@ApiOperation(value = "search劳务合同", tags = {"PimContract" } ,notes = "search劳务合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchlwht")
	public ResponseEntity<Page<PimContractDTO>> searchLWHT(@RequestBody PimContractSearchContext context) {
        Page<PimContract> domains = pimcontractService.searchLWHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimContract" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractDTO pimcontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractService.checkKey(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-CalContractTime-all')")
    @ApiOperation(value = "计算合同签订次数ByPimPerson", tags = {"PimContract" },  notes = "计算合同签订次数ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}/calcontracttime")
    @Transactional
    public ResponseEntity<PimContractDTO> calContractTimeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimcontractService.calContractTime(domain) ;
        pimcontractdto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.get(#pimcontract_id),'ehr-PimContract-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimContract" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.remove(pimcontract_id));
    }

    @PreAuthorize("hasPermission(this.pimcontractService.getPimcontractByIds(#ids),'ehr-PimContract-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimContract" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimcontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcontractMapping.toDomain(returnObject.body),'ehr-PimContract-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimContract" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    public ResponseEntity<PimContractDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id) {
        PimContract domain = pimcontractService.get(pimcontract_id);
        PimContractDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdto),'ehr-PimContract-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimContract" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts")
    @Transactional
    public ResponseEntity<PimContractDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
		pimcontractService.create(domain);
        PimContractDTO dto = pimcontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdtos),'ehr-PimContract-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimContract" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimContractDTO> pimcontractdtos) {
        List<PimContract> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PimContract domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdto),'ehr-PimContract-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimContract" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcontractMapping.toDomain(#pimcontractdtos),'ehr-PimContract-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimContract" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimContractDTO> pimcontractdtos) {
        List<PimContract> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PimContract domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContract-all')")
    @ApiOperation(value = "终止合同ByPimPerson", tags = {"PimContract" },  notes = "终止合同ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}/stopcontract")
    @Transactional
    public ResponseEntity<PimContractDTO> stopContractByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimcontractService.stopContract(domain) ;
        pimcontractdto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.get(#pimcontract_id),'ehr-PimContract-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimContract" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<PimContractDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PimContractDTO pimcontractdto) {
        PimContract domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimcontractid(pimcontract_id);
		pimcontractService.update(domain);
        PimContractDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontractService.getPimcontractByEntities(this.pimcontractMapping.toDomain(#pimcontractdtos)),'ehr-PimContract-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimContract" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimContractDTO> pimcontractdtos) {
        List<PimContract> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PimContract domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimContract" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcontracts/getdraft")
    public ResponseEntity<PimContractDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimContract domain = new PimContract();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractMapping.toDto(pimcontractService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-RSTXDS-all')")
	@ApiOperation(value = "fetch人事提醒ByPimPerson", tags = {"PimContract" } ,notes = "fetch人事提醒ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchrstxds")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractRSTXDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchRSTXDS(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-RSTXDS-all')")
	@ApiOperation(value = "search人事提醒ByPimPerson", tags = {"PimContract" } ,notes = "search人事提醒ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchrstxds")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractRSTXDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchRSTXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPimPerson", tags = {"PimContract" } ,notes = "fetch记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchjlss")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchJLSS(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPimPerson", tags = {"PimContract" } ,notes = "search记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchjlss")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-OrderByOrg-all')")
	@ApiOperation(value = "fetch按组织树过滤ByPimPerson", tags = {"PimContract" } ,notes = "fetch按组织树过滤ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchorderbyorg")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractOrderByOrgByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchOrderByOrg(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-OrderByOrg-all')")
	@ApiOperation(value = "search按组织树过滤ByPimPerson", tags = {"PimContract" } ,notes = "search按组织树过滤ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchorderbyorg")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractOrderByOrgByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchOrderByOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContracts-all')")
	@ApiOperation(value = "fetch待终止合同ByPimPerson", tags = {"PimContract" } ,notes = "fetch待终止合同ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchstopcontracts")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractStopContractsByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchStopContracts(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-StopContracts-all')")
	@ApiOperation(value = "search待终止合同ByPimPerson", tags = {"PimContract" } ,notes = "search待终止合同ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchstopcontracts")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractStopContractsByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchStopContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-SignContracts-all')")
	@ApiOperation(value = "fetch待签订合同ByPimPerson", tags = {"PimContract" } ,notes = "fetch待签订合同ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchsigncontracts")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractSignContractsByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchSignContracts(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-SignContracts-all')")
	@ApiOperation(value = "search待签订合同ByPimPerson", tags = {"PimContract" } ,notes = "search待签订合同ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchsigncontracts")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractSignContractsByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchSignContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimContract" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchdefault")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchDefault(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimContract" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchdefault")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-XYHT-all')")
	@ApiOperation(value = "fetch协议合同ByPimPerson", tags = {"PimContract" } ,notes = "fetch协议合同ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchxyht")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractXYHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchXYHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-XYHT-all')")
	@ApiOperation(value = "search协议合同ByPimPerson", tags = {"PimContract" } ,notes = "search协议合同ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchxyht")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractXYHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchXYHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(合同信息)ByPimPerson", tags = {"PimContract" } ,notes = "fetch自助(合同信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchzizhu")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchZIZHU(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-ZIZHU-all')")
	@ApiOperation(value = "search自助(合同信息)ByPimPerson", tags = {"PimContract" } ,notes = "search自助(合同信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchzizhu")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LDHT-all')")
	@ApiOperation(value = "fetch劳动合同ByPimPerson", tags = {"PimContract" } ,notes = "fetch劳动合同ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchldht")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractLDHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchLDHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LDHT-all')")
	@ApiOperation(value = "search劳动合同ByPimPerson", tags = {"PimContract" } ,notes = "search劳动合同ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchldht")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractLDHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchLDHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LWHT-all')")
	@ApiOperation(value = "fetch劳务合同ByPimPerson", tags = {"PimContract" } ,notes = "fetch劳务合同ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchlwht")
	public ResponseEntity<List<PimContractDTO>> fetchPimContractLWHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchLWHT(context) ;
        List<PimContractDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimContract-LWHT-all')")
	@ApiOperation(value = "search劳务合同ByPimPerson", tags = {"PimContract" } ,notes = "search劳务合同ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchlwht")
	public ResponseEntity<Page<PimContractDTO>> searchPimContractLWHTByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimContractSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimContract> domains = pimcontractService.searchLWHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

