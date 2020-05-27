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
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaDashboard;
import cn.ibizlab.ehr.core.r7rt_dyna.service.IDynaDashboardService;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaDashboardSearchContext;

@Slf4j
@Api(tags = {"DynaDashboard" })
@RestController("WebApi-dynadashboard")
@RequestMapping("")
public class DynaDashboardResource {

    @Autowired
    public IDynaDashboardService dynadashboardService;

    @Autowired
    @Lazy
    public DynaDashboardMapping dynadashboardMapping;

    @ApiOperation(value = "Save", tags = {"DynaDashboard" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/save")
    public ResponseEntity<Boolean> save(@RequestBody DynaDashboardDTO dynadashboarddto) {
        return ResponseEntity.status(HttpStatus.OK).body(dynadashboardService.save(dynadashboardMapping.toDomain(dynadashboarddto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DynaDashboard" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DynaDashboardDTO> dynadashboarddtos) {
        dynadashboardService.saveBatch(dynadashboardMapping.toDomain(dynadashboarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "Update", tags = {"DynaDashboard" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dynadashboards/{dynadashboard_id}")

    public ResponseEntity<DynaDashboardDTO> update(@PathVariable("dynadashboard_id") String dynadashboard_id, @RequestBody DynaDashboardDTO dynadashboarddto) {
		DynaDashboard domain  = dynadashboardMapping.toDomain(dynadashboarddto);
        domain .setDynadashboardid(dynadashboard_id);
		dynadashboardService.update(domain );
		DynaDashboardDTO dto = dynadashboardMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"DynaDashboard" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dynadashboards/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DynaDashboardDTO> dynadashboarddtos) {
        dynadashboardService.updateBatch(dynadashboardMapping.toDomain(dynadashboarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "Get", tags = {"DynaDashboard" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dynadashboards/{dynadashboard_id}")
    public ResponseEntity<DynaDashboardDTO> get(@PathVariable("dynadashboard_id") String dynadashboard_id) {
        DynaDashboard domain = dynadashboardService.get(dynadashboard_id);
        DynaDashboardDTO dto = dynadashboardMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "Remove", tags = {"DynaDashboard" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dynadashboards/{dynadashboard_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("dynadashboard_id") String dynadashboard_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dynadashboardService.remove(dynadashboard_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DynaDashboard" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dynadashboards/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dynadashboardService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"DynaDashboard" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DynaDashboardDTO dynadashboarddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dynadashboardService.checkKey(dynadashboardMapping.toDomain(dynadashboarddto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"DynaDashboard" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dynadashboards/getdraft")
    public ResponseEntity<DynaDashboardDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dynadashboardMapping.toDto(dynadashboardService.getDraft(new DynaDashboard())));
    }

    @ApiOperation(value = "Create", tags = {"DynaDashboard" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dynadashboards")

    public ResponseEntity<DynaDashboardDTO> create(@RequestBody DynaDashboardDTO dynadashboarddto) {
        DynaDashboard domain = dynadashboardMapping.toDomain(dynadashboarddto);
		dynadashboardService.create(domain);
        DynaDashboardDTO dto = dynadashboardMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"DynaDashboard" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dynadashboards/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DynaDashboardDTO> dynadashboarddtos) {
        dynadashboardService.createBatch(dynadashboardMapping.toDomain(dynadashboarddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DynaDashboard" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dynadashboards/fetchdefault")
	public ResponseEntity<List<DynaDashboardDTO>> fetchDefault(DynaDashboardSearchContext context) {
        Page<DynaDashboard> domains = dynadashboardService.searchDefault(context) ;
        List<DynaDashboardDTO> list = dynadashboardMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DynaDashboard" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dynadashboards/searchdefault")
	public ResponseEntity<Page<DynaDashboardDTO>> searchDefault(@RequestBody DynaDashboardSearchContext context) {
        Page<DynaDashboard> domains = dynadashboardService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dynadashboardMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

