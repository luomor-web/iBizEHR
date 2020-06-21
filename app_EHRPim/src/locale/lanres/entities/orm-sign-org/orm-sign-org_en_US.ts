
export default {
  fields: {
    orgcode: "组织编号",
    ormsignorgid: "法人主体标识",
    updatedate: "更新时间",
    updateman: "更新人",
    zzjc: "简称",
    createman: "建立人",
    createdate: "建立时间",
    ormsignorgname: "法人主体名称",
  },
	views: {
		bdwpickupgridview: {
			caption: "注册单位选择",
      		title: "注册单位选择",
		},
		htqddwpickupgridview: {
			caption: "合同签订单位选择",
      		title: "合同签订单位选择",
		},
		bdwpickupview: {
			caption: "注册单位选择",
      		title: "注册单位选择",
		},
		pickupview: {
			caption: "法人主体",
      		title: "法人主体数据选择视图",
		},
		pickupgridview: {
			caption: "法人主体",
      		title: "法人主体选择表格视图",
		},
		htqddwwpickupview: {
			caption: "合同签订单位选择",
      		title: "合同签订单位选择",
		},
	},
	main_grid: {
		columns: {
			ormsignorgname: "法人主体组织",
			orgcode: "组织编号",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormsignorgname_like: "法人主体组织", 
			n_orgcode_like: "组织编号(%)", 
		},
		uiactions: {
		},
	},
};