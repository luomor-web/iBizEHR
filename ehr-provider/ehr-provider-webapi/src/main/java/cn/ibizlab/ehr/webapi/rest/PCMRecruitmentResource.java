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
import cn.ibizlab.ehr.core.pcm.domain.PCMRecruitment;
import cn.ibizlab.ehr.core.pcm.service.IPCMRecruitmentService;
import cn.ibizlab.ehr.core.pcm.filter.PCMRecruitmentSearchContext;




@Slf4j
@Api(tags = {"PCMRecruitment" })
@RestController("WebApi-pcmrecruitment")
@RequestMapping("")
public class PCMRecruitmentResource {

    @Autowired
    private IPCMRecruitmentService pcmrecruitmentService;

    @Autowired
    @Lazy
    private PCMRecruitmentMapping pcmrecruitmentMapping;




    @ApiOperation(value = "GetDraft", tags = {"PCMRecruitment" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrecruitments/getdraft")
    public ResponseEntity<PCMRecruitmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentMapping.toDto(pcmrecruitmentService.getDraft(new PCMRecruitment())));
    }




    @PreAuthorize("hasPermission(#pcmrecruitment_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMRecruitment" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrecruitments/{pcmrecruitment_id}")
    public ResponseEntity<PCMRecruitmentDTO> get(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id) {
        PCMRecruitment domain = pcmrecruitmentService.get(pcmrecruitment_id);
        PCMRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PCMRecruitment" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMRecruitmentDTO pcmrecruitmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.save(pcmrecruitmentMapping.toDomain(pcmrecruitmentdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMRecruitment" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.saveBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMRecruitment" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments")
    @Transactional
    public ResponseEntity<PCMRecruitmentDTO> create(@RequestBody PCMRecruitmentDTO pcmrecruitmentdto) {
        PCMRecruitment domain = pcmrecruitmentMapping.toDomain(pcmrecruitmentdto);
		pcmrecruitmentService.create(domain);
        PCMRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMRecruitment" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.createBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMRecruitment" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrecruitments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMRecruitmentDTO pcmrecruitmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.checkKey(pcmrecruitmentMapping.toDomain(pcmrecruitmentdto)));
    }




    @PreAuthorize("hasPermission(#pcmrecruitment_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMRecruitment" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrecruitments/{pcmrecruitment_id}")
    @Transactional
    public ResponseEntity<PCMRecruitmentDTO> update(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id, @RequestBody PCMRecruitmentDTO pcmrecruitmentdto) {
		PCMRecruitment domain = pcmrecruitmentMapping.toDomain(pcmrecruitmentdto);
        domain.setPcmrecruitmentid(pcmrecruitment_id);
		pcmrecruitmentService.update(domain);
		PCMRecruitmentDTO dto = pcmrecruitmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmrecruitment_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMRecruitment" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMRecruitmentDTO> pcmrecruitmentdtos) {
        pcmrecruitmentService.updateBatch(pcmrecruitmentMapping.toDomain(pcmrecruitmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmrecruitment_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMRecruitment" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrecruitments/{pcmrecruitment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrecruitment_id") String pcmrecruitment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrecruitmentService.remove(pcmrecruitment_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMRecruitment" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrecruitments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrecruitmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMRecruitment-NBZP-all')")
	@ApiOperation(value = "fetch内部招聘信息", tags = {"PCMRecruitment" } ,notes = "fetch内部招聘信息")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrecruitments/fetchnbzp")
	public ResponseEntity<List<PCMRecruitmentDTO>> fetchNBZP(PCMRecruitmentSearchContext context) {
        Page<PCMRecruitment> domains = pcmrecruitmentService.searchNBZP(context) ;
        List<PCMRecruitmentDTO> list = pcmrecruitmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMRecruitment-NBZP-all')")
	@ApiOperation(value = "search内部招聘信息", tags = {"PCMRecruitment" } ,notes = "search内部招聘信息")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrecruitments/searchnbzp")
	public ResponseEntity<Page<PCMRecruitmentDTO>> searchNBZP(@RequestBody PCMRecruitmentSearchContext context) {
        Page<PCMRecruitment> domains = pcmrecruitmentService.searchNBZP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrecruitmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMRecruitment-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMRecruitment" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrecruitments/fetchdefault")
	public ResponseEntity<List<PCMRecruitmentDTO>> fetchDefault(PCMRecruitmentSearchContext context) {
        Page<PCMRecruitment> domains = pcmrecruitmentService.searchDefault(context) ;
        List<PCMRecruitmentDTO> list = pcmrecruitmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMRecruitment-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMRecruitment" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrecruitments/searchdefault")
	public ResponseEntity<Page<PCMRecruitmentDTO>> searchDefault(@RequestBody PCMRecruitmentSearchContext context) {
        Page<PCMRecruitment> domains = pcmrecruitmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrecruitmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMRecruitment getEntity(){
        return new PCMRecruitment();
    }

}
