
export default {
  fields: {
    szqz: '考核权重（%）',
    parkhzcmxid: '考核内容标识',
    createman: '建立人',
    updateman: '更新人',
    sfqy: '是否启用',
    parkhzcmxname: '考核内容',
    createdate: '建立时间',
    updatedate: '更新时间',
    khdx: '考核对象',
    parjxkhjcszname: '考核方案',
    parjxkhjcszid: '考核方案ID',
  },
	views: {
		pickupgridview: {
			caption: "考核内容",
      title: '考核组成明细选择表格视图',
		},
		editview: {
			caption: "考核内容",
      title: '考核组成明细编辑视图',
		},
		pickupview: {
			caption: "考核内容",
      title: '考核组成明细数据选择视图',
		},
	},
	main_form: {
		details: {
			group1: "考核内容组成", 
			druipart1: "", 
			grouppanel1: "评分主体权重", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "考核内容标识", 
			srfmajortext: "考核内容", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			parjxkhjcszid: "考核方案ID", 
			parjxkhjcszname: "考核方案", 
			parkhzcmxid: "考核内容标识", 
			parkhzcmxname: "考核内容", 
			szqz: "考核权重（%）", 
			khdx: "考核对象", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			parkhzcmxname: "考核内容",
			szqz: "考核权重（%）",
			uagridcolumn1: "设置评分权重",
		},
		uiactions: {
			szpfzt: "设置评分权重",
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
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
};