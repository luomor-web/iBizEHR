package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[职务管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMDUTY",resultMap = "OrmDutyResultMap")
public class OrmDuty extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职务标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormdutyid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 职务编码
     */
    @TableField(value = "fglx")
    @JSONField(name = "fglx")
    @JsonProperty("fglx")
    private String fglx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职务级别
     */
    @TableField(value = "zwjb")
    @JSONField(name = "zwjb")
    @JsonProperty("zwjb")
    private String zwjb;
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
     * 对应职级
     */
    @TableField(value = "dyzj")
    @JSONField(name = "dyzj")
    @JsonProperty("dyzj")
    private String dyzj;
    /**
     * 建议交流年限
     */
    @TableField(value = "nx")
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Integer nx;
    /**
     * 层级
     */
    @TableField(value = "zwlb")
    @JSONField(name = "zwlb")
    @JsonProperty("zwlb")
    private String zwlb;
    /**
     * 必须交流年限
     */
    @TableField(value = "bxjlnx")
    @JSONField(name = "bxjlnx")
    @JsonProperty("bxjlnx")
    private Integer bxjlnx;
    /**
     * 职务
     */
    @TableField(value = "ormdutyname")
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;



    /**
     * 设置 [职务编码]
     */
    public void setFglx(String fglx){
        this.fglx = fglx ;
        this.modify("fglx",fglx);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [职务级别]
     */
    public void setZwjb(String zwjb){
        this.zwjb = zwjb ;
        this.modify("zwjb",zwjb);
    }

    /**
     * 设置 [对应职级]
     */
    public void setDyzj(String dyzj){
        this.dyzj = dyzj ;
        this.modify("dyzj",dyzj);
    }

    /**
     * 设置 [建议交流年限]
     */
    public void setNx(Integer nx){
        this.nx = nx ;
        this.modify("nx",nx);
    }

    /**
     * 设置 [层级]
     */
    public void setZwlb(String zwlb){
        this.zwlb = zwlb ;
        this.modify("zwlb",zwlb);
    }

    /**
     * 设置 [必须交流年限]
     */
    public void setBxjlnx(Integer bxjlnx){
        this.bxjlnx = bxjlnx ;
        this.modify("bxjlnx",bxjlnx);
    }

    /**
     * 设置 [职务]
     */
    public void setOrmdutyname(String ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }


}


