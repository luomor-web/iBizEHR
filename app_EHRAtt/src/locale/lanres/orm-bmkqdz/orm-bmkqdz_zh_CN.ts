export default {
  fields: {
    ormorgdzid: '组织地址ID',
    ormbmkqdzname: '部门地址',
    createdate: '建立时间',
    createman: '建立人',
    ormbmkqdzid: '部门地址维护标识',
    lng: '经度',
    sfmrkqdz: '默认考勤地址',
    updateman: '更新人',
    updatedate: '更新时间',
    lat: '纬度',
    xh: '排序号',
    ormorgsectorname: '部门名称',
    ormorgsectorid: '部门ID',
    attendancerange: '考勤范围',
  },
	views: {
		bmkqdzeditview: {
			caption: '部门考勤地址',
      title: '部门考勤地址',
		},
		bmkqdzgridview: {
			caption: '考勤地址信息',
      title: '考勤地址信息',
		},
	},
	main_2_form: {
		details: {
			group1: '部门地址维护', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '部门地址维护标识', 
			srfmajortext: '部门地址', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			ormbmkqdzname: '部门地址', 
			ormorgsectorid: '部门ID', 
			ormorgsectorname: '部门名称', 
			ormorgdzid: '组织地址ID', 
			ormbmkqdzid: '部门地址维护标识', 
		},
		uiactions: {
		},
	},
	main_2_grid: {
		columns: {
			ormbmkqdzname: '部门地址',
			attendancerange: '考勤范围',
			updateman: '更新人',
			updatedate: '更新时间',
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
	bmkqdzgridviewtoolbar_toolbar: {
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
	bmkqdzeditviewtoolbar_toolbar: {
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
	},
};