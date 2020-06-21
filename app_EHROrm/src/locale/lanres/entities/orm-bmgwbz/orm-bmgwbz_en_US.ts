
export default {
  fields: {
    gwzzsm: "岗位职责说明",
    updateman: "更新人",
    ormbmgwbzid: "部门岗位编制标识",
    createdate: "建立时间",
    createman: "建立人",
    xh: "排序号",
    updatedate: "更新时间",
    numcompilation: "人数编制",
    ormbmgwbzname: "部门岗位编制名称",
    ormpostname: "岗位",
    ormgwbzmc: "岗位编制",
    ormpostid: "岗位ID",
    ormgwbzid: "岗位编制ID",
  },
	views: {
		pickupgridview: {
			caption: "部门岗位编制",
      		title: "部门岗位编制选择表格视图",
		},
		redirectview: {
			caption: "部门岗位编制",
      		title: "部门岗位编制数据重定向视图",
		},
		editview2: {
			caption: "部门岗位编制",
      		title: "部门岗位编制编辑视图",
		},
		pickupview: {
			caption: "部门岗位编制",
      		title: "部门岗位编制数据选择视图",
		},
		editview: {
			caption: "岗位编制明细",
      		title: "岗位编制明细",
		},
		mpickupview: {
			caption: "部门岗位编制",
      		title: "部门岗位编制数据多项选择视图",
		},
		gridview: {
			caption: "岗位编制明细",
      		title: "岗位编制明细",
		},
	},
	main_form: {
		details: {
			group1: "岗位编制明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "部门岗位编制标识", 
			srfmajortext: "部门岗位编制名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormpostid: "岗位ID", 
			ormgwbzid: "岗位编制ID", 
			ormgwbzmc: "岗位编制", 
			xh: "排序号", 
			ormpostname: "岗位", 
			numcompilation: "人数编制", 
			gwzzsm: "岗位职责说明", 
			ormbmgwbzid: "部门岗位编制标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormpostname: "岗位",
			numcompilation: "人数编制",
			gwzzsm: "岗位职责说明",
			createman: "建立人",
			createdate: "建立时间",
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