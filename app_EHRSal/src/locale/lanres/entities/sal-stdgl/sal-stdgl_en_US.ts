
export default {
  fields: {
    updateman: "更新人",
    bz: "补贴标准",
    createman: "建立人",
    jsgl: "结束年功工龄",
    salstdglname: "工龄工资标准名称",
    qsgl: "起始年功工龄",
    updatedate: "更新时间",
    salstdglid: "工龄工资标准标识",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		editview: {
			caption: "工龄工资标准",
      		title: "工龄工资标准编辑视图",
		},
		gridview: {
			caption: "工龄工资标准",
      		title: "工龄工资标准表格视图",
		},
	},
	main_form: {
		details: {
			group1: "工龄工资标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工龄工资标准标识", 
			srfmajortext: "工龄工资标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			qsgl: "起始年功工龄", 
			jsgl: "结束年功工龄", 
			bz: "补贴标准", 
			ormorgid: "组织标识", 
			salstdglid: "工龄工资标准标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			qsgl: "起始年功工龄",
			jsgl: "结束年功工龄",
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