
export default {
  fields: {
    val2: "新值",
    createman: "操作人",
    sallogname: "操作类型",
    updateman: "更新人",
    sallogid: "薪酬调整日志标识",
    val1: "原值",
    createdate: "操作时间",
    updatedate: "更新时间",
    salsalaryname: "员工薪酬",
    salsalarydetailname: "要素项",
    salsalarydetailid: "员工薪酬明细标识",
    salsalaryid: "员工薪酬标识",
  },
	views: {
		gridview: {
			caption: "薪酬调整日志",
      		title: "薪酬调整日志表格视图",
		},
	},
	main_grid: {
		columns: {
			sallogname: "操作类型",
			salsalaryname: "员工薪酬",
			salsalarydetailname: "要素项",
			val1: "原值",
			val2: "新值",
			createman: "操作人",
			createdate: "操作时间",
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
};