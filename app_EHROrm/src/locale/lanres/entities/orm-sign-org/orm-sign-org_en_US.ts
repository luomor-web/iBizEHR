
export default {
  fields: {
    orgcode: "组织编号",
    ormsignorgid: "法人主体标识",
    updatedate: "更新时间",
    updateman: "更新人",
    zzjc: "简称",
    createman: "建立人",
    createdate: "建立时间",
    ormsignorgname: "法人主体名称",
  },
	views: {
		editview2: {
			caption: "法人主体",
      		title: "法人主体编辑视图",
		},
		htqddwpickupgridview: {
			caption: "合同签订单位选择",
      		title: "合同签订单位选择",
		},
		htqddwwpickupview: {
			caption: "合同签订单位选择",
      		title: "合同签订单位选择",
		},
		pickupgridview: {
			caption: "法人主体",
      		title: "法人主体选择表格视图",
		},
		editview: {
			caption: "法人主体",
      		title: "法人主体编辑视图",
		},
		gridview: {
			caption: "法人主体维护",
      		title: "法人主体维护",
		},
		bdwpickupgridview: {
			caption: "注册单位选择",
      		title: "注册单位选择",
		},
		bdwpickupview: {
			caption: "注册单位选择",
      		title: "注册单位选择",
		},
		redirectview: {
			caption: "法人主体",
      		title: "法人主体数据重定向视图",
		},
		mpickupview: {
			caption: "法人主体",
      		title: "法人主体数据多项选择视图",
		},
		pickupview: {
			caption: "法人主体",
      		title: "法人主体数据选择视图",
		},
	},
	main_form: {
		details: {
			group1: "法人主体基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "法人主体标识", 
			srfmajortext: "法人主体名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			orgcode: "组织编号", 
			ormsignorgname: "法人主体组织", 
			zzjc: "简称", 
			ormsignorgid: "法人主体标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormsignorgname: "法人主体组织",
			orgcode: "组织编号",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormsignorgname_like: "法人主体组织", 
			n_orgcode_like: "组织编号(%)", 
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