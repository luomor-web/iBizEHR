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
import cn.ibizlab.ehr.core.common.domain.UserDictCat;
import cn.ibizlab.ehr.core.common.service.IUserDictCatService;
import cn.ibizlab.ehr.core.common.filter.UserDictCatSearchContext;




@Slf4j
@Api(tags = {"UserDictCat" })
@RestController("WebApi-userdictcat")
@RequestMapping("")
public class UserDictCatResource {

    @Autowired
    private IUserDictCatService userdictcatService;

    @Autowired
    @Lazy
    private UserDictCatMapping userdictcatMapping;




    @ApiOperation(value = "Save", tags = {"UserDictCat" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictcats/save")
    public ResponseEntity<Boolean> save(@RequestBody UserDictCatDTO userdictcatdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userdictcatService.save(userdictcatMapping.toDomain(userdictcatdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserDictCat" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictcats/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserDictCatDTO> userdictcatdtos) {
        userdictcatService.saveBatch(userdictcatMapping.toDomain(userdictcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userdictcat_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserDictCat" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userdictcats/{userdictcat_id}")
    public ResponseEntity<UserDictCatDTO> get(@PathVariable("userdictcat_id") String userdictcat_id) {
        UserDictCat domain = userdictcatService.get(userdictcat_id);
        UserDictCatDTO dto = userdictcatMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserDictCat" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictcats/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserDictCatDTO userdictcatdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userdictcatService.checkKey(userdictcatMapping.toDomain(userdictcatdto)));
    }




    @PreAuthorize("hasPermission(#userdictcat_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserDictCat" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdictcats/{userdictcat_id}")
    @Transactional
    public ResponseEntity<UserDictCatDTO> update(@PathVariable("userdictcat_id") String userdictcat_id, @RequestBody UserDictCatDTO userdictcatdto) {
		UserDictCat domain = userdictcatMapping.toDomain(userdictcatdto);
        domain.setUserdictcatid(userdictcat_id);
		userdictcatService.update(domain);
		UserDictCatDTO dto = userdictcatMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userdictcat_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserDictCat" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdictcats/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserDictCatDTO> userdictcatdtos) {
        userdictcatService.updateBatch(userdictcatMapping.toDomain(userdictcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userdictcat_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"UserDictCat" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdictcats/{userdictcat_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userdictcat_id") String userdictcat_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userdictcatService.remove(userdictcat_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserDictCat" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdictcats/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userdictcatService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserDictCat" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userdictcats/getdraft")
    public ResponseEntity<UserDictCatDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userdictcatMapping.toDto(userdictcatService.getDraft(new UserDictCat())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserDictCat" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictcats")
    @Transactional
    public ResponseEntity<UserDictCatDTO> create(@RequestBody UserDictCatDTO userdictcatdto) {
        UserDictCat domain = userdictcatMapping.toDomain(userdictcatdto);
		userdictcatService.create(domain);
        UserDictCatDTO dto = userdictcatMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserDictCat" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictcats/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserDictCatDTO> userdictcatdtos) {
        userdictcatService.createBatch(userdictcatMapping.toDomain(userdictcatdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDictCat-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserDictCat" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userdictcats/fetchdefault")
	public ResponseEntity<List<UserDictCatDTO>> fetchDefault(UserDictCatSearchContext context) {
        Page<UserDictCat> domains = userdictcatService.searchDefault(context) ;
        List<UserDictCatDTO> list = userdictcatMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDictCat-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserDictCat" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userdictcats/searchdefault")
	public ResponseEntity<Page<UserDictCatDTO>> searchDefault(@RequestBody UserDictCatSearchContext context) {
        Page<UserDictCat> domains = userdictcatService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userdictcatMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserDictCat getEntity(){
        return new UserDictCat();
    }

}
