/**
 * AppIndexView 部件模型
 *
 * @export
 * @class AppIndexViewModel
 */
export default class AppIndexViewModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof AppIndexViewModel
     */
    public items: any[] = [
        {
	id: '3ff154c6cf2631de6458fa56b2ee5c15',
	name: 'menuitem1',
	text: '组织管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组织管理',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/rencaixulie.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'fbcffd8a04377251a1306d64ec986718',
	name: 'menuitem3',
	text: '组织管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组织管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/rencaixulie.png',
	textcls: '',
	appfunctag: 'Auto486',
	resourcetag: '',
},
		{
	id: '66b6adc82026f738ebec0c3a64723e31',
	name: 'menuitem2',
	text: '编制查询',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '编制查询',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/guazhidaoqiguanli.png',
	textcls: '',
	appfunctag: 'Auto468',
	resourcetag: '',
},
		{
	id: '184af6a08026aab3a9ca6d792da7869d',
	name: 'menuitem5',
	text: '职务设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职务设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/zhiwuguanli.png',
	textcls: '',
	appfunctag: 'Auto461',
	resourcetag: '',
},
		{
	id: '3ae2a28eb5cca8f73c5c7d8bb029d1a2',
	name: 'menuitem6',
	text: '标准岗位设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '标准岗位设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/gangweiguanli.png',
	textcls: '',
	appfunctag: 'Auto482',
	resourcetag: '',
},
		{
	id: 'f77a8337aad1c2768a9c8a2af7938ced',
	name: 'menuitem9',
	text: '岗位集设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '岗位集设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xuliegangweiguanxi.png',
	textcls: '',
	appfunctag: 'Auto465',
	resourcetag: '',
},
		{
	id: '2783327117d0981e84fb6292b1d007f0',
	name: 'menuitem10',
	text: '项目标签',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '项目标签',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmuguanli.png',
	textcls: '',
	appfunctag: 'Auto456',
	resourcetag: '',
},
		{
	id: '16be6b27f7a61f221d9611022e605c10',
	name: 'menuitem7',
	text: 'ERP项目',
	type: 'MENUITEM',
	counterid: '',
	tooltip: 'ERP项目',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/kfgl/1/peixunjiluguanli.png',
	textcls: '',
	appfunctag: 'Auto497',
	resourcetag: '',
},
		{
	id: 'c5e4abc5f66a1415f842d99f2a1c2d44',
	name: 'menuitem11',
	text: '法人主体维护',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '法人主体维护',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengmuluguanli.png',
	textcls: '',
	appfunctag: 'Auto453',
	resourcetag: '',
},
		{
	id: '20d9f2a7f789de9d60d600e2b1a01cd8',
	name: 'menuitem12',
	text: '法人主体设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '法人主体设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinshezhi.png',
	textcls: '',
	appfunctag: 'Auto483',
	resourcetag: '',
},
	],
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof AppIndexViewModel
	 */
	public funcs: any[] = [
        {
            appfunctag: 'Auto461',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormdutygridview',
            deResParameters: [],
            routepath: '/index/:index?/ormduties/:ormduty?/gridview/:gridview?',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto482',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormpostlibgridview',
            deResParameters: [],
            routepath: '/index/:index?/ormpostlibs/:ormpostlib?/gridview/:gridview?',
            parameters: [
                { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto453',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormsignorggridview',
            deResParameters: [],
            routepath: '/index/:index?/ormsignorgs/:ormsignorg?/gridview/:gridview?',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto468',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormorgsectorbzcxgridview',
            deResParameters: [],
            routepath: '/index/:index?/ormorgsectors/:ormorgsector?/bzcxgridview/:bzcxgridview?',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
            ],
        },
        {
            appfunctag: 'Auto486',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormorginfoorgtreeexpview',
            deResParameters: [],
            routepath: '/index/:index?/ormorginfos/:ormorginfo?/orgtreeexpview/:orgtreeexpview?',
            parameters: [
                { pathName: 'ormorginfos', parameterName: 'ormorginfo' },
                { pathName: 'orgtreeexpview', parameterName: 'orgtreeexpview' },
            ],
        },
        {
            appfunctag: 'Auto465',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormpostgwxhwhgridview',
            deResParameters: [],
            routepath: '/index/:index?/ormposts/:ormpost?/gwxhwhgridview/:gwxhwhgridview?',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'gwxhwhgridview', parameterName: 'gwxhwhgridview' },
            ],
        },
        {
            appfunctag: 'Auto483',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'contractsignorggridview',
            deResParameters: [],
            routepath: '/index/:index?/contractsignorgs/:contractsignorg?/gridview/:gridview?',
            parameters: [
                { pathName: 'contractsignorgs', parameterName: 'contractsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto456',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormxmbqgridview',
            deResParameters: [],
            routepath: '/index/:index?/ormxmbqs/:ormxmbq?/gridview/:gridview?',
            parameters: [
                { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: 'Auto497',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'ormxmglgridview',
            deResParameters: [],
            routepath: '/index/:index?/ormxmgls/:ormxmgl?/gridview/:gridview?',
            parameters: [
                { pathName: 'ormxmgls', parameterName: 'ormxmgl' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof AppIndexViewModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof AppIndexViewModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}