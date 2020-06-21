package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[绩效面谈反馈]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXMTFK",resultMap = "ParJxmtfkResultMap")
public class ParJxmtfk extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面谈内容
     */
    @TableField(value = "mtnr")
    @JSONField(name = "mtnr")
    @JsonProperty("mtnr")
    private String mtnr;
    /**
     * 员工陈述
     */
    @TableField(value = "ygcs")
    @JSONField(name = "ygcs")
    @JsonProperty("ygcs")
    private String ygcs;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 标题
     */
    @TableField(value = "parjxmtfkname")
    @JSONField(name = "parjxmtfkname")
    @JsonProperty("parjxmtfkname")
    private String parjxmtfkname;
    /**
     * 绩效面谈反馈标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxmtfkid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxmtfkid")
    @JsonProperty("parjxmtfkid")
    private String parjxmtfkid;
    /**
     * 附件信息
     */
    @TableField(value = "fjxx")
    @JSONField(name = "fjxx")
    @JsonProperty("fjxx")
    private String fjxx;
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
     * 所属组织
     */
    @TableField(exist = false)
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;
    /**
     * 员工
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 所属部门
     */
    @TableField(exist = false)
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [面谈内容]
     */
    public void setMtnr(String mtnr){
        this.mtnr = mtnr ;
        this.modify("mtnr",mtnr);
    }

    /**
     * 设置 [员工陈述]
     */
    public void setYgcs(String ygcs){
        this.ygcs = ygcs ;
        this.modify("ygcs",ygcs);
    }

    /**
     * 设置 [标题]
     */
    public void setParjxmtfkname(String parjxmtfkname){
        this.parjxmtfkname = parjxmtfkname ;
        this.modify("parjxmtfkname",parjxmtfkname);
    }

    /**
     * 设置 [附件信息]
     */
    public void setFjxx(String fjxx){
        this.fjxx = fjxx ;
        this.modify("fjxx",fjxx);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


