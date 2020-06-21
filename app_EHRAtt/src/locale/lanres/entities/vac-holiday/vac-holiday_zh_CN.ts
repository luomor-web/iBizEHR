export default {
  fields: {
    updatedate: "更新时间",
    nd: "年度",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    vacholidayname: "名称",
    vacholidayid: "节假日管理标识",
    age: "年龄（及以下）",
    jssj: "结束时间",
    bz: "备注",
    createman: "建立人",
    jjrlx: "类型",
    kssj: "开始时间",
    sex: "性别",
    updateman: "更新人",
    ormorgname: "组织名称",
    vacholidayrulesname: "考勤规则名称",
    ormorgid: "组织机构",
    vacholidayrulesid: "考勤规则标识",
  },
	views: {
		editview: {
			caption: "节假日/调休上班",
      		title: "节假日/调休上班",
		},
		jjrtxsbgridview: {
			caption: "节假日/调休上班",
      		title: "节假日/调休上班",
		},
	},
	main_form: {
		details: {
			grouppanel1: "分组面板", 
			grouppanel2: "分组面板", 
			group1: "节假日信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "节假日管理标识", 
			srfmajortext: "名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			vacholidayrulesid: "考勤规则标识", 
			vacholidayrulesname: "考勤规则名称", 
			vacholidayname: "名称", 
			jjrlx: "类型", 
			vacholidayid: "节假日管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			vacholidayname: "名称",
			jjrlx: "类型",
			kssj: "开始时间",
			jssj: "结束时间",
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
	jjrtxsbgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
	},
};