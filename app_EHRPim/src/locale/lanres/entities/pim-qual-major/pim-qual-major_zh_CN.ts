export default {
  fields: {
    createman: "建立人",
    gwzs: "岗位类型",
    gwtype: "岗位类型",
    zyjszw: "专业技术职务",
    createdate: "建立时间",
    quamajor: "专业",
    gwlx: "岗位类型",
    orgid: "组织ID",
    enable: "逻辑有效标志",
    qualevel: "级别",
    updatedate: "更新时间",
    updateman: "更新人",
    pimqualmajorid: "执业资格专业编码",
    zyzgzy: "执业资格名称",
    pimqualmajorname: "执业资格",
    professionaltype: "执业资格类别",
    pimqualtypename: "执业资格类别",
    ormorgid: "组织标识",
    pimqualtypeid: "执业资格类别标识",
  },
	views: {
		mpickupview: {
			caption: "执业资格专业",
      		title: "执业资格专业数据多项选择视图",
		},
		editview2: {
			caption: "执业资格专业",
      		title: "执业资格专业编辑视图",
		},
		pickupview: {
			caption: "执业资格专业",
      		title: "执业资格专业数据选择视图",
		},
		pickupgridview: {
			caption: "执业资格专业",
      		title: "执业资格专业选择表格视图",
		},
		selgridview: {
			caption: "执业资格专业",
      		title: "执业资格专业表格视图",
		},
		editview: {
			caption: "执业资格专业",
      		title: "执业资格专业",
		},
		redirectview: {
			caption: "执业资格专业",
      		title: "执业资格专业数据重定向视图",
		},
		gridview: {
			caption: "执业资格专业",
      		title: "执业资格专业",
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
	selgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
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
			caption: "删除",
			tip: "删除",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "导出",
			tip: "导出",
		},
	},
};