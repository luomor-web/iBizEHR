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
 * 实体[考核对象]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARKHFA",resultMap = "ParKhfaResultMap")
public class ParKhfa extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设置时间
     */
    @TableField(value = "szsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "szsj" , format="yyyy-MM-dd")
    @JsonProperty("szsj")
    private Timestamp szsj;
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
     * 考核对象
     */
    @TableField(value = "parkhfaname")
    @JSONField(name = "parkhfaname")
    @JsonProperty("parkhfaname")
    private String parkhfaname;
    /**
     * 考核对象标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parkhfaid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parkhfaid")
    @JsonProperty("parkhfaid")
    private String parkhfaid;
    /**
     * 考核对象
     */
    @TableField(value = "khdx")
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 是否有效
     */
    @TableField(value = "availableflag")
    @JSONField(name = "availableflag")
    @JsonProperty("availableflag")
    private String availableflag;



    /**
     * 设置 [设置时间]
     */
    public void setSzsj(Timestamp szsj){
        this.szsj = szsj ;
        this.modify("szsj",szsj);
    }

    /**
     * 格式化日期 [设置时间]
     */
    public String formatSzsj(){
        if (this.szsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(szsj);
    }
    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [考核对象]
     */
    public void setParkhfaname(String parkhfaname){
        this.parkhfaname = parkhfaname ;
        this.modify("parkhfaname",parkhfaname);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhdx(String khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [是否有效]
     */
    public void setAvailableflag(String availableflag){
        this.availableflag = availableflag ;
        this.modify("availableflag",availableflag);
    }


}


