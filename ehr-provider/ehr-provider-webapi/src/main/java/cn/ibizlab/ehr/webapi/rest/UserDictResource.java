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
import cn.ibizlab.ehr.core.common.domain.UserDict;
import cn.ibizlab.ehr.core.common.service.IUserDictService;
import cn.ibizlab.ehr.core.common.filter.UserDictSearchContext;




@Slf4j
@Api(tags = {"UserDict" })
@RestController("WebApi-userdict")
@RequestMapping("")
public class UserDictResource {

    @Autowired
    private IUserDictService userdictService;

    @Autowired
    @Lazy
    private UserDictMapping userdictMapping;




    @PreAuthorize("hasPermission('Remove',{#userdict_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"UserDict" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdicts/{userdict_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userdict_id") String userdict_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userdictService.remove(userdict_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserDict" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdicts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userdictService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserDict" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserDictDTO userdictdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userdictService.checkKey(userdictMapping.toDomain(userdictdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserDict" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts")
    @Transactional
    public ResponseEntity<UserDictDTO> create(@RequestBody UserDictDTO userdictdto) {
        UserDict domain = userdictMapping.toDomain(userdictdto);
		userdictService.create(domain);
        UserDictDTO dto = userdictMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserDict" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserDictDTO> userdictdtos) {
        userdictService.createBatch(userdictMapping.toDomain(userdictdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserDict" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userdicts/getdraft")
    public ResponseEntity<UserDictDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userdictMapping.toDto(userdictService.getDraft(new UserDict())));
    }




    @ApiOperation(value = "重新加载当前用户词典", tags = {"UserDict" },  notes = "重新加载当前用户词典")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts/{userdict_id}/reloadcuruser")
    @Transactional
    public ResponseEntity<UserDictDTO> reloadCurUser(@PathVariable("userdict_id") String userdict_id, @RequestBody UserDictDTO userdictdto) {
        UserDict userdict = userdictMapping.toDomain(userdictdto);
        userdict = userdictService.reloadCurUser(userdict);
        userdictdto = userdictMapping.toDto(userdict);
        return ResponseEntity.status(HttpStatus.OK).body(userdictdto);
    }




    @PreAuthorize("hasPermission(#userdict_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserDict" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userdicts/{userdict_id}")
    public ResponseEntity<UserDictDTO> get(@PathVariable("userdict_id") String userdict_id) {
        UserDict domain = userdictService.get(userdict_id);
        UserDictDTO dto = userdictMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"UserDict" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts/save")
    public ResponseEntity<Boolean> save(@RequestBody UserDictDTO userdictdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userdictService.save(userdictMapping.toDomain(userdictdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserDict" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdicts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserDictDTO> userdictdtos) {
        userdictService.saveBatch(userdictMapping.toDomain(userdictdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userdict_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserDict" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdicts/{userdict_id}")
    @Transactional
    public ResponseEntity<UserDictDTO> update(@PathVariable("userdict_id") String userdict_id, @RequestBody UserDictDTO userdictdto) {
		UserDict domain = userdictMapping.toDomain(userdictdto);
        domain.setUserdictid(userdict_id);
		userdictService.update(domain);
		UserDictDTO dto = userdictMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userdict_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserDict" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdicts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserDictDTO> userdictdtos) {
        userdictService.updateBatch(userdictMapping.toDomain(userdictdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"UserDict" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userdicts/fetchdefault")
	public ResponseEntity<List<UserDictDTO>> fetchDefault(UserDictSearchContext context) {
        Page<UserDict> domains = userdictService.searchDefault(context) ;
        List<UserDictDTO> list = userdictMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"UserDict" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userdicts/searchdefault")
	public ResponseEntity<Page<UserDictDTO>> searchDefault(@RequestBody UserDictSearchContext context) {
        Page<UserDict> domains = userdictService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userdictMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserDict getEntity(){
        return new UserDict();
    }

}
