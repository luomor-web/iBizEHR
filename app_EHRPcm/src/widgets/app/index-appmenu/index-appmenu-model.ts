/**
 * Index 部件模型
 *
 * @export
 * @class IndexModel
 */
export default class IndexModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof IndexModel
     */
    public items: any[] = [
        {
	id: 'd7cd6c0305b469dd469ed647293f2cd7',
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
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof IndexModel
	 */
	public funcs: any[] = [
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}