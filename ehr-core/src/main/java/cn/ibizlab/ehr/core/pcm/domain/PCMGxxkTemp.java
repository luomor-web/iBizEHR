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
 * 实体[高校学科中间表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMGXXKTEMP",resultMap = "PCMGxxkTempResultMap")
public class PCMGxxkTemp extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 高校学科中间表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmgxxktempid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmgxxktempid")
    @JsonProperty("pcmgxxktempid")
    private String pcmgxxktempid;
    /**
     * 高校学科中间表名称
     */
    @TableField(value = "pcmgxxktempname")
    @JSONField(name = "pcmgxxktempname")
    @JsonProperty("pcmgxxktempname")
    private String pcmgxxktempname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 高校名录年度
     */
    @TableField(exist = false)
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 学科目录年度
     */
    @TableField(exist = false)
    @JSONField(name = "nd2")
    @JsonProperty("nd2")
    private String nd2;
    /**
     * 高校名称
     */
    @TableField(exist = false)
    @JSONField(name = "pcmgxmlname")
    @JsonProperty("pcmgxmlname")
    private String pcmgxmlname;
    /**
     * 学科名称
     */
    @TableField(exist = false)
    @JSONField(name = "pcmxkmlname")
    @JsonProperty("pcmxkmlname")
    private String pcmxkmlname;
    /**
     * 学科目录标识
     */
    @TableField(value = "pcmxkmlid")
    @JSONField(name = "pcmxkmlid")
    @JsonProperty("pcmxkmlid")
    private String pcmxkmlid;
    /**
     * 高校名录标识
     */
    @TableField(value = "pcmgxmlid")
    @JSONField(name = "pcmgxmlid")
    @JsonProperty("pcmgxmlid")
    private String pcmgxmlid;

    /**
     * 高校名录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmGxml pcmgxml;

    /**
     * 学科名录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmXkml pcmxkml;



    /**
     * 设置 [高校学科中间表名称]
     */
    public void setPcmgxxktempname(String pcmgxxktempname){
        this.pcmgxxktempname = pcmgxxktempname ;
        this.modify("pcmgxxktempname",pcmgxxktempname);
    }

    /**
     * 设置 [学科目录标识]
     */
    public void setPcmxkmlid(String pcmxkmlid){
        this.pcmxkmlid = pcmxkmlid ;
        this.modify("pcmxkmlid",pcmxkmlid);
    }

    /**
     * 设置 [高校名录标识]
     */
    public void setPcmgxmlid(String pcmgxmlid){
        this.pcmgxmlid = pcmgxmlid ;
        this.modify("pcmgxmlid",pcmgxmlid);
    }


    /**
     * 获取 [高校学科中间表标识]
     */
    public String getPcmgxxktempid(){
        if(ObjectUtils.isEmpty(pcmgxxktempid)){
            pcmgxxktempid=(String)getDefaultKey(true);
        }
        return pcmgxxktempid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getPcmgxmlid()))&&(!ObjectUtils.isEmpty(this.getPcmxkmlid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getPcmgxmlid(),this.getPcmxkmlid()).getBytes());
        return null;
    }
}


