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
import cn.ibizlab.ehr.core.common.domain.MsgAccount;
import cn.ibizlab.ehr.core.common.service.IMsgAccountService;
import cn.ibizlab.ehr.core.common.filter.MsgAccountSearchContext;




@Slf4j
@Api(tags = {"MsgAccount" })
@RestController("WebApi-msgaccount")
@RequestMapping("")
public class MsgAccountResource {

    @Autowired
    private IMsgAccountService msgaccountService;

    @Autowired
    @Lazy
    private MsgAccountMapping msgaccountMapping;




    @PreAuthorize("hasPermission(#msgaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"MsgAccount" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgaccounts/{msgaccount_id}")
    @Transactional
    public ResponseEntity<MsgAccountDTO> update(@PathVariable("msgaccount_id") String msgaccount_id, @RequestBody MsgAccountDTO msgaccountdto) {
		MsgAccount domain = msgaccountMapping.toDomain(msgaccountdto);
        domain.setMsgaccountid(msgaccount_id);
		msgaccountService.update(domain);
		MsgAccountDTO dto = msgaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#msgaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"MsgAccount" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgAccountDTO> msgaccountdtos) {
        msgaccountService.updateBatch(msgaccountMapping.toDomain(msgaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#msgaccount_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"MsgAccount" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgaccounts/{msgaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("msgaccount_id") String msgaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgaccountService.remove(msgaccount_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"MsgAccount" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"MsgAccount" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgAccountDTO msgaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgaccountService.save(msgaccountMapping.toDomain(msgaccountdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"MsgAccount" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgAccountDTO> msgaccountdtos) {
        msgaccountService.saveBatch(msgaccountMapping.toDomain(msgaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"MsgAccount" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgAccountDTO msgaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgaccountService.checkKey(msgaccountMapping.toDomain(msgaccountdto)));
    }




    @PreAuthorize("hasPermission(#msgaccount_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"MsgAccount" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/msgaccounts/{msgaccount_id}")
    public ResponseEntity<MsgAccountDTO> get(@PathVariable("msgaccount_id") String msgaccount_id) {
        MsgAccount domain = msgaccountService.get(msgaccount_id);
        MsgAccountDTO dto = msgaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"MsgAccount" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/msgaccounts/getdraft")
    public ResponseEntity<MsgAccountDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(msgaccountMapping.toDto(msgaccountService.getDraft(new MsgAccount())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"MsgAccount" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccounts")
    @Transactional
    public ResponseEntity<MsgAccountDTO> create(@RequestBody MsgAccountDTO msgaccountdto) {
        MsgAccount domain = msgaccountMapping.toDomain(msgaccountdto);
		msgaccountService.create(domain);
        MsgAccountDTO dto = msgaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"MsgAccount" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgAccountDTO> msgaccountdtos) {
        msgaccountService.createBatch(msgaccountMapping.toDomain(msgaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"MsgAccount" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgaccounts/fetchdefault")
	public ResponseEntity<List<MsgAccountDTO>> fetchDefault(MsgAccountSearchContext context) {
        Page<MsgAccount> domains = msgaccountService.searchDefault(context) ;
        List<MsgAccountDTO> list = msgaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"MsgAccount" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgaccounts/searchdefault")
	public ResponseEntity<Page<MsgAccountDTO>> searchDefault(@RequestBody MsgAccountSearchContext context) {
        Page<MsgAccount> domains = msgaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public MsgAccount getEntity(){
        return new MsgAccount();
    }

}
