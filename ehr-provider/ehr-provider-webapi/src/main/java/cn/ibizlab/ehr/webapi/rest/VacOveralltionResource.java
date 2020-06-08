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
import cn.ibizlab.ehr.core.vac.domain.VacOveralltion;
import cn.ibizlab.ehr.core.vac.service.IVacOveralltionService;
import cn.ibizlab.ehr.core.vac.filter.VacOveralltionSearchContext;

@Slf4j
@Api(tags = {"统筹休假(暂时停用)" })
@RestController("WebApi-vacoveralltion")
@RequestMapping("")
public class VacOveralltionResource {

    @Autowired
    public IVacOveralltionService vacoveralltionService;

    @Autowired
    @Lazy
    public VacOveralltionMapping vacoveralltionMapping;

    @ApiOperation(value = "获取统筹休假(暂时停用)草稿", tags = {"统筹休假(暂时停用)" },  notes = "获取统筹休假(暂时停用)草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacoveralltions/getdraft")
    public ResponseEntity<VacOveralltionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionMapping.toDto(vacoveralltionService.getDraft(new VacOveralltion())));
    }

    @PreAuthorize("hasPermission(this.vacoveralltionMapping.toDomain(#vacoveralltiondto),'ehr-VacOveralltion-Save')")
    @ApiOperation(value = "保存统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "保存统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/save")
    public ResponseEntity<Boolean> save(@RequestBody VacOveralltionDTO vacoveralltiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.save(vacoveralltionMapping.toDomain(vacoveralltiondto)));
    }

    @PreAuthorize("hasPermission(this.vacoveralltionMapping.toDomain(#vacoveralltiondtos),'ehr-VacOveralltion-Save')")
    @ApiOperation(value = "批量保存统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "批量保存统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacOveralltionDTO> vacoveralltiondtos) {
        vacoveralltionService.saveBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "检查统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacOveralltionDTO vacoveralltiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.checkKey(vacoveralltionMapping.toDomain(vacoveralltiondto)));
    }

    @PreAuthorize("hasPermission(this.vacoveralltionService.get(#vacoveralltion_id),'ehr-VacOveralltion-Update')")
    @ApiOperation(value = "更新统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "更新统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacoveralltions/{vacoveralltion_id}")
    @Transactional
    public ResponseEntity<VacOveralltionDTO> update(@PathVariable("vacoveralltion_id") String vacoveralltion_id, @RequestBody VacOveralltionDTO vacoveralltiondto) {
		VacOveralltion domain  = vacoveralltionMapping.toDomain(vacoveralltiondto);
        domain .setVacoveralltionid(vacoveralltion_id);
		vacoveralltionService.update(domain );
		VacOveralltionDTO dto = vacoveralltionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacoveralltionService.getVacoveralltionByEntities(this.vacoveralltionMapping.toDomain(#vacoveralltiondtos)),'ehr-VacOveralltion-Update')")
    @ApiOperation(value = "批量更新统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "批量更新统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacOveralltionDTO> vacoveralltiondtos) {
        vacoveralltionService.updateBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacoveralltionService.get(#vacoveralltion_id),'ehr-VacOveralltion-Remove')")
    @ApiOperation(value = "删除统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "删除统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacoveralltions/{vacoveralltion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacoveralltion_id") String vacoveralltion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.remove(vacoveralltion_id));
    }

    @PreAuthorize("hasPermission(this.vacoveralltionService.getVacoveralltionByIds(#ids),'ehr-VacOveralltion-Remove')")
    @ApiOperation(value = "批量删除统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "批量删除统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacoveralltionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacoveralltionMapping.toDomain(#vacoveralltiondto),'ehr-VacOveralltion-Create')")
    @ApiOperation(value = "新建统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "新建统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions")
    @Transactional
    public ResponseEntity<VacOveralltionDTO> create(@RequestBody VacOveralltionDTO vacoveralltiondto) {
        VacOveralltion domain = vacoveralltionMapping.toDomain(vacoveralltiondto);
		vacoveralltionService.create(domain);
        VacOveralltionDTO dto = vacoveralltionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacoveralltionMapping.toDomain(#vacoveralltiondtos),'ehr-VacOveralltion-Create')")
    @ApiOperation(value = "批量新建统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "批量新建统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacOveralltionDTO> vacoveralltiondtos) {
        vacoveralltionService.createBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacoveralltionMapping.toDomain(returnObject.body),'ehr-VacOveralltion-Get')")
    @ApiOperation(value = "获取统筹休假(暂时停用)", tags = {"统筹休假(暂时停用)" },  notes = "获取统筹休假(暂时停用)")
	@RequestMapping(method = RequestMethod.GET, value = "/vacoveralltions/{vacoveralltion_id}")
    public ResponseEntity<VacOveralltionDTO> get(@PathVariable("vacoveralltion_id") String vacoveralltion_id) {
        VacOveralltion domain = vacoveralltionService.get(vacoveralltion_id);
        VacOveralltionDTO dto = vacoveralltionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacOveralltion-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"统筹休假(暂时停用)" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacoveralltions/fetchdefault")
	public ResponseEntity<List<VacOveralltionDTO>> fetchDefault(VacOveralltionSearchContext context) {
        Page<VacOveralltion> domains = vacoveralltionService.searchDefault(context) ;
        List<VacOveralltionDTO> list = vacoveralltionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacOveralltion-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"统筹休假(暂时停用)" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacoveralltions/searchdefault")
	public ResponseEntity<Page<VacOveralltionDTO>> searchDefault(@RequestBody VacOveralltionSearchContext context) {
        Page<VacOveralltion> domains = vacoveralltionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacoveralltionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

