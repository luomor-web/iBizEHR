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
 * 服务DTO对象[PortalPageDTO]
 */
@Data
public class PortalPageDTO extends DTOBase implements Serializable {

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PORTALPAGEID]
     *
     */
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;

    /**
     * 属性 [ENABLECTX]
     *
     */
    @JSONField(name = "enablectx")
    @JsonProperty("enablectx")
    private Integer enablectx;

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
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [PORTALPAGEMEMO]
     *
     */
    @JSONField(name = "portalpagememo")
    @JsonProperty("portalpagememo")
    private String portalpagememo;

    /**
     * 属性 [PORTALPAGENAME]
     *
     */
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;


    /**
     * 设置 [ENABLECTX]
     */
    public void setEnablectx(Integer  enablectx){
        this.enablectx = enablectx ;
        this.modify("enablectx",enablectx);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [PORTALPAGEMEMO]
     */
    public void setPortalpagememo(String  portalpagememo){
        this.portalpagememo = portalpagememo ;
        this.modify("portalpagememo",portalpagememo);
    }

    /**
     * 设置 [PORTALPAGENAME]
     */
    public void setPortalpagename(String  portalpagename){
        this.portalpagename = portalpagename ;
        this.modify("portalpagename",portalpagename);
    }


}

