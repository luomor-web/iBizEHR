
export default {
  fields: {
    bz: "备注",
    vacsynjcxid: "年休假查询标识",
    yynj: "已用天数",
    createdate: "建立时间",
    createman: "建立人",
    synjts: "剩余天数",
    bnts: "应休天数",
    ksyxsj: "开始有效时间",
    updatedate: "更新时间",
    vacsynjcxname: "年休假查询名称",
    sjbnts: "实休天数",
    nd: "年度",
    jsyxsj: "结束有效时间",
    bcts: "补偿天数（停用）",
    orgid: "组织id",
    updateman: "更新人",
    zz: "组织名称",
    bm: "部门名称",
    pimpersonname: "员工姓名",
    gly: "工龄（年）",
    ygbh: "员工编号",
    ormorgid: "组织标识",
    pimpersonid: "员工信息标识",
  },
	views: {
		gridview: {
			caption: "年休假查询",
      		title: "年休假查询",
		},
		editview: {
			caption: "年休假查询",
      		title: "年休假查询编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "年休假查询基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "年休假查询标识", 
			srfmajortext: "年休假查询名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "员工姓名", 
			ygbh: "员工编号", 
			nd: "年度", 
			gly: "工龄（年）", 
			zz: "组织名称", 
			bm: "部门名称", 
			sjbnts: "实休天数", 
			bnts: "应休天数", 
			yynj: "已用天数", 
			synjts: "剩余天数", 
			ksyxsj: "开始有效时间", 
			jsyxsj: "结束有效时间", 
			bz: "备注", 
			vacsynjcxid: "年休假查询标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			nd: "年度",
			gly: "工龄（年）",
			zz: "组织名称",
			bm: "部门名称",
			sjbnts: "实休天数",
			bnts: "应休天数",
			yynj: "已用天数",
			synjts: "剩余天数",
			ksyxsj: "开始有效时间",
			jsyxsj: "结束有效时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名(%)", 
			n_nd_eq: "年度(=)", 
			n_zz_like: "组织名称(%)", 
			n_bm_like: "部门名称(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
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