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
 * 实体[绩效年度考核结果]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXNDKHJG",resultMap = "ParJxndkhjgResultMap")
public class ParJxndkhjg extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核年度
     */
    @TableField(value = "khnd")
    @JSONField(name = "khnd")
    @JsonProperty("khnd")
    private String khnd;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 考核周期
     */
    @TableField(value = "khzq")
    @JSONField(name = "khzq")
    @JsonProperty("khzq")
    private String khzq;
    /**
     * 考核定级
     */
    @TableField(value = "khpgdj")
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;
    /**
     * 排名
     */
    @TableField(value = "pm")
    @JSONField(name = "pm")
    @JsonProperty("pm")
    private Integer pm;
    /**
     * 绩效年度考核结果名称
     */
    @TableField(value = "parjxndkhjgname")
    @JSONField(name = "parjxndkhjgname")
    @JsonProperty("parjxndkhjgname")
    private String parjxndkhjgname;
    /**
     * 是否提醒
     */
    @TableField(value = "sftx")
    @JSONField(name = "sftx")
    @JsonProperty("sftx")
    private Integer sftx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 绩效年度考核结果标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxndkhjgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxndkhjgid")
    @JsonProperty("parjxndkhjgid")
    private String parjxndkhjgid;
    /**
     * 总分
     */
    @TableField(value = "zf")
    @JSONField(name = "zf")
    @JsonProperty("zf")
    private Double zf;
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
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 考核人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [考核年度]
     */
    public void setKhnd(String khnd){
        this.khnd = khnd ;
        this.modify("khnd",khnd);
    }

    /**
     * 设置 [考核周期]
     */
    public void setKhzq(String khzq){
        this.khzq = khzq ;
        this.modify("khzq",khzq);
    }

    /**
     * 设置 [考核定级]
     */
    public void setKhpgdj(String khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [排名]
     */
    public void setPm(Integer pm){
        this.pm = pm ;
        this.modify("pm",pm);
    }

    /**
     * 设置 [绩效年度考核结果名称]
     */
    public void setParjxndkhjgname(String parjxndkhjgname){
        this.parjxndkhjgname = parjxndkhjgname ;
        this.modify("parjxndkhjgname",parjxndkhjgname);
    }

    /**
     * 设置 [是否提醒]
     */
    public void setSftx(Integer sftx){
        this.sftx = sftx ;
        this.modify("sftx",sftx);
    }

    /**
     * 设置 [总分]
     */
    public void setZf(Double zf){
        this.zf = zf ;
        this.modify("zf",zf);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


