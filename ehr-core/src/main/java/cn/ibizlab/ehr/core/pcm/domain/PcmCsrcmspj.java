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
 * 实体[成熟人才面试评价]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMCSRCMSPJ",resultMap = "PcmCsrcmspjResultMap")
public class PcmCsrcmspj extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成熟人才面试评价标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmcsrcmspjid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmcsrcmspjid")
    @JsonProperty("pcmcsrcmspjid")
    private String pcmcsrcmspjid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 面试评价
     */
    @TableField(value = "mspj")
    @JSONField(name = "mspj")
    @JsonProperty("mspj")
    private String mspj;
    /**
     * 面试成绩
     */
    @TableField(value = "mscj")
    @JSONField(name = "mscj")
    @JsonProperty("mscj")
    private Double mscj;
    /**
     * 员工
     */
    @TableField(value = "ygmc")
    @JSONField(name = "ygmc")
    @JsonProperty("ygmc")
    private String ygmc;
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
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
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
     * 成熟人才面试评价名称
     */
    @TableField(value = "pcmcsrcmspjname")
    @JSONField(name = "pcmcsrcmspjname")
    @JsonProperty("pcmcsrcmspjname")
    private String pcmcsrcmspjname;



    /**
     * 设置 [面试评价]
     */
    public void setMspj(String mspj){
        this.mspj = mspj ;
        this.modify("mspj",mspj);
    }

    /**
     * 设置 [面试成绩]
     */
    public void setMscj(Double mscj){
        this.mscj = mscj ;
        this.modify("mscj",mscj);
    }

    /**
     * 设置 [员工]
     */
    public void setYgmc(String ygmc){
        this.ygmc = ygmc ;
        this.modify("ygmc",ygmc);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [成熟人才面试评价名称]
     */
    public void setPcmcsrcmspjname(String pcmcsrcmspjname){
        this.pcmcsrcmspjname = pcmcsrcmspjname ;
        this.modify("pcmcsrcmspjname",pcmcsrcmspjname);
    }


}


