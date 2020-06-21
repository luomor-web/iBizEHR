export default {
  fields: {
    jsdj: "讲师等级",
    trmteacherchargeid: "讲师收费记录标识",
    dj: "单价",
    updateman: "更新人",
    createdate: "建立时间",
    trmteacherchargename: "讲师收费记录名称",
    enable: "逻辑有效标志",
    createman: "建立人",
    zfy: "总费用",
    xs: "学时",
    updatedate: "更新时间",
    trmtrainteachername: "讲师",
    trmtrainplantermname: "培训班",
    trmtrainplantermid: "培训计划项标识",
    trmtrainteacherid: "培训教师标识",
  },
	views: {
		mpickupview: {
			caption: "讲师收费记录",
      		title: "讲师收费记录数据多项选择视图",
		},
		pickupgridview: {
			caption: "讲师收费记录",
      		title: "讲师收费记录选择表格视图",
		},
		pickupview: {
			caption: "讲师收费记录",
      		title: "讲师收费记录数据选择视图",
		},
		editview: {
			caption: "讲师费用台账",
      		title: "讲师费用台账",
		},
		gridview: {
			caption: "讲师费用台账",
      		title: "讲师费用台账",
		},
	},
	main_form: {
		details: {
			group1: "讲师费用台账", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "讲师收费记录标识", 
			srfmajortext: "讲师收费记录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainplantermname: "培训班", 
			trmtrainteachername: "讲师", 
			jsdj: "讲师等级", 
			dj: "单价", 
			xs: "学时", 
			zfy: "总费用", 
			trmtrainteacherid: "培训教师标识", 
			trmteacherchargeid: "讲师收费记录标识", 
			trmtrainplantermid: "培训计划项标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrainplantermname: "培训班",
			trmtrainteachername: "讲师",
			jsdj: "讲师等级",
			dj: "单价",
			xs: "学时",
			zfy: "总费用",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_jsdj_eq: "讲师等级(=)", 
			n_trmtrainplantermname_eq: "培训班(=)", 
			n_trmtrainplantermname_like: "培训班(%)", 
			n_trmtrainplantermid_eq: "", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem5: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
	},
};