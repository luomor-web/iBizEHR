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
 * 实体[项目人员需求汇总]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMXQHZ",resultMap = "OrmXmxqhzResultMap")
public class OrmXmxqhz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目
     */
    @TableField(value = "xm")
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 标题
     */
    @TableField(value = "ormxmxqhzname")
    @JSONField(name = "ormxmxqhzname")
    @JsonProperty("ormxmxqhzname")
    private String ormxmxqhzname;
    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmxqhzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmxqhzid")
    @JsonProperty("ormxmxqhzid")
    private String ormxmxqhzid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 本岗位当前人数
     */
    @TableField(value = "rs")
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;
    /**
     * 组织ID
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
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
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 项目ID
     */
    @TableField(value = "xmid")
    @JSONField(name = "xmid")
    @JsonProperty("xmid")
    private String xmid;
    /**
     * 月份
     */
    @TableField(value = "yf")
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;



    /**
     * 设置 [项目]
     */
    public void setXm(String xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [标题]
     */
    public void setOrmxmxqhzname(String ormxmxqhzname){
        this.ormxmxqhzname = ormxmxqhzname ;
        this.modify("ormxmxqhzname",ormxmxqhzname);
    }

    /**
     * 设置 [本岗位当前人数]
     */
    public void setRs(Integer rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
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
     * 设置 [项目ID]
     */
    public void setXmid(String xmid){
        this.xmid = xmid ;
        this.modify("xmid",xmid);
    }

    /**
     * 设置 [月份]
     */
    public void setYf(String yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }


}


