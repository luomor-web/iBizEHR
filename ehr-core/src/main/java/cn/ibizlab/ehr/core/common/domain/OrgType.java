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
 * 实体[组织类型]
 */
@Data
@TableName(value = "T_SRFORGTYPE",resultMap = "OrgTypeResultMap")
public class OrgType extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 保留字段21
     */
    @TableField(value = "reserver21")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver21" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver21")
    private Timestamp reserver21;
    /**
     * 保留字段29
     */
    @TableField(value = "reserver29")
    @JSONField(name = "reserver29")
    @JsonProperty("reserver29")
    private String reserver29;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 保留字段19
     */
    @TableField(value = "reserver19")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver19" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver19")
    private Timestamp reserver19;
    /**
     * 保留字段30
     */
    @TableField(value = "reserver30")
    @JSONField(name = "reserver30")
    @JsonProperty("reserver30")
    private String reserver30;
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
     * 保留字段8
     */
    @TableField(value = "reserver8")
    @JSONField(name = "reserver8")
    @JsonProperty("reserver8")
    private String reserver8;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 保留字段5
     */
    @TableField(value = "reserver5")
    @JSONField(name = "reserver5")
    @JsonProperty("reserver5")
    private String reserver5;
    /**
     * 保留字段10
     */
    @TableField(value = "reserver10")
    @JSONField(name = "reserver10")
    @JsonProperty("reserver10")
    private String reserver10;
    /**
     * 保留字段16
     */
    @TableField(value = "reserver16")
    @JSONField(name = "reserver16")
    @JsonProperty("reserver16")
    private Double reserver16;
    /**
     * 保留字段9
     */
    @TableField(value = "reserver9")
    @JSONField(name = "reserver9")
    @JsonProperty("reserver9")
    private String reserver9;
    /**
     * 保留字段27
     */
    @TableField(value = "reserver27")
    @JSONField(name = "reserver27")
    @JsonProperty("reserver27")
    private String reserver27;
    /**
     * 保留字段17
     */
    @TableField(value = "reserver17")
    @JSONField(name = "reserver17")
    @JsonProperty("reserver17")
    private Double reserver17;
    /**
     * 组织类型标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "orgtypeid",type=IdType.UUID)
    @JSONField(name = "orgtypeid")
    @JsonProperty("orgtypeid")
    private String orgtypeid;
    /**
     * 保留字段6
     */
    @TableField(value = "reserver6")
    @JSONField(name = "reserver6")
    @JsonProperty("reserver6")
    private String reserver6;
    /**
     * 组织类型名称
     */
    @TableField(value = "orgtypename")
    @JSONField(name = "orgtypename")
    @JsonProperty("orgtypename")
    private String orgtypename;
    /**
     * 保留字段14
     */
    @TableField(value = "reserver14")
    @JSONField(name = "reserver14")
    @JsonProperty("reserver14")
    private Integer reserver14;
    /**
     * 保留字段12
     */
    @TableField(value = "reserver12")
    @JSONField(name = "reserver12")
    @JsonProperty("reserver12")
    private Integer reserver12;
    /**
     * 保留字段28
     */
    @TableField(value = "reserver28")
    @JSONField(name = "reserver28")
    @JsonProperty("reserver28")
    private String reserver28;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 保留字段15
     */
    @TableField(value = "reserver15")
    @JSONField(name = "reserver15")
    @JsonProperty("reserver15")
    private Double reserver15;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 保留字段13
     */
    @TableField(value = "reserver13")
    @JSONField(name = "reserver13")
    @JsonProperty("reserver13")
    private Integer reserver13;
    /**
     * 保留字段11
     */
    @TableField(value = "reserver11")
    @JSONField(name = "reserver11")
    @JsonProperty("reserver11")
    private Integer reserver11;
    /**
     * 保留字段7
     */
    @TableField(value = "reserver7")
    @JSONField(name = "reserver7")
    @JsonProperty("reserver7")
    private String reserver7;
    /**
     * 保留字段22
     */
    @TableField(value = "reserver22")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver22" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver22")
    private Timestamp reserver22;
    /**
     * 保留字段20
     */
    @TableField(value = "reserver20")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver20" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver20")
    private Timestamp reserver20;
    /**
     * 保留字段23
     */
    @TableField(value = "reserver23")
    @JSONField(name = "reserver23")
    @JsonProperty("reserver23")
    private String reserver23;
    /**
     * 保留字段18
     */
    @TableField(value = "reserver18")
    @JSONField(name = "reserver18")
    @JsonProperty("reserver18")
    private Double reserver18;
    /**
     * 保留字段26
     */
    @TableField(value = "reserver26")
    @JSONField(name = "reserver26")
    @JsonProperty("reserver26")
    private String reserver26;
    /**
     * 保留字段24
     */
    @TableField(value = "reserver24")
    @JSONField(name = "reserver24")
    @JsonProperty("reserver24")
    private String reserver24;
    /**
     * 保留字段25
     */
    @TableField(value = "reserver25")
    @JSONField(name = "reserver25")
    @JsonProperty("reserver25")
    private String reserver25;



    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段21]
     */
    public void setReserver21(Timestamp reserver21){
        this.reserver21 = reserver21 ;
        this.modify("reserver21",reserver21);
    }
    /**
     * 设置 [保留字段29]
     */
    public void setReserver29(String reserver29){
        this.reserver29 = reserver29 ;
        this.modify("reserver29",reserver29);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [保留字段19]
     */
    public void setReserver19(Timestamp reserver19){
        this.reserver19 = reserver19 ;
        this.modify("reserver19",reserver19);
    }
    /**
     * 设置 [保留字段30]
     */
    public void setReserver30(String reserver30){
        this.reserver30 = reserver30 ;
        this.modify("reserver30",reserver30);
    }
    /**
     * 设置 [保留字段8]
     */
    public void setReserver8(String reserver8){
        this.reserver8 = reserver8 ;
        this.modify("reserver8",reserver8);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [保留字段5]
     */
    public void setReserver5(String reserver5){
        this.reserver5 = reserver5 ;
        this.modify("reserver5",reserver5);
    }
    /**
     * 设置 [保留字段10]
     */
    public void setReserver10(String reserver10){
        this.reserver10 = reserver10 ;
        this.modify("reserver10",reserver10);
    }
    /**
     * 设置 [保留字段16]
     */
    public void setReserver16(Double reserver16){
        this.reserver16 = reserver16 ;
        this.modify("reserver16",reserver16);
    }
    /**
     * 设置 [保留字段9]
     */
    public void setReserver9(String reserver9){
        this.reserver9 = reserver9 ;
        this.modify("reserver9",reserver9);
    }
    /**
     * 设置 [保留字段27]
     */
    public void setReserver27(String reserver27){
        this.reserver27 = reserver27 ;
        this.modify("reserver27",reserver27);
    }
    /**
     * 设置 [保留字段17]
     */
    public void setReserver17(Double reserver17){
        this.reserver17 = reserver17 ;
        this.modify("reserver17",reserver17);
    }
    /**
     * 设置 [保留字段6]
     */
    public void setReserver6(String reserver6){
        this.reserver6 = reserver6 ;
        this.modify("reserver6",reserver6);
    }
    /**
     * 设置 [组织类型名称]
     */
    public void setOrgtypename(String orgtypename){
        this.orgtypename = orgtypename ;
        this.modify("orgtypename",orgtypename);
    }
    /**
     * 设置 [保留字段14]
     */
    public void setReserver14(Integer reserver14){
        this.reserver14 = reserver14 ;
        this.modify("reserver14",reserver14);
    }
    /**
     * 设置 [保留字段12]
     */
    public void setReserver12(Integer reserver12){
        this.reserver12 = reserver12 ;
        this.modify("reserver12",reserver12);
    }
    /**
     * 设置 [保留字段28]
     */
    public void setReserver28(String reserver28){
        this.reserver28 = reserver28 ;
        this.modify("reserver28",reserver28);
    }
    /**
     * 设置 [保留字段15]
     */
    public void setReserver15(Double reserver15){
        this.reserver15 = reserver15 ;
        this.modify("reserver15",reserver15);
    }
    /**
     * 设置 [保留字段13]
     */
    public void setReserver13(Integer reserver13){
        this.reserver13 = reserver13 ;
        this.modify("reserver13",reserver13);
    }
    /**
     * 设置 [保留字段11]
     */
    public void setReserver11(Integer reserver11){
        this.reserver11 = reserver11 ;
        this.modify("reserver11",reserver11);
    }
    /**
     * 设置 [保留字段7]
     */
    public void setReserver7(String reserver7){
        this.reserver7 = reserver7 ;
        this.modify("reserver7",reserver7);
    }
    /**
     * 设置 [保留字段22]
     */
    public void setReserver22(Timestamp reserver22){
        this.reserver22 = reserver22 ;
        this.modify("reserver22",reserver22);
    }
    /**
     * 设置 [保留字段20]
     */
    public void setReserver20(Timestamp reserver20){
        this.reserver20 = reserver20 ;
        this.modify("reserver20",reserver20);
    }
    /**
     * 设置 [保留字段23]
     */
    public void setReserver23(String reserver23){
        this.reserver23 = reserver23 ;
        this.modify("reserver23",reserver23);
    }
    /**
     * 设置 [保留字段18]
     */
    public void setReserver18(Double reserver18){
        this.reserver18 = reserver18 ;
        this.modify("reserver18",reserver18);
    }
    /**
     * 设置 [保留字段26]
     */
    public void setReserver26(String reserver26){
        this.reserver26 = reserver26 ;
        this.modify("reserver26",reserver26);
    }
    /**
     * 设置 [保留字段24]
     */
    public void setReserver24(String reserver24){
        this.reserver24 = reserver24 ;
        this.modify("reserver24",reserver24);
    }
    /**
     * 设置 [保留字段25]
     */
    public void setReserver25(String reserver25){
        this.reserver25 = reserver25 ;
        this.modify("reserver25",reserver25);
    }

}


