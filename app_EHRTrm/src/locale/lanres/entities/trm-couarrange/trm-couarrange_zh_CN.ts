export default {
  fields: {
    pj: "评价",
    trmcouarrangeid: "课程安排标识",
    createman: "建立人",
    updatedate: "更新时间",
    ckzl: "参考资料",
    skksrq: "授课开始日期",
    kcxs: "课程学时",
    skjssj: "授课结束时间",
    trmcouarrangename: "课程安排名称",
    updateman: "更新人",
    skkssj: "授课开始时间",
    ybzs: "预备知识",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    kcnr: "课程内容",
    trmtrainagencyname: "培训机构",
    trmtrainplantermname: "班级",
    trmtrainactapplyname: "培训活动申请名称",
    trmtrainaddressname: "培训场地",
    trmtrianpersonname: "参培人员",
    trmtraincoursename: "课程",
    trmcoursesystemname: "名称",
    trmtrainfaciesname: "会议室",
    trmtrainteachername: "讲师",
    trmagencyrecordname: "培训记录",
    trmtrianpersonid: "培训人员标识",
    trmtrainteacherid: "培训教师标识",
    trmtrainfaciesid: "培训设施标识",
    trmtrainagencyid: "培训机构标识",
    trmtrainplantermid: "培训计划项标识",
    trmtrainactapplyid: "培训活动申请标识",
    trmtrainaddressid: "培训地点标识",
    trmagencyrecordid: "机构培训记录标识",
    trmtraincourseid: "培训课程标识",
    trmcoursesystemid: "课程体系标识",
  },
	views: {
		editview: {
			caption: "培训记录",
      		title: "培训记录",
		},
		gridview: {
			caption: "培训记录",
      		title: "课程安排表格视图",
		},
		pxjggridview: {
			caption: "培训记录",
      		title: "课程安排表格视图",
		},
	},
	main_form: {
		details: {
			grouppanel1: "培训记录", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "课程安排标识", 
			srfmajortext: "课程安排名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainplantermname: "班级", 
			trmtraincoursename: "课程", 
			trmtrainagencyname: "培训机构", 
			trmtrainaddressname: "培训场地", 
			trmtrainteachername: "讲师", 
			skkssj: "授课开始时间", 
			skjssj: "授课结束时间", 
			pj: "评价", 
			trmtrainaddressid: "培训地点标识", 
			trmtrainagencyid: "培训机构标识", 
			trmtraincourseid: "培训课程标识", 
			trmtrainteacherid: "培训教师标识", 
			trmcouarrangeid: "课程安排标识", 
			trmtrainplantermid: "培训计划项标识", 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			trmtrainplantermname: "班级",
			trmtraincoursename: "课程",
			trmtrainaddressname: "培训场地",
			skkssj: "培训开始时间",
			skjssj: "培训结束时间",
			pj: "评价",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrainplantermname: "班级",
			trmtraincoursename: "课程",
			trmtrainagencyname: "培训机构",
			trmtrainaddressname: "培训场地",
			trmtrainteachername: "讲师",
			skkssj: "授课开始时间",
			skjssj: "授课结束时间",
			pj: "评价",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainplantermname_like: "班级(%)", 
			n_trmtraincoursename_like: "课程(%)", 
			n_trmtrainfaciesname_like: "会议室(%)", 
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
	pxjggridviewtoolbar_toolbar: {
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