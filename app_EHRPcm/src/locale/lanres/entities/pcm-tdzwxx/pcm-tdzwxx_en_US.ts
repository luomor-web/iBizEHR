
export default {
  fields: {
    department: "投递组织",
    phaseinfo: "所在阶段信息",
    organization: "组织机构",
    statusinfo: "所在状态信息",
    updateman: "更新人",
    jobcode: "职位编号",
    updatedate: "更新时间",
    flag: "是否有效",
    jobid: "职位ID",
    createdate: "建立时间",
    createman: "建立人",
    tdzwxxid: "投递职位摘要信息标识",
    initapplydate: "最初投递时间",
    tdzwxxname: "职位名称",
    bbsj: "版本时间",
    certificatenumber: "证件号码",
    pcmprofilename: "姓名",
    pcmprofileid: "应聘者ID",
  },
	views: {
		editview: {
			caption: "投递职位摘要信息",
      		title: "投递职位摘要信息",
		},
		tdzw_wsswbjgridview: {
			caption: "投递职位摘要信息",
      		title: "投递职位摘要信息",
		},
		tdzwgridview: {
			caption: "投递职位摘要信息（要求：带*必填）",
      		title: "投递职位摘要信息（要求：带*必填）",
		},
	},
	main_form: {
		details: {
			group1: "投递职位摘要信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "投递职位摘要信息标识", 
			srfmajortext: "职位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmprofileid: "应聘者ID", 
			jobid: "职位ID", 
			tdzwxxname: "职位名称", 
			initapplydate: "最初投递时间", 
			department: "投递组织", 
			phaseinfo: "所在阶段信息", 
			statusinfo: "所在状态信息", 
			tdzwxxid: "投递职位摘要信息标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			tdzwxxname: "职位名称（*）",
			initapplydate: "最初投递时间（*）",
			department: "投递组织（*）",
			phaseinfo: "所在阶段信息（*）",
			statusinfo: "所在状态信息（*）",
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
	tdzw_wsswbjgridviewtoolbar_toolbar: {
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
	tdzwgridviewtoolbar_toolbar: {
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
};