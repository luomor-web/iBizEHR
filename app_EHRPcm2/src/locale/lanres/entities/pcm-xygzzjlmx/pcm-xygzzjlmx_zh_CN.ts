export default {
  fields: {
    createdate: '建立时间',
    orgid: '权限组织id',
    updateman: '更新人',
    pcmxygzzjlmxname: '试用期员工转正结果引用明细名称',
    checkstatus: '审核状态',
    updatedate: '更新时间',
    zzsj: '转正时间',
    finished: '是否完成',
    pcmxygzzjlmxid: '试用期员工转正结果引用明细标识',
    orgsectorid: '权限部门id',
    createman: '建立人',
    istemp: '是否为临时数据',
    rzqd: '入职渠道',
    jssj: '试用期到期时间',
    bm: '部门',
    pcmxygzzkhjgjlname: '员工',
    duration: '试用期限（月）',
    pcmxygzzsqname: '试用期员工转正申请名称',
    pimpersonname: '员工姓名',
    fs: '分数',
    ygbh: '员工编号',
    qssj: '到局时间',
    zz: '组织',
    zzgw: '转正岗位',
    zzid: '组织ID',
    pj: '评价',
    bmid: '部门ID',
    pimpersonid: '人员信息标识',
    pcmxygzzsqid: '试用期员工转正申请标识',
    pcmxygzzkhjgjlid: '试用期员工转正考核结果记录标识',
  },
	views: {
		editview: {
			caption: '试用期员工转正申请',
      title: '试用期员工转正申请',
		},
		syqzzjlgridview: {
			caption: '试用期转正记录',
      title: '试用期转正记录',
		},
		ckeditview: {
			caption: '试用期员工转正记录引用明细',
      title: '试用期员工转正记录引用明细',
		},
		approvalgridview: {
			caption: '试用期员工转正',
      title: '试用期员工转正',
		},
		zzsqlsjmgridview: {
			caption: '试用期员工转正结果引用明细',
      title: '试用期员工转正结果引用明细',
		},
	},
	main_form: {
		details: {
			group1: '员工信息', 
			grouppanel1: '转正考核成绩', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '试用期员工转正结果引用明细标识', 
			srfmajortext: '试用期员工转正结果引用明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pcmxygzzsqid: '试用期员工转正申请标识', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			zz: '组织', 
			zzid: '组织ID', 
			bm: '部门', 
			bmid: '部门ID', 
			rzqd: '入职渠道', 
			zzgw: '转正岗位', 
			pimpersonid: '人员信息标识', 
			istemp: '是否为临时数据', 
			finished: '是否完成', 
			checkstatus: '审核状态', 
			pcmxygzzkhjgjlname: '考核结果记录', 
			jssj: '试用期到期时间', 
			qssj: '到局时间', 
			zzsj: '转正时间', 
			fs: '分数', 
			pj: '评价', 
			pcmxygzzkhjgjlid: '试用期员工转正考核结果记录标识', 
			pcmxygzzjlmxid: '试用期员工转正结果引用明细标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			zz: '组织',
			bm: '部门',
			rzqd: '入职渠道',
			duration: '试用期限（月）',
			zzgw: '转正岗位',
			zzsj: '转正时间',
			jssj: '试用期到期时间',
			fs: '分数',
			pj: '评价',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_pimpersonname_like: '员工姓名', 
			n_ygbh_like: '员工编号', 
			n_duration_eq: '试用期限（月）', 
			n_checkstatus_eq: '审核状态', 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		deuiaction5: {
			caption: '确认',
			tip: '确认',
		},
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	zzsqlsjmgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: '新建',
			tip: '新建',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
		},
		tbitem18: {
			caption: '帮助',
			tip: '帮助',
		},
	},
	syqzzjlgridviewtoolbar_toolbar: {
		deuiaction1_remove: {
			caption: '删除',
			tip: '删除',
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
	ckeditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	approvalgridviewtoolbar_toolbar: {
		tbitem1_shtg: {
			caption: '审核通过',
			tip: '审核通过',
		},
		tbitem1_shbtg: {
			caption: '审核不通过',
			tip: '审核不通过',
		},
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
		tbitem18: {
			caption: '帮助',
			tip: '帮助',
		},
	},
};