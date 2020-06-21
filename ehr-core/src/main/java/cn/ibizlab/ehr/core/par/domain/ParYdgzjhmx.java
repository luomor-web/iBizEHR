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
 * 实体[月度工作计划明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARYDGZJHMX",resultMap = "ParYdgzjhmxResultMap")
public class ParYdgzjhmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 完成标准
     */
    @TableField(value = "wcbz")
    @JSONField(name = "wcbz")
    @JsonProperty("wcbz")
    private String wcbz;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 权重
     */
    @TableField(value = "qz")
    @JSONField(name = "qz")
    @JsonProperty("qz")
    private Integer qz;
    /**
     * 自评/评分
     */
    @TableField(value = "zppf")
    @JSONField(name = "zppf")
    @JsonProperty("zppf")
    private Integer zppf;
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
     * 完成情况
     */
    @TableField(value = "wcqk")
    @JSONField(name = "wcqk")
    @JsonProperty("wcqk")
    private String wcqk;
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
     * 月度工作计划明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parydgzjhmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parydgzjhmxid")
    @JsonProperty("parydgzjhmxid")
    private String parydgzjhmxid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 修改后提交工作计划
     */
    @TableField(value = "xzhtjgzjh")
    @JSONField(name = "xzhtjgzjh")
    @JsonProperty("xzhtjgzjh")
    private String xzhtjgzjh;
    /**
     * 指标类型
     */
    @TableField(value = "zblx")
    @JSONField(name = "zblx")
    @JsonProperty("zblx")
    private String zblx;
    /**
     * 拟完成日期
     */
    @TableField(value = "nwcrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "nwcrq" , format="yyyy-MM-dd")
    @JsonProperty("nwcrq")
    private Timestamp nwcrq;
    /**
     * 工作计划
     */
    @TableField(value = "parydgzjhmxname")
    @JSONField(name = "parydgzjhmxname")
    @JsonProperty("parydgzjhmxname")
    private String parydgzjhmxname;
    /**
     * 月度工作计划
     */
    @TableField(exist = false)
    @JSONField(name = "parydgzjhname")
    @JsonProperty("parydgzjhname")
    private String parydgzjhname;
    /**
     * 月度工作计划ID
     */
    @TableField(value = "parydgzjhid")
    @JSONField(name = "parydgzjhid")
    @JsonProperty("parydgzjhid")
    private String parydgzjhid;

    /**
     * 月度工作计划
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParYdgzjh parydgzjh;



    /**
     * 设置 [完成标准]
     */
    public void setWcbz(String wcbz){
        this.wcbz = wcbz ;
        this.modify("wcbz",wcbz);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [权重]
     */
    public void setQz(Integer qz){
        this.qz = qz ;
        this.modify("qz",qz);
    }

    /**
     * 设置 [自评/评分]
     */
    public void setZppf(Integer zppf){
        this.zppf = zppf ;
        this.modify("zppf",zppf);
    }

    /**
     * 设置 [完成情况]
     */
    public void setWcqk(String wcqk){
        this.wcqk = wcqk ;
        this.modify("wcqk",wcqk);
    }

    /**
     * 设置 [修改后提交工作计划]
     */
    public void setXzhtjgzjh(String xzhtjgzjh){
        this.xzhtjgzjh = xzhtjgzjh ;
        this.modify("xzhtjgzjh",xzhtjgzjh);
    }

    /**
     * 设置 [指标类型]
     */
    public void setZblx(String zblx){
        this.zblx = zblx ;
        this.modify("zblx",zblx);
    }

    /**
     * 设置 [拟完成日期]
     */
    public void setNwcrq(Timestamp nwcrq){
        this.nwcrq = nwcrq ;
        this.modify("nwcrq",nwcrq);
    }

    /**
     * 格式化日期 [拟完成日期]
     */
    public String formatNwcrq(){
        if (this.nwcrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(nwcrq);
    }
    /**
     * 设置 [工作计划]
     */
    public void setParydgzjhmxname(String parydgzjhmxname){
        this.parydgzjhmxname = parydgzjhmxname ;
        this.modify("parydgzjhmxname",parydgzjhmxname);
    }

    /**
     * 设置 [月度工作计划ID]
     */
    public void setParydgzjhid(String parydgzjhid){
        this.parydgzjhid = parydgzjhid ;
        this.modify("parydgzjhid",parydgzjhid);
    }


}


