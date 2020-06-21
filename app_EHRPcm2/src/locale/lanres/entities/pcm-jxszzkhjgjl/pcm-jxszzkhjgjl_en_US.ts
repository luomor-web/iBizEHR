
export default {
  fields: {
    enable: "逻辑有效标志",
    pj: "评价",
    pcmjxszzkhjgjlname: "员工",
    ygbh: "员工编号",
    updateman: "更新人",
    jssj: "结束时间",
    createdate: "建立时间",
    fs: "分数",
    updatedate: "更新时间",
    createman: "建立人",
    pcmjxszzkhjgjlid: "见习生员工转正考核结果记录标识",
    qssj: "起始时间",
  },
	views: {
		pickupgridview: {
			caption: "见习生员工转正考核结果记录",
      		title: "见习生员工转正考核结果记录选择表格视图",
		},
		pickupview: {
			caption: "见习生员工转正考核结果记录",
      		title: "见习生员工转正考核结果记录数据选择视图",
		},
	},
	main_grid: {
		columns: {
			pcmjxszzkhjgjlname: "员工",
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