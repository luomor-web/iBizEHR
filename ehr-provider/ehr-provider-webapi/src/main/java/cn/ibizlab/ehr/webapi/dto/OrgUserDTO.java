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
 * 服务DTO对象[OrgUserDTO]
 */
@Data
public class OrgUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGUSERNAME]
     *
     */
    @JSONField(name = "orgusername")
    @JsonProperty("orgusername")
    private String orgusername;

    /**
     * 属性 [RESERVER16]
     *
     */
    @JSONField(name = "reserver16")
    @JsonProperty("reserver16")
    private Double reserver16;

    /**
     * 属性 [RESERVER30]
     *
     */
    @JSONField(name = "reserver30")
    @JsonProperty("reserver30")
    private String reserver30;

    /**
     * 属性 [RESERVER4]
     *
     */
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;

    /**
     * 属性 [RESERVER13]
     *
     */
    @JSONField(name = "reserver13")
    @JsonProperty("reserver13")
    private Integer reserver13;

    /**
     * 属性 [RESERVER9]
     *
     */
    @JSONField(name = "reserver9")
    @JsonProperty("reserver9")
    private String reserver9;

    /**
     * 属性 [RESERVER29]
     *
     */
    @JSONField(name = "reserver29")
    @JsonProperty("reserver29")
    private String reserver29;

    /**
     * 属性 [USERCODE]
     *
     */
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;

    /**
     * 属性 [RESERVER5]
     *
     */
    @JSONField(name = "reserver5")
    @JsonProperty("reserver5")
    private String reserver5;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [TITLENAME]
     *
     */
    @JSONField(name = "titlename")
    @JsonProperty("titlename")
    private String titlename;

    /**
     * 属性 [ORGUSERID]
     *
     */
    @JSONField(name = "orguserid")
    @JsonProperty("orguserid")
    private String orguserid;

    /**
     * 属性 [RESERVER7]
     *
     */
    @JSONField(name = "reserver7")
    @JsonProperty("reserver7")
    private String reserver7;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [RESERVER10]
     *
     */
    @JSONField(name = "reserver10")
    @JsonProperty("reserver10")
    private String reserver10;

    /**
     * 属性 [VALIDFLAG]
     *
     */
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;

    /**
     * 属性 [RESERVER19]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver19" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver19")
    private Timestamp reserver19;

    /**
     * 属性 [RESERVER21]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver21" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver21")
    private Timestamp reserver21;

    /**
     * 属性 [RESERVER23]
     *
     */
    @JSONField(name = "reserver23")
    @JsonProperty("reserver23")
    private String reserver23;

    /**
     * 属性 [RESERVER2]
     *
     */
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;

    /**
     * 属性 [RESERVER22]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver22" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver22")
    private Timestamp reserver22;

    /**
     * 属性 [RESERVER27]
     *
     */
    @JSONField(name = "reserver27")
    @JsonProperty("reserver27")
    private String reserver27;

    /**
     * 属性 [RESERVER24]
     *
     */
    @JSONField(name = "reserver24")
    @JsonProperty("reserver24")
    private String reserver24;

    /**
     * 属性 [RESERVER28]
     *
     */
    @JSONField(name = "reserver28")
    @JsonProperty("reserver28")
    private String reserver28;

    /**
     * 属性 [RESERVER14]
     *
     */
    @JSONField(name = "reserver14")
    @JsonProperty("reserver14")
    private Integer reserver14;

    /**
     * 属性 [RESERVER20]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "reserver20" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("reserver20")
    private Timestamp reserver20;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [RESERVER15]
     *
     */
    @JSONField(name = "reserver15")
    @JsonProperty("reserver15")
    private Double reserver15;

    /**
     * 属性 [RESERVER3]
     *
     */
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;

    /**
     * 属性 [RESERVER11]
     *
     */
    @JSONField(name = "reserver11")
    @JsonProperty("reserver11")
    private Integer reserver11;

    /**
     * 属性 [RESERVER25]
     *
     */
    @JSONField(name = "reserver25")
    @JsonProperty("reserver25")
    private String reserver25;

    /**
     * 属性 [RESERVER26]
     *
     */
    @JSONField(name = "reserver26")
    @JsonProperty("reserver26")
    private String reserver26;

    /**
     * 属性 [RESERVER8]
     *
     */
    @JSONField(name = "reserver8")
    @JsonProperty("reserver8")
    private String reserver8;

    /**
     * 属性 [RESERVER6]
     *
     */
    @JSONField(name = "reserver6")
    @JsonProperty("reserver6")
    private String reserver6;

    /**
     * 属性 [RESERVER12]
     *
     */
    @JSONField(name = "reserver12")
    @JsonProperty("reserver12")
    private Integer reserver12;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [RESERVER18]
     *
     */
    @JSONField(name = "reserver18")
    @JsonProperty("reserver18")
    private Double reserver18;

    /**
     * 属性 [RESERVER17]
     *
     */
    @JSONField(name = "reserver17")
    @JsonProperty("reserver17")
    private Double reserver17;

    /**
     * 属性 [ORGSECUSERTYPENAME]
     *
     */
    @JSONField(name = "orgsecusertypename")
    @JsonProperty("orgsecusertypename")
    private String orgsecusertypename;

    /**
     * 属性 [BIZCODE]
     *
     */
    @JSONField(name = "bizcode")
    @JsonProperty("bizcode")
    private String bizcode;

    /**
     * 属性 [ORGSECTORNAME]
     *
     */
    @JSONField(name = "orgsectorname")
    @JsonProperty("orgsectorname")
    private String orgsectorname;

    /**
     * 属性 [ORGUSERLEVELNAME]
     *
     */
    @JSONField(name = "orguserlevelname")
    @JsonProperty("orguserlevelname")
    private String orguserlevelname;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ORGUSERLEVELID]
     *
     */
    @JSONField(name = "orguserlevelid")
    @JsonProperty("orguserlevelid")
    private String orguserlevelid;

    /**
     * 属性 [ORGSECUSERTYPEID]
     *
     */
    @JSONField(name = "orgsecusertypeid")
    @JsonProperty("orgsecusertypeid")
    private String orgsecusertypeid;

    /**
     * 属性 [ORGSECTORID]
     *
     */
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;


    /**
     * 设置 [ORGUSERNAME]
     */
    public void setOrgusername(String  orgusername){
        this.orgusername = orgusername ;
        this.modify("orgusername",orgusername);
    }

    /**
     * 设置 [RESERVER16]
     */
    public void setReserver16(Double  reserver16){
        this.reserver16 = reserver16 ;
        this.modify("reserver16",reserver16);
    }

    /**
     * 设置 [RESERVER30]
     */
    public void setReserver30(String  reserver30){
        this.reserver30 = reserver30 ;
        this.modify("reserver30",reserver30);
    }

    /**
     * 设置 [RESERVER4]
     */
    public void setReserver4(String  reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }

    /**
     * 设置 [RESERVER13]
     */
    public void setReserver13(Integer  reserver13){
        this.reserver13 = reserver13 ;
        this.modify("reserver13",reserver13);
    }

    /**
     * 设置 [RESERVER9]
     */
    public void setReserver9(String  reserver9){
        this.reserver9 = reserver9 ;
        this.modify("reserver9",reserver9);
    }

    /**
     * 设置 [RESERVER29]
     */
    public void setReserver29(String  reserver29){
        this.reserver29 = reserver29 ;
        this.modify("reserver29",reserver29);
    }

    /**
     * 设置 [USERCODE]
     */
    public void setUsercode(String  usercode){
        this.usercode = usercode ;
        this.modify("usercode",usercode);
    }

    /**
     * 设置 [RESERVER5]
     */
    public void setReserver5(String  reserver5){
        this.reserver5 = reserver5 ;
        this.modify("reserver5",reserver5);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
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
     * 设置 [TITLENAME]
     */
    public void setTitlename(String  titlename){
        this.titlename = titlename ;
        this.modify("titlename",titlename);
    }

    /**
     * 设置 [RESERVER7]
     */
    public void setReserver7(String  reserver7){
        this.reserver7 = reserver7 ;
        this.modify("reserver7",reserver7);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [RESERVER10]
     */
    public void setReserver10(String  reserver10){
        this.reserver10 = reserver10 ;
        this.modify("reserver10",reserver10);
    }

    /**
     * 设置 [VALIDFLAG]
     */
    public void setValidflag(Integer  validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }

    /**
     * 设置 [RESERVER19]
     */
    public void setReserver19(Timestamp  reserver19){
        this.reserver19 = reserver19 ;
        this.modify("reserver19",reserver19);
    }

    /**
     * 设置 [RESERVER21]
     */
    public void setReserver21(Timestamp  reserver21){
        this.reserver21 = reserver21 ;
        this.modify("reserver21",reserver21);
    }

    /**
     * 设置 [RESERVER23]
     */
    public void setReserver23(String  reserver23){
        this.reserver23 = reserver23 ;
        this.modify("reserver23",reserver23);
    }

    /**
     * 设置 [RESERVER2]
     */
    public void setReserver2(String  reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }

    /**
     * 设置 [RESERVER22]
     */
    public void setReserver22(Timestamp  reserver22){
        this.reserver22 = reserver22 ;
        this.modify("reserver22",reserver22);
    }

    /**
     * 设置 [RESERVER27]
     */
    public void setReserver27(String  reserver27){
        this.reserver27 = reserver27 ;
        this.modify("reserver27",reserver27);
    }

    /**
     * 设置 [RESERVER24]
     */
    public void setReserver24(String  reserver24){
        this.reserver24 = reserver24 ;
        this.modify("reserver24",reserver24);
    }

    /**
     * 设置 [RESERVER28]
     */
    public void setReserver28(String  reserver28){
        this.reserver28 = reserver28 ;
        this.modify("reserver28",reserver28);
    }

    /**
     * 设置 [RESERVER14]
     */
    public void setReserver14(Integer  reserver14){
        this.reserver14 = reserver14 ;
        this.modify("reserver14",reserver14);
    }

    /**
     * 设置 [RESERVER20]
     */
    public void setReserver20(Timestamp  reserver20){
        this.reserver20 = reserver20 ;
        this.modify("reserver20",reserver20);
    }

    /**
     * 设置 [ORDERVALUE]
     */
    public void setOrdervalue(Integer  ordervalue){
        this.ordervalue = ordervalue ;
        this.modify("ordervalue",ordervalue);
    }

    /**
     * 设置 [RESERVER15]
     */
    public void setReserver15(Double  reserver15){
        this.reserver15 = reserver15 ;
        this.modify("reserver15",reserver15);
    }

    /**
     * 设置 [RESERVER3]
     */
    public void setReserver3(String  reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }

    /**
     * 设置 [RESERVER11]
     */
    public void setReserver11(Integer  reserver11){
        this.reserver11 = reserver11 ;
        this.modify("reserver11",reserver11);
    }

    /**
     * 设置 [RESERVER25]
     */
    public void setReserver25(String  reserver25){
        this.reserver25 = reserver25 ;
        this.modify("reserver25",reserver25);
    }

    /**
     * 设置 [RESERVER26]
     */
    public void setReserver26(String  reserver26){
        this.reserver26 = reserver26 ;
        this.modify("reserver26",reserver26);
    }

    /**
     * 设置 [RESERVER8]
     */
    public void setReserver8(String  reserver8){
        this.reserver8 = reserver8 ;
        this.modify("reserver8",reserver8);
    }

    /**
     * 设置 [RESERVER6]
     */
    public void setReserver6(String  reserver6){
        this.reserver6 = reserver6 ;
        this.modify("reserver6",reserver6);
    }

    /**
     * 设置 [RESERVER12]
     */
    public void setReserver12(Integer  reserver12){
        this.reserver12 = reserver12 ;
        this.modify("reserver12",reserver12);
    }

    /**
     * 设置 [RESERVER18]
     */
    public void setReserver18(Double  reserver18){
        this.reserver18 = reserver18 ;
        this.modify("reserver18",reserver18);
    }

    /**
     * 设置 [RESERVER17]
     */
    public void setReserver17(Double  reserver17){
        this.reserver17 = reserver17 ;
        this.modify("reserver17",reserver17);
    }

    /**
     * 设置 [ORGSECUSERTYPENAME]
     */
    public void setOrgsecusertypename(String  orgsecusertypename){
        this.orgsecusertypename = orgsecusertypename ;
        this.modify("orgsecusertypename",orgsecusertypename);
    }

    /**
     * 设置 [ORGUSERLEVELNAME]
     */
    public void setOrguserlevelname(String  orguserlevelname){
        this.orguserlevelname = orguserlevelname ;
        this.modify("orguserlevelname",orguserlevelname);
    }

    /**
     * 设置 [ORGUSERLEVELID]
     */
    public void setOrguserlevelid(String  orguserlevelid){
        this.orguserlevelid = orguserlevelid ;
        this.modify("orguserlevelid",orguserlevelid);
    }

    /**
     * 设置 [ORGSECUSERTYPEID]
     */
    public void setOrgsecusertypeid(String  orgsecusertypeid){
        this.orgsecusertypeid = orgsecusertypeid ;
        this.modify("orgsecusertypeid",orgsecusertypeid);
    }


}

