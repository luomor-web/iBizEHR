
export default {
  fields: {
    nd: '年度',
    createdate: '建立时间',
    pcmxkmlname: '学科名称',
    updateman: '更新人',
    pcmxkmlid: '学科目录标识',
    xh: '排序号',
    updatedate: '更新时间',
    createman: '建立人',
    xkml: '学科门类',
  },
	views: {
		pickupgridview: {
			caption: "学科目录",
      title: '学科目录',
		},
		xkmltreeexpview: {
			caption: "学科目录",
      title: '学科目录',
		},
		editview: {
			caption: "学科目录",
      title: '学科目录',
		},
		mpickupview: {
			caption: "学科目录",
      title: '学科目录',
		},
		curndgridview: {
			caption: "学科目录",
      title: '学科目录',
		},
	},
	main_form: {
		details: {
			group1: "学科名录信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "学科目录标识", 
			srfmajortext: "学科名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			xkml: "学科门类", 
			pcmxkmlname: "学科名称", 
			pcmxkmlid: "学科目录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			nd: "年度",
			xkml: "学科门类",
			pcmxkmlname: "学科名称",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_xkml_eq: "学科门类", 
			n_pcmxkmlname_like: "学科名称", 
			n_nd_eq: "年度", 
		},
		uiactions: {
		},
	},
	curndgridviewtoolbar2_toolbar: {
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
	curndgridviewtoolbar_toolbar: {
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
		deuiaction3: {
			caption: "导入",
			tip: "导入",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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
	xkmltree_treeview: {
		nodes: {
			root: '默认根节点',
		},
		uiactions: {
		},
	},
};