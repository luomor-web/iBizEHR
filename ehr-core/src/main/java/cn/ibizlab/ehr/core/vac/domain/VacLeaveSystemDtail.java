package cn.ibizlab.ehr.core.vac.domain;

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
 * 实体[休假制度明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_VACLEAVESYSTEMDETAIL",resultMap = "VacLeaveSystemDtailResultMap")
public class VacLeaveSystemDtail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 休假制度明细名称
     */
    @TableField(value = "vacleavesystemdetailname")
    @JSONField(name = "vacleavesystemdetailname")
    @JsonProperty("vacleavesystemdetailname")
    private String vacleavesystemdetailname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 休假类型
     */
    @TableField(value = "xjlx")
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;
    /**
     * 休假规则
     */
    @TableField(value = "xjgz")
    @JSONField(name = "xjgz")
    @JsonProperty("xjgz")
    private String xjgz;
    /**
     * 休假制度明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacleavesystemdetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "vacleavesystemdetailid")
    @JsonProperty("vacleavesystemdetailid")
    private String vacleavesystemdetailid;
    /**
     * 休假规则公式
     */
    @TableField(value = "xjgzgs")
    @JSONField(name = "xjgzgs")
    @JsonProperty("xjgzgs")
    private String xjgzgs;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID)
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
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
     * 休假制度名称
     */
    @TableField(exist = false)
    @JSONField(name = "vacleavesystemname")
    @JsonProperty("vacleavesystemname")
    private String vacleavesystemname;
    /**
     * 休假制度管理标识
     */
    @TableField(value = "vacleavesystemid")
    @JSONField(name = "vacleavesystemid")
    @JsonProperty("vacleavesystemid")
    private String vacleavesystemid;

    /**
     * 休假制度管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VacLeaveSystem vacleavesystem;



    /**
     * 设置 [休假制度明细名称]
     */
    public void setVacleavesystemdetailname(String vacleavesystemdetailname){
        this.vacleavesystemdetailname = vacleavesystemdetailname ;
        this.modify("vacleavesystemdetailname",vacleavesystemdetailname);
    }

    /**
     * 设置 [休假类型]
     */
    public void setXjlx(String xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [休假规则]
     */
    public void setXjgz(String xjgz){
        this.xjgz = xjgz ;
        this.modify("xjgz",xjgz);
    }

    /**
     * 设置 [休假规则公式]
     */
    public void setXjgzgs(String xjgzgs){
        this.xjgzgs = xjgzgs ;
        this.modify("xjgzgs",xjgzgs);
    }

    /**
     * 设置 [休假制度管理标识]
     */
    public void setVacleavesystemid(String vacleavesystemid){
        this.vacleavesystemid = vacleavesystemid ;
        this.modify("vacleavesystemid",vacleavesystemid);
    }


}


