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
 * 服务DTO对象[SocCompanyWelDTO]
 */
@Data
public class SocCompanyWelDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SOCCOMPANYWELID]
     *
     */
    @JSONField(name = "soccompanywelid")
    @JsonProperty("soccompanywelid")
    private String soccompanywelid;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SOCCOMPANYWELNAME]
     *
     */
    @JSONField(name = "soccompanywelname")
    @JsonProperty("soccompanywelname")
    private String soccompanywelname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [SOCSELFAREBASENAME]
     *
     */
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [SOCSELFAREBASEID]
     *
     */
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;


    /**
     * 设置 [SOCCOMPANYWELNAME]
     */
    public void setSoccompanywelname(String  soccompanywelname){
        this.soccompanywelname = soccompanywelname ;
        this.modify("soccompanywelname",soccompanywelname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [SOCSELFAREBASEID]
     */
    public void setSocselfarebaseid(String  socselfarebaseid){
        this.socselfarebaseid = socselfarebaseid ;
        this.modify("socselfarebaseid",socselfarebaseid);
    }


}

