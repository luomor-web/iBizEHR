
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
			caption: "解聘记录",
      title: '解聘记录',
		},
		editview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		redirectview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		editview2: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		mpickupview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		xzeditview: {
			caption: "新增解聘",
      title: '新增解聘',
		},
		glgridview: {
			caption: "解聘管理",
      title: '解聘管理',
		},
		pickupgridview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		gridview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		ckeditview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
		pickupview: {
			caption: "异动解聘明细",
      title: '异动解聘明细',
		},
	},
	main_form: {
		details: {
			group1: "人员信息", 
			grouppanel1: "解聘信息", 
			grouppanel3: "补偿", 
			grouppanel4: "劳动争议", 
			grouppanel2: "赔偿信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "异动解聘明细标识", 
			srfmajortext: "解聘明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonid: "人员信息标识", 
			ygbh: "员工编号", 
			pimpersonname: "员工姓名", 
			zz: "所属组织", 
			zzid: "所属组织标识", 
			bm: "所属部门", 
			bmid: "部门标识", 
			yrank: "职级", 
			yzw: "所属职务", 
			ygw: "所属岗位", 
			lxdh: "联系电话", 
			sxrq: "解聘日期", 
			sfhmd: "是否加黑名单", 
			reason: "解聘原因", 
			jpfj: "解除劳动合同附件", 
			bz: "原因详情", 
			remarks: "备注", 
			finished: "是否审核", 
			sfzfbcj: "是否支付补偿金", 
			bcjse: "补偿金数额（元）", 
			sfldzy: "是否有劳动争议", 
			ldzytype: "劳动争议类型", 
			pcjse: "赔偿金数额（元）", 
			pcmydjpmxid: "异动解聘明细标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			zz: "所属组织",
			bm: "所属部门",
			yzw: "所属职务",
			ygw: "所属岗位",
			lxdh: "联系电话",
			sxrq: "解聘日期",
			reason: "解聘原因",
			sfhmd: "是否加黑名单",
		},
		uiactions: {
		},
	},
	jpgl_grid: {
		columns: {
			uagridcolumn1: "操作",
			ygbh: "员工编号",
			pimpersonname: "员工姓名",
			zzdzs: "所属组织",
			shortname: "所属部门",
			yzw: "所属职务",
			ygw: "所属岗位",
			lxdh: "联系电话",
			sxrq: "解聘日期",
			reason: "解聘原因",
			sfhmd: "是否加黑名单",
		},
		uiactions: {
			jpwc: "确认解聘",
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ygbh_like: "员工编号", 
			n_pimpersonname_like: "员工姓名", 
			n_zz_like: "所属组织", 
			n_bm_like: "所属部门", 
		},
		uiactions: {
		},
	},
	jpjlgridviewtoolbar_toolbar: {
		deuiaction1_remove: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction6: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
	ckeditviewtoolbar_toolbar: {
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	editview2toolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem4: {
			caption: "Save And New",
			tip: "Save And New",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	xzeditviewtoolbar_toolbar: {
		deuiaction2_saveandexit: {
			caption: "确认",
			tip: "确认",
		},
		deuiaction1: {
			caption: "退出",
			tip: "退出",
		},
	},
	glgridviewtoolbar2_toolbar: {
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction1: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
		},
	},
	glgridviewtoolbar_toolbar: {
		deuiaction1_xz: {
			caption: "新增",
			tip: "新增",
		},
		deuiaction1_remove: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction1_jsjl: {
			caption: "解聘记录",
			tip: "解聘记录",
		},
		deuiaction3: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		deuiaction6: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		deuiaction2: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
};