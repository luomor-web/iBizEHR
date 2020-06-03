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
 * 服务DTO对象[PcmWzd0002DTO]
 */
@Data
public class PcmWzd0002DTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WZD0002ID]
     *
     */
    @JSONField(name = "wzd0002id")
    @JsonProperty("wzd0002id")
    private String wzd0002id;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TCYY]
     *
     */
    @JSONField(name = "tcyy")
    @JsonProperty("tcyy")
    private String tcyy;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JTYY]
     *
     */
    @JSONField(name = "jtyy")
    @JsonProperty("jtyy")
    private String jtyy;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;

    /**
     * 属性 [PROFILELIST]
     *
     */
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;

    /**
     * 属性 [PEOPLENUM]
     *
     */
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WZD0002NAME]
     *
     */
    @JSONField(name = "wzd0002name")
    @JsonProperty("wzd0002name")
    private String wzd0002name;


    /**
     * 设置 [TCYY]
     */
    public void setTcyy(String  tcyy){
        this.tcyy = tcyy ;
        this.modify("tcyy",tcyy);
    }

    /**
     * 设置 [JTYY]
     */
    public void setJtyy(String  jtyy){
        this.jtyy = jtyy ;
        this.modify("jtyy",jtyy);
    }

    /**
     * 设置 [STATUS]
     */
    public void setStatus(String  status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [PROFILELIST]
     */
    public void setProfilelist(String  profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [PEOPLENUM]
     */
    public void setPeoplenum(Integer  peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [WZD0002NAME]
     */
    public void setWzd0002name(String  wzd0002name){
        this.wzd0002name = wzd0002name ;
        this.modify("wzd0002name",wzd0002name);
    }


}

