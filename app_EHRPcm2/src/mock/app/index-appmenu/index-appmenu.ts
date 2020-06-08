import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/indexappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: 'A18E11A6-8CAF-4A54-86FA-C014CBA7672B',
	name: 'menuitem4',
	text: '人员异动',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员异动',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/2/diaodongguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '82339241-A705-4EC6-8072-E809C7B39152',
	name: 'menuitem1',
	text: '调动管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '调动管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/diaodongguanli.png',
	textcls: '',
	appfunctag: 'Auto29',
	resourcetag: '',
},
		{
	id: 'BA8084C6-166C-481E-9384-5D1339FFF2A1',
	name: 'menuitem2',
	text: '借调管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '借调管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jiediaoguanli.png',
	textcls: '',
	appfunctag: 'Auto25',
	resourcetag: '',
},
		{
	id: '197F49E7-BA8D-405C-A0A0-837219E82D9C',
	name: 'menuitem3',
	text: '兼职管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '兼职管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianzhijilu.png',
	textcls: '',
	appfunctag: 'Auto28',
	resourcetag: '',
},
		{
	id: 'E0108CF4-713E-49BC-8086-999DCF02B0AB',
	name: 'menuitem7',
	text: '待岗管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '待岗管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/daigangguanli.png',
	textcls: '',
	appfunctag: 'Auto23',
	resourcetag: '',
},
		{
	id: 'A6E8D8EE-0446-44EE-89EF-EC245288260D',
	name: 'menuitem8',
	text: '内退管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '内退管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/neituiguanli.png',
	textcls: '',
	appfunctag: 'Auto30',
	resourcetag: '',
},
		{
	id: '1C08415A-3674-449D-AAF1-9132C826596A',
	name: 'menuitem9',
	text: '病休管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '病休管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/xiujiaguanli.png',
	textcls: '',
	appfunctag: 'Auto37',
	resourcetag: '',
},
		{
	id: '543D3A50-4BF9-4602-8F34-ACC197D72D29',
	name: 'menuitem10',
	text: '离职管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离职管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/lizhiguanli.png',
	textcls: '',
	appfunctag: 'Auto20',
	resourcetag: '',
},
		{
	id: '962DB420-ED0C-4354-8CA6-5AD41A295AAC',
	name: 'menuitem11',
	text: '解聘管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '解聘管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jiepinguanli.png',
	textcls: '',
	appfunctag: 'Auto46',
	resourcetag: '',
},
		{
	id: '812AFEB2-8721-45E1-A708-EEB06FAB18CB',
	name: 'menuitem12',
	text: '退休管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '退休管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: 'Auto44',
	resourcetag: '',
},
	],
},
            {
	id: '11257DB0-513B-45C1-BF59-52B3797A5257',
	name: 'menuitem5',
	text: '试用期转正',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '试用期转正',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/xiujialeixing.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'D124962B-C2B7-4404-B2C5-A9C7E2C46E47',
	name: 'menuitem6',
	text: '试用期转正申请',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '试用期转正申请',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/shiyongqiguanli.png',
	textcls: '',
	appfunctag: 'Auto39',
	resourcetag: '',
},
		{
	id: '34583CE6-C9CB-4016-B31E-0E2E2383D4DD',
	name: 'menuitem15',
	text: '试用期转正审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '试用期转正审核',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmububianzhi.png',
	textcls: '',
	appfunctag: 'Auto41',
	resourcetag: '',
},
	],
},
            {
	id: '384E032F-7AD0-41FB-8DEB-5CDF186D894C',
	name: 'menuitem13',
	text: '见习期转正',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习期转正',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmurenyuanpeizhi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'C5F41F97-2844-42D8-99BD-5644D2D0BBFF',
	name: 'menuitem14',
	text: '见习期转正申请',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习期转正申请',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianxiqiguanli.png',
	textcls: '',
	appfunctag: 'Auto38',
	resourcetag: '',
},
		{
	id: 'C7E00017-BCB3-4F30-8B8A-9CCEE919301C',
	name: 'menuitem16',
	text: '见习期转正审核',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习期转正审核',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmurenyuanxuqiu.png',
	textcls: '',
	appfunctag: 'Auto19',
	resourcetag: '',
},
	],
},
        ],
    }];
});

