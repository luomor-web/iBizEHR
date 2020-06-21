
export default {
  fields: {
    reason: "拒绝原因",
    pimlanguageabilityid: "语言能力标识",
    updatedate: "更新时间",
    jlglbh: "记录管理编号",
    enable: "逻辑有效标志",
    wydjhqsj: "外语等级获取时间",
    fj: "附件",
    wyyz: "语种",
    jlczz: "记录操作者",
    bz: "备注",
    spstate: "审批状态",
    jlss: "记录所属",
    createman: "建立人",
    orgsectorid: "部门ID",
    updateman: "更新人",
    orgid: "组织ID",
    wydj: "外语等级",
    createdate: "建立时间",
    pimlanguageabilityname: "语种",
    jlspzt: "记录审批状态",
    ormorgsectorid: "部门标识",
    ygbh: "员工编号",
    pimpersonname: "员工姓名",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		gryynlgridview: {
			caption: "语言能力",
      		title: "语言能力表格视图",
		},
		greditview: {
			caption: "语言能力",
      		title: "语言能力编辑视图",
		},
	},
	main_2_form: {
		details: {
			group1: "语言能力信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "语言能力标识", 
			srfmajortext: "语种", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimlanguageabilityname: "语种", 
			wydj: "外语等级", 
			wydjhqsj: "外语等级获取时间", 
			bz: "备注", 
			pimpersonid: "人员信息标识", 
			jlss: "记录所属", 
			fj: "附件", 
			pimlanguageabilityid: "语言能力标识", 
		},
		uiactions: {
		},
	},
	main_language_grid: {
		columns: {
			wyyz: "语种",
			wydj: "外语等级",
			wydjhqsj: "外语等级获取时间",
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
	gryynlgridviewtoolbar2_toolbar: {
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
	gryynlgridviewtoolbar_toolbar: {
		tbitem1_custremove: {
			caption: "删除",
			tip: "删除",
		},
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
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
};