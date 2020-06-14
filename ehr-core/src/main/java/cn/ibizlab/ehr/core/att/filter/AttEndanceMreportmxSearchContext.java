package cn.ibizlab.ehr.core.att.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
/**
 * 关系型数据实体[AttEndanceMreportmx] 查询条件对象
 */
@Slf4j
@Data
public class AttEndanceMreportmxSearchContext extends QueryWrapperContext<AttEndanceMreportmx> {

	private String n_day14_eq;//[14]
	public void setN_day14_eq(String n_day14_eq) {
        this.n_day14_eq = n_day14_eq;
        if(!ObjectUtils.isEmpty(this.n_day14_eq)){
            this.getSearchCond().eq("day14", n_day14_eq);
        }
    }
	private String n_day10_eq;//[10]
	public void setN_day10_eq(String n_day10_eq) {
        this.n_day10_eq = n_day10_eq;
        if(!ObjectUtils.isEmpty(this.n_day10_eq)){
            this.getSearchCond().eq("day10", n_day10_eq);
        }
    }
	private String n_day8_eq;//[8]
	public void setN_day8_eq(String n_day8_eq) {
        this.n_day8_eq = n_day8_eq;
        if(!ObjectUtils.isEmpty(this.n_day8_eq)){
            this.getSearchCond().eq("day8", n_day8_eq);
        }
    }
	private String n_day2_eq;//[2]
	public void setN_day2_eq(String n_day2_eq) {
        this.n_day2_eq = n_day2_eq;
        if(!ObjectUtils.isEmpty(this.n_day2_eq)){
            this.getSearchCond().eq("day2", n_day2_eq);
        }
    }
	private String n_yf_eq;//[月份]
	public void setN_yf_eq(String n_yf_eq) {
        this.n_yf_eq = n_yf_eq;
        if(!ObjectUtils.isEmpty(this.n_yf_eq)){
            this.getSearchCond().eq("yf", n_yf_eq);
        }
    }
	private String n_day30_eq;//[30]
	public void setN_day30_eq(String n_day30_eq) {
        this.n_day30_eq = n_day30_eq;
        if(!ObjectUtils.isEmpty(this.n_day30_eq)){
            this.getSearchCond().eq("day30", n_day30_eq);
        }
    }
	private String n_day27_eq;//[27]
	public void setN_day27_eq(String n_day27_eq) {
        this.n_day27_eq = n_day27_eq;
        if(!ObjectUtils.isEmpty(this.n_day27_eq)){
            this.getSearchCond().eq("day27", n_day27_eq);
        }
    }
	private String n_day1_eq;//[1]
	public void setN_day1_eq(String n_day1_eq) {
        this.n_day1_eq = n_day1_eq;
        if(!ObjectUtils.isEmpty(this.n_day1_eq)){
            this.getSearchCond().eq("day1", n_day1_eq);
        }
    }
	private String n_day7_eq;//[7]
	public void setN_day7_eq(String n_day7_eq) {
        this.n_day7_eq = n_day7_eq;
        if(!ObjectUtils.isEmpty(this.n_day7_eq)){
            this.getSearchCond().eq("day7", n_day7_eq);
        }
    }
	private String n_day24_eq;//[24]
	public void setN_day24_eq(String n_day24_eq) {
        this.n_day24_eq = n_day24_eq;
        if(!ObjectUtils.isEmpty(this.n_day24_eq)){
            this.getSearchCond().eq("day24", n_day24_eq);
        }
    }
	private String n_day13_eq;//[13]
	public void setN_day13_eq(String n_day13_eq) {
        this.n_day13_eq = n_day13_eq;
        if(!ObjectUtils.isEmpty(this.n_day13_eq)){
            this.getSearchCond().eq("day13", n_day13_eq);
        }
    }
	private String n_day3_eq;//[3]
	public void setN_day3_eq(String n_day3_eq) {
        this.n_day3_eq = n_day3_eq;
        if(!ObjectUtils.isEmpty(this.n_day3_eq)){
            this.getSearchCond().eq("day3", n_day3_eq);
        }
    }
	private String n_attendancemreportmxname_like;//[考勤月报明细名称]
	public void setN_attendancemreportmxname_like(String n_attendancemreportmxname_like) {
        this.n_attendancemreportmxname_like = n_attendancemreportmxname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportmxname_like)){
            this.getSearchCond().like("attendancemreportmxname", n_attendancemreportmxname_like);
        }
    }
	private String n_day11_eq;//[11]
	public void setN_day11_eq(String n_day11_eq) {
        this.n_day11_eq = n_day11_eq;
        if(!ObjectUtils.isEmpty(this.n_day11_eq)){
            this.getSearchCond().eq("day11", n_day11_eq);
        }
    }
	private String n_day29_eq;//[29]
	public void setN_day29_eq(String n_day29_eq) {
        this.n_day29_eq = n_day29_eq;
        if(!ObjectUtils.isEmpty(this.n_day29_eq)){
            this.getSearchCond().eq("day29", n_day29_eq);
        }
    }
	private String n_day4_eq;//[4]
	public void setN_day4_eq(String n_day4_eq) {
        this.n_day4_eq = n_day4_eq;
        if(!ObjectUtils.isEmpty(this.n_day4_eq)){
            this.getSearchCond().eq("day4", n_day4_eq);
        }
    }
	private String n_day17_eq;//[17]
	public void setN_day17_eq(String n_day17_eq) {
        this.n_day17_eq = n_day17_eq;
        if(!ObjectUtils.isEmpty(this.n_day17_eq)){
            this.getSearchCond().eq("day17", n_day17_eq);
        }
    }
	private String n_day16_eq;//[16]
	public void setN_day16_eq(String n_day16_eq) {
        this.n_day16_eq = n_day16_eq;
        if(!ObjectUtils.isEmpty(this.n_day16_eq)){
            this.getSearchCond().eq("day16", n_day16_eq);
        }
    }
	private String n_day5_eq;//[5]
	public void setN_day5_eq(String n_day5_eq) {
        this.n_day5_eq = n_day5_eq;
        if(!ObjectUtils.isEmpty(this.n_day5_eq)){
            this.getSearchCond().eq("day5", n_day5_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_day28_eq;//[28]
	public void setN_day28_eq(String n_day28_eq) {
        this.n_day28_eq = n_day28_eq;
        if(!ObjectUtils.isEmpty(this.n_day28_eq)){
            this.getSearchCond().eq("day28", n_day28_eq);
        }
    }
	private String n_day31_eq;//[31]
	public void setN_day31_eq(String n_day31_eq) {
        this.n_day31_eq = n_day31_eq;
        if(!ObjectUtils.isEmpty(this.n_day31_eq)){
            this.getSearchCond().eq("day31", n_day31_eq);
        }
    }
	private String n_day23_eq;//[23]
	public void setN_day23_eq(String n_day23_eq) {
        this.n_day23_eq = n_day23_eq;
        if(!ObjectUtils.isEmpty(this.n_day23_eq)){
            this.getSearchCond().eq("day23", n_day23_eq);
        }
    }
	private String n_day21_eq;//[21]
	public void setN_day21_eq(String n_day21_eq) {
        this.n_day21_eq = n_day21_eq;
        if(!ObjectUtils.isEmpty(this.n_day21_eq)){
            this.getSearchCond().eq("day21", n_day21_eq);
        }
    }
	private String n_day9_eq;//[9]
	public void setN_day9_eq(String n_day9_eq) {
        this.n_day9_eq = n_day9_eq;
        if(!ObjectUtils.isEmpty(this.n_day9_eq)){
            this.getSearchCond().eq("day9", n_day9_eq);
        }
    }
	private String n_day20_eq;//[20]
	public void setN_day20_eq(String n_day20_eq) {
        this.n_day20_eq = n_day20_eq;
        if(!ObjectUtils.isEmpty(this.n_day20_eq)){
            this.getSearchCond().eq("day20", n_day20_eq);
        }
    }
	private String n_day22_eq;//[22]
	public void setN_day22_eq(String n_day22_eq) {
        this.n_day22_eq = n_day22_eq;
        if(!ObjectUtils.isEmpty(this.n_day22_eq)){
            this.getSearchCond().eq("day22", n_day22_eq);
        }
    }
	private String n_day26_eq;//[26]
	public void setN_day26_eq(String n_day26_eq) {
        this.n_day26_eq = n_day26_eq;
        if(!ObjectUtils.isEmpty(this.n_day26_eq)){
            this.getSearchCond().eq("day26", n_day26_eq);
        }
    }
	private String n_day6_eq;//[6]
	public void setN_day6_eq(String n_day6_eq) {
        this.n_day6_eq = n_day6_eq;
        if(!ObjectUtils.isEmpty(this.n_day6_eq)){
            this.getSearchCond().eq("day6", n_day6_eq);
        }
    }
	private String n_day25_eq;//[25]
	public void setN_day25_eq(String n_day25_eq) {
        this.n_day25_eq = n_day25_eq;
        if(!ObjectUtils.isEmpty(this.n_day25_eq)){
            this.getSearchCond().eq("day25", n_day25_eq);
        }
    }
	private String n_day18_eq;//[18]
	public void setN_day18_eq(String n_day18_eq) {
        this.n_day18_eq = n_day18_eq;
        if(!ObjectUtils.isEmpty(this.n_day18_eq)){
            this.getSearchCond().eq("day18", n_day18_eq);
        }
    }
	private String n_day19_eq;//[19]
	public void setN_day19_eq(String n_day19_eq) {
        this.n_day19_eq = n_day19_eq;
        if(!ObjectUtils.isEmpty(this.n_day19_eq)){
            this.getSearchCond().eq("day19", n_day19_eq);
        }
    }
	private String n_day12_eq;//[12]
	public void setN_day12_eq(String n_day12_eq) {
        this.n_day12_eq = n_day12_eq;
        if(!ObjectUtils.isEmpty(this.n_day12_eq)){
            this.getSearchCond().eq("day12", n_day12_eq);
        }
    }
	private String n_day15_eq;//[15]
	public void setN_day15_eq(String n_day15_eq) {
        this.n_day15_eq = n_day15_eq;
        if(!ObjectUtils.isEmpty(this.n_day15_eq)){
            this.getSearchCond().eq("day15", n_day15_eq);
        }
    }
	private String n_pimpersonname_eq;//[姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_attendancemreportid2_eq;//[考勤月报标识]
	public void setN_attendancemreportid2_eq(String n_attendancemreportid2_eq) {
        this.n_attendancemreportid2_eq = n_attendancemreportid2_eq;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportid2_eq)){
            this.getSearchCond().eq("attendancemreportid2", n_attendancemreportid2_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("pimpersonname", query)   
            );
		 }
	}
}




