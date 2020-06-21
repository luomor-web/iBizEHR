
export default {
  fields: {
    enable: "逻辑有效标志",
    createman: "建立人",
    createdate: "建立时间",
    vacleacetypeid: "休假类型管理标识",
    updatedate: "更新时间",
    typecode: "休假类型代码",
    vacleacetypename: "休假类型管理名称",
    updateman: "更新人",
  },
	views: {
		gridview: {
			caption: "休假类型",
      		title: "休假类型管理表格视图",
		},
		editview: {
			caption: "休假类型",
      		title: "休假类型管理编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "休假类型信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "休假类型管理标识", 
			srfmajortext: "休假类型管理名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			vacleacetypeid: "标识码", 
			typecode: "休假类型代码", 
			vacleacetypename: "休假类型名称", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			typecode: "休假类型代码",
			vacleacetypename: "休假类型名称",
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
};