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
 * 实体[班主任]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMHMATSER",resultMap = "TrmHmatserResultMap")
public class TrmHmatser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 班主任标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmhmatserid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmhmatserid")
    @JsonProperty("trmhmatserid")
    private String trmhmatserid;
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
     * 班主任名称
     */
    @TableField(value = "trmhmatsername")
    @JSONField(name = "trmhmatsername")
    @JsonProperty("trmhmatsername")
    private String trmhmatsername;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 联系方式
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 班主任
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 身份证号码
     */
    @TableField(value = "zjhm")
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 年龄
     */
    @TableField(value = "nj")
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 所属单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 班主任
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 培训机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [班主任名称]
     */
    public void setTrmhmatsername(String trmhmatsername){
        this.trmhmatsername = trmhmatsername ;
        this.modify("trmhmatsername",trmhmatsername);
    }

    /**
     * 设置 [联系方式]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [班主任]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [身份证号码]
     */
    public void setZjhm(String zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [年龄]
     */
    public void setNj(Integer nj){
        this.nj = nj ;
        this.modify("nj",nj);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


