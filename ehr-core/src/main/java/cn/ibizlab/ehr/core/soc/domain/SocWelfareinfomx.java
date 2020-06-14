package cn.ibizlab.ehr.core.soc.domain;

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
 * 实体[个人社保福利明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCWELFAREINFOMX",resultMap = "SocWelfareinfomxResultMap")
public class SocWelfareinfomx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 个人社保福利标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socwelfareinfomxid",type=IdType.UUID)
    @JSONField(name = "socwelfareinfomxid")
    @JsonProperty("socwelfareinfomxid")
    private String socwelfareinfomxid;
    /**
     * 单位基数
     */
    @TableField(value = "dwjs")
    @JSONField(name = "dwjs")
    @JsonProperty("dwjs")
    private String dwjs;
    /**
     * 个人社保福利明细名称
     */
    @TableField(value = "socwelfareinfomxname")
    @JSONField(name = "socwelfareinfomxname")
    @JsonProperty("socwelfareinfomxname")
    private String socwelfareinfomxname;
    /**
     * 个人基数
     */
    @TableField(value = "grjs")
    @JSONField(name = "grjs")
    @JsonProperty("grjs")
    private String grjs;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
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
     * 说明
     */
    @TableField(exist = false)
    @JSONField(name = "sm")
    @JsonProperty("sm")
    private String sm;
    /**
     * 个人社保福利名称
     */
    @TableField(exist = false)
    @JSONField(name = "socwelfareinfoname")
    @JsonProperty("socwelfareinfoname")
    private String socwelfareinfoname;
    /**
     * 单位比例(%)
     */
    @TableField(exist = false)
    @JSONField(name = "dwbl")
    @JsonProperty("dwbl")
    private String dwbl;
    /**
     * 上限(￥)
     */
    @TableField(exist = false)
    @JSONField(name = "de")
    @JsonProperty("de")
    private String de;
    /**
     * 个人比例(%)
     */
    @TableField(exist = false)
    @JSONField(name = "grbl")
    @JsonProperty("grbl")
    private String grbl;
    /**
     * 社保福利类型
     */
    @TableField(exist = false)
    @JSONField(name = "sbfllx")
    @JsonProperty("sbfllx")
    private String sbfllx;
    /**
     * 社保明细标识
     */
    @TableField(value = "socselfarebasemxid")
    @JSONField(name = "socselfarebasemxid")
    @JsonProperty("socselfarebasemxid")
    private String socselfarebasemxid;
    /**
     * 个人社保福利明细标识
     */
    @TableField(value = "socwelfareinfoid")
    @JSONField(name = "socwelfareinfoid")
    @JsonProperty("socwelfareinfoid")
    private String socwelfareinfoid;

    /**
     * 社保明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx socselfarebasemx;

    /**
     * 个人社保福利明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo socwelfareinfo;



    /**
     * 设置 [单位基数]
     */
    public void setDwjs(String dwjs){
        this.dwjs = dwjs ;
        this.modify("dwjs",dwjs);
    }

    /**
     * 设置 [个人社保福利明细名称]
     */
    public void setSocwelfareinfomxname(String socwelfareinfomxname){
        this.socwelfareinfomxname = socwelfareinfomxname ;
        this.modify("socwelfareinfomxname",socwelfareinfomxname);
    }

    /**
     * 设置 [个人基数]
     */
    public void setGrjs(String grjs){
        this.grjs = grjs ;
        this.modify("grjs",grjs);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [社保明细标识]
     */
    public void setSocselfarebasemxid(String socselfarebasemxid){
        this.socselfarebasemxid = socselfarebasemxid ;
        this.modify("socselfarebasemxid",socselfarebasemxid);
    }

    /**
     * 设置 [个人社保福利明细标识]
     */
    public void setSocwelfareinfoid(String socwelfareinfoid){
        this.socwelfareinfoid = socwelfareinfoid ;
        this.modify("socwelfareinfoid",socwelfareinfoid);
    }


}


