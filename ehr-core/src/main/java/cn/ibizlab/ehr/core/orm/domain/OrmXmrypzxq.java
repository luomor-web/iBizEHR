package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[项目人员需求]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMRYPZXQ",resultMap = "OrmXmrypzxqResultMap")
public class OrmXmrypzxq extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目人员需求标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmrypzxqid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmrypzxqid")
    @JsonProperty("ormxmrypzxqid")
    private String ormxmrypzxqid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 审批状态（需求计划）
     */
    @DEField(defaultValue = "10")
    @TableField(value = "approvalstatus")
    @JSONField(name = "approvalstatus")
    @JsonProperty("approvalstatus")
    private String approvalstatus;
    /**
     * 拟任岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 计划状态
     */
    @TableField(value = "planstate")
    @JSONField(name = "planstate")
    @JsonProperty("planstate")
    private String planstate;
    /**
     * 修改审批状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "modspzt")
    @JSONField(name = "modspzt")
    @JsonProperty("modspzt")
    private String modspzt;
    /**
     * 岗位职责
     */
    @TableField(value = "majorresp")
    @JSONField(name = "majorresp")
    @JsonProperty("majorresp")
    private String majorresp;
    /**
     * 拒绝原因（调配申请）
     */
    @TableField(value = "tpjjyy")
    @JSONField(name = "tpjjyy")
    @JsonProperty("tpjjyy")
    private String tpjjyy;
    /**
     * 序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 比较结果一
     */
    @TableField(value = "contresultone")
    @JSONField(name = "contresultone")
    @JsonProperty("contresultone")
    private String contresultone;
    /**
     * 审批状态（释放）
     */
    @TableField(value = "spzt")
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;
    /**
     * 拒绝原因（释放申请）
     */
    @TableField(value = "sfjjyy")
    @JSONField(name = "sfjjyy")
    @JsonProperty("sfjjyy")
    private String sfjjyy;
    /**
     * 项目人员需求名称
     */
    @TableField(value = "ormxmrypzxqname")
    @JSONField(name = "ormxmrypzxqname")
    @JsonProperty("ormxmrypzxqname")
    private String ormxmrypzxqname;
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
     * 离岗时间
     */
    @TableField(value = "kqjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqjssj" , format="yyyy-MM-dd")
    @JsonProperty("kqjssj")
    private Timestamp kqjssj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 到岗时间
     */
    @TableField(value = "kqkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kqkssj" , format="yyyy-MM-dd")
    @JsonProperty("kqkssj")
    private Timestamp kqkssj;
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
     * 实际到岗时间
     */
    @TableField(value = "realarrivaltime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "realarrivaltime" , format="yyyy-MM-dd")
    @JsonProperty("realarrivaltime")
    private Timestamp realarrivaltime;
    /**
     * 是否临时数据
     */
    @TableField(value = "istemp")
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private String istemp;
    /**
     * 实际离岗时间
     */
    @TableField(value = "realleavetime")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "realleavetime" , format="yyyy-MM-dd")
    @JsonProperty("realleavetime")
    private Timestamp realleavetime;
    /**
     * 拒绝原因
     */
    @TableField(value = "reason")
    @JSONField(name = "reason")
    @JsonProperty("reason")
    private String reason;
    /**
     * 审批状态（调配）
     */
    @TableField(value = "tpspzt")
    @JSONField(name = "tpspzt")
    @JsonProperty("tpspzt")
    private String tpspzt;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 比较结果二
     */
    @TableField(value = "contresulttwo")
    @JSONField(name = "contresulttwo")
    @JsonProperty("contresulttwo")
    private String contresulttwo;
    /**
     * 修改人员
     */
    @TableField(exist = false)
    @JSONField(name = "modpersonname")
    @JsonProperty("modpersonname")
    private String modpersonname;
    /**
     * 拟任岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 项目部
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 是否关键岗位
     */
    @TableField(exist = false)
    @JSONField(name = "iskeypostion")
    @JsonProperty("iskeypostion")
    private String iskeypostion;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "orgshortname")
    @JsonProperty("orgshortname")
    private String orgshortname;
    /**
     * 职业资格类证书
     */
    @TableField(exist = false)
    @JSONField(name = "certificateability")
    @JsonProperty("certificateability")
    private String certificateability;
    /**
     * 年龄
     */
    @TableField(exist = false)
    @JSONField(name = "age")
    @JsonProperty("age")
    private Integer age;
    /**
     * 性别
     */
    @TableField(exist = false)
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;
    /**
     * 当前岗位
     */
    @TableField(exist = false)
    @JSONField(name = "curpost")
    @JsonProperty("curpost")
    private String curpost;
    /**
     * 实际人员
     */
    @TableField(exist = false)
    @JSONField(name = "realpersonname")
    @JsonProperty("realpersonname")
    private String realpersonname;
    /**
     * 项目名称及编码
     */
    @TableField(exist = false)
    @JSONField(name = "gcmcjbm")
    @JsonProperty("gcmcjbm")
    private String gcmcjbm;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orginfoid")
    @JsonProperty("orginfoid")
    private String orginfoid;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "personnum")
    @JsonProperty("personnum")
    private String personnum;
    /**
     * 项目名称及编码
     */
    @TableField(exist = false)
    @JSONField(name = "xmmc")
    @JsonProperty("xmmc")
    private String xmmc;
    /**
     * 项目部
     */
    @TableField(exist = false)
    @JSONField(name = "xmbmc")
    @JsonProperty("xmbmc")
    private String xmbmc;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 项目部ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsecinfoid")
    @JsonProperty("orgsecinfoid")
    private String orgsecinfoid;
    /**
     * 项目部ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 需求计划ID
     */
    @TableField(value = "ormxmxqjhid")
    @JSONField(name = "ormxmxqjhid")
    @JsonProperty("ormxmxqjhid")
    private String ormxmxqjhid;
    /**
     * 实际人员ID
     */
    @DEField(name = "realperosnid")
    @TableField(value = "realperosnid")
    @JSONField(name = "realpersonid")
    @JsonProperty("realpersonid")
    private String realpersonid;
    /**
     * 人员ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 修改人员ID
     */
    @TableField(value = "modpimpersonid")
    @JSONField(name = "modpimpersonid")
    @JsonProperty("modpimpersonid")
    private String modpimpersonid;
    /**
     * 岗位ID
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 项目部
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 需求计划
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh ormxmxqjh;

    /**
     * 修改人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson modpimperson;

    /**
     * 项目人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 实际人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson realperson;



    /**
     * 设置 [审批状态（需求计划）]
     */
    public void setApprovalstatus(String approvalstatus){
        this.approvalstatus = approvalstatus ;
        this.modify("approvalstatus",approvalstatus);
    }

    /**
     * 设置 [拟任岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [计划状态]
     */
    public void setPlanstate(String planstate){
        this.planstate = planstate ;
        this.modify("planstate",planstate);
    }

    /**
     * 设置 [修改审批状态]
     */
    public void setModspzt(String modspzt){
        this.modspzt = modspzt ;
        this.modify("modspzt",modspzt);
    }

    /**
     * 设置 [岗位职责]
     */
    public void setMajorresp(String majorresp){
        this.majorresp = majorresp ;
        this.modify("majorresp",majorresp);
    }

    /**
     * 设置 [拒绝原因（调配申请）]
     */
    public void setTpjjyy(String tpjjyy){
        this.tpjjyy = tpjjyy ;
        this.modify("tpjjyy",tpjjyy);
    }

    /**
     * 设置 [序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [比较结果一]
     */
    public void setContresultone(String contresultone){
        this.contresultone = contresultone ;
        this.modify("contresultone",contresultone);
    }

    /**
     * 设置 [审批状态（释放）]
     */
    public void setSpzt(String spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [拒绝原因（释放申请）]
     */
    public void setSfjjyy(String sfjjyy){
        this.sfjjyy = sfjjyy ;
        this.modify("sfjjyy",sfjjyy);
    }

    /**
     * 设置 [项目人员需求名称]
     */
    public void setOrmxmrypzxqname(String ormxmrypzxqname){
        this.ormxmrypzxqname = ormxmrypzxqname ;
        this.modify("ormxmrypzxqname",ormxmrypzxqname);
    }

    /**
     * 设置 [离岗时间]
     */
    public void setKqjssj(Timestamp kqjssj){
        this.kqjssj = kqjssj ;
        this.modify("kqjssj",kqjssj);
    }

    /**
     * 格式化日期 [离岗时间]
     */
    public String formatKqjssj(){
        if (this.kqjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kqjssj);
    }
    /**
     * 设置 [到岗时间]
     */
    public void setKqkssj(Timestamp kqkssj){
        this.kqkssj = kqkssj ;
        this.modify("kqkssj",kqkssj);
    }

    /**
     * 格式化日期 [到岗时间]
     */
    public String formatKqkssj(){
        if (this.kqkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kqkssj);
    }
    /**
     * 设置 [实际到岗时间]
     */
    public void setRealarrivaltime(Timestamp realarrivaltime){
        this.realarrivaltime = realarrivaltime ;
        this.modify("realarrivaltime",realarrivaltime);
    }

    /**
     * 格式化日期 [实际到岗时间]
     */
    public String formatRealarrivaltime(){
        if (this.realarrivaltime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(realarrivaltime);
    }
    /**
     * 设置 [是否临时数据]
     */
    public void setIstemp(String istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [实际离岗时间]
     */
    public void setRealleavetime(Timestamp realleavetime){
        this.realleavetime = realleavetime ;
        this.modify("realleavetime",realleavetime);
    }

    /**
     * 格式化日期 [实际离岗时间]
     */
    public String formatRealleavetime(){
        if (this.realleavetime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(realleavetime);
    }
    /**
     * 设置 [拒绝原因]
     */
    public void setReason(String reason){
        this.reason = reason ;
        this.modify("reason",reason);
    }

    /**
     * 设置 [审批状态（调配）]
     */
    public void setTpspzt(String tpspzt){
        this.tpspzt = tpspzt ;
        this.modify("tpspzt",tpspzt);
    }

    /**
     * 设置 [比较结果二]
     */
    public void setContresulttwo(String contresulttwo){
        this.contresulttwo = contresulttwo ;
        this.modify("contresulttwo",contresulttwo);
    }

    /**
     * 设置 [项目部ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [需求计划ID]
     */
    public void setOrmxmxqjhid(String ormxmxqjhid){
        this.ormxmxqjhid = ormxmxqjhid ;
        this.modify("ormxmxqjhid",ormxmxqjhid);
    }

    /**
     * 设置 [实际人员ID]
     */
    public void setRealpersonid(String realpersonid){
        this.realpersonid = realpersonid ;
        this.modify("realperosnid",realpersonid);
    }

    /**
     * 设置 [人员ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [修改人员ID]
     */
    public void setModpimpersonid(String modpimpersonid){
        this.modpimpersonid = modpimpersonid ;
        this.modify("modpimpersonid",modpimpersonid);
    }

    /**
     * 设置 [岗位ID]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }


}


