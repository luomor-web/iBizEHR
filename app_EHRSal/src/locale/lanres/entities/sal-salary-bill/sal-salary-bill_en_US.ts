
export default {
  fields: {
    enable: "逻辑有效标志",
    ssou: "所属OU",
    salsalarybillname: "工资表名称",
    salsalarybillid: "工资表标识",
    updatedate: "更新时间",
    createdate: "建立时间",
    updateman: "更新人",
    createman: "建立人",
    ormorgsectorname: "部门",
    ormorgname: "组织",
    ormorgsectorid: "部门标识",
    ormorgid: "组织标识",
  },
	views: {
		pickupview: {
			caption: "工资表",
      		title: "工资单数据选择视图",
		},
		pickupgridview: {
			caption: "工资表",
      		title: "工资单选择表格视图",
		},
	},
	main_grid: {
		columns: {
			salsalarybillname: "工资表名称",
			ormorgname: "组织",
			ormorgsectorname: "部门",
			ssou: "所属OU",
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