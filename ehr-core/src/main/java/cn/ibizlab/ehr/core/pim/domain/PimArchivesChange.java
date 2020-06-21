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
 * 实体[档案归档地变更记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMARCHIVESCHANGE",resultMap = "PimArchivesChangeResultMap")
public class PimArchivesChange extends EntityMP implements Serializable {

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
     * 归档地变更记录
     */
    @TableField(value = "pimarchiveschangename")
    @JSONField(name = "pimarchiveschangename")
    @JsonProperty("pimarchiveschangename")
    private String pimarchiveschangename;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 档案状态
     */
    @TableField(value = "dazt")
    @JSONField(name = "dazt")
    @JsonProperty("dazt")
    private String dazt;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 调出单位
     */
    @TableField(value = "dcdw")
    @JSONField(name = "dcdw")
    @JsonProperty("dcdw")
    private String dcdw;
    /**
     * 调档记录类型
     */
    @TableField(value = "ddjltype")
    @JSONField(name = "ddjltype")
    @JsonProperty("ddjltype")
    private String ddjltype;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 档案归档地变更记录标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimarchiveschangeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimarchiveschangeid")
    @JsonProperty("pimarchiveschangeid")
    private String pimarchiveschangeid;
    /**
     * 管理单位
     */
    @TableField(value = "xgdbgd")
    @JSONField(name = "xgdbgd")
    @JsonProperty("xgdbgd")
    private String xgdbgd;
    /**
     * 调动时间
     */
    @TableField(value = "jlcssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jlcssj" , format="yyyy-MM-dd")
    @JsonProperty("jlcssj")
    private Timestamp jlcssj;
    /**
     * 调入单位
     */
    @TableField(value = "drdw")
    @JSONField(name = "drdw")
    @JsonProperty("drdw")
    private String drdw;
    /**
     * 调动日期
     */
    @TableField(value = "daddrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "daddrq" , format="yyyy-MM-dd")
    @JsonProperty("daddrq")
    private Timestamp daddrq;
    /**
     * 调入单位
     */
    @TableField(value = "ormorgname2")
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 档案名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;
    /**
     * 调出单位
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 调入单位标识
     */
    @TableField(value = "ormorgid2")
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;
    /**
     * 调出单位标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 档案信息标识
     */
    @TableField(value = "pimarchivesid")
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 
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
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg2;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimArchives pimarchives;

    /**
     * 档案归档地变更记录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [归档地变更记录]
     */
    public void setPimarchiveschangename(String pimarchiveschangename){
        this.pimarchiveschangename = pimarchiveschangename ;
        this.modify("pimarchiveschangename",pimarchiveschangename);
    }

    /**
     * 设置 [档案状态]
     */
    public void setDazt(String dazt){
        this.dazt = dazt ;
        this.modify("dazt",dazt);
    }

    /**
     * 设置 [调出单位]
     */
    public void setDcdw(String dcdw){
        this.dcdw = dcdw ;
        this.modify("dcdw",dcdw);
    }

    /**
     * 设置 [调档记录类型]
     */
    public void setDdjltype(String ddjltype){
        this.ddjltype = ddjltype ;
        this.modify("ddjltype",ddjltype);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [管理单位]
     */
    public void setXgdbgd(String xgdbgd){
        this.xgdbgd = xgdbgd ;
        this.modify("xgdbgd",xgdbgd);
    }

    /**
     * 设置 [调动时间]
     */
    public void setJlcssj(Timestamp jlcssj){
        this.jlcssj = jlcssj ;
        this.modify("jlcssj",jlcssj);
    }

    /**
     * 格式化日期 [调动时间]
     */
    public String formatJlcssj(){
        if (this.jlcssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jlcssj);
    }
    /**
     * 设置 [调入单位]
     */
    public void setDrdw(String drdw){
        this.drdw = drdw ;
        this.modify("drdw",drdw);
    }

    /**
     * 设置 [调动日期]
     */
    public void setDaddrq(Timestamp daddrq){
        this.daddrq = daddrq ;
        this.modify("daddrq",daddrq);
    }

    /**
     * 格式化日期 [调动日期]
     */
    public String formatDaddrq(){
        if (this.daddrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(daddrq);
    }
    /**
     * 设置 [调入单位]
     */
    public void setOrmorgname2(String ormorgname2){
        this.ormorgname2 = ormorgname2 ;
        this.modify("ormorgname2",ormorgname2);
    }

    /**
     * 设置 [调出单位]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [调入单位标识]
     */
    public void setOrmorgid2(String ormorgid2){
        this.ormorgid2 = ormorgid2 ;
        this.modify("ormorgid2",ormorgid2);
    }

    /**
     * 设置 [调出单位标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [档案信息标识]
     */
    public void setPimarchivesid(String pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


