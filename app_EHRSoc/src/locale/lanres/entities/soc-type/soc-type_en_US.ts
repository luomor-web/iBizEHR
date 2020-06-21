
export default {
  fields: {
    soctypeid: "保险类型标识",
    soctypename: "保险类型",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    createman: "建立人",
    updatedate: "更新时间",
    updateman: "更新人",
    ordervalue: "排序号",
  },
	views: {
		pickupview: {
			caption: "保险类型",
      		title: "保险类型数据选择视图",
		},
		pickupgridview: {
			caption: "保险类型",
      		title: "保险类型选择表格视图",
		},
		editview: {
			caption: "保险类型",
      		title: "保险类型编辑视图",
		},
		gridview: {
			caption: "保险类型",
      		title: "保险类型表格视图",
		},
	},
	main_form: {
		details: {
			group1: "保险类型基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "保险类型标识", 
			srfmajortext: "保险类型", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			soctypename: "保险类型", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			soctypeid: "保险类型标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ordervalue: "排序号",
			soctypename: "保险类型",
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
};