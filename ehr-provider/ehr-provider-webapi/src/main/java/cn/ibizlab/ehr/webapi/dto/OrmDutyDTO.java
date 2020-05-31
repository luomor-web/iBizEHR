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
 * 服务DTO对象[OrmDutyDTO]
 */
@Data
public class OrmDutyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [FGLX]
     *
     */
    @JSONField(name = "fglx")
    @JsonProperty("fglx")
    private String fglx;

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
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZWJB]
     *
     */
    @JSONField(name = "zwjb")
    @JsonProperty("zwjb")
    private String zwjb;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DYZJ]
     *
     */
    @JSONField(name = "dyzj")
    @JsonProperty("dyzj")
    private String dyzj;

    /**
     * 属性 [NX]
     *
     */
    @JSONField(name = "nx")
    @JsonProperty("nx")
    private Integer nx;

    /**
     * 属性 [ZWLB]
     *
     */
    @JSONField(name = "zwlb")
    @JsonProperty("zwlb")
    private String zwlb;

    /**
     * 属性 [BXJLNX]
     *
     */
    @JSONField(name = "bxjlnx")
    @JsonProperty("bxjlnx")
    private Integer bxjlnx;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;


    /**
     * 设置 [FGLX]
     */
    public void setFglx(String  fglx){
        this.fglx = fglx ;
        this.modify("fglx",fglx);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ZWJB]
     */
    public void setZwjb(String  zwjb){
        this.zwjb = zwjb ;
        this.modify("zwjb",zwjb);
    }

    /**
     * 设置 [DYZJ]
     */
    public void setDyzj(String  dyzj){
        this.dyzj = dyzj ;
        this.modify("dyzj",dyzj);
    }

    /**
     * 设置 [NX]
     */
    public void setNx(Integer  nx){
        this.nx = nx ;
        this.modify("nx",nx);
    }

    /**
     * 设置 [ZWLB]
     */
    public void setZwlb(String  zwlb){
        this.zwlb = zwlb ;
        this.modify("zwlb",zwlb);
    }

    /**
     * 设置 [BXJLNX]
     */
    public void setBxjlnx(Integer  bxjlnx){
        this.bxjlnx = bxjlnx ;
        this.modify("bxjlnx",bxjlnx);
    }

    /**
     * 设置 [ORMDUTYNAME]
     */
    public void setOrmdutyname(String  ormdutyname){
        this.ormdutyname = ormdutyname ;
        this.modify("ormdutyname",ormdutyname);
    }


}

