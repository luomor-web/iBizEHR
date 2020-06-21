export default {
  fields: {
    createdate: "建立时间",
    pimarchiveschangename: "归档地变更记录",
    updateman: "更新人",
    dazt: "档案状态",
    updatedate: "更新时间",
    createman: "建立人",
    dcdw: "调出单位",
    ddjltype: "调档记录类型",
    bz: "备注",
    pimarchiveschangeid: "档案归档地变更记录标识",
    xgdbgd: "管理单位",
    jlcssj: "调动时间",
    drdw: "调入单位",
    daddrq: "调动日期",
    ormorgname2: "调入单位",
    pimpersonname: "员工姓名",
    pimarchivesname: "档案名称",
    ormorgname: "调出单位",
    ygbh: "员工编号",
    ormorgid2: "调入单位标识",
    ormorgid: "调出单位标识",
    pimarchivesid: "档案信息标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		editview2: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录编辑视图",
		},
		pickupgridview: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录选择表格视图",
		},
		redirectview: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录数据重定向视图",
		},
		mpickupview: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录数据多项选择视图",
		},
		gridview: {
			caption: "调档记录",
      		title: "调档记录表格视图",
		},
		pickupview: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录数据选择视图",
		},
		editview: {
			caption: "档案归档地变更记录",
      		title: "档案归档地变更记录编辑视图",
		},
		archiveseditview: {
			caption: "档案归档地变更记录",
      		title: "档案调档记录编辑视图",
		},
		dadcjlgridview: {
			caption: "档案调出记录",
      		title: "档案调出记录",
		},
	},
	main_form: {
		details: {
			group1: "调档记录", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "档案归档地变更记录标识", 
			srfmajortext: "归档地变更记录", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			dcdw: "调出单位", 
			drdw: "调入单位", 
			ormorgid2: "调入单位标识", 
			daddrq: "调动日期", 
			pimarchivesid: "档案信息标识", 
			pimarchiveschangeid: "档案归档地变更记录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ddjltype: "调档记录类型",
			ormorgname: "调出单位",
			ormorgname2: "调入单位",
			jlcssj: "调动时间",
			bz: "备注",
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			ormorgname: "调出单位",
			ormorgname2: "调入单位",
			jlcssj: "调动时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ygbh_like: "员工编号(%)", 
			n_pimpersonname_like: "员工姓名(%)", 
		},
		uiactions: {
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
	editview2toolbar_toolbar: {
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
	dadcjlgridviewtoolbar_toolbar: {
		deuiaction6: {
			caption: "导出",
			tip: "导出",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	archiveseditviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};