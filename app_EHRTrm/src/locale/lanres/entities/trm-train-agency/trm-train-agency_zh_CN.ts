export default {
  fields: {
    khhmc: '开户行名称',
    createman: '建立人',
    nsrsbh: '纳税人识别号',
    updateman: '更新人',
    pxcs: '培训次数',
    khh: '开户行',
    jgdj: '机构等级',
    jglx: '机构类型',
    sffc: '是否封存',
    sfgx: '是否共享',
    trmtrainagencyname: '培训机构名称',
    lxr: '联系人',
    jgbm: '机构编码',
    bz: '备注',
    wz: '网址',
    createdate: '建立时间',
    kplx: '开票类型',
    jglb: '机构性质',
    zcxx: '注册信息',
    khhzh: '开户行账号',
    pxzsc: '培训总时长',
    kctxfw: '培训模块范围',
    updatedate: '更新时间',
    kprdh: '电话',
    kpxx: '开票信息',
    dzxx: '电子信箱',
    jj: '简介',
    enable: '逻辑有效标志',
    pj: '评价',
    trmtrainagencyid: '培训机构标识',
    kpr: '开票人',
    kpmc: '开票名称',
    kpdz: '地址',
    lxdh: '联系电话',
    trmtrainagencyname2: '上级机构',
    zzdzs: '所属单位',
    ormorgname: '所属单位',
    pimpersonname: '员工姓名',
    pimpersonid: '人员信息标识',
    ormorgid: '组织标识',
    trmtrainagencyid2: '培训机构标识',
  },
	views: {
		editview: {
			caption: '培训机构',
      title: '培训机构编辑视图',
		},
		pickupgridview: {
			caption: '培训机构',
      title: '培训机构选择表格视图',
		},
		mpickupview: {
			caption: '培训机构',
      title: '培训机构数据多项选择视图',
		},
		gridview: {
			caption: '培训机构',
      title: '培训机构表格视图',
		},
		pickupview: {
			caption: '培训机构',
      title: '培训机构数据选择视图',
		},
	},
	main_form: {
		details: {
			grouppanel1: '开票信息', 
			grouppanel3: '简介', 
			grouppanel4: '评价', 
			group1: '培训机构信息', 
			formpage1: '基本信息', 
			druipart1: '', 
			formpage5: '培训师资', 
			druipart2: '', 
			formpage2: '培训记录', 
			druipart3: '', 
			formpage3: '班主任', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '培训机构标识', 
			srfmajortext: '培训机构名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			trmtrainagencyname: '机构名称', 
			jglx: '机构类型', 
			jgdj: '机构等级', 
			jglb: '机构性质', 
			trmtrainagencyname2: '上级机构', 
			sfgx: '是否共享', 
			pimpersonname: '联系人', 
			lxdh: '联系电话', 
			ormorgname: '所属单位', 
			zcxx: '注册信息', 
			kctxfw: '培训模块范围', 
			kpmc: '开票名称', 
			kplx: '开票类型', 
			nsrsbh: '纳税人识别号', 
			khh: '开户行', 
			khhzh: '开户行账号', 
			kpr: '开票人', 
			kprdh: '电话', 
			kpdz: '地址', 
			jj: '', 
			pj: '', 
			trmtrainagencyid: '培训机构标识', 
			pimpersonid: '人员信息标识', 
			ormorgid: '组织标识', 
			trmtrainagencyid2: '培训机构标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmtrainagencyname: '机构名称',
			jglx: '机构类型',
			jglb: '机构性质',
			trmtrainagencyname2: '上级机构',
			zcxx: '注册信息',
			pimpersonname: '联系人',
			lxdh: '联系电话',
			jgdj: '机构等级',
			zzdzs: '所属单位',
			sfgx: '是否共享',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_trmtrainagencyname_like: '机构名称', 
			n_jgdj_eq: '机构等级(=)', 
			n_pimpersonname_like: '联系人', 
			n_sfgx_eq: '是否共享(=)', 
		},
		uiactions: {
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
	gridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: '新建',
			tip: '新建',
		},
		deuiaction2: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction4: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction3: {
			caption: '关闭行编辑',
			tip: '关闭行编辑',
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
		deuiaction1: {
			caption: '开启行编辑',
			tip: '开启行编辑',
		},
		tbitem18: {
			caption: '帮助',
			tip: '帮助',
		},
	},
};