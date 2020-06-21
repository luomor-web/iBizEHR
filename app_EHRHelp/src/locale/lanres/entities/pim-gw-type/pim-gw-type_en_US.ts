
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
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
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