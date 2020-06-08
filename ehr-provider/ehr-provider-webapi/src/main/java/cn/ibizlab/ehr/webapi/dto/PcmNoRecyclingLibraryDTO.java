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
 * 服务DTO对象[PcmNoRecyclingLibraryDTO]
 */
@Data
public class PcmNoRecyclingLibraryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMNORECYCLINGLIBRARYID]
     *
     */
    @JSONField(name = "pcmnorecyclinglibraryid")
    @JsonProperty("pcmnorecyclinglibraryid")
    private String pcmnorecyclinglibraryid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [YGLX]
     *
     */
    @JSONField(name = "yglx")
    @JsonProperty("yglx")
    private String yglx;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PCMNORECYCLINGLIBRARYNAME]
     *
     */
    @JSONField(name = "pcmnorecyclinglibraryname")
    @JsonProperty("pcmnorecyclinglibraryname")
    private String pcmnorecyclinglibraryname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [USEFUL]
     *
     */
    @JSONField(name = "useful")
    @JsonProperty("useful")
    private Integer useful;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;


    /**
     * 设置 [YGLX]
     */
    public void setYglx(String  yglx){
        this.yglx = yglx ;
        this.modify("yglx",yglx);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PCMNORECYCLINGLIBRARYNAME]
     */
    public void setPcmnorecyclinglibraryname(String  pcmnorecyclinglibraryname){
        this.pcmnorecyclinglibraryname = pcmnorecyclinglibraryname ;
        this.modify("pcmnorecyclinglibraryname",pcmnorecyclinglibraryname);
    }

    /**
     * 设置 [USEFUL]
     */
    public void setUseful(Integer  useful){
        this.useful = useful ;
        this.modify("useful",useful);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }


}

