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
	id: 'B03E7D7B-38AC-4636-AEBB-40F72477E089',
	name: 'menuitem1',
	text: '校招应聘者',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '校招应聘者',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: 'Auto499',
	resourcetag: '',
},
        ],
    }];
});
