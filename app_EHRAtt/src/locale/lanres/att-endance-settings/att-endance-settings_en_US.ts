
export default {
  fields: {
    updatedate: '更新时间',
    updateman: '更新人',
    attendancesettingsname: '考勤人员名称',
    dkfs: '打卡方式',
    createdate: '建立时间',
    attendancesettingsid: '考勤人员标识',
    createman: '建立人',
    attendencesetupname: '所属考勤表',
    ormorgname2: '考勤表组织简称',
    ormorgsectorname: '部门',
    ygzt: '员工状态',
    ormorgsectorid: '部门标识',
    ygbh: '员工编号',
    ormorgid2: '考勤表组织标识',
    pimpersonname: '员工姓名',
    ormorgid: '组织标识',
    zzdzs: '人员组织简称',
    attendencesetupid: '考勤设置标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		editview: {
			caption: "考勤人员",
      title: '考勤人员',
		},
		gridview: {
			caption: "考勤人员",
      title: '考勤人员',
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
	gridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
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
		deuiaction2: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction1: {
			caption: "Help",
			tip: "Help",
		},
	},
};