export default {
  fields: {
    zlh: "专利号(*)",
    updatedate: "更新时间",
    pimpatentid: "专利信息编码",
    orgid: "组织ID",
    jlss: "记录所属",
    orgsectorid: "部门ID",
    zlhqsj: "专利获取时间(*)",
    jlspzt: "审批状态",
    jlczz: "记录操作者",
    enable: "逻辑有效标志",
    pimpatentname: "专利名称(*)",
    updateman: "更新人",
    jlglbh: "记录管理编号",
    reason: "拒绝原因",
    createman: "建立人",
    enclolure: "附件",
    createdate: "建立时间",
    zlpzgb: "专利批准国别(*)",
    pimpersonname: "员工姓名",
    ygbh: "员工编号",
    ormorgsectorid: "部门标识",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		greditview: {
			caption: "专利信息",
      		title: "专利信息编辑视图",
		},
		grpatentgridview: {
			caption: "专利信息",
      		title: "专利信息表格视图",
		},
	},
	grpatenteditform_form: {
		details: {
			group1: "专利信息基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "专利信息编码", 
			srfmajortext: "专利名称(*)", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			zlh: "专利号(*)", 
			pimpatentname: "专利名称(*)", 
			zlpzgb: "专利批准国别(*)", 
			zlhqsj: "专利获取时间(*)", 
			pimpersonid: "人员信息标识", 
			jlss: "记录所属", 
			enclolure: "附件", 
			pimpatentid: "专利信息编码", 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			zlh: "专利号(*)",
			pimpatentname: "专利名称(*)",
			zlhqsj: "专利获取时间(*)",
			zlpzgb: "专利批准国别(*)",
			enclolure: "附件",
			jlspzt: "审批状态",
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
	greditviewtoolbar_toolbar: {
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
	grpatentgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "提交",
			tip: "提交",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
	},
	grpatentgridviewtoolbar_toolbar: {
		deuiaction5: {
			caption: "帮助",
			tip: "帮助",
		},
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
	},
};