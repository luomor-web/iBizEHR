export default {
  fields: {
    orgid: "组织ID",
    dh: "职称代码",
    titletype: "职称类型",
    zclc: "职称类型",
    pimtitlecataloguename: "职称目录名称",
    updatedate: "更新时间",
    zcdj: "职称等级",
    enable: "逻辑有效标志",
    createman: "建立人",
    createdate: "建立时间",
    updateman: "更新人",
    pxh: "排序号",
    pimtitlecatalogueid: "职称标识",
    pimtitlecataloguename2: "职称目录类型",
    ormorgid: "组织标识",
    pimtitlecatalogueid2: "职称标识",
  },
	views: {
		gridview: {
			caption: "职称目录",
      		title: "职称目录管理表格视图",
		},
		pickupview: {
			caption: "职称目录",
      		title: "职称目录管理数据选择视图",
		},
		notpickupgridview: {
			caption: "职称目录",
      		title: "职称目录管理选择表格视图",
		},
		notpickupview: {
			caption: "职称目录",
      		title: "职称目录管理数据选择视图",
		},
		pickupgridview: {
			caption: "职称目录",
      		title: "职称目录管理选择表格视图",
		},
		editview: {
			caption: "职称目录",
      		title: "职称目录管理编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "职称目录信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "职称标识", 
			srfmajortext: "职称目录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			dh: "职称代码", 
			pimtitlecataloguename: "职称目录名称", 
			pimtitlecataloguename2: "职称目录类型", 
			zclc: "职称类型", 
			pimtitlecatalogueid: "职称标识", 
			pimtitlecatalogueid2: "职称标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pxh: "排序号",
			dh: "职称代码",
			pimtitlecataloguename: "职称目录名称",
			pimtitlecataloguename2: "职称目录类型",
			zclc: "职称类型",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimtitlecataloguename_like: "职称目录名称", 
			n_dh_eq: "职称代码(=)", 
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
};