package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[附件信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMENCLOSURE",resultMap = "PimEnclosureResultMap")
public class PimEnclosure extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
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
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
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
     * 附件信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimenclosureid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimenclosureid")
    @JsonProperty("pimenclosureid")
    private String pimenclosureid;
    /**
     * 附件信息名称
     */
    @TableField(value = "pimenclosurename")
    @JSONField(name = "pimenclosurename")
    @JsonProperty("pimenclosurename")
    private String pimenclosurename;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 附件分类
     */
    @TableField(value = "fjfl")
    @JSONField(name = "fjfl")
    @JsonProperty("fjfl")
    private String fjfl;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 附件路径
     */
    @TableField(value = "fjlj")
    @JSONField(name = "fjlj")
    @JsonProperty("fjlj")
    private String fjlj;
    /**
     * USERSTATE
     */
    @TableField(value = "userstate")
    @JSONField(name = "userstate")
    @JsonProperty("userstate")
    private String userstate;
    /**
     * 附件快照
     */
    @TableField(value = "fjkz")
    @JSONField(name = "fjkz")
    @JsonProperty("fjkz")
    private String fjkz;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 人员信息名称
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 附件信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [附件信息名称]
     */
    public void setPimenclosurename(String pimenclosurename){
        this.pimenclosurename = pimenclosurename ;
        this.modify("pimenclosurename",pimenclosurename);
    }

    /**
     * 设置 [附件分类]
     */
    public void setFjfl(String fjfl){
        this.fjfl = fjfl ;
        this.modify("fjfl",fjfl);
    }

    /**
     * 设置 [附件路径]
     */
    public void setFjlj(String fjlj){
        this.fjlj = fjlj ;
        this.modify("fjlj",fjlj);
    }

    /**
     * 设置 [USERSTATE]
     */
    public void setUserstate(String userstate){
        this.userstate = userstate ;
        this.modify("userstate",userstate);
    }

    /**
     * 设置 [附件快照]
     */
    public void setFjkz(String fjkz){
        this.fjkz = fjkz ;
        this.modify("fjkz",fjkz);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


