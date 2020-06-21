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
 * 实体[合同信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMCONTRACT",resultMap = "PimContractResultMap")
public class PimContract extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 劳务派遣公司
     */
    @TableField(value = "sslwpqgs")
    @JSONField(name = "sslwpqgs")
    @JsonProperty("sslwpqgs")
    private String sslwpqgs;
    /**
     * 合同签订年限
     */
    @TableField(exist = false)
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;
    /**
     * 试用到期时间
     */
    @TableField(value = "sydqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sydqsj" , format="yyyy-MM-dd")
    @JsonProperty("sydqsj")
    private Timestamp sydqsj;
    /**
     * 合同信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimcontractid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimcontractid")
    @JsonProperty("pimcontractid")
    private String pimcontractid;
    /**
     * 合同剩余天数
     */
    @TableField(exist = false)
    @JSONField(name = "htsyts")
    @JsonProperty("htsyts")
    private Integer htsyts;
    /**
     * 合同编号
     */
    @TableField(value = "htbh")
    @JSONField(name = "htbh")
    @JsonProperty("htbh")
    private String htbh;
    /**
     * 合同签订单位（组合字段）
     */
    @TableField(exist = false)
    @JSONField(name = "signingunit")
    @JsonProperty("signingunit")
    private String signingunit;
    /**
     * 合同类别
     */
    @TableField(value = "htlx")
    @JSONField(name = "htlx")
    @JsonProperty("htlx")
    private String htlx;
    /**
     * 备注
     */
    @TableField(value = "demo")
    @JSONField(name = "demo")
    @JsonProperty("demo")
    private String demo;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 工作内容
     */
    @TableField(value = "jobcontent")
    @JSONField(name = "jobcontent")
    @JsonProperty("jobcontent")
    private String jobcontent;
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
     * 合同签订单位
     */
    @TableField(value = "legalorg")
    @JSONField(name = "legalorg")
    @JsonProperty("legalorg")
    private String legalorg;
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
     * 合同信息名称
     */
    @TableField(value = "pimcontractname")
    @JSONField(name = "pimcontractname")
    @JsonProperty("pimcontractname")
    private String pimcontractname;
    /**
     * 结束日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 合同类型
     */
    @TableField(value = "contracttype")
    @JSONField(name = "contracttype")
    @JsonProperty("contracttype")
    private String contracttype;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 员工+编号
     */
    @TableField(exist = false)
    @JSONField(name = "employeeandno")
    @JsonProperty("employeeandno")
    private String employeeandno;
    /**
     * 合同状态
     */
    @TableField(value = "htzt")
    @JSONField(name = "htzt")
    @JsonProperty("htzt")
    private String htzt;
    /**
     * 操作
     */
    @TableField(value = "action")
    @JSONField(name = "action")
    @JsonProperty("action")
    private String action;
    /**
     * 合同剩余天数颜色
     */
    @TableField(exist = false)
    @JSONField(name = "htsyts_color")
    @JsonProperty("htsyts_color")
    private Integer htsytsColor;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 起始日期
     */
    @TableField(value = "qsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 是否初签
     */
    @TableField(value = "isfirstsign")
    @JSONField(name = "isfirstsign")
    @JsonProperty("isfirstsign")
    private Integer isfirstsign;
    /**
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 第几次签订
     */
    @TableField(value = "contractnum")
    @JSONField(name = "contractnum")
    @JsonProperty("contractnum")
    private Integer contractnum;
    /**
     * 操作
     */
    @TableField(value = "cz")
    @JSONField(name = "cz")
    @JsonProperty("cz")
    private String cz;
    /**
     * Y类员工
     */
    @TableField(value = "isyemp")
    @JSONField(name = "isyemp")
    @JsonProperty("isyemp")
    private String isyemp;
    /**
     * 合同管理单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 在岗标识
     */
    @TableField(exist = false)
    @JSONField(name = "zgcode")
    @JsonProperty("zgcode")
    private String zgcode;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 合同签订单位
     */
    @TableField(exist = false)
    @JSONField(name = "ormsignorgname")
    @JsonProperty("ormsignorgname")
    private String ormsignorgname;
    /**
     * 合同签订单位
     */
    @TableField(exist = false)
    @JSONField(name = "contractsignorgname")
    @JsonProperty("contractsignorgname")
    private String contractsignorgname;
    /**
     * 组织编码
     */
    @TableField(exist = false)
    @JSONField(name = "levelcode")
    @JsonProperty("levelcode")
    private String levelcode;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 人员所属单位标识
     */
    @TableField(exist = false)
    @JSONField(name = "personorgid")
    @JsonProperty("personorgid")
    private String personorgid;
    /**
     * 员工所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 劳务派遣公司
     */
    @TableField(exist = false)
    @JSONField(name = "pimlabourcampanyname")
    @JsonProperty("pimlabourcampanyname")
    private String pimlabourcampanyname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 合同管理单位
     */
    @TableField(exist = false)
    @JSONField(name = "htzzdzs")
    @JsonProperty("htzzdzs")
    private String htzzdzs;
    /**
     * 员工状态
     */
    @TableField(exist = false)
    @JSONField(name = "ygzt")
    @JsonProperty("ygzt")
    private String ygzt;
    /**
     * 到本单位时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "dbdwsj" , format="yyyy-MM-dd")
    @JsonProperty("dbdwsj")
    private Timestamp dbdwsj;
    /**
     * 人员所属单位
     */
    @TableField(exist = false)
    @JSONField(name = "personorgname")
    @JsonProperty("personorgname")
    private String personorgname;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 劳务派遣公司管理标识
     */
    @TableField(value = "pimlabourcampanyid")
    @JSONField(name = "pimlabourcampanyid")
    @JsonProperty("pimlabourcampanyid")
    private String pimlabourcampanyid;
    /**
     * 签约主体单位标识
     */
    @TableField(value = "contractsignorgid")
    @JSONField(name = "contractsignorgid")
    @JsonProperty("contractsignorgid")
    private String contractsignorgid;
    /**
     * 合同管理单位标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 合同签订单位
     */
    @TableField(value = "ormsignorgid")
    @JSONField(name = "ormsignorgid")
    @JsonProperty("ormsignorgid")
    private String ormsignorgid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg contractsignorg;

    /**
     * 合同管理单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 合同签订单位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg;

    /**
     * 劳务派遣公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimLabourcampany pimlabourcampany;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [劳务派遣公司]
     */
    public void setSslwpqgs(String sslwpqgs){
        this.sslwpqgs = sslwpqgs ;
        this.modify("sslwpqgs",sslwpqgs);
    }

    /**
     * 设置 [试用到期时间]
     */
    public void setSydqsj(Timestamp sydqsj){
        this.sydqsj = sydqsj ;
        this.modify("sydqsj",sydqsj);
    }

    /**
     * 格式化日期 [试用到期时间]
     */
    public String formatSydqsj(){
        if (this.sydqsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sydqsj);
    }
    /**
     * 设置 [合同编号]
     */
    public void setHtbh(String htbh){
        this.htbh = htbh ;
        this.modify("htbh",htbh);
    }

    /**
     * 设置 [合同类别]
     */
    public void setHtlx(String htlx){
        this.htlx = htlx ;
        this.modify("htlx",htlx);
    }

    /**
     * 设置 [备注]
     */
    public void setDemo(String demo){
        this.demo = demo ;
        this.modify("demo",demo);
    }

    /**
     * 设置 [工作内容]
     */
    public void setJobcontent(String jobcontent){
        this.jobcontent = jobcontent ;
        this.modify("jobcontent",jobcontent);
    }

    /**
     * 设置 [合同签订单位]
     */
    public void setLegalorg(String legalorg){
        this.legalorg = legalorg ;
        this.modify("legalorg",legalorg);
    }

    /**
     * 设置 [合同信息名称]
     */
    public void setPimcontractname(String pimcontractname){
        this.pimcontractname = pimcontractname ;
        this.modify("pimcontractname",pimcontractname);
    }

    /**
     * 设置 [结束日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [结束日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [合同类型]
     */
    public void setContracttype(String contracttype){
        this.contracttype = contracttype ;
        this.modify("contracttype",contracttype);
    }

    /**
     * 设置 [合同状态]
     */
    public void setHtzt(String htzt){
        this.htzt = htzt ;
        this.modify("htzt",htzt);
    }

    /**
     * 设置 [操作]
     */
    public void setAction(String action){
        this.action = action ;
        this.modify("action",action);
    }

    /**
     * 设置 [起始日期]
     */
    public void setQsrq(Timestamp qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 格式化日期 [起始日期]
     */
    public String formatQsrq(){
        if (this.qsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qsrq);
    }
    /**
     * 设置 [是否初签]
     */
    public void setIsfirstsign(Integer isfirstsign){
        this.isfirstsign = isfirstsign ;
        this.modify("isfirstsign",isfirstsign);
    }

    /**
     * 设置 [第几次签订]
     */
    public void setContractnum(Integer contractnum){
        this.contractnum = contractnum ;
        this.modify("contractnum",contractnum);
    }

    /**
     * 设置 [操作]
     */
    public void setCz(String cz){
        this.cz = cz ;
        this.modify("cz",cz);
    }

    /**
     * 设置 [Y类员工]
     */
    public void setIsyemp(String isyemp){
        this.isyemp = isyemp ;
        this.modify("isyemp",isyemp);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [劳务派遣公司管理标识]
     */
    public void setPimlabourcampanyid(String pimlabourcampanyid){
        this.pimlabourcampanyid = pimlabourcampanyid ;
        this.modify("pimlabourcampanyid",pimlabourcampanyid);
    }

    /**
     * 设置 [签约主体单位标识]
     */
    public void setContractsignorgid(String contractsignorgid){
        this.contractsignorgid = contractsignorgid ;
        this.modify("contractsignorgid",contractsignorgid);
    }

    /**
     * 设置 [合同管理单位标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [合同签订单位]
     */
    public void setOrmsignorgid(String ormsignorgid){
        this.ormsignorgid = ormsignorgid ;
        this.modify("ormsignorgid",ormsignorgid);
    }


}


