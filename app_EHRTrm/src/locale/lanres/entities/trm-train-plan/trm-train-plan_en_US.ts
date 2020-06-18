
export default {
  fields: {
    lclx: '流程类型',
    sdfy: '预计培训费用',
    ysze: '预算总额',
    shfs: '审核方式',
    jhkssj: '计划开始时间',
    xh: '排序号',
    jhyd: '计划月度',
    bzsj: '编制时间',
    npxqs: '拟培训期数',
    jhnd: '计划年度',
    jhjssj: '计划结束时间',
    jhjb: '计划级别',
    bmjzsj: '报名截止时间',
    jhbm: '计划编码',
    trmtrainplanid: '培训计划标识',
    enable: '逻辑有效标志',
    createman: '建立人',
    jhlx: '计划类型',
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
    trmdemdeftionid: '需求调查定义标识',
    trmplanformuid: '培训计划制定标识',
    ormorgid: '组织标识',
  },
	views: {
		mpickupview: {
			caption: "培训计划",
      title: '培训计划数据多项选择视图',
		},
		pickupgridview: {
			caption: "培训计划",
      title: '培训计划选择表格视图',
		},
		feditview: {
			caption: "培训计划",
      title: '培训计划编辑视图',
		},
		fgridview: {
			caption: "培训计划",
      title: '培训计划表格视图',
		},
		gridview: {
			caption: "培训计划详情",
      title: '培训计划详情',
		},
		pickupview: {
			caption: "培训计划",
      title: '培训计划数据选择视图',
		},
		editview: {
			caption: "培训计划详情",
      title: '培训计划详情',
		},
	},
	main_2_form: {
		details: {
			group1: "公司培训计划制定", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训计划标识", 
			srfmajortext: "培训班名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			trmdemdeftionname: "培训班名称", 
			pxdx: "培训对象", 
			pxzynr: "拟培训内容", 
			pxkssj: "培训开始时间", 
			pxjssj: "培训结束时间", 
			pxdd: "培训地点", 
			pxrs: "拟培训人数", 
			npxks: "拟培训课时", 
			npxqs: "拟培训期数", 
			ysze: "预计培训费用", 
			bz: "备注", 
			trmdemdeftionid: "需求调查定义标识", 
			trmtrainplanid: "培训计划标识", 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			group1: "培训计划详情", 
			druipart1: "", 
			grouppanel1: "培训计划项", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训计划标识", 
			srfmajortext: "培训班名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序", 
			trmdemdeftionname: "培训需求", 
			pxdx: "培训对象", 
			npxks: "拟培训课时", 
			npxqs: "拟培训期数", 
			ysze: "预计培训费用", 
			bz: "备注", 
			trmdemdeftionid: "需求调查定义标识", 
			trmtrainplanid: "培训计划标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序",
			trmdemdeftionname: "培训需求名称",
			pxdx: "培训对象",
			pxzynr: "拟培训内容",
			pxkssj: "培训开始时间",
			pxjssj: "培训结束时间",
			pxdd: "培训地点",
			pxrs: "拟培训人数",
			npxks: "拟培训课时",
			npxqs: "拟培训期数",
			ysze: "预计培训费用",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmdemdeftionname_like: "培训班名称(%)", 
		},
		uiactions: {
		},
	},
	feditviewtoolbar_toolbar: {
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
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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
	fgridviewtoolbar_toolbar: {
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