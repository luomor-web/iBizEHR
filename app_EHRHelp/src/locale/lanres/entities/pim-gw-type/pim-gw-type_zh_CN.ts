export default {
  fields: {
    enable: "逻辑有效标志",
    pimgwtypename: "岗位类型对照表名称",
    gwlx: "岗位类型",
    ordervalue: "排序值",
    createdate: "建立时间",
    pimgwtypeid: "岗位类型对照表标识",
    createman: "建立人",
    updateman: "更新人",
    updatedate: "更新时间",
  },
	views: {
		gridview: {
			caption: "岗位类型对照表",
      		title: "岗位类型对照表表格视图",
		},
		editview2: {
			caption: "岗位类型对照表",
      		title: "岗位类型对照表编辑视图",
		},
		pickupgridview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
		redirectview: {
			caption: "岗位类型对照表",
      		title: "岗位类型对照表数据重定向视图",
		},
		editview: {
			caption: "岗位类型对照表",
      		title: "岗位类型对照表编辑视图",
		},
		mpickupview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
		pickupview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
	},
	main_form: {
		details: {
			group1: "岗位类型对照表基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位类型对照表标识", 
			srfmajortext: "岗位类型对照表名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimgwtypename: "岗位类型对照表名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			pimgwtypeid: "岗位类型对照表标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ordervalue: "排序",
			gwlx: "岗位类型",
			createdate: "建立时间",
			createman: "建立人",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_gwlx_eq: "岗位类型", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
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
};