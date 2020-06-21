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
		editview: {
			caption: "考勤设置",
      		title: "考勤设置编辑视图",
		},
		pickupview: {
			caption: "考勤设置",
      		title: "考勤设置数据选择视图",
		},
		pickupgridview: {
			caption: "考勤设置",
      		title: "考勤设置选择表格视图",
		},
		gridview: {
			caption: "考勤设置",
      		title: "考勤设置表格视图",
		},
		kqsztreeexpview: {
			caption: "考勤设置",
      		title: "考勤设置树导航视图",
		},
		mpickupview: {
			caption: "考勤设置",
      		title: "考勤设置数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "基本信息", 
			druipart1: "", 
			grouppanel1: "考勤部门", 
			rawitem1: "", 
			druipart2: "", 
			grouppanel2: "考勤人员", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤设置标识", 
			srfmajortext: "考勤表名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgid: "组织标识", 
			ormorgname: "组织名称", 
			attendencesetupname: "考勤表名称", 
			pimpersonid: "人员信息标识", 
			pimpersonname: "考勤员", 
			vacholidayrulesid: "考勤规则标识", 
			vacholidayrulesname: "考勤规则", 
			sbsj: "上班时间", 
			xbsj: "下班时间", 
			dkfs: "打卡方式", 
			allowoutwork: "允许外勤", 
			attendencesetupid: "考勤设置标识", 
		},
		uiactions: {
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
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
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
	attendencesetuptree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};