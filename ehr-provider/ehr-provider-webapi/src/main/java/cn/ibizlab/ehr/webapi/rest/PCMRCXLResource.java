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
import cn.ibizlab.ehr.core.pcm.domain.PCMRCXL;
import cn.ibizlab.ehr.core.pcm.service.IPCMRCXLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMRCXLSearchContext;




@Slf4j
@Api(tags = {"PCMRCXL" })
@RestController("WebApi-pcmrcxl")
@RequestMapping("")
public class PCMRCXLResource {

    @Autowired
    private IPCMRCXLService pcmrcxlService;

    @Autowired
    @Lazy
    private PCMRCXLMapping pcmrcxlMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMRCXL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls")
    @Transactional
    public ResponseEntity<PCMRCXLDTO> create(@RequestBody PCMRCXLDTO pcmrcxldto) {
        PCMRCXL domain = pcmrcxlMapping.toDomain(pcmrcxldto);
		pcmrcxlService.create(domain);
        PCMRCXLDTO dto = pcmrcxlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMRCXL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMRCXLDTO> pcmrcxldtos) {
        pcmrcxlService.createBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMRCXL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrcxls/getdraft")
    public ResponseEntity<PCMRCXLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlMapping.toDto(pcmrcxlService.getDraft(new PCMRCXL())));
    }




    @PreAuthorize("hasPermission(#pcmrcxl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMRCXL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrcxls/{pcmrcxl_id}")
    public ResponseEntity<PCMRCXLDTO> get(@PathVariable("pcmrcxl_id") String pcmrcxl_id) {
        PCMRCXL domain = pcmrcxlService.get(pcmrcxl_id);
        PCMRCXLDTO dto = pcmrcxlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmrcxl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMRCXL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrcxls/{pcmrcxl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrcxl_id") String pcmrcxl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.remove(pcmrcxl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMRCXL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrcxlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmrcxl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMRCXL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrcxls/{pcmrcxl_id}")
    @Transactional
    public ResponseEntity<PCMRCXLDTO> update(@PathVariable("pcmrcxl_id") String pcmrcxl_id, @RequestBody PCMRCXLDTO pcmrcxldto) {
		PCMRCXL domain = pcmrcxlMapping.toDomain(pcmrcxldto);
        domain.setPcmrcxlid(pcmrcxl_id);
		pcmrcxlService.update(domain);
		PCMRCXLDTO dto = pcmrcxlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmrcxl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMRCXL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMRCXLDTO> pcmrcxldtos) {
        pcmrcxlService.updateBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMRCXL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMRCXLDTO pcmrcxldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.checkKey(pcmrcxlMapping.toDomain(pcmrcxldto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMRCXL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMRCXLDTO pcmrcxldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.save(pcmrcxlMapping.toDomain(pcmrcxldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMRCXL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMRCXLDTO> pcmrcxldtos) {
        pcmrcxlService.saveBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Current',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch查询当前人才序列下的序列", tags = {"PCMRCXL" } ,notes = "fetch查询当前人才序列下的序列")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchcurrent")
	public ResponseEntity<List<PCMRCXLDTO>> fetchCurrent(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchCurrent(context) ;
        List<PCMRCXLDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Current',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search查询当前人才序列下的序列", tags = {"PCMRCXL" } ,notes = "search查询当前人才序列下的序列")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/searchcurrent")
	public ResponseEntity<Page<PCMRCXLDTO>> searchCurrent(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchCurrent(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'RCXLPPXLLX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch人才序列匹配人才序列类型", tags = {"PCMRCXL" } ,notes = "fetch人才序列匹配人才序列类型")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchrcxlppxllx")
	public ResponseEntity<List<PCMRCXLDTO>> fetchRCXLPPXLLX(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchRCXLPPXLLX(context) ;
        List<PCMRCXLDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'RCXLPPXLLX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search人才序列匹配人才序列类型", tags = {"PCMRCXL" } ,notes = "search人才序列匹配人才序列类型")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/searchrcxlppxllx")
	public ResponseEntity<Page<PCMRCXLDTO>> searchRCXLPPXLLX(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchRCXLPPXLLX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'ZiDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch子查询", tags = {"PCMRCXL" } ,notes = "fetch子查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchzidq")
	public ResponseEntity<List<PCMRCXLDTO>> fetchZiDQ(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchZiDQ(context) ;
        List<PCMRCXLDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'ZiDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search子查询", tags = {"PCMRCXL" } ,notes = "search子查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/searchzidq")
	public ResponseEntity<Page<PCMRCXLDTO>> searchZiDQ(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchZiDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMRCXL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchdefault")
	public ResponseEntity<List<PCMRCXLDTO>> fetchDefault(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchDefault(context) ;
        List<PCMRCXLDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMRCXL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/searchdefault")
	public ResponseEntity<Page<PCMRCXLDTO>> searchDefault(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'GenDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根查询", tags = {"PCMRCXL" } ,notes = "fetch根查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchgendq")
	public ResponseEntity<List<PCMRCXLDTO>> fetchGenDQ(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchGenDQ(context) ;
        List<PCMRCXLDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'GenDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根查询", tags = {"PCMRCXL" } ,notes = "search根查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/searchgendq")
	public ResponseEntity<Page<PCMRCXLDTO>> searchGenDQ(PCMRCXLSearchContext context) {
        Page<PCMRCXL> domains = pcmrcxlService.searchGenDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMRCXL getEntity(){
        return new PCMRCXL();
    }

}