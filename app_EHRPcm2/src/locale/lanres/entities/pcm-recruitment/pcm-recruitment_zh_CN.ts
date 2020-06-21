export default {
  fields: {
    createman: "建立人",
    updatedate: "更新时间",
    createdate: "建立时间",
    updateman: "更新人",
    pcmrecruitmentid: "内部招聘信息标识",
    requirements: "能力要求",
    sjzprs: "实际招聘人数",
    pcmrecruitmentname: "内部招聘信息名称",
    yjzprs: "预计招聘人数",
    sfzpwc: "是否招聘完成",
    recruitmenttype: "招聘类型",
    ormpostname: "岗位",
    ormorgname: "组织名称",
    ormorgsectorname: "部门名称",
    ormdutyname: "职务",
    ormorgsectorid: "部门标识",
    ormorgid: "组织标识",
    ormpostid: "岗位管理标识",
    ormdutyid: "职务标识",
  },
	views: {
		pickupgridview: {
			caption: "内部招聘信息",
      		title: "内部招聘信息选择表格视图",
		},
		pickupview: {
			caption: "内部招聘信息",
      		title: "内部招聘信息数据选择视图",
		},
	},
	main_grid: {
		columns: {
			pcmrecruitmentname: "内部招聘信息名称",
			recruitmenttype: "招聘类型",
			sfzpwc: "是否招聘完成",
			ormorgname: "组织名称",
			ormorgsectorname: "部门名称",
			ormdutyname: "职务",
			ormpostname: "岗位",
			yjzprs: "预计招聘人数",
			sjzprs: "实际招聘人数",
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