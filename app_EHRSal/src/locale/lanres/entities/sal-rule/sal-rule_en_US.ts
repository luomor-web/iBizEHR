
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
};