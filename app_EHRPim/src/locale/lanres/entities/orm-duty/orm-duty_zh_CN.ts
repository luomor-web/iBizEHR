export default {
  fields: {
    ormdutyid: "职务标识",
    fglx: "职务编码",
    updateman: "更新人",
    updatedate: "更新时间",
    xh: "排序号",
    createman: "建立人",
    zwjb: "职务级别",
    createdate: "建立时间",
    dyzj: "对应职级",
    nx: "建议交流年限",
    zwlb: "层级",
    bxjlnx: "必须交流年限",
    ormdutyname: "职务",
  },
	views: {
		ormorgsectorpickupview: {
			caption: "职务库",
      		title: "职务库",
		},
		ormorgsectorpickupgridview: {
			caption: "职务库",
      		title: "职务库",
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			fglx: "职务编码",
			ormdutyname: "职务名称",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	wcjsearchform_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormdutyname_like: "职务名称", 
			n_fglx_like: "职务编码", 
		},
		uiactions: {
		},
	},
};