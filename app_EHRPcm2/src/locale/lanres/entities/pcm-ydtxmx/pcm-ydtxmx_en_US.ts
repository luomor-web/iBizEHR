
export default {
  fields: {
    shortname: "所属部门",
    retiplace: "退休地",
    yzw: "所属职务",
    updateman: "更新人",
    orgid: "权限组织id",
    pcmydtxmxname: "异动退休明细名称",
    createman: "建立人",
    pimpersonname: "员工姓名",
    pcmydtxmxid: "异动退休明细标识",
    ygbh: "员工编号",
    zzdzs: "所属组织",
    finished: "是否审核",
    lxdh: "联系电话",
    updatedate: "更新时间",
    pcmydbxmxname: "异动病休明细名称",
    pcmydmxtype: "分组类型",
    yrank: "职级",
    jsrq: "结束日期",
    pcmydbxmxid: "异动病休明细标识",
    sxrq: "退休日期",
    reason: "原因",
    bmid: "部门标识",
    nj: "年龄（身份证）",
    checkstatus: "审核状态",
    zjhm: "证件号码",
    orgsectorid: "权限部门id",
    createdate: "建立时间",
    ygw: "所属岗位",
    pimpersonid: "人员信息标识",
    bm: "所属部门",
    csrq: "出生日期",
    zzid: "所属组织标识",
    nl: "年龄2",
    zz: "所属组织",
    bz: "备注",
  },
	views: {
		mpickupview: {
			caption: "异动退休明细",
      		title: "异动病休明细数据多项选择视图",
		},
		editview: {
			caption: "异动退休明细",
      		title: "异动病休明细编辑视图",
		},
		redirectview: {
			caption: "异动退休明细",
      		title: "异动病休明细数据重定向视图",
		},
		editview2: {
			caption: "异动退休明细",
      		title: "异动病休明细编辑视图",
		},
		pickupgridview: {
			caption: "异动退休明细",
      		title: "异动病休明细选择表格视图",
		},
		pickupview: {
			caption: "异动退休明细",
      		title: "异动病休明细数据选择视图",
		},
		ckeditview: {
			caption: "异动退休明细",
      		title: "异动退休明细",
		},
		jlgridview: {
			caption: "退休记录",
      		title: "退休记录",
		},
		gridview: {
			caption: "退休记录",
      		title: "退休记录",
		},
	},
	main_form: {
		details: {
			group1: "人员信息", 
			grouppanel1: "退休信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "异动退休明细标识", 
			srfmajortext: "异动退休明细名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
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
			csrq: "出生日期", 
			nj: "年龄（身份证）", 
			sxrq: "退休日期", 
			retiplace: "退休地", 
			bz: "备注", 
			pimpersonid: "人员信息标识", 
			pcmydtxmxid: "异动退休明细标识", 
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
			csrq: "出生日期",
			sxrq: "退休日期",
		},
		uiactions: {
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
	editviewtoolbar_toolbar: {
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
	jlgridviewtoolbar_toolbar: {
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
	gridviewtoolbar_toolbar: {
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