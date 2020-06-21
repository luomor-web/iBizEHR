export default {
  fields: {
    createman: "建立人",
    updateman: "更新人",
    updatedate: "更新时间",
    ormpostdetailsid: "岗位明细标识",
    createdate: "建立时间",
    ormpostdetailsname: "岗位明细",
    gwflag: "岗位标签",
    sugexcyear: "建议交流年限",
    gwtype: "岗位类型",
    postnature: "岗位性质",
    ormpostname: "岗位集名称",
    mustexcyear: "必须交流年限",
    ormpostlibname: "岗位名称",
    isconfidential: "是否保密岗",
    ormpostid: "岗位集ID",
    ormpostlibid: "岗位ID",
  },
	views: {
		gridview: {
			caption: "岗位明细",
      		title: "岗位明细",
		},
		pickupgridview: {
			caption: "岗位明细",
      		title: "岗位明细选择表格视图",
		},
		editview: {
			caption: "岗位明细",
      		title: "岗位明细",
		},
		editview2: {
			caption: "岗位明细",
      		title: "岗位明细编辑视图",
		},
		mpickupview: {
			caption: "岗位明细",
      		title: "岗位明细数据多项选择视图",
		},
		pickupview: {
			caption: "岗位明细",
      		title: "岗位明细数据选择视图",
		},
		redirectview: {
			caption: "岗位明细",
      		title: "岗位明细数据重定向视图",
		},
	},
	main_form: {
		details: {
			group1: "岗位明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位明细标识", 
			srfmajortext: "岗位明细", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormpostlibid: "岗位ID", 
			ormpostname: "岗位集名称", 
			ormpostid: "岗位集ID", 
			ormpostlibname: "岗位名称", 
			ormpostdetailsid: "岗位明细标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormpostlibname: "岗位名称",
			gwtype: "岗位类型",
			sugexcyear: "建议交流年限",
			mustexcyear: "必须交流年限",
			isconfidential: "是否保密岗",
			postnature: "岗位性质",
			gwflag: "岗位标签",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormpostdetailsname_like: "岗位明细", 
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
	},
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
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