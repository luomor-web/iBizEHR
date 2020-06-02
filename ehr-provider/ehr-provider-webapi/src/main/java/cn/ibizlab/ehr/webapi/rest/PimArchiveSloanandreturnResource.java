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
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
import cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService;
import cn.ibizlab.ehr.core.pim.filter.PimArchiveSloanandreturnSearchContext;

@Slf4j
@Api(tags = {"档案借阅及归还记录" })
@RestController("WebApi-pimarchivesloanandreturn")
@RequestMapping("")
public class PimArchiveSloanandreturnResource {

    @Autowired
    public IPimArchiveSloanandreturnService pimarchivesloanandreturnService;

    @Autowired
    @Lazy
    public PimArchiveSloanandreturnMapping pimarchivesloanandreturnMapping;

    @PostAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(returnObject.body),'ehr-PimArchiveSloanandreturn-Get')")
    @ApiOperation(value = "获取档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "获取档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PimArchiveSloanandreturnDTO> get(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> update(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
		PimArchiveSloanandreturn domain  = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain .setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain );
		PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByEntities(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos)),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "批量更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "批量更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.updateBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "新建档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "新建档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> create(@RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
		pimarchivesloanandreturnService.create(domain);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "批量新建档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "批量新建档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.createBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取档案借阅及归还记录草稿", tags = {"档案借阅及归还记录" },  notes = "获取档案借阅及归还记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PimArchiveSloanandreturnDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(new PimArchiveSloanandreturn())));
    }

    @ApiOperation(value = "检查档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "检查档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateState-all')")
    @ApiOperation(value = "", tags = {"档案借阅及归还记录" },  notes = "")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateState(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn pimarchivesloanandreturn = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        pimarchivesloanandreturn.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
        pimarchivesloanandreturn = pimarchivesloanandreturnService.updateState(pimarchivesloanandreturn);
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturn);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "批量保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "批量保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.saveBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByIds(#ids),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "批量删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "批量删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateArchiveState-all')")
    @ApiOperation(value = "更新档案信息借阅状态", tags = {"档案借阅及归还记录" },  notes = "更新档案信息借阅状态")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateArchiveState(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn pimarchivesloanandreturn = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        pimarchivesloanandreturn.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
        pimarchivesloanandreturn = pimarchivesloanandreturnService.updateArchiveState(pimarchivesloanandreturn);
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturn);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PimArchiveSloanandreturnDTO>> fetchDefault(PimArchiveSloanandreturnSearchContext context) {
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PimArchiveSloanandreturnDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PimArchiveSloanandreturnDTO>> searchDefault(@RequestBody PimArchiveSloanandreturnSearchContext context) {
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(returnObject.body),'ehr-PimArchiveSloanandreturn-Get')")
    @ApiOperation(value = "根据档案信息获取档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息获取档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PimArchiveSloanandreturnDTO> getByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "根据档案信息更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByEntities(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos)),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "根据档案信息批量更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息批量更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "根据档案信息建立档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息建立档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> createByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesloanandreturnService.create(domain);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "根据档案信息批量建立档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息批量建立档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据档案信息获取档案借阅及归还记录草稿", tags = {"档案借阅及归还记录" },  notes = "根据档案信息获取档案借阅及归还记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PimArchiveSloanandreturnDTO> getDraftByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchiveSloanandreturn domain = new PimArchiveSloanandreturn();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(domain)));
    }

    @ApiOperation(value = "根据档案信息检查档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息检查档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateState-all')")
    @ApiOperation(value = "根据档案信息档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateStateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "根据档案信息保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> saveByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "根据档案信息批量保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息批量保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "根据档案信息删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByIds(#ids),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "根据档案信息批量删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息批量删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatchByPimArchives(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateArchiveState-all')")
    @ApiOperation(value = "根据档案信息档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据档案信息档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateArchiveStateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateArchiveState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "根据档案信息获取DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "根据档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PimArchiveSloanandreturnDTO>> fetchPimArchiveSloanandreturnDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PimArchiveSloanandreturnSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PimArchiveSloanandreturnDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "根据档案信息查询DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "根据档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PimArchiveSloanandreturnDTO>> searchPimArchiveSloanandreturnDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(returnObject.body),'ehr-PimArchiveSloanandreturn-Get')")
    @ApiOperation(value = "根据人员信息档案信息获取档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息获取档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PimArchiveSloanandreturnDTO> getByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "根据人员信息档案信息更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByEntities(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos)),'ehr-PimArchiveSloanandreturn-Update')")
    @ApiOperation(value = "根据人员信息档案信息批量更新档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息批量更新档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "根据人员信息档案信息建立档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息建立档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> createByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesloanandreturnService.create(domain);
        PimArchiveSloanandreturnDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Create')")
    @ApiOperation(value = "根据人员信息档案信息批量建立档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息批量建立档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息档案信息获取档案借阅及归还记录草稿", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息获取档案借阅及归还记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PimArchiveSloanandreturnDTO> getDraftByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchiveSloanandreturn domain = new PimArchiveSloanandreturn();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息档案信息检查档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息检查档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateState-all')")
    @ApiOperation(value = "根据人员信息档案信息档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateStateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndto),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "根据人员信息档案信息保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> saveByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnMapping.toDomain(#pimarchivesloanandreturndtos),'ehr-PimArchiveSloanandreturn-Save')")
    @ApiOperation(value = "根据人员信息档案信息批量保存档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息批量保存档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchiveSloanandreturnDTO> pimarchivesloanandreturndtos) {
        List<PimArchiveSloanandreturn> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PimArchiveSloanandreturn domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.get(#pimarchivesloanandreturn_id),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "根据人员信息档案信息删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesloanandreturnService.getPimarchivesloanandreturnByIds(#ids),'ehr-PimArchiveSloanandreturn-Remove')")
    @ApiOperation(value = "根据人员信息档案信息批量删除档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息批量删除档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimArchives(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-UpdateArchiveState-all')")
    @ApiOperation(value = "根据人员信息档案信息档案借阅及归还记录", tags = {"档案借阅及归还记录" },  notes = "根据人员信息档案信息档案借阅及归还记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PimArchiveSloanandreturnDTO> updateArchiveStateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PimArchiveSloanandreturnDTO pimarchivesloanandreturndto) {
        PimArchiveSloanandreturn domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateArchiveState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息获取DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "根据人员信息档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PimArchiveSloanandreturnDTO>> fetchPimArchiveSloanandreturnDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PimArchiveSloanandreturnSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PimArchiveSloanandreturnDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchiveSloanandreturn-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息查询DEFAULT", tags = {"档案借阅及归还记录" } ,notes = "根据人员信息档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PimArchiveSloanandreturnDTO>> searchPimArchiveSloanandreturnDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchiveSloanandreturnSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchiveSloanandreturn> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

