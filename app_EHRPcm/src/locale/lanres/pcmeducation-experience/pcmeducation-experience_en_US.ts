
export default {
  fields: {
    majordescription: '专业描述',
    flag: '是否有效',
    subjectresearch: '课题研究',
    trainingmode: '培养方式',
    majorcategory: '专业类别',
    pcmeducationexperiencename: '教育背景名称',
    formsoflearning: '学习形式',
    educationlevel: '受教育程度',
    xwz: '学位证',
    bbsj: '版本时间',
    majorcourses: '专业课程',
    collegename: '学院名称',
    byz: '毕业证',
    updateman: '更新人',
    createdate: '建立时间',
    xlyz: '学历验证',
    isabroad: '是否为海外留学',
    starttime: '入学时间',
    sfxzy: '是否小专业',
    xkml: '一级学科',
    higestxl: '是否最高学历',
    majorname: '专业名称',
    schoolname: '毕业院校',
    city: '城市',
    xxxz: '学校性质',
    xl: '学历',
    updatedate: '更新时间',
    endtime: '毕业时间',
    degree: '学位',
    createman: '建立人',
    firstxl: '是否第一学历',
    pcmeducationexperienceid: '教育背景标识',
    certificatenumber: '证件号码',
    pcmprofilename: '姓名',
    xznf: '招聘年份',
    pcmprofileid: '应聘者ID',
  },
	views: {
		jybjgridview: {
			caption: "教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）",
      title: '教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）',
		},
	},
	main_grid: {
		columns: {
			xl: "学历（*）",
			starttime: "入学时间（*）",
			endtime: "毕业时间（*）",
			schoolname: "毕业院校（*）",
			xkml: "一级学科（*）",
			majorname: "专业名称（*）",
			xxxz: "学校性质",
			formsoflearning: "学习形式",
			firstxl: "是否第一学历",
			higestxl: "是否最高学历",
			byz: "毕业证（*）",
			xwz: "学位证（*）",
			xlyz: "学历验证",
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
	jybjgridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "New",
			tip: "New",
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
	jybjgridviewtoolbar_toolbar: {
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction6: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
};