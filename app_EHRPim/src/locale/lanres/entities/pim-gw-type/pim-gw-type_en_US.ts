
export default {
  fields: {
    enable: "逻辑有效标志",
    pimgwtypename: "岗位类型对照表名称",
    gwlx: "岗位类型",
    ordervalue: "排序值",
    createdate: "建立时间",
    pimgwtypeid: "岗位类型对照表标识",
    createman: "建立人",
    updateman: "更新人",
    updatedate: "更新时间",
  },
	views: {
		pickupgridview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
		mpickupview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
		pickupview: {
			caption: "岗位类型",
      		title: "岗位类型",
		},
	},
	main_grid: {
		columns: {
			ordervalue: "排序",
			gwlx: "岗位类型",
			createdate: "建立时间",
			createman: "建立人",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_gwlx_eq: "岗位类型", 
		},
		uiactions: {
		},
	},
};