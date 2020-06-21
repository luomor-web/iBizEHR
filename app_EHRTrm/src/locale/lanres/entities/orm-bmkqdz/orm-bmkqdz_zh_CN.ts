export default {
  fields: {
    ormorgdzid: "组织地址ID",
    ormbmkqdzname: "部门地址",
    createdate: "建立时间",
    createman: "建立人",
    ormbmkqdzid: "部门地址维护标识",
    lng: "经度",
    sfmrkqdz: "默认考勤地址",
    updateman: "更新人",
    updatedate: "更新时间",
    lat: "纬度",
    xh: "排序号",
    ormorgsectorname: "部门名称",
    ormorgsectorid: "部门ID",
    attendancerange: "考勤范围",
  },
	views: {
		pickupview: {
			caption: "部门地址维护",
      		title: "部门地址维护数据选择视图",
		},
		pickupgridview: {
			caption: "部门地址维护",
      		title: "部门地址维护选择表格视图",
		},
	},
	main_grid: {
		columns: {
			ormbmkqdzname: "部门地址",
			sfmrkqdz: "默认考勤地址",
			createman: "建立人",
			createdate: "建立时间",
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