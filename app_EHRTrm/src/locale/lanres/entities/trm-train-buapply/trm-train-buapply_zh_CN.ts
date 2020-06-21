export default {
  fields: {
    trmtrainbuapplyid: "培训预算申请标识",
    jgfy: "机构费用",
    updatedate: "更新时间",
    bz: "备注",
    tzje: "实际费用",
    trmtrainbuapplyname: "培训预算申请名称",
    szf: "师资费",
    updateman: "更新人",
    nd: "年度",
    clf: "差旅费",
    enable: "逻辑有效标志",
    qtfy: "其他费用",
    cdzj: "场地租金",
    createdate: "建立时间",
    yszje: "培训预算",
    createman: "建立人",
    tzysxm: "调整预算项目",
    jflx: "经费类型",
    trmtrainplantermname: "培训班",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
    trmtrainplantermid: "培训计划项标识",
  },
	views: {
		gridview: {
			caption: "培训费用登记",
      		title: "培训费用登记",
		},
		editview: {
			caption: "培训费用登记",
      		title: "培训费用登记",
		},
		pickupview: {
			caption: "教育经费",
      		title: "培训预算申请数据选择视图",
		},
		pickupgridview: {
			caption: "教育经费",
      		title: "培训预算申请选择表格视图",
		},
		mpickupview: {
			caption: "教育经费",
      		title: "培训预算申请数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "培训费用登记", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训预算申请标识", 
			srfmajortext: "培训预算申请名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainplantermid: "培训计划项标识", 
			trmtrainplantermname: "培训班", 
			jflx: "经费类型", 
			tzysxm: "预算费用", 
			tzje: "实际费用", 
			clf: "差旅费", 
			szf: "师资费", 
			cdzj: "场地租金", 
			jgfy: "机构费用", 
			qtfy: "其他费用", 
			bz: "备注", 
			trmtrainbuapplyid: "培训预算申请标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrainplantermname: "培训立项",
			jflx: "经费类型",
			tzysxm: "预算费用",
			tzje: "实际费用",
			clf: "差旅费",
			szf: "师资费",
			cdzj: "场地租金",
			jgfy: "机构费用",
			qtfy: "其他费用",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainplantermname_like: "培训班(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem5: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
	},
};