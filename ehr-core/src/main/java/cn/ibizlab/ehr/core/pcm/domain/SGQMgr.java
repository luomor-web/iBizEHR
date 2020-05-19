package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[试岗期管理（弃用）]
 */
@Data
@TableName(value = "T_SGQMGR",resultMap = "SGQMgrResultMap")
public class SGQMgr extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试岗期管理名称
     */
    @TableField(value = "sgqmgrname")
    @JSONField(name = "sgqmgrname")
    @JsonProperty("sgqmgrname")
    private String sgqmgrname;
    /**
     * 试岗期管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "sgqmgrid",type=IdType.UUID)
    @JSONField(name = "sgqmgrid")
    @JsonProperty("sgqmgrid")
    private String sgqmgrid;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 试岗开始时间
     */
    @TableField(value = "kssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 是否通过审核
     */
    @TableField(value = "sftgsh")
    @JSONField(name = "sftgsh")
    @JsonProperty("sftgsh")
    private Integer sftgsh;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 申请单明细标识
     */
    @TableField(value = "pcmbdsqdmxid")
    @JSONField(name = "pcmbdsqdmxid")
    @JsonProperty("pcmbdsqdmxid")
    private String pcmbdsqdmxid;

    /**
     * 职级变动
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX pcmbdsqdmx;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson;



    /**
     * 设置 [试岗期管理名称]
     */
    public void setSgqmgrname(String sgqmgrname){
        this.sgqmgrname = sgqmgrname ;
        this.modify("sgqmgrname",sgqmgrname);
    }
    /**
     * 设置 [试岗开始时间]
     */
    public void setKssj(Timestamp kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }
    /**
     * 设置 [结束时间]
     */
    public void setJssj(Timestamp jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }
    /**
     * 设置 [是否通过审核]
     */
    public void setSftgsh(Integer sftgsh){
        this.sftgsh = sftgsh ;
        this.modify("sftgsh",sftgsh);
    }
    /**
     * 设置 [员工编号]
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
     * 设置 [申请单明细标识]
     */
    public void setPcmbdsqdmxid(String pcmbdsqdmxid){
        this.pcmbdsqdmxid = pcmbdsqdmxid ;
        this.modify("pcmbdsqdmxid",pcmbdsqdmxid);
    }

}


