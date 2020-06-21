export default {
  fields: {
    updateman: "更新人",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    salstdzxname: "专项津贴标准名称",
    memo: "备注",
    salstdzxid: "专项津贴标准标识",
    createman: "建立人",
    bz: "补贴标准",
    updatedate: "更新时间",
    qy: "区域",
    ormorgname: "组织",
    ormdutyname: "职务",
    ormdutyid: "职务管理标识",
    ormorgid: "组织标识",
  },
	views: {
		editview: {
			caption: "专项津贴标准",
      		title: "专项津贴标准编辑视图",
		},
		gridview: {
			caption: "专项津贴标准",
      		title: "专项津贴标准表格视图",
		},
	},
	main_form: {
		details: {
			group1: "专项津贴标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "专项津贴标准标识", 
			srfmajortext: "专项津贴标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			ormdutyname: "职务", 
			qy: "区域", 
			bz: "补贴标准", 
			memo: "备注", 
			ormdutyid: "职务管理标识", 
			ormorgid: "组织标识", 
			salstdzxid: "专项津贴标准标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			ormdutyname: "职务",
			qy: "区域",
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
};