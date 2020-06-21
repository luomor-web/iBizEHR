
export default {
  fields: {
    bz: "标准额",
    updatedate: "更新时间",
    createman: "建立人",
    sitemtype: "要素项类型",
    createdate: "建立时间",
    salschemeitemname: "工资单要素项名称",
    memo: "备注",
    updateman: "更新人",
    enable: "逻辑有效标志",
    gs: "公式",
    salschemeitemid: "工资单要素项标识",
    sitemadd: "增/减",
    xh: "排序号",
    salschemename: "工资单名称",
    salrulename: "薪酬规则",
    salitemname: "要素项",
    salschemeid: "工资单标识",
    salruleid: "薪酬规则标识",
    salitemid: "薪酬要素项标识",
    xh2: "排序号",
  },
	views: {
		pickupview: {
			caption: "工资单要素项",
      		title: "方案要素项数据选择视图",
		},
		pickupgridview: {
			caption: "工资单要素项",
      		title: "方案要素项选择表格视图",
		},
		gridview: {
			caption: "工资单要素项",
      		title: "方案要素项表格视图",
		},
		editview: {
			caption: "工资单要素项",
      		title: "方案要素项编辑视图",
		},
	},
	main_form: {
		details: {
			grouppanel1: "", 
			group1: "方案要素项", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工资单要素项标识", 
			srfmajortext: "要素项", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			salitemname: "要素项", 
			sitemadd: "增/减", 
			sitemtype: "要素项类型", 
			bz: "标准额", 
			salrulename: "薪酬规则", 
			gs: "公式", 
			memo: "备注", 
			salschemeid: "工资单标识", 
			salitemid: "薪酬要素项标识", 
			salruleid: "薪酬规则标识", 
			salschemeitemid: "工资单要素项标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh2: "排序号",
			salitemname: "要素项",
			sitemtype: "要素项类型",
			salrulename: "薪酬规则",
			gs: "公式",
			sitemadd: "增/减",
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