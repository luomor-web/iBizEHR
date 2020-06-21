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
 * 实体[项目人员缺口情况]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMXMSFHZ",resultMap = "OrmXmsfhzResultMap")
public class OrmXmsfhz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "augy_color")
    @JsonProperty("augy_color")
    private String augyColor;
    /**
     * 月份
     */
    @TableField(value = "month")
    @JSONField(name = "month")
    @JsonProperty("month")
    private String month;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "yf_color")
    @JsonProperty("yf_color")
    private String yfColor;
    /**
     * 8月
     */
    @TableField(value = "augy")
    @JSONField(name = "augy")
    @JsonProperty("augy")
    private String augy;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 2月
     */
    @TableField(value = "ey")
    @JSONField(name = "ey")
    @JsonProperty("ey")
    private String ey;
    /**
     * 9月
     */
    @TableField(value = "jy")
    @JSONField(name = "jy")
    @JsonProperty("jy")
    private String jy;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "qy_color")
    @JsonProperty("qy_color")
    private String qyColor;
    /**
     * 4月
     */
    @TableField(value = "apy")
    @JSONField(name = "apy")
    @JsonProperty("apy")
    private String apy;
    /**
     * 1月
     */
    @TableField(value = "yy")
    @JSONField(name = "yy")
    @JsonProperty("yy")
    private String yy;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "syy_color")
    @JsonProperty("syy_color")
    private String syyColor;
    /**
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormxmsfhzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormxmsfhzid")
    @JsonProperty("ormxmsfhzid")
    private String ormxmsfhzid;
    /**
     * 需求人数
     */
    @TableField(value = "xm")
    @JSONField(name = "xm")
    @JsonProperty("xm")
    private String xm;
    /**
     * 11月
     */
    @TableField(value = "syy")
    @JSONField(name = "syy")
    @JsonProperty("syy")
    private String syy;
    /**
     * 3月
     */
    @TableField(value = "sy")
    @JSONField(name = "sy")
    @JsonProperty("sy")
    private String sy;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "sy_color")
    @JsonProperty("sy_color")
    private String syColor;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "wy_color")
    @JsonProperty("wy_color")
    private String wyColor;
    /**
     * 10月
     */
    @TableField(value = "octy")
    @JSONField(name = "octy")
    @JsonProperty("octy")
    private String octy;
    /**
     * 本岗位人数
     */
    @TableField(value = "rs")
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "ey_color")
    @JsonProperty("ey_color")
    private String eyColor;
    /**
     * 标题
     */
    @TableField(value = "ormxmsfhzname")
    @JSONField(name = "ormxmsfhzname")
    @JsonProperty("ormxmsfhzname")
    private String ormxmsfhzname;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 5月
     */
    @TableField(value = "wy")
    @JSONField(name = "wy")
    @JsonProperty("wy")
    private String wy;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 6月
     */
    @TableField(value = "ly")
    @JSONField(name = "ly")
    @JsonProperty("ly")
    private String ly;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "apy_color")
    @JsonProperty("apy_color")
    private String apyColor;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "yy_color")
    @JsonProperty("yy_color")
    private String yyColor;
    /**
     * 12月
     */
    @TableField(value = "yf")
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "jy_color")
    @JsonProperty("jy_color")
    private String jyColor;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "ly_color")
    @JsonProperty("ly_color")
    private String lyColor;
    /**
     * 7月
     */
    @TableField(value = "qy")
    @JSONField(name = "qy")
    @JsonProperty("qy")
    private String qy;
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
     * 超人数的颜色显示
     */
    @TableField(exist = false)
    @JSONField(name = "octy_color")
    @JsonProperty("octy_color")
    private String octyColor;



    /**
     * 设置 [月份]
     */
    public void setMonth(String month){
        this.month = month ;
        this.modify("month",month);
    }

    /**
     * 设置 [8月]
     */
    public void setAugy(String augy){
        this.augy = augy ;
        this.modify("augy",augy);
    }

    /**
     * 设置 [2月]
     */
    public void setEy(String ey){
        this.ey = ey ;
        this.modify("ey",ey);
    }

    /**
     * 设置 [9月]
     */
    public void setJy(String jy){
        this.jy = jy ;
        this.modify("jy",jy);
    }

    /**
     * 设置 [4月]
     */
    public void setApy(String apy){
        this.apy = apy ;
        this.modify("apy",apy);
    }

    /**
     * 设置 [1月]
     */
    public void setYy(String yy){
        this.yy = yy ;
        this.modify("yy",yy);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [需求人数]
     */
    public void setXm(String xm){
        this.xm = xm ;
        this.modify("xm",xm);
    }

    /**
     * 设置 [11月]
     */
    public void setSyy(String syy){
        this.syy = syy ;
        this.modify("syy",syy);
    }

    /**
     * 设置 [3月]
     */
    public void setSy(String sy){
        this.sy = sy ;
        this.modify("sy",sy);
    }

    /**
     * 设置 [10月]
     */
    public void setOcty(String octy){
        this.octy = octy ;
        this.modify("octy",octy);
    }

    /**
     * 设置 [本岗位人数]
     */
    public void setRs(Integer rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [标题]
     */
    public void setOrmxmsfhzname(String ormxmsfhzname){
        this.ormxmsfhzname = ormxmsfhzname ;
        this.modify("ormxmsfhzname",ormxmsfhzname);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [5月]
     */
    public void setWy(String wy){
        this.wy = wy ;
        this.modify("wy",wy);
    }

    /**
     * 设置 [组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [6月]
     */
    public void setLy(String ly){
        this.ly = ly ;
        this.modify("ly",ly);
    }

    /**
     * 设置 [12月]
     */
    public void setYf(String yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [7月]
     */
    public void setQy(String qy){
        this.qy = qy ;
        this.modify("qy",qy);
    }


}


