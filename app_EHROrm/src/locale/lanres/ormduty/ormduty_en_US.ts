
export default {
  fields: {
    ormdutyid: '职务标识',
    fglx: '职务编码',
    updateman: '更新人',
    updatedate: '更新时间',
    xh: '排序号',
    createman: '建立人',
    zwjb: '职务级别',
    createdate: '建立时间',
    dyzj: '对应职级',
    nx: '建议交流年限',
    zwlb: '层级',
    bxjlnx: '必须交流年限',
    ormdutyname: '职务',
  },
	views: {
		estmanpickupview: {
			caption: "职务库",
      title: '职务库',
		},
		gridview: {
			caption: "职务设置",
      title: '职务设置',
		},
		pickupview: {
			caption: "职务库",
      title: '职务库',
		},
		estmanpickupgridview: {
			caption: "职务库",
      title: '职务库',
		},
		orgsectorpickupgridview: {
			caption: "职务库",
      title: '职务库',
		},
		mpickupview: {
			caption: "职务库",
      title: '职务库',
		},
		orgsectorpickupview: {
			caption: "职务库",
      title: '职务库',
		},
		redirectview: {
			caption: "职务管理",
      title: '职务管理',
		},
		estmanmpickupview: {
			caption: "职务库",
      title: '职务库',
		},
		editview2: {
			caption: "职务管理",
      title: '职务管理',
		},
		ormorgsectorpickupview: {
			caption: "职务库",
      title: '职务库',
		},
		ormorgsectorpickupgridview: {
			caption: "职务库",
      title: '职务库',
		},
		editview: {
			caption: "职务设置",
      title: '职务设置',
		},
		pickupgridview: {
			caption: "职务库",
      title: '职务库',
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
			zwlb: "层级",
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
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
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
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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