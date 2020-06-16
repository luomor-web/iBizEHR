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
	id: '4176781E-2367-44AA-ACD5-D7142B8BDA83',
	name: 'menuitem1',
	text: '基础信息',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '基础信息',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gerenshebaoxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '644835C8-0CD2-4186-90A3-70E9C1A1C57C',
	name: 'menuitem2',
	text: '参保地',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保地',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gerenshebaoxinxi.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
},
		{
	id: 'F91CFF61-8640-4CD6-8583-FB96A9FE77B3',
	name: 'menuitem3',
	text: '参保账户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保账户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gongsishebaoxinxi.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
},
	],
},
        ],
    }];
});

