export default {
  fields: {
    ormdutyid: "职务标识",
    fglx: "职务编码",
    updateman: "更新人",
    updatedate: "更新时间",
    xh: "排序号",
    createman: "建立人",
    zwjb: "职务级别",
    createdate: "建立时间",
    dyzj: "对应职级",
    nx: "建议交流年限",
    zwlb: "层级",
    bxjlnx: "必须交流年限",
    ormdutyname: "职务",
  },
	views: {
		estmanpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		gridview: {
			caption: "职务设置",
      		title: "职务设置",
		},
		pickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		estmanpickupgridview: {
			caption: "职务库",
      		title: "职务库",
		},
		orgsectorpickupgridview: {
			caption: "职务库",
      		title: "职务库",
		},
		mpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		orgsectorpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		redirectview: {
			caption: "职务管理",
      		title: "职务管理数据重定向视图",
		},
		estmanmpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		editview2: {
			caption: "职务管理",
      		title: "职务管理编辑视图",
		},
		ormorgsectorpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		ormorgsectorpickupgridview: {
			caption: "职务库",
      		title: "职务库",
		},
		editview: {
			caption: "职务设置",
      		title: "职务设置",
		},
		pickupgridview: {
			caption: "职务库",
      		title: "职务库",
		},
	},
	main_form: {
		details: {
			group1: "职务设置", 
			formpage1: "职务基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "职务标识", 
			srfmajortext: "职务", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			fglx: "职务编码", 
			ormdutyname: "职务名称", 
			zwlb: "层级", 
			nx: "建议交流年限", 
			bxjlnx: "必须交流年限", 
			ormdutyid: "职务标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			fglx: "职务编码",
			ormdutyname: "职务名称",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormdutyname_like: "职务名称", 
			n_fglx_like: "职务编码", 
			n_zwlb_like: "层级", 
		},
		uiactions: {
		},
	},
	wcjsearchform_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormdutyname_like: "职务名称", 
			n_fglx_like: "职务编码", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
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