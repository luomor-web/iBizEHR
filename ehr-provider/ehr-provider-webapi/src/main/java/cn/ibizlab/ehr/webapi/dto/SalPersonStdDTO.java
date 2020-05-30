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
 * 服务DTO对象[SalPersonStdDTO]
 */
@Data
public class SalPersonStdDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [SALPERSONSTDID]
     *
     */
    @JSONField(name = "salpersonstdid")
    @JsonProperty("salpersonstdid")
    private String salpersonstdid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [SALPERSONSTDNAME]
     *
     */
    @JSONField(name = "salpersonstdname")
    @JsonProperty("salpersonstdname")
    private String salpersonstdname;

    /**
     * 属性 [CHANGEREASON]
     *
     */
    @JSONField(name = "changereason")
    @JsonProperty("changereason")
    private String changereason;

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
     * 属性 [BEGINTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "begintime" , format="yyyy-MM-dd")
    @JsonProperty("begintime")
    private Timestamp begintime;

    /**
     * 属性 [SALTYPE]
     *
     */
    @JSONField(name = "saltype")
    @JsonProperty("saltype")
    private String saltype;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [SALPERSONSTDNAME]
     */
    public void setSalpersonstdname(String  salpersonstdname){
        this.salpersonstdname = salpersonstdname ;
        this.modify("salpersonstdname",salpersonstdname);
    }

    /**
     * 设置 [CHANGEREASON]
     */
    public void setChangereason(String  changereason){
        this.changereason = changereason ;
        this.modify("changereason",changereason);
    }

    /**
     * 设置 [BEGINTIME]
     */
    public void setBegintime(Timestamp  begintime){
        this.begintime = begintime ;
        this.modify("begintime",begintime);
    }

    /**
     * 设置 [SALTYPE]
     */
    public void setSaltype(String  saltype){
        this.saltype = saltype ;
        this.modify("saltype",saltype);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}

