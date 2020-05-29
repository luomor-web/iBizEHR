package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[DynaDashboardDTO]
 */
@Data
public class DynaDashboardDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [DYNADASHBOARDID]
     *
     */
    @JSONField(name = "dynadashboardid")
    @JsonProperty("dynadashboardid")
    private String dynadashboardid;

    /**
     * 属性 [DYNADASHBOARDNAME]
     *
     */
    @JSONField(name = "dynadashboardname")
    @JsonProperty("dynadashboardname")
    private String dynadashboardname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MODELID]
     *
     */
    @JSONField(name = "modelid")
    @JsonProperty("modelid")
    private String modelid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [APPID]
     *
     */
    @JSONField(name = "appid")
    @JsonProperty("appid")
    private String appid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [MODEL]
     *
     */
    @JSONField(name = "model")
    @JsonProperty("model")
    private String model;


    /**
     * 设置 [USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [DYNADASHBOARDNAME]
     */
    public void setDynadashboardname(String  dynadashboardname){
        this.dynadashboardname = dynadashboardname ;
        this.modify("dynadashboardname",dynadashboardname);
    }

    /**
     * 设置 [MODELID]
     */
    public void setModelid(String  modelid){
        this.modelid = modelid ;
        this.modify("modelid",modelid);
    }

    /**
     * 设置 [APPID]
     */
    public void setAppid(String  appid){
        this.appid = appid ;
        this.modify("appid",appid);
    }

    /**
     * 设置 [MODEL]
     */
    public void setModel(String  model){
        this.model = model ;
        this.modify("model",model);
    }


}

