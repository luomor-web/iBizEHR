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
 * 实体[年度量化目标明细（职能部门级 ）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARZNBMNDLHMBMX",resultMap = "ParZnbmndlhmbmxResultMap")
public class ParZnbmndlhmbmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核周期
     */
    @TableField(value = "khzq")
    @JSONField(name = "khzq")
    @JsonProperty("khzq")
    private String khzq;
    /**
     * 修改日志
     */
    @TableField(value = "xgrz")
    @JSONField(name = "xgrz")
    @JsonProperty("xgrz")
    private String xgrz;
    /**
     * 目标类型
     */
    @TableField(value = "mblx")
    @JSONField(name = "mblx")
    @JsonProperty("mblx")
    private String mblx;
    /**
     * 审批状态
     */
    @TableField(value = "spzt")
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;
    /**
     * 完成情况
     */
    @TableField(value = "wcqk")
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;
    /**
     * 分值/权重
     */
    @TableField(value = "fzqz")
    @JSONField(name = "fzqz")
    @JsonProperty("fzqz")
    private Double fzqz;
    /**
     * 状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 年度量化目标明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parznbmndlhmbmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parznbmndlhmbmxid")
    @JsonProperty("parznbmndlhmbmxid")
    private String parznbmndlhmbmxid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 自评分数
     */
    @TableField(value = "zpfs")
    @JSONField(name = "zpfs")
    @JsonProperty("zpfs")
    private Double zpfs;
    /**
     * 考核标准
     */
    @TableField(value = "khbz")
    @JSONField(name = "khbz")
    @JsonProperty("khbz")
    private String khbz;
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
     * 提炼指标
     */
    @TableField(value = "parznbmndlhmbmxname")
    @JSONField(name = "parznbmndlhmbmxname")
    @JsonProperty("parznbmndlhmbmxname")
    private String parznbmndlhmbmxname;
    /**
     * 数据来源/证明材料
     */
    @TableField(value = "zmcl")
    @JSONField(name = "zmcl")
    @JsonProperty("zmcl")
    private String zmcl;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 目标量化要求
     */
    @TableField(value = "mblhyq")
    @JSONField(name = "mblhyq")
    @JsonProperty("mblhyq")
    private String mblhyq;
    /**
     * 年度量化目标
     */
    @TableField(exist = false)
    @JSONField(name = "parznbmndlhmbname")
    @JsonProperty("parznbmndlhmbname")
    private String parznbmndlhmbname;
    /**
     * 年度量化目标ID
     */
    @TableField(value = "parznbmndlhmbid")
    @JSONField(name = "parznbmndlhmbid")
    @JsonProperty("parznbmndlhmbid")
    private String parznbmndlhmbid;

    /**
     * 年度量化目标
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb parznbmndlhmb;



    /**
     * 设置 [考核周期]
     */
    public void setKhzq(String khzq){
        this.khzq = khzq ;
        this.modify("khzq",khzq);
    }

    /**
     * 设置 [修改日志]
     */
    public void setXgrz(String xgrz){
        this.xgrz = xgrz ;
        this.modify("xgrz",xgrz);
    }

    /**
     * 设置 [目标类型]
     */
    public void setMblx(String mblx){
        this.mblx = mblx ;
        this.modify("mblx",mblx);
    }

    /**
     * 设置 [审批状态]
     */
    public void setSpzt(String spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [完成情况]
     */
    public void setWcqk(String wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [分值/权重]
     */
    public void setFzqz(Double fzqz){
        this.fzqz = fzqz ;
        this.modify("fzqz",fzqz);
    }

    /**
     * 设置 [状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [自评分数]
     */
    public void setZpfs(Double zpfs){
        this.zpfs = zpfs ;
        this.modify("zpfs",zpfs);
    }

    /**
     * 设置 [考核标准]
     */
    public void setKhbz(String khbz){
        this.khbz = khbz ;
        this.modify("khbz",khbz);
    }

    /**
     * 设置 [提炼指标]
     */
    public void setParznbmndlhmbmxname(String parznbmndlhmbmxname){
        this.parznbmndlhmbmxname = parznbmndlhmbmxname ;
        this.modify("parznbmndlhmbmxname",parznbmndlhmbmxname);
    }

    /**
     * 设置 [数据来源/证明材料]
     */
    public void setZmcl(String zmcl){
        this.zmcl = zmcl ;
        this.modify("zmcl",zmcl);
    }

    /**
     * 设置 [目标量化要求]
     */
    public void setMblhyq(String mblhyq){
        this.mblhyq = mblhyq ;
        this.modify("mblhyq",mblhyq);
    }

    /**
     * 设置 [年度量化目标ID]
     */
    public void setParznbmndlhmbid(String parznbmndlhmbid){
        this.parznbmndlhmbid = parznbmndlhmbid ;
        this.modify("parznbmndlhmbid",parznbmndlhmbid);
    }


}


