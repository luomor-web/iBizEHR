export default {
  fields: {
    updateman: "更新人",
    salsubjectid: "财务科目标识",
    enable: "逻辑有效标志",
    salsubjectname: "财务科目名称",
    updatedate: "更新时间",
    createman: "建立人",
    subcode: "财务科目编码",
    createdate: "建立时间",
  },
	views: {
		pickupview: {
			caption: "财务科目",
      		title: "财务科目数据选择视图",
		},
		pickupgridview: {
			caption: "财务科目",
      		title: "财务科目选择表格视图",
		},
	},
	main_grid: {
		columns: {
			subcode: "财务科目编码",
			salsubjectname: "财务科目名称",
			updateman: "更新人",
			updatedate: "更新时间",
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