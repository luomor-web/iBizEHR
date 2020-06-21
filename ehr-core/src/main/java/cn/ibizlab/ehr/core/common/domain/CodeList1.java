package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[代码表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SRFCODELIST",resultMap = "CodeList1ResultMap")
public class CodeList1 extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 值分割符号
     */
    @TableField(value = "valueseperator")
    @JSONField(name = "valueseperator")
    @JsonProperty("valueseperator")
    private String valueseperator;
    /**
     * 配置路径
     */
    @TableField(value = "clpath")
    @JSONField(name = "clpath")
    @JsonProperty("clpath")
    private String clpath;
    /**
     * 用户范围
     */
    @TableField(value = "isuserscope")
    @JSONField(name = "isuserscope")
    @JsonProperty("isuserscope")
    private Integer isuserscope;
    /**
     * 系统数据
     */
    @DEField(defaultValue = "0")
    @TableField(value = "issystem")
    @JSONField(name = "issystem")
    @JsonProperty("issystem")
    private Integer issystem;
    /**
     * 显示分割符号
     */
    @TableField(value = "seperator")
    @JSONField(name = "seperator")
    @JsonProperty("seperator")
    private String seperator;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 框架发布
     */
    @TableField(value = "srfsyspub")
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;
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
     * 保留字段5
     */
    @TableField(value = "reserver5")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver5" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver5")
    private Timestamp reserver5;
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
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 或模式
     */
    @TableField(value = "ormode")
    @JSONField(name = "ormode")
    @JsonProperty("ormode")
    private String ormode;
    /**
     * 空白显示内容
     */
    @TableField(value = "emptytext")
    @JSONField(name = "emptytext")
    @JsonProperty("emptytext")
    private String emptytext;
    /**
     * 数据库填充器
     */
    @TableField(value = "filler")
    @JSONField(name = "filler")
    @JsonProperty("filler")
    private String filler;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 代码表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "codelistid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;
    /**
     * 代码表版本
     */
    @DEField(defaultValue = "1")
    @TableField(value = "clversion")
    @JSONField(name = "clversion")
    @JsonProperty("clversion")
    private Integer clversion;
    /**
     * 无值显示空白
     */
    @TableField(value = "novalueempty")
    @JSONField(name = "novalueempty")
    @JsonProperty("novalueempty")
    private Integer novalueempty;
    /**
     * 代码表名称
     */
    @TableField(value = "codelistname")
    @JSONField(name = "codelistname")
    @JsonProperty("codelistname")
    private String codelistname;
    /**
     * 代码表模型
     */
    @TableField(value = "clmodel")
    @JSONField(name = "clmodel")
    @JsonProperty("clmodel")
    private String clmodel;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 代码表参数
     */
    @TableField(value = "clparam")
    @JSONField(name = "clparam")
    @JsonProperty("clparam")
    private String clparam;
    /**
     * 应用发布
     */
    @TableField(value = "srfuserpub")
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;



    /**
     * 设置 [值分割符号]
     */
    public void setValueseperator(String valueseperator){
        this.valueseperator = valueseperator ;
        this.modify("valueseperator",valueseperator);
    }

    /**
     * 设置 [配置路径]
     */
    public void setClpath(String clpath){
        this.clpath = clpath ;
        this.modify("clpath",clpath);
    }

    /**
     * 设置 [用户范围]
     */
    public void setIsuserscope(Integer isuserscope){
        this.isuserscope = isuserscope ;
        this.modify("isuserscope",isuserscope);
    }

    /**
     * 设置 [系统数据]
     */
    public void setIssystem(Integer issystem){
        this.issystem = issystem ;
        this.modify("issystem",issystem);
    }

    /**
     * 设置 [显示分割符号]
     */
    public void setSeperator(String seperator){
        this.seperator = seperator ;
        this.modify("seperator",seperator);
    }

    /**
     * 设置 [框架发布]
     */
    public void setSrfsyspub(Integer srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [保留字段5]
     */
    public void setReserver5(Timestamp reserver5){
        this.reserver5 = reserver5 ;
        this.modify("reserver5",reserver5);
    }

    /**
     * 格式化日期 [保留字段5]
     */
    public String formatReserver5(){
        if (this.reserver5 == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(reserver5);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [或模式]
     */
    public void setOrmode(String ormode){
        this.ormode = ormode ;
        this.modify("ormode",ormode);
    }

    /**
     * 设置 [空白显示内容]
     */
    public void setEmptytext(String emptytext){
        this.emptytext = emptytext ;
        this.modify("emptytext",emptytext);
    }

    /**
     * 设置 [数据库填充器]
     */
    public void setFiller(String filler){
        this.filler = filler ;
        this.modify("filler",filler);
    }

    /**
     * 设置 [代码表版本]
     */
    public void setClversion(Integer clversion){
        this.clversion = clversion ;
        this.modify("clversion",clversion);
    }

    /**
     * 设置 [无值显示空白]
     */
    public void setNovalueempty(Integer novalueempty){
        this.novalueempty = novalueempty ;
        this.modify("novalueempty",novalueempty);
    }

    /**
     * 设置 [代码表名称]
     */
    public void setCodelistname(String codelistname){
        this.codelistname = codelistname ;
        this.modify("codelistname",codelistname);
    }

    /**
     * 设置 [代码表模型]
     */
    public void setClmodel(String clmodel){
        this.clmodel = clmodel ;
        this.modify("clmodel",clmodel);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [代码表参数]
     */
    public void setClparam(String clparam){
        this.clparam = clparam ;
        this.modify("clparam",clparam);
    }

    /**
     * 设置 [应用发布]
     */
    public void setSrfuserpub(Integer srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }


}


