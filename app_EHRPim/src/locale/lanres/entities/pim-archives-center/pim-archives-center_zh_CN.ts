export default {
  fields: {
    cabinetno: "柜号",
    createman: "建立人",
    createdate: "建立时间",
    bnumber: "编号",
    updatedate: "更新时间",
    position: "档案存放位置",
    archivescenterid: "档案室管理标识",
    serialno: "排序号",
    memo: "备注",
    updateman: "更新人",
    archivescentername: "档案室名称",
    orgid: "组织ID",
    layerno: "层号",
    enable: "逻辑有效标志",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
  },
	views: {
		mpickupview: {
			caption: "档案室管理",
      		title: "档案室管理数据多项选择视图",
		},
		editview2: {
			caption: "档案室管理",
      		title: "档案室管理编辑视图",
		},
		pickupview: {
			caption: "档案室管理",
      		title: "档案室管理数据选择视图",
		},
		pickupgridview: {
			caption: "档案室管理",
      		title: "档案室管理选择表格视图",
		},
		editview: {
			caption: "档案室管理",
      		title: "档案室管理编辑视图",
		},
		redirectview: {
			caption: "档案室管理",
      		title: "档案室管理数据重定向视图",
		},
		gridview: {
			caption: "档案室管理",
      		title: "档案室管理表格视图",
		},
	},
	main_form: {
		details: {
			group1: "档案室管理基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "档案室管理标识", 
			srfmajortext: "档案存放位置", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			serialno: "排序号", 
			layerno: "层号", 
			archivescentername: "档案室名称", 
			cabinetno: "柜号", 
			bnumber: "编号", 
			memo: "备注", 
			ormorgid: "组织标识", 
			archivescenterid: "档案室管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			serialno: "排序号",
			archivescentername: "档案室名称",
			cabinetno: "柜号",
			layerno: "层号",
			bnumber: "编号",
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
	editview2toolbar_toolbar: {
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
			caption: "删除",
			tip: "删除",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "导出",
			tip: "导出",
		},
	},
};