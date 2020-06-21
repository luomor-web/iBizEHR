
export default {
  fields: {
    updatedate: "更新时间",
    createdate: "建立时间",
    xh: "排序号",
    numcompilation: "人数编制",
    ormdepestmanname: "部门编制管理名称",
    updateman: "更新人",
    createman: "建立人",
    ormdepestmanid: "部门编制管理标识",
    zwzzsm: "职务职责说明",
    ormdutyname: "职务",
    ormzwbzmc: "职务编制",
    ormzwbzid: "职务编制ID",
    ormdutyid: "职务ID",
  },
	views: {
		gridview: {
			caption: "部门职务编制",
      		title: "部门编制管理表格视图",
		},
		redirectview: {
			caption: "部门职务编制",
      		title: "部门编制管理数据重定向视图",
		},
		zwgridview: {
			caption: "职务编制明细",
      		title: "职务编制明细",
		},
		pickupgridview: {
			caption: "部门职务编制",
      		title: "部门编制管理选择表格视图",
		},
		mpickupview: {
			caption: "部门职务编制",
      		title: "部门编制管理数据多项选择视图",
		},
		pickupview: {
			caption: "部门职务编制",
      		title: "部门编制管理数据选择视图",
		},
		editview2: {
			caption: "部门职务编制",
      		title: "部门编制管理编辑视图",
		},
		zweditview: {
			caption: "职务编制明细",
      		title: "职务编制明细",
		},
		editview: {
			caption: "部门职务编制",
      		title: "部门编制管理编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "部门编制信息", 
			grouppanel1: "职务编制明细", 
			grouppanel2: "岗位编制明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "部门编制管理标识", 
			srfmajortext: "部门编制管理名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormdepestmanid: "部门编制管理标识", 
		},
		uiactions: {
		},
	},
	zwbzmx_form: {
		details: {
			group1: "职务编制明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "部门编制管理标识", 
			srfmajortext: "部门编制管理名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormzwbzid: "职务编制ID", 
			ormzwbzmc: "职务编制", 
			xh: "排序号", 
			ormdutyname: "职务", 
			numcompilation: "人数编制", 
			ormdutyid: "职务ID", 
			ormdepestmanid: "部门编制管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
		},
		uiactions: {
		},
	},
	zwbzmx_grid: {
		columns: {
			ormdutyname: "职务",
			numcompilation: "人数编制",
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
	zwgridviewtoolbar2_toolbar: {
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
	zwgridviewtoolbar_toolbar: {
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
	zweditviewtoolbar_toolbar: {
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
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