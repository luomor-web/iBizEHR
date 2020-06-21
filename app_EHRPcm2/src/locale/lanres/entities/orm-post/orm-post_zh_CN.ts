export default {
  fields: {
    createman: "建立人",
    lgnx: "轮岗年限",
    bxjlnx: "必须交流年限",
    istemp: "是否临时数据",
    updatedate: "更新时间",
    gwtype: "岗位类型",
    qzlgnx: "强制轮岗年限",
    postnature: "岗位性质",
    iskeypostion: "是否关键岗位",
    xh: "排序号",
    ormpostid: "岗位标识",
    nx: "建议交流年限",
    orgid: "组织ID",
    isconfidential: "是否保密岗",
    updateman: "更新人",
    ormpostname: "岗位名称",
    gwfl: "岗位分类",
    startstopsign: "启用标识",
    createdate: "建立时间",
    ormorgname: "组织",
    ormorgid: "组织标识",
  },
	views: {
		orgidpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
		pickupgridview: {
			caption: "岗位",
      		title: "岗位管理选择表格视图",
		},
		ejormorgidpickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		orgidpickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		pickupview: {
			caption: "岗位",
      		title: "岗位管理数据选择视图",
		},
		ejormorgidpickupgridview: {
			caption: "岗位选择",
      		title: "岗位选择",
		},
	},
	gwchoice_grid: {
		columns: {
			xh: "排序",
			ormpostname: "岗位名称",
			postnature: "岗位性质",
			createman: "建立人",
			createdate: "建立时间",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			ormpostname: "岗位名称",
			gwfl: "岗位分类",
			nx: "建议交流年限",
			bxjlnx: "必须交流年限",
			isconfidential: "是否保密岗",
			postnature: "岗位性质",
			iskeypostion: "是否关键岗位",
			startstopsign: "启用标识",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormpostname_like: "岗位集名称", 
			n_ormorgname_like: "组织名称", 
			n_startstopsign_eq: "启用标识", 
			n_gwtype_eq: "岗位类型", 
		},
		uiactions: {
		},
	},
};