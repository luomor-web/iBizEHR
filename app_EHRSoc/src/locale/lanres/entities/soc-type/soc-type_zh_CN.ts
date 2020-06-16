export default {
  fields: {
    soctypeid: '保险类型标识',
    soctypename: '保险类型',
    enable: '逻辑有效标志',
    createdate: '建立时间',
    createman: '建立人',
    updatedate: '更新时间',
    updateman: '更新人',
    ordervalue: '排序号',
  },
	views: {
		editview: {
			caption: '保险类型',
      title: '保险类型编辑视图',
		},
		gridview: {
			caption: '保险类型',
      title: '保险类型表格视图',
		},
	},
	main_form: {
		details: {
			group1: '保险类型基本信息', 
			formpage1: '基本信息', 
			group2: '操作信息', 
			formpage2: '其它', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '保险类型标识', 
			srfmajortext: '保险类型', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			soctypename: '保险类型', 
			createman: '建立人', 
			createdate: '建立时间', 
			updateman: '更新人', 
			updatedate: '更新时间', 
			soctypeid: '保险类型标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ordervalue: '排序号',
			soctypename: '保险类型',
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
	},
	gridviewtoolbar_toolbar: {
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
};