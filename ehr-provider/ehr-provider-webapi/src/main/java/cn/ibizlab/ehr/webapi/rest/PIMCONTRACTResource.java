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
import cn.ibizlab.ehr.core.pim.domain.PIMCONTRACT;
import cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService;
import cn.ibizlab.ehr.core.pim.filter.PIMCONTRACTSearchContext;




@Slf4j
@Api(tags = {"PIMCONTRACT" })
@RestController("WebApi-pimcontract")
@RequestMapping("")
public class PIMCONTRACTResource {

    @Autowired
    private IPIMCONTRACTService pimcontractService;

    @Autowired
    @Lazy
    public PIMCONTRACTMapping pimcontractMapping;

    public PIMCONTRACTDTO permissionDTO=new PIMCONTRACTDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMCONTRACT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCONTRACTDTO pimcontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractService.checkKey(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-CalContractTime-all')")
    @ApiOperation(value = "计算合同签订次数", tags = {"PIMCONTRACT" },  notes = "计算合同签订次数")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/{pimcontract_id}/calcontracttime")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> calContractTime(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT pimcontract = pimcontractMapping.toDomain(pimcontractdto);
        pimcontract = pimcontractService.calContractTime(pimcontract);
        pimcontractdto = pimcontractMapping.toDto(pimcontract);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(#pimcontract_id,'Remove',{'Sql',this.pimcontractMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMCONTRACT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcontract_id") String pimcontract_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.remove(pimcontract_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMCONTRACT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimcontract_id,'Get',{'Sql',this.pimcontractMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMCONTRACT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracts/{pimcontract_id}")
    public ResponseEntity<PIMCONTRACTDTO> get(@PathVariable("pimcontract_id") String pimcontract_id) {
        PIMCONTRACT domain = pimcontractService.get(pimcontract_id);
        PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimcontractMapping,#pimcontractdto})")
    @ApiOperation(value = "Create", tags = {"PIMCONTRACT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> create(@RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
		pimcontractService.create(domain);
        PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMCONTRACT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        pimcontractService.createBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMCONTRACT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCONTRACTDTO pimcontractdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.save(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMCONTRACT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        pimcontractService.saveBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContract-all')")
    @ApiOperation(value = "终止合同", tags = {"PIMCONTRACT" },  notes = "终止合同")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracts/{pimcontract_id}/stopcontract")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> stopContract(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT pimcontract = pimcontractMapping.toDomain(pimcontractdto);
        pimcontract = pimcontractService.stopContract(pimcontract);
        pimcontractdto = pimcontractMapping.toDto(pimcontract);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    @PreAuthorize("hasPermission(#pimcontract_id,'Update',{'Sql',this.pimcontractMapping,#pimcontractdto})")
    @ApiOperation(value = "Update", tags = {"PIMCONTRACT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> update(@PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
		PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimcontractid(pimcontract_id);
		pimcontractService.update(domain);
		PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMCONTRACT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        pimcontractService.updateBatch(pimcontractMapping.toDomain(pimcontractdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMCONTRACT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracts/getdraft")
    public ResponseEntity<PIMCONTRACTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractMapping.toDto(pimcontractService.getDraft(new PIMCONTRACT())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-RSTXDS-all')")
	@ApiOperation(value = "fetch人事提醒", tags = {"PIMCONTRACT" } ,notes = "fetch人事提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchrstxds")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchRSTXDS(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchRSTXDS(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-RSTXDS-all')")
	@ApiOperation(value = "search人事提醒", tags = {"PIMCONTRACT" } ,notes = "search人事提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchrstxds")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchRSTXDS(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchRSTXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PIMCONTRACT" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchjlss")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchJLSS(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchJLSS(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PIMCONTRACT" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchjlss")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchJLSS(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-OrderByOrg-all')")
	@ApiOperation(value = "fetch按组织树过滤", tags = {"PIMCONTRACT" } ,notes = "fetch按组织树过滤")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchorderbyorg")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchOrderByOrg(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchOrderByOrg(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-OrderByOrg-all')")
	@ApiOperation(value = "search按组织树过滤", tags = {"PIMCONTRACT" } ,notes = "search按组织树过滤")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchorderbyorg")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchOrderByOrg(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchOrderByOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContracts-all')")
	@ApiOperation(value = "fetch待终止合同", tags = {"PIMCONTRACT" } ,notes = "fetch待终止合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchstopcontracts")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchStopContracts(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchStopContracts(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContracts-all')")
	@ApiOperation(value = "search待终止合同", tags = {"PIMCONTRACT" } ,notes = "search待终止合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchstopcontracts")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchStopContracts(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchStopContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-SignContracts-all')")
	@ApiOperation(value = "fetch待签订合同", tags = {"PIMCONTRACT" } ,notes = "fetch待签订合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchsigncontracts")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchSignContracts(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchSignContracts(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-SignContracts-all')")
	@ApiOperation(value = "search待签订合同", tags = {"PIMCONTRACT" } ,notes = "search待签订合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchsigncontracts")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchSignContracts(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchSignContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMCONTRACT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchdefault")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchDefault(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchDefault(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMCONTRACT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchdefault")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchDefault(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-XYHT-all')")
	@ApiOperation(value = "fetch协议合同", tags = {"PIMCONTRACT" } ,notes = "fetch协议合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchxyht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchXYHT(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchXYHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-XYHT-all')")
	@ApiOperation(value = "search协议合同", tags = {"PIMCONTRACT" } ,notes = "search协议合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchxyht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchXYHT(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchXYHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(合同信息)", tags = {"PIMCONTRACT" } ,notes = "fetch自助(合同信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchzizhu")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchZIZHU(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchZIZHU(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-ZIZHU-all')")
	@ApiOperation(value = "search自助(合同信息)", tags = {"PIMCONTRACT" } ,notes = "search自助(合同信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchzizhu")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchZIZHU(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LDHT-all')")
	@ApiOperation(value = "fetch劳动合同", tags = {"PIMCONTRACT" } ,notes = "fetch劳动合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchldht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchLDHT(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchLDHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LDHT-all')")
	@ApiOperation(value = "search劳动合同", tags = {"PIMCONTRACT" } ,notes = "search劳动合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchldht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchLDHT(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchLDHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LWHT-all')")
	@ApiOperation(value = "fetch劳务合同", tags = {"PIMCONTRACT" } ,notes = "fetch劳务合同")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracts/fetchlwht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchLWHT(PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchLWHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LWHT-all')")
	@ApiOperation(value = "search劳务合同", tags = {"PIMCONTRACT" } ,notes = "search劳务合同")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracts/searchlwht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchLWHT(@RequestBody PIMCONTRACTSearchContext context) {
        Page<PIMCONTRACT> domains = pimcontractService.searchLWHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontractService.checkKey(pimcontractMapping.toDomain(pimcontractdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-CalContractTime-all')")
    @ApiOperation(value = "计算合同签订次数ByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "计算合同签订次数ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontractpimcontractid}/calcontracttime")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> calContractTimeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimcontractService.calContractTime(domain) ;
        pimcontractdto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    //@PreAuthorize("hasPermission(#pimcontract_id,'Remove',{'Sql',this.pimcontractMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.remove(pimcontract_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimcontractService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimcontract_id,'Get',{'Sql',this.pimcontractMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    public ResponseEntity<PIMCONTRACTDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id) {
        PIMCONTRACT domain = pimcontractService.get(pimcontract_id);
        PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimcontractMapping,#pimcontractdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
		pimcontractService.create(domain);
        PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        List<PIMCONTRACT> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PIMCONTRACT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        List<PIMCONTRACT> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PIMCONTRACT domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContract-all')")
    @ApiOperation(value = "终止合同ByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "终止合同ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontractpimcontractid}/stopcontract")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> stopContractByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimcontractService.stopContract(domain) ;
        pimcontractdto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractdto);
    }

    //@PreAuthorize("hasPermission(#pimcontract_id,'Update',{'Sql',this.pimcontractMapping,#pimcontractdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcontracts/{pimcontract_id}")
    @Transactional
    public ResponseEntity<PIMCONTRACTDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcontract_id") String pimcontract_id, @RequestBody PIMCONTRACTDTO pimcontractdto) {
        PIMCONTRACT domain = pimcontractMapping.toDomain(pimcontractdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimcontractid(pimcontract_id);
		pimcontractService.update(domain);
        PIMCONTRACTDTO dto = pimcontractMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcontracts/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCONTRACTDTO> pimcontractdtos) {
        List<PIMCONTRACT> domainlist=pimcontractMapping.toDomain(pimcontractdtos);
        for(PIMCONTRACT domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcontractService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMCONTRACT" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcontracts/getdraft")
    public ResponseEntity<PIMCONTRACTDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMCONTRACT domain = new PIMCONTRACT();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcontractMapping.toDto(pimcontractService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-RSTXDS-all')")
	@ApiOperation(value = "fetch人事提醒ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch人事提醒ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchrstxds")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTRSTXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchRSTXDS(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-RSTXDS-all')")
	@ApiOperation(value = "search人事提醒ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search人事提醒ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchrstxds")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTRSTXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchRSTXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchjlss")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchJLSS(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchjlss")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-OrderByOrg-all')")
	@ApiOperation(value = "fetch按组织树过滤ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch按组织树过滤ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchorderbyorg")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTOrderByOrgByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchOrderByOrg(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-OrderByOrg-all')")
	@ApiOperation(value = "search按组织树过滤ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search按组织树过滤ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchorderbyorg")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTOrderByOrgByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchOrderByOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContracts-all')")
	@ApiOperation(value = "fetch待终止合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch待终止合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchstopcontracts")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTStopContractsByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchStopContracts(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-StopContracts-all')")
	@ApiOperation(value = "search待终止合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search待终止合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchstopcontracts")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTStopContractsByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchStopContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-SignContracts-all')")
	@ApiOperation(value = "fetch待签订合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch待签订合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchsigncontracts")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTSignContractsByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchSignContracts(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-SignContracts-all')")
	@ApiOperation(value = "search待签订合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search待签订合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchsigncontracts")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTSignContractsByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchSignContracts(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchdefault")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchDefault(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchdefault")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-XYHT-all')")
	@ApiOperation(value = "fetch协议合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch协议合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchxyht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTXYHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchXYHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-XYHT-all')")
	@ApiOperation(value = "search协议合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search协议合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchxyht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTXYHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchXYHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(合同信息)ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch自助(合同信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchzizhu")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchZIZHU(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-ZIZHU-all')")
	@ApiOperation(value = "search自助(合同信息)ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search自助(合同信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchzizhu")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LDHT-all')")
	@ApiOperation(value = "fetch劳动合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch劳动合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchldht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTLDHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchLDHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LDHT-all')")
	@ApiOperation(value = "search劳动合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search劳动合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchldht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTLDHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchLDHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LWHT-all')")
	@ApiOperation(value = "fetch劳务合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "fetch劳务合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcontracts/fetchlwht")
	public ResponseEntity<List<PIMCONTRACTDTO>> fetchPIMCONTRACTLWHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchLWHT(context) ;
        List<PIMCONTRACTDTO> list = pimcontractMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACT-LWHT-all')")
	@ApiOperation(value = "search劳务合同ByPIMPERSON", tags = {"PIMCONTRACT" } ,notes = "search劳务合同ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcontracts/searchlwht")
	public ResponseEntity<Page<PIMCONTRACTDTO>> searchPIMCONTRACTLWHTByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCONTRACTSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCONTRACT> domains = pimcontractService.searchLWHT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontractMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
