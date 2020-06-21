export default {
  fields: {
    serialnumber: "排序号",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    updatedate: "更新时间",
    createman: "建立人",
    updateman: "更新人",
    archivalcatalogueid: "档案目录标识",
    archivalcataloguename: "档案目录名称",
    pimarchivesname: "档案信息名称",
    pimarchivesid: "档案信息标识",
  },
	views: {
		editview: {
			caption: "档案目录",
      		title: "档案类别编辑视图",
		},
		pickupgridview: {
			caption: "档案目录",
      		title: "档案目录选择表格视图",
		},
		pickupview: {
			caption: "档案目录",
      		title: "档案目录数据选择视图",
		},
		mpickupview: {
			caption: "档案目录",
      		title: "档案目录数据多项选择视图",
		},
		redirectview: {
			caption: "档案目录",
      		title: "档案目录数据重定向视图",
		},
		gridview: {
			caption: "档案目录",
      		title: "档案类别表格视图",
		},
		editview2: {
			caption: "档案目录",
      		title: "档案目录编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "档案目录基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "档案目录标识", 
			srfmajortext: "档案目录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			serialnumber: "排序号", 
			archivalcataloguename: "档案目录名称", 
			archivalcatalogueid: "档案目录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			serialnumber: "排序号",
			archivalcataloguename: "档案目录名称",
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
};