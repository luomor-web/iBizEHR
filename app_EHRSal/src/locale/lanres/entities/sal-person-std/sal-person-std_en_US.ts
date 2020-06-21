
export default {
  fields: {
    memo: "备注",
    salpersonstdid: "员工薪酬标准标识",
    enable: "逻辑有效标志",
    salpersonstdname: "员工薪酬标准名称",
    changereason: "变更原因",
    updatedate: "更新时间",
    createman: "建立人",
    begintime: "生效日期",
    saltype: "薪酬类型",
    createdate: "建立时间",
    endtime: "失效日期",
    updateman: "更新人",
    ormpostname: "岗位",
    ormorgsectorname: "部门",
    pimpersonname: "员工姓名",
    ormorgname: "组织",
    ormdutyname: "职务",
    pimpersonid: "人员信息标识",
    ormdutyid: "职务管理标识",
    ormpostid: "岗位管理标识",
    ormorgid: "组织标识",
    ormorgsectorid: "部门标识",
  },
	views: {
		editview: {
			caption: "员工薪酬标准",
      		title: "员工薪酬标准编辑视图",
		},
		gridview: {
			caption: "员工薪酬标准",
      		title: "员工薪酬标准表格视图",
		},
	},
	main_form: {
		details: {
			group1: "员工薪酬标准信息", 
			druipart1: "", 
			grouppanel1: "薪酬要素项", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "员工薪酬标准标识", 
			srfmajortext: "员工薪酬标准名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			saltype: "薪酬类型", 
			ormorgname: "组织", 
			ormorgsectorname: "部门", 
			ormdutyname: "职务", 
			ormpostname: "岗位", 
			begintime: "生效日期", 
			endtime: "失效日期", 
			changereason: "变更原因", 
			memo: "备注", 
			salpersonstdid: "员工薪酬标准标识", 
			ormdutyid: "职务管理标识", 
			ormpostid: "岗位管理标识", 
			ormorgsectorid: "部门标识", 
			pimpersonid: "人员信息标识", 
			ormorgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: "员工姓名",
			ormorgname: "组织",
			ormorgsectorname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			saltype: "薪酬类型",
			begintime: "生效日期",
			endtime: "失效日期",
			changereason: "变更原因",
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