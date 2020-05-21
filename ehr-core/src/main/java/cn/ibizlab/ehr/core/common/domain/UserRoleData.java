package cn.ibizlab.ehr.core.common.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[数据对象能力]
 */
@Data
@TableName(value = "T_USERROLEDATA",resultMap = "UserRoleDataResultMap")
public class UserRoleData extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 数据对象能力标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userroledataid",type=IdType.UUID)
    @JSONField(name = "userroledataid")
    @JsonProperty("userroledataid")
    private String userroledataid;
    /**
     * 版本
     */
    @DEField(defaultValue = "1")
    @TableField(value = "udversion")
    @JSONField(name = "udversion")
    @JsonProperty("udversion")
    private Integer udversion;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 部门数据类型
     */
    @TableField(value = "secdr")
    @JSONField(name = "secdr")
    @JsonProperty("secdr")
    private Integer secdr;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
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
     * 能力名称
     */
    @TableField(value = "userroledataname")
    @JSONField(name = "userroledataname")
    @JsonProperty("userroledataname")
    private String userroledataname;
    /**
     * 条线数据类型
     */
    @TableField(value = "bcdr")
    @JSONField(name = "bcdr")
    @JsonProperty("bcdr")
    private Integer bcdr;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 机构数据类型
     */
    @TableField(value = "orgdr")
    @JSONField(name = "orgdr")
    @JsonProperty("orgdr")
    private Integer orgdr;
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
     * 用户数据类型
     */
    @TableField(value = "userdr")
    @JSONField(name = "userdr")
    @JsonProperty("userdr")
    private Integer userdr;
    /**
     * 全部数据
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isalldata")
    @JSONField(name = "isalldata")
    @JsonProperty("isalldata")
    private Integer isalldata;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 指定部门业务类型
     */
    @TableField(value = "dstsecbc")
    @JSONField(name = "dstsecbc")
    @JsonProperty("dstsecbc")
    private String dstsecbc;
    /**
     * 框架发布
     */
    @TableField(value = "srfsyspub")
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;
    /**
     * 应用发布
     */
    @TableField(value = "srfuserpub")
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 数据对象
     */
    @TableField(exist = false)
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 指定当前部门
     */
    @TableField(exist = false)
    @JSONField(name = "dstorgsectorname")
    @JsonProperty("dstorgsectorname")
    private String dstorgsectorname;
    /**
     * 指定当前机构
     */
    @TableField(exist = false)
    @JSONField(name = "dstorgname")
    @JsonProperty("dstorgname")
    private String dstorgname;
    /**
     * 指定当前部门
     */
    @TableField(value = "dstorgsectorid")
    @JSONField(name = "dstorgsectorid")
    @JsonProperty("dstorgsectorid")
    private String dstorgsectorid;
    /**
     * 指定当前机构
     */
    @TableField(value = "dstorgid")
    @JSONField(name = "dstorgid")
    @JsonProperty("dstorgid")
    private String dstorgid;
    /**
     * 数据实体
     */
    @TableField(value = "deid")
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.DataEntity de;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.OrgSector dstorgsector;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.Org dstorg;



    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [版本]
     */
    public void setUdversion(Integer udversion){
        this.udversion = udversion ;
        this.modify("udversion",udversion);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [部门数据类型]
     */
    public void setSecdr(Integer secdr){
        this.secdr = secdr ;
        this.modify("secdr",secdr);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [能力名称]
     */
    public void setUserroledataname(String userroledataname){
        this.userroledataname = userroledataname ;
        this.modify("userroledataname",userroledataname);
    }
    /**
     * 设置 [条线数据类型]
     */
    public void setBcdr(Integer bcdr){
        this.bcdr = bcdr ;
        this.modify("bcdr",bcdr);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [机构数据类型]
     */
    public void setOrgdr(Integer orgdr){
        this.orgdr = orgdr ;
        this.modify("orgdr",orgdr);
    }
    /**
     * 设置 [用户数据类型]
     */
    public void setUserdr(Integer userdr){
        this.userdr = userdr ;
        this.modify("userdr",userdr);
    }
    /**
     * 设置 [全部数据]
     */
    public void setIsalldata(Integer isalldata){
        this.isalldata = isalldata ;
        this.modify("isalldata",isalldata);
    }
    /**
     * 设置 [指定部门业务类型]
     */
    public void setDstsecbc(String dstsecbc){
        this.dstsecbc = dstsecbc ;
        this.modify("dstsecbc",dstsecbc);
    }
    /**
     * 设置 [框架发布]
     */
    public void setSrfsyspub(Integer srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }
    /**
     * 设置 [应用发布]
     */
    public void setSrfuserpub(Integer srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [指定当前部门]
     */
    public void setDstorgsectorid(String dstorgsectorid){
        this.dstorgsectorid = dstorgsectorid ;
        this.modify("dstorgsectorid",dstorgsectorid);
    }
    /**
     * 设置 [指定当前机构]
     */
    public void setDstorgid(String dstorgid){
        this.dstorgid = dstorgid ;
        this.modify("dstorgid",dstorgid);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDeid(String deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }

}


