
export default {
  fields: {
    cabinetno: "柜号",
    createman: "建立人",
    createdate: "建立时间",
    bnumber: "编号",
    updatedate: "更新时间",
    position: "档案存放位置",
    archivescenterid: "档案室管理标识",
    serialno: "排序号",
    memo: "备注",
    updateman: "更新人",
    archivescentername: "档案室名称",
    orgid: "组织ID",
    layerno: "层号",
    enable: "逻辑有效标志",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
  },
	views: {
		pickupview: {
			caption: "档案室管理",
      		title: "档案室管理数据选择视图",
		},
		pickupgridview: {
			caption: "档案室管理",
      		title: "档案室管理选择表格视图",
		},
	},
	main_grid: {
		columns: {
			serialno: "排序号",
			archivescentername: "档案室名称",
			cabinetno: "柜号",
			layerno: "层号",
			bnumber: "编号",
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