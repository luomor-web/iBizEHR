export default {
  fields: {
    nd: "年度",
    createdate: "建立时间",
    pcmxkmlname: "学科名称",
    updateman: "更新人",
    pcmxkmlid: "学科目录标识",
    xh: "排序号",
    updatedate: "更新时间",
    createman: "建立人",
    xkml: "学科门类",
  },
	views: {
		pickupgridview: {
			caption: "学科目录",
      		title: "学科目录选择表格视图",
		},
		xkmltreeexpview: {
			caption: "学科目录",
      		title: "学科目录树导航视图",
		},
		editview: {
			caption: "学科目录",
      		title: "学科目录编辑视图",
		},
		mpickupview: {
			caption: "学科目录",
      		title: "学科目录数据多项选择视图",
		},
		curndgridview: {
			caption: "学科目录",
      		title: "学科目录表格视图",
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
	curndgridviewtoolbar_toolbar: {
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
	xkmltree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};