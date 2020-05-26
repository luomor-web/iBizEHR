
export default {
  fields: {
    yybm: '原因编码',
    createman: '建立人',
    pcmprofilespyyname: '应聘者审批原因名称',
    updatedate: '更新时间',
    pcmprofilespyyid: '应聘者审批原因标识',
    createdate: '建立时间',
    updateman: '更新人',
    yymc: '原因名称',
  },
	views: {
		gridview: {
			caption: "应聘者审批原因",
      title: '应聘者审批原因',
		},
		editview: {
			caption: "应聘者审批原因",
      title: '应聘者审批原因',
		},
	},
	main_form: {
		details: {
			group1: "应聘者审批原因基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "应聘者审批原因标识", 
			srfmajortext: "应聘者审批原因名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			yybm: "原因编码", 
			yymc: "原因名称", 
			pcmprofilespyyid: "应聘者审批原因标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			yybm: "原因编码",
			yymc: "原因名称",
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
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
		deuiaction3: {
			caption: "导入",
			tip: "导入",
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