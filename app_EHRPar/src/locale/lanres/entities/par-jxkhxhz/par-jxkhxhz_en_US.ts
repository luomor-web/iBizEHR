
export default {
  fields: {
    xh: "排序号",
    updatedate: "更新时间",
    jswmjc: "月度计划",
    szmzpy: "集中述职评审",
    khlx: "考核对象",
    ywnlks: "工作周报",
    parjxkhxhzname: "绩效考核项得分汇总名称",
    createman: "建立人",
    zz: "所属组织",
    ygid: "员工ID",
    gznljtd: "工作能力及态度评价（上半年）",
    updateman: "更新人",
    gznljtd_xbn: "工作能力及态度评价",
    createdate: "建立时间",
    parjxkhxhzid: "绩效考核项得分汇总标识",
    gzjx: "量化目标",
    yg: "员工",
    bm: "部门",
    parassesstemplateid: "考核模板标识",
    parassesstemplatename: "考核模板名称",
    nd: "年度",
  },
	views: {
		ygkhxgridview: {
			caption: "考核方案",
      		title: "考核方案",
		},
		gridview: {
			caption: "考核方案",
      		title: "考核方案",
		},
		ygkhxeditview: {
			caption: "考核方案",
      		title: "考核方案",
		},
		pickupview: {
			caption: "考核方案",
      		title: "考核方案数据选择视图",
		},
		mpickupview: {
			caption: "考核方案",
      		title: "考核方案数据多项选择视图",
		},
		pickupgridview: {
			caption: "考核方案",
      		title: "考核方案选择表格视图",
		},
		editview: {
			caption: "考核方案",
      		title: "考核方案编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "被考核人信息", 
			grouppanel1: "考核模板信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "绩效考核项得分汇总标识", 
			srfmajortext: "绩效考核项得分汇总名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ygid: "员工ID", 
			xh: "排序号", 
			yg: "员工", 
			zz: "所属组织", 
			bm: "部门", 
			parassesstemplatename: "考核模板名称", 
			nd: "年度", 
			parjxkhxhzid: "绩效考核项得分汇总标识", 
			parassesstemplateid: "考核模板标识", 
		},
		uiactions: {
		},
	},
	ygkhx_form: {
		details: {
			group1: "考核方案信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "绩效考核项得分汇总标识", 
			srfmajortext: "绩效考核项得分汇总名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			parjxkhxhzname: "绩效考核项得分汇总名称", 
			ygid: "员工ID", 
			xh: "排序号", 
			khlx: "考核对象", 
			yg: "员工", 
			zz: "所属组织", 
			bm: "部门", 
			gzjx: "量化目标", 
			jswmjc: "月度计划", 
			ywnlks: "工作周报", 
			gznljtd: "工作能力及态度评价", 
			parjxkhxhzid: "绩效考核项得分汇总标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			yg: "员工",
			zz: "所属组织",
			bm: "部门",
			parassesstemplatename: "考核模板",
			nd: "年度",
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
	ygkhxgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
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
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	ygkhxeditviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
};