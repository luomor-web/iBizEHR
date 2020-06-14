export default {
  fields: {
    createman: '建立人',
    finished: '是否审核完成',
    checkstatus: '审核状态',
    istemp: '是否为临时数据',
    updateman: '更新人',
    createdate: '建立时间',
    orgid: '权限组织id',
    pcmjxsygzzjlmxid: '见习生员工转正记录引用明细标识',
    updatedate: '更新时间',
    orgsectorid: '权限部门id',
    pcmjxsygzzjlmxname: '见习生员工转正记录引用明细名称',
    bmid: '部门ID',
    rzqd: '入职渠道',
    duration: '见习期限（月）',
    zz: '组织',
    pimpersonname: '员工姓名',
    jssj: '见习到期时间',
    ygbh: '员工编号',
    bm: '部门',
    zzid: '组织ID',
    fs: '分数',
    pj: '评价',
    qssj: '到局时间',
    zzgw: '转正岗位',
    pcmjxsygzzsqname: '见习生员工转正申请名称',
    pcmjxszzkhjgjlname: '员工',
    pcmjxsygzzsqid: '见习生员工转正申请标识',
    pcmjxszzkhjgjlid: '见习生员工转正考核结果记录标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		sqtemplgridview: {
			caption: '见习生员工转正记录引用明细',
      title: '见习生员工转正记录引用明细表',
		},
		xzeditview: {
			caption: '见习期员工转正申请',
      title: '见习期员工转正申请',
		},
		zzjlgridview: {
			caption: '见习期转正记录',
      title: '见习期转正记录',
		},
		ckeditview: {
			caption: '见习生员工转正记录引用明细',
      title: '见习生员工转正明细',
		},
		approavlgridview: {
			caption: '见习期转正审核',
      title: '见习期转正审核',
		},
		editview: {
			caption: '见习生员工转正记录引用明细',
      title: '见习生员工转正记录引用明细编辑视图',
		},
		editview9: {
			caption: '见习期员工转正',
      title: '见习期员工转正',
		},
	},
	main_form: {
		details: {
			group1: '详细信息', 
			grouppanel1: '转正考核信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '见习生员工转正记录引用明细标识', 
			srfmajortext: '见习生员工转正记录引用明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pcmjxsygzzsqid: '见习生员工转正申请标识', 
			pcmjxsygzzsqname: '标题', 
			pcmjxszzkhjgjlid: '见习生员工转正考核结果记录标识', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			zz: '组织', 
			bm: '部门', 
			zzgw: '转正岗位', 
			rzqd: '入职渠道', 
			istemp: '是否为临时数据', 
			finished: '是否审核完成', 
			checkstatus: '审核状态', 
			pcmjxszzkhjgjlname: '考核结果', 
			qssj: '到公司时间', 
			jssj: '见习到期时间', 
			fs: '分数', 
			pj: '评价', 
			pcmjxsygzzjlmxid: '见习生员工转正记录引用明细标识', 
		},
		uiactions: {
		},
	},
	newdataform_form: {
		details: {
			group1: '详细信息', 
			grouppanel1: '转正考核信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '见习生员工转正记录引用明细标识', 
			srfmajortext: '见习生员工转正记录引用明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pcmjxsygzzsqid: '见习生员工转正申请标识', 
			pcmjxsygzzsqname: '标题', 
			pcmjxszzkhjgjlid: '见习生员工转正考核结果记录标识', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			zz: '组织', 
			zzid: '组织ID', 
			bm: '部门', 
			bmid: '部门ID', 
			zzgw: '转正岗位', 
			rzqd: '入职渠道', 
			istemp: '是否为临时数据', 
			finished: '是否审核完成', 
			checkstatus: '审核状态', 
			pimpersonid: '人员信息标识', 
			pcmjxszzkhjgjlname: '考核结果', 
			qssj: '到公司时间', 
			jssj: '见习到期时间', 
			fs: '分数', 
			pj: '评价', 
			pcmjxsygzzjlmxid: '见习生员工转正记录引用明细标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			uagridcolumn1: '操作',
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			zz: '组织',
			bm: '部门',
			zzgw: '转正岗位',
			duration: '见习期限（月）',
			rzqd: '入职渠道',
			jssj: '见习到期时间',
			fs: '分数',
			pj: '评价',
			checkstatus: '审核状态',
		},
		uiactions: {
			checkdetail: '查看',
			remove: '删除',
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_pimpersonname_like: '员工姓名', 
			n_ygbh_like: '员工编号', 
			n_duration_eq: '见习期限（月）', 
			n_checkstatus_eq: '审核状态', 
		},
		uiactions: {
		},
	},
	editview9toolbar_toolbar: {
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
	sqtemplgridviewtoolbar_toolbar: {
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
	xzeditviewtoolbar_toolbar: {
		deuiaction5: {
			caption: '确认',
			tip: '确认',
		},
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	zzjlgridviewtoolbar_toolbar: {
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
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem4: {
			caption: '保存并新建',
			tip: '保存并新建',
		},
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
		tbitem7: {
			caption: '删除并关闭',
			tip: '删除并关闭',
		},
		tbitem22: {
			caption: '帮助',
			tip: '帮助',
		},
	},
	ckeditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	approavlgridviewtoolbar_toolbar: {
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