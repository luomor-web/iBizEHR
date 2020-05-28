
export default {
  fields: {
    createman: '建立人',
    dh: '资格证书代码',
    pimvocationalcatalogname: '职（执）业资格名称',
    createdate: '建立时间',
    updatedate: '更新时间',
    pimvocationalcatalogid: '职（执）业资格管理标识',
    updateman: '更新人',
    pxh: '排序号',
    enable: '逻辑有效标志',
  },
	views: {
		mpickupview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		editview2: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		redirectview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		pickupgridview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		pickupview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		editview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
		gridview: {
			caption: "执（职）业资格管理",
      title: '执（职）业资格管理',
		},
	},
	main_form: {
		details: {
			group1: "执（职）业资格信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "职（执）业资格管理标识", 
			srfmajortext: "职（执）业资格名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pxh: "排序号", 
			dh: "资格证书代码", 
			pimvocationalcatalogname: "资格证书名称", 
			pimvocationalcatalogid: "职（执）业资格管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pxh: "排序号",
			dh: "资格证书代码",
			pimvocationalcatalogname: "资格证书名称",
			updateman: "更新人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_dh_eq: "资格证书代码(=)", 
			n_pimvocationalcatalogname_like: "资格证书名称", 
		},
		uiactions: {
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
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
};