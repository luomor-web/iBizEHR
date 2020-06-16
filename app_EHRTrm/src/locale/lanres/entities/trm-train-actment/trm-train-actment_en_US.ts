
export default {
  fields: {
    dcwjtm: '调查问卷题目',
    createman: '建立人',
    bz: '备注',
    updateman: '更新人',
    trmtrainactmentid: '培训活动评估标识',
    updatedate: '更新时间',
    createdate: '建立时间',
    enable: '逻辑有效标志',
    pxjg: '评估结果',
    trmtrainactmentname: '培训活动评估名称',
    trmtrainactapplyname: '培训活动申请名称',
    trmtrainactapplyid: '培训活动申请标识',
  },
	views: {
		editview: {
			caption: "培训活动评估",
      title: '培训活动评估编辑视图',
		},
		pickupview: {
			caption: "培训活动评估",
      title: '培训活动评估数据选择视图',
		},
		mpickupview: {
			caption: "培训活动评估",
      title: '培训活动评估数据多项选择视图',
		},
		gridview: {
			caption: "培训活动评估",
      title: '培训活动评估表格视图',
		},
		pickupgridview: {
			caption: "培训活动评估",
      title: '培训活动评估选择表格视图',
		},
	},
	main_form: {
		details: {
			group1: "培训活动评估信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训活动评估标识", 
			srfmajortext: "培训活动评估名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrainactapplyid: "培训活动申请标识", 
			trmtrainactapplyname: "评估项目", 
			pxjg: "评估结果", 
			dcwjtm: "调查问卷题目", 
			bz: "备注", 
			trmtrainactmentid: "培训活动评估标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrainactapplyname: "评估项目",
			pxjg: "评估结果",
			dcwjtm: "调查问卷题目",
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
			caption: "Save",
			tip: "Save",
		},
		tbitem4: {
			caption: "Save And New",
			tip: "Save And New",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
};