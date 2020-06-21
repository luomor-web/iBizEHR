
export default {
  fields: {
    updatedate: "更新时间",
    attendancemreportid: "考勤月报标识",
    attendancemreportname: "考勤月报名称",
    createman: "建立人",
    orgid: "组织ID",
    createdate: "建立时间",
    updateman: "更新人",
    yf: "月份",
    enable: "逻辑有效标志",
    nd: "年度",
    zt: "状态",
    ormorgname: "组织",
    pimpersonname: "考勤员",
    pimpersonid: "考勤员id",
    attendencesetupname: "考勤表",
    ormorgid: "组织标识",
    attendencesetupid: "考勤设置标识",
  },
	views: {
		gridview: {
			caption: "考勤月报",
      		title: "考勤月报",
		},
		editview: {
			caption: "考勤月报",
      		title: "考勤月报",
		},
		curzzkqybgridview: {
			caption: "考勤月报",
      		title: "考勤月报",
		},
		kqybtreeexpview: {
			caption: "考勤月报",
      		title: "考勤月报树导航视图",
		},
	},
	main_form: {
		details: {
			group1: "考勤月报信息", 
			druipart1: "", 
			grouppanel1: "考勤月报明细（人员）", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考勤月报标识", 
			srfmajortext: "考勤月报名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormorgid: "组织标识", 
			ormorgname: "组织名称", 
			nd: "年度", 
			yf: "月份", 
			attendencesetupid: "考勤设置标识", 
			attendencesetupname: "考勤表", 
			pimpersonname: "考勤员", 
			zt: "状态", 
			attendancemreportid: "考勤月报标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			nd: "年度",
			yf: "月份",
			attendencesetupname: "考勤表",
			pimpersonname: "考勤员",
			zt: "状态",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_nd_eq: "年度(=)", 
			n_yf_eq: "月份(=)", 
			n_zt_eq: "状态(=)", 
		},
		uiactions: {
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
		tbitem1_sckqyb: {
			caption: "生成月报",
			tip: "生成月报",
		},
		tbitem14_qr: {
			caption: "确认月报",
			tip: "确认月报",
		},
		deuiaction2_printkqyb: {
			caption: "打印月报",
			tip: "打印月报",
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
	curzzkqybgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem1_sckqyb: {
			caption: "生成月报",
			tip: "生成月报",
		},
		tbitem14_exportkqyb: {
			caption: "导出月报",
			tip: "导出月报",
		},
		deuiaction2_qr: {
			caption: "确认月报",
			tip: "确认月报",
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
	ormorgbmtree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};