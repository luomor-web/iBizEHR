
export default {
  fields: {
    createman: "建立人",
    orgid: "组织ID",
    xbsj: "下班时间",
    updateman: "更新人",
    updatedate: "更新时间",
    createdate: "建立时间",
    attendencesetupname: "考勤表名称",
    allowoutwork: "允许外勤",
    enable: "逻辑有效标志",
    dkfs: "打卡方式",
    attendencesetupid: "考勤设置标识",
    sbsj: "上班时间",
    pimpersonname: "考勤员",
    vacholidayrulesname: "考勤规则",
    porgid: "上级机构ID",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
    vacholidayrulesid: "考勤规则标识",
  },
	views: {
		kqbpickupgridview: {
			caption: "考勤设置",
      		title: "考勤设置选择表格视图",
		},
		kqbypickupview: {
			caption: "考勤设置",
      		title: "考勤设置数据选择视图",
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织名称",
			attendencesetupname: "考勤表名称",
			vacholidayrulesname: "考勤规则",
			pimpersonname: "考勤员",
			dkfs: "打卡方式",
			allowoutwork: "允许外勤",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormorgname_like: "组织名称(%)", 
			n_attendencesetupname_like: "考勤表名称(%)", 
		},
		uiactions: {
		},
	},
};