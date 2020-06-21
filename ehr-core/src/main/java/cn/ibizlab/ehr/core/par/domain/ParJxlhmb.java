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
 * 实体[绩效量化目标]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXLHMB",resultMap = "ParJxlhmbResultMap")
public class ParJxlhmb extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核类型
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 结束时间
     */
    @TableField(value = "jssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jssj" , format="yyyy-MM-dd")
    @JsonProperty("jssj")
    private Timestamp jssj;
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
     * 开始时间
     */
    @TableField(value = "kssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "kssj" , format="yyyy-MM-dd")
    @JsonProperty("kssj")
    private Timestamp kssj;
    /**
     * 绩效量化目标名称
     */
    @TableField(value = "parjxlhmbname")
    @JSONField(name = "parjxlhmbname")
    @JsonProperty("parjxlhmbname")
    private String parjxlhmbname;
    /**
     * 绩效量化目标标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxlhmbid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxlhmbid")
    @JsonProperty("parjxlhmbid")
    private String parjxlhmbid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [考核类型]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [结束时间]
     */
    public void setJssj(Timestamp jssj){
        this.jssj = jssj ;
        this.modify("jssj",jssj);
    }

    /**
     * 格式化日期 [结束时间]
     */
    public String formatJssj(){
        if (this.jssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jssj);
    }
    /**
     * 设置 [开始时间]
     */
    public void setKssj(Timestamp kssj){
        this.kssj = kssj ;
        this.modify("kssj",kssj);
    }

    /**
     * 格式化日期 [开始时间]
     */
    public String formatKssj(){
        if (this.kssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(kssj);
    }
    /**
     * 设置 [绩效量化目标名称]
     */
    public void setParjxlhmbname(String parjxlhmbname){
        this.parjxlhmbname = parjxlhmbname ;
        this.modify("parjxlhmbname",parjxlhmbname);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


