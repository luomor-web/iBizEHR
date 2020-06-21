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
 * 实体[应聘者审批原因]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMPROFILESPYY",resultMap = "PcmProfileSpyyResultMap")
public class PcmProfileSpyy extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 原因编码
     */
    @TableField(value = "yybm")
    @JSONField(name = "yybm")
    @JsonProperty("yybm")
    private String yybm;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 应聘者审批原因名称
     */
    @TableField(value = "pcmprofilespyyname")
    @JSONField(name = "pcmprofilespyyname")
    @JsonProperty("pcmprofilespyyname")
    private String pcmprofilespyyname;
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
     * 应聘者审批原因标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmprofilespyyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmprofilespyyid")
    @JsonProperty("pcmprofilespyyid")
    private String pcmprofilespyyid;
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
     * 原因名称
     */
    @TableField(value = "yymc")
    @JSONField(name = "yymc")
    @JsonProperty("yymc")
    private String yymc;



    /**
     * 设置 [原因编码]
     */
    public void setYybm(String yybm){
        this.yybm = yybm ;
        this.modify("yybm",yybm);
    }

    /**
     * 设置 [应聘者审批原因名称]
     */
    public void setPcmprofilespyyname(String pcmprofilespyyname){
        this.pcmprofilespyyname = pcmprofilespyyname ;
        this.modify("pcmprofilespyyname",pcmprofilespyyname);
    }

    /**
     * 设置 [原因名称]
     */
    public void setYymc(String yymc){
        this.yymc = yymc ;
        this.modify("yymc",yymc);
    }


}


