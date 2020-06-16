
export default {
  fields: {
    socruleid: '社保规则标识',
    socrulename: '社保规则名称',
    createman: '建立人',
    enable: '逻辑有效标志',
    updateman: '更新人',
    createdate: '建立时间',
    updatedate: '更新时间',
    ormorgid: '组织标识',
    ormorgname: '组织',
    nyear: '年度',
    memo: '备注',
  },
	views: {
		gridview: {
			caption: "社保规则",
      title: '社保规则表格视图',
		},
		editview: {
			caption: "社保规则",
      title: '社保规则编辑视图',
		},
	},
	main_form: {
		details: {
			group1: "社保规则基本信息", 
			druipart1: "", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "社保规则标识", 
			srfmajortext: "社保规则名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			socrulename: "社保规则名称", 
			nyear: "年度", 
			ormorgname: "组织", 
			memo: "备注", 
			ormorgid: "组织标识", 
			socruleid: "社保规则标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			socrulename: "社保规则名称",
			nyear: "年度",
			ormorgname: "组织",
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
	},
};