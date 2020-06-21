export default {
  fields: {
    dd: "地址",
    trmtrainfaciesid: "培训设施标识",
    sb: "特殊设备",
    sffc: "是否封存",
    updateman: "更新人",
    yysb: "影音设备",
    sslb: "类型",
    bgsb: "办公设备",
    updatedate: "更新时间",
    dgsb: "灯光设备",
    trmtrainfaciesname: "培训设施名称",
    ssbm: "设施编码",
    sfgx: "是否共享",
    createman: "建立人",
    sssl: "可容纳人数",
    sszp: "设施照片",
    enable: "逻辑有效标志",
    createdate: "建立时间",
    trmtrainaddressname: "培训地点",
    trmtrainaddressid: "培训地点标识",
  },
	views: {
		gridview: {
			caption: "培训设施",
      		title: "培训设施表格视图",
		},
		editview: {
			caption: "培训设施",
      		title: "培训设施",
		},
	},
	main_form: {
		details: {
			group1: "培训设施信息", 
			grouppanel1: "影音设备", 
			grouppanel2: "办公设备", 
			grouppanel3: "灯光设备", 
			grouppanel4: "特殊设备", 
			grouppanel5: "设施照片", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训设施标识", 
			srfmajortext: "培训设施名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sslb: "类型", 
			sssl: "可容纳人数", 
			dd: "地址", 
			trmtrainaddressid: "培训地点标识", 
			yysb: "", 
			bgsb: "", 
			dgsb: "", 
			sb: "", 
			sszp: "设施照片", 
			trmtrainfaciesid: "培训设施标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sslb: "类型",
			sssl: "可容纳人数",
			dd: "地址",
			yysb: "影音设备",
			bgsb: "办公设备",
			dgsb: "灯光设备",
			sb: "特殊设备",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainfaciesname_like: "培训设施名称(%)", 
			n_sslb_eq: "类型(=)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem5: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
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
	},
};