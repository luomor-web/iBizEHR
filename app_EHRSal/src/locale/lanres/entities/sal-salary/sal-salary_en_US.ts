
export default {
  fields: {
    salsalaryid: "员工薪酬标识",
    orgid: "组织ID",
    memo: "备注",
    state: "状态",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    createman: "建立人",
    xc: "实发薪酬",
    updatedate: "更新时间",
    salsalaryname: "员工薪酬名称",
    orgsectorid: "部门ID",
    updateman: "更新人",
    salsalarybillname: "工资单名称",
    ormpostname: "岗位",
    nyear: "年",
    ormorgname: "组织",
    nmonth: "月",
    ormdutyname: "职务",
    ormorgsectorname: "部门",
    pimpersonname: "员工姓名",
    salplanname: "薪酬计算计划",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
    salsalarybillid: "工资单标识",
    ormdutyid: "职务管理标识",
    ormorgsectorid: "部门标识",
    ormpostid: "岗位管理标识",
    salplanid: "薪酬计算计划标识",
  },
	views: {
		editview: {
			caption: "员工薪酬",
      		title: "员工薪酬编辑视图",
		},
		gridview: {
			caption: "员工薪酬",
      		title: "员工薪酬表格视图",
		},
	},
	main_form: {
		details: {
			group1: "员工薪酬", 
			druipart1: "", 
			grouppanel1: "薪酬明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "员工薪酬标识", 
			srfmajortext: "员工薪酬名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			ormorgname: "组织", 
			ormorgsectorname: "部门", 
			ormdutyname: "职务", 
			ormpostname: "岗位", 
			xc: "实发薪酬", 
			state: "状态", 
			salplanname: "薪酬计算计划", 
			memo: "备注", 
			salsalaryid: "员工薪酬标识", 
			ormdutyid: "职务管理标识", 
			ormpostid: "岗位管理标识", 
			ormorgsectorid: "部门标识", 
			pimpersonid: "人员信息标识", 
			salplanid: "薪酬计算计划标识", 
			ormorgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ormorgname: "组织",
			ormorgsectorname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			xc: "实发薪酬",
			state: "状态",
			salplanname: "薪酬计算计划",
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