
export default {
  fields: {
    grzlwzzzdpm: "个人在论文著作中的排名",
    jlglbh: "记录管理编号",
    updateman: "更新人",
    jlczz: "记录操作者",
    pimpaperid: "论文信息标识",
    jlspzt: "审批状态",
    reason: "拒绝原因",
    createdate: "建立时间",
    updatedate: "更新时间",
    kwmc: "刊物名称(*)",
    fj: "附件",
    createman: "建立人",
    fbsj: "发表时间(*)",
    orgid: "部门ID",
    pimpapername: "论文名称(*)",
    kwqs: "刊物期数",
    cbs: "出版社(*)",
    orgsectorid: "部门ID",
    cbshkwmc: "出版社或刊物名称",
    jlss: "记录所属",
    enable: "逻辑有效标志",
    ygbh: "员工编号",
    ormorgid: "组织标识",
    pimpersonname: "员工姓名",
    ormorgsectorid: "部门标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		grpapergridview: {
			caption: "论文信息",
      		title: "论文信息表格视图",
		},
		greditview: {
			caption: "论文信息",
      		title: "论文信息编辑视图",
		},
	},
	greditform_form: {
		details: {
			group1: "论文信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "论文信息标识", 
			srfmajortext: "论文名称(*)", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpapername: "论文名称", 
			cbshkwmc: "出版社或刊物名称", 
			fbsj: "发表时间(*)", 
			grzlwzzzdpm: "个人在论文著作中的排名", 
			pimpersonid: "人员信息标识", 
			fj: "附件", 
			jlss: "记录所属", 
			pimpaperid: "论文信息标识", 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			pimpapername: "论文名称(*)",
			cbs: "出版社(*)",
			kwmc: "刊物名称(*)",
			kwqs: "刊物期数",
			fbsj: "发表时间(*)",
			grzlwzzzdpm: "个人在论文著作中的排名",
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
	grpapergridviewtoolbar2_toolbar: {
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
	grpapergridviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "Help",
			tip: "Help",
		},
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
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