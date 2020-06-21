
export default {
  fields: {
    createdate: "建立时间",
    updateman: "更新人",
    code: "序列号",
    updatedate: "更新时间",
    rcxlmc: "人才序列名称",
    pcmrcxlid: "人才序列标识",
    snumber: "排序编码",
    rcxllx: "人才序列类型",
    pcmrcxlname: "人才序列名称",
    xldj: "序列等级",
    createman: "建立人",
    pcmrcxlname2: "上级",
    pcmrcxlid2: "人才序列标识",
  },
	views: {
		pickupview: {
			caption: "人才序列",
      		title: "人才序列数据选择视图",
		},
		pickupgridview: {
			caption: "人才序列",
      		title: "人才序列选择表格视图",
		},
	},
	main_grid: {
		columns: {
			snumber: "排序编码",
			rcxllx: "人才序列类型",
			rcxlmc: "人才序列名称",
			code: "序列号",
			xldj: "序列等级",
			pcmrcxlname2: "上级",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_rcxllx_eq: "人才序列类型(=)", 
			n_pcmrcxlname_like: "人才序列名称(%)", 
		},
		uiactions: {
		},
	},
};