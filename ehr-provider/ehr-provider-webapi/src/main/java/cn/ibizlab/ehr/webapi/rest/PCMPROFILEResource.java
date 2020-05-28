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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESearchContext;

@Slf4j
@Api(tags = {"PCMPROFILE" })
@RestController("WebApi-pcmprofile")
@RequestMapping("")
public class PCMPROFILEResource {

    @Autowired
    public IPCMPROFILEService pcmprofileService;

    @Autowired
    @Lazy
    public PCMPROFILEMapping pcmprofileMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBTG-all')")
    @ApiOperation(value = "初审通过", tags = {"PCMPROFILE" },  notes = "初审通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jzbtg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jZBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jZBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-SBJZB-all')")
    @ApiOperation(value = "上报总部", tags = {"PCMPROFILE" },  notes = "上报总部")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/sbjzb")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> sBJZB(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sBJZB(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JSPBTG-all')")
    @ApiOperation(value = "审批不通过", tags = {"PCMPROFILE" },  notes = "审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jspbtg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jSPBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jSPBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-PrintSPB-all')")
    @ApiOperation(value = "打印审批表", tags = {"PCMPROFILE" },  notes = "打印审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/printspb")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> printSPB(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.printSPB(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-GetYPZNL-all')")
    @ApiOperation(value = "通过出生日期获取应聘者年龄", tags = {"PCMPROFILE" },  notes = "通过出生日期获取应聘者年龄")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/getypznl")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> getYPZNL(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.getYPZNL(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ClearPersonUpdateInfo-all')")
    @ApiOperation(value = "改变证件类型清空证件号码、出生日期、年龄、性别", tags = {"PCMPROFILE" },  notes = "改变证件类型清空证件号码、出生日期、年龄、性别")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/clearpersonupdateinfo")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> clearPersonUpdateInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearPersonUpdateInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledto),'ehr-PCMPROFILE-Save')")
    @ApiOperation(value = "Save", tags = {"PCMPROFILE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEDTO pcmprofiledto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.save(pcmprofileMapping.toDomain(pcmprofiledto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledtos),'ehr-PCMPROFILE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEDTO> pcmprofiledtos) {
        pcmprofileService.saveBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-Invalid2-all')")
    @ApiOperation(value = "公司董事长审批拒绝", tags = {"PCMPROFILE" },  notes = "公司董事长审批拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/invalid2")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> invalid2(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.invalid2(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BD-all')")
    @ApiOperation(value = "报到", tags = {"PCMPROFILE" },  notes = "报到")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/bd")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> bD(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.bD(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDTG-all')")
    @ApiOperation(value = "审核通过", tags = {"PCMPROFILE" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jldtg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jLDTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jLDTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-CheckYJSNF-all')")
    @ApiOperation(value = "检查毕业年份", tags = {"PCMPROFILE" },  notes = "检查毕业年份")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkyjsnf")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> checkYJSNF(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkYJSNF(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-GSSP-all')")
    @ApiOperation(value = "公司初审同意", tags = {"PCMPROFILE" },  notes = "公司初审同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/gssp")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> gSSP(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.gSSP(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-CheckEmail-all')")
    @ApiOperation(value = "检查邮箱", tags = {"PCMPROFILE" },  notes = "检查邮箱")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkemail")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> checkEmail(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkEmail(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-GetPcmprofileInfo-all')")
    @ApiOperation(value = "获取应聘者信息", tags = {"PCMPROFILE" },  notes = "获取应聘者信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/getpcmprofileinfo")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> getPcmprofileInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.getPcmprofileInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledto),'ehr-PCMPROFILE-Create')")
    @ApiOperation(value = "Create", tags = {"PCMPROFILE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> create(@RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE domain = pcmprofileMapping.toDomain(pcmprofiledto);
		pcmprofileService.create(domain);
        PCMPROFILEDTO dto = pcmprofileMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledtos),'ehr-PCMPROFILE-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMPROFILE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEDTO> pcmprofiledtos) {
        pcmprofileService.createBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.get(#pcmprofile_id),'ehr-PCMPROFILE-Update')")
    @ApiOperation(value = "Update", tags = {"PCMPROFILE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> update(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
		PCMPROFILE domain  = pcmprofileMapping.toDomain(pcmprofiledto);
        domain .setPcmprofileid(pcmprofile_id);
		pcmprofileService.update(domain );
		PCMPROFILEDTO dto = pcmprofileMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.getPcmprofileByEntities(this.pcmprofileMapping.toDomain(#pcmprofiledtos)),'ehr-PCMPROFILE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEDTO> pcmprofiledtos) {
        pcmprofileService.updateBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ReturnYPZ-all')")
    @ApiOperation(value = "失效", tags = {"PCMPROFILE" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/returnypz")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> returnYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.returnYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PostAuthorize("hasPermission(this.pcmprofileMapping.toDomain(returnObject.body),'ehr-PCMPROFILE-Get')")
    @ApiOperation(value = "Get", tags = {"PCMPROFILE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}")
    public ResponseEntity<PCMPROFILEDTO> get(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMPROFILE domain = pcmprofileService.get(pcmprofile_id);
        PCMPROFILEDTO dto = pcmprofileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-CheckYglxIsChanged-all')")
    @ApiOperation(value = "检查申报类型是否改变", tags = {"PCMPROFILE" },  notes = "检查申报类型是否改变")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkyglxischanged")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> checkYglxIsChanged(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkYglxIsChanged(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-SX-all')")
    @ApiOperation(value = "生效", tags = {"PCMPROFILE" },  notes = "生效")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/sx")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> sX(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sX(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEDTO pcmprofiledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.checkKey(pcmprofileMapping.toDomain(pcmprofiledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-Invalid-all')")
    @ApiOperation(value = "公司初审拒绝", tags = {"PCMPROFILE" },  notes = "公司初审拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/invalid")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> invalid(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.invalid(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBBTG-all')")
    @ApiOperation(value = "初审不通过", tags = {"PCMPROFILE" },  notes = "初审不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jzbbtg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jZBBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jZBBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ClearYPZ-all')")
    @ApiOperation(value = "清空应聘者信息", tags = {"PCMPROFILE" },  notes = "清空应聘者信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/clearypz")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> clearYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-CheckFP-all')")
    @ApiOperation(value = "检查返聘", tags = {"PCMPROFILE" },  notes = "检查返聘")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkfp")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> checkFP(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkFP(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-SCBH-all')")
    @ApiOperation(value = "生成编号", tags = {"PCMPROFILE" },  notes = "生成编号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/scbh")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> sCBH(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sCBH(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/getdraft")
    public ResponseEntity<PCMPROFILEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileMapping.toDto(pcmprofileService.getDraft(new PCMPROFILE())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ClearYYDJMC-all')")
    @ApiOperation(value = "清空语言等级名称", tags = {"PCMPROFILE" },  notes = "清空语言等级名称")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/clearyydjmc")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> clearYYDJMC(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearYYDJMC(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-Submit-all')")
    @ApiOperation(value = "提交", tags = {"PCMPROFILE" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/submit")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> submit(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.submit(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-PersonUpdateInfo-all')")
    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"PCMPROFILE" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/personupdateinfo")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> personUpdateInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.personUpdateInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-GSCS-all')")
    @ApiOperation(value = "公司董事长同意", tags = {"PCMPROFILE" },  notes = "公司董事长同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/gscs")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> gSCS(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.gSCS(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-FillingYPZ-all')")
    @ApiOperation(value = "获取人员信息填充应聘者", tags = {"PCMPROFILE" },  notes = "获取人员信息填充应聘者")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/fillingypz")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> fillingYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.fillingYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YQWBD-all')")
    @ApiOperation(value = "逾期未报到", tags = {"PCMPROFILE" },  notes = "逾期未报到")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/yqwbd")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> yQWBD(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.yQWBD(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-USEYBH-all')")
    @ApiOperation(value = "使用原编号", tags = {"PCMPROFILE" },  notes = "使用原编号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/useybh")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> uSEYBH(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.uSEYBH(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-CheckMobieNumber-all')")
    @ApiOperation(value = "检查手机号", tags = {"PCMPROFILE" },  notes = "检查手机号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkmobienumber")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> checkMobieNumber(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkMobieNumber(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.get(#pcmprofile_id),'ehr-PCMPROFILE-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofile_id") String pcmprofile_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.remove(pcmprofile_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.getPcmprofileByIds(#ids),'ehr-PCMPROFILE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PCMPROFILE" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jldbtg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jLDBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jLDBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JSPTG-all')")
    @ApiOperation(value = "审批通过", tags = {"PCMPROFILE" },  notes = "审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jsptg")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> jSPTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jSPTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-SetNQDLDHTQX-all')")
    @ApiOperation(value = "设置拟签订劳动合同期限", tags = {"PCMPROFILE" },  notes = "设置拟签订劳动合同期限")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/setnqdldhtqx")
    @Transactional
    public ResponseEntity<PCMPROFILEDTO> setNQDLDHTQX(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEDTO pcmprofiledto) {
        PCMPROFILE pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.setNQDLDHTQX(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YRDWSH_CSRCYJ-all')")
	@ApiOperation(value = "fetch用人单位董事长审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch用人单位董事长审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchyrdwsh_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchYRDWSH_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYRDWSH_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YRDWSH_CSRCYJ-all')")
	@ApiOperation(value = "search用人单位董事长审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search用人单位董事长审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchyrdwsh_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchYRDWSH_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYRDWSH_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDSP-all')")
	@ApiOperation(value = "fetch局总部审核（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch局总部审核（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjldsp")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchJLDSP(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJLDSP(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDSP-all')")
	@ApiOperation(value = "search局总部审核（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search局总部审核（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjldsp")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchJLDSP(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJLDSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BD_CSRCYJ-all')")
	@ApiOperation(value = "fetch报到（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch报到（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbd_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchBD_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBD_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BD_CSRCYJ-all')")
	@ApiOperation(value = "search报到（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search报到（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbd_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchBD_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBD_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YPZSPB_CSRCYJ-all')")
	@ApiOperation(value = "fetch应聘者审批表（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch应聘者审批表（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchypzspb_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchYPZSPB_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYPZSPB_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YPZSPB_CSRCYJ-all')")
	@ApiOperation(value = "search应聘者审批表（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search应聘者审批表（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchypzspb_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchYPZSPB_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYPZSPB_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ZPDWSH-all')")
	@ApiOperation(value = "fetch用人单位初审（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch用人单位初审（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchzpdwsh")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchZPDWSH(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchZPDWSH(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-ZPDWSH-all')")
	@ApiOperation(value = "search用人单位初审（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search用人单位初审（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchzpdwsh")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchZPDWSH(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchZPDWSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BD-all')")
	@ApiOperation(value = "fetch报到（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch报到（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbd")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchBD(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBD(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BD-all')")
	@ApiOperation(value = "search报到（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search报到（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbd")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchBD(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BHSP-all')")
	@ApiOperation(value = "fetch编号审批（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch编号审批（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbhsp")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchBHSP(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBHSP(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BHSP-all')")
	@ApiOperation(value = "search编号审批（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search编号审批（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbhsp")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchBHSP(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBHSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-LR-all')")
	@ApiOperation(value = "fetch录入（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch录入（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchlr")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchLR(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchLR(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-LR-all')")
	@ApiOperation(value = "search录入（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search录入（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchlr")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchLR(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchLR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RLSB-all')")
	@ApiOperation(value = "fetch人力上报（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch人力上报（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrlsb")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchRLSB(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRLSB(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RLSB-all')")
	@ApiOperation(value = "search人力上报（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search人力上报（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrlsb")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchRLSB(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRLSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-FormType-all')")
	@ApiOperation(value = "fetchFormType", tags = {"PCMPROFILE" } ,notes = "fetchFormType")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchformtype")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchFormType(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchFormType(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-FormType-all')")
	@ApiOperation(value = "searchFormType", tags = {"PCMPROFILE" } ,notes = "searchFormType")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchformtype")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchFormType(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-HTRY_CSRCYJ-all')")
	@ApiOperation(value = "fetch回退人员（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch回退人员（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchhtry_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchHTRY_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchHTRY_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-HTRY_CSRCYJ-all')")
	@ApiOperation(value = "search回退人员（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search回退人员（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchhtry_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchHTRY_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchHTRY_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchdefault")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchDefault(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchDefault(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchdefault")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchDefault(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBSP-all')")
	@ApiOperation(value = "fetch局总部审批（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch局总部审批（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjzbsp")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchJZBSP(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJZBSP(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBSP-all')")
	@ApiOperation(value = "search局总部审批（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search局总部审批（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjzbsp")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchJZBSP(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RZSP_CSRCYJ-all')")
	@ApiOperation(value = "fetch局总部初审（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch局总部初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrzsp_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchRZSP_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRZSP_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RZSP_CSRCYJ-all')")
	@ApiOperation(value = "search局总部初审（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search局总部初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrzsp_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchRZSP_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRZSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDSP_CSRCYJ-all')")
	@ApiOperation(value = "fetch局总部审核（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch局总部审核（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjldsp_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchJLDSP_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJLDSP_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JLDSP_CSRCYJ-all')")
	@ApiOperation(value = "search局总部审核（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search局总部审核（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjldsp_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchJLDSP_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJLDSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BHSP_CSRCYJ-all')")
	@ApiOperation(value = "fetch编号审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch编号审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbhsp_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchBHSP_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBHSP_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-BHSP_CSRCYJ-all')")
	@ApiOperation(value = "search编号审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search编号审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbhsp_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchBHSP_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchBHSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-LR_CSRCYJ-all')")
	@ApiOperation(value = "fetch录入（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch录入（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchlr_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchLR_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchLR_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-LR_CSRCYJ-all')")
	@ApiOperation(value = "search录入（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search录入（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchlr_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchLR_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchLR_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YPZBB_READ-all')")
	@ApiOperation(value = "fetch应聘者查询", tags = {"PCMPROFILE" } ,notes = "fetch应聘者查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchypzbb_read")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchYPZBB_READ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYPZBB_READ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YPZBB_READ-all')")
	@ApiOperation(value = "search应聘者查询", tags = {"PCMPROFILE" } ,notes = "search应聘者查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchypzbb_read")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchYPZBB_READ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYPZBB_READ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-HTRY-all')")
	@ApiOperation(value = "fetch回退人员（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch回退人员（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchhtry")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchHTRY(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchHTRY(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-HTRY-all')")
	@ApiOperation(value = "search回退人员（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search回退人员（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchhtry")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchHTRY(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RZSP-all')")
	@ApiOperation(value = "fetch局总部初审（校园招聘）", tags = {"PCMPROFILE" } ,notes = "fetch局总部初审（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrzsp")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchRZSP(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRZSP(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RZSP-all')")
	@ApiOperation(value = "search局总部初审（校园招聘）", tags = {"PCMPROFILE" } ,notes = "search局总部初审（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrzsp")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchRZSP(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRZSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YRDWCS_CSRCYJ-all')")
	@ApiOperation(value = "fetch用人单位初审（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch用人单位初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchyrdwcs_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchYRDWCS_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYRDWCS_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-YRDWCS_CSRCYJ-all')")
	@ApiOperation(value = "search用人单位初审（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search用人单位初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchyrdwcs_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchYRDWCS_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchYRDWCS_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBSP_CSRCYJ-all')")
	@ApiOperation(value = "fetch局总部审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch局总部审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjzbsp_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchJZBSP_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJZBSP_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-JZBSP_CSRCYJ-all')")
	@ApiOperation(value = "search局总部审批（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search局总部审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjzbsp_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchJZBSP_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchJZBSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RLSB_CSRCYJ-all')")
	@ApiOperation(value = "fetch人力上报（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "fetch人力上报（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrlsb_csrcyj")
	public ResponseEntity<List<PCMPROFILEDTO>> fetchRLSB_CSRCYJ(PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRLSB_CSRCYJ(context) ;
        List<PCMPROFILEDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILE-RLSB_CSRCYJ-all')")
	@ApiOperation(value = "search人力上报（成熟人才引进）", tags = {"PCMPROFILE" } ,notes = "search人力上报（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrlsb_csrcyj")
	public ResponseEntity<Page<PCMPROFILEDTO>> searchRLSB_CSRCYJ(@RequestBody PCMPROFILESearchContext context) {
        Page<PCMPROFILE> domains = pcmprofileService.searchRLSB_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

