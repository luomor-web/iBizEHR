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
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
};