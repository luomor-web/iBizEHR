export default {
  fields: {
    lxfs: "联系电话",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    createman: "建立人",
    legalperosn: "法人",
    orgid: "组织ID",
    updateman: "更新人",
    regcapital: "注册资本金",
    pimlabourcampanyname: "公司名称",
    jyfw: "经营范围",
    pimlabourcampanyid: "劳务派遣公司管理标识",
    lxr: "联系人",
    gsjj: "公司简介",
    updatedate: "更新时间",
    lxdz: "联系地址",
    pimpersonname: "人员信息名称",
    ormorgname: "所属单位",
    zzdzs: "所属单位",
    pimpersonid: "人员信息标识",
    ormorgid: "组织标识",
  },
	views: {
		pickupview: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司管理数据选择视图",
		},
		mpickupview: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司管理数据多项选择视图",
		},
		pickupgridview: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司管理选择表格视图",
		},
		editview2: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司管理编辑视图",
		},
		editview: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司编辑视图",
		},
		redirectview: {
			caption: "劳务派遣公司管理",
      		title: "劳务派遣公司管理数据重定向视图",
		},
		gridview: {
			caption: "劳务派遣公司",
      		title: "劳务派遣公司表格视图",
		},
	},
	main_form: {
		details: {
			group1: "劳务派遣公司信息", 
			druipart1: "", 
			grouppanel1: "劳务合同", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "劳务派遣公司管理标识", 
			srfmajortext: "公司名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimlabourcampanyname: "公司名称", 
			ormorgname: "所属单位", 
			lxdz: "联系地址", 
			lxr: "联系人", 
			lxfs: "联系电话", 
			ormorgid: "组织标识", 
			legalperosn: "法人", 
			regcapital: "注册资本金", 
			gsjj: "公司简介", 
			pimlabourcampanyid: "劳务派遣公司管理标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimlabourcampanyname: "公司名称",
			zzdzs: "所属单位",
			lxdz: "联系地址",
			lxr: "联系人",
			lxfs: "联系电话",
			regcapital: "注册资本金",
			legalperosn: "法人",
			updatedate: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimlabourcampanyname_like: "公司名称", 
			n_lxr_like: "联系人(%)", 
		},
		uiactions: {
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
};