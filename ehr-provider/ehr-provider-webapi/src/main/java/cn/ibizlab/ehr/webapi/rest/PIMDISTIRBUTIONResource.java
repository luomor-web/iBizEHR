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
import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;
import cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService;
import cn.ibizlab.ehr.core.pim.filter.PIMDISTIRBUTIONSearchContext;

@Slf4j
@Api(tags = {"PIMDISTIRBUTION" })
@RestController("WebApi-pimdistirbution")
@RequestMapping("")
public class PIMDISTIRBUTIONResource {

    @Autowired
    private IPIMDISTIRBUTIONService pimdistirbutionService;

    @Autowired
    @Lazy
    public PIMDISTIRBUTIONMapping pimdistirbutionMapping;

    public PIMDISTIRBUTIONDTO permissionDTO=new PIMDISTIRBUTIONDTO();

    @PreAuthorize("hasPermission(#pimdistirbution_id,'Remove',{'Sql',this.pimdistirbutionMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMDISTIRBUTION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.remove(pimdistirbution_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMDISTIRBUTION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimdistirbutionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMDISTIRBUTION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.checkKey(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission(#pimdistirbution_id,'Update',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "Update", tags = {"PIMDISTIRBUTION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> update(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
		PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pimdistirbutionService.update(domain);
		PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMDISTIRBUTION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        pimdistirbutionService.updateBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMDISTIRBUTION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/getdraft")
    public ResponseEntity<PIMDISTIRBUTIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionMapping.toDto(pimdistirbutionService.getDraft(new PIMDISTIRBUTION())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DDCZC-all')")
    @ApiOperation(value = "调动出操作", tags = {"PIMDISTIRBUTION" },  notes = "调动出操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/ddczc")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> dDCZC(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION pimdistirbution = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        pimdistirbution = pimdistirbutionService.dDCZC(pimdistirbution);
        pimdistirbutiondto = pimdistirbutionMapping.toDto(pimdistirbution);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutiondto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "Save", tags = {"PIMDISTIRBUTION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.save(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMDISTIRBUTION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        pimdistirbutionService.saveBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "Create", tags = {"PIMDISTIRBUTION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> create(@RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
		pimdistirbutionService.create(domain);
        PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMDISTIRBUTION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        pimdistirbutionService.createBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimdistirbution_id,'Get',{'Sql',this.pimdistirbutionMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMDISTIRBUTION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}")
    public ResponseEntity<PIMDISTIRBUTIONDTO> get(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PIMDISTIRBUTION domain = pimdistirbutionService.get(pimdistirbution_id);
        PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GBYXZFP-all')")
	@ApiOperation(value = "fetch干部可调动的分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch干部可调动的分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchgbyxzfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchGBYXZFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchGBYXZFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GBYXZFP-all')")
	@ApiOperation(value = "search干部可调动的分配", tags = {"PIMDISTIRBUTION" } ,notes = "search干部可调动的分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchgbyxzfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchGBYXZFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchGBYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-LGTX-all')")
	@ApiOperation(value = "fetch轮岗查询", tags = {"PIMDISTIRBUTION" } ,notes = "fetch轮岗查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchlgtx")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchLGTX(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchLGTX(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-LGTX-all')")
	@ApiOperation(value = "search轮岗查询", tags = {"PIMDISTIRBUTION" } ,notes = "search轮岗查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchlgtx")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchLGTX(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchLGTX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ISOUTRECORD-all')")
	@ApiOperation(value = "fetch外单位履历为1的（支持增删改查）", tags = {"PIMDISTIRBUTION" } ,notes = "fetch外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchisoutrecord")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchISOUTRECORD(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ISOUTRECORD-all')")
	@ApiOperation(value = "search外单位履历为1的（支持增删改查）", tags = {"PIMDISTIRBUTION" } ,notes = "search外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchisoutrecord")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchISOUTRECORD(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDCFP-all')")
	@ApiOperation(value = "fetch已调出分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch已调出分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchydcfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchYDCFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDCFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDCFP-all')")
	@ApiOperation(value = "search已调出分配", tags = {"PIMDISTIRBUTION" } ,notes = "search已调出分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchydcfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchYDCFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDCFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YXFP-all')")
	@ApiOperation(value = "fetch可调动的分配(有效分配)", tags = {"PIMDISTIRBUTION" } ,notes = "fetch可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchyxfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchYXFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYXFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YXFP-all')")
	@ApiOperation(value = "search可调动的分配(有效分配)", tags = {"PIMDISTIRBUTION" } ,notes = "search可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchyxfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchYXFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZPCJFP-all')")
	@ApiOperation(value = "fetch招聘创建分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch招聘创建分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchzpcjfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchZPCJFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZPCJFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZPCJFP-all')")
	@ApiOperation(value = "search招聘创建分配", tags = {"PIMDISTIRBUTION" } ,notes = "search招聘创建分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchzpcjfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchZPCJFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZPCJFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDWQX-all')")
	@ApiOperation(value = "fetch原单位权限", tags = {"PIMDISTIRBUTION" } ,notes = "fetch原单位权限")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchydwqx")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchYDWQX(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDWQX(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDWQX-all')")
	@ApiOperation(value = "search原单位权限", tags = {"PIMDISTIRBUTION" } ,notes = "search原单位权限")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchydwqx")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchYDWQX(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDWQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQYXFP-all')")
	@ApiOperation(value = "fetch当前有效用户分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch当前有效用户分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdqyxfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchDQYXFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQYXFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQYXFP-all')")
	@ApiOperation(value = "search当前有效用户分配", tags = {"PIMDISTIRBUTION" } ,notes = "search当前有效用户分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdqyxfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchDQYXFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDRYHMC-all')")
	@ApiOperation(value = "fetch借调人员花名册", tags = {"PIMDISTIRBUTION" } ,notes = "fetch借调人员花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjdryhmc")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchJDRYHMC(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDRYHMC(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDRYHMC-all')")
	@ApiOperation(value = "search借调人员花名册", tags = {"PIMDISTIRBUTION" } ,notes = "search借调人员花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjdryhmc")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchJDRYHMC(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDDQ-all')")
	@ApiOperation(value = "fetch借调人员", tags = {"PIMDISTIRBUTION" } ,notes = "fetch借调人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjddq")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchJDDQ(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDDQ(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDDQ-all')")
	@ApiOperation(value = "search借调人员", tags = {"PIMDISTIRBUTION" } ,notes = "search借调人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjddq")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchJDDQ(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-EXPEREENCE-all')")
	@ApiOperation(value = "fetch是否主要经历（工作履历）", tags = {"PIMDISTIRBUTION" } ,notes = "fetch是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchexpereence")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchEXPEREENCE(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-EXPEREENCE-all')")
	@ApiOperation(value = "search是否主要经历（工作履历）", tags = {"PIMDISTIRBUTION" } ,notes = "search是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchexpereence")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchEXPEREENCE(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PIMDISTIRBUTION" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjlss")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchJLSS(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJLSS(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PIMDISTIRBUTION" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjlss")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchJLSS(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(分配信息)", tags = {"PIMDISTIRBUTION" } ,notes = "fetch自助(分配信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchzizhu")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchZIZHU(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZIZHU(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZIZHU-all')")
	@ApiOperation(value = "search自助(分配信息)", tags = {"PIMDISTIRBUTION" } ,notes = "search自助(分配信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchzizhu")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchZIZHU(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMDISTIRBUTION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdefault")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchDefault(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDefault(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMDISTIRBUTION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdefault")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchDefault(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQFP-all')")
	@ApiOperation(value = "fetch当前分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch当前分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdqfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchDQFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQFP-all')")
	@ApiOperation(value = "search当前分配", tags = {"PIMDISTIRBUTION" } ,notes = "search当前分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdqfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchDQFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-MobDefault-all')")
	@ApiOperation(value = "fetch移动端默认查询", tags = {"PIMDISTIRBUTION" } ,notes = "fetch移动端默认查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchmobdefault")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchMobDefault(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchMobDefault(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-MobDefault-all')")
	@ApiOperation(value = "search移动端默认查询", tags = {"PIMDISTIRBUTION" } ,notes = "search移动端默认查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchmobdefault")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchMobDefault(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchMobDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-KDDYXZFP-all')")
	@ApiOperation(value = "fetch可调动的有效主分配", tags = {"PIMDISTIRBUTION" } ,notes = "fetch可调动的有效主分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchkddyxzfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchKDDYXZFP(PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-KDDYXZFP-all')")
	@ApiOperation(value = "search可调动的有效主分配", tags = {"PIMDISTIRBUTION" } ,notes = "search可调动的有效主分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchkddyxzfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchKDDYXZFP(@RequestBody PIMDISTIRBUTIONSearchContext context) {
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#pimdistirbution_id,'Remove',{'Sql',this.pimdistirbutionMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.remove(pimdistirbution_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimdistirbutionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.checkKey(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission(#pimdistirbution_id,'Update',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pimdistirbutionService.update(domain);
        PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        List<PIMDISTIRBUTION> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PIMDISTIRBUTION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/getdraft")
    public ResponseEntity<PIMDISTIRBUTIONDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMDISTIRBUTION domain = new PIMDISTIRBUTION();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionMapping.toDto(pimdistirbutionService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DDCZC-all')")
    @ApiOperation(value = "调动出操作ByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "调动出操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/ddczc")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> dDCZCByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        domain = pimdistirbutionService.dDCZC(domain) ;
        pimdistirbutiondto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutiondto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        List<PIMDISTIRBUTION> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PIMDISTIRBUTION domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimdistirbutionMapping,#pimdistirbutiondto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions")
    @Transactional
    public ResponseEntity<PIMDISTIRBUTIONDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONDTO pimdistirbutiondto) {
        PIMDISTIRBUTION domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
		pimdistirbutionService.create(domain);
        PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMDISTIRBUTIONDTO> pimdistirbutiondtos) {
        List<PIMDISTIRBUTION> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PIMDISTIRBUTION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimdistirbution_id,'Get',{'Sql',this.pimdistirbutionMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMDISTIRBUTION" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    public ResponseEntity<PIMDISTIRBUTIONDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PIMDISTIRBUTION domain = pimdistirbutionService.get(pimdistirbution_id);
        PIMDISTIRBUTIONDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GBYXZFP-all')")
	@ApiOperation(value = "fetch干部可调动的分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch干部可调动的分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchgbyxzfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONGBYXZFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchGBYXZFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-GBYXZFP-all')")
	@ApiOperation(value = "search干部可调动的分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search干部可调动的分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchgbyxzfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONGBYXZFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchGBYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-LGTX-all')")
	@ApiOperation(value = "fetch轮岗查询ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch轮岗查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchlgtx")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONLGTXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchLGTX(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-LGTX-all')")
	@ApiOperation(value = "search轮岗查询ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search轮岗查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchlgtx")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONLGTXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchLGTX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ISOUTRECORD-all')")
	@ApiOperation(value = "fetch外单位履历为1的（支持增删改查）ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch外单位履历为1的（支持增删改查）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchisoutrecord")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONISOUTRECORDByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ISOUTRECORD-all')")
	@ApiOperation(value = "search外单位履历为1的（支持增删改查）ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search外单位履历为1的（支持增删改查）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchisoutrecord")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONISOUTRECORDByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDCFP-all')")
	@ApiOperation(value = "fetch已调出分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch已调出分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchydcfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONYDCFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDCFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDCFP-all')")
	@ApiOperation(value = "search已调出分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search已调出分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchydcfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONYDCFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDCFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YXFP-all')")
	@ApiOperation(value = "fetch可调动的分配(有效分配)ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch可调动的分配(有效分配)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchyxfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONYXFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYXFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YXFP-all')")
	@ApiOperation(value = "search可调动的分配(有效分配)ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search可调动的分配(有效分配)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchyxfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONYXFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZPCJFP-all')")
	@ApiOperation(value = "fetch招聘创建分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch招聘创建分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchzpcjfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONZPCJFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZPCJFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZPCJFP-all')")
	@ApiOperation(value = "search招聘创建分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search招聘创建分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchzpcjfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONZPCJFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZPCJFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDWQX-all')")
	@ApiOperation(value = "fetch原单位权限ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch原单位权限ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchydwqx")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONYDWQXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDWQX(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-YDWQX-all')")
	@ApiOperation(value = "search原单位权限ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search原单位权限ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchydwqx")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONYDWQXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchYDWQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQYXFP-all')")
	@ApiOperation(value = "fetch当前有效用户分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch当前有效用户分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdqyxfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONDQYXFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQYXFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQYXFP-all')")
	@ApiOperation(value = "search当前有效用户分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search当前有效用户分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdqyxfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONDQYXFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDRYHMC-all')")
	@ApiOperation(value = "fetch借调人员花名册ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch借调人员花名册ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjdryhmc")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONJDRYHMCByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDRYHMC(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDRYHMC-all')")
	@ApiOperation(value = "search借调人员花名册ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search借调人员花名册ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjdryhmc")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONJDRYHMCByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDDQ-all')")
	@ApiOperation(value = "fetch借调人员ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch借调人员ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjddq")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONJDDQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDDQ(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JDDQ-all')")
	@ApiOperation(value = "search借调人员ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search借调人员ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjddq")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONJDDQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJDDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-EXPEREENCE-all')")
	@ApiOperation(value = "fetch是否主要经历（工作履历）ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch是否主要经历（工作履历）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchexpereence")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONEXPEREENCEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-EXPEREENCE-all')")
	@ApiOperation(value = "search是否主要经历（工作履历）ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search是否主要经历（工作履历）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchexpereence")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONEXPEREENCEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjlss")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJLSS(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search记录所属和人员ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjlss")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(分配信息)ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch自助(分配信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchzizhu")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZIZHU(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-ZIZHU-all')")
	@ApiOperation(value = "search自助(分配信息)ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search自助(分配信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchzizhu")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdefault")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDefault(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdefault")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQFP-all')")
	@ApiOperation(value = "fetch当前分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch当前分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdqfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONDQFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-DQFP-all')")
	@ApiOperation(value = "search当前分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search当前分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdqfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONDQFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchDQFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-MobDefault-all')")
	@ApiOperation(value = "fetch移动端默认查询ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch移动端默认查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchmobdefault")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONMobDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchMobDefault(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-MobDefault-all')")
	@ApiOperation(value = "search移动端默认查询ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search移动端默认查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchmobdefault")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONMobDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchMobDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-KDDYXZFP-all')")
	@ApiOperation(value = "fetch可调动的有效主分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "fetch可调动的有效主分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchkddyxzfp")
	public ResponseEntity<List<PIMDISTIRBUTIONDTO>> fetchPIMDISTIRBUTIONKDDYXZFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
        List<PIMDISTIRBUTIONDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMDISTIRBUTION-KDDYXZFP-all')")
	@ApiOperation(value = "search可调动的有效主分配ByPIMPERSON", tags = {"PIMDISTIRBUTION" } ,notes = "search可调动的有效主分配ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchkddyxzfp")
	public ResponseEntity<Page<PIMDISTIRBUTIONDTO>> searchPIMDISTIRBUTIONKDDYXZFPByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMDISTIRBUTIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMDISTIRBUTION> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
