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
 * 服务DTO对象[PimEnclosureDTO]
 */
@Data
public class PimEnclosureDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PIMENCLOSUREID]
     *
     */
    @JSONField(name = "pimenclosureid")
    @JsonProperty("pimenclosureid")
    private String pimenclosureid;

    /**
     * 属性 [PIMENCLOSURENAME]
     *
     */
    @JSONField(name = "pimenclosurename")
    @JsonProperty("pimenclosurename")
    private String pimenclosurename;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [FJFL]
     *
     */
    @JSONField(name = "fjfl")
    @JsonProperty("fjfl")
    private String fjfl;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [FJLJ]
     *
     */
    @JSONField(name = "fjlj")
    @JsonProperty("fjlj")
    private String fjlj;

    /**
     * 属性 [USERSTATE]
     *
     */
    @JSONField(name = "userstate")
    @JsonProperty("userstate")
    private String userstate;

    /**
     * 属性 [FJKZ]
     *
     */
    @JSONField(name = "fjkz")
    @JsonProperty("fjkz")
    private String fjkz;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [PIMENCLOSURENAME]
     */
    public void setPimenclosurename(String  pimenclosurename){
        this.pimenclosurename = pimenclosurename ;
        this.modify("pimenclosurename",pimenclosurename);
    }

    /**
     * 设置 [FJFL]
     */
    public void setFjfl(String  fjfl){
        this.fjfl = fjfl ;
        this.modify("fjfl",fjfl);
    }

    /**
     * 设置 [FJLJ]
     */
    public void setFjlj(String  fjlj){
        this.fjlj = fjlj ;
        this.modify("fjlj",fjlj);
    }

    /**
     * 设置 [USERSTATE]
     */
    public void setUserstate(String  userstate){
        this.userstate = userstate ;
        this.modify("userstate",userstate);
    }

    /**
     * 设置 [FJKZ]
     */
    public void setFjkz(String  fjkz){
        this.fjkz = fjkz ;
        this.modify("fjkz",fjkz);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

