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
 * 服务DTO对象[TrmTeacherChargeDTO]
 */
@Data
public class TrmTeacherChargeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [JSDJ]
     *
     */
    @JSONField(name = "jsdj")
    @JsonProperty("jsdj")
    private String jsdj;

    /**
     * 属性 [TRMTEACHERCHARGEID]
     *
     */
    @JSONField(name = "trmteacherchargeid")
    @JsonProperty("trmteacherchargeid")
    private String trmteacherchargeid;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private Double dj;

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
     * 属性 [TRMTEACHERCHARGENAME]
     *
     */
    @JSONField(name = "trmteacherchargename")
    @JsonProperty("trmteacherchargename")
    private String trmteacherchargename;

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
     * 属性 [ZFY]
     *
     */
    @JSONField(name = "zfy")
    @JsonProperty("zfy")
    private Double zfy;

    /**
     * 属性 [XS]
     *
     */
    @JSONField(name = "xs")
    @JsonProperty("xs")
    private Double xs;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TRMTRAINTEACHERNAME]
     *
     */
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;

    /**
     * 属性 [TRMTRAINPLANTERMNAME]
     *
     */
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 属性 [TRMTRAINTEACHERID]
     *
     */
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;


    /**
     * 设置 [JSDJ]
     */
    public void setJsdj(String  jsdj){
        this.jsdj = jsdj ;
        this.modify("jsdj",jsdj);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(Double  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [TRMTEACHERCHARGENAME]
     */
    public void setTrmteacherchargename(String  trmteacherchargename){
        this.trmteacherchargename = trmteacherchargename ;
        this.modify("trmteacherchargename",trmteacherchargename);
    }

    /**
     * 设置 [ZFY]
     */
    public void setZfy(Double  zfy){
        this.zfy = zfy ;
        this.modify("zfy",zfy);
    }

    /**
     * 设置 [XS]
     */
    public void setXs(Double  xs){
        this.xs = xs ;
        this.modify("xs",xs);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [TRMTRAINTEACHERID]
     */
    public void setTrmtrainteacherid(String  trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }


}

