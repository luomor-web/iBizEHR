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
 * 服务DTO对象[VacSituationDTO]
 */
@Data
public class VacSituationDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [YYTS]
     *
     */
    @JSONField(name = "yyts")
    @JsonProperty("yyts")
    private Integer yyts;

    /**
     * 属性 [VACSITUATIONNAME]
     *
     */
    @JSONField(name = "vacsituationname")
    @JsonProperty("vacsituationname")
    private String vacsituationname;

    /**
     * 属性 [BCTS]
     *
     */
    @JSONField(name = "bcts")
    @JsonProperty("bcts")
    private Integer bcts;

    /**
     * 属性 [VACSITUATIONID]
     *
     */
    @JSONField(name = "vacsituationid")
    @JsonProperty("vacsituationid")
    private String vacsituationid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [BNTS]
     *
     */
    @JSONField(name = "bnts")
    @JsonProperty("bnts")
    private Integer bnts;

    /**
     * 属性 [SNZRTS]
     *
     */
    @JSONField(name = "snzrts")
    @JsonProperty("snzrts")
    private Integer snzrts;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [LJSYTS]
     *
     */
    @JSONField(name = "ljsyts")
    @JsonProperty("ljsyts")
    private Integer ljsyts;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BNSYTS]
     *
     */
    @JSONField(name = "bnsyts")
    @JsonProperty("bnsyts")
    private Integer bnsyts;

    /**
     * 属性 [ZTS]
     *
     */
    @JSONField(name = "zts")
    @JsonProperty("zts")
    private Integer zts;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [YYTS]
     */
    public void setYyts(Integer  yyts){
        this.yyts = yyts ;
        this.modify("yyts",yyts);
    }

    /**
     * 设置 [VACSITUATIONNAME]
     */
    public void setVacsituationname(String  vacsituationname){
        this.vacsituationname = vacsituationname ;
        this.modify("vacsituationname",vacsituationname);
    }

    /**
     * 设置 [BCTS]
     */
    public void setBcts(Integer  bcts){
        this.bcts = bcts ;
        this.modify("bcts",bcts);
    }

    /**
     * 设置 [BNTS]
     */
    public void setBnts(Integer  bnts){
        this.bnts = bnts ;
        this.modify("bnts",bnts);
    }

    /**
     * 设置 [SNZRTS]
     */
    public void setSnzrts(Integer  snzrts){
        this.snzrts = snzrts ;
        this.modify("snzrts",snzrts);
    }

    /**
     * 设置 [LJSYTS]
     */
    public void setLjsyts(Integer  ljsyts){
        this.ljsyts = ljsyts ;
        this.modify("ljsyts",ljsyts);
    }

    /**
     * 设置 [BNSYTS]
     */
    public void setBnsyts(Integer  bnsyts){
        this.bnsyts = bnsyts ;
        this.modify("bnsyts",bnsyts);
    }

    /**
     * 设置 [ZTS]
     */
    public void setZts(Integer  zts){
        this.zts = zts ;
        this.modify("zts",zts);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

