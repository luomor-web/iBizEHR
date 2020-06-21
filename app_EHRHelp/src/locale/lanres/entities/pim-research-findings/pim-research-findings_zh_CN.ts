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
	grresearchgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "提交",
			tip: "提交",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
	},
	grresearchgridviewtoolbar_toolbar: {
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction6: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
	},
};