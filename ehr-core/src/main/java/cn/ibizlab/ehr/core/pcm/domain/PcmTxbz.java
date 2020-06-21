package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[退休标准管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMTXBZ",resultMap = "PcmTxbzResultMap")
public class PcmTxbz extends EntityMP implements Serializable {

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
     * 退休标准管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmtxbzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmtxbzid")
    @JsonProperty("pcmtxbzid")
    private String pcmtxbzid;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;
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
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 退休年龄
     */
    @TableField(value = "txnl")
    @JSONField(name = "txnl")
    @JsonProperty("txnl")
    private Integer txnl;
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
     * 退休标准管理名称
     */
    @TableField(value = "pcmtxbzname")
    @JSONField(name = "pcmtxbzname")
    @JsonProperty("pcmtxbzname")
    private String pcmtxbzname;



    /**
     * 设置 [排序号]
     */
    public void setXh(String xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [退休年龄]
     */
    public void setTxnl(Integer txnl){
        this.txnl = txnl ;
        this.modify("txnl",txnl);
    }

    /**
     * 设置 [退休标准管理名称]
     */
    public void setPcmtxbzname(String pcmtxbzname){
        this.pcmtxbzname = pcmtxbzname ;
        this.modify("pcmtxbzname",pcmtxbzname);
    }


}


