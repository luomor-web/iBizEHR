
export default {
  fields: {
    createdate: "建立时间",
    saltype: "薪酬类型",
    memo: "备注",
    updatedate: "更新时间",
    createman: "建立人",
    enable: "逻辑有效标志",
    salschemename: "工资单名称",
    updateman: "更新人",
    salschemeid: "工资单标识",
    validflag: "是否启用",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		pickupview: {
			caption: "工资单",
      		title: "薪酬方案数据选择视图",
		},
		editview: {
			caption: "工资单",
      		title: "薪酬方案编辑视图",
		},
		mpickupview: {
			caption: "工资单",
      		title: "薪酬方案数据多项选择视图",
		},
		gridview: {
			caption: "工资单",
      		title: "薪酬方案表格视图",
		},
		pickupgridview: {
			caption: "工资单",
      		title: "薪酬方案选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "工资单信息", 
			druipart1: "", 
			grouppanel1: "工资单要素项", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工资单标识", 
			srfmajortext: "工资单名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salschemename: "工资单名称", 
			ormorgname: "组织", 
			saltype: "薪酬类型", 
			validflag: "是否启用", 
			memo: "备注", 
			ormorgid: "组织标识", 
			salschemeid: "工资单标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salschemename: "工资单名称",
			ormorgname: "组织",
			saltype: "薪酬类型",
			validflag: "是否启用",
			memo: "备注",
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