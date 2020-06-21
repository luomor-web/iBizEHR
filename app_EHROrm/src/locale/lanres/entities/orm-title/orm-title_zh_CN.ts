export default {
  fields: {
    titletype: "头衔类型",
    ormtitlename: "头衔",
    ormtitleid: "头衔标识",
    createdate: "建立时间",
    updatedate: "更新时间",
    updateman: "更新人",
    createman: "建立人",
  },
	views: {
		editview: {
			caption: "标准头衔设置",
      		title: "标准头衔设置",
		},
		redirectview: {
			caption: "头衔管理",
      		title: "头衔管理数据重定向视图",
		},
		mpickupview: {
			caption: "标准头衔库",
      		title: "标准头衔库",
		},
		pickupgridview: {
			caption: "标准头衔库",
      		title: "标准头衔库",
		},
		gridview: {
			caption: "标准头衔设置",
      		title: "标准头衔设置",
		},
		pickupview: {
			caption: "标准头衔库",
      		title: "标准头衔库",
		},
		editview2: {
			caption: "头衔管理",
      		title: "头衔管理编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "头衔信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "头衔标识", 
			srfmajortext: "头衔", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormtitlename: "头衔", 
			titletype: "头衔类型", 
			ormtitleid: "头衔标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormtitlename: "头衔",
			titletype: "头衔类型",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormtitlename_like: "头衔", 
			n_titletype_eq: "头衔类型", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
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
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
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