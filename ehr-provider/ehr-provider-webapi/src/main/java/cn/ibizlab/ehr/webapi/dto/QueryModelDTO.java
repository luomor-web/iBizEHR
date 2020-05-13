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
 * 服务DTO对象[QueryModelDTO]
 */
@Data
public class QueryModelDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [QUERYMODELNAME]
     *
     */
    @JSONField(name = "querymodelname")
    @JsonProperty("querymodelname")
    private String querymodelname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [QUERYOBJECT]
     *
     */
    @JSONField(name = "queryobject")
    @JsonProperty("queryobject")
    private String queryobject;

    /**
     * 属性 [SRFUSERPUB]
     *
     */
    @JSONField(name = "srfuserpub")
    @JsonProperty("srfuserpub")
    private Integer srfuserpub;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [QUERYPARAM]
     *
     */
    @JSONField(name = "queryparam")
    @JsonProperty("queryparam")
    private String queryparam;

    /**
     * 属性 [QUERYMODELID]
     *
     */
    @JSONField(name = "querymodelid")
    @JsonProperty("querymodelid")
    private String querymodelid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [QUERYMODEL]
     *
     */
    @JSONField(name = "querymodel")
    @JsonProperty("querymodel")
    private String querymodel;

    /**
     * 属性 [QUERYFIELD]
     *
     */
    @JSONField(name = "queryfield")
    @JsonProperty("queryfield")
    private String queryfield;

    /**
     * 属性 [QUERYSQL]
     *
     */
    @JSONField(name = "querysql")
    @JsonProperty("querysql")
    private String querysql;

    /**
     * 属性 [SELECTORDER]
     *
     */
    @JSONField(name = "selectorder")
    @JsonProperty("selectorder")
    private String selectorder;

    /**
     * 属性 [QMVERSION]
     *
     */
    @JSONField(name = "qmversion")
    @JsonProperty("qmversion")
    private Integer qmversion;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [GROUPMODEL]
     *
     */
    @JSONField(name = "groupmodel")
    @JsonProperty("groupmodel")
    private String groupmodel;

    /**
     * 属性 [ISRAWMODE]
     *
     */
    @JSONField(name = "israwmode")
    @JsonProperty("israwmode")
    private Integer israwmode;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [SELECTMODE]
     *
     */
    @JSONField(name = "selectmode")
    @JsonProperty("selectmode")
    private String selectmode;

    /**
     * 属性 [QUERYCOND]
     *
     */
    @JSONField(name = "querycond")
    @JsonProperty("querycond")
    private String querycond;

    /**
     * 属性 [SRFSYSPUB]
     *
     */
    @JSONField(name = "srfsyspub")
    @JsonProperty("srfsyspub")
    private Integer srfsyspub;

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
     * 设置 [QUERYMODELNAME]
     */
    public void setQuerymodelname(String  querymodelname){
        this.querymodelname = querymodelname ;
        this.modify("querymodelname",querymodelname);
    }

    /**
     * 设置 [QUERYOBJECT]
     */
    public void setQueryobject(String  queryobject){
        this.queryobject = queryobject ;
        this.modify("queryobject",queryobject);
    }

    /**
     * 设置 [SRFUSERPUB]
     */
    public void setSrfuserpub(Integer  srfuserpub){
        this.srfuserpub = srfuserpub ;
        this.modify("srfuserpub",srfuserpub);
    }

    /**
     * 设置 [QUERYPARAM]
     */
    public void setQueryparam(String  queryparam){
        this.queryparam = queryparam ;
        this.modify("queryparam",queryparam);
    }

    /**
     * 设置 [QUERYMODEL]
     */
    public void setQuerymodel(String  querymodel){
        this.querymodel = querymodel ;
        this.modify("querymodel",querymodel);
    }

    /**
     * 设置 [QUERYFIELD]
     */
    public void setQueryfield(String  queryfield){
        this.queryfield = queryfield ;
        this.modify("queryfield",queryfield);
    }

    /**
     * 设置 [QUERYSQL]
     */
    public void setQuerysql(String  querysql){
        this.querysql = querysql ;
        this.modify("querysql",querysql);
    }

    /**
     * 设置 [SELECTORDER]
     */
    public void setSelectorder(String  selectorder){
        this.selectorder = selectorder ;
        this.modify("selectorder",selectorder);
    }

    /**
     * 设置 [QMVERSION]
     */
    public void setQmversion(Integer  qmversion){
        this.qmversion = qmversion ;
        this.modify("qmversion",qmversion);
    }

    /**
     * 设置 [GROUPMODEL]
     */
    public void setGroupmodel(String  groupmodel){
        this.groupmodel = groupmodel ;
        this.modify("groupmodel",groupmodel);
    }

    /**
     * 设置 [ISRAWMODE]
     */
    public void setIsrawmode(Integer  israwmode){
        this.israwmode = israwmode ;
        this.modify("israwmode",israwmode);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [SELECTMODE]
     */
    public void setSelectmode(String  selectmode){
        this.selectmode = selectmode ;
        this.modify("selectmode",selectmode);
    }

    /**
     * 设置 [QUERYCOND]
     */
    public void setQuerycond(String  querycond){
        this.querycond = querycond ;
        this.modify("querycond",querycond);
    }

    /**
     * 设置 [SRFSYSPUB]
     */
    public void setSrfsyspub(Integer  srfsyspub){
        this.srfsyspub = srfsyspub ;
        this.modify("srfsyspub",srfsyspub);
    }

    /**
     * 设置 [DEID]
     */
    public void setDeid(String  deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }


}

