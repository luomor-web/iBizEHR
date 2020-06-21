
export default {
  fields: {
    kssj: "开始时间",
    jssj: "结束时间",
    updatedate: "更新时间",
    je: "金额",
    hdsm: "活动说明",
    createdate: "建立时间",
    updateman: "更新人",
    enable: "逻辑有效标志",
    orgid: "组织iD",
    trmlgbcostname: "活动",
    trmlgbcostid: "老干部费用标识",
    createman: "建立人",
    memo: "附件",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
  },
	views: {
		editview: {
			caption: "老干部活动管理",
      		title: "老干部活动管理",
		},
		gridview: {
			caption: "老干部活动管理",
      		title: "老干部活动管理",
		},
	},
	main_form: {
		details: {
			group1: "老干部活动管理", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "老干部费用标识", 
			srfmajortext: "活动", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmlgbcostname: "活动", 
			kssj: "开始时间", 
			jssj: "结束时间", 
			je: "金额", 
			hdsm: "活动说明", 
			memo: "附件", 
			ormorgid: "组织标识", 
			trmlgbcostid: "老干部费用标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmlgbcostname: "活动",
			kssj: "开始时间",
			jssj: "结束时间",
			je: "金额",
			hdsm: "活动说明",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmlgbcostname_like: "活动(%)", 
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