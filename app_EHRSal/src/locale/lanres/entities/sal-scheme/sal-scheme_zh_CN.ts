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
};