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
import cn.ibizlab.ehr.core.pim.domain.PimLabourcampany;
import cn.ibizlab.ehr.core.pim.service.IPimLabourcampanyService;
import cn.ibizlab.ehr.core.pim.filter.PimLabourcampanySearchContext;

@Slf4j
@Api(tags = {"劳务派遣公司管理" })
@RestController("WebApi-pimlabourcampany")
@RequestMapping("")
public class PimLabourcampanyResource {

    @Autowired
    public IPimLabourcampanyService pimlabourcampanyService;

    @Autowired
    @Lazy
    public PimLabourcampanyMapping pimlabourcampanyMapping;

    @PreAuthorize("hasPermission(this.pimlabourcampanyMapping.toDomain(#pimlabourcampanydto),'ehr-PimLabourcampany-Save')")
    @ApiOperation(value = "保存劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "保存劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/save")
    public ResponseEntity<Boolean> save(@RequestBody PimLabourcampanyDTO pimlabourcampanydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.save(pimlabourcampanyMapping.toDomain(pimlabourcampanydto)));
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyMapping.toDomain(#pimlabourcampanydtos),'ehr-PimLabourcampany-Save')")
    @ApiOperation(value = "批量保存劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "批量保存劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimLabourcampanyDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.saveBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "检查劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimLabourcampanyDTO pimlabourcampanydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.checkKey(pimlabourcampanyMapping.toDomain(pimlabourcampanydto)));
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyService.get(#pimlabourcampany_id),'ehr-PimLabourcampany-Update')")
    @ApiOperation(value = "更新劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "更新劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    @Transactional
    public ResponseEntity<PimLabourcampanyDTO> update(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id, @RequestBody PimLabourcampanyDTO pimlabourcampanydto) {
		PimLabourcampany domain  = pimlabourcampanyMapping.toDomain(pimlabourcampanydto);
        domain .setPimlabourcampanyid(pimlabourcampany_id);
		pimlabourcampanyService.update(domain );
		PimLabourcampanyDTO dto = pimlabourcampanyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyService.getPimlabourcampanyByEntities(this.pimlabourcampanyMapping.toDomain(#pimlabourcampanydtos)),'ehr-PimLabourcampany-Update')")
    @ApiOperation(value = "批量更新劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "批量更新劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimLabourcampanyDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.updateBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyMapping.toDomain(#pimlabourcampanydto),'ehr-PimLabourcampany-Create')")
    @ApiOperation(value = "新建劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "新建劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies")
    @Transactional
    public ResponseEntity<PimLabourcampanyDTO> create(@RequestBody PimLabourcampanyDTO pimlabourcampanydto) {
        PimLabourcampany domain = pimlabourcampanyMapping.toDomain(pimlabourcampanydto);
		pimlabourcampanyService.create(domain);
        PimLabourcampanyDTO dto = pimlabourcampanyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyMapping.toDomain(#pimlabourcampanydtos),'ehr-PimLabourcampany-Create')")
    @ApiOperation(value = "批量新建劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "批量新建劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimLabourcampanyDTO> pimlabourcampanydtos) {
        pimlabourcampanyService.createBatch(pimlabourcampanyMapping.toDomain(pimlabourcampanydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyService.get(#pimlabourcampany_id),'ehr-PimLabourcampany-Remove')")
    @ApiOperation(value = "删除劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "删除劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyService.remove(pimlabourcampany_id));
    }

    @PreAuthorize("hasPermission(this.pimlabourcampanyService.getPimlabourcampanyByIds(#ids),'ehr-PimLabourcampany-Remove')")
    @ApiOperation(value = "批量删除劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "批量删除劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlabourcampanies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlabourcampanyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimlabourcampanyMapping.toDomain(returnObject.body),'ehr-PimLabourcampany-Get')")
    @ApiOperation(value = "获取劳务派遣公司管理", tags = {"劳务派遣公司管理" },  notes = "获取劳务派遣公司管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlabourcampanies/{pimlabourcampany_id}")
    public ResponseEntity<PimLabourcampanyDTO> get(@PathVariable("pimlabourcampany_id") String pimlabourcampany_id) {
        PimLabourcampany domain = pimlabourcampanyService.get(pimlabourcampany_id);
        PimLabourcampanyDTO dto = pimlabourcampanyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取劳务派遣公司管理草稿", tags = {"劳务派遣公司管理" },  notes = "获取劳务派遣公司管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlabourcampanies/getdraft")
    public ResponseEntity<PimLabourcampanyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlabourcampanyMapping.toDto(pimlabourcampanyService.getDraft(new PimLabourcampany())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLabourcampany-AuthLab-all')")
	@ApiOperation(value = "获取AuthLab", tags = {"劳务派遣公司管理" } ,notes = "获取AuthLab")
    @RequestMapping(method= RequestMethod.GET , value="/pimlabourcampanies/fetchauthlab")
	public ResponseEntity<List<PimLabourcampanyDTO>> fetchAuthLab(PimLabourcampanySearchContext context) {
        Page<PimLabourcampany> domains = pimlabourcampanyService.searchAuthLab(context) ;
        List<PimLabourcampanyDTO> list = pimlabourcampanyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLabourcampany-AuthLab-all')")
	@ApiOperation(value = "查询AuthLab", tags = {"劳务派遣公司管理" } ,notes = "查询AuthLab")
    @RequestMapping(method= RequestMethod.POST , value="/pimlabourcampanies/searchauthlab")
	public ResponseEntity<Page<PimLabourcampanyDTO>> searchAuthLab(@RequestBody PimLabourcampanySearchContext context) {
        Page<PimLabourcampany> domains = pimlabourcampanyService.searchAuthLab(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlabourcampanyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLabourcampany-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"劳务派遣公司管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlabourcampanies/fetchdefault")
	public ResponseEntity<List<PimLabourcampanyDTO>> fetchDefault(PimLabourcampanySearchContext context) {
        Page<PimLabourcampany> domains = pimlabourcampanyService.searchDefault(context) ;
        List<PimLabourcampanyDTO> list = pimlabourcampanyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLabourcampany-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"劳务派遣公司管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlabourcampanies/searchdefault")
	public ResponseEntity<Page<PimLabourcampanyDTO>> searchDefault(@RequestBody PimLabourcampanySearchContext context) {
        Page<PimLabourcampany> domains = pimlabourcampanyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlabourcampanyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

