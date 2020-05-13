
export default {
  fields: {
    zlh: '专利号(*)',
    updatedate: '更新时间',
    pimpatentid: '专利信息编码',
    orgid: '组织ID',
    jlss: '记录所属',
    orgsectorid: '部门ID',
    zlhqsj: '专利获取时间(*)',
    jlspzt: '审批状态',
    jlczz: '记录操作者',
    enable: '逻辑有效标志',
    pimpatentname: '专利名称(*)',
    updateman: '更新人',
    jlglbh: '记录管理编号',
    reason: '拒绝原因',
    createman: '建立人',
    enclolure: '附件',
    createdate: '建立时间',
    zlpzgb: '专利批准国别(*)',
    pimpersonname: '员工姓名',
    ygbh: '员工编号',
    ormorgsectorid: '部门标识',
    ormorgid: '组织标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		greditview: {
			caption: "专利信息",
      title: '专利信息',
		},
		mpickupview: {
			caption: "专利信息",
      title: '专利信息',
		},
		editview: {
			caption: "专利信息",
      title: '专利信息',
		},
		pickupview: {
			caption: "专利信息",
      title: '专利信息',
		},
		patentgridview: {
			caption: "专利信息",
      title: '专利信息',
		},
		gridview: {
			caption: "专利信息",
      title: '专利信息',
		},
		grpatentgridview: {
			caption: "专利信息",
      title: '专利信息',
		},
		pickupgridview: {
			caption: "专利信息",
      title: '专利信息',
		},
		redirectview: {
			caption: "专利信息",
      title: '专利信息',
		},
		editview2: {
			caption: "专利信息",
      title: '专利信息',
		},
	},
	main_form: {
		details: {
			group1: "专利信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "专利信息编码", 
			srfmajortext: "专利名称(*)", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			zlh: "专利号(*)", 
			pimpatentname: "专利名称(*)", 
			zlpzgb: "专利批准国别(*)", 
			zlhqsj: "专利获取时间(*)", 
			pimpersonid: "人员信息标识", 
			jlss: "记录所属", 
			enclolure: "附件", 
			pimpatentid: "专利信息编码", 
		},
		uiactions: {
		},
	},
	grpatenteditform_form: {
		details: {
			group1: "专利信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "专利信息编码", 
			srfmajortext: "专利名称(*)", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			zlh: "专利号(*)", 
			pimpatentname: "专利名称(*)", 
			zlpzgb: "专利批准国别(*)", 
			zlhqsj: "专利获取时间(*)", 
			pimpersonid: "人员信息标识", 
			jlss: "记录所属", 
			enclolure: "附件", 
			pimpatentid: "专利信息编码", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			zlh: "专利号(*)",
			pimpatentname: "专利名称(*)",
			zlhqsj: "专利获取时间(*)",
			zlpzgb: "专利批准国别(*)",
			enclolure: "附件",
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			zlh: "专利号(*)",
			pimpatentname: "专利名称(*)",
			zlhqsj: "专利获取时间(*)",
			zlpzgb: "专利批准国别(*)",
			enclolure: "附件",
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
	patentgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
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
	patentgridviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "Help",
			tip: "Help",
		},
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
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
	grpatentgridviewtoolbar2_toolbar: {
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
	grpatentgridviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "Help",
			tip: "Help",
		},
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
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