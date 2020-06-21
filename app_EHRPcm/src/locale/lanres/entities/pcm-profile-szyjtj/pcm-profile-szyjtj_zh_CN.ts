export default {
  fields: {
    createman: "建立人",
    xh: "序号",
    updatedate: "更新时间",
    createdate: "建立时间",
    pcmprofileszyjtjid: "应聘者社招引进条件标识",
    yglx: "申报类型",
    pcmprofileszyjtjname: "应聘者社招引进条件",
    updateman: "更新人",
  },
	views: {
		mpickupview: {
			caption: "应聘者社招引进条件",
      		title: "应聘者社招引进条件选择",
		},
		pickupgridview: {
			caption: "应聘者社招引进条件",
      		title: "应聘者社招引进条件选择表格视图",
		},
	},
	ypzsy_grid: {
		columns: {
			yglx: "申报类型",
			pcmprofileszyjtjname: "应聘者社招引进条件",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_yglx_eq: "申报类型", 
			n_pcmprofileszyjtjname_like: "应聘者社招引进条件", 
		},
		uiactions: {
		},
	},
};