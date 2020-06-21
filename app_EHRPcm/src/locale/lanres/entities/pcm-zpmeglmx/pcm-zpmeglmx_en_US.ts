
export default {
  fields: {
    pcmzpmeglmxid: "招聘名额管理明细标识",
    pfrq: "批复日期",
    createman: "建立人",
    updatedate: "更新时间",
    updateman: "更新人",
    pcmzpmeglmxname: "招聘名额管理明细名称",
    createdate: "建立时间",
    pcmzpmeglname: "招聘名额管理名称",
    pcmzpmeglid: "招聘名额管理标识",
  },
	views: {
		zpmeglmxgridview: {
			caption: "招聘名额管理明细",
      		title: "招聘名额管理明细表格视图",
		},
	},
	main_grid: {
		columns: {
			pcmzpmeglmxname1: "招聘名额管理明细名称",
			pfrq: "批复日期",
		},
		uiactions: {
		},
	},
	zpmeglmxgridviewtoolbar_toolbar: {
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
};