export default {
  fields: {
    lx: '类型',
    createdate: '建立时间',
    sbm: '合同类别代码',
    updateman: '更新人',
    updatedate: '更新时间',
    enable: '逻辑有效标志',
    pimcontracttypeid: '合同/协议类型管理标识',
    pimcontracttypename: '合同类别名称',
    createman: '建立人',
    ormorgid: '组织标识',
  },
	views: {
		editview: {
			caption: '合同类型',
      title: '合同类型编辑视图',
		},
		pickupview: {
			caption: '合同类别',
      title: '合同/协议类型管理数据选择视图',
		},
		editview2: {
			caption: '合同类别',
      title: '合同/协议类型管理编辑视图',
		},
		redirectview: {
			caption: '合同类别',
      title: '合同/协议类型管理数据重定向视图',
		},
		mpickupview: {
			caption: '合同类别',
      title: '合同/协议类型管理数据多项选择视图',
		},
		selgridview: {
			caption: '合同类型',
      title: '合同类型表格视图',
		},
		gridview: {
			caption: '合同类别',
      title: '合同类别表格视图',
		},
		pickupgridview: {
			caption: '合同类别',
      title: '合同/协议类型管理选择表格视图',
		},
	},
	main_form: {
		details: {
			group1: '合同类别信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '合同/协议类型管理标识', 
			srfmajortext: '合同类别名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			sbm: '合同类别代码', 
			pimcontracttypename: '合同/协议类型名称', 
			pimcontracttypeid: '合同/协议类型管理标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sbm: '合同类别代码',
			pimcontracttypename: '合同类别名称',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_pimcontracttypeid_like: '识别码', 
			n_pimcontracttypename_like: '合同/协议类型名称', 
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
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: '新建',
			tip: '新建',
		},
		deuiaction2: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction3: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction4: {
			caption: '导入',
			tip: '导入',
		},
		deuiaction5: {
			caption: '导出',
			tip: '导出',
		},
	},
	selgridviewtoolbar_toolbar: {
		deuiaction6: {
			caption: '导出',
			tip: '导出',
		},
		deuiaction2: {
			caption: '过滤',
			tip: '过滤',
		},
	},
};