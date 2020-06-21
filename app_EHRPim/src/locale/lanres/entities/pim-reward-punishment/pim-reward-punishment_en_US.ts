
export default {
  fields: {
    createdate: "建立时间",
    reason: "拒绝原因",
    jlsj: "奖惩时间",
    jlczz: "记录操作者",
    updatedate: "更新时间",
    pimrewardpunishmentname: "奖惩名称",
    department: "授予单位",
    updateman: "更新人",
    bz: "备注",
    jlspzt: "记录审批状态",
    jlss: "记录所属",
    jlglbh: "记录管理编号",
    yxqjsrq: "影响期结束日期",
    jcjb: "奖惩级别",
    createman: "建立人",
    cfsj: "惩罚时间",
    jcje: "奖惩金额",
    spstate: "审批状态",
    enable: "逻辑有效标志",
    fj: "附件",
    orgid: "组织ID",
    lx: "奖惩分类",
    jcsj: "奖惩事件",
    csrq: "产生日期",
    pimrewardpunishmentid: "奖励惩罚标识",
    cflx: "惩罚类型",
    jclx: "奖励级别",
    orgsectorid: "部门ID",
    ormorgsectorid: "部门标识",
    ygbh: "员工编号",
    ormorgid: "组织标识",
    pimpersonname: "人员信息名称",
    pimpersonid: "人员信息标识",
  },
	views: {
		greditview: {
			caption: "奖惩信息",
      		title: "奖励惩罚编辑视图",
		},
		mpickupview: {
			caption: "奖惩信息",
      		title: "奖励惩罚数据多项选择视图",
		},
		honorgridview: {
			caption: "奖惩信息",
      		title: "荣誉奖励",
		},
		gridview: {
			caption: "奖惩信息",
      		title: "奖励惩罚表格视图",
		},
		pimjanglgridview: {
			caption: "奖惩信息",
      		title: "奖励惩罚表格视图",
		},
		pickupgridview: {
			caption: "奖惩信息",
      		title: "奖励惩罚选择表格视图",
		},
		editview: {
			caption: "奖惩信息",
      		title: "奖励惩罚编辑视图",
		},
		redirectview: {
			caption: "奖惩信息",
      		title: "奖励惩罚数据重定向视图",
		},
		grpimjanglgridview: {
			caption: "奖惩信息",
      		title: "奖励惩罚表格视图",
		},
		pickupview: {
			caption: "奖惩信息",
      		title: "奖励惩罚数据选择视图",
		},
		editview2: {
			caption: "奖惩信息",
      		title: "奖励惩罚编辑视图",
		},
	},
	main_form: {
		details: {
			grouppanel3: "惩罚信息", 
			group1: "奖励惩罚基本信息", 
			grouppanel1: "", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "奖励惩罚标识", 
			srfmajortext: "奖惩名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			lx: "奖惩分类", 
			pimrewardpunishmentname: "奖惩名称", 
			jcjb: "奖惩级别", 
			jcje: "奖惩金额", 
			jlsj: "奖惩时间", 
			department: "授予单位", 
			cflx: "惩罚类型", 
			yxqjsrq: "影响期结束日期", 
			jlss: "记录所属", 
			jlczz: "记录操作者", 
			jcsj: "奖惩事件", 
			bz: "备注", 
			fj: "附件", 
			pimrewardpunishmentid: "奖励惩罚标识", 
		},
		uiactions: {
		},
	},
	main_2_form: {
		details: {
			grouppanel2: "奖励信息", 
			grouppanel3: "惩罚信息", 
			group1: "奖励惩罚基本信息", 
			grouppanel1: "", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "奖励惩罚标识", 
			srfmajortext: "奖惩名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			lx: "奖惩分类", 
			pimrewardpunishmentname: "奖惩名称", 
			jcjb: "奖惩级别", 
			jlsj: "奖惩时间", 
			jcje: "奖惩金额", 
			department: "授予单位", 
			cflx: "惩罚类型", 
			yxqjsrq: "影响期结束日期", 
			jlss: "记录所属", 
			jcsj: "奖惩事件", 
			bz: "备注", 
			fj: "附件", 
			pimrewardpunishmentid: "奖励惩罚标识", 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			jlsj: "奖惩时间",
			pimrewardpunishmentname: "名称",
			lx: "奖惩分类",
			department: "授予单位",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			jlsj: "获取时间",
			pimrewardpunishmentname: "名称",
			lx: "奖惩分类",
			department: "授予单位",
		},
		uiactions: {
		},
	},
	main_bonuspenalty_grid: {
		columns: {
			lx: "奖惩分类",
			jcjb: "奖惩级别",
			jlsj: "奖惩时间",
			jcsj: "奖惩事件",
			jlspzt: "审批状态",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
			n_lx_eq: "奖惩分类(=)", 
		},
		uiactions: {
		},
	},
	honorgridviewtoolbar_toolbar: {
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
	pimjanglgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
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
	greditviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
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
	grpimjanglgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
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