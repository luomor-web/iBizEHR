
export default {
  fields: {
    createdate: "建立时间",
    attenddate: "考勤日期",
    dksjqt: "下班打卡时间",
    orgid: "组织ID",
    isoutoffice: "上班卡是否外勤",
    enable: "逻辑有效标志",
    dkfs: "考勤方式",
    isoutleave: "下班卡是否外勤",
    createman: "建立人",
    updatedate: "更新时间",
    attendancerecordid: "考勤记录标识",
    dksjqd: "上班打卡时间",
    updateman: "更新人",
    orgsectorid: "部门ID",
    attendancerecordname: "考勤记录名称",
    pimpersonname: "员工姓名",
    ormorgsectorname: "部门/项目部",
    ygbh: "员工编号",
    ormorgsectorid: "部门标识",
    trmtrainplantermname: "培训计划项名称",
    ormbmkqdzname: "部门地址",
    zzdzs: "组织名称",
    zjhm: "证件号码",
    ormorgid: "组织标识",
    attendancemreportmxname: "考勤月报明细名称",
    ormorgname: "组织名称",
    pimpersonid: "人员信息标识",
    ormbmkqdzid: "部门地址维护标识",
    attendancemreportid: "考勤月报明细标识",
    trmtrainplantermid: "培训计划项标识",
  },
	views: {
		gridview: {
			caption: "考勤记录",
      		title: "考勤记录表格视图",
		},
		editview: {
			caption: "考勤记录",
      		title: "考勤记录编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "考勤记录信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤记录标识", 
			srfmajortext: "考勤记录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			pimpersonname: "员工姓名", 
			ygbh: "员工编号", 
			ormorgid: "组织标识", 
			ormorgname: "组织名称", 
			ormorgsectorid: "部门标识", 
			ormorgsectorname: "部门/项目部", 
			dkfs: "考勤方式", 
			attenddate: "考勤日期", 
			dksjqd: "上班打卡时间", 
			dksjqt: "下班打卡时间", 
			ormbmkqdzname: "部门地址", 
			ormbmkqdzid: "部门地址维护标识", 
			attendancerecordid: "考勤记录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: "员工姓名",
			ygbh: "员工编号",
			zjhm: "证件号码",
			zzdzs: "组织名称",
			ormorgsectorname: "部门/项目部",
			attenddate: "考勤日期",
			dksjqd: "上班打卡时间",
			dksjqt: "下班打卡时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名(%)", 
			n_dkfs_eq: "考勤方式(=)", 
			n_ormorgname_like: "组织名称(%)", 
			n_ormorgsectorname_like: "部门/项目部(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
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