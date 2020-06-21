export default {
  fields: {
    cz: "操作",
    czdxmc: "操作对象的名称",
    jlbh: "记录编号",
    czdxbh: "操作对象的",
    sxsj: "生效时间",
    zt: "审批状态",
    fj: "附件信息",
    reason: "拒绝原因",
    bglx: "变更类型",
    orgsectorid: "部门ID",
    createman: "建立人",
    bz: "备注",
    pimpersonchangeid: "人员信息变更审核标识",
    createdate: "建立时间",
    updatedate: "更新时间",
    bgnr: "变更内容",
    bgsj: "变更时间",
    pimpersonchangename: "人员信息变更审核名称",
    sqsj: "申请时间",
    updateman: "更新人",
    orgid: "组织ID",
    pimpersonname: "员工姓名",
    ormorgid: "组织标识",
    ormorgsectorid: "部门标识",
    ygbh: "员工编号",
    pimpersonid: "人员信息标识",
  },
	views: {
		editview2: {
			caption: "人员信息变更审核",
      		title: "人员信息变更审核编辑视图",
		},
		gridview: {
			caption: "员工信息审核",
      		title: "员工信息审核表格视图",
		},
		editview: {
			caption: "员工信息审核",
      		title: "员工信息审核编辑视图",
		},
		hisrecgridview: {
			caption: "历史审核记录",
      		title: "历史审核记录",
		},
		reasoneditview: {
			caption: "驳回原因",
      		title: "驳回原因",
		},
		pickupgridview: {
			caption: "人员信息变更审核",
      		title: "人员信息变更审核选择表格视图",
		},
		readeditview: {
			caption: "员工信息审核记录",
      		title: "人员信息变更审核编辑视图",
		},
		pickupview: {
			caption: "人员信息变更审核",
      		title: "人员信息变更审核数据选择视图",
		},
		redirectview: {
			caption: "人员信息变更审核",
      		title: "人员信息变更审核数据重定向视图",
		},
		mpickupview: {
			caption: "人员信息变更审核",
      		title: "人员信息变更审核数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "人员变更信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "人员信息变更审核标识", 
			srfmajortext: "人员信息变更审核名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			ygbh: "员工编号", 
			pimpersonname: "员工姓名", 
			bglx: "变更类型", 
			bgnr: "变更内容", 
			sqsj: "申请时间", 
			sxsj: "生效时间", 
			bz: "备注", 
			ormorgid: "组织标识", 
			pimpersonchangeid: "人员信息变更审核标识", 
		},
		uiactions: {
		},
	},
	reasonedit_form: {
		details: {
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "人员信息变更审核标识", 
			srfmajortext: "人员信息变更审核名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			bglx: "变更类型", 
			bgnr: "变更内容", 
			reason: "拒绝原因", 
			pimpersonchangeid: "人员信息变更审核标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			bgnr: "变更内容",
			fj: "附件信息",
			bglx: "变更类型",
			sqsj: "申请时间",
			uagridcolumn1: "操作列",
		},
		uiactions: {
			refuse: "拒绝",
		},
	},
	hisrec_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			bgnr: "变更内容",
			fj: "附件信息",
			sqsj: "申请时间",
			bglx: "变更类型",
			reason: "拒绝原因",
			zt: "审批状态",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
			n_bglx_eq: "变更类型(=)", 
			n_zt_eq: "审批状态(=)", 
		},
		uiactions: {
		},
	},
	editview2toolbar_toolbar: {
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
	reasoneditviewtoolbar_toolbar: {
		tbitem1_ensure: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction2: {
			caption: "关闭",
			tip: "关闭",
		},
	},
	hisrecgridviewtoolbar_toolbar: {
		deuiaction6: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	readeditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1_qr: {
			caption: "同意",
			tip: "同意",
		},
		deuiaction1_hisrec: {
			caption: "历史审核记录",
			tip: "历史审核记录",
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
	editviewtoolbar_toolbar: {
		deuiaction2_qr: {
			caption: "同意",
			tip: "同意",
		},
		deuiaction2_bh: {
			caption: "拒绝",
			tip: "拒绝",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};