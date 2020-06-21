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
 * 实体[提醒消息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMNOTICE",resultMap = "PcmNoticeResultMap")
public class PcmNotice extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 生效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 提醒类型
     */
    @TableField(value = "noticetype")
    @JSONField(name = "noticetype")
    @JsonProperty("noticetype")
    private String noticetype;
    /**
     * 通知角色类型
     */
    @TableField(value = "roletype")
    @JSONField(name = "roletype")
    @JsonProperty("roletype")
    private Integer roletype;
    /**
     * 是否已处理
     */
    @DEField(defaultValue = "0")
    @TableField(value = "done")
    @JSONField(name = "done")
    @JsonProperty("done")
    private Integer done;
    /**
     * 提醒消息名称
     */
    @TableField(value = "pcmnoticename")
    @JSONField(name = "pcmnoticename")
    @JsonProperty("pcmnoticename")
    private String pcmnoticename;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 所属范围
     */
    @TableField(value = "ssfw")
    @JSONField(name = "ssfw")
    @JsonProperty("ssfw")
    private String ssfw;
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
     * 部门id
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 提醒消息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmnoticeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmnoticeid")
    @JsonProperty("pcmnoticeid")
    private String pcmnoticeid;
    /**
     * 提醒通知内容
     */
    @TableField(value = "notice")
    @JSONField(name = "notice")
    @JsonProperty("notice")
    private String notice;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 异动员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 异动员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 分配信息标识
     */
    @TableField(value = "pimdistirbutionid")
    @JSONField(name = "pimdistirbutionid")
    @JsonProperty("pimdistirbutionid")
    private String pimdistirbutionid;
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
     * 部门
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
     * 分配
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimDistirbution pimdistirbution;

    /**
     * 人员对象
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [生效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [生效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [提醒类型]
     */
    public void setNoticetype(String noticetype){
        this.noticetype = noticetype ;
        this.modify("noticetype",noticetype);
    }

    /**
     * 设置 [通知角色类型]
     */
    public void setRoletype(Integer roletype){
        this.roletype = roletype ;
        this.modify("roletype",roletype);
    }

    /**
     * 设置 [是否已处理]
     */
    public void setDone(Integer done){
        this.done = done ;
        this.modify("done",done);
    }

    /**
     * 设置 [提醒消息名称]
     */
    public void setPcmnoticename(String pcmnoticename){
        this.pcmnoticename = pcmnoticename ;
        this.modify("pcmnoticename",pcmnoticename);
    }

    /**
     * 设置 [所属范围]
     */
    public void setSsfw(String ssfw){
        this.ssfw = ssfw ;
        this.modify("ssfw",ssfw);
    }

    /**
     * 设置 [提醒通知内容]
     */
    public void setNotice(String notice){
        this.notice = notice ;
        this.modify("notice",notice);
    }

    /**
     * 设置 [异动员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [分配信息标识]
     */
    public void setPimdistirbutionid(String pimdistirbutionid){
        this.pimdistirbutionid = pimdistirbutionid ;
        this.modify("pimdistirbutionid",pimdistirbutionid);
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


}


