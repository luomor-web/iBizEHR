export default {
  fields: {
    zjhm: '证件号码',
    bxyy: '病休原因',
    updatedate: '更新时间',
    ygbh: '员工编号',
    yrank: '职级',
    zzid: '所属组织标识',
    ygw: '所属岗位',
    orgsectorid: '权限部门id',
    updateman: '更新人',
    lxdh: '联系电话',
    bmid: '部门标识',
    bm: '所属部门',
    pcmydbxmxname: '异动病休明细名称',
    checkstatus: '审核状态',
    zzdzs: '所属组织',
    distirbutionid: '分配信息id',
    finished: '是否审核',
    pcmydmxtype: '分组类型',
    csrq: '出生日期',
    createman: '建立人',
    orgid: '权限组织id',
    sxrq: '病休开始日期',
    pimpersonid: '人员信息标识',
    yzw: '所属职务',
    createdate: '建立时间',
    bz: '备注',
    zz: '所属组织',
    shortname: '所属部门',
    cz: '操作',
    jsrq: '病休结束日期',
    pcmydbxmxid: '异动病休明细标识',
    nl: '年龄',
    pimpersonname: '员工姓名',
  },
	views: {
		mpickupview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		bxjsrqqreditview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		bxglgridview: {
			caption: '病休管理',
      title: '病休管理',
		},
		gridview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		pickupgridview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		editview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		redirectview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		jlgridview: {
			caption: '病休记录',
      title: '病休记录',
		},
		xzeditview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		pickupview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		ckeditview: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
		editview2: {
			caption: '异动病休明细',
      title: '异动病休明细',
		},
	},
	bxjsrqqr_form: {
		details: {
			group1: '异动病休明细基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '异动病休明细标识', 
			srfmajortext: '异动病休明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			sxrq: '病休开始日期', 
			jsrq: '病休结束日期', 
			pcmydbxmxid: '异动病休明细标识', 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: '人员信息', 
			grouppanel1: '病休信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '异动病休明细标识', 
			srfmajortext: '异动病休明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			pimpersonid: '人员信息标识', 
			zz: '所属组织', 
			zzid: '所属组织标识', 
			bm: '所属部门', 
			bmid: '部门标识', 
			yrank: '职级', 
			yzw: '所属职务', 
			ygw: '所属岗位', 
			lxdh: '联系电话', 
			sxrq: '病休开始日期', 
			bxyy: '病休原因', 
			bz: '备注', 
			finished: '是否审核', 
			pcmydbxmxid: '异动病休明细标识', 
		},
		uiactions: {
		},
	},
	jleditform_form: {
		details: {
			group1: '人员信息', 
			grouppanel1: '病休信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '异动病休明细标识', 
			srfmajortext: '异动病休明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			pimpersonid: '人员信息标识', 
			zz: '所属组织', 
			zzid: '所属组织标识', 
			bm: '所属部门', 
			bmid: '部门标识', 
			yrank: '职级', 
			yzw: '所属职务', 
			ygw: '所属岗位', 
			lxdh: '联系电话', 
			sxrq: '病休开始日期', 
			jsrq: '病休结束日期', 
			bxyy: '病休原因', 
			bz: '备注', 
			finished: '是否审核', 
			pcmydbxmxid: '异动病休明细标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			zz: '所属组织',
			bm: '所属部门',
			yzw: '所属职务',
			ygw: '所属岗位',
			lxdh: '联系电话',
			sxrq: '病休开始日期',
			jsrq: '病休结束日期',
			bxyy: '病休原因',
		},
		uiactions: {
		},
	},
	glgrid_grid: {
		columns: {
			cz: '操作',
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			zzdzs: '所属组织',
			shortname: '所属部门',
			yzw: '所属职务',
			ygw: '所属岗位',
			lxdh: '联系电话',
			sxrq: '病休开始日期',
			bxyy: '病休原因',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_ygbh_like: '员工编号', 
			n_pimpersonname_like: '员工姓名', 
			n_zz_like: '所属组织', 
			n_bm_like: '所属部门', 
		},
		uiactions: {
		},
	},
	bxjsrqqreditviewtoolbar_toolbar: {
		deuiaction5: {
			caption: '确认',
			tip: '确认',
		},
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	bxglgridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction1: {
			caption: '关闭行编辑',
			tip: '关闭行编辑',
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
	jlgridviewtoolbar_toolbar: {
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
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
	},
	ckeditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
	bxglgridviewtoolbar_toolbar: {
		deuiaction1_xzbx: {
			caption: '新增',
			tip: '新增',
		},
		deuiaction1_remove: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction1_bxjl: {
			caption: '病休记录',
			tip: '病休记录',
		},
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
	gridviewtoolbar_toolbar: {
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
	editview2toolbar_toolbar: {
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
};