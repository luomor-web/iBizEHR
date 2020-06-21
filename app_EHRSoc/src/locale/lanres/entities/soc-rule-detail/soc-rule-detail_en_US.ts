
export default {
  fields: {
    socruledetailid: "社保规则明细标识",
    socruledetailname: "社保规则明细名称",
    createman: "建立人",
    createdate: "建立时间",
    updateman: "更新人",
    updatedate: "更新时间",
    soctypeid: "保险类型标识",
    soctypename: "保险类型",
    socruleid: "社保规则标识",
    socrulename: "社保规则名称",
    highnum: "最高基数",
    lownum: "最低基数",
    companynum: "企业基数",
    personnum: "个人基数",
    companyrate: "企业比例",
    personrate: "个人比例",
    personamount: "个人固定额",
    companyamount: "企业固定额",
    memo: "备注",
    ordervalue: "排序号",
  },
	views: {
		pickupview: {
			caption: "社保规则明细",
      		title: "社保规则明细数据选择视图",
		},
		pickupgridview: {
			caption: "社保规则明细",
      		title: "社保规则明细选择表格视图",
		},
		editview: {
			caption: "社保规则明细",
      		title: "社保规则明细编辑视图",
		},
		gridview: {
			caption: "社保规则明细",
      		title: "社保规则明细表格视图",
		},
	},
	main_form: {
		details: {
			group1: "社保规则明细基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "社保规则明细标识", 
			srfmajortext: "社保规则明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			socruledetailname: "社保规则明细名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			socruledetailid: "社保规则明细标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ordervalue: "排序号",
			soctypename: "保险类型",
			highnum: "最高基数",
			lownum: "最低基数",
			companynum: "企业基数",
			companyrate: "企业比例",
			personrate: "个人比例",
			companyamount: "企业固定额",
			personamount: "个人固定额",
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