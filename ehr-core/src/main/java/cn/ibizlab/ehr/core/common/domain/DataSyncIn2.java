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
 * 实体[数据同步接收队列2]
 */
@Data
@TableName(value = "T_SRFDATASYNCIN2",resultMap = "DataSyncIn2ResultMap")
public class DataSyncIn2 extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 逻辑数据
     */
    @TableField(value = "logicdata")
    @JSONField(name = "logicdata")
    @JsonProperty("logicdata")
    private String logicdata;
    /**
     * 数据同步接收队列2标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "datasyncin2id",type=IdType.UUID)
    @JSONField(name = "datasyncin2id")
    @JsonProperty("datasyncin2id")
    private String datasyncin2id;
    /**
     * 数据输入代理
     */
    @TableField(value = "syncagent")
    @JSONField(name = "syncagent")
    @JsonProperty("syncagent")
    private String syncagent;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 同步错误信息
     */
    @TableField(value = "error")
    @JSONField(name = "error")
    @JsonProperty("error")
    private String error;
    /**
     * 是否为文件
     */
    @TableField(value = "fileflag")
    @JSONField(name = "fileflag")
    @JsonProperty("fileflag")
    private Integer fileflag;
    /**
     * 事件类型
     */
    @TableField(value = "eventtype")
    @JSONField(name = "eventtype")
    @JsonProperty("eventtype")
    private Integer eventtype;
    /**
     * 数据主键
     */
    @TableField(value = "datakey")
    @JSONField(name = "datakey")
    @JsonProperty("datakey")
    private String datakey;
    /**
     * 数据同步接收队列2名称
     */
    @TableField(value = "datasyncin2name")
    @JSONField(name = "datasyncin2name")
    @JsonProperty("datasyncin2name")
    private String datasyncin2name;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 数据
     */
    @TableField(value = "data")
    @JSONField(name = "data")
    @JsonProperty("data")
    private String data;
    /**
     * 数据实体
     */
    @TableField(value = "dename")
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;
    /**
     * 数据实体
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
     * 设置 [逻辑数据]
     */
    public void setLogicdata(String logicdata){
        this.logicdata = logicdata ;
        this.modify("logicdata",logicdata);
    }
    /**
     * 设置 [数据输入代理]
     */
    public void setSyncagent(String syncagent){
        this.syncagent = syncagent ;
        this.modify("syncagent",syncagent);
    }
    /**
     * 设置 [同步错误信息]
     */
    public void setError(String error){
        this.error = error ;
        this.modify("error",error);
    }
    /**
     * 设置 [是否为文件]
     */
    public void setFileflag(Integer fileflag){
        this.fileflag = fileflag ;
        this.modify("fileflag",fileflag);
    }
    /**
     * 设置 [事件类型]
     */
    public void setEventtype(Integer eventtype){
        this.eventtype = eventtype ;
        this.modify("eventtype",eventtype);
    }
    /**
     * 设置 [数据主键]
     */
    public void setDatakey(String datakey){
        this.datakey = datakey ;
        this.modify("datakey",datakey);
    }
    /**
     * 设置 [数据同步接收队列2名称]
     */
    public void setDatasyncin2name(String datasyncin2name){
        this.datasyncin2name = datasyncin2name ;
        this.modify("datasyncin2name",datasyncin2name);
    }
    /**
     * 设置 [数据]
     */
    public void setData(String data){
        this.data = data ;
        this.modify("data",data);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDename(String dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }
    /**
     * 设置 [数据实体]
     */
    public void setDeid(String deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }

}


