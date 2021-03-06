
export default {
  fields: {
    fj: "附件",
    sfzgzc: "是否最高职称",
    createdate: "建立时间",
    updateman: "更新人",
    jlglbh: "记录管理编号",
    reviewbody: "评审单位",
    duration: "职称获取月数",
    zcdj: "职称等级",
    spstate: "审批状态",
    careername: "专业名称",
    orgsectorid: "部门ID",
    orgid: "组织ID",
    updatedate: "更新时间",
    jlspzt: "记录审批状态",
    pimtitleid: "职称信息标识",
    reason: "拒绝原因",
    pdjg: "评定机构",
    jlss: "记录所属",
    employtime: "职称聘用时间",
    enclosure: "附件",
    enable: "逻辑有效标志",
    zcbh: "证书编号",
    createman: "建立人",
    zchqrq: "职称获取日期",
    majorengaged: "专业类别",
    lssuingagency: "签发机构",
    pimtitlename: "职称信息名称",
    jlczz: "记录操作者",
    ormorgsectorid: "部门标识",
    pimpersonname: "员工姓名",
    pimtitlecataloguename: "职称名称",
    ygbh: "员工编号",
    ormorgname: "组织",
    ygzt: "员工状态",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
    pimtitlecatalogueid: "职称管理标识",
  },
	views: {
		greditview: {
			caption: "职称信息",
      		title: "职称信息编辑视图",
		},
		grpimzhicgridview: {
			caption: "职称信息",
      		title: "职称信息表格视图",
		},
	},
	main_2_form: {
		details: {
			group1: "职称信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "职称信息标识", 
			srfmajortext: "员工姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			pimtitlecataloguename: "职称名称", 
			zchqrq: "职称获取日期", 
			zcbh: "证书编号", 
			zcdj: "职称等级", 
			majorengaged: "专业类别", 
			careername: "专业名称", 
			lssuingagency: "签发机构", 
			reviewbody: "评审单位", 
			employtime: "职称聘用时间", 
			sfzgzc: "是否最高职称", 
			jlss: "记录所属", 
			fj: "附件", 
			pimtitlecatalogueid: "职称管理标识", 
			pimtitleid: "职称信息标识", 
		},
		uiactions: {
		},
	},
	main_title_grid: {
		columns: {
			pimtitlecataloguename: "职称名称",
			zcbh: "证书编号",
			zcdj: "职称等级",
			majorengaged: "专业类别",
			zchqrq: "职称获取日期",
			reviewbody: "评审单位",
			lssuingagency: "签发机构",
			employtime: "职称聘用时间",
			sfzgzc: "是否最高职称",
			jlspzt: "审批状态",
		},
		uiactions: {
		},
	},
	default_2_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ygbh_like: "员工编号(%)", 
			n_pimpersonname_like: "员工姓名", 
			n_pimtitlecataloguename_like: "职称名称(%)", 
			n_zcdj_eq: "职称等级(=)", 
			n_sfzgzc_eq: "是否最高职称(=)", 
		},
		uiactions: {
		},
	},
	grpimzhicgridviewtoolbar_toolbar: {
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