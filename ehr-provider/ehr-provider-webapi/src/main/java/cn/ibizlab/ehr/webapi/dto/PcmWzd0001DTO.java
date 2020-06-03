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
 * 服务DTO对象[PcmWzd0001DTO]
 */
@Data
public class PcmWzd0001DTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PEOPLENUM]
     *
     */
    @JSONField(name = "peoplenum")
    @JsonProperty("peoplenum")
    private Integer peoplenum;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [SHYY]
     *
     */
    @JSONField(name = "shyy")
    @JsonProperty("shyy")
    private String shyy;

    /**
     * 属性 [CSYJ]
     *
     */
    @JSONField(name = "csyj")
    @JsonProperty("csyj")
    private String csyj;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WZD0001ID]
     *
     */
    @JSONField(name = "wzd0001id")
    @JsonProperty("wzd0001id")
    private String wzd0001id;

    /**
     * 属性 [CSYY]
     *
     */
    @JSONField(name = "csyy")
    @JsonProperty("csyy")
    private String csyy;

    /**
     * 属性 [SPYY]
     *
     */
    @JSONField(name = "spyy")
    @JsonProperty("spyy")
    private String spyy;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZPME]
     *
     */
    @JSONField(name = "zpme")
    @JsonProperty("zpme")
    private String zpme;

    /**
     * 属性 [WZD0001NAME]
     *
     */
    @JSONField(name = "wzd0001name")
    @JsonProperty("wzd0001name")
    private String wzd0001name;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BDSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "bdsj" , format="yyyy-MM-dd")
    @JsonProperty("bdsj")
    private Timestamp bdsj;

    /**
     * 属性 [SPYJ]
     *
     */
    @JSONField(name = "spyj")
    @JsonProperty("spyj")
    private String spyj;

    /**
     * 属性 [YGLX]
     *
     */
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;

    /**
     * 属性 [PROFILELIST]
     *
     */
    @JSONField(name = "profilelist")
    @JsonProperty("profilelist")
    private String profilelist;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SHYJ]
     *
     */
    @JSONField(name = "shyj")
    @JsonProperty("shyj")
    private String shyj;


    /**
     * 设置 [PEOPLENUM]
     */
    public void setPeoplenum(Integer  peoplenum){
        this.peoplenum = peoplenum ;
        this.modify("peoplenum",peoplenum);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [SHYY]
     */
    public void setShyy(String  shyy){
        this.shyy = shyy ;
        this.modify("shyy",shyy);
    }

    /**
     * 设置 [CSYJ]
     */
    public void setCsyj(String  csyj){
        this.csyj = csyj ;
        this.modify("csyj",csyj);
    }

    /**
     * 设置 [CSYY]
     */
    public void setCsyy(String  csyy){
        this.csyy = csyy ;
        this.modify("csyy",csyy);
    }

    /**
     * 设置 [SPYY]
     */
    public void setSpyy(String  spyy){
        this.spyy = spyy ;
        this.modify("spyy",spyy);
    }

    /**
     * 设置 [ZPME]
     */
    public void setZpme(String  zpme){
        this.zpme = zpme ;
        this.modify("zpme",zpme);
    }

    /**
     * 设置 [WZD0001NAME]
     */
    public void setWzd0001name(String  wzd0001name){
        this.wzd0001name = wzd0001name ;
        this.modify("wzd0001name",wzd0001name);
    }

    /**
     * 设置 [BDSJ]
     */
    public void setBdsj(Timestamp  bdsj){
        this.bdsj = bdsj ;
        this.modify("bdsj",bdsj);
    }

    /**
     * 设置 [SPYJ]
     */
    public void setSpyj(String  spyj){
        this.spyj = spyj ;
        this.modify("spyj",spyj);
    }

    /**
     * 设置 [YGLX]
     */
    public void setYglx(String  yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [PROFILELIST]
     */
    public void setProfilelist(String  profilelist){
        this.profilelist = profilelist ;
        this.modify("profilelist",profilelist);
    }

    /**
     * 设置 [SHYJ]
     */
    public void setShyj(String  shyj){
        this.shyj = shyj ;
        this.modify("shyj",shyj);
    }


}

