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
import cn.ibizlab.ehr.core.common.domain.UserDictItem;
import cn.ibizlab.ehr.core.common.service.IUserDictItemService;
import cn.ibizlab.ehr.core.common.filter.UserDictItemSearchContext;




@Slf4j
@Api(tags = {"UserDictItem" })
@RestController("WebApi-userdictitem")
@RequestMapping("")
public class UserDictItemResource {

    @Autowired
    private IUserDictItemService userdictitemService;

    @Autowired
    @Lazy
    private UserDictItemMapping userdictitemMapping;




    @PreAuthorize("hasPermission(#userdictitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserDictItem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdictitems/{userdictitem_id}")
    @Transactional
    public ResponseEntity<UserDictItemDTO> update(@PathVariable("userdictitem_id") String userdictitem_id, @RequestBody UserDictItemDTO userdictitemdto) {
		UserDictItem domain = userdictitemMapping.toDomain(userdictitemdto);
        domain.setUserdictitemid(userdictitem_id);
		userdictitemService.update(domain);
		UserDictItemDTO dto = userdictitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userdictitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserDictItem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdictitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserDictItemDTO> userdictitemdtos) {
        userdictitemService.updateBatch(userdictitemMapping.toDomain(userdictitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserDictItem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userdictitems/getdraft")
    public ResponseEntity<UserDictItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userdictitemMapping.toDto(userdictitemService.getDraft(new UserDictItem())));
    }




    @ApiOperation(value = "CheckKey", tags = {"UserDictItem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserDictItemDTO userdictitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userdictitemService.checkKey(userdictitemMapping.toDomain(userdictitemdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#userdictitem_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"UserDictItem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdictitems/{userdictitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userdictitem_id") String userdictitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userdictitemService.remove(userdictitem_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserDictItem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdictitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userdictitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userdictitem_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserDictItem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userdictitems/{userdictitem_id}")
    public ResponseEntity<UserDictItemDTO> get(@PathVariable("userdictitem_id") String userdictitem_id) {
        UserDictItem domain = userdictitemService.get(userdictitem_id);
        UserDictItemDTO dto = userdictitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"UserDictItem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictitems/save")
    public ResponseEntity<Boolean> save(@RequestBody UserDictItemDTO userdictitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userdictitemService.save(userdictitemMapping.toDomain(userdictitemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserDictItem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserDictItemDTO> userdictitemdtos) {
        userdictitemService.saveBatch(userdictitemMapping.toDomain(userdictitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserDictItem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictitems")
    @Transactional
    public ResponseEntity<UserDictItemDTO> create(@RequestBody UserDictItemDTO userdictitemdto) {
        UserDictItem domain = userdictitemMapping.toDomain(userdictitemdto);
		userdictitemService.create(domain);
        UserDictItemDTO dto = userdictitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserDictItem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdictitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserDictItemDTO> userdictitemdtos) {
        userdictitemService.createBatch(userdictitemMapping.toDomain(userdictitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"UserDictItem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userdictitems/fetchdefault")
	public ResponseEntity<List<UserDictItemDTO>> fetchDefault(UserDictItemSearchContext context) {
        Page<UserDictItem> domains = userdictitemService.searchDefault(context) ;
        List<UserDictItemDTO> list = userdictitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"UserDictItem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userdictitems/searchdefault")
	public ResponseEntity<Page<UserDictItemDTO>> searchDefault(@RequestBody UserDictItemSearchContext context) {
        Page<UserDictItem> domains = userdictitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userdictitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserDictItem getEntity(){
        return new UserDictItem();
    }

}
