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
 * 服务DTO对象[UserRoleDEFieldDTO]
 */
@Data
public class UserRoleDEFieldDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERROLEDEFIELDNAME]
     *
     */
    @JSONField(name = "userroledefieldname")
    @JsonProperty("userroledefieldname")
    private String userroledefieldname;

    /**
     * 属性 [DEFACTION]
     *
     */
    @JSONField(name = "defaction")
    @JsonProperty("defaction")
    private String defaction;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [USERROLEDEFIELDID]
     *
     */
    @JSONField(name = "userroledefieldid")
    @JsonProperty("userroledefieldid")
    private String userroledefieldid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SRFSYSPUB]
     *
     */
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [SRFUSERPUB]
     *
     */
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;

    /**
     * 属性 [RELATEDDEFIELD]
     *
     */
    @JSONField(name = "relateddefield")
    @JsonProperty("relateddefield")
    private String relateddefield;

    /**
     * 属性 [DENAME]
     *
     */
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;

    /**
     * 属性 [DEID]
     *
     */
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;


    /**
     * 设置 [USERROLEDEFIELDNAME]
     */
    public void setUserroledefieldname(String  userroledefieldname){
        this.userroledefieldname = userroledefieldname ;
        this.modify("userroledefieldname",userroledefieldname);
    }

    /**
     * 设置 [DEFACTION]
     */
    public void setDefaction(String  defaction){
        this.defaction = defaction ;
        this.modify("defaction",defaction);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [SRFSYSPUB]
     */
    public void setSrfsyspub(Integer  srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [SRFUSERPUB]
     */
    public void setSrfuserpub(Integer  srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }

    /**
     * 设置 [RELATEDDEFIELD]
     */
    public void setRelateddefield(String  relateddefield){
        this.relateddefield = relateddefield ;
        this.modify("relateddefield",relateddefield);
    }

    /**
     * 设置 [DENAME]
     */
    public void setDename(String  dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }

    /**
     * 设置 [DEID]
     */
    public void setDeid(String  deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }


}

