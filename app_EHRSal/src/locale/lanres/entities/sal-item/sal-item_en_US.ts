
export default {
  fields: {
    enable: '逻辑有效标志',
    createdate: '建立时间',
    updatedate: '更新时间',
    createman: '建立人',
    updateman: '更新人',
    salitemname: '要素项',
    salitemid: '薪酬要素项标识',
    xh: '排序号',
    salsubjectname: '财务科目',
    salsubjectid: '财务科目标识',
  },
	views: {
		pickupgridview: {
			caption: "薪酬要素项",
      title: '薪酬要素项',
		},
		pickupview: {
			caption: "薪酬要素项",
      title: '薪酬要素项',
		},
		gridview: {
			caption: "薪酬要素项",
      title: '薪酬要素项',
		},
		editview: {
			caption: "薪酬要素项",
      title: '薪酬要素项',
		},
	},
	main_form: {
		details: {
			group1: "薪酬要素项信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬要素项标识", 
			srfmajortext: "要素项", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			salitemname: "要素项", 
			salsubjectname: "财务科目", 
			salsubjectid: "财务科目标识", 
			salitemid: "薪酬要素项标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			salitemname: "要素项",
			salsubjectname: "财务科目",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			grouppanel1: "", 
			formpage1: "常规条件", 
			n_salitemname_like: "要素项(%)", 
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
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
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