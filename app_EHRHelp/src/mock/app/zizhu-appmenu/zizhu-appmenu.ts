import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/zizhuappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '9371c58f35c296a9ae0bcecabd6b2ae4',
	name: 'menuitem4',
	text: '我的信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '我的信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '7783838d0a4d46a5e5a314c5b87ed8f8',
	name: 'menuitem5',
	text: '个人信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '个人信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gerenxinxi.png',
	textcls: '',
	appfunctag: 'Auto400',
	resourcetag: '',
},
		{
	id: '635b53d9b5d87168e9788021bbfe36a5',
	name: 'menuitem6',
	text: '教育信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '教育信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/jiaoyuxinxi.png',
	textcls: '',
	appfunctag: 'Auto87',
	resourcetag: '',
},
		{
	id: '68bf542285117a0308169a1ed73989f4',
	name: 'menuitem7',
	text: '语言信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '语言信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/yuyanshuiping.png',
	textcls: '',
	appfunctag: 'Auto311',
	resourcetag: '',
},
		{
	id: '53957621dcb281fde71315180c031f6c',
	name: 'menuitem8',
	text: '家庭信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '家庭信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/jiatingqingkuang.png',
	textcls: '',
	appfunctag: 'Auto58',
	resourcetag: '',
},
		{
	id: 'b400d6848ac392820850a640eaa8fe46',
	name: 'menuitem9',
	text: '工作履历',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '工作履历',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/gongzuolvli.png',
	textcls: '',
	appfunctag: 'Auto110',
	resourcetag: '',
},
		{
	id: 'bf9374f5f6ef1211e02409cf48ec1c21',
	name: 'menuitem10',
	text: '证书信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '证书信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezige.png',
	textcls: '',
	appfunctag: 'Auto272',
	resourcetag: '',
},
		{
	id: '2d561f3b75f94483469ef875fe5f7f1e',
	name: 'menuitem11',
	text: '职称信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职称信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengxinxi.png',
	textcls: '',
	appfunctag: 'Auto430',
	resourcetag: '',
},
		{
	id: 'fe67b35144210a22edb76b89f34f81ca',
	name: 'menuitem12',
	text: '奖励惩罚',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '奖励惩罚',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/jianglichengfa.png',
	textcls: '',
	appfunctag: 'Auto178',
	resourcetag: '',
},
		{
	id: '3040b7896794510053064b4f3103551a',
	name: 'menuitem13',
	text: '科研成果',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '科研成果',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/keyanchengguo.png',
	textcls: '',
	appfunctag: 'Auto385',
	resourcetag: '',
},
		{
	id: 'c415c9a6e05f3abd49e22aeb8e107ca3',
	name: 'menuitem14',
	text: '专利信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '专利信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhuanlixinxi.png',
	textcls: '',
	appfunctag: 'Auto319',
	resourcetag: '',
},
		{
	id: '27241d8702d679b56bbf305daf1d8fac',
	name: 'menuitem15',
	text: '论文信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '论文信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/lunwenxinxi.png',
	textcls: '',
	appfunctag: 'Auto56',
	resourcetag: '',
},
	],
},
            {
	id: '1111063cd91b1ef99ccce70925ab1f9b',
	name: 'menuitem17',
	text: '我的查询',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '我的查询',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'b15d98f25246f4482030276991d1edc0',
	name: 'menuitem19',
	text: '分配信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '分配信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/fenpeixinxi.png',
	textcls: '',
	appfunctag: 'Auto159',
	resourcetag: '',
},
		{
	id: 'd67778367a36029c0bd7a635e1d3eea3',
	name: 'menuitem20',
	text: '档案信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '档案信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganxinxi.png',
	textcls: '',
	appfunctag: 'Auto276',
	resourcetag: '',
},
		{
	id: '2961d366e9fa97176c0e87c484a1a3cb',
	name: 'menuitem21',
	text: '绩效信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '绩效信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/jixiaoxinxi.png',
	textcls: '',
	appfunctag: 'Auto180',
	resourcetag: '',
},
		{
	id: 'fbc090f26ec269f928d7367e6480309e',
	name: 'menuitem22',
	text: '合同信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '合同信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongxinxi.png',
	textcls: '',
	appfunctag: 'Auto57',
	resourcetag: '',
},
		{
	id: '0fe884bbb3aca267699fae1c80483d27',
	name: 'menuitem23',
	text: '军转干部',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '军转干部',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/junzhuanganbu.png',
	textcls: '',
	appfunctag: 'Auto416',
	resourcetag: '',
},
	],
},
            {
	id: 'bdf73e2b2c360b764f26941d3dd69c59',
	name: 'menuitem18',
	text: '我的申请',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '我的申请',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'd671e001174c57d93b0ef6ca745a5d7d',
	name: 'menuitem24',
	text: '休假申请',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '休假申请',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/xiujiaxinxi.png',
	textcls: '',
	appfunctag: 'Auto36',
	resourcetag: '',
},
		{
	id: 'ec65a10addc4342a9c641f9ff297060a',
	name: 'menuitem25',
	text: '出（国）境申请',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '出（国）境申请',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/rujing.png',
	textcls: '',
	appfunctag: 'Auto5',
	resourcetag: '',
},
	],
},
        ],
    }];
});

