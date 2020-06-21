export default {
  fields: {
    dcwjtm: "调查问卷附件",
    createman: "建立人",
    bz: "备注",
    updateman: "更新人",
    trmtrainactmentid: "培训后评估标识",
    updatedate: "更新时间",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    pxjg: "评估结果",
    trmtrainactmentname: "培训后评估名称",
    trmtrainactapplyname: "培训后评估名称",
    trmtrainactapplyid: "培训后评估标识",
    evaltarget: "评估对象",
    evalcontents: "评估内容",
    evaltime: "评估时间",
  },
	views: {
		editview: {
			caption: "培训后评估",
      		title: "培训后评估",
		},
		pickupview: {
			caption: "培训活动评估",
      		title: "培训活动评估数据选择视图",
		},
		mpickupview: {
			caption: "培训活动评估",
      		title: "培训活动评估数据多项选择视图",
		},
		gridview: {
			caption: "培训后评估",
      		title: "培训后评估表格视图",
		},
		pickupgridview: {
			caption: "培训活动评估",
      		title: "培训活动评估选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "培训后评估", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训后评估标识", 
			srfmajortext: "培训后评估名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainactapplyid: "培训后评估标识", 
			evalcontents: "评估内容", 
			evaltarget: "评估对象", 
			pxjg: "评估结果", 
			evaltime: "评估时间", 
			dcwjtm: "调查问卷附件", 
			bz: "备注", 
			trmtrainactmentid: "培训后评估标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			evalcontents: "评估内容",
			evaltarget: "评估对象",
			pxjg: "评估结果",
			evaltime: "评估时间",
			bz: "备注",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainactapplyname_eq: "评估项目", 
			n_trmtrainactapplyid_eq: "", 
		},
		uiactions: {
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
};