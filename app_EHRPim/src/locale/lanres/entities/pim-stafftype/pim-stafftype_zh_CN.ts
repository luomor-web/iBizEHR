export default {
  fields: {
    updateman: "更新人",
    pimstafftypeid: "员工类型管理标识",
    updatedate: "更新时间",
    shgz: "入职审核规则",
    createdate: "建立时间",
    sbm: "员工类型代码",
    pimstafftypename: "员工类型管理名称",
    createman: "建立人",
    enable: "逻辑有效标志",
  },
	views: {
		editview: {
			caption: "员工类型",
      		title: "员工类型编辑视图",
		},
		editview2: {
			caption: "员工类型管理",
      		title: "员工类型管理编辑视图",
		},
		gridview: {
			caption: "员工类型",
      		title: "员工类型表格视图",
		},
		pickupgridview: {
			caption: "员工类型管理",
      		title: "员工类型管理选择表格视图",
		},
		pickupview: {
			caption: "员工类型管理",
      		title: "员工类型管理数据选择视图",
		},
		mpickupview: {
			caption: "员工类型管理",
      		title: "员工类型管理数据多项选择视图",
		},
		selgridview: {
			caption: "员工类型",
      		title: "员工类型表格视图",
		},
		seleditview: {
			caption: "员工类型",
      		title: "员工类型编辑视图",
		},
		redirectview: {
			caption: "员工类型管理",
      		title: "员工类型管理数据重定向视图",
		},
	},
	main_form: {
		details: {
			group1: "员工类型信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "员工类型管理标识", 
			srfmajortext: "员工类型管理名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sbm: "员工类型代码", 
			pimstafftypename: "员工类型", 
			shgz: "入职审核规则", 
			pimstafftypeid: "员工类型管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sbm: "员工类型代码",
			pimstafftypename: "员工类型",
			shgz: "入职审核规则",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimstafftypeid_eq: "识别码", 
			n_pimstafftypename_like: "员工类型名称", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editview2toolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	gridviewtoolbar2_toolbar: {
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
	gridviewtoolbar_toolbar: {
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction6: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	selgridviewtoolbar_toolbar: {
		deuiaction6: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	seleditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};