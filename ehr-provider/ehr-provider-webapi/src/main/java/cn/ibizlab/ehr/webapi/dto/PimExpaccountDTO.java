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
 * 服务DTO对象[PimExpaccountDTO]
 */
@Data
public class PimExpaccountDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [FFSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "ffsj" , format="yyyy-MM-dd")
    @JsonProperty("ffsj")
    private Timestamp ffsj;

    /**
     * 属性 [FFRS]
     *
     */
    @JSONField(name = "ffrs")
    @JsonProperty("ffrs")
    private Integer ffrs;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [FYJE]
     *
     */
    @JSONField(name = "fyje")
    @JsonProperty("fyje")
    private Double fyje;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PIMEXPACCOUNTNAME]
     *
     */
    @JSONField(name = "pimexpaccountname")
    @JsonProperty("pimexpaccountname")
    private String pimexpaccountname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FFYBZ]
     *
     */
    @JSONField(name = "ffybz")
    @JsonProperty("ffybz")
    private String ffybz;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMEXPACCOUNTID]
     *
     */
    @JSONField(name = "pimexpaccountid")
    @JsonProperty("pimexpaccountid")
    private String pimexpaccountid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [FYLB]
     *
     */
    @JSONField(name = "fylb")
    @JsonProperty("fylb")
    private String fylb;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [FFSJ]
     */
    public void setFfsj(Timestamp  ffsj){
        this.ffsj = ffsj ;
        this.modify("ffsj",ffsj);
    }

    /**
     * 设置 [FFRS]
     */
    public void setFfrs(Integer  ffrs){
        this.ffrs = ffrs ;
        this.modify("ffrs",ffrs);
    }

    /**
     * 设置 [FYJE]
     */
    public void setFyje(Double  fyje){
        this.fyje = fyje ;
        this.modify("fyje",fyje);
    }

    /**
     * 设置 [PIMEXPACCOUNTNAME]
     */
    public void setPimexpaccountname(String  pimexpaccountname){
        this.pimexpaccountname = pimexpaccountname ;
        this.modify("pimexpaccountname",pimexpaccountname);
    }

    /**
     * 设置 [FFYBZ]
     */
    public void setFfybz(String  ffybz){
        this.ffybz = ffybz ;
        this.modify("ffybz",ffybz);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [FYLB]
     */
    public void setFylb(String  fylb){
        this.fylb = fylb ;
        this.modify("fylb",fylb);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

