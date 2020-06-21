
export default {
  fields: {
    parexamcycleid: "考核周期标识",
    createman: "建立人",
    parexamcyclename: "考核周期",
    createdate: "建立时间",
    updateman: "更新人",
    updatedate: "更新时间",
    cycleid: "周期编码",
  },
	views: {
		pickupview: {
			caption: "考核周期",
      		title: "考核周期数据选择视图",
		},
		gridview: {
			caption: "考核周期",
      		title: "考核周期",
		},
		pickupgridview: {
			caption: "考核周期",
      		title: "考核周期选择表格视图",
		},
		mpickupview: {
			caption: "考核周期",
      		title: "考核周期数据多项选择视图",
		},
		editview: {
			caption: "考核周期",
      		title: "考核周期",
		},
		newgridview: {
			caption: "考核周期设置",
      		title: "考核周期设置",
		},
	},
	main_form: {
		details: {
			group1: "考核周期", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考核周期标识", 
			srfmajortext: "考核周期", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			cycleid: "周期编码", 
			parexamcycleid: "周期标识", 
			parexamcyclename: "考核周期", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			cycleid: "周期编码",
			parexamcyclename: "考核周期",
			createman: "建立人",
			createdate: "建立时间",
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
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
	newgridviewtoolbar_toolbar: {
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
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
};