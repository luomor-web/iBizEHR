package cn.ibizlab.ehr.core.r7rt_dyna.domain;

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

import cn.ibizlab.ehr.util.domain.EntityClient;

/**
 * ServiceApi [动态数据看板] 对象
 */
@Data
public class DynaDashboard extends EntityClient implements Serializable {

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 实体标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "dynadashboardid")
    @JsonProperty("dynadashboardid")
    private String dynadashboardid;

    /**
     * 实体名称
     */
    @JSONField(name = "dynadashboardname")
    @JsonProperty("dynadashboardname")
    private String dynadashboardname;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 模型标识
     */
    @JSONField(name = "modelid")
    @JsonProperty("modelid")
    private String modelid;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 应用标识
     */
    @JSONField(name = "appid")
    @JsonProperty("appid")
    private String appid;

    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 模型
     */
    @JSONField(name = "model")
    @JsonProperty("model")
    private String model;





    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [实体名称]
     */
    public void setDynadashboardname(String dynadashboardname){
        this.dynadashboardname = dynadashboardname ;
        this.modify("dynadashboardname",dynadashboardname);
    }

    /**
     * 设置 [模型标识]
     */
    public void setModelid(String modelid){
        this.modelid = modelid ;
        this.modify("modelid",modelid);
    }

    /**
     * 设置 [应用标识]
     */
    public void setAppid(String appid){
        this.appid = appid ;
        this.modify("appid",appid);
    }

    /**
     * 设置 [模型]
     */
    public void setModel(String model){
        this.model = model ;
        this.modify("model",model);
    }


}


