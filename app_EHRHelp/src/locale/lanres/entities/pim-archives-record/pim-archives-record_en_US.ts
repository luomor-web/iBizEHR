
export default {
  fields: {
    pimarchivesrecordname: "档案目录缺失记录名称",
    enable: "逻辑有效标志",
    updatedate: "更新时间",
    memo: "备注",
    createman: "建立人",
    pimarchivesrecordid: "档案目录缺失记录标识",
    createdate: "建立时间",
    updateman: "更新人",
    pimarchivesname: "档案信息名称",
    serialnumber: "目录序号",
    archivalcataloguename: "档案目录名称",
    archivalcatalogueid: "档案目录标识",
    pimarchivesid: "档案信息标识",
  },
	views: {
		gridview: {
			caption: "档案目录缺失记录",
      		title: "档案目录缺失记录表格视图",
		},
		editview: {
			caption: "档案目录缺失记录",
      		title: "档案目录缺失记录编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "档案目录缺失记录基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "档案目录缺失记录标识", 
			srfmajortext: "档案目录缺失记录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			serialnumber: "目录序号", 
			archivalcataloguename: "档案目录名称", 
			memo: "备注", 
			pimarchivesrecordid: "档案目录缺失记录标识", 
			archivalcatalogueid: "档案目录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			serialnumber: "目录序号",
			archivalcataloguename: "档案目录名称",
			memo: "备注",
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
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
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