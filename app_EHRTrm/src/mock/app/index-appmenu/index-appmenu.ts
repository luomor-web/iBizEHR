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
	id: 'ED0C5606-4F3E-4CBD-8CF7-1ABC0E26DAB8',
	name: 'menuitem1',
	text: '培训资源',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训资源',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/danganguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'CC85A158-6FAC-4412-AF7B-7C31F0F95D22',
	name: 'menuitem6',
	text: '培训机构',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训机构',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/peixunjigou.png',
	textcls: '',
	appfunctag: '_17',
	resourcetag: '',
},
		{
	id: '314D5184-58EA-4F87-8D4E-9E94A47E12AA',
	name: 'menuitem7',
	text: '培训场地',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训场地',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunsheshi.png',
	textcls: '',
	appfunctag: '_5',
	resourcetag: '',
},
		{
	id: 'CEF509A4-7C06-4213-B7A8-28F7D8218B6B',
	name: 'menuitem8',
	text: '培训模块',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训模块',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunziliao.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
},
		{
	id: 'E23C028D-99A7-4F64-ACC9-3046CB6C5678',
	name: 'menuitem9',
	text: '培训课程',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训课程',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunkecheng.png',
	textcls: '',
	appfunctag: '_18',
	resourcetag: '',
},
		{
	id: 'DD704CB1-88A1-45E6-B6D0-C1F4C2C54DE4',
	name: 'menuitem10',
	text: '内部讲师',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '内部讲师',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/chengshurencaizhaopin.png',
	textcls: '',
	appfunctag: '_13',
	resourcetag: '',
},
		{
	id: 'DC1B55EF-1F38-44F1-93B1-3BFE7A38F7F3',
	name: 'menuitem11',
	text: '外部讲师',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '外部讲师',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
	textcls: '',
	appfunctag: '_16',
	resourcetag: '',
},
	],
},
            {
	id: 'DCD854A9-8112-48BC-A69F-CD487F758AF1',
	name: 'menuitem2',
	text: '培训需求',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训需求',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '57392FF2-9B84-4192-A37F-1974EFD2305B',
	name: 'menuitem12',
	text: '需求通知',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '需求通知',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/yuangongxuqiutianbao.png',
	textcls: '',
	appfunctag: '_4',
	resourcetag: '',
},
		{
	id: 'C5FC6E19-31DB-4EE6-A78D-4F0440A58704',
	name: 'menuitem13',
	text: '需求填报',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '需求填报',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/xuqiudiaochadingyi.png',
	textcls: '',
	appfunctag: '_11',
	resourcetag: '',
},
		{
	id: '69D77DBE-B79C-4F0D-9A1E-E8F364B87E5D',
	name: 'menuitem14',
	text: '需求汇总',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '需求汇总',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunxuqiuhuizong.png',
	textcls: '',
	appfunctag: '_12',
	resourcetag: '',
},
	],
},
            {
	id: '5679BCE0-996A-4452-9BA0-11F3105680C4',
	name: 'menuitem3',
	text: '培训计划',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训计划',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunjihua.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '0ECEFBEE-C893-4C89-B418-2701707F433F',
	name: 'menuitem15',
	text: '计划制定',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '计划制定',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunjihua.png',
	textcls: '',
	appfunctag: '_7',
	resourcetag: '',
},
		{
	id: '136D91F9-4565-4DE1-9264-2A281EAC99A7',
	name: 'menuitem16',
	text: '计划审批',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '计划审批',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
	textcls: '',
	appfunctag: '_6',
	resourcetag: '',
},
		{
	id: '39B1BF6E-4928-4697-8BA0-6D5A48319F27',
	name: 'menuitem17',
	text: '计划发布',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '计划发布',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/bumenxuqiutianbao.png',
	textcls: '',
	appfunctag: '_8',
	resourcetag: '',
},
	],
},
            {
	id: 'A061D949-6007-47CE-BFBC-2DFCABF34736',
	name: 'menuitem4',
	text: '培训实施',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训实施',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/lianghuamubiaokaohe.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '7B1F144E-3EEA-4ABC-97CD-2931C633D22C',
	name: 'menuitem18',
	text: '培训立项',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训立项',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunhuodong.png',
	textcls: '',
	appfunctag: '_19',
	resourcetag: '',
},
		{
	id: '620E3910-0B2D-441B-89D2-81ECF767E9C7',
	name: 'menuitem19',
	text: '培训班级',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训班级',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunhuodongshenqing.png',
	textcls: '',
	appfunctag: '_15',
	resourcetag: '',
},
		{
	id: '4DF69405-DE98-489E-AEA8-C062DCC4CBC4',
	name: 'menuitem20',
	text: '培训后评估',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训后评估',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jxgl/1/jixiaokaohepinggu.png',
	textcls: '',
	appfunctag: '_10',
	resourcetag: '',
},
	],
},
            {
	id: '39657408-8010-4B72-90D0-107316272729',
	name: 'menuitem5',
	text: '培训费用',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训费用',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunyusuan.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'DB67E1CA-BB14-418E-9C7C-136C64F15861',
	name: 'menuitem23',
	text: '培训费用登记',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '培训费用登记',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/penxunyusuanshenqing.png',
	textcls: '',
	appfunctag: '_14',
	resourcetag: '',
},
		{
	id: 'A4093CC5-F4D5-45E1-9C64-84438442FAD6',
	name: 'menuitem21',
	text: '内部讲师费用',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '内部讲师费用',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
},
		{
	id: 'CD5B5D2D-E4E8-4182-9D17-BAC270F315C1',
	name: 'menuitem22',
	text: '个人教育经费登记',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '个人教育经费登记',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/waibupeixunshenqing.png',
	textcls: '',
	appfunctag: '_9',
	resourcetag: '',
},
	],
},
        ],
    }];
});

