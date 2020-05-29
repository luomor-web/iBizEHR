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
 * 服务DTO对象[TrmGradecadresDTO]
 */
@Data
public class TrmGradecadresDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TRMGRADECADRESID]
     *
     */
    @JSONField(name = "trmgradecadresid")
    @JsonProperty("trmgradecadresid")
    private String trmgradecadresid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TRMGRADECADRESNAME]
     *
     */
    @JSONField(name = "trmgradecadresname")
    @JsonProperty("trmgradecadresname")
    private String trmgradecadresname;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONNAME2]
     *
     */
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;

    /**
     * 属性 [ORMORGSECTORNAME2]
     *
     */
    @JSONField(name = "ormorgsectorname2")
    @JsonProperty("ormorgsectorname2")
    private String ormorgsectorname2;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMRANKNAME]
     *
     */
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGNAME2]
     *
     */
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;

    /**
     * 属性 [ORMRANKID]
     *
     */
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [ORMORGSECTORID2]
     *
     */
    @JSONField(name = "ormorgsectorid2")
    @JsonProperty("ormorgsectorid2")
    private String ormorgsectorid2;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGID2]
     *
     */
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;

    /**
     * 属性 [PIMPERSONID2]
     *
     */
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;


    /**
     * 设置 [TRMGRADECADRESNAME]
     */
    public void setTrmgradecadresname(String  trmgradecadresname){
        this.trmgradecadresname = trmgradecadresname ;
        this.modify("trmgradecadresname",trmgradecadresname);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ORMRANKID]
     */
    public void setOrmrankid(String  ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [ORMORGSECTORID2]
     */
    public void setOrmorgsectorid2(String  ormorgsectorid2){
        this.ormorgsectorid2 = ormorgsectorid2 ;
        this.modify("ormorgsectorid2",ormorgsectorid2);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMORGID2]
     */
    public void setOrmorgid2(String  ormorgid2){
        this.ormorgid2 = ormorgid2 ;
        this.modify("ormorgid2",ormorgid2);
    }

    /**
     * 设置 [PIMPERSONID2]
     */
    public void setPimpersonid2(String  pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }


}

