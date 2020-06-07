export default {
  fields: {
    updateman: '更新人',
    createdate: '建立时间',
    finished: '是否审核完成',
    createman: '建立人',
    enable: '逻辑有效标志',
    updatedate: '更新时间',
    pcmxygzzsqmxid: '试用期员工转正申请明细标识',
    pcmxygzzsqmxname: '试用期员工转正申请明细名称',
    bm: '部门',
    gw: '岗位',
    pimpersonname: '员工',
    zj: '职级',
    pcmxygzzsqname: '试用期员工转正申请名称',
    zz: '组织',
    zw: '职务',
    pcmxygzzsqid: '试用期员工转正申请标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		editview: {
			caption: '试用期员工转正申请明细（停用）',
      title: '试用期员工转正申请明细（停用）',
		},
		gridview: {
			caption: '试用期员工转正申请明细（停用）',
      title: '试用期员工转正申请明细（停用）',
		},
	},
	main_form: {
		details: {
			group1: '试用期员工转正申请明细基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '试用期员工转正申请明细标识', 
			srfmajortext: '试用期员工转正申请明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonid: '人员信息标识', 
			pimpersonname: '员工', 
			zz: '组织', 
			bm: '部门', 
			zj: '职级', 
			zw: '职务', 
			gw: '岗位', 
			pcmxygzzsqmxid: '试用期员工转正申请明细标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: '员工',
			zz: '组织',
			bm: '部门',
			zj: '职级',
			zw: '职务',
			gw: '岗位',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
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