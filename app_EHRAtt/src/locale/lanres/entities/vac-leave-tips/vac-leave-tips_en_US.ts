
export default {
  fields: {
    updatedate: "更新时间",
    createman: "建立人",
    updateman: "更新人",
    tips: "温馨提示",
    vacleavetipsid: "请假提示标识",
    createdate: "建立时间",
    qjzl: "请假种类",
    vacleavetipsname: "请假提示名称",
    vacholidayrulesname: "考勤规则名称",
    vacholidayrulesid: "考勤规则标识",
  },
	views: {
		qjtsgridview: {
			caption: "温馨提示",
      		title: "温馨提示",
		},
		editview: {
			caption: "请假提示",
      		title: "请假提示",
		},
	},
	main_form: {
		details: {
			group1: "请假提示", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "请假提示标识", 
			srfmajortext: "请假提示名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			vacholidayrulesid: "考勤规则标识", 
			vacholidayrulesname: "考勤规则名称", 
			qjzl: "请假种类", 
			tips: "温馨提示", 
			vacleavetipsid: "请假提示标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			qjzl: "请假种类",
			tips: "温馨提示",
		},
		uiactions: {
		},
	},
	qjtsgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
	},
	editviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};