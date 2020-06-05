
export default {
  fields: {
    createman: '建立人',
    day14: '14',
    day10: '10',
    day8: '8',
    day2: '2',
    yf: '月份',
    day30: '30',
    day27: '27',
    day1: '1',
    day7: '7',
    day24: '24',
    day13: '13',
    day3: '3',
    attendancemreportname: '考勤月报明细名称',
    updatedate: '更新时间',
    ormrogname: '组织名称',
    day11: '11',
    day29: '29',
    day4: '4',
    day17: '17',
    day16: '16',
    ormrogsectorid: '部门id',
    day5: '5',
    nd: '年度',
    attendancemreportmxid: '考勤月报明细标识',
    day28: '28',
    day31: '31',
    ormrogsectorname: '部门名称',
    createdate: '建立时间',
    day23: '23',
    day21: '21',
    day9: '9',
    day20: '20',
    day22: '22',
    ormrogid: '组织id',
    updateman: '更新人',
    day26: '26',
    kqhz: '考勤汇总',
    day6: '6',
    day25: '25',
    day18: '18',
    day19: '19',
    day12: '12',
    day15: '15',
    ygbh: '员工编号',
    attendencesetupid: '考勤设置标识',
    bm: '部门',
    pimpersonname: '姓名',
    gw: '岗位',
    attendancemreportid2: '考勤月报标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		gridview: {
			caption: "考勤月报明细",
      title: '考勤月报明细',
		},
		editview: {
			caption: "考勤月报明细",
      title: '考勤月报明细',
		},
	},
	main_form: {
		details: {
			group1: "考勤月报明细基本信息", 
			grouppanel1: "每日明细", 
			grouppanel2: "统计", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤月报明细标识", 
			srfmajortext: "考勤月报明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			pimpersonname: "姓名", 
			ygbh: "员工编号", 
			ormrogname: "组织名称", 
			ormrogsectorname: "部门名称", 
			gw: "岗位", 
			nd: "年度", 
			yf: "月份", 
			attendancemreportid2: "考勤月报标识", 
			day1: "1", 
			day2: "2", 
			day3: "3", 
			day4: "4", 
			day5: "5", 
			day6: "6", 
			day7: "7", 
			day8: "8", 
			day9: "9", 
			day10: "10", 
			day11: "11", 
			day12: "12", 
			day13: "13", 
			day14: "14", 
			day15: "15", 
			day16: "16", 
			day17: "17", 
			day18: "18", 
			day19: "19", 
			day20: "20", 
			day21: "21", 
			day22: "22", 
			day23: "23", 
			day24: "24", 
			day25: "25", 
			day26: "26", 
			day27: "27", 
			day28: "28", 
			day29: "29", 
			day30: "30", 
			day31: "31", 
			kqhz: "考勤汇总", 
			attendancemreportmxid: "考勤月报明细标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname1: "姓名",
			bm: "部门",
			gw: "岗位",
			day1: "1",
			day2: "2",
			day3: "3",
			day4: "4",
			day5: "5",
			day6: "6",
			day7: "7",
			day8: "8",
			day9: "9",
			day10: "10",
			day11: "11",
			day12: "12",
			day13: "13",
			day14: "14",
			day15: "15",
			day16: "16",
			day17: "17",
			day18: "18",
			day19: "19",
			day20: "20",
			day21: "21",
			day22: "22",
			day23: "23",
			day24: "24",
			day25: "25",
			day26: "26",
			day27: "27",
			day28: "28",
			day29: "29",
			day30: "30",
			day31: "31",
			kqhz: "考勤汇总",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "姓名(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem14_export2excel: {
			caption: "导出",
			tip: "导出",
		},
		tbitem13: {
			caption: "导入",
			tip: "导入",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem4: {
			caption: "Save And New",
			tip: "Save And New",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
};