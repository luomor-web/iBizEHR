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
 * 实体[试用期员工转正记录引用明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMXYGZZJLMX",resultMap = "PcmXygzzjlmxResultMap")
public class PcmXygzzjlmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 权限组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 试用期员工转正结果引用明细名称
     */
    @TableField(value = "pcmxygzzjlmxname")
    @JSONField(name = "pcmxygzzjlmxname")
    @JsonProperty("pcmxygzzjlmxname")
    private String pcmxygzzjlmxname;
    /**
     * 审核状态
     */
    @DEField(defaultValue = "2")
    @TableField(value = "checkstatus")
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
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
     * 转正时间
     */
    @TableField(value = "zzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zzsj" , format="yyyy-MM-dd")
    @JsonProperty("zzsj")
    private Timestamp zzsj;
    /**
     * 是否完成
     */
    @DEField(defaultValue = "0")
    @TableField(value = "finished")
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;
    /**
     * 试用期员工转正结果引用明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmxygzzjlmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmxygzzjlmxid")
    @JsonProperty("pcmxygzzjlmxid")
    private String pcmxygzzjlmxid;
    /**
     * 权限部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否为临时数据
     */
    @DEField(defaultValue = "0")
    @TableField(value = "istemp")
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;
    /**
     * 入职渠道
     */
    @TableField(value = "rzqd")
    @JSONField(name = "rzqd")
    @JsonProperty("rzqd")
    private String rzqd;
    /**
     * 试用期到期时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 员工
     */
    @TableField(exist = false)
    @JSONField(name = "pcmxygzzkhjgjlname")
    @JsonProperty("pcmxygzzkhjgjlname")
    private String pcmxygzzkhjgjlname;
    /**
     * 试用期限（月）
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;
    /**
     * 试用期员工转正申请名称
     */
    @TableField(exist = false)
    @JSONField(name = "pcmxygzzsqname")
    @JsonProperty("pcmxygzzsqname")
    private String pcmxygzzsqname;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 分数
     */
    @TableField(value = "fs")
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 到局时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qssj" , format="yyyy-MM-dd")
    @JsonProperty("qssj")
    private Timestamp qssj;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 转正岗位
     */
    @TableField(value = "zzgw")
    @JSONField(name = "zzgw")
    @JsonProperty("zzgw")
    private String zzgw;
    /**
     * 组织ID
     */
    @TableField(value = "zzid")
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 评价
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 部门ID
     */
    @TableField(value = "bmid")
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 试用期员工转正申请标识
     */
    @TableField(value = "pcmxygzzsqid")
    @JSONField(name = "pcmxygzzsqid")
    @JsonProperty("pcmxygzzsqid")
    private String pcmxygzzsqid;
    /**
     * 试用期员工转正考核结果记录标识
     */
    @TableField(value = "pcmxygzzkhjgjlid")
    @JSONField(name = "pcmxygzzkhjgjlid")
    @JsonProperty("pcmxygzzkhjgjlid")
    private String pcmxygzzkhjgjlid;

    /**
     * 试用期转正结果记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmXygzzkhjgjl pcmxygzzkhjgjl;

    /**
     * 试用期转正记录引用明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq pcmxygzzsq;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [试用期员工转正结果引用明细名称]
     */
    public void setPcmxygzzjlmxname(String pcmxygzzjlmxname){
        this.pcmxygzzjlmxname = pcmxygzzjlmxname ;
        this.modify("pcmxygzzjlmxname",pcmxygzzjlmxname);
    }

    /**
     * 设置 [审核状态]
     */
    public void setCheckstatus(String checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [转正时间]
     */
    public void setZzsj(Timestamp zzsj){
        this.zzsj = zzsj ;
        this.modify("zzsj",zzsj);
    }

    /**
     * 格式化日期 [转正时间]
     */
    public String formatZzsj(){
        if (this.zzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zzsj);
    }
    /**
     * 设置 [是否完成]
     */
    public void setFinished(Integer finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [是否为临时数据]
     */
    public void setIstemp(Integer istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [入职渠道]
     */
    public void setRzqd(String rzqd){
        this.rzqd = rzqd ;
        this.modify("rzqd",rzqd);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [试用期限（月）]
     */
    public void setDuration(String duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [分数]
     */
    public void setFs(Double fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [转正岗位]
     */
    public void setZzgw(String zzgw){
        this.zzgw = zzgw ;
        this.modify("zzgw",zzgw);
    }

    /**
     * 设置 [组织ID]
     */
    public void setZzid(String zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [评价]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [部门ID]
     */
    public void setBmid(String bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [试用期员工转正申请标识]
     */
    public void setPcmxygzzsqid(String pcmxygzzsqid){
        this.pcmxygzzsqid = pcmxygzzsqid ;
        this.modify("pcmxygzzsqid",pcmxygzzsqid);
    }

    /**
     * 设置 [试用期员工转正考核结果记录标识]
     */
    public void setPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid){
        this.pcmxygzzkhjgjlid = pcmxygzzkhjgjlid ;
        this.modify("pcmxygzzkhjgjlid",pcmxygzzkhjgjlid);
    }


}


