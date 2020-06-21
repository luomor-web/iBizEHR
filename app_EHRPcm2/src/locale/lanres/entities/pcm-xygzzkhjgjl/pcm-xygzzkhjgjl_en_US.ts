
export default {
  fields: {
    jssj: "结束时间",
    ygbh: "员工编号",
    pj: "评价",
    pcmxygzzkhjgjlname: "员工",
    enable: "逻辑有效标志",
    updateman: "更新人",
    pcmxygzzkhjgjlid: "新员工转正考核结果记录标识",
    createdate: "建立时间",
    createman: "建立人",
    updatedate: "更新时间",
    fs: "分数",
    qssj: "起始时间",
  },
	views: {
		pickupview: {
			caption: "试用期员工转正考核结果记录",
      		title: "新员工转正考核结果记录数据选择视图",
		},
		pickupgridview: {
			caption: "试用期员工转正考核结果记录",
      		title: "新员工转正考核结果记录选择表格视图",
		},
	},
	main_grid: {
		columns: {
			pcmxygzzkhjgjlname: "员工",
			ygbh: "员工编号",
			qssj: "起始时间",
			jssj: "结束时间",
			fs: "分数",
			pj: "评价",
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