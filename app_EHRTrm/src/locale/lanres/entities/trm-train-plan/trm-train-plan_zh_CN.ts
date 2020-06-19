export default {
  fields: {
    lclx: '流程类型',
    sdfy: '预计培训费用',
    ysze: '预算总额',
    shfs: '发布状态',
    jhkssj: '计划开始时间',
    xh: '排序',
    jhyd: '计划月度',
    bzsj: '编制时间',
    npxqs: '拟培训期数',
    jhnd: '年度',
    jhjssj: '计划结束时间',
    jhjb: '计划级别',
    bmjzsj: '报名截止时间',
    jhbm: '计划编码',
    trmtrainplanid: '培训计划标识',
    enable: '逻辑有效标志',
    createman: '建立人',
    jhlx: '类型',
    trmtrainplanname: '培训计划名称',
    updatedate: '更新时间',
    npxks: '拟培训课时',
    createdate: '建立时间',
    updateman: '更新人',
    jhjd: '计划季度',
    bz: '备注',
    pxdx: '培训对象',
    pimpersonname: '员工姓名',
    trmplanformuname: '培训计划',
    ormorgname: '组织名称',
    trmdemdeftionname: '培训班名称',
    pxrs: '拟培训人数',
    pxzynr: '拟培训内容',
    pxkssj: '培训开始时间',
    pxdd: '培训地点',
    pxjssj: '培训结束时间',
    pimpersonid: '人员信息标识',
    trmdemdeftionid: '培训需求标识',
    trmplanformuid: '培训计划制定标识',
    ormorgid: '组织标识',
    pxadress: '拟培训地点',
    pxcontent: '拟培训内容',
    pxnum: '拟培训人数',
    approvalstatus: '审批状态',
  },
	views: {
		mpickupview: {
			caption: '培训计划',
      title: '培训计划数据多项选择视图',
		},
		pickupgridview: {
			caption: '培训计划',
      title: '培训计划选择表格视图',
		},
		feditview: {
			caption: '培训计划',
      title: '培训计划',
		},
		fgridview: {
			caption: '计划审批',
      title: '计划审批',
		},
		gridview: {
			caption: '培训计划详情',
      title: '培训计划详情',
		},
		pickupview: {
			caption: '培训计划',
      title: '培训计划数据选择视图',
		},
		editview: {
			caption: '培训计划详情',
      title: '培训计划详情',
		},
		jhfbgridview: {
			caption: '计划发布',
      title: '计划发布',
		},
	},
	main2_form: {
		details: {
			group1: '培训计划详情', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '培训计划标识', 
			srfmajortext: '培训班名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			xh: '排序', 
			trmdemdeftionname: '培训需求', 
			jhnd: '年度', 
			jhlx: '类型', 
			pxadress: '拟培训地点', 
			jhkssj: '拟开始时间', 
			jhjssj: '拟结束时间', 
			npxks: '拟培训课时', 
			pxnum: '拟培训人数', 
			npxqs: '拟培训期数', 
			pxcontent: '拟培训内容', 
			ysze: '预计培训费用', 
			bz: '备注', 
			trmtrainplanid: '培训计划标识', 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: '培训计划详情', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '培训计划标识', 
			srfmajortext: '培训班名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			xh: '排序', 
			trmdemdeftionname: '培训需求', 
			jhnd: '年度', 
			jhlx: '类型', 
			pxadress: '拟培训地点', 
			jhkssj: '拟开始时间', 
			jhjssj: '拟结束时间', 
			npxks: '拟培训课时', 
			pxnum: '拟培训人数', 
			npxqs: '拟培训期数', 
			pxcontent: '拟培训内容', 
			ysze: '预计培训费用', 
			bz: '备注', 
			approvalstatus: '审批状态', 
			trmdemdeftionid: '培训需求标识', 
			trmtrainplanid: '培训计划标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: '排序',
			jhnd: '年度',
			jhlx: '类型',
			trmdemdeftionname: '培训需求',
			jhkssj: '拟开始时间',
			jhjssj: '拟结束时间',
			npxks: '拟培训课时',
			npxqs: '拟培训期数',
			pxnum: '拟培训人数',
			approvalstatus: '审批状态',
			shfs: '发布状态',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_trmdemdeftionname_like: '培训班名称(%)', 
		},
		uiactions: {
		},
	},
	feditviewtoolbar_toolbar: {
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: '新建',
			tip: '新建',
		},
		tbitem5: {
			caption: '编辑',
			tip: '编辑',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
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
	fgridviewtoolbar_toolbar: {
		tbitem1_setapprovalstatus_sep: {
			caption: '',
			tip: '',
		},
		tbitem1_setapprovalstatus: {
			caption: '审批通过',
			tip: '审批通过',
		},
		tbitem1_setrejectstatus_sep: {
			caption: '',
			tip: '',
		},
		tbitem1_setrejectstatus: {
			caption: '审批不通过',
			tip: '审批不通过',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
		},
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
	},
	jhfbgridviewtoolbar_toolbar: {
		tbitem1_setapprovalstatus_sep: {
			caption: '',
			tip: '',
		},
		tbitem1_setapprovalstatus: {
			caption: '审批通过',
			tip: '审批通过',
		},
		tbitem1_setrejectstatus_sep: {
			caption: '',
			tip: '',
		},
		tbitem1_setrejectstatus: {
			caption: '审批不通过',
			tip: '审批不通过',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
		},
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
	},
};