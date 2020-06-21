export default {
  fields: {
    updatedate: "更新时间",
    updateman: "更新人",
    attendancesettingsname: "考勤人员名称",
    dkfs: "打卡方式",
    createdate: "建立时间",
    attendancesettingsid: "考勤人员标识",
    createman: "建立人",
    attendencesetupname: "所属考勤表",
    ormorgname2: "考勤表组织简称",
    ormorgsectorname: "部门",
    ygzt: "员工状态",
    ormorgsectorid: "部门标识",
    ygbh: "员工编号",
    ormorgid2: "考勤表组织标识",
    pimpersonname: "员工姓名",
    ormorgid: "组织标识",
    zzdzs: "人员组织简称",
    attendencesetupid: "考勤设置标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		editview: {
			caption: "考勤人员",
      		title: "考勤人员",
		},
		fygzzkqgridview: {
			caption: "非员工终止考勤",
      		title: "非员工终止考勤",
		},
		gridview: {
			caption: "考勤人员",
      		title: "考勤人员",
		},
		ygszkqgridview: {
			caption: "员工设置考勤",
      		title: "员工设置考勤",
		},
	},
	main_form: {
		details: {
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤人员标识", 
			srfmajortext: "考勤人员名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			attendencesetupid: "考勤设置标识", 
			attendencesetupname: "所属考勤表", 
			attendancesettingsid: "考勤人员标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			ormorgsectorname: "部门",
			dkfs: "打卡方式",
		},
		uiactions: {
		},
	},
	fygzzkq_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			zzdzs: "人员组织简称",
			ormorgsectorname: "部门",
			ygzt: "员工状态",
			attendencesetupname: "所属考勤表",
			ormorgname2: "考勤表组织简称",
			dkfs: "打卡方式",
		},
		uiactions: {
		},
	},
	ygszkq_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			zzdzs: "人员组织简称",
			ormorgsectorname: "部门",
			ygzt: "员工状态",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名(%)", 
			n_zzdzs_like: "人员组织简称(%)", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
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
	},
	fygzzkqgridviewtoolbar_toolbar: {
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	ygszkqgridviewtoolbar_toolbar: {
		tbitem1_addtokqz: {
			caption: "添加到考勤组",
			tip: "添加到考勤组",
		},
		deuiaction1: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
};