
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