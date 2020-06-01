
export default {
  fields: {
    attendencetypeid: '考勤类型标识',
    updatedate: '更新时间',
    createman: '建立人',
    typecode: '考勤类型代码',
    createdate: '建立时间',
    updateman: '更新人',
    attendencetypename: '考勤类型名称',
    enable: '逻辑有效标志',
  },
	views: {
		gridview: {
			caption: "考勤类型",
      title: '考勤类型',
		},
		editview: {
			caption: "考勤类型",
      title: '考勤类型',
		},
	},
	main_form: {
		details: {
			group1: "考勤类型信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤类型标识", 
			srfmajortext: "考勤类型名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			attendencetypeid: "标识码", 
			typecode: "考勤类型代码", 
			attendencetypename: "考勤类型名称", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			typecode: "考勤类型代码",
			attendencetypename: "考勤类型名称",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_typecode_like: "考勤类型代码(%)", 
			n_attendencetypename_like: "考勤类型名称(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction4: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction3: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction3: {
			caption: "导入",
			tip: "导入",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
};