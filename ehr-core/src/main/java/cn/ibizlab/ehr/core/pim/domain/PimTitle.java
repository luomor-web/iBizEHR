package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[职称信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMTITLE",resultMap = "PimTitleResultMap")
public class PimTitle extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 是否最高职称
     */
    @TableField(value = "sfzgzc")
    @JSONField(name = "sfzgzc")
    @JsonProperty("sfzgzc")
    private Integer sfzgzc;
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
     * 记录管理编号
     */
    @TableField(value = "jlglbh")
    @JSONField(name = "jlglbh")
    @JsonProperty("jlglbh")
    private String jlglbh;
    /**
     * 评审单位
     */
    @TableField(value = "reviewbody")
    @JSONField(name = "reviewbody")
    @JsonProperty("reviewbody")
    private String reviewbody;
    /**
     * 职称获取月数
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;
    /**
     * 职称等级
     */
    @TableField(value = "zcdj")
    @JSONField(name = "zcdj")
    @JsonProperty("zcdj")
    private String zcdj;
    /**
     * 审批状态
     */
    @TableField(exist = false)
    @JSONField(name = "spstate")
    @JsonProperty("spstate")
    private String spstate;
    /**
     * 专业名称
     */
    @TableField(value = "careername")
    @JSONField(name = "careername")
    @JsonProperty("careername")
    private String careername;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 记录审批状态
     */
    @TableField(value = "jlspzt")
    @JSONField(name = "jlspzt")
    @JsonProperty("jlspzt")
    private String jlspzt;
    /**
     * 职称信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimtitleid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimtitleid")
    @JsonProperty("pimtitleid")
    private String pimtitleid;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 评定机构
     */
    @TableField(value = "pdjg")
    @JSONField(name = "pdjg")
    @JsonProperty("pdjg")
    private String pdjg;
    /**
     * 记录所属
     */
    @TableField(value = "jlss")
    @JSONField(name = "jlss")
    @JsonProperty("jlss")
    private String jlss;
    /**
     * 职称聘用时间
     */
    @TableField(value = "employtime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "employtime" , format="yyyy-MM-dd")
    @JsonProperty("employtime")
    private Timestamp employtime;
    /**
     * 附件
     */
    @TableField(value = "enclosure")
    @JSONField(name = "enclosure")
    @JsonProperty("enclosure")
    private String enclosure;
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
     * 证书编号
     */
    @TableField(value = "zcbh")
    @JSONField(name = "zcbh")
    @JsonProperty("zcbh")
    private String zcbh;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职称获取日期
     */
    @TableField(value = "zchqrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zchqrq" , format="yyyy-MM-dd")
    @JsonProperty("zchqrq")
    private Timestamp zchqrq;
    /**
     * 专业类别
     */
    @TableField(value = "majorengaged")
    @JSONField(name = "majorengaged")
    @JsonProperty("majorengaged")
    private String majorengaged;
    /**
     * 签发机构
     */
    @TableField(value = "lssuingagency")
    @JSONField(name = "lssuingagency")
    @JsonProperty("lssuingagency")
    private String lssuingagency;
    /**
     * 职称信息名称
     */
    @TableField(value = "pimtitlename")
    @JSONField(name = "pimtitlename")
    @JsonProperty("pimtitlename")
    private String pimtitlename;
    /**
     * 记录操作者
     */
    @TableField(value = "jlczz")
    @JSONField(name = "jlczz")
    @JsonProperty("jlczz")
    private String jlczz;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 职称名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimtitlecataloguename")
    @JsonProperty("pimtitlecataloguename")
    private String pimtitlecataloguename;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 职称管理标识
     */
    @TableField(value = "pimtitlecatalogueid")
    @JSONField(name = "pimtitlecatalogueid")
    @JsonProperty("pimtitlecatalogueid")
    private String pimtitlecatalogueid;

    /**
     * 职称信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue pimtitlecatalogue;



    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [是否最高职称]
     */
    public void setSfzgzc(Integer sfzgzc){
        this.sfzgzc = sfzgzc ;
        this.modify("sfzgzc",sfzgzc);
    }

    /**
     * 设置 [记录管理编号]
     */
    public void setJlglbh(String jlglbh){
        this.jlglbh = jlglbh ;
        this.modify("jlglbh",jlglbh);
    }

    /**
     * 设置 [评审单位]
     */
    public void setReviewbody(String reviewbody){
        this.reviewbody = reviewbody ;
        this.modify("reviewbody",reviewbody);
    }

    /**
     * 设置 [职称获取月数]
     */
    public void setDuration(Integer duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [职称等级]
     */
    public void setZcdj(String zcdj){
        this.zcdj = zcdj ;
        this.modify("zcdj",zcdj);
    }

    /**
     * 设置 [专业名称]
     */
    public void setCareername(String careername){
        this.careername = careername ;
        this.modify("careername",careername);
    }

    /**
     * 设置 [记录审批状态]
     */
    public void setJlspzt(String jlspzt){
        this.jlspzt = jlspzt ;
        this.modify("jlspzt",jlspzt);
    }

    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [评定机构]
     */
    public void setPdjg(String pdjg){
        this.pdjg = pdjg ;
        this.modify("pdjg",pdjg);
    }

    /**
     * 设置 [记录所属]
     */
    public void setJlss(String jlss){
        this.jlss = jlss ;
        this.modify("jlss",jlss);
    }

    /**
     * 设置 [职称聘用时间]
     */
    public void setEmploytime(Timestamp employtime){
        this.employtime = employtime ;
        this.modify("employtime",employtime);
    }

    /**
     * 格式化日期 [职称聘用时间]
     */
    public String formatEmploytime(){
        if (this.employtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(employtime);
    }
    /**
     * 设置 [附件]
     */
    public void setEnclosure(String enclosure){
        this.enclosure = enclosure ;
        this.modify("enclosure",enclosure);
    }

    /**
     * 设置 [证书编号]
     */
    public void setZcbh(String zcbh){
        this.zcbh = zcbh ;
        this.modify("zcbh",zcbh);
    }

    /**
     * 设置 [职称获取日期]
     */
    public void setZchqrq(Timestamp zchqrq){
        this.zchqrq = zchqrq ;
        this.modify("zchqrq",zchqrq);
    }

    /**
     * 格式化日期 [职称获取日期]
     */
    public String formatZchqrq(){
        if (this.zchqrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zchqrq);
    }
    /**
     * 设置 [专业类别]
     */
    public void setMajorengaged(String majorengaged){
        this.majorengaged = majorengaged ;
        this.modify("majorengaged",majorengaged);
    }

    /**
     * 设置 [签发机构]
     */
    public void setLssuingagency(String lssuingagency){
        this.lssuingagency = lssuingagency ;
        this.modify("lssuingagency",lssuingagency);
    }

    /**
     * 设置 [职称信息名称]
     */
    public void setPimtitlename(String pimtitlename){
        this.pimtitlename = pimtitlename ;
        this.modify("pimtitlename",pimtitlename);
    }

    /**
     * 设置 [记录操作者]
     */
    public void setJlczz(String jlczz){
        this.jlczz = jlczz ;
        this.modify("jlczz",jlczz);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [职称管理标识]
     */
    public void setPimtitlecatalogueid(String pimtitlecatalogueid){
        this.pimtitlecatalogueid = pimtitlecatalogueid ;
        this.modify("pimtitlecatalogueid",pimtitlecatalogueid);
    }


}


