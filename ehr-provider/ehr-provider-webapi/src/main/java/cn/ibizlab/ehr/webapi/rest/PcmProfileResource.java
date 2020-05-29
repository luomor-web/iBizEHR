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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileSearchContext;

@Slf4j
@Api(tags = {"应聘者基本信息" })
@RestController("WebApi-pcmprofile")
@RequestMapping("")
public class PcmProfileResource {

    @Autowired
    public IPcmProfileService pcmprofileService;

    @Autowired
    @Lazy
    public PcmProfileMapping pcmprofileMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBTG-all')")
    @ApiOperation(value = "初审通过", tags = {"应聘者基本信息" },  notes = "初审通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jzbtg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jZBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jZBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-SBJZB-all')")
    @ApiOperation(value = "上报总部", tags = {"应聘者基本信息" },  notes = "上报总部")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/sbjzb")
    @Transactional
    public ResponseEntity<PcmProfileDTO> sBJZB(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sBJZB(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JSPBTG-all')")
    @ApiOperation(value = "审批不通过", tags = {"应聘者基本信息" },  notes = "审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jspbtg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jSPBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jSPBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-PrintSPB-all')")
    @ApiOperation(value = "打印审批表", tags = {"应聘者基本信息" },  notes = "打印审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/printspb")
    @Transactional
    public ResponseEntity<PcmProfileDTO> printSPB(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.printSPB(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-GetYPZNL-all')")
    @ApiOperation(value = "通过出生日期获取应聘者年龄", tags = {"应聘者基本信息" },  notes = "通过出生日期获取应聘者年龄")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/getypznl")
    @Transactional
    public ResponseEntity<PcmProfileDTO> getYPZNL(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.getYPZNL(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ClearPersonUpdateInfo-all')")
    @ApiOperation(value = "改变证件类型清空证件号码、出生日期、年龄、性别", tags = {"应聘者基本信息" },  notes = "改变证件类型清空证件号码、出生日期、年龄、性别")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/clearpersonupdateinfo")
    @Transactional
    public ResponseEntity<PcmProfileDTO> clearPersonUpdateInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearPersonUpdateInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledto),'ehr-PcmProfile-Save')")
    @ApiOperation(value = "保存应聘者基本信息", tags = {"应聘者基本信息" },  notes = "保存应聘者基本信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileDTO pcmprofiledto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.save(pcmprofileMapping.toDomain(pcmprofiledto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledtos),'ehr-PcmProfile-Save')")
    @ApiOperation(value = "批量保存应聘者基本信息", tags = {"应聘者基本信息" },  notes = "批量保存应聘者基本信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileDTO> pcmprofiledtos) {
        pcmprofileService.saveBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-Invalid2-all')")
    @ApiOperation(value = "公司董事长审批拒绝", tags = {"应聘者基本信息" },  notes = "公司董事长审批拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/invalid2")
    @Transactional
    public ResponseEntity<PcmProfileDTO> invalid2(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.invalid2(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BD-all')")
    @ApiOperation(value = "报到", tags = {"应聘者基本信息" },  notes = "报到")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/bd")
    @Transactional
    public ResponseEntity<PcmProfileDTO> bD(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.bD(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDTG-all')")
    @ApiOperation(value = "审核通过", tags = {"应聘者基本信息" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jldtg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jLDTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jLDTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-CheckYJSNF-all')")
    @ApiOperation(value = "检查毕业年份", tags = {"应聘者基本信息" },  notes = "检查毕业年份")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkyjsnf")
    @Transactional
    public ResponseEntity<PcmProfileDTO> checkYJSNF(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkYJSNF(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-GSSP-all')")
    @ApiOperation(value = "公司初审同意", tags = {"应聘者基本信息" },  notes = "公司初审同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/gssp")
    @Transactional
    public ResponseEntity<PcmProfileDTO> gSSP(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.gSSP(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-CheckEmail-all')")
    @ApiOperation(value = "检查邮箱", tags = {"应聘者基本信息" },  notes = "检查邮箱")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkemail")
    @Transactional
    public ResponseEntity<PcmProfileDTO> checkEmail(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkEmail(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-GetPcmprofileInfo-all')")
    @ApiOperation(value = "获取应聘者信息", tags = {"应聘者基本信息" },  notes = "获取应聘者信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/getpcmprofileinfo")
    @Transactional
    public ResponseEntity<PcmProfileDTO> getPcmprofileInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.getPcmprofileInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledto),'ehr-PcmProfile-Create')")
    @ApiOperation(value = "新建应聘者基本信息", tags = {"应聘者基本信息" },  notes = "新建应聘者基本信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles")
    @Transactional
    public ResponseEntity<PcmProfileDTO> create(@RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile domain = pcmprofileMapping.toDomain(pcmprofiledto);
		pcmprofileService.create(domain);
        PcmProfileDTO dto = pcmprofileMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileMapping.toDomain(#pcmprofiledtos),'ehr-PcmProfile-Create')")
    @ApiOperation(value = "批量新建应聘者基本信息", tags = {"应聘者基本信息" },  notes = "批量新建应聘者基本信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileDTO> pcmprofiledtos) {
        pcmprofileService.createBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.get(#pcmprofile_id),'ehr-PcmProfile-Update')")
    @ApiOperation(value = "更新应聘者基本信息", tags = {"应聘者基本信息" },  notes = "更新应聘者基本信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}")
    @Transactional
    public ResponseEntity<PcmProfileDTO> update(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
		PcmProfile domain  = pcmprofileMapping.toDomain(pcmprofiledto);
        domain .setPcmprofileid(pcmprofile_id);
		pcmprofileService.update(domain );
		PcmProfileDTO dto = pcmprofileMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.getPcmprofileByEntities(this.pcmprofileMapping.toDomain(#pcmprofiledtos)),'ehr-PcmProfile-Update')")
    @ApiOperation(value = "批量更新应聘者基本信息", tags = {"应聘者基本信息" },  notes = "批量更新应聘者基本信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileDTO> pcmprofiledtos) {
        pcmprofileService.updateBatch(pcmprofileMapping.toDomain(pcmprofiledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ReturnYPZ-all')")
    @ApiOperation(value = "失效", tags = {"应聘者基本信息" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/returnypz")
    @Transactional
    public ResponseEntity<PcmProfileDTO> returnYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.returnYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PostAuthorize("hasPermission(this.pcmprofileMapping.toDomain(returnObject.body),'ehr-PcmProfile-Get')")
    @ApiOperation(value = "获取应聘者基本信息", tags = {"应聘者基本信息" },  notes = "获取应聘者基本信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}")
    public ResponseEntity<PcmProfileDTO> get(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmProfile domain = pcmprofileService.get(pcmprofile_id);
        PcmProfileDTO dto = pcmprofileMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-CheckYglxIsChanged-all')")
    @ApiOperation(value = "检查申报类型是否改变", tags = {"应聘者基本信息" },  notes = "检查申报类型是否改变")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkyglxischanged")
    @Transactional
    public ResponseEntity<PcmProfileDTO> checkYglxIsChanged(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkYglxIsChanged(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-SX-all')")
    @ApiOperation(value = "生效", tags = {"应聘者基本信息" },  notes = "生效")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/sx")
    @Transactional
    public ResponseEntity<PcmProfileDTO> sX(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sX(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @ApiOperation(value = "检查应聘者基本信息", tags = {"应聘者基本信息" },  notes = "检查应聘者基本信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileDTO pcmprofiledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.checkKey(pcmprofileMapping.toDomain(pcmprofiledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-Invalid-all')")
    @ApiOperation(value = "公司初审拒绝", tags = {"应聘者基本信息" },  notes = "公司初审拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/invalid")
    @Transactional
    public ResponseEntity<PcmProfileDTO> invalid(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.invalid(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBBTG-all')")
    @ApiOperation(value = "初审不通过", tags = {"应聘者基本信息" },  notes = "初审不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jzbbtg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jZBBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jZBBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ClearYPZ-all')")
    @ApiOperation(value = "清空应聘者信息", tags = {"应聘者基本信息" },  notes = "清空应聘者信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/clearypz")
    @Transactional
    public ResponseEntity<PcmProfileDTO> clearYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-CheckFP-all')")
    @ApiOperation(value = "检查返聘", tags = {"应聘者基本信息" },  notes = "检查返聘")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkfp")
    @Transactional
    public ResponseEntity<PcmProfileDTO> checkFP(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkFP(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-SCBH-all')")
    @ApiOperation(value = "生成编号", tags = {"应聘者基本信息" },  notes = "生成编号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/scbh")
    @Transactional
    public ResponseEntity<PcmProfileDTO> sCBH(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.sCBH(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @ApiOperation(value = "获取应聘者基本信息草稿", tags = {"应聘者基本信息" },  notes = "获取应聘者基本信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/getdraft")
    public ResponseEntity<PcmProfileDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileMapping.toDto(pcmprofileService.getDraft(new PcmProfile())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ClearYYDJMC-all')")
    @ApiOperation(value = "清空语言等级名称", tags = {"应聘者基本信息" },  notes = "清空语言等级名称")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/clearyydjmc")
    @Transactional
    public ResponseEntity<PcmProfileDTO> clearYYDJMC(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.clearYYDJMC(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-Submit-all')")
    @ApiOperation(value = "提交", tags = {"应聘者基本信息" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/submit")
    @Transactional
    public ResponseEntity<PcmProfileDTO> submit(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.submit(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-PersonUpdateInfo-all')")
    @ApiOperation(value = "根据证件号更改出生日期、性别、年龄", tags = {"应聘者基本信息" },  notes = "根据证件号更改出生日期、性别、年龄")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/personupdateinfo")
    @Transactional
    public ResponseEntity<PcmProfileDTO> personUpdateInfo(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.personUpdateInfo(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-GSCS-all')")
    @ApiOperation(value = "公司董事长同意", tags = {"应聘者基本信息" },  notes = "公司董事长同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/gscs")
    @Transactional
    public ResponseEntity<PcmProfileDTO> gSCS(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.gSCS(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-FillingYPZ-all')")
    @ApiOperation(value = "获取人员信息填充应聘者", tags = {"应聘者基本信息" },  notes = "获取人员信息填充应聘者")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/fillingypz")
    @Transactional
    public ResponseEntity<PcmProfileDTO> fillingYPZ(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.fillingYPZ(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YQWBD-all')")
    @ApiOperation(value = "逾期未报到", tags = {"应聘者基本信息" },  notes = "逾期未报到")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/yqwbd")
    @Transactional
    public ResponseEntity<PcmProfileDTO> yQWBD(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.yQWBD(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-USEYBH-all')")
    @ApiOperation(value = "使用原编号", tags = {"应聘者基本信息" },  notes = "使用原编号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/useybh")
    @Transactional
    public ResponseEntity<PcmProfileDTO> uSEYBH(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.uSEYBH(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-CheckMobieNumber-all')")
    @ApiOperation(value = "检查手机号", tags = {"应聘者基本信息" },  notes = "检查手机号")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/checkmobienumber")
    @Transactional
    public ResponseEntity<PcmProfileDTO> checkMobieNumber(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.checkMobieNumber(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.get(#pcmprofile_id),'ehr-PcmProfile-Remove')")
    @ApiOperation(value = "删除应聘者基本信息", tags = {"应聘者基本信息" },  notes = "删除应聘者基本信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofile_id") String pcmprofile_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileService.remove(pcmprofile_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileService.getPcmprofileByIds(#ids),'ehr-PcmProfile-Remove')")
    @ApiOperation(value = "批量删除应聘者基本信息", tags = {"应聘者基本信息" },  notes = "批量删除应聘者基本信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"应聘者基本信息" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jldbtg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jLDBTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jLDBTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JSPTG-all')")
    @ApiOperation(value = "审批通过", tags = {"应聘者基本信息" },  notes = "审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/jsptg")
    @Transactional
    public ResponseEntity<PcmProfileDTO> jSPTG(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.jSPTG(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-SetNQDLDHTQX-all')")
    @ApiOperation(value = "设置拟签订劳动合同期限", tags = {"应聘者基本信息" },  notes = "设置拟签订劳动合同期限")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/setnqdldhtqx")
    @Transactional
    public ResponseEntity<PcmProfileDTO> setNQDLDHTQX(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmProfileDTO pcmprofiledto) {
        PcmProfile pcmprofile = pcmprofileMapping.toDomain(pcmprofiledto);
        pcmprofile.setPcmprofileid(pcmprofile_id);
        pcmprofile = pcmprofileService.setNQDLDHTQX(pcmprofile);
        pcmprofiledto = pcmprofileMapping.toDto(pcmprofile);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofiledto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YRDWSH_CSRCYJ-all')")
	@ApiOperation(value = "获取用人单位董事长审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取用人单位董事长审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchyrdwsh_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchYRDWSH_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYRDWSH_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YRDWSH_CSRCYJ-all')")
	@ApiOperation(value = "查询用人单位董事长审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询用人单位董事长审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchyrdwsh_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchYRDWSH_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYRDWSH_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDSP-all')")
	@ApiOperation(value = "获取局总部审核（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取局总部审核（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjldsp")
	public ResponseEntity<List<PcmProfileDTO>> fetchJLDSP(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJLDSP(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDSP-all')")
	@ApiOperation(value = "查询局总部审核（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询局总部审核（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjldsp")
	public ResponseEntity<Page<PcmProfileDTO>> searchJLDSP(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJLDSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BD_CSRCYJ-all')")
	@ApiOperation(value = "获取报到（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取报到（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbd_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchBD_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBD_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BD_CSRCYJ-all')")
	@ApiOperation(value = "查询报到（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询报到（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbd_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchBD_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBD_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YPZSPB_CSRCYJ-all')")
	@ApiOperation(value = "获取应聘者审批表（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取应聘者审批表（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchypzspb_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchYPZSPB_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYPZSPB_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YPZSPB_CSRCYJ-all')")
	@ApiOperation(value = "查询应聘者审批表（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询应聘者审批表（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchypzspb_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchYPZSPB_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYPZSPB_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ZPDWSH-all')")
	@ApiOperation(value = "获取用人单位初审（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取用人单位初审（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchzpdwsh")
	public ResponseEntity<List<PcmProfileDTO>> fetchZPDWSH(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchZPDWSH(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-ZPDWSH-all')")
	@ApiOperation(value = "查询用人单位初审（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询用人单位初审（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchzpdwsh")
	public ResponseEntity<Page<PcmProfileDTO>> searchZPDWSH(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchZPDWSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BD-all')")
	@ApiOperation(value = "获取报到（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取报到（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbd")
	public ResponseEntity<List<PcmProfileDTO>> fetchBD(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBD(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BD-all')")
	@ApiOperation(value = "查询报到（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询报到（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbd")
	public ResponseEntity<Page<PcmProfileDTO>> searchBD(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BHSP-all')")
	@ApiOperation(value = "获取编号审批（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取编号审批（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbhsp")
	public ResponseEntity<List<PcmProfileDTO>> fetchBHSP(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBHSP(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BHSP-all')")
	@ApiOperation(value = "查询编号审批（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询编号审批（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbhsp")
	public ResponseEntity<Page<PcmProfileDTO>> searchBHSP(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBHSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-LR-all')")
	@ApiOperation(value = "获取录入（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取录入（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchlr")
	public ResponseEntity<List<PcmProfileDTO>> fetchLR(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchLR(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-LR-all')")
	@ApiOperation(value = "查询录入（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询录入（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchlr")
	public ResponseEntity<Page<PcmProfileDTO>> searchLR(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchLR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RLSB-all')")
	@ApiOperation(value = "获取人力上报（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取人力上报（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrlsb")
	public ResponseEntity<List<PcmProfileDTO>> fetchRLSB(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRLSB(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RLSB-all')")
	@ApiOperation(value = "查询人力上报（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询人力上报（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrlsb")
	public ResponseEntity<Page<PcmProfileDTO>> searchRLSB(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRLSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-FormType-all')")
	@ApiOperation(value = "获取FormType", tags = {"应聘者基本信息" } ,notes = "获取FormType")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchformtype")
	public ResponseEntity<List<PcmProfileDTO>> fetchFormType(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchFormType(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-FormType-all')")
	@ApiOperation(value = "查询FormType", tags = {"应聘者基本信息" } ,notes = "查询FormType")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchformtype")
	public ResponseEntity<Page<PcmProfileDTO>> searchFormType(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-HTRY_CSRCYJ-all')")
	@ApiOperation(value = "获取回退人员（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取回退人员（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchhtry_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchHTRY_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchHTRY_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-HTRY_CSRCYJ-all')")
	@ApiOperation(value = "查询回退人员（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询回退人员（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchhtry_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchHTRY_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchHTRY_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者基本信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchdefault")
	public ResponseEntity<List<PcmProfileDTO>> fetchDefault(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchDefault(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者基本信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchdefault")
	public ResponseEntity<Page<PcmProfileDTO>> searchDefault(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBSP-all')")
	@ApiOperation(value = "获取局总部审批（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取局总部审批（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjzbsp")
	public ResponseEntity<List<PcmProfileDTO>> fetchJZBSP(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJZBSP(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBSP-all')")
	@ApiOperation(value = "查询局总部审批（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询局总部审批（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjzbsp")
	public ResponseEntity<Page<PcmProfileDTO>> searchJZBSP(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RZSP_CSRCYJ-all')")
	@ApiOperation(value = "获取局总部初审（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取局总部初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrzsp_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchRZSP_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRZSP_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RZSP_CSRCYJ-all')")
	@ApiOperation(value = "查询局总部初审（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询局总部初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrzsp_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchRZSP_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRZSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDSP_CSRCYJ-all')")
	@ApiOperation(value = "获取局总部审核（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取局总部审核（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjldsp_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchJLDSP_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJLDSP_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JLDSP_CSRCYJ-all')")
	@ApiOperation(value = "查询局总部审核（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询局总部审核（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjldsp_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchJLDSP_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJLDSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BHSP_CSRCYJ-all')")
	@ApiOperation(value = "获取编号审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取编号审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchbhsp_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchBHSP_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBHSP_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-BHSP_CSRCYJ-all')")
	@ApiOperation(value = "查询编号审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询编号审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchbhsp_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchBHSP_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchBHSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-LR_CSRCYJ-all')")
	@ApiOperation(value = "获取录入（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取录入（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchlr_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchLR_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchLR_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-LR_CSRCYJ-all')")
	@ApiOperation(value = "查询录入（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询录入（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchlr_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchLR_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchLR_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YPZBB_READ-all')")
	@ApiOperation(value = "获取应聘者查询", tags = {"应聘者基本信息" } ,notes = "获取应聘者查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchypzbb_read")
	public ResponseEntity<List<PcmProfileDTO>> fetchYPZBB_READ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYPZBB_READ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YPZBB_READ-all')")
	@ApiOperation(value = "查询应聘者查询", tags = {"应聘者基本信息" } ,notes = "查询应聘者查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchypzbb_read")
	public ResponseEntity<Page<PcmProfileDTO>> searchYPZBB_READ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYPZBB_READ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-HTRY-all')")
	@ApiOperation(value = "获取回退人员（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取回退人员（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchhtry")
	public ResponseEntity<List<PcmProfileDTO>> fetchHTRY(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchHTRY(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-HTRY-all')")
	@ApiOperation(value = "查询回退人员（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询回退人员（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchhtry")
	public ResponseEntity<Page<PcmProfileDTO>> searchHTRY(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RZSP-all')")
	@ApiOperation(value = "获取局总部初审（校园招聘）", tags = {"应聘者基本信息" } ,notes = "获取局总部初审（校园招聘）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrzsp")
	public ResponseEntity<List<PcmProfileDTO>> fetchRZSP(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRZSP(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RZSP-all')")
	@ApiOperation(value = "查询局总部初审（校园招聘）", tags = {"应聘者基本信息" } ,notes = "查询局总部初审（校园招聘）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrzsp")
	public ResponseEntity<Page<PcmProfileDTO>> searchRZSP(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRZSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YRDWCS_CSRCYJ-all')")
	@ApiOperation(value = "获取用人单位初审（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取用人单位初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchyrdwcs_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchYRDWCS_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYRDWCS_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-YRDWCS_CSRCYJ-all')")
	@ApiOperation(value = "查询用人单位初审（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询用人单位初审（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchyrdwcs_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchYRDWCS_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchYRDWCS_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBSP_CSRCYJ-all')")
	@ApiOperation(value = "获取局总部审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取局总部审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchjzbsp_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchJZBSP_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJZBSP_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-JZBSP_CSRCYJ-all')")
	@ApiOperation(value = "查询局总部审批（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询局总部审批（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchjzbsp_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchJZBSP_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchJZBSP_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RLSB_CSRCYJ-all')")
	@ApiOperation(value = "获取人力上报（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "获取人力上报（成熟人才引进）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/fetchrlsb_csrcyj")
	public ResponseEntity<List<PcmProfileDTO>> fetchRLSB_CSRCYJ(PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRLSB_CSRCYJ(context) ;
        List<PcmProfileDTO> list = pcmprofileMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfile-RLSB_CSRCYJ-all')")
	@ApiOperation(value = "查询人力上报（成熟人才引进）", tags = {"应聘者基本信息" } ,notes = "查询人力上报（成熟人才引进）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/searchrlsb_csrcyj")
	public ResponseEntity<Page<PcmProfileDTO>> searchRLSB_CSRCYJ(@RequestBody PcmProfileSearchContext context) {
        Page<PcmProfile> domains = pcmprofileService.searchRLSB_CSRCYJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

