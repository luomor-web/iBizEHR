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
 * 实体[部门职务编制]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMDEPESTMAN",resultMap = "OrmDepEstManResultMap")
public class OrmDepEstMan extends EntityMP implements Serializable {

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
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 人数编制
     */
    @TableField(value = "numcompilation")
    @JSONField(name = "numcompilation")
    @JsonProperty("numcompilation")
    private Integer numcompilation;
    /**
     * 部门编制管理名称
     */
    @TableField(value = "ormdepestmanname")
    @JSONField(name = "ormdepestmanname")
    @JsonProperty("ormdepestmanname")
    private String ormdepestmanname;
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
     * 部门编制管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormdepestmanid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormdepestmanid")
    @JsonProperty("ormdepestmanid")
    private String ormdepestmanid;
    /**
     * 职务职责说明
     */
    @TableField(value = "zwzzsm")
    @JSONField(name = "zwzzsm")
    @JsonProperty("zwzzsm")
    private String zwzzsm;
    /**
     * 职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 职务编制
     */
    @TableField(exist = false)
    @JSONField(name = "ormzwbzmc")
    @JsonProperty("ormzwbzmc")
    private String ormzwbzmc;
    /**
     * 职务编制ID
     */
    @TableField(value = "ormzwbzid")
    @JSONField(name = "ormzwbzid")
    @JsonProperty("ormzwbzid")
    private String ormzwbzid;
    /**
     * 职务ID
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 职务编制
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormzwbz;



    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [人数编制]
     */
    public void setNumcompilation(Integer numcompilation){
        this.numcompilation = numcompilation ;
        this.modify("numcompilation",numcompilation);
    }

    /**
     * 设置 [部门编制管理名称]
     */
    public void setOrmdepestmanname(String ormdepestmanname){
        this.ormdepestmanname = ormdepestmanname ;
        this.modify("ormdepestmanname",ormdepestmanname);
    }

    /**
     * 设置 [职务职责说明]
     */
    public void setZwzzsm(String zwzzsm){
        this.zwzzsm = zwzzsm ;
        this.modify("zwzzsm",zwzzsm);
    }

    /**
     * 设置 [职务编制ID]
     */
    public void setOrmzwbzid(String ormzwbzid){
        this.ormzwbzid = ormzwbzid ;
        this.modify("ormzwbzid",ormzwbzid);
    }

    /**
     * 设置 [职务ID]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


    /**
     * 获取 [部门编制管理标识]
     */
    public String getOrmdepestmanid(){
        if(ObjectUtils.isEmpty(ormdepestmanid)){
            ormdepestmanid=(String)getDefaultKey(true);
        }
        return ormdepestmanid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getOrmzwbzid()))&&(!ObjectUtils.isEmpty(this.getOrmdutyid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getOrmzwbzid(),this.getOrmdutyid()).getBytes());
        return null;
    }
}


