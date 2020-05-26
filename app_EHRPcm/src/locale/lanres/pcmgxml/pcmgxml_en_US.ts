
export default {
  fields: {
    nd: '年度',
    pcmgxmlid: '高校名录标识',
    createman: '建立人',
    xh: '排序号',
    updatedate: '更新时间',
    updateman: '更新人',
    xxxz: '学校性质',
    createdate: '建立时间',
    gxlb: '高校类型（停用）',
    nationarea: '国家或地区',
    pcmgxmlname: '高校名称',
  },
	views: {
		curndgridview: {
			caption: "高校名录",
      title: '高校名录',
		},
		gxmltreeexpview: {
			caption: "高校名录",
      title: '高校名录',
		},
		pickupgridview: {
			caption: "高校名录",
      title: '高校名录',
		},
		editview: {
			caption: "高校名录",
      title: '高校名录',
		},
		mpickupview: {
			caption: "高校名录",
      title: '高校名录',
		},
	},
	main_form: {
		details: {
			group1: "高校名录", 
			druipart1: "", 
			grouppanel1: "高校学科名录", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "高校名录标识", 
			srfmajortext: "高校名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			nd: "年度", 
			nationarea: "国家或地区", 
			pcmgxmlname: "高校名称", 
			xxxz: "学校性质", 
			pcmgxmlid: "高校名录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			nd: "年度",
			nationarea: "国家或地区",
			xxxz: "学校性质",
			pcmgxmlname: "高校名称",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_nationarea_like: "国家或地区(%)", 
			n_xxxz_eq: "学校性质(=)", 
			n_pcmgxmlname_like: "高校名称(%)", 
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
	gxmltree_treeview: {
		nodes: {
			root: '默认根节点',
		},
		uiactions: {
		},
	},
};