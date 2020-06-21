
export default {
  fields: {
    orgid: "组织ID",
    updateman: "更新人",
    createdate: "建立时间",
    xh: "排序号",
    createman: "建立人",
    ormxmbqname: "项目标签",
    updatedate: "更新时间",
    ormxmbqid: "项目标签标识",
    ormorgname: "组织名称",
    ormorgid: "组织ID",
  },
	views: {
		editview: {
			caption: "项目标签",
      		title: "项目标签编辑视图",
		},
		redirectview: {
			caption: "项目标签",
      		title: "项目标签数据重定向视图",
		},
		mpickupview: {
			caption: "项目标签",
      		title: "项目标签数据多项选择视图",
		},
		editview2: {
			caption: "项目标签",
      		title: "项目标签编辑视图",
		},
		gridview: {
			caption: "项目标签",
      		title: "项目标签",
		},
		pickupview: {
			caption: "项目标签",
      		title: "项目标签数据选择视图",
		},
		pickupgridview: {
			caption: "项目标签",
      		title: "项目标签选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "项目标签维护", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "项目标签标识", 
			srfmajortext: "项目标签", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgid: "组织ID", 
			xh: "排序号", 
			ormorgname: "组织名称", 
			ormxmbqname: "项目标签", 
			ormxmbqid: "项目标签标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			ormorgname: "组织名称",
			ormxmbqname: "项目标签",
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
			n_ormorgname_like: "组织名称", 
			n_ormxmbqname_like: "项目标签", 
		},
		uiactions: {
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
	},
	editview2toolbar_toolbar: {
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