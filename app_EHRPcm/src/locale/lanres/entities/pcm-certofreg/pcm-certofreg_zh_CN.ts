export default {
  fields: {
    lx: "证书类型",
    createdate: "建立时间",
    pcmcertofregname: "证书名称",
    bh: "证书编号",
    updatedate: "更新时间",
    updateman: "更新人",
    createman: "建立人",
    pcmcertofregid: "注册证书标识",
    zsfj: "证书附件",
    certificatenumber: "证件号码",
    zyzgzy: "证书名称",
    pcmprofilename: "姓名",
    pimqualmajorid: "执业资格专业编码",
    pcmprofileid: "应聘者ID",
  },
	views: {
		editview: {
			caption: "注册证书",
      		title: "注册证书编辑视图",
		},
		zczs_wsswbjgridview: {
			caption: "注册证书",
      		title: "注册证书",
		},
		zczsgridview: {
			caption: "注册证书（要求：带*必填）",
      		title: "注册证书（要求：带*必填）",
		},
	},
	main_form: {
		details: {
			group1: "注册证书基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "注册证书标识", 
			srfmajortext: "证书名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmcertofregname: "证书名称", 
			zyzgzy: "注册证书", 
			pcmprofileid: "应聘者ID", 
			pcmcertofregid: "注册证书标识", 
			pimqualmajorid: "执业资格专业编码", 
		},
		uiactions: {
		},
	},
	ck_grid: {
		columns: {
			zyzgzy: "证书名称（*）",
			zsfj: "证书附件",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			zyzgzy: "证书名称（*）",
			zsfj: "证书附件",
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
	zczs_wsswbjgridviewtoolbar_toolbar: {
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	zczsgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "导出",
			tip: "导出",
		},
	},
};