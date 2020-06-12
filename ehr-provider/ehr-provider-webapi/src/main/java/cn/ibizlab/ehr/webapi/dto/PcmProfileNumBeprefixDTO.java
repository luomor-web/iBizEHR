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
 * 服务DTO对象[PcmProfileNumBeprefixDTO]
 */
@Data
public class PcmProfileNumBeprefixDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [NUMBERPREFIX]
     *
     */
    @JSONField(name = "numberprefix")
    @JsonProperty("numberprefix")
    private String numberprefix;

    /**
     * 属性 [PCMPROFILENUMBEPREFIXID]
     *
     */
    @JSONField(name = "pcmprofilenumbeprefixid")
    @JsonProperty("pcmprofilenumbeprefixid")
    private String pcmprofilenumbeprefixid;

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
     * 属性 [PCMPROFILENUMBEPREFIXNAME]
     *
     */
    @JSONField(name = "pcmprofilenumbeprefixname")
    @JsonProperty("pcmprofilenumbeprefixname")
    private String pcmprofilenumbeprefixname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [NUMBERPREFIX]
     */
    public void setNumberprefix(String  numberprefix){
        this.numberprefix = numberprefix ;
        this.modify("numberprefix",numberprefix);
    }

    /**
     * 设置 [PCMPROFILENUMBEPREFIXNAME]
     */
    public void setPcmprofilenumbeprefixname(String  pcmprofilenumbeprefixname){
        this.pcmprofilenumbeprefixname = pcmprofilenumbeprefixname ;
        this.modify("pcmprofilenumbeprefixname",pcmprofilenumbeprefixname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

