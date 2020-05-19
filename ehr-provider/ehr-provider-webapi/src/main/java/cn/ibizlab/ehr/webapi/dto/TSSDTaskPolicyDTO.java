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
 * 服务DTO对象[TSSDTaskPolicyDTO]
 */
@Data
public class TSSDTaskPolicyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TSSDTASKPOLICYID]
     *
     */
    @JSONField(name = "tssdtaskpolicyid")
    @JsonProperty("tssdtaskpolicyid")
    private String tssdtaskpolicyid;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [TSSDTASKPOLICYNAME]
     *
     */
    @JSONField(name = "tssdtaskpolicyname")
    @JsonProperty("tssdtaskpolicyname")
    private String tssdtaskpolicyname;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TSSDPOLICYNAME]
     *
     */
    @JSONField(name = "tssdpolicyname")
    @JsonProperty("tssdpolicyname")
    private String tssdpolicyname;

    /**
     * 属性 [TSSDTASKNAME]
     *
     */
    @JSONField(name = "tssdtaskname")
    @JsonProperty("tssdtaskname")
    private String tssdtaskname;

    /**
     * 属性 [TSSDTASKID]
     *
     */
    @JSONField(name = "tssdtaskid")
    @JsonProperty("tssdtaskid")
    private String tssdtaskid;

    /**
     * 属性 [TSSDPOLICYID]
     *
     */
    @JSONField(name = "tssdpolicyid")
    @JsonProperty("tssdpolicyid")
    private String tssdpolicyid;


    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [TSSDTASKPOLICYNAME]
     */
    public void setTssdtaskpolicyname(String  tssdtaskpolicyname){
        this.tssdtaskpolicyname = tssdtaskpolicyname ;
        this.modify("tssdtaskpolicyname",tssdtaskpolicyname);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [TSSDTASKID]
     */
    public void setTssdtaskid(String  tssdtaskid){
        this.tssdtaskid = tssdtaskid ;
        this.modify("tssdtaskid",tssdtaskid);
    }

    /**
     * 设置 [TSSDPOLICYID]
     */
    public void setTssdpolicyid(String  tssdpolicyid){
        this.tssdpolicyid = tssdpolicyid ;
        this.modify("tssdpolicyid",tssdpolicyid);
    }


}

