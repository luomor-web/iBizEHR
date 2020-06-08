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
 * 服务DTO对象[PimArchivesDTO]
 */
@Data
public class PimArchivesDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ZT]
     *
     */
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;

    /**
     * 属性 [DALYD]
     *
     */
    @JSONField(name = "dalyd")
    @JsonProperty("dalyd")
    private String dalyd;

    /**
     * 属性 [FILEAUDIT]
     *
     */
    @JSONField(name = "fileaudit")
    @JsonProperty("fileaudit")
    private Integer fileaudit;

    /**
     * 属性 [EDUCATION]
     *
     */
    @JSONField(name = "education")
    @JsonProperty("education")
    private String education;

    /**
     * 属性 [PIMARCHIVESID]
     *
     */
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [DCDA]
     *
     */
    @JSONField(name = "dcda")
    @JsonProperty("dcda")
    private String dcda;

    /**
     * 属性 [OPERATIONDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "operationdate" , format="yyyy-MM-dd")
    @JsonProperty("operationdate")
    private Timestamp operationdate;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [TRANSTOOUT]
     *
     */
    @JSONField(name = "transtoout")
    @JsonProperty("transtoout")
    private String transtoout;

    /**
     * 属性 [PIMARCHIVESNAME]
     *
     */
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;

    /**
     * 属性 [STARTWORKDATAE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "startworkdatae" , format="yyyy-MM-dd")
    @JsonProperty("startworkdatae")
    private Timestamp startworkdatae;

    /**
     * 属性 [SFXJD]
     *
     */
    @JSONField(name = "sfxjd")
    @JsonProperty("sfxjd")
    private Integer sfxjd;

    /**
     * 属性 [DABH]
     *
     */
    @JSONField(name = "dabh")
    @JsonProperty("dabh")
    private String dabh;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CFGH]
     *
     */
    @JSONField(name = "cfgh")
    @JsonProperty("cfgh")
    private String cfgh;

    /**
     * 属性 [DATEOFBIRTH]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dateofbirth" , format="yyyy-MM-dd")
    @JsonProperty("dateofbirth")
    private Timestamp dateofbirth;

    /**
     * 属性 [DADRRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dadrrq" , format="yyyy-MM-dd")
    @JsonProperty("dadrrq")
    private Timestamp dadrrq;

    /**
     * 属性 [DAZT]
     *
     */
    @JSONField(name = "dazt")
    @JsonProperty("dazt")
    private String dazt;

    /**
     * 属性 [DASTATE]
     *
     */
    @JSONField(name = "dastate")
    @JsonProperty("dastate")
    private String dastate;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [JOINPARTYDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "joinpartydate" , format="yyyy-MM-dd")
    @JsonProperty("joinpartydate")
    private Timestamp joinpartydate;

    /**
     * 属性 [OPERATIONS]
     *
     */
    @JSONField(name = "operations")
    @JsonProperty("operations")
    private String operations;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [DABGD]
     *
     */
    @JSONField(name = "dabgd")
    @JsonProperty("dabgd")
    private String dabgd;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DAMU]
     *
     */
    @JSONField(name = "damu")
    @JsonProperty("damu")
    private String damu;

    /**
     * 属性 [DADCDW]
     *
     */
    @JSONField(name = "dadcdw")
    @JsonProperty("dadcdw")
    private String dadcdw;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 属性 [DRDA]
     *
     */
    @JSONField(name = "drda")
    @JsonProperty("drda")
    private String drda;

    /**
     * 属性 [XDABGDW]
     *
     */
    @JSONField(name = "xdabgdw")
    @JsonProperty("xdabgdw")
    private String xdabgdw;

    /**
     * 属性 [DABGDD]
     *
     */
    @JSONField(name = "dabgdd")
    @JsonProperty("dabgdd")
    private String dabgdd;

    /**
     * 属性 [ARCHIVESCENTERNAME]
     *
     */
    @JSONField(name = "archivescentername")
    @JsonProperty("archivescentername")
    private String archivescentername;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [GLZZDZS]
     *
     */
    @JSONField(name = "glzzdzs")
    @JsonProperty("glzzdzs")
    private String glzzdzs;

    /**
     * 属性 [ORMORGNAME2]
     *
     */
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;

    /**
     * 属性 [DBDWSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [LEAVEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "leavedate" , format="yyyy-MM-dd")
    @JsonProperty("leavedate")
    private Timestamp leavedate;

    /**
     * 属性 [SSZZDZS]
     *
     */
    @JSONField(name = "sszzdzs")
    @JsonProperty("sszzdzs")
    private String sszzdzs;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ORMORGNAME3]
     *
     */
    @JSONField(name = "ormorgname3")
    @JsonProperty("ormorgname3")
    private String ormorgname3;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [ZGCODE]
     *
     */
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;

    /**
     * 属性 [YGZT]
     *
     */
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;

    /**
     * 属性 [ZZDZS]
     *
     */
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;

    /**
     * 属性 [ARCHIVESCENTERID]
     *
     */
    @JSONField(name = "archivescenterid")
    @JsonProperty("archivescenterid")
    private String archivescenterid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [ORMORGID2]
     *
     */
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;

    /**
     * 属性 [ORMORGID3]
     *
     */
    @JSONField(name = "ormorgid3")
    @JsonProperty("ormorgid3")
    private String ormorgid3;


    /**
     * 设置 [ZT]
     */
    public void setZt(String  zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [DALYD]
     */
    public void setDalyd(String  dalyd){
        this.dalyd = dalyd ;
        this.modify("dalyd",dalyd);
    }

    /**
     * 设置 [FILEAUDIT]
     */
    public void setFileaudit(Integer  fileaudit){
        this.fileaudit = fileaudit ;
        this.modify("fileaudit",fileaudit);
    }

    /**
     * 设置 [EDUCATION]
     */
    public void setEducation(String  education){
        this.education = education ;
        this.modify("education",education);
    }

    /**
     * 设置 [DCDA]
     */
    public void setDcda(String  dcda){
        this.dcda = dcda ;
        this.modify("dcda",dcda);
    }

    /**
     * 设置 [OPERATIONDATE]
     */
    public void setOperationdate(Timestamp  operationdate){
        this.operationdate = operationdate ;
        this.modify("operationdate",operationdate);
    }

    /**
     * 设置 [TRANSTOOUT]
     */
    public void setTranstoout(String  transtoout){
        this.transtoout = transtoout ;
        this.modify("transtoout",transtoout);
    }

    /**
     * 设置 [PIMARCHIVESNAME]
     */
    public void setPimarchivesname(String  pimarchivesname){
        this.pimarchivesname = pimarchivesname ;
        this.modify("pimarchivesname",pimarchivesname);
    }

    /**
     * 设置 [STARTWORKDATAE]
     */
    public void setStartworkdatae(Timestamp  startworkdatae){
        this.startworkdatae = startworkdatae ;
        this.modify("startworkdatae",startworkdatae);
    }

    /**
     * 设置 [SFXJD]
     */
    public void setSfxjd(Integer  sfxjd){
        this.sfxjd = sfxjd ;
        this.modify("sfxjd",sfxjd);
    }

    /**
     * 设置 [DABH]
     */
    public void setDabh(String  dabh){
        this.dabh = dabh ;
        this.modify("dabh",dabh);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [CFGH]
     */
    public void setCfgh(String  cfgh){
        this.cfgh = cfgh ;
        this.modify("cfgh",cfgh);
    }

    /**
     * 设置 [DATEOFBIRTH]
     */
    public void setDateofbirth(Timestamp  dateofbirth){
        this.dateofbirth = dateofbirth ;
        this.modify("dateofbirth",dateofbirth);
    }

    /**
     * 设置 [DADRRQ]
     */
    public void setDadrrq(Timestamp  dadrrq){
        this.dadrrq = dadrrq ;
        this.modify("dadrrq",dadrrq);
    }

    /**
     * 设置 [DAZT]
     */
    public void setDazt(String  dazt){
        this.dazt = dazt ;
        this.modify("dazt",dazt);
    }

    /**
     * 设置 [DASTATE]
     */
    public void setDastate(String  dastate){
        this.dastate = dastate ;
        this.modify("dastate",dastate);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [JOINPARTYDATE]
     */
    public void setJoinpartydate(Timestamp  joinpartydate){
        this.joinpartydate = joinpartydate ;
        this.modify("joinpartydate",joinpartydate);
    }

    /**
     * 设置 [OPERATIONS]
     */
    public void setOperations(String  operations){
        this.operations = operations ;
        this.modify("operations",operations);
    }

    /**
     * 设置 [DABGD]
     */
    public void setDabgd(String  dabgd){
        this.dabgd = dabgd ;
        this.modify("dabgd",dabgd);
    }

    /**
     * 设置 [DAMU]
     */
    public void setDamu(String  damu){
        this.damu = damu ;
        this.modify("damu",damu);
    }

    /**
     * 设置 [DADCDW]
     */
    public void setDadcdw(String  dadcdw){
        this.dadcdw = dadcdw ;
        this.modify("dadcdw",dadcdw);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(Integer  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [DRDA]
     */
    public void setDrda(String  drda){
        this.drda = drda ;
        this.modify("drda",drda);
    }

    /**
     * 设置 [XDABGDW]
     */
    public void setXdabgdw(String  xdabgdw){
        this.xdabgdw = xdabgdw ;
        this.modify("xdabgdw",xdabgdw);
    }

    /**
     * 设置 [DABGDD]
     */
    public void setDabgdd(String  dabgdd){
        this.dabgdd = dabgdd ;
        this.modify("dabgdd",dabgdd);
    }

    /**
     * 设置 [ORMORGNAME2]
     */
    public void setOrmorgname2(String  ormorgname2){
        this.ormorgname2 = ormorgname2 ;
        this.modify("ormorgname2",ormorgname2);
    }

    /**
     * 设置 [ARCHIVESCENTERID]
     */
    public void setArchivescenterid(String  archivescenterid){
        this.archivescenterid = archivescenterid ;
        this.modify("archivescenterid",archivescenterid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [ORMORGID2]
     */
    public void setOrmorgid2(String  ormorgid2){
        this.ormorgid2 = ormorgid2 ;
        this.modify("ormorgid2",ormorgid2);
    }

    /**
     * 设置 [ORMORGID3]
     */
    public void setOrmorgid3(String  ormorgid3){
        this.ormorgid3 = ormorgid3 ;
        this.modify("ormorgid3",ormorgid3);
    }


}

