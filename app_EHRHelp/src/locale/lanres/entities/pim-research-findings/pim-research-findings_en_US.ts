
export default {
  fields: {
    jlglbh: "记录管理编号",
    updateman: "更新人",
    pimresearchfindingsname: "科研成果名称",
    jlss: "记录所属",
    fj: "附件",
    jlspzt: "审批状态",
    orgsectorid: "部门ID",
    enable: "逻辑有效标志",
    hqsj: "获取时间",
    createdate: "建立时间",
    updatedate: "更新时间",
    createman: "建立人",
    orgid: "组织ID",
    reason: "拒绝原因",
    jlczz: "记录操作者",
    pimresearchfindingsid: "科研成果标识",
    ormorgsectorid: "部门标识",
    pimpersonname: "员工姓名",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		greditview: {
			caption: "科研成果",
      		title: "科研成果编辑视图",
		},
		grresearchgridview: {
			caption: "科研成果",
      		title: "科研成果表格视图",
		},
	},
	greditform_form: {
		details: {
			group1: "科研成果基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "科研成果标识", 
			srfmajortext: "科研成果名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimresearchfindingsname: "科研成果名称", 
			hqsj: "获取时间", 
			fj: "附件", 
			pimpersonid: "人员信息标识", 
			jlss: "记录所属", 
			pimresearchfindingsid: "科研成果标识", 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			pimresearchfindingsname: "科研成果名称(*)",
			hqsj: "获取时间(*)",
			fj: "附件",
			jlspzt: "审批状态",
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
	grresearchgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
		},
		deuiaction2: {
			caption: "提交",
			tip: "提交",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
	},
	grresearchgridviewtoolbar_toolbar: {
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction6: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
};