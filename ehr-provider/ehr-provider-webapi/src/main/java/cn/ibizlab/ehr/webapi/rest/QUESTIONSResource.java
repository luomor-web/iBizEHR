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
import cn.ibizlab.ehr.core.pim.domain.QUESTIONS;
import cn.ibizlab.ehr.core.pim.service.IQUESTIONSService;
import cn.ibizlab.ehr.core.pim.filter.QUESTIONSSearchContext;

@Slf4j
@Api(tags = {"QUESTIONS" })
@RestController("WebApi-questions")
@RequestMapping("")
public class QUESTIONSResource {

    @Autowired
    public IQUESTIONSService questionsService;

    @Autowired
    @Lazy
    public QUESTIONSMapping questionsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-RemoveTemp-all')")
    @ApiOperation(value = "RemoveTemp", tags = {"QUESTIONS" },  notes = "RemoveTemp")
	@RequestMapping(method = RequestMethod.DELETE, value = "/questions/{questions_id}/removetemp")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> removeTemp(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.removeTemp(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-GetTemp-all')")
    @ApiOperation(value = "GetTemp", tags = {"QUESTIONS" },  notes = "GetTemp")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/{questions_id}/gettemp")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> getTemp(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.getTemp(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-GetDraftTempMajor-all')")
    @ApiOperation(value = "GetDraftTempMajor", tags = {"QUESTIONS" },  notes = "GetDraftTempMajor")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/{questions_id}/getdrafttempmajor")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> getDraftTempMajor(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.getDraftTempMajor(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-UpdateTemp-all')")
    @ApiOperation(value = "UpdateTemp", tags = {"QUESTIONS" },  notes = "UpdateTemp")
	@RequestMapping(method = RequestMethod.PUT, value = "/questions/{questions_id}/updatetemp")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> updateTemp(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.updateTemp(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasPermission(this.questionsMapping.toDomain(#questionsdto),'ehr-QUESTIONS-Save')")
    @ApiOperation(value = "Save", tags = {"QUESTIONS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/save")
    public ResponseEntity<Boolean> save(@RequestBody QUESTIONSDTO questionsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(questionsService.save(questionsMapping.toDomain(questionsdto)));
    }

    @PreAuthorize("hasPermission(this.questionsMapping.toDomain(#questionsdtos),'ehr-QUESTIONS-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"QUESTIONS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<QUESTIONSDTO> questionsdtos) {
        questionsService.saveBatch(questionsMapping.toDomain(questionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-CreateTempMajor-all')")
    @ApiOperation(value = "CreateTempMajor", tags = {"QUESTIONS" },  notes = "CreateTempMajor")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/{questions_id}/createtempmajor")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> createTempMajor(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.createTempMajor(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasPermission(this.questionsService.get(#questions_id),'ehr-QUESTIONS-Update')")
    @ApiOperation(value = "Update", tags = {"QUESTIONS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/questions/{questions_id}")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> update(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
		QUESTIONS domain  = questionsMapping.toDomain(questionsdto);
        domain .setQuestionsid(questions_id);
		questionsService.update(domain );
		QUESTIONSDTO dto = questionsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.questionsService.getQuestionsByEntities(this.questionsMapping.toDomain(#questionsdtos)),'ehr-QUESTIONS-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"QUESTIONS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/questions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<QUESTIONSDTO> questionsdtos) {
        questionsService.updateBatch(questionsMapping.toDomain(questionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.questionsMapping.toDomain(returnObject.body),'ehr-QUESTIONS-Get')")
    @ApiOperation(value = "Get", tags = {"QUESTIONS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/{questions_id}")
    public ResponseEntity<QUESTIONSDTO> get(@PathVariable("questions_id") String questions_id) {
        QUESTIONS domain = questionsService.get(questions_id);
        QUESTIONSDTO dto = questionsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-UpdateTempMajor-all')")
    @ApiOperation(value = "UpdateTempMajor", tags = {"QUESTIONS" },  notes = "UpdateTempMajor")
	@RequestMapping(method = RequestMethod.PUT, value = "/questions/{questions_id}/updatetempmajor")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> updateTempMajor(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.updateTempMajor(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"QUESTIONS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody QUESTIONSDTO questionsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(questionsService.checkKey(questionsMapping.toDomain(questionsdto)));
    }

    @PreAuthorize("hasPermission(this.questionsService.get(#questions_id),'ehr-QUESTIONS-Remove')")
    @ApiOperation(value = "Remove", tags = {"QUESTIONS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/questions/{questions_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("questions_id") String questions_id) {
         return ResponseEntity.status(HttpStatus.OK).body(questionsService.remove(questions_id));
    }

    @PreAuthorize("hasPermission(this.questionsService.getQuestionsByIds(#ids),'ehr-QUESTIONS-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"QUESTIONS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/questions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        questionsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.questionsMapping.toDomain(#questionsdto),'ehr-QUESTIONS-Create')")
    @ApiOperation(value = "Create", tags = {"QUESTIONS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/questions")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> create(@RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS domain = questionsMapping.toDomain(questionsdto);
		questionsService.create(domain);
        QUESTIONSDTO dto = questionsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.questionsMapping.toDomain(#questionsdtos),'ehr-QUESTIONS-Create')")
    @ApiOperation(value = "createBatch", tags = {"QUESTIONS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<QUESTIONSDTO> questionsdtos) {
        questionsService.createBatch(questionsMapping.toDomain(questionsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-GetTempMajor-all')")
    @ApiOperation(value = "GetTempMajor", tags = {"QUESTIONS" },  notes = "GetTempMajor")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/{questions_id}/gettempmajor")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> getTempMajor(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.getTempMajor(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"QUESTIONS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/getdraft")
    public ResponseEntity<QUESTIONSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(questionsMapping.toDto(questionsService.getDraft(new QUESTIONS())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-CreateTemp-all')")
    @ApiOperation(value = "CreateTemp", tags = {"QUESTIONS" },  notes = "CreateTemp")
	@RequestMapping(method = RequestMethod.POST, value = "/questions/{questions_id}/createtemp")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> createTemp(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.createTemp(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-RemoveTempMajor-all')")
    @ApiOperation(value = "RemoveTempMajor", tags = {"QUESTIONS" },  notes = "RemoveTempMajor")
	@RequestMapping(method = RequestMethod.DELETE, value = "/questions/{questions_id}/removetempmajor")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> removeTempMajor(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.removeTempMajor(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-GetDraftTemp-all')")
    @ApiOperation(value = "GetDraftTemp", tags = {"QUESTIONS" },  notes = "GetDraftTemp")
	@RequestMapping(method = RequestMethod.GET, value = "/questions/{questions_id}/getdrafttemp")
    @Transactional
    public ResponseEntity<QUESTIONSDTO> getDraftTemp(@PathVariable("questions_id") String questions_id, @RequestBody QUESTIONSDTO questionsdto) {
        QUESTIONS questions = questionsMapping.toDomain(questionsdto);
        questions.setQuestionsid(questions_id);
        questions = questionsService.getDraftTemp(questions);
        questionsdto = questionsMapping.toDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questionsdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-QUERYcurrentQUESTION-all')")
	@ApiOperation(value = "fetch查询当前页面问题", tags = {"QUESTIONS" } ,notes = "fetch查询当前页面问题")
    @RequestMapping(method= RequestMethod.GET , value="/questions/fetchquerycurrentquestion")
	public ResponseEntity<List<QUESTIONSDTO>> fetchQUERYcurrentQUESTION(QUESTIONSSearchContext context) {
        Page<QUESTIONS> domains = questionsService.searchQUERYcurrentQUESTION(context) ;
        List<QUESTIONSDTO> list = questionsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-QUERYcurrentQUESTION-all')")
	@ApiOperation(value = "search查询当前页面问题", tags = {"QUESTIONS" } ,notes = "search查询当前页面问题")
    @RequestMapping(method= RequestMethod.POST , value="/questions/searchquerycurrentquestion")
	public ResponseEntity<Page<QUESTIONSDTO>> searchQUERYcurrentQUESTION(@RequestBody QUESTIONSSearchContext context) {
        Page<QUESTIONS> domains = questionsService.searchQUERYcurrentQUESTION(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(questionsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"QUESTIONS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/questions/fetchdefault")
	public ResponseEntity<List<QUESTIONSDTO>> fetchDefault(QUESTIONSSearchContext context) {
        Page<QUESTIONS> domains = questionsService.searchDefault(context) ;
        List<QUESTIONSDTO> list = questionsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-QUESTIONS-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"QUESTIONS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/questions/searchdefault")
	public ResponseEntity<Page<QUESTIONSDTO>> searchDefault(@RequestBody QUESTIONSSearchContext context) {
        Page<QUESTIONS> domains = questionsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(questionsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

