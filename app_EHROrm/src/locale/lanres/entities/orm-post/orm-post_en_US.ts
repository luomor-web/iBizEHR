
export default {
  fields: {
    createman: "建立人",
    lgnx: "轮岗年限",
    bxjlnx: "必须交流年限",
    istemp: "是否临时数据",
    updatedate: "更新时间",
    gwtype: "岗位类型",
    qzlgnx: "强制轮岗年限",
    postnature: "岗位性质",
    iskeypostion: "是否关键岗位",
    xh: "排序号",
    ormpostid: "岗位标识",
    nx: "建议交流年限",
    orgid: "组织ID",
    isconfidential: "是否保密岗",
    updateman: "更新人",
    ormpostname: "岗位名称",
    gwfl: "岗位分类",
    startstopsign: "启用标识",
    createdate: "建立时间",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		nrgwpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		mpickupview: {
			caption: "岗位",
      		title: "岗位管理数据多项选择视图",
		},
		gwxhwheditview: {
			caption: "岗位集设置",
      		title: "岗位集设置",
		},
		editview2: {
			caption: "岗位",
      		title: "岗位管理编辑视图",
		},
		gwbzxzmpickupview: {
			caption: "岗位库",
      		title: "岗位库",
		},
		pickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		gwxhwhgridview: {
			caption: "岗位设置",
      		title: "岗位设置",
		},
		jzbgwpickupview: {
			caption: "局总部岗位",
      		title: "局总部岗位",
		},
		pickupgridview: {
			caption: "岗位",
      		title: "岗位管理选择表格视图",
		},
		editview: {
			caption: "岗位设置",
      		title: "岗位设置",
		},
		xjgridview: {
			caption: "岗位设置",
      		title: "岗位设置",
		},
		orgidpickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		gridview: {
			caption: "岗位设置",
      		title: "岗位设置",
		},
		fpxxpickupview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		fpxxpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		ejormorgidpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		redirectview: {
			caption: "岗位",
      		title: "岗位管理数据重定向视图",
		},
		nrgwpickupview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		ejormorgidpickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		orgidpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		jzbgwpickupgridview: {
			caption: "局总部岗位",
      		title: "局总部岗位",
		},
		gwbzxzpickupgridview: {
			caption: "岗位库",
      		title: "岗位库",
		},
	},
	gwgl_form: {
		details: {
			group1: "岗位维护", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位标识", 
			srfmajortext: "岗位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序", 
			ormorgid: "组织标识", 
			ormorgname: "组织", 
			gwtype: "岗位类型", 
			lgnx: "轮岗年限", 
			isconfidential: "是否保密岗", 
			qzlgnx: "强制轮岗年限", 
			ormpostid: "岗位标识", 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: "岗位设置", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位标识", 
			srfmajortext: "岗位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序", 
			ormorgid: "组织标识", 
			ormorgname: "组织", 
			gwtype: "岗位类型", 
			ormpostname: "岗位名称", 
			nx: "建议交流年限", 
			bxjlnx: "必须交流年限", 
			isconfidential: "是否保密岗", 
			postnature: "岗位性质", 
			iskeypostion: "是否关键岗位", 
			startstopsign: "启用标识", 
			gwfl: "岗位分类", 
			ormpostid: "岗位标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			ormpostname: "岗位名称",
			gwfl: "岗位分类",
			nx: "建议交流年限",
			bxjlnx: "必须交流年限",
			isconfidential: "是否保密岗",
			postnature: "岗位性质",
			iskeypostion: "是否关键岗位",
			startstopsign: "启用标识",
		},
		uiactions: {
		},
	},
	gwchoice_grid: {
		columns: {
			xh: "排序",
			ormpostname: "岗位名称",
			postnature: "岗位性质",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	gwgl_grid: {
		columns: {
			xh: "排序",
			ormpostname: "岗位名称",
			ormorgname: "组织",
			lgnx: "轮岗年限",
			isconfidential: "是否保密岗",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormpostname_like: "岗位集名称", 
			n_ormorgname_like: "组织名称", 
			n_startstopsign_eq: "启用标识", 
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
	gwxhwheditviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
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
	gwxhwhgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	xjgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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
};