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
 * 实体[年度量化目标明细（公司领导类 ）]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARLDNDLHMBMX",resultMap = "ParLdndlhmbmxResultMap")
public class ParLdndlhmbmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 目标类型
     */
    @TableField(value = "mblx")
    @JSONField(name = "mblx")
    @JsonProperty("mblx")
    private String mblx;
    /**
     * 完成情况
     */
    @TableField(value = "wcqk")
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;
    /**
     * 量化目标
     */
    @TableField(value = "parldndlhmbmxname")
    @JSONField(name = "parldndlhmbmxname")
    @JsonProperty("parldndlhmbmxname")
    private String parldndlhmbmxname;
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
     * 修改日志
     */
    @TableField(value = "xgrz")
    @JSONField(name = "xgrz")
    @JsonProperty("xgrz")
    private String xgrz;
    /**
     * 自评分数
     */
    @TableField(value = "zpfs")
    @JSONField(name = "zpfs")
    @JsonProperty("zpfs")
    private Double zpfs;
    /**
     * 考核办法
     */
    @TableField(value = "khbf")
    @JSONField(name = "khbf")
    @JsonProperty("khbf")
    private String khbf;
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
     * 集中述职评审分数
     */
    @TableField(value = "jzszpsfs")
    @JSONField(name = "jzszpsfs")
    @JsonProperty("jzszpsfs")
    private Double jzszpsfs;
    /**
     * 分管领导评分
     */
    @TableField(value = "fgldpf")
    @JSONField(name = "fgldpf")
    @JsonProperty("fgldpf")
    private Double fgldpf;
    /**
     * 量化目标明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parldndlhmbmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parldndlhmbmxid")
    @JsonProperty("parldndlhmbmxid")
    private String parldndlhmbmxid;
    /**
     * 状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 审批状态
     */
    @TableField(value = "spzt")
    @JSONField(name = "spzt")
    @JsonProperty("spzt")
    private String spzt;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 分值
     */
    @TableField(value = "fz")
    @JSONField(name = "fz")
    @JsonProperty("fz")
    private Double fz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 证明材料
     */
    @TableField(value = "zmcl")
    @JSONField(name = "zmcl")
    @JsonProperty("zmcl")
    private String zmcl;
    /**
     * 目标量化要求
     */
    @TableField(value = "mblhyq")
    @JSONField(name = "mblhyq")
    @JsonProperty("mblhyq")
    private String mblhyq;
    /**
     * 年度量化目标名称
     */
    @TableField(exist = false)
    @JSONField(name = "parldndlhmbname")
    @JsonProperty("parldndlhmbname")
    private String parldndlhmbname;
    /**
     * 年度量化目标ID
     */
    @TableField(value = "parldndlhmbid")
    @JSONField(name = "parldndlhmbid")
    @JsonProperty("parldndlhmbid")
    private String parldndlhmbid;

    /**
     * 年度量化目标
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParLdndlhmb parldndlhmb;



    /**
     * 设置 [目标类型]
     */
    public void setMblx(String mblx){
        this.mblx = mblx ;
        this.modify("mblx",mblx);
    }

    /**
     * 设置 [完成情况]
     */
    public void setWcqk(String wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [量化目标]
     */
    public void setParldndlhmbmxname(String parldndlhmbmxname){
        this.parldndlhmbmxname = parldndlhmbmxname ;
        this.modify("parldndlhmbmxname",parldndlhmbmxname);
    }

    /**
     * 设置 [修改日志]
     */
    public void setXgrz(String xgrz){
        this.xgrz = xgrz ;
        this.modify("xgrz",xgrz);
    }

    /**
     * 设置 [自评分数]
     */
    public void setZpfs(Double zpfs){
        this.zpfs = zpfs ;
        this.modify("zpfs",zpfs);
    }

    /**
     * 设置 [考核办法]
     */
    public void setKhbf(String khbf){
        this.khbf = khbf ;
        this.modify("khbf",khbf);
    }

    /**
     * 设置 [集中述职评审分数]
     */
    public void setJzszpsfs(Double jzszpsfs){
        this.jzszpsfs = jzszpsfs ;
        this.modify("jzszpsfs",jzszpsfs);
    }

    /**
     * 设置 [分管领导评分]
     */
    public void setFgldpf(Double fgldpf){
        this.fgldpf = fgldpf ;
        this.modify("fgldpf",fgldpf);
    }

    /**
     * 设置 [状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [审批状态]
     */
    public void setSpzt(String spzt){
        this.spzt = spzt ;
        this.modify("spzt",spzt);
    }

    /**
     * 设置 [分值]
     */
    public void setFz(Double fz){
        this.fz = fz ;
        this.modify("fz",fz);
    }

    /**
     * 设置 [证明材料]
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
    public void setParldndlhmbid(String parldndlhmbid){
        this.parldndlhmbid = parldndlhmbid ;
        this.modify("parldndlhmbid",parldndlhmbid);
    }


}


