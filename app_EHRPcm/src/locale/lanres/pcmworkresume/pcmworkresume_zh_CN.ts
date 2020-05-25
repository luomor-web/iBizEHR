export default {
  fields: {
    workunit: '工作单位',
    serveendtime: '任职结束时间',
    resumecontent: '履历说明',
    updateman: '更新人',
    zw: '职务',
    gw: '岗位',
    bm: '部门',
    updatedate: '更新时间',
    pcmworkresumename: '工作履历名称',
    servebegintime: '任职开始时间',
    createdate: '建立时间',
    pcmworkresumeid: '工作履历标识',
    createman: '建立人',
    pcmprofilename: '姓名',
    certificatenumber: '证件号码',
    pcmprofileid: '应聘者ID',
  },
	views: {
		gzllgridview: {
			caption: '工作履历（要求：带*必填）',
      title: '工作履历（要求：带*必填）',
		},
	},
	main_grid: {
		columns: {
			servebegintime: '任职开始时间（*）',
			serveendtime: '任职结束时间',
			workunit: '工作单位（*）',
			bm: '部门',
			zw: '职务',
			gw: '岗位',
			resumecontent: '履历说明',
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
	gzllgridviewtoolbar2_toolbar: {
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
	gzllgridviewtoolbar_toolbar: {
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