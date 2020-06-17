
export default {
  fields: {
    socareaid: '参保地标识',
    socareaname: '参保地名称',
    enable: '逻辑有效标志',
    createman: '建立人',
    updateman: '更新人',
    createdate: '建立时间',
    updatedate: '更新时间',
    ormorgid: '组织标识',
    ormorgname: '组织',
    memo: '备注',
  },
	views: {
		gridview: {
			caption: "参保地",
      title: '参保地表格视图',
		},
		editview: {
			caption: "参保地",
      title: '参保地编辑视图',
		},
		pickupgridview: {
			caption: "参保地",
      title: '参保地选择表格视图',
		},
		pickupview: {
			caption: "参保地",
      title: '参保地数据选择视图',
		},
	},
	main_form: {
		details: {
			group1: "参保地基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "参保地标识", 
			srfmajortext: "参保地名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			socareaname: "参保地名称", 
			ormorgname: "组织", 
			memo: "备注", 
			socareaid: "参保地标识", 
			ormorgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			socareaname: "参保地名称",
			memo: "备注",
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
		deuiaction3: {
			caption: "导入",
			tip: "导入",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
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