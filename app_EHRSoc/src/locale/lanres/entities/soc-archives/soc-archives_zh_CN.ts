export default {
  fields: {
    socarchivesid: '社保档案标识',
    socarchivesname: '社保档案名称',
    createman: '建立人',
    enable: '逻辑有效标志',
    updateman: '更新人',
    createdate: '建立时间',
    updatedate: '更新时间',
    pimpersonid: '人员信息标识',
    pimpersonname: '员工姓名',
    socaccountid: '参保账户标识',
    socaccountname: '参保账户',
    socruleid: '社保规则标识',
    socrulename: '社保规则名称',
    ormorgid: '组织ID',
    ormorgname: '组织',
    ormorgsectorid: '部门ID',
    ormorgsectorname: '部门',
    ygbh: '员工编号',
    state: '状态',
    ygzt: '员工状态',
  },
	views: {
		quickeditview: {
			caption: '社保档案',
      title: '社保档案编辑视图',
		},
		gridview: {
			caption: '社保档案',
      title: '社保档案表格视图',
		},
		editview: {
			caption: '社保档案',
      title: '社保档案编辑视图',
		},
		main2editview: {
			caption: '社保档案',
      title: '社保档案编辑视图',
		},
		stopgridview: {
			caption: '社保档案',
      title: '社保档案表格视图',
		},
	},
	main2_form: {
		details: {
			group1: '社保档案基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '社保档案标识', 
			srfmajortext: '社保档案名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonname: '员工姓名', 
			socaccountname: '参保账户', 
			socrulename: '社保规则名称', 
			ygbh: '员工编号', 
			ormorgname: '组织', 
			ormorgsectorname: '部门', 
			state: '状态', 
			pimpersonid: '人员信息标识', 
			socaccountid: '参保账户标识', 
			socruleid: '社保规则标识', 
			socarchivesid: '社保档案标识', 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: '社保档案基本信息', 
			druipart1: '', 
			grouppanel1: '分组面板', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '社保档案标识', 
			srfmajortext: '社保档案名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonname: '员工姓名', 
			socaccountname: '参保账户', 
			socrulename: '社保规则名称', 
			ygbh: '员工编号', 
			ormorgname: '组织', 
			ormorgsectorname: '部门', 
			pimpersonid: '人员信息标识', 
			socaccountid: '参保账户标识', 
			socruleid: '社保规则标识', 
			socarchivesid: '社保档案标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			ygzt: '员工状态',
			ormorgname: '组织',
			ormorgsectorname: '部门',
			socaccountname: '参保账户',
			socrulename: '社保规则名称',
			state: '状态',
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
	quickeditviewtoolbar_toolbar: {
		deuiaction5: {
			caption: '确认',
			tip: '确认',
		},
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	main2editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
	editviewtoolbar_toolbar: {
		tbitem1_openeditview: {
			caption: '编辑',
			tip: '编辑',
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1_quickcreatesocarchives: {
			caption: '新建',
			tip: '新建',
		},
		deuiaction8: {
			caption: '导入',
			tip: '导入',
		},
		deuiaction6: {
			caption: '导出',
			tip: '导出',
		},
		deuiaction2: {
			caption: '过滤',
			tip: '过滤',
		},
		deuiaction5: {
			caption: '帮助',
			tip: '帮助',
		},
	},
	stopgridviewtoolbar_toolbar: {
		deuiaction1_stoparchives: {
			caption: '终止社保',
			tip: '终止社保',
		},
		deuiaction8: {
			caption: '导入',
			tip: '导入',
		},
		deuiaction6: {
			caption: '导出',
			tip: '导出',
		},
		deuiaction2: {
			caption: '过滤',
			tip: '过滤',
		},
		deuiaction5: {
			caption: '帮助',
			tip: '帮助',
		},
	},
};