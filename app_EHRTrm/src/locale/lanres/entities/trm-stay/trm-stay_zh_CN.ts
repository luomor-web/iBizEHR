export default {
  fields: {
    lxr: '联系人',
    createman: '建立人',
    trmstayid: '培训住宿标识',
    enable: '逻辑有效标志',
    trmstayname: '名称',
    fjlx: '房间类型',
    createdate: '建立时间',
    updateman: '更新人',
    fjsl: '房间数量',
    lxdh: '联系电话',
    updatedate: '更新时间',
    trmtrainaddressname: '培训地点',
    trmtrainaddressid: '培训地点标识',
  },
	views: {
		gridview: {
			caption: '培训住宿',
      title: '培训住宿表格视图',
		},
		editview: {
			caption: '培训住宿',
      title: '培训住宿编辑视图',
		},
		mpickupview: {
			caption: '培训住宿',
      title: '培训住宿数据多项选择视图',
		},
		pickupview: {
			caption: '培训住宿',
      title: '培训住宿数据选择视图',
		},
		pickupgridview: {
			caption: '培训住宿',
      title: '培训住宿选择表格视图',
		},
	},
	main_form: {
		details: {
			group1: '培训住宿基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '培训住宿标识', 
			srfmajortext: '名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			fjlx: '房间类型', 
			fjsl: '房间数量', 
			trmtrainaddressid: '培训地点标识', 
			trmstayid: '培训住宿标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			fjlx: '房间类型',
			fjsl: '房间数量',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_trmstayname_like: '名称(%)', 
			n_fjlx_eq: '房间类型(=)', 
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