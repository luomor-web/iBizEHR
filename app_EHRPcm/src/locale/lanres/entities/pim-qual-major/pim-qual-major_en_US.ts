
export default {
  fields: {
    createman: "建立人",
    gwzs: "岗位类型",
    gwtype: "岗位类型",
    zyjszw: "专业技术职务",
    createdate: "建立时间",
    quamajor: "专业",
    gwlx: "岗位类型",
    orgid: "组织ID",
    enable: "逻辑有效标志",
    qualevel: "级别",
    updatedate: "更新时间",
    updateman: "更新人",
    pimqualmajorid: "执业资格专业编码",
    zyzgzy: "执业资格名称",
    pimqualmajorname: "执业资格",
    professionaltype: "执业资格类别",
    pimqualtypename: "执业资格类别",
    ormorgid: "组织标识",
    pimqualtypeid: "执业资格类别标识",
  },
	views: {
		pickupview: {
			caption: "执业资格专业",
      		title: "执业资格专业数据选择视图",
		},
		pickupgridview: {
			caption: "执业资格专业",
      		title: "执业资格专业选择表格视图",
		},
	},
	main_grid: {
		columns: {
			zyzgzy: "执业资格名称",
			qualevel: "级别",
			pimqualmajorname: "执业资格",
			quamajor: "专业",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimqualmajorname_like: "执业资格(%)", 
		},
		uiactions: {
		},
	},
};