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
 * 服务DTO对象[TrmTrainFillinDTO]
 */
@Data
public class TrmTrainFillinDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMTRAINFILLINNAME]
     *
     */
    @JSONField(name = "trmtrainfillinname")
    @JsonProperty("trmtrainfillinname")
    private String trmtrainfillinname;

    /**
     * 属性 [TRMTRAINFILLINID]
     *
     */
    @JSONField(name = "trmtrainfillinid")
    @JsonProperty("trmtrainfillinid")
    private String trmtrainfillinid;

    /**
     * 属性 [TRMTRAINFILLINNAME2]
     *
     */
    @JSONField(name = "trmtrainfillinname2")
    @JsonProperty("trmtrainfillinname2")
    private String trmtrainfillinname2;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [JD]
     *
     */
    @JSONField(name = "jd")
    @JsonProperty("jd")
    private String jd;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [TRMDEPARTNAME]
     *
     */
    @JSONField(name = "trmdepartname")
    @JsonProperty("trmdepartname")
    private String trmdepartname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [JZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jzrq" , format="yyyy-MM-dd")
    @JsonProperty("jzrq")
    private Timestamp jzrq;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMTRAINFILLINID2]
     *
     */
    @JSONField(name = "trmtrainfillinid2")
    @JsonProperty("trmtrainfillinid2")
    private String trmtrainfillinid2;

    /**
     * 属性 [TRMDEPARTID]
     *
     */
    @JSONField(name = "trmdepartid")
    @JsonProperty("trmdepartid")
    private String trmdepartid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [TRMTRAINFILLINNAME]
     */
    public void setTrmtrainfillinname(String  trmtrainfillinname){
        this.trmtrainfillinname = trmtrainfillinname ;
        this.modify("trmtrainfillinname",trmtrainfillinname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINFILLINID2]
     */
    public void setTrmtrainfillinid2(String  trmtrainfillinid2){
        this.trmtrainfillinid2 = trmtrainfillinid2 ;
        this.modify("trmtrainfillinid2",trmtrainfillinid2);
    }

    /**
     * 设置 [TRMDEPARTID]
     */
    public void setTrmdepartid(String  trmdepartid){
        this.trmdepartid = trmdepartid ;
        this.modify("trmdepartid",trmdepartid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

