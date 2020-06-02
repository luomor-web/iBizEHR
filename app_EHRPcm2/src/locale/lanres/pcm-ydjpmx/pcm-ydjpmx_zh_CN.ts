export default {
  fields: {
    pcmydmxtype: '分组类型',
    jsrq: '结束日期',
    sfhmd: '是否加黑名单',
    bmid: '部门标识',
    ygw: '所属岗位',
    sfldzy: '是否有劳动争议',
    zzid: '所属组织标识',
    pimpersonid: '人员信息标识',
    nl: '年龄',
    remarks: '备注',
    bcjse: '补偿金数额（元）',
    ldzytype: '劳动争议类型',
    createman: '建立人',
    pcmydjpmxid: '异动解聘明细标识',
    ygbh: '员工编号',
    updateman: '更新人',
    shortname: '所属部门',
    pcjse: '赔偿金数额（元）',
    pimpersonname: '员工姓名',
    pcmydjpmxname: '解聘明细名称',
    orgsectorid: '权限部门id',
    createdate: '建立时间',
    reason: '解聘原因',
    updatedate: '更新时间',
    bm: '所属部门',
    zz: '所属组织',
    sxrq: '解聘日期',
    checkstatus: '审核状态',
    jpfj: '解除劳动合同附件',
    orgid: '权限组织id',
    bz: '原因详情',
    lxdh: '联系电话',
    cz: '操作',
    zzdzs: '所属组织',
    finished: '是否审核',
    yrank: '职级',
    zjhm: '证件号码',
    csrq: '出生日期',
    yzw: '所属职务',
    sfzfbcj: '是否支付补偿金',
  },
	views: {
		jpjlgridview: {
			caption: '解聘记录',
      title: '解聘记录',
		},
		editview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		redirectview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		editview2: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		mpickupview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		xzeditview: {
			caption: '新增解聘',
      title: '新增解聘',
		},
		glgridview: {
			caption: '解聘管理',
      title: '解聘管理',
		},
		pickupgridview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		gridview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		ckeditview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
		pickupview: {
			caption: '异动解聘明细',
      title: '异动解聘明细',
		},
	},
	main_form: {
		details: {
			group1: '人员信息', 
			grouppanel1: '解聘信息', 
			grouppanel3: '补偿', 
			grouppanel4: '劳动争议', 
			grouppanel2: '赔偿信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '异动解聘明细标识', 
			srfmajortext: '解聘明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonid: '人员信息标识', 
			ygbh: '员工编号', 
			pimpersonname: '员工姓名', 
			zz: '所属组织', 
			zzid: '所属组织标识', 
			bm: '所属部门', 
			bmid: '部门标识', 
			yrank: '职级', 
			yzw: '所属职务', 
			ygw: '所属岗位', 
			lxdh: '联系电话', 
			sxrq: '解聘日期', 
			sfhmd: '是否加黑名单', 
			reason: '解聘原因', 
			jpfj: '解除劳动合同附件', 
			bz: '原因详情', 
			remarks: '备注', 
			finished: '是否审核', 
			sfzfbcj: '是否支付补偿金', 
			bcjse: '补偿金数额（元）', 
			sfldzy: '是否有劳动争议', 
			ldzytype: '劳动争议类型', 
			pcjse: '赔偿金数额（元）', 
			pcmydjpmxid: '异动解聘明细标识', 
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
			sxrq: '解聘日期',
			reason: '解聘原因',
			sfhmd: '是否加黑名单',
		},
		uiactions: {
		},
	},
	jpgl_grid: {
		columns: {
			cz: '操作',
			ygbh: '员工编号',
			pimpersonname: '员工姓名',
			zzdzs: '所属组织',
			shortname: '所属部门',
			yzw: '所属职务',
			ygw: '所属岗位',
			lxdh: '联系电话',
			sxrq: '解聘日期',
			reason: '解聘原因',
			sfhmd: '是否加黑名单',
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
	jpjlgridviewtoolbar_toolbar: {
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
		tbitem22: {
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
	xzeditviewtoolbar_toolbar: {
		deuiaction2_saveandexit: {
			caption: '确认',
			tip: '确认',
		},
		deuiaction1: {
			caption: '退出',
			tip: '退出',
		},
	},
	glgridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction1: {
			caption: '关闭行编辑',
			tip: '关闭行编辑',
		},
	},
	glgridviewtoolbar_toolbar: {
		deuiaction1_xz: {
			caption: '新增',
			tip: '新增',
		},
		deuiaction1_remove: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction1_jsjl: {
			caption: '解聘记录',
			tip: '解聘记录',
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
};