
export default {
  fields: {
    jbgzbl: "基本工资比例(%)",
    bz: "工资总额",
    enable: "逻辑有效标志",
    dj: "工资档级",
    salstdgwgzid: "岗位工资标准标识",
    createdate: "建立时间",
    createman: "建立人",
    salstdgwgzname: "岗位工资标准名称",
    updatedate: "更新时间",
    updateman: "更新人",
    jxgzbl: "绩效工资比例(%)",
    ormorgname: "组织",
    ormdutyname: "职务",
    ormdutyid: "职务管理标识",
    ormorgid: "组织标识",
  },
	views: {
		gridview: {
			caption: "岗位工资标准",
      		title: "岗位工资标准表格视图",
		},
		editview: {
			caption: "岗位工资标准",
      		title: "岗位工资标准编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "岗位工资标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位工资标准标识", 
			srfmajortext: "岗位工资标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgname: "组织", 
			ormdutyname: "职务", 
			dj: "工资档级", 
			bz: "工资总额", 
			jbgzbl: "基本工资比例(%)", 
			jxgzbl: "绩效工资比例(%)", 
			ormdutyid: "职务管理标识", 
			ormorgid: "组织标识", 
			salstdgwgzid: "岗位工资标准标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			ormdutyname: "职务",
			dj: "工资档级",
			bz: "工资总额",
			jbgzbl: "基本工资比例(%)",
			jxgzbl: "绩效工资比例(%)",
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