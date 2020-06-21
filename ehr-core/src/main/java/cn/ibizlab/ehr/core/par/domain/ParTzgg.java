package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[通知发布]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARTZGG",resultMap = "ParTzggResultMap")
public class ParTzgg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 通知公告标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "partzggid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "partzggid")
    @JsonProperty("partzggid")
    private String partzggid;
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
     * 通知附件
     */
    @TableField(value = "lhzbmb")
    @JSONField(name = "lhzbmb")
    @JsonProperty("lhzbmb")
    private String lhzbmb;
    /**
     * 周期类型
     */
    @TableField(value = "zqlx")
    @JSONField(name = "zqlx")
    @JsonProperty("zqlx")
    private String zqlx;
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
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 月度
     */
    @TableField(value = "yd")
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;
    /**
     * 通知类型
     */
    @TableField(value = "tzlx")
    @JSONField(name = "tzlx")
    @JsonProperty("tzlx")
    private String tzlx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 标题
     */
    @TableField(value = "partzggname")
    @JSONField(name = "partzggname")
    @JsonProperty("partzggname")
    private String partzggname;
    /**
     * 截止时间
     */
    @TableField(value = "jzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzsj" , format="yyyy-MM-dd")
    @JsonProperty("jzsj")
    private Timestamp jzsj;



    /**
     * 设置 [通知附件]
     */
    public void setLhzbmb(String lhzbmb){
        this.lhzbmb = lhzbmb ;
        this.modify("lhzbmb",lhzbmb);
    }

    /**
     * 设置 [周期类型]
     */
    public void setZqlx(String zqlx){
        this.zqlx = zqlx ;
        this.modify("zqlx",zqlx);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [月度]
     */
    public void setYd(String yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }

    /**
     * 设置 [通知类型]
     */
    public void setTzlx(String tzlx){
        this.tzlx = tzlx ;
        this.modify("tzlx",tzlx);
    }

    /**
     * 设置 [标题]
     */
    public void setPartzggname(String partzggname){
        this.partzggname = partzggname ;
        this.modify("partzggname",partzggname);
    }

    /**
     * 设置 [截止时间]
     */
    public void setJzsj(Timestamp jzsj){
        this.jzsj = jzsj ;
        this.modify("jzsj",jzsj);
    }

    /**
     * 格式化日期 [截止时间]
     */
    public String formatJzsj(){
        if (this.jzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jzsj);
    }

}


