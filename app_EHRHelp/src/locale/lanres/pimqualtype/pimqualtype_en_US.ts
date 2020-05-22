
export default {
  fields: {
    enable: '逻辑有效标志',
    updateman: '更新人',
    updatedate: '更新时间',
    createman: '建立人',
    seialno: '排序号',
    pimqualtypeid: '岗位（技能）证书目录ID',
    createdate: '建立时间',
    pimqualtypename: '岗位（技能）证书',
  },
	views: {
		pickupview: {
			caption: "岗位（技能）证书",
      title: '岗位（技能）证书',
		},
		pickupgridview: {
			caption: "岗位（技能）证书",
      title: '岗位（技能）证书',
		},
		gridview: {
			caption: "岗位（技能）证书",
      title: '岗位（技能）证书',
		},
		editview: {
			caption: "岗位（技能）证书",
      title: '岗位（技能）证书',
		},
	},
	main_form: {
		details: {
			group1: "岗位（技能）证书", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "岗位（技能）证书目录ID", 
			srfmajortext: "岗位（技能）证书", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			seialno: "排序号", 
			pimqualtypename: "岗位（技能）证书", 
			pimqualtypeid: "岗位（技能）证书目录ID", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			seialno: "排序号",
			pimqualtypename: "岗位（技能）证书",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimqualtypename_like: "岗位（技能）证书(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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