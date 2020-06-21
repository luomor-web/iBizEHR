
export default {
  fields: {
    isorno: "是否允许删除",
    updateman: "更新人",
    updatedate: "更新时间",
    createdate: "建立时间",
    sortno: "排序号",
    pimtypecontractid: "合同类型标识",
    createman: "建立人",
    contractlife: "合同年限",
    typecode: "合同类型代码",
    pimtypecontractname: "合同类型名称",
    enable: "逻辑有效标志",
  },
	views: {
		gridview: {
			caption: "合同类型",
      		title: "合同类型表格视图",
		},
		redirectview: {
			caption: "合同类型",
      		title: "合同类型数据重定向视图",
		},
		pickupgridview: {
			caption: "合同类型",
      		title: "合同类型选择表格视图",
		},
		pickupview: {
			caption: "合同类型",
      		title: "合同类型数据选择视图",
		},
		editview2: {
			caption: "合同类型",
      		title: "合同类型编辑视图",
		},
		editview: {
			caption: "合同类型",
      		title: "合同类型编辑视图",
		},
		mpickupview: {
			caption: "合同类型",
      		title: "合同类型数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "合同类型基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "合同类型标识", 
			srfmajortext: "合同类型名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sortno: "排序号", 
			pimtypecontractname: "合同类型名称", 
			contractlife: "合同年限", 
			pimtypecontractid: "合同类型标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			typecode: "合同类型代码",
			pimtypecontractname: "合同类型名称",
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
};