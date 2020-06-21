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
 * 实体[投递职位摘要信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TDZWXX",resultMap = "PcmTdzwxxResultMap")
public class PcmTdzwxx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投递组织
     */
    @TableField(value = "department")
    @JSONField(name = "department")
    @JsonProperty("department")
    private String department;
    /**
     * 所在阶段信息
     */
    @TableField(value = "phaseinfo")
    @JSONField(name = "phaseinfo")
    @JsonProperty("phaseinfo")
    private String phaseinfo;
    /**
     * 组织机构
     */
    @TableField(value = "organization")
    @JSONField(name = "organization")
    @JsonProperty("organization")
    private String organization;
    /**
     * 所在状态信息
     */
    @TableField(value = "statusinfo")
    @JSONField(name = "statusinfo")
    @JsonProperty("statusinfo")
    private String statusinfo;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 职位编号
     */
    @TableField(value = "jobcode")
    @JSONField(name = "jobcode")
    @JsonProperty("jobcode")
    private String jobcode;
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
     * 是否有效
     */
    @DEField(defaultValue = "1")
    @TableField(value = "flag")
    @JSONField(name = "flag")
    @JsonProperty("flag")
    private String flag;
    /**
     * 职位ID
     */
    @TableField(value = "jobid")
    @JSONField(name = "jobid")
    @JsonProperty("jobid")
    private String jobid;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 投递职位摘要信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tdzwxxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "tdzwxxid")
    @JsonProperty("tdzwxxid")
    private String tdzwxxid;
    /**
     * 最初投递时间
     */
    @TableField(value = "initapplydate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "initapplydate" , format="yyyy-MM-dd")
    @JsonProperty("initapplydate")
    private Timestamp initapplydate;
    /**
     * 职位名称
     */
    @TableField(value = "tdzwxxname")
    @JSONField(name = "tdzwxxname")
    @JsonProperty("tdzwxxname")
    private String tdzwxxname;
    /**
     * 版本时间
     */
    @TableField(value = "bbsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bbsj" , format="yyyy-MM-dd")
    @JsonProperty("bbsj")
    private Timestamp bbsj;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
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
     * 应聘者信息-投递职务信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;



    /**
     * 设置 [投递组织]
     */
    public void setDepartment(String department){
        this.department = department ;
        this.modify("department",department);
    }

    /**
     * 设置 [所在阶段信息]
     */
    public void setPhaseinfo(String phaseinfo){
        this.phaseinfo = phaseinfo ;
        this.modify("phaseinfo",phaseinfo);
    }

    /**
     * 设置 [组织机构]
     */
    public void setOrganization(String organization){
        this.organization = organization ;
        this.modify("organization",organization);
    }

    /**
     * 设置 [所在状态信息]
     */
    public void setStatusinfo(String statusinfo){
        this.statusinfo = statusinfo ;
        this.modify("statusinfo",statusinfo);
    }

    /**
     * 设置 [职位编号]
     */
    public void setJobcode(String jobcode){
        this.jobcode = jobcode ;
        this.modify("jobcode",jobcode);
    }

    /**
     * 设置 [是否有效]
     */
    public void setFlag(String flag){
        this.flag = flag ;
        this.modify("flag",flag);
    }

    /**
     * 设置 [职位ID]
     */
    public void setJobid(String jobid){
        this.jobid = jobid ;
        this.modify("jobid",jobid);
    }

    /**
     * 设置 [最初投递时间]
     */
    public void setInitapplydate(Timestamp initapplydate){
        this.initapplydate = initapplydate ;
        this.modify("initapplydate",initapplydate);
    }

    /**
     * 格式化日期 [最初投递时间]
     */
    public String formatInitapplydate(){
        if (this.initapplydate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(initapplydate);
    }
    /**
     * 设置 [职位名称]
     */
    public void setTdzwxxname(String tdzwxxname){
        this.tdzwxxname = tdzwxxname ;
        this.modify("tdzwxxname",tdzwxxname);
    }

    /**
     * 设置 [版本时间]
     */
    public void setBbsj(Timestamp bbsj){
        this.bbsj = bbsj ;
        this.modify("bbsj",bbsj);
    }

    /**
     * 格式化日期 [版本时间]
     */
    public String formatBbsj(){
        if (this.bbsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bbsj);
    }
    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


