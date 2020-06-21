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
 * 实体[内部招聘信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMRECRUITMENT",resultMap = "PcmRecruitmentResultMap")
public class PcmRecruitment extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 内部招聘信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmrecruitmentid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmrecruitmentid")
    @JsonProperty("pcmrecruitmentid")
    private String pcmrecruitmentid;
    /**
     * 能力要求
     */
    @TableField(value = "requirements")
    @JSONField(name = "requirements")
    @JsonProperty("requirements")
    private String requirements;
    /**
     * 实际招聘人数
     */
    @TableField(value = "sjzprs")
    @JSONField(name = "sjzprs")
    @JsonProperty("sjzprs")
    private Integer sjzprs;
    /**
     * 内部招聘信息名称
     */
    @TableField(value = "pcmrecruitmentname")
    @JSONField(name = "pcmrecruitmentname")
    @JsonProperty("pcmrecruitmentname")
    private String pcmrecruitmentname;
    /**
     * 预计招聘人数
     */
    @TableField(value = "yjzprs")
    @JSONField(name = "yjzprs")
    @JsonProperty("yjzprs")
    private Integer yjzprs;
    /**
     * 是否招聘完成
     */
    @TableField(value = "sfzpwc")
    @JSONField(name = "sfzpwc")
    @JsonProperty("sfzpwc")
    private Integer sfzpwc;
    /**
     * 招聘类型
     */
    @TableField(value = "recruitmenttype")
    @JSONField(name = "recruitmenttype")
    @JsonProperty("recruitmenttype")
    private String recruitmenttype;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 岗位管理标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 职务标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 部门管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;



    /**
     * 设置 [能力要求]
     */
    public void setRequirements(String requirements){
        this.requirements = requirements ;
        this.modify("requirements",requirements);
    }

    /**
     * 设置 [实际招聘人数]
     */
    public void setSjzprs(Integer sjzprs){
        this.sjzprs = sjzprs ;
        this.modify("sjzprs",sjzprs);
    }

    /**
     * 设置 [内部招聘信息名称]
     */
    public void setPcmrecruitmentname(String pcmrecruitmentname){
        this.pcmrecruitmentname = pcmrecruitmentname ;
        this.modify("pcmrecruitmentname",pcmrecruitmentname);
    }

    /**
     * 设置 [预计招聘人数]
     */
    public void setYjzprs(Integer yjzprs){
        this.yjzprs = yjzprs ;
        this.modify("yjzprs",yjzprs);
    }

    /**
     * 设置 [是否招聘完成]
     */
    public void setSfzpwc(Integer sfzpwc){
        this.sfzpwc = sfzpwc ;
        this.modify("sfzpwc",sfzpwc);
    }

    /**
     * 设置 [招聘类型]
     */
    public void setRecruitmenttype(String recruitmenttype){
        this.recruitmenttype = recruitmenttype ;
        this.modify("recruitmenttype",recruitmenttype);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [岗位管理标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [职务标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}


