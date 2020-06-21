package cn.ibizlab.ehr.core.att.domain;

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
 * 实体[考勤月报明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDANCEMREPORTMX",resultMap = "AttEndanceMreportmxResultMap")
public class AttEndanceMreportmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 14
     */
    @TableField(value = "day14")
    @JSONField(name = "day14")
    @JsonProperty("day14")
    private String day14;
    /**
     * 10
     */
    @TableField(value = "day10")
    @JSONField(name = "day10")
    @JsonProperty("day10")
    private String day10;
    /**
     * 8
     */
    @TableField(value = "day8")
    @JSONField(name = "day8")
    @JsonProperty("day8")
    private String day8;
    /**
     * 2
     */
    @TableField(value = "day2")
    @JSONField(name = "day2")
    @JsonProperty("day2")
    private String day2;
    /**
     * 月份
     */
    @TableField(value = "yf")
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;
    /**
     * 30
     */
    @TableField(value = "day30")
    @JSONField(name = "day30")
    @JsonProperty("day30")
    private String day30;
    /**
     * 27
     */
    @TableField(value = "day27")
    @JSONField(name = "day27")
    @JsonProperty("day27")
    private String day27;
    /**
     * 1
     */
    @TableField(value = "day1")
    @JSONField(name = "day1")
    @JsonProperty("day1")
    private String day1;
    /**
     * 7
     */
    @TableField(value = "day7")
    @JSONField(name = "day7")
    @JsonProperty("day7")
    private String day7;
    /**
     * 24
     */
    @TableField(value = "day24")
    @JSONField(name = "day24")
    @JsonProperty("day24")
    private String day24;
    /**
     * 13
     */
    @TableField(value = "day13")
    @JSONField(name = "day13")
    @JsonProperty("day13")
    private String day13;
    /**
     * 3
     */
    @TableField(value = "day3")
    @JSONField(name = "day3")
    @JsonProperty("day3")
    private String day3;
    /**
     * 考勤月报明细名称
     */
    @DEField(name = "attendancemreportmxname")
    @TableField(value = "attendancemreportmxname")
    @JSONField(name = "attendancemreportname")
    @JsonProperty("attendancemreportname")
    private String attendancemreportname;
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
     * 组织名称
     */
    @TableField(value = "ormrogname")
    @JSONField(name = "ormrogname")
    @JsonProperty("ormrogname")
    private String ormrogname;
    /**
     * 11
     */
    @TableField(value = "day11")
    @JSONField(name = "day11")
    @JsonProperty("day11")
    private String day11;
    /**
     * 29
     */
    @TableField(value = "day29")
    @JSONField(name = "day29")
    @JsonProperty("day29")
    private String day29;
    /**
     * 4
     */
    @TableField(value = "day4")
    @JSONField(name = "day4")
    @JsonProperty("day4")
    private String day4;
    /**
     * 17
     */
    @TableField(value = "day17")
    @JSONField(name = "day17")
    @JsonProperty("day17")
    private String day17;
    /**
     * 16
     */
    @TableField(value = "day16")
    @JSONField(name = "day16")
    @JsonProperty("day16")
    private String day16;
    /**
     * 部门id
     */
    @TableField(value = "ormrogsectorid")
    @JSONField(name = "ormrogsectorid")
    @JsonProperty("ormrogsectorid")
    private String ormrogsectorid;
    /**
     * 5
     */
    @TableField(value = "day5")
    @JSONField(name = "day5")
    @JsonProperty("day5")
    private String day5;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 考勤月报明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendancemreportmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendancemreportmxid")
    @JsonProperty("attendancemreportmxid")
    private String attendancemreportmxid;
    /**
     * 28
     */
    @TableField(value = "day28")
    @JSONField(name = "day28")
    @JsonProperty("day28")
    private String day28;
    /**
     * 31
     */
    @TableField(value = "day31")
    @JSONField(name = "day31")
    @JsonProperty("day31")
    private String day31;
    /**
     * 部门名称
     */
    @TableField(value = "ormrogsectorname")
    @JSONField(name = "ormrogsectorname")
    @JsonProperty("ormrogsectorname")
    private String ormrogsectorname;
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
     * 23
     */
    @TableField(value = "day23")
    @JSONField(name = "day23")
    @JsonProperty("day23")
    private String day23;
    /**
     * 21
     */
    @TableField(value = "day21")
    @JSONField(name = "day21")
    @JsonProperty("day21")
    private String day21;
    /**
     * 9
     */
    @TableField(value = "day9")
    @JSONField(name = "day9")
    @JsonProperty("day9")
    private String day9;
    /**
     * 20
     */
    @TableField(value = "day20")
    @JSONField(name = "day20")
    @JsonProperty("day20")
    private String day20;
    /**
     * 22
     */
    @TableField(value = "day22")
    @JSONField(name = "day22")
    @JsonProperty("day22")
    private String day22;
    /**
     * 组织id
     */
    @TableField(value = "ormrogid")
    @JSONField(name = "ormrogid")
    @JsonProperty("ormrogid")
    private String ormrogid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 26
     */
    @TableField(value = "day26")
    @JSONField(name = "day26")
    @JsonProperty("day26")
    private String day26;
    /**
     * 考勤汇总
     */
    @TableField(value = "kqhz")
    @JSONField(name = "kqhz")
    @JsonProperty("kqhz")
    private String kqhz;
    /**
     * 6
     */
    @TableField(value = "day6")
    @JSONField(name = "day6")
    @JsonProperty("day6")
    private String day6;
    /**
     * 25
     */
    @TableField(value = "day25")
    @JSONField(name = "day25")
    @JsonProperty("day25")
    private String day25;
    /**
     * 18
     */
    @TableField(value = "day18")
    @JSONField(name = "day18")
    @JsonProperty("day18")
    private String day18;
    /**
     * 19
     */
    @TableField(value = "day19")
    @JSONField(name = "day19")
    @JsonProperty("day19")
    private String day19;
    /**
     * 12
     */
    @TableField(value = "day12")
    @JSONField(name = "day12")
    @JsonProperty("day12")
    private String day12;
    /**
     * 15
     */
    @TableField(value = "day15")
    @JSONField(name = "day15")
    @JsonProperty("day15")
    private String day15;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 考勤设置标识
     */
    @TableField(value = "attendencesetupid")
    @JSONField(name = "attendencesetupid")
    @JsonProperty("attendencesetupid")
    private String attendencesetupid;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 考勤月报标识
     */
    @TableField(value = "attendancemreportid2")
    @JSONField(name = "attendancemreportid2")
    @JsonProperty("attendancemreportid2")
    private String attendancemreportid2;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 考勤月报-考勤月报明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.att.domain.AttEndanceMreport attendancemreport2;

    /**
     * 人员信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [14]
     */
    public void setDay14(String day14){
        this.day14 = day14 ;
        this.modify("day14",day14);
    }

    /**
     * 设置 [10]
     */
    public void setDay10(String day10){
        this.day10 = day10 ;
        this.modify("day10",day10);
    }

    /**
     * 设置 [8]
     */
    public void setDay8(String day8){
        this.day8 = day8 ;
        this.modify("day8",day8);
    }

    /**
     * 设置 [2]
     */
    public void setDay2(String day2){
        this.day2 = day2 ;
        this.modify("day2",day2);
    }

    /**
     * 设置 [月份]
     */
    public void setYf(String yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [30]
     */
    public void setDay30(String day30){
        this.day30 = day30 ;
        this.modify("day30",day30);
    }

    /**
     * 设置 [27]
     */
    public void setDay27(String day27){
        this.day27 = day27 ;
        this.modify("day27",day27);
    }

    /**
     * 设置 [1]
     */
    public void setDay1(String day1){
        this.day1 = day1 ;
        this.modify("day1",day1);
    }

    /**
     * 设置 [7]
     */
    public void setDay7(String day7){
        this.day7 = day7 ;
        this.modify("day7",day7);
    }

    /**
     * 设置 [24]
     */
    public void setDay24(String day24){
        this.day24 = day24 ;
        this.modify("day24",day24);
    }

    /**
     * 设置 [13]
     */
    public void setDay13(String day13){
        this.day13 = day13 ;
        this.modify("day13",day13);
    }

    /**
     * 设置 [3]
     */
    public void setDay3(String day3){
        this.day3 = day3 ;
        this.modify("day3",day3);
    }

    /**
     * 设置 [考勤月报明细名称]
     */
    public void setAttendancemreportname(String attendancemreportname){
        this.attendancemreportname = attendancemreportname ;
        this.modify("attendancemreportmxname",attendancemreportname);
    }

    /**
     * 设置 [组织名称]
     */
    public void setOrmrogname(String ormrogname){
        this.ormrogname = ormrogname ;
        this.modify("ormrogname",ormrogname);
    }

    /**
     * 设置 [11]
     */
    public void setDay11(String day11){
        this.day11 = day11 ;
        this.modify("day11",day11);
    }

    /**
     * 设置 [29]
     */
    public void setDay29(String day29){
        this.day29 = day29 ;
        this.modify("day29",day29);
    }

    /**
     * 设置 [4]
     */
    public void setDay4(String day4){
        this.day4 = day4 ;
        this.modify("day4",day4);
    }

    /**
     * 设置 [17]
     */
    public void setDay17(String day17){
        this.day17 = day17 ;
        this.modify("day17",day17);
    }

    /**
     * 设置 [16]
     */
    public void setDay16(String day16){
        this.day16 = day16 ;
        this.modify("day16",day16);
    }

    /**
     * 设置 [部门id]
     */
    public void setOrmrogsectorid(String ormrogsectorid){
        this.ormrogsectorid = ormrogsectorid ;
        this.modify("ormrogsectorid",ormrogsectorid);
    }

    /**
     * 设置 [5]
     */
    public void setDay5(String day5){
        this.day5 = day5 ;
        this.modify("day5",day5);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [28]
     */
    public void setDay28(String day28){
        this.day28 = day28 ;
        this.modify("day28",day28);
    }

    /**
     * 设置 [31]
     */
    public void setDay31(String day31){
        this.day31 = day31 ;
        this.modify("day31",day31);
    }

    /**
     * 设置 [部门名称]
     */
    public void setOrmrogsectorname(String ormrogsectorname){
        this.ormrogsectorname = ormrogsectorname ;
        this.modify("ormrogsectorname",ormrogsectorname);
    }

    /**
     * 设置 [23]
     */
    public void setDay23(String day23){
        this.day23 = day23 ;
        this.modify("day23",day23);
    }

    /**
     * 设置 [21]
     */
    public void setDay21(String day21){
        this.day21 = day21 ;
        this.modify("day21",day21);
    }

    /**
     * 设置 [9]
     */
    public void setDay9(String day9){
        this.day9 = day9 ;
        this.modify("day9",day9);
    }

    /**
     * 设置 [20]
     */
    public void setDay20(String day20){
        this.day20 = day20 ;
        this.modify("day20",day20);
    }

    /**
     * 设置 [22]
     */
    public void setDay22(String day22){
        this.day22 = day22 ;
        this.modify("day22",day22);
    }

    /**
     * 设置 [组织id]
     */
    public void setOrmrogid(String ormrogid){
        this.ormrogid = ormrogid ;
        this.modify("ormrogid",ormrogid);
    }

    /**
     * 设置 [26]
     */
    public void setDay26(String day26){
        this.day26 = day26 ;
        this.modify("day26",day26);
    }

    /**
     * 设置 [考勤汇总]
     */
    public void setKqhz(String kqhz){
        this.kqhz = kqhz ;
        this.modify("kqhz",kqhz);
    }

    /**
     * 设置 [6]
     */
    public void setDay6(String day6){
        this.day6 = day6 ;
        this.modify("day6",day6);
    }

    /**
     * 设置 [25]
     */
    public void setDay25(String day25){
        this.day25 = day25 ;
        this.modify("day25",day25);
    }

    /**
     * 设置 [18]
     */
    public void setDay18(String day18){
        this.day18 = day18 ;
        this.modify("day18",day18);
    }

    /**
     * 设置 [19]
     */
    public void setDay19(String day19){
        this.day19 = day19 ;
        this.modify("day19",day19);
    }

    /**
     * 设置 [12]
     */
    public void setDay12(String day12){
        this.day12 = day12 ;
        this.modify("day12",day12);
    }

    /**
     * 设置 [15]
     */
    public void setDay15(String day15){
        this.day15 = day15 ;
        this.modify("day15",day15);
    }

    /**
     * 设置 [考勤设置标识]
     */
    public void setAttendencesetupid(String attendencesetupid){
        this.attendencesetupid = attendencesetupid ;
        this.modify("attendencesetupid",attendencesetupid);
    }

    /**
     * 设置 [考勤月报标识]
     */
    public void setAttendancemreportid2(String attendancemreportid2){
        this.attendancemreportid2 = attendancemreportid2 ;
        this.modify("attendancemreportid2",attendancemreportid2);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


