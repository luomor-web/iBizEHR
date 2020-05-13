export default {
  fields: {
    pcmschoolofficename: '在校职务名称',
    cadrename: '职务名称',
    cadreenddatetime: '结束时间',
    bbsj: '版本时间',
    flag: '是否有效',
    createman: '建立人',
    updateman: '更新人',
    pcmschoolofficeid: '在校职务标识',
    updatedate: '更新时间',
    cadrestartdatetime: '开始时间',
    cadredescription: '在校职务描述',
    createdate: '建立时间',
    pcmprofilename: '姓名',
    certificatenumber: '证件号码',
    pcmprofileid: '应聘者ID',
  },
	views: {
		zxzwgridview: {
			caption: '在校职务（要求：带*必填）',
      title: '在校职务（要求：带*必填）',
		},
	},
	main_grid: {
		columns: {
			cadrename: '职务名称（*）',
			cadrestartdatetime: '开始时间（*）',
			cadreenddatetime: '结束时间（*）',
			cadredescription: '在校职务描述',
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
	zxzwgridviewtoolbar2_toolbar: {
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
	zxzwgridviewtoolbar_toolbar: {
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