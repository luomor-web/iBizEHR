package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[职级变动明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMBDSQDMX",resultMap = "PcmBdsqdmxResultMap")
public class PcmBdsqdmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任职文书附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 免职
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sfmz")
    @JSONField(name = "sfmz")
    @JsonProperty("sfmz")
    private Integer sfmz;
    /**
     * 挂职开始时间
     */
    @TableField(value = "gzkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzkssj" , format="yyyy-MM-dd")
    @JsonProperty("gzkssj")
    private Timestamp gzkssj;
    /**
     * 离职面谈附件
     */
    @TableField(value = "lzfj")
    @JSONField(name = "lzfj")
    @JsonProperty("lzfj")
    private String lzfj;
    /**
     * 申请单明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmbdsqdmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmbdsqdmxid")
    @JsonProperty("pcmbdsqdmxid")
    private String pcmbdsqdmxid;
    /**
     * 是否审核
     */
    @TableField(value = "finished")
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;
    /**
     * 赔偿金数额（元）
     */
    @TableField(value = "pcje")
    @JSONField(name = "pcje")
    @JsonProperty("pcje")
    private Double pcje;
    /**
     * 离职原因
     */
    @TableField(value = "lzyy")
    @JSONField(name = "lzyy")
    @JsonProperty("lzyy")
    private String lzyy;
    /**
     * 回填结果
     */
    @TableField(value = "wfresult")
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;
    /**
     * 劳动争议类型
     */
    @TableField(value = "ldzytype")
    @JSONField(name = "ldzytype")
    @JsonProperty("ldzytype")
    private String ldzytype;
    /**
     * 离职去向
     */
    @TableField(value = "lzqx")
    @JSONField(name = "lzqx")
    @JsonProperty("lzqx")
    private String lzqx;
    /**
     * 生效日期
     */
    @TableField(value = "sxrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sxrq" , format="yyyy-MM-dd")
    @JsonProperty("sxrq")
    private Timestamp sxrq;
    /**
     * 离职时间
     */
    @TableField(value = "lzsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "lzsj" , format="yyyy-MM-dd")
    @JsonProperty("lzsj")
    private Timestamp lzsj;
    /**
     * 任职文号
     */
    @TableField(value = "rzwh")
    @JSONField(name = "rzwh")
    @JsonProperty("rzwh")
    private String rzwh;
    /**
     * 挂职状态
     */
    @TableField(value = "gzzt")
    @JSONField(name = "gzzt")
    @JsonProperty("gzzt")
    private String gzzt;
    /**
     * 是否加入黑名单
     */
    @TableField(value = "sfjrhmd")
    @JSONField(name = "sfjrhmd")
    @JsonProperty("sfjrhmd")
    private String sfjrhmd;
    /**
     * 审核状态
     */
    @TableField(value = "checkstatus")
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
    /**
     * 是否同时调动
     */
    @DEField(defaultValue = "0")
    @TableField(value = "sftsdd")
    @JSONField(name = "sftsdd")
    @JsonProperty("sftsdd")
    private Integer sftsdd;
    /**
     * 类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 是否支付离职补偿金
     */
    @TableField(value = "sfzflzbcj")
    @JSONField(name = "sfzflzbcj")
    @JsonProperty("sfzflzbcj")
    private Integer sfzflzbcj;
    /**
     * 申请单明细名称
     */
    @TableField(value = "pcmbdsqdmxname")
    @JSONField(name = "pcmbdsqdmxname")
    @JsonProperty("pcmbdsqdmxname")
    private String pcmbdsqdmxname;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 部门ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 是否有劳动争议
     */
    @TableField(value = "sfldzy")
    @JSONField(name = "sfldzy")
    @JsonProperty("sfldzy")
    private Integer sfldzy;
    /**
     * 补偿金数额（元）
     */
    @TableField(value = "bcjse")
    @JSONField(name = "bcjse")
    @JsonProperty("bcjse")
    private Double bcjse;
    /**
     * 新职级
     */
    @TableField(value = "xrank")
    @JSONField(name = "xrank")
    @JsonProperty("xrank")
    private String xrank;
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
     * 挂职结束时间
     */
    @TableField(value = "gzjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "gzjssj" , format="yyyy-MM-dd")
    @JsonProperty("gzjssj")
    private Timestamp gzjssj;
    /**
     * 待岗类型
     */
    @TableField(value = "dglx")
    @JSONField(name = "dglx")
    @JsonProperty("dglx")
    private String dglx;
    /**
     * 退休管理部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname2")
    @JsonProperty("ormorgsectorname2")
    private String ormorgsectorname2;
    /**
     * 证件号码
     */
    @TableField(value = "zjhm")
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 新部门/项目
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 离职面谈人
     */
    @TableField(value = "lzmtr")
    @JSONField(name = "lzmtr")
    @JsonProperty("lzmtr")
    private String lzmtr;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 新岗位
     */
    @TableField(value = "ormpostname")
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 部门/项目
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 组织ID
     */
    @TableField(value = "zzid")
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 原职级
     */
    @TableField(value = "rank")
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 政治面貌
     */
    @TableField(exist = false)
    @JSONField(name = "zzmm")
    @JsonProperty("zzmm")
    private String zzmm;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 部门/项目ID
     */
    @TableField(value = "bmid")
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 新组织
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 原职务
     */
    @TableField(value = "yzw")
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 原岗位
     */
    @DEField(name = "ywg")
    @TableField(value = "ywg")
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 新职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid2")
    @JSONField(name = "ormorgsectorid2")
    @JsonProperty("ormorgsectorid2")
    private String ormorgsectorid2;
    /**
     * 职务标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 变动申请单标识
     */
    @TableField(value = "pcmbdsqdid")
    @JSONField(name = "pcmbdsqdid")
    @JsonProperty("pcmbdsqdid")
    private String pcmbdsqdid;
    /**
     * 人员信息标识
     */
    @TableField(value = "lzmtrid")
    @JSONField(name = "lzmtrid")
    @JsonProperty("lzmtrid")
    private String lzmtrid;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 挂职组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 岗位管理标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 新部门/项目ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 新职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 新部门/项目
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector2;

    /**
     * 新组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 新岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 申请单
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmBdsqd pcmbdsqd;

    /**
     * 离职面谈人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimpersonLzmtr;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [任职文书附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [免职]
     */
    public void setSfmz(Integer sfmz){
        this.sfmz = sfmz ;
        this.modify("sfmz",sfmz);
    }

    /**
     * 设置 [挂职开始时间]
     */
    public void setGzkssj(Timestamp gzkssj){
        this.gzkssj = gzkssj ;
        this.modify("gzkssj",gzkssj);
    }

    /**
     * 格式化日期 [挂职开始时间]
     */
    public String formatGzkssj(){
        if (this.gzkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(gzkssj);
    }
    /**
     * 设置 [离职面谈附件]
     */
    public void setLzfj(String lzfj){
        this.lzfj = lzfj ;
        this.modify("lzfj",lzfj);
    }

    /**
     * 设置 [是否审核]
     */
    public void setFinished(Integer finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [赔偿金数额（元）]
     */
    public void setPcje(Double pcje){
        this.pcje = pcje ;
        this.modify("pcje",pcje);
    }

    /**
     * 设置 [离职原因]
     */
    public void setLzyy(String lzyy){
        this.lzyy = lzyy ;
        this.modify("lzyy",lzyy);
    }

    /**
     * 设置 [回填结果]
     */
    public void setWfresult(String wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }

    /**
     * 设置 [劳动争议类型]
     */
    public void setLdzytype(String ldzytype){
        this.ldzytype = ldzytype ;
        this.modify("ldzytype",ldzytype);
    }

    /**
     * 设置 [离职去向]
     */
    public void setLzqx(String lzqx){
        this.lzqx = lzqx ;
        this.modify("lzqx",lzqx);
    }

    /**
     * 设置 [生效日期]
     */
    public void setSxrq(Timestamp sxrq){
        this.sxrq = sxrq ;
        this.modify("sxrq",sxrq);
    }

    /**
     * 格式化日期 [生效日期]
     */
    public String formatSxrq(){
        if (this.sxrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sxrq);
    }
    /**
     * 设置 [离职时间]
     */
    public void setLzsj(Timestamp lzsj){
        this.lzsj = lzsj ;
        this.modify("lzsj",lzsj);
    }

    /**
     * 格式化日期 [离职时间]
     */
    public String formatLzsj(){
        if (this.lzsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(lzsj);
    }
    /**
     * 设置 [任职文号]
     */
    public void setRzwh(String rzwh){
        this.rzwh = rzwh ;
        this.modify("rzwh",rzwh);
    }

    /**
     * 设置 [挂职状态]
     */
    public void setGzzt(String gzzt){
        this.gzzt = gzzt ;
        this.modify("gzzt",gzzt);
    }

    /**
     * 设置 [是否加入黑名单]
     */
    public void setSfjrhmd(String sfjrhmd){
        this.sfjrhmd = sfjrhmd ;
        this.modify("sfjrhmd",sfjrhmd);
    }

    /**
     * 设置 [审核状态]
     */
    public void setCheckstatus(String checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [是否同时调动]
     */
    public void setSftsdd(Integer sftsdd){
        this.sftsdd = sftsdd ;
        this.modify("sftsdd",sftsdd);
    }

    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [是否支付离职补偿金]
     */
    public void setSfzflzbcj(Integer sfzflzbcj){
        this.sfzflzbcj = sfzflzbcj ;
        this.modify("sfzflzbcj",sfzflzbcj);
    }

    /**
     * 设置 [申请单明细名称]
     */
    public void setPcmbdsqdmxname(String pcmbdsqdmxname){
        this.pcmbdsqdmxname = pcmbdsqdmxname ;
        this.modify("pcmbdsqdmxname",pcmbdsqdmxname);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [是否有劳动争议]
     */
    public void setSfldzy(Integer sfldzy){
        this.sfldzy = sfldzy ;
        this.modify("sfldzy",sfldzy);
    }

    /**
     * 设置 [补偿金数额（元）]
     */
    public void setBcjse(Double bcjse){
        this.bcjse = bcjse ;
        this.modify("bcjse",bcjse);
    }

    /**
     * 设置 [新职级]
     */
    public void setXrank(String xrank){
        this.xrank = xrank ;
        this.modify("xrank",xrank);
    }

    /**
     * 设置 [挂职结束时间]
     */
    public void setGzjssj(Timestamp gzjssj){
        this.gzjssj = gzjssj ;
        this.modify("gzjssj",gzjssj);
    }

    /**
     * 格式化日期 [挂职结束时间]
     */
    public String formatGzjssj(){
        if (this.gzjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(gzjssj);
    }
    /**
     * 设置 [待岗类型]
     */
    public void setDglx(String dglx){
        this.dglx = dglx ;
        this.modify("dglx",dglx);
    }

    /**
     * 设置 [证件号码]
     */
    public void setZjhm(String zjhm){
        this.zjhm = zjhm ;
        this.modify("zjhm",zjhm);
    }

    /**
     * 设置 [新部门/项目]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [离职面谈人]
     */
    public void setLzmtr(String lzmtr){
        this.lzmtr = lzmtr ;
        this.modify("lzmtr",lzmtr);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [新岗位]
     */
    public void setOrmpostname(String ormpostname){
        this.ormpostname = ormpostname ;
        this.modify("ormpostname",ormpostname);
    }

    /**
     * 设置 [部门/项目]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [组织ID]
     */
    public void setZzid(String zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [原职级]
     */
    public void setRank(String rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [部门/项目ID]
     */
    public void setBmid(String bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [新组织]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [原职务]
     */
    public void setYzw(String yzw){
        this.yzw = yzw ;
        this.modify("yzw",yzw);
    }

    /**
     * 设置 [原岗位]
     */
    public void setYgw(String ygw){
        this.ygw = ygw ;
        this.modify("ywg",ygw);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid2(String ormorgsectorid2){
        this.ormorgsectorid2 = ormorgsectorid2 ;
        this.modify("ormorgsectorid2",ormorgsectorid2);
    }

    /**
     * 设置 [职务标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [变动申请单标识]
     */
    public void setPcmbdsqdid(String pcmbdsqdid){
        this.pcmbdsqdid = pcmbdsqdid ;
        this.modify("pcmbdsqdid",pcmbdsqdid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setLzmtrid(String lzmtrid){
        this.lzmtrid = lzmtrid ;
        this.modify("lzmtrid",lzmtrid);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [挂职组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [岗位管理标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [新部门/项目ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


