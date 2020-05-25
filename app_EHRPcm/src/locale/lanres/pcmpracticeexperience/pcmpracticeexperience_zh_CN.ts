export default {
  fields: {
    practicereferencesposition: '证明人职务',
    updatedate: '更新时间',
    practicecompanydescription: '单位介绍',
    updateman: '更新人',
    endtime: '结束时间',
    createdate: '建立时间',
    practicecompanyname: '实习单位',
    flag: '是否有效',
    createman: '建立人',
    bbsj: '版本时间',
    practicecontent: '实习内容',
    practicereferencesname: '证明人',
    practicereferencescontact: '证明人联系方式',
    sxpj: '实习评价',
    pcmpracticeexperiencename: '实习经验名称',
    pcmpracticeexperienceid: '实习经验标识',
    practiceaddress: '实习地点',
    sxgw: '实习岗位',
    practicereferencesrelation: '证明人关系',
    starttime: '开始时间',
    pcmprofilename: '姓名',
    certificatenumber: '证件号码',
    pcmprofileid: '应聘者ID',
  },
	views: {
		sxjygridview: {
			caption: '实习信息（要求：带*必填）',
      title: '实习信息（要求：带*必填）',
		},
	},
	main_grid: {
		columns: {
			practicecompanyname: '实习单位（*）',
			sxgw: '实习岗位',
			starttime: '开始时间（*）',
			endtime: '结束时间（*）',
			practicecontent: '实习内容',
			sxpj: '实习评价',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
		},
		uiactions: {
		},
	},
	sxjygridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: '新建',
			tip: '新建',
		},
		deuiaction2: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction3: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction4: {
			caption: '导入',
			tip: '导入',
		},
		deuiaction5: {
			caption: '导出',
			tip: '导出',
		},
	},
	sxjygridviewtoolbar_toolbar: {
		deuiaction3: {
			caption: '开启行编辑',
			tip: '开启行编辑',
		},
		deuiaction6: {
			caption: '导出',
			tip: '导出',
		},
		deuiaction2: {
			caption: '过滤',
			tip: '过滤',
		},
	},
};