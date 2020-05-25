export default {
  fields: {
    awardlevel: '获奖等级',
    flag: '是否有效',
    createdate: '建立时间',
    awardname: '获奖名称',
    awardtime: '获奖时间',
    createman: '建立人',
    awarddescription: '获奖情况',
    pcmawardswonsname: '获奖情况名称',
    pcmawardswonsid: '获奖情况标识',
    bbsj: '版本时间',
    updateman: '更新人',
    judgeorg: '评定机构',
    updatedate: '更新时间',
    certificatenumber: '证件号码',
    pcmprofilename: '姓名',
    pcmprofileid: '应聘者ID',
  },
	views: {
		hjqkgridview: {
			caption: '获奖情况（要求：带*必填）',
      title: '获奖情况（要求：带*必填）',
		},
	},
	main_grid: {
		columns: {
			awardname: '获奖名称（*）',
			awardtime: '获奖时间（*）',
			awardlevel: '获奖等级（*）',
			judgeorg: '评定机构',
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
	hjqkgridviewtoolbar2_toolbar: {
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
	hjqkgridviewtoolbar_toolbar: {
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