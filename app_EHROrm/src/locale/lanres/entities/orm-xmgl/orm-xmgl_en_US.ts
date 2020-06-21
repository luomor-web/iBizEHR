
export default {
  fields: {
    ehr_org_id: "EHR组织ID",
    target_finish_date: "项目结束时间",
    isdirectlymanage: "是否局直管",
    project_name: "项目名称",
    ormxmglname: "项目名称",
    engineeringbustype: "工程业务类型",
    project_type: "项目类型",
    project_status_code: "项目状态",
    project_status_name: "项目状态释义",
    createdate: "建立时间",
    updateman: "更新人",
    engineeringscale: "工程规模",
    engineeringpurpose: "工程用途",
    project_size: "项目规模",
    ormxmglid: "项目管理标识",
    xmbh: "项目备用属性",
    project_full_name: "项目全称",
    org_id: "ERP组织ID",
    procapitalatt: "项目资金属性",
    project_number: "项目编号",
    target_start_date: "项目开始时间",
    createman: "建立人",
    updatedate: "更新时间",
  },
	views: {
		editview: {
			caption: "ERP项目",
      		title: "ERP项目信息",
		},
		pickupview: {
			caption: "ERP项目库",
      		title: "ERP项目库",
		},
		editview2: {
			caption: "项目管理",
      		title: "项目管理编辑视图",
		},
		mpickupview: {
			caption: "ERP项目库",
      		title: "ERP项目库",
		},
		redirectview: {
			caption: "项目管理",
      		title: "项目管理数据重定向视图",
		},
		pickupgridview: {
			caption: "ERP项目库",
      		title: "ERP项目库",
		},
		gridview: {
			caption: "ERP项目",
      		title: "ERP项目信息",
		},
	},
	main_form: {
		details: {
			group1: "ERP项目信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "项目管理标识", 
			srfmajortext: "项目名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ormxmglid: "项目ID", 
			project_number: "项目编号", 
			project_name: "项目名称", 
			project_type: "项目类型", 
			org_id: "ERP组织ID", 
			project_full_name: "项目全称", 
			project_status_code: "项目状态", 
			project_status_name: "项目状态", 
			project_size: "项目规模说明", 
			target_start_date: "项目开始时间", 
			target_finish_date: "项目结束时间", 
			engineeringbustype: "工程业务类型", 
			engineeringpurpose: "工程用途", 
			engineeringscale: "工程规模", 
			isdirectlymanage: "是否局直管", 
			procapitalatt: "项目资金属性", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			project_number: "项目编号",
			project_name: "项目名称",
			project_type: "项目类型",
			project_full_name: "项目全称",
			project_status_name: "项目状态",
			target_start_date: "项目开始时间",
			target_finish_date: "项目结束时间",
			engineeringbustype: "工程业务类型",
			engineeringpurpose: "工程用途",
			engineeringscale: "工程规模",
			isdirectlymanage: "是否局直管",
			procapitalatt: "项目资金属性",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_project_number_like: "项目编号", 
			n_project_name_like: "项目名称", 
			n_project_type_eq: "项目类型", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
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
	gridviewtoolbar_toolbar: {
		tbitem1_synchro: {
			caption: "同步项目信息",
			tip: "同步项目信息",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
};