
export default {
  fields: {
    createman: '建立人',
    gwzs: '岗位类型',
    gwtype: '岗位类型',
    zyjszw: '专业技术职务',
    createdate: '建立时间',
    quamajor: '专业',
    gwlx: '岗位类型',
    orgid: '组织ID',
    enable: '逻辑有效标志',
    qualevel: '级别',
    updatedate: '更新时间',
    updateman: '更新人',
    pimqualmajorid: '执业资格专业编码',
    zyzgzy: '执业资格名称',
    pimqualmajorname: '执业资格',
    professionaltype: '执业资格类别',
    pimqualtypename: '执业资格类别',
    ormorgid: '组织标识',
    pimqualtypeid: '执业资格类别标识',
  },
	views: {
		mpickupview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		editview2: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		pickupview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		pickupgridview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		selgridview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		editview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		redirectview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		gridview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
	},
	main_form: {
		details: {
			group1: "执业资格专业", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "执业资格专业编码", 
			srfmajortext: "执业资格名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			gwlx: "岗位类型", 
			zyzgzy: "执业资格名称", 
			pimqualmajorname: "执业资格", 
			qualevel: "级别", 
			quamajor: "专业", 
			gwtype: "岗位类型", 
			gwzs: "岗位类型", 
			pimqualmajorid: "执业资格专业编码", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			zyzgzy: "执业资格名称",
			pimqualmajorname: "执业资格",
			qualevel: "级别",
			quamajor: "专业",
			gwzs: "岗位类型",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimqualmajorname_like: "执业资格(%)", 
		},
		uiactions: {
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
	selgridviewtoolbar_toolbar: {
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
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
	gridviewtoolbar2_toolbar: {
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
		deuiaction6: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
};