export default {
  fields: {
    department: '投递组织',
    phaseinfo: '所在阶段信息',
    organization: '组织机构',
    statusinfo: '所在状态信息',
    updateman: '更新人',
    jobcode: '职位编号',
    updatedate: '更新时间',
    flag: '是否有效',
    jobid: '职位ID',
    createdate: '建立时间',
    createman: '建立人',
    tdzwxxid: '投递职位摘要信息标识',
    initapplydate: '最初投递时间',
    tdzwxxname: '职位名称',
    bbsj: '版本时间',
    certificatenumber: '证件号码',
    pcmprofilename: '姓名',
    pcmprofileid: '应聘者ID',
  },
	views: {
		tdzwgridview: {
			caption: '投递职位摘要信息（要求：带*必填）',
      title: '投递职位摘要信息（要求：带*必填）',
		},
	},
	main_grid: {
		columns: {
			jobid: '职位ID',
			tdzwxxname: '职位名称（*）',
			initapplydate: '最初投递时间（*）',
			department: '投递组织（*）',
			phaseinfo: '所在阶段信息（*）',
			statusinfo: '所在状态信息（*）',
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
	tdzwgridviewtoolbar2_toolbar: {
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
	tdzwgridviewtoolbar_toolbar: {
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