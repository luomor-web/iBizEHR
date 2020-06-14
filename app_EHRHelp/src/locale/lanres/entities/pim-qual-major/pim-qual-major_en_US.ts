
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
		gridview: {
			caption: "执业资格专业",
      title: '执业资格专业',
		},
		pickupgridview: {
			caption: "执业资格专业",
      title: '执业资格专业选择表格视图',
		},
		pickupview: {
			caption: "执业资格专业",
      title: '执业资格专业数据选择视图',
		},
		editview: {
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
			qualevel: "级别",
			pimqualmajorname: "执业资格",
			quamajor: "专业",
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
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
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
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
};