
export default {
  fields: {
    khnd: "考核年度",
    createman: "建立人",
    updatedate: "更新时间",
    khzq: "考核周期",
    khpgdj: "考核定级",
    pm: "排名",
    parjxndkhjgname: "绩效年度考核结果名称",
    sftx: "是否提醒",
    updateman: "更新人",
    parjxndkhjgid: "绩效年度考核结果标识",
    zf: "总分",
    createdate: "建立时间",
    pimpersonname: "员工姓名",
    pimpersonid: "人员信息标识",
  },
	views: {
		lasttwoyeargridview: {
			caption: "绩效考核成绩",
      		title: "绩效考核成绩",
		},
		editview: {
			caption: "绩效年度考核结果",
      		title: "绩效年度考核结果编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "绩效年度考核结果基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "绩效年度考核结果标识", 
			srfmajortext: "绩效年度考核结果名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			parjxndkhjgname: "绩效年度考核结果名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			parjxndkhjgid: "绩效年度考核结果标识", 
		},
		uiactions: {
		},
	},
	gmjxkhcj_grid: {
		columns: {
			khnd: "考核年度",
			khzq: "考核周期",
			zf: "总分",
			khpgdj: "考核定级",
			pm: "排名",
			sftx: "是否提醒",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
		},
		uiactions: {
		},
	},
	lasttwoyeargridviewtoolbar_toolbar: {
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