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
import cn.ibizlab.ehr.core.common.domain.MsgAccountDetail;
import cn.ibizlab.ehr.core.common.service.IMsgAccountDetailService;
import cn.ibizlab.ehr.core.common.filter.MsgAccountDetailSearchContext;




@Slf4j
@Api(tags = {"MsgAccountDetail" })
@RestController("WebApi-msgaccountdetail")
@RequestMapping("")
public class MsgAccountDetailResource {

    @Autowired
    private IMsgAccountDetailService msgaccountdetailService;

    @Autowired
    @Lazy
    private MsgAccountDetailMapping msgaccountdetailMapping;




    @ApiOperation(value = "GetDraft", tags = {"MsgAccountDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/msgaccountdetails/getdraft")
    public ResponseEntity<MsgAccountDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(msgaccountdetailMapping.toDto(msgaccountdetailService.getDraft(new MsgAccountDetail())));
    }




    @PreAuthorize("hasPermission(#msgaccountdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"MsgAccountDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgaccountdetails/{msgaccountdetail_id}")
    @Transactional
    public ResponseEntity<MsgAccountDetailDTO> update(@PathVariable("msgaccountdetail_id") String msgaccountdetail_id, @RequestBody MsgAccountDetailDTO msgaccountdetaildto) {
		MsgAccountDetail domain = msgaccountdetailMapping.toDomain(msgaccountdetaildto);
        domain.setMsgaccountdetailid(msgaccountdetail_id);
		msgaccountdetailService.update(domain);
		MsgAccountDetailDTO dto = msgaccountdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#msgaccountdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"MsgAccountDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgaccountdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgAccountDetailDTO> msgaccountdetaildtos) {
        msgaccountdetailService.updateBatch(msgaccountdetailMapping.toDomain(msgaccountdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#msgaccountdetail_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"MsgAccountDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgaccountdetails/{msgaccountdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("msgaccountdetail_id") String msgaccountdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgaccountdetailService.remove(msgaccountdetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"MsgAccountDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgaccountdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgaccountdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"MsgAccountDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccountdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgAccountDetailDTO msgaccountdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgaccountdetailService.checkKey(msgaccountdetailMapping.toDomain(msgaccountdetaildto)));
    }




    @ApiOperation(value = "Save", tags = {"MsgAccountDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccountdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgAccountDetailDTO msgaccountdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgaccountdetailService.save(msgaccountdetailMapping.toDomain(msgaccountdetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"MsgAccountDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccountdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgAccountDetailDTO> msgaccountdetaildtos) {
        msgaccountdetailService.saveBatch(msgaccountdetailMapping.toDomain(msgaccountdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"MsgAccountDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccountdetails")
    @Transactional
    public ResponseEntity<MsgAccountDetailDTO> create(@RequestBody MsgAccountDetailDTO msgaccountdetaildto) {
        MsgAccountDetail domain = msgaccountdetailMapping.toDomain(msgaccountdetaildto);
		msgaccountdetailService.create(domain);
        MsgAccountDetailDTO dto = msgaccountdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"MsgAccountDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/msgaccountdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgAccountDetailDTO> msgaccountdetaildtos) {
        msgaccountdetailService.createBatch(msgaccountdetailMapping.toDomain(msgaccountdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#msgaccountdetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"MsgAccountDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/msgaccountdetails/{msgaccountdetail_id}")
    public ResponseEntity<MsgAccountDetailDTO> get(@PathVariable("msgaccountdetail_id") String msgaccountdetail_id) {
        MsgAccountDetail domain = msgaccountdetailService.get(msgaccountdetail_id);
        MsgAccountDetailDTO dto = msgaccountdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgAccountDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"MsgAccountDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgaccountdetails/fetchdefault")
	public ResponseEntity<List<MsgAccountDetailDTO>> fetchDefault(MsgAccountDetailSearchContext context) {
        Page<MsgAccountDetail> domains = msgaccountdetailService.searchDefault(context) ;
        List<MsgAccountDetailDTO> list = msgaccountdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-MsgAccountDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"MsgAccountDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgaccountdetails/searchdefault")
	public ResponseEntity<Page<MsgAccountDetailDTO>> searchDefault(@RequestBody MsgAccountDetailSearchContext context) {
        Page<MsgAccountDetail> domains = msgaccountdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgaccountdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public MsgAccountDetail getEntity(){
        return new MsgAccountDetail();
    }

}
