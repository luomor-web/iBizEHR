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
 * 实体[注册证书]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMCERTOFREG",resultMap = "PcmCertofregResultMap")
public class PcmCertofreg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 证书类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
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
     * 证书名称
     */
    @TableField(value = "pcmcertofregname")
    @JSONField(name = "pcmcertofregname")
    @JsonProperty("pcmcertofregname")
    private String pcmcertofregname;
    /**
     * 证书编号
     */
    @TableField(value = "bh")
    @JSONField(name = "bh")
    @JsonProperty("bh")
    private String bh;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 注册证书标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmcertofregid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmcertofregid")
    @JsonProperty("pcmcertofregid")
    private String pcmcertofregid;
    /**
     * 证书附件
     */
    @TableField(value = "zsfj")
    @JSONField(name = "zsfj")
    @JsonProperty("zsfj")
    private String zsfj;
    /**
     * 证件号码
     */
    @TableField(exist = false)
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;
    /**
     * 证书名称
     */
    @TableField(exist = false)
    @JSONField(name = "zyzgzy")
    @JsonProperty("zyzgzy")
    private String zyzgzy;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;
    /**
     * 执业资格专业编码
     */
    @TableField(value = "pimqualmajorid")
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 应聘者信息-注册证书
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;

    /**
     * 执业资格专业-注册证书
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimQualMajor pimqualmajor;



    /**
     * 设置 [证书类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [证书名称]
     */
    public void setPcmcertofregname(String pcmcertofregname){
        this.pcmcertofregname = pcmcertofregname ;
        this.modify("pcmcertofregname",pcmcertofregname);
    }

    /**
     * 设置 [证书编号]
     */
    public void setBh(String bh){
        this.bh = bh ;
        this.modify("bh",bh);
    }

    /**
     * 设置 [证书附件]
     */
    public void setZsfj(String zsfj){
        this.zsfj = zsfj ;
        this.modify("zsfj",zsfj);
    }

    /**
     * 设置 [执业资格专业编码]
     */
    public void setPimqualmajorid(String pimqualmajorid){
        this.pimqualmajorid = pimqualmajorid ;
        this.modify("pimqualmajorid",pimqualmajorid);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


