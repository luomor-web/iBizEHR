
export default {
  fields: {
    postinfo: "岗位",
    porgsectorid: "上级部门ID",
    ordernum: "组织排序编号",
    ouid: "所属OU的组织ID",
    ormorginfoid: "组织ID",
    shortname: "组织简称",
    orgcode: "组织编码",
    startstopsign: "启停标识",
    porgid: "上级组织ID",
    orgtypename: "组织类型释义",
    createdate: "建立时间",
    createman: "建立人",
    updatedate: "更新时间",
    belongregion: "所属区域",
    updateman: "更新人",
    orgtype: "组织类型",
    substandard: "补贴标准",
    ormorginfoname: "组织名称",
  },
	views: {
		subsubsuborggridview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		gridview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		redirectview: {
			caption: "组织信息",
      		title: "组织信息数据重定向视图",
		},
		subsuborggridview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		pickupview: {
			caption: "组织信息",
      		title: "组织信息数据选择视图",
		},
		orgtreegridview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		pickupgridview: {
			caption: "组织信息",
      		title: "组织信息选择表格视图",
		},
		editview2: {
			caption: "组织信息",
      		title: "组织信息编辑视图",
		},
		editview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		suborggridview: {
			caption: "组织管理",
      		title: "组织管理",
		},
		mpickupview: {
			caption: "组织信息",
      		title: "组织信息数据多项选择视图",
		},
		orgtreeexpview: {
			caption: "组织管理",
      		title: "组织管理",
		},
	},
	main_form: {
		details: {
			group1: "组织信息基本信息", 
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
			ormorginfoname: "组织名称", 
			createman: "建立人", 
			createdate: "建立时间", 
			updateman: "更新人", 
			updatedate: "更新时间", 
			ormorginfoid: "组织ID", 
		},
		uiactions: {
		},
	},
	person_grid: {
		columns: {
			orgcode: "员工编号",
			ormorginfoname: "员工姓名",
			belongregion: "证件号码",
			substandard: "手机号码",
			postinfo: "岗位",
			shortname: "员工状态",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ordernum: "排序",
			orgcode: "组织编码",
			shortname: "组织简称",
			ormorginfoname: "组织名称",
			belongregion: "所属区域",
			substandard: "补贴标准",
			startstopsign: "启停标识",
		},
		uiactions: {
		},
	},
	searchperson_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormorginfoname_like: "员工姓名", 
			n_orgcode_eq: "员工编号", 
			n_postinfo_like: "岗位", 
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormorginfoname_like: "组织名称", 
			n_orgcode_eq: "组织编码", 
			n_startstopsign_eq: "启停标识", 
		},
		uiactions: {
		},
	},
	subsubsuborggridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "Filter",
			tip: "Filter",
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
			caption: "新建组织",
			tip: "新建组织",
		},
		tbitem1_newrecorddep: {
			caption: "新建部门",
			tip: "新建部门",
		},
		tbitem1_newrecordpro: {
			caption: "新建项目部",
			tip: "新建项目部",
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
	subsuborggridviewtoolbar_toolbar: {
		tbitem1_newrecorddeplower: {
			caption: "新建部门",
			tip: "新建部门",
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
	orgtreegridviewtoolbar_toolbar: {
		tbitem1_newrecord: {
			caption: "新建组织",
			tip: "新建组织",
		},
		tbitem1_newrecorddep: {
			caption: "新建部门",
			tip: "新建部门",
		},
		tbitem1_newrecordpro: {
			caption: "新建项目部",
			tip: "新建项目部",
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
	suborggridviewtoolbar_toolbar: {
		tbitem1_newrecord: {
			caption: "新建组织",
			tip: "新建组织",
		},
		tbitem1_newrecorddep: {
			caption: "新建部门",
			tip: "新建部门",
		},
		tbitem1_newrecordpro: {
			caption: "新建项目部",
			tip: "新建项目部",
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
	ormorginfotree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};