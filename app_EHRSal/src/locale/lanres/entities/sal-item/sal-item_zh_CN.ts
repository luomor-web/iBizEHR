export default {
  fields: {
    enable: '逻辑有效标志',
    createdate: '建立时间',
    updatedate: '更新时间',
    createman: '建立人',
    updateman: '更新人',
    salitemname: '要素项',
    salitemid: '薪酬要素项标识',
    xh: '排序号',
    salsubjectname: '财务科目',
    salsubjectid: '财务科目标识',
  },
	views: {
		pickupgridview: {
			caption: '薪酬要素项',
      title: '薪酬要素项',
		},
		mpickupview: {
			caption: '薪酬要素项',
      title: '薪酬要素项',
		},
		pickupview: {
			caption: '薪酬要素项',
      title: '薪酬要素项',
		},
		gridview: {
			caption: '薪酬要素项',
      title: '薪酬要素项',
		},
		editview: {
			caption: '薪酬要素项',
      title: '薪酬要素项',
		},
	},
	main_form: {
		details: {
			group1: '薪酬要素项信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '薪酬要素项标识', 
			srfmajortext: '要素项', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			xh: '排序号', 
			salitemname: '要素项', 
			salsubjectname: '财务科目', 
			salsubjectid: '财务科目标识', 
			salitemid: '薪酬要素项标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: '排序号',
			salitemname: '要素项',
			salsubjectname: '财务科目',
			updateman: '更新人',
			updatedate: '更新时间',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			grouppanel1: '', 
			formpage1: '常规条件', 
			n_salitemname_like: '要素项(%)', 
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
		deuiaction1: {
			caption: '开启行编辑',
			tip: '开启行编辑',
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