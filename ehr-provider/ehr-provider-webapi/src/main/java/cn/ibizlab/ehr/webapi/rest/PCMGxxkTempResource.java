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
import cn.ibizlab.ehr.core.pcm.domain.PCMGxxkTemp;
import cn.ibizlab.ehr.core.pcm.service.IPCMGxxkTempService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGxxkTempSearchContext;

@Slf4j
@Api(tags = {"高校学科中间表" })
@RestController("WebApi-pcmgxxktemp")
@RequestMapping("")
public class PCMGxxkTempResource {

    @Autowired
    public IPCMGxxkTempService pcmgxxktempService;

    @Autowired
    @Lazy
    public PCMGxxkTempMapping pcmgxxktempMapping;

    @ApiOperation(value = "获取高校学科中间表草稿", tags = {"高校学科中间表" },  notes = "获取高校学科中间表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(new PCMGxxkTemp())));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "新建高校学科中间表", tags = {"高校学科中间表" },  notes = "新建高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> create(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "批量新建高校学科中间表", tags = {"高校学科中间表" },  notes = "批量新建高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.createBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "删除高校学科中间表", tags = {"高校学科中间表" },  notes = "删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "批量删除高校学科中间表", tags = {"高校学科中间表" },  notes = "批量删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查高校学科中间表", tags = {"高校学科中间表" },  notes = "检查高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "保存高校学科中间表", tags = {"高校学科中间表" },  notes = "保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "批量保存高校学科中间表", tags = {"高校学科中间表" },  notes = "批量保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.saveBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "获取高校学科中间表", tags = {"高校学科中间表" },  notes = "获取高校学科中间表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> get(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "更新高校学科中间表", tags = {"高校学科中间表" },  notes = "更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> update(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
		PCMGxxkTemp domain  = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain .setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain );
		PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "批量更新高校学科中间表", tags = {"高校学科中间表" },  notes = "批量更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.updateBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"高校学科中间表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchDefault(PCMGxxkTempSearchContext context) {
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"高校学科中间表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchDefault(@RequestBody PCMGxxkTempSearchContext context) {
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据高校名录获取高校学科中间表草稿", tags = {"高校学科中间表" },  notes = "根据高校名录获取高校学科中间表草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraftByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id) {
        PCMGxxkTemp domain = new PCMGxxkTemp();
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "根据高校名录建立高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录建立高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> createByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "根据高校名录批量建立高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录批量建立高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "根据高校名录删除高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "根据高校名录批量删除高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录批量删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPcmGxml(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据高校名录检查高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录检查高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "根据高校名录保存高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "根据高校名录批量保存高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录批量保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
             domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "根据高校名录获取高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录获取高校学科中间表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> getByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "根据高校名录更新高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> updateByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "根据高校名录批量更新高校学科中间表", tags = {"高校学科中间表" },  notes = "根据高校名录批量更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "根据高校名录获取DEFAULT", tags = {"高校学科中间表" } ,notes = "根据高校名录获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchPCMGxxkTempDefaultByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id,PCMGxxkTempSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "根据高校名录查询DEFAULT", tags = {"高校学科中间表" } ,notes = "根据高校名录查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchPCMGxxkTempDefaultByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据学科目录获取高校学科中间表草稿", tags = {"高校学科中间表" },  notes = "根据学科目录获取高校学科中间表草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraftByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id) {
        PCMGxxkTemp domain = new PCMGxxkTemp();
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "根据学科目录建立高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录建立高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> createByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "根据学科目录批量建立高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录批量建立高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "根据学科目录删除高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "根据学科目录批量删除高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录批量删除高校学科中间表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPcmXkml(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据学科目录检查高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录检查高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "根据学科目录保存高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "根据学科目录批量保存高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录批量保存高校学科中间表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
             domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "根据学科目录获取高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录获取高校学科中间表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> getByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "根据学科目录更新高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> updateByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "根据学科目录批量更新高校学科中间表", tags = {"高校学科中间表" },  notes = "根据学科目录批量更新高校学科中间表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "根据学科目录获取DEFAULT", tags = {"高校学科中间表" } ,notes = "根据学科目录获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchPCMGxxkTempDefaultByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id,PCMGxxkTempSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "根据学科目录查询DEFAULT", tags = {"高校学科中间表" } ,notes = "根据学科目录查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchPCMGxxkTempDefaultByPcmXkml(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

