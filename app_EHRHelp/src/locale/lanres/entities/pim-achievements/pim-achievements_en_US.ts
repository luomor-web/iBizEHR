
export default {
  fields: {
    evaluationunit: "考评单位",
    updateman: "更新人",
    khdf: "考核得分",
    createman: "建立人",
    qsrq: "起始日期",
    khjl: "考核结论",
    orgsectorid: "部门ID",
    updatedate: "更新时间",
    createdate: "建立时间",
    xmjb: "项目级别",
    jd: "季度",
    jsrq: "结束日期",
    dj: "档级",
    orgid: "组织ID",
    enable: "逻辑有效标志",
    pimachievementsname: "年度",
    pimachievementsid: "绩效信息标识",
    khlx: "绩效考核类型",
    yd: "月度",
    pimpersonname: "员工姓名",
    ygbh: "员工编号",
    ormorgid: "组织标识",
    ormorgsectorid: "部门标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		grpimjixgridview: {
			caption: "绩效信息",
      		title: "绩效信息表格视图",
		},
		editview: {
			caption: "绩效信息",
      		title: "绩效信息编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "绩效信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "绩效信息标识", 
			srfmajortext: "年度", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			pimpersonname: "员工姓名", 
			pimachievementsname: "年度", 
			khlx: "考核类型", 
			jd: "季度", 
			yd: "月度", 
			khdf: "考核得分", 
			khjl: "考核结论", 
			xmjb: "项目级别", 
			dj: "档级", 
			pimachievementsid: "绩效信息标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			khlx: "考核类型",
			pimachievementsname: "年度",
			jd: "季度",
			yd: "月度",
			khjl: "考核结论",
			evaluationunit: "考评单位",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
			n_khjl_eq: "考核结论(=)", 
			n_xmjb_eq: "项目级别(=)", 
			n_dj_eq: "档级(=)", 
		},
		uiactions: {
		},
	},
	grpimjixgridviewtoolbar_toolbar: {
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
};