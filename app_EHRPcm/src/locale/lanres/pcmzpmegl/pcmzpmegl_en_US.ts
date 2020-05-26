
export default {
  fields: {
    orgid: '组织ID',
    nd: '年度',
    sfce_szy: '是否超额（社招Y）',
    pcmzpmeglname: '招聘名额管理名称',
    xh: '排序号',
    createdate: '建立时间',
    xyzpbme: '校招B名额',
    ybdrs_szjhw: '已使用名额（社招计划外）',
    sfce_xza: '是否超额（校招A）',
    sfce_szb: '是否超额（社招B）',
    ybdrs_xzxzy: '已使用名额（校招小专业）',
    createman: '建立人',
    sfce_szjhw: '是否超额（社招计划外）',
    fpme_szb: '分配名额（社招B）',
    pcmzpmeglid: '招聘名额管理标识',
    shzpyme: '社招Y名额',
    ybdrs_xza: '已使用名额（校招A）',
    fpme_szjhw: '分配名额（社招计划外）',
    ybdrs_szb: '已使用名额（社招B）',
    shzpbme: '社招B名额',
    fpme_xzxzy: '分配名额（校招小专业）',
    shzpjhwme: '社招计划外名额',
    pfcs: '批复次数',
    fpme_szy: '分配名额（社招Y）',
    xyzpame: '校招A名额',
    xyzpxzyme: '校招小专业名额',
    sfce_sza: '是否超额（社招A）',
    fpme_xzb: '分配名额（校招B）',
    ybdrs_sza: '已使用名额（社招A）',
    updatedate: '更新时间',
    sfce_xzb: '是否超额（校招B）',
    fpme_xza: '分配名额（校招A）',
    ybdrs_xzb: '已使用名额（校招B）',
    fpme_sza: '分配名额（社招A）',
    sfce_xzxzy: '是否超额（校招小专业）',
    updateman: '更新人',
    ybdrs_szy: '已使用名额（社招Y）',
    shzpame: '社招A名额',
    zzdzs: '组织',
    ormorgname: '组织',
    ormorgid: '组织标识',
  },
	views: {
		treeexpview: {
			caption: "招聘名额管理",
      title: '招聘名额管理',
		},
		curndgridview: {
			caption: "招聘名额管理",
      title: '招聘名额管理',
		},
		editview: {
			caption: "招聘名额管理",
      title: '招聘名额管理',
		},
	},
	main_form: {
		details: {
			group1: "招聘名额信息", 
			grouppanel2: "招聘名额分类", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "招聘名额管理标识", 
			srfmajortext: "招聘名额管理名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			nd: "年度", 
			ormorgid: "组织标识", 
			ormorgname: "组织", 
			xyzpame: "校招A名额", 
			ybdrs_xza: "已使用名额（校招A）", 
			sfce_xza: "是否超额（校招A）", 
			xyzpbme: "校招B名额", 
			ybdrs_xzb: "已使用名额（校招B）", 
			sfce_xzb: "是否超额（校招B）", 
			xyzpxzyme: "校招小专业名额", 
			ybdrs_xzxzy: "已使用名额（校招小专业）", 
			sfce_xzxzy: "是否超额（校招小专业）", 
			shzpame: "社招A名额", 
			ybdrs_sza: "已使用名额（社招A）", 
			sfce_sza: "是否超额（社招A）", 
			shzpbme: "社招B名额", 
			ybdrs_szb: "已使用名额（社招B）", 
			sfce_szb: "是否超额（社招B）", 
			shzpyme: "社招Y名额", 
			ybdrs_szy: "已使用名额（社招Y）", 
			sfce_szy: "是否超额（社招Y）", 
			shzpjhwme: "社招计划外名额", 
			ybdrs_szjhw: "已使用名额（社招计划外）", 
			sfce_szjhw: "是否超额（社招计划外）", 
			pcmzpmeglid: "招聘名额管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			nd: "年度",
			zzdzs: "组织",
			pfcs: "批复次数",
			fpme_xza: "分配名额（校招A）",
			fpme_xzb: "分配名额（校招B）",
			fpme_xzxzy: "分配名额（校招小专业）",
			fpme_sza: "分配名额（社招A）",
			fpme_szb: "分配名额（社招B）",
			fpme_szy: "分配名额（社招Y）",
			fpme_szjhw: "分配名额（社招计划外）",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_nd_eq: "年度(=)", 
			n_ormorgname_eq: "组织(=)", 
			n_ormorgid_eq: "", 
		},
		uiactions: {
		},
	},
	curndgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
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
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
	zpmenftree_treeview: {
		nodes: {
			root: '默认根节点',
		},
		uiactions: {
		},
	},
};