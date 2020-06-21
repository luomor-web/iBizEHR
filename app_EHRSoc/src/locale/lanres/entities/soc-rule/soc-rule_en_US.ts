
export default {
  fields: {
    socruleid: "社保规则标识",
    socrulename: "社保规则名称",
    createman: "建立人",
    enable: "逻辑有效标志",
    updateman: "更新人",
    createdate: "建立时间",
    updatedate: "更新时间",
    ormorgid: "组织标识",
    ormorgname: "组织",
    nyear: "年度",
    memo: "备注",
    socareaid: "参保地标识",
    socareaname: "参保地",
    state: "状态",
  },
	views: {
		gridview: {
			caption: "社保规则",
      		title: "社保规则表格视图",
		},
		editview: {
			caption: "社保规则",
      		title: "社保规则编辑视图",
		},
		main2editview: {
			caption: "社保规则",
      		title: "社保规则编辑视图",
		},
		pickupview: {
			caption: "社保规则",
      		title: "社保规则数据选择视图",
		},
		quickeditview: {
			caption: "社保规则",
      		title: "社保规则编辑视图",
		},
		pickupgridview: {
			caption: "社保规则",
      		title: "社保规则选择表格视图",
		},
	},
	main2_form: {
		details: {
			group1: "社保规则基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "社保规则标识", 
			srfmajortext: "社保规则名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			nyear: "年度", 
			socareaname: "参保地", 
			socrulename: "社保规则名称", 
			state: "状态", 
			memo: "备注", 
			socareaid: "参保地标识", 
			ormorgid: "组织标识", 
			socruleid: "社保规则标识", 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: "社保规则基本信息", 
			druipart1: "", 
			grouppanel1: "分组面板", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "社保规则标识", 
			srfmajortext: "社保规则名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			nyear: "年度", 
			socareaname: "参保地", 
			socrulename: "社保规则名称", 
			state: "状态", 
			memo: "备注", 
			socruleid: "社保规则标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			socrulename: "社保规则名称",
			ormorgname: "组织",
			socareaname: "参保地",
			nyear: "年度",
			state: "状态",
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
	quickeditviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
	main2editviewtoolbar_toolbar: {
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
	editviewtoolbar_toolbar: {
		tbitem1_openeditview: {
			caption: "编辑",
			tip: "编辑",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1_quickcreatesocrule: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction8: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction6: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
		deuiaction5: {
			caption: "Help",
			tip: "Help",
		},
	},
};