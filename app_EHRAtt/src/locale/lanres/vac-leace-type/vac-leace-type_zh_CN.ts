export default {
  fields: {
    enable: '逻辑有效标志',
    createman: '建立人',
    createdate: '建立时间',
    vacleacetypeid: '休假类型管理标识',
    updatedate: '更新时间',
    typecode: '休假类型代码',
    vacleacetypename: '休假类型管理名称',
    updateman: '更新人',
  },
	views: {
		gridview: {
			caption: '休假类型',
      title: '休假类型',
		},
		editview: {
			caption: '休假类型',
      title: '休假类型',
		},
	},
	main_form: {
		details: {
			group1: '休假类型信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '休假类型管理标识', 
			srfmajortext: '休假类型管理名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			vacleacetypeid: '标识码', 
			typecode: '休假类型代码', 
			vacleacetypename: '休假类型名称', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			typecode: '休假类型代码',
			vacleacetypename: '休假类型名称',
			updateman: '更新人',
			updatedate: '更新时间',
		},
		uiactions: {
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
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
};