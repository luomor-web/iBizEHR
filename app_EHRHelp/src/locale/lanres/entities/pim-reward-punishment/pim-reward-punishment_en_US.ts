
export default {
  fields: {
    createdate: '建立时间',
    reason: '拒绝原因',
    jlsj: '奖惩时间',
    jlczz: '记录操作者',
    updatedate: '更新时间',
    pimrewardpunishmentname: '奖惩名称',
    department: '授予单位',
    updateman: '更新人',
    bz: '备注',
    jlspzt: '记录审批状态',
    jlss: '记录所属',
    jlglbh: '记录管理编号',
    yxqjsrq: '影响期结束日期',
    jcjb: '奖惩级别',
    createman: '建立人',
    cfsj: '惩罚时间',
    jcje: '奖惩金额',
    spstate: '审批状态',
    enable: '逻辑有效标志',
    fj: '附件',
    orgid: '组织ID',
    lx: '奖惩分类',
    jcsj: '奖惩事件',
    csrq: '产生日期',
    pimrewardpunishmentid: '奖励惩罚标识',
    cflx: '惩罚类型',
    jclx: '奖励级别',
    orgsectorid: '部门ID',
    ormorgsectorid: '部门标识',
    ygbh: '员工编号',
    ormorgid: '组织标识',
    pimpersonname: '人员信息名称',
    pimpersonid: '人员信息标识',
  },
	views: {
		grpimjanglgridview: {
			caption: "奖惩信息",
      title: '奖励惩罚表格视图',
		},
		greditview: {
			caption: "奖惩信息",
      title: '奖励惩罚编辑视图',
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
};