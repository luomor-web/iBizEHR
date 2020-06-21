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
 * 实体[见习生员工转正申请明细（停用）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMJXSYGZZSQMX",resultMap = "PcmJxsygzzsqmxResultMap")
public class PcmJxsygzzsqmx extends EntityMP implements Serializable {

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 审核状态
     */
    @TableField(value = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;
    /**
     * 见习生员工转正申请明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmjxsygzzsqmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmjxsygzzsqmxid")
    @JsonProperty("pcmjxsygzzsqmxid")
    private String pcmjxsygzzsqmxid;
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
     * 见习生员工转正申请明细名称
     */
    @TableField(value = "pcmjxsygzzsqmxname")
    @JSONField(name = "pcmjxsygzzsqmxname")
    @JsonProperty("pcmjxsygzzsqmxname")
    private String pcmjxsygzzsqmxname;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 职级
     */
    @TableField(value = "zj")
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;
    /**
     * 见习生员工转正申请名称
     */
    @TableField(exist = false)
    @JSONField(name = "pcmjxsygzzsqname")
    @JsonProperty("pcmjxsygzzsqname")
    private String pcmjxsygzzsqname;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 见习生员工转正申请标识
     */
    @TableField(value = "pcmjxsygzzsqid")
    @JSONField(name = "pcmjxsygzzsqid")
    @JsonProperty("pcmjxsygzzsqid")
    private String pcmjxsygzzsqid;

    /**
     * 见习生转正申请明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq pcmjxsygzzsq;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [审核状态]
     */
    public void setStatus(String status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [见习生员工转正申请明细名称]
     */
    public void setPcmjxsygzzsqmxname(String pcmjxsygzzsqmxname){
        this.pcmjxsygzzsqmxname = pcmjxsygzzsqmxname ;
        this.modify("pcmjxsygzzsqmxname",pcmjxsygzzsqmxname);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [职级]
     */
    public void setZj(String zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [见习生员工转正申请标识]
     */
    public void setPcmjxsygzzsqid(String pcmjxsygzzsqid){
        this.pcmjxsygzzsqid = pcmjxsygzzsqid ;
        this.modify("pcmjxsygzzsqid",pcmjxsygzzsqid);
    }


}


