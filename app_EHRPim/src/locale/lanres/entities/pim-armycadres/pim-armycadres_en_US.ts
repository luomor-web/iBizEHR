
export default {
  fields: {
    updatedate: "更新时间",
    pimarmycadresname: "军转干部名称",
    orgid: "组织ID",
    fj: "附件",
    jlss: "记录所属",
    jlspzt: "审批状态",
    createdate: "建立时间",
    orgsectorid: "部门ID",
    updateman: "更新人",
    trooptype: "类型(*)",
    leveltype: "级别(*)",
    fssj: "发生时间(*)",
    enable: "逻辑有效标志",
    reason: "拒绝原因",
    pimarmycadresid: "军转干部标识",
    createman: "建立人",
    jlczz: "记录操作者",
    jlglbh: "记录管理编号",
    ormorgid: "组织标识",
    pimpersonname: "员工姓名",
    ormorgsectorid: "部门标识",
    ygbh: "员工编号",
    pimpersonid: "人员信息标识",
  },
	views: {
		grarmygridview: {
			caption: "军转干部",
      		title: "军转干部表格视图",
		},
		gridview: {
			caption: "军转干部",
      		title: "军转干部表格视图",
		},
		pickupgridview: {
			caption: "军转干部",
      		title: "军转干部选择表格视图",
		},
		editview: {
			caption: "军转干部",
      		title: "军转干部编辑视图",
		},
		pickupview: {
			caption: "军转干部",
      		title: "军转干部数据选择视图",
		},
		redirectview: {
			caption: "军转干部",
      		title: "军转干部数据重定向视图",
		},
		editview2: {
			caption: "军转干部",
      		title: "军转干部编辑视图",
		},
		mpickupview: {
			caption: "军转干部",
      		title: "军转干部数据多项选择视图",
		},
		armygridview: {
			caption: "军转干部",
      		title: "军转干部表格视图",
		},
		greditview: {
			caption: "军转干部",
      		title: "军转干部编辑视图",
		},
	},
	admin_greditform_form: {
		details: {
			group1: "军转干部基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "军转干部标识", 
			srfmajortext: "军转干部名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			trooptype: "类型(*)", 
			leveltype: "级别(*)", 
			fssj: "发生时间(*)", 
			fj: "附件", 
			jlss: "记录所属", 
			pimarmycadresid: "军转干部标识", 
		},
		uiactions: {
		},
	},
	greditform_form: {
		details: {
			group1: "军转干部基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "军转干部标识", 
			srfmajortext: "军转干部名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			trooptype: "类型(*)", 
			leveltype: "级别(*)", 
			fssj: "发生时间(*)", 
			fj: "附件", 
			jlss: "记录所属", 
			pimarmycadresid: "军转干部标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trooptype: "类型(*)",
			leveltype: "级别(*)",
			fssj: "发生时间(*)",
			fj: "附件",
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			trooptype: "类型(*)",
			leveltype: "级别(*)",
			fssj: "发生时间(*)",
			fj: "附件",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
		},
		uiactions: {
		},
	},
	armygridviewtoolbar_toolbar: {
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
	grarmygridviewtoolbar_toolbar: {
		deuiaction2: {
			caption: "View",
			tip: "View {0}",
		},
	},
	greditviewtoolbar_toolbar: {
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
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
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