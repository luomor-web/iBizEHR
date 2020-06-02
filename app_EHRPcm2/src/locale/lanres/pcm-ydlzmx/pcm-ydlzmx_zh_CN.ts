export default {
  fields: {
    nl: '年龄',
    finished: '是否审核',
    checkstatus: '审核状态',
    sfhmd: '是否加入黑名单',
    yytype: '离职理由',
    zzid: '所属组织标识',
    yrank: '职级',
    lxdh: '联系电话',
    pimpersonid: '人员信息标识',
    bm: '所属部门',
    zzdzs: '所属组织',
    fj: '离职面谈附件',
    shortname: '所属部门',
    bz: '原因详情',
    pcmydlzmxname: '异动离职明细名称',
    ygbh: '员工编号',
    createman: '建立人',
    zjhm: '证件号码',
    sxrq: '离职日期',
    orgid: '权限组织id',
    pimpersonname: '员工姓名',
    orgsectorid: '权限部门id',
    cz: '操作',
    bmid: '部门标识',
    updateman: '更新人',
    createdate: '建立时间',
    pcmydmxtype: '分组类型',
    yzw: '所属职务',
    remarks: '备注',
    lzqx: '离职去向',
    csrq: '出生日期',
    ygw: '所属岗位',
    zz: '所属组织',
    updatedate: '更新时间',
    pcmydlzmxid: '异动离职明细标识',
    lzmtrname: '离职面谈人',
    lzmtrid: '人员信息标识',
  },
	views: {
		gridview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		xzeditview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		ckeditview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		redirectview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		pickupview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		mpickupview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		editview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		glgridview: {
			caption: '离职管理',
      title: '离职管理',
		},
		pickupgridview: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
		lsjlgridview: {
			caption: '离职记录',
      title: '离职记录',
		},
		editview2: {
			caption: '异动离职明细',
      title: '异动离职明细',
		},
	},
	main_form: {
		details: {
			group1: '人员信息', 
			grouppanel1: '离职信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '异动离职明细标识', 
			srfmajortext: '异动离职明细名称', 
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
			sxrq: '离职日期', 
			sfhmd: '是否加入黑名单', 
			lzmtrname: '离职面谈人', 
			lzmtrid: '人员信息标识', 
			fj: '离职面谈附件', 
			yytype: '离职理由', 
			lzqx: '离职去向', 
			bz: '原因详情', 
			remarks: '备注', 
			finished: '是否审核', 
			pcmydlzmxid: '异动离职明细标识', 
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
			ygw: '所属岗位',
			yzw: '所属职务',
			lxdh: '联系电话',
			sxrq: '离职日期',
			yytype: '离职理由',
			lzqx: '离职去向',
			sfhmd: '是否加入黑名单',
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
			ygw: '所属岗位',
			yzw: '所属职务',
			lxdh: '联系电话',
			sxrq: '离职日期',
			yytype: '离职理由',
			lzqx: '离职去向',
			sfhmd: '是否加入黑名单',
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
	glsearchform_searchform: {
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
	ckeditviewtoolbar_toolbar: {
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
	lsjlgridviewtoolbar_toolbar: {
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
	glgridviewtoolbar_toolbar: {
		deuiaction1_xz: {
			caption: '新增',
			tip: '新增',
		},
		deuiaction1_remove: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction1_jlck: {
			caption: '离职记录',
			tip: '离职记录',
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