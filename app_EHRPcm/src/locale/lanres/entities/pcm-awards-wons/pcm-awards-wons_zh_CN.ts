export default {
  fields: {
    awardlevel: "获奖等级",
    flag: "是否有效",
    createdate: "建立时间",
    awardname: "获奖名称",
    awardtime: "获奖时间",
    createman: "建立人",
    awarddescription: "获奖情况",
    pcmawardswonsname: "获奖情况名称",
    pcmawardswonsid: "获奖情况标识",
    bbsj: "版本时间",
    updateman: "更新人",
    judgeorg: "评定机构",
    updatedate: "更新时间",
    certificatenumber: "证件号码",
    pcmprofilename: "姓名",
    pcmprofileid: "应聘者ID",
  },
	views: {
		hjqk_wsswbjgridview: {
			caption: "获奖情况",
      		title: "获奖情况表格视图",
		},
		hjqkgridview: {
			caption: "获奖情况（要求：带*必填）",
      		title: "获奖情况（要求：带*必填）",
		},
		editview: {
			caption: "获奖情况",
      		title: "获奖情况",
		},
	},
	main_form: {
		details: {
			group1: "获奖情况", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "获奖情况标识", 
			srfmajortext: "获奖情况名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pcmprofileid: "应聘者ID", 
			awardname: "获奖名称", 
			awardtime: "获奖时间", 
			awardlevel: "获奖等级", 
			judgeorg: "评定机构", 
			pcmawardswonsid: "获奖情况标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			awardname: "获奖名称（*）",
			awardtime: "获奖时间（*）",
			awardlevel: "获奖等级（*）",
			judgeorg: "评定机构",
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
	hjqk_wsswbjgridviewtoolbar_toolbar: {
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
	hjqkgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "删除",
			tip: "删除",
		},
		deuiaction4: {
			caption: "导入",
			tip: "导入",
		},
		deuiaction5: {
			caption: "导出",
			tip: "导出",
		},
	},
};