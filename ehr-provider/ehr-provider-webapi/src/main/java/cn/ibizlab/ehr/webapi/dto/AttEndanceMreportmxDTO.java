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
 * 服务DTO对象[AttEndanceMreportmxDTO]
 */
@Data
public class AttEndanceMreportmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DAY14]
     *
     */
    @JSONField(name = "day14")
    @JsonProperty("day14")
    private String day14;

    /**
     * 属性 [DAY10]
     *
     */
    @JSONField(name = "day10")
    @JsonProperty("day10")
    private String day10;

    /**
     * 属性 [DAY8]
     *
     */
    @JSONField(name = "day8")
    @JsonProperty("day8")
    private String day8;

    /**
     * 属性 [DAY2]
     *
     */
    @JSONField(name = "day2")
    @JsonProperty("day2")
    private String day2;

    /**
     * 属性 [YF]
     *
     */
    @JSONField(name = "yf")
    @JsonProperty("yf")
    private String yf;

    /**
     * 属性 [DAY30]
     *
     */
    @JSONField(name = "day30")
    @JsonProperty("day30")
    private String day30;

    /**
     * 属性 [DAY27]
     *
     */
    @JSONField(name = "day27")
    @JsonProperty("day27")
    private String day27;

    /**
     * 属性 [DAY1]
     *
     */
    @JSONField(name = "day1")
    @JsonProperty("day1")
    private String day1;

    /**
     * 属性 [DAY7]
     *
     */
    @JSONField(name = "day7")
    @JsonProperty("day7")
    private String day7;

    /**
     * 属性 [DAY24]
     *
     */
    @JSONField(name = "day24")
    @JsonProperty("day24")
    private String day24;

    /**
     * 属性 [DAY13]
     *
     */
    @JSONField(name = "day13")
    @JsonProperty("day13")
    private String day13;

    /**
     * 属性 [DAY3]
     *
     */
    @JSONField(name = "day3")
    @JsonProperty("day3")
    private String day3;

    /**
     * 属性 [ATTENDANCEMREPORTMXNAME]
     *
     */
    @JSONField(name = "attendancemreportname")
    @JsonProperty("attendancemreportname")
    private String attendancemreportname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORMROGNAME]
     *
     */
    @JSONField(name = "ormrogname")
    @JsonProperty("ormrogname")
    private String ormrogname;

    /**
     * 属性 [DAY11]
     *
     */
    @JSONField(name = "day11")
    @JsonProperty("day11")
    private String day11;

    /**
     * 属性 [DAY29]
     *
     */
    @JSONField(name = "day29")
    @JsonProperty("day29")
    private String day29;

    /**
     * 属性 [DAY4]
     *
     */
    @JSONField(name = "day4")
    @JsonProperty("day4")
    private String day4;

    /**
     * 属性 [DAY17]
     *
     */
    @JSONField(name = "day17")
    @JsonProperty("day17")
    private String day17;

    /**
     * 属性 [DAY16]
     *
     */
    @JSONField(name = "day16")
    @JsonProperty("day16")
    private String day16;

    /**
     * 属性 [ORMROGSECTORID]
     *
     */
    @JSONField(name = "ormrogsectorid")
    @JsonProperty("ormrogsectorid")
    private String ormrogsectorid;

    /**
     * 属性 [DAY5]
     *
     */
    @JSONField(name = "day5")
    @JsonProperty("day5")
    private String day5;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 属性 [ATTENDANCEMREPORTMXID]
     *
     */
    @JSONField(name = "attendancemreportmxid")
    @JsonProperty("attendancemreportmxid")
    private String attendancemreportmxid;

    /**
     * 属性 [DAY28]
     *
     */
    @JSONField(name = "day28")
    @JsonProperty("day28")
    private String day28;

    /**
     * 属性 [DAY31]
     *
     */
    @JSONField(name = "day31")
    @JsonProperty("day31")
    private String day31;

    /**
     * 属性 [ORMROGSECTORNAME]
     *
     */
    @JSONField(name = "ormrogsectorname")
    @JsonProperty("ormrogsectorname")
    private String ormrogsectorname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DAY23]
     *
     */
    @JSONField(name = "day23")
    @JsonProperty("day23")
    private String day23;

    /**
     * 属性 [DAY21]
     *
     */
    @JSONField(name = "day21")
    @JsonProperty("day21")
    private String day21;

    /**
     * 属性 [DAY9]
     *
     */
    @JSONField(name = "day9")
    @JsonProperty("day9")
    private String day9;

    /**
     * 属性 [DAY20]
     *
     */
    @JSONField(name = "day20")
    @JsonProperty("day20")
    private String day20;

    /**
     * 属性 [DAY22]
     *
     */
    @JSONField(name = "day22")
    @JsonProperty("day22")
    private String day22;

    /**
     * 属性 [ORMROGID]
     *
     */
    @JSONField(name = "ormrogid")
    @JsonProperty("ormrogid")
    private String ormrogid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [DAY26]
     *
     */
    @JSONField(name = "day26")
    @JsonProperty("day26")
    private String day26;

    /**
     * 属性 [KQHZ]
     *
     */
    @JSONField(name = "kqhz")
    @JsonProperty("kqhz")
    private String kqhz;

    /**
     * 属性 [DAY6]
     *
     */
    @JSONField(name = "day6")
    @JsonProperty("day6")
    private String day6;

    /**
     * 属性 [DAY25]
     *
     */
    @JSONField(name = "day25")
    @JsonProperty("day25")
    private String day25;

    /**
     * 属性 [DAY18]
     *
     */
    @JSONField(name = "day18")
    @JsonProperty("day18")
    private String day18;

    /**
     * 属性 [DAY19]
     *
     */
    @JSONField(name = "day19")
    @JsonProperty("day19")
    private String day19;

    /**
     * 属性 [DAY12]
     *
     */
    @JSONField(name = "day12")
    @JsonProperty("day12")
    private String day12;

    /**
     * 属性 [DAY15]
     *
     */
    @JSONField(name = "day15")
    @JsonProperty("day15")
    private String day15;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [ATTENDENCESETUPID]
     *
     */
    @JSONField(name = "attendencesetupid")
    @JsonProperty("attendencesetupid")
    private String attendencesetupid;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [ATTENDANCEMREPORTID2]
     *
     */
    @JSONField(name = "attendancemreportid2")
    @JsonProperty("attendancemreportid2")
    private String attendancemreportid2;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [DAY14]
     */
    public void setDay14(String  day14){
        this.day14 = day14 ;
        this.modify("day14",day14);
    }

    /**
     * 设置 [DAY10]
     */
    public void setDay10(String  day10){
        this.day10 = day10 ;
        this.modify("day10",day10);
    }

    /**
     * 设置 [DAY8]
     */
    public void setDay8(String  day8){
        this.day8 = day8 ;
        this.modify("day8",day8);
    }

    /**
     * 设置 [DAY2]
     */
    public void setDay2(String  day2){
        this.day2 = day2 ;
        this.modify("day2",day2);
    }

    /**
     * 设置 [YF]
     */
    public void setYf(String  yf){
        this.yf = yf ;
        this.modify("yf",yf);
    }

    /**
     * 设置 [DAY30]
     */
    public void setDay30(String  day30){
        this.day30 = day30 ;
        this.modify("day30",day30);
    }

    /**
     * 设置 [DAY27]
     */
    public void setDay27(String  day27){
        this.day27 = day27 ;
        this.modify("day27",day27);
    }

    /**
     * 设置 [DAY1]
     */
    public void setDay1(String  day1){
        this.day1 = day1 ;
        this.modify("day1",day1);
    }

    /**
     * 设置 [DAY7]
     */
    public void setDay7(String  day7){
        this.day7 = day7 ;
        this.modify("day7",day7);
    }

    /**
     * 设置 [DAY24]
     */
    public void setDay24(String  day24){
        this.day24 = day24 ;
        this.modify("day24",day24);
    }

    /**
     * 设置 [DAY13]
     */
    public void setDay13(String  day13){
        this.day13 = day13 ;
        this.modify("day13",day13);
    }

    /**
     * 设置 [DAY3]
     */
    public void setDay3(String  day3){
        this.day3 = day3 ;
        this.modify("day3",day3);
    }

    /**
     * 设置 [ATTENDANCEMREPORTMXNAME]
     */
    public void setAttendancemreportname(String  attendancemreportname){
        this.attendancemreportname = attendancemreportname ;
        this.modify("attendancemreportmxname",attendancemreportname);
    }

    /**
     * 设置 [ORMROGNAME]
     */
    public void setOrmrogname(String  ormrogname){
        this.ormrogname = ormrogname ;
        this.modify("ormrogname",ormrogname);
    }

    /**
     * 设置 [DAY11]
     */
    public void setDay11(String  day11){
        this.day11 = day11 ;
        this.modify("day11",day11);
    }

    /**
     * 设置 [DAY29]
     */
    public void setDay29(String  day29){
        this.day29 = day29 ;
        this.modify("day29",day29);
    }

    /**
     * 设置 [DAY4]
     */
    public void setDay4(String  day4){
        this.day4 = day4 ;
        this.modify("day4",day4);
    }

    /**
     * 设置 [DAY17]
     */
    public void setDay17(String  day17){
        this.day17 = day17 ;
        this.modify("day17",day17);
    }

    /**
     * 设置 [DAY16]
     */
    public void setDay16(String  day16){
        this.day16 = day16 ;
        this.modify("day16",day16);
    }

    /**
     * 设置 [ORMROGSECTORID]
     */
    public void setOrmrogsectorid(String  ormrogsectorid){
        this.ormrogsectorid = ormrogsectorid ;
        this.modify("ormrogsectorid",ormrogsectorid);
    }

    /**
     * 设置 [DAY5]
     */
    public void setDay5(String  day5){
        this.day5 = day5 ;
        this.modify("day5",day5);
    }

    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [DAY28]
     */
    public void setDay28(String  day28){
        this.day28 = day28 ;
        this.modify("day28",day28);
    }

    /**
     * 设置 [DAY31]
     */
    public void setDay31(String  day31){
        this.day31 = day31 ;
        this.modify("day31",day31);
    }

    /**
     * 设置 [ORMROGSECTORNAME]
     */
    public void setOrmrogsectorname(String  ormrogsectorname){
        this.ormrogsectorname = ormrogsectorname ;
        this.modify("ormrogsectorname",ormrogsectorname);
    }

    /**
     * 设置 [DAY23]
     */
    public void setDay23(String  day23){
        this.day23 = day23 ;
        this.modify("day23",day23);
    }

    /**
     * 设置 [DAY21]
     */
    public void setDay21(String  day21){
        this.day21 = day21 ;
        this.modify("day21",day21);
    }

    /**
     * 设置 [DAY9]
     */
    public void setDay9(String  day9){
        this.day9 = day9 ;
        this.modify("day9",day9);
    }

    /**
     * 设置 [DAY20]
     */
    public void setDay20(String  day20){
        this.day20 = day20 ;
        this.modify("day20",day20);
    }

    /**
     * 设置 [DAY22]
     */
    public void setDay22(String  day22){
        this.day22 = day22 ;
        this.modify("day22",day22);
    }

    /**
     * 设置 [ORMROGID]
     */
    public void setOrmrogid(String  ormrogid){
        this.ormrogid = ormrogid ;
        this.modify("ormrogid",ormrogid);
    }

    /**
     * 设置 [DAY26]
     */
    public void setDay26(String  day26){
        this.day26 = day26 ;
        this.modify("day26",day26);
    }

    /**
     * 设置 [KQHZ]
     */
    public void setKqhz(String  kqhz){
        this.kqhz = kqhz ;
        this.modify("kqhz",kqhz);
    }

    /**
     * 设置 [DAY6]
     */
    public void setDay6(String  day6){
        this.day6 = day6 ;
        this.modify("day6",day6);
    }

    /**
     * 设置 [DAY25]
     */
    public void setDay25(String  day25){
        this.day25 = day25 ;
        this.modify("day25",day25);
    }

    /**
     * 设置 [DAY18]
     */
    public void setDay18(String  day18){
        this.day18 = day18 ;
        this.modify("day18",day18);
    }

    /**
     * 设置 [DAY19]
     */
    public void setDay19(String  day19){
        this.day19 = day19 ;
        this.modify("day19",day19);
    }

    /**
     * 设置 [DAY12]
     */
    public void setDay12(String  day12){
        this.day12 = day12 ;
        this.modify("day12",day12);
    }

    /**
     * 设置 [DAY15]
     */
    public void setDay15(String  day15){
        this.day15 = day15 ;
        this.modify("day15",day15);
    }

    /**
     * 设置 [ATTENDENCESETUPID]
     */
    public void setAttendencesetupid(String  attendencesetupid){
        this.attendencesetupid = attendencesetupid ;
        this.modify("attendencesetupid",attendencesetupid);
    }

    /**
     * 设置 [ATTENDANCEMREPORTID2]
     */
    public void setAttendancemreportid2(String  attendancemreportid2){
        this.attendancemreportid2 = attendancemreportid2 ;
        this.modify("attendancemreportid2",attendancemreportid2);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

