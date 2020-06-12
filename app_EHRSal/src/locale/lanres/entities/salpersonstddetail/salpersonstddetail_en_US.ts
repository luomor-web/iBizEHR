
export default {
  fields: {
    ywz: '实际业务值',
    createdate: '建立时间',
    createman: '建立人',
    enable: '逻辑有效标志',
    xc: '薪酬',
    updatedate: '更新时间',
    ywms: '实际情况描述',
    salpersonstddetailname: '员工薪酬标准明细名称',
    salpersonstddetailid: '员工薪酬标准明细标识',
    updateman: '更新人',
    salpersonstdname: '员工薪酬标准名称',
    salschemeitemname: '要素项',
    salpersonstdid: '员工薪酬标准标识',
    salschemeitemid: '方案要素项标识',
  },
	views: {
		editview: {
			caption: "员工薪酬标准明细",
      title: '员工薪酬标准明细编辑视图',
		},
		gridview: {
			caption: "员工薪酬标准明细",
      title: '员工薪酬标准明细表格视图',
		},
	},
	main_form: {
		details: {
			group1: "标准明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "员工薪酬标准明细标识", 
			srfmajortext: "员工薪酬标准明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			salpersonstdid: "员工薪酬标准标识", 
			salschemeitemname: "要素项", 
			ywms: "实际情况描述", 
			xc: "薪酬", 
			salpersonstddetailid: "员工薪酬标准明细标识", 
			salschemeitemid: "方案要素项标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			salschemeitemname: "要素项",
			ywms: "实际情况描述",
			xc: "薪酬",
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
};