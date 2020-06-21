
export default {
  fields: {
    ffsj: "发放时间",
    ffrs: "发放人数",
    orgid: "组织ID",
    fyje: "费用金额",
    updateman: "更新人",
    pimexpaccountname: "费用台账名称",
    createdate: "建立时间",
    ffybz: "费用标准",
    updatedate: "更新时间",
    pimexpaccountid: "费用台账标识",
    createman: "建立人",
    bz: "备注",
    fylb: "费用类别",
    ormorgname: "组织名称",
    ormorgid: "组织标识",
  },
	views: {
		editview: {
			caption: "费用台账",
      		title: "费用台账编辑视图",
		},
		pickupgridview: {
			caption: "费用台账",
      		title: "费用台账选择表格视图",
		},
		gridview: {
			caption: "费用台账",
      		title: "费用台账表格视图",
		},
		mpickupview: {
			caption: "费用台账",
      		title: "费用台账数据多项选择视图",
		},
		editview2: {
			caption: "费用台账",
      		title: "费用台账编辑视图",
		},
		pickupview: {
			caption: "费用台账",
      		title: "费用台账数据选择视图",
		},
		redirectview: {
			caption: "费用台账",
      		title: "费用台账数据重定向视图",
		},
	},
	main_form: {
		details: {
			group1: "费用台账基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "费用台账标识", 
			srfmajortext: "费用台账名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			fylb: "费用类别", 
			fyje: "费用金额", 
			ffrs: "发放人数", 
			ffsj: "发放时间", 
			ffybz: "费用标准", 
			bz: "备注", 
			ormorgid: "组织标识", 
			pimexpaccountid: "费用台账标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			fylb: "费用类别",
			fyje: "费用金额",
			ffrs: "发放人数",
			ffsj: "发放时间",
			ffybz: "费用标准",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_fylb_eq: "费用类别(=)", 
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
	editview2toolbar_toolbar: {
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
};