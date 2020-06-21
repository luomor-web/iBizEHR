package cn.ibizlab.ehr.core.pim.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[档案信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMARCHIVES",resultMap = "PimArchivesResultMap")
public class PimArchives extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 档案借阅状态
     */
    @TableField(value = "zt")
    @JSONField(name = "zt")
    @JsonProperty("zt")
    private String zt;
    /**
     * 档案来源地
     */
    @TableField(value = "dalyd")
    @JSONField(name = "dalyd")
    @JsonProperty("dalyd")
    private String dalyd;
    /**
     * 档案专项审核
     */
    @TableField(value = "fileaudit")
    @JSONField(name = "fileaudit")
    @JsonProperty("fileaudit")
    private Integer fileaudit;
    /**
     * 档案学历
     */
    @TableField(value = "education")
    @JSONField(name = "education")
    @JsonProperty("education")
    private String education;
    /**
     * 档案信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimarchivesid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 调出档案
     */
    @TableField(value = "dcda")
    @JSONField(name = "dcda")
    @JsonProperty("dcda")
    private String dcda;
    /**
     * 操作时间
     */
    @TableField(value = "operationdate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "operationdate" , format="yyyy-MM-dd")
    @JsonProperty("operationdate")
    private Timestamp operationdate;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 调出至（外单位）
     */
    @TableField(value = "transtoout")
    @JSONField(name = "transtoout")
    @JsonProperty("transtoout")
    private String transtoout;
    /**
     * 档案信息名称
     */
    @TableField(value = "pimarchivesname")
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;
    /**
     * 档案参加工作时间
     */
    @TableField(value = "startworkdatae")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "startworkdatae" , format="yyyy-MM-dd")
    @JsonProperty("startworkdatae")
    private Timestamp startworkdatae;
    /**
     * 是否新建档
     */
    @TableField(value = "sfxjd")
    @JSONField(name = "sfxjd")
    @JsonProperty("sfxjd")
    private Integer sfxjd;
    /**
     * 档案编号
     */
    @TableField(value = "dabh")
    @JSONField(name = "dabh")
    @JsonProperty("dabh")
    private String dabh;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 存放柜号
     */
    @TableField(value = "cfgh")
    @JSONField(name = "cfgh")
    @JsonProperty("cfgh")
    private String cfgh;
    /**
     * 档案出生日期
     */
    @TableField(value = "dateofbirth")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dateofbirth" , format="yyyy-MM-dd")
    @JsonProperty("dateofbirth")
    private Timestamp dateofbirth;
    /**
     * 档案调动日期
     */
    @TableField(value = "dadrrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dadrrq" , format="yyyy-MM-dd")
    @JsonProperty("dadrrq")
    private Timestamp dadrrq;
    /**
     * 档案状态
     */
    @TableField(value = "dazt")
    @JSONField(name = "dazt")
    @JsonProperty("dazt")
    private String dazt;
    /**
     * 档案状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "dastate")
    @JSONField(name = "dastate")
    @JsonProperty("dastate")
    private String dastate;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 档案入党时间
     */
    @TableField(value = "joinpartydate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "joinpartydate" , format="yyyy-MM-dd")
    @JsonProperty("joinpartydate")
    private Timestamp joinpartydate;
    /**
     * 操作内容
     */
    @TableField(value = "operations")
    @JSONField(name = "operations")
    @JsonProperty("operations")
    private String operations;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID)
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 档案保管地
     */
    @TableField(value = "dabgd")
    @JSONField(name = "dabgd")
    @JsonProperty("dabgd")
    private String dabgd;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 档案目录
     */
    @TableField(value = "damu")
    @JSONField(name = "damu")
    @JsonProperty("damu")
    private String damu;
    /**
     * 档案调出单位
     */
    @TableField(value = "dadcdw")
    @JSONField(name = "dadcdw")
    @JsonProperty("dadcdw")
    private String dadcdw;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 档案未转出月数
     */
    @TableField(value = "duration")
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;
    /**
     * 调入档案
     */
    @TableField(value = "drda")
    @JSONField(name = "drda")
    @JsonProperty("drda")
    private String drda;
    /**
     * 现档案保管单位
     */
    @TableField(value = "xdabgdw")
    @JSONField(name = "xdabgdw")
    @JsonProperty("xdabgdw")
    private String xdabgdw;
    /**
     * 档案保管地
     */
    @TableField(value = "dabgdd")
    @JSONField(name = "dabgdd")
    @JsonProperty("dabgdd")
    private String dabgdd;
    /**
     * 档案室
     */
    @TableField(exist = false)
    @JSONField(name = "archivescentername")
    @JsonProperty("archivescentername")
    private String archivescentername;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 管理单位
     */
    @TableField(exist = false)
    @JSONField(name = "glzzdzs")
    @JsonProperty("glzzdzs")
    private String glzzdzs;
    /**
     * 调出单位
     */
    @TableField(value = "ormorgname2")
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;
    /**
     * 到本单位时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 离职日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "leavedate" , format="yyyy-MM-dd")
    @JsonProperty("leavedate")
    private Timestamp leavedate;
    /**
     * 所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "sszzdzs")
    @JsonProperty("sszzdzs")
    private String sszzdzs;
    /**
     * 组织编号
     */
    @TableField(exist = false)
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 管理单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname3")
    @JsonProperty("ormorgname3")
    private String ormorgname3;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 在岗状态
     */
    @TableField(exist = false)
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 管理单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 档案室管理标识
     */
    @TableField(value = "archivescenterid")
    @JSONField(name = "archivescenterid")
    @JsonProperty("archivescenterid")
    private String archivescenterid;
    /**
     * 员工
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 现档案保管单位标识
     */
    @TableField(value = "ormorgid2")
    @JSONField(name = "ormorgid2")
    @JsonProperty("ormorgid2")
    private String ormorgid2;
    /**
     * 管理单位
     */
    @TableField(value = "ormorgid3")
    @JSONField(name = "ormorgid3")
    @JsonProperty("ormorgid3")
    private String ormorgid3;

    /**
     * 档案存放位置
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter archivescenter;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 档案管理单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg3;

    /**
     * 档案信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [档案借阅状态]
     */
    public void setZt(String zt){
        this.zt = zt ;
        this.modify("zt",zt);
    }

    /**
     * 设置 [档案来源地]
     */
    public void setDalyd(String dalyd){
        this.dalyd = dalyd ;
        this.modify("dalyd",dalyd);
    }

    /**
     * 设置 [档案专项审核]
     */
    public void setFileaudit(Integer fileaudit){
        this.fileaudit = fileaudit ;
        this.modify("fileaudit",fileaudit);
    }

    /**
     * 设置 [档案学历]
     */
    public void setEducation(String education){
        this.education = education ;
        this.modify("education",education);
    }

    /**
     * 设置 [调出档案]
     */
    public void setDcda(String dcda){
        this.dcda = dcda ;
        this.modify("dcda",dcda);
    }

    /**
     * 设置 [操作时间]
     */
    public void setOperationdate(Timestamp operationdate){
        this.operationdate = operationdate ;
        this.modify("operationdate",operationdate);
    }

    /**
     * 格式化日期 [操作时间]
     */
    public String formatOperationdate(){
        if (this.operationdate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(operationdate);
    }
    /**
     * 设置 [调出至（外单位）]
     */
    public void setTranstoout(String transtoout){
        this.transtoout = transtoout ;
        this.modify("transtoout",transtoout);
    }

    /**
     * 设置 [档案信息名称]
     */
    public void setPimarchivesname(String pimarchivesname){
        this.pimarchivesname = pimarchivesname ;
        this.modify("pimarchivesname",pimarchivesname);
    }

    /**
     * 设置 [档案参加工作时间]
     */
    public void setStartworkdatae(Timestamp startworkdatae){
        this.startworkdatae = startworkdatae ;
        this.modify("startworkdatae",startworkdatae);
    }

    /**
     * 格式化日期 [档案参加工作时间]
     */
    public String formatStartworkdatae(){
        if (this.startworkdatae == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(startworkdatae);
    }
    /**
     * 设置 [是否新建档]
     */
    public void setSfxjd(Integer sfxjd){
        this.sfxjd = sfxjd ;
        this.modify("sfxjd",sfxjd);
    }

    /**
     * 设置 [档案编号]
     */
    public void setDabh(String dabh){
        this.dabh = dabh ;
        this.modify("dabh",dabh);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [存放柜号]
     */
    public void setCfgh(String cfgh){
        this.cfgh = cfgh ;
        this.modify("cfgh",cfgh);
    }

    /**
     * 设置 [档案出生日期]
     */
    public void setDateofbirth(Timestamp dateofbirth){
        this.dateofbirth = dateofbirth ;
        this.modify("dateofbirth",dateofbirth);
    }

    /**
     * 格式化日期 [档案出生日期]
     */
    public String formatDateofbirth(){
        if (this.dateofbirth == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateofbirth);
    }
    /**
     * 设置 [档案调动日期]
     */
    public void setDadrrq(Timestamp dadrrq){
        this.dadrrq = dadrrq ;
        this.modify("dadrrq",dadrrq);
    }

    /**
     * 格式化日期 [档案调动日期]
     */
    public String formatDadrrq(){
        if (this.dadrrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dadrrq);
    }
    /**
     * 设置 [档案状态]
     */
    public void setDazt(String dazt){
        this.dazt = dazt ;
        this.modify("dazt",dazt);
    }

    /**
     * 设置 [档案状态]
     */
    public void setDastate(String dastate){
        this.dastate = dastate ;
        this.modify("dastate",dastate);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [档案入党时间]
     */
    public void setJoinpartydate(Timestamp joinpartydate){
        this.joinpartydate = joinpartydate ;
        this.modify("joinpartydate",joinpartydate);
    }

    /**
     * 格式化日期 [档案入党时间]
     */
    public String formatJoinpartydate(){
        if (this.joinpartydate == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(joinpartydate);
    }
    /**
     * 设置 [操作内容]
     */
    public void setOperations(String operations){
        this.operations = operations ;
        this.modify("operations",operations);
    }

    /**
     * 设置 [档案保管地]
     */
    public void setDabgd(String dabgd){
        this.dabgd = dabgd ;
        this.modify("dabgd",dabgd);
    }

    /**
     * 设置 [档案目录]
     */
    public void setDamu(String damu){
        this.damu = damu ;
        this.modify("damu",damu);
    }

    /**
     * 设置 [档案调出单位]
     */
    public void setDadcdw(String dadcdw){
        this.dadcdw = dadcdw ;
        this.modify("dadcdw",dadcdw);
    }

    /**
     * 设置 [档案未转出月数]
     */
    public void setDuration(Integer duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [调入档案]
     */
    public void setDrda(String drda){
        this.drda = drda ;
        this.modify("drda",drda);
    }

    /**
     * 设置 [现档案保管单位]
     */
    public void setXdabgdw(String xdabgdw){
        this.xdabgdw = xdabgdw ;
        this.modify("xdabgdw",xdabgdw);
    }

    /**
     * 设置 [档案保管地]
     */
    public void setDabgdd(String dabgdd){
        this.dabgdd = dabgdd ;
        this.modify("dabgdd",dabgdd);
    }

    /**
     * 设置 [调出单位]
     */
    public void setOrmorgname2(String ormorgname2){
        this.ormorgname2 = ormorgname2 ;
        this.modify("ormorgname2",ormorgname2);
    }

    /**
     * 设置 [档案室管理标识]
     */
    public void setArchivescenterid(String archivescenterid){
        this.archivescenterid = archivescenterid ;
        this.modify("archivescenterid",archivescenterid);
    }

    /**
     * 设置 [员工]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [现档案保管单位标识]
     */
    public void setOrmorgid2(String ormorgid2){
        this.ormorgid2 = ormorgid2 ;
        this.modify("ormorgid2",ormorgid2);
    }

    /**
     * 设置 [管理单位]
     */
    public void setOrmorgid3(String ormorgid3){
        this.ormorgid3 = ormorgid3 ;
        this.modify("ormorgid3",ormorgid3);
    }


}


