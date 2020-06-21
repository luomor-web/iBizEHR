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
		grpimworkgridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		greditview: {
			caption: "工作履历",
      		title: "工作履历编辑视图",
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
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
		},
		uiactions: {
		},
	},
	grpimworkgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "提交",
			tip: "提交",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
	},
	grpimworkgridviewtoolbar_toolbar: {
	},
	greditviewtoolbar_toolbar: {
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