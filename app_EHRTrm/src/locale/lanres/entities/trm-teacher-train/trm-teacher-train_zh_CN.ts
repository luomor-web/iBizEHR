export default {
  fields: {
    pj: "评价",
    createman: "建立人",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    updatedate: "更新时间",
    updateman: "更新人",
    trmteachertrainid: "讲师授课记录标识",
    jf: "积分",
    trmteachertrainname: "讲师授课记录",
    trmtraincoursename: "授课课程",
    trmtrainaddressname: "授课地点",
    trmtrainteachername: "授课讲师",
    trmtrainplantermname: "授课班级",
    pxjssj: "授课结束时间",
    pxsc: "授课时长",
    pxkssj: "授课开始时间",
    trmtrainplantermid: "培训计划项标识",
    trmtraincourseid: "培训课程标识",
    trmtrainteacherid: "培训教师标识",
    trmtrainaddressid: "培训地点标识",
  },
	views: {
		editview: {
			caption: "讲师授课记录",
      		title: "讲师授课记录编辑视图",
		},
		gridview: {
			caption: "讲师授课记录",
      		title: "讲师授课记录表格视图",
		},
	},
	main_form: {
		details: {
			group1: "讲师授课记录基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "讲师授课记录标识", 
			srfmajortext: "讲师授课记录", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainteacherid: "培训教师标识", 
			trmtrainteachername: "授课讲师", 
			pxkssj: "授课开始时间", 
			pxjssj: "授课结束时间", 
			trmtrainplantermname: "授课班级", 
			trmtraincoursename: "授课课程", 
			pxsc: "授课时长", 
			trmtrainaddressname: "授课地点", 
			jf: "积分", 
			pj: "评价", 
			trmtraincourseid: "培训课程标识", 
			trmtrainaddressid: "培训地点标识", 
			trmtrainplantermid: "培训计划项标识", 
			trmteachertrainid: "讲师授课记录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pxkssj: "授课开始时间",
			pxjssj: "授课结束时间",
			trmtrainplantermname: "授课班级",
			trmtraincoursename: "授课课程",
			pxsc: "授课时长",
			trmtrainaddressname: "授课地点",
			jf: "积分",
			pj: "评价",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainplantermname_like: "授课班级(%)", 
			n_trmtraincoursename_like: "授课课程(%)", 
			n_trmtrainaddressname_like: "授课地点(%)", 
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