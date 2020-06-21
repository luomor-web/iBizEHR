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
 * 实体[休假信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMVACATION",resultMap = "PimVacationResultMap")
public class PimVacation extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 休假信息名称
     */
    @TableField(value = "pimvacationname")
    @JSONField(name = "pimvacationname")
    @JsonProperty("pimvacationname")
    private String pimvacationname;
    /**
     * 休假天数
     */
    @TableField(value = "xjts")
    @JSONField(name = "xjts")
    @JsonProperty("xjts")
    private Double xjts;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 休假结束时间
     */
    @TableField(value = "xjjssj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xjjssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("xjjssj")
    private Timestamp xjjssj;
    /**
     * 休假开始时间
     */
    @TableField(value = "xjkssj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xjkssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("xjkssj")
    private Timestamp xjkssj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 休假类型
     */
    @TableField(value = "xjlx")
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;
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
     * 休假信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimvacationid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimvacationid")
    @JsonProperty("pimvacationid")
    private String pimvacationid;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [休假信息名称]
     */
    public void setPimvacationname(String pimvacationname){
        this.pimvacationname = pimvacationname ;
        this.modify("pimvacationname",pimvacationname);
    }

    /**
     * 设置 [休假天数]
     */
    public void setXjts(Double xjts){
        this.xjts = xjts ;
        this.modify("xjts",xjts);
    }

    /**
     * 设置 [休假结束时间]
     */
    public void setXjjssj(Timestamp xjjssj){
        this.xjjssj = xjjssj ;
        this.modify("xjjssj",xjjssj);
    }

    /**
     * 格式化日期 [休假结束时间]
     */
    public String formatXjjssj(){
        if (this.xjjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(xjjssj);
    }
    /**
     * 设置 [休假开始时间]
     */
    public void setXjkssj(Timestamp xjkssj){
        this.xjkssj = xjkssj ;
        this.modify("xjkssj",xjkssj);
    }

    /**
     * 格式化日期 [休假开始时间]
     */
    public String formatXjkssj(){
        if (this.xjkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(xjkssj);
    }
    /**
     * 设置 [休假类型]
     */
    public void setXjlx(String xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


