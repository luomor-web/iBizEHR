
export default {
  fields: {
    orgtype: "组织类型",
    towncity: "省市",
    isenable: "是否有效",
    updateman: "更新人",
    dateto: "有效期至",
    orgaddressline1: "组织地址1",
    createman: "建立人",
    orgtypename: "组织类型释义",
    orgaddressline3: "组织地址3",
    orgaddressline2: "组织地址2",
    createdate: "建立时间",
    ormerporgid: "组织ID",
    oucode: "所属OU的组织编码",
    belongou: "所属OU的组织名称",
    lastupdatedate: "最近更新时间",
    datefrom: "有效期从",
    admcoding: "行政编码",
    yyflag: "引用标志",
    orgshortname: "组织简称",
    ormerporgname: "组织名称",
    orgcreatedate: "创建日期",
    parentorgid: "父级组织ID",
    ordernum: "组织排序编号",
    updatedate: "更新时间",
    orgzipcode: "邮编",
    ouid: "所属OU的组织ID",
    numcomp: "人数编制",
    orgcode: "组织编码",
  },
	views: {
		editview2: {
			caption: "ERP组织中间表",
      		title: "ERP组织中间表编辑视图",
		},
		redirectview: {
			caption: "ERP组织中间表",
      		title: "ERP组织中间表数据重定向视图",
		},
		pickupview: {
			caption: "ERP组织库",
      		title: "ERP组织库",
		},
		pickupgridview: {
			caption: "ERP组织库",
      		title: "ERP组织库",
		},
		editview: {
			caption: "ERP组织中间表",
      		title: "ERP组织中间表编辑视图",
		},
		legalpickupview: {
			caption: "管理单位",
      		title: "管理单位",
		},
		orgsectorgridview: {
			caption: "ERP组织库",
      		title: "ERP组织库",
		},
		legalmpickupview: {
			caption: "管理单位",
      		title: "管理单位",
		},
		mpickupview: {
			caption: "ERP组织中间表",
      		title: "ERP组织中间表数据多项选择视图",
		},
		legalpickupgridview: {
			caption: "管理单位",
      		title: "管理单位",
		},
		gridview: {
			caption: "ERP组织库",
      		title: "ERP组织库",
		},
		suborgsectorgridview: {
			caption: "ERP组织库",
      		title: "ERP组织库",
		},
	},
	main_form: {
		details: {
			group1: "ERP组织中间表基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "组织ID", 
			srfmajortext: "组织名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormerporgname: "组织名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			ormerporgid: "组织ID", 
		},
		uiactions: {
		},
	},
	magunitgrid_grid: {
		columns: {
			ormerporgname: "组织名称",
			orgcode: "组织编码",
			orgtype: "组织类型",
			orgtypename: "组织类型释义",
		},
		uiactions: {
		},
	},
	neworg_grid: {
		columns: {
			yyflag: "引用标志",
			ormerporgname: "组织名称",
			orgcode: "组织编码",
			orgtype: "组织类型",
			orgtypename: "组织类型释义",
			belongou: "所属OU",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			yyflag: "引用标志",
			ormerporgname: "组织名称",
			orgcode: "组织编码",
			orgtype: "组织类型",
			orgtypename: "组织类型释义",
			belongou: "所属OU",
			numcomp: "人数编制",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_orgcode_like: "组织编码", 
			n_ormerporgname_like: "组织名称", 
		},
		uiactions: {
		},
	},
	legalpickupgridviewtoolbar_toolbar: {
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
		tbitem1_newrecord: {
			caption: "确认",
			tip: "新建组织",
		},
		tbitem1_synorg: {
			caption: "同步ERP组织信息",
			tip: "从ERP系统中同步组织信息",
		},
		deuiaction1: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	orgsectorgridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction1: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
		},
	},
	orgsectorgridviewtoolbar_toolbar: {
		deuiaction3_newrecorddep: {
			caption: "确认",
			tip: "新建部门",
		},
		deuiaction3_synorg: {
			caption: "同步ERP组织信息",
			tip: "从ERP系统中同步组织信息",
		},
		deuiaction6: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction1: {
			caption: "Filter",
			tip: "Filter",
		},
		deuiaction5: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	pickupgridviewtoolbar_toolbar: {
		tbitem1_newrecord: {
			caption: "确认",
			tip: "新建组织",
		},
		tbitem1_synorg: {
			caption: "同步ERP组织信息",
			tip: "从ERP系统中同步组织信息",
		},
	},
	suborgsectorgridviewtoolbar_toolbar: {
		tbitem1_newrecorddeplower: {
			caption: "确认",
			tip: "新建部门",
		},
		tbitem1_synorg: {
			caption: "同步ERP组织信息",
			tip: "从ERP系统中同步组织信息",
		},
		deuiaction1: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
};