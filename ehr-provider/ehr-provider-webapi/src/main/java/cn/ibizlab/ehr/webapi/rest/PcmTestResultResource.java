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
import cn.ibizlab.ehr.core.pcm.domain.PcmTestResult;
import cn.ibizlab.ehr.core.pcm.service.IPcmTestResultService;
import cn.ibizlab.ehr.core.pcm.filter.PcmTestResultSearchContext;

@Slf4j
@Api(tags = {"测评结果摘要信息" })
@RestController("WebApi-pcmtestresult")
@RequestMapping("")
public class PcmTestResultResource {

    @Autowired
    public IPcmTestResultService pcmtestresultService;

    @Autowired
    @Lazy
    public PcmTestResultMapping pcmtestresultMapping;

    @ApiOperation(value = "获取测评结果摘要信息草稿", tags = {"测评结果摘要信息" },  notes = "获取测评结果摘要信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtestresults/getdraft")
    public ResponseEntity<PcmTestResultDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultMapping.toDto(pcmtestresultService.getDraft(new PcmTestResult())));
    }

    @ApiOperation(value = "检查测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "检查测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtestresults/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmTestResultDTO pcmtestresultdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.checkKey(pcmtestresultMapping.toDomain(pcmtestresultdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdto),'ehr-PcmTestResult-Create')")
    @ApiOperation(value = "新建测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "新建测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtestresults")
    @Transactional
    public ResponseEntity<PcmTestResultDTO> create(@RequestBody PcmTestResultDTO pcmtestresultdto) {
        PcmTestResult domain = pcmtestresultMapping.toDomain(pcmtestresultdto);
		pcmtestresultService.create(domain);
        PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos),'ehr-PcmTestResult-Create')")
    @ApiOperation(value = "批量新建测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "批量新建测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtestresults/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        pcmtestresultService.createBatch(pcmtestresultMapping.toDomain(pcmtestresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdto),'ehr-PcmTestResult-Save')")
    @ApiOperation(value = "保存测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "保存测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtestresults/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmTestResultDTO pcmtestresultdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.save(pcmtestresultMapping.toDomain(pcmtestresultdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos),'ehr-PcmTestResult-Save')")
    @ApiOperation(value = "批量保存测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "批量保存测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtestresults/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        pcmtestresultService.saveBatch(pcmtestresultMapping.toDomain(pcmtestresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(returnObject.body),'ehr-PcmTestResult-Get')")
    @ApiOperation(value = "获取测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "获取测评结果摘要信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtestresults/{pcmtestresult_id}")
    public ResponseEntity<PcmTestResultDTO> get(@PathVariable("pcmtestresult_id") String pcmtestresult_id) {
        PcmTestResult domain = pcmtestresultService.get(pcmtestresult_id);
        PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.get(#pcmtestresult_id),'ehr-PcmTestResult-Update')")
    @ApiOperation(value = "更新测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "更新测评结果摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtestresults/{pcmtestresult_id}")
    @Transactional
    public ResponseEntity<PcmTestResultDTO> update(@PathVariable("pcmtestresult_id") String pcmtestresult_id, @RequestBody PcmTestResultDTO pcmtestresultdto) {
		PcmTestResult domain  = pcmtestresultMapping.toDomain(pcmtestresultdto);
        domain .setTestresultid(pcmtestresult_id);
		pcmtestresultService.update(domain );
		PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.getPcmtestresultByEntities(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos)),'ehr-PcmTestResult-Update')")
    @ApiOperation(value = "批量更新测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "批量更新测评结果摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtestresults/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        pcmtestresultService.updateBatch(pcmtestresultMapping.toDomain(pcmtestresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.get(#pcmtestresult_id),'ehr-PcmTestResult-Remove')")
    @ApiOperation(value = "删除测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "删除测评结果摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtestresults/{pcmtestresult_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtestresult_id") String pcmtestresult_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.remove(pcmtestresult_id));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.getPcmtestresultByIds(#ids),'ehr-PcmTestResult-Remove')")
    @ApiOperation(value = "批量删除测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "批量删除测评结果摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtestresults/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtestresultService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTestResult-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"测评结果摘要信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtestresults/fetchdefault")
	public ResponseEntity<List<PcmTestResultDTO>> fetchDefault(PcmTestResultSearchContext context) {
        Page<PcmTestResult> domains = pcmtestresultService.searchDefault(context) ;
        List<PcmTestResultDTO> list = pcmtestresultMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTestResult-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"测评结果摘要信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtestresults/searchdefault")
	public ResponseEntity<Page<PcmTestResultDTO>> searchDefault(@RequestBody PcmTestResultSearchContext context) {
        Page<PcmTestResult> domains = pcmtestresultService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtestresultMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据应聘者基本信息获取测评结果摘要信息草稿", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息获取测评结果摘要信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/getdraft")
    public ResponseEntity<PcmTestResultDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmTestResult domain = new PcmTestResult();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultMapping.toDto(pcmtestresultService.getDraft(domain)));
    }

    @ApiOperation(value = "根据应聘者基本信息检查测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息检查测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTestResultDTO pcmtestresultdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.checkKey(pcmtestresultMapping.toDomain(pcmtestresultdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdto),'ehr-PcmTestResult-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息建立测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults")
    @Transactional
    public ResponseEntity<PcmTestResultDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTestResultDTO pcmtestresultdto) {
        PcmTestResult domain = pcmtestresultMapping.toDomain(pcmtestresultdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmtestresultService.create(domain);
        PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos),'ehr-PcmTestResult-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息批量建立测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        List<PcmTestResult> domainlist=pcmtestresultMapping.toDomain(pcmtestresultdtos);
        for(PcmTestResult domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtestresultService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdto),'ehr-PcmTestResult-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息保存测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTestResultDTO pcmtestresultdto) {
        PcmTestResult domain = pcmtestresultMapping.toDomain(pcmtestresultdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos),'ehr-PcmTestResult-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息批量保存测评结果摘要信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        List<PcmTestResult> domainlist=pcmtestresultMapping.toDomain(pcmtestresultdtos);
        for(PcmTestResult domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtestresultService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmtestresultMapping.toDomain(returnObject.body),'ehr-PcmTestResult-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息获取测评结果摘要信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/{pcmtestresult_id}")
    public ResponseEntity<PcmTestResultDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtestresult_id") String pcmtestresult_id) {
        PcmTestResult domain = pcmtestresultService.get(pcmtestresult_id);
        PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.get(#pcmtestresult_id),'ehr-PcmTestResult-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息更新测评结果摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/{pcmtestresult_id}")
    @Transactional
    public ResponseEntity<PcmTestResultDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtestresult_id") String pcmtestresult_id, @RequestBody PcmTestResultDTO pcmtestresultdto) {
        PcmTestResult domain = pcmtestresultMapping.toDomain(pcmtestresultdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setTestresultid(pcmtestresult_id);
		pcmtestresultService.update(domain);
        PcmTestResultDTO dto = pcmtestresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.getPcmtestresultByEntities(this.pcmtestresultMapping.toDomain(#pcmtestresultdtos)),'ehr-PcmTestResult-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息批量更新测评结果摘要信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTestResultDTO> pcmtestresultdtos) {
        List<PcmTestResult> domainlist=pcmtestresultMapping.toDomain(pcmtestresultdtos);
        for(PcmTestResult domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtestresultService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.get(#pcmtestresult_id),'ehr-PcmTestResult-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息删除测评结果摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/{pcmtestresult_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtestresult_id") String pcmtestresult_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmtestresultService.remove(pcmtestresult_id));
    }

    @PreAuthorize("hasPermission(this.pcmtestresultService.getPcmtestresultByIds(#ids),'ehr-PcmTestResult-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除测评结果摘要信息", tags = {"测评结果摘要信息" },  notes = "根据应聘者基本信息批量删除测评结果摘要信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtestresults/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmtestresultService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTestResult-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"测评结果摘要信息" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmtestresults/fetchdefault")
	public ResponseEntity<List<PcmTestResultDTO>> fetchPcmTestResultDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmTestResultSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTestResult> domains = pcmtestresultService.searchDefault(context) ;
        List<PcmTestResultDTO> list = pcmtestresultMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTestResult-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"测评结果摘要信息" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmtestresults/searchdefault")
	public ResponseEntity<Page<PcmTestResultDTO>> searchPcmTestResultDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTestResultSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTestResult> domains = pcmtestresultService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtestresultMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

