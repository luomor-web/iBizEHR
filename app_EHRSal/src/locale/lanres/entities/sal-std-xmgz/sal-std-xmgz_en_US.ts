
export default {
  fields: {
    dj: "工资档级",
    bz: "工资总额",
    updateman: "更新人",
    salstdxmgzid: "项目工资标准标识",
    createman: "建立人",
    xmjb: "项目级别",
    salstdxmgzname: "项目工资标准名称",
    jxgzbl: "绩效工资比例(%)",
    enable: "逻辑有效标志",
    updatedate: "更新时间",
    createdate: "建立时间",
    jbgzbl: "基本工资比例(%)",
    ormdutyname: "职务",
    ormorgname: "组织",
    ormorgid: "组织标识",
    ormdutyid: "职务管理标识",
  },
	views: {
		editview: {
			caption: "项目工资标准",
      		title: "项目工资标准编辑视图",
		},
		gridview: {
			caption: "项目工资标准",
      		title: "项目工资标准表格视图",
		},
	},
	main_form: {
		details: {
			group1: "项目工资标准信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "项目工资标准标识", 
			srfmajortext: "项目工资标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xmjb: "项目级别", 
			dj: "工资档级", 
			bz: "工资总额", 
			jbgzbl: "基本工资比例(%)", 
			jxgzbl: "绩效工资比例(%)", 
			ormdutyname: "职务", 
			ormorgname: "组织", 
			ormdutyid: "职务管理标识", 
			salstdxmgzid: "项目工资标准标识", 
			ormorgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			xmjb: "项目级别",
			ormdutyname: "职务",
			dj: "工资档级",
			bz: "工资总额",
			jbgzbl: "基本工资比例(%)",
			jxgzbl: "绩效工资比例(%)",
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