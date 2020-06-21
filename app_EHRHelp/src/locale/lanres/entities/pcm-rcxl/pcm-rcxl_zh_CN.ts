export default {
  fields: {
    createdate: "建立时间",
    updateman: "更新人",
    code: "序列号",
    updatedate: "更新时间",
    rcxlmc: "人才序列名称",
    pcmrcxlid: "人才序列标识",
    snumber: "排序编码",
    rcxllx: "人才序列类型",
    pcmrcxlname: "人才序列名称",
    xldj: "序列等级",
    createman: "建立人",
    pcmrcxlname2: "上级",
    pcmrcxlid2: "人才序列标识",
  },
	views: {
		gridview: {
			caption: "人才序列",
      		title: "人才序列表格视图",
		},
		editview: {
			caption: "人才序列设置",
      		title: "人才序列设置",
		},
		pickupgridview: {
			caption: "人才序列",
      		title: "人才序列选择表格视图",
		},
		pickupview: {
			caption: "人才序列",
      		title: "人才序列数据选择视图",
		},
	},
	main_form: {
		details: {
			group1: "人才序列设置", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "人才序列标识", 
			srfmajortext: "人才序列名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			snumber: "排序编码", 
			rcxllx: "人才序列类型", 
			rcxlmc: "人才序列名称", 
			code: "序列号", 
			xldj: "序列等级", 
			pcmrcxlname2: "上级", 
			pcmrcxlid2: "人才序列标识", 
			pcmrcxlid: "人才序列标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			snumber: "排序编码",
			rcxllx: "人才序列类型",
			rcxlmc: "人才序列名称",
			code: "序列号",
			xldj: "序列等级",
			pcmrcxlname2: "上级",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_rcxllx_eq: "人才序列类型(=)", 
			n_pcmrcxlname_like: "人才序列名称(%)", 
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
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
		deuiaction3: {
			caption: "导入",
			tip: "导入",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
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
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
};