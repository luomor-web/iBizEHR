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
import cn.ibizlab.ehr.core.pcm.domain.TestResult;
import cn.ibizlab.ehr.core.pcm.service.ITestResultService;
import cn.ibizlab.ehr.core.pcm.filter.TestResultSearchContext;

@Slf4j
@Api(tags = {"TestResult" })
@RestController("WebApi-testresult")
@RequestMapping("")
public class TestResultResource {

    @Autowired
    public ITestResultService testresultService;

    @Autowired
    @Lazy
    public TestResultMapping testresultMapping;

    @ApiOperation(value = "GetDraft", tags = {"TestResult" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/testresults/getdraft")
    public ResponseEntity<TestResultDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(testresultMapping.toDto(testresultService.getDraft(new TestResult())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TestResult" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/testresults/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TestResultDTO testresultdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(testresultService.checkKey(testresultMapping.toDomain(testresultdto)));
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdto),'ehr-TestResult-Create')")
    @ApiOperation(value = "Create", tags = {"TestResult" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/testresults")
    @Transactional
    public ResponseEntity<TestResultDTO> create(@RequestBody TestResultDTO testresultdto) {
        TestResult domain = testresultMapping.toDomain(testresultdto);
		testresultService.create(domain);
        TestResultDTO dto = testresultMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdtos),'ehr-TestResult-Create')")
    @ApiOperation(value = "createBatch", tags = {"TestResult" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/testresults/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TestResultDTO> testresultdtos) {
        testresultService.createBatch(testresultMapping.toDomain(testresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdto),'ehr-TestResult-Save')")
    @ApiOperation(value = "Save", tags = {"TestResult" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/testresults/save")
    public ResponseEntity<Boolean> save(@RequestBody TestResultDTO testresultdto) {
        return ResponseEntity.status(HttpStatus.OK).body(testresultService.save(testresultMapping.toDomain(testresultdto)));
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdtos),'ehr-TestResult-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TestResult" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/testresults/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TestResultDTO> testresultdtos) {
        testresultService.saveBatch(testresultMapping.toDomain(testresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.testresultMapping.toDomain(returnObject.body),'ehr-TestResult-Get')")
    @ApiOperation(value = "Get", tags = {"TestResult" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/testresults/{testresult_id}")
    public ResponseEntity<TestResultDTO> get(@PathVariable("testresult_id") String testresult_id) {
        TestResult domain = testresultService.get(testresult_id);
        TestResultDTO dto = testresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultService.get(#testresult_id),'ehr-TestResult-Update')")
    @ApiOperation(value = "Update", tags = {"TestResult" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/testresults/{testresult_id}")
    @Transactional
    public ResponseEntity<TestResultDTO> update(@PathVariable("testresult_id") String testresult_id, @RequestBody TestResultDTO testresultdto) {
		TestResult domain  = testresultMapping.toDomain(testresultdto);
        domain .setTestresultid(testresult_id);
		testresultService.update(domain );
		TestResultDTO dto = testresultMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultService.getTestresultByEntities(this.testresultMapping.toDomain(#testresultdtos)),'ehr-TestResult-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TestResult" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/testresults/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TestResultDTO> testresultdtos) {
        testresultService.updateBatch(testresultMapping.toDomain(testresultdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.testresultService.get(#testresult_id),'ehr-TestResult-Remove')")
    @ApiOperation(value = "Remove", tags = {"TestResult" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/testresults/{testresult_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("testresult_id") String testresult_id) {
         return ResponseEntity.status(HttpStatus.OK).body(testresultService.remove(testresult_id));
    }

    @PreAuthorize("hasPermission(this.testresultService.getTestresultByIds(#ids),'ehr-TestResult-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TestResult" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/testresults/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        testresultService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TestResult-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TestResult" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/testresults/fetchdefault")
	public ResponseEntity<List<TestResultDTO>> fetchDefault(TestResultSearchContext context) {
        Page<TestResult> domains = testresultService.searchDefault(context) ;
        List<TestResultDTO> list = testresultMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TestResult-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TestResult" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/testresults/searchdefault")
	public ResponseEntity<Page<TestResultDTO>> searchDefault(@RequestBody TestResultSearchContext context) {
        Page<TestResult> domains = testresultService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(testresultMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPcmProfile", tags = {"TestResult" },  notes = "GetDraftByPcmProfile")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/testresults/getdraft")
    public ResponseEntity<TestResultDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        TestResult domain = new TestResult();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(testresultMapping.toDto(testresultService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPcmProfile", tags = {"TestResult" },  notes = "CheckKeyByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/testresults/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TestResultDTO testresultdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(testresultService.checkKey(testresultMapping.toDomain(testresultdto)));
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdto),'ehr-TestResult-Create')")
    @ApiOperation(value = "CreateByPcmProfile", tags = {"TestResult" },  notes = "CreateByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/testresults")
    @Transactional
    public ResponseEntity<TestResultDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TestResultDTO testresultdto) {
        TestResult domain = testresultMapping.toDomain(testresultdto);
        domain.setPcmprofileid(pcmprofile_id);
		testresultService.create(domain);
        TestResultDTO dto = testresultMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdtos),'ehr-TestResult-Create')")
    @ApiOperation(value = "createBatchByPcmProfile", tags = {"TestResult" },  notes = "createBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/testresults/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TestResultDTO> testresultdtos) {
        List<TestResult> domainlist=testresultMapping.toDomain(testresultdtos);
        for(TestResult domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        testresultService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdto),'ehr-TestResult-Save')")
    @ApiOperation(value = "SaveByPcmProfile", tags = {"TestResult" },  notes = "SaveByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/testresults/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TestResultDTO testresultdto) {
        TestResult domain = testresultMapping.toDomain(testresultdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(testresultService.save(domain));
    }

    @PreAuthorize("hasPermission(this.testresultMapping.toDomain(#testresultdtos),'ehr-TestResult-Save')")
    @ApiOperation(value = "SaveBatchByPcmProfile", tags = {"TestResult" },  notes = "SaveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/testresults/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TestResultDTO> testresultdtos) {
        List<TestResult> domainlist=testresultMapping.toDomain(testresultdtos);
        for(TestResult domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        testresultService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.testresultMapping.toDomain(returnObject.body),'ehr-TestResult-Get')")
    @ApiOperation(value = "GetByPcmProfile", tags = {"TestResult" },  notes = "GetByPcmProfile")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/testresults/{testresult_id}")
    public ResponseEntity<TestResultDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("testresult_id") String testresult_id) {
        TestResult domain = testresultService.get(testresult_id);
        TestResultDTO dto = testresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultService.get(#testresult_id),'ehr-TestResult-Update')")
    @ApiOperation(value = "UpdateByPcmProfile", tags = {"TestResult" },  notes = "UpdateByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/testresults/{testresult_id}")
    @Transactional
    public ResponseEntity<TestResultDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("testresult_id") String testresult_id, @RequestBody TestResultDTO testresultdto) {
        TestResult domain = testresultMapping.toDomain(testresultdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setTestresultid(testresult_id);
		testresultService.update(domain);
        TestResultDTO dto = testresultMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.testresultService.getTestresultByEntities(this.testresultMapping.toDomain(#testresultdtos)),'ehr-TestResult-Update')")
    @ApiOperation(value = "UpdateBatchByPcmProfile", tags = {"TestResult" },  notes = "UpdateBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/testresults/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TestResultDTO> testresultdtos) {
        List<TestResult> domainlist=testresultMapping.toDomain(testresultdtos);
        for(TestResult domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        testresultService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.testresultService.get(#testresult_id),'ehr-TestResult-Remove')")
    @ApiOperation(value = "RemoveByPcmProfile", tags = {"TestResult" },  notes = "RemoveByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/testresults/{testresult_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("testresult_id") String testresult_id) {
		return ResponseEntity.status(HttpStatus.OK).body(testresultService.remove(testresult_id));
    }

    @PreAuthorize("hasPermission(this.testresultService.getTestresultByIds(#ids),'ehr-TestResult-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmProfile", tags = {"TestResult" },  notes = "RemoveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/testresults/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        testresultService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TestResult-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmProfile", tags = {"TestResult" } ,notes = "fetchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/testresults/fetchdefault")
	public ResponseEntity<List<TestResultDTO>> fetchTestResultDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,TestResultSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<TestResult> domains = testresultService.searchDefault(context) ;
        List<TestResultDTO> list = testresultMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TestResult-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmProfile", tags = {"TestResult" } ,notes = "searchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/testresults/searchdefault")
	public ResponseEntity<Page<TestResultDTO>> searchTestResultDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TestResultSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<TestResult> domains = testresultService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(testresultMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

