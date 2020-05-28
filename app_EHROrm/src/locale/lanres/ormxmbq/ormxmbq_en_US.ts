
export default {
  fields: {
    orgid: '组织ID',
    updateman: '更新人',
    createdate: '建立时间',
    xh: '排序号',
    createman: '建立人',
    ormxmbqname: '项目标签',
    updatedate: '更新时间',
    ormxmbqid: '项目标签标识',
    ormorgname: '组织名称',
    ormorgid: '组织ID',
  },
	views: {
		editview: {
			caption: "项目标签",
      title: '项目标签',
		},
		redirectview: {
			caption: "项目标签",
      title: '项目标签',
		},
		mpickupview: {
			caption: "项目标签",
      title: '项目标签',
		},
		editview2: {
			caption: "项目标签",
      title: '项目标签',
		},
		gridview: {
			caption: "项目标签",
      title: '项目标签',
		},
		pickupview: {
			caption: "项目标签",
      title: '项目标签',
		},
		pickupgridview: {
			caption: "项目标签",
      title: '项目标签',
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
	gridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
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
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
	},
};