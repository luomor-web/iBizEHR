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
 * 实体[培训场地]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINADDRESS",resultMap = "TrmTrainAddressResultMap")
public class TrmTrainAddress extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 介绍
     */
    @TableField(value = "js")
    @JSONField(name = "js")
    @JsonProperty("js")
    private String js;
    /**
     * 培训类型
     */
    @TableField(value = "pxlx")
    @JSONField(name = "pxlx")
    @JsonProperty("pxlx")
    private String pxlx;
    /**
     * 共享范围
     */
    @TableField(value = "gxfw")
    @JSONField(name = "gxfw")
    @JsonProperty("gxfw")
    private String gxfw;
    /**
     * Email
     */
    @TableField(value = "email")
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 培训地点标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainaddressid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;
    /**
     * 地址
     */
    @TableField(value = "dz")
    @JSONField(name = "dz")
    @JsonProperty("dz")
    private String dz;
    /**
     * 是否启用
     */
    @TableField(value = "sfqy")
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;
    /**
     * 环境状况
     */
    @TableField(value = "hjzk")
    @JSONField(name = "hjzk")
    @JsonProperty("hjzk")
    private String hjzk;
    /**
     * 省份
     */
    @TableField(value = "sf")
    @JSONField(name = "sf")
    @JsonProperty("sf")
    private String sf;
    /**
     * 联系人
     */
    @TableField(value = "lxr")
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否开票
     */
    @TableField(value = "sfkp")
    @JSONField(name = "sfkp")
    @JsonProperty("sfkp")
    private Integer sfkp;
    /**
     * 性质
     */
    @TableField(value = "xz")
    @JSONField(name = "xz")
    @JsonProperty("xz")
    private String xz;
    /**
     * 星级
     */
    @TableField(value = "xj")
    @JSONField(name = "xj")
    @JsonProperty("xj")
    private String xj;
    /**
     * 场地名称
     */
    @TableField(value = "trmtrainaddressname")
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 市
     */
    @TableField(value = "s")
    @JSONField(name = "s")
    @JsonProperty("s")
    private String s;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [介绍]
     */
    public void setJs(String js){
        this.js = js ;
        this.modify("js",js);
    }

    /**
     * 设置 [培训类型]
     */
    public void setPxlx(String pxlx){
        this.pxlx = pxlx ;
        this.modify("pxlx",pxlx);
    }

    /**
     * 设置 [共享范围]
     */
    public void setGxfw(String gxfw){
        this.gxfw = gxfw ;
        this.modify("gxfw",gxfw);
    }

    /**
     * 设置 [Email]
     */
    public void setEmail(String email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [地址]
     */
    public void setDz(String dz){
        this.dz = dz ;
        this.modify("dz",dz);
    }

    /**
     * 设置 [是否启用]
     */
    public void setSfqy(Integer sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [环境状况]
     */
    public void setHjzk(String hjzk){
        this.hjzk = hjzk ;
        this.modify("hjzk",hjzk);
    }

    /**
     * 设置 [省份]
     */
    public void setSf(String sf){
        this.sf = sf ;
        this.modify("sf",sf);
    }

    /**
     * 设置 [联系人]
     */
    public void setLxr(String lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [是否开票]
     */
    public void setSfkp(Integer sfkp){
        this.sfkp = sfkp ;
        this.modify("sfkp",sfkp);
    }

    /**
     * 设置 [性质]
     */
    public void setXz(String xz){
        this.xz = xz ;
        this.modify("xz",xz);
    }

    /**
     * 设置 [星级]
     */
    public void setXj(String xj){
        this.xj = xj ;
        this.modify("xj",xj);
    }

    /**
     * 设置 [场地名称]
     */
    public void setTrmtrainaddressname(String trmtrainaddressname){
        this.trmtrainaddressname = trmtrainaddressname ;
        this.modify("trmtrainaddressname",trmtrainaddressname);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [市]
     */
    public void setS(String s){
        this.s = s ;
        this.modify("s",s);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


