
export default {
  fields: {
    nyear: "年",
    createman: "建立人",
    createdate: "建立时间",
    updatedate: "更新时间",
    salplanid: "薪酬计算计划标识",
    salplanname: "薪酬计算计划名称",
    enable: "逻辑有效标志",
    updateman: "更新人",
    nmonth: "月",
    state: "计划状态",
    memo: "备注",
    salschemename: "薪酬方案",
    ormorgname: "组织",
    ormorgid: "组织标识",
    salschemeid: "薪酬方案标识",
  },
	views: {
		pickupgridview: {
			caption: "薪酬计算计划",
      		title: "薪酬计算计划选择表格视图",
		},
		gridview: {
			caption: "薪酬计算计划",
      		title: "薪酬计算计划表格视图",
		},
		pickupview: {
			caption: "薪酬计算计划",
      		title: "薪酬计算计划数据选择视图",
		},
		editview: {
			caption: "薪酬计算计划",
      		title: "薪酬计算计划编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬计算计划信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬计算计划标识", 
			srfmajortext: "薪酬计算计划名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salplanname: "薪酬计算计划名称", 
			nyear: "年", 
			nmonth: "月", 
			ormorgname: "组织", 
			salschemename: "薪酬方案", 
			state: "计划状态", 
			memo: "备注", 
			salplanid: "薪酬计算计划标识", 
			ormorgid: "组织标识", 
			salschemeid: "薪酬方案标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salplanname: "薪酬计算计划名称",
			nyear: "年",
			nmonth: "月",
			ormorgname: "组织",
			salschemename: "薪酬方案",
			updateman: "更新人",
			updatedate: "更新时间",
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
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
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