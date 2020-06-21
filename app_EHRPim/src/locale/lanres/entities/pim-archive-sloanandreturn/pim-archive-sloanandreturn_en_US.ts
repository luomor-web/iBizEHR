
export default {
  fields: {
    jyr: "借阅人",
    createman: "建立人",
    spdate: "审批时间",
    enable: "逻辑有效标志",
    pimarchivesloanandreturnid: "档案借阅及归还记录标识",
    jyyy: "借阅原因",
    ghrq: "归还时间",
    zt: "状态",
    jyqssj: "借阅时间",
    createdate: "建立时间",
    pimarchivesloanandreturnname: "档案借阅及归还记录名称",
    spperson: "审批同意人",
    updatedate: "更新时间",
    updateman: "更新人",
    pimarchivesname: "档案信息名称",
    pimpersonname2: "借阅人",
    pimpersonname3: "审批人",
    pimpersonname: "员工姓名",
    pimpersonid3: "人员信息标识",
    pimpersonid: "人员信息标识",
    pimarchivesid: "档案信息标识",
    pimpersonid2: "人员信息标识",
  },
	views: {
		pickupgridview: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录选择表格视图",
		},
		redirectview: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录数据重定向视图",
		},
		editview2: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录编辑视图",
		},
		editview: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录编辑视图",
		},
		pickupview: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录数据选择视图",
		},
		gridview: {
			caption: "借阅记录",
      		title: "借阅记录表格视图",
		},
		mpickupview: {
			caption: "档案借阅及归还记录",
      		title: "档案借阅及归还记录数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "借阅记录", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "档案借阅及归还记录标识", 
			srfmajortext: "档案借阅及归还记录名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			jyr: "借阅人", 
			jyqssj: "借阅时间", 
			ghrq: "归还时间", 
			jyyy: "借阅原因", 
			spperson: "审批同意人", 
			spdate: "审批时间", 
			zt: "状态", 
			pimarchivesid: "档案信息标识", 
			pimpersonid3: "人员信息标识", 
			pimarchivesloanandreturnid: "档案借阅及归还记录标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			jyr: "借阅人",
			jyqssj: "借阅时间",
			ghrq: "归还时间",
			pimpersonname3: "审批人",
			spdate: "审批时间",
			jyyy: "借阅原因",
			zt: "状态",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pimpersonname_like: "员工姓名", 
			n_zt_eq: "状态(=)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
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