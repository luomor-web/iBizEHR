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
 * 服务DTO对象[OrmOrgInfoDTO]
 */
@Data
public class OrmOrgInfoDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [POSTINFO]
     *
     */
    @JSONField(name = "postinfo")
    @JsonProperty("postinfo")
    private String postinfo;

    /**
     * 属性 [PORGSECTORID]
     *
     */
    @JSONField(name = "porgsectorid")
    @JsonProperty("porgsectorid")
    private String porgsectorid;

    /**
     * 属性 [ORDERNUM]
     *
     */
    @JSONField(name = "ordernum")
    @JsonProperty("ordernum")
    private String ordernum;

    /**
     * 属性 [OUID]
     *
     */
    @JSONField(name = "ouid")
    @JsonProperty("ouid")
    private String ouid;

    /**
     * 属性 [ORMORGINFOID]
     *
     */
    @JSONField(name = "ormorginfoid")
    @JsonProperty("ormorginfoid")
    private String ormorginfoid;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [STARTSTOPSIGN]
     *
     */
    @JSONField(name = "startstopsign")
    @JsonProperty("startstopsign")
    private String startstopsign;

    /**
     * 属性 [PORGID]
     *
     */
    @JSONField(name = "porgid")
    @JsonProperty("porgid")
    private String porgid;

    /**
     * 属性 [ORGTYPENAME]
     *
     */
    @JSONField(name = "orgtypename")
    @JsonProperty("orgtypename")
    private String orgtypename;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BELONGREGION]
     *
     */
    @JSONField(name = "belongregion")
    @JsonProperty("belongregion")
    private String belongregion;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORGTYPE]
     *
     */
    @JSONField(name = "orgtype")
    @JsonProperty("orgtype")
    private String orgtype;

    /**
     * 属性 [SUBSTANDARD]
     *
     */
    @JSONField(name = "substandard")
    @JsonProperty("substandard")
    private String substandard;

    /**
     * 属性 [ORMORGINFONAME]
     *
     */
    @JSONField(name = "ormorginfoname")
    @JsonProperty("ormorginfoname")
    private String ormorginfoname;


    /**
     * 设置 [POSTINFO]
     */
    public void setPostinfo(String  postinfo){
        this.postinfo = postinfo ;
        this.modify("postinfo",postinfo);
    }

    /**
     * 设置 [PORGSECTORID]
     */
    public void setPorgsectorid(String  porgsectorid){
        this.porgsectorid = porgsectorid ;
        this.modify("porgsectorid",porgsectorid);
    }

    /**
     * 设置 [ORDERNUM]
     */
    public void setOrdernum(String  ordernum){
        this.ordernum = ordernum ;
        this.modify("ordernum",ordernum);
    }

    /**
     * 设置 [OUID]
     */
    public void setOuid(String  ouid){
        this.ouid = ouid ;
        this.modify("ouid",ouid);
    }

    /**
     * 设置 [SHORTNAME]
     */
    public void setShortname(String  shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [STARTSTOPSIGN]
     */
    public void setStartstopsign(String  startstopsign){
        this.startstopsign = startstopsign ;
        this.modify("startstopsign",startstopsign);
    }

    /**
     * 设置 [PORGID]
     */
    public void setPorgid(String  porgid){
        this.porgid = porgid ;
        this.modify("porgid",porgid);
    }

    /**
     * 设置 [ORGTYPENAME]
     */
    public void setOrgtypename(String  orgtypename){
        this.orgtypename = orgtypename ;
        this.modify("orgtypename",orgtypename);
    }

    /**
     * 设置 [BELONGREGION]
     */
    public void setBelongregion(String  belongregion){
        this.belongregion = belongregion ;
        this.modify("belongregion",belongregion);
    }

    /**
     * 设置 [ORGTYPE]
     */
    public void setOrgtype(String  orgtype){
        this.orgtype = orgtype ;
        this.modify("orgtype",orgtype);
    }

    /**
     * 设置 [SUBSTANDARD]
     */
    public void setSubstandard(String  substandard){
        this.substandard = substandard ;
        this.modify("substandard",substandard);
    }

    /**
     * 设置 [ORMORGINFONAME]
     */
    public void setOrmorginfoname(String  ormorginfoname){
        this.ormorginfoname = ormorginfoname ;
        this.modify("ormorginfoname",ormorginfoname);
    }


}

