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
 * 服务DTO对象[UserDictItemDTO]
 */
@Data
public class UserDictItemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [USERDICTITEMID]
     *
     */
    @JSONField(name = "userdictitemid")
    @JsonProperty("userdictitemid")
    private String userdictitemid;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERDICTITEMNAME]
     *
     */
    @JSONField(name = "userdictitemname")
    @JsonProperty("userdictitemname")
    private String userdictitemname;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MARKFLAG]
     *
     */
    @JSONField(name = "markflag")
    @JsonProperty("markflag")
    private Integer markflag;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [USERDICTCATNAME]
     *
     */
    @JSONField(name = "userdictcatname")
    @JsonProperty("userdictcatname")
    private String userdictcatname;

    /**
     * 属性 [USERDICTNAME]
     *
     */
    @JSONField(name = "userdictname")
    @JsonProperty("userdictname")
    private String userdictname;

    /**
     * 属性 [USERDICTID]
     *
     */
    @JSONField(name = "userdictid")
    @JsonProperty("userdictid")
    private String userdictid;

    /**
     * 属性 [USERDICTCATID]
     *
     */
    @JSONField(name = "userdictcatid")
    @JsonProperty("userdictcatid")
    private String userdictcatid;


    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [USERDICTITEMNAME]
     */
    public void setUserdictitemname(String  userdictitemname){
        this.userdictitemname = userdictitemname ;
        this.modify("userdictitemname",userdictitemname);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [MARKFLAG]
     */
    public void setMarkflag(Integer  markflag){
        this.markflag = markflag ;
        this.modify("markflag",markflag);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [USERDICTID]
     */
    public void setUserdictid(String  userdictid){
        this.userdictid = userdictid ;
        this.modify("userdictid",userdictid);
    }

    /**
     * 设置 [USERDICTCATID]
     */
    public void setUserdictcatid(String  userdictcatid){
        this.userdictcatid = userdictcatid ;
        this.modify("userdictcatid",userdictcatid);
    }


}

