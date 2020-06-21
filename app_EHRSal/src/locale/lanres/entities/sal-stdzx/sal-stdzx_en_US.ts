
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
};