export default {
  fields: {
    jyr: '借阅人',
    createman: '建立人',
    spdate: '审批时间',
    enable: '逻辑有效标志',
    pimarchivesloanandreturnid: '档案借阅及归还记录标识',
    jyyy: '借阅原因',
    ghrq: '归还时间',
    zt: '状态',
    jyqssj: '借阅时间',
    createdate: '建立时间',
    pimarchivesloanandreturnname: '档案借阅及归还记录名称',
    spperson: '审批同意人',
    updatedate: '更新时间',
    updateman: '更新人',
    pimarchivesname: '档案信息名称',
    pimpersonname2: '借阅人',
    pimpersonname3: '审批人',
    pimpersonname: '员工姓名',
    pimpersonid3: '人员信息标识',
    pimpersonid: '人员信息标识',
    pimarchivesid: '档案信息标识',
    pimpersonid2: '人员信息标识',
  },
	views: {
		pickupgridview: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
		redirectview: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
		editview2: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
		editview: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
		pickupview: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
		gridview: {
			caption: '借阅记录',
      title: '借阅记录',
		},
		mpickupview: {
			caption: '档案借阅及归还记录',
      title: '档案借阅及归还记录',
		},
	},
	main_form: {
		details: {
			group1: '借阅记录', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '档案借阅及归还记录标识', 
			srfmajortext: '档案借阅及归还记录名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			jyr: '借阅人', 
			jyqssj: '借阅时间', 
			ghrq: '归还时间', 
			jyyy: '借阅原因', 
			spperson: '审批同意人', 
			spdate: '审批时间', 
			zt: '状态', 
			pimarchivesid: '档案信息标识', 
			pimpersonid3: '人员信息标识', 
			pimarchivesloanandreturnid: '档案借阅及归还记录标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			jyr: '借阅人',
			jyqssj: '借阅时间',
			ghrq: '归还时间',
			pimpersonname3: '审批人',
			spdate: '审批时间',
			jyyy: '借阅原因',
			zt: '状态',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_pimpersonname_like: '员工姓名', 
			n_zt_eq: '状态(=)', 
		},
		uiactions: {
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
		deuiaction1: {
			caption: '开启行编辑',
			tip: '开启行编辑',
		},
		tbitem16: {
			caption: '其它',
			tip: '其它',
		},
		tbitem23: {
			caption: '数据导入',
			tip: '数据导入',
		},
		tbitem13: {
			caption: '导出数据',
			tip: '导出数据',
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