package cn.ibizlab.ehr.core.common.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[注册表]
 */
@Data
@TableName(value = "T_REGISTRY",resultMap = "RegistryResultMap")
public class Registry extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数8(500)
     */
    @TableField(value = "param8")
    @JSONField(name = "param8")
    @JsonProperty("param8")
    private String param8;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 参数5(500)
     */
    @TableField(value = "param5")
    @JSONField(name = "param5")
    @JsonProperty("param5")
    private String param5;
    /**
     * 参数1
     */
    @TableField(value = "param1")
    @JSONField(name = "param1")
    @JsonProperty("param1")
    private String param1;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 参数4(250)
     */
    @TableField(value = "param4")
    @JSONField(name = "param4")
    @JsonProperty("param4")
    private String param4;
    /**
     * 说明
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 参数7(500)
     */
    @TableField(value = "param7")
    @JSONField(name = "param7")
    @JsonProperty("param7")
    private String param7;
    /**
     * 参数6(500)
     */
    @TableField(value = "param6")
    @JSONField(name = "param6")
    @JsonProperty("param6")
    private String param6;
    /**
     * 目录
     */
    @DEField(name = "section")
    @TableField(value = "section")
    @JSONField(name = "sector")
    @JsonProperty("sector")
    private String sector;
    /**
     * 注册表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "registryid",type=IdType.UUID)
    @JSONField(name = "registryid")
    @JsonProperty("registryid")
    private String registryid;
    /**
     * 系统目录
     */
    @TableField(value = "registryname")
    @JSONField(name = "registryname")
    @JsonProperty("registryname")
    private String registryname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 参数2
     */
    @TableField(value = "param2")
    @JSONField(name = "param2")
    @JsonProperty("param2")
    private String param2;
    /**
     * 参数9
     */
    @TableField(value = "param9")
    @JSONField(name = "param9")
    @JsonProperty("param9")
    private String param9;
    /**
     * 参数3(250)
     */
    @TableField(value = "param3")
    @JSONField(name = "param3")
    @JsonProperty("param3")
    private String param3;



    /**
     * 设置 [参数8(500)]
     */
    public void setParam8(String param8){
        this.param8 = param8 ;
        this.modify("param8",param8);
    }
    /**
     * 设置 [参数5(500)]
     */
    public void setParam5(String param5){
        this.param5 = param5 ;
        this.modify("param5",param5);
    }
    /**
     * 设置 [参数1]
     */
    public void setParam1(String param1){
        this.param1 = param1 ;
        this.modify("param1",param1);
    }
    /**
     * 设置 [参数4(250)]
     */
    public void setParam4(String param4){
        this.param4 = param4 ;
        this.modify("param4",param4);
    }
    /**
     * 设置 [说明]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [参数7(500)]
     */
    public void setParam7(String param7){
        this.param7 = param7 ;
        this.modify("param7",param7);
    }
    /**
     * 设置 [参数6(500)]
     */
    public void setParam6(String param6){
        this.param6 = param6 ;
        this.modify("param6",param6);
    }
    /**
     * 设置 [目录]
     */
    public void setSector(String sector){
        this.sector = sector ;
        this.modify("section",sector);
    }
    /**
     * 设置 [系统目录]
     */
    public void setRegistryname(String registryname){
        this.registryname = registryname ;
        this.modify("registryname",registryname);
    }
    /**
     * 设置 [参数2]
     */
    public void setParam2(String param2){
        this.param2 = param2 ;
        this.modify("param2",param2);
    }
    /**
     * 设置 [参数9]
     */
    public void setParam9(String param9){
        this.param9 = param9 ;
        this.modify("param9",param9);
    }
    /**
     * 设置 [参数3(250)]
     */
    public void setParam3(String param3){
        this.param3 = param3 ;
        this.modify("param3",param3);
    }

    /**
     * 获取 [注册表标识]
     */
    public String getRegistryid(){
        if(ObjectUtils.isEmpty(registryid)){
            registryid=(String)getDefaultKey(true);
        }
        return registryid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getRegistryname()))&&(!ObjectUtils.isEmpty(this.getSector())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getRegistryname(),this.getSector()).getBytes());
        return null;
    }
}


