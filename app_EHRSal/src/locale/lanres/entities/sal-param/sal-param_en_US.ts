
export default {
  fields: {
    updateman: "更新人",
    memo: "备注",
    updatedate: "更新时间",
    createman: "建立人",
    enable: "逻辑有效标志",
    param: "对应计算源属性",
    salparamid: "薪酬计算指标标识",
    salparamname: "薪酬计算指标名称",
    createdate: "建立时间",
    salsourcename: "薪酬计算源",
    salsourceid: "薪酬计算源",
  },
	views: {
		editview: {
			caption: "薪酬计算指标",
      		title: "薪酬计算指标编辑视图",
		},
		pickupgridview: {
			caption: "薪酬计算指标",
      		title: "薪酬计算指标选择表格视图",
		},
		gridview: {
			caption: "薪酬计算指标",
      		title: "薪酬计算指标表格视图",
		},
		pickupview: {
			caption: "薪酬计算指标",
      		title: "薪酬计算指标数据选择视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬计算指标信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬计算指标标识", 
			srfmajortext: "薪酬计算指标名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salparamname: "薪酬计算指标名称", 
			salsourcename: "薪酬计算源", 
			param: "对应计算源属性", 
			memo: "备注", 
			salparamid: "薪酬计算指标标识", 
			salsourceid: "薪酬计算源", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salparamname: "薪酬计算指标名称",
			salsourcename: "薪酬计算源",
			param: "对应计算源属性",
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