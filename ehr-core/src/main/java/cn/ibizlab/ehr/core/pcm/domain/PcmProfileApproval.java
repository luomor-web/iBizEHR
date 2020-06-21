package cn.ibizlab.ehr.core.pcm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[应聘者审批表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMPROFILEAPPROVAL",resultMap = "PcmProfileApprovalResultMap")
public class PcmProfileApproval extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应聘者审批表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmprofileapprovalid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmprofileapprovalid")
    @JsonProperty("pcmprofileapprovalid")
    private String pcmprofileapprovalid;
    /**
     * 审批阶段（非A类员工）
     */
    @TableField(value = "fastate")
    @JSONField(name = "fastate")
    @JsonProperty("fastate")
    private String fastate;
    /**
     * 通过/拒绝
     */
    @DEField(defaultValue = "10")
    @TableField(value = "passorreject")
    @JSONField(name = "passorreject")
    @JsonProperty("passorreject")
    private String passorreject;
    /**
     * 审批人
     */
    @TableField(value = "approver")
    @JSONField(name = "approver")
    @JsonProperty("approver")
    private String approver;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 审批时间
     */
    @TableField(value = "approvaldate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "approvaldate" , format="yyyy-MM-dd")
    @JsonProperty("approvaldate")
    private Timestamp approvaldate;
    /**
     * 审批意见
     */
    @TableField(value = "approvalopinion")
    @JSONField(name = "approvalopinion")
    @JsonProperty("approvalopinion")
    private String approvalopinion;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 意见原因
     */
    @TableField(value = "yjyy")
    @JSONField(name = "yjyy")
    @JsonProperty("yjyy")
    private String yjyy;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 审批阶段
     */
    @TableField(value = "approvalstage")
    @JSONField(name = "approvalstage")
    @JsonProperty("approvalstage")
    private String approvalstage;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 应聘者审批表名称
     */
    @TableField(value = "pcmprofileapprovalname")
    @JSONField(name = "pcmprofileapprovalname")
    @JsonProperty("pcmprofileapprovalname")
    private String pcmprofileapprovalname;
    /**
     * 非A类员工编号变更
     */
    @TableField(exist = false)
    @JSONField(name = "pimbyzzjlmxname")
    @JsonProperty("pimbyzzjlmxname")
    private String pimbyzzjlmxname;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;
    /**
     * 非A类员工编号变更ID
     */
    @TableField(value = "pimbyzzjlmxid")
    @JSONField(name = "pimbyzzjlmxid")
    @JsonProperty("pimbyzzjlmxid")
    private String pimbyzzjlmxid;

    /**
     * 应聘者信息-应聘者审批表
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;

    /**
     * 非A类员工编号变更-审批表
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx pimbyzzjlmx;



    /**
     * 设置 [审批阶段（非A类员工）]
     */
    public void setFastate(String fastate){
        this.fastate = fastate ;
        this.modify("fastate",fastate);
    }

    /**
     * 设置 [通过/拒绝]
     */
    public void setPassorreject(String passorreject){
        this.passorreject = passorreject ;
        this.modify("passorreject",passorreject);
    }

    /**
     * 设置 [审批人]
     */
    public void setApprover(String approver){
        this.approver = approver ;
        this.modify("approver",approver);
    }

    /**
     * 设置 [审批时间]
     */
    public void setApprovaldate(Timestamp approvaldate){
        this.approvaldate = approvaldate ;
        this.modify("approvaldate",approvaldate);
    }

    /**
     * 格式化日期 [审批时间]
     */
    public String formatApprovaldate(){
        if (this.approvaldate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(approvaldate);
    }
    /**
     * 设置 [审批意见]
     */
    public void setApprovalopinion(String approvalopinion){
        this.approvalopinion = approvalopinion ;
        this.modify("approvalopinion",approvalopinion);
    }

    /**
     * 设置 [意见原因]
     */
    public void setYjyy(String yjyy){
        this.yjyy = yjyy ;
        this.modify("yjyy",yjyy);
    }

    /**
     * 设置 [审批阶段]
     */
    public void setApprovalstage(String approvalstage){
        this.approvalstage = approvalstage ;
        this.modify("approvalstage",approvalstage);
    }

    /**
     * 设置 [应聘者审批表名称]
     */
    public void setPcmprofileapprovalname(String pcmprofileapprovalname){
        this.pcmprofileapprovalname = pcmprofileapprovalname ;
        this.modify("pcmprofileapprovalname",pcmprofileapprovalname);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }

    /**
     * 设置 [非A类员工编号变更ID]
     */
    public void setPimbyzzjlmxid(String pimbyzzjlmxid){
        this.pimbyzzjlmxid = pimbyzzjlmxid ;
        this.modify("pimbyzzjlmxid",pimbyzzjlmxid);
    }


}


