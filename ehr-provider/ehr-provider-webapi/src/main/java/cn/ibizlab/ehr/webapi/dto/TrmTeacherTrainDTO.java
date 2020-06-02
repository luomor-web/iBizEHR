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
 * 服务DTO对象[TrmTeacherTrainDTO]
 */
@Data
public class TrmTeacherTrainDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PJ]
     *
     */
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [TRMTEACHERTRAINID]
     *
     */
    @JSONField(name = "trmteachertrainid")
    @JsonProperty("trmteachertrainid")
    private String trmteachertrainid;

    /**
     * 属性 [JF]
     *
     */
    @JSONField(name = "jf")
    @JsonProperty("jf")
    private Double jf;

    /**
     * 属性 [TRMTEACHERTRAINNAME]
     *
     */
    @JSONField(name = "trmteachertrainname")
    @JsonProperty("trmteachertrainname")
    private String trmteachertrainname;

    /**
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

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
     * 属性 [PXJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;

    /**
     * 属性 [PXSC]
     *
     */
    @JSONField(name = "pxsc")
    @JsonProperty("pxsc")
    private Double pxsc;

    /**
     * 属性 [PXKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;

    /**
     * 属性 [TRMTRAINPLANTERMID]
     *
     */
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [TRMTRAINTEACHERID]
     *
     */
    @JSONField(name = "trmtrainteacherid")
    @JsonProperty("trmtrainteacherid")
    private String trmtrainteacherid;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;


    /**
     * 设置 [PJ]
     */
    public void setPj(String  pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [JF]
     */
    public void setJf(Double  jf){
        this.jf = jf ;
        this.modify("jf",jf);
    }

    /**
     * 设置 [TRMTEACHERTRAINNAME]
     */
    public void setTrmteachertrainname(String  trmteachertrainname){
        this.trmteachertrainname = trmteachertrainname ;
        this.modify("trmteachertrainname",trmteachertrainname);
    }

    /**
     * 设置 [TRMTRAINPLANTERMID]
     */
    public void setTrmtrainplantermid(String  trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [TRMTRAINTEACHERID]
     */
    public void setTrmtrainteacherid(String  trmtrainteacherid){
        this.trmtrainteacherid = trmtrainteacherid ;
        this.modify("trmtrainteacherid",trmtrainteacherid);
    }

    /**
     * 设置 [TRMTRAINADDRESSID]
     */
    public void setTrmtrainaddressid(String  trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}

