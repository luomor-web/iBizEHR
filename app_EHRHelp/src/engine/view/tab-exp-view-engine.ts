import ViewEngine from './view-engine';

/**
 * 实体选择视图
 *
 * @export
 * @class TabExpViewEngine
 * @extends {ViewEngine}
 */
export default class TabExpViewEngine extends ViewEngine {


    /**
     * Creates an instance of TabExpViewEngine.
     * 
     * @memberof TabExpViewEngine
     */
    constructor() {
        super();
    }

    /**
     * 初始化引擎
     *
     * @param {*} options
     * @memberof TabExpViewEngine
     */
    public init(options: any): void {
        super.init(options);
    }


    /**
     * 引擎加载
     *
     * @memberof TabExpViewEngine
     */
    public load(): void {
        super.load();
        Object.values(this.view.containerModel).forEach((_item: any) => {
            if (!Object.is(_item.type, 'TABEXPPANEL')) {
                return;
            }
            this.setViewState2({ tag: _item.name, action: 'load', viewdata: this.view.context });
        });
    }
}