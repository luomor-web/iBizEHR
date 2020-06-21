export default {
  fields: {
    socarchivesdetailid: "社保档案明细标识",
    socarchivesdetailname: "社保档案明细名称",
    createman: "建立人",
    createdate: "建立时间",
    updateman: "更新人",
    updatedate: "更新时间",
    socarchivesid: "社保档案标识",
    socarchivesname: "社保档案名称",
    socruledetailid: "社保规则明细标识",
    personnum: "个人基数",
    companynum: "企业基数",
    highnum: "最高基数",
    lownum: "最低基数",
    ordervalue: "排序号",
    soctypeid: "保险类型标识",
    soctypename: "保险类型",
    personrate: "个人比例",
    companyrate: "企业比例",
    personamount: "个人固定额",
    companyamount: "企业固定额",
    socruledetailname: "社保规则明细名称",
  },
	views: {
		editview: {
			caption: "社保档案明细",
      		title: "社保档案明细编辑视图",
		},
		gridview: {
			caption: "社保档案明细",
      		title: "社保档案明细表格视图",
		},
	},
	main_form: {
		details: {
			group1: "社保档案明细基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "社保档案明细标识", 
			srfmajortext: "社保档案明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			socarchivesdetailname: "社保档案明细名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			socarchivesdetailid: "社保档案明细标识", 
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
			personnum: "个人基数",
			companyrate: "企业比例",
			personrate: "个人比例",
			companyamount: "企业固定额",
			personamount: "个人固定额",
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
			caption: "删除",
			tip: "删除",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "导出",
			tip: "导出",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
	},
};