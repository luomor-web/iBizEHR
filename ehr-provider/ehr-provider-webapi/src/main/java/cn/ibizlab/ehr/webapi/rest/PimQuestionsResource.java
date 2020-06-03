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
import cn.ibizlab.ehr.core.pim.domain.PimQuestions;
import cn.ibizlab.ehr.core.pim.service.IPimQuestionsService;
import cn.ibizlab.ehr.core.pim.filter.PimQuestionsSearchContext;

@Slf4j
@Api(tags = {"问题收集" })
@RestController("WebApi-pimquestions")
@RequestMapping("")
public class PimQuestionsResource {

    @Autowired
    public IPimQuestionsService pimquestionsService;

    @Autowired
    @Lazy
    public PimQuestionsMapping pimquestionsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-RemoveTemp-all')")
    @ApiOperation(value = "RemoveTemp", tags = {"问题收集" },  notes = "RemoveTemp")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimquestions/{pimquestions_id}/removetemp")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> removeTemp(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.removeTemp(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-GetTemp-all')")
    @ApiOperation(value = "GetTemp", tags = {"问题收集" },  notes = "GetTemp")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/{pimquestions_id}/gettemp")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> getTemp(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.getTemp(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-GetDraftTempMajor-all')")
    @ApiOperation(value = "GetDraftTempMajor", tags = {"问题收集" },  notes = "GetDraftTempMajor")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/{pimquestions_id}/getdrafttempmajor")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> getDraftTempMajor(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.getDraftTempMajor(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-UpdateTemp-all')")
    @ApiOperation(value = "UpdateTemp", tags = {"问题收集" },  notes = "UpdateTemp")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimquestions/{pimquestions_id}/updatetemp")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> updateTemp(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.updateTemp(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasPermission(this.pimquestionsMapping.toDomain(#pimquestionsdto),'ehr-PimQuestions-Save')")
    @ApiOperation(value = "保存问题收集", tags = {"问题收集" },  notes = "保存问题收集")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/save")
    public ResponseEntity<Boolean> save(@RequestBody PimQuestionsDTO pimquestionsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsService.save(pimquestionsMapping.toDomain(pimquestionsdto)));
    }

    @PreAuthorize("hasPermission(this.pimquestionsMapping.toDomain(#pimquestionsdtos),'ehr-PimQuestions-Save')")
    @ApiOperation(value = "批量保存问题收集", tags = {"问题收集" },  notes = "批量保存问题收集")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimQuestionsDTO> pimquestionsdtos) {
        pimquestionsService.saveBatch(pimquestionsMapping.toDomain(pimquestionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-CreateTempMajor-all')")
    @ApiOperation(value = "CreateTempMajor", tags = {"问题收集" },  notes = "CreateTempMajor")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/{pimquestions_id}/createtempmajor")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> createTempMajor(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.createTempMajor(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasPermission(this.pimquestionsService.get(#pimquestions_id),'ehr-PimQuestions-Update')")
    @ApiOperation(value = "更新问题收集", tags = {"问题收集" },  notes = "更新问题收集")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimquestions/{pimquestions_id}")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> update(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
		PimQuestions domain  = pimquestionsMapping.toDomain(pimquestionsdto);
        domain .setQuestionsid(pimquestions_id);
		pimquestionsService.update(domain );
		PimQuestionsDTO dto = pimquestionsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimquestionsService.getPimquestionsByEntities(this.pimquestionsMapping.toDomain(#pimquestionsdtos)),'ehr-PimQuestions-Update')")
    @ApiOperation(value = "批量更新问题收集", tags = {"问题收集" },  notes = "批量更新问题收集")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimquestions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimQuestionsDTO> pimquestionsdtos) {
        pimquestionsService.updateBatch(pimquestionsMapping.toDomain(pimquestionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimquestionsMapping.toDomain(returnObject.body),'ehr-PimQuestions-Get')")
    @ApiOperation(value = "获取问题收集", tags = {"问题收集" },  notes = "获取问题收集")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/{pimquestions_id}")
    public ResponseEntity<PimQuestionsDTO> get(@PathVariable("pimquestions_id") String pimquestions_id) {
        PimQuestions domain = pimquestionsService.get(pimquestions_id);
        PimQuestionsDTO dto = pimquestionsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-UpdateTempMajor-all')")
    @ApiOperation(value = "UpdateTempMajor", tags = {"问题收集" },  notes = "UpdateTempMajor")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimquestions/{pimquestions_id}/updatetempmajor")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> updateTempMajor(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.updateTempMajor(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @ApiOperation(value = "检查问题收集", tags = {"问题收集" },  notes = "检查问题收集")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimQuestionsDTO pimquestionsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimquestionsService.checkKey(pimquestionsMapping.toDomain(pimquestionsdto)));
    }

    @PreAuthorize("hasPermission(this.pimquestionsService.get(#pimquestions_id),'ehr-PimQuestions-Remove')")
    @ApiOperation(value = "删除问题收集", tags = {"问题收集" },  notes = "删除问题收集")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimquestions/{pimquestions_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimquestions_id") String pimquestions_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimquestionsService.remove(pimquestions_id));
    }

    @PreAuthorize("hasPermission(this.pimquestionsService.getPimquestionsByIds(#ids),'ehr-PimQuestions-Remove')")
    @ApiOperation(value = "批量删除问题收集", tags = {"问题收集" },  notes = "批量删除问题收集")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimquestions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimquestionsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimquestionsMapping.toDomain(#pimquestionsdto),'ehr-PimQuestions-Create')")
    @ApiOperation(value = "新建问题收集", tags = {"问题收集" },  notes = "新建问题收集")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> create(@RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions domain = pimquestionsMapping.toDomain(pimquestionsdto);
		pimquestionsService.create(domain);
        PimQuestionsDTO dto = pimquestionsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimquestionsMapping.toDomain(#pimquestionsdtos),'ehr-PimQuestions-Create')")
    @ApiOperation(value = "批量新建问题收集", tags = {"问题收集" },  notes = "批量新建问题收集")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimQuestionsDTO> pimquestionsdtos) {
        pimquestionsService.createBatch(pimquestionsMapping.toDomain(pimquestionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-GetTempMajor-all')")
    @ApiOperation(value = "GetTempMajor", tags = {"问题收集" },  notes = "GetTempMajor")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/{pimquestions_id}/gettempmajor")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> getTempMajor(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.getTempMajor(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @ApiOperation(value = "获取问题收集草稿", tags = {"问题收集" },  notes = "获取问题收集草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/getdraft")
    public ResponseEntity<PimQuestionsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsMapping.toDto(pimquestionsService.getDraft(new PimQuestions())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-CreateTemp-all')")
    @ApiOperation(value = "CreateTemp", tags = {"问题收集" },  notes = "CreateTemp")
	@RequestMapping(method = RequestMethod.POST, value = "/pimquestions/{pimquestions_id}/createtemp")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> createTemp(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.createTemp(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-RemoveTempMajor-all')")
    @ApiOperation(value = "RemoveTempMajor", tags = {"问题收集" },  notes = "RemoveTempMajor")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimquestions/{pimquestions_id}/removetempmajor")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> removeTempMajor(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.removeTempMajor(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-GetDraftTemp-all')")
    @ApiOperation(value = "GetDraftTemp", tags = {"问题收集" },  notes = "GetDraftTemp")
	@RequestMapping(method = RequestMethod.GET, value = "/pimquestions/{pimquestions_id}/getdrafttemp")
    @Transactional
    public ResponseEntity<PimQuestionsDTO> getDraftTemp(@PathVariable("pimquestions_id") String pimquestions_id, @RequestBody PimQuestionsDTO pimquestionsdto) {
        PimQuestions pimquestions = pimquestionsMapping.toDomain(pimquestionsdto);
        pimquestions.setQuestionsid(pimquestions_id);
        pimquestions = pimquestionsService.getDraftTemp(pimquestions);
        pimquestionsdto = pimquestionsMapping.toDto(pimquestions);
        return ResponseEntity.status(HttpStatus.OK).body(pimquestionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-QUERYcurrentQUESTION-all')")
	@ApiOperation(value = "获取查询当前页面问题", tags = {"问题收集" } ,notes = "获取查询当前页面问题")
    @RequestMapping(method= RequestMethod.GET , value="/pimquestions/fetchquerycurrentquestion")
	public ResponseEntity<List<PimQuestionsDTO>> fetchQUERYcurrentQUESTION(PimQuestionsSearchContext context) {
        Page<PimQuestions> domains = pimquestionsService.searchQUERYcurrentQUESTION(context) ;
        List<PimQuestionsDTO> list = pimquestionsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-QUERYcurrentQUESTION-all')")
	@ApiOperation(value = "查询查询当前页面问题", tags = {"问题收集" } ,notes = "查询查询当前页面问题")
    @RequestMapping(method= RequestMethod.POST , value="/pimquestions/searchquerycurrentquestion")
	public ResponseEntity<Page<PimQuestionsDTO>> searchQUERYcurrentQUESTION(@RequestBody PimQuestionsSearchContext context) {
        Page<PimQuestions> domains = pimquestionsService.searchQUERYcurrentQUESTION(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimquestionsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"问题收集" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimquestions/fetchdefault")
	public ResponseEntity<List<PimQuestionsDTO>> fetchDefault(PimQuestionsSearchContext context) {
        Page<PimQuestions> domains = pimquestionsService.searchDefault(context) ;
        List<PimQuestionsDTO> list = pimquestionsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQuestions-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"问题收集" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimquestions/searchdefault")
	public ResponseEntity<Page<PimQuestionsDTO>> searchDefault(@RequestBody PimQuestionsSearchContext context) {
        Page<PimQuestions> domains = pimquestionsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimquestionsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

