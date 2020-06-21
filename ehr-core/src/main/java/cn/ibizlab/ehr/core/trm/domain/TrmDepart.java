package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[培训需求通知]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMDEPART",resultMap = "TrmDepartResultMap")
public class TrmDepart extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 需求通知
     */
    @TableField(value = "trmdepartname")
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 周期类型
     */
    @TableField(value = "lclx")
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;
    /**
     * 需求来源类型
     */
    @TableField(value = "xqlylx")
    @JSONField(name = "xqlylx")
    @JsonProperty("xqlylx")
    private String xqlylx;
    /**
     * 需求单编码
     */
    @TableField(value = "xqdbm")
    @JSONField(name = "xqdbm")
    @JsonProperty("xqdbm")
    private String xqdbm;
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
     * 审批方式
     */
    @TableField(value = "spfs")
    @JSONField(name = "spfs")
    @JsonProperty("spfs")
    private String spfs;
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
     * 通知类型
     */
    @TableField(value = "tzlx")
    @JSONField(name = "tzlx")
    @JsonProperty("tzlx")
    private String tzlx;
    /**
     * 培训需求填报标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmdepartid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 季度
     */
    @TableField(value = "jd")
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;
    /**
     * 通知发布日期
     */
    @TableField(value = "tdrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tdrq" , format="yyyy-MM-dd")
    @JsonProperty("tdrq")
    private Timestamp tdrq;
    /**
     * 截止日期
     */
    @TableField(value = "jzrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzrq" , format="yyyy-MM-dd")
    @JsonProperty("jzrq")
    private Timestamp jzrq;
    /**
     * 职能部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 填单人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 直属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
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
     * 填单公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 填单人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [需求通知]
     */
    public void setTrmdepartname(String trmdepartname){
        this.trmdepartname = trmdepartname ;
        this.modify("trmdepartname",trmdepartname);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [周期类型]
     */
    public void setLclx(String lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [需求来源类型]
     */
    public void setXqlylx(String xqlylx){
        this.xqlylx = xqlylx ;
        this.modify("xqlylx",xqlylx);
    }

    /**
     * 设置 [需求单编码]
     */
    public void setXqdbm(String xqdbm){
        this.xqdbm = xqdbm ;
        this.modify("xqdbm",xqdbm);
    }

    /**
     * 设置 [审批方式]
     */
    public void setSpfs(String spfs){
        this.spfs = spfs ;
        this.modify("spfs",spfs);
    }

    /**
     * 设置 [通知类型]
     */
    public void setTzlx(String tzlx){
        this.tzlx = tzlx ;
        this.modify("tzlx",tzlx);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [季度]
     */
    public void setJd(String jd){
        this.jd = jd ;
        this.modify("jd",jd);
    }

    /**
     * 设置 [通知发布日期]
     */
    public void setTdrq(Timestamp tdrq){
        this.tdrq = tdrq ;
        this.modify("tdrq",tdrq);
    }

    /**
     * 格式化日期 [通知发布日期]
     */
    public String formatTdrq(){
        if (this.tdrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tdrq);
    }
    /**
     * 设置 [截止日期]
     */
    public void setJzrq(Timestamp jzrq){
        this.jzrq = jzrq ;
        this.modify("jzrq",jzrq);
    }

    /**
     * 格式化日期 [截止日期]
     */
    public String formatJzrq(){
        if (this.jzrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jzrq);
    }
    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
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


