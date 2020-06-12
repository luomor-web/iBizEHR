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
 * 实体[单位社保账户]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SOCCOMPANYWEL",resultMap = "SocCompanyWelResultMap")
public class SocCompanyWel extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 单位社保账户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "soccompanywelid",type=IdType.UUID)
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 单位社保账户
     */
    @TableField(value = "soccompanywelname")
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 社保参保地名称
     */
    @TableField(exist = false)
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 社保参保地标识
     */
    @TableField(value = "socselfarebaseid")
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;

    /**
     * 单位组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 参保地管理
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.soc.domain.SocSelfareBase socselfarebase;



    /**
     * 设置 [单位社保账户]
     */
    public void setSoccompanywelname(String soccompanywelname){
        this.soccompanywelname = soccompanywelname ;
        this.modify("soccompanywelname",soccompanywelname);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [社保参保地标识]
     */
    public void setSocselfarebaseid(String socselfarebaseid){
        this.socselfarebaseid = socselfarebaseid ;
        this.modify("socselfarebaseid",socselfarebaseid);
    }


}


