
export default {
  fields: {
    enable: "逻辑有效标志",
    ormpostname: "岗位(*)",
    createdate: "建立时间",
    ormdutyname: "职务(*)",
    experience: "是否主要经历",
    jlglbh: "记录管理编号",
    pimworkhistoryname: "工作履历名称",
    rzkssj: "任职开始时间(*)",
    jssj: "结束时间",
    jlss: "记录所属",
    rzjssj: "任职结束时间",
    qssj: "起始时间",
    spstate: "审批状态",
    cfplx: "兼职借调类型",
    ormorgsectorname: "部门(*)",
    createman: "建立人",
    isoutrecord: "外单位履历",
    updatedate: "更新时间",
    pimworkhistoryid: "工作履历标识",
    ormorgname: "工作单位(*)",
    bz: "备注",
    jlczz: "记录操作者",
    record: "履历说明",
    updateman: "更新人",
    jlspzt: "记录审批状态",
    pimpersonname: "人员信息名称",
    ygbh: "员工编号",
    ormrankname: "职级",
    ormrankid: "职级标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		personinfogridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		greditview: {
			caption: "工作履历",
      		title: "工作履历编辑视图",
		},
		redirectview: {
			caption: "工作履历",
      		title: "工作履历数据重定向视图",
		},
		gridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		mpickupview: {
			caption: "工作履历",
      		title: "工作履历数据多项选择视图",
		},
		pimworkgridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		pickupgridview: {
			caption: "工作履历",
      		title: "工作履历选择表格视图",
		},
		fazzsygridview: {
			caption: "工作履历",
      		title: "工作履历",
		},
		pickupview: {
			caption: "工作履历",
      		title: "工作履历数据选择视图",
		},
		editview2: {
			caption: "工作履历",
      		title: "工作履历编辑视图",
		},
		grpimworkgridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		gbllgridview: {
			caption: "工作履历",
      		title: "工作履历",
		},
		editview: {
			caption: "工作履历",
      		title: "工作履历编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "工作履历基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工作履历标识", 
			srfmajortext: "工作履历名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			qssj: "起始时间", 
			jssj: "结束时间", 
			bz: "备注", 
			jlczz: "记录操作者", 
			pimpersonid: "人员信息标识", 
			pimworkhistoryid: "工作履历标识", 
		},
		uiactions: {
		},
	},
	main_2_form: {
		details: {
			group1: "工作履历基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工作履历标识", 
			srfmajortext: "工作履历名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			qssj: "起始时间", 
			jssj: "结束时间", 
			bz: "备注", 
			jlss: "记录所属", 
			pimpersonid: "人员信息标识", 
			pimworkhistoryid: "工作履历标识", 
		},
		uiactions: {
		},
	},
	gbll_grid: {
		columns: {
			rzkssj: "任职开始时间(*)",
			rzjssj: "任职结束时间",
			ormorgname: "工作单位(*)",
			ormorgsectorname: "部门(*)",
			ormdutyname: "职务(*)",
			ormpostname: "岗位(*)",
			ormrankname: "职级",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			rzkssj: "任职开始时间",
			rzjssj: "任职结束时间",
			ormorgname: "工作单位",
			ormorgsectorname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			cfplx: "兼职借调类型",
			experience: "是否主要经历",
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			rzkssj: "任职开始时间",
			rzjssj: "任职结束时间",
			ormorgname: "工作单位",
			ormorgsectorname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
		},
		uiactions: {
		},
	},
	main_3_grid: {
		columns: {
			rzkssj: "任职开始时间",
			rzjssj: "任职结束时间",
			ormorgname: "工作单位",
			ormorgsectorname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			cfplx: "兼职借调类型",
			experience: "是否主要经历",
			jlspzt: "审批状态",
		},
		uiactions: {
		},
	},
	fabg_grid: {
		columns: {
			rzkssj: "任职开始时间",
			rzjssj: "任职结束时间",
			ormorgname: "工作单位",
			ormorgsectorname: "所在部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			cfplx: "兼职借调类型",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
		},
		uiactions: {
		},
	},
	gbllgridviewtoolbar_toolbar: {
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
	pimworkgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	personinfogridviewtoolbar_toolbar: {
	},
	greditviewtoolbar_toolbar: {
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
	grpimworkgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
		},
		deuiaction2: {
			caption: "提交",
			tip: "提交",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
	},
	grpimworkgridviewtoolbar_toolbar: {
	},
	fazzsygridviewtoolbar_toolbar: {
	},
	editview2toolbar_toolbar: {
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