package cn.ibizlab.ehr.core.demodel.domain;

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
 * 实体[实体查询模型]
 */
@Data
@TableName(value = "T_SRFQUERYMODEL",resultMap = "QueryModelResultMap")
public class QueryModel extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体查询模型名称
     */
    @TableField(value = "querymodelname")
    @JSONField(name = "querymodelname")
    @JsonProperty("querymodelname")
    private String querymodelname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 查询对象
     */
    @TableField(value = "queryobject")
    @JSONField(name = "queryobject")
    @JsonProperty("queryobject")
    private String queryobject;
    /**
     * 应用发布
     */
    @TableField(value = "srfuserpub")
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;
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
     * 查询参数
     */
    @TableField(value = "queryparam")
    @JSONField(name = "queryparam")
    @JsonProperty("queryparam")
    private String queryparam;
    /**
     * 实体查询模型标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "querymodelid",type=IdType.UUID)
    @JSONField(name = "querymodelid")
    @JsonProperty("querymodelid")
    private String querymodelid;
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
     * 查询模型
     */
    @TableField(value = "querymodel")
    @JSONField(name = "querymodel")
    @JsonProperty("querymodel")
    private String querymodel;
    /**
     * 查询字段
     */
    @TableField(value = "queryfield")
    @JSONField(name = "queryfield")
    @JsonProperty("queryfield")
    private String queryfield;
    /**
     * 查询SQL
     */
    @TableField(value = "querysql")
    @JSONField(name = "querysql")
    @JsonProperty("querysql")
    private String querysql;
    /**
     * 查询排序信息
     */
    @TableField(value = "selectorder")
    @JSONField(name = "selectorder")
    @JsonProperty("selectorder")
    private String selectorder;
    /**
     * 版本
     */
    @TableField(value = "qmversion")
    @JSONField(name = "qmversion")
    @JsonProperty("qmversion")
    private Integer qmversion;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 分组模型
     */
    @TableField(value = "groupmodel")
    @JSONField(name = "groupmodel")
    @JsonProperty("groupmodel")
    private String groupmodel;
    /**
     * 直接代码
     */
    @TableField(value = "israwmode")
    @JSONField(name = "israwmode")
    @JsonProperty("israwmode")
    private Integer israwmode;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 查询模式
     */
    @TableField(value = "selectmode")
    @JSONField(name = "selectmode")
    @JsonProperty("selectmode")
    private String selectmode;
    /**
     * 查询条件
     */
    @TableField(value = "querycond")
    @JSONField(name = "querycond")
    @JsonProperty("querycond")
    private String querycond;
    /**
     * 框架发布
     */
    @TableField(value = "srfsyspub")
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;
    /**
     * 数据对象
     */
    @TableField(exist = false)
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 查询模型_相关实体
     */
    @TableField(value = "deid")
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.demodel.domain.DataEntity de;



    /**
     * 设置 [实体查询模型名称]
     */
    public void setQuerymodelname(String querymodelname){
        this.querymodelname = querymodelname ;
        this.modify("querymodelname",querymodelname);
    }
    /**
     * 设置 [查询对象]
     */
    public void setQueryobject(String queryobject){
        this.queryobject = queryobject ;
        this.modify("queryobject",queryobject);
    }
    /**
     * 设置 [应用发布]
     */
    public void setSrfuserpub(Integer srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }
    /**
     * 设置 [查询参数]
     */
    public void setQueryparam(String queryparam){
        this.queryparam = queryparam ;
        this.modify("queryparam",queryparam);
    }
    /**
     * 设置 [查询模型]
     */
    public void setQuerymodel(String querymodel){
        this.querymodel = querymodel ;
        this.modify("querymodel",querymodel);
    }
    /**
     * 设置 [查询字段]
     */
    public void setQueryfield(String queryfield){
        this.queryfield = queryfield ;
        this.modify("queryfield",queryfield);
    }
    /**
     * 设置 [查询SQL]
     */
    public void setQuerysql(String querysql){
        this.querysql = querysql ;
        this.modify("querysql",querysql);
    }
    /**
     * 设置 [查询排序信息]
     */
    public void setSelectorder(String selectorder){
        this.selectorder = selectorder ;
        this.modify("selectorder",selectorder);
    }
    /**
     * 设置 [版本]
     */
    public void setQmversion(Integer qmversion){
        this.qmversion = qmversion ;
        this.modify("qmversion",qmversion);
    }
    /**
     * 设置 [分组模型]
     */
    public void setGroupmodel(String groupmodel){
        this.groupmodel = groupmodel ;
        this.modify("groupmodel",groupmodel);
    }
    /**
     * 设置 [直接代码]
     */
    public void setIsrawmode(Integer israwmode){
        this.israwmode = israwmode ;
        this.modify("israwmode",israwmode);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [查询模式]
     */
    public void setSelectmode(String selectmode){
        this.selectmode = selectmode ;
        this.modify("selectmode",selectmode);
    }
    /**
     * 设置 [查询条件]
     */
    public void setQuerycond(String querycond){
        this.querycond = querycond ;
        this.modify("querycond",querycond);
    }
    /**
     * 设置 [框架发布]
     */
    public void setSrfsyspub(Integer srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }
    /**
     * 设置 [查询模型_相关实体]
     */
    public void setDeid(String deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }

}


