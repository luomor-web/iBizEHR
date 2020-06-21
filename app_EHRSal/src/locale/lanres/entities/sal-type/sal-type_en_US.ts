
export default {
  fields: {
    saltypeid: "薪酬类型标识",
    updateman: "更新人",
    saltypename: "薪酬类型名称",
    updatedate: "更新时间",
    enable: "逻辑有效标志",
    createman: "建立人",
    createdate: "建立时间",
  },
	views: {
		editview: {
			caption: "薪酬类型",
      		title: "薪酬类型编辑视图",
		},
		gridview: {
			caption: "薪酬类型",
      		title: "薪酬类型表格视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬类型信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬类型标识", 
			srfmajortext: "薪酬类型名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			saltypeid: "薪酬类型标识", 
			saltypename: "薪酬类型名称", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			saltypeid: "薪酬类型标识",
			saltypename: "薪酬类型名称",
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
};