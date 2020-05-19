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
 * 服务DTO对象[PCMGXMLDTO]
 */
@Data
public class PCMGXMLDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [PCMGXMLID]
     *
     */
    @JSONField(name = "pcmgxmlid")
    @JsonProperty("pcmgxmlid")
    private String pcmgxmlid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

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
     * 属性 [XXXZ]
     *
     */
    @JSONField(name = "xxxz")
    @JsonProperty("xxxz")
    private String xxxz;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [GXLB]
     *
     */
    @JSONField(name = "gxlb")
    @JsonProperty("gxlb")
    private String gxlb;

    /**
     * 属性 [NATIONAREA]
     *
     */
    @JSONField(name = "nationarea")
    @JsonProperty("nationarea")
    private String nationarea;

    /**
     * 属性 [PCMGXMLNAME]
     *
     */
    @JSONField(name = "pcmgxmlname")
    @JsonProperty("pcmgxmlname")
    private String pcmgxmlname;


    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [XXXZ]
     */
    public void setXxxz(String  xxxz){
        this.xxxz = xxxz ;
        this.modify("xxxz",xxxz);
    }

    /**
     * 设置 [GXLB]
     */
    public void setGxlb(String  gxlb){
        this.gxlb = gxlb ;
        this.modify("gxlb",gxlb);
    }

    /**
     * 设置 [NATIONAREA]
     */
    public void setNationarea(String  nationarea){
        this.nationarea = nationarea ;
        this.modify("nationarea",nationarea);
    }

    /**
     * 设置 [PCMGXMLNAME]
     */
    public void setPcmgxmlname(String  pcmgxmlname){
        this.pcmgxmlname = pcmgxmlname ;
        this.modify("pcmgxmlname",pcmgxmlname);
    }


}

