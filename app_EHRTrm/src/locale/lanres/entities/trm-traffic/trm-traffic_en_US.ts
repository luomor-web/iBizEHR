
export default {
  fields: {
    trmtrafficid: "交通标识",
    createdate: "建立时间",
    updateman: "更新人",
    jtfs: "交通方式",
    createman: "建立人",
    enable: "逻辑有效标志",
    zm: "站名",
    trmtrafficname: "交通名称",
    xlmc: "交通线路",
    ck: "出口",
    mdd: "目的地",
    cfd: "出发地",
    updatedate: "更新时间",
    trmtrainaddressname: "培训地点",
    trmtrainaddressid: "培训地点标识",
  },
	views: {
		gridview: {
			caption: "交通信息",
      		title: "交通信息",
		},
		editview: {
			caption: "交通信息",
      		title: "交通信息",
		},
	},
	main_form: {
		details: {
			group1: "基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "交通标识", 
			srfmajortext: "交通名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmtrafficname: "交通名称", 
			jtfs: "交通方式", 
			xlmc: "交通线路", 
			trmtrainaddressid: "培训地点标识", 
			trmtrafficid: "交通标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrafficname: "交通名称",
			jtfs: "交通方式",
			xlmc: "交通线路",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrafficname_like: "交通名称(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
};