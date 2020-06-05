export default {
  fields: {
    vacleavedetailid: '请销假明细标识',
    hyzk: '婚姻状况',
    vacleavedetailname: '请销假明细名称',
    createdate: '建立时间',
    qjzl: '请假种类',
    sjqjjs: '实际请假结束',
    jhjssxw: '计划结束上下午',
    jhkssxw: '计划开始上下午',
    njsy: '假期使用情况',
    createman: '建立人',
    sjjssj: '实际结束时间',
    sjts: '实际天数',
    tqlx: '探亲类型',
    sjkssj: '实际开始时间',
    fj: '附件',
    updateman: '更新人',
    sjjssxw: '实际结束上下午',
    jhkssj: '计划开始时间',
    sjkssxw: '实际开始上下午',
    jhqjks: '计划请假开始',
    jhts: '计划天数',
    updatedate: '更新时间',
    bz: '备注',
    sjqjks: '实际请假开始',
    jhqjjs: '计划请假结束',
    tips: '温馨提示',
    jhjssj: '计划结束时间',
    ormorgsectorid: '部门标识',
    ormorgid: '组织标识',
    pimpersonid: '人员信息标识',
    pimpersonname: '请假人员',
    vacleavemanagename: '请销假管理名称',
    vacleavemanageid: '请销假管理标识',
  },
	views: {
		editview: {
			caption: '请假明细',
      title: '请假明细',
		},
		gridview: {
			caption: '请假明细',
      title: '请假明细',
		},
	},
	main_form: {
		details: {
			group1: '请假明细', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '请销假明细标识', 
			srfmajortext: '请销假明细名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			vacleavedetailid: '请销假明细标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: '请假人员',
			qjzl: '请假种类',
			jhqjks: '计划请假开始',
			jhqjjs: '计划请假结束',
			jhts: '计划天数',
			bz: '备注',
			sjqjks: '实际请假开始',
			sjqjjs: '实际请假结束',
			sjts: '实际天数',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_qjzl_eq: '请假种类(=)', 
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