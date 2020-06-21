export default {
  fields: {
    salrulename: "薪酬规则名称",
    enable: "逻辑有效标志",
    memo: "备注",
    createdate: "建立时间",
    salruleid: "薪酬规则标识",
    createman: "建立人",
    updateman: "更新人",
    updatedate: "更新时间",
    salparamname: "薪酬计算指标名称",
    salparamid: "薪酬计算指标标识",
  },
	views: {
		mpickupview: {
			caption: "薪酬规则",
      		title: "薪酬规则数据多项选择视图",
		},
		editview: {
			caption: "薪酬规则",
      		title: "薪酬规则编辑视图",
		},
		pickupview: {
			caption: "薪酬规则",
      		title: "薪酬规则数据选择视图",
		},
		gridview: {
			caption: "薪酬规则",
      		title: "薪酬规则表格视图",
		},
		pickupgridview: {
			caption: "薪酬规则",
      		title: "薪酬规则选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬规则信息", 
			druipart1: "", 
			grouppanel1: "规则明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬规则标识", 
			srfmajortext: "薪酬规则名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salrulename: "薪酬规则名称", 
			salparamname: "薪酬计算指标名称", 
			memo: "备注", 
			salparamid: "薪酬计算指标标识", 
			salruleid: "薪酬规则标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salrulename: "薪酬规则名称",
			salparamname: "薪酬计算指标名称",
			memo: "备注",
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
};