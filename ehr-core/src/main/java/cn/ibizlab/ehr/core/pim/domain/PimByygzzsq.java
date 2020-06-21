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
 * 实体[B/Y类员工转正申请]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMBYYGZZSQ",resultMap = "PimByygzzsqResultMap")
public class PimByygzzsq extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 转正类型
     */
    @TableField(value = "zzlx")
    @JSONField(name = "zzlx")
    @JsonProperty("zzlx")
    private String zzlx;
    /**
     * 是否为临时数据
     */
    @TableField(value = "istemp")
    @JSONField(name = "istemp")
    @JsonProperty("istemp")
    private Integer istemp;
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
     * 操作日期
     */
    @TableField(value = "czrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "czrq" , format="yyyy-MM-dd")
    @JsonProperty("czrq")
    private Timestamp czrq;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 标题
     */
    @TableField(value = "pimbyygzzsqname")
    @JSONField(name = "pimbyygzzsqname")
    @JsonProperty("pimbyygzzsqname")
    private String pimbyygzzsqname;
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
     * 生效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 操作人
     */
    @TableField(value = "czr")
    @JSONField(name = "czr")
    @JsonProperty("czr")
    private String czr;
    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimbyygzzsqid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimbyygzzsqid")
    @JsonProperty("pimbyygzzsqid")
    private String pimbyygzzsqid;



    /**
     * 设置 [转正类型]
     */
    public void setZzlx(String zzlx){
        this.zzlx = zzlx ;
        this.modify("zzlx",zzlx);
    }

    /**
     * 设置 [是否为临时数据]
     */
    public void setIstemp(Integer istemp){
        this.istemp = istemp ;
        this.modify("istemp",istemp);
    }

    /**
     * 设置 [操作日期]
     */
    public void setCzrq(Timestamp czrq){
        this.czrq = czrq ;
        this.modify("czrq",czrq);
    }

    /**
     * 格式化日期 [操作日期]
     */
    public String formatCzrq(){
        if (this.czrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(czrq);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [标题]
     */
    public void setPimbyygzzsqname(String pimbyygzzsqname){
        this.pimbyygzzsqname = pimbyygzzsqname ;
        this.modify("pimbyygzzsqname",pimbyygzzsqname);
    }

    /**
     * 设置 [生效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [生效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [操作人]
     */
    public void setCzr(String czr){
        this.czr = czr ;
        this.modify("czr",czr);
    }


}


