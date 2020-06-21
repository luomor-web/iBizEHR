export default {
  fields: {
    salruledetailname: "薪酬规则明细名称",
    createman: "建立人",
    updatedate: "更新时间",
    updateman: "更新人",
    checkrule: "比较规则",
    salruledetailid: "薪酬规则明细标识",
    createdate: "建立时间",
    salrulename: "薪酬规则名称",
    salparamname: "薪酬计算指标(原值)",
    salparamname2: "薪酬计算指标(对应值)",
    salparamid: "薪酬计算指标标识",
    salruleid: "薪酬规则标识",
    salparamid2: "薪酬计算指标标识",
  },
	views: {
		editview: {
			caption: "薪酬规则明细",
      		title: "薪酬规则明细编辑视图",
		},
		gridview: {
			caption: "薪酬规则明细",
      		title: "薪酬规则明细表格视图",
		},
	},
	main_form: {
		details: {
			group1: "薪酬规则明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "薪酬规则明细标识", 
			srfmajortext: "薪酬规则明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salruleid: "薪酬规则标识", 
			salparamname: "指标原值", 
			checkrule: "比较规则", 
			salparamname2: "指标对应值", 
			salruledetailid: "薪酬规则明细标识", 
			salparamid2: "薪酬计算指标标识", 
			salparamid: "薪酬计算指标标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salparamname: "薪酬计算指标(原值)",
			checkrule: "比较规则",
			salparamname2: "薪酬计算指标(对应值)",
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
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
};