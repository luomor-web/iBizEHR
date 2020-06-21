
export default {
  fields: {
    mustexcyear: "必须交流年限",
    postnature: "岗位性质",
    createdate: "建立时间",
    jobdesc: "岗位职责说明",
    ormpostlibid: "岗位标识",
    gwflag: "岗位标签",
    sugexcyear: "建议交流年限",
    updatedate: "更新时间",
    gwtype: "岗位类型",
    isconfidential: "是否保密岗",
    createman: "建立人",
    ormpostlibname: "岗位名称",
    updateman: "更新人",
  },
	views: {
		redirectview: {
			caption: "岗位库",
      		title: "岗位库数据重定向视图",
		},
		mpickupview: {
			caption: "标准岗位",
      		title: "标准岗位",
		},
		cxgridview: {
			caption: "标准岗位查询",
      		title: "标准岗位查询",
		},
		gridview: {
			caption: "标准岗位设置",
      		title: "标准岗位设置",
		},
		editview2: {
			caption: "岗位库",
      		title: "岗位库编辑视图",
		},
		editview: {
			caption: "标准岗位设置",
      		title: "标准岗位设置",
		},
		pickupview: {
			caption: "标准岗位",
      		title: "标准岗位",
		},
		pickupgridview: {
			caption: "标准岗位",
      		title: "标准岗位",
		},
	},
	main_form: {
		details: {
			group1: "岗位库", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位标识", 
			srfmajortext: "岗位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			gwtype: "岗位类型", 
			ormpostlibname: "岗位名称", 
			gwflag: "岗位标签", 
			sugexcyear: "建议交流年限", 
			mustexcyear: "必须交流年限", 
			isconfidential: "是否保密岗", 
			postnature: "岗位性质", 
			jobdesc: "岗位职责说明", 
			ormpostlibid: "岗位标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormpostlibname: "岗位名称",
			gwtype: "岗位类型",
			gwflag: "岗位标签",
			sugexcyear: "建议交流年限",
			mustexcyear: "必须交流年限",
			isconfidential: "是否保密岗",
			postnature: "岗位性质",
			jobdesc: "岗位职责说明",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormpostlibname_like: "岗位名称", 
			n_gwtype_eq: "岗位类型", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
	cxgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	gridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction4: {
			caption: "Filter",
			tip: "Filter",
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
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
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