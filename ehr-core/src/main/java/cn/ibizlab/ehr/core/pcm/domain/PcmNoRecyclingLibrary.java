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
 * 实体[员工编号回收库]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMNORECYCLINGLIBRARY",resultMap = "PcmNoRecyclingLibraryResultMap")
public class PcmNoRecyclingLibrary extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号回收库标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmnorecyclinglibraryid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmnorecyclinglibraryid")
    @JsonProperty("pcmnorecyclinglibraryid")
    private String pcmnorecyclinglibraryid;
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
     * 员工类型
     */
    @TableField(value = "yglx")
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;
    /**
     * 组织
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 员工编号回收库名称
     */
    @TableField(value = "pcmnorecyclinglibraryname")
    @JSONField(name = "pcmnorecyclinglibraryname")
    @JsonProperty("pcmnorecyclinglibraryname")
    private String pcmnorecyclinglibraryname;
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
     * 是否可用
     */
    @TableField(value = "useful")
    @JSONField(name = "useful")
    @JsonProperty("useful")
    private Integer useful;
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
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;



    /**
     * 设置 [员工类型]
     */
    public void setYglx(String yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [组织]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [员工编号回收库名称]
     */
    public void setPcmnorecyclinglibraryname(String pcmnorecyclinglibraryname){
        this.pcmnorecyclinglibraryname = pcmnorecyclinglibraryname ;
        this.modify("pcmnorecyclinglibraryname",pcmnorecyclinglibraryname);
    }

    /**
     * 设置 [是否可用]
     */
    public void setUseful(Integer useful){
        this.useful = useful ;
        this.modify("useful",useful);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }


}


