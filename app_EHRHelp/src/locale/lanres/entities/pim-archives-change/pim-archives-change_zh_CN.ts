export default {
  fields: {
    createdate: '建立时间',
    pimarchiveschangename: '归档地变更记录',
    updateman: '更新人',
    dazt: '档案状态',
    updatedate: '更新时间',
    createman: '建立人',
    dcdw: '调出单位',
    ddjltype: '调档记录类型',
    bz: '备注',
    pimarchiveschangeid: '档案归档地变更记录标识',
    xgdbgd: '管理单位',
    jlcssj: '调动时间',
    drdw: '调入单位',
    daddrq: '调动日期',
    ormorgname2: '调入单位',
    pimpersonname: '员工姓名',
    pimarchivesname: '档案名称',
    ormorgname: '调出单位',
    ygbh: '员工编号',
    ormorgid2: '调入单位标识',
    ormorgid: '调出单位标识',
    pimarchivesid: '档案信息标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		gridview: {
			caption: '调档记录',
      title: '调档记录表格视图',
		},
		editview: {
			caption: '档案归档地变更记录',
      title: '档案归档地变更记录编辑视图',
		},
	},
	main_form: {
		details: {
			group1: '调档记录', 
			formpage1: '基本信息', 
			srfupdatedate: '更新时间', 
			srforikey: '', 
			srfkey: '档案归档地变更记录标识', 
			srfmajortext: '归档地变更记录', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			pimpersonid: '人员信息标识', 
			dcdw: '调出单位', 
			drdw: '调入单位', 
			ormorgid2: '调入单位标识', 
			daddrq: '调动日期', 
			pimarchivesid: '档案信息标识', 
			pimarchiveschangeid: '档案归档地变更记录标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ddjltype: '调档记录类型',
			ormorgname: '调出单位',
			ormorgname2: '调入单位',
			jlcssj: '调动时间',
			bz: '备注',
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
};