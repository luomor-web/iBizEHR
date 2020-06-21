export default {
  fields: {
    salsourcename: "薪酬计算源名称",
    enable: "逻辑有效标志",
    createman: "建立人",
    createdate: "建立时间",
    source: "数据源(表/视图)",
    updateman: "更新人",
    salsourceid: "薪酬计算源标识",
    memo: "备注",
    updatedate: "更新时间",
  },
	views: {
		pickupview: {
			caption: "薪酬计算源",
      		title: "薪酬计算源数据选择视图",
		},
		pickupgridview: {
			caption: "薪酬计算源",
      		title: "薪酬计算源选择表格视图",
		},
		editview: {
			caption: "薪酬计算源",
      		title: "薪酬计算源编辑视图",
		},
		gridview: {
			caption: "薪酬计算源",
      		title: "薪酬计算源表格视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬计算源信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬计算源标识", 
			srfmajortext: "薪酬计算源名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salsourcename: "薪酬计算源名称", 
			source: "数据源(表/视图)", 
			memo: "备注", 
			salsourceid: "薪酬计算源标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salsourcename: "薪酬计算源名称",
			source: "数据源(表/视图)",
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