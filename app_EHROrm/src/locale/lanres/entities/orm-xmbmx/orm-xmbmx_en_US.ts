
export default {
  fields: {
    xh: "排序号",
    updatedate: "更新时间",
    ormxmbmxname: "项目部明细名称",
    ormxmbmxid: "项目部明细标识",
    zsmc: "证书名称",
    createdate: "建立时间",
    zsbh: "证书编号",
    updateman: "更新人",
    createman: "建立人",
    xmrylx: "项目人员类型",
    ormorgsectorname: "项目部名称",
    pimpersonname: "员工姓名",
    ormorgsectorid: "项目部ID",
    pimpersonid: "人员ID",
  },
	views: {
		editview: {
			caption: "项目部人员明细",
      		title: "项目部人员明细",
		},
		pickupview: {
			caption: "项目部明细",
      		title: "项目部明细数据选择视图",
		},
		mpickupview: {
			caption: "项目部明细",
      		title: "项目部明细数据多项选择视图",
		},
		redirectview: {
			caption: "项目部明细",
      		title: "项目部明细数据重定向视图",
		},
		gridview: {
			caption: "项目部人员明细",
      		title: "项目部人员明细",
		},
		editview2: {
			caption: "项目部明细",
      		title: "项目部明细编辑视图",
		},
		pickupgridview: {
			caption: "项目部明细",
      		title: "项目部明细选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "项目部成立人员明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "项目部明细标识", 
			srfmajortext: "项目部明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			pimpersonid: "人员ID", 
			ormorgsectorid: "项目部ID", 
			pimpersonname: "项目部人员", 
			ormorgsectorname: "项目部名称", 
			xmrylx: "项目人员类型", 
			zsmc: "证书名称", 
			zsbh: "证书编号", 
			ormxmbmxid: "项目部明细标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			pimpersonname: "员工姓名",
			xmrylx: "项目人员类型",
			zsmc: "证书名称",
			zsbh: "证书编号",
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
	gridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
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