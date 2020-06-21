
export default {
  fields: {
    orgid: "组织ID",
    createdate: "建立时间",
    fj: "附件",
    enable: "逻辑有效标志",
    createman: "建立人",
    pimenclosureid: "附件信息标识",
    pimenclosurename: "附件信息名称",
    updateman: "更新人",
    fjfl: "附件分类",
    updatedate: "更新时间",
    fjlj: "附件路径",
    userstate: "USERSTATE",
    fjkz: "附件快照",
    orgsectorid: "部门ID",
    ormorgsectorid: "部门标识",
    pimpersonname: "人员信息名称",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		filepreviewcustomview: {
			caption: "附件预览",
      		title: "表格附件预览",
		},
		pickupgridview: {
			caption: "附件信息",
      		title: "附件信息选择表格视图",
		},
		pickupview: {
			caption: "附件信息",
      		title: "附件信息数据选择视图",
		},
		editview2: {
			caption: "附件信息",
      		title: "附件信息编辑视图",
		},
		pcmprofilefujgridview: {
			caption: "附件信息",
      		title: "应聘者附件预览",
		},
		redirectview: {
			caption: "附件信息",
      		title: "附件信息数据重定向视图",
		},
		editview: {
			caption: "附件信息",
      		title: "附件信息编辑视图",
		},
		pimfujgridview: {
			caption: "附件信息",
      		title: "附件信息表格视图",
		},
		mpickupview: {
			caption: "附件信息",
      		title: "附件信息数据多项选择视图",
		},
		gridview: {
			caption: "附件信息",
      		title: "附件信息表格视图",
		},
	},
	main_form: {
		details: {
			group1: "附件信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "附件信息标识", 
			srfmajortext: "附件信息名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			pimpersonname: "员工姓名", 
			pimenclosurename: "附件信息名称", 
			fjfl: "附件分类", 
			fjkz: "附件快照", 
			pimenclosureid: "附件信息标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimenclosurename: "附件信息名称",
			fjfl: "附件分类",
			updateman: "更新人",
			updatedate: "更新时间",
			fjkz: "附件快照",
		},
		uiactions: {
		},
	},
	ypzfjyl_grid: {
		columns: {
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_eq: "员工姓名", 
			n_fjfl_eq: "附件分类(=)", 
			n_pimpersonid_eq: "", 
		},
		uiactions: {
		},
	},
	editview2toolbar_toolbar: {
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	pcmprofilefujgridviewtoolbar_toolbar: {
		deuiaction2: {
			caption: "View",
			tip: "View {0}",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	pimfujgridviewtoolbar_toolbar: {
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
	gridviewtoolbar_toolbar: {
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
};