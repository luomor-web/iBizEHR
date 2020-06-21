
export default {
  fields: {
    updatedate: "更新时间",
    testresultname: "测评结果信息名称",
    matchdegree: "胜任力（岗位匹配等级）",
    psychologystatus: "心理健康",
    abilityscore: "能力（能力倾向得分）",
    bbsj: "版本时间",
    abilityscorereports: "能力得分报告",
    abilitygrade: "能力",
    createdate: "建立时间",
    psychologyhealthylevel: "心理健康等级",
    createman: "建立人",
    updateman: "更新人",
    jobfitdegree: "胜任力",
    flag: "是否有效",
    firsttest: "第一次测试",
    examscore: "考试得分",
    examscorereports: "考试报告",
    secondtest: "第二次测试",
    psychologyhealthylevelreports: "心理健康报告",
    testresultid: "测评结果信息标识",
    matchdegreereports: "胜任力测试报告",
    pcmprofilename: "姓名",
    certificatenumber: "证件号码",
    pcmprofileid: "应聘者ID",
  },
	views: {
		cpjggridview: {
			caption: "测评结果摘要信息（要求：带*必填）",
      		title: "测评结果摘要信息（要求：带*必填）",
		},
		editview: {
			caption: "测评结果摘要信息",
      		title: "测评结果摘要信息",
		},
		cpjg_wsswbjgridview: {
			caption: "测评结果摘要信息",
      		title: "测评结果摘要信息",
		},
	},
	main_form: {
		details: {
			group1: "测评结果摘要信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "测评结果信息标识", 
			srfmajortext: "测评结果信息名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			psychologystatus: "心理健康", 
			abilitygrade: "能力", 
			jobfitdegree: "胜任力", 
			pcmprofileid: "应聘者ID", 
			testresultid: "测评结果信息标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			psychologystatus: "心理健康（*）",
			abilitygrade: "能力（*）",
			jobfitdegree: "胜任力（*）",
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
	cpjg_wsswbjgridviewtoolbar_toolbar: {
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
	cpjggridviewtoolbar_toolbar: {
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