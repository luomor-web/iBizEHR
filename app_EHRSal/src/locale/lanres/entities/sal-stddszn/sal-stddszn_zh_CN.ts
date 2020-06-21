export default {
  fields: {
    createdate: "建立时间",
    createman: "建立人",
    sfdszn: "是否有独生子女证",
    salstddsznid: "独生子女标准标识",
    updateman: "更新人",
    salstddsznname: "独生子女标准名称",
    bz: "补贴标准",
    enable: "逻辑有效标志",
    updatedate: "更新时间",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		gridview: {
			caption: "独生子女标准",
      		title: "独生子女标准表格视图",
		},
		editview: {
			caption: "独生子女标准",
      		title: "独生子女标准编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "独生子女标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "独生子女标准标识", 
			srfmajortext: "独生子女标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			bz: "补贴标准", 
			ormorgid: "组织标识", 
			salstddsznid: "独生子女标准标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
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