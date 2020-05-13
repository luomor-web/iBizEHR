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
 * 实体[数据同步发送队列]
 */
@Data
@TableName(value = "T_SRFDATASYNCOUT",resultMap = "DataSyncOutResultMap")
public class DataSyncOut extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 同步文件清单
     */
    @TableField(value = "filelist")
    @JSONField(name = "filelist")
    @JsonProperty("filelist")
    private String filelist;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 数据
     */
    @TableField(value = "data")
    @JSONField(name = "data")
    @JsonProperty("data")
    private String data;
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
     * 事件类型
     */
    @TableField(value = "eventtype")
    @JSONField(name = "eventtype")
    @JsonProperty("eventtype")
    private Integer eventtype;
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
     * 数据输出代理
     */
    @TableField(value = "syncagent")
    @JSONField(name = "syncagent")
    @JsonProperty("syncagent")
    private String syncagent;
    /**
     * 数据同步发送队列名称
     */
    @TableField(value = "datasyncoutname")
    @JSONField(name = "datasyncoutname")
    @JsonProperty("datasyncoutname")
    private String datasyncoutname;
    /**
     * 逻辑数据
     */
    @TableField(value = "logicdata")
    @JSONField(name = "logicdata")
    @JsonProperty("logicdata")
    private String logicdata;
    /**
     * 数据同步发送队列标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "datasyncoutid",type=IdType.UUID)
    @JSONField(name = "datasyncoutid")
    @JsonProperty("datasyncoutid")
    private String datasyncoutid;
    /**
     * 数据主键
     */
    @TableField(value = "datakey")
    @JSONField(name = "datakey")
    @JsonProperty("datakey")
    private String datakey;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 设置 [同步文件清单]
     */
    public void setFilelist(String filelist){
        this.filelist = filelist ;
        this.modify("filelist",filelist);
    }
    /**
     * 设置 [数据]
     */
    public void setData(String data){
        this.data = data ;
        this.modify("data",data);
    }
    /**
     * 设置 [事件类型]
     */
    public void setEventtype(Integer eventtype){
        this.eventtype = eventtype ;
        this.modify("eventtype",eventtype);
    }
    /**
     * 设置 [数据输出代理]
     */
    public void setSyncagent(String syncagent){
        this.syncagent = syncagent ;
        this.modify("syncagent",syncagent);
    }
    /**
     * 设置 [数据同步发送队列名称]
     */
    public void setDatasyncoutname(String datasyncoutname){
        this.datasyncoutname = datasyncoutname ;
        this.modify("datasyncoutname",datasyncoutname);
    }
    /**
     * 设置 [逻辑数据]
     */
    public void setLogicdata(String logicdata){
        this.logicdata = logicdata ;
        this.modify("logicdata",logicdata);
    }
    /**
     * 设置 [数据主键]
     */
    public void setDatakey(String datakey){
        this.datakey = datakey ;
        this.modify("datakey",datakey);
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






