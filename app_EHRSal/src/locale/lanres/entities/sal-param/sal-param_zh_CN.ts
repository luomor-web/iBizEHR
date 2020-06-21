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