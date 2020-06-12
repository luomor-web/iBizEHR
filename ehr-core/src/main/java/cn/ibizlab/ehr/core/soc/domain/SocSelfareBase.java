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
 * 实体[参保地管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCSELFAREBASE",resultMap = "SocSelfareBaseResultMap")
public class SocSelfareBase extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参保地名称
     */
    @TableField(value = "socselfarebasename")
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;
    /**
     * 参保地区
     */
    @TableField(value = "cbdq")
    @JSONField(name = "cbdq")
    @JsonProperty("cbdq")
    private String cbdq;
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
     * 参保地标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "socselfarebaseid",type=IdType.UUID)
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 个人社保比例(%)
     */
    @TableField(value = "grsbbl")
    @JSONField(name = "grsbbl")
    @JsonProperty("grsbbl")
    private String grsbbl;
    /**
     * 社保福利类型
     */
    @TableField(value = "sblx")
    @JSONField(name = "sblx")
    @JsonProperty("sblx")
    private String sblx;
    /**
     * 参保单位
     */
    @TableField(value = "cbdw")
    @JSONField(name = "cbdw")
    @JsonProperty("cbdw")
    private String cbdw;
    /**
     * 单位社保比例(%)
     */
    @TableField(value = "dwsbbli")
    @JSONField(name = "dwsbbli")
    @JsonProperty("dwsbbli")
    private String dwsbbli;
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
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 组织信息管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [参保地名称]
     */
    public void setSocselfarebasename(String socselfarebasename){
        this.socselfarebasename = socselfarebasename ;
        this.modify("socselfarebasename",socselfarebasename);
    }

    /**
     * 设置 [参保地区]
     */
    public void setCbdq(String cbdq){
        this.cbdq = cbdq ;
        this.modify("cbdq",cbdq);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [个人社保比例(%)]
     */
    public void setGrsbbl(String grsbbl){
        this.grsbbl = grsbbl ;
        this.modify("grsbbl",grsbbl);
    }

    /**
     * 设置 [社保福利类型]
     */
    public void setSblx(String sblx){
        this.sblx = sblx ;
        this.modify("sblx",sblx);
    }

    /**
     * 设置 [参保单位]
     */
    public void setCbdw(String cbdw){
        this.cbdw = cbdw ;
        this.modify("cbdw",cbdw);
    }

    /**
     * 设置 [单位社保比例(%)]
     */
    public void setDwsbbli(String dwsbbli){
        this.dwsbbli = dwsbbli ;
        this.modify("dwsbbli",dwsbbli);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


