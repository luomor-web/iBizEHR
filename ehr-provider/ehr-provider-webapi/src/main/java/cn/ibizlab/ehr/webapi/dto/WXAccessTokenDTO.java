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
 * 服务DTO对象[WXAccessTokenDTO]
 */
@Data
public class WXAccessTokenDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WXACCESSTOKENNAME]
     *
     */
    @JSONField(name = "wxaccesstokenname")
    @JsonProperty("wxaccesstokenname")
    private String wxaccesstokenname;

    /**
     * 属性 [ACCESSTOKEN]
     *
     */
    @JSONField(name = "accesstoken")
    @JsonProperty("accesstoken")
    private String accesstoken;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WXACCESSTOKENID]
     *
     */
    @JSONField(name = "wxaccesstokenid")
    @JsonProperty("wxaccesstokenid")
    private String wxaccesstokenid;

    /**
     * 属性 [EXPIREDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "expiredtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expiredtime")
    private Timestamp expiredtime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WXACCOUNTNAME]
     *
     */
    @JSONField(name = "wxaccountname")
    @JsonProperty("wxaccountname")
    private String wxaccountname;

    /**
     * 属性 [WXACCOUNTID]
     *
     */
    @JSONField(name = "wxaccountid")
    @JsonProperty("wxaccountid")
    private String wxaccountid;


    /**
     * 设置 [WXACCESSTOKENNAME]
     */
    public void setWxaccesstokenname(String  wxaccesstokenname){
        this.wxaccesstokenname = wxaccesstokenname ;
        this.modify("wxaccesstokenname",wxaccesstokenname);
    }

    /**
     * 设置 [ACCESSTOKEN]
     */
    public void setAccesstoken(String  accesstoken){
        this.accesstoken = accesstoken ;
        this.modify("accesstoken",accesstoken);
    }

    /**
     * 设置 [EXPIREDTIME]
     */
    public void setExpiredtime(Timestamp  expiredtime){
        this.expiredtime = expiredtime ;
        this.modify("expiredtime",expiredtime);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [WXACCOUNTNAME]
     */
    public void setWxaccountname(String  wxaccountname){
        this.wxaccountname = wxaccountname ;
        this.modify("wxaccountname",wxaccountname);
    }

    /**
     * 设置 [WXACCOUNTID]
     */
    public void setWxaccountid(String  wxaccountid){
        this.wxaccountid = wxaccountid ;
        this.modify("wxaccountid",wxaccountid);
    }


}

