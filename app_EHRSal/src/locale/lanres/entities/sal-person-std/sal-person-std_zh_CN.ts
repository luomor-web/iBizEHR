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
};