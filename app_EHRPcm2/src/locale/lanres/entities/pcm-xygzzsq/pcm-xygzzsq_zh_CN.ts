export default {
  fields: {
    istemp: "是否为临时数据",
    updateman: "更新人",
    orgid: "组织机构标识",
    pcmxygzzsqid: "试用期员工转正申请标识",
    updatedate: "更新时间",
    czr: "操作人",
    sxrq: "生效日期",
    createman: "建立人",
    pcmxygzzsqname: "试用期员工转正申请名称",
    bz: "备注",
    zzlx: "转正类型",
    czrq: "操作日期",
    createdate: "建立时间",
  },
	views: {
		gridview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请表格视图",
		},
		mpickupview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请数据多项选择视图",
		},
		pickupgridview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请选择表格视图",
		},
		pickupview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请数据选择视图",
		},
		redirectview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请数据重定向视图",
		},
		editview2: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请编辑视图",
		},
		zzsqjmeditview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正",
		},
		editview: {
			caption: "试用期员工转正申请",
      		title: "试用期员工转正申请编辑视图",
		},
	},
	main_form: {
		details: {
			druipart1: "", 
			druipart2: "", 
			group1: "试用期员工转正申请基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "试用期员工转正申请标识", 
			srfmajortext: "试用期员工转正申请名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmxygzzsqname: "标题", 
			czr: "操作人", 
			czrq: "操作日期", 
			sxrq: "生效日期", 
			zzlx: "转正类型", 
			bz: "备注", 
			pcmxygzzsqid: "试用期员工转正申请标识", 
		},
		uiactions: {
		},
	},
	xygzz_form: {
		details: {
			group1: "试用期转正基本信息", 
			druipart2: "", 
			grouppanel1: "试用期转正明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "试用期员工转正申请标识", 
			srfmajortext: "试用期员工转正申请名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmxygzzsqid: "试用期员工转正申请标识", 
			pcmxygzzsqname: "标题", 
			czr: "操作人", 
			czrq: "操作时间", 
			sxrq: "生效日期", 
			zzlx: "转正类型", 
			bz: "备注", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pcmxygzzsqname: "标题",
			czr: "操作人",
			czrq: "操作日期",
			sxrq: "生效日期",
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
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
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
	editview2toolbar_toolbar: {
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
	zzsqjmeditviewtoolbar_toolbar: {
		deuiaction2_saveandexit: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
};