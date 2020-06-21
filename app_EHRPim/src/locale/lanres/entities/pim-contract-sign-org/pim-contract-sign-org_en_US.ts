
export default {
  fields: {
    updateman: "更新人",
    contractsignorgname: "签约主体单位名称",
    contractsignorgid: "签约主体单位标识",
    createman: "建立人",
    createdate: "建立时间",
    updatedate: "更新时间",
    enable: "逻辑有效标志",
    isdefaultsignorg: "默认签约主体",
    ormsignorgname: "法人主体名称",
    ormorgname: "管理单位名称",
    ormsignorgid: "法人主体标识",
    ormorgid: "管理单位标识",
  },
	views: {
		editview2: {
			caption: "签约主体单位",
      		title: "签约主体单位编辑视图",
		},
		pickupgridview: {
			caption: "签约主体单位",
      		title: "签约主体单位选择表格视图",
		},
		gridview: {
			caption: "法人主体设置",
      		title: "法人主体设置",
		},
		editview: {
			caption: "签约主体单位",
      		title: "法人主体设置编辑视图",
		},
		redirectview: {
			caption: "签约主体单位",
      		title: "签约主体单位数据重定向视图",
		},
		pickupview: {
			caption: "签约主体单位",
      		title: "签约主体单位数据选择视图",
		},
		mpickupview: {
			caption: "签约主体单位",
      		title: "签约主体单位数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "签约主体基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "签约主体单位标识", 
			srfmajortext: "签约主体单位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgid: "管理单位标识", 
			ormorgname: "管理单位名称", 
			ormsignorgid: "法人主体标识", 
			ormsignorgname: "法人主体名称", 
			isdefaultsignorg: "默认签约主体", 
			contractsignorgid: "签约主体单位标识", 
		},
		uiactions: {
		},
	},
	pickgrid_grid: {
		columns: {
			ormorgname: "管理单位",
			contractsignorgname: "签约单位",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "管理单位名称",
			ormsignorgname: "法人主体名称",
			isdefaultsignorg: "默认签约主体",
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