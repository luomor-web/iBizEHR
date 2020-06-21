
export default {
  fields: {
    updatedate: "更新时间",
    bz: "补贴标准",
    createman: "建立人",
    salstdgwid: "高温津贴标准标识",
    updateman: "更新人",
    jssj: "结束时间",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    salstdgwname: "高温津贴标准名称",
    qssj: "起始时间",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		editview: {
			caption: "高温津贴标准",
      		title: "高温津贴标准编辑视图",
		},
		gridview: {
			caption: "高温津贴标准",
      		title: "高温津贴标准表格视图",
		},
	},
	main_form: {
		details: {
			group1: "高温津贴标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "高温津贴标准标识", 
			srfmajortext: "高温津贴标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			qssj: "起始时间", 
			jssj: "结束时间", 
			bz: "补贴标准", 
			ormorgid: "组织标识", 
			salstdgwid: "高温津贴标准标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			qssj: "起始时间",
			jssj: "结束时间",
			bz: "补贴标准",
			updateman: "更新人",
			updatedate: "更新时间",
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
};