
export default {
  fields: {
    workunit: "工作单位",
    serveendtime: "任职结束时间",
    resumecontent: "履历说明",
    updateman: "更新人",
    zw: "职务",
    gw: "岗位",
    bm: "部门",
    updatedate: "更新时间",
    pcmworkresumename: "工作履历名称",
    servebegintime: "任职开始时间",
    createdate: "建立时间",
    pcmworkresumeid: "工作履历标识",
    createman: "建立人",
    pcmprofilename: "姓名",
    certificatenumber: "证件号码",
    pcmprofileid: "应聘者ID",
  },
	views: {
		gzll_wsswbjgridview: {
			caption: "工作履历",
      		title: "工作履历表格视图",
		},
		gzllgridview: {
			caption: "工作履历（要求：带*必填）",
      		title: "工作履历（要求：带*必填）",
		},
		editview: {
			caption: "工作履历",
      		title: "工作履历",
		},
	},
	main_form: {
		details: {
			group1: "工作履历基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "工作履历标识", 
			srfmajortext: "工作履历名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmprofileid: "应聘者ID", 
			servebegintime: "任职开始时间", 
			serveendtime: "任职结束时间", 
			workunit: "工作单位", 
			bm: "部门", 
			zw: "职务", 
			gw: "岗位", 
			resumecontent: "履历说明", 
			pcmworkresumeid: "工作履历标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			servebegintime: "任职开始时间（*）",
			serveendtime: "任职结束时间",
			workunit: "工作单位（*）",
			bm: "部门",
			zw: "职务",
			gw: "岗位",
			resumecontent: "履历说明",
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
	gzll_wsswbjgridviewtoolbar_toolbar: {
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
	gzllgridviewtoolbar_toolbar: {
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